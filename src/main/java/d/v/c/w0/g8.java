/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.widget.base.BaseResourceListView;
import d.v.c.f1.a.b$a;
import d.v.c.v0.i;
import d.v.c.w0.f8;
import d.v.c.w0.g8$a;
import d.v.c.x0.c.d.j$a;
import d.v.c.x0.c.d.l;

public class g8
extends f8
implements b$a {
    private static final ViewDataBinding$IncludedLayouts k;
    private static final SparseIntArray l;
    private final ConstraintLayout f;
    private final SwipeRefreshLayout g;
    private final View.OnClickListener h;
    private g8$a i;
    private long j;

    static {
        SparseIntArray sparseIntArray;
        l = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363074, 3);
    }

    public g8(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = k;
        SparseIntArray sparseIntArray = l;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private g8(DataBindingComponent object, View object2, Object[] object3) {
        Object object4;
        Object object5 = object4 = object3[3];
        object5 = (BaseResourceListView)object4;
        Object object6 = object4 = object3[2];
        object6 = (StatusView)((Object)object4);
        super(object, (View)object2, 2, (BaseResourceListView)object5, (StatusView)((Object)object6));
        this.j = -1;
        object = (ConstraintLayout)((Object)object3[0]);
        this.f = object;
        object.setTag(null);
        int n10 = 1;
        this.g = object3 = (SwipeRefreshLayout)object3[n10];
        object3.setTag(null);
        this.b.setTag(null);
        this.setRootTag((View)object2);
        super(this, n10);
        this.h = object2;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.j;
                long l11 = 1L;
                this.j = l10 |= l11;
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
                long l10 = this.j;
                long l11 = 2;
                this.j = l10 |= l11;
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
    public void B(j$a j$a) {
        this.e = j$a;
        synchronized (this) {
            long l10 = this.j;
            long l11 = 4;
            this.j = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(i i10) {
        this.d = i10;
        synchronized (this) {
            long l10 = this.j;
            long l11 = 8;
            this.j = l10 |= l11;
        }
        this.notifyPropertyChanged(81);
        super.requestRebind();
    }

    public void D(l l10) {
        this.c = l10;
    }

    public final void a(int n10, View view) {
        j$a j$a = this.e;
        boolean bl2 = j$a != null;
        if (bl2) {
            j$a.a();
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
        boolean bl2;
        Object object;
        long l14;
        long l15;
        g8 g82 = this;
        synchronized (this) {
            l15 = this.j;
            this.j = l14 = 0L;
        }
        Object object2 = this.e;
        Object object3 = this.d;
        long l16 = (long)36 & l15;
        long l17 = l16 == l14 ? 0 : (l16 < l14 ? -1 : 1);
        Object object4 = null;
        if (l17 != false && object2 != null) {
            object = this.i;
            if (object == null) {
                object = new g8$a();
                this.i = object;
            }
            object2 = ((g8$a)object).a((j$a)object2);
        } else {
            bl2 = false;
            object2 = null;
        }
        long l18 = (long)43 & l15;
        Object object5 = l18 == l14 ? 0 : (l18 < l14 ? -1 : 1);
        long l19 = 42;
        long l20 = 41;
        int n10 = 0;
        if (object5 != false) {
            long l21 = l15 & l20;
            long l22 = l21 - l14;
            object5 = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
            if (object5 != false) {
                if (object3 != null) {
                    object = ((i)object3).c();
                } else {
                    object5 = 0;
                    object = null;
                }
                g82.updateLiveDataRegistration(0, (LiveData)object);
                if (object != null) {
                    object = (Boolean)((LiveData)object).getValue();
                } else {
                    object5 = 0;
                    object = null;
                }
                object5 = ViewDataBinding.safeUnbox((Boolean)object);
            } else {
                object5 = 0;
                object = null;
            }
            l21 = l15 & l19;
            long l23 = l21 == l14 ? 0 : (l21 < l14 ? -1 : 1);
            if (l23 != false) {
                object3 = object3 != null ? ((i)object3).d() : null;
                n10 = 1;
                g82.updateLiveDataRegistration(n10, (LiveData)object3);
                if (object3 != null) {
                    object4 = object3 = ((LiveData)object3).getValue();
                    object4 = (Boolean)object3;
                }
                n10 = (int)(ViewDataBinding.safeUnbox(object4) ? 1 : 0);
            }
        } else {
            object5 = 0;
            object = null;
        }
        if (l17 != false) {
            object3 = g82.g;
            ((SwipeRefreshLayout)object3).setOnRefreshListener((SwipeRefreshLayout$OnRefreshListener)object2);
        }
        if (bl2 = (l13 = (l12 = l15 & l19) - l14) == 0L ? 0 : (l13 < 0L ? -1 : 1)) {
            object2 = g82.g;
            ((SwipeRefreshLayout)object2).setEnabled(n10 != 0);
        }
        if (bl2 = (l11 = (l12 = l15 & l20) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) {
            object2 = g82.g;
            ((SwipeRefreshLayout)object2).setRefreshing((boolean)object5);
        }
        if (bl2 = (l10 = (l15 &= (l12 = (long)32)) - l14) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            object2 = g82.b;
            int n11 = ViewDataBinding.getColorFromResource((View)object2, 2131099860);
            ((StatusView)((Object)object2)).setBackgroundColor(n11);
            object2 = g82.b;
            Context context = object2.getContext();
            int n12 = 2131231805;
            context = AppCompatResources.getDrawable(context, n12);
            ((StatusView)((Object)object2)).setErrorImage((Drawable)context);
            g82.b.setErrorText("@string/request_error");
            object2 = g82.b;
            context = g82.h;
            ((StatusView)((Object)object2)).setOnClickErrorListener((View.OnClickListener)context);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.j;
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
            this.j = l10 = (long)32;
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
        object = (MutableLiveData)object;
        return this.E((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (j$a)object;
            this.B((j$a)object);
            return 1 != 0;
        } else {
            n11 = 81;
            if (n11 == n10) {
                object = (i)object;
                this.C((i)object);
                return 1 != 0;
            } else {
                n11 = 152;
                if (n11 != n10) return 0 != 0;
                object = (l)object;
                this.D((l)object);
            }
        }
        return 1 != 0;
    }
}

