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
		
		
		System.out.println("MiniCardGane Loading");
		
		main.Config = new File("plugins/MiniCardGame","Cfg.yml");
    	main.cfg = YamlConfiguration.loadConfiguration(main.Config);
    	main.Arena = new File("plugins/MiniCardGame","Arenas.yml");
    	main.arena = YamlConfiguration.loadConfiguration(main.Arena);
    	main.Duell = new File("plugins/MiniCardGame","Duell.yml");
    	main.duell = YamlConfiguration.loadConfiguration(main.Duell);
    	
	}
	public void onDisable() {
		ArrayList<String> Arenas = new ArrayList<String>();
		Arenas.addAll(main.arena.getStringList("Arena.list"));
		int count = 0;
		for(String E : Arenas) {
			
			String p1Name = main.duell.getString(Arena+".p1");
			String p2Name = main.duell.getString(Arena+".p2");
			
			
			Game.Spawner.deSummon("p1", 1, Arenas.get(count), Bukkit.getPlayer(p1Name));
			Game.Spawner.deSummon("p1", 2, Arenas.get(count), Bukkit.getPlayer(p1Name));
			Game.Spawner.deSummon("p1", 3, Arenas.get(count), Bukkit.getPlayer(p1Name));
			Game.Spawner.deSummon("p1", 4, Arenas.get(count), Bukkit.getPlayer(p1Name));
			Game.Spawner.deSummon("p1", 5, Arenas.get(count), Bukkit.getPlayer(p1Name));
			
			Game.Spawner.deSummon("p2", 1, Arenas.get(count), Bukkit.getPlayer(p2Name));
			Game.Spawner.deSummon("p2", 2, Arenas.get(count), Bukkit.getPlayer(p2Name));
			Game.Spawner.deSummon("p2", 3, Arenas.get(count), Bukkit.getPlayer(p2Name));
			Game.Spawner.deSummon("p2", 4, Arenas.get(count), Bukkit.getPlayer(p2Name));
			Game.Spawner.deSummon("p2", 5, Arenas.get(count), Bukkit.getPlayer(p2Name));
			
			
			
			
			main.arena.set(E+".1 p1", "");
			main.arena.set(E+".1 p2", "");
			
			main.arena.set(E+".2 p1", "");
			main.arena.set(E+".2 p2", "");
			
			main.arena.set(E+".3 p1", "");
			main.arena.set(E+".3 p2", "");
			
			main.arena.set(E+".4 p1", "");
			main.arena.set(E+".4 p2", "");
			
			main.arena.set(E+".5 p1", "");
			main.arena.set(E+".5 p2", "");
		count = count+1;
		}
		try {
			main.arena.save(main.Arena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
 