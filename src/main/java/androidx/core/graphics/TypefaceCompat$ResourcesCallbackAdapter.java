/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 */
package androidx.core.graphics;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import androidx.core.provider.FontsContractCompat$FontRequestCallback;

public class TypefaceCompat$ResourcesCallbackAdapter
extends FontsContractCompat$FontRequestCallback {
    private ResourcesCompat$FontCallback mFontCallback;

    public TypefaceCompat$ResourcesCallbackAdapter(ResourcesCompat$FontCallback resourcesCompat$FontCallback) {
        this.mFontCallback = resourcesCompat$FontCallback;
    }

    public void onTypefaceRequestFailed(int n10) {
        ResourcesCompat$FontCallback resourcesCompat$FontCallback = this.mFontCallback;
        if (resourcesCompat$FontCallback != null) {
            resourcesCompat$FontCallback.onFontRetrievalFailed(n10);
        }
    }

    public void onTypefaceRetrieved(Typeface typeface) {
        ResourcesCompat$FontCallback resourcesCompat$FontCallback = this.mFontCallback;
        if (resourcesCompat$FontCallback != null) {
            resourcesCompat$FontCallback.onFontRetrieved(typeface);
        }
    }
}

