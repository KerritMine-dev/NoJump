package io.github.kerrit_mine.nojump;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoJump extends JavaPlugin implements Listener {
    
	public static final String comd = "nojump";
	public static final String en = "Enable";
	public static final String dis = "Disable";
	boolean allow = false;
    
	public void onEnable() {
		getLogger().info(en);
        getServer().getPluginManager().registerEvents(this, this);

	}
	public void onDisable() {
		getLogger().info(dis);
	}

	
	public boolean onCommand (CommandSender sender,Command cmd,String lbl, String[] args) {
		if(cmd.getName().equalsIgnoreCase("nojump")){
			allow = !allow;
			if(!allow) sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Теперь прыгать можно");
			else sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Теперь прыгать нельзя");
			return true;
		}
	    return false;	
	}
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (PlayerUtils.isValid(event.getPlayer()))
            if (!event.getPlayer().isOnGround() && event.getFrom().getY() + 0.419 < event.getTo().getY() && allow) {
                event.getPlayer().setHealth(0);
            }
    }
	

	
	
}
