/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.push.al;
import com.xiaomi.push.al$b;

public class am
extends Handler {
    public final /* synthetic */ al a;

    public am(al al2, Looper looper) {
        this.a = al2;
        super(looper);
    }

    public void handleMessage(Message message) {
        al$b al$b = (al$b)message.obj;
        int n10 = message.what;
        if (n10 == 0) {
            al$b.a();
        } else {
            int n11 = 1;
            if (n10 == n11) {
                al$b.c();
            }
        }
        super.handleMessage(message);
    }
}

