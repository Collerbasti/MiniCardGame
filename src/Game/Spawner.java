package Game;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.Skeleton;

import Main.main;

public class Spawner {
	
	
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
		Spawn.getWorld().spawn(Spawn, Creeper.class);
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
		Spawn.getWorld().spawn(Spawn, Zombie.class);
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".isinuse",true);
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".mobname","Zombie");
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".mobint",2);
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
		Spawn.getWorld().spawn(Spawn, Skeleton.class);
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".isinuse",true);
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".mobname","Skeletton");
		main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".mobint",0);
	}
	
	}


	public static void BlockSpawner(String Playerside , int mobfield , String Arena , Player p , boolean wizzone) {
		if(wizzone) {
			
			if(!(main.cfg.getBoolean(Arena+"."+Playerside+".wizzone."+mobfield+".isinuse"))) {
			Double x = main.arena.getDouble(Arena+"."+Playerside+".Wizzone."+mobfield+".loc.X");
			Double y = main.arena.getDouble(Arena+"."+Playerside+".Wizzone."+mobfield+".loc.Y");
			Double z = main.arena.getDouble(Arena+"."+Playerside+".Wizzone."+mobfield+".loc.Z");
			Float yaw = (float) main.arena.getDouble(Arena+"."+Playerside+".Wizzone."+mobfield+".loc.Yaw");
			Float pitch = (float) main.arena.getDouble(Arena+"."+Playerside+".Wizzone."+mobfield+".loc.Pitch");
			org.bukkit.World w = Bukkit.getWorld(main.arena.getString(Arena+"."+Playerside+".Wizzone."+mobfield+".loc.World"));
			Location Spawn = new Location(w,x,y,z,yaw,pitch);
			w.getBlockAt(Spawn).setType(Material.WOOD);
			main.cfg.set(Arena+"."+Playerside+".wizzone."+mobfield+".isinuse",true);
			main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".mobname","Verdekte Karte");
			main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".mobint",0);
			}
		}else {
			
			if(!(main.cfg.getBoolean(Arena+".mobfield."+mobfield+".isinuse"))) {
			Double x = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.X");
			Double y = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Y");
			Double z = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Z");
			Float yaw = (float) main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Yaw");
			Float pitch = (float) main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Pitch");
			org.bukkit.World w = Bukkit.getWorld(main.arena.getString(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.World"));
			Location Spawn = new Location(w,x,y,z,yaw,pitch);
			w.getBlockAt(Spawn).setType(Material.WOOD);
			main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".isinuse",true);
			main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".mobname","Verdekte Karte");
			main.cfg.set(Arena+"."+Playerside+".mobfield."+mobfield+".mobint",0);
			}
		}
	}
	
	
}
