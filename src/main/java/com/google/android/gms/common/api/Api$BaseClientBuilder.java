/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api;

import java.util.Collections;
import java.util.List;

public class Api$BaseClientBuilder {
    public static final int API_PRIORITY_GAMES = 1;
    public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
    public static final int API_PRIORITY_PLUS = 2;

    public List getImpliedScopes(Object object) {
        return Collections.emptyList();
    }

    public int getPriority() {
        return -1 >>> 1;
    }
}

