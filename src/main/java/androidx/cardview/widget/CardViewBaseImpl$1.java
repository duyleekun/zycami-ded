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
import androidx.cardview.widget.CardViewBaseImpl;
import androidx.cardview.widget.RoundRectDrawableWithShadow$RoundRectHelper;

public class CardViewBaseImpl$1
implements RoundRectDrawableWithShadow$RoundRectHelper {
    public final /* synthetic */ CardViewBaseImpl this$0;

    public CardViewBaseImpl$1(CardViewBaseImpl cardViewBaseImpl) {
        this.this$0 = cardViewBaseImpl;
    }

    public void drawRoundRect(Canvas canvas, RectF rectF, float f10, Paint paint) {
        float f11;
        float f12;
        float f13;
        RectF rectF2;
        RectF rectF3 = rectF;
        float f14 = 2.0f * f10;
        float f15 = rectF.width() - f14;
        float f16 = 1.0f;
        float f17 = f15 - f16;
        f15 = rectF.height() - f14;
        float f18 = f15 - f16;
        Object object = f10 == f16 ? 0 : (f10 > f16 ? 1 : -1);
        if (object >= 0) {
            object = 0x3F000000;
            float f19 = f10 + 0.5f;
            rectF2 = this.this$0.mCornerRect;
            f15 = -f19;
            rectF2.set(f15, f15, f19, f19);
            int n10 = canvas.save();
            f14 = rectF.left + f19;
            f15 = rectF.top + f19;
            canvas.translate(f14, f15);
            RectF rectF4 = this.this$0.mCornerRect;
            f13 = 180.0f;
            f12 = 90.0f;
            boolean bl2 = true;
            rectF2 = canvas;
            canvas.drawArc(rectF4, f13, f12, bl2, paint);
            canvas.translate(f17, 0.0f);
            float f20 = 90.0f;
            canvas.rotate(f20);
            rectF4 = this.this$0.mCornerRect;
            rectF2 = canvas;
            canvas.drawArc(rectF4, f13, f12, bl2, paint);
            canvas.translate(f18, 0.0f);
            canvas.rotate(f20);
            rectF4 = this.this$0.mCornerRect;
            rectF2 = canvas;
            canvas.drawArc(rectF4, f13, f12, bl2, paint);
            canvas.translate(f17, 0.0f);
            canvas.rotate(f20);
            rectF4 = this.this$0.mCornerRect;
            rectF2 = canvas;
            canvas.drawArc(rectF4, f13, f12, bl2, paint);
            canvas.restoreToCount(n10);
            f15 = rectF.left + f19 - f16;
            f13 = rectF.top;
            f12 = rectF.right - f19 + f16;
            f11 = f13 + f19;
            canvas.drawRect(f15, f13, f12, f11, paint);
            f15 = rectF.left + f19 - f16;
            f11 = rectF.bottom;
            f13 = f11 - f19;
            f14 = rectF.right - f19;
            f12 = f14 + f16;
            canvas.drawRect(f15, f13, f12, f11, paint);
        }
        f15 = rectF3.left;
        f13 = rectF3.top + f10;
        f12 = rectF3.right;
        f11 = rectF3.bottom - f10;
        rectF2 = canvas;
        canvas.drawRect(f15, f13, f12, f11, paint);
    }
}

