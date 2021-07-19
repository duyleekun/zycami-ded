/*
 * Decompiled with CFR 0.151.
 */
package m.a;

import java.io.PrintWriter;
import java.io.StringWriter;

public abstract class a$c {
    public final ThreadLocal a;

    public a$c() {
        ThreadLocal threadLocal;
        this.a = threadLocal = new ThreadLocal();
    }

    private String h(Throwable throwable) {
        StringWriter stringWriter = new StringWriter(256);
        PrintWriter printWriter = new PrintWriter(stringWriter, false);
        throwable.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    private void s(int n10, Throwable throwable, String string2, Object ... objectArray) {
        String string3 = this.i();
        int n11 = this.n(string3, n10);
        if (n11 == 0) {
            return;
        }
        if (string2 != null && (n11 = string2.length()) == 0) {
            string2 = null;
        }
        if (string2 == null) {
            if (throwable == null) {
                return;
            }
            string2 = this.h(throwable);
        } else {
            if (objectArray != null && (n11 = objectArray.length) > 0) {
                string2 = this.g(string2, objectArray);
            }
            if (throwable != null) {
                objectArray = new StringBuilder();
                objectArray.append(string2);
                objectArray.append("\n");
                string2 = this.h(throwable);
                objectArray.append(string2);
                string2 = objectArray.toString();
            }
        }
        this.o(n10, string3, string2, throwable);
    }

    public void A(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        this.s(7, throwable, null, objectArray);
    }

    public void B(Throwable throwable, String string2, Object ... objectArray) {
        this.s(7, throwable, string2, objectArray);
    }

    public void a(String string2, Object ... objectArray) {
        this.s(3, null, string2, objectArray);
    }

    public void b(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        this.s(3, throwable, null, objectArray);
    }

    public void c(Throwable throwable, String string2, Object ... objectArray) {
        this.s(3, throwable, string2, objectArray);
    }

    public void d(String string2, Object ... objectArray) {
        this.s(6, null, string2, objectArray);
    }

    public void e(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        this.s(6, throwable, null, objectArray);
    }

    public void f(Throwable throwable, String string2, Object ... objectArray) {
        this.s(6, throwable, string2, objectArray);
    }

    public String g(String string2, Object[] objectArray) {
        return String.format(string2, objectArray);
    }

    public String i() {
        String string2 = (String)this.a.get();
        if (string2 != null) {
            ThreadLocal threadLocal = this.a;
            threadLocal.remove();
        }
        return string2;
    }

    public void j(String string2, Object ... objectArray) {
        this.s(4, null, string2, objectArray);
    }

    public void k(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        this.s(4, throwable, null, objectArray);
    }

    public void l(Throwable throwable, String string2, Object ... objectArray) {
        this.s(4, throwable, string2, objectArray);
    }

    public boolean m(int n10) {
        return true;
    }

    public boolean n(String string2, int n10) {
        return this.m(n10);
    }

    public abstract void o(int var1, String var2, String var3, Throwable var4);

    public void p(int n10, String string2, Object ... objectArray) {
        this.s(n10, null, string2, objectArray);
    }

    public void q(int n10, Throwable throwable) {
        Object[] objectArray = new Object[]{};
        this.s(n10, throwable, null, objectArray);
    }

    public void r(int n10, Throwable throwable, String string2, Object ... objectArray) {
        this.s(n10, throwable, string2, objectArray);
    }

    public void t(String string2, Object ... objectArray) {
        this.s(2, null, string2, objectArray);
    }

    public void u(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        this.s(2, throwable, null, objectArray);
    }

    public void v(Throwable throwable, String string2, Object ... objectArray) {
        this.s(2, throwable, string2, objectArray);
    }

    public void w(String string2, Object ... objectArray) {
        this.s(5, null, string2, objectArray);
    }

    public void x(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        this.s(5, throwable, null, objectArray);
    }

    public void y(Throwable throwable, String string2, Object ... objectArray) {
        this.s(5, throwable, string2, objectArray);
    }

    public void z(String string2, Object ... objectArray) {
        this.s(7, null, string2, objectArray);
    }
}

