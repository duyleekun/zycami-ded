/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

public abstract class ReaderException
extends Exception {
    public static final StackTraceElement[] NO_TRACE;
    public static final boolean isStackTrace;

    static {
        boolean bl2;
        String string2 = System.getProperty("surefire.test.class.path");
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        isStackTrace = bl2;
        NO_TRACE = new StackTraceElement[0];
    }

    public ReaderException() {
    }

    public ReaderException(Throwable throwable) {
        super(throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final Throwable fillInStackTrace() {
        // MONITORENTER : this
        // MONITOREXIT : this
        return null;
    }
}

