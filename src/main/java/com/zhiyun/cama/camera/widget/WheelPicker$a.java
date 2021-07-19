/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.widget;

import com.zhiyun.cama.camera.widget.WheelPicker;

public class WheelPicker$a
implements Runnable {
    public final /* synthetic */ WheelPicker a;

    public WheelPicker$a(WheelPicker wheelPicker) {
        this.a = wheelPicker;
    }

    public void run() {
        int n10;
        Object object;
        Object object2 = WheelPicker.a(this.a);
        int n11 = object2.computeScrollOffset();
        if (n11 != 0) {
            object2 = this.a;
            object = WheelPicker.a((WheelPicker)((Object)object2));
            n10 = object.getCurrY();
            WheelPicker.c((WheelPicker)((Object)object2), n10);
            this.a.postInvalidate();
            object2 = WheelPicker.d(this.a);
            long l10 = 16;
            object2.postDelayed((Runnable)this, l10);
        }
        if ((n11 = (object2 = WheelPicker.a(this.a)).isFinished()) != 0 || (n11 = (object2 = WheelPicker.a(this.a)).getFinalY()) == (n10 = (object = WheelPicker.a(this.a)).getCurrY()) && (n11 = (object2 = WheelPicker.a(this.a)).getFinalX()) == (n10 = (object = WheelPicker.a(this.a)).getCurrX())) {
            object2 = this.a;
            n11 = WheelPicker.e((WheelPicker)((Object)object2));
            if (n11 == 0) {
                return;
            }
            object2 = this.a;
            n11 = -WheelPicker.b((WheelPicker)((Object)object2));
            n10 = WheelPicker.e(this.a);
            n11 /= n10;
            n11 = WheelPicker.f(this.a, n11);
            object = this.a;
            n10 = WheelPicker.g((WheelPicker)((Object)object));
            if (n10 != n11) {
                WheelPicker.h(this.a, n11);
                object = WheelPicker.i(this.a);
                if (object == null) {
                    return;
                }
                object = WheelPicker.i(this.a);
                Object e10 = WheelPicker.j(this.a).get(n11);
                object.a(e10, n11);
            }
        }
    }
}

