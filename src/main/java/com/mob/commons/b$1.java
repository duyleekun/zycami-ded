/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons;

import com.mob.commons.b;
import com.mob.commons.b$a;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;

public final class b$1
extends Thread {
    public final /* synthetic */ b$a a;

    public b$1(b$a b$a) {
        this.a = b$a;
    }

    public void run() {
        boolean bl2;
        block4: {
            bl2 = b.aq();
            if (bl2) break block4;
            try {
                b.ar();
            }
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.d(throwable);
            }
        }
        bl2 = false;
        b.a(false);
        b$a b$a = this.a;
        if (b$a != null) {
            b$a.a();
        }
    }
}

