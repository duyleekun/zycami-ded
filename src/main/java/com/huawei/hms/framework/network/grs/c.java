/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.b.b;
import com.huawei.hms.framework.network.grs.c.m;
import com.huawei.hms.framework.network.grs.c.n;
import com.huawei.hms.framework.network.grs.d;
import java.util.Map;
import java.util.concurrent.Callable;

public class c
implements Callable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ GrsBaseInfo b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ d d;

    public c(d d10, Context context, GrsBaseInfo grsBaseInfo, Context context2) {
        this.d = d10;
        this.a = context;
        this.b = grsBaseInfo;
        this.c = context2;
    }

    public Boolean call() {
        Object object = this.d;
        Object object2 = new m();
        com.huawei.hms.framework.network.grs.d.a((d)object, (m)object2);
        object = this.d;
        Object object3 = this.a;
        object2 = new com.huawei.hms.framework.network.grs.a.c((Context)object3, "share_pre_grs_conf_");
        com.huawei.hms.framework.network.grs.d.a((d)object, (com.huawei.hms.framework.network.grs.a.c)object2);
        object = this.d;
        object3 = this.a;
        object2 = new com.huawei.hms.framework.network.grs.a.c((Context)object3, "share_pre_grs_services_");
        com.huawei.hms.framework.network.grs.d.b((d)object, (com.huawei.hms.framework.network.grs.a.c)object2);
        object = this.d;
        object3 = com.huawei.hms.framework.network.grs.d.b((d)object);
        Object object4 = com.huawei.hms.framework.network.grs.d.c(this.d);
        Object object5 = com.huawei.hms.framework.network.grs.d.a(this.d);
        object2 = new a((com.huawei.hms.framework.network.grs.a.c)object3, (com.huawei.hms.framework.network.grs.a.c)object4, (m)object5);
        com.huawei.hms.framework.network.grs.d.a((d)object, (a)object2);
        object = this.d;
        object3 = com.huawei.hms.framework.network.grs.d.e((d)object);
        object4 = com.huawei.hms.framework.network.grs.d.d(this.d);
        object5 = com.huawei.hms.framework.network.grs.d.a(this.d);
        Object object6 = com.huawei.hms.framework.network.grs.d.c(this.d);
        object2 = new com.huawei.hms.framework.network.grs.a((GrsBaseInfo)object3, (a)object4, (m)object5, (com.huawei.hms.framework.network.grs.a.c)object6);
        com.huawei.hms.framework.network.grs.d.a((d)object, (com.huawei.hms.framework.network.grs.a)object2);
        object2 = this.a;
        object3 = this.b;
        boolean bl2 = true;
        object = new b((Context)object2, (GrsBaseInfo)object3, bl2);
        object2 = this.b;
        ((b)object).a((GrsBaseInfo)object2);
        object2 = this.b;
        object3 = this.a;
        object = new com.huawei.hms.framework.network.grs.c.b.c((GrsBaseInfo)object2, (Context)object3);
        object = ((com.huawei.hms.framework.network.grs.c.b.c)object).c();
        object2 = com.huawei.hms.framework.network.grs.d.a();
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("scan serviceSet is:");
        ((StringBuilder)object3).append((String)object);
        object3 = ((StringBuilder)object3).toString();
        Logger.v((String)object2, object3);
        object2 = com.huawei.hms.framework.network.grs.d.c(this.d);
        object3 = "services";
        object5 = "";
        object2 = ((com.huawei.hms.framework.network.grs.a.c)object2).a((String)object3, (String)object5);
        object = n.a((String)object2, (String)object);
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (!bl3) {
            com.huawei.hms.framework.network.grs.d.c(this.d).b((String)object3, (String)object);
            object3 = com.huawei.hms.framework.network.grs.d.a();
            object5 = new StringBuilder();
            ((StringBuilder)object5).append("postList is:");
            ((StringBuilder)object5).append((String)object);
            object6 = " currentServices:";
            ((StringBuilder)object5).append((String)object6);
            ((StringBuilder)object5).append((String)object2);
            object5 = ((StringBuilder)object5).toString();
            Logger.v((String)object3, object5);
            boolean bl4 = ((String)object).equals(object2);
            if (!bl4) {
                object = com.huawei.hms.framework.network.grs.d.e(this.d);
                object2 = this.a;
                object = ((GrsBaseInfo)object).getGrsParasKey(false, bl2, (Context)object2);
                com.huawei.hms.framework.network.grs.d.a(this.d).a((String)object);
                object = com.huawei.hms.framework.network.grs.d.a(this.d);
                object3 = this.b;
                object5 = this.c;
                object2 = new com.huawei.hms.framework.network.grs.c.b.c((GrsBaseInfo)object3, (Context)object5);
                object3 = com.huawei.hms.framework.network.grs.d.c(this.d);
                bl3 = false;
                object5 = null;
                ((m)object).a((com.huawei.hms.framework.network.grs.c.b.c)object2, null, null, (com.huawei.hms.framework.network.grs.a.c)object3);
            }
        }
        object = this.d;
        object2 = com.huawei.hms.framework.network.grs.d.b((d)object).a();
        com.huawei.hms.framework.network.grs.d.a((d)object, (Map)object2);
        object = com.huawei.hms.framework.network.grs.d.d(this.d);
        object2 = this.b;
        object3 = this.a;
        ((a)object).b((GrsBaseInfo)object2, (Context)object3);
        return com.huawei.hms.framework.network.grs.d.a(this.d, bl2);
    }
}

