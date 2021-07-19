/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 */
package d.v.g0.t;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.common.widget.RotateTextView;
import com.zhiyun.ui.R$id;
import d.v.g0.h;
import d.v.g0.t.i;

public class j
extends i {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private long h;

    static {
        SparseIntArray sparseIntArray;
        j = sparseIntArray = new SparseIntArray();
        int n10 = R$id.tv_pop_content;
        sparseIntArray.put(n10, 5);
    }

    public j(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private j(DataBindingComponent dataBindingComponent, View view, Object[] object) {
        Object object2;
        Object object3 = object2 = object[0];
        object3 = (ConstraintLayout)((Object)object2);
        Object object4 = object2 = object[5];
        object4 = (RotateTextView)object2;
        Object object5 = object2 = object[2];
        object5 = (View)object2;
        Object object6 = object2 = object[3];
        object6 = (View)object2;
        Object object7 = object2 = object[4];
        object7 = (View)object2;
        object = object[1];
        View view2 = object;
        view2 = (View)object;
        super(dataBindingComponent, view, 0, (ConstraintLayout)((Object)object3), (RotateTextView)object4, (View)object5, (View)object6, (View)object7, view2);
        this.h = -1;
        this.a.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        int n10;
        int n11;
        long l11;
        long l12;
        synchronized (this) {
            l12 = this.h;
            this.h = l11 = 0L;
        }
        Integer n12 = this.g;
        long l13 = 3;
        long l14 = l12 & l13;
        long l15 = l14 == l11 ? 0 : (l14 < l11 ? -1 : 1);
        int n13 = 0;
        float f10 = 0.0f;
        if (l15 != false) {
            long l16;
            long l17;
            long l18;
            long l19;
            float f11;
            int n14;
            n11 = ViewDataBinding.safeUnbox(n12);
            int n15 = 1;
            float f12 = Float.MIN_VALUE;
            if (n11 == 0) {
                n14 = n15;
                f11 = f12;
            } else {
                n14 = 0;
                f11 = 0.0f;
            }
            n10 = 2;
            n10 = n11 == n10 ? n15 : 0;
            int n16 = 3;
            n16 = n11 == n16 ? n15 : 0;
            if (n11 != n15) {
                n15 = 0;
                f12 = 0.0f;
            }
            if (l15 != false) {
                l19 = n14 != 0 ? 128L : (long)64;
                l12 |= l19;
            }
            if ((n11 = (int)((l18 = (l19 = l12 & l13) - l11) == 0L ? 0 : (l18 < 0L ? -1 : 1))) != 0) {
                l19 = n10 != 0 ? (long)32 : (long)16;
                l12 |= l19;
            }
            if ((n11 = (int)((l17 = (l19 = l12 & l13) - l11) == 0L ? 0 : (l17 < 0L ? -1 : 1))) != 0) {
                l19 = n16 != 0 ? 512L : 256L;
                l12 |= l19;
            }
            if ((n11 = (int)((l16 = (l19 = l12 & l13) - l11) == 0L ? 0 : (l16 < 0L ? -1 : 1))) != 0) {
                l19 = n15 != 0 ? (long)8 : (long)4;
                l12 |= l19;
            }
            n11 = 8;
            float f13 = 1.1E-44f;
            l15 = n14 != 0 ? (long)0 : (long)n11;
            if (n10 != 0) {
                n14 = 0;
                f11 = 0.0f;
            } else {
                n14 = n11;
                f11 = f13;
            }
            n10 = n16 != 0 ? 0 : n11;
            if (n15 == 0) {
                n13 = n11;
                f10 = f13;
            }
            n11 = n13;
            f13 = f10;
            n13 = n14;
            f10 = f11;
        } else {
            n11 = 0;
            n12 = null;
            float f14 = 0.0f;
            l15 = 0;
            n10 = 0;
        }
        long l20 = (l10 = (l12 &= l13) - l11) == 0L ? 0 : (l10 < 0L ? -1 : 1);
        if (l20 != false) {
            this.c.setVisibility(n13);
            this.d.setVisibility(n10);
            this.e.setVisibility(n11);
            View view = this.f;
            view.setVisibility((int)l15);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.h;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 == false) return false;
            return (boolean)((long)1);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void invalidateAll() {
        synchronized (this) {
            long l10;
            this.h = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = d.v.g0.h.P;
        if (n11 == n10) {
            object = (Integer)object;
            this.z((Integer)object);
            n10 = 1;
        } else {
            n10 = 0;
        }
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void z(Integer n10) {
        this.g = n10;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 1L;
            this.h = l10 |= l11;
        }
        int n11 = d.v.g0.h.P;
        this.notifyPropertyChanged(n11);
        super.requestRebind();
    }
}

