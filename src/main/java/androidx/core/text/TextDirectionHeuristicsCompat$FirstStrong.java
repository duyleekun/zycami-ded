/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.text;

import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm;

public class TextDirectionHeuristicsCompat$FirstStrong
implements TextDirectionHeuristicsCompat$TextDirectionAlgorithm {
    public static final TextDirectionHeuristicsCompat$FirstStrong INSTANCE;

    static {
        TextDirectionHeuristicsCompat$FirstStrong textDirectionHeuristicsCompat$FirstStrong;
        INSTANCE = textDirectionHeuristicsCompat$FirstStrong = new TextDirectionHeuristicsCompat$FirstStrong();
    }

    private TextDirectionHeuristicsCompat$FirstStrong() {
    }

    public int checkRtl(CharSequence charSequence, int n10, int n11) {
        int n12;
        n11 += n10;
        int n13 = n12 = 2;
        while (n10 < n11 && n13 == n12) {
            n13 = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(charSequence.charAt(n10)));
            ++n10;
        }
        return n13;
    }
}

