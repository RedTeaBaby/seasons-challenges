package ru.kochkaev.seasons.challenge;

import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import ru.kochkaev.seasons.config.Config;
import ru.kochkaev.seasons.object.ChallengeObject;
import ru.kochkaev.seasons.service.Weather;

import java.util.Collections;

public class Revitalized extends ChallengeObject {

    public Revitalized() {
        super(Config.getLang().getString("lang.effect.revitalized.message.trigger"), Collections.singletonList(Weather.getWeatherByID("BEAUTIFUL")), false);
    }

    @Override
    public void register() {
    }

    @Override
    public int logic(ServerPlayerEntity player, int countOfInARowCalls, int ticksPerAction) {
        if (player.getServerWorld() == player.getServerWorld().getServer().getOverworld()) {
            if (countOfInARowCalls == 0) {
                sendMessage(player, Config.getLang().getString("lang.effect.revitalized.message.get"));
                giveEffect(player, StatusEffects.REGENERATION);
                spawnParticles(player, ParticleTypes.HAPPY_VILLAGER, false, 1, 10);
            }
            return 1;
        }
        else if ((player.getServerWorld() != player.getServerWorld().getServer().getOverworld()) && countOfInARowCalls == 1) {
            removeEffect(player, StatusEffects.REGENERATION);
            spawnParticles(player, ParticleTypes.ANGRY_VILLAGER, false, 1, 2);
            sendMessage(player, Config.getLang().getString("lang.effect.revitalized.message.remove"));
        }
        return 0;
    }

    @Override
    public void challengeEnd(ServerPlayerEntity player) {
        removeEffect(player, StatusEffects.REGENERATION);
    }
}
