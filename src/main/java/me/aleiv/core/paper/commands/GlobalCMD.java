package me.aleiv.core.paper.commands;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import lombok.NonNull;
import me.aleiv.core.paper.Core;
import net.md_5.bungee.api.ChatColor;

@CommandAlias("global")
@CommandPermission("admin.perm")
public class GlobalCMD extends BaseCommand {

    private @NonNull Core instance;
    Entity current = null;

    public GlobalCMD(Core instance) {
        this.instance = instance;

    }

    @Subcommand("velocity|v|velo")
    public void velocity(Player sender, Float x, Float y, Float z){

        var entity = sender.getTargetEntity(10, true);

        if(entity != null){
            entity.setVelocity(new Vector(x, y, z));
            sender.sendMessage(ChatColor.BLUE + "Velocity target: " + x + " " + y + " " + z);
            current = entity;

        }else if(current != null){
            current.setVelocity(new Vector(x, y, z));
            sender.sendMessage(ChatColor.BLUE + "Velocity current: " + x + " " + y + " " + z);

        }else{
            sender.sendMessage(ChatColor.RED + "No target.");
        }

    }
}
