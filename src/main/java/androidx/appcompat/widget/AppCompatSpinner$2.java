/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package androidx.appcompat.widget;

import android.os.Build;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatSpinner;

public class AppCompatSpinner$2
implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ AppCompatSpinner this$0;

    public AppCompatSpinner$2(AppCompatSpinner appCompatSpinner) {
        this.this$0 = appCompatSpinner;
    }

    public void onGlobalLayout() {
        Object object = this.this$0.getInternalPopup();
        boolean bl2 = object.isShowing();
        if (!bl2) {
            object = this.this$0;
            ((AppCompatSpinner)object).showPopup();
        }
        if ((object = this.this$0.getViewTreeObserver()) != null) {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 16;
            if (n10 >= n11) {
                object.removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
            } else {
                object.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
            }
        }
    }
}

