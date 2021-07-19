/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.renderengine.business.display;

import com.zhiyun.renderengine.business.display.DisplayRender;
import com.zhiyun.renderengine.business.display.DisplayRender$l;
import com.zhiyun.renderengine.engine.IRenderEngine;

public class DisplayRender$l$a
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ DisplayRender$l c;

    public DisplayRender$l$a(DisplayRender$l l10, int n10, int n11) {
        this.c = l10;
        this.a = n10;
        this.b = n11;
    }

    public void run() {
        IRenderEngine iRenderEngine = DisplayRender.r(this.c.a);
        if (iRenderEngine != null) {
            iRenderEngine = DisplayRender.r(this.c.a);
            int n10 = this.a;
            int n11 = this.b;
            iRenderEngine.a(n10, n11);
        }
    }
}

