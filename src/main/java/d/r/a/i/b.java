/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.i;

import android.content.Context;
import d.r.a.f.a;
import d.r.a.h$e;
import d.r.a.h$g;
import d.r.a.h$z;
import d.r.a.i.e;
import d.r.a.m;
import d.r.a.o;
import d.r.a.r.f;
import d.r.a.u.w;

public final class b
extends m {
    public b(o o10) {
        super(o10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void a(o object) {
        String string2;
        Object object2;
        block24: {
            Object object3;
            block23: {
                object = (h$e)object;
                object2 = w.a(this.a);
                boolean bl2 = ((h$e)object).c;
                if (bl2) {
                    object = this.a;
                    bl2 = e.b((Context)object);
                } else {
                    object = this.a;
                    bl2 = e.c((Context)object);
                }
                if (!bl2) return;
                try {
                    object = this.a;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
                object = w.a((Context)object);
                if (object2 == null || object == null) break block23;
                string2 = ((f)object).a;
                if (string2 == null) break block23;
                object3 = ((f)object2).a;
                boolean bl3 = string2.equals(object3);
                if (!bl3) break block23;
                return;
            }
            if (object2 != null) {
                string2 = ((f)object2).a;
                if (string2 == null) break block24;
                object3 = new h$z(string2);
                string2 = this.a;
                object2 = ((f)object2).a;
                d.r.a.f.a.b((Context)string2, (String)object2, (o)object3);
            }
        }
        if (object == null) return;
        object2 = ((f)object).a;
        if (object2 == null) return;
        object2 = new h$g();
        string2 = this.a;
        object = ((f)object).a;
        d.r.a.f.a.b((Context)string2, (String)object, (o)object2);
    }
}

