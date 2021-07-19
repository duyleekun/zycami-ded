/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.text;

import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm;
import java.nio.CharBuffer;

public abstract class TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl
implements TextDirectionHeuristicCompat {
    private final TextDirectionHeuristicsCompat$TextDirectionAlgorithm mAlgorithm;

    public TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl(TextDirectionHeuristicsCompat$TextDirectionAlgorithm textDirectionHeuristicsCompat$TextDirectionAlgorithm) {
        this.mAlgorithm = textDirectionHeuristicsCompat$TextDirectionAlgorithm;
    }

    private boolean doCheck(CharSequence charSequence, int n10, int n11) {
        TextDirectionHeuristicsCompat$TextDirectionAlgorithm textDirectionHeuristicsCompat$TextDirectionAlgorithm = this.mAlgorithm;
        int n12 = textDirectionHeuristicsCompat$TextDirectionAlgorithm.checkRtl(charSequence, n10, n11);
        n10 = 1;
        if (n12 != 0) {
            if (n12 != n10) {
                return this.defaultIsRtl();
            }
            return false;
        }
        return n10 != 0;
    }

    public abstract boolean defaultIsRtl();

    public boolean isRtl(CharSequence object, int n10, int n11) {
        int n12;
        if (object != null && n10 >= 0 && n11 >= 0 && (n12 = object.length() - n11) >= n10) {
            TextDirectionHeuristicsCompat$TextDirectionAlgorithm textDirectionHeuristicsCompat$TextDirectionAlgorithm = this.mAlgorithm;
            if (textDirectionHeuristicsCompat$TextDirectionAlgorithm == null) {
                return this.defaultIsRtl();
            }
            return this.doCheck((CharSequence)object, n10, n11);
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public boolean isRtl(char[] object, int n10, int n11) {
        object = CharBuffer.wrap(object);
        return this.isRtl((CharSequence)object, n10, n11);
    }
}

