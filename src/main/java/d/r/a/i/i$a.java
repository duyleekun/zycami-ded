/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.i;

import android.content.Context;
import d.r.a.h$n;
import d.r.a.h$t;
import d.r.a.i.i;
import d.r.a.s.c;
import java.util.ArrayList;

public final class i$a
implements Runnable {
    public final /* synthetic */ h$n a;
    public final /* synthetic */ i b;

    public i$a(i i10, h$n n10) {
        this.b = i10;
        this.a = n10;
    }

    public final void run() {
        i i10 = this.b;
        c c10 = i10.d;
        i10 = i.d(i10);
        Object object = this.a;
        int n10 = ((h$t)object).d;
        ArrayList arrayList = ((h$n)object).e;
        object = ((h$t)object).c;
        c10.onListTags((Context)i10, n10, arrayList, (String)object);
    }
}

