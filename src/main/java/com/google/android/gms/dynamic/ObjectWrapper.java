/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.dynamic;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper$Stub;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public final class ObjectWrapper
extends IObjectWrapper$Stub {
    private final Object zza;

    private ObjectWrapper(Object object) {
        this.zza = object;
    }

    public static Object unwrap(IObjectWrapper object) {
        int n10 = object instanceof ObjectWrapper;
        if (n10 != 0) {
            return ((ObjectWrapper)object).zza;
        }
        object = object.asBinder();
        Object object2 = object.getClass().getDeclaredFields();
        AccessibleObject accessibleObject = null;
        int n11 = ((Field[])object2).length;
        int n12 = 0;
        for (int i10 = 0; i10 < n11; i10 += 1) {
            Field field = object2[i10];
            boolean bl2 = field.isSynthetic();
            if (bl2) continue;
            n12 += 1;
            accessibleObject = field;
        }
        n11 = 1;
        if (n12 == n11) {
            n10 = accessibleObject.isAccessible();
            if (n10 == 0) {
                ((Field)accessibleObject).setAccessible(n11 != 0);
                try {
                    return ((Field)accessibleObject).get(object);
                }
                catch (IllegalAccessException illegalAccessException) {
                    object2 = new IllegalArgumentException("Could not access the field in remoteBinder.", illegalAccessException);
                    throw object2;
                }
                catch (NullPointerException nullPointerException) {
                    object2 = new IllegalArgumentException("Binder object is null.", nullPointerException);
                    throw object2;
                }
            }
            object = new IllegalArgumentException("IObjectWrapper declared field not private!");
            throw object;
        }
        n10 = ((Field[])object2).length;
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("Unexpected number of IObjectWrapper declared fields: ");
        stringBuilder.append(n10);
        object2 = stringBuilder.toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public static IObjectWrapper wrap(Object object) {
        ObjectWrapper objectWrapper = new ObjectWrapper(object);
        return objectWrapper;
    }
}

