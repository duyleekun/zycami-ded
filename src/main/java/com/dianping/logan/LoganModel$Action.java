/*
 * Decompiled with CFR 0.151.
 */
package com.dianping.logan;

public final class LoganModel$Action
extends Enum {
    public static final /* enum */ LoganModel$Action FLUSH;
    public static final /* enum */ LoganModel$Action SEND;
    public static final /* enum */ LoganModel$Action WRITE;
    private static final /* synthetic */ LoganModel$Action[] a;

    static {
        LoganModel$Action loganModel$Action;
        LoganModel$Action loganModel$Action2;
        LoganModel$Action loganModel$Action3;
        WRITE = loganModel$Action3 = new LoganModel$Action("WRITE", 0);
        int n10 = 1;
        SEND = loganModel$Action2 = new LoganModel$Action("SEND", n10);
        int n11 = 2;
        FLUSH = loganModel$Action = new LoganModel$Action("FLUSH", n11);
        LoganModel$Action[] loganModel$ActionArray = new LoganModel$Action[3];
        loganModel$ActionArray[0] = loganModel$Action3;
        loganModel$ActionArray[n10] = loganModel$Action2;
        loganModel$ActionArray[n11] = loganModel$Action;
        a = loganModel$ActionArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private LoganModel$Action() {
        void var2_-1;
        void var1_-1;
    }

    public static LoganModel$Action valueOf(String string2) {
        return Enum.valueOf(LoganModel$Action.class, string2);
    }

    public static LoganModel$Action[] values() {
        return (LoganModel$Action[])a.clone();
    }
}

