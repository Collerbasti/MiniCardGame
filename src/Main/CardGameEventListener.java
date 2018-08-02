package Main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import Game.Spawner;

public class CardGameEventListener implements Listener
{
	private final main plugin;
	public CardGameEventListener(main plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
        
    }
	
	
	@EventHandler 
	public void onPLayerThrow(PlayerDropItemEvent ev) {	
		Player p = ev.getPlayer();
			if(main.cfg.getBoolean(p.getName()+".isinGame")) {
				ev.setCancelled(true);
			}
	}
	
	@EventHandler 
	public void onPLayerPick(EntityPickupItemEvent ev) {	
		 LivingEntity pe = ev.getEntity();
		 if(pe.getType().equals(EntityType.PLAYER)){
			 
			Player p = Bukkit.getServer().getPlayer(pe.getName());
		
				if(main.cfg.getBoolean(p.getName()+".isinGame")) {
					ev.setCancelled(true);
				}
		 
		 }
	}
	@EventHandler
	public void onPlayerInventoryClick(InventoryClickEvent ev) {
		Player pe = (Player) ev.getWhoClicked();
		String Arena2 = main.duell.getString(pe.getName()+".DuellArena");
		
		
		if(ev.getInventory().getName().contains("Atack")){
			if(ev.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Creeper")||ev.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Zombie")||ev.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Skeleton")){
			pe.closeInventory();
				String MonsterAtack = "None";
			int pMobfield = 0;
			if(ev.getInventory().getName().contains("Skeleton")) {
				MonsterAtack = "Skeleton";
			}else if(ev.getInventory().getName().contains("Creeper")) {
				MonsterAtack = "Creeper";
			}else if(ev.getInventory().getName().contains("Zombie")) {
				MonsterAtack = "Zombie";
			}
			if(ev.getInventory().getName().contains("0")){
				pMobfield = 1;
			}else if(ev.getInventory().getName().contains("1")){
				pMobfield = 2;
			}else if(ev.getInventory().getName().contains("2")){
				pMobfield = 3;
			}else if(ev.getInventory().getName().contains("3")){
				pMobfield = 4;
			}else if(ev.getInventory().getName().contains("4")){
				pMobfield = 5;
			}
			
			
			String p1Playerside = main.duell.getString(ev.getWhoClicked().getName()+".DuellSpieler");
			String p2Playerside = "";
			if(p1Playerside.equalsIgnoreCase("p1")) {
				p2Playerside = "p2";
			}else {
				p2Playerside ="p1";
			}
			
		int p2Mobfield = ev.getSlot() +1;
		String p2Monster = main.cfg.getString(Arena2+"."+p2Playerside+".mobfield."+p2Mobfield+".mobname");
		int APS= Main.main.duell.getInt(pe.getName()+".Cards.APS");
		if (APS==0) {
		pe.sendMessage("Du hast keine Aktzions Punkte Mehr");	
		}else {
			Main.main.duell.set(pe.getName()+".Cards.APS", APS-1);
			
		if(MonsterAtack.equalsIgnoreCase("creeper"))	{
			main.cfg.set(Arena2+"."+p2Playerside+".mobfield."+p2Mobfield+".Def",0);
			main.cfg.set(Arena2+"."+p1Playerside+".mobfield."+pMobfield+".Def",0);
		}else if(MonsterAtack.equalsIgnoreCase("Skeleton"))	{
			
			
			if(!p2Monster.equalsIgnoreCase("Skeleton"))	{
			int Counter = main.cfg.getInt(Arena2+"."+p2Playerside+".mobfield."+p2Mobfield+".Def")-1;
			main.cfg.set(Arena2+"."+p2Playerside+".mobfield."+p2Mobfield+".Def",Counter);
			}else {
				int Counter = main.cfg.getInt(Arena2+"."+p1Playerside+".mobfield."+pMobfield+".Def")-1;
				main.cfg.set(Arena2+"."+p1Playerside+".mobfield."+pMobfield+".Def",Counter);	
				int Counter2 = main.cfg.getInt(Arena2+"."+p2Playerside+".mobfield."+p2Mobfield+".Def")-2;
				main.cfg.set(Arena2+"."+p2Playerside+".mobfield."+p2Mobfield+".Def",Counter2);
			}
		}else if(MonsterAtack.equalsIgnoreCase("Zombie"))	{
			
			
			
				int Counter = main.cfg.getInt(Arena2+"."+p1Playerside+".mobfield."+pMobfield+".Def")-1;
				main.cfg.set(Arena2+"."+p1Playerside+".mobfield."+pMobfield+".Def",Counter);	
				int Counter2 = main.cfg.getInt(Arena2+"."+p2Playerside+".mobfield."+p2Mobfield+".Def")-2;
				main.cfg.set(Arena2+"."+p2Playerside+".mobfield."+p2Mobfield+".Def",Counter2);
			
		}
		pe.sendMessage(Integer.toString(main.cfg.getInt(Arena2+"."+p1Playerside+".mobfield."+pMobfield+".Def")));
		if(main.cfg.getInt(Arena2+"."+p1Playerside+".mobfield."+pMobfield+".Def") <= 0 ) {
			
			
			Game.Spawner.deSummon(p1Playerside, pMobfield, Arena2, (Player) ev.getWhoClicked());
		
			double p1Health = pe.getHealth()-2;
			pe.setHealth(p1Health);
		}
		pe.sendMessage(Integer.toString(main.cfg.getInt(Arena2+"."+p2Playerside+".mobfield."+p2Mobfield+".Def")));
		
		if(main.cfg.getInt(Arena2+"."+p2Playerside+".mobfield."+p2Mobfield+".Def") <= 0) {
	
			
			Game.Spawner.deSummon(p2Playerside, p2Mobfield, Arena2, (Player) ev.getWhoClicked());
			double p2Health = Bukkit.getPlayer(main.duell.getString(Arena2+"."+p2Playerside)).getHealth()-4;
			Bukkit.getPlayer(main.duell.getString(Arena2+"."+p2Playerside)).setHealth(p2Health);
		}
			
			
		}
			pe.closeInventory();
		}
		}
		
		
		if(ev.getInventory().getName().equalsIgnoreCase("Duell Beschw�re Creeper")) {
			if(ev.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Hier Beschw�ren")){
				Game.Spawner.Summon(main.arena.getBoolean(pe.getName()+".Cards.Modus"), "Creeper", main.duell.getString(pe.getName()+".DuellSpieler"), ev.getSlot()+1, Arena2, pe,Material.CREEPER_HEAD);
			}

		}else if(ev.getInventory().getName().equalsIgnoreCase("Duell Beschw�re Zombie")) {
			if(ev.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Hier Beschw�ren")){
				Game.Spawner.Summon(main.arena.getBoolean(pe.getName()+".Cards.Modus"), "Zombie", main.duell.getString(pe.getName()+".DuellSpieler"), ev.getSlot()+1, Arena2, pe,Material.ZOMBIE_HEAD);
			}
			
		}else if(ev.getInventory().getName().equalsIgnoreCase("Duell Beschw�re Skeleton")) {
			if(ev.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Hier Beschw�ren")){
				Game.Spawner.Summon(main.arena.getBoolean(pe.getName()+".Cards.Modus"), "Skeleton", main.duell.getString(pe.getName()+".DuellSpieler"), ev.getSlot()+1, Arena2, pe,Material.SKELETON_SKULL);
			}
			
		
			}
		
		
		
		
		if(ev.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Offen Spielen")||ev.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Verdeckt Spielen")) {
			boolean reopen = false;
			if(ev.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Verdeckt Spielen")) {
				ev.getWhoClicked().sendMessage("Verdeckt");
				main.duell.set(pe.getName()+".Cards.Modus", true);
				reopen=true;
				
				
				
			}else if(ev.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Offen Spielen")) {
				main.duell.set(pe.getName()+".Cards.Modus", false);
				ev.getWhoClicked().sendMessage("Offen ");
				reopen=true;
			}
			ev.getWhoClicked().sendMessage(" Spielen");
			if(reopen) {
				
				Inventory Spawner = Bukkit.createInventory(null, 9, "Duell "+pe.getInventory().getItemInMainHand().getItemMeta().getDisplayName());	
				
				int Count = 9;
				String Arena =  Main.main.duell.getString(pe.getName()+".DuellArena");
				if(Main.main.duell.getString(pe.getName()+".DuellSpieler").equalsIgnoreCase("p2")) {
				while(Count > 0) {
					
				Count=Count-1;
					if(Count == 4 || Count == 3 || Count == 2 || Count == 1 || Count == 0) {
						int p2mobzone = Count +1;
						if(main.cfg.getBoolean(Arena+".p2"+".mobfield."+p2mobzone+".isinuse")) {
							if(main.cfg.getString(Arena+".p2"+".mobfield."+p2mobzone+".mobname").equalsIgnoreCase("Verdekte Karte")) {
								
								ItemStack Skull = new ItemStack(Material.ACACIA_WOOD , 1);
						    	ItemMeta IMeta =  Skull.getItemMeta(); 
						    	IMeta.setDisplayName("Verdekte Karte");
						    	Skull.setItemMeta(IMeta);
						    	Spawner.setItem(Count,Skull);
						    	
							}else {
								ItemStack Skull = new ItemStack(Material.SKELETON_SKULL , 1);
						    	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
						    	SMeta.setDisplayName(main.cfg.getString(Arena+".p2"+".mobfield."+p2mobzone+".mobname"));
						    	Skull.setItemMeta(SMeta);
						    	Skull.setDurability((short) main.cfg.getInt(Arena+".p2"+".mobfield."+p2mobzone+".mobint"));
						    	Spawner.setItem(Count,Skull);
							}
					
					
					
					
				}else {
					ItemStack Skull = new ItemStack(Material.GLASS , 1);
			    	ItemMeta SMeta = (ItemMeta) Skull.getItemMeta(); 
			    	SMeta.setDisplayName("Hier Beschw�ren");
			    	Skull.setItemMeta(SMeta);
			    	Spawner.setItem(Count,Skull);
				}
				
				
					}
				}//Ende der While
				}else {
					while(Count > 0) {
						
						Count=Count-1;
							if(Count == 4 || Count == 3 || Count == 2 || Count == 1 || Count == 0) {
								int p1mobzone = Count +1;
								if(main.cfg.getBoolean(Arena+".p1"+".mobfield."+p1mobzone+".isinuse")) {
									if(main.cfg.getString(Arena+".p1"+".mobfield."+p1mobzone+".mobname").equalsIgnoreCase("Verdekte Karte")) {
										
										ItemStack Skull = new ItemStack(Material.ACACIA_WOOD , 1);
								    	ItemMeta IMeta =  Skull.getItemMeta(); 
								    	IMeta.setDisplayName("Verdekte Karte");
								    	Skull.setItemMeta(IMeta);
								    	Spawner.setItem(Count,Skull);
								    	
									}else {
										ItemStack Skull = new ItemStack(Material.SKELETON_SKULL , 1);
								    	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
								    	SMeta.setDisplayName(main.cfg.getString(Arena+".p1"+".mobfield."+p1mobzone+".mobname"));
								    	Skull.setItemMeta(SMeta);
								    	Skull.setDurability((short) main.cfg.getInt(Arena+".p1"+".mobfield."+p1mobzone+".mobint"));
								    	Spawner.setItem(Count,Skull);
									}
							
								}else {
									ItemStack Skull = new ItemStack(Material.GLASS , 1);
							    	ItemMeta SMeta = (ItemMeta) Skull.getItemMeta(); 
							    	SMeta.setDisplayName("Hier Beschw�ren");
							    	Skull.setItemMeta(SMeta);
							    	Spawner.setItem(Count,Skull);
								}
							
							
						}
						
						
							}
				}
				if(!main.duell.getBoolean(pe.getName()+".Cards.Modus")) {
					ItemStack Skull = new ItemStack(Material.BIRCH_PLANKS , 1);
			    	ItemMeta SMeta = (ItemMeta) Skull.getItemMeta(); 
			    	SMeta.setDisplayName("Verdeckt Spielen");
			    	Skull.setItemMeta(SMeta);
			    	Spawner.setItem(8,Skull);
			    	}else {
			    		ItemStack Skull = new ItemStack(Material.GLASS , 1);
			        	ItemMeta SMeta = (ItemMeta) Skull.getItemMeta(); 
			        	SMeta.setDisplayName("Offen Spielen");
			        	Skull.setItemMeta(SMeta);
			        	Spawner.setItem(8,Skull);
			    		
			    		
			    	}
		    	
				pe.openInventory(Spawner);
				
				
			}	
			}
			 
			
		
				if(ev.getInventory().getName().contains("Duell")) {
					ev.setCancelled(true);
					
					
				
					
					
					
					
					
					if(main.duell.getBoolean(ev.getWhoClicked().getName()+".DuellAnfrage")) {
					if(ev.getSlot() ==0 || ev.getSlot() == 1||ev.getSlot() ==2 || ev.getSlot() == 3||ev.getSlot() ==4 ) {
						if(main.duell.getString(ev.getWhoClicked().getName()+".DuellSpieler").equalsIgnoreCase("p1")){
							if(ev.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Creeper")||ev.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Skeleton")||ev.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Zombie")){
	
						Inventory Atack = Bukkit.createInventory(null, 9, "Duell Atack with "+ev.getCurrentItem().getItemMeta().getDisplayName()+" from Field "+ ev.getSlot());	
							
						int Count = 9;
						String Arena =  main.duell.getString(pe.getName()+".DuellArena");
						while(Count > 0) {
							
						Count=Count-1;
							if(Count == 4 || Count == 3 || Count == 2 || Count == 1 || Count == 0) {
								int p2mobzone = Count +1;
								if(main.cfg.getBoolean(Arena+".p2"+".mobfield."+p2mobzone+".isinuse")) {
									if(main.cfg.getString(Arena+".p2"+".mobfield."+p2mobzone+".mobname").equalsIgnoreCase("Verdekte Karte")) {
										
										ItemStack Skull = new ItemStack(Material.ACACIA_WOOD , 1);
								    	ItemMeta IMeta =  Skull.getItemMeta(); 
								    	IMeta.setDisplayName("Verdekte Karte");
								    	Skull.setItemMeta(IMeta);
								    	Atack.setItem(Count,Skull);
								    	
									}else {
										if(main.cfg.getString(Arena+".p2"+".mobfield."+p2mobzone+".mobname").equalsIgnoreCase("Skeleton")) {
								    		ItemStack Skull = new ItemStack(Material.SKELETON_SKULL , 1);
									    	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
									    	SMeta.setDisplayName(main.cfg.getString(Arena+".p2"+".mobfield."+p2mobzone+".mobname"));
									    	ArrayList<String> lore = new ArrayList<String>();
								    		lore.add("4");
								    		lore.add(Integer.toString(main.cfg.getInt(Arena+"."+"p2.mobfield."+p2mobzone+".Def")));
								    		SMeta.setLore(lore);
									    	Skull.setItemMeta(SMeta);
									    	Skull.setDurability((short) main.cfg.getInt(Arena+".p2"+".mobfield."+p2mobzone+".mobint"));
									    	Atack.setItem(Count,Skull);
								    	}
										
								    	if(main.cfg.getString(Arena+".p2"+".mobfield."+p2mobzone+".mobname").equalsIgnoreCase("creeper")) {
								    		ItemStack Skull = new ItemStack(Material.CREEPER_HEAD , 1);
									    	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
									    	SMeta.setDisplayName(main.cfg.getString(Arena+".p2"+".mobfield."+p2mobzone+".mobname"));
								    		ArrayList<String> lore = new ArrayList<String>();
								    		lore.add("1");
								    		lore.add(Integer.toString(main.cfg.getInt(Arena+"."+"p2.mobfield."+p2mobzone+".Def")));
								    		SMeta.setLore(lore);
								    		Skull.setItemMeta(SMeta);
								    		Atack.setItem(Count,Skull);
								    	}else if(main.cfg.getString(Arena+".p2"+".mobfield."+p2mobzone+".mobname").equalsIgnoreCase("Zombie")) {
								    		ItemStack Skull = new ItemStack(Material.ZOMBIE_HEAD , 1);
									    	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
									    	SMeta.setDisplayName(main.cfg.getString(Arena+".p2"+".mobfield."+p2mobzone+".mobname"));
								    		ArrayList<String> lore = new ArrayList<String>();
								    		lore.add("2");
								    		lore.add(Integer.toString(main.cfg.getInt(Arena+"."+"p2.mobfield."+p2mobzone+".Def")));
								    		SMeta.setLore(lore);
								    		Skull.setItemMeta(SMeta);
								    		Atack.setItem(Count,Skull);
									    	
								    	}
									}
							
							
							
							
						}
						
						
							}
						}//Ende der While					
						Player p = (Player) ev.getWhoClicked(); 
						if(Main.main.duell.getString(p.getName()+".Phase").equalsIgnoreCase("Main")||Main.main.duell.getString(p.getName()+".Phase").equalsIgnoreCase("Main2")){
						ev.getWhoClicked().openInventory(Atack);
						}
							}
						
						
						}
						
						
						}
						
						
						if(ev.getSlot() ==18 || ev.getSlot() == 19||ev.getSlot() ==20 || ev.getSlot() == 21||ev.getSlot() ==22 ) {
							if(main.duell.getString(ev.getWhoClicked().getName()+".DuellSpieler").equalsIgnoreCase("p2")){
								if(ev.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Creeper")||ev.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Skeleton")||ev.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Zombie")){
		
							Inventory Atack = Bukkit.createInventory(null, 9, "Duell Atack with "+ev.getCurrentItem().getItemMeta().getDisplayName()+" from Field "+ (ev.getSlot()-18));	
								
							
								
								int Count = 9;
								String Arena =  main.duell.getString(pe.getName()+".DuellArena");
								while(Count > 0) {
									
								Count=Count-1;
									if(Count == 4 || Count == 3 || Count == 2 || Count == 1 || Count == 0) {
										int p1mobzone = Count +1;
										if(main.cfg.getBoolean(Arena+".p1"+".mobfield."+p1mobzone+".isinuse")) {
											if(main.cfg.getString(Arena+".p1"+".mobfield."+p1mobzone+".mobname").equalsIgnoreCase("Verdekte Karte")) {
												
												ItemStack Skull = new ItemStack(Material.ACACIA_WOOD , 1);
										    	ItemMeta IMeta =  Skull.getItemMeta(); 
										    	IMeta.setDisplayName("Verdekte Karte");
										    	Skull.setItemMeta(IMeta);
										    	Atack.setItem(Count,Skull);
										    	
											}else {
												if(main.cfg.getString(Arena+".p1"+".mobfield."+p1mobzone+".mobname").equalsIgnoreCase("creeper")) {
										    		ItemStack Skull = new ItemStack(Material.CREEPER_HEAD , 1);
											    	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
											    	SMeta.setDisplayName(main.cfg.getString(Arena+".p1"+".mobfield."+p1mobzone+".mobname"));
										    		ArrayList<String> lore = new ArrayList<String>();
										    		lore.add("1");
										    		lore.add(Integer.toString(main.cfg.getInt(Arena+"."+"p1.mobfield."+p1mobzone+".Def")));
										    		SMeta.setLore(lore);
										    		Skull.setItemMeta(SMeta);
										    		Atack.setItem(Count,Skull);
										    	}else if(main.cfg.getString(Arena+".p1"+".mobfield."+p1mobzone+".mobname").equalsIgnoreCase("Zombie")) {
										    		ItemStack Skull = new ItemStack(Material.ZOMBIE_HEAD , 1);
											    	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
											    	SMeta.setDisplayName(main.cfg.getString(Arena+".p1"+".mobfield."+p1mobzone+".mobname"));
										    		ArrayList<String> lore = new ArrayList<String>();
										    		lore.add("2");
										    		lore.add(Integer.toString(main.cfg.getInt(Arena+"."+"p1.mobfield."+p1mobzone+".Def")));
										    		SMeta.setLore(lore);
										    		Skull.setItemMeta(SMeta);
										    		Atack.setItem(Count,Skull);
											    	
										    	}else if(main.cfg.getString(Arena+".p1"+".mobfield."+p1mobzone+".mobname").equalsIgnoreCase("Skeleton")) {
										    		ItemStack Skull = new ItemStack(Material.SKELETON_SKULL , 1);
											    	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
											    	SMeta.setDisplayName(main.cfg.getString(Arena+".p1"+".mobfield."+p1mobzone+".mobname"));
										    		ArrayList<String> lore = new ArrayList<String>();
										    		lore.add("1");
										    		lore.add(Integer.toString(main.cfg.getInt(Arena+"."+"p1.mobfield."+p1mobzone+".Def")));
										    		SMeta.setLore(lore);
										    		Skull.setItemMeta(SMeta);
										    		Atack.setItem(Count,Skull);
										    	}
											}
									
									
									
									
								}
								
								
									}
								}//Ende der While
								Player p = (Player) ev.getWhoClicked(); 
								if(Main.main.duell.getString(p.getName()+".Phase").equalsIgnoreCase("Main")||Main.main.duell.getString(p.getName()+".Phase").equalsIgnoreCase("Main2")){
								ev.getWhoClicked().openInventory(Atack);
								}
							}
								
								
								
								
								
								
							}else {
								
							}
						}
						
						
					
						
						
					
					
					
					
					
					
					
				
		 
		 
	}
	
}
	if(ev.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Runde Beenden")){
		pe.sendMessage("Runde Wird Beendet");
		pe.closeInventory();
		if(main.duell.getString(main.duell.getString(Arena2+".p1")+".Phase")=="Main"){
			main.duell.set(main.duell.getString(Arena2+".p1")+".Phase", "Enemie");	
			
			
		}else if(main.duell.getString(main.duell.getString(Arena2+".p1")+".Phase")=="Enemie"){
			main.duell.set(main.duell.getString(Arena2+".p1")+".Phase", "Main");	
			Game.DrawCard.DrawaCard(Bukkit.getPlayer(main.duell.getString(Arena2+".p1")));
			
		}
		
		if(main.duell.getString(main.duell.getString(Arena2+".p2")+".Phase")=="Main"){
			main.duell.set(main.duell.getString(Arena2+".p2")+".Phase", "Enemie");	

			
		}else if(main.duell.getString(main.duell.getString(Arena2+".p2")+".Phase")=="Enemie"){
			main.duell.set(main.duell.getString(Arena2+".p2")+".Phase", "Main");
			Game.DrawCard.DrawaCard(Bukkit.getPlayer(main.duell.getString(Arena2+".p2")));
	
			
		}
		Main.main.duell.set(main.duell.getString(Arena2+".p2")+".Cards.APS", 3);
		Main.main.duell.set(main.duell.getString(Arena2+".p1")+".Cards.APS", 3);
		
		
		
	}
				
				
				
	}
	
