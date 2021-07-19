/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 */
package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;
import com.huawei.hms.base.log.b;
import com.huawei.hms.base.log.c;
import com.huawei.hms.base.log.d;

public class a {
    public static final b c;
    public int a = 4;
    public String b;

    static {
        d d10 = new d();
        c = d10;
    }

    public final c a(int n10, String string2, String string3, Throwable throwable) {
        String string4 = this.b;
        c c10 = new c(8, string4, n10, string2);
        c10.a(string3);
        c10.a(throwable);
        return c10;
    }

    public void a(int n10, String string2, String string3) {
        boolean bl2 = this.a(n10);
        if (bl2) {
            bl2 = false;
            Object object = this.a(n10, string2, string3, null);
            Object object2 = new StringBuilder();
            String string4 = ((c)object).c();
            ((StringBuilder)object2).append(string4);
            object = ((c)object).a();
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            object2 = c;
            object2.a((String)object, n10, string2, string3);
        }
    }

    public void a(Context context, int n10, String string2) {
        this.a = n10;
        this.b = string2;
        c.a(context, "HMSCore");
    }

    public void a(String string2, String string3) {
        int n10 = 4;
        Object object = this.a(n10, string2, string3, null);
        StringBuilder stringBuilder = new StringBuilder();
        String string4 = ((c)object).c();
        stringBuilder.append(string4);
        stringBuilder.append('\n');
        object = ((c)object).a();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        c.a((String)object, n10, string2, string3);
    }

    public boolean a(int n10) {
        int n11 = this.a;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    public void b(int n10, String string2, String string3, Throwable throwable) {
        boolean bl2 = this.a(n10);
        if (bl2) {
            Object object = this.a(n10, string2, string3, throwable);
            Object object2 = new StringBuilder();
            CharSequence charSequence = ((c)object).c();
            ((StringBuilder)object2).append((String)charSequence);
            object = ((c)object).a();
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            object2 = c;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string3);
            char c10 = '\n';
            ((StringBuilder)charSequence).append(c10);
            string3 = Log.getStackTraceString((Throwable)throwable);
            ((StringBuilder)charSequence).append(string3);
            string3 = ((StringBuilder)charSequence).toString();
            object2.a((String)object, n10, string2, string3);
        }
    }
}

