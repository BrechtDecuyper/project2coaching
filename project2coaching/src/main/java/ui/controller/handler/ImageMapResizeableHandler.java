package ui.controller.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ui.controller.RequestHandler;

public class ImageMapResizeableHandler extends RequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/imageMapResizeable.jsp").forward(request, response);
	}
}
