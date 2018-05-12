package Game;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.Skeleton;

import Main.main;

public class Spawner {
	
	
	public static void Creeper(String Playerside , int mobfield , String Arena, Player p) {
		p.sendMessage("Creeper wird versucht zu spawnen 2");
		
		Double x = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.X");
		Double y = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Y");
		Double z = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Z");
		Float yaw = (float) main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Yaw");
		Float pitch = (float) main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Pitch");
		org.bukkit.World w = Bukkit.getWorld(main.arena.getString(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.World"));
		
		
		Location Spawn = new Location(w,x,y,z,yaw,pitch);
		Spawn.getWorld().spawn(Spawn, Creeper.class);
		

		
		
	}
	
	public static void Zombie(String Playerside , int mobfield , String Arena , Player p) {
		p.sendMessage("Zombie wird versucht zu spawnen 2");
		
		Double x = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.X");
		Double y = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Y");
		Double z = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Z");
		Float yaw = (float) main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Yaw");
		Float pitch = (float) main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Pitch");
		org.bukkit.World w = Bukkit.getWorld(main.arena.getString(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.World"));
		
		
		Location Spawn = new Location(w,x,y,z,yaw,pitch);
		Spawn.getWorld().spawn(Spawn, Zombie.class);
	
	}
	
	public static void Skeleton(String Playerside , int mobfield , String Arena , Player p) {
		p.sendMessage("Zombie wird versucht zu spawnen 2");
		
		Double x = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.X");
		Double y = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Y");
		Double z = main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Z");
		Float yaw = (float) main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Yaw");
		Float pitch = (float) main.arena.getDouble(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.Pitch");
		org.bukkit.World w = Bukkit.getWorld(main.arena.getString(Arena+"."+Playerside+".Mobzone."+mobfield+".loc.World"));
		
		
		Location Spawn = new Location(w,x,y,z,yaw,pitch);
		Spawn.getWorld().spawn(Spawn, Skeleton.class);
	
	}


	
	
	
}
