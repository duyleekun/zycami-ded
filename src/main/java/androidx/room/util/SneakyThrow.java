/*
 * Decompiled with CFR 0.151.
 */
package androidx.room.util;

public class SneakyThrow {
    private SneakyThrow() {
    }

    public static void reThrow(Exception exception) {
        SneakyThrow.sneakyThrow(exception);
    }

    private static void sneakyThrow(Throwable throwable) {
        throw throwable;
    }
}

