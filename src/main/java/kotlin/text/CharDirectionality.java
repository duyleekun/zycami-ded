/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.t;
import f.w;
import kotlin.text.CharDirectionality$Companion$directionalityMap$2;
import kotlin.text.CharDirectionality$a;

public final class CharDirectionality
extends Enum {
    public static final /* enum */ CharDirectionality ARABIC_NUMBER;
    public static final /* enum */ CharDirectionality BOUNDARY_NEUTRAL;
    public static final /* enum */ CharDirectionality COMMON_NUMBER_SEPARATOR;
    public static final CharDirectionality$a Companion;
    public static final /* enum */ CharDirectionality EUROPEAN_NUMBER;
    public static final /* enum */ CharDirectionality EUROPEAN_NUMBER_SEPARATOR;
    public static final /* enum */ CharDirectionality EUROPEAN_NUMBER_TERMINATOR;
    public static final /* enum */ CharDirectionality LEFT_TO_RIGHT;
    public static final /* enum */ CharDirectionality LEFT_TO_RIGHT_EMBEDDING;
    public static final /* enum */ CharDirectionality LEFT_TO_RIGHT_OVERRIDE;
    public static final /* enum */ CharDirectionality NONSPACING_MARK;
    public static final /* enum */ CharDirectionality OTHER_NEUTRALS;
    public static final /* enum */ CharDirectionality PARAGRAPH_SEPARATOR;
    public static final /* enum */ CharDirectionality POP_DIRECTIONAL_FORMAT;
    public static final /* enum */ CharDirectionality RIGHT_TO_LEFT;
    public static final /* enum */ CharDirectionality RIGHT_TO_LEFT_ARABIC;
    public static final /* enum */ CharDirectionality RIGHT_TO_LEFT_EMBEDDING;
    public static final /* enum */ CharDirectionality RIGHT_TO_LEFT_OVERRIDE;
    public static final /* enum */ CharDirectionality SEGMENT_SEPARATOR;
    public static final /* enum */ CharDirectionality UNDEFINED;
    public static final /* enum */ CharDirectionality WHITESPACE;
    private static final /* synthetic */ CharDirectionality[] a;
    private static final t b;
    private final int value;

    static {
        CharDirectionality charDirectionality;
        Object object = new CharDirectionality[20];
        UNDEFINED = charDirectionality = new CharDirectionality("UNDEFINED", 0, -1);
        object[0] = charDirectionality;
        int n10 = 1;
        LEFT_TO_RIGHT = charDirectionality = new CharDirectionality("LEFT_TO_RIGHT", n10, 0);
        object[n10] = charDirectionality;
        int n11 = 2;
        RIGHT_TO_LEFT = charDirectionality = new CharDirectionality("RIGHT_TO_LEFT", n11, n10);
        object[n11] = charDirectionality;
        n10 = 3;
        RIGHT_TO_LEFT_ARABIC = charDirectionality = new CharDirectionality("RIGHT_TO_LEFT_ARABIC", n10, n11);
        object[n10] = charDirectionality;
        n11 = 4;
        EUROPEAN_NUMBER = charDirectionality = new CharDirectionality("EUROPEAN_NUMBER", n11, n10);
        object[n11] = charDirectionality;
        n10 = 5;
        EUROPEAN_NUMBER_SEPARATOR = charDirectionality = new CharDirectionality("EUROPEAN_NUMBER_SEPARATOR", n10, n11);
        object[n10] = charDirectionality;
        n11 = 6;
        EUROPEAN_NUMBER_TERMINATOR = charDirectionality = new CharDirectionality("EUROPEAN_NUMBER_TERMINATOR", n11, n10);
        object[n11] = charDirectionality;
        n10 = 7;
        ARABIC_NUMBER = charDirectionality = new CharDirectionality("ARABIC_NUMBER", n10, n11);
        object[n10] = charDirectionality;
        n11 = 8;
        COMMON_NUMBER_SEPARATOR = charDirectionality = new CharDirectionality("COMMON_NUMBER_SEPARATOR", n11, n10);
        object[n11] = charDirectionality;
        n10 = 9;
        NONSPACING_MARK = charDirectionality = new CharDirectionality("NONSPACING_MARK", n10, n11);
        object[n10] = charDirectionality;
        n11 = 10;
        BOUNDARY_NEUTRAL = charDirectionality = new CharDirectionality("BOUNDARY_NEUTRAL", n11, n10);
        object[n11] = charDirectionality;
        n10 = 11;
        PARAGRAPH_SEPARATOR = charDirectionality = new CharDirectionality("PARAGRAPH_SEPARATOR", n10, n11);
        object[n10] = charDirectionality;
        n11 = 12;
        SEGMENT_SEPARATOR = charDirectionality = new CharDirectionality("SEGMENT_SEPARATOR", n11, n10);
        object[n11] = charDirectionality;
        n10 = 13;
        WHITESPACE = charDirectionality = new CharDirectionality("WHITESPACE", n10, n11);
        object[n10] = charDirectionality;
        n11 = 14;
        OTHER_NEUTRALS = charDirectionality = new CharDirectionality("OTHER_NEUTRALS", n11, n10);
        object[n11] = charDirectionality;
        n10 = 15;
        LEFT_TO_RIGHT_EMBEDDING = charDirectionality = new CharDirectionality("LEFT_TO_RIGHT_EMBEDDING", n10, n11);
        object[n10] = charDirectionality;
        n11 = 16;
        LEFT_TO_RIGHT_OVERRIDE = charDirectionality = new CharDirectionality("LEFT_TO_RIGHT_OVERRIDE", n11, n10);
        object[n11] = charDirectionality;
        n10 = 17;
        RIGHT_TO_LEFT_EMBEDDING = charDirectionality = new CharDirectionality("RIGHT_TO_LEFT_EMBEDDING", n10, n11);
        object[n10] = charDirectionality;
        n11 = 18;
        RIGHT_TO_LEFT_OVERRIDE = charDirectionality = new CharDirectionality("RIGHT_TO_LEFT_OVERRIDE", n11, n10);
        object[n11] = charDirectionality;
        n10 = 19;
        POP_DIRECTIONAL_FORMAT = charDirectionality = new CharDirectionality("POP_DIRECTIONAL_FORMAT", n10, n11);
        object[n10] = charDirectionality;
        a = object;
        Companion = object = new CharDirectionality$a(null);
        b = w.c(CharDirectionality$Companion$directionalityMap$2.INSTANCE);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CharDirectionality() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static final /* synthetic */ t access$getDirectionalityMap$cp() {
        return b;
    }

    public static CharDirectionality valueOf(String string2) {
        return Enum.valueOf(CharDirectionality.class, string2);
    }

    public static CharDirectionality[] values() {
        return (CharDirectionality[])a.clone();
    }

    public final int getValue() {
        return this.value;
    }
}

