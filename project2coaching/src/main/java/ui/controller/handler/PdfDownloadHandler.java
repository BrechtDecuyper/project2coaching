package ui.controller.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.service.PdfDownloader;
import ui.controller.RequestHandler;

public class PdfDownloadHandler extends RequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        response.setHeader("Content-Disposition", "attachment; filename=\"download.pdf\"");
        new PdfDownloader().buildPdfDocument(this.getService().getModels(), response.getOutputStream());
	}
}
