/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.text.ssa;

import android.graphics.Color;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ssa.SsaStyle$Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;

public final class SsaStyle {
    public static final int SSA_ALIGNMENT_BOTTOM_CENTER = 2;
    public static final int SSA_ALIGNMENT_BOTTOM_LEFT = 1;
    public static final int SSA_ALIGNMENT_BOTTOM_RIGHT = 3;
    public static final int SSA_ALIGNMENT_MIDDLE_CENTER = 5;
    public static final int SSA_ALIGNMENT_MIDDLE_LEFT = 4;
    public static final int SSA_ALIGNMENT_MIDDLE_RIGHT = 6;
    public static final int SSA_ALIGNMENT_TOP_CENTER = 8;
    public static final int SSA_ALIGNMENT_TOP_LEFT = 7;
    public static final int SSA_ALIGNMENT_TOP_RIGHT = 9;
    public static final int SSA_ALIGNMENT_UNKNOWN = 255;
    private static final String TAG = "SsaStyle";
    public final int alignment;
    public final float fontSize;
    public final String name;
    public final Integer primaryColor;

    private SsaStyle(String string2, int n10, Integer n11, float f10) {
        this.name = string2;
        this.alignment = n10;
        this.primaryColor = n11;
        this.fontSize = f10;
    }

    public static /* synthetic */ int access$000(String string2) {
        return SsaStyle.parseAlignment(string2);
    }

    public static SsaStyle fromStyleLine(String string2, SsaStyle$Format object) {
        Assertions.checkArgument(string2.startsWith("Style:"));
        int n10 = 6;
        Object object2 = string2.substring(n10);
        Object object3 = ",";
        object2 = TextUtils.split((String)object2, (String)object3);
        int n11 = ((String[])object2).length;
        int n12 = ((SsaStyle$Format)object).length;
        String string3 = TAG;
        if (n11 != n12) {
            object = new Object[3];
            Integer n13 = n12;
            object[0] = n13;
            object[1] = object2 = Integer.valueOf(((String[])object2).length);
            object[2] = string2;
            string2 = Util.formatInvariant("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", (Object[])object);
            Log.w(string3, string2);
            return null;
        }
        try {
            n12 = ((SsaStyle$Format)object).nameIndex;
        }
        catch (RuntimeException runtimeException) {
            n10 = String.valueOf(string2).length() + 36;
            object3 = new StringBuilder(n10);
            ((StringBuilder)object3).append("Skipping malformed 'Style:' line: '");
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append("'");
            string2 = ((StringBuilder)object3).toString();
            Log.w(string3, string2, runtimeException);
            return null;
        }
        String string4 = object2[n12];
        string4 = string4.trim();
        int n14 = ((SsaStyle$Format)object).alignmentIndex;
        String string5 = object2[n14];
        string5 = string5.trim();
        n14 = SsaStyle.parseAlignment(string5);
        int n15 = ((SsaStyle$Format)object).primaryColorIndex;
        Object object4 = object2[n15];
        object4 = ((String)object4).trim();
        object4 = SsaStyle.parseColor((String)object4);
        int n16 = ((SsaStyle$Format)object).fontSizeIndex;
        object = object2[n16];
        object = ((String)object).trim();
        float f10 = SsaStyle.parseFontSize((String)object);
        object3 = new SsaStyle(string4, n14, (Integer)object4, f10);
        return object3;
    }

    private static boolean isValidAlignment(int n10) {
        switch (n10) {
            default: {
                return false;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
        }
        return true;
    }

    private static int parseAlignment(String string2) {
        String string3;
        try {
            string3 = string2.trim();
        }
        catch (NumberFormatException numberFormatException) {}
        int n10 = Integer.parseInt(string3);
        int n11 = (int)(SsaStyle.isValidAlignment(n10) ? 1 : 0);
        if (n11 != 0) {
            return n10;
        }
        string3 = "Ignoring unknown alignment: ";
        n11 = (string2 = String.valueOf(string2)).length();
        string2 = n11 != 0 ? string3.concat(string2) : new String(string3);
        Log.w(TAG, string2);
        return -1;
    }

    public static Integer parseColor(String string2) {
        long l10;
        int n10;
        int n11;
        String string3;
        block9: {
            block8: {
                string3 = "&H";
                try {
                    n11 = string2.startsWith(string3);
                    n10 = 16;
                    if (n11 == 0) break block8;
                    n11 = 2;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    n10 = String.valueOf(string2).length() + 36;
                    StringBuilder stringBuilder = new StringBuilder(n10);
                    stringBuilder.append("Failed to parse color expression: '");
                    stringBuilder.append(string2);
                    stringBuilder.append("'");
                    string2 = stringBuilder.toString();
                    Log.w(TAG, string2, illegalArgumentException);
                    return null;
                }
                string3 = string2.substring(n11);
                l10 = Long.parseLong(string3, n10);
                break block9;
            }
            l10 = Long.parseLong(string2);
        }
        long l11 = 0xFFFFFFFFL;
        n11 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        if (n11 <= 0) {
            n11 = 1;
        } else {
            n11 = 0;
            string3 = null;
        }
        Assertions.checkArgument(n11 != 0);
        l11 = l10 >> 24;
        long l12 = 255L;
        int n12 = Ints.checkedCast(l11 & l12 ^ l12);
        n11 = Ints.checkedCast(l10 >> n10 & l12);
        n10 = Ints.checkedCast(l10 >> 8 & l12);
        int n13 = Ints.checkedCast(l10 & l12);
        return Color.argb((int)n12, (int)n13, (int)n10, (int)n11);
    }

    private static float parseFontSize(String string2) {
        try {
            return Float.parseFloat(string2);
        }
        catch (NumberFormatException numberFormatException) {
            int n10 = String.valueOf(string2).length() + 29;
            StringBuilder stringBuilder = new StringBuilder(n10);
            stringBuilder.append("Failed to parse font size: '");
            stringBuilder.append(string2);
            stringBuilder.append("'");
            string2 = stringBuilder.toString();
            Log.w(TAG, string2, numberFormatException);
            return -3.4028235E38f;
        }
    }
}

