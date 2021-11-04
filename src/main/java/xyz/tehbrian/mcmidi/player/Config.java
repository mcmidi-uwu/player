package xyz.tehbrian.mcmidi.player;

import com.google.inject.Inject;
import org.bukkit.configuration.file.FileConfiguration;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.logging.Logger;

/**
 * Grabs and holds values from a {@link org.bukkit.configuration.file.FileConfiguration}
 * for easy access.
 */
public final class Config {

    private final FileConfiguration config;
    private final Logger logger;

    private boolean particlesEnabled;

    /**
     * @param config the {@link FileConfiguration} to use for values
     * @param logger the {@link Logger} to yell at when values are absent
     */
    @Inject
    public Config(
            final @NonNull FileConfiguration config,
            final @NonNull Logger logger
    ) {
        this.config = config;
        this.logger = logger;
    }

    /**
     * Loads and validates values from {@link #config}.
     * Whines to {@link #logger} if they're invalid.
     */
    public void loadValues() {
        this.particlesEnabled = this.config.getBoolean("particles", true);
    }

    /**
     * Whether a fancy particle will be shown above the
     * player's head whenever they play a note.
     *
     * @return a boolean
     */
    public boolean particlesEnabled() {
        return this.particlesEnabled;
    }

}
