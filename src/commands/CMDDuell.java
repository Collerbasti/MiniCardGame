package commands;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
					if(player.getName() !=sender.getName()) {
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
										p2.sendMessage("Nimm mit /Duell act an oder /Duell Ablehnen nicht");
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
				}else{sender.sendMessage("Computer sagt nein");
					}
				}
				
				
			}else if(args.length == 1) {
				if(args[0].equalsIgnoreCase("Aktzeptieren")||args[0].equalsIgnoreCase("accept")||args[0].equalsIgnoreCase("act")) {
					
					
					
					
					Player p1 = Bukkit.getPlayer(main.duell.getString(p.getName()+".DuellGegner"));
					Player p2 = p;

					
					
					
					
					p1.sendMessage(p2.getName()+": Es ist Zeit für ein Duell");
					p2.sendMessage(p1.getName()+": Es ist Zeit für ein Duell");
					Double x = Main.main.arena.getDouble(Main.main.duell.getString(p1.getName()+".DuellArena")+".p1.loc.X");
							Double y = Main.main.arena.getDouble(Main.main.duell.getString(p1.getName()+".DuellArena")+".p1.loc.Y");
							Double z = Main.main.arena.getDouble(Main.main.duell.getString(p1.getName()+".DuellArena")+".p1.loc.Z");
							Float yaw = (float) Main.main.arena.getDouble(Main.main.duell.getString(p1.getName()+".DuellArena")+".p1.loc.Yaw");
							Float pitch = (float) Main.main.arena.getDouble(Main.main.duell.getString(p1.getName()+".DuellArena")+".p1.loc.Pitch");
							org.bukkit.World w = Bukkit.getWorld(Main.main.arena.getString(Main.main.duell.getString(p1.getName()+".DuellArena")+".p1.loc.World"));
							p1.teleport(new Location(w,x,y,z,yaw,pitch));
							
							
							

							Double x2 = Main.main.arena.getDouble(Main.main.duell.getString(p2.getName()+".DuellArena")+".p2.loc.X");
									Double y2 = Main.main.arena.getDouble(Main.main.duell.getString(p2.getName()+".DuellArena")+".p2.loc.Y");
									Double z2 = Main.main.arena.getDouble(Main.main.duell.getString(p2.getName()+".DuellArena")+".p2.loc.Z");
									Float yaw2 = (float) Main.main.arena.getDouble(Main.main.duell.getString(p2.getName()+".DuellArena")+".p2.loc.Yaw");
									Float pitch2 = (float) Main.main.arena.getDouble(Main.main.duell.getString(p2.getName()+".DuellArena")+".p2.loc.Pitch");
									org.bukkit.World w2 = Bukkit.getWorld(Main.main.arena.getString(Main.main.duell.getString(p2.getName()+".DuellArena")+".p2.loc.World"));
									p2.teleport(new Location(w2,x2,y2,z2,yaw2,pitch2));
					
									p1.getInventory().clear();
									p2.getInventory().clear();
									
									
									ItemStack Cart = new ItemStack(Material.MINECART , 1);
									ItemMeta MCart = Cart.getItemMeta();
									MCart.setDisplayName("Menu");
									Cart.setItemMeta(MCart);
									
									p1.getInventory().setItem(8, Cart);
									p1.getPlayer().updateInventory();
									p2.getInventory().setItem(8, Cart);
									p2.getPlayer().updateInventory();
									
									Game.DrawCard.DrawaCard(p1);
									Game.DrawCard.DrawaCard(p1);
									Game.DrawCard.DrawaCard(p1);
									
									Game.DrawCard.DrawaCard(p2);
									Game.DrawCard.DrawaCard(p2);
									Game.DrawCard.DrawaCard(p2);
									
									Main.main.duell.set(p1.getName()+".Cards.APS", 3);
									Main.main.duell.set(p2.getName()+".Cards.APS", 3);
									p1.setGameMode(GameMode.ADVENTURE);
									p2.setGameMode(GameMode.ADVENTURE);
									p1.setHealth(20);
									p2.setHealth(20);
									
									Main.main.duell.set(p1.getName()+".Phase", "Main");
									Main.main.duell.set(p2.getName()+".Phase", "Enemie");
									main.duell.set(main.duell.getString(p1.getName()+".DuellArena")+".p1",p1.getName());
									main.duell.set(main.duell.getString(p1.getName()+".DuellArena")+".p2",p2.getName());
									main.duell.set(main.duell.getString(p1.getName()+".DuellArena")+".isinUse",true);
											
									
									
					
					
					
					
					
					
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
					
				}else if(args[0].equalsIgnoreCase("sichern")) {
					try {
						main.duell.save(main.Duell);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						main.cfg.save(main.Config);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(args[0].equalsIgnoreCase("reload")) {
					main.Arena = new File("plugins/MiniCardGame","Arenas.yml");
					main.arena = YamlConfiguration.loadConfiguration(main.Arena);	
				}
			}
			
			
			
		}
		
		
		
		return true;
	}
}
