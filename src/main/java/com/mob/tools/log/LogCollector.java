/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.log;

public interface LogCollector {
    public static final int LEVEL_CRASH = 1;
    public static final int LEVEL_NATIVE = 2;
    public static final int LEVEL_NORMAL = 0;
    public static final int LEVEL_NORMAL_UPLOAD = 3;

    public void log(String var1, int var2, int var3, String var4, String var5);
}

