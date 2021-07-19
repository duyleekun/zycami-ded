/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 */
package androidx.core.provider;

import android.graphics.Typeface;

public final class FontRequestWorker$TypefaceResult {
    public final int mResult;
    public final Typeface mTypeface;

    public FontRequestWorker$TypefaceResult(int n10) {
        this.mTypeface = null;
        this.mResult = n10;
    }

    public FontRequestWorker$TypefaceResult(Typeface typeface) {
        this.mTypeface = typeface;
        this.mResult = 0;
    }

    public boolean isSuccess() {
        int n10 = this.mResult;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }
}

