/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.RectF
 */
package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.cardview.widget.CardViewApi17Impl;
import androidx.cardview.widget.RoundRectDrawableWithShadow$RoundRectHelper;

public class CardViewApi17Impl$1
implements RoundRectDrawableWithShadow$RoundRectHelper {
    public final /* synthetic */ CardViewApi17Impl this$0;

    public CardViewApi17Impl$1(CardViewApi17Impl cardViewApi17Impl) {
        this.this$0 = cardViewApi17Impl;
    }

    public void drawRoundRect(Canvas canvas, RectF rectF, float f10, Paint paint) {
        canvas.drawRoundRect(rectF, f10, f10, paint);
    }
}

