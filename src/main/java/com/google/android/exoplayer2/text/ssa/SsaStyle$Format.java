/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.text.ssa;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.Util;

public final class SsaStyle$Format {
    public final int alignmentIndex;
    public final int fontSizeIndex;
    public final int length;
    public final int nameIndex;
    public final int primaryColorIndex;

    private SsaStyle$Format(int n10, int n11, int n12, int n13, int n14) {
        this.nameIndex = n10;
        this.alignmentIndex = n11;
        this.primaryColorIndex = n12;
        this.fontSizeIndex = n13;
        this.length = n14;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static SsaStyle$Format fromFormatLine(String stringArray) {
        int n10;
        Object object;
        int n11;
        stringArray = TextUtils.split((String)stringArray.substring(7), (String)",");
        SsaStyle$Format ssaStyle$Format = null;
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
                        case 1767875043: {
                            String string2 = "alignment";
                            n11 = (int)(((String)object).equals(string2) ? 1 : 0);
                            if (n11 == 0) break;
                            n11 = 3;
                            break block13;
                        }
                        case 366554320: {
                            String string2 = "fontsize";
                            n11 = (int)(((String)object).equals(string2) ? 1 : 0);
                            if (n11 == 0) break;
                            n11 = 2;
                            break block13;
                        }
                        case 3373707: {
                            String string2 = "name";
                            n11 = (int)(((String)object).equals(string2) ? 1 : 0);
                            if (n11 == 0) break;
                            n11 = 1;
                            break block13;
                        }
                        case -70925746: {
                            String string2 = "primarycolour";
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
                    n14 = i10;
                    continue block12;
                }
                case 2: {
                    n16 = i10;
                    continue block12;
                }
                case 1: {
                    n13 = i10;
                    continue block12;
                }
                case 0: {
                    n15 = i10;
                }
            }
        }
        if (n13 == n12) return null;
        n10 = stringArray.length;
        object = ssaStyle$Format;
        return new SsaStyle$Format(n13, n14, n15, n16, n10);
    }
}

