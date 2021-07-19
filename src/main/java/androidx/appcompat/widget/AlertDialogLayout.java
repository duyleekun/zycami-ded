/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$id;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.LinearLayoutCompat$LayoutParams;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

public class AlertDialogLayout
extends LinearLayoutCompat {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void forceUniformWidth(int n10, int n11) {
        int n12 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)0x40000000);
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object;
            int n13;
            View view = this.getChildAt(i10);
            int n14 = view.getVisibility();
            if (n14 == (n13 = 8)) continue;
            Object object2 = object = view.getLayoutParams();
            object2 = (LinearLayoutCompat$LayoutParams)((Object)object);
            n14 = object2.width;
            n13 = -1;
            if (n14 != n13) continue;
            int n15 = object2.height;
            object2.height = n14 = view.getMeasuredHeight();
            object = this;
            n13 = n12;
            this.measureChildWithMargins(view, n12, 0, n11, 0);
            object2.height = n15;
        }
    }

    private static int resolveMinimumHeight(View view) {
        int n10;
        int n11 = ViewCompat.getMinimumHeight(view);
        if (n11 > 0) {
            return n11;
        }
        n11 = view instanceof ViewGroup;
        if (n11 != 0 && (n11 = (view = (ViewGroup)view).getChildCount()) == (n10 = 1)) {
            return AlertDialogLayout.resolveMinimumHeight(view.getChildAt(0));
        }
        return 0;
    }

    private void setChildFrame(View view, int n10, int n11, int n12, int n13) {
        view.layout(n10, n11, n12 += n10, n13 += n11);
    }

    private boolean tryOnMeasure(int n10, int n11) {
        int n12;
        int n13;
        int n14;
        int n15;
        AlertDialogLayout alertDialogLayout = this;
        int n16 = n10;
        int n17 = n11;
        int n18 = this.getChildCount();
        int n19 = 0;
        View view = null;
        int n20 = 0;
        int n21 = 0;
        View view2 = null;
        int n22 = 0;
        View view3 = null;
        int n23 = 0;
        View view4 = null;
        while (true) {
            n15 = 8;
            if (n23 >= n18) break;
            View view5 = alertDialogLayout.getChildAt(n23);
            n14 = view5.getVisibility();
            if (n14 != n15) {
                n15 = view5.getId();
                if (n15 == (n14 = R$id.topPanel)) {
                    view = view5;
                } else {
                    n14 = R$id.buttonPanel;
                    if (n15 == n14) {
                        view2 = view5;
                    } else {
                        n14 = R$id.contentPanel;
                        if (n15 != n14 && n15 != (n14 = R$id.customPanel)) {
                            return false;
                        }
                        if (view3 != null) {
                            return false;
                        }
                        view3 = view5;
                    }
                }
            }
            ++n23;
        }
        n23 = View.MeasureSpec.getMode((int)n11);
        int n24 = View.MeasureSpec.getSize((int)n11);
        n14 = View.MeasureSpec.getMode((int)n10);
        int n25 = this.getPaddingTop();
        int n26 = this.getPaddingBottom();
        n25 += n26;
        if (view != null) {
            view.measure(n16, 0);
            n26 = view.getMeasuredHeight();
            n25 += n26;
            n19 = view.getMeasuredState();
            n19 = View.combineMeasuredStates((int)0, (int)n19);
        } else {
            n19 = 0;
            view = null;
        }
        if (view2 != null) {
            view2.measure(n16, 0);
            n26 = AlertDialogLayout.resolveMinimumHeight(view2);
            n13 = view2.getMeasuredHeight() - n26;
            n25 += n26;
            n12 = view2.getMeasuredState();
            n19 = View.combineMeasuredStates((int)n19, (int)n12);
        } else {
            n26 = 0;
            n13 = 0;
        }
        if (view3 != null) {
            if (n23 == 0) {
                n12 = 0;
            } else {
                n12 = n24 - n25;
                n12 = View.MeasureSpec.makeMeasureSpec((int)Math.max(0, n12), (int)n23);
            }
            view3.measure(n16, n12);
            n12 = view3.getMeasuredHeight();
            n25 += n12;
            n20 = view3.getMeasuredState();
            n19 = View.combineMeasuredStates((int)n19, (int)n20);
        } else {
            n12 = 0;
        }
        n24 -= n25;
        n20 = 0x40000000;
        if (view2 != null) {
            n25 -= n26;
            if ((n13 = Math.min(n24, n13)) > 0) {
                n24 -= n13;
                n26 += n13;
            }
            n26 = View.MeasureSpec.makeMeasureSpec((int)n26, (int)n20);
            view2.measure(n16, n26);
            n26 = view2.getMeasuredHeight();
            n25 += n26;
            n21 = view2.getMeasuredState();
            n19 = View.combineMeasuredStates((int)n19, (int)n21);
        }
        if (view3 != null && n24 > 0) {
            n25 -= n12;
            n21 = View.MeasureSpec.makeMeasureSpec((int)(n12 += n24), (int)n23);
            view3.measure(n16, n21);
            n21 = view3.getMeasuredHeight();
            n25 += n21;
            n21 = view3.getMeasuredState();
            n19 = View.combineMeasuredStates((int)n19, (int)n21);
        }
        view2 = null;
        n22 = 0;
        view3 = null;
        for (n21 = 0; n21 < n18; ++n21) {
            view4 = alertDialogLayout.getChildAt(n21);
            n24 = view4.getVisibility();
            if (n24 == n15) continue;
            n23 = view4.getMeasuredWidth();
            n22 = Math.max(n22, n23);
        }
        n21 = this.getPaddingLeft();
        n23 = this.getPaddingRight();
        n16 = View.resolveSizeAndState((int)(n22 += (n21 += n23)), (int)n16, (int)n19);
        view = null;
        n19 = View.resolveSizeAndState((int)n25, (int)n17, (int)0);
        alertDialogLayout.setMeasuredDimension(n16, n19);
        if (n14 != n20) {
            alertDialogLayout.forceUniformWidth(n18, n17);
        }
        return true;
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        AlertDialogLayout alertDialogLayout = this;
        int n14 = this.getPaddingLeft();
        int n15 = n12 - n10;
        int n16 = this.getPaddingRight();
        int n17 = n15 - n16;
        n16 = this.getPaddingRight();
        int n18 = (n15 -= n14) - n16;
        n15 = this.getMeasuredHeight();
        int n19 = this.getChildCount();
        n16 = this.getGravity();
        int n20 = n16 & 0x70;
        int n21 = 0x800007;
        int n22 = n16 & n21;
        n16 = 16;
        if (n20 != n16) {
            n16 = 80;
            if (n20 != n16) {
                n15 = this.getPaddingTop();
            } else {
                n16 = this.getPaddingTop() + n13 - n11;
                n15 = n16 - n15;
            }
        } else {
            n16 = this.getPaddingTop();
            n20 = (n13 - n11 - n15) / 2;
            n15 = n16 + n20;
        }
        Drawable drawable2 = this.getDividerDrawable();
        n20 = 0;
        ViewGroup.LayoutParams layoutParams = null;
        int n23 = drawable2 == null ? 0 : (n16 = drawable2.getIntrinsicHeight());
        for (int i10 = 0; i10 < n19; ++i10) {
            int n24;
            Object object;
            int n25;
            int n26;
            block9: {
                block10: {
                    block7: {
                        block8: {
                            drawable2 = alertDialogLayout.getChildAt(i10);
                            if (drawable2 == null || (n20 = drawable2.getVisibility()) == (n21 = 8)) continue;
                            n26 = drawable2.getMeasuredWidth();
                            n25 = drawable2.getMeasuredHeight();
                            object = layoutParams = drawable2.getLayoutParams();
                            object = (LinearLayoutCompat$LayoutParams)layoutParams;
                            n20 = object.gravity;
                            if (n20 < 0) {
                                n20 = n22;
                            }
                            n21 = ViewCompat.getLayoutDirection((View)this);
                            if ((n20 = GravityCompat.getAbsoluteGravity(n20, n21) & 7) == (n21 = 1)) break block7;
                            n21 = 5;
                            if (n20 == n21) break block8;
                            n20 = object.leftMargin + n14;
                            break block9;
                        }
                        n20 = n17 - n26;
                        n21 = object.rightMargin;
                        break block10;
                    }
                    n20 = (n18 - n26) / 2 + n14;
                    n21 = object.leftMargin;
                    n20 += n21;
                    n21 = object.rightMargin;
                }
                n20 -= n21;
            }
            n21 = (int)(alertDialogLayout.hasDividerBeforeChildAt(i10) ? 1 : 0);
            if (n21 != 0) {
                n15 += n23;
            }
            n21 = object.topMargin;
            n21 = n24 = n15 + n21;
            this.setChildFrame((View)drawable2, n20, n24, n26, n25);
            n15 = object.bottomMargin;
            n24 += (n25 += n15);
            n15 = n24;
        }
    }

    public void onMeasure(int n10, int n11) {
        boolean bl2 = this.tryOnMeasure(n10, n11);
        if (!bl2) {
            super.onMeasure(n10, n11);
        }
    }
}

