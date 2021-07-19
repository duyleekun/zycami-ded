/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me;

public final class PublishLogManager$ReasonCode
extends Enum {
    public static final /* enum */ PublishLogManager$ReasonCode API_FAILED;
    public static final /* enum */ PublishLogManager$ReasonCode COMPRESS_FAILED;
    public static final /* enum */ PublishLogManager$ReasonCode NETWORK_ERROR;
    public static final /* enum */ PublishLogManager$ReasonCode OTHER;
    public static final /* enum */ PublishLogManager$ReasonCode UPLOAD_IMAGE_FAILED;
    public static final /* enum */ PublishLogManager$ReasonCode UPLOAD_VIDEO_FAILED;
    private static final /* synthetic */ PublishLogManager$ReasonCode[] a;
    private String value;

    static {
        PublishLogManager$ReasonCode publishLogManager$ReasonCode;
        PublishLogManager$ReasonCode publishLogManager$ReasonCode2;
        PublishLogManager$ReasonCode publishLogManager$ReasonCode3;
        PublishLogManager$ReasonCode publishLogManager$ReasonCode4;
        PublishLogManager$ReasonCode publishLogManager$ReasonCode5;
        PublishLogManager$ReasonCode publishLogManager$ReasonCode6;
        COMPRESS_FAILED = publishLogManager$ReasonCode6 = new PublishLogManager$ReasonCode("COMPRESS_FAILED", 0, "compress_failed");
        int n10 = 1;
        UPLOAD_IMAGE_FAILED = publishLogManager$ReasonCode5 = new PublishLogManager$ReasonCode("UPLOAD_IMAGE_FAILED", n10, "upload_image_failed");
        int n11 = 2;
        UPLOAD_VIDEO_FAILED = publishLogManager$ReasonCode4 = new PublishLogManager$ReasonCode("UPLOAD_VIDEO_FAILED", n11, "upload_video_failed");
        int n12 = 3;
        API_FAILED = publishLogManager$ReasonCode3 = new PublishLogManager$ReasonCode("API_FAILED", n12, "api_failed");
        int n13 = 4;
        NETWORK_ERROR = publishLogManager$ReasonCode2 = new PublishLogManager$ReasonCode("NETWORK_ERROR", n13, "network_error");
        int n14 = 5;
        OTHER = publishLogManager$ReasonCode = new PublishLogManager$ReasonCode("OTHER", n14, "other");
        PublishLogManager$ReasonCode[] publishLogManager$ReasonCodeArray = new PublishLogManager$ReasonCode[6];
        publishLogManager$ReasonCodeArray[0] = publishLogManager$ReasonCode6;
        publishLogManager$ReasonCodeArray[n10] = publishLogManager$ReasonCode5;
        publishLogManager$ReasonCodeArray[n11] = publishLogManager$ReasonCode4;
        publishLogManager$ReasonCodeArray[n12] = publishLogManager$ReasonCode3;
        publishLogManager$ReasonCodeArray[n13] = publishLogManager$ReasonCode2;
        publishLogManager$ReasonCodeArray[n14] = publishLogManager$ReasonCode;
        a = publishLogManager$ReasonCodeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PublishLogManager$ReasonCode() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static /* synthetic */ String access$000(PublishLogManager$ReasonCode publishLogManager$ReasonCode) {
        return publishLogManager$ReasonCode.value;
    }

    public static PublishLogManager$ReasonCode valueOf(String string2) {
        return Enum.valueOf(PublishLogManager$ReasonCode.class, string2);
    }

    public static PublishLogManager$ReasonCode[] values() {
        return (PublishLogManager$ReasonCode[])a.clone();
    }

    public String getValue() {
        return this.value;
    }
}

