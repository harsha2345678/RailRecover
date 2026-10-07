package Train.Ticket.Recovery.service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.File;

@Service
public class OCRService {

    public String extractText(MultipartFile file) throws Exception {

        String filename = file.getOriginalFilename();

        // PDF FILE
        if (filename != null &&
                filename.toLowerCase().endsWith(".pdf")) {

            File tempPdf = File.createTempFile("ticket-", ".pdf");

            file.transferTo(tempPdf);

            try (PDDocument document = Loader.loadPDF(tempPdf)) {

                // First try direct PDF text extraction
                PDFTextStripper stripper = new PDFTextStripper();

                String text = stripper.getText(document);

                if (text != null && !text.trim().isEmpty()) {

                    return text;
                }

                // If PDF has no selectable text,
                // use OCR on rendered pages
                PDFRenderer renderer = new PDFRenderer(document);

                Tesseract tesseract = new Tesseract();

                tesseract.setDatapath(
                        "C:/Program Files/Tesseract-OCR/tessdata"
                );

                tesseract.setLanguage("eng");

                StringBuilder ocrText = new StringBuilder();

                for (int page = 0;
                     page < document.getNumberOfPages();
                     page++) {

                    BufferedImage image =
                            renderer.renderImageWithDPI(page, 300);

                    try {

                        ocrText.append(
                                tesseract.doOCR(image)
                        );

                    } catch (TesseractException e) {

                        throw new Exception(
                                "OCR failed: " + e.getMessage()
                        );
                    }

                    ocrText.append("\n");
                }

                return ocrText.toString();

            } finally {

                if (tempPdf.exists()) {
                    tempPdf.delete();
                }
            }
        }

        throw new Exception("Please upload a PDF ticket.");
    }
}