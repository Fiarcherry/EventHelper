package dialight.guilib

import com.google.inject.Inject
import dialight.observable.map.observableMapOf
import org.slf4j.Logger
import org.spongepowered.api.Sponge
import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.game.state.GameStartedServerEvent
import org.spongepowered.api.item.inventory.Inventory
import org.spongepowered.api.plugin.Plugin
import org.spongepowered.api.plugin.PluginContainer
import org.spongepowered.api.plugin.PluginManager
import java.util.*

@Plugin(id = "guilib")
class GuiPlugin @Inject constructor(
    val container: PluginContainer,
    val logger: Logger
) {

    val guistory = GuiStory(this)

    @Listener
    fun onServerStart(event: GameStartedServerEvent) {
        Sponge.getEventManager().registerListeners(this, GuiListener(this))
        logger.info("GuiLib v${container.version.orElse("null")} has been Enabled")
    }

    fun openView(player: Player, view: View) = guistory.openView(player, view)
    fun openGui(player: Player, gui: Gui) = guistory.openGui(player, gui)
    fun openLast(player: Player) = guistory.openLast(player)
    fun clearStory(player: Player) = guistory.clearStory(player)

}