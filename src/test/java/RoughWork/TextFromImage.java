package RoughWork;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;

public class TextFromImage {

	
	public static String GetTextFromImage(String imagePath)
	{
		String text="";
		try {
			
			File file=new File(imagePath);
			Tesseract tesseract=new Tesseract();
			tesseract.setDatapath("C:\\Users\\dheeraj.singh\\git\\JavaFrameWork\\TessData");
			text=tesseract.doOCR(file);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return text;
	}
	
	public static void main(String[] args) {
		
		String imagePath=(System.getProperty("user.dir")+"/SikuliImageCapture/Capture.PNG");
		String string=GetTextFromImage(imagePath);
		System.out.println(string);
		
	}
	
	
	
}
