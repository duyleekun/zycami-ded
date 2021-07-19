/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding.adapters;

import androidx.cardview.widget.CardView;

public class CardViewBindingAdapter {
    public static void setContentPadding(CardView cardView, int n10) {
        cardView.setContentPadding(n10, n10, n10, n10);
    }

    public static void setContentPaddingBottom(CardView cardView, int n10) {
        int n11 = cardView.getContentPaddingLeft();
        int n12 = cardView.getContentPaddingTop();
        int n13 = cardView.getContentPaddingRight();
        cardView.setContentPadding(n11, n12, n13, n10);
    }

    public static void setContentPaddingLeft(CardView cardView, int n10) {
        int n11 = cardView.getContentPaddingTop();
        int n12 = cardView.getContentPaddingRight();
        int n13 = cardView.getContentPaddingBottom();
        cardView.setContentPadding(n10, n11, n12, n13);
    }

    public static void setContentPaddingRight(CardView cardView, int n10) {
        int n11 = cardView.getContentPaddingLeft();
        int n12 = cardView.getContentPaddingTop();
        int n13 = cardView.getContentPaddingBottom();
        cardView.setContentPadding(n11, n12, n10, n13);
    }

    public static void setContentPaddingTop(CardView cardView, int n10) {
        int n11 = cardView.getContentPaddingLeft();
        int n12 = cardView.getContentPaddingRight();
        int n13 = cardView.getContentPaddingBottom();
        cardView.setContentPadding(n11, n10, n12, n13);
    }
}

