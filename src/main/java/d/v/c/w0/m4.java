/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.widget.ThumbnailView;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.f1.a.c;
import d.v.c.f1.a.c$a;
import d.v.c.f1.a.k;
import d.v.c.f1.a.k$a;
import d.v.c.f1.a.m;
import d.v.c.f1.a.m$a;
import d.v.c.q0.f.a;
import d.v.c.r0.d;
import d.v.c.r0.d$b;
import d.v.c.r0.d$c;
import d.v.c.r0.d$d;
import d.v.c.u0.n$a;
import d.v.c.w0.l4;
import d.v.c.w0.wi;
import d.v.e.l.l2;
import l.a.q.g0.u;

public class m4
extends l4
implements m$a,
k$a,
c$a {
    private static final ViewDataBinding$IncludedLayouts m;
    private static final SparseIntArray n;
    private final d$d i;
    private final d$c j;
    private final d$b k;
    private long l;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        m = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(6);
        String[] stringArray = new String[]{"widget_titlebar_no_button"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 3;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558817;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        n = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131362635, 4);
        viewDataBinding$IncludedLayouts.put(2131363695, 5);
    }

    public m4(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = m;
        SparseIntArray sparseIntArray = n;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private m4(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[0];
        object2 = (ConstraintLayout)((Object)object);
        Object object3 = object = objectArray[4];
        object3 = (ImageView)object;
        int n10 = 3;
        Object object4 = object = objectArray[n10];
        object4 = (wi)object;
        int n11 = 1;
        Object object5 = object = objectArray[n11];
        object5 = (ZYTextView)object;
        Object object6 = object = objectArray[5];
        object6 = (View)object;
        int n12 = 2;
        Object object7 = object = objectArray[n12];
        object7 = (ThumbnailView)object;
        object = this;
        super(dataBindingComponent, view, 2, (ConstraintLayout)((Object)object2), (ImageView)object3, (wi)object4, (ZYTextView)object5, (View)object6, (ThumbnailView)object7);
        this.l = -1;
        this.a.setTag(null);
        object = this.c;
        this.setContainedBinding((ViewDataBinding)object);
        this.d.setTag(null);
        this.f.setTag(null);
        object = view;
        this.setRootTag(view);
        this.i = object = new m(this, n10);
        this.j = object = new k(this, n12);
        this.k = object = new c(this, n11);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(wi wi2, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.l;
                long l11 = 2;
                this.l = l10 |= l11;
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
    private boolean D(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.l;
                long l11 = 1L;
                this.l = l10 |= l11;
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
    public void A(n$a n$a) {
        this.h = n$a;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 4;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(d.v.c.u0.m m10) {
        this.g = m10;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 8;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void c(int n10) {
        n$a n$a = this.h;
        boolean bl2 = n$a != null;
        if (bl2) {
            n$a.f();
        }
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
        synchronized (this) {
            l14 = this.l;
            this.l = l13 = 0L;
        }
        Object object = this.h;
        Object object2 = this.g;
        long l15 = (long)20 & l14;
        long l16 = l15 == l13 ? 0 : (l15 < l13 ? -1 : 1);
        long l17 = (long)25 & l14;
        long l18 = l17 == l13 ? 0 : (l17 < l13 ? -1 : 1);
        if (l18 != false) {
            object2 = object2 != null ? ((d.v.c.u0.m)object2).e() : null;
            this.updateLiveDataRegistration(0, (LiveData)object2);
            object2 = object2 != null ? (Long)((LiveData)object2).getValue() : null;
            long l19 = ViewDataBinding.safeUnbox((Long)object2);
            object2 = l2.d(l19);
        } else {
            object2 = null;
        }
        if (l16 != false) {
            wi wi2 = this.c;
            wi2.z((a)object);
        }
        if (l18 != false) {
            object = this.d;
            u.n((TextView)object, (String)object2, null, null);
        }
        if ((l12 = (l11 = (l14 &= (l10 = (long)16)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            ThumbnailView thumbnailView = this.f;
            d$c d$c = this.j;
            d$d d$d = this.i;
            d$b d$b = this.k;
            d.v.c.r0.d.a(thumbnailView, d$c, d$d, d$b);
        }
        ViewDataBinding.executeBindingsOn(this.c);
    }

    public final void f(int n10, RecyclerView recyclerView, long l10) {
        n$a n$a = this.h;
        boolean bl2 = n$a != null;
        if (bl2) {
            n$a.c(recyclerView, l10);
        }
    }

    public final void g(int n10) {
        n$a n$a = this.h;
        boolean bl2 = n$a != null;
        if (bl2) {
            n$a.e();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.l;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            wi wi2 = this.c;
            l12 = (long)wi2.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            return false;
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
            this.l = l10 = (long)16;
        }
        this.c.invalidateAll();
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                return false;
            }
            object = (wi)object;
            return this.C((wi)object, n11);
        }
        object = (MutableLiveData)object;
        return this.D((MutableLiveData)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.c.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (n$a)object;
            this.A((n$a)object);
            return 1 != 0;
        } else {
            n11 = 152;
            if (n11 != n10) return 0 != 0;
            object = (d.v.c.u0.m)object;
            this.B((d.v.c.u0.m)object);
        }
        return 1 != 0;
    }
}

