/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnLongClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import d.v.c.b1.r;
import d.v.c.b1.s;
import d.v.c.f1.a.e$a;
import d.v.c.w0.sa;
import d.v.l.g.a;
import l.a.q.g0.u;

public class ta
extends sa
implements e$a {
    private static final ViewDataBinding$IncludedLayouts l;
    private static final SparseIntArray m;
    private final ConstraintLayout i;
    private final View.OnLongClickListener j;
    private long k;

    static {
        SparseIntArray sparseIntArray;
        m = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363695, 5);
    }

    public ta(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = l;
        SparseIntArray sparseIntArray = m;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private ta(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[4];
        object4 = (TextView)object3;
        Object object5 = object3 = objectArray[2];
        object5 = (TextView)object3;
        int n10 = 1;
        Object object6 = object2 = objectArray[n10];
        object6 = (ImageView)object2;
        Object object7 = object2 = objectArray[3];
        object7 = (TextView)object2;
        Object object8 = object2 = objectArray[5];
        object8 = (View)object2;
        object2 = this;
        super(object, view, 1, (TextView)object4, (TextView)object5, (ImageView)object6, (TextView)object7, (View)object8);
        this.k = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.i = object;
        object.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.setRootTag(view);
        super(this, n10);
        this.j = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(r r10, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.k;
                long l11 = 1L;
                this.k = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(r r10) {
        this.updateRegistration(0, r10);
        this.f = r10;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 1L;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(70);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(Integer n10) {
        this.g = n10;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 2;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(101);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(s s10) {
        this.h = s10;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 4;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        ConstraintLayout constraintLayout;
        Context context;
        Object object;
        String string2;
        String string3;
        long l10;
        long l11;
        ta ta2 = this;
        synchronized (this) {
            l11 = this.k;
            this.k = l10 = 0L;
        }
        Object object2 = this.f;
        long l12 = (long)9 & l11;
        long l13 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
        if (l13 != false && object2 != null) {
            string3 = ((r)object2).s();
            string2 = ((r)object2).y();
            object = this.getRoot().getContext();
            object = ((r)object2).w((Context)object);
            context = this.getRoot().getContext();
            object2 = ((r)object2).x(context);
            Object object3 = object;
            object = string2;
            string2 = object3;
        } else {
            object2 = null;
            string3 = null;
            string2 = null;
            object = null;
        }
        long l14 = 8;
        long l15 = (l11 &= l14) - l10;
        long l16 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (l16 != false) {
            constraintLayout = ta2.i;
            View.OnLongClickListener onLongClickListener = ta2.j;
            constraintLayout.setOnLongClickListener(onLongClickListener);
        }
        if (l13 != false) {
            u.n(ta2.a, string2, null, null);
            u.n(ta2.b, string3, null, null);
            string2 = ta2.c;
            context = null;
            int n10 = 8;
            boolean bl2 = true;
            d.v.l.g.a.b((ImageView)string2, object, null, null, n10, bl2, false, null, null, null);
            constraintLayout = ta2.d;
            u.n((TextView)constraintLayout, (String)object2, null, null);
        }
    }

    public final boolean h(int n10, View object) {
        r r10 = this.f;
        object = this.g;
        s s10 = this.h;
        boolean bl2 = false;
        boolean bl3 = s10 != null;
        if (bl3) {
            int n11 = (Integer)object;
            bl2 = s10.i(n11, r10);
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.k;
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
            this.k = l10 = (long)8;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (r)object;
        return this.E((r)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 70;
        if (n11 == n10) {
            object = (r)object;
            this.B((r)object);
            return 1 != 0;
        } else {
            n11 = 101;
            if (n11 == n10) {
                object = (Integer)object;
                this.C((Integer)object);
                return 1 != 0;
            } else {
                n11 = 152;
                if (n11 != n10) return 0 != 0;
                object = (s)object;
                this.D((s)object);
            }
        }
        return 1 != 0;
    }
}

