/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorinterface;

import d.v.e.j.a;

public final class EditConfig$ResourceType
extends Enum
implements a {
    public static final /* enum */ EditConfig$ResourceType CAPTION;
    public static final /* enum */ EditConfig$ResourceType FILTER;
    public static final /* enum */ EditConfig$ResourceType FONT;
    public static final /* enum */ EditConfig$ResourceType MUSIC;
    public static final /* enum */ EditConfig$ResourceType RECORD;
    public static final /* enum */ EditConfig$ResourceType SPEED;
    public static final /* enum */ EditConfig$ResourceType STICKER;
    public static final /* enum */ EditConfig$ResourceType TRANSITION;
    private static final /* synthetic */ EditConfig$ResourceType[] a;
    private final String mName;

    static {
        EditConfig$ResourceType editConfig$ResourceType;
        EditConfig$ResourceType editConfig$ResourceType2;
        EditConfig$ResourceType editConfig$ResourceType3;
        EditConfig$ResourceType editConfig$ResourceType4;
        EditConfig$ResourceType editConfig$ResourceType5;
        EditConfig$ResourceType editConfig$ResourceType6;
        EditConfig$ResourceType editConfig$ResourceType7;
        EditConfig$ResourceType editConfig$ResourceType8;
        MUSIC = editConfig$ResourceType8 = new EditConfig$ResourceType("MUSIC", 0, "Music");
        int n10 = 1;
        RECORD = editConfig$ResourceType7 = new EditConfig$ResourceType("RECORD", n10, "record");
        int n11 = 2;
        FILTER = editConfig$ResourceType6 = new EditConfig$ResourceType("FILTER", n11, "Filter");
        int n12 = 3;
        FONT = editConfig$ResourceType5 = new EditConfig$ResourceType("FONT", n12, "Font");
        int n13 = 4;
        CAPTION = editConfig$ResourceType4 = new EditConfig$ResourceType("CAPTION", n13, "Caption");
        STICKER = editConfig$ResourceType3 = new EditConfig$ResourceType("STICKER", 5, "Sticker");
        TRANSITION = editConfig$ResourceType2 = new EditConfig$ResourceType("TRANSITION", 6, "Transition");
        int n14 = 7;
        SPEED = editConfig$ResourceType = new EditConfig$ResourceType("SPEED", n14, "Speed");
        EditConfig$ResourceType[] editConfig$ResourceTypeArray = new EditConfig$ResourceType[8];
        editConfig$ResourceTypeArray[0] = editConfig$ResourceType8;
        editConfig$ResourceTypeArray[n10] = editConfig$ResourceType7;
        editConfig$ResourceTypeArray[n11] = editConfig$ResourceType6;
        editConfig$ResourceTypeArray[n12] = editConfig$ResourceType5;
        editConfig$ResourceTypeArray[n13] = editConfig$ResourceType4;
        editConfig$ResourceTypeArray[5] = editConfig$ResourceType3;
        editConfig$ResourceTypeArray[6] = editConfig$ResourceType2;
        editConfig$ResourceTypeArray[n14] = editConfig$ResourceType;
        a = editConfig$ResourceTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EditConfig$ResourceType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.mName = var3_1;
    }

    public static EditConfig$ResourceType valueOf(String string2) {
        return Enum.valueOf(EditConfig$ResourceType.class, string2);
    }

    public static EditConfig$ResourceType[] values() {
        return (EditConfig$ResourceType[])a.clone();
    }

    public String getDirName() {
        return this.mName;
    }

    public String getType() {
        return this.mName;
    }
}

