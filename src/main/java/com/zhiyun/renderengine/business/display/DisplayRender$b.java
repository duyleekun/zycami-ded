/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.renderengine.business.display;

import com.zhiyun.renderengine.business.display.DisplayRender;
import d.v.b0.d.d;
import java.util.Iterator;

public class DisplayRender$b
implements Runnable {
    public final /* synthetic */ float a;
    public final /* synthetic */ DisplayRender b;

    public DisplayRender$b(DisplayRender displayRender, float f10) {
        this.b = displayRender;
        this.a = f10;
    }

    public void run() {
        Iterator iterator2 = DisplayRender.r(this.b);
        int n10 = 1;
        if (iterator2 != null) {
            boolean bl2;
            iterator2 = DisplayRender.r(this.b).d().iterator();
            while (bl2 = iterator2.hasNext()) {
                d d10 = (d)iterator2.next();
                if (d10 == null) continue;
                float f10 = this.a;
                d10.j(n10, f10);
            }
        } else {
            iterator2 = this.b.Y;
            Integer n11 = n10;
            float f11 = this.a;
            Float f12 = Float.valueOf(f11);
            iterator2.put(n11, f12);
        }
    }
}

