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
import d.v.c.w0.gc;
import d.v.l.g.a;

public class hc
extends gc
implements b$a {
    private static final ViewDataBinding$IncludedLayouts n;
    private static final SparseIntArray o;
    private final ConstraintLayout f;
    private final View g;
    private final View h;
    private final ConstraintLayout i;
    private final RingProgressBar j;
    private final View.OnClickListener k;
    private final View.OnClickListener l;
    private long m;

    public hc(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = n;
        SparseIntArray sparseIntArray = o;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private hc(DataBindingComponent object, View object2, Object[] object3) {
        Object object4;
        Object object5;
        Object object6 = object5 = object3[6];
        object6 = (ImageView)object5;
        int n10 = 1;
        Object object7 = object4 = object3[n10];
        object7 = (RoundImageView)object4;
        object4 = this;
        Object object8 = object;
        super(object, (View)object2, 2, (ImageView)object6, (RoundImageView)object7);
        this.m = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)object3[0]);
        this.f = object;
        object.setTag(null);
        int n11 = 2;
        object8 = (View)object3[n11];
        this.g = object8;
        object8.setTag(null);
        object8 = (View)object3[3];
        this.h = object8;
        object8.setTag(null);
        object8 = (ConstraintLayout)((Object)object3[4]);
        this.i = object8;
        object8.setTag(null);
        this.j = object3 = (RingProgressBar)((Object)object3[5]);
        object3.setTag(null);
        this.setRootTag((View)object2);
        super(this, n11);
        this.k = object2;
        super(this, n10);
        this.l = object;
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
                long l10 = this.m;
                long l11 = 2;
                this.m = l10 |= l11;
                return bl2;
            }
        }
        int n11 = 42;
        if (n10 == n11) {
            synchronized (this) {
                long l12 = this.m;
                long l13 = 16;
                this.m = l12 |= l13;
                return bl2;
            }
        }
        n11 = 43;
        if (n10 == n11) {
            synchronized (this) {
                long l14 = this.m;
                long l15 = 32;
                this.m = l14 |= l15;
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
                long l10 = this.m;
                long l11 = 1L;
                this.m = l10 |= l11;
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
        this.e = n10;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 8;
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
    public void C(d.v.c.b2.w.a a10) {
        int n10 = 1;
        this.updateRegistration(n10, a10);
        this.c = a10;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 2;
            this.m = l10 |= l11;
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
        this.d = b10;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 4;
            this.m = l10 |= l11;
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
                Integer n14 = this.e;
                b b10 = this.d;
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
            Integer n16 = this.e;
            b b11 = this.d;
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
        block30: {
            block31: {
                var1_1 = this;
                synchronized (this) {
                    var2_2 = this.m;
                    this.m = var4_3 = 0L;
                }
                var6_4 = this.d;
                var7_5 = this.e;
                var8_6 /* !! */  = this.c;
                var9_7 = 77;
                var11_8 = var2_2 & var9_7;
                var13_9 = var11_8 == var4_3 ? 0 : (var11_8 < var4_3 ? -1 : 1);
                var14_10 = 4;
                var15_11 = 5.6E-45f;
                var16_12 = 0;
                var17_13 = null;
                var18_14 = 0;
                if (var13_9 == false) ** GOTO lbl-1000
                if (var6_4 != null) {
                    var6_4 = var6_4.g();
                } else {
                    var19_15 = 0;
                    var6_4 = null;
                }
                var1_1.updateLiveDataRegistration(0, (LiveData)var6_4);
                if (var6_4 != null) {
                    var6_4 = (Integer)var6_4.getValue();
                } else {
                    var19_15 = 0;
                    var6_4 = null;
                }
                if (var7_5 == var6_4) {
                    var19_15 = 1;
                } else {
                    var19_15 = 0;
                    var6_4 = null;
                }
                if (var13_9 != false) {
                    var20_16 = var19_15 != 0 ? 256L : 128L;
                    var2_2 |= var20_16;
                }
                if (var19_15 == 0) {
                    var19_15 = var14_10;
                } else lbl-1000:
                // 2 sources

                {
                    var19_15 = 0;
                    var6_4 = null;
                }
                var22_17 /* !! */  = (cfr_temp_0 = ((long)114 & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
                var20_16 = 82;
                var23_18 = 98;
                var25_19 = 66;
                if (var22_17 /* !! */  == false) break block31;
                var27_20 = var2_2 & var23_18;
                cfr_temp_1 = var27_20 - var4_3;
                var22_17 /* !! */  = (long)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                if (var22_17 /* !! */  != false && var8_6 /* !! */  != null) {
                    var22_17 /* !! */  = var8_6 /* !! */ .t();
                } else {
                    var22_17 /* !! */  = 0;
                    var7_5 = null;
                }
                var27_20 = var2_2 & var25_19;
                var13_9 = var27_20 == var4_3 ? 0 : (var27_20 < var4_3 ? -1 : 1);
                if (var13_9 == false) ** GOTO lbl-1000
                if (var8_6 /* !! */  != null) {
                    var17_13 = var8_6 /* !! */ .I();
                    var29_21 = var8_6 /* !! */ .J();
                } else {
                    var29_21 = false;
                }
                if (var13_9 != false) {
                    var30_22 = var29_21 != false ? 4096L : 2048L;
                    var2_2 |= var30_22;
                }
                if (!var29_21) {
                    var13_9 = var14_10;
                } else lbl-1000:
                // 2 sources

                {
                    var13_9 = 0;
                    var32_23 = null;
                }
                var27_20 = var2_2 & var20_16;
                var29_21 = var27_20 == var4_3 ? 0 : (var27_20 < var4_3 ? -1 : 1);
                if (var29_21) {
                    if (var8_6 /* !! */  != null) {
                        var33_24 = (long)var8_6 /* !! */ .z();
                    } else {
                        var33_24 = 0;
                        var8_6 /* !! */  = null;
                    }
                    if (var29_21) {
                        var27_20 = var33_24 != false ? 1024L : 512L;
                        var2_2 |= var27_20;
                    }
                    if (var33_24 == false) {
                        var14_10 = 0;
                        var15_11 = 0.0f;
                    }
                    var18_14 = (int)var13_9;
                    var34_25 = var17_13;
                    break block30;
                } else {
                    var34_25 = var17_13;
                    var14_10 = 0;
                    var15_11 = 0.0f;
                    var18_14 = (int)var13_9;
                }
                break block30;
            }
            var34_25 = null;
            var22_17 /* !! */  = 0;
            var7_5 = null;
            var14_10 = 0;
            var15_11 = 0.0f;
        }
        var25_19 = var2_2 & var25_19;
        var33_24 = var25_19 == var4_3 ? 0 : (var25_19 < var4_3 ? -1 : 1);
        if (var33_24 != false) {
            var1_1.a.setVisibility(var18_14);
            var8_6 /* !! */  = var1_1.b;
            var32_23 = var8_6 /* !! */ .getContext();
            var16_12 = 2131231217;
            var35_26 = AppCompatResources.getDrawable(var32_23, var16_12);
            var36_27 = true;
            d.v.l.g.a.b((ImageView)var8_6 /* !! */ , var34_25, null, var35_26, 0, var36_27, false, null, null, null);
        }
        if ((var33_24 = (cfr_temp_2 = (var37_28 = (long)64 & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
            var8_6 /* !! */  = var1_1.f;
            var32_23 = var1_1.l;
            var8_6 /* !! */ .setOnClickListener((View.OnClickListener)var32_23);
            var8_6 /* !! */  = var1_1.i;
            var32_23 = var1_1.k;
            var8_6 /* !! */ .setOnClickListener((View.OnClickListener)var32_23);
        }
        if ((var33_24 = (cfr_temp_3 = (var37_28 = var2_2 & var20_16) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) {
            var1_1.g.setVisibility(var14_10);
            var1_1.i.setVisibility(var14_10);
            var8_6 /* !! */  = var1_1.j;
            var8_6 /* !! */ .setVisibility(var14_10);
        }
        if ((var33_24 = (cfr_temp_4 = (var39_29 = var2_2 & var9_7) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) != false) {
            var8_6 /* !! */  = var1_1.h;
            var8_6 /* !! */ .setVisibility(var19_15);
        }
        if ((var19_15 = (int)((cfr_temp_5 = (var2_2 &= var23_18) - var4_3) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.j;
            var6_4.setProgress((int)var22_17 /* !! */ );
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
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                return false;
            }
            object = (d.v.c.b2.w.a)object;
            return this.E((d.v.c.b2.w.a)object, n11);
        }
        object = (MediatorLiveData)object;
        return this.F((MediatorLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 115;
        if (n11 == n10) {
            object = (b)object;
            this.D((b)object);
            return 1 != 0;
        } else {
            n11 = 101;
            if (n11 == n10) {
                object = (Integer)object;
                this.B((Integer)object);
                return 1 != 0;
            } else {
                n11 = 114;
                if (n11 != n10) return 0 != 0;
                object = (d.v.c.b2.w.a)object;
                this.C((d.v.c.b2.w.a)object);
            }
        }
        return 1 != 0;
    }
}

