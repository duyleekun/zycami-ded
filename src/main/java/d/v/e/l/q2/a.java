/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.l.q2;

import d.v.e.l.q2.b;

public abstract class a
extends b {
    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof b;
        if (bl3) {
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "GsonValueBean{}";
    }
}

