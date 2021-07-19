/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

public final class TextFormat$Parser$SingularOverwritePolicy
extends Enum {
    private static final /* synthetic */ TextFormat$Parser$SingularOverwritePolicy[] $VALUES;
    public static final /* enum */ TextFormat$Parser$SingularOverwritePolicy ALLOW_SINGULAR_OVERWRITES;
    public static final /* enum */ TextFormat$Parser$SingularOverwritePolicy FORBID_SINGULAR_OVERWRITES;

    static {
        TextFormat$Parser$SingularOverwritePolicy textFormat$Parser$SingularOverwritePolicy;
        TextFormat$Parser$SingularOverwritePolicy textFormat$Parser$SingularOverwritePolicy2;
        ALLOW_SINGULAR_OVERWRITES = textFormat$Parser$SingularOverwritePolicy2 = new TextFormat$Parser$SingularOverwritePolicy("ALLOW_SINGULAR_OVERWRITES", 0);
        int n10 = 1;
        FORBID_SINGULAR_OVERWRITES = textFormat$Parser$SingularOverwritePolicy = new TextFormat$Parser$SingularOverwritePolicy("FORBID_SINGULAR_OVERWRITES", n10);
        TextFormat$Parser$SingularOverwritePolicy[] textFormat$Parser$SingularOverwritePolicyArray = new TextFormat$Parser$SingularOverwritePolicy[2];
        textFormat$Parser$SingularOverwritePolicyArray[0] = textFormat$Parser$SingularOverwritePolicy2;
        textFormat$Parser$SingularOverwritePolicyArray[n10] = textFormat$Parser$SingularOverwritePolicy;
        $VALUES = textFormat$Parser$SingularOverwritePolicyArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private TextFormat$Parser$SingularOverwritePolicy() {
        void var2_-1;
        void var1_-1;
    }

    public static TextFormat$Parser$SingularOverwritePolicy valueOf(String string2) {
        return Enum.valueOf(TextFormat$Parser$SingularOverwritePolicy.class, string2);
    }

    public static TextFormat$Parser$SingularOverwritePolicy[] values() {
        return (TextFormat$Parser$SingularOverwritePolicy[])$VALUES.clone();
    }
}

