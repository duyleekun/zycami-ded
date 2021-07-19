/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 */
package com.tencent.liteav;

import android.graphics.SurfaceTexture;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.c;
import com.tencent.liteav.capturer.a;
import com.tencent.liteav.g;

public class c$2
implements Runnable {
    public final /* synthetic */ c a;

    public c$2(c c10) {
        this.a = c10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        String string2 = "CameraCapture";
        try {
            Object object = this.a;
            boolean bl2 = ((c)object).d();
            if (bl2 && (bl2 = c.b((c)(object = this.a)))) {
                object = this.a;
                object = c.c((c)object);
                if ((object = ((a)object).h()) == null) {
                    object = "camera monitor restart capture";
                    TXCLog.w(string2, (String)object);
                    object = this.a;
                    object = c.c((c)object);
                    ((a)object).c();
                    object = this.a;
                    object = c.d((c)object);
                    boolean bl3 = false;
                    Object object2 = null;
                    object.a(false);
                    object = this.a;
                    object = c.c((c)object);
                    object2 = this.a;
                    object2 = c.a((c)object2);
                    int n10 = ((g)object2).h;
                    ((a)object).a(n10);
                    object = this.a;
                    object = c.c((c)object);
                    object2 = this.a;
                    object2 = c.a((c)object2);
                    boolean bl4 = ((g)object2).W;
                    Object object3 = this.a;
                    object3 = c.a((c)object3);
                    int n11 = ((g)object3).a;
                    Object object4 = this.a;
                    object4 = c.a((c)object4);
                    int n12 = ((g)object4).b;
                    ((a)object).a(bl4, n11, n12);
                    object = this.a;
                    object = c.c((c)object);
                    object2 = this.a;
                    object2 = c.d((c)object2);
                    object2 = object2.getSurfaceTexture();
                    ((a)object).a((SurfaceTexture)object2);
                    object = this.a;
                    object = c.c((c)object);
                    object2 = this.a;
                    object2 = c.a((c)object2);
                    boolean bl5 = ((g)object2).m;
                    ((a)object).d(bl5);
                    return;
                }
            }
            object = this.a;
            if ((object = c.e((c)object)) == null) return;
            object = this.a;
            object = c.e((c)object);
            long l10 = 2000L;
            object.postDelayed((Runnable)this, l10);
            return;
        }
        catch (Exception exception) {
            String string3 = "camera monitor exception ";
            TXCLog.w(string2, string3);
        }
    }
}

