/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.os.Build$VERSION
 */
package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.os.Build;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import java.lang.ref.WeakReference;

public class AppCompatTextHelper$1
extends ResourcesCompat$FontCallback {
    public final /* synthetic */ AppCompatTextHelper this$0;
    public final /* synthetic */ int val$fontWeight;
    public final /* synthetic */ int val$style;
    public final /* synthetic */ WeakReference val$textViewWeak;

    public AppCompatTextHelper$1(AppCompatTextHelper appCompatTextHelper, int n10, int n11, WeakReference weakReference) {
        this.this$0 = appCompatTextHelper;
        this.val$fontWeight = n10;
        this.val$style = n11;
        this.val$textViewWeak = weakReference;
    }

    public void onFontRetrievalFailed(int n10) {
    }

    public void onFontRetrieved(Typeface typeface) {
        WeakReference weakReference;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11 && (n10 = this.val$fontWeight) != (n11 = -1)) {
            n11 = this.val$style & 2;
            if (n11) {
                n11 = 1;
            } else {
                n11 = 0;
                weakReference = null;
            }
            typeface = Typeface.create((Typeface)typeface, (int)n10, n11 != 0);
        }
        AppCompatTextHelper appCompatTextHelper = this.this$0;
        weakReference = this.val$textViewWeak;
        appCompatTextHelper.onAsyncTypefaceReceived(weakReference, typeface);
    }
}

