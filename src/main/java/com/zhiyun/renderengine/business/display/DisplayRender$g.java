/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.renderengine.business.display;

import com.zhiyun.renderengine.business.display.DisplayRender;

public class DisplayRender$g
implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ DisplayRender b;

    public DisplayRender$g(DisplayRender displayRender, boolean bl2) {
        this.b = displayRender;
        this.a = bl2;
    }

    public void run() {
        DisplayRender displayRender = this.b;
        boolean bl2 = this.a;
        DisplayRender.x(displayRender, bl2);
    }
}

