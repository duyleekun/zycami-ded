/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorinterface.edit;

public final class MediaType
extends Enum {
    public static final /* enum */ MediaType ALL;
    public static final /* enum */ MediaType GIF;
    public static final /* enum */ MediaType IMAGE;
    public static final /* enum */ MediaType VIDEO;
    private static final /* synthetic */ MediaType[] a;

    static {
        MediaType mediaType;
        MediaType mediaType2;
        MediaType mediaType3;
        MediaType mediaType4;
        ALL = mediaType4 = new MediaType("ALL", 0);
        int n10 = 1;
        IMAGE = mediaType3 = new MediaType("IMAGE", n10);
        int n11 = 2;
        GIF = mediaType2 = new MediaType("GIF", n11);
        int n12 = 3;
        VIDEO = mediaType = new MediaType("VIDEO", n12);
        MediaType[] mediaTypeArray = new MediaType[4];
        mediaTypeArray[0] = mediaType4;
        mediaTypeArray[n10] = mediaType3;
        mediaTypeArray[n11] = mediaType2;
        mediaTypeArray[n12] = mediaType;
        a = mediaTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MediaType() {
        void var2_-1;
        void var1_-1;
    }

    public static MediaType valueOf(String string2) {
        return Enum.valueOf(MediaType.class, string2);
    }

    public static MediaType[] values() {
        return (MediaType[])a.clone();
    }
}

