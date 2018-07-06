package Main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import Main.CardGameEventListener;
import commands.CMDCreateArena;
import commands.CMDDuell;
import commands.CMDTestSummon;

public class main extends JavaPlugin implements Listener {
	
	public static File Config;
	public static FileConfiguration cfg;
	public static File Arena;
	public static FileConfiguration arena;
	public static File Duell;
	public static FileConfiguration duell;
	
	
	@Override	
	
	public void onEnable(){
		
		
		
		Bukkit.getPluginManager().registerEvents(this, this);
		new CardGameEventListener(this);
		
		this.getCommand("CreateArena").setExecutor(new CMDCreateArena());
		this.getCommand("TestSummon").setExecutor(new CMDTestSummon());
		this.getCommand("Duell").setExecutor(new CMDDuell());
		
		
		System.out.println("MiniCardGane Loading");
		
		main.Config = new File("plugins/MiniCardGame","Cfg.yml");
    	main.cfg = YamlConfiguration.loadConfiguration(main.Config);
    	main.Arena = new File("plugins/MiniCardGame","Arenas.yml");
    	main.arena = YamlConfiguration.loadConfiguration(main.Arena);
    	main.Duell = new File("plugins/MiniCardGame","Duell.yml");
    	main.duell = YamlConfiguration.loadConfiguration(main.Duell);
    	
	}
	public void onDisable() {
		try {
			main.arena.save(main.Arena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
 