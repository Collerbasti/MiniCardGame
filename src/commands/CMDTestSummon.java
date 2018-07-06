package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Game.MenuSpawner;
import Game.Spawner;

public class CMDTestSummon implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		//TestSummon p1/p2 (1-5) "name der Arena" mob
		Player p = (Player) sender;
		if(args.length == 4) {
			
			if(args[3].equalsIgnoreCase("Creeper")) {
				p.sendMessage("Creeper wird versucht zu spawnen 1");
				Spawner.Creeper(args[0], Integer.parseInt(args[1]), args[2], p);
				
			}else if(args[3].equalsIgnoreCase("Zombie")) {
				p.sendMessage("Zombie wird versucht zu spawnen 1");
				Spawner.Zombie(args[0], Integer.parseInt(args[1]), args[2], p);
			}
		else if(args[3].equalsIgnoreCase("Skeleton")) {
			p.sendMessage("Skeleton wird versucht zu spawnen 1");
			Spawner.Skeleton(args[0], Integer.parseInt(args[1]), args[2], p);
		}
			
			//TestSummon p1/p2 (1-5) "name der arena" Block true/false
		}else if(args.length == 5) {
			
			if(args[3].equalsIgnoreCase("Block")) {
				p.sendMessage("Block wird versucht zu setzen 1");
				Spawner.BlockSpawner(args[0], Integer.parseInt(args[1]), args[2], p, Boolean.parseBoolean(args[4]));
				
			}
			
		}
		if(args.length == 2) {
			if(args[0].equalsIgnoreCase("Menu")) {
			MenuSpawner.DuellFeld("p2", args[1],(Player) sender);
			}
		}
		return true;
	}

}
