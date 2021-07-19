/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import java.util.EnumMap;
import java.util.Map;

public final class MultimapBuilder$4
extends MultimapBuilder$MultimapBuilderWithKeys {
    public final /* synthetic */ Class val$keyClass;

    public MultimapBuilder$4(Class clazz) {
        this.val$keyClass = clazz;
    }

    public Map createMap() {
        Class clazz = this.val$keyClass;
        EnumMap enumMap = new EnumMap(clazz);
        return enumMap;
    }
}

