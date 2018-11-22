package Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import Game.Spawner;
import Main.CardGameEventListener;
import commands.CMDCreateArena;
import commands.CMDDuell;
import commands.CMDTestSummon;
import commands.CMDnextPhase;

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
		this.getCommand("nextPhase").setExecutor(new CMDnextPhase());
		
		main.Config = new File("plugins/MiniCardGame","Cfg.yml");
    	main.cfg = YamlConfiguration.loadConfiguration(main.Config);
    	main.Arena = new File("plugins/MiniCardGame","Arenas.yml");
    	main.arena = YamlConfiguration.loadConfiguration(main.Arena);
    	main.Duell = new File("plugins/MiniCardGame","Duell.yml");
    	main.duell = YamlConfiguration.loadConfiguration(main.Duell);
		System.out.println("MiniCardGane Loading");
		
		for(String Arenas : Main.main.arena.getStringList("Arena.list" )) {
    		String p1Name = main.duell.getString(Arenas+".p1");
    		String p2Name = main.duell.getString(Arenas+".p2");
		Spawner.deSummon("p1", 1, Arenas, Bukkit.getPlayer(p1Name));
		Spawner.deSummon("p1", 2, Arenas, Bukkit.getPlayer(p1Name));
		Spawner.deSummon("p1", 3, Arenas, Bukkit.getPlayer(p1Name));
		Spawner.deSummon("p1", 4, Arenas, Bukkit.getPlayer(p1Name));
		Spawner.deSummon("p1", 5, Arenas, Bukkit.getPlayer(p1Name));
		
		Spawner.deSummon("p2", 1, Arenas, Bukkit.getPlayer(p2Name));
		Spawner.deSummon("p2", 2, Arenas, Bukkit.getPlayer(p2Name));
		Spawner.deSummon("p2", 3, Arenas, Bukkit.getPlayer(p2Name));
		Spawner.deSummon("p2", 4, Arenas, Bukkit.getPlayer(p2Name));
		Spawner.deSummon("p2", 5, Arenas, Bukkit.getPlayer(p2Name));
    	}
    	
	}
	static public void rereload() {
		
    	main.cfg = YamlConfiguration.loadConfiguration(main.Config);
    	
   	
    	main.duell = YamlConfiguration.loadConfiguration(main.Duell);
 
    	
    	
	}
	public void onDisable() {
		
		for(String Arenas : Main.main.arena.getStringList("Arena.list" )) {
    		String p1Name = main.duell.getString(Arenas+".p1");
    		String p2Name = main.duell.getString(Arenas+".p2");
		Spawner.deSummon("p1", 1, Arenas, Bukkit.getPlayer(p1Name));
		Spawner.deSummon("p1", 2, Arenas, Bukkit.getPlayer(p1Name));
		Spawner.deSummon("p1", 3, Arenas, Bukkit.getPlayer(p1Name));
		Spawner.deSummon("p1", 4, Arenas, Bukkit.getPlayer(p1Name));
		Spawner.deSummon("p1", 5, Arenas, Bukkit.getPlayer(p1Name));
		
		Spawner.deSummon("p2", 1, Arenas, Bukkit.getPlayer(p2Name));
		Spawner.deSummon("p2", 2, Arenas, Bukkit.getPlayer(p2Name));
		Spawner.deSummon("p2", 3, Arenas, Bukkit.getPlayer(p2Name));
		Spawner.deSummon("p2", 4, Arenas, Bukkit.getPlayer(p2Name));
		Spawner.deSummon("p2", 5, Arenas, Bukkit.getPlayer(p2Name));
    	}
		
	}
	
	
}
 