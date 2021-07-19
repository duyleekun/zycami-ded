/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 */
package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Message;
import com.google.android.gms.common.api.internal.BackgroundDetector$BackgroundStateChangeListener;
import com.google.android.gms.common.api.internal.GoogleApiManager;

public final class zabi
implements BackgroundDetector$BackgroundStateChangeListener {
    private final /* synthetic */ GoogleApiManager zaim;

    public zabi(GoogleApiManager googleApiManager) {
        this.zaim = googleApiManager;
    }

    public final void onBackgroundStateChanged(boolean bl2) {
        Handler handler = GoogleApiManager.zaa(this.zaim);
        Handler handler2 = GoogleApiManager.zaa(this.zaim);
        Boolean bl3 = bl2;
        bl3 = handler2.obtainMessage(1, (Object)bl3);
        handler.sendMessage((Message)bl3);
    }
}

