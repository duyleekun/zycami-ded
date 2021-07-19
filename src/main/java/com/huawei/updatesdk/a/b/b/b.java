/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.huawei.updatesdk.a.b.b;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.updatesdk.a.a.a;

public final class b {
    private Intent a;

    private b(Intent intent) {
        this.a = intent;
    }

    public static b a(Intent intent) {
        b b10 = new b(intent);
        return b10;
    }

    public int a(String string2, int n10) {
        boolean bl2 = this.d();
        if (bl2) {
            Object object = this.a;
            try {
                return object.getIntExtra(string2, n10);
            }
            catch (Exception exception) {
                string2 = "SecureIntent";
                object = "getIntExtra exception!";
                com.huawei.updatesdk.a.a.a.a(string2, (String)object);
            }
        }
        return n10;
    }

    public String a() {
        String string2;
        boolean bl2 = this.d();
        String string3 = "";
        if (bl2 && (string2 = this.a.getAction()) != null) {
            string3 = string2;
        }
        return string3;
    }

    public String a(String string2) {
        boolean bl2 = this.d();
        if (bl2) {
            Object object = this.a;
            try {
                return object.getStringExtra(string2);
            }
            catch (Exception exception) {
                string2 = "SecureIntent";
                object = "getStringExtra exception!";
                com.huawei.updatesdk.a.a.a.a(string2, (String)object);
            }
        }
        return "";
    }

    public boolean a(String string2, boolean bl2) {
        boolean bl3 = this.d();
        if (bl3) {
            Object object = this.a;
            try {
                return object.getBooleanExtra(string2, bl2);
            }
            catch (Exception exception) {
                string2 = "SecureIntent";
                object = "getBooleanExtra exception!";
                com.huawei.updatesdk.a.a.a.a(string2, (String)object);
            }
        }
        return bl2;
    }

    public long b(String string2, int n10) {
        boolean bl2 = this.d();
        if (bl2) {
            Object object = this.a;
            long l10 = n10;
            try {
                return object.getLongExtra(string2, l10);
            }
            catch (Exception exception) {
                string2 = "SecureIntent";
                object = "getIntExtra exception!";
                com.huawei.updatesdk.a.a.a.a(string2, (String)object);
            }
        }
        return n10;
    }

    public Bundle b() {
        Bundle bundle;
        boolean bl2 = this.d();
        if (bl2) {
            bundle = this.a.getExtras();
        } else {
            bl2 = false;
            bundle = null;
        }
        return bundle;
    }

    public Intent c() {
        return this.a;
    }

    public boolean d() {
        boolean bl2;
        Intent intent = this.a;
        if (intent != null) {
            bl2 = true;
        } else {
            bl2 = false;
            intent = null;
        }
        return bl2;
    }
}

