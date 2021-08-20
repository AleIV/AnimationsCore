package me.aleiv.core.paper;

import java.util.List;

import org.bukkit.Bukkit;

import co.aikar.taskchain.TaskChain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Game{
    Core instance;

    public Game(Core instance) {
        this.instance = instance;

    }

    public void animation(boolean numeric, int frames, int from, int until){

        var chain = Core.newChain();

        List<Character> animationList = numeric ? Frames.getFramesCharsIntegers(from, until) : Frames.getFramesChars(from, until);

        animationList.forEach(charac ->{
            chain.delay(frames).sync(() -> {

                Bukkit.getOnlinePlayers().forEach(p->{
                    p.sendTitle(charac + "", "", 0, 20, 0);
                   
                });

            });
        });
    
        chain.sync(TaskChain::abort).execute();

    }

}