/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.annotation;

public @interface AVIMMessageType {
    public static final int AUDIO_MESSAGE_TYPE = 253;
    public static final int FILE_MESSAGE_TYPE = 250;
    public static final int IMAGE_MESSAGE_TYPE = 254;
    public static final int LOCATION_MESSAGE_TYPE = 251;
    public static final int RECALLED_MESSAGE_TYPE = 129;
    public static final int TEXT_MESSAGE_TYPE = 255;
    public static final int VIDEO_MESSAGE_TYPE = 252;

    public int type();
}

