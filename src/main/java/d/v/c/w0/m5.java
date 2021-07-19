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
import androidx.lifecycle.MediatorLiveData;
import com.zhiyun.cama.device.active.ActivationFailFragment$b;
import com.zhiyun.device.active.ActivationViewModel;
import d.v.c.f1.a.b$a;
import d.v.c.w0.l5;
import l.a.q.g0.u;

public class m5
extends l5
implements b$a {
    private static final ViewDataBinding$IncludedLayouts j;
    private static final SparseIntArray k;
    private final ConstraintLayout g;
    private final View.OnClickListener h;
    private long i;

    static {
        SparseIntArray sparseIntArray;
        k = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363346, 3);
        sparseIntArray.put(2131363500, 4);
    }

    public m5(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = j;
        SparseIntArray sparseIntArray = k;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private m5(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[3];
        object4 = (TextView)object3;
        int n10 = 1;
        Object object5 = object2 = objectArray[n10];
        object5 = (TextView)object2;
        Object object6 = object2 = objectArray[2];
        object6 = (TextView)object2;
        Object object7 = object2 = objectArray[4];
        object7 = (TextView)object2;
        object2 = this;
        super(object, view, 1, (TextView)object4, (TextView)object5, (TextView)object6, (TextView)object7);
        this.i = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.g = object;
        object.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.setRootTag(view);
        super(this, n10);
        this.h = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(MediatorLiveData mediatorLiveData, int n10) {
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
    public void A(ActivationFailFragment$b activationFailFragment$b) {
        this.e = activationFailFragment$b;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 2;
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
    public void B(ActivationViewModel activationViewModel) {
        this.f = activationViewModel;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 4;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        ActivationFailFragment$b activationFailFragment$b = this.e;
        boolean bl2 = activationFailFragment$b != null;
        if (bl2) {
            activationFailFragment$b.a();
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
            var1_1 = this.i;
            this.i = var3_2 = 0L;
        }
        var5_3 = this.f;
        var6_4 = (long)13 & var1_1;
        var8_5 = var6_4 == var3_2 ? 0 : (var6_4 < var3_2 ? -1 : 1);
        if (var8_5 == false) ** GOTO lbl-1000
        var5_3 = var5_3 != null ? var5_3.u() : null;
        this.updateLiveDataRegistration(0, (LiveData)var5_3);
        if (var5_3 != null) {
            var5_3 = (String)var5_3.getValue();
        } else lbl-1000:
        // 2 sources

        {
            var5_3 = null;
        }
        if (var8_5 != false) {
            var9_6 = this.b;
            u.n(var9_6, (String)var5_3, null, null);
        }
        if ((var12_8 = (cfr_temp_0 = (var1_1 &= (var10_7 = (long)8)) - var3_2) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false) {
            var13_9 = this.c;
            var14_10 = this.h;
            var13_9.setOnClickListener(var14_10);
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
            this.i = l10 = (long)8;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (MediatorLiveData)object;
        return this.C((MediatorLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (ActivationFailFragment$b)object;
            this.A((ActivationFailFragment$b)object);
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

