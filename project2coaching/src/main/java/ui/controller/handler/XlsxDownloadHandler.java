package ui.controller.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.service.ExcelDownloader;
import ui.controller.RequestHandler;

public class XlsxDownloadHandler extends RequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        response.setHeader("Content-Disposition", "attachment; filename=\"download.xlsx\"");
		new ExcelDownloader().buildXlsxDocument(this.getService().getModels(), response.getOutputStream());
	}
}
