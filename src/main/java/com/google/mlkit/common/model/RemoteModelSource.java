/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.model;

import com.google.android.gms.common.internal.Objects;

public class RemoteModelSource {
    private final String zza;

    public RemoteModelSource(String string2) {
        this.zza = string2;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        boolean bl2;
        if (object == this) {
            return true;
        }
        if (object != null && (bl2 = (object2 = object.getClass()).equals(clazz = this.getClass()))) {
            object = (RemoteModelSource)object;
            object2 = this.zza;
            object = ((RemoteModelSource)object).zza;
            return Objects.equal(object2, object);
        }
        return false;
    }

    public int hashCode() {
        Object[] objectArray = new Object[1];
        String string2 = this.zza;
        objectArray[0] = string2;
        return Objects.hashCode(objectArray);
    }
}