@EventHandler
public void PlayerUseEvent(PlayerInteractEvent ev) {
	
	Player p = ev.getPlayer();
	
	
	
	
	
	
	
	
	
	if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("Menu")) {
		Game.MenuSpawner.DuellFeld(main.duell.getString(p.getName()+".DuellSpieler"), main.duell.getString(p.getName()+".DuellArena"), p);
	}
	if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("Beschw�re Creeper")||p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("Beschw�re Skeleton")||p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("Beschw�re Zombie")) {
		if(Main.main.duell.getString(p.getName()+".Phase").equalsIgnoreCase("Main")||Main.main.duell.getString(p.getName()+".Phase").equalsIgnoreCase("Main2")){
		Inventory Spawner = Bukkit.createInventory(null, 9, "Duell "+p.getInventory().getItemInMainHand().getItemMeta().getDisplayName());	
		
		int Count = 9;
		String Arena =  Main.main.duell.getString(p.getName()+".DuellArena");
		if(Main.main.duell.getString(p.getName()+".DuellSpieler").equalsIgnoreCase("p2")) {
		while(Count > 0) {
			
		Count=Count-1;
			if(Count == 4 || Count == 3 || Count == 2 || Count == 1 || Count == 0) {
				int p2mobzone = Count +1;
				if(main.cfg.getBoolean(Arena+".p2"+".mobfield."+p2mobzone+".isinuse")) {
					if(main.cfg.getString(Arena+".p2"+".mobfield."+p2mobzone+".mobname").equalsIgnoreCase("Verdekte Karte")) {
						
						ItemStack Skull = new ItemStack(Material.ACACIA_WOOD , 1);
				    	ItemMeta IMeta =  Skull.getItemMeta(); 
				    	IMeta.setDisplayName("Verdekte Karte");
				    	Skull.setItemMeta(IMeta);
				    	Spawner.setItem(Count,Skull);
				    	
					}else {
						ItemStack Skull = new ItemStack(Material.SKELETON_SKULL , 1);
				    	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
				    	SMeta.setDisplayName(main.cfg.getString(Arena+".p2"+".mobfield."+p2mobzone+".mobname"));
				    	Skull.setItemMeta(SMeta);
				    	Skull.setDurability((short) main.cfg.getInt(Arena+".p2"+".mobfield."+p2mobzone+".mobint"));
				    	Spawner.setItem(Count,Skull);
					}
			
			
			
			
		}else{
			ItemStack Skull = new ItemStack(Material.GLASS , 1);
	    	ItemMeta SMeta = (ItemMeta) Skull.getItemMeta(); 
	    	SMeta.setDisplayName("Hier Beschw�ren");
	    	Skull.setItemMeta(SMeta);
	    	Spawner.setItem(Count,Skull);
		}
		
		
			}
		}//Ende der While
		}else {
			while(Count > 0) {
				
				Count=Count-1;
					if(Count == 4 || Count == 3 || Count == 2 || Count == 1 || Count == 0) {
						int p1mobzone = Count +1;
						if(main.cfg.getBoolean(Arena+".p1"+".mobfield."+p1mobzone+".isinuse")) {
							if(main.cfg.getString(Arena+".p1"+".mobfield."+p1mobzone+".mobname").equalsIgnoreCase("Verdekte Karte")) {
								
								ItemStack Skull = new ItemStack(Material.ACACIA_WOOD , 1);
						    	ItemMeta IMeta =  Skull.getItemMeta(); 
						    	IMeta.setDisplayName("Verdekte Karte");
						    	Skull.setItemMeta(IMeta);
						    	Spawner.setItem(Count,Skull);
						    	
							}else {
								ItemStack Skull = new ItemStack(Material.SKELETON_SKULL , 1);
						    	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
						    	SMeta.setDisplayName(main.cfg.getString(Arena+".p1"+".mobfield."+p1mobzone+".mobname"));
						    	Skull.setItemMeta(SMeta);
						    	Skull.setDurability((short) main.cfg.getInt(Arena+".p1"+".mobfield."+p1mobzone+".mobint"));
						    	Spawner.setItem(Count,Skull);
							}
					
						}else{
							ItemStack Skull = new ItemStack(Material.GLASS , 1);
					    	ItemMeta SMeta = (ItemMeta) Skull.getItemMeta(); 
					    	SMeta.setDisplayName("Hier Beschw�ren");
					    	Skull.setItemMeta(SMeta);
					    	Spawner.setItem(Count,Skull);
						}
					
					
				}
				
				
					}
		}
		if(!main.duell.getBoolean(p.getName()+".Cards.Modus")) {
		ItemStack Skull = new ItemStack(Material.BIRCH_PLANKS , 1);
    	ItemMeta SMeta = (ItemMeta) Skull.getItemMeta(); 
    	SMeta.setDisplayName("Verdeckt Spielen");
    	Skull.setItemMeta(SMeta);
    	Spawner.setItem(8,Skull);
    	}else {
    		ItemStack Skull = new ItemStack(Material.GLASS , 1);
        	ItemMeta SMeta = (ItemMeta) Skull.getItemMeta(); 
        	SMeta.setDisplayName("Offen Spielen");
        	Skull.setItemMeta(SMeta);
        	Spawner.setItem(8,Skull);
    		
    		
    	}
    	
		p.openInventory(Spawner);
		
		
		
		
		
	}
}
}
@EventHandler
public void PlayerDeath(PlayerDeathEvent ev) {
Player p = ev.getEntity();
	String Arena =  Main.main.duell.getString(p.getName()+".DuellArena");	
	String p1Name = main.duell.getString(Arena+".p1");
	String p2Name = main.duell.getString(Arena+".p2");
	if(p1Name.equalsIgnoreCase(p.getName())) {
		Bukkit.broadcastMessage("Der Spieler: "+p2Name+" Hat auf der Arena: "+Arena+" gegen: "+p1Name+" Gewonnen");
		Bukkit.getPlayer(p2Name).performCommand("spawn");
	}else if(p2Name.equalsIgnoreCase(p.getName())) {
		Bukkit.broadcastMessage("Der Spieler: "+p1Name+" Hat auf der Arena: "+Arena+" gegen: "+p2Name+" Gewonnen");
		Bukkit.getPlayer(p1Name).performCommand("spawn");
	}
	if(p2Name.equalsIgnoreCase(p.getName())||p1Name.equalsIgnoreCase(p.getName())) {
		Spawner.deSummon("p1", 1, Arena, Bukkit.getPlayer(p1Name));
		Spawner.deSummon("p1", 2, Arena, Bukkit.getPlayer(p1Name));
		Spawner.deSummon("p1", 3, Arena, Bukkit.getPlayer(p1Name));
		Spawner.deSummon("p1", 4, Arena, Bukkit.getPlayer(p1Name));
		Spawner.deSummon("p1", 5, Arena, Bukkit.getPlayer(p1Name));
		
		Spawner.deSummon("p2", 1, Arena, Bukkit.getPlayer(p2Name));
		Spawner.deSummon("p2", 2, Arena, Bukkit.getPlayer(p2Name));
		Spawner.deSummon("p2", 3, Arena, Bukkit.getPlayer(p2Name));
		Spawner.deSummon("p2", 4, Arena, Bukkit.getPlayer(p2Name));
		Spawner.deSummon("p2", 5, Arena, Bukkit.getPlayer(p2Name));
		
	}
	
	
}
}

