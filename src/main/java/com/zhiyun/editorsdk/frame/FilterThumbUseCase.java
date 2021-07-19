/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.text.TextUtils
 */
package com.zhiyun.editorsdk.frame;

import android.graphics.Bitmap;
import android.text.TextUtils;
import d.v.e.l.h2;
import d.v.h.g.a;
import d.v.h.g.a$a;
import d.v.v.i.b;
import java.util.List;

public class FilterThumbUseCase {
    private a a;

    public FilterThumbUseCase(String string2) {
        b b10 = new b();
        this.a = b10;
        float f10 = 74.0f;
        int n10 = h2.b(f10) / 4 * 4;
        int n11 = h2.b(f10) / 2 * 2;
        b10.c(string2, n10, n11);
    }

    /*
     * WARNING - void declaration
     */
    public Bitmap a(String object, String string2) {
        void var3_8;
        boolean n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10) {
            boolean bl2 = false;
            Object var4_9 = null;
        } else {
            String string3 = ".png";
            boolean bl3 = ((String)object).endsWith(string3);
            if (bl3) {
                int n11 = 2;
            } else {
                boolean bl4 = true;
            }
        }
        d.v.h.f.a a10 = new d.v.h.f.a();
        object = a10.w(string2).x((String)object).y(100).u(0).z((int)var3_8);
        return this.a.e(object);
    }

    public void b(List list, a.a a10) {
        this.a.d(list, a10);
    }

    public void c() {
        this.a.release();
    }
}

