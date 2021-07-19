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
import androidx.constraintlayout.utils.widget.ImageFilterButton;

public class ImageFilterButton$1
extends ViewOutlineProvider {
    public final /* synthetic */ ImageFilterButton this$0;

    public ImageFilterButton$1(ImageFilterButton imageFilterButton) {
        this.this$0 = imageFilterButton;
    }

    public void getOutline(View view, Outline outline) {
        int n10 = this.this$0.getWidth();
        int n11 = this.this$0.getHeight();
        float f10 = Math.min(n10, n11);
        float f11 = ImageFilterButton.access$000(this.this$0);
        float f12 = f10 * f11 / 2.0f;
        outline.setRoundRect(0, 0, n10, n11, f12);
    }
}

