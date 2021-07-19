/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation;

import androidx.navigation.NavType$SerializableType;

public final class NavType$EnumType
extends NavType$SerializableType {
    private final Class mType;

    public NavType$EnumType(Class object) {
        IllegalArgumentException illegalArgumentException = null;
        super(false, (Class)object);
        boolean bl2 = ((Class)object).isEnum();
        if (bl2) {
            this.mType = object;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(object);
        stringBuilder.append(" is not an Enum type.");
        object = stringBuilder.toString();
        illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public String getName() {
        return this.mType.getName();
    }

    public Enum parseValue(String string2) {
        for (Enum enum_ : (Enum[])this.mType.getEnumConstants()) {
            String string3 = enum_.name();
            boolean bl2 = string3.equals(string2);
            if (!bl2) continue;
            return enum_;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Enum value ");
        stringBuilder.append(string2);
        stringBuilder.append(" not found for type ");
        string2 = this.mType.getName();
        stringBuilder.append(string2);
        stringBuilder.append(".");
        string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }
}

