/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.net.NetworkInfo
 *  android.net.NetworkInfo$State
 */
package com.baidu.location.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.baidu.location.f.i;
import com.baidu.location.f.i$1;
import com.baidu.location.f.j;

public class i$a
extends BroadcastReceiver {
    public final /* synthetic */ i a;
    private long b = 0L;
    private boolean c = false;

    private i$a(i i10) {
        this.a = i10;
    }

    public /* synthetic */ i$a(i i10, i$1 i$1) {
        this(i10);
    }

    public void onReceive(Context object, Intent intent) {
        if (object == null) {
            return;
        }
        object = intent.getAction();
        Object object2 = "android.net.wifi.SCAN_RESULTS";
        boolean bl2 = ((String)object).equals(object2);
        boolean bl3 = true;
        if (bl2) {
            long l10 = System.currentTimeMillis();
            long l11 = 1000L;
            i.a = l10 /= l11;
            object = "resultsUpdated";
            boolean bl4 = intent.getBooleanExtra((String)object, bl3);
            intent = i.c(this.a);
            object2 = new j(this, bl4);
            intent.post((Runnable)object2);
        } else {
            object2 = "android.net.wifi.STATE_CHANGE";
            Object object3 = ((String)object).equals(object2);
            if (object3 != 0) {
                object = ((NetworkInfo)intent.getParcelableExtra("networkInfo")).getState();
                object3 = object.equals((Object)(intent = NetworkInfo.State.CONNECTED));
                if (object3 == 0) {
                    return;
                }
                long l12 = System.currentTimeMillis();
                long l13 = this.b;
                long l14 = (l12 -= l13) - (l13 = 5000L);
                object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object3 < 0) {
                    return;
                }
                this.b = l12 = System.currentTimeMillis();
                object3 = this.c;
                if (object3 == 0) {
                    this.c = bl3;
                }
            }
        }
    }
}

