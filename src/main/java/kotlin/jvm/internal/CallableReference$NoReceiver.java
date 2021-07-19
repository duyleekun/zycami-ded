/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import java.io.Serializable;

public class CallableReference$NoReceiver
implements Serializable {
    private static final CallableReference$NoReceiver a;

    static {
        CallableReference$NoReceiver callableReference$NoReceiver;
        a = callableReference$NoReceiver = new CallableReference$NoReceiver();
    }

    private CallableReference$NoReceiver() {
    }

    public static /* synthetic */ CallableReference$NoReceiver access$000() {
        return a;
    }

    private Object readResolve() {
        return a;
    }
}

