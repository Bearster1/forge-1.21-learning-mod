package net.bearster.examplemod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

import static net.bearster.examplemod.ExampleMod.MOD_ID;

public class SetHomeCommand {
    public SetHomeCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("home").then(Commands.literal("set")
                .executes(this::execute)));

    }

    private int execute(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();
        BlockPos playerPos = player.blockPosition();
        String positionString = "(" + playerPos.getX()+ ", " + playerPos.getY() + ", "+ playerPos.getZ()+")";

        player.getPersistentData().putIntArray(MOD_ID+".homepos",
                new int[] {playerPos.getX(), playerPos.getY(), playerPos.getZ()});
        context.getSource().sendSuccess(() -> Component.literal("Set Home at "+positionString), true);
        return 1;
    }
}
