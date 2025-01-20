package top.DrakGod.DgInMC.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class ScheduledTask {
    private final Runnable Task;

    public ScheduledTask(World World, Runnable Task, long Delay) {
        this.Task = Task;

        if (!World.isClientSide) {
            MinecraftServer Server = World.getServer();
            if (Server != null) {
                ScheduledExecutorService Executor = Executors.newSingleThreadScheduledExecutor();
                Executor.schedule(() -> {
                    this.Task.run();
                }, Delay, TimeUnit.SECONDS);
            }
        }
    }
}
