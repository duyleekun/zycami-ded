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

public class ImageFilterView$2
extends ViewOutlineProvider {
    public final /* synthetic */ ImageFilterView this$0;

    public ImageFilterView$2(ImageFilterView imageFilterView) {
        this.this$0 = imageFilterView;
    }

    public void getOutline(View view, Outline outline) {
        int n10 = this.this$0.getWidth();
        int n11 = this.this$0.getHeight();
        float f10 = ImageFilterView.access$100(this.this$0);
        outline.setRoundRect(0, 0, n10, n11, f10);
    }
}

