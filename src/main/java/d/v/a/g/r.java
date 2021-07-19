/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.a.g;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.zhiyun.account.R$color;
import d.v.a.d;
import d.v.a.g.q;
import l.a.q.g0.u;

public class r
extends q {
    private static final ViewDataBinding$IncludedLayouts h;
    private static final SparseIntArray i;
    private final LinearLayout f;
    private long g;

    public r(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = h;
        SparseIntArray sparseIntArray = i;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private r(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[2];
        object2 = (TextView)object;
        Object object3 = object = objectArray[1];
        object3 = (View)object;
        super(dataBindingComponent, view, 0, (TextView)object2, (View)object3);
        this.g = -1;
        dataBindingComponent = (LinearLayout)objectArray[0];
        this.f = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(String string2) {
        this.c = string2;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 4;
            this.g = l10 |= l11;
        }
        int n10 = d.v.a.d.m0;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(int n10) {
        this.d = n10;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 1L;
            this.g = l10 |= l11;
        }
        n10 = d.v.a.d.r0;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(boolean bl2) {
        this.e = bl2;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 2;
            this.g = l10 |= l11;
        }
        bl2 = d.v.a.d.u0;
        this.notifyPropertyChanged((int)(bl2 ? 1 : 0));
        super.requestRebind();
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
        var5_3 = this.d;
        var6_4 = this.e;
        var7_5 = this.c;
        var8_6 = 9;
        var10_7 = var1_1 & var8_6;
        var12_8 = var10_7 == var3_2 ? 0 : (var10_7 < var3_2 ? -1 : 1);
        var13_9 = 0;
        var14_10 = null;
        if (var12_8 == false) ** GOTO lbl-1000
        var5_3 = var5_3 == 0 ? 1 : 0;
        if (var12_8 != false) {
            var15_11 = var5_3 != 0 ? 512L : 256L;
            var1_1 |= var15_11;
        }
        if (var5_3 != 0) {
            var5_3 = 4;
        } else lbl-1000:
        // 2 sources

        {
            var5_3 = 0;
        }
        var15_11 = 10;
        var17_12 = var1_1 & var15_11;
        var12_8 = var17_12 == var3_2 ? 0 : (var17_12 < var3_2 ? -1 : 1);
        if (var12_8 != false) {
            if (var12_8 != false) {
                if (var6_4 != 0) {
                    var1_1 |= (long)32;
                    var10_7 = 128L;
                } else {
                    var1_1 |= (long)16;
                    var10_7 = 64;
                }
                var1_1 |= var10_7;
            }
            var19_13 = this.a;
            var13_9 = var6_4 != 0 ? R$color.com_color_white : R$color.com_color_black;
            var12_8 = ViewDataBinding.getColorFromResource((View)var19_13, var13_9);
            var13_9 = (int)var12_8;
            if (var6_4 != 0) {
                var20_14 = this.b;
                var12_8 = R$color.com_color_white_10;
            } else {
                var20_14 = this.b;
                var12_8 = R$color.com_color_account_divider;
            }
            var6_4 = ViewDataBinding.getColorFromResource(var20_14, (int)var12_8);
        } else {
            var6_4 = 0;
            var20_14 = null;
        }
        var17_12 = (long)12 & var1_1;
        var12_8 = var17_12 == var3_2 ? 0 : (var17_12 < var3_2 ? -1 : 1);
        cfr_temp_0 = (var15_11 &= var1_1) - var3_2;
        var21_15 = cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
        if (var21_15 != false) {
            var22_16 = this.a;
            var22_16.setTextColor(var13_9);
            var14_10 = this.b;
            var20_14 = Converters.convertColorToDrawable(var6_4);
            ViewBindingAdapter.setBackground(var14_10, (Drawable)var20_14);
        }
        if (var12_8 != false) {
            var20_14 = this.a;
            var12_8 = 0;
            var19_13 = null;
            u.n((TextView)var20_14, var7_5, null, null);
        }
        if ((var23_17 = (cfr_temp_1 = (var1_1 &= var8_6) - var3_2) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
            var24_18 = this.b;
            var24_18.setVisibility(var5_3);
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
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = d.v.a.d.r0;
        if (n11 == n10) {
            object = (Integer)object;
            n10 = (Integer)object;
            this.C(n10);
            return 1 != 0;
        } else {
            n11 = d.v.a.d.u0;
            if (n11 == n10) {
                object = (Boolean)object;
                n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                this.D(n10 != 0);
                return 1 != 0;
            } else {
                n11 = d.v.a.d.m0;
                if (n11 != n10) return 0 != 0;
                object = (String)object;
                this.B((String)object);
            }
        }
        return 1 != 0;
    }
}

