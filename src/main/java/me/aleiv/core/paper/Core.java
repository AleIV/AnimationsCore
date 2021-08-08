package me.aleiv.core.paper;

import org.bukkit.plugin.java.JavaPlugin;

import co.aikar.commands.PaperCommandManager;
import co.aikar.taskchain.BukkitTaskChainFactory;
import co.aikar.taskchain.TaskChain;
import co.aikar.taskchain.TaskChainFactory;
import lombok.Getter;
import lombok.Setter;
import me.aleiv.core.paper.commands.GlobalCMD;

public class Core extends JavaPlugin {

    private static @Getter Core instance;
    private static @Getter @Setter TaskChainFactory taskChainFactory;
    private @Getter Game game;
    private @Getter PaperCommandManager commandManager;

    @Override
    public void onEnable() {
        instance = this;

        game = new Game(this);

        taskChainFactory = BukkitTaskChainFactory.create(this);

        //COMMANDS
        
        commandManager = new PaperCommandManager(this);
        commandManager.registerCommand(new GlobalCMD(this));

    }

    @Override
    public void onDisable() {

    }

    public static <T> TaskChain<T> newChain() {
        return taskChainFactory.newChain();
    }

    public static <T> TaskChain<T> newSharedChain(String name) {
        return taskChainFactory.newSharedChain(name);
    }

}