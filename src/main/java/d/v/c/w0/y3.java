/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.l1.e0.d$b;
import d.v.c.w0.x3;

public class y3
extends x3
implements b$a {
    private static final ViewDataBinding$IncludedLayouts n;
    private static final SparseIntArray o;
    private final ConstraintLayout j;
    private final FrameLayout k;
    private final View.OnClickListener l;
    private long m;

    static {
        SparseIntArray sparseIntArray;
        o = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362976, 2);
        sparseIntArray.put(2131363016, 3);
        sparseIntArray.put(2131362293, 4);
        sparseIntArray.put(2131362080, 5);
        sparseIntArray.put(2131362285, 6);
        sparseIntArray.put(2131362071, 7);
        sparseIntArray.put(2131362286, 8);
        sparseIntArray.put(2131362072, 9);
    }

    public y3(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = n;
        SparseIntArray sparseIntArray = o;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 10, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private y3(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[7];
        object2 = (RadioButton)object;
        Object object3 = object = objectArray[9];
        object3 = (RadioButton)object;
        Object object4 = object = objectArray[5];
        object4 = (RadioButton)object;
        Object object5 = object = objectArray[6];
        object5 = (View)object;
        Object object6 = object = objectArray[8];
        object6 = (View)object;
        Object object7 = object = objectArray[4];
        object7 = (View)object;
        Object object8 = object = objectArray[2];
        object8 = (TextView)object;
        Object object9 = object = objectArray[3];
        object9 = (RadioGroup)object;
        object = this;
        Object object10 = dataBindingComponent;
        View view2 = view;
        super(dataBindingComponent, view, 0, (RadioButton)object2, (RadioButton)object3, (RadioButton)object4, (View)object5, (View)object6, (View)object7, (TextView)object8, (RadioGroup)object9);
        this.m = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.j = object;
        object.setTag(null);
        int n10 = 1;
        view2 = (FrameLayout)objectArray[n10];
        this.k = view2;
        view2.setTag(null);
        object10 = view;
        this.setRootTag(view);
        object10 = new b(this, n10);
        this.l = object10;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        d$b d$b = this.i;
        boolean bl2 = d$b != null;
        if (bl2) {
            d$b.a();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        synchronized (this) {
            long l11 = this.m;
            this.m = l10 = 0L;
        }
        long l12 = 2;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            FrameLayout frameLayout = this.k;
            View.OnClickListener onClickListener = this.l;
            frameLayout.setOnClickListener(onClickListener);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.m;
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
            this.m = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (d$b)object;
            this.z((d$b)object);
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
    public void z(d$b d$b) {
        this.i = d$b;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 1L;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }
}

