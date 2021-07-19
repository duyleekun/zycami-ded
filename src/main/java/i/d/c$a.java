/*
 * Decompiled with CFR 0.151.
 */
package i.d;

import javax.net.ssl.SSLEngineResult;

public class c$a {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        Enum enum_;
        int n11;
        Object object2;
        int n12;
        Object object3;
        int n13;
        Object object4;
        int n14 = SSLEngineResult.HandshakeStatus.values().length;
        int[] nArray = new int[n14];
        b = nArray;
        int n15 = 1;
        try {
            object4 = SSLEngineResult.HandshakeStatus.FINISHED;
            n13 = object4.ordinal();
            nArray[n13] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 2;
        try {
            object4 = b;
            object3 = SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
            n12 = object3.ordinal();
            object4[n12] = (SSLEngineResult.HandshakeStatus)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 3;
        try {
            object3 = b;
            object2 = SSLEngineResult.HandshakeStatus.NEED_WRAP;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (SSLEngineResult.HandshakeStatus)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 4;
        try {
            object2 = b;
            enum_ = SSLEngineResult.HandshakeStatus.NEED_TASK;
            n10 = enum_.ordinal();
            object2[n10] = (SSLEngineResult.HandshakeStatus)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
            n10 = enum_.ordinal();
            int n16 = 5;
            object2[n10] = (SSLEngineResult.HandshakeStatus)n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = SSLEngineResult.Status.values().length;
        object2 = new int[n11];
        a = (int[])object2;
        try {
            enum_ = SSLEngineResult.Status.OK;
            n10 = enum_.ordinal();
            object2[n10] = (SSLEngineResult.HandshakeStatus)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = a;
            object2 = SSLEngineResult.Status.BUFFER_UNDERFLOW;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = (Object)SSLEngineResult.Status.BUFFER_OVERFLOW;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = SSLEngineResult.Status.CLOSED;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n12;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

