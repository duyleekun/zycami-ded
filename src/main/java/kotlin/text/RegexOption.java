/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.t.u;
import f.q2.g;

public final class RegexOption
extends Enum
implements g {
    public static final /* enum */ RegexOption CANON_EQ;
    public static final /* enum */ RegexOption COMMENTS;
    public static final /* enum */ RegexOption DOT_MATCHES_ALL;
    public static final /* enum */ RegexOption IGNORE_CASE;
    public static final /* enum */ RegexOption LITERAL;
    public static final /* enum */ RegexOption MULTILINE;
    public static final /* enum */ RegexOption UNIX_LINES;
    private static final /* synthetic */ RegexOption[] a;
    private final int mask;
    private final int value;

    static {
        RegexOption regexOption;
        RegexOption[] regexOptionArray = new RegexOption[7];
        RegexOption regexOption2 = regexOption;
        IGNORE_CASE = regexOption = new RegexOption("IGNORE_CASE", 0, 2, 0, 2, null);
        regexOptionArray[0] = regexOption;
        MULTILINE = regexOption2 = new RegexOption("MULTILINE", 1, 8, 0, 2, null);
        regexOptionArray[1] = regexOption2;
        int n10 = 2;
        LITERAL = regexOption2 = new RegexOption("LITERAL", 2, 16, 0, n10, null);
        regexOptionArray[2] = regexOption2;
        UNIX_LINES = regexOption2 = new RegexOption("UNIX_LINES", 3, 1, 0, n10, null);
        regexOptionArray[3] = regexOption2;
        COMMENTS = regexOption2 = new RegexOption("COMMENTS", 4, 4, 0, n10, null);
        regexOptionArray[4] = regexOption2;
        DOT_MATCHES_ALL = regexOption2 = new RegexOption("DOT_MATCHES_ALL", 5, 32, 0, n10, null);
        regexOptionArray[5] = regexOption2;
        CANON_EQ = regexOption2 = new RegexOption("CANON_EQ", 6, 128, 0, n10, null);
        regexOptionArray[6] = regexOption2;
        a = regexOptionArray;
    }

    /*
     * WARNING - void declaration
     */
    private RegexOption() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
        this.mask = var4_2;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ RegexOption(int n10, int n11, int n12, u object) {
        void var1_-1;
        void var5_4;
        int n13 = var5_4 & 2;
        if (n13 != 0) {
            object = n12;
        }
        this((String)var1_-1, n11, n12, (int)object);
    }

    public static RegexOption valueOf(String string2) {
        return Enum.valueOf(RegexOption.class, string2);
    }

    public static RegexOption[] values() {
        return (RegexOption[])a.clone();
    }

    public int getMask() {
        return this.mask;
    }

    public int getValue() {
        return this.value;
    }
}

