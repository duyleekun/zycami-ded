/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.CheckedTextView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import d.v.c.s1.t;
import d.v.c.s1.u;
import d.v.c.w0.ec;

public class fc
extends ec {
    private static final ViewDataBinding$IncludedLayouts f;
    private static final SparseIntArray g;
    private final CheckedTextView d;
    private long e;

    public fc(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = f;
        SparseIntArray sparseIntArray = g;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 1, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private fc(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        super((Object)dataBindingComponent, view, 2);
        this.e = -1;
        dataBindingComponent = (CheckedTextView)objectArray[0];
        this.d = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(t t10, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.e;
                long l11 = 1L;
                this.e = l10 |= l11;
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
    private boolean F(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.e;
                long l11 = 2;
                this.e = l10 |= l11;
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
    public void B(Integer n10) {
        this.a = n10;
        synchronized (this) {
            long l10 = this.e;
            long l11 = 4;
            this.e = l10 |= l11;
        }
        this.notifyPropertyChanged(101);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(t t10) {
        this.updateRegistration(0, t10);
        this.b = t10;
        synchronized (this) {
            long l10 = this.e;
            long l11 = 1L;
            this.e = l10 |= l11;
        }
        this.notifyPropertyChanged(125);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(u u10) {
        this.c = u10;
        synchronized (this) {
            long l10 = this.e;
            long l11 = 8;
            this.e = l10 |= l11;
        }
        this.notifyPropertyChanged(126);
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
        long l14;
        float f10;
        long l15;
        boolean bl2;
        int n10;
        long l16;
        long l17;
        fc fc2 = this;
        synchronized (this) {
            l17 = this.e;
            this.e = l16 = 0L;
        }
        Integer n11 = this.a;
        Object object = this.b;
        Object object2 = this.c;
        long l18 = 30;
        long l19 = l17 & l18;
        long l20 = l19 == l16 ? 0 : (l19 < l16 ? -1 : 1);
        float f11 = 0.0f;
        boolean bl3 = false;
        if (l20 != false) {
            if (object2 != null) {
                object2 = ((u)object2).e();
            } else {
                n10 = 0;
                object2 = null;
            }
            bl2 = true;
            fc2.updateLiveDataRegistration((int)(bl2 ? 1 : 0), (LiveData)object2);
            if (object2 != null) {
                object2 = (Integer)((LiveData)object2).getValue();
            } else {
                n10 = 0;
                object2 = null;
            }
            if (n11 != object2) {
                bl2 = false;
            }
            if (l20 != false) {
                l15 = bl2 ? 256L : 128L;
                l17 |= l15;
            }
            if (bl2) {
                n11 = fc2.d.getResources();
                n10 = 2131165357;
                f11 = f10 = n11.getDimension(n10);
            }
        } else {
            bl2 = false;
        }
        if ((l14 = (l13 = (l12 = l17 & (l15 = (long)17)) - l16) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            if (object != null) {
                bl3 = ((t)object).u();
                object = ((t)object).t();
            } else {
                object = null;
            }
            if (l14 != false) {
                l12 = bl3 ? (long)64 : (long)32;
                l17 |= l12;
            }
            n11 = fc2.d;
            n10 = bl3 ? 2131099772 : 2131099775;
            l14 = ViewDataBinding.getColorFromResource((View)n11, n10);
        } else {
            l14 = 0;
            n11 = null;
            f10 = 0.0f;
            object = null;
        }
        long l21 = l17 & l18;
        n10 = (int)(l21 == l16 ? 0 : (l21 < l16 ? -1 : 1));
        if (n10 != 0) {
            fc2.d.setChecked(bl2);
            object2 = fc2.d;
            ViewBindingAdapter.setPadding((View)object2, f11);
        }
        if ((l11 = (l10 = (l17 &= l15) - l16) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            fc2.d.setEnabled(bl3);
            CheckedTextView checkedTextView = fc2.d;
            checkedTextView.setTextColor((int)l14);
            n11 = fc2.d;
            l.a.q.g0.u.n((TextView)n11, (String)object, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.e;
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
            this.e = l10 = (long)16;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                return false;
            }
            object = (MutableLiveData)object;
            return this.F((MutableLiveData)object, n11);
        }
        object = (t)object;
        return this.E((t)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 101;
        if (n11 == n10) {
            object = (Integer)object;
            this.B((Integer)object);
            return 1 != 0;
        } else {
            n11 = 125;
            if (n11 == n10) {
                object = (t)object;
                this.C((t)object);
                return 1 != 0;
            } else {
                n11 = 126;
                if (n11 != n10) return 0 != 0;
                object = (u)object;
                this.D((u)object);
            }
        }
        return 1 != 0;
    }
}

