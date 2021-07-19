/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.http2;

import f.h2.t.f0;
import java.io.IOException;
import okhttp3.internal.http2.ErrorCode;

public final class StreamResetException
extends IOException {
    public final ErrorCode errorCode;

    public StreamResetException(ErrorCode errorCode) {
        f0.p((Object)errorCode, "errorCode");
        CharSequence charSequence = new StringBuilder();
        charSequence.append("stream was reset: ");
        charSequence.append((Object)errorCode);
        charSequence = charSequence.toString();
        super((String)charSequence);
        this.errorCode = errorCode;
    }
}

