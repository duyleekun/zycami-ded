/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.story;

public final class StoryZoom$Type
extends Enum {
    public static final /* enum */ StoryZoom$Type IMMEDIATELY;
    public static final /* enum */ StoryZoom$Type SMOOTHLY;
    private static final /* synthetic */ StoryZoom$Type[] a;

    static {
        StoryZoom$Type storyZoom$Type;
        StoryZoom$Type storyZoom$Type2;
        SMOOTHLY = storyZoom$Type2 = new StoryZoom$Type("SMOOTHLY", 0);
        int n10 = 1;
        IMMEDIATELY = storyZoom$Type = new StoryZoom$Type("IMMEDIATELY", n10);
        StoryZoom$Type[] storyZoom$TypeArray = new StoryZoom$Type[2];
        storyZoom$TypeArray[0] = storyZoom$Type2;
        storyZoom$TypeArray[n10] = storyZoom$Type;
        a = storyZoom$TypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private StoryZoom$Type() {
        void var2_-1;
        void var1_-1;
    }

    public static StoryZoom$Type valueOf(String string2) {
        return Enum.valueOf(StoryZoom$Type.class, string2);
    }

    public static StoryZoom$Type[] values() {
        return (StoryZoom$Type[])a.clone();
    }
}

