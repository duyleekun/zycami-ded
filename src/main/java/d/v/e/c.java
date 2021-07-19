/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  android.os.SystemClock
 */
package d.v.e;

import android.os.Process;
import android.os.SystemClock;
import d.v.e.a;
import d.v.e.c$a;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class c
implements Thread.UncaughtExceptionHandler {
    private static c c;
    private Thread.UncaughtExceptionHandler a;
    private Set b;

    static {
        c c10;
        c = c10 = new c();
    }

    private c() {
        HashSet hashSet;
        this.b = hashSet = new HashSet();
    }

    public static c b() {
        return c;
    }

    private void c() {
        Stream stream = this.b.stream();
        a a10 = d.v.e.a.a;
        stream.forEach(a10);
    }

    public void a(c$a c$a) {
        if (c$a == null) {
            return;
        }
        this.b.add(c$a);
    }

    public void d() {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        this.a = uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void e() {
        this.b.clear();
    }

    public void f(c$a c$a) {
        if (c$a == null) {
            return;
        }
        this.b.remove(c$a);
    }

    public void uncaughtException(Thread thread, Throwable throwable) {
        this.c();
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, throwable);
        } else {
            long l10 = 1000L;
            SystemClock.sleep((long)l10);
            Process.killProcess((int)Process.myPid());
            thread = null;
            System.exit(0);
        }
    }
}

