package xyz.tehbrian.mcmidi.player.listeners;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import xyz.tehbrian.mcmidi.serverapi.Note;
import xyz.tehbrian.mcmidi.serverapi.NoteRequestEvent;
import xyz.tehbrian.mcmidi.serverapi.RequestType;

/**
 * Listens for {@link NoteRequestEvent}s sent by mcmidi server.
 */
public class NoteRequestListener implements Listener {

    /**
     * Called when a note is requested.
     */
    @EventHandler
    public void onNoteRequest(final NoteRequestEvent event) {
        final Player player = event.getPlayer();
        final Note note = event.getNote();

        if (event.getType() == RequestType.ON) {
            player.getWorld().playSound(
                    player.getLocation(),
                    note.instrument().asBukkitSound(),
                    SoundCategory.MASTER,
                    note.velocity(),
                    note.pitch().asFloat()
            );

            final Location location = player.getLocation();
            player.getWorld().spawnParticle(
                    Particle.NOTE,
                    location.getX(),
                    location.getY() + 2.25,
                    location.getZ(),
                    0,
                    note.pitch().getParticleColor(),
                    0,
                    0,
                    1
            );
        }
    }

}
