/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.tools.utils;

import android.os.Handler;
import android.os.Message;

public final class UIHandler$InnerObj {
    public final Handler.Callback callback;
    public final Message msg;

    public UIHandler$InnerObj(Message message, Handler.Callback callback) {
        this.msg = message;
        this.callback = callback;
    }
}

