/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.text;

import androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl;
import androidx.core.text.TextUtilsCompat;
import java.util.Locale;

public class TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale
extends TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl {
    public static final TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale INSTANCE;

    static {
        TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale textDirectionHeuristicsCompat$TextDirectionHeuristicLocale;
        INSTANCE = textDirectionHeuristicsCompat$TextDirectionHeuristicLocale = new TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale();
    }

    public TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale() {
        super(null);
    }

    public boolean defaultIsRtl() {
        int n10;
        Locale locale = Locale.getDefault();
        int n11 = TextUtilsCompat.getLayoutDirectionFromLocale(locale);
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }
}

