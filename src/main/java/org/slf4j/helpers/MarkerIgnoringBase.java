/*
 * Decompiled with CFR 0.151.
 */
package org.slf4j.helpers;

import i.h.c;
import org.slf4j.Marker;
import org.slf4j.helpers.NamedLoggerBase;

public abstract class MarkerIgnoringBase
extends NamedLoggerBase
implements c {
    private static final long serialVersionUID = 9044267456635152283L;

    public void debug(Marker marker, String string2) {
        this.debug(string2);
    }

    public void debug(Marker marker, String string2, Object object) {
        this.debug(string2, object);
    }

    public void debug(Marker marker, String string2, Object object, Object object2) {
        this.debug(string2, object, object2);
    }

    public void debug(Marker marker, String string2, Throwable throwable) {
        this.debug(string2, throwable);
    }

    public void debug(Marker marker, String string2, Object ... objectArray) {
        this.debug(string2, objectArray);
    }

    public void error(Marker marker, String string2) {
        this.error(string2);
    }

    public void error(Marker marker, String string2, Object object) {
        this.error(string2, object);
    }

    public void error(Marker marker, String string2, Object object, Object object2) {
        this.error(string2, object, object2);
    }

    public void error(Marker marker, String string2, Throwable throwable) {
        this.error(string2, throwable);
    }

    public void error(Marker marker, String string2, Object ... objectArray) {
        this.error(string2, objectArray);
    }

    public void info(Marker marker, String string2) {
        this.info(string2);
    }

    public void info(Marker marker, String string2, Object object) {
        this.info(string2, object);
    }

    public void info(Marker marker, String string2, Object object, Object object2) {
        this.info(string2, object, object2);
    }

    public void info(Marker marker, String string2, Throwable throwable) {
        this.info(string2, throwable);
    }

    public void info(Marker marker, String string2, Object ... objectArray) {
        this.info(string2, objectArray);
    }

    public boolean isDebugEnabled(Marker marker) {
        return this.isDebugEnabled();
    }

    public boolean isErrorEnabled(Marker marker) {
        return this.isErrorEnabled();
    }

    public boolean isInfoEnabled(Marker marker) {
        return this.isInfoEnabled();
    }

    public boolean isTraceEnabled(Marker marker) {
        return this.isTraceEnabled();
    }

    public boolean isWarnEnabled(Marker marker) {
        return this.isWarnEnabled();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.getClass().getName();
        stringBuilder.append(string2);
        stringBuilder.append("(");
        string2 = this.getName();
        stringBuilder.append(string2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void trace(Marker marker, String string2) {
        this.trace(string2);
    }

    public void trace(Marker marker, String string2, Object object) {
        this.trace(string2, object);
    }

    public void trace(Marker marker, String string2, Object object, Object object2) {
        this.trace(string2, object, object2);
    }

    public void trace(Marker marker, String string2, Throwable throwable) {
        this.trace(string2, throwable);
    }

    public void trace(Marker marker, String string2, Object ... objectArray) {
        this.trace(string2, objectArray);
    }

    public void warn(Marker marker, String string2) {
        this.warn(string2);
    }

    public void warn(Marker marker, String string2, Object object) {
        this.warn(string2, object);
    }

    public void warn(Marker marker, String string2, Object object, Object object2) {
        this.warn(string2, object, object2);
    }

    public void warn(Marker marker, String string2, Throwable throwable) {
        this.warn(string2, throwable);
    }

    public void warn(Marker marker, String string2, Object ... objectArray) {
        this.warn(string2, objectArray);
    }
}

