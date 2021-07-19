/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.backend.FormatChar;
import com.google.common.flogger.parser.ParseException;

public final class FormatOptions {
    public static final int ALL_FLAGS = 255;
    private static final FormatOptions DEFAULT;
    private static final long ENCODED_FLAG_INDICES = 0L;
    private static final String FLAG_CHARS_ORDERED = " #(+,-0";
    public static final int FLAG_LEFT_ALIGN = 32;
    public static final int FLAG_PREFIX_PLUS_FOR_POSITIVE_VALUES = 8;
    public static final int FLAG_PREFIX_SPACE_FOR_POSITIVE_VALUES = 1;
    public static final int FLAG_SHOW_ALT_FORM = 2;
    public static final int FLAG_SHOW_GROUPING = 16;
    public static final int FLAG_SHOW_LEADING_ZEROS = 64;
    public static final int FLAG_UPPER_CASE = 128;
    public static final int FLAG_USE_PARENS_FOR_NEGATIVE_VALUES = 4;
    private static final int MAX_ALLOWED_PRECISION = 999999;
    private static final int MAX_ALLOWED_WIDTH = 999999;
    private static final int MAX_FLAG_VALUE = 48;
    private static final int MIN_FLAG_VALUE = 32;
    public static final int UNSET = 255;
    private final int flags;
    private final int precision;
    private final int width;

    static {
        FormatOptions formatOptions;
        int n10;
        long l10 = 0L;
        for (int i10 = 0; i10 < (n10 = 7); ++i10) {
            String string2 = FLAG_CHARS_ORDERED;
            long l11 = string2.charAt(i10) + -32;
            long l12 = (long)i10 + 1L;
            long l13 = 3;
            n10 = (int)(l11 * l13);
            l11 = l12 << n10;
            l10 |= l11;
        }
        ENCODED_FLAG_INDICES = l10;
        int n11 = -1;
        DEFAULT = formatOptions = new FormatOptions(0, n11, n11);
    }

    private FormatOptions(int n10, int n11, int n12) {
        this.flags = n10;
        this.width = n11;
        this.precision = n12;
    }

    public static boolean checkFlagConsistency(int n10, boolean bl2) {
        int n11 = n10 & 9;
        int n12 = 9;
        if (n11 == n12) {
            return false;
        }
        n11 = 96;
        if ((n10 &= n11) == n11) {
            return false;
        }
        return n10 == 0 || bl2;
    }

    public static FormatOptions getDefault() {
        return DEFAULT;
    }

    private static int indexOfFlagCharacter(char c10) {
        long l10 = ENCODED_FLAG_INDICES;
        c10 = (char)((c10 + -32) * 3);
        return (int)(l10 >>> c10 & (long)7) + -1;
    }

