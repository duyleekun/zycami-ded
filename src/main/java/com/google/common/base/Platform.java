/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.CommonPattern;
import com.google.common.base.Enums;
import com.google.common.base.Optional;
import com.google.common.base.PatternCompiler;
import com.google.common.base.Platform$JdkPatternCompiler;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Platform {
    private static final String GWT_RPC_PROPERTY_NAME = "guava.gwt.emergency_reenable_rpc";
    private static final Logger logger = Logger.getLogger(Platform.class.getName());
    private static final PatternCompiler patternCompiler = Platform.loadPatternCompiler();

    private Platform() {
    }

    public static void checkGwtRpcEnabled() {
        String string2 = GWT_RPC_PROPERTY_NAME;
        Object object = System.getProperty(string2, "true");
        boolean bl2 = Boolean.parseBoolean((String)object);
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[]{string2, "https://stackoverflow.com/q/5189914/28465", "https://groups.google.com/d/msg/guava-announce/zHZTFg7YF3o/rQNnwdHeEwAJ"};
        string2 = Strings.lenientFormat("We are removing GWT-RPC support for Guava types. You can temporarily reenable support by setting the system property %s to true. For more about system properties, see %s. For more about Guava's GWT-RPC support, see %s.", objectArray);
        object = new UnsupportedOperationException(string2);
        throw object;
    }

    public static CommonPattern compilePattern(String string2) {
        Preconditions.checkNotNull(string2);
        return patternCompiler.compile(string2);
    }

    public static String emptyToNull(String string2) {
        boolean bl2 = Platform.stringIsNullOrEmpty(string2);
        if (bl2) {
            string2 = null;
        }
        return string2;
    }

    public static String formatCompact4Digits(double d10) {
        Locale locale = Locale.ROOT;
        Object[] objectArray = new Object[1];
        Double d11 = d10;
        objectArray[0] = d11;
        return String.format(locale, "%.4g", objectArray);
    }

    public static Optional getEnumIfPresent(Class serializable, String object) {
        Map map = Enums.getEnumConstants((Class)serializable);
        object = (WeakReference)map.get(object);
        if (object == null) {
            serializable = Optional.absent();
        } else {
            object = ((Reference)object).get();
            serializable = Optional.of(((Class)serializable).cast(object));
        }
        return serializable;
    }

    private static PatternCompiler loadPatternCompiler() {
        Platform$JdkPatternCompiler platform$JdkPatternCompiler = new Platform$JdkPatternCompiler(null);
        return platform$JdkPatternCompiler;
    }

    private static void logPatternCompilerError(ServiceConfigurationError serviceConfigurationError) {
        Logger logger = Platform.logger;
        Level level = Level.WARNING;
        logger.log(level, "Error loading regex compiler, falling back to next option", serviceConfigurationError);
    }

    public static String nullToEmpty(String string2) {
        if (string2 == null) {
            string2 = "";
        }
        return string2;
    }

    public static boolean patternCompilerIsPcreLike() {
        return patternCompiler.isPcreLike();
    }

    public static CharMatcher precomputeCharMatcher(CharMatcher charMatcher) {
        return charMatcher.precomputedInternal();
    }

    public static boolean stringIsNullOrEmpty(String string2) {
        boolean bl2;
        if (string2 != null && !(bl2 = string2.isEmpty())) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static long systemNanoTime() {
        return System.nanoTime();
    }
}

