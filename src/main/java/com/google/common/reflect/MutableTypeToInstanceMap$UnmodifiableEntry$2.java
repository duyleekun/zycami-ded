/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.reflect.MutableTypeToInstanceMap$UnmodifiableEntry;
import java.util.Map;

public final class MutableTypeToInstanceMap$UnmodifiableEntry$2
implements Function {
    public Map.Entry apply(Map.Entry entry) {
        MutableTypeToInstanceMap$UnmodifiableEntry mutableTypeToInstanceMap$UnmodifiableEntry = new MutableTypeToInstanceMap$UnmodifiableEntry(entry, null);
        return mutableTypeToInstanceMap$UnmodifiableEntry;
    }
}

