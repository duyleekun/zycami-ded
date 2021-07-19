/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaFormat
 */
package com.tencent.liteav.muxer;

import android.content.Context;
import android.media.MediaFormat;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.muxer.a;

public class c
implements a {
    private int a = 0;
    private a b;

    public c(Context object, int n10) {
        String string2 = "TXCMP4Muxer: use sw model ";
        String string3 = "TXCMP4Muxer";
        if (n10 != 0) {
            String string4 = "TXCMP4Muxer: use hw model ";
            int n11 = 1;
            if (n10 != n11) {
                boolean bl2 = c.a(object);
                if (bl2) {
                    this.a = 0;
                    this.b = object;
                    TXCLog.i(string3, string2);
                } else {
                    this.a = n11;
                    super();
                    this.b = object;
                    TXCLog.i(string3, string4);
                }
            } else {
                this.a = n11;
                super();
                this.b = object;
                TXCLog.i(string3, string4);
            }
        } else {
            this.a = 0;
            super();
            this.b = object;
            TXCLog.i(string3, string2);
        }
    }

    public static boolean a(Context object) {
        com.tencent.liteav.basic.c.c c10 = com.tencent.liteav.basic.c.c.a();
        c10.a((Context)object);
        object = com.tencent.liteav.basic.c.c.a();
        boolean bl2 = ((com.tencent.liteav.basic.c.c)object).f();
        boolean bl3 = true;
        if (bl2 != bl3) {
            bl3 = false;
            c10 = null;
        }
        return bl3;
    }

    public int a() {
        return this.b.a();
    }

    public void a(MediaFormat mediaFormat) {
        this.b.a(mediaFormat);
    }

    public void a(String string2) {
        this.b.a(string2);
    }

    public void a(byte[] byArray, int n10, int n11, long l10, int n12) {
        this.b.a(byArray, n10, n11, l10, n12);
    }

    public int b() {
        return this.b.b();
    }

    public void b(MediaFormat mediaFormat) {
        this.b.b(mediaFormat);
    }

    public void b(byte[] byArray, int n10, int n11, long l10, int n12) {
        this.b.b(byArray, n10, n11, l10, n12);
    }

    public boolean c() {
        return this.b.c();
    }
}

