/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.mipush.sdk.aq;
import com.xiaomi.push.ai$a;
import com.xiaomi.push.hm;
import com.xiaomi.push.il;
import com.xiaomi.push.service.an;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class o
extends ai$a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ il a;

    public o(il il2, Context context) {
        this.a = il2;
        this.a = context;
    }

    public int a() {
        return 22;
    }

    public void run() {
        il il2 = this.a;
        if (il2 != null) {
            Object object = an.a();
            il2.a((String)object);
            il2 = this.a.getApplicationContext();
            object = aq.a((Context)il2);
            il il3 = this.a;
            hm hm2 = hm.i;
            boolean bl2 = true;
            boolean bl3 = true;
            ((aq)object).a(il3, hm2, bl2, null, bl3);
        }
    }
}

