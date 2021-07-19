/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.json;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class ParameterizedTypeImpl
implements ParameterizedType {
    private final Type[] actualTypeArguments;
    private final Type ownerType;
    private final Type rawType;

    public ParameterizedTypeImpl(Type[] typeArray, Type type, Type type2) {
        this.actualTypeArguments = typeArray;
        this.ownerType = type;
        this.rawType = type2;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            object = (ParameterizedTypeImpl)object;
            object3 = this.actualTypeArguments;
            object2 = ((ParameterizedTypeImpl)object).actualTypeArguments;
            boolean bl3 = Arrays.equals((Object[])object3, object2);
            if (!bl3) {
                return false;
            }
            object3 = this.ownerType;
            if (object3 != null) {
                object2 = ((ParameterizedTypeImpl)object).ownerType;
                bl3 = object3.equals(object2);
                if (bl3) {
                    object3 = this.rawType;
                    object = ((ParameterizedTypeImpl)object).rawType;
                    if (object3 != null) {
                        bl2 = object3.equals(object);
                    } else if (object != null) {
                        bl2 = false;
                    }
                    return bl2;
                }
            } else {
                object3 = ((ParameterizedTypeImpl)object).ownerType;
                if (object3 == null) {
                    object3 = this.rawType;
                    object = ((ParameterizedTypeImpl)object).rawType;
                    if (object3 != null) {
                        bl2 = object3.equals(object);
                    } else if (object != null) {
                        bl2 = false;
                    }
                    return bl2;
                }
            }
        }
        return false;
    }

    public Type[] getActualTypeArguments() {
        return this.actualTypeArguments;
    }

    public Type getOwnerType() {
        return this.ownerType;
    }

    public Type getRawType() {
        return this.rawType;
    }

    public int hashCode() {
        int n10;
        int n11;
        Object[] objectArray = this.actualTypeArguments;
        int n12 = 0;
        if (objectArray != null) {
            n11 = Arrays.hashCode(objectArray);
        } else {
            n11 = 0;
            objectArray = null;
        }
        n11 *= 31;
        Type type = this.ownerType;
        if (type != null) {
            n10 = type.hashCode();
        } else {
            n10 = 0;
            type = null;
        }
        n11 = (n11 + n10) * 31;
        type = this.rawType;
        if (type != null) {
            n12 = type.hashCode();
        }
        return n11 + n12;
    }
}

