/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  android.view.Surface
 */
package d.v.b.f0.l;

import android.util.Size;
import android.view.Surface;
import com.zhiyun.renderengine.business.display.DisplayRender;
import com.zhiyun.renderengine.business.display.DisplayRender$u;
import d.v.b.c0.b;

public class c
extends b {
    private d.v.b0.b.c i = null;

    public c(DisplayRender displayRender) {
        super(displayRender);
    }

    public void o(Surface object, int n10, Size size, DisplayRender$u displayRender$u) {
        d.v.b0.b.c c10;
        this.i = c10 = new d.v.b0.b.c(object, false, null);
        int n11 = size.getWidth();
        c10.l(n11);
        object = this.i;
        n10 = size.getHeight();
        ((d.v.b0.b.c)object).k(n10);
        object = (DisplayRender)this.a;
        c10 = this.i;
        ((DisplayRender)object).v0(c10, displayRender$u);
        object = (DisplayRender)this.a;
        c10 = this.i;
        ((DisplayRender)object).B0(c10);
    }

    public void p() {
        Object object = this.a;
        if (object == null) {
            return;
        }
        object = (DisplayRender)object;
        d.v.b0.b.c c10 = this.i;
        ((DisplayRender)object).F0(c10);
    }
}

