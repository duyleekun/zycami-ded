/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.tencent.liteav.beauty;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.a.a.c;
import com.tencent.liteav.beauty.b.a;
import com.tencent.liteav.beauty.b.m;
import com.tencent.liteav.beauty.d$b;

public class c$a
extends Handler {
    public final /* synthetic */ com.tencent.liteav.beauty.c a;
    private String b;

    public c$a(com.tencent.liteav.beauty.c c10, Looper looper, Context context) {
        this.a = c10;
        super(looper);
        this.b = "EGLDrawThreadHandler";
    }

    private void a(Object object) {
        TXCLog.i(this.b, "come into InitEGL");
        object = (d$b)object;
        this.a();
        com.tencent.liteav.beauty.c c10 = this.a;
        Object object2 = new com.tencent.liteav.beauty.a.a.a();
        com.tencent.liteav.beauty.c.a(c10, (com.tencent.liteav.beauty.a.a.a)object2);
        c10 = this.a;
        com.tencent.liteav.beauty.a.a.a a10 = com.tencent.liteav.beauty.c.m(c10);
        int n10 = ((d$b)object).g;
        int n11 = ((d$b)object).f;
        object2 = new c(a10, n10, n11, false);
        com.tencent.liteav.beauty.c.a(c10, (c)object2);
        com.tencent.liteav.beauty.c.n(this.a).b();
        c10 = this.a;
        boolean bl2 = com.tencent.liteav.beauty.c.a(c10, (d$b)object);
        if (!bl2) {
            TXCLog.e(this.b, "initInternal failed!");
            return;
        }
        TXCLog.i(this.b, "come out InitEGL");
    }

    public void a() {
        TXCLog.i(this.b, "come into releaseEGL");
        com.tencent.liteav.beauty.c.o(this.a);
        Object object = com.tencent.liteav.beauty.c.n(this.a);
        if (object != null) {
            com.tencent.liteav.beauty.c.n(this.a).c();
            object = this.a;
            com.tencent.liteav.beauty.c.a((com.tencent.liteav.beauty.c)((Object)object), null);
        }
        if ((object = com.tencent.liteav.beauty.c.m(this.a)) != null) {
            com.tencent.liteav.beauty.c.m(this.a).a();
            object = this.a;
            com.tencent.liteav.beauty.c.a((com.tencent.liteav.beauty.c)((Object)object), null);
        }
        com.tencent.liteav.beauty.c.b(this.a, false);
        NativeLoad.nativeDeleteYuv2Yuv();
        TXCLog.i(this.b, "come out releaseEGL");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        synchronized (this) {
            Throwable throwable2;
            block5: {
                try {
                    ((Object)((Object)this)).wait();
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                catch (InterruptedException interruptedException) {}
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void handleMessage(Message object) {
        int n10;
        int n11;
        block13: {
            float f10;
            block12: {
                block7: {
                    float f11;
                    block11: {
                        block8: {
                            block9: {
                                block10: {
                                    super.handleMessage((Message)object);
                                    int n12 = ((Message)object).what;
                                    n11 = 1;
                                    f10 = Float.MIN_VALUE;
                                    if (n12 == 0) break block7;
                                    if (n12 == n11) break block8;
                                    int n13 = 2;
                                    if (n12 == n13) break block9;
                                    n13 = 3;
                                    if (n12 == n13) break block10;
                                    n13 = 4;
                                    if (n12 != n13) {
                                        n13 = 5;
                                        if (n12 == n13) {
                                            object = (d$b)((Message)object).obj;
                                            com.tencent.liteav.beauty.c c10 = this.a;
                                            com.tencent.liteav.beauty.c.b(c10, (d$b)object);
                                        }
                                        break block11;
                                    } else {
                                        com.tencent.liteav.beauty.c c11 = this.a;
                                        n10 = ((Message)object).arg1;
                                        double d10 = n10;
                                        double d11 = 100.0;
                                        f11 = (float)(d10 /= d11);
                                        com.tencent.liteav.beauty.c.a(c11, f11);
                                        object = com.tencent.liteav.beauty.c.a(this.a);
                                        if (object != null) {
                                            object = com.tencent.liteav.beauty.c.a(this.a);
                                            c11 = this.a;
                                            float f12 = com.tencent.liteav.beauty.c.q(c11);
                                            ((m)object).a(f12);
                                        }
                                    }
                                    break block11;
                                }
                                com.tencent.liteav.beauty.c c12 = this.a;
                                n10 = ((Message)object).arg1;
                                com.tencent.liteav.beauty.c.b(c12, n10);
                                break block12;
                            }
                            com.tencent.liteav.beauty.c c13 = this.a;
                            object = (byte[])((Message)object).obj;
                            com.tencent.liteav.beauty.c.a(c13, (byte[])object);
                            break block11;
                        }
                        this.a();
                        object = com.tencent.liteav.beauty.c.p(this.a);
                        ((a)object).a();
                    }
                    n10 = 0;
                    f11 = 0.0f;
                    object = null;
                    break block13;
                }
                object = ((Message)object).obj;
                this.a(object);
                object = this.a;
                com.tencent.liteav.beauty.c.b((com.tencent.liteav.beauty.c)((Object)object), n11 != 0);
            }
            n10 = n11;
            float f13 = f10;
        }
        synchronized (this) {
            if (n11 == n10) {
                ((Object)((Object)this)).notify();
            }
            return;
        }
    }
}

