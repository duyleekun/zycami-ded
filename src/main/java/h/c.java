/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.k0;
import h.m0;
import h.n;
import h.o;
import h.z;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;

public final class c {
    public static final c a;

    static {
        c c10;
        a = c10 = new c();
    }

    private c() {
    }

    public final k0 a(File file) {
        f0.p(file, "file");
        return z.a(file);
    }

    public final k0 b() {
        return z.b();
    }

    public final n c(k0 k02) {
        f0.p(k02, "sink");
        return z.c(k02);
    }

    public final o d(m0 m02) {
        f0.p(m02, "source");
        return z.d(m02);
    }

    public final k0 e(File file) {
        f0.p(file, "file");
        return z.k(file, false, 1, null);
    }

    public final k0 f(OutputStream outputStream) {
        f0.p(outputStream, "outputStream");
        return z.h(outputStream);
    }

    public final k0 g(Socket socket) {
        f0.p(socket, "socket");
        return z.i(socket);
    }

    public final k0 h(Path path, OpenOption ... openOptionArray) {
        f0.p(path, "path");
        f0.p(openOptionArray, "options");
        int n10 = openOptionArray.length;
        openOptionArray = Arrays.copyOf(openOptionArray, n10);
        return z.j(path, openOptionArray);
    }

    public final m0 i(File file) {
        f0.p(file, "file");
        return z.l(file);
    }

    public final m0 j(InputStream inputStream) {
        f0.p(inputStream, "inputStream");
        return z.m(inputStream);
    }

    public final m0 k(Socket socket) {
        f0.p(socket, "socket");
        return z.n(socket);
    }

    public final m0 l(Path path, OpenOption ... openOptionArray) {
        f0.p(path, "path");
        f0.p(openOptionArray, "options");
        int n10 = openOptionArray.length;
        openOptionArray = Arrays.copyOf(openOptionArray, n10);
        return z.o(path, openOptionArray);
    }
}

