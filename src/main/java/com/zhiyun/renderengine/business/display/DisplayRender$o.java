/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.renderengine.business.display;

import com.zhiyun.renderengine.business.display.DisplayRender;
import d.v.b0.d.d;
import java.util.Iterator;

public class DisplayRender$o
implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ DisplayRender b;

    public DisplayRender$o(DisplayRender displayRender, boolean bl2) {
        this.b = displayRender;
        this.a = bl2;
    }

    public void run() {
        Iterator iterator2 = this.b;
        boolean bl2 = this.a;
        DisplayRender.t((DisplayRender)((Object)iterator2), bl2);
        iterator2 = DisplayRender.r(this.b);
        if (iterator2 != null) {
            iterator2 = DisplayRender.r(this.b).d().iterator();
            while (bl2 = iterator2.hasNext()) {
                d d10 = (d)iterator2.next();
                if (d10 == null) continue;
                boolean bl3 = this.a;
                d10.h(bl3);
            }
        } else {
            Float f10;
            float f11;
            iterator2 = this.b.Y;
            bl2 = false;
            Integer n10 = 0;
            int n11 = this.a;
            if (n11 != 0) {
                n11 = 1065353216;
                f11 = 1.0f;
            } else {
                n11 = 0;
                f11 = 0.0f;
                f10 = null;
            }
            f10 = Float.valueOf(f11);
            iterator2.put(n10, f10);
        }
    }
}

