/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.websocket;

import cn.leancloud.websocket.HeartBeatPolicy$1;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class HeartBeatPolicy {
    private static final long HEALTHY_THRESHOLD = 360000L;
    private static final long HEART_BEAT_INTERNAL = 180000L;
    private static final ScheduledThreadPoolExecutor executor;
    private Future healthFuture;
    private Runnable healthMonitor;
    private long lastPongTS;

    static {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        executor = scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
    }

    public HeartBeatPolicy() {
        HeartBeatPolicy$1 heartBeatPolicy$1 = new HeartBeatPolicy$1(this);
        this.healthMonitor = heartBeatPolicy$1;
    }

    public static /* synthetic */ long access$000(HeartBeatPolicy heartBeatPolicy) {
        return heartBeatPolicy.lastPongTS;
    }

    public void onPong() {
        synchronized (this) {
            long l10 = System.currentTimeMillis();
            this.lastPongTS = l10;
            return;
        }
    }

    public abstract void onTimeOut();

    public abstract void sendPing();

    public void start() {
        synchronized (this) {
            this.stop();
            long l10 = System.currentTimeMillis();
            this.lastPongTS = l10;
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = executor;
            Runnable runnable = this.healthMonitor;
            long l11 = 180000L;
            long l12 = 180000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            ScheduledFuture<?> scheduledFuture = scheduledThreadPoolExecutor.scheduleAtFixedRate(runnable, l11, l12, timeUnit);
            this.healthFuture = scheduledFuture;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void stop() {
        synchronized (this) {
            Future future = this.healthFuture;
            if (future != null) {
                boolean bl2 = true;
                future.cancel(bl2);
                future = null;
                this.healthFuture = null;
            }
            return;
        }
    }
}

