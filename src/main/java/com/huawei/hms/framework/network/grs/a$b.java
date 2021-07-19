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
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.b.b;
import com.huawei.hms.framework.network.grs.c.f;

public class a$b
implements com.huawei.hms.framework.network.grs.b {
    public String a;
    public String b;
    public IQueryUrlCallBack c;
    public String d;
    public Context e;
    public GrsBaseInfo f;
    public a g;

    public a$b(String string2, String string3, IQueryUrlCallBack iQueryUrlCallBack, String string4, Context context, GrsBaseInfo grsBaseInfo, a a10) {
        this.a = string2;
        this.b = string3;
        this.c = iQueryUrlCallBack;
        this.d = string4;
        this.e = context;
        this.f = grsBaseInfo;
        this.g = a10;
    }

    public void a() {
        Object object = this.d;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            object = this.c;
            String string2 = this.d;
            object.onCallBackSuccess(string2);
        } else {
            object = this.d;
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) {
                Logger.i(com.huawei.hms.framework.network.grs.a.a(), "access local config for return a domain.");
                object = this.e.getPackageName();
                Object object2 = this.f;
                b b10 = com.huawei.hms.framework.network.grs.b.b.a((String)object, (GrsBaseInfo)object2);
                Context context = this.e;
                a a10 = this.g;
                GrsBaseInfo grsBaseInfo = this.f;
                String string3 = this.a;
                String string4 = this.b;
                boolean bl3 = true;
                object = b10.a(context, a10, grsBaseInfo, string3, string4, bl3);
                object2 = this.c;
                object2.onCallBackSuccess((String)object);
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
        Object object3 = this.b;
        int n10 = TextUtils.isEmpty((CharSequence)(object = com.huawei.hms.framework.network.grs.a.a((String)object, (String)object2, (String)object3)));
        if (n10 != 0) {
            object = this.d;
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (!bl2) {
                object = this.c;
                object2 = this.d;
                object.onCallBackSuccess((String)object2);
                return;
            }
            object = this.d;
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (!bl2) {
                object = this.c;
                n10 = -5;
                object.onCallBackFail(n10);
                return;
            }
            Logger.i(com.huawei.hms.framework.network.grs.a.a(), "access local config for return a domain.");
            object = this.e.getPackageName();
            object2 = this.f;
            object3 = com.huawei.hms.framework.network.grs.b.b.a((String)object, (GrsBaseInfo)object2);
            Context context = this.e;
            a a10 = this.g;
            GrsBaseInfo grsBaseInfo = this.f;
            String string2 = this.a;
            String string3 = this.b;
            boolean bl3 = true;
            object = ((b)object3).a(context, a10, grsBaseInfo, string2, string3, bl3);
        }
        object2 = this.c;
        object2.onCallBackSuccess((String)object);
    }
}

