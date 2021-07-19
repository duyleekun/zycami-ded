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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.widget.base.BaseResourceListView;
import d.v.c.f1.a.b$a;
import d.v.c.v0.i;
import d.v.c.w0.l8;
import d.v.c.w0.m8$a;
import d.v.c.x0.c.f.k$a;

public class m8
extends l8
implements b$a {
    private static final ViewDataBinding$IncludedLayouts j;
    private static final SparseIntArray k;
    private final FrameLayout e;
    private final SwipeRefreshLayout f;
    private final View.OnClickListener g;
    private m8$a h;
    private long i;

    static {
        SparseIntArray sparseIntArray;
        k = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363084, 3);
    }

    public m8(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = j;
        SparseIntArray sparseIntArray = k;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private m8(DataBindingComponent dataBindingComponent, View object, Object[] object2) {
        Object object3;
        Object object4 = object3 = object2[3];
        object4 = (BaseResourceListView)object3;
        Object object5 = object3 = object2[2];
        object5 = (StatusView)((Object)object3);
        super(dataBindingComponent, (View)object, 2, (BaseResourceListView)object4, (StatusView)((Object)object5));
        this.i = -1;
        dataBindingComponent = (FrameLayout)object2[0];
        this.e = dataBindingComponent;
        dataBindingComponent.setTag(null);
        int n10 = 1;
        this.f = object2 = (SwipeRefreshLayout)object2[n10];
        object2.setTag(null);
        this.b.setTag(null);
        this.setRootTag((View)object);
        super(this, n10);
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
                long l10 = this.i;
                long l11 = 1L;
                this.i = l10 |= l11;
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
                long l10 = this.i;
                long l11 = 2;
                this.i = l10 |= l11;
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
    public void A(k$a k$a) {
        this.d = k$a;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 4;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(i i10) {
        this.c = i10;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 8;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(81);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        k$a k$a = this.d;
        boolean bl2 = k$a != null;
        if (bl2) {
            k$a.a();
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
        m8 m82 = this;
        synchronized (this) {
            l15 = this.i;
            this.i = l14 = 0L;
        }
        Object object2 = this.d;
        Object object3 = this.c;
        long l16 = (long)20 & l15;
        long l17 = l16 == l14 ? 0 : (l16 < l14 ? -1 : 1);
        Object object4 = null;
        if (l17 != false && object2 != null) {
            object = this.h;
            if (object == null) {
                object = new m8$a();
                this.h = object;
            }
            object2 = ((m8$a)object).a((k$a)object2);
        } else {
            bl2 = false;
            object2 = null;
        }
        long l18 = (long)27 & l15;
        Object object5 = l18 == l14 ? 0 : (l18 < l14 ? -1 : 1);
        long l19 = 26;
        long l20 = 25;
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
                m82.updateLiveDataRegistration(0, (LiveData)object);
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
                m82.updateLiveDataRegistration(n10, (LiveData)object3);
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
            object3 = m82.f;
            ((SwipeRefreshLayout)object3).setOnRefreshListener((SwipeRefreshLayout$OnRefreshListener)object2);
        }
        if (bl2 = (l13 = (l12 = l15 & l19) - l14) == 0L ? 0 : (l13 < 0L ? -1 : 1)) {
            object2 = m82.f;
            ((SwipeRefreshLayout)object2).setEnabled(n10 != 0);
        }
        if (bl2 = (l11 = (l12 = l15 & l20) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) {
            object2 = m82.f;
            ((SwipeRefreshLayout)object2).setRefreshing((boolean)object5);
        }
        if (bl2 = (l10 = (l15 &= (l12 = (long)16)) - l14) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            object2 = m82.b;
            int n11 = ViewDataBinding.getColorFromResource((View)object2, 2131099860);
            ((StatusView)((Object)object2)).setBackgroundColor(n11);
            object2 = m82.b;
            Context context = object2.getContext();
            int n12 = 2131231805;
            context = AppCompatResources.getDrawable(context, n12);
            ((StatusView)((Object)object2)).setErrorImage((Drawable)context);
            m82.b.setErrorText("@string/request_error");
            object2 = m82.b;
            context = m82.g;
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
            long l10 = this.i;
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
            this.i = l10 = (long)16;
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
            return this.D((MutableLiveData)object, n11);
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
            object = (k$a)object;
            this.A((k$a)object);
            return 1 != 0;
        } else {
            n11 = 81;
            if (n11 != n10) return 0 != 0;
            object = (i)object;
            this.B((i)object);
        }
        return 1 != 0;
    }
}

