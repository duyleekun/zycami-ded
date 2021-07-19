/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Map;

public class Functions$FunctionForMapNoDefault
implements Function,
Serializable {
    private static final long serialVersionUID;
    public final Map map;

    public Functions$FunctionForMapNoDefault(Map map) {
        this.map = map = (Map)Preconditions.checkNotNull(map);
    }

    public Object apply(Object object) {
        Map map;
        boolean bl2;
        Object v10 = this.map.get(object);
        if (v10 == null && !(bl2 = (map = this.map).containsKey(object))) {
            bl2 = false;
            map = null;
        } else {
            bl2 = true;
        }
        Preconditions.checkArgument(bl2, "Key '%s' not present in map", object);
        return v10;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Functions$FunctionForMapNoDefault;
        if (bl2) {
            object = (Functions$FunctionForMapNoDefault)object;
            Map map = this.map;
            object = ((Functions$FunctionForMapNoDefault)object).map;
            return map.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Functions.forMap(");
        Map map = this.map;
        stringBuilder.append(map);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

