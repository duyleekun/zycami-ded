/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.usb.media;

public final class MediaType
extends Enum {
    public static final /* enum */ MediaType AUDIO_RMP;
    public static final /* enum */ MediaType UNKNOWN;
    public static final /* enum */ MediaType VIDEO_RMP;
    private static final /* synthetic */ MediaType[] a;
    public final int value;

    static {
        MediaType mediaType;
        MediaType mediaType2;
        MediaType mediaType3;
        UNKNOWN = mediaType3 = new MediaType("UNKNOWN", 0, -1);
        int n10 = 1;
        VIDEO_RMP = mediaType2 = new MediaType("VIDEO_RMP", n10, 0);
        int n11 = 2;
        AUDIO_RMP = mediaType = new MediaType("AUDIO_RMP", n11, n10);
        MediaType[] mediaTypeArray = new MediaType[3];
        mediaTypeArray[0] = mediaType3;
        mediaTypeArray[n10] = mediaType2;
        mediaTypeArray[n11] = mediaType;
        a = mediaTypeArray;
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

    public static MediaType from(int n10) {
        MediaType mediaType = UNKNOWN;
        for (MediaType mediaType2 : MediaType.values()) {
            int n11 = mediaType2.value;
            if (n11 != n10) continue;
            mediaType = mediaType2;
            break;
        }
        return mediaType;
    }

    public static MediaType valueOf(String string2) {
        return Enum.valueOf(MediaType.class, string2);
    }

    public static MediaType[] values() {
        return (MediaType[])a.clone();
    }
}

