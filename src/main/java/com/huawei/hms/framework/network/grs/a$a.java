/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.IQueryUrlsCallBack;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.b.b;
import com.huawei.hms.framework.network.grs.c.f;
import java.util.Map;

public class a$a
implements com.huawei.hms.framework.network.grs.b {
    public String a;
    public Map b;
    public IQueryUrlsCallBack c;
    public Context d;
    public GrsBaseInfo e;
    public a f;

    public a$a(String string2, Map map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, a a10) {
        this.a = string2;
        this.b = map;
        this.c = iQueryUrlsCallBack;
        this.d = context;
        this.e = grsBaseInfo;
        this.f = a10;
    }

    public void a() {
        boolean bl2;
        Object object = this.b;
        if (object != null && !(bl2 = object.isEmpty())) {
            object = this.c;
            Map map = this.b;
            object.onCallBackSuccess(map);
        } else {
            object = this.b;
            if (object == null) {
                Logger.i(com.huawei.hms.framework.network.grs.a.a(), "access local config for return a domain.");
                object = this.d.getPackageName();
                Object object2 = this.e;
                b b10 = com.huawei.hms.framework.network.grs.b.b.a((String)object, (GrsBaseInfo)object2);
                Context context = this.d;
                a a10 = this.f;
                GrsBaseInfo grsBaseInfo = this.e;
                String string2 = this.a;
                boolean bl3 = true;
                object = b10.a(context, a10, grsBaseInfo, string2, bl3);
                object2 = this.c;
                object2.onCallBackSuccess((Map)object);
            } else {
                object = this.c;
                int n10 = -3;
                object.onCallBackFail(n10);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(f object) {
        object = ((f)object).i();
        Object object2 = this.a;
        int n10 = (object = com.huawei.hms.framework.network.grs.a.a((String)object, (String)object2)).isEmpty();
        if (n10 != 0) {
            boolean bl2;
            object = this.b;
            if (object != null && !(bl2 = object.isEmpty())) {
                object = this.c;
                object2 = this.b;
                object.onCallBackSuccess((Map)object2);
                return;
            }
            object = this.b;
            if (object != null) {
                object = this.c;
                n10 = -5;
                object.onCallBackFail(n10);
                return;
            }
            Logger.i(com.huawei.hms.framework.network.grs.a.a(), "access local config for return a domain.");
            object = this.d.getPackageName();
            object2 = this.e;
            b b10 = com.huawei.hms.framework.network.grs.b.b.a((String)object, (GrsBaseInfo)object2);
            Context context = this.d;
            a a10 = this.f;
            GrsBaseInfo grsBaseInfo = this.e;
            String string2 = this.a;
            boolean bl3 = true;
            object = b10.a(context, a10, grsBaseInfo, string2, bl3);
        }
        object2 = this.c;
        object2.onCallBackSuccess((Map)object);
    }
}

