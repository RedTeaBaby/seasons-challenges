package ru.kochkaev.seasons.challenge;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import ru.kochkaev.api.seasons.config.Config;
import ru.kochkaev.api.seasons.object.ChallengeObject;
import ru.kochkaev.api.seasons.service.Weather;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WetMud extends ChallengeObject {

    public WetMud() {
        super(Collections.singletonList(Weather.getWeatherByID("RAINY")), true);
    }

    private final static List<Block> muddy = Arrays.asList(Blocks.MUD, Blocks.DIRT, Blocks.DIRT_PATH, Blocks.FARMLAND);

    @Override
    public void register() {
    }

    @Override
    public int logic(ServerPlayerEntity player, int countOfInARowCalls, int ticksPerAction) {
        if (muddy.contains(player.getSteppingBlockState().getBlock()) && !player.hasVehicle()) {
            if (countOfInARowCalls == 0) {
                giveEffect(player, StatusEffects.SLOWNESS);
                sendMessage(player, Config.getModConfig("Seasons Challenges").getLang().getString("lang.effect.wetMud.message.get"));
                spawnParticles(player, ParticleTypes.ANGRY_VILLAGER, true, 1, 2);
            }
            return countOfInARowCalls+1;
        }
        else if (countOfInARowCalls>0) {
            removeEffect(player, StatusEffects.SLOWNESS);
            spawnParticles(player, ParticleTypes.HAPPY_VILLAGER, false, 1, 10);
        }
        return 0;
    }

    @Override
    public void onChallengeStart(ServerPlayerEntity player) {
        sendMessage(player, Config.getModConfig("Seasons Challenges").getLang().getString("lang.effect.wetMud.message.trigger"));
    }

    @Override
    public void onChallengeEnd(ServerPlayerEntity player) {
        removeEffect(player, StatusEffects.SLOWNESS);
    }
}