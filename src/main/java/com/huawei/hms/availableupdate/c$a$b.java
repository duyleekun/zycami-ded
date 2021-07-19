/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.availableupdate;

import com.huawei.hms.availableupdate.c$a;
import com.huawei.hms.availableupdate.f;
import java.io.File;

public class c$a$b
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ File d;
    public final /* synthetic */ c$a e;

    public c$a$b(c$a c$a, int n10, int n11, int n12, File file) {
        this.e = c$a;
        this.a = n10;
        this.b = n11;
        this.c = n12;
        this.d = file;
    }

    public void run() {
        f f10 = this.e.a;
        int n10 = this.a;
        int n11 = this.b;
        int n12 = this.c;
        File file = this.d;
        f10.a(n10, n11, n12, file);
    }
}

