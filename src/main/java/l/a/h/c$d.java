/*
 * Decompiled with CFR 0.151.
 */
package l.a.h;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import l.a.h.b;
import l.a.h.c;

public final class c$d
implements Iterator,
Map.Entry {
    public int a;
    public int b;
    public boolean c = false;
    public final /* synthetic */ c d;

    public c$d(c c10) {
        int n10;
        this.d = c10;
        this.a = n10 = c10.d() + -1;
        this.b = -1;
    }

    public Map.Entry a() {
        int n10 = this.hasNext();
        if (n10 != 0) {
            n10 = this.b;
            int n11 = 1;
            this.b = n10 += n11;
            this.c = n11;
            return this;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public boolean equals(Object object) {
        boolean bl2 = this.c;
        if (bl2) {
            bl2 = object instanceof Map.Entry;
            int n10 = 0;
            if (!bl2) {
                return false;
            }
            object = (Map.Entry)object;
            Object object2 = object.getKey();
            Object object3 = this.d;
            int n11 = this.b;
            object3 = ((c)object3).b(n11, 0);
            bl2 = l.a.h.b.c(object2, object3);
            int n12 = 1;
            if (bl2) {
                object = object.getValue();
                object2 = this.d;
                n11 = this.b;
                boolean bl3 = l.a.h.b.c(object, object2 = ((c)object2).b(n11, n12));
                if (bl3) {
                    n10 = n12;
                }
            }
            return n10 != 0;
        }
        object = new IllegalStateException("This container does not support retaining Map.Entry objects");
        throw object;
    }

    public Object getKey() {
        boolean bl2 = this.c;
        if (bl2) {
            c c10 = this.d;
            int n10 = this.b;
            return c10.b(n10, 0);
        }
        IllegalStateException illegalStateException = new IllegalStateException("This container does not support retaining Map.Entry objects");
        throw illegalStateException;
    }

    public Object getValue() {
        boolean bl2 = this.c;
        if (bl2) {
            c c10 = this.d;
            int n10 = this.b;
            return c10.b(n10, 1);
        }
        IllegalStateException illegalStateException = new IllegalStateException("This container does not support retaining Map.Entry objects");
        throw illegalStateException;
    }

    public boolean hasNext() {
        int n10 = this.b;
        int n11 = this.a;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.c;
        if (n10 != 0) {
            Object object = this.d;
            int n11 = this.b;
            int n12 = 0;
            object = ((c)object).b(n11, 0);
            Object object2 = this.d;
            int n13 = this.b;
            int n14 = 1;
            object2 = ((c)object2).b(n13, n14);
            if (object == null) {
                n10 = 0;
                object = null;
            } else {
                n10 = object.hashCode();
            }
            if (object2 != null) {
                n12 = object2.hashCode();
            }
            return n10 ^ n12;
        }
        IllegalStateException illegalStateException = new IllegalStateException("This container does not support retaining Map.Entry objects");
        throw illegalStateException;
    }

    public void remove() {
        int n10 = this.c;
        if (n10 != 0) {
            c c10 = this.d;
            int n11 = this.b;
            c10.h(n11);
            this.b = n10 = this.b + -1;
            this.a = n10 = this.a + -1;
            this.c = false;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    public Object setValue(Object object) {
        boolean bl2 = this.c;
        if (bl2) {
            c c10 = this.d;
            int n10 = this.b;
            return c10.i(n10, object);
        }
        object = new IllegalStateException("This container does not support retaining Map.Entry objects");
        throw object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.getKey();
        stringBuilder.append(object);
        stringBuilder.append("=");
        object = this.getValue();
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}

