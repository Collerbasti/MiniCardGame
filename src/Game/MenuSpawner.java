package Game;

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
    	BMeta.setDisplayName("Zurück");
    	Back.setItemMeta(BMeta);
    	myInventory.setItem(44, Back);
		int Count = 36;
		while(Count > 0) {
			Count = Count -1;
			
			
			
			if(Count == 4 || Count == 3 || Count == 2 || Count == 1 || Count == 0) {
				int p1Mobzone = Count +1;
				if(main.cfg.getBoolean(Arena+".p1"+".mobfield."+p1Mobzone+".isinuse")) {
					if(main.cfg.getString(Arena+".p1"+".mobfield."+p1Mobzone+".mobname")=="Verdekte Karte") {
						
						ItemStack Skull = new ItemStack(Material.WOOD , 1);
				    	ItemMeta IMeta = (ItemMeta) Skull.getItemMeta(); 
				    	IMeta.setDisplayName("Verdekte Karte");
				    	Skull.setItemMeta(IMeta);
				    	myInventory.setItem(Count,Skull);
						
					}else {
					ItemStack Skull = new ItemStack(Material.SKULL_ITEM , 1);
			    	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
			    	SMeta.setDisplayName(main.cfg.getString(Arena+".p1"+".mobfield."+p1Mobzone+".mobname"));
			    	Skull.setItemMeta(SMeta);
			    	Skull.setDurability((short) main.cfg.getInt(Arena+".p1"+".mobfield."+p1Mobzone+".mobint"));
			    	myInventory.setItem(Count,Skull);
				}
				}
					
			}else if(Count == 13 || Count == 12 || Count == 11 || Count == 10 || Count == 9) {
				
					int p1wizzone = Count -8;
					if(main.cfg.getBoolean(Arena+".p1"+".wizzone."+p1wizzone+".isinuse")) {
						
						if(main.cfg.getString(Arena+".p1"+".mobfield."+p1wizzone+".mobname")=="Verdekte Karte") {
							
							ItemStack Skull = new ItemStack(Material.WOOD , 1);
					    	ItemMeta IMeta =  Skull.getItemMeta(); 
					    	IMeta.setDisplayName("Verdekte Karte");
					    	Skull.setItemMeta(IMeta);
					    	myInventory.setItem(Count,Skull);
							
						}
					}
				}else if(Count == 22 || Count == 21 || Count == 20 || Count == 19 || Count == 18) {
						int p2mobzone = Count -17;
						if(main.cfg.getBoolean(Arena+".p2"+".mobfield."+p2mobzone+".isinuse")) {
							if(main.cfg.getString(Arena+".p2"+".mobfield."+p2mobzone+".mobname")=="Verdekte Karte") {
								
								ItemStack Skull = new ItemStack(Material.WOOD , 1);
						    	ItemMeta IMeta =  Skull.getItemMeta(); 
						    	IMeta.setDisplayName("Verdekte Karte");
						    	Skull.setItemMeta(IMeta);
						    	myInventory.setItem(Count,Skull);
						    	
							}else {
								ItemStack Skull = new ItemStack(Material.SKULL_ITEM , 1);
						    	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
						    	SMeta.setDisplayName(main.cfg.getString(Arena+".p2"+".mobfield."+p2mobzone+".mobname"));
						    	Skull.setItemMeta(SMeta);
						    	Skull.setDurability((short) main.cfg.getInt(Arena+".p2"+".mobfield."+p2mobzone+".mobint"));
						    	myInventory.setItem(Count,Skull);
							}
						}
					}else if(Count == 31 || Count == 30 || Count == 29 || Count == 28 || Count == 27) {
						
						p.sendMessage(String.valueOf(Count));
							int p2wizzone = Count -26;
							if(main.cfg.getBoolean(Arena+".p2"+".wizzone."+p2wizzone+".isinuse")) {
								
								if(main.cfg.getString(Arena+".p2"+".Wizzone."+p2wizzone+".mobname")=="Verdekte Karte") {
									
									ItemStack Skull = new ItemStack(Material.WOOD , 1);
							    	ItemMeta IMeta = Skull.getItemMeta(); 
							    	IMeta.setDisplayName("Verdekte Karte");
							    	Skull.setItemMeta(IMeta);
							    	myInventory.setItem(Count,Skull);
								}
								
						}					
		}
	
	
	
	

	
	

	
			}
	p.openInventory(myInventory);	
	}



}
		
