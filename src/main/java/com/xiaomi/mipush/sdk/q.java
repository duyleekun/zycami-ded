/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.mipush.sdk.aq;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.dp;
import com.xiaomi.push.hm;
import com.xiaomi.push.hz;
import com.xiaomi.push.il;
import com.xiaomi.push.ix;

public class q
implements dp {
    private Context a;

    public q(Context context) {
        this.a = context;
    }

    public String a() {
        return b.a(this.a).d();
    }

    public void a(il il2, hm hm2, hz hz2) {
        aq.a(this.a).a((ix)il2, hm2, hz2);
    }
}

