/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import d.v.c.f1.a.b$a;
import d.v.c.v0.i;
import d.v.c.w0.v5;
import d.v.c.w0.w5$a;
import d.v.c.y1.f.v.i$a;
import d.v.f.e.a;

public class w5
extends v5
implements b$a {
    private static final ViewDataBinding$IncludedLayouts o;
    private static final SparseIntArray p;
    private final ConstraintLayout j;
    private final View.OnClickListener k;
    private final View.OnClickListener l;
    private w5$a m;
    private long n;

    static {
        SparseIntArray sparseIntArray;
        p = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362169, 5);
        sparseIntArray.put(2131363608, 6);
    }

    public w5(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = o;
        SparseIntArray sparseIntArray = p;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private w5(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[5];
        object4 = (ConstraintLayout)((Object)object3);
        int n10 = 1;
        Object object5 = object2 = objectArray[n10];
        object5 = (ImageView)object2;
        Object object6 = object2 = objectArray[3];
        object6 = (RecyclerView)object2;
        int n11 = 2;
        Object object7 = object2 = objectArray[n11];
        object7 = (SwipeRefreshLayout)object2;
        Object object8 = object2 = objectArray[4];
        object8 = (StatusView)((Object)object2);
        Object object9 = object2 = objectArray[6];
        object9 = (TextView)object2;
        object2 = this;
        super(object, view, 2, (ConstraintLayout)((Object)object4), (ImageView)object5, (RecyclerView)object6, (SwipeRefreshLayout)object7, (StatusView)((Object)object8), (TextView)object9);
        this.n = -1;
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.j = object;
        object.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.setRootTag(view);
        super(this, n11);
        this.k = object;
        super(this, n10);
        this.l = object;
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
                long l10 = this.n;
                long l11 = 1L;
                this.n = l10 |= l11;
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
                long l10 = this.n;
                long l11 = 2;
                this.n = l10 |= l11;
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
    public void B(i$a i$a) {
        this.i = i$a;
        synchronized (this) {
            long l10 = this.n;
            long l11 = 4;
            this.n = l10 |= l11;
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
        this.h = i10;
        synchronized (this) {
            long l10 = this.n;
            long l11 = 8;
            this.n = l10 |= l11;
        }
        this.notifyPropertyChanged(81);
        super.requestRebind();
    }

    public void D(MusicListViewModel musicListViewModel) {
        this.g = musicListViewModel;
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                i$a i$a = this.i;
                if (i$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    i$a.b();
                }
            }
        } else {
            i$a i$a = this.i;
            if (i$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                i$a.a(view);
            }
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
        w5 w52 = this;
        synchronized (this) {
            l17 = this.n;
            this.n = l16 = 0L;
        }
        Object object2 = this.i;
        Object object3 = this.h;
        long l18 = (long)36 & l17;
        long l19 = l18 == l16 ? 0 : (l18 < l16 ? -1 : 1);
        int n10 = 0;
        Object object4 = null;
        if (l19 != false && object2 != null) {
            object = this.m;
            if (object == null) {
                object = new w5$a();
                this.m = object;
            }
            object2 = ((w5$a)object).a((i$a)object2);
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
                w52.updateLiveDataRegistration(0, (LiveData)object);
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
                w52.updateLiveDataRegistration(n11, (LiveData)object3);
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
            object3 = w52.b;
            object4 = w52.l;
            object3.setOnClickListener(object4);
            d.v.f.e.a.a(w52.c, n11 != 0);
            object3 = w52.e;
            n10 = ViewDataBinding.getColorFromResource((View)object3, 2131099762);
            ((StatusView)((Object)object3)).setBackgroundColor(n10);
            object3 = w52.e;
            object4 = object3.getContext();
            n11 = 2131231805;
            object4 = AppCompatResources.getDrawable((Context)object4, n11);
            ((StatusView)((Object)object3)).setErrorImage((Drawable)object4);
            w52.e.setErrorText("@string/request_error");
            object3 = w52.e;
            object4 = w52.k;
            ((StatusView)((Object)object3)).setOnClickErrorListener((View.OnClickListener)object4);
        }
        if (l19 != false) {
            object3 = w52.d;
            ((SwipeRefreshLayout)object3).setOnRefreshListener((SwipeRefreshLayout$OnRefreshListener)object2);
        }
        if (bl2 = (l12 = (l11 = l17 & l21) - l16) == 0L ? 0 : (l12 < 0L ? -1 : 1)) {
            object2 = w52.d;
            ((SwipeRefreshLayout)object2).setEnabled(bl3);
        }
        if (bl2 = (l10 = (l17 &= l22) - l16) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            object2 = w52.d;
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
            long l10 = this.n;
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
            this.n = l10 = (long)32;
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
            object = (i$a)object;
            this.B((i$a)object);
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

