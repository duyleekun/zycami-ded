/*
 * Decompiled with CFR 0.151.
 */
package f.e2;

import f.e2.m;
import f.h2.t.f0;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

public final class c {
    private static final void a(byte by2) {
        PrintStream printStream = System.out;
        Byte by3 = by2;
        printStream.print(by3);
    }

    private static final void b(char c10) {
        System.out.print(c10);
    }

    private static final void c(double d10) {
        System.out.print(d10);
    }

    private static final void d(float f10) {
        System.out.print(f10);
    }

    private static final void e(int n10) {
        System.out.print(n10);
    }

    private static final void f(long l10) {
        System.out.print(l10);
    }

    private static final void g(Object object) {
        System.out.print(object);
    }

    private static final void h(short s10) {
        PrintStream printStream = System.out;
        Short s11 = s10;
        printStream.print(s11);
    }

    private static final void i(boolean bl2) {
        System.out.print(bl2);
    }

    private static final void j(char[] cArray) {
        System.out.print(cArray);
    }

    private static final void k() {
        System.out.println();
    }

    private static final void l(byte by2) {
        PrintStream printStream = System.out;
        Byte by3 = by2;
        printStream.println(by3);
    }

    private static final void m(char c10) {
        System.out.println(c10);
    }

    private static final void n(double d10) {
        System.out.println(d10);
    }

    private static final void o(float f10) {
        System.out.println(f10);
    }

    private static final void p(int n10) {
        System.out.println(n10);
    }

    private static final void q(long l10) {
        System.out.println(l10);
    }

    private static final void r(Object object) {
        System.out.println(object);
    }

    private static final void s(short s10) {
        PrintStream printStream = System.out;
        Short s11 = s10;
        printStream.println(s11);
    }

    private static final void t(boolean bl2) {
        System.out.println(bl2);
    }

    private static final void u(char[] cArray) {
        System.out.println(cArray);
    }

    public static final String v() {
        m m10 = m.i;
        InputStream inputStream = System.in;
        f0.o(inputStream, "System.`in`");
        Charset charset = Charset.defaultCharset();
        f0.o(charset, "Charset.defaultCharset()");
        return m10.f(inputStream, charset);
    }
}

