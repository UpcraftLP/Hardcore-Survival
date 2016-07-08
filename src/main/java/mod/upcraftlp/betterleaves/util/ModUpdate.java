package mod.upcraftlp.betterleaves.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import mod.upcraftlp.betterleaves.Reference;
import mod.upcraftlp.betterleaves.init.LeafConfig;

public class ModUpdate {

	private static String UPDATE_URL = Reference.INTERNAL_UPDATE_URL;
	private static boolean newVersionAvailable = false;
	public static String latestVersion = Reference.VERSION; 
	
	public static void init()
	{
		if(!LeafConfig.enableUpdateChecker) return;
		new Thread("Update-Checker" + Reference.MOD_ID)
		{
			public void run()
			{
				try {
					URL url = new URL(UPDATE_URL);
					Scanner scanner = new Scanner(url.openStream());
					latestVersion = scanner.nextLine();
					scanner.close();
					
					if (!Reference.VERSION.equals(latestVersion))
					{
						setNewVersionAvailable();
					}
				} catch (MalformedURLException e)
			{
				System.err.println("URL ERROR: MALFORMED URL");
			} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();
	}
	
	private static synchronized void setNewVersionAvailable()
	{
		newVersionAvailable = true;
		SysUtils.println("New Version available: " + latestVersion);
		SysUtils.println("download it here: " + Reference.UPDATE_URL);
	}
	
	public static synchronized boolean isNewVersionAvailable()
	{
		return newVersionAvailable;
	}
}
