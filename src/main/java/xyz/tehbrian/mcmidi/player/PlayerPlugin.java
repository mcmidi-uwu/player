package xyz.tehbrian.mcmidi.player;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tehbrian.mcmidi.player.inject.ConfigModule;
import xyz.tehbrian.mcmidi.player.inject.PluginModule;
import xyz.tehbrian.mcmidi.player.listeners.NoteRequestListener;

public final class PlayerPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        final Injector injector = Guice.createInjector(
                new PluginModule(this),
                new ConfigModule()
        );

        injector.getInstance(Config.class).loadValues();

        final PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(injector.getInstance(NoteRequestListener.class), this);
    }

}
