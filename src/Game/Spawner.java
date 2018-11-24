package Game;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.entity.Skeleton;

import Main.main;

public class Spawner {
	public static void Summon(Boolean Verdeckt,String Mob,String Playerside , int mobfield , String Arena , Player p,Material MobType) {

		int APS= Main.main.duell.getInt(p.getName()+".Cards.APS");
		if (APS==0) {
		p.sendMessage("Du hast keine Aktzions Punkte Mehr");	
		}else {
			Main.main.duell.set(p.getName()+".Cards.APS", APS-1);
		
			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("Beschwöre Creeper")) {
				if(p.getInventory().getItemInMainHand().getAmount()-1==0) {
					p.getInventory().remove(Material.CREEPER_HEAD);	
				}else {
		  	ItemStack p1Health = new ItemStack(Material.CREEPER_HEAD,p.getInventory().getItemInMainHand().getAmount()-1);
	    	SkullMeta p1Meta = (SkullMeta) p1Health.getItemMeta();
	    	p1Meta.setDisplayName("Beschwöre Creeper");
	    	p1Health.setItemMeta(p1Meta);
	    	int Slot = p.getInventory().getHeldItemSlot();
	    	p.getInventory().remove(Material.CREEPER_HEAD);
			p.getInventory().setItem(Slot, p1Health);
				}
				
			}else 	if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("Beschwöre ZOMBIE")) {
				if(p.getInventory().getItemInMainHand().getAmount()-1==0) {
					p.getInventory().remove(Material.ZOMBIE_HEAD);	
				}else {
		  	ItemStack p1Health = new ItemStack(Material.ZOMBIE_HEAD,p.getInventory().getItemInMainHand().getAmount()-1);
	    	SkullMeta p1Meta = (SkullMeta) p1Health.getItemMeta();
	    	p1Meta.setDisplayName("Beschwöre ZOMBIE");
	    	p1Health.setItemMeta(p1Meta);
	    	int Slot = p.getInventory().getHeldItemSlot();
	    	p.getInventory().remove(Material.ZOMBIE_HEAD);
			p.getInventory().setItem(Slot, p1Health);
				}
			}
			else 	if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("Beschwöre SKELETON")) {
				if(p.getInventory().getItemInMainHand().getAmount()-1==0) {
					p.getInventory().remove(Material.SKELETON_SKULL);	
				}else {
		  	ItemStack p1Health = new ItemStack(Material.SKELETON_SKULL,p.getInventory().getItemInMainHand().getAmount()-1);
	    	SkullMeta p1Meta = (SkullMeta) p1Health.getItemMeta();
	    	p1Meta.setDisplayName("Beschwöre SKELETON");
	    	p1Health.setItemMeta(p1Meta);
	    	int Slot = p.getInventory().getHeldItemSlot();
	    	p.getInventory().remove(Material.SKELETON_SKULL);
			p.getInventory().setItem(Slot, p1Health);
				}
			}
			
		int Count = Main.main.duell.getInt(p.getName()+".Cards.Count")-1;
		
		
		
		
		Main.main.duell.set(p.getName()+".Cards.Count", Count);
	if(main.duell.getBoolean(p.getName()+".Cards.Modus")) {
		BlockSpawner(Arena, mobfield, Arena, false, true);
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".Karte",Mob);
		
		
		
	}else {
		if(Mob.equalsIgnoreCase("Creeper")) {
			Creeper(Playerside, mobfield, Arena, p);
		}else if(Mob.equalsIgnoreCase("Zombie")) {
			Zombie(Playerside, mobfield, Arena, p);
		}else if(Mob.equalsIgnoreCase("Skeleton")){
			Skeleton(Playerside, mobfield, Arena, p);
		}
		p.closeInventory();
	}
	}
	}
	public static void Creeper(String Playerside , int mobfield , String Arena, Player p) {
		if(!(main.cfg.getBoolean(Arena+"."+Playerside+".mobfield."+mobfield+".isinuse"))) {
		p.sendMessage("Creeper wird versucht zu spawnen 2");
		
		Double x = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.X");
		Double y = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Y");
		Double z = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Z");
		Float yaw = (float) main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Yaw");
		Float pitch = (float) main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Pitch");
		org.bukkit.World w = Bukkit.getWorld(main.arena.getString(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.World"));
		
		
		Location Spawn = new Location(w,x,y,z,yaw,pitch);
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".isinuse",true);
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".mobname","Creeper");
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".mobint",4);
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".Def",2);
		LivingEntity entity = (LivingEntity) Bukkit.getWorld(main.arena.getString(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.World")).spawnEntity(Spawn, EntityType.CREEPER);
		entity.setCustomName(Integer.toString(mobfield)+" "+Playerside);
		main.arena.set(Arena+"."+entity.getCustomName(), entity.getUniqueId());
		}
	}
	
	public static void Zombie(String Playerside , int mobfield , String Arena , Player p) {
		if(!(main.cfg.getBoolean(Arena+"."+Playerside+".mobfield."+mobfield+".isinuse"))) {
		p.sendMessage("Zombie wird versucht zu spawnen 2");
		
		Double x = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.X");
		Double y = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Y");
		Double z = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Z");
		Float yaw = (float) main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Yaw");
		Float pitch = (float) main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Pitch");
		org.bukkit.World w = Bukkit.getWorld(main.arena.getString(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.World"));
		
		
		Location Spawn = new Location(w,x,y,z,yaw,pitch);
		LivingEntity entity = (LivingEntity) Bukkit.getWorld(main.arena.getString(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.World")).spawnEntity(Spawn, EntityType.ZOMBIE);
		entity.setCustomName(Integer.toString(mobfield)+" "+Playerside);
		main.arena.set(Arena+"."+entity.getCustomName(), entity.getUniqueId());
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".isinuse",true);
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".mobname","Zombie");
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".mobint",2);
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".Def",4);
		}
	}
	
	public static void Skeleton(String Playerside , int mobfield , String Arena , Player p) {
		if(!(main.cfg.getBoolean(Arena+"."+Playerside+".mobfield."+mobfield+".isinuse"))) {
		p.sendMessage("Zombie wird versucht zu spawnen 2");
		
		Double x = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.X");
		Double y = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Y");
		Double z = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Z");
		Float yaw = (float) main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Yaw");
		Float pitch = (float) main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Pitch");
		org.bukkit.World w = Bukkit.getWorld(main.arena.getString(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.World"));
		
		
		Location Spawn = new Location(w,x,y,z,yaw,pitch);
		LivingEntity entity = (LivingEntity) Bukkit.getWorld(main.arena.getString(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.World")).spawnEntity(Spawn, EntityType.SKELETON);
		entity.setCustomName(Integer.toString(mobfield)+" "+Playerside);
		main.arena.set(Arena+"."+entity.getCustomName(), entity.getUniqueId());
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".isinuse",true);
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".mobname","Skeleton");
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".mobint",1);
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".Def",4);
	}
	
	}
	public static void deSummon(String Playerside , int mobfield , String Arena ) {
		
		
		for(Entity e : Bukkit.getWorld(main.arena.getString(Arena+"."+Playerside+".Wizzone."+mobfield+".loc.World")).getEntities()) {
			if (e instanceof LivingEntity && !(e instanceof Player)) {
				
				if(e.getUniqueId().equals(main.arena.get(Arena+"."+mobfield+" "+Playerside))) {
					if(main.cfg.getBoolean(Arena+"."+Playerside+".mobfield."+mobfield+".hasExtras")) {
						int count = main.cfg.getInt(Arena+"."+Playerside+".mobfield."+mobfield+".Extras.count");
						while(count!=0) {
							count = count -1;
							
							int mobfieldB = main.cfg.getInt(Arena+"."+Playerside+".mobfield."+mobfield+".Extras."+count+".mobfield");
							Bukkit.getPlayer(main.duell.getString(Arena+"."+Playerside)).sendMessage(Playerside+ mobfieldB+ Arena );
							BlockSpawner(Playerside, mobfieldB, Arena, true, false );
								
						}
						
					}
					main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".isinuse",false);
					e.remove();
				}
			}
		}
	}
		

	public static void BlockSpawner(String Playerside , int mobfield , String Arena  , boolean wizzone, boolean Setzen ) {
			if(wizzone) {
			
		
			Double x = main.arena.getDouble(Arena+"."+Playerside+".Wizzone."+mobfield+".loc.X");
			Double y = main.arena.getDouble(Arena+"."+Playerside+".Wizzone."+mobfield+".loc.Y");
			Double z = main.arena.getDouble(Arena+"."+Playerside+".Wizzone."+mobfield+".loc.Z");
			Float yaw = (float) main.arena.getDouble(Arena+"."+Playerside+".Wizzone."+mobfield+".loc.Yaw");
			Float pitch = (float) main.arena.getDouble(Arena+"."+Playerside+".Wizzone."+mobfield+".loc.Pitch");
			org.bukkit.World w = Bukkit.getWorld(main.arena.getString(Arena+"."+Playerside+".Wizzone."+mobfield+".loc.World"));
			Location Spawn = new Location(w,x,y,z,yaw,pitch);
			
			if(Setzen) {
			w.getBlockAt(Spawn).setType(Material.ACACIA_WOOD);
			main.cfg.set(Arena+"."+Playerside+".wizzone."+mobfield+".isinuse",true);
			main.cfg.set(Arena+"."+Playerside+".wizzone."+mobfield+".mobname","Verdekte Karte");
			main.cfg.set(Arena+"."+Playerside+".wizzone."+mobfield+".mobint",0);
			}else {
				w.getBlockAt(Spawn).setType(Material.AIR);
				System.out.println("Block wird gelöscht");
				
				main.cfg.set(Arena+"."+Playerside+".wizzone."+mobfield+".isinuse",false);
				main.cfg.set(Arena+"."+Playerside+".wizzone."+mobfield+".mobname","none");
				main.cfg.set(Arena+"."+Playerside+".wizzone."+mobfield+".mobint",0);
			}
			
			
	
		}
	}
	
	
}
