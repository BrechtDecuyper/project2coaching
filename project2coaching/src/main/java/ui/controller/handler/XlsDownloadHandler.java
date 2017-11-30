package ui.controller.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.service.ExcelDownloader;
import ui.controller.RequestHandler;

public class XlsDownloadHandler extends RequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        response.setHeader("Content-Disposition", "attachment; filename=\"download.xls\"");
		new ExcelDownloader().buildXlsDocument(this.getService().getModels(), response.getOutputStream());
	}
}
