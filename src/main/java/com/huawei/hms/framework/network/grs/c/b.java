/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 */
package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.a.c;
import com.huawei.hms.framework.network.grs.c.a;
import com.huawei.hms.framework.network.grs.c.b$a;
import com.huawei.hms.framework.network.grs.c.f;
import com.huawei.hms.framework.network.grs.c.i;
import com.huawei.hms.framework.network.grs.c.j;
import java.util.concurrent.Callable;

public class b {
    public f a;
    private String b;
    private a c;
    private int d;
    private Context e;
    private String f;
    private GrsBaseInfo g;
    private c h;

    public b(String string2, int n10, a a10, Context context, String string3, GrsBaseInfo grsBaseInfo, c c10) {
        this.b = string2;
        this.c = a10;
        this.d = n10;
        this.e = context;
        this.f = string3;
        this.g = grsBaseInfo;
        this.h = c10;
    }

    private String a(String string2) {
        return Uri.parse((String)string2).getPath();
    }

    private b$a h() {
        String string2;
        String string3 = this.b;
        boolean bl2 = string3.isEmpty();
        if (bl2) {
            return b$a.c;
        }
        string3 = this.b;
        boolean bl3 = (string3 = this.a(string3)).contains(string2 = "1.0");
        if (bl3) {
            return b$a.b;
        }
        string2 = "2.0";
        bl2 = string3.contains(string2);
        if (bl2) {
            return b$a.a;
        }
        return b$a.c;
    }

    public a a() {
        return this.c;
    }

    public Context b() {
        return this.e;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public String e() {
        return this.f;
    }

    public c f() {
        return this.h;
    }

    public Callable g() {
        Object object = b$a.c;
        Object object2 = this.h();
        boolean bl2 = object.equals(object2);
        if (bl2) {
            return null;
        }
        object = b$a.b;
        object2 = this.h();
        bl2 = object.equals(object2);
        if (bl2) {
            String string2 = this.b;
            int n10 = this.d;
            a a10 = this.c;
            Context context = this.e;
            String string3 = this.f;
            GrsBaseInfo grsBaseInfo = this.g;
            object2 = object;
            object = new i(string2, n10, a10, context, string3, grsBaseInfo);
            return object;
        }
        String string4 = this.b;
        int n11 = this.d;
        a a11 = this.c;
        Context context = this.e;
        String string5 = this.f;
        GrsBaseInfo grsBaseInfo = this.g;
        object2 = this.h;
        object = new j(string4, n11, a11, context, string5, grsBaseInfo, (c)object2);
        return object;
    }
}

