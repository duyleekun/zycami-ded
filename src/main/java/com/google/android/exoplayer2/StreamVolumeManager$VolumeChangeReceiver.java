/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.exoplayer2.StreamVolumeManager;
import com.google.android.exoplayer2.StreamVolumeManager$1;
import d.h.a.a.c0;

public final class StreamVolumeManager$VolumeChangeReceiver
extends BroadcastReceiver {
    public final /* synthetic */ StreamVolumeManager this$0;

    private StreamVolumeManager$VolumeChangeReceiver(StreamVolumeManager streamVolumeManager) {
        this.this$0 = streamVolumeManager;
    }

    public /* synthetic */ StreamVolumeManager$VolumeChangeReceiver(StreamVolumeManager streamVolumeManager, StreamVolumeManager$1 streamVolumeManager$1) {
        this(streamVolumeManager);
    }

    public static /* synthetic */ void a(StreamVolumeManager streamVolumeManager) {
        StreamVolumeManager.access$200(streamVolumeManager);
    }

    public void onReceive(Context context, Intent object) {
        context = StreamVolumeManager.access$100(this.this$0);
        object = this.this$0;
        c0 c02 = new c0((StreamVolumeManager)object);
        context.post((Runnable)c02);
    }
}

