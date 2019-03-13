package dialight.freezer

import jekarus.colorizer.Colorizer
import jekarus.colorizer.Text_colorized
import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.plugin.PluginContainer
import org.spongepowered.api.text.Text
import java.util.*

object FreezerMessages {

    var pluginPrefix = Text_colorized("|go|Freezer|gr|: ")

    fun untagged(names: List<String>): Text {
        return if (names.size == 1) {
            Text.of(FreezerMessages.pluginPrefix, Text_colorized("|y|Удалён: |w|" + names[0]))
        } else Text.of(FreezerMessages.pluginPrefix, Text_colorized("|y|Удалены: |w|$names"))
    }

    fun tagged(names: List<String>): Text {
        return if (names.size == 1) {
            Text.of(FreezerMessages.pluginPrefix, Text_colorized("|y|Добавлен: |w|" + names[0]))
        } else Text.of(FreezerMessages.pluginPrefix, Text_colorized("|y|Добавлены: |w|$names"))
    }

    var areaSelSecondPoint = Text.of(pluginPrefix, "|y|Выберите 2-ю точку")

    var areaSelFirstPoint = Text.of(pluginPrefix, "|y|Выбор точек области")

    @Deprecated("")
    var editWasCancelled = Text.of(pluginPrefix, "|y|Редактирование было преостановлено")

    fun alreadyOnEdit(player: Player): Text {
        return Text.of(pluginPrefix, Text_colorized("|r|Команда уже редактируется игроком: " + player.name))
    }

    fun actionMsg(channel: String, msg: String): Text {
        return Text.of(pluginPrefix, Text_colorized("|g|$channel|gr| -> |y|$msg"))
    }

    fun notFound(invoker: Player, trgName: String) {
        invoker.sendMessage(Text.of(pluginPrefix, Text_colorized("|y|Игрок с ником $trgName не найден")))
    }
    fun notFound(uuid: UUID): Text {
        return Text.of(pluginPrefix, Text_colorized("|y|Игрок с uuid $uuid не найден"))
    }


    fun freeze(invoker: Player, trg: Player) {
        if (invoker.uniqueId == trg.uniqueId) {
            invoker.sendMessage(Text.of(pluginPrefix, Text_colorized("|y|ты заморозил сам себя")))
        } else {
            trg.sendMessage(Text.of(pluginPrefix, Text_colorized("|y|тебя заморозил |w|" + invoker.name)))
            invoker.sendMessage(Text.of(pluginPrefix, Text_colorized("|y|ты заморозил: |w|" + trg.name)))
        }
    }

    fun unfreeze(invoker: Player, trg: Player) {
        if (invoker.uniqueId == trg.uniqueId) {
            invoker.sendMessage(Text.of(pluginPrefix, Text_colorized("|y|ты разморозил сам себя")))
        } else {
            trg.sendMessage(Text.of(pluginPrefix, Text_colorized("|y|тебя разморозил |w|" + invoker.name)))
            invoker.sendMessage(Text.of(pluginPrefix, Text_colorized("|y|ты разморозил: |w|" + trg.name)))
        }
    }

    fun freeze(invoker: Player, frozen: FrozenPlayers.Frozen) {
        //trg.sendMessage(Text_colorized("тебя заморозил " + invoker.getName()));
        invoker.sendMessage(Text.of(pluginPrefix, Text_colorized("|y|ты заморозил: |w|" + frozen.name)))
    }

    fun unfreeze(invoker: Player, frozen: FrozenPlayers.Frozen) {
        //trg.sendMessage(Text_colorized("тебя разморозил " + invoker.getName()));
        invoker.sendMessage(Text.of(pluginPrefix, Text_colorized("|y|ты разморозил: |w|" + frozen.name)))
    }

    fun freeze(invoker: PluginContainer, trg: Player) {
        trg.sendMessage(Text.of(pluginPrefix, Text_colorized("|y|Тебя заморозило плагином |w|" + invoker.name)))
    }

    fun unfreeze(invoker: PluginContainer, trg: Player) {
        trg.sendMessage(Text.of(pluginPrefix, Text_colorized("|y|Тебя разморозило плагином |w|" + invoker.name)))
    }

    fun freeze(invoker: PluginContainer, frozen: FrozenPlayers.Frozen) {
        //trg.sendMessage(Text_colorized("|y|тебя заморозил " + invoker.getName());
        //invoker.sendMessage(Text_colorized("|y|ты заморозил: " + frozen.getName());
    }

    fun unfreeze(invoker: PluginContainer, frozen: FrozenPlayers.Frozen) {
        //trg.sendMessage(Text.of(pluginPrefix, Text_colorized("|y|тебя разморозил " + invoker.getName())));
        //invoker.sendMessage(Text.of(pluginPrefix, Text_colorized("|y|ты разморозил: " + frozen.getName())));
    }

    fun unfreezeByReload(trg: Player) {
        trg.sendMessage(Text.of(pluginPrefix, Text_colorized("|y|Тебя разморозило из-за перезагрузки плагина")))
    }

    fun frozen(trg: Player) {
        trg.sendMessage(Text.of(pluginPrefix, Text_colorized("|y|Ты находишься в замороженном состоянии")))
    }


}