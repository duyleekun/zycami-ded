/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import e.a.d;

public class SchedulerWhen$b
implements Runnable {
    public final d a;
    public final Runnable b;

    public SchedulerWhen$b(Runnable runnable, d d10) {
        this.b = runnable;
        this.a = d10;
    }

    public void run() {
        try {
            Runnable runnable = this.b;
            runnable.run();
            return;
        }
        finally {
            this.a.onComplete();
        }
    }
}

