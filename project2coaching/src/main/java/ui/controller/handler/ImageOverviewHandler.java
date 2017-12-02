package ui.controller.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ui.controller.RequestHandler;

public class ImageOverviewHandler extends RequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("images", this.getService().getImageNames());
		request.getRequestDispatcher("imageOverview.jsp").forward(request, response);
	}
}
