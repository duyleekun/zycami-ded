/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

public final class TextFormat$Parser$UnknownField$Type
extends Enum {
    private static final /* synthetic */ TextFormat$Parser$UnknownField$Type[] $VALUES;
    public static final /* enum */ TextFormat$Parser$UnknownField$Type EXTENSION;
    public static final /* enum */ TextFormat$Parser$UnknownField$Type FIELD;

    static {
        TextFormat$Parser$UnknownField$Type textFormat$Parser$UnknownField$Type;
        TextFormat$Parser$UnknownField$Type textFormat$Parser$UnknownField$Type2;
        FIELD = textFormat$Parser$UnknownField$Type2 = new TextFormat$Parser$UnknownField$Type("FIELD", 0);
        int n10 = 1;
        EXTENSION = textFormat$Parser$UnknownField$Type = new TextFormat$Parser$UnknownField$Type("EXTENSION", n10);
        TextFormat$Parser$UnknownField$Type[] textFormat$Parser$UnknownField$TypeArray = new TextFormat$Parser$UnknownField$Type[2];
        textFormat$Parser$UnknownField$TypeArray[0] = textFormat$Parser$UnknownField$Type2;
        textFormat$Parser$UnknownField$TypeArray[n10] = textFormat$Parser$UnknownField$Type;
        $VALUES = textFormat$Parser$UnknownField$TypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private TextFormat$Parser$UnknownField$Type() {
        void var2_-1;
        void var1_-1;
    }

    public static TextFormat$Parser$UnknownField$Type valueOf(String string2) {
        return Enum.valueOf(TextFormat$Parser$UnknownField$Type.class, string2);
    }

    public static TextFormat$Parser$UnknownField$Type[] values() {
        return (TextFormat$Parser$UnknownField$Type[])$VALUES.clone();
    }
}

