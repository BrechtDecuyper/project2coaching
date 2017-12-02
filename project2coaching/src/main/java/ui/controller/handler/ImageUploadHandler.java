package ui.controller.handler;

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
		this.getService().addNewImage(file);

		response.sendRedirect("Controller?action=imageOverview");
	}
}
