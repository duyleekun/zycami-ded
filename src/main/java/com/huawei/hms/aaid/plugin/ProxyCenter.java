/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.aaid.plugin;

import com.huawei.hms.aaid.plugin.ProxyCenter$a;
import com.huawei.hms.aaid.plugin.PushProxy;

public class ProxyCenter {
    public PushProxy proxy;

    public static ProxyCenter getInstance() {
        return ProxyCenter$a.a();
    }

    public static PushProxy getProxy() {
        return ProxyCenter.getInstance().proxy;
    }

    public static void register(PushProxy pushProxy) {
        ProxyCenter.getInstance().proxy = pushProxy;
    }
}

