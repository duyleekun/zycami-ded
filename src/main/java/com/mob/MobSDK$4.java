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
import com.mob.OperationCallback;

public final class MobSDK$4
implements Handler.Callback {
    public final /* synthetic */ OperationCallback a;

    public MobSDK$4(OperationCallback operationCallback) {
        this.a = operationCallback;
    }

    public boolean handleMessage(Message message) {
        this.a.onComplete(null);
        return false;
    }
}

