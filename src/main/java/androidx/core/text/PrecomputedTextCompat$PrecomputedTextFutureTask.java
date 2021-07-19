/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.text;

import androidx.core.text.PrecomputedTextCompat$Params;
import androidx.core.text.PrecomputedTextCompat$PrecomputedTextFutureTask$PrecomputedTextCallback;
import java.util.concurrent.FutureTask;

public class PrecomputedTextCompat$PrecomputedTextFutureTask
extends FutureTask {
    public PrecomputedTextCompat$PrecomputedTextFutureTask(PrecomputedTextCompat$Params precomputedTextCompat$Params, CharSequence charSequence) {
        PrecomputedTextCompat$PrecomputedTextFutureTask$PrecomputedTextCallback precomputedTextCompat$PrecomputedTextFutureTask$PrecomputedTextCallback = new PrecomputedTextCompat$PrecomputedTextFutureTask$PrecomputedTextCallback(precomputedTextCompat$Params, charSequence);
        super(precomputedTextCompat$PrecomputedTextFutureTask$PrecomputedTextCallback);
    }
}

