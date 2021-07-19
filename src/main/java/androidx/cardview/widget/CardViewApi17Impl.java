/*
 * Decompiled with CFR 0.151.
 */
package androidx.cardview.widget;

import androidx.cardview.widget.CardViewApi17Impl$1;
import androidx.cardview.widget.CardViewBaseImpl;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

public class CardViewApi17Impl
extends CardViewBaseImpl {
    public void initStatic() {
        CardViewApi17Impl$1 cardViewApi17Impl$1 = new CardViewApi17Impl$1(this);
        RoundRectDrawableWithShadow.sRoundRectHelper = cardViewApi17Impl$1;
    }
}

