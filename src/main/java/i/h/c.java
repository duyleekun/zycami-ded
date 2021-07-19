/*
 * Decompiled with CFR 0.151.
 */
package i.h;

import org.slf4j.Marker;

public interface c {
    public static final String h0 = "ROOT";

    public void debug(String var1);

    public void debug(String var1, Object var2);

    public void debug(String var1, Object var2, Object var3);

    public void debug(String var1, Throwable var2);

    public void debug(String var1, Object ... var2);

    public void debug(Marker var1, String var2);

    public void debug(Marker var1, String var2, Object var3);

    public void debug(Marker var1, String var2, Object var3, Object var4);

    public void debug(Marker var1, String var2, Throwable var3);

    public void debug(Marker var1, String var2, Object ... var3);

    public void error(String var1);

    public void error(String var1, Object var2);

    public void error(String var1, Object var2, Object var3);

    public void error(String var1, Throwable var2);

    public void error(String var1, Object ... var2);

    public void error(Marker var1, String var2);

    public void error(Marker var1, String var2, Object var3);

    public void error(Marker var1, String var2, Object var3, Object var4);

    public void error(Marker var1, String var2, Throwable var3);

    public void error(Marker var1, String var2, Object ... var3);

    public String getName();

    public void info(String var1);

    public void info(String var1, Object var2);

    public void info(String var1, Object var2, Object var3);

    public void info(String var1, Throwable var2);

    public void info(String var1, Object ... var2);

    public void info(Marker var1, String var2);

    public void info(Marker var1, String var2, Object var3);

    public void info(Marker var1, String var2, Object var3, Object var4);

    public void info(Marker var1, String var2, Throwable var3);

    public void info(Marker var1, String var2, Object ... var3);

    public boolean isDebugEnabled();

    public boolean isDebugEnabled(Marker var1);

    public boolean isErrorEnabled();

    public boolean isErrorEnabled(Marker var1);

    public boolean isInfoEnabled();

    public boolean isInfoEnabled(Marker var1);

    public boolean isTraceEnabled();

    public boolean isTraceEnabled(Marker var1);

    public boolean isWarnEnabled();

    public boolean isWarnEnabled(Marker var1);

    public void trace(String var1);

    public void trace(String var1, Object var2);

    public void trace(String var1, Object var2, Object var3);

    public void trace(String var1, Throwable var2);

    public void trace(String var1, Object ... var2);

    public void trace(Marker var1, String var2);

    public void trace(Marker var1, String var2, Object var3);

    public void trace(Marker var1, String var2, Object var3, Object var4);

    public void trace(Marker var1, String var2, Throwable var3);

    public void trace(Marker var1, String var2, Object ... var3);

    public void warn(String var1);

    public void warn(String var1, Object var2);

    public void warn(String var1, Object var2, Object var3);

    public void warn(String var1, Throwable var2);

    public void warn(String var1, Object ... var2);

    public void warn(Marker var1, String var2);

    public void warn(Marker var1, String var2, Object var3);

    public void warn(Marker var1, String var2, Object var3, Object var4);

    public void warn(Marker var1, String var2, Throwable var3);

    public void warn(Marker var1, String var2, Object ... var3);
}

