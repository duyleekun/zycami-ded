/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer.entities;

public final class StoryAxis$Type
extends Enum {
    private static final /* synthetic */ StoryAxis$Type[] $VALUES;
    public static final /* enum */ StoryAxis$Type POSITION;
    public static final /* enum */ StoryAxis$Type SPEED;
    public static final /* enum */ StoryAxis$Type UNMOVE;

    static {
        StoryAxis$Type storyAxis$Type;
        StoryAxis$Type storyAxis$Type2;
        StoryAxis$Type storyAxis$Type3;
        POSITION = storyAxis$Type3 = new StoryAxis$Type("POSITION", 0);
        int n10 = 1;
        SPEED = storyAxis$Type2 = new StoryAxis$Type("SPEED", n10);
        int n11 = 2;
        UNMOVE = storyAxis$Type = new StoryAxis$Type("UNMOVE", n11);
        StoryAxis$Type[] storyAxis$TypeArray = new StoryAxis$Type[3];
        storyAxis$TypeArray[0] = storyAxis$Type3;
        storyAxis$TypeArray[n10] = storyAxis$Type2;
        storyAxis$TypeArray[n11] = storyAxis$Type;
        $VALUES = storyAxis$TypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private StoryAxis$Type() {
        void var2_-1;
        void var1_-1;
    }

    public static StoryAxis$Type valueOf(String string2) {
        return Enum.valueOf(StoryAxis$Type.class, string2);
    }

    public static StoryAxis$Type[] values() {
        return (StoryAxis$Type[])$VALUES.clone();
    }
}

