/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.util.AttributeSet
 */
package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.utils.widget.MockView;
import androidx.constraintlayout.widget.R$styleable;

public class MotionTelltales
extends MockView {
    private static final String TAG = "MotionTelltales";
    public Matrix mInvertMatrix;
    public MotionLayout mMotionLayout;
    private Paint mPaintTelltales;
    public int mTailColor;
    public float mTailScale;
    public int mVelocityMode;
    public float[] velocity;

    public MotionTelltales(Context context) {
        super(context);
        Object object;
        this.mPaintTelltales = object = new Paint();
        object = new float[2];
        this.velocity = (float[])object;
        super();
        this.mInvertMatrix = object;
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        this.init(context, null);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Object object;
        this.mPaintTelltales = object = new Paint();
        object = new float[2];
        this.velocity = (float[])object;
        super();
        this.mInvertMatrix = object;
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        this.init(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        Object object;
        this.mPaintTelltales = object = new Paint();
        object = new float[2];
        this.velocity = (float[])object;
        super();
        this.mInvertMatrix = object;
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        this.init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        int n10;
        if (attributeSet != null) {
            int[] nArray = R$styleable.MotionTelltales;
            context = context.obtainStyledAttributes(attributeSet, nArray);
            n10 = context.getIndexCount();
            nArray = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                float f10;
                int n11;
                int n12 = context.getIndex(i10);
                if (n12 == (n11 = R$styleable.MotionTelltales_telltales_tailColor)) {
                    n11 = this.mTailColor;
                    this.mTailColor = n12 = context.getColor(n12, n11);
                    continue;
                }
                n11 = R$styleable.MotionTelltales_telltales_velocityMode;
                if (n12 == n11) {
                    n11 = this.mVelocityMode;
                    this.mVelocityMode = n12 = context.getInt(n12, n11);
                    continue;
                }
                n11 = R$styleable.MotionTelltales_telltales_tailScale;
                if (n12 != n11) continue;
                float f11 = this.mTailScale;
                this.mTailScale = f10 = context.getFloat(n12, f11);
            }
            context.recycle();
        }
        context = this.mPaintTelltales;
        n10 = this.mTailColor;
        context.setColor(n10);
        this.mPaintTelltales.setStrokeWidth(5.0f);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onDraw(Canvas canvas) {
        float[] fArray;
        MotionTelltales motionTelltales = this;
        super.onDraw(canvas);
        Object object = this.getMatrix();
        Object object2 = this.mInvertMatrix;
        object.invert(object2);
        object = this.mMotionLayout;
        if (object == null) {
            object = this.getParent();
            boolean bl2 = object instanceof MotionLayout;
            if (bl2) {
                object = (MotionLayout)object;
                this.mMotionLayout = object;
            }
            return;
        }
        int n10 = this.getWidth();
        int n11 = this.getHeight();
        int n12 = 5;
        float[] fArray2 = fArray = new float[n12];
        float[] fArray3 = fArray;
        fArray2[0] = 0.1f;
        fArray3[1] = 0.25f;
        fArray2[2] = 0.5f;
        fArray3[3] = 0.75f;
        fArray3[4] = 0.9f;
        for (int i10 = 0; i10 < n12; ++i10) {
            float f10 = fArray[i10];
            for (int i11 = 0; i11 < n12; ++i11) {
                float f11 = fArray[i11];
                object = motionTelltales.mMotionLayout;
                float[] fArray4 = motionTelltales.velocity;
                int n13 = motionTelltales.mVelocityMode;
                object2 = this;
                float f12 = f11;
                object.getViewVelocity(this, f11, f10, fArray4, n13);
                object = motionTelltales.mInvertMatrix;
                object2 = motionTelltales.velocity;
                object.mapVectors((float[])object2);
                float f13 = (float)n10 * f11;
                float f14 = n11;
                float f15 = f14 * f10;
                object = motionTelltales.velocity;
                reference var20_21 = object[0];
                f12 = motionTelltales.mTailScale;
                float f16 = f13 - (var20_21 *= f12);
                int n14 = 1;
                var20_21 = object[n14] * f12;
                float f17 = f15 - var20_21;
                object2 = motionTelltales.mInvertMatrix;
                object2.mapVectors((float[])object);
                object = motionTelltales.mPaintTelltales;
                canvas.drawLine(f13, f15, f16, f17, (Paint)object);
            }
        }
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        super.onLayout(bl2, n10, n11, n12, n13);
        this.postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        charSequence = charSequence.toString();
        this.mText = charSequence;
        this.requestLayout();
    }
}

