/*
 * VitalSuicide is a Spigot Plugin that gives players the ability to commit suicide.
 * Copyright © 2022 Leopold Meinel & contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see https://github.com/TamrielNetwork/VitalSuicide/blob/main/LICENSE
 */

package com.tamrielnetwork.vitalsuicide.commands;

import com.tamrielnetwork.vitalsuicide.utils.Chat;
import com.tamrielnetwork.vitalsuicide.utils.commands.Cmd;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VitalSuicideCmd
		implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
	                         @NotNull String[] args) {
		if (Cmd.isArgsLengthNotEqualTo(sender, args, 0)) {
			return false;
		}
		doSuicide(sender);
		return true;
	}

	private void doSuicide(@NotNull CommandSender sender) {
		if (Cmd.isInvalidSender(sender) || Cmd.isNotPermitted(sender, "vitalsuicide.suicide")) {
			return;
		}
		Player senderPlayer = (Player) sender;
		Chat.sendMessage(sender, "suicide");
		senderPlayer.setHealth(0);
	}
}