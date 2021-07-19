/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 */
package com.baidu.location.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.b.l;
import com.baidu.location.f;

public class l$a
extends Handler {
    public final /* synthetic */ l a;

    public l$a(l l10) {
        this.a = l10;
    }

    public void handleMessage(Message object) {
        int n10 = f.isServing;
        if (n10 == 0) {
            return;
        }
        n10 = ((Message)object).what;
        int n11 = 21;
        if (n10 != n11) {
            int n12 = 62;
            if (n10 == n12 || n10 == (n12 = 63)) {
                object = this.a;
                ((l)object).a();
            }
        } else {
            l l10 = this.a;
            l10.a((Message)object);
        }
    }
}

