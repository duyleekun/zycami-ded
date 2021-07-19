/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.PopupWindow
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.widget.PopupWindowCompat;

public class AppCompatPopupWindow
extends PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR;
    private boolean mOverlapAnchor;

    static {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        n10 = n10 < n11 ? 1 : 0;
        COMPAT_OVERLAP_ANCHOR = n10;
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.init(context, attributeSet, n10, 0);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
        this.init(context, attributeSet, n10, n11);
    }

    private void init(Context object, AttributeSet attributeSet, int n10, int n11) {
        boolean bl2;
        int[] nArray = R$styleable.PopupWindow;
        if ((n10 = (int)(((TintTypedArray)(object = TintTypedArray.obtainStyledAttributes((Context)object, attributeSet, nArray, n10, n11))).hasValue((bl2 = R$styleable.PopupWindow_overlapAnchor) ? 1 : 0) ? 1 : 0)) != 0) {
            n10 = 0;
            bl2 = ((TintTypedArray)object).getBoolean(bl2 ? 1 : 0, false);
            this.setSupportOverlapAnchor(bl2);
        }
        bl2 = R$styleable.PopupWindow_android_popupBackground;
        attributeSet = ((TintTypedArray)object).getDrawable(bl2 ? 1 : 0);
        this.setBackgroundDrawable((Drawable)attributeSet);
        ((TintTypedArray)object).recycle();
    }

    private void setSupportOverlapAnchor(boolean bl2) {
        boolean bl3 = COMPAT_OVERLAP_ANCHOR;
        if (bl3) {
            this.mOverlapAnchor = bl2;
        } else {
            PopupWindowCompat.setOverlapAnchor(this, bl2);
        }
    }

    public void showAsDropDown(View view, int n10, int n11) {
        int n12 = COMPAT_OVERLAP_ANCHOR;
        if (n12 != 0 && (n12 = this.mOverlapAnchor) != 0) {
            n12 = view.getHeight();
            n11 -= n12;
        }
        super.showAsDropDown(view, n10, n11);
    }

    public void showAsDropDown(View view, int n10, int n11, int n12) {
        int n13 = COMPAT_OVERLAP_ANCHOR;
        if (n13 != 0 && (n13 = this.mOverlapAnchor) != 0) {
            n13 = view.getHeight();
            n11 -= n13;
        }
        super.showAsDropDown(view, n10, n11, n12);
    }

    public void update(View view, int n10, int n11, int n12, int n13) {
        int n14 = COMPAT_OVERLAP_ANCHOR;
        if (n14 != 0 && (n14 = this.mOverlapAnchor) != 0) {
            n14 = view.getHeight();
            n11 -= n14;
        }
        super.update(view, n10, n11, n12, n13);
    }
}

