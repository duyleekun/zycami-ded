/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.opengl;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.f;

public class f$3
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;
    public final /* synthetic */ int g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ f j;

    public f$3(f f10, int n10, boolean bl2, int n11, int n12, int n13, int n14, int n15, boolean bl3, boolean bl4) {
        this.j = f10;
        this.a = n10;
        this.b = bl2;
        this.c = n11;
        this.d = n12;
        this.e = n13;
        this.f = n14;
        this.g = n15;
        this.h = bl3;
        this.i = bl4;
    }

    public void run() {
        f f10 = this.j;
        int n10 = this.a;
        boolean bl2 = this.b;
        int n11 = this.c;
        int n12 = this.d;
        int n13 = this.e;
        int n14 = this.f;
        int n15 = this.g;
        boolean bl3 = this.h;
        boolean bl4 = this.i;
        try {
            com.tencent.liteav.basic.opengl.f.a(f10, n10, bl2, n11, n12, n13, n14, n15, bl3, bl4);
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            String string2 = "surface-render: render texture error occurred!";
            charSequence.append(string2);
            String string3 = exception.getMessage();
            charSequence.append(string3);
            string3 = charSequence.toString();
            charSequence = "TXGLSurfaceRenderThread";
            TXCLog.e((String)charSequence, string3);
        }
    }
}

