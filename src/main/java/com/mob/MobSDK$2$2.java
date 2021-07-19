/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob;

import android.os.Handler;
import android.os.Message;
import com.mob.MobSDK$2;

public class MobSDK$2$2
implements Handler.Callback {
    public final /* synthetic */ Throwable a;
    public final /* synthetic */ MobSDK$2 b;

    public MobSDK$2$2(MobSDK$2 mobSDK$2, Throwable throwable) {
        this.b = mobSDK$2;
        this.a = throwable;
    }

    public boolean handleMessage(Message object) {
        object = this.b.c;
        Throwable throwable = this.a;
        object.onFailure(throwable);
        return false;
    }
}

