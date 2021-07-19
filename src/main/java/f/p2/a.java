/*
 * Decompiled with CFR 0.151.
 */
package f.p2;

public final class a {
    private static final Void a(int n10) {
        System.exit(n10);
        RuntimeException runtimeException = new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        throw runtimeException;
    }
}

