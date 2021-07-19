/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Outline
 *  android.view.View
 *  android.view.ViewOutlineProvider
 */
package androidx.constraintlayout.utils.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.utils.widget.ImageFilterView;

public class ImageFilterView$1
extends ViewOutlineProvider {
    public final /* synthetic */ ImageFilterView this$0;

    public ImageFilterView$1(ImageFilterView imageFilterView) {
        this.this$0 = imageFilterView;
    }

    public void getOutline(View view, Outline outline) {
        int n10 = this.this$0.getWidth();
        int n11 = this.this$0.getHeight();
        float f10 = Math.min(n10, n11);
        float f11 = ImageFilterView.access$000(this.this$0);
        float f12 = f10 * f11 / 2.0f;
        outline.setRoundRect(0, 0, n10, n11, f12);
    }
}

