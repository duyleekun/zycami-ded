/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.availableupdate;

import android.content.Context;
import com.huawei.hms.availableupdate.a;
import com.huawei.hms.availableupdate.b;
import com.huawei.hms.availableupdate.d;
import java.io.File;

public class d$a
extends b {
    public long b;
    public int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ String e;
    public final /* synthetic */ d f;

    public d$a(d d10, File file, int n10, int n11, String string2) {
        int n12;
        this.f = d10;
        this.d = n11;
        this.e = string2;
        super(file, n10);
        this.b = 0L;
        this.c = n12 = com.huawei.hms.availableupdate.d.a(d10).a();
    }

    public final void a(int n10) {
        Object object = com.huawei.hms.availableupdate.d.a(this.f);
        Context context = this.f.b();
        String string2 = this.e;
        ((a)object).a(context, n10, string2);
        object = this.f;
        int n11 = this.d;
        com.huawei.hms.availableupdate.d.a((d)object, 2100, n10, n11);
    }

    public void write(byte[] byArray, int n10, int n11) {
        long l10;
        int n12;
        super.write(byArray, n10, n11);
        this.c = n12 = this.c + n11;
        n10 = 0xC800000;
        if (n12 > n10) {
            return;
        }
        long l11 = System.currentTimeMillis();
        long l12 = this.b;
        long l13 = (l12 = Math.abs(l11 - l12)) - (l10 = 1000L);
        n11 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
        if (n11 > 0) {
            this.b = l11;
            n12 = this.c;
            this.a(n12);
        }
        if ((n12 = this.c) == (n10 = this.d)) {
            this.a(n12);
        }
    }
}

