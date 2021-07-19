/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.commons.logcollector;

import android.os.Handler;
import android.os.Message;
import com.mob.commons.a;
import com.mob.commons.b;
import com.mob.commons.logcollector.c;

public class c$1
implements Handler.Callback {
    public final /* synthetic */ c a;

    public c$1(c c10) {
        this.a = c10;
    }

    public boolean handleMessage(Message message) {
        com.mob.commons.a.b();
        boolean bl2 = b.Z();
        if (!bl2) {
            c c10 = this.a;
            c10.a(message);
        }
        return false;
    }
}

