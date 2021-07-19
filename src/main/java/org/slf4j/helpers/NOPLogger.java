/*
 * Decompiled with CFR 0.151.
 */
package org.slf4j.helpers;

import org.slf4j.helpers.MarkerIgnoringBase;

public class NOPLogger
extends MarkerIgnoringBase {
    public static final NOPLogger NOP_LOGGER;
    private static final long serialVersionUID = -517220405410904473L;

    static {
        NOPLogger nOPLogger;
        NOP_LOGGER = nOPLogger = new NOPLogger();
    }

    public final void debug(String string2) {
    }

    public final void debug(String string2, Object object) {
    }

    public final void debug(String string2, Object object, Object object2) {
    }

    public final void debug(String string2, Throwable throwable) {
    }

    public final void debug(String string2, Object ... objectArray) {
    }

    public final void error(String string2) {
    }

    public final void error(String string2, Object object) {
    }

    public final void error(String string2, Object object, Object object2) {
    }

    public final void error(String string2, Throwable throwable) {
    }

    public final void error(String string2, Object ... objectArray) {
    }

    public String getName() {
        return "NOP";
    }

    public final void info(String string2) {
    }

    public final void info(String string2, Object object) {
    }

    public final void info(String string2, Object object, Object object2) {
    }

    public final void info(String string2, Throwable throwable) {
    }

    public final void info(String string2, Object ... objectArray) {
    }

    public final boolean isDebugEnabled() {
        return false;
    }

    public final boolean isErrorEnabled() {
        return false;
    }

    public final boolean isInfoEnabled() {
        return false;
    }

    public final boolean isTraceEnabled() {
        return false;
    }

    public final boolean isWarnEnabled() {
        return false;
    }

    public final void trace(String string2) {
    }

    public final void trace(String string2, Object object) {
    }

    public final void trace(String string2, Object object, Object object2) {
    }

    public final void trace(String string2, Throwable throwable) {
    }

    public final void trace(String string2, Object ... objectArray) {
    }

    public final void warn(String string2) {
    }

    public final void warn(String string2, Object object) {
    }

    public final void warn(String string2, Object object, Object object2) {
    }

    public final void warn(String string2, Throwable throwable) {
    }

    public final void warn(String string2, Object ... objectArray) {
    }
}

