/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.http2;

import okhttp3.internal.http2.ErrorCode$a;

public final class ErrorCode
extends Enum {
    public static final /* enum */ ErrorCode CANCEL;
    public static final /* enum */ ErrorCode COMPRESSION_ERROR;
    public static final /* enum */ ErrorCode CONNECT_ERROR;
    public static final ErrorCode$a Companion;
    public static final /* enum */ ErrorCode ENHANCE_YOUR_CALM;
    public static final /* enum */ ErrorCode FLOW_CONTROL_ERROR;
    public static final /* enum */ ErrorCode FRAME_SIZE_ERROR;
    public static final /* enum */ ErrorCode HTTP_1_1_REQUIRED;
    public static final /* enum */ ErrorCode INADEQUATE_SECURITY;
    public static final /* enum */ ErrorCode INTERNAL_ERROR;
    public static final /* enum */ ErrorCode NO_ERROR;
    public static final /* enum */ ErrorCode PROTOCOL_ERROR;
    public static final /* enum */ ErrorCode REFUSED_STREAM;
    public static final /* enum */ ErrorCode SETTINGS_TIMEOUT;
    public static final /* enum */ ErrorCode STREAM_CLOSED;
    private static final /* synthetic */ ErrorCode[] a;
    private final int httpCode;

    static {
        ErrorCode errorCode;
        Object object = new ErrorCode[14];
        NO_ERROR = errorCode = new ErrorCode("NO_ERROR", 0, 0);
        object[0] = errorCode;
        int n10 = 1;
        PROTOCOL_ERROR = errorCode = new ErrorCode("PROTOCOL_ERROR", n10, n10);
        object[n10] = errorCode;
        n10 = 2;
        INTERNAL_ERROR = errorCode = new ErrorCode("INTERNAL_ERROR", n10, n10);
        object[n10] = errorCode;
        n10 = 3;
        FLOW_CONTROL_ERROR = errorCode = new ErrorCode("FLOW_CONTROL_ERROR", n10, n10);
        object[n10] = errorCode;
        n10 = 4;
        SETTINGS_TIMEOUT = errorCode = new ErrorCode("SETTINGS_TIMEOUT", n10, n10);
        object[n10] = errorCode;
        n10 = 5;
        STREAM_CLOSED = errorCode = new ErrorCode("STREAM_CLOSED", n10, n10);
        object[n10] = errorCode;
        n10 = 6;
        FRAME_SIZE_ERROR = errorCode = new ErrorCode("FRAME_SIZE_ERROR", n10, n10);
        object[n10] = errorCode;
        n10 = 7;
        REFUSED_STREAM = errorCode = new ErrorCode("REFUSED_STREAM", n10, n10);
        object[n10] = errorCode;
        n10 = 8;
        CANCEL = errorCode = new ErrorCode("CANCEL", n10, n10);
        object[n10] = errorCode;
        n10 = 9;
        COMPRESSION_ERROR = errorCode = new ErrorCode("COMPRESSION_ERROR", n10, n10);
        object[n10] = errorCode;
        n10 = 10;
        CONNECT_ERROR = errorCode = new ErrorCode("CONNECT_ERROR", n10, n10);
        object[n10] = errorCode;
        n10 = 11;
        ENHANCE_YOUR_CALM = errorCode = new ErrorCode("ENHANCE_YOUR_CALM", n10, n10);
        object[n10] = errorCode;
        n10 = 12;
        INADEQUATE_SECURITY = errorCode = new ErrorCode("INADEQUATE_SECURITY", n10, n10);
        object[n10] = errorCode;
        n10 = 13;
        HTTP_1_1_REQUIRED = errorCode = new ErrorCode("HTTP_1_1_REQUIRED", n10, n10);
        object[n10] = errorCode;
        a = object;
        Companion = object = new ErrorCode$a(null);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ErrorCode() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.httpCode = var3_1;
    }

    public static ErrorCode valueOf(String string2) {
        return Enum.valueOf(ErrorCode.class, string2);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[])a.clone();
    }

    public final int getHttpCode() {
        return this.httpCode;
    }
}

