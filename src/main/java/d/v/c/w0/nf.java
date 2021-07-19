/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import d.v.c.w0.mf;
import l.a.q.g0.u;

public class nf
extends mf {
    private static final ViewDataBinding$IncludedLayouts n;
    private static final SparseIntArray o;
    private final ConstraintLayout k;
    private final View l;
    private long m;

    public nf(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = n;
        SparseIntArray sparseIntArray = o;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private nf(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[5];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[3];
        object4 = (TextView)object2;
        Object object5 = object2 = objectArray[4];
        object5 = (TextView)object2;
        Object object6 = object2 = objectArray[2];
        object6 = (TextView)object2;
        super(object, view, 0, (ImageView)object3, (TextView)object4, (TextView)object5, (TextView)object6);
        this.m = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.k = object;
        object.setTag(null);
        object = (View)objectArray[1];
        this.l = object;
        object.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(boolean bl2) {
        this.h = bl2;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 8;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(17);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(String string2) {
        this.i = string2;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 16;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(87);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void G(String string2) {
        this.e = string2;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 2;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(88);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void H(int n10) {
        this.g = n10;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 1L;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(101);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void I(boolean bl2) {
        this.j = bl2;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 4;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(121);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void J(String string2) {
        this.f = string2;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 32;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(140);
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
            var2_2 = this.m;
            this.m = var4_3 = 0L;
        }
        var6_4 = this.g;
        var7_5 = this.e;
        var8_6 = this.j;
        var9_7 = this.h;
        var10_8 = this.i;
        var11_9 = this.f;
        var12_10 = 65;
        var14_11 = var2_2 & var12_10;
        var16_12 = var14_11 == var4_3 ? 0 : (var14_11 < var4_3 ? -1 : 1);
        var17_13 = 4;
        var18_14 = 0;
        if (var16_12 == false) ** GOTO lbl-1000
        if (var6_4 == 0) {
            var6_4 = 1;
        } else {
            var6_4 = 0;
            var19_15 = null;
        }
        if (var16_12 != false) {
            var20_16 = var6_4 != 0 ? 1024L : 512L;
            var2_2 |= var20_16;
        }
        if (var6_4 != 0) {
            var6_4 = var17_13;
        } else lbl-1000:
        // 2 sources

        {
            var6_4 = 0;
            var19_15 = null;
        }
        var20_16 = 68;
        var22_17 = var2_2 & var20_16;
        var16_12 = var22_17 == var4_3 ? 0 : (var22_17 < var4_3 ? -1 : 1);
        if (var16_12 == false) ** GOTO lbl-1000
        if (var16_12 != false) {
            var22_17 = var8_6 != 0 ? 4096L : 2048L;
            var2_2 |= var22_17;
        }
        if (var8_6 == 0) {
            var8_6 = 8;
        } else lbl-1000:
        // 2 sources

        {
            var8_6 = 0;
            var24_18 = null;
        }
        var22_17 = 72;
        var25_19 = var2_2 & var22_17;
        var16_12 = var25_19 == var4_3 ? 0 : (var25_19 < var4_3 ? -1 : 1);
        if (var16_12 != false) {
            if (var16_12 != false) {
                var25_19 = var9_7 != false ? 256L : 128L;
                var2_2 |= var25_19;
            }
            if (var9_7) {
                var17_13 = 0;
                var27_20 = null;
            }
            var18_14 = var17_13;
        }
        var9_7 = (cfr_temp_0 = ((long)80 & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
        var14_11 = (long)96 & var2_2;
        var16_12 = var14_11 == var4_3 ? 0 : (var14_11 < var4_3 ? -1 : 1);
        cfr_temp_1 = (var22_17 = var2_2 & var22_17) - var4_3;
        var17_13 = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
        if (var17_13 != 0) {
            var27_20 = var1_1.a;
            var27_20.setVisibility(var18_14);
        }
        if ((var28_21 = (cfr_temp_2 = (var12_10 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
            var29_22 = var1_1.l;
            var29_22.setVisibility(var6_4);
        }
        if ((var6_4 = (int)((cfr_temp_3 = (var12_10 = var2_2 & var20_16) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) != 0) {
            var19_15 = var1_1.b;
            var19_15.setVisibility(var8_6);
        }
        var6_4 = 0;
        var19_15 = null;
        if (var9_7) {
            var24_18 = var1_1.b;
            u.n(var24_18, var10_8, null, null);
        }
        if (var16_12 != false) {
            var24_18 = var1_1.c;
            u.n(var24_18, var11_9, null, null);
        }
        if ((var32_24 = (cfr_temp_4 = (var2_2 &= (var30_23 = (long)66)) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) != false) {
            var33_25 = var1_1.d;
            u.n(var33_25, var7_5, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.m;
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
            this.m = l10 = (long)64;
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
        int n11 = 101;
        if (n11 == n10) {
            object = (Integer)object;
            n10 = (Integer)object;
            this.H(n10);
            return 1 != 0;
        } else {
            n11 = 88;
            if (n11 == n10) {
                object = (String)object;
                this.G((String)object);
                return 1 != 0;
            } else {
                n11 = 121;
                if (n11 == n10) {
                    object = (Boolean)object;
                    n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                    this.I(n10 != 0);
                    return 1 != 0;
                } else {
                    n11 = 17;
                    if (n11 == n10) {
                        object = (Boolean)object;
                        n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                        this.E(n10 != 0);
                        return 1 != 0;
                    } else {
                        n11 = 87;
                        if (n11 == n10) {
                            object = (String)object;
                            this.F((String)object);
                            return 1 != 0;
                        } else {
                            n11 = 140;
                            if (n11 != n10) return 0 != 0;
                            object = (String)object;
                            this.J((String)object);
                        }
                    }
                }
            }
        }
        return 1 != 0;
    }
}

