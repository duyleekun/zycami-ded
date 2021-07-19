/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 */
package com.xiaomi.mipush.sdk;

import android.os.Handler;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.BaseService;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class BaseService$a
extends Handler {
    private WeakReference a;

    public BaseService$a(WeakReference weakReference) {
        this.a = weakReference;
    }

    public void a() {
        int n10 = 1001;
        boolean bl2 = this.hasMessages(n10);
        if (bl2) {
            this.removeMessages(n10);
        }
        this.sendEmptyMessageDelayed(n10, 1000L);
    }

    public void handleMessage(Message object) {
        int n10 = ((Message)object).what;
        int n11 = 1001;
        if (n10 == n11 && (object = this.a) != null && (object = (BaseService)((Object)((Reference)object).get())) != null) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("TimeoutHandler");
            String string2 = object.toString();
            charSequence.append(string2);
            string2 = "  kill self";
            charSequence.append(string2);
            charSequence = charSequence.toString();
            b.c((String)charSequence);
            boolean bl2 = ((BaseService)((Object)object)).a();
            if (!bl2) {
                object.stopSelf();
            } else {
                object = "TimeoutHandler has job";
                b.c((String)object);
                long l10 = 1000L;
                this.sendEmptyMessageDelayed(n11, l10);
            }
        }
    }
}

