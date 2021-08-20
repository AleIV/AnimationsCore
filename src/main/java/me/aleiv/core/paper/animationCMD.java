package me.aleiv.core.paper;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import lombok.NonNull;
import net.md_5.bungee.api.ChatColor;

@CommandAlias("animation|animations")
@CommandPermission("animation.cmd")
public class animationCMD extends BaseCommand {

    private @NonNull Core instance;
    Entity current = null;

    public animationCMD(Core instance) {
        this.instance = instance;

    }

    @Default
    public void animation(CommandSender sender, boolean numeric, int frames, int from, int until){
        var game = instance.getGame();
        game.animation(numeric, frames, from, until);
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "[Animation in " + frames + " tick] from (" + from + " to " + until + ") numeric " + numeric);

    }
}
