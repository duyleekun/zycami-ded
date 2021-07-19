/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.t;

import d.c.a.o.c;
import d.c.a.u.k;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public final class e
implements c {
    private final Object c;

    public e(Object object) {
        this.c = object = k.d(object);
    }

    public void b(MessageDigest messageDigest) {
        Object object = this.c.toString();
        Charset charset = d.c.a.o.c.b;
        object = ((String)object).getBytes(charset);
        messageDigest.update((byte[])object);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof e;
        if (bl2) {
            object = (e)object;
            Object object2 = this.c;
            object = ((e)object).c;
            return object2.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ObjectKey{object=");
        Object object = this.c;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

