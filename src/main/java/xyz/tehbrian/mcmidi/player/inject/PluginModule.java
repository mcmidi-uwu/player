package xyz.tehbrian.mcmidi.player.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;
import xyz.tehbrian.mcmidi.player.PlayerPlugin;

/**
 * Guice module which provides bindings for instances originating from the plugin's main class.
 */
public final class PluginModule extends AbstractModule {

    /**
     * PlayerPlugin reference.
     */
    private final PlayerPlugin playerPlugin;

    /**
     * Constructs {@link PluginModule}.
     *
     * @param playerPlugin PlayerPlugin reference
     */
    public PluginModule(final @NonNull PlayerPlugin playerPlugin) {
        this.playerPlugin = playerPlugin;
    }

    /**
     * Provides the plugin's {@link FileConfiguration}.
     *
     * @return the {@link FileConfiguration}
     */
    @Provides
    public FileConfiguration provideFileConfiguration() {
        return this.playerPlugin.getConfig();
    }

    @Override
    protected void configure() {
        this.bind(PlayerPlugin.class).toInstance(this.playerPlugin);
        this.bind(JavaPlugin.class).toInstance(this.playerPlugin);
    }

}
