/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend.system;

import com.google.common.flogger.backend.LoggerBackend;
import com.google.common.flogger.backend.system.BackendFactory;
import com.google.common.flogger.backend.system.SimpleLoggerBackend;
import java.util.logging.Logger;

public final class SimpleBackendFactory
extends BackendFactory {
    private static final BackendFactory INSTANCE;

    static {
        SimpleBackendFactory simpleBackendFactory = new SimpleBackendFactory();
        INSTANCE = simpleBackendFactory;
    }

    private SimpleBackendFactory() {
    }

    public static BackendFactory getInstance() {
        return INSTANCE;
    }

    public LoggerBackend create(String object) {
        object = Logger.getLogger(((String)object).replace('$', '.'));
        SimpleLoggerBackend simpleLoggerBackend = new SimpleLoggerBackend((Logger)object);
        return simpleLoggerBackend;
    }

    public String toString() {
        return "Default logger backend factory";
    }
}

