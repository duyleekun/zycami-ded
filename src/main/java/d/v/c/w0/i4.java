/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.LinearLayout
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.i1.i2;
import d.v.c.i1.l2$a;
import d.v.c.w0.h4;
import l.a.q.g0.u;

public class i4
extends h4
implements b$a {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private final LinearLayout e;
    private final TextView f;
    private final View.OnClickListener g;
    private long h;

    public i4(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private i4(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        int n10 = 1;
        Object object3 = object2 = objectArray[n10];
        object3 = (ProgressBar)object2;
        Object object4 = object2 = objectArray[2];
        object4 = (TextView)object2;
        super(object, view, 1, (ProgressBar)object3, (TextView)object4);
        this.h = -1;
        object = (LinearLayout)objectArray[0];
        this.e = object;
        object.setTag(null);
        object = (TextView)objectArray[3];
        this.f = object;
        object.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        this.setRootTag(view);
        object = new b(this, n10);
        this.g = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.h;
                long l11 = 1L;
                this.h = l10 |= l11;
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
    public void A(l2$a l2$a) {
        this.c = l2$a;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 2;
            this.h = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(i2 i22) {
        this.d = i22;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 4;
            this.h = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        l2$a l2$a = this.c;
        boolean bl2 = l2$a != null;
        if (bl2) {
            l2$a.a();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        Object object;
        TextView textView;
        long l10;
        long l11;
        synchronized (this) {
            l11 = this.h;
            this.h = l10 = 0L;
        }
        Object object2 = this.d;
        long l12 = (long)13 & l11;
        long l13 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
        int n10 = 0;
        if (l13 != false) {
            object2 = object2 != null ? ((i2)object2).R1() : null;
            this.updateLiveDataRegistration(0, (LiveData)object2);
            object2 = object2 != null ? (Integer)((LiveData)object2).getValue() : null;
            n10 = ViewDataBinding.safeUnbox((Integer)object2);
        } else {
            object2 = null;
        }
        long l14 = 8;
        long l15 = (l11 &= l14) - l10;
        long l16 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (l16 != false) {
            textView = this.f;
            object = this.g;
            textView.setOnClickListener(object);
        }
        if (l13 != false) {
            this.a.setProgress(n10);
            textView = this.b;
            object = "@string/reverse_progress";
            u.n(textView, (String)object, object2, null);
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
            this.h = l10 = (long)8;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (MutableLiveData)object;
        return this.C((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (l2$a)object;
            this.A((l2$a)object);
            return 1 != 0;
        } else {
            n11 = 152;
            if (n11 != n10) return 0 != 0;
            object = (i2)object;
            this.B((i2)object);
        }
        return 1 != 0;
    }
}

