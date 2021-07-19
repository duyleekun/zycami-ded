/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 */
package com.baidu.location.indoor;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.BDLocation;
import com.baidu.location.f;
import com.baidu.location.indoor.g;

public class g$d
extends Handler {
    public final /* synthetic */ g a;

    public g$d(g g10) {
        this.a = g10;
    }

    public void handleMessage(Message object) {
        int n10 = f.isServing;
        if (n10 == 0) {
            return;
        }
        n10 = object.what;
        int n11 = 21;
        if (n10 != n11) {
            n11 = 41;
            if (n10 != n11) {
                n11 = 801;
                if (n10 != n11) {
                    super.dispatchMessage(object);
                } else {
                    object = (BDLocation)object.obj;
                    g g10 = this.a;
                    g.a(g10, (BDLocation)object);
                }
            } else {
                object = this.a;
                g.m((g)object);
            }
        } else {
            g g11 = this.a;
            g.a(g11, object);
        }
    }
}

