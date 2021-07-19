/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend.system;

import com.google.common.flogger.backend.LoggerBackend;
import com.google.common.flogger.backend.Platform;
import com.google.common.flogger.backend.Platform$LogCallerFinder;
import com.google.common.flogger.backend.Tags;
import com.google.common.flogger.backend.system.BackendFactory;
import com.google.common.flogger.backend.system.Clock;
import com.google.common.flogger.backend.system.EmptyLoggingContext;
import com.google.common.flogger.backend.system.LoggingContext;
import com.google.common.flogger.backend.system.SimpleBackendFactory;
import com.google.common.flogger.backend.system.StackBasedCallerFinder;
import com.google.common.flogger.backend.system.SystemClock;
import com.google.common.flogger.util.Checks;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.logging.Level;

public class DefaultPlatform
extends Platform {
    private static final String BACKEND_FACTORY = "backend_factory";
    private static final String CLOCK = "clock";
    private static final String LOGGING_CONTEXT = "logging_context";
    private final BackendFactory backendFactory;
    private final Platform$LogCallerFinder callerFinder;
    private final Clock clock;
    private final LoggingContext context;

    public DefaultPlatform() {
        String string2 = BACKEND_FACTORY;
        Object object = (BackendFactory)DefaultPlatform.resolveAttribute(string2, BackendFactory.class);
        if (object == null) {
            object = SimpleBackendFactory.getInstance();
        }
        this.backendFactory = object;
        string2 = LOGGING_CONTEXT;
        object = (LoggingContext)DefaultPlatform.resolveAttribute(string2, LoggingContext.class);
        if (object == null) {
            object = EmptyLoggingContext.getInstance();
        }
        this.context = object;
        string2 = CLOCK;
        object = (Clock)DefaultPlatform.resolveAttribute(string2, Clock.class);
        if (object == null) {
            object = SystemClock.getInstance();
        }
        this.clock = object;
        this.callerFinder = object = StackBasedCallerFinder.getInstance();
    }

    public DefaultPlatform(BackendFactory backendFactory, LoggingContext loggingContext, Clock clock, Platform$LogCallerFinder platform$LogCallerFinder) {
        this.backendFactory = backendFactory;
        this.context = loggingContext;
        this.clock = clock;
        this.callerFinder = platform$LogCallerFinder;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Object callStaticMethod(String string2, String string3, Class clazz) {
        int n10 = 3;
        int n11 = 2;
        int n12 = 1;
        try {
            Object object = Class.forName(string2);
            Object[] objectArray = new Class[]{};
            object = ((Class)object).getMethod(string3, (Class<?>[])objectArray);
            objectArray = new Object[]{};
            object = ((Method)object).invoke(null, objectArray);
            return clazz.cast(object);
        }
        catch (Exception exception) {
            Object[] objectArray = new Object[n10];
            objectArray[0] = string2;
            objectArray[n12] = string3;
            objectArray[n11] = exception;
            string2 = "cannot call expected no-argument static method '%s#%s': %s\n";
            DefaultPlatform.error(string2, objectArray);
            return null;
        }
        catch (ClassCastException classCastException) {
            int n13 = 4;
            Object[] objectArray = new Object[n13];
            objectArray[0] = string2;
            objectArray[n12] = string3;
            string2 = clazz.getName();
            objectArray[n11] = string2;
            objectArray[n10] = classCastException;
            string2 = "cannot cast result of calling '%s#%s' to '%s': %s\n";
            DefaultPlatform.error(string2, objectArray);
            return null;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return null;
        }
    }

    private static void error(String string2, Object ... objectArray) {
        PrintStream printStream = System.err;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DefaultPlatform.class);
        stringBuilder.append(": ");
        string2 = String.format(string2, objectArray);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        printStream.println(string2);
    }

    private static String readProperty(String string2) {
        Checks.checkNotNull(string2, "attribute name");
        StringBuilder stringBuilder = new StringBuilder();
        Object[] objectArray = "flogger.";
        stringBuilder.append((String)objectArray);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        try {
            return System.getProperty(string2);
        }
        catch (SecurityException securityException) {
            objectArray = new Object[]{string2, securityException};
            DefaultPlatform.error("cannot read property name %s: %s", objectArray);
            return null;
        }
    }

    private static Object resolveAttribute(String string2, Class objectArray) {
        int n10;
        string2 = DefaultPlatform.readProperty(string2);
        String string3 = null;
        if (string2 == null) {
            return null;
        }
        int n11 = string2.indexOf(35);
        int n12 = 1;
        if (n11 > 0 && n11 != (n10 = string2.length() - n12)) {
            string3 = string2.substring(0, n11);
            string2 = string2.substring(n11 += n12);
            return DefaultPlatform.callStaticMethod(string3, string2, (Class)objectArray);
        }
        objectArray = new Object[n12];
        objectArray[0] = string2;
        DefaultPlatform.error("invalid getter (expected <class>#<method>): %s\n", objectArray);
        return null;
    }

    public LoggerBackend getBackendImpl(String string2) {
        return this.backendFactory.create(string2);
    }

    public Platform$LogCallerFinder getCallerFinderImpl() {
        return this.callerFinder;
    }

    public String getConfigInfoImpl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Platform: ");
        Object object = this.getClass().getName();
        stringBuilder.append((String)object);
        stringBuilder.append("\nBackendFactory: ");
        object = this.backendFactory;
        stringBuilder.append(object);
        stringBuilder.append("\nClock: ");
        object = this.clock;
        stringBuilder.append(object);
        stringBuilder.append("\nLoggingContext: ");
        object = this.context;
        stringBuilder.append(object);
        stringBuilder.append("\nLogCallerFinder: ");
        object = this.callerFinder;
        stringBuilder.append(object);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public long getCurrentTimeNanosImpl() {
        return this.clock.getCurrentTimeNanos();
    }

    public Tags getInjectedTagsImpl() {
        return this.context.getTags();
    }

    public boolean shouldForceLoggingImpl(String string2, Level level, boolean bl2) {
        return this.context.shouldForceLogging(string2, level, bl2);
    }
}

