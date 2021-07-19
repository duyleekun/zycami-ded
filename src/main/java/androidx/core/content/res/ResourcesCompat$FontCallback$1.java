/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 */
package androidx.core.content.res;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat$FontCallback;

public class ResourcesCompat$FontCallback$1
implements Runnable {
    public final /* synthetic */ ResourcesCompat$FontCallback this$0;
    public final /* synthetic */ Typeface val$typeface;

    public ResourcesCompat$FontCallback$1(ResourcesCompat$FontCallback resourcesCompat$FontCallback, Typeface typeface) {
        this.this$0 = resourcesCompat$FontCallback;
        this.val$typeface = typeface;
    }

    public void run() {
        ResourcesCompat$FontCallback resourcesCompat$FontCallback = this.this$0;
        Typeface typeface = this.val$typeface;
        resourcesCompat$FontCallback.onFontRetrieved(typeface);
    }
}

