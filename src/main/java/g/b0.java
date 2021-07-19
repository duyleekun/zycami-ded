/*
 * Decompiled with CFR 0.151.
 */
package g;

import g.b0$a;
import g.v;
import h.n;
import java.io.File;
import okio.ByteString;

public abstract class b0 {
    public static final b0$a Companion;

    static {
        b0$a b0$a;
        Companion = b0$a = new b0$a(null);
    }

    public static final b0 create(v v10, File file) {
        return Companion.c(v10, file);
    }

    public static final b0 create(v v10, String string2) {
        return Companion.d(v10, string2);
    }

    public static final b0 create(v v10, ByteString byteString) {
        return Companion.e(v10, byteString);
    }

    public static final b0 create(v v10, byte[] byArray) {
        return b0$a.p(Companion, v10, byArray, 0, 0, 12, null);
    }

    public static final b0 create(v v10, byte[] byArray, int n10) {
        return b0$a.p(Companion, v10, byArray, n10, 0, 8, null);
    }

    public static final b0 create(v v10, byte[] byArray, int n10, int n11) {
        return Companion.h(v10, byArray, n10, n11);
    }

    public static final b0 create(File file, v v10) {
        return Companion.a(file, v10);
    }

    public static final b0 create(String string2, v v10) {
        return Companion.b(string2, v10);
    }

    public static final b0 create(ByteString byteString, v v10) {
        return Companion.i(byteString, v10);
    }

    public static final b0 create(byte[] byArray) {
        return b0$a.r(Companion, byArray, null, 0, 0, 7, null);
    }

    public static final b0 create(byte[] byArray, v v10) {
        return b0$a.r(Companion, byArray, v10, 0, 0, 6, null);
    }

    public static final b0 create(byte[] byArray, v v10, int n10) {
        return b0$a.r(Companion, byArray, v10, n10, 0, 4, null);
    }

    public static final b0 create(byte[] byArray, v v10, int n10, int n11) {
        return Companion.m(byArray, v10, n10, n11);
    }

    public long contentLength() {
        return -1;
    }

    public abstract v contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(n var1);
}

