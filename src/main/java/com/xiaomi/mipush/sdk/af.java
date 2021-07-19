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
import com.xiaomi.push.hs;
import com.xiaomi.push.hw;
import com.xiaomi.push.ie;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.al;

public class af
extends ai$a {
    private Context a;

    public af(Context context) {
        this.a = context;
    }

    public int a() {
        return 2;
    }

    public void run() {
        Object object = ak.a(this.a);
        Object object2 = new ie();
        Object object3 = hs.a;
        int n10 = al.a((ak)object, object3);
        ((ie)object2).a(n10);
        object3 = hs.b;
        int n11 = al.a((ak)object, object3);
        ((ie)object2).b(n11);
        object = new il("-1", false);
        object3 = hw.p.a;
        ((il)object).c((String)object3);
        object2 = iw.a((ix)object2);
        ((il)object).a((byte[])object2);
        object2 = aq.a(this.a);
        object3 = hm.i;
        ((aq)object2).a((ix)object, (hm)((Object)object3), null);
    }
}

