/*
 * File: VitalSuicideCmd.java
 * Author: Leopold Meinel (leo@meinel.dev)
 * -----
 * Copyright (c) 2022 Leopold Meinel & contributors
 * SPDX ID: GPL-3.0-or-later
 * URL: https://www.gnu.org/licenses/gpl-3.0-standalone.html
 * -----
 */

package dev.meinel.leo.vitalsuicide.commands;

import dev.meinel.leo.vitalsuicide.utils.Chat;
import dev.meinel.leo.vitalsuicide.utils.commands.Cmd;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VitalSuicideCmd implements CommandExecutor {

    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args) {
        if (Cmd.isArgsLengthNotEqualTo(sender, args, 0)) {
            return false;
        }
        doSuicide(sender);
        return true;
    }

    private void doSuicide(@NotNull CommandSender sender) {
        if (Cmd.isInvalidSender(sender) ||
                Cmd.isNotPermitted(sender, "vitalsuicide.suicide")) {
            return;
        }
        Player senderPlayer = (Player) sender;
        Chat.sendMessage(sender, "suicide");
        senderPlayer.setHealth(0);
    }
}
