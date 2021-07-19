/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 */
package d.v.e.m;

import android.content.BroadcastReceiver;
import android.content.Context;
import com.zhiyun.common.viewmodel.DeviceViewModel$c;
import e.a.v0.f;

public final class d
implements f {
    public final /* synthetic */ Context a;
    public final /* synthetic */ BroadcastReceiver b;

    public /* synthetic */ d(Context context, BroadcastReceiver broadcastReceiver) {
        this.a = context;
        this.b = broadcastReceiver;
    }

    public final void cancel() {
        Context context = this.a;
        BroadcastReceiver broadcastReceiver = this.b;
        DeviceViewModel$c.a(context, broadcastReceiver);
    }
}

