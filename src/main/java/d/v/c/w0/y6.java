/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener;
import com.zhiyun.account.widget.StatusView;
import d.v.c.f1.a.b$a;
import d.v.c.v0.i;
import d.v.c.w0.x6;
import d.v.c.w0.y6$a;
import d.v.c.y1.f.v.j$a;
import d.v.c.y1.f.v.l;
import d.v.f.e.a;

public class y6
extends x6
implements b$a {
    private static final ViewDataBinding$IncludedLayouts k;
    private static final SparseIntArray l;
    private final FrameLayout f;
    private final SwipeRefreshLayout g;
    private final View.OnClickListener h;
    private y6$a i;
    private long j;

    public y6(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = k;
        SparseIntArray sparseIntArray = l;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private y6(DataBindingComponent dataBindingComponent, View object, Object[] object2) {
        Object object3;
        Object object4 = object3 = object2[2];
        object4 = (RecyclerView)object3;
        Object object5 = object3 = object2[3];
        object5 = (StatusView)((Object)object3);
        super(dataBindingComponent, (View)object, 2, (RecyclerView)object4, (StatusView)((Object)object5));
        this.j = -1;
        dataBindingComponent = (FrameLayout)object2[0];
        this.f = dataBindingComponent;
        dataBindingComponent.setTag(null);
        int n10 = 1;
        this.g = object2 = (SwipeRefreshLayout)object2[n10];
        object2.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        this.setRootTag((View)object);
        super(this, n10);
        this.h = object;
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
        y6 y62 = this;
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
                object = new y6$a();
                this.i = object;
            }
            object2 = ((y6$a)object).a((j$a)object2);
        } else {
            bl2 = false;
            object2 = null;
        }
        long l18 = (long)43 & l15;
        Object object5 = l18 == l14 ? 0 : (l18 < l14 ? -1 : 1);
        boolean bl3 = true;
        long l19 = 42;
        long l20 = 41;
        boolean bl4 = false;
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
                y62.updateLiveDataRegistration(0, (LiveData)object);
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
                y62.updateLiveDataRegistration((int)(bl3 ? 1 : 0), (LiveData)object3);
                if (object3 != null) {
                    object4 = object3 = ((LiveData)object3).getValue();
                    object4 = (Boolean)object3;
                }
                bl4 = ViewDataBinding.safeUnbox(object4);
            }
        } else {
            object5 = 0;
            object = null;
        }
        if (l17 != false) {
            object3 = y62.g;
            ((SwipeRefreshLayout)object3).setOnRefreshListener((SwipeRefreshLayout$OnRefreshListener)object2);
        }
        if (bl2 = (l13 = (l12 = l15 & l19) - l14) == 0L ? 0 : (l13 < 0L ? -1 : 1)) {
            object2 = y62.g;
            ((SwipeRefreshLayout)object2).setEnabled(bl4);
        }
        if (bl2 = (l11 = (l12 = l15 & l20) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) {
            object2 = y62.g;
            ((SwipeRefreshLayout)object2).setRefreshing((boolean)object5);
        }
        if (bl2 = (l10 = (l15 &= (l12 = (long)32)) - l14) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            d.v.f.e.a.a(y62.a, bl3);
            object2 = y62.b;
            int n10 = ViewDataBinding.getColorFromResource((View)object2, 2131099860);
            ((StatusView)((Object)object2)).setBackgroundColor(n10);
            object2 = y62.b;
            Context context = object2.getContext();
            int n11 = 2131231805;
            context = AppCompatResources.getDrawable(context, n11);
            ((StatusView)((Object)object2)).setErrorImage((Drawable)context);
            y62.b.setErrorText("@string/request_error");
            object2 = y62.b;
            context = y62.h;
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

