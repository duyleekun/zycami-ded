/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons;

import com.mob.commons.b;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;

public final class b$3
extends Thread {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        boolean bl2;
        while ((bl2 = b.as()) && (bl2 = b.at())) {
            long l10 = 1000L;
            try {
                Thread.sleep(l10);
            }
            catch (Throwable throwable) {}
        }
        bl2 = b.as();
        if (bl2 && !(bl2 = b.at())) {
            b.a(true);
            bl2 = false;
            b.b(false);
            try {
                boolean bl3 = b.aq();
                if (!bl3) {
                    b.ar();
                }
            }
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.d(throwable);
            }
            b.a(false);
        }
    }
}

