/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.zabi;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects$ToStringHelper;

public final class GoogleApiManager$zab {
    private final zai zajb;
    private final Feature zajc;

    private GoogleApiManager$zab(zai zai2, Feature feature) {
        this.zajb = zai2;
        this.zajc = feature;
    }

    public /* synthetic */ GoogleApiManager$zab(zai zai2, Feature feature, zabi zabi2) {
        this(zai2, feature);
    }

    public static /* synthetic */ zai zac(GoogleApiManager$zab googleApiManager$zab) {
        return googleApiManager$zab.zajb;
    }

    public static /* synthetic */ Feature zad(GoogleApiManager$zab googleApiManager$zab) {
        return googleApiManager$zab.zajc;
    }

    public final boolean equals(Object object) {
        boolean bl2;
        if (object != null && (bl2 = object instanceof GoogleApiManager$zab)) {
            boolean bl3;
            object = (GoogleApiManager$zab)object;
            Object object2 = this.zajb;
            zai zai2 = ((GoogleApiManager$zab)object).zajb;
            bl2 = Objects.equal(object2, zai2);
            if (bl2 && (bl3 = Objects.equal(object2 = this.zajc, object = ((GoogleApiManager$zab)object).zajc))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Object object = this.zajb;
        object = this.zajc;
        Object[] objectArray = new Object[]{object, object};
        return Objects.hashCode(objectArray);
    }

    public final String toString() {
        Objects$ToStringHelper objects$ToStringHelper = Objects.toStringHelper(this);
        Object object = this.zajb;
        objects$ToStringHelper = objects$ToStringHelper.add("key", object);
        object = this.zajc;
        return objects$ToStringHelper.add("feature", object).toString();
    }
}

