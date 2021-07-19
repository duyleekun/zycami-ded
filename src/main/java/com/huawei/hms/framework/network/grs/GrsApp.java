/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.network.grs.a;

public class GrsApp {
    private static GrsApp instance;
    private String appConfigName;

    static {
        GrsApp grsApp;
        instance = grsApp = new GrsApp();
    }

    private GrsApp() {
    }

    public static GrsApp getInstance() {
        return instance;
    }

    public String getAppConfigName() {
        return this.appConfigName;
    }

    public String getIssueCountryCode(Context context) {
        return a.a(context, false).getCountryCode();
    }

    public void setAppConfigName(String string2) {
        this.appConfigName = string2;
    }
}

