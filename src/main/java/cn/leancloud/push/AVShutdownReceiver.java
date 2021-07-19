/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package cn.leancloud.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.leancloud.push.AVShutdownListener;

public class AVShutdownReceiver
extends BroadcastReceiver {
    private AVShutdownListener listener;

    public AVShutdownReceiver(AVShutdownListener aVShutdownListener) {
        this.listener = aVShutdownListener;
    }

    public void onReceive(Context context, Intent intent) {
        this.listener.onShutdown(context);
    }
}

