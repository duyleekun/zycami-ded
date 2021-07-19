/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 */
package d.r.a.t;

import android.content.Context;
import android.os.Bundle;
import d.r.a.a;
import d.r.a.t.d;
import d.r.a.t.e;
import d.r.a.t.f$a;
import d.r.a.t.f$b;
import d.r.a.t.f$c;

public class f {
    private static f a;

    public static f a() {
        f f10 = a;
        if (f10 == null) {
            a = f10 = new f();
        }
        return a;
    }

    public void b(Context context, Bundle bundle) {
    }

    public void c(Context context, String object, String object2, String string2, d d10) {
        object = d.r.a.d.f(context);
        object2 = new f$a(this, d10, context);
        ((d.r.a.d)object).o((a)object2);
    }

    public void d(Context object, e e10) {
        object = d.r.a.d.f((Context)object);
        f$c f$c = new f$c(this, e10);
        ((d.r.a.d)object).n(f$c);
    }

    public void e(Context object, e e10) {
        d.r.a.d.f(object).j();
        object = new d.r.a.t.a(0);
        e10.onResult(object);
    }

    public void f(Context object, d d10) {
        object = d.r.a.d.f((Context)object);
        f$b f$b = new f$b(this, d10);
        ((d.r.a.d)object).n(f$b);
    }
}

