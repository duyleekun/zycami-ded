/*
 * Decompiled with CFR 0.151.
 */
package com.google.j2objc.annotations;

public final class LoopTranslation$LoopStyle
extends Enum {
    private static final /* synthetic */ LoopTranslation$LoopStyle[] $VALUES;
    public static final /* enum */ LoopTranslation$LoopStyle FAST_ENUMERATION;
    public static final /* enum */ LoopTranslation$LoopStyle JAVA_ITERATOR;

    static {
        LoopTranslation$LoopStyle loopTranslation$LoopStyle;
        LoopTranslation$LoopStyle loopTranslation$LoopStyle2;
        JAVA_ITERATOR = loopTranslation$LoopStyle2 = new LoopTranslation$LoopStyle("JAVA_ITERATOR", 0);
        int n10 = 1;
        FAST_ENUMERATION = loopTranslation$LoopStyle = new LoopTranslation$LoopStyle("FAST_ENUMERATION", n10);
        LoopTranslation$LoopStyle[] loopTranslation$LoopStyleArray = new LoopTranslation$LoopStyle[2];
        loopTranslation$LoopStyleArray[0] = loopTranslation$LoopStyle2;
        loopTranslation$LoopStyleArray[n10] = loopTranslation$LoopStyle;
        $VALUES = loopTranslation$LoopStyleArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private LoopTranslation$LoopStyle() {
        void var2_-1;
        void var1_-1;
    }

    public static LoopTranslation$LoopStyle valueOf(String string2) {
        return Enum.valueOf(LoopTranslation$LoopStyle.class, string2);
    }

    public static LoopTranslation$LoopStyle[] values() {
        return (LoopTranslation$LoopStyle[])$VALUES.clone();
    }
}

