/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavType;
import java.io.Serializable;

public final class NavType$SerializableArrayType
extends NavType {
    private final Class mArrayType;

    public NavType$SerializableArrayType(Class clazz) {
        super(true);
        Object object = Serializable.class;
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
        stringBuilder.append(" does not implement Serializable.");
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
        if (object != null && (clazz2 = NavType$SerializableArrayType.class) == (clazz = object.getClass())) {
            object = (NavType$SerializableArrayType)object;
            clazz2 = this.mArrayType;
            object = ((NavType$SerializableArrayType)object).mArrayType;
            return clazz2.equals(object);
        }
        return false;
    }

    public Serializable[] get(Bundle bundle, String string2) {
        return (Serializable[])bundle.get(string2);
    }

    public String getName() {
        return this.mArrayType.getName();
    }

    public int hashCode() {
        return this.mArrayType.hashCode();
    }

    public Serializable[] parseValue(String object) {
        object = new UnsupportedOperationException("Arrays don't support default values.");
        throw object;
    }

    public void put(Bundle bundle, String string2, Serializable[] serializableArray) {
        this.mArrayType.cast(serializableArray);
        bundle.putSerializable(string2, (Serializable)serializableArray);
    }
}

