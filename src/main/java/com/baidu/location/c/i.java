/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 */
package com.baidu.location.c;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.c.h;

public class i
extends Handler {
    public final /* synthetic */ h a;

    public i(h h10) {
        this.a = h10;
    }

    public void handleMessage(Message object) {
        int n10 = object.what;
        int n11 = 1;
        if (n10 == n11) {
            object = this.a;
            h.a((h)object);
        }
    }
}

