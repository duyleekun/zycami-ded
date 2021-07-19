/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.heytap.mcssdk.b;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.mcssdk.R$string;
import com.heytap.mcssdk.b.a;
import com.heytap.mcssdk.f.d;

public class a$1
implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ a b;

    public a$1(a a10, Context context) {
        this.b = a10;
        this.a = context;
    }

    public void run() {
        Object object = this.a;
        boolean bl2 = d.a(object);
        if (bl2) {
            return;
        }
        object = this.a;
        int n10 = R$string.system_default_channel;
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)(object = object.getString(n10))) ? 1 : 0)) != 0) {
            object = "System Default Channel";
        }
        a a10 = this.b;
        Context context = this.a;
        bl2 = com.heytap.mcssdk.b.a.a(a10, context, "Heytap PUSH", (String)object, 3);
        d.a(this.a, bl2);
    }
}

