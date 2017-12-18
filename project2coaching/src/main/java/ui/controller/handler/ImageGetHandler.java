package ui.controller.handler;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ui.controller.RequestHandler;

public class ImageGetHandler extends RequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileName = request.getParameter("fileName");

        File file = new File(this.getImageDirectory(), fileName);
        BufferedImage image = ImageIO.read(file);
        String extension = fileName.substring(fileName.lastIndexOf(".")+1);

        response.setContentType("image/" + extension);
        ImageIO.write(image, extension, response.getOutputStream());
	}
}
