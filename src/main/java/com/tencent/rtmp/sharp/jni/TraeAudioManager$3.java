/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;

public class TraeAudioManager$3
implements Runnable {
    public final /* synthetic */ TraeAudioManager this$0;
    public final /* synthetic */ boolean val$TAMisDeviceChangeable;

    public TraeAudioManager$3(TraeAudioManager traeAudioManager, boolean bl2) {
        this.this$0 = traeAudioManager;
        this.val$TAMisDeviceChangeable = bl2;
    }

    public void run() {
        Intent intent = new Intent();
        intent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
        intent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICECHANGABLE_UPDATE");
        boolean bl2 = this.val$TAMisDeviceChangeable;
        String string2 = "NOTIFY_DEVICECHANGABLE_UPDATE_DATE";
        intent.putExtra(string2, bl2);
        Context context = this.this$0._context;
        if (context != null) {
            context.sendBroadcast(intent);
        }
    }
}

