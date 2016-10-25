package mod.upcraftlp.hardcoresurvival.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.upcraftlp.hardcoresurvival.Reference;

public class SysUtils {

	private static Logger log = LogManager.getLogger(Reference.MODNAME.toUpperCase());
	
	public static Logger getLogger() {
		return log;
	}
	
	public static void println(String output)
	{
		System.out.println("[" + Reference.MOD_ID + "] " + output);
	}
	
	public static void printFML(String output)
	{
		log.info(output);
	}
	
	public static void extractZip(String inputFile, String outputFolder) throws IOException
	{
		byte[] buffer = new byte[1024];
		File folder = new File(outputFolder);
		if(!folder.exists()) folder.mkdir();
		ZipInputStream input = new ZipInputStream(new FileInputStream(new File(inputFile)));
		try {
			
			ZipEntry entry;
			while((entry = input.getNextEntry()) != null) {
				String outPath = outputFolder + File.separator + entry.getName();
				FileOutputStream out = null;
				try {
					out = new FileOutputStream(outPath);
					int length = 0;
					while((length = input.read(buffer)) > 0) {
						out.write(buffer, 0, length);
					}
				} finally {
					if(out != null) out.close();
				}
				
			}
		} finally {
			input.close();
		}
	}
	
}
