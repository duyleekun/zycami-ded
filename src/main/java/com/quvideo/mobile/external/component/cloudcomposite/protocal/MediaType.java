/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudcomposite.protocal;

public final class MediaType
extends Enum {
    private static final /* synthetic */ MediaType[] $VALUES;
    public static final /* enum */ MediaType IMAGE;
    public static final /* enum */ MediaType VIDEO;
    private int value;

    static {
        MediaType mediaType;
        MediaType mediaType2;
        int n10 = 1;
        VIDEO = mediaType2 = new MediaType("VIDEO", 0, n10);
        int n11 = 2;
        IMAGE = mediaType = new MediaType("IMAGE", n10, n11);
        MediaType[] mediaTypeArray = new MediaType[n11];
        mediaTypeArray[0] = mediaType2;
        mediaTypeArray[n10] = mediaType;
        $VALUES = mediaTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MediaType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static MediaType valueOf(String string2) {
        return Enum.valueOf(MediaType.class, string2);
    }

    public static MediaType[] values() {
        return (MediaType[])$VALUES.clone();
    }

    public int value() {
        return this.value;
    }
}

