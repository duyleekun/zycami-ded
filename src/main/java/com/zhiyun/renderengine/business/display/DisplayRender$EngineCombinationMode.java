/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.renderengine.business.display;

public final class DisplayRender$EngineCombinationMode
extends Enum {
    public static final /* enum */ DisplayRender$EngineCombinationMode ALL_ENGINE_APPLY;
    public static final /* enum */ DisplayRender$EngineCombinationMode SELECT_ENGINE_APPLY;
    private static final /* synthetic */ DisplayRender$EngineCombinationMode[] a;

    static {
        DisplayRender$EngineCombinationMode displayRender$EngineCombinationMode;
        DisplayRender$EngineCombinationMode displayRender$EngineCombinationMode2;
        ALL_ENGINE_APPLY = displayRender$EngineCombinationMode2 = new DisplayRender$EngineCombinationMode("ALL_ENGINE_APPLY", 0);
        int n10 = 1;
        SELECT_ENGINE_APPLY = displayRender$EngineCombinationMode = new DisplayRender$EngineCombinationMode("SELECT_ENGINE_APPLY", n10);
        DisplayRender$EngineCombinationMode[] displayRender$EngineCombinationModeArray = new DisplayRender$EngineCombinationMode[2];
        displayRender$EngineCombinationModeArray[0] = displayRender$EngineCombinationMode2;
        displayRender$EngineCombinationModeArray[n10] = displayRender$EngineCombinationMode;
        a = displayRender$EngineCombinationModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DisplayRender$EngineCombinationMode() {
        void var2_-1;
        void var1_-1;
    }

    public static DisplayRender$EngineCombinationMode valueOf(String string2) {
        return Enum.valueOf(DisplayRender$EngineCombinationMode.class, string2);
    }

    public static DisplayRender$EngineCombinationMode[] values() {
        return (DisplayRender$EngineCombinationMode[])a.clone();
    }
}

