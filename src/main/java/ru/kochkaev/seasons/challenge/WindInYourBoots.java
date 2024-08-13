package ru.kochkaev.seasons.challenge;

import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import ru.kochkaev.api.seasons.config.Config;
import ru.kochkaev.api.seasons.object.ChallengeObject;
import ru.kochkaev.api.seasons.service.Weather;

import java.util.Collections;
import java.util.Random;

public class WindInYourBoots extends ChallengeObject {

    public WindInYourBoots() {
        super("WindInYourBoots", Collections.singletonList(Weather.getWeatherByID("BREEZY")), false);
    }

    @Override
    public void register() {
    }

    @Override
    public int logic(ServerPlayerEntity player, int countOfInARowCalls, int ticksPerAction) {
        if (countOfInARowCalls >= 60 * 2) {
            int random = new Random().nextInt(10);
            if (random < 5 && !player.hasStatusEffect(StatusEffects.SPEED)) {
                giveEffect(player, StatusEffects.SPEED, 20*10, 0);
                sendMessage(player, Config.getModConfig("Seasons Challenges").getLang().getString("lang.effect.windInYourBoots.message.get"));
                spawnParticles(player, ParticleTypes.HAPPY_VILLAGER, false, 1, 10);
            }
            return 0;
        }
        else {
            return countOfInARowCalls+1;
        }
    }

    @Override
    public void onChallengeStart(ServerPlayerEntity player) {
        sendMessage(player, Config.getModConfig("Seasons Challenges").getLang().getString("lang.effect.windInYourBoots.message.trigger"));
    }

    @Override
    public void onChallengeEnd(ServerPlayerEntity player) {

    }
}
