/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.zhiyun.cama.widget.RingProgressBar;
import com.zhiyun.cama.widget.RoundImageView;
import d.v.c.b2.v.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.ba;
import d.v.l.g.a;
import l.a.q.g0.u;

public class ca
extends ba
implements b$a {
    private static final ViewDataBinding$IncludedLayouts p;
    private static final SparseIntArray q;
    private final ConstraintLayout k;
    private final View l;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private long o;

    public ca(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = p;
        SparseIntArray sparseIntArray = q;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private ca(DataBindingComponent object, View object2, Object[] view) {
        Object object3;
        Object object4;
        Object object5 = object4 = view[6];
        object5 = (ImageView)object4;
        int n10 = 1;
        Object object6 = object3 = view[n10];
        object6 = (RoundImageView)object3;
        Object object7 = object3 = view[5];
        object7 = (TextView)object3;
        Object object8 = object3 = view[3];
        object8 = (View)object3;
        Object object9 = object3 = view[4];
        object9 = (RingProgressBar)((Object)object3);
        object3 = this;
        super(object, (View)object2, 3, (ImageView)object5, (RoundImageView)object6, (TextView)object7, (View)object8, (RingProgressBar)((Object)object9));
        this.o = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)view[0]);
        this.k = object;
        object.setTag(null);
        int n11 = 2;
        this.l = view = (View)view[n11];
        view.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.setRootTag((View)object2);
        super(this, n11);
        this.m = object2;
        super(this, n10);
        this.n = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean I(d.v.c.b2.w.a a10, int n10) {
        boolean bl2 = true;
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.o;
                long l11 = 4;
                this.o = l10 |= l11;
                return bl2;
            }
        }
        int n11 = 42;
        if (n10 == n11) {
            synchronized (this) {
                long l12 = this.o;
                long l13 = 64;
                this.o = l12 |= l13;
                return bl2;
            }
        }
        n11 = 43;
        if (n10 == n11) {
            synchronized (this) {
                long l14 = this.o;
                long l15 = 128L;
                this.o = l14 |= l15;
                return bl2;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean J(ObservableList observableList, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.o;
                long l11 = 1L;
                this.o = l10 |= l11;
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
    private boolean K(MediatorLiveData mediatorLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.o;
                long l11 = 2;
                this.o = l10 |= l11;
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
    public void D(d.v.c.b2.w.a a10) {
        int n10 = 2;
        this.updateRegistration(n10, a10);
        this.f = a10;
        synchronized (this) {
            long l10 = this.o;
            long l11 = 4;
            this.o = l10 |= l11;
        }
        this.notifyPropertyChanged(6);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(Boolean bl2) {
        this.j = bl2;
        synchronized (this) {
            long l10 = this.o;
            long l11 = 8;
            this.o = l10 |= l11;
        }
        this.notifyPropertyChanged(35);
        super.requestRebind();
    }

    public void F(ObservableList observableList) {
        this.h = observableList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void G(Integer n10) {
        this.g = n10;
        synchronized (this) {
            long l10 = this.o;
            long l11 = 16;
            this.o = l10 |= l11;
        }
        this.notifyPropertyChanged(101);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void H(b b10) {
        this.i = b10;
        synchronized (this) {
            long l10 = this.o;
            long l11 = 32;
            this.o = l10 |= l11;
        }
        this.notifyPropertyChanged(115);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                Integer n14 = this.g;
                b b10 = this.i;
                d.v.c.b2.w.a a10 = this.f;
                int n15 = a10 != null ? n12 : 0;
                if (n15 != 0) {
                    n15 = (int)(a10.z() ? 1 : 0);
                    if (n15 != 0) {
                        if (b10 != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            n10 = n14;
                            b10.i(n10);
                        }
                    } else {
                        n10 = a10.t();
                        if (n10 == 0) {
                            n10 = n12;
                        } else {
                            n10 = 0;
                            n14 = null;
                        }
                        if (n10 != 0) {
                            if (b10 != null) {
                                n11 = n12;
                            }
                            if (n11 != 0) {
                                b10.c(a10);
                            }
                        }
                    }
                }
            }
        } else {
            boolean bl2;
            Integer n16 = this.g;
            b b11 = this.i;
            d.v.c.b2.w.a a11 = this.f;
            int n17 = a11 != null ? n12 : 0;
            if (n17 != 0 && (bl2 = a11.z())) {
                if (b11 != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    n10 = n16;
                    b11.i(n10);
                }
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
        block43: {
            block44: {
                block41: {
                    block42: {
                        var1_1 = this;
                        synchronized (this) {
                            var2_2 = this.o;
                            this.o = var4_3 = 0L;
                        }
                        var6_4 = this.j;
                        var7_5 = this.g;
                        var8_6 /* !! */  = this.i;
                        var9_7 = this.f;
                        var10_8 = 264L;
                        var12_9 = var2_2 & var10_8;
                        var14_10 = var12_9 == var4_3 ? 0 : (var12_9 < var4_3 ? -1 : 1);
                        if (var14_10 == false) ** GOTO lbl-1000
                        var15_11 = ViewDataBinding.safeUnbox((Boolean)var6_4);
                        if (var14_10 != false) {
                            var16_12 = var15_11 != 0 ? 4096L : 2048L;
                            var2_2 |= var16_12;
                        }
                        if (var15_11 == 0) {
                            var15_11 = 8;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var15_11 = 0;
                            var6_4 = null;
                        }
                        var16_12 = 306L;
                        var18_13 = var2_2 & var16_12;
                        var14_10 = var18_13 == var4_3 ? 0 : (var18_13 < var4_3 ? -1 : 1);
                        var20_14 = 1;
                        if (var14_10 == false) ** GOTO lbl-1000
                        if (var8_6 /* !! */  != null) {
                            var8_6 /* !! */  = var8_6 /* !! */ .g();
                        } else {
                            var21_15 /* !! */  = 0;
                            var8_6 /* !! */  = null;
                        }
                        var1_1.updateLiveDataRegistration(var20_14, (LiveData)var8_6 /* !! */ );
                        if (var8_6 /* !! */  != null) {
                            var8_6 /* !! */  = (Integer)var8_6 /* !! */ .getValue();
                        } else {
                            var21_15 /* !! */  = 0;
                            var8_6 /* !! */  = null;
                        }
                        if (var7_5 == var8_6 /* !! */ ) {
                            var22_16 = var20_14;
                        } else {
                            var22_16 = 0;
                            var7_5 = null;
                        }
                        if (var14_10 != false) {
                            var23_17 = var22_16 != 0 ? 16384L : 8192L;
                            var2_2 |= var23_17;
                        }
                        if (var22_16 == 0) {
                            var22_16 = 4;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var22_16 = 0;
                            var7_5 = null;
                        }
                        var21_15 /* !! */  = (cfr_temp_0 = (var2_2 & 452L) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
                        var23_17 = 388L;
                        var25_18 = 324L;
                        var27_19 = 65536L;
                        var29_20 = 260L;
                        if (var21_15 /* !! */  == 0) break block41;
                        var31_21 = var2_2 & var29_20;
                        cfr_temp_1 = var31_21 - var4_3;
                        var21_15 /* !! */  = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                        if (var21_15 /* !! */  != 0) {
                            if (var9_7 != null) {
                                var33_22 = var9_7.G();
                                var34_23 /* !! */  = var9_7.H();
                                var35_24 = var9_7.J();
                            } else {
                                var14_10 = 0;
                                var33_22 = null;
                                var34_23 /* !! */  = null;
                                var35_24 = false;
                                var36_25 = null;
                            }
                            if (var21_15 /* !! */  != 0) {
                                var37_26 = var35_24 != false ? 262144L : 131072L;
                                var2_2 |= var37_26;
                            }
                            if (var34_23 /* !! */  != null) {
                                var20_14 = 0;
                            }
                            if (var35_24) {
                                var21_15 /* !! */  = 0;
                                var8_6 /* !! */  = null;
                            } else {
                                var21_15 /* !! */  = 4;
                            }
                            var39_27 = var2_2 & var29_20;
                            var35_24 = var39_27 == var4_3 ? 0 : (var39_27 < var4_3 ? -1 : 1);
                            if (var35_24) {
                                if (var20_14 != 0) {
                                    var2_2 |= var27_19;
                                } else {
                                    var39_27 = 32768L;
                                    var2_2 |= var39_27;
                                }
                            }
                        } else {
                            var14_10 = 0;
                            var33_22 = null;
                            var34_23 /* !! */  = null;
                            var21_15 /* !! */  = 0;
                            var8_6 /* !! */  = null;
                            var20_14 = 0;
                        }
                        if (!(var35_24 = (cfr_temp_2 = (var39_27 = var2_2 & var25_18) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) ** GOTO lbl-1000
                        if (var9_7 != null) {
                            var41_28 = var9_7.z();
                        } else {
                            var41_28 = false;
                            var42_30 = null;
                        }
                        if (var35_24) {
                            var43_31 = var41_28 != false ? 1024L : 512L;
                            var2_2 |= var43_31;
                        }
                        if (var41_28) {
                            var45_32 = 4;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var45_32 = 0;
                        }
                        var39_27 = var2_2 & var23_17;
                        var35_24 = var39_27 == var4_3 ? 0 : (var39_27 < var4_3 ? -1 : 1);
                        if (!var35_24 || var9_7 == null) break block42;
                        var47_34 = var46_33 = var9_7.t();
                        var48_35 = var45_32;
                        var42_30 = var34_23 /* !! */ ;
                        break block43;
                    }
                    var48_35 = var45_32;
                    var42_30 = var34_23 /* !! */ ;
                    break block44;
                }
                var14_10 = 0;
                var33_22 = null;
                var41_29 = false;
                var42_30 = null;
                var21_15 /* !! */  = 0;
                var8_6 /* !! */  = null;
                var20_14 = 0;
                var48_35 = 0;
            }
            var47_34 = 0;
        }
        var27_19 = var2_2 & var27_19;
        var49_36 = var27_19 == var4_3 ? 0 : (var27_19 < var4_3 ? -1 : 1);
        var9_7 = var49_36 != false && var9_7 != null ? var9_7.I() : null;
        var27_19 = var2_2 & var29_20;
        var49_36 = var27_19 == var4_3 ? 0 : (var27_19 < var4_3 ? -1 : 1);
        if (var49_36 != false) {
            if (var20_14 == 0) {
                var9_7 = null;
            }
            var36_25 = var9_7;
        } else {
            var35_24 = false;
            var36_25 = null;
        }
        if (var49_36 != false) {
            var1_1.a.setVisibility(var21_15 /* !! */ );
            var8_6 /* !! */  = var1_1.b;
            var9_7 = var8_6 /* !! */ .getContext();
            var20_14 = 2131231217;
            var50_37 = AppCompatResources.getDrawable((Context)var9_7, var20_14);
            var51_38 = true;
            var34_23 /* !! */  = var8_6 /* !! */ ;
            d.v.l.g.a.b((ImageView)var8_6 /* !! */ , var36_25, var42_30, var50_37, 0, var51_38, false, null, null, null);
            var8_6 /* !! */  = var1_1.c;
            u.n((TextView)var8_6 /* !! */ , var33_22, null, null);
        }
        if ((var21_15 /* !! */  = (int)((cfr_temp_3 = (var52_39 = 256L & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) != 0) {
            var8_6 /* !! */  = var1_1.k;
            var9_7 = var1_1.n;
            var8_6 /* !! */ .setOnClickListener((View.OnClickListener)var9_7);
            var8_6 /* !! */  = var1_1.e;
            var9_7 = var1_1.m;
            var8_6 /* !! */ .setOnClickListener((View.OnClickListener)var9_7);
        }
        if ((var21_15 /* !! */  = (int)((cfr_temp_4 = (var52_39 = var2_2 & var25_18) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) != 0) {
            var1_1.l.setVisibility(var48_35);
            var8_6 /* !! */  = var1_1.e;
            var8_6 /* !! */ .setVisibility(var48_35);
        }
        if ((var21_15 /* !! */  = (int)((cfr_temp_5 = (var52_39 = var2_2 & var10_8) - var4_3) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) != 0) {
            var8_6 /* !! */  = var1_1.c;
            var8_6 /* !! */ .setVisibility(var15_11);
        }
        if ((var15_11 = (int)((cfr_temp_6 = (var52_39 = 306L & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.d;
            var6_4.setVisibility(var22_16);
        }
        if ((var15_11 = (int)((cfr_temp_7 = (var2_2 &= var23_17) - var4_3) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.e;
            var6_4.setProgress(var47_34);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.o;
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
            this.o = l10 = 256L;
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
                object = (d.v.c.b2.w.a)object;
                return this.I((d.v.c.b2.w.a)object, n11);
            }
            object = (MediatorLiveData)object;
            return this.K((MediatorLiveData)object, n11);
        }
        object = (ObservableList)object;
        return this.J((ObservableList)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 35;
        if (n11 == n10) {
            object = (Boolean)object;
            this.E((Boolean)object);
            return 1 != 0;
        } else {
            n11 = 101;
            if (n11 == n10) {
                object = (Integer)object;
                this.G((Integer)object);
                return 1 != 0;
            } else {
                n11 = 78;
                if (n11 == n10) {
                    object = (ObservableList)object;
                    this.F((ObservableList)object);
                    return 1 != 0;
                } else {
                    n11 = 115;
                    if (n11 == n10) {
                        object = (b)object;
                        this.H((b)object);
                        return 1 != 0;
                    } else {
                        n11 = 6;
                        if (n11 != n10) return 0 != 0;
                        object = (d.v.c.b2.w.a)object;
                        this.D((d.v.c.b2.w.a)object);
                    }
                }
            }
        }
        return 1 != 0;
    }
}

