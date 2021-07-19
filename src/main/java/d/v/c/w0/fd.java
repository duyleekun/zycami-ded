/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
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
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.zhiyun.cama.widget.RingProgressBar;
import d.v.c.b2.v.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.ed;
import d.v.l.g.a;
import l.a.q.g0.u;

public class fd
extends ed
implements b$a {
    private static final ViewDataBinding$IncludedLayouts o;
    private static final SparseIntArray p;
    private final ConstraintLayout i;
    private final ImageView j;
    private final View k;
    private final View.OnClickListener l;
    private final View.OnClickListener m;
    private long n;

    public fd(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = o;
        SparseIntArray sparseIntArray = p;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private fd(DataBindingComponent object, View object2, Object[] view) {
        Object object3;
        Object object4 = object3 = view[6];
        object4 = (ImageView)object3;
        Object object5 = object3 = view[5];
        object5 = (TextView)object3;
        Object object6 = object3 = view[3];
        object6 = (View)object3;
        Object object7 = object3 = view[4];
        object7 = (RingProgressBar)((Object)object3);
        fd fd2 = this;
        super(object, (View)object2, 3, (ImageView)object4, (TextView)object5, (View)object6, (RingProgressBar)((Object)object7));
        this.n = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)view[0]);
        this.i = object;
        object.setTag(null);
        int n10 = 1;
        fd2 = (ImageView)view[n10];
        this.j = fd2;
        fd2.setTag(null);
        int n11 = 2;
        this.k = view = (View)view[n11];
        view.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.setRootTag((View)object2);
        super(this, n11);
        this.l = object2;
        super(this, n10);
        this.m = object2;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean G(ObservableList observableList, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.n;
                long l11 = 2;
                this.n = l10 |= l11;
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
    private boolean H(d.v.c.b2.w.a a10, int n10) {
        boolean bl2 = true;
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.n;
                long l11 = 1L;
                this.n = l10 |= l11;
                return bl2;
            }
        }
        int n11 = 42;
        if (n10 == n11) {
            synchronized (this) {
                long l12 = this.n;
                long l13 = 32;
                this.n = l12 |= l13;
                return bl2;
            }
        }
        n11 = 43;
        if (n10 == n11) {
            synchronized (this) {
                long l14 = this.n;
                long l15 = 64;
                this.n = l14 |= l15;
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
    private boolean I(MediatorLiveData mediatorLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.n;
                long l11 = 4;
                this.n = l10 |= l11;
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
    public void C(ObservableList observableList) {
        int n10 = 1;
        this.updateRegistration(n10, observableList);
        this.f = observableList;
        synchronized (this) {
            long l10 = this.n;
            long l11 = 2;
            this.n = l10 |= l11;
        }
        this.notifyPropertyChanged(78);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(Integer n10) {
        this.g = n10;
        synchronized (this) {
            long l10 = this.n;
            long l11 = 8;
            this.n = l10 |= l11;
        }
        this.notifyPropertyChanged(101);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(d.v.c.b2.w.a a10) {
        this.updateRegistration(0, a10);
        this.e = a10;
        synchronized (this) {
            long l10 = this.n;
            long l11 = 1L;
            this.n = l10 |= l11;
        }
        this.notifyPropertyChanged(114);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(b b10) {
        this.h = b10;
        synchronized (this) {
            long l10 = this.n;
            long l11 = 16;
            this.n = l10 |= l11;
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
                b b10 = this.h;
                d.v.c.b2.w.a a10 = this.e;
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
            b b11 = this.h;
            d.v.c.b2.w.a a11 = this.e;
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
        block47: {
            block46: {
                block45: {
                    block44: {
                        block43: {
                            var1_1 = this;
                            synchronized (this) {
                                var2_2 = this.n;
                                this.n = var4_3 = 0L;
                            }
                            var6_4 = this.g;
                            var7_5 = this.e;
                            var8_6 /* !! */  = this.f;
                            var9_7 /* !! */  = this.h;
                            var10_8 = 158L & var2_2;
                            var12_9 = var10_8 == var4_3 ? 0 : (var10_8 < var4_3 ? -1 : 1);
                            var13_10 = 2131165374;
                            var14_11 = 136L;
                            var16_12 = 138L;
                            var18_13 = 1;
                            var19_14 = 1.4E-45f;
                            if (var12_9 == false || (var12_9 = (cfr_temp_0 = (var20_15 = var2_2 & var16_12) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) == false) break block43;
                            var12_9 = ViewDataBinding.safeUnbox((Integer)var6_4);
                            var20_15 = var2_2 & var14_11;
                            cfr_temp_1 = var20_15 - var4_3;
                            var22_16 /* !! */  = (long)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                            if (var22_16 /* !! */  == false) break block44;
                            if (var12_9 == false) {
                                var23_17 = var18_13;
                            } else {
                                var23_17 = 0;
                                var24_18 = null;
                            }
                            if (var22_16 /* !! */  != false) {
                                var25_19 = var23_17 != false ? 2048L : 1024L;
                                var2_2 |= var25_19;
                            }
                            if (var23_17 == false) break block44;
                            var27_20 = var1_1.i.getResources();
                            var28_22 = var27_20.getDimension(var13_10);
                            break block45;
                        }
                        var12_9 = 0;
                        var29_23 = null;
                    }
                    var28_22 = 0.0f;
                    var27_21 = null;
                }
                var30_24 = var2_2 & 225L;
                var23_17 = var30_24 == var4_3 ? 0 : (var30_24 < var4_3 ? -1 : 1);
                var25_19 = 161L;
                var32_25 = 193L;
                var34_26 = 129L;
                if (var23_17 == false) break block46;
                var36_27 = var2_2 & var34_26;
                cfr_temp_2 = var36_27 - var4_3;
                var38_28 /* !! */  = (int)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
                if (var38_28 /* !! */  != 0) {
                    if (var7_5 != null) {
                        var24_18 = var7_5.I();
                        var39_29 /* !! */  = var7_5.G();
                        var40_30 = var7_5.J();
                    } else {
                        var40_30 = 0;
                        var41_32 = null;
                        var23_17 = 0;
                        var24_18 = null;
                        var42_33 = false;
                        var39_29 /* !! */  = null;
                    }
                    if (var38_28 /* !! */  != 0) {
                        var43_34 = var40_30 != 0 ? 131072L : 65536L;
                        var2_2 |= var43_34;
                    }
                    var38_28 /* !! */  = var40_30 != 0 ? 0 : 4;
                } else {
                    var38_28 /* !! */  = 0;
                    var23_17 = 0;
                    var24_18 = null;
                    var42_33 = false;
                    var39_29 /* !! */  = null;
                }
                var45_35 = var2_2 & var32_25;
                var40_30 = var45_35 == var4_3 ? 0 : (var45_35 < var4_3 ? -1 : 1);
                if (var40_30 != 0 && var7_5 != null) {
                    var40_30 = var7_5.t();
                } else {
                    var40_30 = 0;
                    var41_32 = null;
                }
                var43_34 = var2_2 & var25_19;
                var47_36 = var43_34 == var4_3 ? 0 : (var43_34 < var4_3 ? -1 : 1);
                if (var47_36 == false) ** GOTO lbl-1000
                if (var7_5 != null) {
                    var48_37 = var7_5.z();
                } else {
                    var48_37 = 0;
                    var7_5 = null;
                }
                if (var47_36 != false) {
                    var43_34 = var48_37 != 0 ? 8192L : 4096L;
                    var2_2 |= var43_34;
                }
                if (var48_37 != 0) {
                    var48_37 = 8;
                } else lbl-1000:
                // 2 sources

                {
                    var48_37 = 0;
                    var7_5 = null;
                }
                var49_38 = var39_29 /* !! */ ;
                var50_39 = var40_30;
                var41_32 = var24_18;
                break block47;
            }
            var48_37 = 0;
            var7_5 = null;
            var38_28 /* !! */  = 0;
            var50_39 = 0;
            var49_38 = null;
            var40_31 = false;
            var41_32 = null;
        }
        var43_34 = var2_2 & var16_12;
        var42_33 = var43_34 == var4_3 ? 0 : (var43_34 < var4_3 ? -1 : 1);
        if (var42_33) {
            if (var8_6 /* !! */  != null) {
                var51_40 = var8_6 /* !! */ .size();
            } else {
                var51_40 = 0;
                var8_6 /* !! */  = null;
                var52_41 = 0.0f;
            }
            if (var12_9 == (var51_40 += -1)) {
                var51_40 = var18_13;
                var52_41 = var19_14;
            } else {
                var51_40 = 0;
                var8_6 /* !! */  = null;
                var52_41 = 0.0f;
            }
            if (var42_33) {
                var43_34 = var51_40 != 0 ? 32768L : 16384L;
                var2_2 |= var43_34;
            }
            if (var51_40 != 0) {
                var8_6 /* !! */  = var1_1.i.getResources();
                var52_41 = var8_6 /* !! */ .getDimension(var13_10);
            } else {
                var8_6 /* !! */  = var1_1.i.getResources();
                var12_9 = 2131165360;
                var52_41 = var8_6 /* !! */ .getDimension((int)var12_9);
            }
        } else {
            var51_40 = 0;
            var52_41 = 0.0f;
            var8_6 /* !! */  = null;
        }
        var10_8 = 156L;
        var43_34 = var2_2 & var10_8;
        var22_16 /* !! */  = var43_34 == var4_3 ? 0 : (var43_34 < var4_3 ? -1 : 1);
        if (var22_16 /* !! */  != false) {
            if (var9_7 /* !! */  != null) {
                var9_7 /* !! */  = var9_7 /* !! */ .g();
            } else {
                var53_42 = 0;
                var9_7 /* !! */  = null;
            }
            var12_9 = 2;
            var1_1.updateLiveDataRegistration((int)var12_9, (LiveData)var9_7 /* !! */ );
            if (var9_7 /* !! */  != null) {
                var9_7 /* !! */  = (Integer)var9_7 /* !! */ .getValue();
            } else {
                var53_42 = 0;
                var9_7 /* !! */  = null;
            }
            if (var9_7 /* !! */  != var6_4) {
                var18_13 = 0;
                var19_14 = 0.0f;
            }
            if (var22_16 /* !! */  != false) {
                var54_43 = var18_13 != 0 ? 512L : 256L;
                var2_2 |= var54_43;
            }
            var6_4 = var1_1.c.getContext();
            var53_42 = var18_13 != 0 ? 2131232057 : 2131232059;
            var6_4 = AppCompatResources.getDrawable((Context)var6_4, var53_42);
        } else {
            var56_44 = false;
            var6_4 = null;
        }
        var54_43 = var2_2 & var34_26;
        var53_42 = var54_43 == var4_3 ? 0 : (var54_43 < var4_3 ? -1 : 1);
        if (var53_42 != 0) {
            var1_1.a.setVisibility(var38_28 /* !! */ );
            var9_7 /* !! */  = var1_1.j;
            var47_36 = 0;
            var29_23 = var9_7 /* !! */ .getContext();
            var13_10 = 2131231047;
            var57_45 = AppCompatResources.getDrawable(var29_23, var13_10);
            var58_46 = true;
            var39_29 /* !! */  = var9_7 /* !! */ ;
            d.v.l.g.a.b((ImageView)var9_7 /* !! */ , var41_32, null, var57_45, 0, var58_46, false, null, null, null);
            var9_7 /* !! */  = var1_1.b;
            var12_9 = 0;
            var29_23 = null;
            u.n((TextView)var9_7 /* !! */ , var49_38, null, null);
        }
        if ((var53_42 = (cfr_temp_3 = (var54_43 = 128L & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != 0) {
            var9_7 /* !! */  = var1_1.i;
            var29_23 = var1_1.m;
            var9_7 /* !! */ .setOnClickListener((View.OnClickListener)var29_23);
            var9_7 /* !! */  = var1_1.d;
            var29_23 = var1_1.l;
            var9_7 /* !! */ .setOnClickListener((View.OnClickListener)var29_23);
        }
        if ((var53_42 = (cfr_temp_4 = (var54_43 = 136L & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) != 0) {
            var9_7 /* !! */  = var1_1.i;
            ViewBindingAdapter.setPaddingStart((View)var9_7 /* !! */ , var28_22);
        }
        if ((var53_42 = (int)((cfr_temp_5 = (var54_43 = var2_2 & var16_12) - var4_3) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) != 0) {
            var9_7 /* !! */  = var1_1.i;
            ViewBindingAdapter.setPaddingEnd((View)var9_7 /* !! */ , var52_41);
        }
        if ((var51_40 = (int)((cfr_temp_6 = (var59_47 = var2_2 & var25_19) - var4_3) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1))) != 0) {
            var1_1.k.setVisibility(var48_37);
            var8_6 /* !! */  = var1_1.d;
            var8_6 /* !! */ .setVisibility(var48_37);
        }
        if ((var48_37 = (int)((cfr_temp_7 = (var61_48 = 156L & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1))) != 0) {
            var7_5 = var1_1.c;
            ViewBindingAdapter.setBackground((View)var7_5, (Drawable)var6_4);
        }
        if (var56_44 = (cfr_temp_8 = (var2_2 &= var32_25) - var4_3) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1)) {
            var6_4 = var1_1.d;
            var6_4.setProgress(var50_39);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.n;
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
            this.n = l10 = 128L;
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
                object = (MediatorLiveData)object;
                return this.I((MediatorLiveData)object, n11);
            }
            object = (ObservableList)object;
            return this.G((ObservableList)object, n11);
        }
        object = (d.v.c.b2.w.a)object;
        return this.H((d.v.c.b2.w.a)object, n11);
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
            n11 = 114;
            if (n11 == n10) {
                object = (d.v.c.b2.w.a)object;
                this.E((d.v.c.b2.w.a)object);
                return 1 != 0;
            } else {
                n11 = 78;
                if (n11 == n10) {
                    object = (ObservableList)object;
                    this.C((ObservableList)object);
                    return 1 != 0;
                } else {
                    n11 = 115;
                    if (n11 != n10) return 0 != 0;
                    object = (b)object;
                    this.F((b)object);
                }
            }
        }
        return 1 != 0;
    }
}

