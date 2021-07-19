/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 */
package com.google.android.gms.common;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.internal.base.zap;

public final class GoogleApiAvailability$zaa
extends zap {
    private final Context zaaq;
    private final /* synthetic */ GoogleApiAvailability zaar;

    public GoogleApiAvailability$zaa(GoogleApiAvailability googleApiAvailability, Context context) {
        this.zaar = googleApiAvailability;
        googleApiAvailability = Looper.myLooper();
        googleApiAvailability = googleApiAvailability == null ? Looper.getMainLooper() : Looper.myLooper();
        super((Looper)googleApiAvailability);
        googleApiAvailability = context.getApplicationContext();
        this.zaaq = googleApiAvailability;
    }

    public final void handleMessage(Message object) {
        int n10 = ((Message)object).what;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 50;
            StringBuilder stringBuilder = new StringBuilder(n11);
            stringBuilder.append("Don't know how to handle this message: ");
            stringBuilder.append(n10);
            object = stringBuilder.toString();
            String string2 = "GoogleApiAvailability";
            Log.w((String)string2, (String)object);
        } else {
            object = this.zaar;
            Object object2 = this.zaaq;
            object2 = this.zaar;
            n10 = ((GoogleApiAvailability)object).isGooglePlayServicesAvailable((Context)object2);
            n11 = (int)(((GoogleApiAvailability)object2).isUserResolvableError(n10) ? 1 : 0);
            if (n11 != 0) {
                object2 = this.zaar;
                Context context = this.zaaq;
                ((GoogleApiAvailability)object2).showErrorNotification(context, n10);
            }
        }
    }
}

