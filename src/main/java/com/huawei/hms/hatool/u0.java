/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.UserManager
 */
package com.huawei.hms.hatool;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import com.huawei.hms.hatool.b;

public class u0 {
    public static u0 c;
    public boolean a = false;
    public Context b;

    static {
        u0 u02;
        c = u02 = new u0();
    }

    public u0() {
        Context context;
        this.b = context = com.huawei.hms.hatool.b.f();
    }

    public static u0 b() {
        return c;
    }

    public boolean a() {
        block1: {
            boolean bl2;
            block4: {
                block2: {
                    block3: {
                        bl2 = this.a;
                        if (bl2) break block1;
                        Context context = this.b;
                        if (context == null) {
                            return false;
                        }
                        int n10 = Build.VERSION.SDK_INT;
                        int n11 = 24;
                        if (n10 < n11) break block2;
                        String string2 = "user";
                        if ((context = (UserManager)context.getSystemService(string2)) == null) break block3;
                        bl2 = context.isUserUnlocked();
                        break block4;
                    }
                    this.a = false;
                    break block1;
                }
                bl2 = true;
            }
            this.a = bl2;
        }
        return this.a;
    }
}

