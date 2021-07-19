/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.SparseArray
 *  android.view.View$MeasureSpec
 */
package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.constraintlayout.widget.ConstraintSet$Constraint;
import androidx.constraintlayout.widget.R$styleable;

public class Flow
extends androidx.constraintlayout.widget.VirtualLayout {
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int HORIZONTAL = 0;
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    private static final String TAG = "Flow";
    public static final int VERTICAL = 1;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE;
    private androidx.constraintlayout.solver.widgets.Flow mFlow;

    public Flow(Context context) {
        super(context);
    }

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Flow(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
    }

    public void init(AttributeSet object) {
        androidx.constraintlayout.solver.widgets.Flow flow;
        int n10 = Build.VERSION.SDK_INT;
        super.init((AttributeSet)object);
        this.mFlow = flow = new androidx.constraintlayout.solver.widgets.Flow();
        if (object != null) {
            flow = this.getContext();
            int[] nArray = R$styleable.ConstraintLayout_Layout;
            object = flow.obtainStyledAttributes((AttributeSet)object, nArray);
            int n11 = object.getIndexCount();
            nArray = null;
            for (int i10 = 0; i10 < n11; ++i10) {
                float f10;
                androidx.constraintlayout.solver.widgets.Flow flow2;
                int n12;
                int n13 = object.getIndex(i10);
                if (n13 == (n12 = R$styleable.ConstraintLayout_Layout_android_orientation)) {
                    flow2 = this.mFlow;
                    n13 = object.getInt(n13, 0);
                    flow2.setOrientation(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_android_padding;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    n13 = object.getDimensionPixelSize(n13, 0);
                    flow2.setPadding(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_android_paddingStart;
                int n14 = 17;
                float f11 = 2.4E-44f;
                if (n13 == n12) {
                    if (n10 < n14) continue;
                    flow2 = this.mFlow;
                    n13 = object.getDimensionPixelSize(n13, 0);
                    flow2.setPaddingStart(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_android_paddingEnd;
                if (n13 == n12) {
                    if (n10 < n14) continue;
                    flow2 = this.mFlow;
                    n13 = object.getDimensionPixelSize(n13, 0);
                    flow2.setPaddingEnd(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_android_paddingLeft;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    n13 = object.getDimensionPixelSize(n13, 0);
                    flow2.setPaddingLeft(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_android_paddingTop;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    n13 = object.getDimensionPixelSize(n13, 0);
                    flow2.setPaddingTop(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_android_paddingRight;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    n13 = object.getDimensionPixelSize(n13, 0);
                    flow2.setPaddingRight(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_android_paddingBottom;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    n13 = object.getDimensionPixelSize(n13, 0);
                    flow2.setPaddingBottom(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_flow_wrapMode;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    n13 = object.getInt(n13, 0);
                    flow2.setWrapMode(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_flow_horizontalStyle;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    n13 = object.getInt(n13, 0);
                    flow2.setHorizontalStyle(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_flow_verticalStyle;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    n13 = object.getInt(n13, 0);
                    flow2.setVerticalStyle(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    n13 = object.getInt(n13, 0);
                    flow2.setFirstHorizontalStyle(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    n13 = object.getInt(n13, 0);
                    flow2.setLastHorizontalStyle(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_flow_firstVerticalStyle;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    n13 = object.getInt(n13, 0);
                    flow2.setFirstVerticalStyle(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_flow_lastVerticalStyle;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    n13 = object.getInt(n13, 0);
                    flow2.setLastVerticalStyle(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_flow_horizontalBias;
                n14 = 0x3F000000;
                f11 = 0.5f;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    f10 = object.getFloat(n13, f11);
                    flow2.setHorizontalBias(f10);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_flow_firstHorizontalBias;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    f10 = object.getFloat(n13, f11);
                    flow2.setFirstHorizontalBias(f10);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_flow_lastHorizontalBias;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    f10 = object.getFloat(n13, f11);
                    flow2.setLastHorizontalBias(f10);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_flow_firstVerticalBias;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    f10 = object.getFloat(n13, f11);
                    flow2.setFirstVerticalBias(f10);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_flow_lastVerticalBias;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    f10 = object.getFloat(n13, f11);
                    flow2.setLastVerticalBias(f10);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_flow_verticalBias;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    f10 = object.getFloat(n13, f11);
                    flow2.setVerticalBias(f10);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_flow_horizontalAlign;
                n14 = 2;
                f11 = 2.8E-45f;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    n13 = object.getInt(n13, n14);
                    flow2.setHorizontalAlign(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_flow_verticalAlign;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    n13 = object.getInt(n13, n14);
                    flow2.setVerticalAlign(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_flow_horizontalGap;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    n13 = object.getDimensionPixelSize(n13, 0);
                    flow2.setHorizontalGap(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_flow_verticalGap;
                if (n13 == n12) {
                    flow2 = this.mFlow;
                    n13 = object.getDimensionPixelSize(n13, 0);
                    flow2.setVerticalGap(n13);
                    continue;
                }
                n12 = R$styleable.ConstraintLayout_Layout_flow_maxElementsWrap;
                if (n13 != n12) continue;
                flow2 = this.mFlow;
                n14 = -1;
                f11 = 0.0f / 0.0f;
                n13 = object.getInt(n13, n14);
                flow2.setMaxElementsWrap(n13);
            }
            object.recycle();
        }
        object = this.mFlow;
        this.mHelperWidget = object;
        this.validateParams();
    }

    public void loadParameters(ConstraintSet$Constraint constraintSet$Constraint, HelperWidget helperWidget, ConstraintLayout$LayoutParams constraintLayout$LayoutParams, SparseArray sparseArray) {
        super.loadParameters(constraintSet$Constraint, helperWidget, constraintLayout$LayoutParams, sparseArray);
        int n10 = helperWidget instanceof androidx.constraintlayout.solver.widgets.Flow;
        if (n10 != 0) {
            helperWidget = (androidx.constraintlayout.solver.widgets.Flow)helperWidget;
            n10 = constraintLayout$LayoutParams.orientation;
            int n11 = -1;
            if (n10 != n11) {
                ((androidx.constraintlayout.solver.widgets.Flow)helperWidget).setOrientation(n10);
            }
        }
    }

    public void onMeasure(int n10, int n11) {
        androidx.constraintlayout.solver.widgets.Flow flow = this.mFlow;
        this.onMeasure(flow, n10, n11);
    }

    public void onMeasure(VirtualLayout virtualLayout, int n10, int n11) {
        int n12 = View.MeasureSpec.getMode((int)n10);
        n10 = View.MeasureSpec.getSize((int)n10);
        int n13 = View.MeasureSpec.getMode((int)n11);
        n11 = View.MeasureSpec.getSize((int)n11);
        if (virtualLayout != null) {
            virtualLayout.measure(n12, n10, n13, n11);
            n10 = virtualLayout.getMeasuredWidth();
            int n14 = virtualLayout.getMeasuredHeight();
            this.setMeasuredDimension(n10, n14);
        } else {
            boolean bl2 = false;
            virtualLayout = null;
            this.setMeasuredDimension(0, 0);
        }
    }

    public void resolveRtl(ConstraintWidget constraintWidget, boolean bl2) {
        this.mFlow.applyRtl(bl2);
    }

    public void setFirstHorizontalBias(float f10) {
        this.mFlow.setFirstHorizontalBias(f10);
        this.requestLayout();
    }

    public void setFirstHorizontalStyle(int n10) {
        this.mFlow.setFirstHorizontalStyle(n10);
        this.requestLayout();
    }

    public void setFirstVerticalBias(float f10) {
        this.mFlow.setFirstVerticalBias(f10);
        this.requestLayout();
    }

    public void setFirstVerticalStyle(int n10) {
        this.mFlow.setFirstVerticalStyle(n10);
        this.requestLayout();
    }

    public void setHorizontalAlign(int n10) {
        this.mFlow.setHorizontalAlign(n10);
        this.requestLayout();
    }

    public void setHorizontalBias(float f10) {
        this.mFlow.setHorizontalBias(f10);
        this.requestLayout();
    }

    public void setHorizontalGap(int n10) {
        this.mFlow.setHorizontalGap(n10);
        this.requestLayout();
    }

    public void setHorizontalStyle(int n10) {
        this.mFlow.setHorizontalStyle(n10);
        this.requestLayout();
    }

    public void setMaxElementsWrap(int n10) {
        this.mFlow.setMaxElementsWrap(n10);
        this.requestLayout();
    }

    public void setOrientation(int n10) {
        this.mFlow.setOrientation(n10);
        this.requestLayout();
    }

    public void setPadding(int n10) {
        this.mFlow.setPadding(n10);
        this.requestLayout();
    }

    public void setPaddingBottom(int n10) {
        this.mFlow.setPaddingBottom(n10);
        this.requestLayout();
    }

    public void setPaddingLeft(int n10) {
        this.mFlow.setPaddingLeft(n10);
        this.requestLayout();
    }

    public void setPaddingRight(int n10) {
        this.mFlow.setPaddingRight(n10);
        this.requestLayout();
    }

    public void setPaddingTop(int n10) {
        this.mFlow.setPaddingTop(n10);
        this.requestLayout();
    }

    public void setVerticalAlign(int n10) {
        this.mFlow.setVerticalAlign(n10);
        this.requestLayout();
    }

    public void setVerticalBias(float f10) {
        this.mFlow.setVerticalBias(f10);
        this.requestLayout();
    }

    public void setVerticalGap(int n10) {
        this.mFlow.setVerticalGap(n10);
        this.requestLayout();
    }

    public void setVerticalStyle(int n10) {
        this.mFlow.setVerticalStyle(n10);
        this.requestLayout();
    }

    public void setWrapMode(int n10) {
        this.mFlow.setWrapMode(n10);
        this.requestLayout();
    }
}

