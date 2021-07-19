/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.util.Util;

public final class Descriptor {
    public final String id;
    public final String schemeIdUri;
    public final String value;

    public Descriptor(String string2, String string3, String string4) {
        this.schemeIdUri = string2;
        this.value = string3;
        this.id = string4;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = Descriptor.class) == (object2 = object.getClass())) {
            boolean bl3;
            object = (Descriptor)object;
            object3 = this.schemeIdUri;
            object2 = ((Descriptor)object).schemeIdUri;
            boolean bl4 = Util.areEqual(object3, object2);
            if (!(bl4 && (bl4 = Util.areEqual(object3 = this.value, object2 = ((Descriptor)object).value)) && (bl3 = Util.areEqual(object3 = this.id, object = ((Descriptor)object).id)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10;
        String string2 = this.schemeIdUri;
        int n11 = string2.hashCode() * 31;
        String string3 = this.value;
        int n12 = 0;
        if (string3 != null) {
            n10 = string3.hashCode();
        } else {
            n10 = 0;
            string3 = null;
        }
        n11 = (n11 + n10) * 31;
        string3 = this.id;
        if (string3 != null) {
            n12 = string3.hashCode();
        }
        return n11 + n12;
    }
}

