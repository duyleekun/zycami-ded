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
import com.tencent.rtmp.sharp.jni.TraeAudioManager$TraeAudioManagerLooper;

public class TraeAudioManager$TraeAudioManagerLooper$3
implements Runnable {
    public final /* synthetic */ TraeAudioManager$TraeAudioManagerLooper this$1;
    public final /* synthetic */ int val$TAMst;

    public TraeAudioManager$TraeAudioManagerLooper$3(TraeAudioManager$TraeAudioManagerLooper traeAudioManager$TraeAudioManagerLooper, int n10) {
        this.this$1 = traeAudioManager$TraeAudioManagerLooper;
        this.val$TAMst = n10;
    }

    public void run() {
        Intent intent = new Intent();
        intent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
        intent.putExtra("PARAM_OPERATION", "NOTIFY_STREAMTYPE_UPDATE");
        int n10 = this.val$TAMst;
        String string2 = "EXTRA_DATA_STREAMTYPE";
        intent.putExtra(string2, n10);
        Context context = this.this$1.this$0._context;
        if (context != null) {
            context.sendBroadcast(intent);
        }
    }
}

