/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.t;
import f.w;
import kotlin.text.CharCategory$Companion$categoryMap$2;
import kotlin.text.CharCategory$a;

public final class CharCategory
extends Enum {
    public static final /* enum */ CharCategory COMBINING_SPACING_MARK;
    public static final /* enum */ CharCategory CONNECTOR_PUNCTUATION;
    public static final /* enum */ CharCategory CONTROL;
    public static final /* enum */ CharCategory CURRENCY_SYMBOL;
    public static final CharCategory$a Companion;
    public static final /* enum */ CharCategory DASH_PUNCTUATION;
    public static final /* enum */ CharCategory DECIMAL_DIGIT_NUMBER;
    public static final /* enum */ CharCategory ENCLOSING_MARK;
    public static final /* enum */ CharCategory END_PUNCTUATION;
    public static final /* enum */ CharCategory FINAL_QUOTE_PUNCTUATION;
    public static final /* enum */ CharCategory FORMAT;
    public static final /* enum */ CharCategory INITIAL_QUOTE_PUNCTUATION;
    public static final /* enum */ CharCategory LETTER_NUMBER;
    public static final /* enum */ CharCategory LINE_SEPARATOR;
    public static final /* enum */ CharCategory LOWERCASE_LETTER;
    public static final /* enum */ CharCategory MATH_SYMBOL;
    public static final /* enum */ CharCategory MODIFIER_LETTER;
    public static final /* enum */ CharCategory MODIFIER_SYMBOL;
    public static final /* enum */ CharCategory NON_SPACING_MARK;
    public static final /* enum */ CharCategory OTHER_LETTER;
    public static final /* enum */ CharCategory OTHER_NUMBER;
    public static final /* enum */ CharCategory OTHER_PUNCTUATION;
    public static final /* enum */ CharCategory OTHER_SYMBOL;
    public static final /* enum */ CharCategory PARAGRAPH_SEPARATOR;
    public static final /* enum */ CharCategory PRIVATE_USE;
    public static final /* enum */ CharCategory SPACE_SEPARATOR;
    public static final /* enum */ CharCategory START_PUNCTUATION;
    public static final /* enum */ CharCategory SURROGATE;
    public static final /* enum */ CharCategory TITLECASE_LETTER;
    public static final /* enum */ CharCategory UNASSIGNED;
    public static final /* enum */ CharCategory UPPERCASE_LETTER;
    private static final /* synthetic */ CharCategory[] a;
    private static final t b;
    private final String code;
    private final int value;

    static {
        CharCategory charCategory;
        Object object = new CharCategory[30];
        UNASSIGNED = charCategory = new CharCategory("UNASSIGNED", 0, 0, "Cn");
        object[0] = charCategory;
        int n10 = 1;
        UPPERCASE_LETTER = charCategory = new CharCategory("UPPERCASE_LETTER", n10, n10, "Lu");
        object[n10] = charCategory;
        n10 = 2;
        LOWERCASE_LETTER = charCategory = new CharCategory("LOWERCASE_LETTER", n10, n10, "Ll");
        object[n10] = charCategory;
        n10 = 3;
        TITLECASE_LETTER = charCategory = new CharCategory("TITLECASE_LETTER", n10, n10, "Lt");
        object[n10] = charCategory;
        n10 = 4;
        MODIFIER_LETTER = charCategory = new CharCategory("MODIFIER_LETTER", n10, n10, "Lm");
        object[n10] = charCategory;
        n10 = 5;
        OTHER_LETTER = charCategory = new CharCategory("OTHER_LETTER", n10, n10, "Lo");
        object[n10] = charCategory;
        n10 = 6;
        NON_SPACING_MARK = charCategory = new CharCategory("NON_SPACING_MARK", n10, n10, "Mn");
        object[n10] = charCategory;
        n10 = 7;
        ENCLOSING_MARK = charCategory = new CharCategory("ENCLOSING_MARK", n10, n10, "Me");
        object[n10] = charCategory;
        n10 = 8;
        COMBINING_SPACING_MARK = charCategory = new CharCategory("COMBINING_SPACING_MARK", n10, n10, "Mc");
        object[n10] = charCategory;
        n10 = 9;
        DECIMAL_DIGIT_NUMBER = charCategory = new CharCategory("DECIMAL_DIGIT_NUMBER", n10, n10, "Nd");
        object[n10] = charCategory;
        n10 = 10;
        LETTER_NUMBER = charCategory = new CharCategory("LETTER_NUMBER", n10, n10, "Nl");
        object[n10] = charCategory;
        n10 = 11;
        OTHER_NUMBER = charCategory = new CharCategory("OTHER_NUMBER", n10, n10, "No");
        object[n10] = charCategory;
        n10 = 12;
        SPACE_SEPARATOR = charCategory = new CharCategory("SPACE_SEPARATOR", n10, n10, "Zs");
        object[n10] = charCategory;
        n10 = 13;
        LINE_SEPARATOR = charCategory = new CharCategory("LINE_SEPARATOR", n10, n10, "Zl");
        object[n10] = charCategory;
        n10 = 14;
        PARAGRAPH_SEPARATOR = charCategory = new CharCategory("PARAGRAPH_SEPARATOR", n10, n10, "Zp");
        object[n10] = charCategory;
        n10 = 15;
        CONTROL = charCategory = new CharCategory("CONTROL", n10, n10, "Cc");
        object[n10] = charCategory;
        n10 = 16;
        FORMAT = charCategory = new CharCategory("FORMAT", n10, n10, "Cf");
        object[n10] = charCategory;
        int n11 = 18;
        PRIVATE_USE = charCategory = new CharCategory("PRIVATE_USE", 17, n11, "Co");
        object[17] = charCategory;
        n10 = 19;
        SURROGATE = charCategory = new CharCategory("SURROGATE", n11, n10, "Cs");
        object[n11] = charCategory;
        n11 = 20;
        DASH_PUNCTUATION = charCategory = new CharCategory("DASH_PUNCTUATION", n10, n11, "Pd");
        object[n10] = charCategory;
        n10 = 21;
        START_PUNCTUATION = charCategory = new CharCategory("START_PUNCTUATION", n11, n10, "Ps");
        object[n11] = charCategory;
        n11 = 22;
        END_PUNCTUATION = charCategory = new CharCategory("END_PUNCTUATION", n10, n11, "Pe");
        object[n10] = charCategory;
        n10 = 23;
        CONNECTOR_PUNCTUATION = charCategory = new CharCategory("CONNECTOR_PUNCTUATION", n11, n10, "Pc");
        object[n11] = charCategory;
        OTHER_PUNCTUATION = charCategory = new CharCategory("OTHER_PUNCTUATION", n10, 24, "Po");
        object[23] = charCategory;
        MATH_SYMBOL = charCategory = new CharCategory("MATH_SYMBOL", 24, 25, "Sm");
        object[24] = charCategory;
        CURRENCY_SYMBOL = charCategory = new CharCategory("CURRENCY_SYMBOL", 25, 26, "Sc");
        object[25] = charCategory;
        MODIFIER_SYMBOL = charCategory = new CharCategory("MODIFIER_SYMBOL", 26, 27, "Sk");
        object[26] = charCategory;
        OTHER_SYMBOL = charCategory = new CharCategory("OTHER_SYMBOL", 27, 28, "So");
        object[27] = charCategory;
        INITIAL_QUOTE_PUNCTUATION = charCategory = new CharCategory("INITIAL_QUOTE_PUNCTUATION", 28, 29, "Pi");
        object[28] = charCategory;
        FINAL_QUOTE_PUNCTUATION = charCategory = new CharCategory("FINAL_QUOTE_PUNCTUATION", 29, 30, "Pf");
        object[29] = charCategory;
        a = object;
        Companion = object = new CharCategory$a(null);
        b = w.c(CharCategory$Companion$categoryMap$2.INSTANCE);
    }

    /*
     * WARNING - void declaration
     */
    private CharCategory() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
        this.code = var4_2;
    }

    public static final /* synthetic */ t access$getCategoryMap$cp() {
        return b;
    }

    public static CharCategory valueOf(String string2) {
        return Enum.valueOf(CharCategory.class, string2);
    }

    public static CharCategory[] values() {
        return (CharCategory[])a.clone();
    }

    public final boolean contains(char c10) {
        int n10;
        c10 = (c10 = (char)Character.getType(c10)) == (n10 = this.value) ? (char)'\u0001' : '\u0000';
        return c10 != 0;
    }

    public final String getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }
}

