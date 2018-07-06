package commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Main.main;

public class CMDDuell implements CommandExecutor {
	
	//Duell (Gegner) (Arena)
	//Duell Aktzeptieren
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}else {
			Player p = (Player) sender;
			if(args.length == 2) {
				
				
				
				Player player = Bukkit.getPlayerExact(args[0]);
				if(player == null)
				{
				    sender.sendMessage("Es ist keiner mit dem Namen Online");
				    return true;
				}else {
					ArrayList<String> Arenas = new ArrayList<String>();
					Arenas.addAll(main.arena.getStringList("Arena.list"));
					if(Arenas.contains(args[1])) {
						if(main.arena.getBoolean(args[1]+".isinUse")) {
							p.sendMessage("Sorry Aber die Arena ist in benutzung");
						}else {
							if(!(main.arena.getBoolean(args[1]+".enable"))) {
								p.sendMessage("Sorry Aber die Arena ist noch nicht Aktiviert");
							}else {
								
								Player p2 = Bukkit.getPlayer(args[0]);
								
								
								if(main.duell.getBoolean(p.getName()+".DuellAnfrage")) {
									p.sendMessage("Du bist bereits in einer anfrage/einem Duell");
								}else {
									
									if(main.duell.getBoolean(p2.getName()+".DuellAnfrage")) {
										p.sendMessage(p2.getName()+" ist bereits in einer anfrage/einem Duell");
									}else {
								
								
										p2.sendMessage("Du wurdest zu einem Duell Herausgefordert!!!");
										p2.sendMessage("Gegner: "+p.getName()+" Arena: "+args[1]);
										p2.sendMessage("Nimm mit /Duell Aktzeptieren an oder /Duell Ablehnen nicht");
										main.duell.set(p2.getName()+".DuellAnfrage", true);
										main.duell.set(p2.getName()+".DuellArena", args[1]);
										main.duell.set(p2.getName()+".DuellSpieler", "p2");
										main.duell.set(p2.getName()+".DuellGegner", p.getName());
								
								
										main.duell.set(p.getName()+".DuellAnfrage", true);
										main.duell.set(p.getName()+".DuellArena", args[1]);
										main.duell.set(p.getName()+".DuellSpieler", "p1");
										main.duell.set(p.getName()+".DuellGegner", p2.getName());
										}
									}
							}
								
						}
					}else {
						p.sendMessage("Sorry Aber die Arena gibt es leider nicht");
					}
				}
				
				
			}else if(args.length == 1) {
				if(args[0].equalsIgnoreCase("Aktzeptieren")) {
					
					
					
					
					
					
				}else if(args[0].equalsIgnoreCase("Ablehnen")) {
					Player p2 = Bukkit.getPlayer(main.duell.getString(p.getName()+".DuellGegner"));
					
					
					main.duell.set(p.getName()+".DuellAnfrage", false);
					main.duell.set(p.getName()+".DuellArena", "");
					main.duell.set(p.getName()+".DuellSpieler", "");
					main.duell.set(p.getName()+".DuellGegner", "");
					
					main.duell.set(p2.getName()+".DuellAnfrage", false);
					main.duell.set(p2.getName()+".DuellArena", "");
					main.duell.set(p2.getName()+".DuellSpieler", "");
					main.duell.set(p2.getName()+".DuellGegner", "");
					p2.sendMessage("Leider hat "+p.getName()+" wohl was besseres zu tun");
					
				}
			}
			
			
			
		}
		
		
		
		return true;
	}
}
