package Main;

import java.io.File;


import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

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

	
	
	
	
	
	
	
	
	
	
	
	
private void StartTimer() {
		

	
	
	
	
	
	
	
	
	Bukkit.getScheduler().scheduleSyncRepeatingTask( null, new Runnable() {
		@Override
	public void run() {   
			for(Player p1 : Bukkit.getOnlinePlayers()) {
			
				
				p1.sendMessage("Hallo Player");
				if(main.duell.getBoolean(p1.getName()+".DuellAktiv")) {
				String NameGegner= "Fehler";
				int wert = main.duell.getInt(p1.getName()+".DuellTime");
				if(wert == 0) {
					wert = 60;
				}
			if(main.duell.getString(p1.getName()+".DuellSpieler").equals("p1")) {
				NameGegner = main.duell.getString(main.duell.getString(p1.getName()+".DuellArena")+".p2") ;
			}else {
				NameGegner = main.duell.getString(main.duell.getString(p1.getName()+".DuellArena")+".p1") ;
				
			}
			Player p2 = Bukkit.getPlayer(NameGegner);
			ScoreboardManager sM = Bukkit.getScoreboardManager(); 
			Scoreboard sb = sM.getNewScoreboard();
			Objective o = sb.registerNewObjective("SidePanel", "Dummy");
			o.setDisplaySlot(DisplaySlot.SIDEBAR);
			
			o.setDisplayName("Duell gegen "+NameGegner);
			
			
			
			
			if(main.duell.getString(p1.getName()+".DuellSpieler").equals("p1")) {
				o.getScore("Deine Runde endet in ").setScore(wert);
			}else {
				o.getScore("Runde endet in ").setScore(wert);
				
			}
			p1.setScoreboard(sb);;		
			
				
			}	
			}	
		
		}
	}, 20*10, 20*10);
	
	
	
	
    	
    		
    	
    	
    	}
	
	
	
	
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
		Spawner.deSummon("p1", 1, Arenas);
		Spawner.deSummon("p1", 2, Arenas);
		Spawner.deSummon("p1", 3, Arenas);
		Spawner.deSummon("p1", 4, Arenas);
		Spawner.deSummon("p1", 5, Arenas);
		
		Spawner.deSummon("p2", 1, Arenas);
		Spawner.deSummon("p2", 2, Arenas);
		Spawner.deSummon("p2", 3, Arenas);
		Spawner.deSummon("p2", 4, Arenas);
		Spawner.deSummon("p2", 5, Arenas);
    	}
		StartTimer();
		rereload();
	}
	static public void rereload() {
		
    	main.cfg = YamlConfiguration.loadConfiguration(main.Config);
    	
    	main.arena = YamlConfiguration.loadConfiguration(main.Arena);
    	main.duell = YamlConfiguration.loadConfiguration(main.Duell);
 
    	
    	
	}
	public void onDisable() {
		
		for(String Arenas : Main.main.arena.getStringList("Arena.list" )) {

    		
    		Spawner.BlockSpawner("p1", 1, Arenas,true, false);
    		Spawner.BlockSpawner("p1", 2, Arenas,true, false);
    		Spawner.BlockSpawner("p1", 3, Arenas,true, false);
    		Spawner.BlockSpawner("p1", 4, Arenas,true, false);
    		Spawner.BlockSpawner("p1", 5, Arenas,true, false);
    		
    		Spawner.BlockSpawner("p2", 1, Arenas,true, false);
    		Spawner.BlockSpawner("p2", 2, Arenas,true, false);
    		Spawner.BlockSpawner("p2", 3, Arenas,true, false);
    		Spawner.BlockSpawner("p2", 4, Arenas,true, false);
    		Spawner.BlockSpawner("p2", 5, Arenas,true, false);
    		
    		
		Spawner.deSummon("p1", 1, Arenas);
		Spawner.deSummon("p1", 2, Arenas);
		Spawner.deSummon("p1", 3, Arenas);
		Spawner.deSummon("p1", 4, Arenas);
		Spawner.deSummon("p1", 5, Arenas);
		
		Spawner.deSummon("p2", 1, Arenas);
		Spawner.deSummon("p2", 2, Arenas);
		Spawner.deSummon("p2", 3, Arenas);
		Spawner.deSummon("p2", 4, Arenas);
		Spawner.deSummon("p2", 5, Arenas);
		

    	}
		
	}
	
	
}
 