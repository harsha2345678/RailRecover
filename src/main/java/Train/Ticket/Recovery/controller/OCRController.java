package Train.Ticket.Recovery.controller;

import Train.Ticket.Recovery.service.OCRService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class OCRController {

    private static final Logger logger = LoggerFactory.getLogger(OCRController.class);

    private final OCRService ocrService;

    public OCRController(OCRService ocrService) {
        this.ocrService = ocrService;
    }

    @PostMapping("/ocr-ticket")
    public Map<String, String> scanTicket(
            @RequestParam("file") MultipartFile file) {

        Map<String, String> result = new HashMap<>();

        try {

            String text = ocrService.extractText(file);

            System.out.println("========== OCR TEXT ==========");
            System.out.println(text);
            System.out.println("==============================");

            result.put("ocrText", text);

            Pattern pattern = Pattern.compile("\\b\\d{10}\\b");

            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                result.put("pnr", matcher.group());
            } else {
                result.put("pnr", "Not Found");
            }

            return result;

        } catch (Exception e) {

            logger.error("Error while scanning ticket", e);

            result.put("error", e.getMessage());

            return result;
        }
    }
}