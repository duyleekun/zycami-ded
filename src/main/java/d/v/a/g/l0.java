/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.a.g;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.R$id;
import com.zhiyun.account.me.account.widget.MePassView;
import com.zhiyun.account.set.privacy.SetNewPassFragment$a;
import d.v.a.d;
import d.v.a.g.k0;
import d.v.a.g.l0$a;
import d.v.a.g.l0$b;
import d.v.a.j.c.y;

public class l0
extends k0 {
    private static final ViewDataBinding$IncludedLayouts l;
    private static final SparseIntArray m;
    private final ConstraintLayout h;
    private l0$b i;
    private l0$a j;
    private long k;

    static {
        SparseIntArray sparseIntArray;
        m = sparseIntArray = new SparseIntArray();
        int n10 = R$id.tv_title;
        sparseIntArray.put(n10, 3);
        n10 = R$id.mnv_pass_first;
        sparseIntArray.put(n10, 4);
        n10 = R$id.mpv_pass_second;
        sparseIntArray.put(n10, 5);
    }

    public l0(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = l;
        SparseIntArray sparseIntArray = m;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private l0(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[1];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[4];
        object4 = (MePassView)((Object)object2);
        Object object5 = object2 = objectArray[5];
        object5 = (MePassView)((Object)object2);
        Object object6 = object2 = objectArray[2];
        object6 = (TextView)object2;
        Object object7 = object2 = objectArray[3];
        object7 = (TextView)object2;
        super(object, view, 1, (ImageView)object3, (MePassView)((Object)object4), (MePassView)((Object)object5), (TextView)object6, (TextView)object7);
        this.k = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.h = object;
        object.setTag(null);
        this.d.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(MutableLiveData mutableLiveData, int n10) {
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
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
    public void A(SetNewPassFragment$a setNewPassFragment$a) {
        this.f = setNewPassFragment$a;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 4;
            this.k = l10 |= l11;
        }
        int n10 = d.v.a.d.x;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(y y10) {
        this.g = y10;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 2;
            this.k = l10 |= l11;
        }
        int n10 = d.v.a.d.N0;
        this.notifyPropertyChanged(n10);
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
        l0$a l0$a;
        int n10;
        long l13;
        long l14;
        l0 l02 = this;
        synchronized (this) {
            l14 = this.k;
            this.k = l13 = 0L;
        }
        Object object = this.g;
        SetNewPassFragment$a setNewPassFragment$a = this.f;
        float f10 = 0.0f;
        long l15 = 15;
        long l16 = l14 & l15;
        long l17 = l16 == l13 ? 0 : (l16 < l13 ? -1 : 1);
        long l18 = 12;
        boolean bl2 = false;
        long l19 = 11;
        l0$b l0$b = null;
        if (l17 != false) {
            long l20;
            long l21;
            float f11;
            if (object != null) {
                object = ((y)object).c;
            } else {
                n10 = 0;
                object = null;
                f11 = 0.0f;
            }
            l02.updateLiveDataRegistration(0, (LiveData)object);
            if (setNewPassFragment$a != null) {
                l0$a = l02.j;
                if (l0$a == null) {
                    l02.j = l0$a = new l0$a();
                }
                l0$a = l0$a.b(setNewPassFragment$a);
            } else {
                l17 = 0;
                l0$a = null;
            }
            if (object != null) {
                object = (Boolean)((LiveData)object).getValue();
            } else {
                n10 = 0;
                object = null;
                f11 = 0.0f;
            }
            bl2 = ViewDataBinding.safeUnbox((Boolean)object);
            long l22 = l14 & l19;
            n10 = (int)(l22 == l13 ? 0 : (l22 < l13 ? -1 : 1));
            if (n10 != 0) {
                l22 = bl2 ? (long)32 : (long)16;
                l14 |= l22;
            }
            if ((n10 = (int)((l21 = (l22 = l14 & l19) - l13) == 0L ? 0 : (l21 < 0L ? -1 : 1))) != 0) {
                if (bl2) {
                    n10 = 1065353216;
                    f11 = 1.0f;
                } else {
                    n10 = 1053609165;
                    f11 = 0.4f;
                }
                f10 = f11;
            }
            if ((n10 = (int)((l20 = (l22 = l14 & l18) - l13) == 0L ? 0 : (l20 < 0L ? -1 : 1))) != 0 && setNewPassFragment$a != null) {
                object = l02.i;
                if (object == null) {
                    l02.i = object = new l0$b();
                }
                l0$b = ((l0$b)object).b(setNewPassFragment$a);
            }
            object = l0$b;
        } else {
            n10 = 0;
            object = null;
            float f12 = 0.0f;
            l17 = 0;
            l0$a = null;
        }
        long l23 = (l12 = (l18 &= l14) - l13) == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (l23 != false) {
            setNewPassFragment$a = l02.a;
            setNewPassFragment$a.setOnClickListener((View.OnClickListener)object);
        }
        if ((n10 = (l11 = (l18 = l14 & l19) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != 0 && (n10 = ViewDataBinding.getBuildSdkInt()) >= (l23 = (long)11)) {
            object = l02.d;
            object.setAlpha(f10);
        }
        if ((n10 = (int)((l10 = (l14 &= l15) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0) {
            object = l02.d;
            ViewBindingAdapter.setOnClick((View)object, l0$a, bl2);
        }
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
        object = (MutableLiveData)object;
        return this.C((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = d.v.a.d.N0;
        if (n11 == n10) {
            object = (y)object;
            this.B((y)object);
            return 1 != 0;
        } else {
            n11 = d.v.a.d.x;
            if (n11 != n10) return 0 != 0;
            object = (SetNewPassFragment$a)object;
            this.A((SetNewPassFragment$a)object);
        }
        return 1 != 0;
    }
}

