/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher$1;
import com.google.common.base.CharMatcher$And;
import com.google.common.base.CharMatcher$Any;
import com.google.common.base.CharMatcher$AnyOf;
import com.google.common.base.CharMatcher$Ascii;
import com.google.common.base.CharMatcher$BitSetMatcher;
import com.google.common.base.CharMatcher$BreakingWhitespace;
import com.google.common.base.CharMatcher$Digit;
import com.google.common.base.CharMatcher$ForPredicate;
import com.google.common.base.CharMatcher$InRange;
import com.google.common.base.CharMatcher$Invisible;
import com.google.common.base.CharMatcher$Is;
import com.google.common.base.CharMatcher$IsEither;
import com.google.common.base.CharMatcher$IsNot;
import com.google.common.base.CharMatcher$JavaDigit;
import com.google.common.base.CharMatcher$JavaIsoControl;
import com.google.common.base.CharMatcher$JavaLetter;
import com.google.common.base.CharMatcher$JavaLetterOrDigit;
import com.google.common.base.CharMatcher$JavaLowerCase;
import com.google.common.base.CharMatcher$JavaUpperCase;
import com.google.common.base.CharMatcher$Negated;
import com.google.common.base.CharMatcher$None;
import com.google.common.base.CharMatcher$Or;
import com.google.common.base.CharMatcher$SingleWidth;
import com.google.common.base.CharMatcher$Whitespace;
import com.google.common.base.Platform;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.SmallCharMatcher;
import java.util.BitSet;

