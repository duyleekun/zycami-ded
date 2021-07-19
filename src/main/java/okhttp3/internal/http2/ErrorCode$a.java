/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.http2;

import f.h2.t.u;
import okhttp3.internal.http2.ErrorCode;

public final class ErrorCode$a {
    private ErrorCode$a() {
    }

    public /* synthetic */ ErrorCode$a(u u10) {
        this();
    }

    public final ErrorCode a(int n10) {
        ErrorCode errorCode2;
        block2: {
            for (ErrorCode errorCode2 : ErrorCode.values()) {
                int n11 = errorCode2.getHttpCode();
                n11 = n11 == n10 ? 1 : 0;
                if (n11 == 0) {
                    continue;
                }
                break block2;
            }
            errorCode2 = null;
        }
        return errorCode2;
    }
}

