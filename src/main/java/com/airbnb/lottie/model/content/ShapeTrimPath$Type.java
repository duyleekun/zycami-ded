/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.content;

public final class ShapeTrimPath$Type
extends Enum {
    private static final /* synthetic */ ShapeTrimPath$Type[] $VALUES;
    public static final /* enum */ ShapeTrimPath$Type INDIVIDUALLY;
    public static final /* enum */ ShapeTrimPath$Type SIMULTANEOUSLY;

    static {
        ShapeTrimPath$Type shapeTrimPath$Type;
        ShapeTrimPath$Type shapeTrimPath$Type2;
        SIMULTANEOUSLY = shapeTrimPath$Type2 = new ShapeTrimPath$Type("SIMULTANEOUSLY", 0);
        int n10 = 1;
        INDIVIDUALLY = shapeTrimPath$Type = new ShapeTrimPath$Type("INDIVIDUALLY", n10);
        ShapeTrimPath$Type[] shapeTrimPath$TypeArray = new ShapeTrimPath$Type[2];
        shapeTrimPath$TypeArray[0] = shapeTrimPath$Type2;
        shapeTrimPath$TypeArray[n10] = shapeTrimPath$Type;
        $VALUES = shapeTrimPath$TypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ShapeTrimPath$Type() {
        void var2_-1;
        void var1_-1;
    }

    public static ShapeTrimPath$Type forId(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 == n11) {
                return INDIVIDUALLY;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown trim path type ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        return SIMULTANEOUSLY;
    }

    public static ShapeTrimPath$Type valueOf(String string2) {
        return Enum.valueOf(ShapeTrimPath$Type.class, string2);
    }

    public static ShapeTrimPath$Type[] values() {
        return (ShapeTrimPath$Type[])$VALUES.clone();
    }
}

