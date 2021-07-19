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
import com.mob.OperationCallback;
import com.mob.commons.a$6;

public class a$6$2
implements Handler.Callback {
    public final /* synthetic */ Throwable a;
    public final /* synthetic */ a$6 b;

    public a$6$2(a$6 a$6, Throwable throwable) {
        this.b = a$6;
        this.a = throwable;
    }

    public boolean handleMessage(Message object) {
        object = this.b.b;
        Throwable throwable = this.a;
        ((OperationCallback)object).onFailure(throwable);
        return false;
    }
}

