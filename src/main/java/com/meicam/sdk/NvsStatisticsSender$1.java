/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.meicam.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.meicam.sdk.NvsStatisticsSender;

public class NvsStatisticsSender$1
extends Handler {
    public final /* synthetic */ NvsStatisticsSender this$0;

    public NvsStatisticsSender$1(NvsStatisticsSender nvsStatisticsSender, Looper looper) {
        this.this$0 = nvsStatisticsSender;
        super(looper);
    }

    public void handleMessage(Message message) {
        NvsStatisticsSender.access$000(this.this$0);
    }
}

