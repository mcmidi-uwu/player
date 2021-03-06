package xyz.tehbrian.mcmidi.player.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.bukkit.configuration.file.FileConfiguration;
import org.checkerframework.checker.nullness.qual.NonNull;
import xyz.tehbrian.mcmidi.player.Config;

import java.util.logging.Logger;

/**
 * Guice module which provides bindings for {@link Config}.
 */
public class ConfigModule extends AbstractModule {

    /**
     * Provides {@link Config}.
     */
    @Provides
    @Singleton
    public Config provideConfig(
            final @NonNull FileConfiguration fileConfiguration,
            final @NonNull Logger logger) {
        Config config = new Config(fileConfiguration, logger);
        config.loadValues();
        return config;
    }
}
