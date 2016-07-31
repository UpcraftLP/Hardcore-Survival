package mod.upcraftlp.hardcoresurvival.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import mod.upcraftlp.hardcoresurvival.Reference;
import mod.upcraftlp.hardcoresurvival.init.LeafConfig;


public class ModUpdate {

	private static String UPDATE_URL = Reference.INTERNAL_UPDATE_URL;
	private static boolean newVersionAvailable = false;
	private static String latest = Reference.VERSION;
	
	public static void init()
	{
		if(!LeafConfig.enableUpdateChecker) return;
		SysUtils.println("checking for updates...");
		new Thread("Update-Checker" + Reference.MOD_ID)
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
						SysUtils.println(content[0] + ", " + content[1]);
						if(content[0].equals(Reference.MCVERSION))
						{
							latest = content[1];
							break;
						}
					}
					scanner.close();
				} catch (MalformedURLException e)
			{
				SysUtils.println("URL ERROR: MALFORMED URL");
			} catch (Exception e) {
					e.printStackTrace();
				}
				if(latest.equals(Reference.VERSION) != true) setNewVersionAvailable();
			};
		}.start();
	}
	
	private static synchronized void setNewVersionAvailable()
	{
		newVersionAvailable = true;
		SysUtils.println("New Version available: " + latest);
		SysUtils.println("download it here: " + Reference.UPDATE_URL);
	}
	
	public static synchronized boolean isNewVersionAvailable()
	{
		return newVersionAvailable;
	}
	
	 public static synchronized String getLatest() {
		return latest;
	}
}
