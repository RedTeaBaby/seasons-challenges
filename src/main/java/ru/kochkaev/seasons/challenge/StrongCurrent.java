package ru.kochkaev.seasons.challenge;

import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import ru.kochkaev.api.seasons.util.functional.IFuncRet;
import ru.kochkaev.api.seasons.service.Config;
import ru.kochkaev.api.seasons.object.ChallengeObject;
import ru.kochkaev.api.seasons.service.Task;
import ru.kochkaev.api.seasons.service.Weather;

import java.util.*;

public class StrongCurrent extends ChallengeObject {

    public StrongCurrent() {
        super("StrongCurrent", Collections.singletonList(Weather.getWeatherByID("STORMY")), true);
    }

    private static final List<EntityType> boats = Arrays.asList(EntityType.BOAT, EntityType.CHEST_BOAT);

    @Override
    public void register() {
    }

    @Override
    public int logic(ServerPlayerEntity player, int countOfInARowCalls, int ticksPerAction) {
        if (player.hasVehicle() && player.getSteppingBlockState().getBlock() == Blocks.WATER) {
            if (new Random().nextInt(100) <= 5) {
                if (boats.contains(Objects.requireNonNull(player.getVehicle()).getType())) {
                    Entity boat = player.getVehicle();
                    IFuncRet task = (args) -> {
                        Entity bt = (Entity) args.getFirst();
                        ServerPlayerEntity playr = (ServerPlayerEntity) args.get(1);
                        int counter = (Integer) args.get(2);
                        IFuncRet tsk = (IFuncRet) args.get(3);
                        bt.onBubbleColumnCollision(true);
                        bt.onBubbleColumnSurfaceCollision(true);
//                        spawnParticles(player, ParticleTypes.BUBBLE, false, 0, 5);
                        if (bt.shouldDismountUnderwater()) {
                            Task.removeTask(tsk);
                            playr.dismountVehicle();
                        }
                        return Arrays.asList(bt, playr, counter + 1, tsk);
                    };
                    giveEffect(player, StatusEffects.NAUSEA);
                    spawnParticles(player, ParticleTypes.ANGRY_VILLAGER, true, 1, 2);
                    Task.addTask(task, Arrays.asList(boat, player, 0, task));
                } else {
                    player.dismountVehicle();
                    spawnParticles(player, ParticleTypes.ANGRY_VILLAGER, true, 1, 2);
                }
            }
        }
//                if (countOfInARowCalls > 0) {
//                    removeEffect(player, StatusEffects.NAUSEA);
//                    removeEffect(player, StatusEffects.MINING_FATIGUE);
//                    return 0;
//                }
        else if (player.getBlockStateAtPos().getBlock() == Blocks.WATER){
            if (countOfInARowCalls == 1)
                sendMessage(player, Config.getModConfig("Seasons Challenges").getLang().getString("lang.challenge.strongCurrent.message.get"));
            else if (countOfInARowCalls == ticksPerAction) {
                spawnParticles(player, ParticleTypes.ANGRY_VILLAGER, true, 1, 2);
                giveEffect(player, StatusEffects.NAUSEA);
                giveEffect(player, StatusEffects.MINING_FATIGUE);
            }
            else if (countOfInARowCalls % ticksPerAction == 0) {
                player.getServerWorld().spawnParticles(ParticleTypes.BUBBLE, player.getX(), player.getY(), player.getZ(), 2, player.getX(), player.getY(), player.getZ(), 0.1);
                damageStorm(player);
            }
            return countOfInARowCalls + 1;
        }
        else if (countOfInARowCalls != 0) {
            if (player.getSteppingBlockState().getBlock() != Blocks.WATER) {
                if (countOfInARowCalls > 0) {
                    return -ticksPerAction-1;
                }
                else if (countOfInARowCalls == -1) {
                    spawnParticles(player, ParticleTypes.HAPPY_VILLAGER, true, 1,10);
                    removeEffect(player, StatusEffects.NAUSEA);
                    removeEffect(player, StatusEffects.MINING_FATIGUE);
                    sendMessage(player, Config.getModConfig("Seasons Challenges").getLang().getString("lang.challenge.strongCurrent.message.remove"));
                }
            }
            return countOfInARowCalls+1;
        }
        return 0;
    }

    @Override
    public void onChallengeStart(ServerPlayerEntity player) {
        sendMessage(player, Config.getModConfig("Seasons Challenges").getLang().getString("lang.challenge.strongCurrent.message.trigger"));
    }

    @Override
    public void onChallengeEnd(ServerPlayerEntity player) {
        removeEffect(player, StatusEffects.MINING_FATIGUE);
        removeEffect(player, StatusEffects.NAUSEA);
    }
}
