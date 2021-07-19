/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Map;

public class Functions$ForMapWithDefault
implements Function,
Serializable {
    private static final long serialVersionUID;
    public final Object defaultValue;
    public final Map map;

    public Functions$ForMapWithDefault(Map map, Object object) {
        this.map = map = (Map)Preconditions.checkNotNull(map);
        this.defaultValue = object;
    }

    public Object apply(Object object) {
        Map map;
        boolean bl2;
        Object object2 = this.map.get(object);
        if (object2 == null && !(bl2 = (map = this.map).containsKey(object))) {
            object2 = this.defaultValue;
        }
        return object2;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Functions$ForMapWithDefault;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            object = (Functions$ForMapWithDefault)object;
            Object object2 = this.map;
            Map map = ((Functions$ForMapWithDefault)object).map;
            bl2 = object2.equals(map);
            if (bl2 && (bl4 = Objects.equal(object2 = this.defaultValue, object = ((Functions$ForMapWithDefault)object).defaultValue))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public int hashCode() {
        Object object = this.map;
        object = this.defaultValue;
        Object[] objectArray = new Object[]{object, object};
        return Objects.hashCode(objectArray);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Functions.forMap(");
        Object object = this.map;
        stringBuilder.append(object);
        stringBuilder.append(", defaultValue=");
        object = this.defaultValue;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

