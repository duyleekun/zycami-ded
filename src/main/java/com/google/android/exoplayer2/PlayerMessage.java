/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import com.google.android.exoplayer2.PlayerMessage$Sender;
import com.google.android.exoplayer2.PlayerMessage$Target;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import java.util.concurrent.TimeoutException;

public final class PlayerMessage {
    private final Clock clock;
    private boolean deleteAfterDelivery;
    private boolean isCanceled;
    private boolean isDelivered;
    private boolean isProcessed;
    private boolean isSent;
    private Looper looper;
    private Object payload;
    private long positionMs;
    private final PlayerMessage$Sender sender;
    private final PlayerMessage$Target target;
    private final Timeline timeline;
    private int type;
    private int windowIndex;

    public PlayerMessage(PlayerMessage$Sender playerMessage$Sender, PlayerMessage$Target playerMessage$Target, Timeline timeline, int n10, Clock clock, Looper looper) {
        this.sender = playerMessage$Sender;
        this.target = playerMessage$Target;
        this.timeline = timeline;
        this.looper = looper;
        this.clock = clock;
        this.windowIndex = n10;
        this.positionMs = -9223372036854775807L;
        this.deleteAfterDelivery = true;
    }

    public boolean blockUntilDelivered() {
        synchronized (this) {
            boolean bl2;
            block11: {
                bl2 = this.isSent;
                Assertions.checkState(bl2);
                Object object = this.looper;
                object = object.getThread();
                Thread thread = Thread.currentThread();
                if (object != thread) {
                    bl2 = true;
                    break block11;
                }
                bl2 = false;
                object = null;
            }
            try {
                Assertions.checkState(bl2);
                while (!(bl2 = this.isProcessed)) {
                    this.wait();
                }
                bl2 = this.isDelivered;
                return bl2;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            finally {
            }
        }
    }

    public boolean blockUntilDelivered(long l10) {
        synchronized (this) {
            Object object;
            boolean bl2;
            Object object2;
            boolean bl3;
            block18: {
                bl3 = this.isSent;
                Assertions.checkState(bl3);
                object2 = this.looper;
                object2 = object2.getThread();
                Thread thread = Thread.currentThread();
                if (object2 != thread) {
                    bl3 = true;
                    break block18;
                }
                bl3 = false;
                object2 = null;
            }
            Assertions.checkState(bl3);
            object2 = this.clock;
            long l11 = object2.elapsedRealtime() + l10;
            while (true) {
                long l12;
                long l13;
                long l14;
                bl2 = this.isProcessed;
                if (bl2 || (l14 = (l13 = l10 - (l12 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) <= 0) break;
                this.wait(l10);
                object = this.clock;
                l10 = object.elapsedRealtime();
                l10 = l11 - l10;
                continue;
                break;
            }
            if (bl2) {
                boolean bl4 = this.isDelivered;
                return bl4;
            }
            String string2 = "Message delivery timed out.";
            try {
                object = new TimeoutException(string2);
                throw object;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            finally {
            }
        }
    }

    public PlayerMessage cancel() {
        synchronized (this) {
            boolean bl2 = this.isSent;
            Assertions.checkState(bl2);
            bl2 = true;
            this.isCanceled = bl2;
            bl2 = false;
            Object var2_2 = null;
            this.markAsProcessed(false);
            return this;
        }
    }

    public boolean getDeleteAfterDelivery() {
        return this.deleteAfterDelivery;
    }

    public Looper getLooper() {
        return this.looper;
    }

    public Object getPayload() {
        return this.payload;
    }

    public long getPositionMs() {
        return this.positionMs;
    }

    public PlayerMessage$Target getTarget() {
        return this.target;
    }

    public Timeline getTimeline() {
        return this.timeline;
    }

    public int getType() {
        return this.type;
    }

    public int getWindowIndex() {
        return this.windowIndex;
    }

    public boolean isCanceled() {
        synchronized (this) {
            boolean bl2 = this.isCanceled;
            return bl2;
        }
    }

    public void markAsProcessed(boolean bl2) {
        synchronized (this) {
            boolean bl3 = this.isDelivered;
            bl2 |= bl3;
            this.isDelivered = bl2;
            bl2 = true;
            this.isProcessed = bl2;
            this.notifyAll();
            return;
        }
    }

    public PlayerMessage send() {
        boolean bl2 = this.isSent;
        boolean bl3 = true;
        Assertions.checkState(bl2 ^ bl3);
        long l10 = this.positionMs;
        long l11 = -9223372036854775807L;
        bl2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (!bl2) {
            bl2 = this.deleteAfterDelivery;
            Assertions.checkArgument(bl2);
        }
        this.isSent = bl3;
        this.sender.sendMessage(this);
        return this;
    }

    public PlayerMessage setDeleteAfterDelivery(boolean bl2) {
        Assertions.checkState(this.isSent ^ true);
        this.deleteAfterDelivery = bl2;
        return this;
    }

    public PlayerMessage setHandler(Handler handler) {
        handler = handler.getLooper();
        return this.setLooper((Looper)handler);
    }

    public PlayerMessage setLooper(Looper looper) {
        Assertions.checkState(this.isSent ^ true);
        this.looper = looper;
        return this;
    }

    public PlayerMessage setPayload(Object object) {
        Assertions.checkState(this.isSent ^ true);
        this.payload = object;
        return this;
    }

    public PlayerMessage setPosition(int n10, long l10) {
        Object object;
        Timeline timeline;
        int n11 = this.isSent;
        boolean bl2 = true;
        Assertions.checkState(n11 ^ bl2);
        long l11 = -9223372036854775807L;
        n11 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (n11 == 0) {
            bl2 = false;
            timeline = null;
        }
        Assertions.checkArgument(bl2);
        if (n10 >= 0 && ((n11 = ((Timeline)(object = this.timeline)).isEmpty()) != 0 || n10 < (n11 = ((Timeline)(object = this.timeline)).getWindowCount()))) {
            this.windowIndex = n10;
            this.positionMs = l10;
            return this;
        }
        timeline = this.timeline;
        object = new IllegalSeekPositionException(timeline, n10, l10);
        throw object;
    }

    public PlayerMessage setPosition(long l10) {
        Assertions.checkState(this.isSent ^ true);
        this.positionMs = l10;
        return this;
    }

    public PlayerMessage setType(int n10) {
        Assertions.checkState(this.isSent ^ true);
        this.type = n10;
        return this;
    }
}