public abstract class CharMatcher
implements Predicate {
    private static final int DISTINCT_CHARS = 65536;

    public static /* synthetic */ String access$100(char c10) {
        return CharMatcher.showCharacter(c10);
    }

    public static CharMatcher any() {
        return CharMatcher$Any.INSTANCE;
    }

    public static CharMatcher anyOf(CharSequence charSequence) {
        int n10 = charSequence.length();
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                int n12 = 2;
                if (n10 != n12) {
                    CharMatcher$AnyOf charMatcher$AnyOf = new CharMatcher$AnyOf(charSequence);
                    return charMatcher$AnyOf;
                }
                n10 = charSequence.charAt(0);
                char c10 = charSequence.charAt(n11);
                return CharMatcher.isEither((char)n10, c10);
            }
            return CharMatcher.is(charSequence.charAt(0));
        }
        return CharMatcher.none();
    }

    public static CharMatcher ascii() {
        return CharMatcher$Ascii.INSTANCE;
    }

    public static CharMatcher breakingWhitespace() {
        return CharMatcher$BreakingWhitespace.INSTANCE;
    }

    public static CharMatcher digit() {
        return CharMatcher$Digit.INSTANCE;
    }

    private String finishCollapseFrom(CharSequence charSequence, int n10, int n11, char c10, StringBuilder stringBuilder, boolean bl2) {
        while (n10 < n11) {
            char c11 = charSequence.charAt(n10);
            boolean bl3 = this.matches(c11);
            if (bl3) {
                if (!bl2) {
                    stringBuilder.append(c10);
                    bl2 = true;
                }
            } else {
                stringBuilder.append(c11);
                bl2 = false;
            }
            ++n10;
        }
        return stringBuilder.toString();
    }

    public static CharMatcher forPredicate(Predicate predicate) {
        boolean bl2 = predicate instanceof CharMatcher;
        if (bl2) {
            predicate = (CharMatcher)predicate;
        } else {
            CharMatcher$ForPredicate charMatcher$ForPredicate = new CharMatcher$ForPredicate(predicate);
            predicate = charMatcher$ForPredicate;
        }
        return predicate;
    }

    public static CharMatcher inRange(char c10, char c11) {
        CharMatcher$InRange charMatcher$InRange = new CharMatcher$InRange(c10, c11);
        return charMatcher$InRange;
    }

    public static CharMatcher invisible() {
        return CharMatcher$Invisible.INSTANCE;
    }

    public static CharMatcher is(char c10) {
        CharMatcher$Is charMatcher$Is = new CharMatcher$Is(c10);
        return charMatcher$Is;
    }

    private static CharMatcher$IsEither isEither(char c10, char c11) {
        CharMatcher$IsEither charMatcher$IsEither = new CharMatcher$IsEither(c10, c11);
        return charMatcher$IsEither;
    }

    public static CharMatcher isNot(char c10) {
        CharMatcher$IsNot charMatcher$IsNot = new CharMatcher$IsNot(c10);
        return charMatcher$IsNot;
    }

    private static boolean isSmall(int n10, int n11) {
        int n12 = 1023;
        n10 = n10 <= n12 && n11 > (n10 = n10 * 4 * 16) ? 1 : 0;
        return n10 != 0;
    }

    public static CharMatcher javaDigit() {
        return CharMatcher$JavaDigit.INSTANCE;
    }

    public static CharMatcher javaIsoControl() {
        return CharMatcher$JavaIsoControl.INSTANCE;
    }

    public static CharMatcher javaLetter() {
        return CharMatcher$JavaLetter.INSTANCE;
    }

    public static CharMatcher javaLetterOrDigit() {
        return CharMatcher$JavaLetterOrDigit.INSTANCE;
    }

    public static CharMatcher javaLowerCase() {
        return CharMatcher$JavaLowerCase.INSTANCE;
    }

    public static CharMatcher javaUpperCase() {
        return CharMatcher$JavaUpperCase.INSTANCE;
    }

    public static CharMatcher none() {
        return CharMatcher$None.INSTANCE;
    }

    public static CharMatcher noneOf(CharSequence charSequence) {
        return CharMatcher.anyOf(charSequence).negate();
    }

    private static CharMatcher precomputedPositive(int n10, BitSet bitSet, String string2) {
        if (n10 != 0) {
            int n11 = 0;
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
                if (n10 != n12) {
                    CharMatcher charMatcher;
                    n11 = bitSet.length();
                    if ((n10 = (int)(CharMatcher.isSmall(n10, n11) ? 1 : 0)) != 0) {
                        charMatcher = SmallCharMatcher.from(bitSet, string2);
                    } else {
                        n11 = 0;
                        charMatcher = new CharMatcher$BitSetMatcher(bitSet, string2, null);
                    }
                    return charMatcher;
                }
                n10 = (char)bitSet.nextSetBit(0);
                int n13 = n10 + 1;
                char c10 = (char)bitSet.nextSetBit(n13);
                return CharMatcher.isEither((char)n10, c10);
            }
            return CharMatcher.is((char)bitSet.nextSetBit(0));
        }
        return CharMatcher.none();
    }

    private static String showCharacter(char c10) {
        int n10;
        char[] cArray;
        int n11 = 6;
        char[] cArray2 = cArray = new char[n11];
        char[] cArray3 = cArray;
        cArray2[0] = 92;
        cArray3[1] = 117;
        cArray2[2] = '\u0000';
        cArray3[3] = '\u0000';
        cArray2[4] = '\u0000';
        cArray3[5] = '\u0000';
        for (int i10 = 0; i10 < (n10 = 4); ++i10) {
            int n12 = 5 - i10;
            int n13 = c10 & 0xF;
            String string2 = "0123456789ABCDEF";
            cArray[n12] = n13 = (int)string2.charAt(n13);
            c10 = (char)(c10 >> n10);
        }
        return String.copyValueOf(cArray);
    }

    public static CharMatcher singleWidth() {
        return CharMatcher$SingleWidth.INSTANCE;
    }

    public static CharMatcher whitespace() {
        return CharMatcher$Whitespace.INSTANCE;
    }

    public CharMatcher and(CharMatcher charMatcher) {
        CharMatcher$And charMatcher$And = new CharMatcher$And(this, charMatcher);
        return charMatcher$And;
    }

    public boolean apply(Character c10) {
        char c11 = c10.charValue();
        return this.matches(c11);
    }

    public String collapseFrom(CharSequence charSequence, char c10) {
        int n10 = charSequence.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            char c11;
            int n11;
            block3: {
                block4: {
                    n11 = charSequence.charAt(i10);
                    c11 = this.matches((char)n11);
                    if (c11 == '\u0000') continue;
                    if (n11 != c10) break block3;
                    n11 = n10 + -1;
                    if (i10 == n11) break block4;
                    n11 = i10 + 1;
                    n11 = charSequence.charAt(n11);
                    if ((n11 = (int)(this.matches((char)n11) ? 1 : 0)) != 0) break block3;
                }
                ++i10;
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder(n10);
            stringBuilder.append(charSequence, 0, i10);
            stringBuilder.append(c10);
            n11 = i10 + 1;
            c11 = c10;
            return this.finishCollapseFrom(charSequence, n11, n10, c10, stringBuilder, true);
        }
        return charSequence.toString();
    }

    public int countIn(CharSequence charSequence) {
        int n10;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            if ((n10 = (int)(this.matches((char)n10) ? 1 : 0)) == 0) continue;
            ++n11;
        }
        return n11;
    }

    public int indexIn(CharSequence charSequence) {
        return this.indexIn(charSequence, 0);
    }

    public int indexIn(CharSequence charSequence, int n10) {
        int n11 = charSequence.length();
        Preconditions.checkPositionIndex(n10, n11);
        while (n10 < n11) {
            char c10 = charSequence.charAt(n10);
            if ((c10 = (char)(this.matches(c10) ? 1 : 0)) != '\u0000') {
                return n10;
            }
            ++n10;
        }
        return -1;
    }

    public int lastIndexIn(CharSequence charSequence) {
        for (int i10 = charSequence.length() + -1; i10 >= 0; i10 += -1) {
            char c10 = charSequence.charAt(i10);
            if ((c10 = (char)(this.matches(c10) ? 1 : 0)) == '\u0000') continue;
            return i10;
        }
        return -1;
    }

    public abstract boolean matches(char var1);

    public boolean matchesAllOf(CharSequence charSequence) {
        int n10 = charSequence.length();
        int n11 = 1;
        n10 -= n11;
        while (n10 >= 0) {
            char c10 = charSequence.charAt(n10);
            if ((c10 = (char)(this.matches(c10) ? 1 : 0)) == '\u0000') {
                return false;
            }
            n10 += -1;
        }
        return n11 != 0;
    }

    public boolean matchesAnyOf(CharSequence charSequence) {
        return this.matchesNoneOf(charSequence) ^ true;
    }

    public boolean matchesNoneOf(CharSequence charSequence) {
        int n10;
        int n11 = this.indexIn(charSequence);
        if (n11 == (n10 = -1)) {
            n11 = 1;
        } else {
            n11 = 0;
            charSequence = null;
        }
        return n11 != 0;
    }

    public CharMatcher negate() {
        CharMatcher$Negated charMatcher$Negated = new CharMatcher$Negated(this);
        return charMatcher$Negated;
    }

    public CharMatcher or(CharMatcher charMatcher) {
        CharMatcher$Or charMatcher$Or = new CharMatcher$Or(this, charMatcher);
        return charMatcher$Or;
    }

    public CharMatcher precomputed() {
        return Platform.precomputeCharMatcher(this);
    }

    public CharMatcher precomputedInternal() {
        Object object = new BitSet();
        this.setBits((BitSet)object);
        int n10 = ((BitSet)object).cardinality();
        int n11 = n10 * 2;
        int n12 = 65536;
        if (n11 <= n12) {
            String string2 = this.toString();
            return CharMatcher.precomputedPositive(n10, (BitSet)object, string2);
        }
        n11 = 0;
        Object object2 = null;
        ((BitSet)object).flip(0, n12);
        n12 -= n10;
        String string3 = ".negate()";
        String string4 = this.toString();
        boolean bl2 = string4.endsWith(string3);
        if (bl2) {
            n10 = string4.length() + -9;
            string3 = string4.substring(0, n10);
        } else {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string4);
            ((StringBuilder)object2).append(string3);
            string3 = ((StringBuilder)object2).toString();
        }
        object = CharMatcher.precomputedPositive(n12, (BitSet)object, string3);
        object2 = new CharMatcher$1(this, (CharMatcher)object, string4);
        return object2;
    }

    public String removeFrom(CharSequence object) {
        int n10;
        int n11 = this.indexIn((CharSequence)(object = object.toString()));
        if (n11 == (n10 = -1)) {
            return object;
        }
        object = ((String)object).toCharArray();
        int n12 = n10 = 1;
        block0: while (true) {
            n11 += n10;
            while (true) {
                Object object2;
                char c10;
                if (n11 == (c10 = ((Object)object).length)) {
                    String string2 = new String((char[])object, 0, n11 -= n12);
                    return string2;
                }
                c10 = (char)object[n11];
                if ((c10 = (char)(this.matches(c10) ? 1 : 0)) != '\u0000') {
                    ++n12;
                    continue block0;
                }
                c10 = (char)(n11 - n12);
                object[c10] = object2 = object[n11];
                ++n11;
            }
            break;
        }
    }

    public String replaceFrom(CharSequence object, char c10) {
        char c11;
        int n10 = this.indexIn((CharSequence)(object = object.toString()));
        if (n10 == (c11 = -1)) {
            return object;
        }
        object = ((String)object).toCharArray();
        object[n10] = c10;
        while (++n10 < (c11 = ((Object)object).length)) {
            c11 = (char)object[n10];
            if ((c11 = (char)(this.matches(c11) ? 1 : 0)) == '\u0000') continue;
            object[n10] = c10;
        }
        String string2 = new String((char[])object);
        return string2;
    }

    public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
        int n10;
        int n11 = charSequence2.length();
        if (n11 == 0) {
            return this.removeFrom(charSequence);
        }
        int n12 = 0;
        int n13 = 1;
        if (n11 == n13) {
            char c10 = charSequence2.charAt(0);
            return this.replaceFrom(charSequence, c10);
        }
        n11 = this.indexIn(charSequence = charSequence.toString());
        if (n11 == (n10 = -1)) {
            return charSequence;
        }
        int n14 = ((String)charSequence).length();
        int n15 = n14 * 3 / 2 + 16;
        StringBuilder stringBuilder = new StringBuilder(n15);
        do {
            stringBuilder.append(charSequence, n12, n11);
            stringBuilder.append(charSequence2);
        } while ((n11 = this.indexIn(charSequence, n12 = n11 + 1)) != n10);
        stringBuilder.append(charSequence, n12, n14);
        return stringBuilder.toString();
    }

    public String retainFrom(CharSequence charSequence) {
        return this.negate().removeFrom(charSequence);
    }

    public void setBits(BitSet bitSet) {
        for (int i10 = (int)-1; i10 >= 0; i10 += -1) {
            char c10 = (char)i10;
            if ((c10 = (char)(this.matches(c10) ? 1 : 0)) == '\u0000') continue;
            bitSet.set(i10);
        }
    }

    public String toString() {
        return super.toString();
    }

    public String trimAndCollapseFrom(CharSequence charSequence, char c10) {
        int n10;
        int n11 = charSequence.length();
        int n12 = n11 + -1;
        char c11 = '\u0000';
        for (n10 = 0; n10 < n11; ++n10) {
            c11 = charSequence.charAt(n10);
            if ((c11 = (char)(this.matches(c11) ? 1 : 0)) == '\u0000') break;
        }
        for (n11 = n12; n11 > n10; n11 += -1) {
            c11 = charSequence.charAt(n11);
            if ((c11 = (char)(this.matches(c11) ? 1 : 0)) == '\u0000') break;
        }
        if (n10 == 0 && n11 == n12) {
            charSequence = this.collapseFrom(charSequence, c10);
        } else {
            int n13 = n11 + 1;
            n11 = n13 - n10;
            StringBuilder stringBuilder = new StringBuilder(n11);
            charSequence = this.finishCollapseFrom(charSequence, n10, n13, c10, stringBuilder, false);
        }
        return charSequence;
    }

    public String trimFrom(CharSequence charSequence) {
        char c10;
        int n10;
        int n11 = charSequence.length();
        for (n10 = 0; n10 < n11; ++n10) {
            c10 = charSequence.charAt(n10);
            if ((c10 = (char)(this.matches(c10) ? 1 : 0)) == '\u0000') break;
        }
        n11 += -1;
        while (n11 > n10) {
            c10 = charSequence.charAt(n11);
            if ((c10 = (char)(this.matches(c10) ? 1 : 0)) == '\u0000') break;
            n11 += -1;
        }
        return charSequence.subSequence(n10, ++n11).toString();
    }

    public String trimLeadingFrom(CharSequence charSequence) {
        int n10 = charSequence.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = charSequence.charAt(i10);
            if ((c10 = (char)(this.matches(c10) ? 1 : 0)) != '\u0000') continue;
            return charSequence.subSequence(i10, n10).toString();
        }
        return "";
    }

    public String trimTrailingFrom(CharSequence charSequence) {
        for (int i10 = charSequence.length() + -1; i10 >= 0; i10 += -1) {
            char c10 = charSequence.charAt(i10);
            if ((c10 = (char)(this.matches(c10) ? 1 : 0)) != '\u0000') continue;
            return charSequence.subSequence(0, ++i10).toString();
        }
        return "";
    }
}

