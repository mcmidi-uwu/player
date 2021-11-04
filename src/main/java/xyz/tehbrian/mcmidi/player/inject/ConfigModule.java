package xyz.tehbrian.mcmidi.player.inject;

import com.google.inject.AbstractModule;
import xyz.tehbrian.mcmidi.player.Config;

public final class ConfigModule extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(Config.class).asEagerSingleton();
    }

}
