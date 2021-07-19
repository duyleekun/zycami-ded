/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.f0$a;
import com.huawei.hms.hatool.y;

public class f0 {
    public long a = 1800000L;
    public volatile boolean b = false;
    public f0$a c = null;

    public static /* synthetic */ boolean a(f0 f02) {
        return f02.b;
    }

    public static /* synthetic */ boolean a(f0 f02, boolean bl2) {
        f02.b = bl2;
        return bl2;
    }

    public static /* synthetic */ long b(f0 f02) {
        return f02.a;
    }

    public String a() {
        f0$a f0$a = this.c;
        if (f0$a == null) {
            y.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
            return "";
        }
        return f0$a.a;
    }

    public void a(long l10) {
        f0$a f0$a = this.c;
        if (f0$a == null) {
            y.c("hmsSdk", "Session is first flush");
            this.c = f0$a = new f0$a(this, l10);
            return;
        }
        f0$a.a(l10);
    }

    public boolean b() {
        f0$a f0$a = this.c;
        if (f0$a == null) {
            y.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
            return false;
        }
        return f0$a.b;
    }
}

