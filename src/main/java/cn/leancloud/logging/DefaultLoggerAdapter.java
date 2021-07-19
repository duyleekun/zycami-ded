/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.logging;

import cn.leancloud.logging.DefaultLogger;
import cn.leancloud.logging.InternalLogger;
import cn.leancloud.logging.InternalLoggerAdapter;

public class DefaultLoggerAdapter
extends InternalLoggerAdapter {
    public InternalLogger getLogger(String string2) {
        DefaultLogger defaultLogger = new DefaultLogger(string2);
        return defaultLogger;
    }
}

