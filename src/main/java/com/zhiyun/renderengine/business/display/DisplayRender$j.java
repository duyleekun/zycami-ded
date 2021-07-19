/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 */
package com.zhiyun.renderengine.business.display;

import android.graphics.SurfaceTexture;
import com.zhiyun.renderengine.business.display.DisplayRender;
import com.zhiyun.renderengine.business.display.DisplayRender$r;
import d.v.b0.j.b;

public class DisplayRender$j
implements SurfaceTexture.OnFrameAvailableListener {
    public final /* synthetic */ DisplayRender a;

    public DisplayRender$j(DisplayRender displayRender) {
        this.a = displayRender;
    }

    public void onFrameAvailable(SurfaceTexture object) {
        long l10;
        long l11 = System.currentTimeMillis();
        DisplayRender.D(this.a);
        object = DisplayRender.b(this.a);
        ((DisplayRender$r)object).d = l10 = System.currentTimeMillis() - l11;
        DisplayRender.b(this.a).c();
        object = DisplayRender.b(this.a);
        boolean bl2 = ((DisplayRender$r)object).c;
        if (bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("onDraw consume time: ");
            l11 = DisplayRender.b((DisplayRender)this.a).d;
            ((StringBuilder)object).append(l11);
            String string2 = " ms";
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            b.c((String)object);
        }
    }
}

