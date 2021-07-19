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
import com.tencent.liteav.network.TXCRTMPDownloader;

public class TXCRTMPDownloader$2
extends Handler {
    public final /* synthetic */ TXCRTMPDownloader a;

    public TXCRTMPDownloader$2(TXCRTMPDownloader tXCRTMPDownloader, Looper looper) {
        this.a = tXCRTMPDownloader;
        super(looper);
    }

    public void handleMessage(Message object) {
        int n10 = object.what;
        int n11 = 101;
        if (n10 == n11) {
            object = this.a;
            TXCRTMPDownloader.access$700((TXCRTMPDownloader)object);
        }
    }
}

