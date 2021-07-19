/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
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
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.widget.RoundImageView;
import com.zhiyun.cama.widget.ZYTextView;
import com.zhiyun.editorinterface.edit.MediaType;
import d.v.c.k1.a.w;
import d.v.c.w0.ob;
import d.v.e.l.l2;
import d.v.f.e.b;
import d.v.l.g.a;
import l.a.q.g0.u;

public class pb
extends ob {
    private static final ViewDataBinding$IncludedLayouts m;
    private static final SparseIntArray n;
    private final ConstraintLayout h;
    private final View i;
    private final ZYTextView j;
    private final ZYTextView k;
    private long l;

    public pb(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = m;
        SparseIntArray sparseIntArray = n;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private pb(DataBindingComponent object, View view, Object[] objectArray) {
        RoundImageView roundImageView = (RoundImageView)objectArray[1];
        int n10 = 3;
        super(object, view, n10, roundImageView);
        this.l = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.h = object;
        object.setTag(null);
        object = (View)objectArray[2];
        this.i = object;
        object.setTag(null);
        object = (ZYTextView)objectArray[n10];
        this.j = object;
        object.setTag(null);
        object = (ZYTextView)objectArray[4];
        this.k = object;
        object.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean K(ObservableBoolean observableBoolean, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.l;
                long l11 = 4;
                this.l = l10 |= l11;
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
    private boolean L(ObservableInt observableInt, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.l;
                long l11 = 2;
                this.l = l10 |= l11;
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
    private boolean M(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.l;
                long l11 = 1L;
                this.l = l10 |= l11;
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
    public void E(ObservableBoolean observableBoolean) {
        int n10 = 2;
        this.updateRegistration(n10, observableBoolean);
        this.b = observableBoolean;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 4;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(8);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(Boolean bl2) {
        this.g = bl2;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 32;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(73);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void G(d.v.h.e.a a10) {
        this.e = a10;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 64;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(83);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void H(Integer n10) {
        this.d = n10;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 16;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(101);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void I(ObservableInt observableInt) {
        int n10 = 1;
        this.updateRegistration(n10, observableInt);
        this.c = observableInt;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 2;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(102);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void J(w w10) {
        this.f = w10;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 8;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(150);
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
            var2_2 = this.l;
            this.l = var4_3 = 0L;
        }
        var6_4 = this.c;
        var7_5 = this.b;
        var8_6 = this.f;
        var9_7 = this.d;
        var10_8 = this.g;
        var11_9 /* !! */  = this.e;
        var12_10 = 210L;
        var14_11 = var2_2 & var12_10;
        var16_12 /* !! */  = var14_11 == var4_3 ? 0 : (var14_11 < var4_3 ? -1 : 1);
        var17_13 = 192L;
        var19_14 = 146L;
        var21_15 = 1;
        var22_16 = 1.4E-45f;
        var23_17 = 0;
        var24_18 = null;
        if (var16_12 /* !! */  != false) {
            if (var6_4 != null) {
                var25_19 = var6_4.get();
            } else {
                var25_19 = 0;
                var6_4 = null;
            }
            var26_20 = ViewDataBinding.safeUnbox(var9_7);
            var27_21 = var11_9 /* !! */  != null ? var11_9 /* !! */ .i() : null;
            var28_22 = var2_2 & var19_14;
            var30_23 = var28_22 == var4_3 ? 0 : (var28_22 < var4_3 ? -1 : 1);
            var30_23 = var30_23 != false && var25_19 != var26_20 ? (long)var21_15 : (long)0;
            if (var25_19 == var26_20) {
                var25_19 = var21_15;
            } else {
                var25_19 = 0;
                var6_4 = null;
            }
            if (var16_12 /* !! */  != false) {
                var31_24 = var25_19 != 0 ? 131072L : 65536L;
                var2_2 |= var31_24;
            }
            if ((var26_20 = (int)((cfr_temp_0 = (var31_24 = var2_2 & var19_14) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) != 0) {
                var31_24 = var25_19 != 0 ? 0x800000L : 0x400000L;
                var2_2 |= var31_24;
            }
            var9_7 = var1_1.a.getContext();
            var16_12 /* !! */  = var25_19 != 0 ? (long)2131232083 : (long)2131232077;
            var9_7 = AppCompatResources.getDrawable((Context)var9_7, (int)var16_12 /* !! */ );
            var31_24 = var2_2 & var19_14;
            cfr_temp_1 = var31_24 - var4_3;
            var16_12 /* !! */  = (long)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
            if (var16_12 /* !! */  != false) {
                if (var25_19 != 0) {
                    var6_4 = var1_1.k;
                    var16_12 /* !! */  = 2131099761;
                } else {
                    var6_4 = var1_1.k;
                    var16_12 /* !! */  = 2131099772;
                }
                var25_19 = ViewDataBinding.getColorFromResource((View)var6_4, (int)var16_12 /* !! */ );
            } else {
                var25_19 = 0;
                var6_4 = null;
            }
            var31_24 = var2_2 & var17_13;
            var16_12 /* !! */  = var31_24 == var4_3 ? 0 : (var31_24 < var4_3 ? -1 : 1);
            if (var16_12 /* !! */  != false) {
                var31_24 = var11_9 /* !! */  != null ? var11_9 /* !! */ .d() : var4_3;
                var33_25 = l2.d(var31_24);
                var17_13 = var31_24;
                var34_26 = String.valueOf(l2.a(var31_24, var21_15));
                var35_27 = new StringBuilder();
                var35_27.append(var34_26);
                var36_28 = 'S';
                var35_27.append(var36_28);
                var34_26 = var35_27.toString();
                var37_31 = var9_7;
                var38_32 = var27_21;
                var26_20 = (int)var30_23;
            } else {
                var37_31 = var9_7;
                var38_32 = var27_21;
                var26_20 = (int)var30_23;
                var16_12 /* !! */  = 0;
                var33_25 = null;
                var36_29 = false;
                var34_26 = null;
            }
        } else {
            var25_19 = 0;
            var6_4 = null;
            var26_20 = 0;
            var9_7 = null;
            var16_12 /* !! */  = 0;
            var33_25 = null;
            var36_30 = false;
            var34_26 = null;
            var38_32 = null;
            var37_31 = null;
        }
        var39_33 = 132L;
        cfr_temp_2 = (var2_2 & var39_33) - var4_3;
        var41_34 = cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1);
        var31_24 = 2048L;
        var42_35 = 1024L;
        var44_36 = 8;
        var45_37 = 1.1E-44f;
        if (var41_34 != false) {
            var46_38 = var7_5 != null ? var7_5.get() : 0;
            if (var41_34 != false) {
                var2_2 = var46_38 != 0 ? (var2_2 |= var31_24) : (var2_2 |= var42_35);
            }
            if (var46_38 != 0) {
                var41_34 = 0;
                var35_27 = null;
            } else {
                var41_34 = var44_36;
            }
        } else {
            var41_34 = 0;
            var35_27 = null;
            var46_38 = 0;
        }
        var47_39 = 237L;
        var49_40 = var2_2 & var47_39;
        var51_41 = var49_40 == var4_3 ? 0 : (var49_40 < var4_3 ? -1 : 1);
        var52_42 = 4096L;
        var54_43 = 173L;
        if (var51_41 != false) {
            var56_44 /* !! */  = ViewDataBinding.safeUnbox((Boolean)var10_8);
            if (var51_41 != false) {
                var57_45 = var56_44 /* !! */  != false ? 512L : 256L;
                var2_2 |= var57_45;
            }
            if ((var51_41 = (cfr_temp_3 = (var57_45 = var2_2 & var54_43) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) {
                if (var56_44 /* !! */ ) {
                    var57_45 = 8192L;
                    var2_2 |= var57_45;
                } else {
                    var2_2 |= var52_42;
                }
            }
        } else {
            var56_44 /* !! */  = false;
            var10_8 = null;
        }
        var51_41 = (cfr_temp_4 = (var2_2 & 4352L) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1);
        var57_45 = 32768L;
        if (var51_41 != false) {
            if (var8_6 != null) {
                var8_6 = var8_6.F();
            } else {
                var59_46 = 0;
                var8_6 = null;
            }
            var1_1.updateLiveDataRegistration(0, (LiveData)var8_6);
            if (var8_6 != null) {
                var8_6 = (Boolean)var8_6.getValue();
            } else {
                var59_46 = 0;
                var8_6 = null;
            }
            var59_46 = (int)ViewDataBinding.safeUnbox((Boolean)var8_6);
            var60_47 = var2_2 & var52_42;
            var51_41 = var60_47 == var4_3 ? 0 : (var60_47 < var4_3 ? -1 : 1);
            if (var51_41 != false) {
                if (var59_46 != 0) {
                    var2_2 |= var57_45;
                } else {
                    var60_47 = 16384L;
                    var2_2 |= var60_47;
                }
            }
        } else {
            var59_46 = 0;
            var8_6 = null;
        }
        var51_41 = (cfr_temp_5 = (var2_2 & var47_39) - var4_3) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1);
        var60_47 = 262144L;
        if (var51_41 != false) {
            var62_48 = var56_44 /* !! */  != false ? var21_15 : var59_46;
            if (var51_41 != false) {
                if (var62_48 != 0) {
                    var63_49 = 524288L;
                    var2_2 |= var63_49;
                } else {
                    var2_2 |= var60_47;
                }
            }
        } else {
            var62_48 = 0;
        }
        var51_41 = (cfr_temp_6 = (var2_2 & var57_45) - var4_3) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1);
        var57_45 = 0x200000L;
        var63_49 = 0x100000L;
        var65_50 = 0x1008000L;
        if (var51_41 == false) ** GOTO lbl-1000
        if (var7_5 != null) {
            var46_38 = var7_5.get();
        }
        if ((var51_41 = (cfr_temp_7 = (var67_51 = var2_2 & var39_33) - var4_3) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1)) != false) {
            var2_2 = var46_38 != 0 ? (var2_2 |= var31_24) : (var2_2 |= var42_35);
        }
        var51_41 = var46_38 ^ 1;
        var67_51 = var2_2 & var65_50;
        cfr_temp_8 = var67_51 - var4_3;
        var69_52 /* !! */  = (long)(cfr_temp_8 == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1));
        if (var69_52 /* !! */  != false) {
            var2_2 = var51_41 != false ? (var2_2 |= var57_45) : (var2_2 |= var63_49);
        }
        if (var51_41 == false) {
            var51_41 = var44_36;
        } else lbl-1000:
        // 2 sources

        {
            var51_41 = 0;
        }
        var60_47 = var2_2 & var60_47;
        var70_53 = var60_47 == var4_3 ? 0 : (var60_47 < var4_3 ? -1 : 1);
        if (var70_53 == false) ** GOTO lbl-1000
        if (var11_9 /* !! */  != null) {
            var11_9 /* !! */  = var11_9 /* !! */ .f();
        } else {
            var71_54 = 0;
            var11_9 /* !! */  = null;
        }
        var24_18 = MediaType.VIDEO;
        if (var11_9 /* !! */  != var24_18) {
            var71_54 = var21_15;
        } else lbl-1000:
        // 2 sources

        {
            var71_54 = 0;
            var11_9 /* !! */  = null;
        }
        var52_42 = var2_2 & var52_42;
        var23_17 = var52_42 == var4_3 ? 0 : (var52_42 < var4_3 ? -1 : 1);
        if (var23_17 != 0) {
            var59_46 = var59_46 != 0 ? (int)var51_41 : var44_36;
        } else {
            var59_46 = 0;
            var8_6 = null;
        }
        var23_17 = (cfr_temp_9 = (var2_2 & var47_39) - var4_3) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1);
        var52_42 = 0x1000000L;
        if (var23_17 != 0) {
            if (var62_48 != 0) {
                var71_54 = var21_15;
            }
            if (var23_17 != 0) {
                if (var71_54 != 0) {
                    var72_55 = 0x2000000L;
                    var2_2 |= var72_55;
                } else {
                    var2_2 |= var52_42;
                }
            }
        } else {
            var71_54 = 0;
            var11_9 /* !! */  = null;
        }
        if ((var23_17 = (cfr_temp_10 = (var72_55 = var2_2 & var54_43) - var4_3) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1)) != 0) {
            if (var56_44 /* !! */ ) {
                var59_46 = var44_36;
            }
        } else {
            var59_46 = 0;
            var8_6 = null;
        }
        if (var56_44 /* !! */  = (cfr_temp_11 = (var52_42 = var2_2 & var52_42) - var4_3) == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1)) {
            if (var7_5 != null) {
                var46_38 = var7_5.get();
            }
            if ((var74_56 = (cfr_temp_12 = (var49_40 = var2_2 & var39_33) - var4_3) == 0L ? 0 : (cfr_temp_12 < 0L ? -1 : 1)) != false) {
                var2_2 = var46_38 != 0 ? (var2_2 |= var31_24) : (var2_2 |= var42_35);
            }
            var74_56 = var46_38 ^ 1;
            var12_10 = var2_2 & var65_50;
            cfr_temp_13 = var12_10 - var4_3;
            var56_44 /* !! */  = cfr_temp_13 == 0L ? 0 : (cfr_temp_13 < 0L ? -1 : 1);
            if (var56_44 /* !! */ ) {
                var2_2 = var74_56 != false ? (var2_2 |= var57_45) : (var2_2 |= var63_49);
            }
            var51_41 = var74_56 != false ? (long)0 : (long)var44_36;
        }
        if ((var74_56 = (cfr_temp_14 = (var12_10 = var2_2 & var47_39) - var4_3) == 0L ? 0 : (cfr_temp_14 < 0L ? -1 : 1)) != false) {
            var23_17 = var71_54 != 0 ? var44_36 : (int)var51_41;
            var75_57 = 210L;
        } else {
            var75_57 = 210L;
            var23_17 = 0;
            var24_18 = null;
        }
        var56_44 /* !! */  = (cfr_temp_15 = (var75_57 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_15 < 0L ? -1 : 1);
        if (var56_44 /* !! */ ) {
            var10_8 = var1_1.a;
            var46_38 = 0;
            var77_58 = true;
            var51_41 = 0;
            d.v.l.g.a.b((ImageView)var10_8, var38_32, null, (Drawable)var37_31, 0, var77_58, false, null, null, null);
        }
        if (var56_44 /* !! */  = (cfr_temp_16 = (var75_57 = var2_2 & var39_33) - var4_3) == 0L ? 0 : (cfr_temp_16 < 0L ? -1 : 1)) {
            var10_8 = var1_1.i;
            var10_8.setVisibility((int)var41_34);
        }
        if (var74_56 != false) {
            var7_5 = var1_1.j;
            var7_5.setVisibility(var23_17);
        }
        if ((var74_56 = (cfr_temp_17 = (var75_57 = 192L & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_17 < 0L ? -1 : 1)) != false) {
            var7_5 = var1_1.j;
            var56_44 /* !! */  = false;
            var10_8 = null;
            u.n((TextView)var7_5, var33_25, null, null);
            var7_5 = var1_1.k;
            u.n((TextView)var7_5, var34_26, null, null);
        }
        if ((var74_56 = (cfr_temp_18 = (var75_57 = var2_2 & var19_14) - var4_3) == 0L ? 0 : (cfr_temp_18 < 0L ? -1 : 1)) != false) {
            var7_5 = var1_1.k;
            var7_5.setTextColor(var25_19);
            var6_4 = var1_1.k;
            var74_56 = ViewDataBinding.getColorFromResource((View)var6_4, 2131099745);
            d.v.f.e.b.b((TextView)var6_4, (boolean)var26_20, (int)var74_56);
        }
        if ((var25_19 = (int)((cfr_temp_19 = (var2_2 &= var54_43) - var4_3) == 0L ? 0 : (cfr_temp_19 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.k;
            var6_4.setVisibility(var59_46);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.l;
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
            this.l = l10 = 128L;
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
                return this.K((ObservableBoolean)object, n11);
            }
            object = (ObservableInt)object;
            return this.L((ObservableInt)object, n11);
        }
        object = (MutableLiveData)object;
        return this.M((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 102;
        if (n11 == n10) {
            object = (ObservableInt)object;
            this.I((ObservableInt)object);
            return 1 != 0;
        } else {
            n11 = 8;
            if (n11 == n10) {
                object = (ObservableBoolean)object;
                this.E((ObservableBoolean)object);
                return 1 != 0;
            } else {
                n11 = 150;
                if (n11 == n10) {
                    object = (w)object;
                    this.J((w)object);
                    return 1 != 0;
                } else {
                    n11 = 101;
                    if (n11 == n10) {
                        object = (Integer)object;
                        this.H((Integer)object);
                        return 1 != 0;
                    } else {
                        n11 = 73;
                        if (n11 == n10) {
                            object = (Boolean)object;
                            this.F((Boolean)object);
                            return 1 != 0;
                        } else {
                            n11 = 83;
                            if (n11 != n10) return 0 != 0;
                            object = (d.v.h.e.a)object;
                            this.G((d.v.h.e.a)object);
                        }
                    }
                }
            }
        }
        return 1 != 0;
    }
}

