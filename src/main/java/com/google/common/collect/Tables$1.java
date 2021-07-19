/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Collections;
import java.util.Map;

public final class Tables$1
implements Function {
    public Map apply(Map map) {
        return Collections.unmodifiableMap(map);
    }
}

