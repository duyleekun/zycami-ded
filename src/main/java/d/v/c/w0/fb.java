/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import d.v.c.f1.a.b$a;
import d.v.c.s0.d7.v$b;
import d.v.c.w0.eb;
import d.v.g0.o;
import l.a.q.g0.u;

public class fb
extends eb
implements b$a {
    private static final ViewDataBinding$IncludedLayouts h;
    private static final SparseIntArray i;
    private final ConstraintLayout e;
    private final View.OnClickListener f;
    private long g;

    public fb(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = h;
        SparseIntArray sparseIntArray = i;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 2, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private fb(DataBindingComponent object, View view, Object[] objectArray) {
        int n10 = 1;
        TextView textView = (TextView)objectArray[n10];
        super(object, view, 0, textView);
        this.g = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.e = object;
        object.setTag(null);
        this.a.setTag(null);
        this.setRootTag(view);
        super(this, n10);
        this.f = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(v$b v$b) {
        this.d = v$b;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 4;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(o o10) {
        this.b = o10;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 1L;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(76);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(Integer n10) {
        this.c = n10;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 2;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(101);
        super.requestRebind();
    }

    public final void a(int n10, View object) {
        Integer n11 = this.c;
        object = this.d;
        boolean bl2 = object != null;
        if (bl2) {
            n10 = n11;
            ((v$b)object).a(n10);
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
        synchronized (this) {
            l11 = this.g;
            this.g = l10 = 0L;
        }
        int n10 = 0;
        Object object = this.b;
        long l12 = (long)9 & l11;
        long l13 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
        if (l13 != false && object != null) {
            n10 = ((o)object).a();
            object = ((o)object).b();
        } else {
            object = null;
        }
        long l14 = 8;
        long l15 = (l11 &= l14) - l10;
        long l16 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (l16 != false) {
            textView = this.a;
            View.OnClickListener onClickListener = this.f;
            textView.setOnClickListener(onClickListener);
        }
        if (l13 != false) {
            this.a.setTextColor(n10);
            textView = this.a;
            u.n(textView, (String)object, null, null);
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
            this.g = l10 = (long)8;
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
        int n11 = 76;
        if (n11 == n10) {
            object = (o)object;
            this.C((o)object);
            return 1 != 0;
        } else {
            n11 = 101;
            if (n11 == n10) {
                object = (Integer)object;
                this.D((Integer)object);
                return 1 != 0;
            } else {
                n11 = 25;
                if (n11 != n10) return 0 != 0;
                object = (v$b)object;
                this.B((v$b)object);
            }
        }
        return 1 != 0;
    }
}

