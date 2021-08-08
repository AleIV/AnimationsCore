package me.aleiv.core.paper;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import co.aikar.taskchain.TaskChain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.md_5.bungee.api.ChatColor;

@Data
@EqualsAndHashCode(callSuper = false)
public class Game{
    Core instance;

    int startCode = '\uE000';


    public Game(Core instance) {
        this.instance = instance;

    }

    public void animation(CommandSender sender, int from, int to, int frames){

        var chain = Core.newChain();
        var n = startCode;
        var count = 0;

        if(from < 0 || to < 0){
            sender.sendMessage(ChatColor.RED + "Invalid format.");
            return;

        }else if(from != 0){
            n += from;
            count += from;

        }
        
        while (count < to) {
    
            final var current = n;
    
            chain.delay(frames).sync(() -> {

                var title = Character.toString(current);

                Bukkit.getOnlinePlayers().forEach(p->{
                    p.sendTitle(title, "", 0, 60, 1);
                });

            });

            count++;
            n++;

        }
    
        chain.sync(TaskChain::abort).execute();
    }
}