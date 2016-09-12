package mod.upcraftlp.hardcoresurvival.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import mod.upcraftlp.hardcoresurvival.Reference;
import mod.upcraftlp.hardcoresurvival.init.ModConfig;


public class ModUpdate {

	private static String UPDATE_URL = Reference.INTERNAL_UPDATE_URL;
	private static boolean newVersionAvailable = false;
	private static String version = Reference.VERSION.split("-")[0];
	private static String latest = version;
	
	public static void init()
	{
		if(!ModConfig.enableUpdateChecker) return;
		SysUtils.printFML("Initializing Update-Checker...");
		new Thread("Update-Checker:" + Reference.MOD_ID)
		{
			public void run()
			{
				try {
					URL url = new URL(UPDATE_URL);
					Scanner scanner = new Scanner(url.openStream());
					while(scanner.hasNextLine())
					{
						String contentString = scanner.nextLine();
								String[] content = contentString.split("-");
						if(content[0].equals(Reference.MCVERSION))
						{
							latest = content[1];
							break;
						}
					}
					scanner.close();
				} catch (MalformedURLException e)
			{
				SysUtils.printFML("URL ERROR: MALFORMED URL");
			} catch (Exception e) {
					e.printStackTrace();
				}
				if(!latest.equals(version)) setNewVersionAvailable();
			};
		}.start();
	}
	
	private static synchronized void setNewVersionAvailable()
	{
		newVersionAvailable = true;
	}
	
	public static synchronized boolean isNewVersionAvailable()
	{
		return newVersionAvailable;
	}
	
	 public static synchronized String getLatest() {
		return latest;
	}
}
