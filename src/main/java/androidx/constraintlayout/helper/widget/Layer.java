/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View
 */
package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.constraintlayout.widget.R$styleable;

public class Layer
extends ConstraintHelper {
    private static final String TAG = "Layer";
    private boolean mApplyElevationOnAttach;
    private boolean mApplyVisibilityOnAttach;
    public float mComputedCenterX;
    public float mComputedCenterY;
    public float mComputedMaxX;
    public float mComputedMaxY;
    public float mComputedMinX;
    public float mComputedMinY;
    public ConstraintLayout mContainer;
    private float mGroupRotateAngle;
    public boolean mNeedBounds;
    private float mRotationCenterX;
    private float mRotationCenterY;
    private float mScaleX;
    private float mScaleY;
    private float mShiftX;
    private float mShiftY;
    public View[] mViews;

    public Layer(Context context) {
        super(context);
        float f10;
        float f11;
        this.mRotationCenterX = f11 = 0.0f / 0.0f;
        this.mRotationCenterY = f11;
        this.mGroupRotateAngle = f11;
        this.mScaleX = f10 = 1.0f;
        this.mScaleY = f10;
        this.mComputedCenterX = f11;
        this.mComputedCenterY = f11;
        this.mComputedMaxX = f11;
        this.mComputedMaxY = f11;
        this.mComputedMinX = f11;
        this.mComputedMinY = f11;
        this.mNeedBounds = true;
        this.mViews = null;
        this.mShiftX = 0.0f;
        this.mShiftY = 0.0f;
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f10;
        float f11;
        this.mRotationCenterX = f11 = 0.0f / 0.0f;
        this.mRotationCenterY = f11;
        this.mGroupRotateAngle = f11;
        this.mScaleX = f10 = 1.0f;
        this.mScaleY = f10;
        this.mComputedCenterX = f11;
        this.mComputedCenterY = f11;
        this.mComputedMaxX = f11;
        this.mComputedMaxY = f11;
        this.mComputedMinX = f11;
        this.mComputedMinY = f11;
        this.mNeedBounds = true;
        this.mViews = null;
        this.mShiftX = 0.0f;
        this.mShiftY = 0.0f;
    }

    public Layer(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        float f10;
        float f11;
        this.mRotationCenterX = f11 = 0.0f / 0.0f;
        this.mRotationCenterY = f11;
        this.mGroupRotateAngle = f11;
        this.mScaleX = f10 = 1.0f;
        this.mScaleY = f10;
        this.mComputedCenterX = f11;
        this.mComputedCenterY = f11;
        this.mComputedMaxX = f11;
        this.mComputedMaxY = f11;
        this.mComputedMinX = f11;
        this.mComputedMinY = f11;
        this.mNeedBounds = true;
        this.mViews = null;
        this.mShiftX = 0.0f;
        this.mShiftY = 0.0f;
    }

    private void reCacheViews() {
        int n10;
        View[] viewArray = this.mContainer;
        if (viewArray == null) {
            return;
        }
        int n11 = this.mCount;
        if (n11 == 0) {
            return;
        }
        View view = this.mViews;
        if (view == null || (n10 = ((View[])view).length) != n11) {
            viewArray = new View[n11];
            this.mViews = viewArray;
        }
        viewArray = null;
        for (n11 = 0; n11 < (n10 = this.mCount); ++n11) {
            n10 = this.mIds[n11];
            View[] viewArray2 = this.mViews;
            ConstraintLayout constraintLayout = this.mContainer;
            viewArray2[n11] = view = constraintLayout.getViewById(n10);
        }
    }

    private void transform() {
        int n10;
        double d10;
        View[] viewArray = this.mContainer;
        if (viewArray == null) {
            return;
        }
        viewArray = this.mViews;
        if (viewArray == null) {
            this.reCacheViews();
        }
        this.calcCenters();
        float f10 = this.mGroupRotateAngle;
        int n11 = Float.isNaN(f10);
        if (n11 != 0) {
            d10 = 0.0;
        } else {
            f10 = this.mGroupRotateAngle;
            d10 = Math.toRadians(f10);
        }
        double d11 = Math.sin(d10);
        float f11 = (float)d11;
        d10 = Math.cos(d10);
        f10 = (float)d10;
        float f12 = this.mScaleX;
        float f13 = f12 * f10;
        float f14 = this.mScaleY;
        float f15 = -f14 * f11;
        f12 *= f11;
        f14 *= f10;
        f10 = 0.0f;
        viewArray = null;
        for (n11 = 0; n11 < (n10 = this.mCount); ++n11) {
            View view = this.mViews[n11];
            int n12 = view.getLeft();
            int n13 = view.getRight();
            n12 = (n12 + n13) / 2;
            n13 = view.getTop();
            int n14 = view.getBottom();
            n13 = (n13 + n14) / 2;
            float f16 = n12;
            float f17 = this.mComputedCenterX;
            f16 -= f17;
            float f18 = n13;
            f17 = this.mComputedCenterY;
            f18 -= f17;
            f17 = f13 * f16;
            float f19 = f15 * f18;
            f17 = f17 + f19 - f16;
            f19 = this.mShiftX;
            f17 += f19;
            f16 *= f12;
            f19 = f14 * f18;
            f16 = f16 + f19 - f18;
            f18 = this.mShiftY;
            view.setTranslationX(f17);
            view.setTranslationY(f16 += f18);
            f16 = this.mScaleY;
            view.setScaleY(f16);
            f16 = this.mScaleX;
            view.setScaleX(f16);
            f16 = this.mGroupRotateAngle;
            n12 = (int)(Float.isNaN(f16) ? 1 : 0);
            if (n12 != 0) continue;
            f16 = this.mGroupRotateAngle;
            view.setRotation(f16);
        }
    }

    public void calcCenters() {
        float f10;
        View[] viewArray = this.mContainer;
        if (viewArray == null) {
            return;
        }
        boolean bl2 = this.mNeedBounds;
        if (!(bl2 || (bl2 = Float.isNaN(f10 = this.mComputedCenterX)) || (bl2 = Float.isNaN(f10 = this.mComputedCenterY)))) {
            return;
        }
        f10 = this.mRotationCenterX;
        bl2 = Float.isNaN(f10);
        if (!bl2 && !(bl2 = Float.isNaN(f10 = this.mRotationCenterY))) {
            this.mComputedCenterY = f10 = this.mRotationCenterY;
            this.mComputedCenterX = f10 = this.mRotationCenterX;
        } else {
            int n10;
            viewArray = this.mContainer;
            viewArray = this.getViews((ConstraintLayout)viewArray);
            View view = viewArray[0];
            int n11 = view.getLeft();
            View view2 = viewArray[0];
            int n12 = view2.getTop();
            View view3 = viewArray[0];
            int n13 = view3.getRight();
            View view4 = viewArray[0];
            int n14 = view4.getBottom();
            for (int i10 = 0; i10 < (n10 = this.mCount); ++i10) {
                View view5 = viewArray[i10];
                int n15 = view5.getLeft();
                n11 = Math.min(n11, n15);
                n15 = view5.getTop();
                n12 = Math.min(n12, n15);
                n15 = view5.getRight();
                n13 = Math.max(n13, n15);
                n10 = view5.getBottom();
                n14 = Math.max(n14, n10);
            }
            this.mComputedMaxX = f10 = (float)n13;
            this.mComputedMaxY = f10 = (float)n14;
            this.mComputedMinX = f10 = (float)n11;
            this.mComputedMinY = f10 = (float)n12;
            f10 = this.mRotationCenterX;
            bl2 = Float.isNaN(f10);
            if (bl2) {
                n11 = (n11 + n13) / 2;
                this.mComputedCenterX = f10 = (float)n11;
            } else {
                this.mComputedCenterX = f10 = this.mRotationCenterX;
            }
            f10 = this.mRotationCenterY;
            bl2 = Float.isNaN(f10);
            if (bl2) {
                n12 = (n12 + n14) / 2;
                this.mComputedCenterY = f10 = (float)n12;
            } else {
                this.mComputedCenterY = f10 = this.mRotationCenterY;
            }
        }
    }

    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mUseViewMeasure = false;
        if (attributeSet != null) {
            Context context = this.getContext();
            int[] nArray = R$styleable.ConstraintLayout_Layout;
            attributeSet = context.obtainStyledAttributes(attributeSet, nArray);
            int n10 = attributeSet.getIndexCount();
            for (int i10 = 0; i10 < n10; ++i10) {
                int n11 = attributeSet.getIndex(i10);
                int n12 = R$styleable.ConstraintLayout_Layout_android_visibility;
                boolean bl2 = true;
                if (n11 == n12) {
                    this.mApplyVisibilityOnAttach = bl2;
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_android_elevation;
                if (n11 != n12) continue;
                this.mApplyElevationOnAttach = bl2;
            }
            attributeSet.recycle();
        }
    }

    public void onAttachedToWindow() {
        ConstraintLayout constraintLayout;
        int n10 = Build.VERSION.SDK_INT;
        super.onAttachedToWindow();
        this.mContainer = constraintLayout = (ConstraintLayout)this.getParent();
        int n11 = this.mApplyVisibilityOnAttach;
        if (n11 != 0 || (n11 = this.mApplyElevationOnAttach) != 0) {
            int n12;
            n11 = this.getVisibility();
            int n13 = 21;
            float f10 = n10 >= n13 ? this.getElevation() : 0.0f;
            for (int i10 = 0; i10 < (n12 = this.mCount); ++i10) {
                float f11;
                ConstraintLayout constraintLayout2 = this.mContainer;
                n12 = this.mIds[i10];
                View view = constraintLayout2.getViewById(n12);
                if (view == null) continue;
                int n14 = this.mApplyVisibilityOnAttach;
                if (n14 != 0) {
                    view.setVisibility(n11);
                }
                if ((n14 = this.mApplyElevationOnAttach) == 0 || (n14 = (f11 = f10 - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) <= 0 || n10 < n13) continue;
                float f12 = view.getTranslationZ() + f10;
                view.setTranslationZ(f12);
            }
        }
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        this.applyLayoutFeatures();
    }

    public void setPivotX(float f10) {
        this.mRotationCenterX = f10;
        this.transform();
    }

    public void setPivotY(float f10) {
        this.mRotationCenterY = f10;
        this.transform();
    }

    public void setRotation(float f10) {
        this.mGroupRotateAngle = f10;
        this.transform();
    }

    public void setScaleX(float f10) {
        this.mScaleX = f10;
        this.transform();
    }

    public void setScaleY(float f10) {
        this.mScaleY = f10;
        this.transform();
    }

    public void setTranslationX(float f10) {
        this.mShiftX = f10;
        this.transform();
    }

    public void setTranslationY(float f10) {
        this.mShiftY = f10;
        this.transform();
    }

    public void setVisibility(int n10) {
        super.setVisibility(n10);
        this.applyLayoutFeatures();
    }

    public void updatePostLayout(ConstraintLayout object) {
        float f10;
        this.reCacheViews();
        this.mComputedCenterX = f10 = 0.0f / 0.0f;
        this.mComputedCenterY = f10;
        object = ((ConstraintLayout$LayoutParams)this.getLayoutParams()).getConstraintWidget();
        ((ConstraintWidget)object).setWidth(0);
        ((ConstraintWidget)object).setHeight(0);
        this.calcCenters();
        int n10 = (int)this.mComputedMinX;
        int n11 = this.getPaddingLeft();
        n10 -= n11;
        n11 = (int)this.mComputedMinY;
        int n12 = this.getPaddingTop();
        n11 -= n12;
        n12 = (int)this.mComputedMaxX;
        int n13 = this.getPaddingRight();
        n12 += n13;
        n13 = (int)this.mComputedMaxY;
        int n14 = this.getPaddingBottom();
        this.layout(n10, n11, n12, n13 += n14);
        this.transform();
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
        this.mContainer = constraintLayout;
        float f10 = this.getRotation();
        float f11 = 0.0f;
        float f12 = f10 - 0.0f;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            f11 = this.mGroupRotateAngle;
            object = Float.isNaN(f11);
            if (object == false) {
                this.mGroupRotateAngle = f10;
            }
        } else {
            this.mGroupRotateAngle = f10;
        }
    }
}

