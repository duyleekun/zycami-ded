/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.b.a;
import com.huawei.hms.framework.network.grs.b.c;
import com.huawei.hms.framework.network.grs.b.d;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class b {
    private static Map a;
    private a b;

    static {
        ConcurrentHashMap concurrentHashMap;
        a = concurrentHashMap = new ConcurrentHashMap(16);
    }

    public b(Context object, GrsBaseInfo grsBaseInfo, boolean bl2) {
        this.a((Context)object, bl2);
        Map map = a;
        StringBuilder stringBuilder = new StringBuilder();
        object = object.getPackageName();
        stringBuilder.append((String)object);
        int n10 = grsBaseInfo.uniqueCode();
        stringBuilder.append(n10);
        object = stringBuilder.toString();
        map.put(object, this);
    }

    public static b a(String string2, GrsBaseInfo grsBaseInfo) {
        Map map = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        int n10 = grsBaseInfo.uniqueCode();
        stringBuilder.append(n10);
        string2 = stringBuilder.toString();
        return (b)map.get(string2);
    }

    public static void a(Context object, GrsBaseInfo object2) {
        if ((object = com.huawei.hms.framework.network.grs.b.b.a(object.getPackageName(), (GrsBaseInfo)object2)) != null && (object = ((b)object).a()) != null) {
            object2 = "LocalManagerProxy";
            String string2 = "appGrs is not null and clear services.";
            Logger.i((String)object2, string2);
            ((com.huawei.hms.framework.network.grs.local.model.a)object).a();
        }
    }

    public com.huawei.hms.framework.network.grs.local.model.a a() {
        return this.b.a();
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.a.a a10, GrsBaseInfo grsBaseInfo, String string2, String string3, boolean bl2) {
        return this.b.a(context, a10, grsBaseInfo, string2, string3, bl2);
    }

    public Map a(Context context, com.huawei.hms.framework.network.grs.a.a a10, GrsBaseInfo grsBaseInfo, String string2, boolean bl2) {
        return this.b.a(context, a10, grsBaseInfo, string2, bl2);
    }

    public void a(Context context, boolean bl2) {
        a a10 = new d(context, bl2);
        this.b = a10;
        boolean bl3 = a10.c();
        if (!bl3) {
            a10 = new c(context, bl2);
            this.b = a10;
        }
    }

    public void a(GrsBaseInfo grsBaseInfo) {
        this.b.a(grsBaseInfo);
    }

    public Set b() {
        return this.b.b();
    }
}

