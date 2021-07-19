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

public class ImageFilterButton$2
extends ViewOutlineProvider {
    public final /* synthetic */ ImageFilterButton this$0;

    public ImageFilterButton$2(ImageFilterButton imageFilterButton) {
        this.this$0 = imageFilterButton;
    }

    public void getOutline(View view, Outline outline) {
        int n10 = this.this$0.getWidth();
        int n11 = this.this$0.getHeight();
        float f10 = ImageFilterButton.access$100(this.this$0);
        outline.setRoundRect(0, 0, n10, n11, f10);
    }
}

