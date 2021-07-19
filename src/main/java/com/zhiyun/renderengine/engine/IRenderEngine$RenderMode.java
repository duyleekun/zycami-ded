/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.renderengine.engine;

public final class IRenderEngine$RenderMode
extends Enum {
    public static final /* enum */ IRenderEngine$RenderMode RENDER_ALL_EFFECTS;
    public static final /* enum */ IRenderEngine$RenderMode RENDER_SELECT_EFFECT;
    private static final /* synthetic */ IRenderEngine$RenderMode[] a;

    static {
        IRenderEngine$RenderMode iRenderEngine$RenderMode;
        IRenderEngine$RenderMode iRenderEngine$RenderMode2;
        RENDER_SELECT_EFFECT = iRenderEngine$RenderMode2 = new IRenderEngine$RenderMode("RENDER_SELECT_EFFECT", 0);
        int n10 = 1;
        RENDER_ALL_EFFECTS = iRenderEngine$RenderMode = new IRenderEngine$RenderMode("RENDER_ALL_EFFECTS", n10);
        IRenderEngine$RenderMode[] iRenderEngine$RenderModeArray = new IRenderEngine$RenderMode[2];
        iRenderEngine$RenderModeArray[0] = iRenderEngine$RenderMode2;
        iRenderEngine$RenderModeArray[n10] = iRenderEngine$RenderMode;
        a = iRenderEngine$RenderModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private IRenderEngine$RenderMode() {
        void var2_-1;
        void var1_-1;
    }

    public static IRenderEngine$RenderMode valueOf(String string2) {
        return Enum.valueOf(IRenderEngine$RenderMode.class, string2);
    }

    public static IRenderEngine$RenderMode[] values() {
        return (IRenderEngine$RenderMode[])a.clone();
    }
}

