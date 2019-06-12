package com.java.framework.Utils;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;

public class ExtractTextFromImagesUtil {
	
	
	public static String TextFromImages(/*String imagePath, String tessDataPath*/)
	{
		String imagePath=(System.getProperty("user.dir")+"/SikuliImageCapture/Text.PNG");
		String tessDataPath=(System.getProperty("user.dir")+"/TessData");
		String text="";
		try {
			
			File file=new File(imagePath);
			Tesseract tesseract=new Tesseract();
			tesseract.setDatapath(tessDataPath);
			text=tesseract.doOCR(file);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return text;
	}	
}
