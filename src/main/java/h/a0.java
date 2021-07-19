/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.d0;
import h.k0;
import h.l0;
import h.m0;
import h.o0;
import h.y;
import h.z;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.text.StringsKt__StringsKt;

public final class a0 {
    private static final Logger a = Logger.getLogger("okio.Okio");

    public static final /* synthetic */ Logger a() {
        return a;
    }

    public static final k0 b(File file) {
        f0.p(file, "$this$appendingSink");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        return z.h(fileOutputStream);
    }

    private static final Logger c() {
        return a;
    }

    public static final boolean d(AssertionError object) {
        f0.p(object, "$this$isAndroidGetsocknameError");
        Throwable throwable = ((Throwable)object).getCause();
        boolean bl2 = false;
        if (throwable != null) {
            boolean bl3;
            if ((object = ((Throwable)object).getMessage()) != null) {
                int n10 = 2;
                String string2 = "getsockname failed";
                bl3 = StringsKt__StringsKt.P2((CharSequence)object, string2, false, n10, null);
            } else {
                bl3 = false;
                object = null;
            }
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public static final k0 e(File file) {
        return z.k(file, false, 1, null);
    }

    public static final k0 f(File file, boolean bl2) {
        f0.p(file, "$this$sink");
        FileOutputStream fileOutputStream = new FileOutputStream(file, bl2);
        return z.h(fileOutputStream);
    }

    public static final k0 g(OutputStream outputStream) {
        f0.p(outputStream, "$this$sink");
        o0 o02 = new o0();
        d0 d02 = new d0(outputStream, o02);
        return d02;
    }

    public static final k0 h(Socket closeable) {
        f0.p(closeable, "$this$sink");
        l0 l02 = new l0((Socket)closeable);
        closeable = closeable.getOutputStream();
        f0.o(closeable, "getOutputStream()");
        d0 d02 = new d0((OutputStream)closeable, l02);
        return l02.z(d02);
    }

    public static final k0 i(Path object, OpenOption ... openOptionArray) {
        f0.p(object, "$this$sink");
        f0.p(openOptionArray, "options");
        int n10 = openOptionArray.length;
        openOptionArray = Arrays.copyOf(openOptionArray, n10);
        object = Files.newOutputStream((Path)object, openOptionArray);
        f0.o(object, "Files.newOutputStream(this, *options)");
        return z.h((OutputStream)object);
    }

    public static /* synthetic */ k0 j(File file, boolean bl2, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            bl2 = false;
        }
        return z.g(file, bl2);
    }

    public static final m0 k(File file) {
        f0.p(file, "$this$source");
        FileInputStream fileInputStream = new FileInputStream(file);
        return z.m(fileInputStream);
    }

    public static final m0 l(InputStream inputStream) {
        f0.p(inputStream, "$this$source");
        o0 o02 = new o0();
        y y10 = new y(inputStream, o02);
        return y10;
    }

    public static final m0 m(Socket closeable) {
        f0.p(closeable, "$this$source");
        l0 l02 = new l0((Socket)closeable);
        closeable = closeable.getInputStream();
        f0.o(closeable, "getInputStream()");
        y y10 = new y((InputStream)closeable, l02);
        return l02.A(y10);
    }

    public static final m0 n(Path object, OpenOption ... openOptionArray) {
        f0.p(object, "$this$source");
        f0.p(openOptionArray, "options");
        int n10 = openOptionArray.length;
        openOptionArray = Arrays.copyOf(openOptionArray, n10);
        object = Files.newInputStream((Path)object, openOptionArray);
        f0.o(object, "Files.newInputStream(this, *options)");
        return z.m((InputStream)object);
    }
}

