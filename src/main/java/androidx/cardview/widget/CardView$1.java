/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.view.View
 */
package androidx.cardview.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.cardview.widget.CardViewDelegate;

public class CardView$1
implements CardViewDelegate {
    private Drawable mCardBackground;
    public final /* synthetic */ CardView this$0;

    public CardView$1(CardView cardView) {
        this.this$0 = cardView;
    }

    public Drawable getCardBackground() {
        return this.mCardBackground;
    }

    public View getCardView() {
        return this.this$0;
    }

    public boolean getPreventCornerOverlap() {
        return this.this$0.getPreventCornerOverlap();
    }

    public boolean getUseCompatPadding() {
        return this.this$0.getUseCompatPadding();
    }

    public void setCardBackground(Drawable drawable2) {
        this.mCardBackground = drawable2;
        this.this$0.setBackgroundDrawable(drawable2);
    }

    public void setMinWidthHeightInternal(int n10, int n11) {
        CardView cardView = this.this$0;
        int n12 = cardView.mUserSetMinWidth;
        if (n10 > n12) {
            CardView.access$101(cardView, n10);
        }
        CardView cardView2 = this.this$0;
        int n13 = cardView2.mUserSetMinHeight;
        if (n11 > n13) {
            CardView.access$201(cardView2, n11);
        }
    }

    public void setShadowPadding(int n10, int n11, int n12, int n13) {
        this.this$0.mShadowBounds.set(n10, n11, n12, n13);
        CardView cardView = this.this$0;
        Rect rect = cardView.mContentPadding;
        int n14 = rect.left;
        n10 += n14;
        n14 = rect.top;
        n11 += n14;
        n14 = rect.right;
        int n15 = rect.bottom;
        CardView.access$001(cardView, n10, n11, n12 += n14, n13 += n15);
    }
}

