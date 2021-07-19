/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.commons;

import android.os.Handler;
import android.os.Message;
import com.mob.commons.a$6;

public class a$6$1
implements Handler.Callback {
    public final /* synthetic */ a$6 a;

    public a$6$1(a$6 var1_1) {
        this.a = var1_1;
    }

    public boolean handleMessage(Message message) {
        this.a.b.onComplete(null);
        return false;
    }
}

