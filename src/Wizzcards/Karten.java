package Wizzcards;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import Main.main;

public class Karten {

	public static void Karte(String p, String Karte) {
	
	if (Karte == "Sword_Of_Destiny") {
	Player p1 =	Bukkit.getPlayer(p);
	ItemStack Skull = new ItemStack(Material.DIAMOND_SWORD, 1);
	ItemMeta SMeta = Skull.getItemMeta(); 
	SMeta.setDisplayName("Sword Of Destiny");
	ArrayList<String> lore = new ArrayList<String>();
	lore.add("Ausrüstungs Karte");
	lore.add("ATK +");
	lore.add("2");
	SMeta.setLore(lore);
	Skull.setItemMeta(SMeta);
	p1.getInventory().addItem(Skull);
	}
	
	if ( Karte == "Trank_der_Heilung") {
		Player p1 =	Bukkit.getPlayer(p);
		ItemStack Skull = new ItemStack(Material.JUNGLE_PLANKS, 1);
		ItemMeta SMeta =  Skull.getItemMeta(); 
		SMeta.setDisplayName("Trank der Heilung");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Ausrüstungs Karte");
		lore.add("DEF +");
		lore.add("2");
		SMeta.setLore(lore);
		Skull.setItemMeta(SMeta);
		p1.getInventory().addItem(Skull);
		}
	if ( Karte == "Kecks") {
		Player p1 =	Bukkit.getPlayer(p);
		ItemStack Skull = new ItemStack(Material.COOKIE, 1);
		ItemMeta SMeta =  Skull.getItemMeta(); 
		SMeta.setDisplayName("Keks");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Füllt Hunger auf");
		SMeta.setLore(lore);
		Skull.setItemMeta(SMeta);
		p1.getInventory().addItem(Skull);
		}
	
	}
	
}
