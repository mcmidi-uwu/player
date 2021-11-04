package xyz.tehbrian.mcmidi.player.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;
import xyz.tehbrian.mcmidi.player.PlayerPlugin;

public final class PluginModule extends AbstractModule {

    private final PlayerPlugin playerPlugin;

    public PluginModule(final @NonNull PlayerPlugin playerPlugin) {
        this.playerPlugin = playerPlugin;
    }

    @Override
    protected void configure() {
        this.bind(PlayerPlugin.class).toInstance(this.playerPlugin);
        this.bind(JavaPlugin.class).toInstance(this.playerPlugin);
    }

    @Provides
    public FileConfiguration provideDefaultConfig() {
        return this.playerPlugin.getConfig();
    }

}
