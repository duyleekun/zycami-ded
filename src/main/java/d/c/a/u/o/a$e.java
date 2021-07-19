/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.c.a.u.o;

import android.util.Log;
import androidx.core.util.Pools$Pool;
import d.c.a.u.o.a$d;
import d.c.a.u.o.a$f;
import d.c.a.u.o.a$g;
import d.c.a.u.o.c;

public final class a$e
implements Pools$Pool {
    private final a$d a;
    private final a$g b;
    private final Pools$Pool c;

    public a$e(Pools$Pool pools$Pool, a$d a$d, a$g a$g) {
        this.c = pools$Pool;
        this.a = a$d;
        this.b = a$g;
    }

    public Object acquire() {
        Object object;
        boolean bl2;
        String string2;
        Object object2 = this.c.acquire();
        if (object2 == null) {
            object2 = this.a.create();
            string2 = "FactoryPools";
            bl2 = Log.isLoggable((String)string2, (int)2);
            if (bl2) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Created new ");
                Class<?> clazz = object2.getClass();
                ((StringBuilder)object).append(clazz);
                object = ((StringBuilder)object).toString();
                Log.v((String)string2, (String)object);
            }
        }
        if (bl2 = object2 instanceof a$f) {
            object = object2;
            object = ((a$f)object2).d();
            string2 = null;
            ((c)object).b(false);
        }
        return object2;
    }

    public boolean release(Object object) {
        boolean bl2 = object instanceof a$f;
        if (bl2) {
            Object object2 = object;
            object2 = ((a$f)object).d();
            boolean bl3 = true;
            ((c)object2).b(bl3);
        }
        this.b.a(object);
        return this.c.release(object);
    }
}

