/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.framework;

public final class MediaPipeException$StatusCode
extends Enum {
    private static final /* synthetic */ MediaPipeException$StatusCode[] $VALUES;
    public static final /* enum */ MediaPipeException$StatusCode ABORTED;
    public static final /* enum */ MediaPipeException$StatusCode ALREADY_EXISTS;
    public static final /* enum */ MediaPipeException$StatusCode CANCELLED;
    public static final /* enum */ MediaPipeException$StatusCode DATA_LOSS;
    public static final /* enum */ MediaPipeException$StatusCode DEADLINE_EXCEEDED;
    public static final /* enum */ MediaPipeException$StatusCode FAILED_PRECONDITION;
    public static final /* enum */ MediaPipeException$StatusCode INTERNAL;
    public static final /* enum */ MediaPipeException$StatusCode INVALID_ARGUMENT;
    public static final /* enum */ MediaPipeException$StatusCode NOT_FOUND;
    public static final /* enum */ MediaPipeException$StatusCode OK;
    public static final /* enum */ MediaPipeException$StatusCode OUT_OF_RANGE;
    public static final /* enum */ MediaPipeException$StatusCode PERMISSION_DENIED;
    public static final /* enum */ MediaPipeException$StatusCode RESOURCE_EXHAUSTED;
    public static final /* enum */ MediaPipeException$StatusCode UNAUTHENTICATED;
    public static final /* enum */ MediaPipeException$StatusCode UNAVAILABLE;
    public static final /* enum */ MediaPipeException$StatusCode UNIMPLEMENTED;
    public static final /* enum */ MediaPipeException$StatusCode UNKNOWN;
    private final String description;

    static {
        MediaPipeException$StatusCode mediaPipeException$StatusCode;
        MediaPipeException$StatusCode mediaPipeException$StatusCode2;
        MediaPipeException$StatusCode mediaPipeException$StatusCode3;
        MediaPipeException$StatusCode mediaPipeException$StatusCode4;
        MediaPipeException$StatusCode mediaPipeException$StatusCode5;
        MediaPipeException$StatusCode mediaPipeException$StatusCode6;
        MediaPipeException$StatusCode mediaPipeException$StatusCode7;
        MediaPipeException$StatusCode mediaPipeException$StatusCode8;
        MediaPipeException$StatusCode mediaPipeException$StatusCode9;
        MediaPipeException$StatusCode mediaPipeException$StatusCode10;
        MediaPipeException$StatusCode mediaPipeException$StatusCode11;
        MediaPipeException$StatusCode mediaPipeException$StatusCode12;
        MediaPipeException$StatusCode mediaPipeException$StatusCode13;
        OK = mediaPipeException$StatusCode13 = new MediaPipeException$StatusCode("OK", 0, "ok");
        CANCELLED = mediaPipeException$StatusCode12 = new MediaPipeException$StatusCode("CANCELLED", 1, "canceled");
        UNKNOWN = mediaPipeException$StatusCode11 = new MediaPipeException$StatusCode("UNKNOWN", 2, "unknown");
        INVALID_ARGUMENT = mediaPipeException$StatusCode10 = new MediaPipeException$StatusCode("INVALID_ARGUMENT", 3, "invalid argument");
        DEADLINE_EXCEEDED = mediaPipeException$StatusCode9 = new MediaPipeException$StatusCode("DEADLINE_EXCEEDED", 4, "deadline exceeded");
        NOT_FOUND = mediaPipeException$StatusCode8 = new MediaPipeException$StatusCode("NOT_FOUND", 5, "not found");
        ALREADY_EXISTS = mediaPipeException$StatusCode7 = new MediaPipeException$StatusCode("ALREADY_EXISTS", 6, "already exists");
        PERMISSION_DENIED = mediaPipeException$StatusCode6 = new MediaPipeException$StatusCode("PERMISSION_DENIED", 7, "permission denied");
        RESOURCE_EXHAUSTED = mediaPipeException$StatusCode5 = new MediaPipeException$StatusCode("RESOURCE_EXHAUSTED", 8, "resource exhausted");
        FAILED_PRECONDITION = mediaPipeException$StatusCode4 = new MediaPipeException$StatusCode("FAILED_PRECONDITION", 9, "failed precondition");
        ABORTED = mediaPipeException$StatusCode3 = new MediaPipeException$StatusCode("ABORTED", 10, "aborted");
        OUT_OF_RANGE = mediaPipeException$StatusCode2 = new MediaPipeException$StatusCode("OUT_OF_RANGE", 11, "out of range");
        UNIMPLEMENTED = mediaPipeException$StatusCode = new MediaPipeException$StatusCode("UNIMPLEMENTED", 12, "unimplemented");
        MediaPipeException$StatusCode mediaPipeException$StatusCode14 = mediaPipeException$StatusCode;
        MediaPipeException$StatusCode[] mediaPipeException$StatusCodeArray = new MediaPipeException$StatusCode("INTERNAL", 13, "internal");
        INTERNAL = mediaPipeException$StatusCodeArray;
        MediaPipeException$StatusCode[] mediaPipeException$StatusCodeArray2 = mediaPipeException$StatusCodeArray;
        UNAVAILABLE = mediaPipeException$StatusCode = new MediaPipeException$StatusCode("UNAVAILABLE", 14, "unavailable");
        MediaPipeException$StatusCode mediaPipeException$StatusCode15 = mediaPipeException$StatusCode;
        mediaPipeException$StatusCodeArray = new MediaPipeException$StatusCode("DATA_LOSS", 15, "data loss");
        DATA_LOSS = mediaPipeException$StatusCodeArray;
        int n10 = 16;
        MediaPipeException$StatusCode[] mediaPipeException$StatusCodeArray3 = mediaPipeException$StatusCodeArray;
        UNAUTHENTICATED = mediaPipeException$StatusCode = new MediaPipeException$StatusCode("UNAUTHENTICATED", n10, "unauthenticated");
        mediaPipeException$StatusCodeArray = new MediaPipeException$StatusCode[17];
        mediaPipeException$StatusCodeArray[0] = mediaPipeException$StatusCode13;
        mediaPipeException$StatusCodeArray[1] = mediaPipeException$StatusCode12;
        mediaPipeException$StatusCodeArray[2] = mediaPipeException$StatusCode11;
        mediaPipeException$StatusCodeArray[3] = mediaPipeException$StatusCode10;
        mediaPipeException$StatusCodeArray[4] = mediaPipeException$StatusCode9;
        mediaPipeException$StatusCodeArray[5] = mediaPipeException$StatusCode8;
        mediaPipeException$StatusCodeArray[6] = mediaPipeException$StatusCode7;
        mediaPipeException$StatusCodeArray[7] = mediaPipeException$StatusCode6;
        mediaPipeException$StatusCodeArray[8] = mediaPipeException$StatusCode5;
        mediaPipeException$StatusCodeArray[9] = mediaPipeException$StatusCode4;
        mediaPipeException$StatusCodeArray[10] = mediaPipeException$StatusCode3;
        mediaPipeException$StatusCodeArray[11] = mediaPipeException$StatusCode2;
        mediaPipeException$StatusCodeArray[12] = mediaPipeException$StatusCode14;
        mediaPipeException$StatusCodeArray[13] = mediaPipeException$StatusCodeArray2;
        mediaPipeException$StatusCodeArray[14] = mediaPipeException$StatusCode15;
        mediaPipeException$StatusCodeArray[15] = mediaPipeException$StatusCodeArray3;
        mediaPipeException$StatusCodeArray[n10] = mediaPipeException$StatusCode;
        $VALUES = mediaPipeException$StatusCodeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MediaPipeException$StatusCode() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.description = var3_1;
    }

    public static MediaPipeException$StatusCode valueOf(String string2) {
        return Enum.valueOf(MediaPipeException$StatusCode.class, string2);
    }

    public static MediaPipeException$StatusCode[] values() {
        return (MediaPipeException$StatusCode[])$VALUES.clone();
    }

    public String description() {
        return this.description;
    }
}

