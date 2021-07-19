/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.ab;
import com.xiaomi.push.ae;
import com.xiaomi.push.fs;
import com.xiaomi.push.fw;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ft
implements Cloneable {
    public static String a = "wcc-ml-test10.bj";
    public static final String b = ae.a;
    public static String c;
    private int a;
    private fw a;
    private boolean a;
    private boolean b;
    private String d;
    private String e;
    private String f;

    public ft(Map map, int n10, String string2, fw fw2) {
        boolean bl2;
        this.a = bl2 = fs.a;
        this.b = true;
        this.a(map, n10, string2, fw2);
    }

    public static final String a() {
        String string2 = c;
        if (string2 != null) {
            return string2;
        }
        boolean bl2 = ab.a();
        if (bl2) {
            return "sandbox.xmpush.xiaomi.com";
        }
        bl2 = ab.b();
        if (bl2) {
            return b;
        }
        return "app.chat.xiaomi.net";
    }

    public static final void a(String string2) {
        c = string2;
    }

    private void a(Map map, int n10, String string2, fw fw2) {
        this.a = n10;
        this.d = string2;
        this.a = fw2;
    }

    public int a() {
        return this.a;
    }

    public void a(boolean bl2) {
        this.a = bl2;
    }

    public boolean a() {
        return this.a;
    }

    public byte[] a() {
        return null;
    }

    public String b() {
        return this.f;
    }

    public void b(String string2) {
        this.f = string2;
    }

    public String c() {
        String string2 = this.e;
        if (string2 == null) {
            this.e = string2 = ft.a();
        }
        return this.e;
    }

    public void c(String string2) {
        this.e = string2;
    }
}

