/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.text;

import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm;

public class TextDirectionHeuristicsCompat$AnyStrong
implements TextDirectionHeuristicsCompat$TextDirectionAlgorithm {
    public static final TextDirectionHeuristicsCompat$AnyStrong INSTANCE_RTL;
    private final boolean mLookForRtl;

    static {
        TextDirectionHeuristicsCompat$AnyStrong textDirectionHeuristicsCompat$AnyStrong;
        INSTANCE_RTL = textDirectionHeuristicsCompat$AnyStrong = new TextDirectionHeuristicsCompat$AnyStrong(true);
    }

    private TextDirectionHeuristicsCompat$AnyStrong(boolean bl2) {
        this.mLookForRtl = bl2;
    }

    public int checkRtl(CharSequence charSequence, int n10, int n11) {
        n11 += n10;
        int n12 = 0;
        while (n10 < n11) {
            block5: {
                int n13;
                block6: {
                    block4: {
                        int n14 = TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(charSequence.charAt(n10)));
                        n13 = 1;
                        if (n14 == 0) break block4;
                        if (n14 != n13) break block5;
                        n12 = this.mLookForRtl;
                        if (n12 == 0) {
                            return n13;
                        }
                        break block6;
                    }
                    n12 = this.mLookForRtl;
                    if (n12 != 0) {
                        return 0;
                    }
                }
                n12 = n13;
            }
            ++n10;
        }
        if (n12 != 0) {
            return (int)(this.mLookForRtl ? 1 : 0);
        }
        return 2;
    }
}

