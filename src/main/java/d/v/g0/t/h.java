/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 */
package d.v.g0.t;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import d.v.g0.i$a;
import d.v.g0.o;
import d.v.g0.t.g;
import d.v.g0.u.a.b$a;

public class h
extends g
implements b$a {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private final ConstraintLayout f;
    private final View.OnClickListener g;
    private long h;

    public h(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 2, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private h(DataBindingComponent object, View view, Object[] objectArray) {
        int n10 = 1;
        TextView textView = (TextView)objectArray[n10];
        super(object, view, 0, textView);
        this.h = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.f = object;
        object.setTag(null);
        this.a.setTag(null);
        this.setRootTag(view);
        super(this, n10);
        this.g = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(i$a i$a) {
        this.d = i$a;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 4;
            this.h = l10 |= l11;
        }
        int n10 = d.v.g0.h.z;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }

    public void D(Boolean bl2) {
        this.e = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(o o10) {
        this.b = o10;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 1L;
            this.h = l10 |= l11;
        }
        int n10 = d.v.g0.h.y0;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(Integer n10) {
        this.c = n10;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 2;
            this.h = l10 |= l11;
        }
        int n11 = d.v.g0.h.X0;
        this.notifyPropertyChanged(n11);
        super.requestRebind();
    }

    public final void a(int n10, View object) {
        Integer n11 = this.c;
        object = this.d;
        boolean bl2 = object != null;
        if (bl2) {
            n10 = n11;
            ((i$a)object).a(n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        TextView textView;
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        synchronized (this) {
            l14 = this.h;
            this.h = l13 = 0L;
        }
        int n10 = 0;
        String string2 = null;
        o o10 = this.b;
        long l15 = (long)17 & l14;
        long l16 = l15 == l13 ? 0 : (l15 < l13 ? -1 : 1);
        if (l16 != false && o10 != null) {
            n10 = o10.a();
            string2 = o10.b();
        }
        if ((l12 = (l11 = (l14 &= (l10 = (long)16)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            textView = this.a;
            View.OnClickListener onClickListener = this.g;
            textView.setOnClickListener(onClickListener);
        }
        if (l16 != false) {
            TextViewBindingAdapter.setText(this.a, string2);
            textView = this.a;
            textView.setTextColor(n10);
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
            this.h = l10 = (long)16;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = d.v.g0.h.y0;
        if (n11 == n10) {
            object = (o)object;
            this.E((o)object);
            return 1 != 0;
        } else {
            n11 = d.v.g0.h.X0;
            if (n11 == n10) {
                object = (Integer)object;
                this.F((Integer)object);
                return 1 != 0;
            } else {
                n11 = d.v.g0.h.z;
                if (n11 == n10) {
                    object = (i$a)object;
                    this.C((i$a)object);
                    return 1 != 0;
                } else {
                    n11 = d.v.g0.h.H;
                    if (n11 != n10) return 0 != 0;
                    object = (Boolean)object;
                    this.D((Boolean)object);
                }
            }
        }
        return 1 != 0;
    }
}

