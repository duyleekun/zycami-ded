/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.logging;

import cn.leancloud.AVLogger$Level;
import cn.leancloud.core.AVOSCloud;
import cn.leancloud.logging.InternalLogger;
import cn.leancloud.logging.InternalLoggerAdapter;
import cn.leancloud.logging.SimpleLogger;
import cn.leancloud.utils.StringUtil;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleLoggerAdapter
extends InternalLoggerAdapter {
    private static ConsoleHandler consoleHandler;

    static {
        ConsoleHandler consoleHandler;
        SimpleLoggerAdapter.consoleHandler = consoleHandler = new ConsoleHandler();
        Level level = Level.ALL;
        consoleHandler.setLevel(level);
    }

    public InternalLogger getLogger(String object) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        object = bl2 ? Logger.getAnonymousLogger() : Logger.getLogger((String)object);
        Object object2 = consoleHandler;
        ((Logger)object).addHandler((Handler)object2);
        object2 = new SimpleLogger((Logger)object);
        object = AVOSCloud.getLogLevel();
        ((InternalLogger)object2).setLevel((AVLogger$Level)((Object)object));
        return object2;
    }
}

