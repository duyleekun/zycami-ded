/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.tencent.rtmp.sharp.jni;

import android.content.Intent;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import java.io.Serializable;

public class TraeAudioManager$1
implements Runnable {
    public final /* synthetic */ TraeAudioManager this$0;
    public final /* synthetic */ String val$TAMOperation;
    public final /* synthetic */ Long val$TAMSessionId;
    public final /* synthetic */ int val$TAMerr;
    public final /* synthetic */ Intent val$TAMintent;

    public TraeAudioManager$1(TraeAudioManager traeAudioManager, Intent intent, Long l10, String string2, int n10) {
        this.this$0 = traeAudioManager;
        this.val$TAMintent = intent;
        this.val$TAMSessionId = l10;
        this.val$TAMOperation = string2;
        this.val$TAMerr = n10;
    }

    public void run() {
        this.val$TAMintent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
        Intent intent = this.val$TAMintent;
        Object object = this.val$TAMSessionId;
        intent.putExtra("PARAM_SESSIONID", (Serializable)object);
        intent = this.val$TAMintent;
        object = this.val$TAMOperation;
        intent.putExtra("PARAM_OPERATION", (String)object);
        intent = this.val$TAMintent;
        int n10 = this.val$TAMerr;
        String string2 = "PARAM_RES_ERRCODE";
        intent.putExtra(string2, n10);
        intent = this.this$0._context;
        if (intent != null) {
            object = this.val$TAMintent;
            intent.sendBroadcast((Intent)object);
        }
    }
}

