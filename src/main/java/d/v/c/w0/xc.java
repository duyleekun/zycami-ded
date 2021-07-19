/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.zhiyun.cama.widget.RingProgressBar;
import com.zhiyun.cama.widget.RoundImageView;
import d.v.c.b2.v.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.wc;
import d.v.l.g.a;

public class xc
extends wc
implements b$a {
    private static final ViewDataBinding$IncludedLayouts m;
    private static final SparseIntArray n;
    private final ConstraintLayout f;
    private final View g;
    private final View h;
    private final RingProgressBar i;
    private final View.OnClickListener j;
    private final View.OnClickListener k;
    private long l;

    public xc(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = m;
        SparseIntArray sparseIntArray = n;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private xc(DataBindingComponent object, View object2, Object[] object3) {
        Object object4;
        Object object5;
        Object object6 = object5 = object3[5];
        object6 = (ImageView)object5;
        int n10 = 1;
        Object object7 = object4 = object3[n10];
        object7 = (RoundImageView)object4;
        object4 = this;
        DataBindingComponent dataBindingComponent = object;
        super(object, (View)object2, 2, (ImageView)object6, (RoundImageView)object7);
        this.l = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)object3[0]);
        this.f = object;
        object.setTag(null);
        int n11 = 2;
        dataBindingComponent = (View)object3[n11];
        this.g = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (View)object3[3];
        this.h = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.i = object3 = (RingProgressBar)((Object)object3[4]);
        object3.setTag(null);
        this.setRootTag((View)object2);
        super(this, n11);
        this.j = object2;
        super(this, n10);
        this.k = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(d.v.c.b2.w.a a10, int n10) {
        boolean bl2 = true;
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.l;
                long l11 = 1L;
                this.l = l10 |= l11;
                return bl2;
            }
        }
        int n11 = 42;
        if (n10 == n11) {
            synchronized (this) {
                long l12 = this.l;
                long l13 = 16;
                this.l = l12 |= l13;
                return bl2;
            }
        }
        n11 = 43;
        if (n10 == n11) {
            synchronized (this) {
                long l14 = this.l;
                long l15 = 32;
                this.l = l14 |= l15;
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
    private boolean F(MediatorLiveData mediatorLiveData, int n10) {
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
    public void B(Integer n10) {
        this.d = n10;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 4;
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
    public void C(d.v.c.b2.w.a a10) {
        this.updateRegistration(0, a10);
        this.c = a10;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 1L;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(114);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(b b10) {
        this.e = b10;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 8;
            this.l = l10 |= l11;
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
                Integer n14 = this.d;
                b b10 = this.e;
                d.v.c.b2.w.a a10 = this.c;
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
            Integer n16 = this.d;
            b b11 = this.e;
            d.v.c.b2.w.a a11 = this.c;
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
        block32: {
            block29: {
                block31: {
                    block30: {
                        var1_1 = this;
                        synchronized (this) {
                            var2_2 = this.l;
                            this.l = var4_3 = 0L;
                        }
                        var6_4 = this.d;
                        var7_5 = this.c;
                        var8_6 = this.e;
                        var9_7 = 78;
                        var11_8 = var2_2 & var9_7;
                        var13_9 = var11_8 == var4_3 ? 0 : (var11_8 < var4_3 ? -1 : 1);
                        var14_10 = 4;
                        var15_11 = 5.6E-45f;
                        var16_12 = 0;
                        var17_13 = null;
                        var18_14 = 0;
                        var19_15 = 0.0f;
                        if (var13_9 == false) ** GOTO lbl-1000
                        if (var8_6 != null) {
                            var8_6 = var8_6.g();
                        } else {
                            var20_16 /* !! */  = 0;
                            var8_6 = null;
                        }
                        var21_17 = 1;
                        var1_1.updateLiveDataRegistration(var21_17, (LiveData)var8_6);
                        if (var8_6 != null) {
                            var8_6 = (Integer)var8_6.getValue();
                        } else {
                            var20_16 /* !! */  = 0;
                            var8_6 = null;
                        }
                        if (var6_4 != var8_6) {
                            var21_17 = 0;
                        }
                        if (var13_9 != false) {
                            var22_18 = var21_17 != 0 ? 1024L : 512L;
                            var2_2 |= var22_18;
                        }
                        if (var21_17 == 0) {
                            var24_19 = var14_10;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var24_19 = 0;
                            var6_4 = null;
                        }
                        var20_16 /* !! */  = (cfr_temp_0 = ((long)113 & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
                        var25_20 = 81;
                        var27_21 = 97;
                        var29_22 = 65;
                        if (var20_16 /* !! */  == 0) break block29;
                        var31_23 = var2_2 & var29_22;
                        cfr_temp_1 = var31_23 - var4_3;
                        var20_16 /* !! */  = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                        if (var20_16 /* !! */  == 0) break block30;
                        if (var7_5 != null) {
                            var17_13 = var7_5.I();
                            var13_9 = (long)var7_5.J();
                        } else {
                            var13_9 = 0;
                            var33_24 /* !! */  = null;
                        }
                        if (var20_16 /* !! */  != 0) {
                            var31_23 = var13_9 != false ? 4096L : 2048L;
                            var2_2 |= var31_23;
                        }
                        if (var13_9 == false) break block31;
                    }
                    var14_10 = 0;
                    var34_25 = null;
                    var15_11 = 0.0f;
                }
                if ((var20_16 /* !! */  = (cfr_temp_2 = (var31_23 = var2_2 & var27_21) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != 0 && var7_5 != null) {
                    var20_16 /* !! */  = var7_5.t();
                } else {
                    var20_16 /* !! */  = 0;
                    var8_6 = null;
                }
                var31_23 = var2_2 & var25_20;
                var13_9 = var31_23 == var4_3 ? 0 : (var31_23 < var4_3 ? -1 : 1);
                if (var13_9 != false) {
                    if (var7_5 != null) {
                        var35_26 = (int)var7_5.z();
                    } else {
                        var35_26 = 0;
                        var7_5 = null;
                        var36_27 = 0.0f;
                    }
                    if (var13_9 != false) {
                        var31_23 = var35_26 != 0 ? 256L : 128L;
                        var2_2 |= var31_23;
                    }
                    if (var35_26 != 0) {
                        var35_26 = 8;
                        var36_27 = 1.1E-44f;
                        var18_14 = var35_26;
                        var19_15 = var36_27;
                    }
                }
                var37_29 = var17_13;
                var35_26 = var18_14;
                var36_27 = var19_15;
                var18_14 = var14_10;
                var19_15 = var15_11;
                break block32;
            }
            var37_29 = null;
            var35_26 = 0;
            var7_5 = null;
            var36_28 = 0.0f;
            var20_16 /* !! */  = 0;
            var8_6 = null;
        }
        var11_8 = var2_2 & var29_22;
        var13_9 = var11_8 == var4_3 ? 0 : (var11_8 < var4_3 ? -1 : 1);
        if (var13_9 != false) {
            var1_1.a.setVisibility(var18_14);
            var33_24 /* !! */  = var1_1.b;
            var34_25 = var33_24 /* !! */ .getContext();
            var16_12 = 2131231217;
            var38_30 = AppCompatResources.getDrawable(var34_25, var16_12);
            var39_31 = true;
            d.v.l.g.a.b(var33_24 /* !! */ , var37_29, null, var38_30, 0, var39_31, false, null, null, null);
        }
        if ((var13_9 = (cfr_temp_3 = (var11_8 = (long)64 & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) {
            var33_24 /* !! */  = var1_1.f;
            var34_25 = var1_1.k;
            var33_24 /* !! */ .setOnClickListener((View.OnClickListener)var34_25);
            var33_24 /* !! */  = var1_1.i;
            var34_25 = var1_1.j;
            var33_24 /* !! */ .setOnClickListener((View.OnClickListener)var34_25);
        }
        if ((var40_32 = (cfr_temp_4 = (var9_7 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) != false) {
            var41_33 = var1_1.g;
            var41_33.setVisibility(var24_19);
        }
        if ((var24_19 = (int)((cfr_temp_5 = (var9_7 = var2_2 & var25_20) - var4_3) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) != 0) {
            var1_1.h.setVisibility(var35_26);
            var6_4 = var1_1.i;
            var6_4.setVisibility(var35_26);
        }
        if ((var24_19 = (int)((cfr_temp_6 = (var2_2 &= var27_21) - var4_3) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.i;
            var6_4.setProgress(var20_16 /* !! */ );
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
            this.l = l10 = (long)64;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                return false;
            }
            object = (MediatorLiveData)object;
            return this.F((MediatorLiveData)object, n11);
        }
        object = (d.v.c.b2.w.a)object;
        return this.E((d.v.c.b2.w.a)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 101;
        if (n11 == n10) {
            object = (Integer)object;
            this.B((Integer)object);
            return 1 != 0;
        } else {
            n11 = 114;
            if (n11 == n10) {
                object = (d.v.c.b2.w.a)object;
                this.C((d.v.c.b2.w.a)object);
                return 1 != 0;
            } else {
                n11 = 115;
                if (n11 != n10) return 0 != 0;
                object = (b)object;
                this.D((b)object);
            }
        }
        return 1 != 0;
    }
}

