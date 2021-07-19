/*
 * Decompiled with CFR 0.151.
 */
package i.h.g;

import i.h.c;
import i.h.g.d;
import i.h.h.g;
import java.util.Queue;
import org.slf4j.Marker;
import org.slf4j.event.Level;

public class b
implements c {
    public String a;
    public g b;
    public Queue c;

    public b(g object, Queue queue) {
        this.b = object;
        this.a = object = ((g)object).getName();
        this.c = queue;
    }

    private void b(Level level, String string2, Object[] objectArray, Throwable throwable) {
        this.c(level, null, string2, objectArray, throwable);
    }

    private void c(Level object, Marker marker, String string2, Object[] objectArray, Throwable throwable) {
        d d10 = new d();
        long l10 = System.currentTimeMillis();
        d10.p(l10);
        d10.i((Level)((Object)object));
        object = this.b;
        d10.j((g)object);
        object = this.a;
        d10.k((String)object);
        d10.l(marker);
        d10.m(string2);
        d10.h(objectArray);
        d10.o(throwable);
        object = Thread.currentThread().getName();
        d10.n((String)object);
        this.c.add(d10);
    }

    public void debug(String string2) {
        Level level = Level.TRACE;
        this.b(level, string2, null, null);
    }

    public void debug(String string2, Object object) {
        Level level = Level.DEBUG;
        Object[] objectArray = new Object[]{object};
        this.b(level, string2, objectArray, null);
    }

    public void debug(String string2, Object object, Object object2) {
        Level level = Level.DEBUG;
        Object[] objectArray = new Object[]{object, object2};
        this.b(level, string2, objectArray, null);
    }

    public void debug(String string2, Throwable throwable) {
        Level level = Level.DEBUG;
        this.b(level, string2, null, throwable);
    }

    public void debug(String string2, Object ... objectArray) {
        Level level = Level.DEBUG;
        this.b(level, string2, objectArray, null);
    }

    public void debug(Marker marker, String string2) {
        Level level = Level.DEBUG;
        this.c(level, marker, string2, null, null);
    }

    public void debug(Marker marker, String string2, Object object) {
        Level level = Level.DEBUG;
        Object[] objectArray = new Object[]{object};
        this.c(level, marker, string2, objectArray, null);
    }

    public void debug(Marker marker, String string2, Object object, Object object2) {
        Level level = Level.DEBUG;
        Object[] objectArray = new Object[]{object, object2};
        this.c(level, marker, string2, objectArray, null);
    }

    public void debug(Marker marker, String string2, Throwable throwable) {
        Level level = Level.DEBUG;
        this.c(level, marker, string2, null, throwable);
    }

    public void debug(Marker marker, String string2, Object ... objectArray) {
        Level level = Level.DEBUG;
        this.c(level, marker, string2, objectArray, null);
    }

    public void error(String string2) {
        Level level = Level.ERROR;
        this.b(level, string2, null, null);
    }

    public void error(String string2, Object object) {
        Level level = Level.ERROR;
        Object[] objectArray = new Object[]{object};
        this.b(level, string2, objectArray, null);
    }

    public void error(String string2, Object object, Object object2) {
        Level level = Level.ERROR;
        Object[] objectArray = new Object[]{object, object2};
        this.b(level, string2, objectArray, null);
    }

    public void error(String string2, Throwable throwable) {
        Level level = Level.ERROR;
        this.b(level, string2, null, throwable);
    }

    public void error(String string2, Object ... objectArray) {
        Level level = Level.ERROR;
        this.b(level, string2, objectArray, null);
    }

    public void error(Marker marker, String string2) {
        Level level = Level.ERROR;
        this.c(level, marker, string2, null, null);
    }

    public void error(Marker marker, String string2, Object object) {
        Level level = Level.ERROR;
        Object[] objectArray = new Object[]{object};
        this.c(level, marker, string2, objectArray, null);
    }

    public void error(Marker marker, String string2, Object object, Object object2) {
        Level level = Level.ERROR;
        Object[] objectArray = new Object[]{object, object2};
        this.c(level, marker, string2, objectArray, null);
    }

    public void error(Marker marker, String string2, Throwable throwable) {
        Level level = Level.ERROR;
        this.c(level, marker, string2, null, throwable);
    }

    public void error(Marker marker, String string2, Object ... objectArray) {
        Level level = Level.ERROR;
        this.c(level, marker, string2, objectArray, null);
    }

    public String getName() {
        return this.a;
    }

    public void info(String string2) {
        Level level = Level.INFO;
        this.b(level, string2, null, null);
    }

    public void info(String string2, Object object) {
        Level level = Level.INFO;
        Object[] objectArray = new Object[]{object};
        this.b(level, string2, objectArray, null);
    }

    public void info(String string2, Object object, Object object2) {
        Level level = Level.INFO;
        Object[] objectArray = new Object[]{object, object2};
        this.b(level, string2, objectArray, null);
    }

    public void info(String string2, Throwable throwable) {
        Level level = Level.INFO;
        this.b(level, string2, null, throwable);
    }

    public void info(String string2, Object ... objectArray) {
        Level level = Level.INFO;
        this.b(level, string2, objectArray, null);
    }

    public void info(Marker marker, String string2) {
        Level level = Level.INFO;
        this.c(level, marker, string2, null, null);
    }

    public void info(Marker marker, String string2, Object object) {
        Level level = Level.INFO;
        Object[] objectArray = new Object[]{object};
        this.c(level, marker, string2, objectArray, null);
    }

    public void info(Marker marker, String string2, Object object, Object object2) {
        Level level = Level.INFO;
        Object[] objectArray = new Object[]{object, object2};
        this.c(level, marker, string2, objectArray, null);
    }

    public void info(Marker marker, String string2, Throwable throwable) {
        Level level = Level.INFO;
        this.c(level, marker, string2, null, throwable);
    }

    public void info(Marker marker, String string2, Object ... objectArray) {
        Level level = Level.INFO;
        this.c(level, marker, string2, objectArray, null);
    }

    public boolean isDebugEnabled() {
        return true;
    }

    public boolean isDebugEnabled(Marker marker) {
        return true;
    }

    public boolean isErrorEnabled() {
        return true;
    }

    public boolean isErrorEnabled(Marker marker) {
        return true;
    }

    public boolean isInfoEnabled() {
        return true;
    }

    public boolean isInfoEnabled(Marker marker) {
        return true;
    }

    public boolean isTraceEnabled() {
        return true;
    }

    public boolean isTraceEnabled(Marker marker) {
        return true;
    }

    public boolean isWarnEnabled() {
        return true;
    }

    public boolean isWarnEnabled(Marker marker) {
        return true;
    }

    public void trace(String string2) {
        Level level = Level.TRACE;
        this.b(level, string2, null, null);
    }

    public void trace(String string2, Object object) {
        Level level = Level.TRACE;
        Object[] objectArray = new Object[]{object};
        this.b(level, string2, objectArray, null);
    }

    public void trace(String string2, Object object, Object object2) {
        Level level = Level.TRACE;
        Object[] objectArray = new Object[]{object, object2};
        this.b(level, string2, objectArray, null);
    }

    public void trace(String string2, Throwable throwable) {
        Level level = Level.TRACE;
        this.b(level, string2, null, throwable);
    }

    public void trace(String string2, Object ... objectArray) {
        Level level = Level.TRACE;
        this.b(level, string2, objectArray, null);
    }

    public void trace(Marker marker, String string2) {
        Level level = Level.TRACE;
        this.c(level, marker, string2, null, null);
    }

    public void trace(Marker marker, String string2, Object object) {
        Level level = Level.TRACE;
        Object[] objectArray = new Object[]{object};
        this.c(level, marker, string2, objectArray, null);
    }

    public void trace(Marker marker, String string2, Object object, Object object2) {
        Level level = Level.TRACE;
        Object[] objectArray = new Object[]{object, object2};
        this.c(level, marker, string2, objectArray, null);
    }

    public void trace(Marker marker, String string2, Throwable throwable) {
        Level level = Level.TRACE;
        this.c(level, marker, string2, null, throwable);
    }

    public void trace(Marker marker, String string2, Object ... objectArray) {
        Level level = Level.TRACE;
        this.c(level, marker, string2, objectArray, null);
    }

    public void warn(String string2) {
        Level level = Level.WARN;
        this.b(level, string2, null, null);
    }

    public void warn(String string2, Object object) {
        Level level = Level.WARN;
        Object[] objectArray = new Object[]{object};
        this.b(level, string2, objectArray, null);
    }

    public void warn(String string2, Object object, Object object2) {
        Level level = Level.WARN;
        Object[] objectArray = new Object[]{object, object2};
        this.b(level, string2, objectArray, null);
    }

    public void warn(String string2, Throwable throwable) {
        Level level = Level.WARN;
        this.b(level, string2, null, throwable);
    }

    public void warn(String string2, Object ... objectArray) {
        Level level = Level.WARN;
        this.b(level, string2, objectArray, null);
    }

    public void warn(Marker object, String string2) {
        object = Level.WARN;
        this.b((Level)((Object)object), string2, null, null);
    }

    public void warn(Marker object, String string2, Object object2) {
        object = Level.WARN;
        Object[] objectArray = new Object[]{object2};
        this.b((Level)((Object)object), string2, objectArray, null);
    }

    public void warn(Marker marker, String string2, Object object, Object object2) {
        Level level = Level.WARN;
        Object[] objectArray = new Object[]{object, object2};
        this.c(level, marker, string2, objectArray, null);
    }

    public void warn(Marker marker, String string2, Throwable throwable) {
        Level level = Level.WARN;
        this.c(level, marker, string2, null, throwable);
    }

    public void warn(Marker marker, String string2, Object ... objectArray) {
        Level level = Level.WARN;
        this.c(level, marker, string2, objectArray, null);
    }
}

