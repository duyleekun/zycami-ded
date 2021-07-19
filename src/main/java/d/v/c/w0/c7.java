/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 */
package d.v.c.w0;

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
import com.zhiyun.cama.voice.music.MusicListViewModel;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.v0.i;
import d.v.c.w0.b7;
import d.v.c.w0.c7$a;
import d.v.c.y1.f.w.f$a;
import d.v.f.e.a;

public class c7
extends b7
implements b$a {
    private static final ViewDataBinding$IncludedLayouts k;
    private static final SparseIntArray l;
    private final FrameLayout g;
    private final View.OnClickListener h;
    private c7$a i;
    private long j;

    public c7(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = k;
        SparseIntArray sparseIntArray = l;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private c7(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[2];
        object4 = (RecyclerView)object3;
        int n10 = 1;
        Object object5 = object2 = objectArray[n10];
        object5 = (SwipeRefreshLayout)object2;
        Object object6 = object2 = objectArray[3];
        object6 = (StatusView)((Object)object2);
        object2 = this;
        super(object, view, 2, (RecyclerView)object4, (SwipeRefreshLayout)object5, (StatusView)((Object)object6));
        this.j = -1;
        object = (FrameLayout)objectArray[0];
        this.g = object;
        object.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.setRootTag(view);
        object = new b(this, n10);
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
    public void B(f$a f$a) {
        this.f = f$a;
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
        this.e = i10;
        synchronized (this) {
            long l10 = this.j;
            long l11 = 8;
            this.j = l10 |= l11;
        }
        this.notifyPropertyChanged(81);
        super.requestRebind();
    }

    public void D(MusicListViewModel musicListViewModel) {
        this.d = musicListViewModel;
    }

    public final void a(int n10, View view) {
        f$a f$a = this.f;
        boolean bl2 = f$a != null;
        if (bl2) {
            f$a.a();
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
        long l15;
        boolean bl2;
        Object object;
        long l16;
        long l17;
        c7 c72 = this;
        synchronized (this) {
            l17 = this.j;
            this.j = l16 = 0L;
        }
        Object object2 = this.f;
        Object object3 = this.e;
        long l18 = (long)36 & l17;
        long l19 = l18 == l16 ? 0 : (l18 < l16 ? -1 : 1);
        int n10 = 0;
        Object object4 = null;
        if (l19 != false && object2 != null) {
            object = this.i;
            if (object == null) {
                object = new c7$a();
                this.i = object;
            }
            object2 = ((c7$a)object).a((f$a)object2);
        } else {
            bl2 = false;
            object2 = null;
        }
        long l20 = (long)43 & l17;
        Object object5 = l20 == l16 ? 0 : (l20 < l16 ? -1 : 1);
        long l21 = 42;
        int n11 = 1;
        long l22 = 41;
        boolean bl3 = false;
        if (object5 != false) {
            l15 = l17 & l22;
            long l23 = l15 - l16;
            object5 = l23 == 0L ? 0 : (l23 < 0L ? -1 : 1);
            if (object5 != false) {
                if (object3 != null) {
                    object = ((i)object3).c();
                } else {
                    object5 = 0;
                    object = null;
                }
                c72.updateLiveDataRegistration(0, (LiveData)object);
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
            l15 = l17 & l21;
            long l24 = l15 == l16 ? 0 : (l15 < l16 ? -1 : 1);
            if (l24 != false) {
                if (object3 != null) {
                    object3 = ((i)object3).d();
                } else {
                    l14 = 0;
                    object3 = null;
                }
                c72.updateLiveDataRegistration(n11, (LiveData)object3);
                if (object3 != null) {
                    object3 = ((LiveData)object3).getValue();
                    object4 = object3;
                    object4 = (Boolean)object3;
                }
                bl3 = ViewDataBinding.safeUnbox((Boolean)object4);
            }
        } else {
            object5 = 0;
            object = null;
        }
        if ((l14 = (l13 = (l15 = l17 & (long)32) - l16) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            d.v.f.e.a.a(c72.a, n11 != 0);
            object3 = c72.c;
            n10 = ViewDataBinding.getColorFromResource((View)object3, 2131099860);
            ((StatusView)((Object)object3)).setBackgroundColor(n10);
            object3 = c72.c;
            object4 = object3.getContext();
            n11 = 2131231805;
            object4 = AppCompatResources.getDrawable(object4, n11);
            ((StatusView)((Object)object3)).setErrorImage((Drawable)object4);
            c72.c.setErrorText("@string/request_error");
            object3 = c72.c;
            object4 = c72.h;
            ((StatusView)((Object)object3)).setOnClickErrorListener((View.OnClickListener)object4);
        }
        if (l19 != false) {
            object3 = c72.b;
            ((SwipeRefreshLayout)object3).setOnRefreshListener((SwipeRefreshLayout$OnRefreshListener)object2);
        }
        if (bl2 = (l12 = (l11 = l17 & l21) - l16) == 0L ? 0 : (l12 < 0L ? -1 : 1)) {
            object2 = c72.b;
            ((SwipeRefreshLayout)object2).setEnabled(bl3);
        }
        if (bl2 = (l10 = (l17 &= l22) - l16) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            object2 = c72.b;
            ((SwipeRefreshLayout)object2).setRefreshing((boolean)object5);
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
            object = (f$a)object;
            this.B((f$a)object);
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
                object = (MusicListViewModel)object;
                this.D((MusicListViewModel)object);
            }
        }
        return 1 != 0;
    }
}

