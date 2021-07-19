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
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.internal.base.zap;

public final class zabb
extends zap {
    private final /* synthetic */ zaaw zahh;

    public zabb(zaaw zaaw2, Looper looper) {
        this.zahh = zaaw2;
        super(looper);
    }

    public final void handleMessage(Message object) {
        int n10 = object.what;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                StringBuilder stringBuilder = new StringBuilder(31);
                stringBuilder.append("Unknown message id: ");
                stringBuilder.append(n10);
                object = stringBuilder.toString();
                Log.w((String)"GoogleApiClientImpl", (String)object);
                return;
            }
            zaaw.zaa(this.zahh);
            return;
        }
        zaaw.zab(this.zahh);
    }
}

