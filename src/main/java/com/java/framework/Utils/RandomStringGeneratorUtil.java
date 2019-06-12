package com.java.framework.Utils;

public class RandomStringGeneratorUtil {
	
	
	public static String RandomString()
	{
		String stringValue="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
		StringBuffer stringbuffer = null;
		try {
			
			stringbuffer=new StringBuffer(10);
			
			for(int i=0;i<10;i++)
			{
				int index=(int)(stringValue.length()*Math.random());
				stringbuffer.append(stringValue.charAt(index));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringbuffer.toString()+"@gmail.com";
	}

}
