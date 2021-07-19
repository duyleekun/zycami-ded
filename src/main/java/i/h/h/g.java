/*
 * Decompiled with CFR 0.151.
 */
package i.h.h;

import i.h.c;
import i.h.g.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import org.slf4j.Marker;
import org.slf4j.helpers.NOPLogger;

public class g
implements c {
    private final String a;
    private volatile c b;
    private Boolean c;
    private Method d;
    private b e;
    private Queue f;
    private final boolean g;

    public g(String string2, Queue queue, boolean bl2) {
        this.a = string2;
        this.f = queue;
        this.g = bl2;
    }

    private c c() {
        b b10 = this.e;
        if (b10 == null) {
            Queue queue = this.f;
            this.e = b10 = new b(this, queue);
        }
        return this.e;
    }

    public c b() {
        c c10 = this.b;
        if (c10 != null) {
            return this.b;
        }
        boolean bl2 = this.g;
        if (bl2) {
            return NOPLogger.NOP_LOGGER;
        }
        return this.c();
    }

    public boolean d() {
        Object object = this.c;
        if (object != null) {
            return (Boolean)object;
        }
        object = this.b;
        object = object.getClass();
        String string2 = "log";
        int n10 = 1;
        Class[] classArray = new Class[n10];
        Class<i.h.g.c> clazz = i.h.g.c.class;
        classArray[0] = clazz;
        object = ((Class)object).getMethod(string2, classArray);
        this.d = object;
        object = Boolean.TRUE;
        try {
            this.c = object;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object = Boolean.FALSE;
            this.c = object;
        }
        return this.c;
    }

    public void debug(String string2) {
        this.b().debug(string2);
    }

    public void debug(String string2, Object object) {
        this.b().debug(string2, object);
    }

    public void debug(String string2, Object object, Object object2) {
        this.b().debug(string2, object, object2);
    }

    public void debug(String string2, Throwable throwable) {
        this.b().debug(string2, throwable);
    }

    public void debug(String string2, Object ... objectArray) {
        this.b().debug(string2, objectArray);
    }

    public void debug(Marker marker, String string2) {
        this.b().debug(marker, string2);
    }

    public void debug(Marker marker, String string2, Object object) {
        this.b().debug(marker, string2, object);
    }

    public void debug(Marker marker, String string2, Object object, Object object2) {
        this.b().debug(marker, string2, object, object2);
    }

    public void debug(Marker marker, String string2, Throwable throwable) {
        this.b().debug(marker, string2, throwable);
    }

    public void debug(Marker marker, String string2, Object ... objectArray) {
        this.b().debug(marker, string2, objectArray);
    }

    public boolean e() {
        return this.b instanceof NOPLogger;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object2 = this.getClass()) == (clazz = object.getClass())) {
            object = (g)object;
            object2 = this.a;
            object = ((g)object).a;
            boolean bl3 = ((String)object2).equals(object);
            if (!bl3) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public void error(String string2) {
        this.b().error(string2);
    }

    public void error(String string2, Object object) {
        this.b().error(string2, object);
    }

    public void error(String string2, Object object, Object object2) {
        this.b().error(string2, object, object2);
    }

    public void error(String string2, Throwable throwable) {
        this.b().error(string2, throwable);
    }

    public void error(String string2, Object ... objectArray) {
        this.b().error(string2, objectArray);
    }

    public void error(Marker marker, String string2) {
        this.b().error(marker, string2);
    }

    public void error(Marker marker, String string2, Object object) {
        this.b().error(marker, string2, object);
    }

    public void error(Marker marker, String string2, Object object, Object object2) {
        this.b().error(marker, string2, object, object2);
    }

    public void error(Marker marker, String string2, Throwable throwable) {
        this.b().error(marker, string2, throwable);
    }

    public void error(Marker marker, String string2, Object ... objectArray) {
        this.b().error(marker, string2, objectArray);
    }

    public boolean f() {
        boolean bl2;
        c c10 = this.b;
        if (c10 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            c10 = null;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void g(i.h.g.c c10) {
        boolean bl2 = this.d();
        if (!bl2) return;
        try {
            Method method = this.d;
            c c11 = this.b;
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = c10;
            method.invoke(c11, objectArray);
            return;
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exception) {
            return;
        }
    }

    public String getName() {
        return this.a;
    }

    public void h(c c10) {
        this.b = c10;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void info(String string2) {
        this.b().info(string2);
    }

    public void info(String string2, Object object) {
        this.b().info(string2, object);
    }

    public void info(String string2, Object object, Object object2) {
        this.b().info(string2, object, object2);
    }

    public void info(String string2, Throwable throwable) {
        this.b().info(string2, throwable);
    }

    public void info(String string2, Object ... objectArray) {
        this.b().info(string2, objectArray);
    }

    public void info(Marker marker, String string2) {
        this.b().info(marker, string2);
    }

    public void info(Marker marker, String string2, Object object) {
        this.b().info(marker, string2, object);
    }

    public void info(Marker marker, String string2, Object object, Object object2) {
        this.b().info(marker, string2, object, object2);
    }

    public void info(Marker marker, String string2, Throwable throwable) {
        this.b().info(marker, string2, throwable);
    }

    public void info(Marker marker, String string2, Object ... objectArray) {
        this.b().info(marker, string2, objectArray);
    }

    public boolean isDebugEnabled() {
        return this.b().isDebugEnabled();
    }

    public boolean isDebugEnabled(Marker marker) {
        return this.b().isDebugEnabled(marker);
    }

    public boolean isErrorEnabled() {
        return this.b().isErrorEnabled();
    }

    public boolean isErrorEnabled(Marker marker) {
        return this.b().isErrorEnabled(marker);
    }

    public boolean isInfoEnabled() {
        return this.b().isInfoEnabled();
    }

    public boolean isInfoEnabled(Marker marker) {
        return this.b().isInfoEnabled(marker);
    }

    public boolean isTraceEnabled() {
        return this.b().isTraceEnabled();
    }

    public boolean isTraceEnabled(Marker marker) {
        return this.b().isTraceEnabled(marker);
    }

    public boolean isWarnEnabled() {
        return this.b().isWarnEnabled();
    }

    public boolean isWarnEnabled(Marker marker) {
        return this.b().isWarnEnabled(marker);
    }

    public void trace(String string2) {
        this.b().trace(string2);
    }

    public void trace(String string2, Object object) {
        this.b().trace(string2, object);
    }

    public void trace(String string2, Object object, Object object2) {
        this.b().trace(string2, object, object2);
    }

    public void trace(String string2, Throwable throwable) {
        this.b().trace(string2, throwable);
    }

    public void trace(String string2, Object ... objectArray) {
        this.b().trace(string2, objectArray);
    }

    public void trace(Marker marker, String string2) {
        this.b().trace(marker, string2);
    }

    public void trace(Marker marker, String string2, Object object) {
        this.b().trace(marker, string2, object);
    }

    public void trace(Marker marker, String string2, Object object, Object object2) {
        this.b().trace(marker, string2, object, object2);
    }

    public void trace(Marker marker, String string2, Throwable throwable) {
        this.b().trace(marker, string2, throwable);
    }

    public void trace(Marker marker, String string2, Object ... objectArray) {
        this.b().trace(marker, string2, objectArray);
    }

    public void warn(String string2) {
        this.b().warn(string2);
    }

    public void warn(String string2, Object object) {
        this.b().warn(string2, object);
    }

    public void warn(String string2, Object object, Object object2) {
        this.b().warn(string2, object, object2);
    }

    public void warn(String string2, Throwable throwable) {
        this.b().warn(string2, throwable);
    }

    public void warn(String string2, Object ... objectArray) {
        this.b().warn(string2, objectArray);
    }

    public void warn(Marker marker, String string2) {
        this.b().warn(marker, string2);
    }

    public void warn(Marker marker, String string2, Object object) {
        this.b().warn(marker, string2, object);
    }

    public void warn(Marker marker, String string2, Object object, Object object2) {
        this.b().warn(marker, string2, object, object2);
    }

    public void warn(Marker marker, String string2, Throwable throwable) {
        this.b().warn(marker, string2, throwable);
    }

    public void warn(Marker marker, String string2, Object ... objectArray) {
        this.b().warn(marker, string2, objectArray);
    }
}

