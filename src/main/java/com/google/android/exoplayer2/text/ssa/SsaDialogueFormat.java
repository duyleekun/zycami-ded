/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.text.ssa;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class SsaDialogueFormat {
    public final int endTimeIndex;
    public final int length;
    public final int startTimeIndex;
    public final int styleIndex;
    public final int textIndex;

    private SsaDialogueFormat(int n10, int n11, int n12, int n13, int n14) {
        this.startTimeIndex = n10;
        this.endTimeIndex = n11;
        this.styleIndex = n12;
        this.textIndex = n13;
        this.length = n14;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static SsaDialogueFormat fromFormatLine(String stringArray) {
        int n10;
        Object object;
        int n11;
        Assertions.checkArgument(stringArray.startsWith("Format:"));
        stringArray = TextUtils.split((String)stringArray.substring(7), (String)",");
        SsaDialogueFormat ssaDialogueFormat = null;
        int n12 = -1;
        int n13 = n12;
        int n14 = n12;
        int n15 = n12;
        int n16 = n12;
        block12: for (int i10 = 0; i10 < (n11 = stringArray.length); ++i10) {
            block13: {
                block14: {
                    object = Util.toLowerInvariant(stringArray[i10].trim());
                    ((String)object).hashCode();
                    n10 = ((String)object).hashCode();
                    switch (n10) {
                        case 109780401: {
                            String string2 = "style";
                            n11 = (int)(((String)object).equals(string2) ? 1 : 0);
                            if (n11 == 0) break;
                            n11 = 3;
                            break block13;
                        }
                        case 109757538: {
                            String string2 = "start";
                            n11 = (int)(((String)object).equals(string2) ? 1 : 0);
                            if (n11 == 0) break;
                            n11 = 2;
                            break block13;
                        }
                        case 3556653: {
                            String string2 = "text";
                            n11 = (int)(((String)object).equals(string2) ? 1 : 0);
                            if (n11 == 0) break;
                            n11 = 1;
                            break block13;
                        }
                        case 100571: {
                            String string2 = "end";
                            n11 = (int)(((String)object).equals(string2) ? 1 : 0);
                            if (n11 != 0) break block14;
                        }
                    }
                    n11 = n12;
                    break block13;
                }
                n11 = 0;
                object = null;
            }
            switch (n11) {
                default: {
                    continue block12;
                }
                case 3: {
                    n15 = i10;
                    continue block12;
                }
                case 2: {
                    n13 = i10;
                    continue block12;
                }
                case 1: {
                    n16 = i10;
                    continue block12;
                }
                case 0: {
                    n14 = i10;
                }
            }
        }
        if (n13 == n12) return null;
        if (n14 == n12) return null;
        n10 = stringArray.length;
        object = ssaDialogueFormat;
        return new SsaDialogueFormat(n13, n14, n15, n16, n10);
    }
}

