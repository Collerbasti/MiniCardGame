package Game;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Main.main;

public class DrawCard {

	public static void DrawaCard(Player p) {
		if(main.duell.getInt(p.getName()+".Cards.Count")==9) {
			p.sendMessage("Du hast bereits 9 Karten in der Hand");
		}else {
			int Count = Main.main.duell.getInt(p.getName()+".Cards.Count");
			Random r = new Random();
			
			int r2 = r.nextInt((3-1)+1)+1;
			
			if(r2 == 1) {
				p.sendMessage("Du hast einen Creeper gezogen");
				ItemStack Creeper = new ItemStack(Material.CREEPER_HEAD,1);
				ItemMeta MCreeper = Creeper.getItemMeta();
						MCreeper.setDisplayName("Beschwöre Creeper");
						Creeper.setItemMeta(MCreeper);
						p.getInventory().addItem(Creeper);
				Count =Count+1;
				
			}else if(r2 == 2) {
				p.sendMessage("Du hast einen ZOMBIE gezogen");
				
				ItemStack ZOMBIE = new ItemStack(Material.ZOMBIE_HEAD,1);
				ItemMeta MZOMBIE = ZOMBIE.getItemMeta();
						MZOMBIE.setDisplayName("Beschwöre ZOMBIE");
						ZOMBIE.setItemMeta(MZOMBIE);
						p.getInventory().addItem(ZOMBIE);
						Count =Count+1;
				
			}else if(r2 == 3) {
				p.sendMessage("Du hast einen SKELETON gezogen");
				ItemStack SKELETON = new ItemStack(Material.SKELETON_SKULL,1);
				ItemMeta MSKELETON = SKELETON.getItemMeta();
						MSKELETON.setDisplayName("Beschwöre SKELETON");
						SKELETON.setItemMeta(MSKELETON);
						p.getInventory().addItem(SKELETON);
						Count =Count+1;		
				
				
			}
			Main.main.duell.set(p.getName()+".Cards.Count", Count);
			
			
			
			
		}
		
		
	}


	
}
