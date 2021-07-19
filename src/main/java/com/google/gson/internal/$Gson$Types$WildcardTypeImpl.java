/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.$Gson$Types;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public final class $Gson$Types$WildcardTypeImpl
implements WildcardType,
Serializable {
    private static final long serialVersionUID;
    private final Type lowerBound;
    private final Type upperBound;

    public $Gson$Types$WildcardTypeImpl(Type[] object, Type[] typeArray) {
        Type type;
        Class<Object> clazz = Object.class;
        boolean bl2 = typeArray.length;
        boolean bl3 = true;
        if (bl2 <= bl3) {
            bl2 = bl3;
        } else {
            bl2 = false;
            type = null;
        }
        $Gson$Preconditions.checkArgument(bl2);
        bl2 = ((Type[])object).length;
        if (bl2 == bl3) {
            bl2 = bl3;
        } else {
            bl2 = false;
            type = null;
        }
        $Gson$Preconditions.checkArgument(bl2);
        bl2 = typeArray.length;
        if (bl2 == bl3) {
            $Gson$Preconditions.checkNotNull(typeArray[0]);
            type = typeArray[0];
            $Gson$Types.checkNotPrimitive(type);
            object = object[0];
            if (object != clazz) {
                bl3 = false;
            }
            $Gson$Preconditions.checkArgument(bl3);
            this.lowerBound = object = $Gson$Types.canonicalize(typeArray[0]);
            this.upperBound = clazz;
        } else {
            $Gson$Preconditions.checkNotNull(object[0]);
            $Gson$Types.checkNotPrimitive(object[0]);
            typeArray = null;
            this.lowerBound = null;
            this.upperBound = object = $Gson$Types.canonicalize(object[0]);
        }
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof WildcardType;
        if (bl3 && (bl2 = $Gson$Types.equals(this, (Type)(object = (WildcardType)object)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Type[] getLowerBounds() {
        Type[] typeArray;
        Type type = this.lowerBound;
        if (type != null) {
            int n10 = 1;
            typeArray = new Type[n10];
            typeArray[0] = type;
        } else {
            typeArray = $Gson$Types.EMPTY_TYPE_ARRAY;
        }
        return typeArray;
    }

    public Type[] getUpperBounds() {
        Type type = this.upperBound;
        Type[] typeArray = new Type[]{type};
        return typeArray;
    }

    public int hashCode() {
        Type type = this.lowerBound;
        int n10 = type != null ? type.hashCode() + 31 : 1;
        int n11 = this.upperBound.hashCode() + 31;
        return n10 ^ n11;
    }

    public String toString() {
        Object object = this.lowerBound;
        if (object != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("? super ");
            String string2 = $Gson$Types.typeToString(this.lowerBound);
            ((StringBuilder)object).append(string2);
            return ((StringBuilder)object).toString();
        }
        object = this.upperBound;
        Class<Object> clazz = Object.class;
        if (object == clazz) {
            return "?";
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("? extends ");
        clazz = $Gson$Types.typeToString(this.upperBound);
        ((StringBuilder)object).append((String)((Object)clazz));
        return ((StringBuilder)object).toString();
    }
}

