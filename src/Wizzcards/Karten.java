package Wizzcards;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import Main.main;

public class Karten {

	
	
	public static void Sword_Of_Destiny(String p) {
	Player p1 =	Bukkit.getPlayer(p);
	ItemStack Skull = new ItemStack(Material.DIAMOND_SWORD, 1);
	SkullMeta SMeta = (SkullMeta) Skull.getItemMeta(); 
	SMeta.setDisplayName("Sword Of Destiny");
	ArrayList<String> lore = new ArrayList<String>();
	lore.add("Ausrüstungs Karte");
	lore.add("ATK +");
	lore.add("2");
	SMeta.setLore(lore);
	Skull.setItemMeta(SMeta);
	p1.getInventory().addItem(Skull);
	}
	
	
	
}
