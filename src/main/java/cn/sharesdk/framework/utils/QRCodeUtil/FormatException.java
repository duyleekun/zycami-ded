/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

import cn.sharesdk.framework.utils.QRCodeUtil.ReaderException;

public final class FormatException
extends ReaderException {
    private static final FormatException INSTANCE;

    static {
        FormatException formatException;
        INSTANCE = formatException = new FormatException();
        StackTraceElement[] stackTraceElementArray = ReaderException.NO_TRACE;
        formatException.setStackTrace(stackTraceElementArray);
    }

    private FormatException() {
    }

    private FormatException(Throwable throwable) {
        super(throwable);
    }

    public static FormatException getFormatInstance() {
        boolean bl2 = ReaderException.isStackTrace;
        FormatException formatException = bl2 ? new FormatException() : INSTANCE;
        return formatException;
    }

    public static FormatException getFormatInstance(Throwable throwable) {
        boolean bl2 = ReaderException.isStackTrace;
        FormatException formatException = bl2 ? new FormatException(throwable) : INSTANCE;
        return formatException;
    }
}

