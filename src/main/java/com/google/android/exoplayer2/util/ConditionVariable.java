/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.Clock;

public class ConditionVariable {
    private final Clock clock;
    private boolean isOpen;

    public ConditionVariable() {
        Clock clock = Clock.DEFAULT;
        this(clock);
    }

    public ConditionVariable(Clock clock) {
        this.clock = clock;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void block() {
        synchronized (this) {
            boolean bl2;
            while (!(bl2 = this.isOpen)) {
                this.wait();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean block(long l10) {
        synchronized (this) {
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 <= 0) {
                return this.isOpen;
            }
            Clock clock = this.clock;
            l11 = clock.elapsedRealtime();
            long l13 = (l10 += l11) - l11;
            Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object >= 0) {
                while ((object = (Object)this.isOpen) == false) {
                    object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
                    if (object >= 0) return this.isOpen;
                    l11 = l10 - l11;
                    this.wait(l11);
                    clock = this.clock;
                    l11 = clock.elapsedRealtime();
                }
                return this.isOpen;
            }
            this.block();
            return this.isOpen;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void blockUninterruptible() {
        synchronized (this) {
            boolean bl2;
            boolean bl3 = false;
            Thread thread = null;
            while (!(bl2 = this.isOpen)) {
                try {
                    this.wait();
                }
                catch (InterruptedException interruptedException) {
                    bl3 = true;
                }
            }
            if (bl3) {
                thread = Thread.currentThread();
                thread.interrupt();
            }
            return;
        }
    }

    public boolean close() {
        synchronized (this) {
            boolean bl2 = this.isOpen;
            this.isOpen = false;
            return bl2;
        }
    }

    public boolean isOpen() {
        synchronized (this) {
            boolean bl2 = this.isOpen;
            return bl2;
        }
    }

    public boolean open() {
        synchronized (this) {
            boolean bl2;
            block4: {
                bl2 = this.isOpen;
                if (!bl2) break block4;
                return false;
            }
            bl2 = true;
            this.isOpen = bl2;
            this.notifyAll();
            return bl2;
        }
    }
}

