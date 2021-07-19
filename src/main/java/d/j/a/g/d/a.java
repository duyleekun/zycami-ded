/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.j.a.g.d;

import android.content.Context;
import com.huawei.agconnect.core.a.f;
import d.j.a.d;
import d.j.a.g.d.b;
import d.j.a.g.d.c;
import java.util.List;

public class a
extends d.j.a.b {
    private final Context b;
    private final c c;
    private b d;

    public a(Context object) {
        this.b = object;
        Object object2 = new f((Context)object);
        object2 = ((f)object2).b();
        super((List)object2);
        this.c = object;
        super();
        this.d = object;
    }

    public Context a() {
        return this.b;
    }

    public Object c(Class clazz) {
        b b10 = this.d;
        boolean bl2 = b10.c(clazz);
        if (bl2) {
            return this.d.d(clazz);
        }
        return this.c.b(this, clazz);
    }

    public void e(d.j.a.c c10) {
        this.d.a(c10);
    }

    public void f(d d10) {
        this.d.b(d10);
    }
}

