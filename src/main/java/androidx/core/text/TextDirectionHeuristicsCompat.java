/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.text;

import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat$AnyStrong;
import androidx.core.text.TextDirectionHeuristicsCompat$FirstStrong;
import androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm;
import androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal;
import androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale;

public final class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat ANYRTL_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
    public static final TextDirectionHeuristicCompat LOCALE;
    public static final TextDirectionHeuristicCompat LTR;
    public static final TextDirectionHeuristicCompat RTL;
    private static final int STATE_FALSE = 1;
    private static final int STATE_TRUE = 0;
    private static final int STATE_UNKNOWN = 2;

    static {
        TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal textDirectionHeuristicsCompat$TextDirectionHeuristicInternal = new TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(null, false);
        LTR = textDirectionHeuristicsCompat$TextDirectionHeuristicInternal;
        boolean bl2 = true;
        textDirectionHeuristicsCompat$TextDirectionHeuristicInternal = new TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(null, bl2);
        RTL = textDirectionHeuristicsCompat$TextDirectionHeuristicInternal;
        TextDirectionHeuristicsCompat$TextDirectionAlgorithm textDirectionHeuristicsCompat$TextDirectionAlgorithm = TextDirectionHeuristicsCompat$FirstStrong.INSTANCE;
        textDirectionHeuristicsCompat$TextDirectionHeuristicInternal = new TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(textDirectionHeuristicsCompat$TextDirectionAlgorithm, false);
        FIRSTSTRONG_LTR = textDirectionHeuristicsCompat$TextDirectionHeuristicInternal;
        textDirectionHeuristicsCompat$TextDirectionHeuristicInternal = new TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(textDirectionHeuristicsCompat$TextDirectionAlgorithm, bl2);
        FIRSTSTRONG_RTL = textDirectionHeuristicsCompat$TextDirectionHeuristicInternal;
        textDirectionHeuristicsCompat$TextDirectionAlgorithm = TextDirectionHeuristicsCompat$AnyStrong.INSTANCE_RTL;
        textDirectionHeuristicsCompat$TextDirectionHeuristicInternal = new TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(textDirectionHeuristicsCompat$TextDirectionAlgorithm, false);
        ANYRTL_LTR = textDirectionHeuristicsCompat$TextDirectionHeuristicInternal;
        LOCALE = TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale.INSTANCE;
    }

    private TextDirectionHeuristicsCompat() {
    }

    public static int isRtlText(int n10) {
        int n11 = 1;
        if (n10 != 0) {
            if (n10 != n11 && n10 != (n11 = 2)) {
                return n11;
            }
            return 0;
        }
        return n11;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int isRtlTextOrFormat(int n10) {
        int n11;
        int n12 = 1;
        if (n10 == 0) return n12;
        if (n10 == n12 || n10 == (n11 = 2)) return 0;
        switch (n10) {
            default: {
                return n11;
            }
            case 16: 
            case 17: {
                return 0;
            }
            case 14: 
            case 15: 
        }
        return n12;
    }
}

