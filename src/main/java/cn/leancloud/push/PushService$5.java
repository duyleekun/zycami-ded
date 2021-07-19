/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package cn.leancloud.push;

import android.content.Intent;
import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.push.PushService;

public class PushService$5
extends AVCallback {
    public final /* synthetic */ PushService this$0;
    public final /* synthetic */ Intent val$intent;

    public PushService$5(PushService pushService, Intent intent) {
        this.this$0 = pushService;
        this.val$intent = intent;
    }

    public void internalDone0(Integer object, AVException aVException) {
        if (aVException == null) {
            object = this.this$0;
            aVException = this.val$intent;
            PushService.access$400((PushService)((Object)object), (Intent)aVException);
        } else {
            PushService.access$000().w("failed to start connection. cause:", aVException);
            object = this.this$0;
            Intent intent = this.val$intent;
            PushService.access$500((PushService)((Object)object), intent, aVException);
        }
    }
}

