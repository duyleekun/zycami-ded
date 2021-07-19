/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences$Editor
 */
package d.r.a.i;

import android.content.Context;
import android.content.SharedPreferences;
import d.r.a.o;
import d.r.a.u.b0;
import d.r.a.u.c0;
import d.r.a.u.s;

public final class f
extends d.r.a.i.o {
    public f(o o10) {
        super(o10);
    }

    public final void a(o object) {
        object = new StringBuilder("delete push info ");
        Object object2 = this.a.getPackageName();
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        s.m("OnClearCacheTask", (String)object);
        object = c0.c(this.a);
        object2 = new b0();
        object = ((c0)object).a;
        boolean bl2 = ((b0)object2).a((Context)object);
        if (bl2) {
            object = ((b0)object2).a.edit();
            if (object != null) {
                object.clear();
                d.r.a.u.f.d((SharedPreferences.Editor)object);
            }
            s.m(b0.b, "system cache is cleared");
            object = "SystemCache";
            object2 = "sp cache is cleared";
            s.m((String)object, (String)object2);
        }
    }
}

