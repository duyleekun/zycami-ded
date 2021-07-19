/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.renderengine.business.display;

import com.zhiyun.renderengine.business.display.DisplayRender;

public class DisplayRender$m
implements Runnable {
    public final /* synthetic */ DisplayRender a;

    public DisplayRender$m(DisplayRender displayRender) {
        this.a = displayRender;
    }

    public void run() {
        DisplayRender.s(this.a, true);
    }
}

