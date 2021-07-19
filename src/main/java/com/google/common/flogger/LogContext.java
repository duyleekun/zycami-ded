/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger;

import com.google.common.flogger.AbstractLogger;
import com.google.common.flogger.LazyArg;
import com.google.common.flogger.LogContext$Key;
import com.google.common.flogger.LogContext$MutableMetadata;
import com.google.common.flogger.LogSite;
import com.google.common.flogger.LogSiteKey;
import com.google.common.flogger.LogSiteStackTrace;
import com.google.common.flogger.LogSiteStats;
import com.google.common.flogger.LogSiteStats$RateLimitPeriod;
import com.google.common.flogger.LoggingApi;
import com.google.common.flogger.MetadataKey;
import com.google.common.flogger.StackSize;
import com.google.common.flogger.backend.LogData;
import com.google.common.flogger.backend.Metadata;
import com.google.common.flogger.backend.Platform;
import com.google.common.flogger.backend.Tags;
import com.google.common.flogger.backend.TemplateContext;
import com.google.common.flogger.parser.MessageParser;
import com.google.common.flogger.util.CallerFinder;
import com.google.common.flogger.util.Checks;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public abstract class LogContext
implements LoggingApi,
LogData {
    private static final String LITERAL_VALUE_MESSAGE;
    private Object[] args;
    private final Level level;
    private LogSite logSite;
    private LogContext$MutableMetadata metadata;
    private TemplateContext templateContext;
    private final long timestampNanos;

    static {
        String string2;
        LITERAL_VALUE_MESSAGE = string2 = new String();
    }

    public LogContext(Level level, boolean bl2) {
        long l10 = Platform.getCurrentTimeNanos();
        this(level, bl2, l10);
    }

    public LogContext(Level object, boolean bl2, long l10) {
        this.metadata = null;
        this.logSite = null;
        this.templateContext = null;
        this.args = null;
        String string2 = "level";
        object = (Level)Checks.checkNotNull(object, string2);
        this.level = object;
        this.timestampNanos = l10;
        if (bl2) {
            object = LogContext$Key.WAS_FORCED;
            Boolean bl3 = Boolean.TRUE;
            this.addMetadata((MetadataKey)object, bl3);
        }
    }

    private void logImpl(String string2, Object ... object) {
        int n10;
        this.args = object;
        MessageParser messageParser = null;
        for (int i10 = 0; i10 < (n10 = ((Object[])object).length); ++i10) {
            Object object2 = object[i10];
            n10 = object2 instanceof LazyArg;
            if (n10 == 0) continue;
            object[i10] = object2 = ((LazyArg)object[i10]).evaluate();
        }
        object = LITERAL_VALUE_MESSAGE;
        if (string2 != object) {
            messageParser = this.getMessageParser();
            this.templateContext = object = new TemplateContext(messageParser, string2);
        }
        this.getLogger().write(this);
    }

    private boolean shouldLog() {
        Object object;
        Object object2 = this.logSite;
        boolean bl2 = true;
        if (object2 == null) {
            object2 = Platform.getCallerFinder().findLogSite(LogContext.class, (int)(bl2 ? 1 : 0));
            object = "logger backend must not return a null LogSite";
            object2 = (LogSite)Checks.checkNotNull(object2, (String)object);
            this.logSite = object2;
        }
        boolean bl3 = false;
        object2 = null;
        object = this.logSite;
        LogSite logSite = LogSite.INVALID;
        if (object != logSite) {
            object2 = object;
        }
        if (!(bl3 = this.postProcess((LogSiteKey)object2))) {
            return false;
        }
        object2 = Platform.getInjectedTags();
        boolean bl4 = ((Tags)object2).isEmpty();
        if (!bl4) {
            object = LogContext$Key.TAGS;
            this.addMetadata((MetadataKey)object, object2);
        }
        return bl2;
    }

    public final void addMetadata(MetadataKey metadataKey, Object object) {
        LogContext$MutableMetadata logContext$MutableMetadata = this.metadata;
        if (logContext$MutableMetadata == null) {
            this.metadata = logContext$MutableMetadata = new LogContext$MutableMetadata();
        }
        this.metadata.addValue(metadataKey, object);
    }

    public abstract LoggingApi api();

    public final LoggingApi atMostEvery(int n10, TimeUnit timeUnit) {
        boolean bl2 = this.wasForced();
        if (bl2) {
            return this.api();
        }
        if (n10 >= 0) {
            if (n10 > 0) {
                MetadataKey metadataKey = LogContext$Key.LOG_AT_MOST_EVERY;
                LogSiteStats$RateLimitPeriod logSiteStats$RateLimitPeriod = LogSiteStats.newRateLimitPeriod(n10, timeUnit);
                this.addMetadata(metadataKey, logSiteStats$RateLimitPeriod);
            }
            return this.api();
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("rate limit period cannot be negative");
        throw illegalArgumentException;
    }

    public final LoggingApi every(int n10) {
        int n11 = this.wasForced();
        if (n11 != 0) {
            return this.api();
        }
        if (n10 > 0) {
            n11 = 1;
            if (n10 > n11) {
                MetadataKey metadataKey = LogContext$Key.LOG_EVERY_N;
                Integer n12 = n10;
                this.addMetadata(metadataKey, n12);
            }
            return this.api();
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("rate limit count must be positive");
        throw illegalArgumentException;
    }

    public final Object[] getArguments() {
        Object object = this.templateContext;
        if (object != null) {
            return this.args;
        }
        object = new IllegalStateException("cannot get arguments unless a template context exists");
        throw object;
    }

    public final Level getLevel() {
        return this.level;
    }

    public final Object getLiteralArgument() {
        Object object = this.templateContext;
        if (object == null) {
            return this.args[0];
        }
        object = new IllegalStateException("cannot get literal argument if a template context exists");
        throw object;
    }

    public final LogSite getLogSite() {
        Object object = this.logSite;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("cannot request log site information prior to postProcess()");
        throw object;
    }

    public abstract AbstractLogger getLogger();

    public final String getLoggerName() {
        return this.getLogger().getBackend().getLoggerName();
    }

    public abstract MessageParser getMessageParser();

    public final Metadata getMetadata() {
        Metadata metadata = this.metadata;
        if (metadata == null) {
            metadata = Metadata.empty();
        }
        return metadata;
    }

    public final TemplateContext getTemplateContext() {
        return this.templateContext;
    }

    public final long getTimestampMicros() {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long l10 = this.timestampNanos;
        return timeUnit.toMicros(l10);
    }

    public final long getTimestampNanos() {
        return this.timestampNanos;
    }

    public final boolean isEnabled() {
        Level level;
        AbstractLogger abstractLogger;
        boolean bl2 = this.wasForced();
        if (!bl2 && !(bl2 = (abstractLogger = this.getLogger()).isLoggable(level = this.level))) {
            bl2 = false;
            abstractLogger = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public final void log() {
        boolean bl2 = this.shouldLog();
        if (bl2) {
            String string2 = LITERAL_VALUE_MESSAGE;
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            String string3 = "";
            objectArray[0] = string3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2) {
        boolean bl2 = this.shouldLog();
        if (bl2) {
            String string3 = LITERAL_VALUE_MESSAGE;
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = string2;
            this.logImpl(string3, objectArray);
        }
    }

    public final void log(String string2, byte by2) {
        int n10 = (int)(this.shouldLog() ? 1 : 0);
        if (n10 != 0) {
            n10 = 1;
            Object[] objectArray = new Object[n10];
            Byte by3 = by2;
            objectArray[0] = by3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, byte by2, byte by3) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Byte by4 = by2;
            objectArray[0] = by4;
            by2 = 1;
            Byte by5 = by3;
            objectArray[by2] = by5;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, byte by2, char c10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Byte by3 = by2;
            objectArray[0] = by3;
            by2 = 1;
            Character c11 = Character.valueOf(c10);
            objectArray[by2] = c11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, byte by2, double d10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Byte by3 = by2;
            objectArray[0] = by3;
            by2 = 1;
            Double d11 = d10;
            objectArray[by2] = d11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, byte by2, float f10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Byte by3 = by2;
            objectArray[0] = by3;
            by2 = 1;
            Float f11 = Float.valueOf(f10);
            objectArray[by2] = f11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, byte by2, int n10) {
        int n11 = this.shouldLog();
        if (n11 != 0) {
            n11 = 2;
            Object[] objectArray = new Object[n11];
            Byte by3 = by2;
            objectArray[0] = by3;
            by2 = 1;
            Integer n12 = n10;
            objectArray[by2] = n12;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, byte by2, long l10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Byte by3 = by2;
            objectArray[0] = by3;
            by2 = 1;
            Long l11 = l10;
            objectArray[by2] = l11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, byte by2, Object object) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Byte by3 = by2;
            objectArray[0] = by3;
            by2 = 1;
            objectArray[by2] = object;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, byte by2, short s10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Byte by3 = by2;
            objectArray[0] = by3;
            by2 = 1;
            Short s11 = s10;
            objectArray[by2] = s11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, byte by2, boolean bl2) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Byte by3 = by2;
            objectArray[0] = by3;
            by2 = 1;
            Boolean bl3 = bl2;
            objectArray[by2] = bl3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, char c10) {
        int n10 = (int)(this.shouldLog() ? 1 : 0);
        if (n10 != 0) {
            n10 = 1;
            Object[] objectArray = new Object[n10];
            Character c11 = Character.valueOf(c10);
            objectArray[0] = c11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, char c10, byte by2) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Character c11 = Character.valueOf(c10);
            objectArray[0] = c11;
            c10 = '\u0001';
            Byte by3 = by2;
            objectArray[c10] = by3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, char c10, char c11) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Character c12 = Character.valueOf(c10);
            objectArray[0] = c12;
            c10 = '\u0001';
            Character c13 = Character.valueOf(c11);
            objectArray[c10] = c13;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, char c10, double d10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Character c11 = Character.valueOf(c10);
            objectArray[0] = c11;
            c10 = '\u0001';
            Double d11 = d10;
            objectArray[c10] = d11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, char c10, float f10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Character c11 = Character.valueOf(c10);
            objectArray[0] = c11;
            c10 = '\u0001';
            Float f11 = Float.valueOf(f10);
            objectArray[c10] = f11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, char c10, int n10) {
        int n11 = this.shouldLog();
        if (n11 != 0) {
            n11 = 2;
            Object[] objectArray = new Object[n11];
            Character c11 = Character.valueOf(c10);
            objectArray[0] = c11;
            c10 = '\u0001';
            Integer n12 = n10;
            objectArray[c10] = n12;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, char c10, long l10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Character c11 = Character.valueOf(c10);
            objectArray[0] = c11;
            c10 = '\u0001';
            Long l11 = l10;
            objectArray[c10] = l11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, char c10, Object object) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Character c11 = Character.valueOf(c10);
            objectArray[0] = c11;
            c10 = '\u0001';
            objectArray[c10] = object;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, char c10, short s10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Character c11 = Character.valueOf(c10);
            objectArray[0] = c11;
            c10 = '\u0001';
            Short s11 = s10;
            objectArray[c10] = s11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, char c10, boolean bl2) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Character c11 = Character.valueOf(c10);
            objectArray[0] = c11;
            c10 = '\u0001';
            Boolean bl3 = bl2;
            objectArray[c10] = bl3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, double d10, byte by2) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Double d11 = d10;
            objectArray[0] = d11;
            int n11 = 1;
            Byte by3 = by2;
            objectArray[n11] = by3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, double d10, char c10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Double d11 = d10;
            objectArray[0] = d11;
            int n11 = 1;
            Character c11 = Character.valueOf(c10);
            objectArray[n11] = c11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, double d10, double d11) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Double d12 = d10;
            objectArray[0] = d12;
            int n11 = 1;
            Double d13 = d11;
            objectArray[n11] = d13;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, double d10, float f10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Double d11 = d10;
            objectArray[0] = d11;
            int n11 = 1;
            Float f11 = Float.valueOf(f10);
            objectArray[n11] = f11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, double d10, int n10) {
        int n11 = this.shouldLog();
        if (n11 != 0) {
            n11 = 2;
            Object[] objectArray = new Object[n11];
            Double d11 = d10;
            objectArray[0] = d11;
            int n12 = 1;
            Integer n13 = n10;
            objectArray[n12] = n13;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, double d10, long l10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Double d11 = d10;
            objectArray[0] = d11;
            int n11 = 1;
            Long l11 = l10;
            objectArray[n11] = l11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, double d10, Object object) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Double d11 = d10;
            objectArray[0] = d11;
            int n11 = 1;
            objectArray[n11] = object;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, double d10, short s10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Double d11 = d10;
            objectArray[0] = d11;
            int n11 = 1;
            Short s11 = s10;
            objectArray[n11] = s11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, double d10, boolean bl2) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Double d11 = d10;
            objectArray[0] = d11;
            int n11 = 1;
            Boolean bl3 = bl2;
            objectArray[n11] = bl3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, float f10, byte by2) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Float f11 = Float.valueOf(f10);
            objectArray[0] = f11;
            int n11 = 1;
            f10 = Float.MIN_VALUE;
            Byte by3 = by2;
            objectArray[n11] = by3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, float f10, char c10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Float f11 = Float.valueOf(f10);
            objectArray[0] = f11;
            int n11 = 1;
            f10 = Float.MIN_VALUE;
            Character c11 = Character.valueOf(c10);
            objectArray[n11] = c11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, float f10, double d10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Float f11 = Float.valueOf(f10);
            objectArray[0] = f11;
            int n11 = 1;
            f10 = Float.MIN_VALUE;
            Double d11 = d10;
            objectArray[n11] = d11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, float f10, float f11) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Float f12 = Float.valueOf(f10);
            objectArray[0] = f12;
            int n11 = 1;
            f10 = Float.MIN_VALUE;
            Float f13 = Float.valueOf(f11);
            objectArray[n11] = f13;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, float f10, int n10) {
        int n11 = this.shouldLog();
        if (n11 != 0) {
            n11 = 2;
            Object[] objectArray = new Object[n11];
            Float f11 = Float.valueOf(f10);
            objectArray[0] = f11;
            int n12 = 1;
            f10 = Float.MIN_VALUE;
            Integer n13 = n10;
            objectArray[n12] = n13;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, float f10, long l10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Float f11 = Float.valueOf(f10);
            objectArray[0] = f11;
            int n11 = 1;
            f10 = Float.MIN_VALUE;
            Long l11 = l10;
            objectArray[n11] = l11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, float f10, Object object) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Float f11 = Float.valueOf(f10);
            objectArray[0] = f11;
            int n11 = 1;
            f10 = Float.MIN_VALUE;
            objectArray[n11] = object;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, float f10, short s10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Float f11 = Float.valueOf(f10);
            objectArray[0] = f11;
            int n11 = 1;
            f10 = Float.MIN_VALUE;
            Short s11 = s10;
            objectArray[n11] = s11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, float f10, boolean bl2) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Float f11 = Float.valueOf(f10);
            objectArray[0] = f11;
            int n11 = 1;
            f10 = Float.MIN_VALUE;
            Boolean bl3 = bl2;
            objectArray[n11] = bl3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, int n10) {
        int n11 = (int)(this.shouldLog() ? 1 : 0);
        if (n11 != 0) {
            n11 = 1;
            Object[] objectArray = new Object[n11];
            Integer n12 = n10;
            objectArray[0] = n12;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, int n10, byte by2) {
        int n11 = this.shouldLog();
        if (n11 != 0) {
            n11 = 2;
            Object[] objectArray = new Object[n11];
            Integer n12 = n10;
            objectArray[0] = n12;
            n10 = 1;
            Byte by3 = by2;
            objectArray[n10] = by3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, int n10, char c10) {
        int n11 = this.shouldLog();
        if (n11 != 0) {
            n11 = 2;
            Object[] objectArray = new Object[n11];
            Integer n12 = n10;
            objectArray[0] = n12;
            n10 = 1;
            Character c11 = Character.valueOf(c10);
            objectArray[n10] = c11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, int n10, double d10) {
        int n11 = this.shouldLog();
        if (n11 != 0) {
            n11 = 2;
            Object[] objectArray = new Object[n11];
            Integer n12 = n10;
            objectArray[0] = n12;
            n10 = 1;
            Double d11 = d10;
            objectArray[n10] = d11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, int n10, float f10) {
        int n11 = this.shouldLog();
        if (n11 != 0) {
            n11 = 2;
            Object[] objectArray = new Object[n11];
            Integer n12 = n10;
            objectArray[0] = n12;
            n10 = 1;
            Float f11 = Float.valueOf(f10);
            objectArray[n10] = f11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, int n10, int n11) {
        int n12 = this.shouldLog();
        if (n12 != 0) {
            n12 = 2;
            Object[] objectArray = new Object[n12];
            Integer n13 = n10;
            objectArray[0] = n13;
            n10 = 1;
            Integer n14 = n11;
            objectArray[n10] = n14;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, int n10, long l10) {
        int n11 = this.shouldLog();
        if (n11 != 0) {
            n11 = 2;
            Object[] objectArray = new Object[n11];
            Integer n12 = n10;
            objectArray[0] = n12;
            n10 = 1;
            Long l11 = l10;
            objectArray[n10] = l11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, int n10, Object object) {
        int n11 = this.shouldLog();
        if (n11 != 0) {
            n11 = 2;
            Object[] objectArray = new Object[n11];
            Integer n12 = n10;
            objectArray[0] = n12;
            n10 = 1;
            objectArray[n10] = object;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, int n10, short s10) {
        int n11 = this.shouldLog();
        if (n11 != 0) {
            n11 = 2;
            Object[] objectArray = new Object[n11];
            Integer n12 = n10;
            objectArray[0] = n12;
            n10 = 1;
            Short s11 = s10;
            objectArray[n10] = s11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, int n10, boolean bl2) {
        int n11 = this.shouldLog();
        if (n11 != 0) {
            n11 = 2;
            Object[] objectArray = new Object[n11];
            Integer n12 = n10;
            objectArray[0] = n12;
            n10 = 1;
            Boolean bl3 = bl2;
            objectArray[n10] = bl3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, long l10) {
        int n10 = (int)(this.shouldLog() ? 1 : 0);
        if (n10 != 0) {
            n10 = 1;
            Object[] objectArray = new Object[n10];
            Long l11 = l10;
            objectArray[0] = l11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, long l10, byte by2) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Long l11 = l10;
            objectArray[0] = l11;
            int n11 = 1;
            Byte by3 = by2;
            objectArray[n11] = by3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, long l10, char c10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Long l11 = l10;
            objectArray[0] = l11;
            int n11 = 1;
            Character c11 = Character.valueOf(c10);
            objectArray[n11] = c11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, long l10, double d10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Long l11 = l10;
            objectArray[0] = l11;
            int n11 = 1;
            Double d11 = d10;
            objectArray[n11] = d11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, long l10, float f10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Long l11 = l10;
            objectArray[0] = l11;
            int n11 = 1;
            Float f11 = Float.valueOf(f10);
            objectArray[n11] = f11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, long l10, int n10) {
        int n11 = this.shouldLog();
        if (n11 != 0) {
            n11 = 2;
            Object[] objectArray = new Object[n11];
            Long l11 = l10;
            objectArray[0] = l11;
            int n12 = 1;
            Integer n13 = n10;
            objectArray[n12] = n13;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, long l10, long l11) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Long l12 = l10;
            objectArray[0] = l12;
            int n11 = 1;
            Long l13 = l11;
            objectArray[n11] = l13;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, long l10, Object object) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Long l11 = l10;
            objectArray[0] = l11;
            int n11 = 1;
            objectArray[n11] = object;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, long l10, short s10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Long l11 = l10;
            objectArray[0] = l11;
            int n11 = 1;
            Short s11 = s10;
            objectArray[n11] = s11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, long l10, boolean bl2) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Long l11 = l10;
            objectArray[0] = l11;
            int n11 = 1;
            Boolean bl3 = bl2;
            objectArray[n11] = bl3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, Object object) {
        int n10 = (int)(this.shouldLog() ? 1 : 0);
        if (n10 != 0) {
            n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, Object object, byte by2) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            int n11 = 1;
            Byte by3 = by2;
            objectArray[n11] = by3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, Object object, char c10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            int n11 = 1;
            Character c11 = Character.valueOf(c10);
            objectArray[n11] = c11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, Object object, double d10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            int n11 = 1;
            Double d11 = d10;
            objectArray[n11] = d11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, Object object, float f10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            int n11 = 1;
            Float f11 = Float.valueOf(f10);
            objectArray[n11] = f11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, Object object, int n10) {
        int n11 = this.shouldLog();
        if (n11 != 0) {
            n11 = 2;
            Object[] objectArray = new Object[n11];
            objectArray[0] = object;
            int n12 = 1;
            Integer n13 = n10;
            objectArray[n12] = n13;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, Object object, long l10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            int n11 = 1;
            Long l11 = l10;
            objectArray[n11] = l11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, Object object, Object object2) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            int n11 = 1;
            objectArray[n11] = object2;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, Object object, Object object2, Object object3) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 3;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            objectArray[1] = object2;
            int n11 = 2;
            objectArray[n11] = object3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, Object object, Object object2, Object object3, Object object4) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 4;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            objectArray[1] = object2;
            objectArray[2] = object3;
            int n11 = 3;
            objectArray[n11] = object4;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, Object object, Object object2, Object object3, Object object4, Object object5) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 5;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            objectArray[1] = object2;
            objectArray[2] = object3;
            objectArray[3] = object4;
            int n11 = 4;
            objectArray[n11] = object5;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 6;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            objectArray[1] = object2;
            objectArray[2] = object3;
            objectArray[3] = object4;
            objectArray[4] = object5;
            int n11 = 5;
            objectArray[n11] = object6;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 7;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            objectArray[1] = object2;
            objectArray[2] = object3;
            objectArray[3] = object4;
            objectArray[4] = object5;
            objectArray[5] = object6;
            int n11 = 6;
            objectArray[n11] = object7;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 8;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            objectArray[1] = object2;
            objectArray[2] = object3;
            objectArray[3] = object4;
            objectArray[4] = object5;
            objectArray[5] = object6;
            objectArray[6] = object7;
            int n11 = 7;
            objectArray[n11] = object8;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 9;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            objectArray[1] = object2;
            objectArray[2] = object3;
            objectArray[3] = object4;
            objectArray[4] = object5;
            objectArray[5] = object6;
            objectArray[6] = object7;
            objectArray[7] = object8;
            int n11 = 8;
            objectArray[n11] = object9;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 10;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            objectArray[1] = object2;
            objectArray[2] = object3;
            objectArray[3] = object4;
            objectArray[4] = object5;
            objectArray[5] = object6;
            objectArray[6] = object7;
            objectArray[7] = object8;
            objectArray[8] = object9;
            int n11 = 9;
            objectArray[n11] = object10;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object ... objectArray) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = objectArray.length;
            int n11 = 10;
            Object[] objectArray2 = new Object[n10 += n11];
            objectArray2[0] = object;
            objectArray2[1] = object2;
            objectArray2[2] = object3;
            objectArray2[3] = object4;
            objectArray2[4] = object5;
            objectArray2[5] = object6;
            objectArray2[6] = object7;
            objectArray2[7] = object8;
            objectArray2[8] = object9;
            objectArray2[9] = object10;
            int n12 = objectArray.length;
            System.arraycopy(objectArray, 0, objectArray2, n11, n12);
            this.logImpl(string2, objectArray2);
        }
    }

    public final void log(String string2, Object object, short s10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            int n11 = 1;
            Short s11 = s10;
            objectArray[n11] = s11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, Object object, boolean bl2) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            int n11 = 1;
            Boolean bl3 = bl2;
            objectArray[n11] = bl3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, short s10) {
        int n10 = (int)(this.shouldLog() ? 1 : 0);
        if (n10 != 0) {
            n10 = 1;
            Object[] objectArray = new Object[n10];
            Short s11 = s10;
            objectArray[0] = s11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, short s10, byte by2) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Short s11 = s10;
            objectArray[0] = s11;
            s10 = 1;
            Byte by3 = by2;
            objectArray[s10] = by3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, short s10, char c10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Short s11 = s10;
            objectArray[0] = s11;
            s10 = 1;
            Character c11 = Character.valueOf(c10);
            objectArray[s10] = c11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, short s10, double d10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Short s11 = s10;
            objectArray[0] = s11;
            s10 = 1;
            Double d11 = d10;
            objectArray[s10] = d11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, short s10, float f10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Short s11 = s10;
            objectArray[0] = s11;
            s10 = 1;
            Float f11 = Float.valueOf(f10);
            objectArray[s10] = f11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, short s10, int n10) {
        int n11 = this.shouldLog();
        if (n11 != 0) {
            n11 = 2;
            Object[] objectArray = new Object[n11];
            Short s11 = s10;
            objectArray[0] = s11;
            s10 = 1;
            Integer n12 = n10;
            objectArray[s10] = n12;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, short s10, long l10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Short s11 = s10;
            objectArray[0] = s11;
            s10 = 1;
            Long l11 = l10;
            objectArray[s10] = l11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, short s10, Object object) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Short s11 = s10;
            objectArray[0] = s11;
            s10 = 1;
            objectArray[s10] = object;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, short s10, short s11) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Short s12 = s10;
            objectArray[0] = s12;
            s10 = 1;
            Short s13 = s11;
            objectArray[s10] = s13;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, short s10, boolean bl2) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Short s11 = s10;
            objectArray[0] = s11;
            s10 = 1;
            Boolean bl3 = bl2;
            objectArray[s10] = bl3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, boolean bl2, byte by2) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Boolean bl3 = bl2;
            objectArray[0] = bl3;
            bl2 = true;
            Byte by3 = by2;
            objectArray[bl2] = by3;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, boolean bl2, char c10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Boolean bl3 = bl2;
            objectArray[0] = bl3;
            bl2 = true;
            Character c11 = Character.valueOf(c10);
            objectArray[bl2] = c11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, boolean bl2, double d10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Boolean bl3 = bl2;
            objectArray[0] = bl3;
            bl2 = true;
            Double d11 = d10;
            objectArray[bl2] = d11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, boolean bl2, float f10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Boolean bl3 = bl2;
            objectArray[0] = bl3;
            bl2 = true;
            Float f11 = Float.valueOf(f10);
            objectArray[bl2] = f11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, boolean bl2, int n10) {
        int n11 = this.shouldLog();
        if (n11 != 0) {
            n11 = 2;
            Object[] objectArray = new Object[n11];
            Boolean bl3 = bl2;
            objectArray[0] = bl3;
            bl2 = true;
            Integer n12 = n10;
            objectArray[bl2] = n12;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, boolean bl2, long l10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Boolean bl3 = bl2;
            objectArray[0] = bl3;
            bl2 = true;
            Long l11 = l10;
            objectArray[bl2] = l11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, boolean bl2, Object object) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Boolean bl3 = bl2;
            objectArray[0] = bl3;
            bl2 = true;
            objectArray[bl2] = object;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, boolean bl2, short s10) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Boolean bl3 = bl2;
            objectArray[0] = bl3;
            bl2 = true;
            Short s11 = s10;
            objectArray[bl2] = s11;
            this.logImpl(string2, objectArray);
        }
    }

    public final void log(String string2, boolean bl2, boolean bl3) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            Boolean bl4 = bl2;
            objectArray[0] = bl4;
            bl2 = true;
            Boolean bl5 = bl3;
            objectArray[bl2] = bl5;
            this.logImpl(string2, objectArray);
        }
    }

    public final void logVarargs(String string2, Object[] objectArray) {
        int n10 = this.shouldLog();
        if (n10 != 0) {
            n10 = objectArray.length;
            objectArray = Arrays.copyOf(objectArray, n10);
            this.logImpl(string2, objectArray);
        }
    }

    public abstract LoggingApi noOp();

    public boolean postProcess(LogSiteKey object) {
        MetadataKey metadataKey;
        Object object2;
        Object object3 = this.metadata;
        if (object3 != null && object != null) {
            long l10;
            boolean bl2;
            object2 = LogContext$Key.LOG_EVERY_N;
            object3 = (Integer)((LogContext$MutableMetadata)object3).findValue((MetadataKey)object2);
            object2 = this.metadata;
            metadataKey = LogContext$Key.LOG_AT_MOST_EVERY;
            object2 = (LogSiteStats$RateLimitPeriod)((LogContext$MutableMetadata)object2).findValue(metadataKey);
            object = LogSiteStats.getStatsForKey(object);
            metadataKey = null;
            if (object3 != null) {
                int n10 = (Integer)object3;
                if ((n10 = (int)(((LogSiteStats)object).incrementAndCheckInvocationCount(n10) ? 1 : 0)) == 0) {
                    return false;
                }
            }
            if (object2 != null && !(bl2 = ((LogSiteStats)object).checkLastTimestamp(l10 = this.getTimestampNanos(), (LogSiteStats$RateLimitPeriod)object2))) {
                return false;
            }
        }
        object = this.getMetadata();
        object3 = LogContext$Key.CONTEXT_STACK_SIZE;
        if ((object = (StackSize)((Object)((Metadata)object).findValue((MetadataKey)object3))) != null) {
            this.removeMetadata((MetadataKey)object3);
            object2 = this.getMetadata();
            metadataKey = LogContext$Key.LOG_CAUSE;
            object2 = (Throwable)((Metadata)object2).findValue(metadataKey);
            Throwable throwable = new Throwable();
            int n11 = ((StackSize)((Object)object)).getMaxDepth();
            StackTraceElement[] stackTraceElementArray = CallerFinder.getStackForCallerOf(LogContext.class, throwable, n11);
            object3 = new LogSiteStackTrace((Throwable)object2, (StackSize)((Object)object), stackTraceElementArray);
            this.addMetadata(metadataKey, object3);
        }
        return true;
    }

    public final void removeMetadata(MetadataKey metadataKey) {
        LogContext$MutableMetadata logContext$MutableMetadata = this.metadata;
        if (logContext$MutableMetadata != null) {
            logContext$MutableMetadata.removeAllValues(metadataKey);
        }
    }

    public final boolean wasForced() {
        MetadataKey metadataKey;
        Boolean bl2;
        boolean bl3;
        Object object = this.metadata;
        if (object != null && (bl3 = (bl2 = Boolean.TRUE).equals(object = ((LogContext$MutableMetadata)object).findValue(metadataKey = LogContext$Key.WAS_FORCED)))) {
            bl3 = true;
        } else {
            bl3 = false;
            object = null;
        }
        return bl3;
    }

    public final LoggingApi withCause(Throwable throwable) {
        if (throwable != null) {
            MetadataKey metadataKey = LogContext$Key.LOG_CAUSE;
            this.addMetadata(metadataKey, throwable);
        }
        return this.api();
    }

    public final LoggingApi withInjectedLogSite(LogSite logSite) {
        Object object = this.logSite;
        if (object == null) {
            object = "log site";
            this.logSite = logSite = (LogSite)Checks.checkNotNull(logSite, (String)object);
        }
        return this.api();
    }

    public final LoggingApi withInjectedLogSite(String object, String string2, int n10, String string3) {
        object = LogSite.injectedLogSite((String)object, string2, n10, string3);
        return this.withInjectedLogSite((LogSite)object);
    }

    public LoggingApi withStackTrace(StackSize stackSize) {
        StackSize stackSize2;
        Object object = Checks.checkNotNull((Object)stackSize, "stack size");
        if (object != (stackSize2 = StackSize.NONE)) {
            object = LogContext$Key.CONTEXT_STACK_SIZE;
            this.addMetadata((MetadataKey)object, (Object)stackSize);
        }
        return this.api();
    }
}