    public static FormatOptions of(int n10, int n11, int n12) {
        int n13 = 1;
        int n14 = -1;
        int n15 = n11 != n14 ? n13 : 0;
        if ((n15 = FormatOptions.checkFlagConsistency(n10, n15 != 0)) != 0) {
            n15 = 999999;
            if (n11 >= n13 && n11 <= n15 || n11 == n14) {
                if (n12 >= 0 && n12 <= n15 || n12 == n14) {
                    FormatOptions formatOptions = new FormatOptions(n10, n11, n12);
                    return formatOptions;
                }
                CharSequence charSequence = new StringBuilder();
                charSequence.append("invalid precision: ");
                charSequence.append(n12);
                charSequence = charSequence.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
                throw illegalArgumentException;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid width: ");
            stringBuilder.append(n11);
            String string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid flags: 0x");
        String string3 = Integer.toHexString(n10);
        stringBuilder.append(string3);
        string3 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }

    public static FormatOptions parse(String object, int n10, int n11, boolean bl2) {
        int n12;
        int n13;
        String string2;
        int n14;
        int n15;
        int n16;
        int n17;
        int n18;
        block11: {
            if (n10 == n11 && !bl2) {
                return DEFAULT;
            }
            if (bl2) {
                int n19 = 128;
            } else {
                boolean bl3 = false;
            }
            while (true) {
                n18 = -1;
                if (n10 == n11) {
                    object = new FormatOptions(n17, n18, n18);
                    return object;
                }
                n16 = n10 + 1;
                n10 = ((String)object).charAt(n10);
                n15 = 32;
                n14 = 46;
                string2 = "invalid flag";
                n13 = 48;
                n12 = 1;
                if (n10 < n15 || n10 > n13) break block11;
                n15 = FormatOptions.indexOfFlagCharacter((char)n10);
                if (n15 < 0) {
                    if (n10 == n14) {
                        int n20 = FormatOptions.parsePrecision((String)object, n16, n11);
                        FormatOptions formatOptions = new FormatOptions(n17, n18, n20);
                        return formatOptions;
                    }
                    throw ParseException.atPosition(string2, (String)object, n16 -= n12);
                }
                n10 = n12 << n15;
                n18 = n17 & n10;
                if (n18 != 0) break;
                n17 |= n10;
                n10 = n16;
            }
            throw ParseException.atPosition("repeated flag", (String)object, n16 -= n12);
        }
        n15 = n16 + -1;
        int n21 = 57;
        if (n10 <= n21) {
            block12: {
                n10 -= n13;
                while (true) {
                    if (n16 == n11) {
                        object = new FormatOptions(n17, n10, n18);
                        return object;
                    }
                    int n22 = n16 + 1;
                    if ((n16 = (int)((String)object).charAt(n16)) == n14) {
                        int n23 = FormatOptions.parsePrecision((String)object, n22, n11);
                        FormatOptions formatOptions = new FormatOptions(n17, n10, n23);
                        return formatOptions;
                    }
                    n13 = 10;
                    if ((n16 = (int)((char)(n16 + -48))) >= n13) break block12;
                    if ((n10 = n10 * 10 + n16) > (n16 = 999999)) break;
                    n16 = n22;
                }
                throw ParseException.withBounds("width too large", (String)object, n15, n11);
            }
            throw ParseException.atPosition("invalid width character", (String)object, n22 -= n12);
        }
        throw ParseException.atPosition(string2, (String)object, n15);
    }

    private static int parsePrecision(String string2, int n10, int n11) {
        if (n10 != n11) {
            int n12;
            int n13 = 0;
            for (n12 = n10; n12 < n11; ++n12) {
                int n14;
                int n15 = string2.charAt(n12) + -48;
                if (n15 < (n14 = 10)) {
                    if ((n13 = n13 * 10 + n15) <= (n15 = 999999)) {
                        continue;
                    }
                    throw ParseException.withBounds("precision too large", string2, n10, n11);
                }
                throw ParseException.atPosition("invalid precision character", string2, n12);
            }
            if (n13 == 0 && n11 != (n12 = n10 + 1)) {
                throw ParseException.withBounds("invalid precision", string2, n10, n11);
            }
            return n13;
        }
        throw ParseException.atPosition("missing precision", string2, n10 += -1);
    }

    public static int parseValidFlags(String string2, boolean bl2) {
        int n10;
        int n11;
        IllegalArgumentException illegalArgumentException;
        int n12 = 0;
        StringBuilder stringBuilder = null;
        if (bl2) {
            int n13 = 128;
        } else {
            boolean bl3 = false;
            illegalArgumentException = null;
        }
        while (n12 < (n11 = string2.length())) {
            n11 = FormatOptions.indexOfFlagCharacter(string2.charAt(n12));
            if (n11 >= 0) {
                int n14 = 1;
                n11 = n14 << n11;
                n10 |= n11;
                ++n12;
                continue;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("invalid flags: ");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        return n10;
    }

    public StringBuilder appendPrintfOptions(StringBuilder stringBuilder) {
        int n10 = this.isDefault();
        if (n10 == 0) {
            char c10;
            n10 = this.flags & 0xFFFFFF7F;
            int n11 = 0;
            while ((c10 = 1 << n11) <= n10) {
                if ((c10 &= n10) != '\u0000') {
                    String string2 = FLAG_CHARS_ORDERED;
                    c10 = string2.charAt(n11);
                    stringBuilder.append(c10);
                }
                ++n11;
            }
            n10 = this.width;
            n11 = -1;
            if (n10 != n11) {
                stringBuilder.append(n10);
            }
            if ((n10 = this.precision) != n11) {
                stringBuilder.append('.');
                n10 = this.precision;
                stringBuilder.append(n10);
            }
        }
        return stringBuilder;
    }

    public boolean areValidFor(FormatChar formatChar) {
        int n10 = formatChar.getAllowedFlags();
        boolean bl2 = formatChar.getType().supportsPrecision();
        return this.validate(n10, bl2);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof FormatOptions;
        if (n10 != 0) {
            int n11;
            object = (FormatOptions)object;
            n10 = ((FormatOptions)object).flags;
            int n12 = this.flags;
            if (n10 != n12 || (n10 = ((FormatOptions)object).width) != (n12 = this.width) || (n11 = ((FormatOptions)object).precision) != (n10 = this.precision)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public FormatOptions filter(int n10, boolean n11, boolean n12) {
        int n13 = this.isDefault();
        if (n13 != 0) {
            return this;
        }
        n13 = this.flags;
        int n14 = -1;
        n11 = n11 != 0 ? this.width : n14;
        n12 = n12 != 0 ? this.precision : n14;
        if ((n10 &= n13) == 0 && n11 == n14 && n12 == n14) {
            return DEFAULT;
        }
        if (n10 == n13 && n11 == (n13 = this.width) && n12 == (n13 = this.precision)) {
            return this;
        }
        FormatOptions formatOptions = new FormatOptions(n10, n11, n12);
        return formatOptions;
    }

    public int getFlags() {
        return this.flags;
    }

    public int getPrecision() {
        return this.precision;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int n10 = this.flags * 31;
        int n11 = this.width;
        n10 = (n10 + n11) * 31;
        n11 = this.precision;
        return n10 + n11;
    }

    public boolean isDefault() {
        boolean bl2;
        FormatOptions formatOptions = FormatOptions.getDefault();
        if (this == formatOptions) {
            bl2 = true;
        } else {
            bl2 = false;
            formatOptions = null;
        }
        return bl2;
    }

    public boolean shouldLeftAlign() {
        int n10 = this.flags & 0x20;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean shouldPrefixPlusForPositiveValues() {
        int n10 = this.flags & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean shouldPrefixSpaceForPositiveValues() {
        int n10 = this.flags;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean shouldShowAltForm() {
        int n10 = this.flags & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean shouldShowGrouping() {
        int n10 = this.flags & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean shouldShowLeadingZeros() {
        int n10 = this.flags & 0x40;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean shouldUpperCase() {
        int n10 = this.flags & 0x80;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean validate(int n10, boolean n11) {
        int n12 = this.isDefault();
        boolean bl2 = true;
        if (n12 != 0) {
            return bl2;
        }
        n12 = this.flags;
        if ((n10 = ~n10 & n12) != 0) {
            return false;
        }
        n10 = -1;
        if (n11 == 0 && (n11 = this.precision) != n10) {
            return false;
        }
        n11 = this.getWidth();
        if (n11 == n10) {
            bl2 = false;
        }
        return FormatOptions.checkFlagConsistency(n12, bl2);
    }
}

