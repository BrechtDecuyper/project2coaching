package ui.controller.handler;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ui.controller.RequestHandler;

public class ImageDownloadHandler extends RequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileName = request.getParameter("fileName");
		
		String fileFormat = fileName.substring(fileName.indexOf(".")+1);

		response.setHeader("Content-Disposition", "attachment; filename=\"download."+fileFormat+"\"");
		ImageIO.write(this.getService().getImage(fileName), fileFormat, response.getOutputStream());        
	}

}
