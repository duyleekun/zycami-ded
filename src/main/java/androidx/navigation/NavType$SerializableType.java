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

public class NavType$SerializableType
extends NavType {
    private final Class mType;

    public NavType$SerializableType(Class object) {
        super(true);
        Object object2 = Serializable.class;
        boolean bl2 = ((Class)object2).isAssignableFrom((Class<?>)object);
        if (bl2) {
            bl2 = ((Class)object).isEnum();
            if (!bl2) {
                this.mType = object;
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(object);
            stringBuilder.append(" is an Enum. You should use EnumType instead.");
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(object);
        stringBuilder.append(" does not implement Serializable.");
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public NavType$SerializableType(boolean bl2, Class object) {
        super(bl2);
        Object object2 = Serializable.class;
        bl2 = ((Class)object2).isAssignableFrom((Class<?>)object);
        if (bl2) {
            this.mType = object;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(object);
        stringBuilder.append(" does not implement Serializable.");
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof NavType$SerializableType;
        if (!bl2) {
            return false;
        }
        object = (NavType$SerializableType)object;
        Class clazz = this.mType;
        object = ((NavType$SerializableType)object).mType;
        return clazz.equals(object);
    }

    public Serializable get(Bundle bundle, String string2) {
        return (Serializable)bundle.get(string2);
    }

    public String getName() {
        return this.mType.getName();
    }

    public int hashCode() {
        return this.mType.hashCode();
    }

    public Serializable parseValue(String object) {
        object = new UnsupportedOperationException("Serializables don't support default values.");
        throw object;
    }

    public void put(Bundle bundle, String string2, Serializable serializable) {
        this.mType.cast(serializable);
        bundle.putSerializable(string2, serializable);
    }
}

