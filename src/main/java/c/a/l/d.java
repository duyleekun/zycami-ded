/*
 * Decompiled with CFR 0.151.
 */
package c.a.l;

import c.a.e;
import c.a.l.l;
import c.b.a.c;

public final class d
implements c,
e {
    private static final Object c;
    public static final /* synthetic */ boolean d;
    private volatile c a;
    private volatile Object b;

    static {
        Object object;
        c = object = new Object();
    }

    private d(c c10) {
        Object object;
        this.b = object = c;
        this.a = c10;
    }

    public static e a(c c10) {
        boolean bl2 = c10 instanceof e;
        if (bl2) {
            return (e)((Object)c10);
        }
        c10 = (c)l.a(c10);
        d d10 = new d(c10);
        return d10;
    }

    public static c b(c c10) {
        l.a(c10);
        boolean bl2 = c10 instanceof d;
        if (bl2) {
            return c10;
        }
        d d10 = new d(c10);
        return d10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object get() {
        Object object = this.b;
        Object object2 = c;
        if (object != object2) return object;
        synchronized (this) {
            object = this.b;
            if (object != object2) return object;
            object = this.a;
            object = object.get();
            Object object3 = this.b;
            if (object3 != object2 && object3 != object) {
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "Scoped provider was invoked recursively returning different results: ";
                stringBuilder.append(string2);
                stringBuilder.append(object3);
                object3 = " & ";
                stringBuilder.append((String)object3);
                stringBuilder.append(object);
                object = ". This is likely due to a circular dependency.";
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                object2 = new IllegalStateException((String)object);
                throw object2;
            }
            this.b = object;
            object2 = null;
            this.a = null;
            return object;
        }
    }
}

