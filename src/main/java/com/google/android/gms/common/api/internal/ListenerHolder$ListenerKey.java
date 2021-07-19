/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

public final class ListenerHolder$ListenerKey {
    private final Object zajk;
    private final String zajn;

    public ListenerHolder$ListenerKey(Object object, String string2) {
        this.zajk = object;
        this.zajn = string2;
    }

    public final boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        boolean bl4 = object instanceof ListenerHolder$ListenerKey;
        if (!bl4) {
            return false;
        }
        object = (ListenerHolder$ListenerKey)object;
        Object object2 = this.zajk;
        Object object3 = ((ListenerHolder$ListenerKey)object).zajk;
        if (object2 == object3 && (bl2 = ((String)(object2 = this.zajn)).equals(object = ((ListenerHolder$ListenerKey)object).zajn))) {
            return bl3;
        }
        return false;
    }

    public final int hashCode() {
        int n10 = System.identityHashCode(this.zajk) * 31;
        int n11 = this.zajn.hashCode();
        return n10 + n11;
    }
}

