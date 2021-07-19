/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.SpannableStringBuilder
 */
package androidx.core.text;

import android.text.SpannableStringBuilder;
import androidx.core.text.BidiFormatter$Builder;
import androidx.core.text.BidiFormatter$DirectionalityEstimator;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.text.TextUtilsCompat;
import java.util.Locale;

public final class BidiFormatter {
    private static final int DEFAULT_FLAGS = 2;
    public static final BidiFormatter DEFAULT_LTR_INSTANCE;
    public static final BidiFormatter DEFAULT_RTL_INSTANCE;
    public static final TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC;
    private static final int DIR_LTR = 255;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = '\u202a';
    private static final char LRM = '\u200e';
    private static final String LRM_STRING;
    private static final char PDF = '\u202c';
    private static final char RLE = '\u202b';
    private static final char RLM = '\u200f';
    private static final String RLM_STRING;
    private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    static {
        BidiFormatter bidiFormatter;
        TextDirectionHeuristicCompat textDirectionHeuristicCompat;
        DEFAULT_TEXT_DIRECTION_HEURISTIC = textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        LRM_STRING = Character.toString('\u200e');
        RLM_STRING = Character.toString('\u200f');
        int n10 = 2;
        DEFAULT_LTR_INSTANCE = bidiFormatter = new BidiFormatter(false, n10, textDirectionHeuristicCompat);
        DEFAULT_RTL_INSTANCE = bidiFormatter = new BidiFormatter(true, n10, textDirectionHeuristicCompat);
    }

    public BidiFormatter(boolean bl2, int n10, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mIsRtlContext = bl2;
        this.mFlags = n10;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
    }

    private static int getEntryDir(CharSequence charSequence) {
        BidiFormatter$DirectionalityEstimator bidiFormatter$DirectionalityEstimator = new BidiFormatter$DirectionalityEstimator(charSequence, false);
        return bidiFormatter$DirectionalityEstimator.getEntryDir();
    }

    private static int getExitDir(CharSequence charSequence) {
        BidiFormatter$DirectionalityEstimator bidiFormatter$DirectionalityEstimator = new BidiFormatter$DirectionalityEstimator(charSequence, false);
        return bidiFormatter$DirectionalityEstimator.getExitDir();
    }

    public static BidiFormatter getInstance() {
        BidiFormatter$Builder bidiFormatter$Builder = new BidiFormatter$Builder();
        return bidiFormatter$Builder.build();
    }

    public static BidiFormatter getInstance(Locale locale) {
        BidiFormatter$Builder bidiFormatter$Builder = new BidiFormatter$Builder(locale);
        return bidiFormatter$Builder.build();
    }

    public static BidiFormatter getInstance(boolean bl2) {
        BidiFormatter$Builder bidiFormatter$Builder = new BidiFormatter$Builder(bl2);
        return bidiFormatter$Builder.build();
    }

    public static boolean isRtlLocale(Locale locale) {
        int n10;
        int n11 = TextUtilsCompat.getLayoutDirectionFromLocale(locale);
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    private String markAfter(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        int n10;
        int n11 = charSequence.length();
        int n12 = 0;
        int n13 = textDirectionHeuristicCompat.isRtl(charSequence, 0, n11);
        n11 = (int)(this.mIsRtlContext ? 1 : 0);
        if (n11 == 0 && (n13 != 0 || (n11 = BidiFormatter.getExitDir(charSequence)) == (n12 = 1))) {
            return LRM_STRING;
        }
        n11 = (int)(this.mIsRtlContext ? 1 : 0);
        if (n11 != 0 && (n13 == 0 || (n10 = BidiFormatter.getExitDir(charSequence)) == (n13 = -1))) {
            return RLM_STRING;
        }
        return EMPTY_STRING;
    }

    private String markBefore(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        int n10;
        int n11 = charSequence.length();
        int n12 = 0;
        int n13 = textDirectionHeuristicCompat.isRtl(charSequence, 0, n11);
        n11 = (int)(this.mIsRtlContext ? 1 : 0);
        if (n11 == 0 && (n13 != 0 || (n11 = BidiFormatter.getEntryDir(charSequence)) == (n12 = 1))) {
            return LRM_STRING;
        }
        n11 = (int)(this.mIsRtlContext ? 1 : 0);
        if (n11 != 0 && (n13 == 0 || (n10 = BidiFormatter.getEntryDir(charSequence)) == (n13 = -1))) {
            return RLM_STRING;
        }
        return EMPTY_STRING;
    }

    public boolean getStereoReset() {
        int n10 = this.mFlags & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isRtl(CharSequence charSequence) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = this.mDefaultTextDirectionHeuristicCompat;
        int n10 = charSequence.length();
        return textDirectionHeuristicCompat.isRtl(charSequence, 0, n10);
    }

    public boolean isRtl(String string2) {
        return this.isRtl((CharSequence)string2);
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = this.mDefaultTextDirectionHeuristicCompat;
        return this.unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return this.unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    /*
     * WARNING - void declaration
     */
    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean bl2) {
        boolean bl3;
        if (charSequence == null) {
            return null;
        }
        int c10 = charSequence.length();
        boolean bl4 = textDirectionHeuristicCompat.isRtl(charSequence, 0, c10);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean bl5 = this.getStereoReset();
        if (bl5 && bl2) {
            Object object = bl4 ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR;
            object = this.markBefore(charSequence, (TextDirectionHeuristicCompat)object);
            spannableStringBuilder.append((CharSequence)object);
        }
        if (bl4 != (bl3 = this.mIsRtlContext)) {
            void var4_9;
            if (bl4) {
                int n10 = 8235;
            } else {
                int n11 = 8234;
            }
            spannableStringBuilder.append((char)var4_9);
            spannableStringBuilder.append(charSequence);
            char c11 = '\u202c';
            spannableStringBuilder.append(c11);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (bl2) {
            textDirectionHeuristicCompat = bl4 ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR;
            charSequence = this.markAfter(charSequence, textDirectionHeuristicCompat);
            spannableStringBuilder.append(charSequence);
        }
        return spannableStringBuilder;
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean bl2) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = this.mDefaultTextDirectionHeuristicCompat;
        return this.unicodeWrap(charSequence, textDirectionHeuristicCompat, bl2);
    }

    public String unicodeWrap(String string2) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = this.mDefaultTextDirectionHeuristicCompat;
        return this.unicodeWrap(string2, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String string2, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return this.unicodeWrap(string2, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String string2, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean bl2) {
        if (string2 == null) {
            return null;
        }
        return this.unicodeWrap((CharSequence)string2, textDirectionHeuristicCompat, bl2).toString();
    }

    public String unicodeWrap(String string2, boolean bl2) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = this.mDefaultTextDirectionHeuristicCompat;
        return this.unicodeWrap(string2, textDirectionHeuristicCompat, bl2);
    }
}

