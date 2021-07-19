/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import d.v.c.f1.a.b$a;
import d.v.c.s0.d7.v$b;
import d.v.c.w0.d9;

public class e9
extends d9
implements b$a {
    private static final ViewDataBinding$IncludedLayouts h;
    private static final SparseIntArray i;
    private final ConstraintLayout e;
    private final View.OnClickListener f;
    private long g;

    static {
        SparseIntArray sparseIntArray;
        i = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362823, 2);
        sparseIntArray.put(2131363690, 3);
    }

    public e9(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = h;
        SparseIntArray sparseIntArray = i;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private e9(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[2];
        object4 = (LinearLayout)object3;
        int n10 = 1;
        Object object5 = object2 = objectArray[n10];
        object5 = (TextView)object2;
        Object object6 = object2 = objectArray[3];
        object6 = (View)object2;
        object2 = this;
        super(object, view, 0, (LinearLayout)object4, (TextView)object5, (View)object6);
        this.g = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.e = object;
        object.setTag(null);
        this.b.setTag(null);
        this.setRootTag(view);
        super(this, n10);
        this.f = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        v$b v$b = this.d;
        boolean bl2 = v$b != null;
        if (bl2) {
            v$b.b();
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
            long l11 = this.g;
            this.g = l10 = 0L;
        }
        long l12 = 2;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            TextView textView = this.b;
            View.OnClickListener onClickListener = this.f;
            textView.setOnClickListener(onClickListener);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.g;
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
            this.g = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (v$b)object;
            this.z((v$b)object);
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
    public void z(v$b v$b) {
        this.d = v$b;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 1L;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }
}

