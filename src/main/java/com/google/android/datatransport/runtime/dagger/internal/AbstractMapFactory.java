/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import java.util.Collections;
import java.util.Map;

public abstract class AbstractMapFactory
implements Factory {
    private final Map contributingMap;

    public AbstractMapFactory(Map map) {
        this.contributingMap = map = Collections.unmodifiableMap(map);
    }

    public static /* synthetic */ Map access$000(AbstractMapFactory abstractMapFactory) {
        return abstractMapFactory.contributingMap;
    }

    public final Map contributingMap() {
        return this.contributingMap;
    }
}

