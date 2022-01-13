package dev.dankom.pi.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("primeval")) {
                if (args.length > 0) {

                }
            }
        } else {
            Bukkit.getConsoleSender().sendMessage("Only players can use that command");
        }
        return false;
    }
}
