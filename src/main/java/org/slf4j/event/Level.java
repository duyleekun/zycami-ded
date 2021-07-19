/*
 * Decompiled with CFR 0.151.
 */
package org.slf4j.event;

public final class Level
extends Enum {
    public static final /* enum */ Level DEBUG;
    public static final /* enum */ Level ERROR;
    public static final /* enum */ Level INFO;
    public static final /* enum */ Level TRACE;
    public static final /* enum */ Level WARN;
    private static final /* synthetic */ Level[] a;
    private int levelInt;
    private String levelStr;

    static {
        Level level;
        Object object = "ERROR";
        ERROR = level = new Level(object, 0, 40, object);
        Object object2 = "WARN";
        int n10 = 1;
        object = new Level(object2, n10, 30, object2);
        WARN = object;
        Object object3 = "INFO";
        int n11 = 2;
        object2 = new Level(object3, n11, 20, object3);
        INFO = object2;
        Object object4 = "DEBUG";
        int n12 = 3;
        object3 = new Level(object4, n12, 10, object4);
        DEBUG = object3;
        Level[] levelArray = "TRACE";
        int n13 = 4;
        object4 = new Level((String)levelArray, n13, 0, (String)levelArray);
        TRACE = object4;
        levelArray = new Level[5];
        levelArray[0] = level;
        levelArray[n10] = object;
        levelArray[n11] = object2;
        levelArray[n12] = object3;
        levelArray[n13] = object4;
        a = levelArray;
    }

    /*
     * WARNING - void declaration
     */
    private Level() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.levelInt = var3_1;
        this.levelStr = var4_2;
    }

    public static Level valueOf(String string2) {
        return Enum.valueOf(Level.class, string2);
    }

    public static Level[] values() {
        return (Level[])a.clone();
    }

    public int toInt() {
        return this.levelInt;
    }

    public String toString() {
        return this.levelStr;
    }
}

