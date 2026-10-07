\# RailRecover – Smart Train Journey Recovery System



RailRecover is a Java-based web application designed to help passengers recover from missed train journeys by providing ticket verification, OCR-based PNR detection, ticket recovery, duplicate detection, suspicious recovery tracking, and alternative train search.



> \*\*Academic Project:\*\* This project is developed for educational/PBL purposes. It is not connected to the live IRCTC or Indian Railways reservation system.



\---



\## 📌 Project Overview



Passengers may face problems when they miss a scheduled train or need to verify their ticket details quickly. Manually checking ticket information and finding suitable alternative trains can be time-consuming.



RailRecover provides a web-based solution that combines:



\- PNR-based ticket verification

\- PDF ticket scanning

\- OCR-based PNR detection

\- Ticket recovery requests

\- Recovery attempt tracking

\- Duplicate ticket detection

\- Rule-based suspicious recovery detection

\- Alternative train search

\- Train fare and seat availability display

\- Database-based recovery analytics



\---



\## 🎯 Objectives



The main objectives of RailRecover are:



1\. Verify railway ticket details using a PNR number.

2\. Extract a 10-digit PNR automatically from a ticket PDF.

3\. Provide a ticket recovery request mechanism.

4\. Track repeated recovery attempts.

5\. Detect duplicate tickets.

6\. Detect suspicious recovery attempts using predefined rules.

7\. Find alternative trains after a missed departure.

8\. Display fare, available seats, departure time, arrival time, and journey duration.

9\. Store and retrieve ticket and train information using MySQL.



\---



\## ✨ Features



\### 1. PNR Ticket Verification



Users can enter a 10-digit PNR number to retrieve ticket details from the MySQL database.



\### 2. OCR Ticket Scanner



Users can upload a PDF ticket.



The system:



```text

Ticket PDF

&#x20;    ↓

Apache PDFBox

&#x20;    ↓

Text Extraction

&#x20;    ↓

Tesseract OCR (when required)

&#x20;    ↓

Extracted Text

&#x20;    ↓

10-Digit PNR Detection

&#x20;    ↓

PNR Verification

