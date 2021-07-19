/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.ai;
import com.xiaomi.push.r;
import com.xiaomi.push.service.af;
import com.xiaomi.push.service.bg$a;
import com.xiaomi.push.service.bh;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bg
implements af {
    private static volatile bg a;
    private long a;
    public Context a;
    private SharedPreferences a;
    private ConcurrentHashMap a;
    private volatile boolean a = false;

    private bg(Context context) {
        Context context2;
        this.a = context2 = new ConcurrentHashMap();
        this.a = context2 = context.getApplicationContext();
        context = context.getSharedPreferences("sync", 0);
        this.a = context;
    }

    public static /* synthetic */ SharedPreferences a(bg bg2) {
        return bg2.a;
    }

    public static /* synthetic */ bg a() {
        return a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static bg a(Context context) {
        Object object = a;
        if (object != null) return a;
        object = bg.class;
        synchronized (object) {
            bg bg2 = a;
            if (bg2 != null) return a;
            a = bg2 = new bg(context);
            return a;
        }
    }

    public static /* synthetic */ ConcurrentHashMap a(bg bg2) {
        return bg2.a;
    }

    public static /* synthetic */ boolean a(bg bg2, boolean bl2) {
        bg2.a = bl2;
        return bl2;
    }

    public String a(String string2, String string3) {
        SharedPreferences sharedPreferences = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(":");
        stringBuilder.append(string3);
        string2 = stringBuilder.toString();
        return sharedPreferences.getString(string2, "");
    }

    public void a() {
        int n10 = this.a;
        if (n10 != 0) {
            return;
        }
        long l10 = System.currentTimeMillis();
        long l11 = this.a;
        long l12 = 3600000L;
        long l13 = (l11 = l10 - l11) - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object < 0) {
            return;
        }
        this.a = l10;
        this.a = true;
        n10 = (int)(Math.random() * 10.0);
        ai ai2 = ai.a(this.a);
        bh bh2 = new bh(this);
        ai2.a(bh2, n10);
    }

    public void a(bg$a bg$a) {
        Object object = this.a;
        Object object2 = bg$a.a;
        if ((object = ((ConcurrentHashMap)object).putIfAbsent(object2, bg$a)) == null) {
            double d10 = Math.random();
            double d11 = 30.0;
            int n10 = (int)(d10 *= d11) + 10;
            object2 = ai.a(this.a);
            ((ai)object2).a(bg$a, n10);
        }
    }

    public void a(String string2, String string3, String string4) {
        SharedPreferences.Editor editor = bg.a.a.edit();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(":");
        stringBuilder.append(string3);
        string2 = stringBuilder.toString();
        r.a(editor.putString(string2, string4));
    }
}

