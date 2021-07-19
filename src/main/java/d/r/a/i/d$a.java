/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.r.a.i;

import android.content.Context;
import android.text.TextUtils;
import d.r.a.h$j;
import d.r.a.h$t;
import d.r.a.i.d;
import d.r.a.i.o;
import d.r.a.s.c;

public final class d$a
implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ h$j b;
    public final /* synthetic */ d c;

    public d$a(d d10, String string2, h$j j10) {
        this.c = d10;
        this.a = string2;
        this.b = j10;
    }

    public final void run() {
        Object object;
        c c10;
        Object object2 = this.a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            object2 = this.c;
            c10 = ((o)object2).d;
            object2 = d.d((d)object2);
            object = this.a;
            c10.onReceiveRegId((Context)object2, (String)object);
        }
        object2 = this.c;
        c10 = ((o)object2).d;
        object2 = d.e((d)object2);
        object = this.b;
        int n10 = ((h$t)object).d;
        object = ((h$j)object).e;
        c10.onBind((Context)object2, n10, (String)object);
    }
}

