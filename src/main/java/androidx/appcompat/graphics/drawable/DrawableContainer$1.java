/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.graphics.drawable;

import androidx.appcompat.graphics.drawable.DrawableContainer;

public class DrawableContainer$1
implements Runnable {
    public final /* synthetic */ DrawableContainer this$0;

    public DrawableContainer$1(DrawableContainer drawableContainer) {
        this.this$0 = drawableContainer;
    }

    public void run() {
        this.this$0.animate(true);
        this.this$0.invalidateSelf();
    }
}

