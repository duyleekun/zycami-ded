/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.logging;

import cn.leancloud.logging.InternalLogger;

public abstract class InternalLoggerAdapter {
    public InternalLogger getLogger(Class object) {
        if (object == null) {
            return null;
        }
        object = ((Class)object).getCanonicalName();
        return this.getLogger((String)object);
    }

    public abstract InternalLogger getLogger(String var1);
}

