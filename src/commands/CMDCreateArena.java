package commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Main.main;

public class CMDCreateArena implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if(p.hasPermission("Noneless.Gameadd")) {
			
		//CreateArena NewArena "Name der Arena"
		if(args.length == 2) {
			if(args[0].equalsIgnoreCase("NewArena")) {
			if(main.arena.getBoolean("Arena.create")==false || main.arena.getString("Arena.create") == null) {
				p.sendMessage("Hallo");
				
				
					ArrayList<String> Arenas = new ArrayList<String>();
					Arenas.addAll(main.arena.getStringList("Arena.list"));
					Arenas.add(args[1]);
					main.arena.set("Arena.list",Arenas);
					main.arena.set("Arena.create",true);
					main.arena.set(args[0]+".enable",false);
					p.sendMessage("Arena Erstellt");
				}
		}}
		//CreateArena p1 ..
		//.. location "Name der Arena"
	
		if(args.length== 3 && args[0].equalsIgnoreCase("p1")&& args[1].equalsIgnoreCase("location")) {
			ArrayList<String> Arenas = new ArrayList<String>();
			Arenas.addAll(main.arena.getStringList("Arena.list"));
			if(Arenas.contains(args[2])) {
				
				main.arena.set(args[2]+".p1.loc.X",p.getLocation().getX());
				main.arena.set(args[2]+".p1.loc.Y",p.getLocation().getY());
				main.arena.set(args[2]+".p1.loc.Z",p.getLocation().getZ());
				main.arena.set(args[2]+".p1.loc.Yaw",p.getLocation().getYaw());
				main.arena.set(args[2]+".p1.loc.Pitch",p.getLocation().getPitch());
				main.arena.set(args[2]+".p1.loc.World",p.getLocation().getWorld().getName());
				main.arena.set(args[2]+".allow.p1.loc", true);
				p.sendMessage("Punkt Erstellt");
			}else {
				sender.sendMessage("Die Arena gibt es nicht");
			}
		}
		
		
		
		
		//.. Mobzone (1-5) "Name der Arena"
		if(args.length== 4 && args[0].equalsIgnoreCase("p1")&& args[1].equalsIgnoreCase("Mobzone")) {
			ArrayList<String> Arenas = new ArrayList<String>();
			Arenas.addAll(main.arena.getStringList("Arena.list"));
			if(Arenas.contains(args[3])) {
				int Count = Integer.parseInt(args[2]);
				main.arena.set(args[3]+".p1.Mobzone."+Count+".loc.X",p.getLocation().getX());
				main.arena.set(args[3]+".p1.Mobzone."+Count+".loc.Y",p.getLocation().getY());
				main.arena.set(args[3]+".p1.Mobzone."+Count+".loc.Z",p.getLocation().getZ());
				main.arena.set(args[3]+".p1.Mobzone."+Count+".loc.Yaw",p.getLocation().getYaw());
				main.arena.set(args[3]+".p1.Mobzone."+Count+".loc.Pitch",p.getLocation().getPitch());
				main.arena.set(args[3]+".p1.Mobzone."+Count+".loc.World",p.getLocation().getWorld().getName());
				
				main.arena.set(args[3]+".allow.p1.mobzone."+Count, true);
				p.sendMessage("Punkt Erstellt");
				
				
			}else {
				sender.sendMessage("Die Arena gibt es nicht");
			}
		}
		
		
		//.. Wizzone (1-5) "Name der Arena"
		if(args.length== 4 && args[0].equalsIgnoreCase("p1")&& args[1].equalsIgnoreCase("Wizzone")) {
			ArrayList<String> Arenas = new ArrayList<String>();
			Arenas.addAll(main.arena.getStringList("Arena.list"));
			if(Arenas.contains(args[3])) {
				int Count = Integer.parseInt(args[2]);
				main.arena.set(args[3]+".p1.Wizzone."+Count+".loc.X",p.getLocation().getX());
				main.arena.set(args[3]+".p1.Wizzone."+Count+".loc.Y",p.getLocation().getY());
				main.arena.set(args[3]+".p1.Wizzone."+Count+".loc.Z",p.getLocation().getZ());
				main.arena.set(args[3]+".p1.Wizzone."+Count+".loc.Yaw",p.getLocation().getYaw());
				main.arena.set(args[3]+".p1.Wizzone."+Count+".loc.Pitch",p.getLocation().getPitch());
				main.arena.set(args[3]+".p1.Wizzone."+Count+".loc.World",p.getLocation().getWorld().getName());
				main.arena.set(args[3]+".allow.p1.wizzone."+Count, true);
				p.sendMessage("Punkt Erstellt");
				
				
			}else {
				sender.sendMessage("Die Arena gibt es nicht");
			}
		}
		
		
		//CreateArena p2 ..
		//.. location "Name der Arena"
				
		if(args.length== 3 && args[0].equalsIgnoreCase("p2")&& args[1].equalsIgnoreCase("location")) {
			ArrayList<String> Arenas = new ArrayList<String>();
			Arenas.addAll(main.arena.getStringList("Arena.list"));
			if(Arenas.contains(args[2])) {
				
				main.arena.set(args[2]+".p2.loc.X",p.getLocation().getX());
				main.arena.set(args[2]+".p2.loc.Y",p.getLocation().getY());
				main.arena.set(args[2]+".p2.loc.Z",p.getLocation().getZ());
				main.arena.set(args[2]+".p2.loc.Yaw",p.getLocation().getYaw());
				main.arena.set(args[2]+".p2.loc.Pitch",p.getLocation().getPitch());
				main.arena.set(args[2]+".p2.loc.World",p.getLocation().getWorld().getName());
				main.arena.set(args[2]+".allow.p2.loc", true);
				p.sendMessage("Punkt Erstellt");
			}else {
				sender.sendMessage("Die Arena gibt es nicht");
			}
		}	
				
				
				
