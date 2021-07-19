/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Ascii;
import com.google.common.base.CaseFormat$1;
import com.google.common.base.CaseFormat$2;
import com.google.common.base.CaseFormat$3;
import com.google.common.base.CaseFormat$4;
import com.google.common.base.CaseFormat$5;
import com.google.common.base.CaseFormat$StringConverter;
import com.google.common.base.CharMatcher;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;

public abstract class CaseFormat
extends Enum {
    private static final /* synthetic */ CaseFormat[] $VALUES;
    public static final /* enum */ CaseFormat LOWER_CAMEL;
    public static final /* enum */ CaseFormat LOWER_HYPHEN;
    public static final /* enum */ CaseFormat LOWER_UNDERSCORE;
    public static final /* enum */ CaseFormat UPPER_CAMEL;
    public static final /* enum */ CaseFormat UPPER_UNDERSCORE;
    private final CharMatcher wordBoundary;
    private final String wordSeparator;

    static {
        Object object = CharMatcher.is('-');
        CaseFormat$1 caseFormat$1 = new CaseFormat$1((CharMatcher)object, "-");
        LOWER_HYPHEN = caseFormat$1;
        char c10 = '_';
        Object object2 = CharMatcher.is(c10);
        int n10 = 1;
        String string2 = "_";
        object = new CaseFormat$2((CharMatcher)object2, string2);
        LOWER_UNDERSCORE = object;
        char c11 = 'A';
        char c12 = 'Z';
        Object object3 = CharMatcher.inRange(c11, c12);
        int n11 = 2;
        String string3 = "";
        object2 = new CaseFormat$3((CharMatcher)object3, string3);
        LOWER_CAMEL = object2;
        Object object4 = CharMatcher.inRange(c11, c12);
        int n12 = 3;
        object3 = new CaseFormat$4((CharMatcher)object4, string3);
        UPPER_CAMEL = object3;
        CaseFormat[] caseFormatArray = CharMatcher.is(c10);
        int n13 = 4;
        object4 = new CaseFormat$5((CharMatcher)caseFormatArray, string2);
        UPPER_UNDERSCORE = object4;
        caseFormatArray = new CaseFormat[5];
        caseFormatArray[0] = caseFormat$1;
        caseFormatArray[n10] = object;
        caseFormatArray[n11] = object2;
        caseFormatArray[n12] = object3;
        caseFormatArray[n13] = object4;
        $VALUES = caseFormatArray;
    }

    /*
     * WARNING - void declaration
     */
    private CaseFormat() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.wordBoundary = var3_1;
        this.wordSeparator = var4_2;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ CaseFormat(CharMatcher charMatcher, String string2, CaseFormat$1 caseFormat$1) {
        this((String)var1_-1, (int)string2, (CharMatcher)((Object)caseFormat$1), (String)var4_3);
        void var4_3;
        void var1_-1;
    }

    public static /* synthetic */ String access$100(String string2) {
        return CaseFormat.firstCharOnlyToUpper(string2);
    }

    private static String firstCharOnlyToUpper(String string2) {
        boolean bl2 = string2.isEmpty();
        if (!bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            char c10 = Ascii.toUpperCase(string2.charAt(0));
            stringBuilder.append(c10);
            c10 = '\u0001';
            string2 = Ascii.toLowerCase(string2.substring(c10));
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    public static CaseFormat valueOf(String string2) {
        return Enum.valueOf(CaseFormat.class, string2);
    }

    public static CaseFormat[] values() {
        return (CaseFormat[])$VALUES.clone();
    }

    public String convert(CaseFormat object, String string2) {
        int n10 = -1;
        StringBuilder stringBuilder = null;
        int n11 = 0;
        String string3 = null;
        int n12 = n10;
        while (true) {
            CharMatcher charMatcher = this.wordBoundary;
            ++n12;
            if ((n12 = charMatcher.indexIn(string2, n12)) == n10) break;
            if (n11 == 0) {
                int n13 = string2.length();
                String string4 = ((CaseFormat)object).wordSeparator;
                int n14 = string4.length() * 4;
                stringBuilder = new StringBuilder(n13 += n14);
                string3 = string2.substring(n11, n12);
                string3 = ((CaseFormat)((Object)object)).normalizeFirstWord(string3);
                stringBuilder.append(string3);
            } else {
                string3 = string2.substring(n11, n12);
                string3 = ((CaseFormat)((Object)object)).normalizeWord(string3);
                stringBuilder.append(string3);
            }
            string3 = ((CaseFormat)object).wordSeparator;
            stringBuilder.append(string3);
            string3 = this.wordSeparator;
            n11 = string3.length() + n12;
        }
        if (n11 == 0) {
            object = ((CaseFormat)((Object)object)).normalizeFirstWord(string2);
        } else {
            string2 = string2.substring(n11);
            object = ((CaseFormat)((Object)object)).normalizeWord(string2);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
        }
        return object;
    }

    public Converter converterTo(CaseFormat caseFormat) {
        CaseFormat$StringConverter caseFormat$StringConverter = new CaseFormat$StringConverter(this, caseFormat);
        return caseFormat$StringConverter;
    }

    public String normalizeFirstWord(String string2) {
        return this.normalizeWord(string2);
    }

    public abstract String normalizeWord(String var1);

    public final String to(CaseFormat caseFormat, String string2) {
        Preconditions.checkNotNull((Object)caseFormat);
        Preconditions.checkNotNull(string2);
        if (caseFormat != this) {
            string2 = this.convert(caseFormat, string2);
        }
        return string2;
    }
}

