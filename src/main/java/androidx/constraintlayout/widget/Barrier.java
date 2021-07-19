/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.SparseArray
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.constraintlayout.widget.ConstraintSet$Constraint;
import androidx.constraintlayout.widget.ConstraintSet$Layout;
import androidx.constraintlayout.widget.R$styleable;

public class Barrier
extends ConstraintHelper {
    public static final int BOTTOM = 3;
    public static final int END = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int START = 5;
    public static final int TOP = 2;
    private androidx.constraintlayout.solver.widgets.Barrier mBarrier;
    private int mIndicatedType;
    private int mResolvedType;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        super.setVisibility(8);
    }

    private void updateType(ConstraintWidget constraintWidget, int n10, boolean bl2) {
        this.mResolvedType = n10;
        n10 = Build.VERSION.SDK_INT;
        int n11 = 1;
        int n12 = 6;
        int n13 = 5;
        int n14 = 17;
        if (n10 < n14) {
            n10 = this.mIndicatedType;
            if (n10 == n13) {
                this.mResolvedType = 0;
            } else if (n10 == n12) {
                this.mResolvedType = n11;
            }
        } else if (bl2) {
            n10 = this.mIndicatedType;
            if (n10 == n13) {
                this.mResolvedType = n11;
            } else if (n10 == n12) {
                this.mResolvedType = 0;
            }
        } else {
            n10 = this.mIndicatedType;
            if (n10 == n13) {
                this.mResolvedType = 0;
            } else if (n10 == n12) {
                this.mResolvedType = n11;
            }
        }
        n10 = constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier;
        if (n10 != 0) {
            constraintWidget = (androidx.constraintlayout.solver.widgets.Barrier)constraintWidget;
            n10 = this.mResolvedType;
            ((androidx.constraintlayout.solver.widgets.Barrier)constraintWidget).setBarrierType(n10);
        }
    }

    public boolean allowsGoneWidget() {
        return this.mBarrier.allowsGoneWidget();
    }

    public int getMargin() {
        return this.mBarrier.getMargin();
    }

    public int getType() {
        return this.mIndicatedType;
    }

    public void init(AttributeSet object) {
        androidx.constraintlayout.solver.widgets.Barrier barrier;
        super.init((AttributeSet)object);
        this.mBarrier = barrier = new androidx.constraintlayout.solver.widgets.Barrier();
        if (object != null) {
            barrier = this.getContext();
            int[] nArray = R$styleable.ConstraintLayout_Layout;
            object = barrier.obtainStyledAttributes((AttributeSet)object, nArray);
            int n10 = object.getIndexCount();
            nArray = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                androidx.constraintlayout.solver.widgets.Barrier barrier2;
                int n11;
                int n12 = object.getIndex(i10);
                if (n12 == (n11 = R$styleable.ConstraintLayout_Layout_barrierDirection)) {
                    n12 = object.getInt(n12, 0);
                    this.setType(n12);
                    continue;
                }
                n11 = R$styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets;
                if (n12 == n11) {
                    barrier2 = this.mBarrier;
                    boolean bl2 = true;
                    n12 = (int)(object.getBoolean(n12, bl2) ? 1 : 0);
                    barrier2.setAllowsGoneWidget(n12 != 0);
                    continue;
                }
                n11 = R$styleable.ConstraintLayout_Layout_barrierMargin;
                if (n12 != n11) continue;
                n12 = object.getDimensionPixelSize(n12, 0);
                barrier2 = this.mBarrier;
                barrier2.setMargin(n12);
            }
            object.recycle();
        }
        object = this.mBarrier;
        this.mHelperWidget = object;
        this.validateParams();
    }

    public void loadParameters(ConstraintSet$Constraint object, HelperWidget object2, ConstraintLayout$LayoutParams object3, SparseArray object4) {
        super.loadParameters((ConstraintSet$Constraint)object, (HelperWidget)object2, (ConstraintLayout$LayoutParams)((Object)object3), (SparseArray)object4);
        boolean bl2 = object2 instanceof androidx.constraintlayout.solver.widgets.Barrier;
        if (bl2) {
            object3 = object2;
            object3 = (androidx.constraintlayout.solver.widgets.Barrier)object2;
            boolean bl3 = ((ConstraintWidgetContainer)((ConstraintWidget)object2).getParent()).isRtl();
            object4 = ((ConstraintSet$Constraint)object).layout;
            int n10 = object4.mBarrierDirection;
            this.updateType((ConstraintWidget)object3, n10, bl3);
            object2 = ((ConstraintSet$Constraint)object).layout;
            bl3 = ((ConstraintSet$Layout)object2).mBarrierAllowsGoneWidgets;
            ((androidx.constraintlayout.solver.widgets.Barrier)object3).setAllowsGoneWidget(bl3);
            object = ((ConstraintSet$Constraint)object).layout;
            int n11 = ((ConstraintSet$Layout)object).mBarrierMargin;
            ((androidx.constraintlayout.solver.widgets.Barrier)object3).setMargin(n11);
        }
    }

    public void resolveRtl(ConstraintWidget constraintWidget, boolean bl2) {
        int n10 = this.mIndicatedType;
        this.updateType(constraintWidget, n10, bl2);
    }

    public void setAllowsGoneWidget(boolean bl2) {
        this.mBarrier.setAllowsGoneWidget(bl2);
    }

    public void setDpMargin(int n10) {
        float f10 = this.getResources().getDisplayMetrics().density;
        n10 = (int)((float)n10 * f10 + 0.5f);
        this.mBarrier.setMargin(n10);
    }

    public void setMargin(int n10) {
        this.mBarrier.setMargin(n10);
    }

    public void setType(int n10) {
        this.mIndicatedType = n10;
    }
}

