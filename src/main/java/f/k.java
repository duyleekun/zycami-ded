/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.d2.l;
import f.h2.t.f0;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Objects;

public class k {
    public static final void a(Throwable throwable, Throwable throwable2) {
        f0.p(throwable, "$this$addSuppressed");
        Object object = "exception";
        f0.p(throwable2, (String)object);
        if (throwable != throwable2) {
            object = l.a;
            ((f.d2.k)object).a(throwable, throwable2);
        }
    }

    public static final StackTraceElement[] b(Throwable stackTraceElementArray) {
        f0.p(stackTraceElementArray, "$this$stackTrace");
        stackTraceElementArray = stackTraceElementArray.getStackTrace();
        f0.m(stackTraceElementArray);
        return stackTraceElementArray;
    }

    public static /* synthetic */ void c(Throwable throwable) {
    }

    public static final List d(Throwable throwable) {
        f0.p(throwable, "$this$suppressedExceptions");
        return l.a.d(throwable);
    }

    public static /* synthetic */ void e(Throwable throwable) {
    }

    private static final void f(Throwable throwable) {
        Objects.requireNonNull(throwable, "null cannot be cast to non-null type java.lang.Throwable");
        throwable.printStackTrace();
    }

    private static final void g(Throwable throwable, PrintStream printStream) {
        Objects.requireNonNull(throwable, "null cannot be cast to non-null type java.lang.Throwable");
        throwable.printStackTrace(printStream);
    }

    private static final void h(Throwable throwable, PrintWriter printWriter) {
        Objects.requireNonNull(throwable, "null cannot be cast to non-null type java.lang.Throwable");
        throwable.printStackTrace(printWriter);
    }

    public static final String i(Throwable object) {
        f0.p(object, "$this$stackTraceToString");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ((Throwable)object).printStackTrace(printWriter);
        printWriter.flush();
        object = stringWriter.toString();
        f0.o(object, "sw.toString()");
        return object;
    }
}

