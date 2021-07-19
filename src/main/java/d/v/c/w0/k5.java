/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.device.active.ActivationAccountFragment$a;
import com.zhiyun.device.active.ActivationViewModel;
import d.v.c.f1.a.b$a;
import d.v.c.w0.j5;
import l.a.q.g0.u;

public class k5
extends j5
implements b$a {
    private static final ViewDataBinding$IncludedLayouts l;
    private static final SparseIntArray m;
    private final ConstraintLayout g;
    private final TextView h;
    private final View.OnClickListener i;
    private final View.OnClickListener j;
    private long k;

    static {
        SparseIntArray sparseIntArray;
        m = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363353, 4);
        sparseIntArray.put(2131363344, 5);
    }

    public k5(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = l;
        SparseIntArray sparseIntArray = m;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private k5(DataBindingComponent object, View object2, Object[] textView) {
        Object object3;
        int n10 = 1;
        Object object4 = object3 = textView[n10];
        object4 = (TextView)object3;
        Object object5 = object3 = textView[5];
        object5 = (TextView)object3;
        Object object6 = object3 = textView[4];
        object6 = (TextView)object3;
        Object object7 = object3 = textView[3];
        object7 = (TextView)object3;
        super(object, (View)object2, 1, (TextView)object4, (TextView)object5, (TextView)object6, (TextView)object7);
        this.k = -1;
        object = (ConstraintLayout)((Object)textView[0]);
        this.g = object;
        object.setTag(null);
        int n11 = 2;
        this.h = textView = (TextView)textView[n11];
        textView.setTag(null);
        this.a.setTag(null);
        this.d.setTag(null);
        this.setRootTag((View)object2);
        super(this, n11);
        this.i = object2;
        super(this, n10);
        this.j = object;
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
    public void A(ActivationAccountFragment$a activationAccountFragment$a) {
        this.e = activationAccountFragment$a;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 2;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(ActivationViewModel activationViewModel) {
        this.f = activationViewModel;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 4;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                ActivationAccountFragment$a activationAccountFragment$a = this.e;
                if (activationAccountFragment$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    activationAccountFragment$a.a();
                }
            }
        } else {
            ActivationAccountFragment$a activationAccountFragment$a = this.e;
            if (activationAccountFragment$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                activationAccountFragment$a.b();
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        synchronized (this) {
            var1_1 = this.k;
            this.k = var3_2 = 0L;
        }
        var5_3 = this.f;
        var6_4 = (long)13 & var1_1;
        var8_5 = var6_4 == var3_2 ? 0 : (var6_4 < var3_2 ? -1 : 1);
        if (var8_5 == false) ** GOTO lbl-1000
        var5_3 = var5_3 != null ? var5_3.Q() : null;
        this.updateLiveDataRegistration(0, (LiveData)var5_3);
        if (var5_3 != null) {
            var5_3 = (String)var5_3.getValue();
        } else lbl-1000:
        // 2 sources

        {
            var5_3 = null;
        }
        var9_6 = 8;
        cfr_temp_0 = (var1_1 &= var9_6) - var3_2;
        var11_7 = cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
        if (var11_7 != false) {
            var12_8 = this.h;
            var13_9 = this.j;
            var12_8.setOnClickListener(var13_9);
            var12_8 = this.d;
            var13_9 = this.i;
            var12_8.setOnClickListener(var13_9);
        }
        if (var8_5 != false) {
            var12_8 = this.a;
            u.n(var12_8, (String)var5_3, null, null);
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
        int n11 = 25;
        if (n11 == n10) {
            object = (ActivationAccountFragment$a)object;
            this.A((ActivationAccountFragment$a)object);
            return 1 != 0;
        } else {
            n11 = 152;
            if (n11 != n10) return 0 != 0;
            object = (ActivationViewModel)object;
            this.B((ActivationViewModel)object);
        }
        return 1 != 0;
    }
}

