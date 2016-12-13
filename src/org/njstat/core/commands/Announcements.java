package org.njstat.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.njstat.core.Core;
import org.njstat.core.util.FileManager;
import org.njstat.core.util.R;

public class Announcements implements CommandExecutor{
	Core plugin;
	public Announcements(Core passedPlugin){
		this.plugin = passedPlugin;
	}
	FileManager fileManager = FileManager.getFileManager();
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		String msg = "";
		for (int i = 0; i < args.length; i++) {
		msg = msg + args[i] + " ";
		}
		Player p = (Player) sender;
        if(R.isOwner(p)|| R.isDev(p) || R.isAdmin(p)){
        	Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "�m===========================================\n" +ChatColor.GOLD + "\n�lANNOUNCEMENT �f- " + msg + "\n�7Sent by �a" + sender.getName() + ChatColor.GREEN + "\n�m===========================================");
        	return true;
        } else {
        	sender.sendMessage("�9�lCORE �7No permission");
        }
		return true;
	}
}