/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.c.a.o;

import android.content.Context;
import d.c.a.o.i;
import d.c.a.o.k.s;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class d
implements i {
    private final Collection c;

    public d(Collection object) {
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            this.c = object;
            return;
        }
        object = new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        throw object;
    }

    public d(i ... object) {
        int n10 = ((i[])object).length;
        if (n10 != 0) {
            this.c = object = Arrays.asList(object);
            return;
        }
        super("MultiTransformation must contain at least one Transformation");
        throw object;
    }

    public s a(Context context, s s10, int n10, int n11) {
        boolean bl2;
        Iterator iterator2 = this.c.iterator();
        s s11 = s10;
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            s s12 = ((i)iterator2.next()).a(context, s11, n10, n11);
            if (s11 != null && !(bl3 = s11.equals(s10)) && !(bl3 = s11.equals(s12))) {
                s11.recycle();
            }
            s11 = s12;
        }
        return s11;
    }

    public void b(MessageDigest messageDigest) {
        boolean bl2;
        Iterator iterator2 = this.c.iterator();
        while (bl2 = iterator2.hasNext()) {
            i i10 = (i)iterator2.next();
            i10.b(messageDigest);
        }
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof d;
        if (bl2) {
            object = (d)object;
            Collection collection = this.c;
            object = ((d)object).c;
            return collection.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }
}

