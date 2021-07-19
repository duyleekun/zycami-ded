/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckedTextView
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.q0.f.a;
import d.v.c.w0.b5;

public class c5
extends b5
implements b$a {
    private static final ViewDataBinding$IncludedLayouts h;
    private static final SparseIntArray i;
    private final FrameLayout d;
    private final View.OnClickListener e;
    private final View.OnClickListener f;
    private long g;

    public c5(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = h;
        SparseIntArray sparseIntArray = i;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private c5(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        int n10 = 2;
        Object object4 = object3 = objectArray[n10];
        object4 = (CheckedTextView)object3;
        int n11 = 1;
        Object object5 = object2 = objectArray[n11];
        object5 = (TextView)object2;
        object2 = this;
        super(object, view, 0, (CheckedTextView)object4, (TextView)object5);
        this.g = -1;
        this.a.setTag(null);
        object = (FrameLayout)objectArray[0];
        this.d = object;
        object.setTag(null);
        this.b.setTag(null);
        this.setRootTag(view);
        object = new b(this, n11);
        this.e = object;
        object = new b(this, n10);
        this.f = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                a a10 = this.c;
                if (a10 != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    a10.b(view);
                }
            }
        } else {
            a a11 = this.c;
            if (a11 != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                a11.a(view);
            }
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
            CheckedTextView checkedTextView = this.a;
            View.OnClickListener onClickListener = this.f;
            checkedTextView.setOnClickListener(onClickListener);
            checkedTextView = this.b;
            onClickListener = this.e;
            checkedTextView.setOnClickListener(onClickListener);
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
            object = (a)object;
            this.z((a)object);
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
    public void z(a a10) {
        this.c = a10;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 1L;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }
}

