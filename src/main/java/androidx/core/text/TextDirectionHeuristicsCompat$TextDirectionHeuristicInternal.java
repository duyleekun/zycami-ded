/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.text;

import androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm;
import androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl;

public class TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal
extends TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl {
    private final boolean mDefaultIsRtl;

    public TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat$TextDirectionAlgorithm textDirectionHeuristicsCompat$TextDirectionAlgorithm, boolean bl2) {
        super(textDirectionHeuristicsCompat$TextDirectionAlgorithm);
        this.mDefaultIsRtl = bl2;
    }

    public boolean defaultIsRtl() {
        return this.mDefaultIsRtl;
    }
}

