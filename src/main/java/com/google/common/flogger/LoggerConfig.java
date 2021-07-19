/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger;

import com.google.common.flogger.AbstractLogger;
import com.google.common.flogger.util.Checks;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Filter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LoggerConfig {
    private static final Map strongRefMap;
    private final Logger logger;

    static {
        ConcurrentHashMap concurrentHashMap;
        strongRefMap = concurrentHashMap = new ConcurrentHashMap();
    }

    private LoggerConfig(String object) {
        this.logger = object = (Logger)Checks.checkNotNull(Logger.getLogger((String)object), "logger");
    }

    public static LoggerConfig getConfig(Class clazz) {
        return LoggerConfig.getConfig(clazz.getName());
    }

    public static LoggerConfig getConfig(String string2) {
        Map map = strongRefMap;
        Object object = Checks.checkNotNull(string2, "logger name");
        if ((object = (LoggerConfig)map.get(object)) == null) {
            object = new LoggerConfig(string2);
            map.put(string2, object);
        }
        return object;
    }

    public static LoggerConfig getPackageConfig(Class clazz) {
        return LoggerConfig.getConfig(clazz.getPackage().getName());
    }

    public static LoggerConfig of(AbstractLogger abstractLogger) {
        boolean bl2;
        String string2 = abstractLogger.getName();
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        Checks.checkArgument(bl2, "cannot obtain configuration for an anonymous logger");
        return LoggerConfig.getConfig(abstractLogger.getName());
    }

    public void addHandler(Handler handler) {
        Checks.checkNotNull(handler, "handler");
        this.logger.addHandler(handler);
    }

    public Filter getFilter() {
        return this.logger.getFilter();
    }

    public Handler[] getHandlers() {
        return this.logger.getHandlers();
    }

    public Level getLevel() {
        return this.logger.getLevel();
    }

    public String getName() {
        return this.logger.getName();
    }

    public Logger getParent() {
        return this.logger.getParent();
    }

    public ResourceBundle getResourceBundle() {
        return this.logger.getResourceBundle();
    }

    public String getResourceBundleName() {
        return this.logger.getResourceBundleName();
    }

    public boolean getUseParentHandlers() {
        return this.logger.getUseParentHandlers();
    }

    public void removeHandler(Handler handler) {
        Checks.checkNotNull(handler, "handler");
        this.logger.removeHandler(handler);
    }

    public void setFilter(Filter filter) {
        this.logger.setFilter(filter);
    }

    public void setLevel(Level level) {
        this.logger.setLevel(level);
    }

    public void setUseParentHandlers(boolean bl2) {
        this.logger.setUseParentHandlers(bl2);
    }
}

