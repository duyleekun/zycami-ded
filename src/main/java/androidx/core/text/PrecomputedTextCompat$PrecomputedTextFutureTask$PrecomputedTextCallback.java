/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.text;

import androidx.core.text.PrecomputedTextCompat;
import androidx.core.text.PrecomputedTextCompat$Params;
import java.util.concurrent.Callable;

public class PrecomputedTextCompat$PrecomputedTextFutureTask$PrecomputedTextCallback
implements Callable {
    private PrecomputedTextCompat$Params mParams;
    private CharSequence mText;

    public PrecomputedTextCompat$PrecomputedTextFutureTask$PrecomputedTextCallback(PrecomputedTextCompat$Params precomputedTextCompat$Params, CharSequence charSequence) {
        this.mParams = precomputedTextCompat$Params;
        this.mText = charSequence;
    }

    public PrecomputedTextCompat call() {
        CharSequence charSequence = this.mText;
        PrecomputedTextCompat$Params precomputedTextCompat$Params = this.mParams;
        return PrecomputedTextCompat.create(charSequence, precomputedTextCompat$Params);
    }
}

