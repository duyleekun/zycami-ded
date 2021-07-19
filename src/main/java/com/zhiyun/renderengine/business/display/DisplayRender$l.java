/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.zhiyun.renderengine.business.display;

import android.os.Handler;
import com.zhiyun.renderengine.bean.TextureFormat;
import com.zhiyun.renderengine.business.display.DisplayRender;
import com.zhiyun.renderengine.business.display.DisplayRender$l$a;
import d.v.b0.c.b;

public class DisplayRender$l
implements b {
    public final /* synthetic */ DisplayRender a;

    public DisplayRender$l(DisplayRender displayRender) {
        this.a = displayRender;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(byte[] object, TextureFormat object2, int n10, int n11, float[] fArray, int n12) {
        object2 = this.a;
        int n13 = DisplayRender.d((DisplayRender)object2);
        if (n13 != n10 || (n13 = DisplayRender.f((DisplayRender)(object2 = this.a))) != n11) {
            object2 = this.a;
            boolean bl2 = true;
            DisplayRender.h((DisplayRender)object2, bl2);
        }
        object2 = DisplayRender.i(this.a);
        synchronized (object2) {
            block6: {
                Object object3;
                block8: {
                    block7: {
                        DisplayRender displayRender = this.a;
                        DisplayRender.k(displayRender, object);
                        object = this.a;
                        DisplayRender.l((DisplayRender)object, fArray);
                        object = this.a;
                        DisplayRender.m((DisplayRender)object, n12);
                        object = this.a;
                        DisplayRender.e((DisplayRender)object, n10);
                        object = this.a;
                        DisplayRender.g((DisplayRender)object, n11);
                        object = this.a;
                        object = DisplayRender.j((DisplayRender)object);
                        if (object == null) break block6;
                        object = this.a;
                        if ((object = DisplayRender.n((DisplayRender)object)) == null) break block7;
                        object = this.a;
                        object = DisplayRender.n((DisplayRender)object);
                        int n14 = ((byte[])object).length;
                        object3 = this.a;
                        n10 = ((byte[])(object3 = DisplayRender.j((DisplayRender)object3))).length;
                        if (n14 == n10) break block8;
                    }
                    object = this.a;
                    object3 = DisplayRender.j((DisplayRender)object);
                    n10 = ((byte[])object3).length;
                    object3 = new byte[n10];
                    DisplayRender.o((DisplayRender)object, object3);
                }
                object = this.a;
                object = DisplayRender.j((DisplayRender)object);
                object3 = this.a;
                object3 = DisplayRender.n((DisplayRender)object3);
                Object object4 = this.a;
                object4 = DisplayRender.j((DisplayRender)object4);
                n11 = ((Object)object4).length;
                fArray = null;
                System.arraycopy(object, 0, object3, 0, n11);
            }
            return;
        }
    }

    public void b(int n10, int n11) {
        Handler handler = DisplayRender.q(this.a);
        if (handler != null) {
            handler = DisplayRender.q(this.a);
            DisplayRender$l$a displayRender$l$a = new DisplayRender$l$a(this, n10, n11);
            handler.post((Runnable)displayRender$l$a);
        }
    }
}

