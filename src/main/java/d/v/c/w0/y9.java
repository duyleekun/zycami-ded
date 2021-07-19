/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ViewBindingAdapter;
import d.v.c.w0.x9;
import l.a.q.g0.u;

public class y9
extends x9 {
    private static final ViewDataBinding$IncludedLayouts h;
    private static final SparseIntArray i;
    private final ConstraintLayout f;
    private long g;

    public y9(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = h;
        SparseIntArray sparseIntArray = i;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private y9(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[2];
        object3 = (TextView)object2;
        Object object4 = object2 = objectArray[1];
        object4 = (TextView)object2;
        super(object, view, 3, (TextView)object3, (TextView)object4);
        this.g = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.f = object;
        object.setTag(null);
        this.b.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(ObservableBoolean observableBoolean, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.g;
                long l11 = 4;
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
    private boolean F(ObservableBoolean observableBoolean, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.g;
                long l11 = 2;
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
    private boolean G(ObservableField observableField, int n10) {
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
    public void B(ObservableBoolean observableBoolean) {
        int n10 = 2;
        this.updateRegistration(n10, observableBoolean);
        this.d = observableBoolean;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 4;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(4);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(ObservableBoolean observableBoolean) {
        int n10 = 1;
        this.updateRegistration(n10, observableBoolean);
        this.c = observableBoolean;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 2;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(65);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(ObservableField observableField) {
        this.updateRegistration(0, observableField);
        this.e = observableField;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 1L;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(141);
        super.requestRebind();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        var1_1 = this;
        synchronized (this) {
            var2_2 = this.g;
            this.g = var4_3 = 0L;
        }
        var6_4 = this.e;
        var7_5 = this.c;
        var8_6 = this.d;
        var9_7 = 9;
        var11_8 = var2_2 & var9_7;
        var13_9 = var11_8 == var4_3 ? 0 : (var11_8 < var4_3 ? -1 : 1);
        var6_4 = var13_9 != false && var6_4 != null ? (String)var6_4.get() : null;
        var14_10 = 10;
        var16_11 = var2_2 & var14_10;
        var13_9 = var16_11 == var4_3 ? 0 : (var16_11 < var4_3 ? -1 : 1);
        var18_12 = false;
        var19_13 = null;
        if (var13_9 == false) ** GOTO lbl-1000
        if (var7_5 != null) {
            var20_14 = var7_5.get();
        } else {
            var20_14 = 0;
            var7_5 = null;
        }
        if (var13_9 != false) {
            var21_15 = var20_14 != 0 ? 128L : (long)64;
            var2_2 |= var21_15;
        }
        if (var20_14 == 0) {
            var20_14 = 8;
        } else lbl-1000:
        // 2 sources

        {
            var20_14 = 0;
            var7_5 = null;
        }
        var21_15 = 12;
        var23_16 = var2_2 & var21_15;
        var13_9 = var23_16 == var4_3 ? 0 : (var23_16 < var4_3 ? -1 : 1);
        if (var13_9 != false) {
            if (var8_6 != null) {
                var18_12 = var8_6.get();
            }
            if (var13_9 != false) {
                if (var18_12) {
                    var2_2 |= (long)32;
                    var23_16 = 512L;
                } else {
                    var2_2 |= (long)16;
                    var23_16 = 256L;
                }
                var2_2 |= var23_16;
            }
            if (var18_12) {
                var8_6 = var1_1.a.getContext();
                var13_9 = 2131231976;
                var8_6 = AppCompatResources.getDrawable((Context)var8_6, (int)var13_9);
            } else {
                var25_17 = false;
                var8_6 = null;
            }
            var26_18 = var18_12 ? "@string/cancel" : "@string/select_all";
        } else {
            var25_17 = false;
            var8_6 = null;
            var13_9 = 0;
            var26_18 = null;
        }
        var16_11 = var2_2 & var21_15;
        var18_12 = var16_11 == var4_3 ? 0 : (var16_11 < var4_3 ? -1 : 1);
        if (var18_12) {
            var19_13 = var1_1.a;
            ViewBindingAdapter.setBackground((View)var19_13, (Drawable)var8_6);
            var8_6 = var1_1.a;
            u.n((TextView)var8_6, var26_18, null, null);
        }
        if (var25_17 = (cfr_temp_0 = (var14_10 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) {
            var8_6 = var1_1.a;
            var8_6.setVisibility(var20_14);
        }
        if ((var27_19 = (cfr_temp_1 = (var2_2 &= var9_7) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
            var28_20 = var1_1.b;
            u.n(var28_20, (String)var6_4, null, null);
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
            this.g = l10 = (long)8;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
                if (n10 != n12) {
                    return false;
                }
                object = (ObservableBoolean)object;
                return this.E((ObservableBoolean)object, n11);
            }
            object = (ObservableBoolean)object;
            return this.F((ObservableBoolean)object, n11);
        }
        object = (ObservableField)object;
        return this.G((ObservableField)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 141;
        if (n11 == n10) {
            object = (ObservableField)object;
            this.D((ObservableField)object);
            return 1 != 0;
        } else {
            n11 = 65;
            if (n11 == n10) {
                object = (ObservableBoolean)object;
                this.C((ObservableBoolean)object);
                return 1 != 0;
            } else {
                n11 = 4;
                if (n11 != n10) return 0 != 0;
                object = (ObservableBoolean)object;
                this.B((ObservableBoolean)object);
            }
        }
        return 1 != 0;
    }
}

