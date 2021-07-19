/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import d.v.c.n1.l2;
import d.v.c.w0.j6;
import d.v.c.w0.k6$a;
import d.v.c.y1.h.h$a;

public class k6
extends j6 {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private final ConstraintLayout f;
    private k6$a g;
    private long h;

    static {
        SparseIntArray sparseIntArray;
        j = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362888, 3);
    }

    public k6(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private k6(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[1];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[2];
        object4 = (ProgressBar)object2;
        Object object5 = object2 = objectArray[3];
        object5 = (RecyclerView)object2;
        super(object, view, 1, (ImageView)object3, (ProgressBar)object4, (RecyclerView)object5);
        this.h = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.f = object;
        object.setTag(null);
        this.setRootTag(view);
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
    public void A(h$a h$a) {
        this.e = h$a;
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
    public void B(l2 l22) {
        this.d = l22;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 4;
            this.h = l10 |= l11;
        }
        this.notifyPropertyChanged(148);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        long l11;
        long l12;
        long l13;
        int n10;
        long l14;
        long l15;
        synchronized (this) {
            l15 = this.h;
            this.h = l14 = 0L;
        }
        Object object = this.e;
        Object object2 = this.d;
        long l16 = 10;
        long l17 = l15 & l16;
        long l18 = l17 == l14 ? 0 : (l17 < l14 ? -1 : 1);
        Object object3 = null;
        if (l18 != false && object != null) {
            k6$a k6$a = this.g;
            if (k6$a == null) {
                this.g = k6$a = new k6$a();
            }
            object = k6$a.b((h$a)object);
        } else {
            object = null;
        }
        long l19 = 13;
        long l20 = l15 & l19;
        l18 = l20 == l14 ? 0 : (l20 < l14 ? -1 : 1);
        int n11 = 0;
        if (l18 != false) {
            if (object2 != null) {
                object2 = ((l2)object2).f();
            } else {
                n10 = 0;
                object2 = null;
            }
            this.updateLiveDataRegistration(0, (LiveData)object2);
            if (object2 != null) {
                object3 = object2 = ((LiveData)object2).getValue();
                object3 = (Boolean)object2;
            }
            n10 = ViewDataBinding.safeUnbox(object3);
            if (l18 != false) {
                l17 = n10 != 0 ? (long)32 : (long)16;
                l15 |= l17;
            }
            if (n10 == 0) {
                n11 = n10 = 8;
            }
        }
        if ((n10 = (l13 = (l12 = l15 & l16) - l14) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != 0) {
            object2 = this.a;
            object2.setOnClickListener((View.OnClickListener)object);
        }
        if ((l11 = (l10 = (l15 &= l19) - l14) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            ProgressBar progressBar = this.b;
            progressBar.setVisibility(n11);
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
            object = (h$a)object;
            this.A((h$a)object);
            return 1 != 0;
        } else {
            n11 = 148;
            if (n11 != n10) return 0 != 0;
            object = (l2)object;
            this.B((l2)object);
        }
        return 1 != 0;
    }
}

