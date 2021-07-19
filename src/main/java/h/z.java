/*
 * Decompiled with CFR 0.151.
 */
package h;

import h.a0;
import h.b0;
import h.k0;
import h.m0;
import h.n;
import h.o;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;

public final class z {
    public static final k0 a(File file) {
        return a0.b(file);
    }

    public static final k0 b() {
        return b0.a();
    }

    public static final n c(k0 k02) {
        return b0.b(k02);
    }

    public static final o d(m0 m02) {
        return b0.c(m02);
    }

    public static final boolean e(AssertionError assertionError) {
        return a0.d(assertionError);
    }

    public static final k0 f(File file) {
        return z.k(file, false, 1, null);
    }

    public static final k0 g(File file, boolean bl2) {
        return a0.f(file, bl2);
    }

    public static final k0 h(OutputStream outputStream) {
        return a0.g(outputStream);
    }

    public static final k0 i(Socket socket) {
        return a0.h(socket);
    }

    public static final k0 j(Path path, OpenOption ... openOptionArray) {
        return a0.i(path, openOptionArray);
    }

    public static /* synthetic */ k0 k(File file, boolean bl2, int n10, Object object) {
        return a0.j(file, bl2, n10, object);
    }

    public static final m0 l(File file) {
        return a0.k(file);
    }

    public static final m0 m(InputStream inputStream) {
        return a0.l(inputStream);
    }

    public static final m0 n(Socket socket) {
        return a0.m(socket);
    }

    public static final m0 o(Path path, OpenOption ... openOptionArray) {
        return a0.n(path, openOptionArray);
    }
}

