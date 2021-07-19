/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.internal;

import com.huawei.hms.common.internal.BindResolveClients;

public class BindResolveClients$SingletonManager {
    private static final BindResolveClients INSTANCE;

    static {
        BindResolveClients bindResolveClients;
        INSTANCE = bindResolveClients = new BindResolveClients(null);
    }

    private BindResolveClients$SingletonManager() {
    }

    public static /* synthetic */ BindResolveClients access$100() {
        return INSTANCE;
    }
}

