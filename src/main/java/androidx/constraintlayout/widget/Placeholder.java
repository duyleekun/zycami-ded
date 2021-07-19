/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Rect
 *  android.graphics.Typeface
 *  android.util.AttributeSet
 *  android.view.View
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.constraintlayout.widget.R$styleable;

public class Placeholder
extends View {
    private View mContent = null;
    private int mContentId = -1;
    private int mEmptyVisibility = 4;

    public Placeholder(Context context) {
        super(context);
        this.init(null);
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.init(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10);
        this.init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        int n10 = this.mEmptyVisibility;
        super.setVisibility(n10);
        this.mContentId = n10 = -1;
        if (attributeSet != null) {
            Context context = this.getContext();
            int[] nArray = R$styleable.ConstraintLayout_placeholder;
            attributeSet = context.obtainStyledAttributes(attributeSet, nArray);
            n10 = attributeSet.getIndexCount();
            nArray = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                int n11;
                int n12 = attributeSet.getIndex(i10);
                if (n12 == (n11 = R$styleable.ConstraintLayout_placeholder_content)) {
                    n11 = this.mContentId;
                    this.mContentId = n12 = attributeSet.getResourceId(n12, n11);
                    continue;
                }
                n11 = R$styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility;
                if (n12 != n11) continue;
                n11 = this.mEmptyVisibility;
                this.mEmptyVisibility = n12 = attributeSet.getInt(n12, n11);
            }
            attributeSet.recycle();
        }
    }

    public View getContent() {
        return this.mContent;
    }

    public int getEmptyVisibility() {
        return this.mEmptyVisibility;
    }

    public void onDraw(Canvas canvas) {
        int n10 = this.isInEditMode();
        if (n10 != 0) {
            n10 = 223;
            canvas.drawRGB(n10, n10, n10);
            Paint paint = new Paint();
            int n11 = 210;
            paint.setARGB(255, n11, n11, n11);
            Paint.Align align = Paint.Align.CENTER;
            paint.setTextAlign(align);
            align = Typeface.DEFAULT;
            n11 = 0;
            align = Typeface.create((Typeface)align, (int)0);
            paint.setTypeface((Typeface)align);
            align = new Rect();
            canvas.getClipBounds((Rect)align);
            float f10 = align.height();
            paint.setTextSize(f10);
            int n12 = align.height();
            int n13 = align.width();
            Object object = Paint.Align.LEFT;
            paint.setTextAlign(object);
            object = "?";
            paint.getTextBounds((String)object, 0, 1, (Rect)align);
            float f11 = n13;
            n13 = 0x40000000;
            float f12 = 2.0f;
            f11 /= f12;
            float f13 = (float)align.width() / f12;
            f11 -= f13;
            f13 = align.left;
            f11 -= f13;
            f10 = (float)n12 / f12;
            int n14 = align.height();
            f13 = (float)n14 / f12;
            f10 += f13;
            int n15 = align.bottom;
            float f14 = n15;
            canvas.drawText((String)object, f11, f10 -= f14, paint);
        }
    }

    public void setContentId(int n10) {
        View view;
        int n11 = this.mContentId;
        if (n11 == n10) {
            return;
        }
        View view2 = this.mContent;
        if (view2 != null) {
            view2.setVisibility(0);
            ((ConstraintLayout$LayoutParams)this.mContent.getLayoutParams()).isInPlaceholder = false;
            n11 = 0;
            view2 = null;
            this.mContent = null;
        }
        this.mContentId = n10;
        n11 = -1;
        if (n10 != n11 && (view = (view2 = (View)this.getParent()).findViewById(n10)) != null) {
            n11 = 8;
            view.setVisibility(n11);
        }
    }

    public void setEmptyVisibility(int n10) {
        this.mEmptyVisibility = n10;
    }

    public void updatePostMeasure(ConstraintLayout object) {
        object = this.mContent;
        if (object == null) {
            return;
        }
        object = (ConstraintLayout$LayoutParams)this.getLayoutParams();
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams)this.mContent.getLayoutParams();
        constraintLayout$LayoutParams.widget.setVisibility(0);
        Object object2 = ((ConstraintLayout$LayoutParams)object).widget.getHorizontalDimensionBehaviour();
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.FIXED;
        if (object2 != constraintWidget$DimensionBehaviour) {
            object2 = ((ConstraintLayout$LayoutParams)object).widget;
            ConstraintWidget constraintWidget = constraintLayout$LayoutParams.widget;
            int n10 = constraintWidget.getWidth();
            ((ConstraintWidget)object2).setWidth(n10);
        }
        if ((object2 = ((ConstraintLayout$LayoutParams)object).widget.getVerticalDimensionBehaviour()) != constraintWidget$DimensionBehaviour) {
            object = ((ConstraintLayout$LayoutParams)object).widget;
            object2 = constraintLayout$LayoutParams.widget;
            int n11 = ((ConstraintWidget)object2).getHeight();
            ((ConstraintWidget)object).setHeight(n11);
        }
        constraintLayout$LayoutParams.widget.setVisibility(8);
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        int n10 = this.mContentId;
        int n11 = -1;
        if (n10 == n11 && (n10 = (int)(this.isInEditMode() ? 1 : 0)) == 0) {
            n10 = this.mEmptyVisibility;
            this.setVisibility(n10);
        }
        n10 = this.mContentId;
        constraintLayout = constraintLayout.findViewById(n10);
        this.mContent = constraintLayout;
        if (constraintLayout != null) {
            ((ConstraintLayout$LayoutParams)constraintLayout.getLayoutParams()).isInPlaceholder = true;
            constraintLayout = this.mContent;
            n10 = 0;
            constraintLayout.setVisibility(0);
            this.setVisibility(0);
        }
    }
}

