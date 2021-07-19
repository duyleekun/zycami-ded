/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbt;
import java.lang.reflect.Method;

public final class zzbs {
    private static final Class zzgl = zzbs.zzak();

    private static Class zzak() {
        String string2 = "com.google.protobuf.ExtensionRegistry";
        try {
            return Class.forName(string2);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return null;
        }
    }

    public static zzbt zzal() {
        Object object = zzgl;
        if (object != null) {
            Class[] classArray;
            String string2 = "getEmptyRegistry";
            Object[] objectArray = null;
            try {
                classArray = new Class[]{};
            }
            catch (Exception exception) {}
            object = ((Class)object).getDeclaredMethod(string2, classArray);
            string2 = null;
            objectArray = new Object[]{};
            object = ((Method)object).invoke(null, objectArray);
            return (zzbt)object;
        }
        return zzbt.zzgo;
    }
}

