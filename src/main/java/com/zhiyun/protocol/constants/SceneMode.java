/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

public final class SceneMode
extends Enum {
    private static final /* synthetic */ SceneMode[] $VALUES;
    public static final /* enum */ SceneMode NONE;
    public static final /* enum */ SceneMode RUN;
    public static final /* enum */ SceneMode WALK;
    public final int value;

    static {
        SceneMode sceneMode;
        SceneMode sceneMode2;
        SceneMode sceneMode3;
        NONE = sceneMode3 = new SceneMode("NONE", 0, -1);
        int n10 = 1;
        WALK = sceneMode2 = new SceneMode("WALK", n10, 0);
        int n11 = 2;
        RUN = sceneMode = new SceneMode("RUN", n11, n10);
        SceneMode[] sceneModeArray = new SceneMode[3];
        sceneModeArray[0] = sceneMode3;
        sceneModeArray[n10] = sceneMode2;
        sceneModeArray[n11] = sceneMode;
        $VALUES = sceneModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SceneMode() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static SceneMode valueOf(int n10) {
        SceneMode sceneMode = WALK;
        for (SceneMode sceneMode2 : SceneMode.values()) {
            int n11 = sceneMode2.value;
            if (n11 != n10) continue;
            sceneMode = sceneMode2;
            break;
        }
        return sceneMode;
    }

    public static SceneMode valueOf(String string2) {
        return Enum.valueOf(SceneMode.class, string2);
    }

    public static SceneMode[] values() {
        return (SceneMode[])$VALUES.clone();
    }
}

