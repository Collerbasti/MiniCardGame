package Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

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
	
}

