/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.framework.network.grs.IQueryUrlsCallBack;
import com.huawei.hms.framework.network.grs.d;
import com.huawei.hms.framework.network.grs.e;
import java.util.Map;

public class GrsClient {
    private d grsClientGlobal;

    public GrsClient(Context object, GrsBaseInfo grsBaseInfo) {
        if (object != null && grsBaseInfo != null) {
            object = e.a(grsBaseInfo, object);
            this.grsClientGlobal = object;
            return;
        }
        super("invalid init params for context is null or GrsBaseInfo instance is null Object.");
        throw object;
    }

    public void ayncGetGrsUrl(String string2, String string3, IQueryUrlCallBack iQueryUrlCallBack) {
        this.grsClientGlobal.a(string2, string3, iQueryUrlCallBack);
    }

    public void ayncGetGrsUrls(String string2, IQueryUrlsCallBack iQueryUrlsCallBack) {
        this.grsClientGlobal.a(string2, iQueryUrlsCallBack);
    }

    public void clearSp() {
        this.grsClientGlobal.b();
    }

    public boolean forceExpire() {
        return this.grsClientGlobal.c();
    }

    public String synGetGrsUrl(String string2, String string3) {
        return this.grsClientGlobal.a(string2, string3);
    }

    public Map synGetGrsUrls(String string2) {
        return this.grsClientGlobal.a(string2);
    }
}

