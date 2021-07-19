/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import java.io.Serializable;

public final class Maps$BiMapConverter
extends Converter
implements Serializable {
    private static final long serialVersionUID;
    private final BiMap bimap;

    public Maps$BiMapConverter(BiMap biMap) {
        this.bimap = biMap = (BiMap)Preconditions.checkNotNull(biMap);
    }

    private static Object convert(BiMap biMap, Object object) {
        boolean bl2 = (biMap = biMap.get(object)) != null;
        Preconditions.checkArgument(bl2, "No non-null mapping present for input: %s", object);
        return biMap;
    }

    public Object doBackward(Object object) {
        return Maps$BiMapConverter.convert(this.bimap.inverse(), object);
    }

    public Object doForward(Object object) {
        return Maps$BiMapConverter.convert(this.bimap, object);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Maps$BiMapConverter;
        if (bl2) {
            object = (Maps$BiMapConverter)object;
            BiMap biMap = this.bimap;
            object = ((Maps$BiMapConverter)object).bimap;
            return biMap.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.bimap.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Maps.asConverter(");
        BiMap biMap = this.bimap;
        stringBuilder.append(biMap);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

