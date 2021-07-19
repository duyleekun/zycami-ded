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
import com.mob.MobSDK$3;
import com.mob.OperationCallback;

public class MobSDK$3$1
implements Handler.Callback {
    public final /* synthetic */ Throwable a;
    public final /* synthetic */ MobSDK$3 b;

    public MobSDK$3$1(MobSDK$3 var1_1, Throwable throwable) {
        this.b = var1_1;
        this.a = throwable;
    }

    public boolean handleMessage(Message object) {
        object = this.b.b;
        Throwable throwable = this.a;
        ((OperationCallback)object).onFailure(throwable);
        return false;
    }
}

