/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorinterface.decoration;

public final class DecorationType
extends Enum {
    public static final /* enum */ DecorationType CAPTION;
    public static final /* enum */ DecorationType FONT;
    public static final /* enum */ DecorationType GIF_PASTER;
    public static final /* enum */ DecorationType IMAGE_PASTER;
    private static final /* synthetic */ DecorationType[] a;

    static {
        DecorationType decorationType;
        DecorationType decorationType2;
        DecorationType decorationType3;
        DecorationType decorationType4;
        GIF_PASTER = decorationType4 = new DecorationType("GIF_PASTER", 0);
        int n10 = 1;
        IMAGE_PASTER = decorationType3 = new DecorationType("IMAGE_PASTER", n10);
        int n11 = 2;
        CAPTION = decorationType2 = new DecorationType("CAPTION", n11);
        int n12 = 3;
        FONT = decorationType = new DecorationType("FONT", n12);
        DecorationType[] decorationTypeArray = new DecorationType[4];
        decorationTypeArray[0] = decorationType4;
        decorationTypeArray[n10] = decorationType3;
        decorationTypeArray[n11] = decorationType2;
        decorationTypeArray[n12] = decorationType;
        a = decorationTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DecorationType() {
        void var2_-1;
        void var1_-1;
    }

    public static DecorationType get(int n10) {
        return DecorationType.values()[n10];
    }

    public static DecorationType valueOf(String string2) {
        return Enum.valueOf(DecorationType.class, string2);
    }

    public static DecorationType[] values() {
        return (DecorationType[])a.clone();
    }

    public int index() {
        return this.ordinal();
    }
}

