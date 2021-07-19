/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.ai$a;
import com.xiaomi.push.bq;
import com.xiaomi.push.bt;
import com.xiaomi.push.by;
import com.xiaomi.push.cb;
import com.xiaomi.push.cb$a;
import com.xiaomi.push.ce;
import com.xiaomi.push.cf;
import com.xiaomi.push.cg;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import com.xiaomi.push.r;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.bi;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bp {
    private static volatile bp a;
    private Context a;
    private ai$a a;
    private ce a;
    private cf a;
    private final String a;
    private ai$a b;
    private final String b;
    private ai$a c;
    private final String c;
    private final String d;
    private String e;
    private String f;

    private bp(Context context) {
        this.a = "push_stat_sp";
        this.b = "upload_time";
        this.c = "delete_time";
        this.d = "check_time";
        ai$a ai$a = new bq(this);
        this.a = ai$a;
        super(this);
        this.b = ai$a;
        super(this);
        this.c = ai$a;
        this.a = context;
    }

    public static /* synthetic */ Context a(bp bp2) {
        return bp2.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static bp a(Context context) {
        Object object = a;
        if (object != null) return a;
        object = bp.class;
        synchronized (object) {
            bp bp2 = a;
            if (bp2 != null) return a;
            a = bp2 = new bp(context);
            return a;
        }
    }

    public static /* synthetic */ cf a(bp bp2) {
        return bp2.a;
    }

    public static /* synthetic */ String a(bp bp2) {
        return bp2.c();
    }

    public static /* synthetic */ void a(bp bp2, String string2) {
        bp2.b(string2);
    }

    private boolean a() {
        ak ak2 = ak.a(this.a);
        int n10 = hr.bc.a();
        return ak2.a(n10, true);
    }

    private void b(String string2) {
        SharedPreferences.Editor editor = this.a.getSharedPreferences("push_stat_sp", 0).edit();
        long l10 = System.currentTimeMillis();
        editor.putLong(string2, l10);
        r.a(editor);
    }

    private String c() {
        Context context = this.a;
        String string2 = bt.a;
        return context.getDatabasePath(string2).getAbsolutePath();
    }

    public String a() {
        return this.e;
    }

    public void a(cb$a cb$a) {
        cb.a(this.a).a(cb$a);
    }

    public void a(hq object) {
        boolean bl2 = this.a();
        if (!bl2) {
            return;
        }
        String string2 = ((hq)object).e();
        bl2 = bi.a(string2);
        if (!bl2) {
            return;
        }
        string2 = this.c();
        object = by.a(this.a, string2, (hq)object);
        this.a((cb$a)object);
    }

    public void a(String object) {
        boolean bl2 = this.a();
        if (!bl2) {
            return;
        }
        bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return;
        }
        object = cg.a(this.a, (String)object);
        this.a((hq)object);
    }

    public void a(String string2, String string3, Boolean object) {
        ce ce2 = this.a;
        if (ce2 != null) {
            boolean bl2 = (Boolean)object;
            if (bl2) {
                object = this.a;
                ce2 = this.a;
                object.a((Context)ce2, string3, string2);
            } else {
                object = this.a;
                ce2 = this.a;
                object.b((Context)ce2, string3, string2);
            }
        }
    }

    public String b() {
        return this.f;
    }
}

