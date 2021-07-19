/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package cn.leancloud.push;

import android.content.Context;
import cn.leancloud.push.AVShutdownListener;
import cn.leancloud.push.PushService;

public class PushService$3
implements AVShutdownListener {
    public final /* synthetic */ PushService this$0;

    public PushService$3(PushService pushService) {
        this.this$0 = pushService;
    }

    public void onShutdown(Context context) {
        PushService.access$100(this.this$0).cleanup();
    }
}

