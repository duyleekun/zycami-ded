/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 */
package d.v.g.f.b.e;

import android.app.Application;
import android.content.Context;
import d.v.e.d;
import d.v.e.f;
import d.v.g.f.b.e.a$a;
import java.util.List;

public class a
extends d {
    private static final String b = "connect_device_preference";
    private static final String c = "connect_device_list";
    private Context a;

    public a() {
        Application application = f.a().b();
        this.a = application;
    }

    public static a B() {
        return a$a.a();
    }

    public List A() {
        Context context = this.a;
        return this.k(context, b, c);
    }

    public void C(List list) {
        Context context = this.a;
        this.p(context, b, c, list);
    }

    public void z() {
        Context context = this.a;
        this.r(context, b, c);
    }
}