		//.. Mobzone (1-5) "Name der Arena"
		if(args.length== 4 && args[0].equalsIgnoreCase("p2")&& args[1].equalsIgnoreCase("Mobzone")) {
			ArrayList<String> Arenas = new ArrayList<String>();
			Arenas.addAll(main.arena.getStringList("Arena.list"));
			if(Arenas.contains(args[3])) {
				int Count = Integer.parseInt(args[2]);
				main.arena.set(args[3]+".p2.Mobzone."+Count+".loc.X",p.getLocation().getX());
				main.arena.set(args[3]+".p2.Mobzone."+Count+".loc.Y",p.getLocation().getY());
				main.arena.set(args[3]+".p2.Mobzone."+Count+".loc.Z",p.getLocation().getZ());
				main.arena.set(args[3]+".p2.Mobzone."+Count+".loc.Yaw",p.getLocation().getYaw());
				main.arena.set(args[3]+".p2.Mobzone."+Count+".loc.Pitch",p.getLocation().getPitch());
				main.arena.set(args[3]+".p2.Mobzone."+Count+".loc.World",p.getLocation().getWorld().getName());
				main.arena.set(args[3]+".allow.p2.mobzone."+Count, true);
				p.sendMessage("Punkt Erstellt");
				
				
			}else {
				sender.sendMessage("Die Arena gibt es nicht");
			}
		}
		
		
		//.. Wizzone (1-5) "Name der Arena"
		if(args.length== 4 && args[0].equalsIgnoreCase("p2")&& args[1].equalsIgnoreCase("Wizzone")) {
			ArrayList<String> Arenas = new ArrayList<String>();
			Arenas.addAll(main.arena.getStringList("Arena.list"));
			if(Arenas.contains(args[3])) {
				int Count = Integer.parseInt(args[2]);
				main.arena.set(args[3]+".p2.Wizzone."+Count+".loc.X",p.getLocation().getX());
				main.arena.set(args[3]+".p2.Wizzone."+Count+".loc.Y",p.getLocation().getY());
				main.arena.set(args[3]+".p2.Wizzone."+Count+".loc.Z",p.getLocation().getZ());
				main.arena.set(args[3]+".p2.Wizzone."+Count+".loc.Yaw",p.getLocation().getYaw());
				main.arena.set(args[3]+".p2.Wizzone."+Count+".loc.Pitch",p.getLocation().getPitch());
				main.arena.set(args[3]+".p2.Wizzone."+Count+".loc.World",p.getLocation().getWorld().getName());
				main.arena.set(args[3]+".allow.p2.wizzone."+Count, true);
				p.sendMessage("Punkt Erstellt");
				
				
			}else {
				sender.sendMessage("Die Arena gibt es nicht");
			}
		}
		}
		//CreateArena enable "Name der Arena"
		if(args.length== 2 && args[0].equalsIgnoreCase("enable")) {
			if(main.arena.getBoolean(args[1]+".allow.p1.loc")&&main.arena.getBoolean(args[1]+".allow.p2.loc")&&main.arena.getBoolean(args[1]+".allow.p1.mobzone.1")&&main.arena.getBoolean(args[1]+".allow.p1.mobzone.2")&&main.arena.getBoolean(args[1]+".allow.p1.mobzone.3")&&main.arena.getBoolean(args[1]+".allow.p1.mobzone.4")&&main.arena.getBoolean(args[1]+".allow.p1.mobzone.5")) {
			if(main.arena.getBoolean(args[1]+".allow.p1.wizzone.1")&&main.arena.getBoolean(args[1]+".allow.p1.wizzone.2")&&main.arena.getBoolean(args[1]+".allow.p1.wizzone.3")&&main.arena.getBoolean(args[1]+".allow.p1.wizzone.4")&&main.arena.getBoolean(args[1]+".allow.p1.wizzone.5")) {
				if(main.arena.getBoolean(args[1]+".allow.p2.mobzone.1")&&main.arena.getBoolean(args[1]+".allow.p2.mobzone.2")&&main.arena.getBoolean(args[1]+".allow.p2.mobzone.3")&&main.arena.getBoolean(args[1]+".allow.p2.mobzone.4")&&main.arena.getBoolean(args[1]+".allow.p2.mobzone.5"))	{
				
					if(main.arena.getBoolean(args[1]+".allow.p2.wizzone.1")&&main.arena.getBoolean(args[1]+".allow.p2.wizzone.2")&&main.arena.getBoolean(args[1]+".allow.p2.wizzone.3")&&main.arena.getBoolean(args[1]+".allow.p2.wizzone.4")&&main.arena.getBoolean(args[1]+".allow.p2.wizzone.5")) {
					main.arena.set(args[1]+".enable", true);
					p.sendMessage("Die Arena Wird aktiviert");
					main.arena.set("Arena.create",false);
					}else {
						p.sendMessage("Bitte setzte alle Felder Code 1");
					}
					
				}else {
					p.sendMessage("Bitte setzte alle Felder Code 2");
				}
			}else {
				p.sendMessage("Bitte setzte alle Felder Code 3");
			}
			}else {
				p.sendMessage("Bitte setzte alle Felder Code 4");
			}
		}
		return true;
		
			
		}
}
