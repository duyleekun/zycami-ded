/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavType;

public final class NavType$ParcelableArrayType
extends NavType {
    private final Class mArrayType;

    public NavType$ParcelableArrayType(Class clazz) {
        super(true);
        Object object = Parcelable.class;
        boolean bl2 = ((Class)object).isAssignableFrom(clazz);
        if (bl2) {
            String string2;
            try {
                object = new StringBuilder();
                string2 = "[L";
            }
            catch (ClassNotFoundException classNotFoundException) {
                object = new RuntimeException(classNotFoundException);
                throw object;
            }
            ((StringBuilder)object).append(string2);
            clazz = clazz.getName();
            ((StringBuilder)object).append((String)((Object)clazz));
            clazz = ";";
            ((StringBuilder)object).append((String)((Object)clazz));
            clazz = ((StringBuilder)object).toString();
            this.mArrayType = clazz = Class.forName((String)((Object)clazz));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clazz);
        stringBuilder.append(" does not implement Parcelable.");
        clazz = stringBuilder.toString();
        object = new IllegalArgumentException((String)((Object)clazz));
        throw object;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class clazz2;
        if (this == object) {
            return true;
        }
        if (object != null && (clazz2 = NavType$ParcelableArrayType.class) == (clazz = object.getClass())) {
            object = (NavType$ParcelableArrayType)object;
            clazz2 = this.mArrayType;
            object = ((NavType$ParcelableArrayType)object).mArrayType;
            return clazz2.equals(object);
        }
        return false;
    }

    public Parcelable[] get(Bundle bundle, String string2) {
        return (Parcelable[])bundle.get(string2);
    }

    public String getName() {
        return this.mArrayType.getName();
    }

    public int hashCode() {
        return this.mArrayType.hashCode();
    }

    public Parcelable[] parseValue(String object) {
        object = new UnsupportedOperationException("Arrays don't support default values.");
        throw object;
    }

    public void put(Bundle bundle, String string2, Parcelable[] parcelableArray) {
        this.mArrayType.cast(parcelableArray);
        bundle.putParcelableArray(string2, parcelableArray);
    }
}

