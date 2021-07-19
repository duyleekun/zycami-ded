/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.bf;
import com.xiaomi.push.ed;
import com.xiaomi.push.ho;
import com.xiaomi.push.l;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ee
extends ed {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;

    public ee(Context context, int n10, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        super(context, n10);
        this.a = bl2;
        this.b = bl3;
        boolean bl6 = l.d();
        if (bl6) {
            bl6 = false;
            context = null;
            this.b = false;
        }
        this.c = bl4;
        this.d = bl5;
    }

    private String a(Context context) {
        boolean bl2 = this.d;
        if (!bl2) {
            return "off";
        }
        return "";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private String b() {
        String string2;
        block10: {
            String string3;
            string2 = "";
            boolean bl2 = this.a;
            if (!bl2) {
                return "off";
            }
            try {
                string3 = this.c();
            }
            catch (Throwable throwable) {
                return string2;
            }
            boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
            if (bl3) break block10;
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = bf.a(string3);
            stringBuilder.append(string4);
            string4 = ",";
            stringBuilder.append(string4);
            string3 = bf.b(string3);
            stringBuilder.append(string3);
            return stringBuilder.toString();
        }
        return string2;
    }

    private String c() {
        return "";
    }

    private String d() {
        boolean bl2 = this.b;
        if (!bl2) {
            return "off";
        }
        return "";
    }

    private String e() {
        boolean bl2 = this.c;
        if (!bl2) {
            return "off";
        }
        return "";
    }

    public int a() {
        return 13;
    }

    public ho a() {
        return ho.t;
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.b();
        stringBuilder.append(string2);
        string2 = "|";
        stringBuilder.append(string2);
        String string3 = this.d();
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string3 = this.e();
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string2 = ((ed)this).a;
        string2 = this.a((Context)string2);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

