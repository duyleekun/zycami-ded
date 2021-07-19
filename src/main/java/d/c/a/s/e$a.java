/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.s;

public class e$a {
    public void a(Object object) {
        object.notifyAll();
    }

    public void b(Object object, long l10) {
        object.wait(l10);
    }
}

