/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.widget.RoundColorView;
import d.v.c.f1.a.b$a;
import d.v.c.w0.sc;
import d.v.c.x0.c.c.f;

public class tc
extends sc
implements b$a {
    private static final ViewDataBinding$IncludedLayouts h;
    private static final SparseIntArray i;
    private final ConstraintLayout d;
    private final RoundColorView e;
    private final View.OnClickListener f;
    private long g;

    public tc(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = h;
        SparseIntArray sparseIntArray = i;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 2, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private tc(DataBindingComponent object, View view, Object[] objectArray) {
        int n10 = 1;
        super(object, view, n10);
        this.g = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.d = object;
        object.setTag(null);
        object = (RoundColorView)((Object)objectArray[n10]);
        this.e = object;
        object.setTag(null);
        this.setRootTag(view);
        super(this, n10);
        this.f = object;
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
                long l10 = this.g;
                long l11 = 1L;
                this.g = l10 |= l11;
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
            long l10 = this.g;
            long l11 = 8;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(26);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(f f10) {
        this.c = f10;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 4;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(27);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(Integer n10) {
        this.b = n10;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 2;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(101);
        super.requestRebind();
    }

    public final void a(int n10, View object) {
        Integer n11 = this.b;
        object = this.c;
        Integer n12 = this.a;
        boolean bl2 = object != null;
        if (bl2) {
            n10 = n11;
            int n13 = n12;
            ((f)object).k(n10, n13);
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
            var1_1 = this.g;
            this.g = var3_2 = 0L;
        }
        var5_3 = this.b;
        var6_4 = this.c;
        var7_5 = this.a;
        var8_6 = (long)23 & var1_1;
        var10_7 = var8_6 == var3_2 ? 0 : (var8_6 < var3_2 ? -1 : 1);
        var11_8 = 0;
        if (var10_7 == false) ** GOTO lbl-1000
        var12_9 = null;
        if (var6_4 != null) {
            var6_4 = var6_4.f();
        } else {
            var13_10 = false;
            var6_4 = null;
        }
        this.updateLiveDataRegistration(0, (LiveData)var6_4);
        if (var6_4 != null) {
            var12_9 = var6_4 = var6_4.getValue();
            var12_9 = (Integer)var6_4;
        }
        if (var5_3 == var12_9) {
            var14_11 = true;
        } else lbl-1000:
        // 2 sources

        {
            var14_11 = false;
            var5_3 = null;
        }
        var15_12 = (long)24 & var1_1;
        var13_10 = var15_12 == var3_2 ? 0 : (var15_12 < var3_2 ? -1 : 1);
        if (var13_10) {
            var11_8 = ViewDataBinding.safeUnbox((Integer)var7_5);
        }
        if (var10_7 != false) {
            var7_5 = this.e;
            var7_5.setChecked(var14_11);
        }
        if (var13_10) {
            var5_3 = this.e;
            var5_3.setColor(var11_8);
        }
        if ((var19_14 = (cfr_temp_0 = (var1_1 &= (var17_13 = (long)16)) - var3_2) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false) {
            var20_15 = this.e;
            var21_16 = this.f;
            var20_15.setOnClickListener(var21_16);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.g;
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
            this.g = l10 = (long)16;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (MutableLiveData)object;
        return this.E((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 101;
        if (n11 == n10) {
            object = (Integer)object;
            this.D((Integer)object);
            return 1 != 0;
        } else {
            n11 = 27;
            if (n11 == n10) {
                object = (f)object;
                this.C((f)object);
                return 1 != 0;
            } else {
                n11 = 26;
                if (n11 != n10) return 0 != 0;
                object = (Integer)object;
                this.B((Integer)object);
            }
        }
        return 1 != 0;
    }
}

