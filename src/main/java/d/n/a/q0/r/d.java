/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.r;

import d.n.a.q0.b;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class d
extends WeakReference {
    public d(b b10) {
        super(b10);
    }

    public d(b b10, ReferenceQueue referenceQueue) {
        super(b10, referenceQueue);
    }

    public boolean a(Object object) {
        boolean bl2;
        Object object2 = (b)this.get();
        boolean bl3 = object instanceof b;
        if (bl3 && object2 != null && (object2 = object2.a()) == (object = ((b)object).a())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean b() {
        boolean bl2;
        Object t10 = this.get();
        if (t10 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            t10 = null;
        }
        return bl2;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3;
        boolean bl4 = object instanceof WeakReference;
        boolean bl5 = false;
        if (!bl4) {
            return false;
        }
        object = (WeakReference)object;
        Object object2 = (b)this.get();
        object = ((Reference)object).get();
        if (object2 != null && (bl3 = object instanceof b) && (bl2 = (object2 = object2.a()).equals(object = ((b)object).a()))) {
            bl5 = true;
        }
        return bl5;
    }

    public int hashCode() {
        int n10;
        Object object = this.get();
        if (object != null) {
            object = (b)this.get();
            n10 = object.hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        return n10;
    }
}

