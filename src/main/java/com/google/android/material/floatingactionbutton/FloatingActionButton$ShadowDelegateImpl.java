/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 */
package com.google.android.material.floatingactionbutton;

import android.graphics.drawable.Drawable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shadow.ShadowViewDelegate;

public class FloatingActionButton$ShadowDelegateImpl
implements ShadowViewDelegate {
    public final /* synthetic */ FloatingActionButton this$0;

    public FloatingActionButton$ShadowDelegateImpl(FloatingActionButton floatingActionButton) {
        this.this$0 = floatingActionButton;
    }

    public float getRadius() {
        return (float)this.this$0.getSizeDimension() / 2.0f;
    }

    public boolean isCompatPaddingEnabled() {
        return this.this$0.compatPadding;
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        FloatingActionButton.access$101(this.this$0, drawable2);
    }

    public void setShadowPadding(int n10, int n11, int n12, int n13) {
        this.this$0.shadowPadding.set(n10, n11, n12, n13);
        FloatingActionButton floatingActionButton = this.this$0;
        int n14 = FloatingActionButton.access$000(floatingActionButton);
        n10 += n14;
        n14 = FloatingActionButton.access$000(this.this$0);
        n11 += n14;
        n14 = FloatingActionButton.access$000(this.this$0);
        n12 += n14;
        n14 = FloatingActionButton.access$000(this.this$0);
        floatingActionButton.setPadding(n10, n11, n12, n13 += n14);
    }
}

