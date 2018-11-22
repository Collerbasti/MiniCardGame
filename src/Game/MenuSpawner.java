package Game;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import Main.main;

public class MenuSpawner {
	
	
	
	public static void DuellFeld(String playerside, String Arena , Player p) {
		
		Inventory myInventory = Bukkit.createInventory(null, 9*5, "Duell Feld!");
		
		ItemStack Back = new ItemStack(Material.BARRIER);
    	ItemMeta BMeta =  Back.getItemMeta(); 
    	BMeta.setDisplayName("Phase: "+Main.main.duell.getString(p.getName()+".Phase"));
    	Back.setItemMeta(BMeta);
    	myInventory.setItem(44, Back);
    	
    	
    	ItemStack APS = new ItemStack(Material.GLASS);
    	ItemMeta APSMETA =  APS.getItemMeta(); 
    	APSMETA.setDisplayName("APS: "+Main.main.duell.getString(p.getName()+".Cards.APS")+"/3");
    	APS.setItemMeta(APSMETA);
    	myInventory.setItem(43, APS);
    	
    	
    	if(main.duell.getString(p.getName()+".Phase")=="Main") {
    	ItemStack Round = new ItemStack(Material.GLASS);
    	ItemMeta RoundMETA =  Round.getItemMeta(); 
    	RoundMETA.setDisplayName("Runde Beenden");
    	Round.setItemMeta(RoundMETA);
    	myInventory.setItem(42, Round);
    	}
    	
    	ItemStack p1Health = new ItemStack(Material.PLAYER_HEAD);
    	SkullMeta p1Meta = (SkullMeta) p1Health.getItemMeta();
    	p1Meta.setOwningPlayer(Bukkit.getPlayer((main.duell.getString(Arena+".p1"))));
    	p1Meta.setDisplayName("LP: "+Bukkit.getPlayer(main.duell.getString(Arena+".p1")).getHealth()+"/20");
    	p1Health.setItemMeta(p1Meta);
    	
    	ItemStack p2Health = new ItemStack(Material.PLAYER_HEAD);
    	SkullMeta p2Meta = (SkullMeta) p2Health.getItemMeta();
    	p2Meta.setOwningPlayer(Bukkit.getPlayer((main.duell.getString(Arena+".p2"))));
    	p2Meta.setDisplayName("LP: "+Bukkit.getPlayer(main.duell.getString(Arena+".p2")).getHealth()+"/20");
    	p2Health.setItemMeta(p2Meta);
    	myInventory.setItem(41, p1Health);
    	myInventory.setItem(40, p2Health);
		int Count = 36;
		while(Count > 0) {
			Count = Count -1;
			
			
			
			if(Count == 4 || Count == 3 || Count == 2 || Count == 1 || Count == 0) {
				int p1Mobzone = Count +1;
				if(main.cfg.getBoolean(Arena+".p1"+".mobfield."+p1Mobzone+".isinuse")) {
					if(main.cfg.getString(Arena+".p1"+".mobfield."+p1Mobzone+".mobname")=="Verdekte Karte") {
						
						ItemStack Skull = new ItemStack(Material.ACACIA_WOOD , 1);
				    	ItemMeta IMeta = (ItemMeta) Skull.getItemMeta(); 
				    	IMeta.setDisplayName("Verdekte Karte");
				    	Skull.setItemMeta(IMeta);
				    	myInventory.setItem(Count,Skull);
						
					}else {
						if(main.cfg.getString(Arena+".p1"+".mobfield."+p1Mobzone+".mobname").equalsIgnoreCase("creeper")) {
				    		ItemStack Skull = new ItemStack(Material.CREEPER_HEAD , 1);
					    	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
					    	SMeta.setDisplayName(main.cfg.getString(Arena+".p1"+".mobfield."+p1Mobzone+".mobname"));
				    		ArrayList<String> lore = new ArrayList<String>();
				    		lore.add(main.cfg.getString(Arena+"."+"p1"+".mobfield."+p1Mobzone+".mobint"));
				    		lore.add(Integer.toString(main.cfg.getInt(Arena+"."+"p1.mobfield."+p1Mobzone+".Def")));
				    		SMeta.setLore(lore);
				    		Skull.setItemMeta(SMeta);
					    	myInventory.setItem(Count,Skull);
				    	}else if(main.cfg.getString(Arena+".p1.mobfield."+p1Mobzone+".mobname").equalsIgnoreCase("Zombie")) {
				    		ItemStack Skull = new ItemStack(Material.ZOMBIE_HEAD , 1);
					    	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
					    	SMeta.setDisplayName(main.cfg.getString(Arena+".p1"+".mobfield."+p1Mobzone+".mobname"));
				    		ArrayList<String> lore = new ArrayList<String>();
				    		lore.add(main.cfg.getString(Arena+"."+"p1"+".mobfield."+p1Mobzone+".mobint"));
				    		lore.add(Integer.toString(main.cfg.getInt(Arena+"."+"p1.mobfield."+p1Mobzone+".Def")));
				    		SMeta.setLore(lore);
				    		Skull.setItemMeta(SMeta);
					    	myInventory.setItem(Count,Skull);
				    	}else if(main.cfg.getString(Arena+".p1.mobfield."+p1Mobzone+".mobname").equalsIgnoreCase("Skeleton")) {
				    		
				    		ItemStack Skull = new ItemStack(Material.SKELETON_SKULL , 1);
					    	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
					    	SMeta.setDisplayName(main.cfg.getString(Arena+".p1"+".mobfield."+p1Mobzone+".mobname"));
					    	Skull.setItemMeta(SMeta);
					    	ArrayList<String> lore = new ArrayList<String>();
					    	lore.add(main.cfg.getString(Arena+"."+"p1"+".mobfield."+p1Mobzone+".mobint"));
				    		lore.add(Integer.toString(main.cfg.getInt(Arena+"."+"p2.mobfield."+p1Mobzone+".Def")));
				    		SMeta.setLore(lore);
				    		Skull.setItemMeta(SMeta);
					    	myInventory.setItem(Count,Skull);
				    	}
				}
				}
					
			}else if(Count == 13 || Count == 12 || Count == 11 || Count == 10 || Count == 9) {
				
					int p1wizzone = Count -8;
					if(main.cfg.getBoolean(Arena+".p1"+".wizzone."+p1wizzone+".isinuse")) {
						
						
							
							ItemStack Skull = new ItemStack(Material.ACACIA_WOOD , 1);
					    	ItemMeta IMeta =  Skull.getItemMeta(); 
					    	IMeta.setDisplayName(main.cfg.getString(Arena+".p1"+".wizzone."+p1wizzone+".mobname"));
					    	Skull.setItemMeta(IMeta);
					    	myInventory.setItem(Count,Skull);
							
						
					}
				}else if(Count == 22 || Count == 21 || Count == 20 || Count == 19 || Count == 18) {
						int p2Mobzone = Count -17;
						if(main.cfg.getBoolean(Arena+".p2"+".mobfield."+p2Mobzone+".isinuse")) {
							if(main.cfg.getString(Arena+".p2"+".mobfield."+p2Mobzone+".mobname")=="Verdekte Karte") {
								
								ItemStack Skull = new ItemStack(Material.ACACIA_WOOD , 1);
						    	ItemMeta IMeta =  Skull.getItemMeta(); 
						    	IMeta.setDisplayName("Verdekte Karte");
						    	Skull.setItemMeta(IMeta);
						    	myInventory.setItem(Count,Skull);
						    	
							}else {
								
								if(main.cfg.getString(Arena+".p2"+".mobfield."+p2Mobzone+".mobname").equalsIgnoreCase("Skeleton")) {
						    		ItemStack Skull = new ItemStack(Material.SKELETON_SKULL , 1);
							    	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
							    	SMeta.setDisplayName(main.cfg.getString(Arena+".p2"+".mobfield."+p2Mobzone+".mobname"));
							    	ArrayList<String> lore = new ArrayList<String>();
							    	lore.add(main.cfg.getString(Arena+"."+"p2"+".mobfield."+p2Mobzone+".mobint"));
						    		lore.add(Integer.toString(main.cfg.getInt(Arena+"."+"p2.mobfield."+p2Mobzone+".Def")));
						    		SMeta.setLore(lore);
							    	Skull.setItemMeta(SMeta);
							    	
							    	myInventory.setItem(Count,Skull);
						    	}
								
						    	if(main.cfg.getString(Arena+".p2"+".mobfield."+p2Mobzone+".mobname").equalsIgnoreCase("creeper")) {
						    		ItemStack Skull = new ItemStack(Material.CREEPER_HEAD , 1);
							    	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
							    	SMeta.setDisplayName(main.cfg.getString(Arena+".p2"+".mobfield."+p2Mobzone+".mobname"));
						    		ArrayList<String> lore = new ArrayList<String>();
						    		lore.add(main.cfg.getString(Arena+"."+"p2"+".mobfield."+p2Mobzone+".mobint"));
						    		lore.add(Integer.toString(main.cfg.getInt(Arena+"."+"p2.mobfield."+p2Mobzone+".Def")));
						    		SMeta.setLore(lore);
						    		Skull.setItemMeta(SMeta);
							    	myInventory.setItem(Count,Skull);
						    	}else if(main.cfg.getString(Arena+".p2"+".mobfield."+p2Mobzone+".mobname").equalsIgnoreCase("Zombie")) {
						    		ItemStack Skull = new ItemStack(Material.ZOMBIE_HEAD , 1);
							    	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
							    	SMeta.setDisplayName(main.cfg.getString(Arena+".p2"+".mobfield."+p2Mobzone+".mobname"));
						    		ArrayList<String> lore = new ArrayList<String>();
						    		lore.add(main.cfg.getString(Arena+"."+"p2"+".mobfield."+p2Mobzone+".mobint"));
						    		lore.add(Integer.toString(main.cfg.getInt(Arena+"."+"p2.mobfield."+p2Mobzone+".Def")));
						    		SMeta.setLore(lore);
						    		Skull.setItemMeta(SMeta);
							    	myInventory.setItem(Count,Skull);
							    	
						    	}
						    	
						    	
						    	
						    	
						    	
						    	
							}
						}
					}else if(Count == 31 || Count == 30 || Count == 29 || Count == 28 || Count == 27) {
						
						
							int p2wizzone = Count -26;
							if(main.cfg.getBoolean(Arena+".p2"+".wizzone."+p2wizzone+".isinuse")) {
								
							
									
									ItemStack Skull = new ItemStack(Material.ACACIA_WOOD , 1);
							    	ItemMeta IMeta = Skull.getItemMeta(); 
							    	IMeta.setDisplayName(main.cfg.getString(Arena+".p2"+".wizzone."+p2wizzone+".mobname"));
							    	Skull.setItemMeta(IMeta);
							    	myInventory.setItem(Count,Skull);
								
								
						}					
		}
	
	
	
	

	
	

	
			}
	p.openInventory(myInventory);	
	}



}
		
