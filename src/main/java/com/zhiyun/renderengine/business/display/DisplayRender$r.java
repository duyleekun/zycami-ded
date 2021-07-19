/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.renderengine.business.display;

import com.zhiyun.renderengine.business.display.DisplayRender;
import com.zhiyun.renderengine.business.display.DisplayRender$i;

public class DisplayRender$r {
    private long a;
    private long b;
    public boolean c;
    public long d;
    public final /* synthetic */ DisplayRender e;

    private DisplayRender$r(DisplayRender displayRender) {
        long l10;
        this.e = displayRender;
        this.a = l10 = (long)-1;
        this.b = l10;
        this.c = false;
        this.d = 0L;
    }

    public /* synthetic */ DisplayRender$r(DisplayRender displayRender, DisplayRender$i displayRender$i) {
        this(displayRender);
    }

    public float a() {
        float f10 = (float)this.b * 1.0f;
        long l10 = System.currentTimeMillis();
        long l11 = this.a;
        float f11 = l10 - l11;
        return f10 / f11 * 1000.0f;
    }

    public void b() {
        long l10;
        this.a = l10 = (long)-1;
        this.b = l10;
    }

    public void c() {
        long l10;
        long l11 = this.a;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object < 0) {
            this.a = l11 = System.currentTimeMillis();
        }
        if ((object = (l10 = (l11 = this.b) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1)) < 0) {
            this.b = l12;
        }
        this.b = l11 = this.b + 1L;
    }
}

