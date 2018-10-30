package mx.com.bwl.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class UtileriaImagen {

	public static String guardarImagen(MultipartFile multiPart, HttpServletRequest request) {
		String nombreOriginal = multiPart.getOriginalFilename();
		nombreOriginal = nombreOriginal.replace(" ","_");
		String rutaFinal = request.getServletContext().getRealPath("/resources/images/");
		try {
			File imageFile = new File(rutaFinal + nombreOriginal);
			multiPart.transferTo(imageFile);
			return nombreOriginal;
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
	}
}
