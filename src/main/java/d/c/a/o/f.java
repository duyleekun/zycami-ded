/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import d.c.a.o.c;
import d.c.a.o.e;
import d.c.a.u.b;
import java.security.MessageDigest;

public final class f
implements c {
    private final ArrayMap c;

    public f() {
        b b10 = new b();
        this.c = b10;
    }

    private static void f(e e10, Object object, MessageDigest messageDigest) {
        e10.h(object, messageDigest);
    }

    public void b(MessageDigest messageDigest) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((SimpleArrayMap)(object = this.c)).size()); ++i10) {
            object = (e)this.c.keyAt(i10);
            Object object2 = this.c.valueAt(i10);
            f.f((e)object, object2, messageDigest);
        }
    }

    public Object c(e object) {
        ArrayMap arrayMap = this.c;
        boolean bl2 = arrayMap.containsKey(object);
        if (bl2) {
            arrayMap = this.c;
            object = arrayMap.get(object);
        } else {
            object = ((e)object).d();
        }
        return object;
    }

    public void d(f object) {
        ArrayMap arrayMap = this.c;
        object = ((f)object).c;
        arrayMap.putAll((SimpleArrayMap)object);
    }

    public f e(e e10, Object object) {
        this.c.put(e10, object);
        return this;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof f;
        if (bl2) {
            object = (f)object;
            ArrayMap arrayMap = this.c;
            object = ((f)object).c;
            return arrayMap.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Options{values=");
        ArrayMap arrayMap = this.c;
        stringBuilder.append(arrayMap);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

