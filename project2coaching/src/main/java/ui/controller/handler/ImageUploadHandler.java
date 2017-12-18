package ui.controller.handler;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ui.controller.RequestHandler;

public class ImageUploadHandler extends RequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part file = request.getPart("file"); // Retrieves <input type="file" name="file">
		
		File theDir = new File(this.getImageDirectory());
		if (!theDir.exists()) {
			theDir.mkdirs();
		}
		
		String fileName = file.getSubmittedFileName().substring(0,file.getSubmittedFileName().lastIndexOf("."))
				+ System.currentTimeMillis()
				+ file.getSubmittedFileName().substring(file.getSubmittedFileName().lastIndexOf("."));
		File save = new File(this.getImageDirectory(), fileName);
		file.write(save.getAbsolutePath());
		
		this.getService().addNewImage(fileName);
		response.sendRedirect("Controller?action=imageOverview");
	}
}
