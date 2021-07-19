/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.api.internal.zabf;
import com.google.android.gms.internal.base.zap;

public final class zabg
extends zap {
    private final /* synthetic */ zabe zahv;

    public zabg(zabe zabe2, Looper looper) {
        this.zahv = zabe2;
        super(looper);
    }

    public final void handleMessage(Message object) {
        int n10 = ((Message)object).what;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                StringBuilder stringBuilder = new StringBuilder(31);
                stringBuilder.append("Unknown message id: ");
                stringBuilder.append(n10);
                object = stringBuilder.toString();
                Log.w((String)"GACStateManager", (String)object);
                return;
            }
            throw (RuntimeException)((Message)object).obj;
        }
        object = (zabf)((Message)object).obj;
        zabe zabe2 = this.zahv;
        ((zabf)object).zac(zabe2);
    }
}

