package commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Main.main;

public class CMDnextPhase implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		
		if(sender instanceof Player) {
		 if(args.length == 1)	{
			 ArrayList<String> Arenas = new ArrayList<String>();
				Arenas.addAll(main.arena.getStringList("Arena.list"));
				if(Arenas.contains(args[0])) {
					if(main.duell.getBoolean(args[0]+".isinUse")) {
						if(main.duell.getString(main.duell.getString(args[0]+".p1")+".Phase")=="Main"){
							main.duell.set(main.duell.getString(args[0]+".p1")+".Phase", "Enemie");	
							sender.sendMessage("Phase wird Gewechselt p1 zu Enemie");
							
						}else if(main.duell.getString(main.duell.getString(args[0]+".p1")+".Phase")=="Enemie"){
							main.duell.set(main.duell.getString(args[0]+".p1")+".Phase", "Main");	
							sender.sendMessage("Phase wird Gewechselt p1 zu Main");
							
						}
						
						if(main.duell.getString(main.duell.getString(args[0]+".p2")+".Phase")=="Main"){
							main.duell.set(main.duell.getString(args[0]+".p2")+".Phase", "Enemie");	
							sender.sendMessage("Phase wird Gewechselt p2 zu Enemie");
							
						}else if(main.duell.getString(main.duell.getString(args[0]+".p2")+".Phase")=="Enemie"){
							main.duell.set(main.duell.getString(args[0]+".p2")+".Phase", "Main");	
							sender.sendMessage("Phase wird Gewechselt p2 zu Main");
							
						}
						Main.main.duell.set(main.duell.getString(args[0]+".p2")+".Cards.APS", 3);
						Main.main.duell.set(main.duell.getString(args[0]+".p1")+".Cards.APS", 3);
						
						
						
					}else {sender.sendMessage("Wird derzeit nicht verwendet");}
					
				}
		 }
		}
		// TODO Auto-generated method stub
		return true;
	}

}
