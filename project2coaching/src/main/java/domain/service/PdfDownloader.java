package domain.service;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import domain.model.ModelClass;

// http://www.vogella.com/tutorials/JavaPDF/article.html

public class PdfDownloader {

	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	public void buildPdfDocument(List<ModelClass> models, OutputStream outputStream) {
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, outputStream);
			document.open();
			addMetaData(document);
			addTitlePage(document);
			addContent(document, models);
			document.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	private static void addMetaData(Document document) {
		document.addTitle("PDF output");
		document.addSubject("Using iText");
		document.addKeywords("Java, PDF, iText");
		document.addAuthor("Project 2 Coaches");
		document.addCreator("Brecht Decuyper");
	}

	private static void addTitlePage(Document document) throws DocumentException {
		Paragraph preface = new Paragraph();
		// We add one empty line
		addEmptyLine(preface, 1);
		// Lets write a big header
		preface.add(new Paragraph("PDF output", catFont));

		addEmptyLine(preface, 1);
		// Will create: Report generated by: _name, _date
		preface.add(new Paragraph("Report generated by: BrechtDecuyper, " + new Date(), smallBold));
		addEmptyLine(preface, 3);
		preface.add(new Paragraph("This document describes something which is very important ", smallBold));

		addEmptyLine(preface, 8);

		preface.add(new Paragraph("This document is a tryout for a pdf downloader, just use and enjoy!.", redFont));

		document.add(preface);
		// Start a new page
		document.newPage();
	}

	private static void addContent(Document document, List<ModelClass> models) throws DocumentException {
		Anchor anchor = new Anchor("First Chapter", catFont);
		anchor.setName("First Chapter");

		// Second parameter is the number of the chapter
		Chapter catPart = new Chapter(new Paragraph(anchor), 1);

		Paragraph subPara = new Paragraph("HELLO, subcategory 1", subFont);
		
		Section subCatPart = catPart.addSection(subPara);

		Paragraph content1 = new Paragraph("HELLO USER");
		addEmptyLine(content1, 2);
		subCatPart.add(content1);

		subPara = new Paragraph("Subcategory 2", subFont);
		addEmptyLine(subPara, 1);
		subCatPart = catPart.addSection(subPara);
		
		// add a table
		createTable(subCatPart, models);

		// now add all this to the document
		document.add(catPart);

		
		
		
		// Next section
		anchor = new Anchor("Second Chapter", catFont);
		anchor.setName("Second Chapter");

		// Second parameter is the number of the chapter
		catPart = new Chapter(new Paragraph(anchor), 2);

		subPara = new Paragraph("Subcategory", subFont);
		addEmptyLine(subPara, 1);
		subCatPart = catPart.addSection(subPara);

		// add a list
		createList(subCatPart);


		// now add all this to the document
		document.add(catPart);
	}

	private static void createTable(Section subCatPart, List<ModelClass> models) throws BadElementException {
		PdfPTable table = new PdfPTable(4);

		PdfPCell c1 = new PdfPCell(new Phrase("Date"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Artist"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Title"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Link"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yy hh:mm:ss");
		for (ModelClass model : models) {
			c1 = new PdfPCell(new Phrase(sdf.format(model.getDate())));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase(model.getArtist()));
			c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase(model.getTitle()));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase(model.getUrl()));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
		}
		subCatPart.add(table);
	}

	private static void createList(Section subCatPart) {
		com.itextpdf.text.List list = new com.itextpdf.text.List(true, false, 10);
		list.add(new ListItem("Als twee honden vechten om een been, is er een been te kort."));
		list.add(new ListItem("Beter een vogel in de hand, dan geen hand."));
		list.add(new ListItem("Men kan met ideeen flirten, maar met de feiten moet men trouwen."));
		subCatPart.add(list);
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}
