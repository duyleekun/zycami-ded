/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.io.Serializable;

public final class zzgh {
    public static void zza(Bundle bundle, Object object) {
        boolean bl2 = object instanceof Double;
        String string2 = "value";
        if (bl2) {
            double d10 = (Double)object;
            bundle.putDouble(string2, d10);
            return;
        }
        bl2 = object instanceof Long;
        if (bl2) {
            long l10 = (Long)object;
            bundle.putLong(string2, l10);
            return;
        }
        object = object.toString();
        bundle.putString(string2, (String)object);
    }

    public static Object zzb(Bundle object, String string2, Class object2, Object serializable) {
        if ((object = object.get(string2)) == null) {
            return serializable;
        }
        serializable = object.getClass();
        boolean bl2 = ((Class)object2).isAssignableFrom((Class<?>)serializable);
        if (bl2) {
            return object;
        }
        Object[] objectArray = new Object[]{string2, object2 = ((Class)object2).getCanonicalName(), object = object.getClass().getCanonicalName()};
        object = String.format("Invalid conditional user property field type. '%s' expected [%s] but was [%s]", objectArray);
        serializable = new Serializable((String)object);
        throw serializable;
    }
}

