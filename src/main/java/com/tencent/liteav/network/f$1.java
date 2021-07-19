/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.tencent.liteav.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.network.f;
import com.tencent.liteav.network.g;

public class f$1
extends Handler {
    public final /* synthetic */ f a;

    public f$1(f f10, Looper looper) {
        this.a = f10;
        super(looper);
    }

    public void handleMessage(Message message) {
        f f10 = this.a;
        g g10 = f10.a;
        if (g10 == null) {
            return;
        }
        int n10 = message.what;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                String string2 = (String)message.obj;
                int n12 = message.arg1;
                g10.onNetFailed(f10, string2, n12);
            }
        } else {
            g10.onNetSuccess(f10);
        }
    }
}

