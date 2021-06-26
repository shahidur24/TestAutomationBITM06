package com.exam.screenshot;

import com.exam.base.TestBase;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class GeneratePdf extends TestBase {
    public static void main(String[] args) throws IOException, DocumentException {
        chromeLaunch();
        openURL("https://demo.opencart.com/");
        createPDF();

    }

    public static void createPDF() throws IOException, DocumentException {
        //take screenshot and save as byte[]
        byte[] input = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Document doc = new Document();
        String output = System.getProperty("user.dir") + "//src//main/PDF/New.pdf";
        FileOutputStream fs = new FileOutputStream(output);
        PdfWriter writer = PdfWriter.getInstance(doc, fs);
        writer.open();
        doc.open();
        Image img = Image.getInstance(input);
        img.scaleToFit(PageSize.A4.getWidth() / 2, PageSize.A4.getHeight() / 2);
        doc.add(img);
        doc.add(new Paragraph(""));
        doc.close();
        writer.close();

    }
}
