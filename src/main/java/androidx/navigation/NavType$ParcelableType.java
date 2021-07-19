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
import java.io.Serializable;

public final class NavType$ParcelableType
extends NavType {
    private final Class mType;

    public NavType$ParcelableType(Class object) {
        super(true);
        Object object2 = Parcelable.class;
        boolean bl2 = ((Class)object2).isAssignableFrom((Class<?>)object);
        if (!bl2 && !(bl2 = ((Class)(object2 = Serializable.class)).isAssignableFrom((Class<?>)object))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(object);
            stringBuilder.append(" does not implement Parcelable or Serializable.");
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        this.mType = object;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class clazz2;
        if (this == object) {
            return true;
        }
        if (object != null && (clazz2 = NavType$ParcelableType.class) == (clazz = object.getClass())) {
            object = (NavType$ParcelableType)object;
            clazz2 = this.mType;
            object = ((NavType$ParcelableType)object).mType;
            return clazz2.equals(object);
        }
        return false;
    }

    public Object get(Bundle bundle, String string2) {
        return bundle.get(string2);
    }

    public String getName() {
        return this.mType.getName();
    }

    public int hashCode() {
        return this.mType.hashCode();
    }

    public Object parseValue(String object) {
        object = new UnsupportedOperationException("Parcelables don't support default values.");
        throw object;
    }

    public void put(Bundle bundle, String string2, Object object) {
        boolean bl2;
        Class clazz = this.mType;
        clazz.cast(object);
        if (object != null && !(bl2 = object instanceof Parcelable)) {
            bl2 = object instanceof Serializable;
            if (bl2) {
                object = (Serializable)object;
                bundle.putSerializable(string2, (Serializable)object);
            }
        } else {
            object = (Parcelable)object;
            bundle.putParcelable(string2, (Parcelable)object);
        }
    }
}

