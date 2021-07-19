/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.ccs;

public final class VideoParams$Protocol
extends Enum {
    public static final /* enum */ VideoParams$Protocol H264;
    public static final /* enum */ VideoParams$Protocol H264_PRI;
    public static final /* enum */ VideoParams$Protocol H265;
    public static final /* enum */ VideoParams$Protocol H265_PRI;
    private static final /* synthetic */ VideoParams$Protocol[] a;

    static {
        VideoParams$Protocol videoParams$Protocol;
        VideoParams$Protocol videoParams$Protocol2;
        VideoParams$Protocol videoParams$Protocol3;
        VideoParams$Protocol videoParams$Protocol4;
        H264 = videoParams$Protocol4 = new VideoParams$Protocol("H264", 0);
        int n10 = 1;
        H265 = videoParams$Protocol3 = new VideoParams$Protocol("H265", n10);
        int n11 = 2;
        H264_PRI = videoParams$Protocol2 = new VideoParams$Protocol("H264_PRI", n11);
        int n12 = 3;
        H265_PRI = videoParams$Protocol = new VideoParams$Protocol("H265_PRI", n12);
        VideoParams$Protocol[] videoParams$ProtocolArray = new VideoParams$Protocol[4];
        videoParams$ProtocolArray[0] = videoParams$Protocol4;
        videoParams$ProtocolArray[n10] = videoParams$Protocol3;
        videoParams$ProtocolArray[n11] = videoParams$Protocol2;
        videoParams$ProtocolArray[n12] = videoParams$Protocol;
        a = videoParams$ProtocolArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private VideoParams$Protocol() {
        void var2_-1;
        void var1_-1;
    }

    public static VideoParams$Protocol valueOf(String string2) {
        return Enum.valueOf(VideoParams$Protocol.class, string2);
    }

    public static VideoParams$Protocol[] values() {
        return (VideoParams$Protocol[])a.clone();
    }
}

