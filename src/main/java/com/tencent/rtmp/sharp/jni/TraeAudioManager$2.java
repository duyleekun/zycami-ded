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
import java.util.ArrayList;

public class TraeAudioManager$2
implements Runnable {
    public final /* synthetic */ TraeAudioManager this$0;
    public final /* synthetic */ String val$_bluetoothName;
    public final /* synthetic */ String val$con;
    public final /* synthetic */ ArrayList val$list;
    public final /* synthetic */ String val$prevCon;

    public TraeAudioManager$2(TraeAudioManager traeAudioManager, ArrayList arrayList, String string2, String string3, String string4) {
        this.this$0 = traeAudioManager;
        this.val$list = arrayList;
        this.val$con = string2;
        this.val$prevCon = string3;
        this.val$_bluetoothName = string4;
    }

    public void run() {
        Intent intent = new Intent();
        intent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
        intent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICELISTUPDATE");
        Context context = this.val$list;
        Object object = new String[]{};
        context = context.toArray((T[])object);
        intent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])context);
        context = this.val$con;
        intent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", (String)context);
        context = this.val$prevCon;
        intent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", (String)context);
        context = this.val$_bluetoothName;
        object = "EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME";
        intent.putExtra((String)object, (String)context);
        context = this.this$0._context;
        if (context != null) {
            context.sendBroadcast(intent);
        }
    }
}

