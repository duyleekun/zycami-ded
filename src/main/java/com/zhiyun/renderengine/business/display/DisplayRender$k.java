/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.renderengine.business.display;

import com.zhiyun.renderengine.business.display.DisplayRender;
import com.zhiyun.renderengine.engine.IRenderEngine;
import java.util.List;

public class DisplayRender$k
implements Runnable {
    public final /* synthetic */ IRenderEngine[] a;
    public final /* synthetic */ DisplayRender b;

    public DisplayRender$k(DisplayRender displayRender, IRenderEngine[] iRenderEngineArray) {
        this.b = displayRender;
        this.a = iRenderEngineArray;
    }

    public void run() {
        for (IRenderEngine iRenderEngine : this.a) {
            List list = DisplayRender.c(this.b);
            list.add(iRenderEngine);
        }
    }
}

