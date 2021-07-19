/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.util.i$a;

public class i
extends Handler {
    private int a;
    private boolean b = false;
    private i$a c;

    public i(Looper looper, i$a i$a) {
        super(looper);
        this.c = i$a;
    }

    public void a() {
        boolean bl2;
        while (bl2 = this.hasMessages(0)) {
            this.removeMessages(0);
        }
        this.b = false;
    }

    public void a(int n10, int n11) {
        this.a();
        this.a = n11;
        this.b = true;
        long l10 = n10;
        this.sendEmptyMessageDelayed(0, l10);
    }

    public void handleMessage(Message object) {
        boolean bl2;
        object = this.c;
        if (object != null) {
            object.onTimeout();
        }
        if (bl2 = this.b) {
            bl2 = false;
            object = null;
            int n10 = this.a;
            long l10 = n10;
            this.sendEmptyMessageDelayed(0, l10);
        }
    }
}

