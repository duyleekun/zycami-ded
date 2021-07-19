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
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.zhiyun.cama.widget.RingProgressBar;
import com.zhiyun.cama.widget.RoundImageView;
import d.v.c.b2.v.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.ab;
import d.v.l.g.a;
import l.a.q.g0.u;

public class bb
extends ab
implements b$a {
    private static final ViewDataBinding$IncludedLayouts o;
    private static final SparseIntArray p;
    private final ConstraintLayout j;
    private final View k;
    private final View.OnClickListener l;
    private final View.OnClickListener m;
    private long n;

    public bb(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = o;
        SparseIntArray sparseIntArray = p;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private bb(DataBindingComponent object, View object2, Object[] view) {
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
        this.n = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)view[0]);
        this.j = object;
        object.setTag(null);
        int n11 = 2;
        this.k = view = (View)view[n11];
        view.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.setRootTag((View)object2);
        super(this, n11);
        this.l = object2;
        super(this, n10);
        this.m = object;
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
        this.h = observableList;
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
            long l11 = 16;
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
        this.f = a10;
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
        this.i = b10;
        synchronized (this) {
            long l10 = this.n;
            long l11 = 8;
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
        block56: {
            block59: {
                block63: {
                    block62: {
                        block60: {
                            block61: {
                                block58: {
                                    block57: {
                                        var1_1 = this;
                                        synchronized (this) {
                                            var2_2 = this.n;
                                            this.n = var4_3 = 0L;
                                        }
                                        var6_4 = this.f;
                                        var7_5 = this.i;
                                        var8_6 = this.g;
                                        var9_7 = this.h;
                                        var10_8 = 241L & var2_2;
                                        var12_9 /* !! */  = var10_8 == var4_3 ? 0 : (var10_8 < var4_3 ? -1 : 1);
                                        var13_10 = 193L;
                                        var15_11 = 161L;
                                        var17_12 = 129L;
                                        var19_13 = 145L;
                                        var21_14 = 0;
                                        if (var12_9 /* !! */  == false) break block57;
                                        var22_15 = var2_2 & var19_13;
                                        cfr_temp_0 = var22_15 - var4_3;
                                        var12_9 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                        if (var12_9 /* !! */  != false && var6_4 != null) {
                                            var24_16 = var6_4.H();
                                        } else {
                                            var12_9 /* !! */  = 0;
                                            var24_16 = null;
                                        }
                                        var22_15 = var2_2 & var17_12;
                                        var25_17 = var22_15 == var4_3 ? 0 : (var22_15 < var4_3 ? -1 : 1);
                                        if (var25_17 != false) {
                                            if (var6_4 != null) {
                                                var26_18 = var6_4.G();
                                                var27_19 = var6_4.J();
                                            } else {
                                                var27_19 = 0;
                                                var28_21 = null;
                                                var26_18 = null;
                                            }
                                            if (var25_17 != false) {
                                                var29_22 = var27_19 != 0 ? 0x200000L : 0x100000L;
                                                var2_2 |= var29_22;
                                            }
                                            var25_17 = var27_19 != 0 ? (long)0 : (long)4;
                                        } else {
                                            var25_17 = 0;
                                            var26_18 = null;
                                        }
                                        var31_23 = var2_2 & var15_11;
                                        var27_19 = var31_23 == var4_3 ? 0 : (var31_23 < var4_3 ? -1 : 1);
                                        if (var27_19 == 0) ** GOTO lbl-1000
                                        if (var6_4 != null) {
                                            var33_24 = var6_4.z();
                                        } else {
                                            var33_24 = 0;
                                            var34_25 = null;
                                            var35_26 = 0.0f;
                                        }
                                        if (var27_19 != 0) {
                                            var36_27 = var33_24 != 0 ? 32768L : 16384L;
                                            var2_2 |= var36_27;
                                        }
                                        if (var33_24 != 0) {
                                            var27_19 = 8;
                                        } else lbl-1000:
                                        // 2 sources

                                        {
                                            var27_19 = 0;
                                            var28_21 = null;
                                        }
                                        var29_22 = var2_2 & var13_10;
                                        var33_24 = var29_22 == var4_3 ? 0 : (var29_22 < var4_3 ? -1 : 1);
                                        if (var33_24 != 0 && var6_4 != null) {
                                            var33_24 = var6_4.t();
                                            var38_28 = var26_18;
                                            var39_29 = var27_19;
                                            var40_30 = var33_24;
                                        } else {
                                            var40_30 = 0;
                                            var38_28 = var26_18;
                                            var39_29 = var27_19;
                                        }
                                        var28_21 = var24_16;
                                        var12_9 /* !! */  = var25_17;
                                        break block58;
                                    }
                                    var12_9 /* !! */  = 0;
                                    var24_16 = null;
                                    var39_29 = 0;
                                    var40_30 = 0;
                                    var38_28 = null;
                                    var27_20 = false;
                                    var28_21 = null;
                                }
                                var41_31 = 156L;
                                var22_15 = var2_2 & var41_31;
                                var25_17 = var22_15 == var4_3 ? 0 : (var22_15 < var4_3 ? -1 : 1);
                                if (var25_17 == false) ** GOTO lbl-1000
                                if (var7_5 != null) {
                                    var7_5 = var7_5.g();
                                } else {
                                    var43_32 = 0;
                                    var7_5 = null;
                                }
                                var44_33 = 2;
                                var1_1.updateLiveDataRegistration(var44_33, (LiveData)var7_5);
                                if (var7_5 != null) {
                                    var7_5 = (Integer)var7_5.getValue();
                                } else lbl-1000:
                                // 2 sources

                                {
                                    var43_32 = 0;
                                    var7_5 = null;
                                }
                                var15_11 = 159L & var2_2;
                                var44_33 = (int)(var15_11 == var4_3 ? 0 : (var15_11 < var4_3 ? -1 : 1));
                                var45_34 = 2131165374;
                                var22_15 = 65536L;
                                var46_35 = 144L;
                                var33_24 = 0;
                                var35_26 = 0.0f;
                                var34_25 = null;
                                var48_36 = 1;
                                var49_37 = 1.4E-45f;
                                if (var44_33 == 0) break block59;
                                var50_38 = var2_2 & 147L;
                                cfr_temp_1 = var50_38 - var4_3;
                                var44_33 = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                                if (var44_33 == 0) break block60;
                                var44_33 = ViewDataBinding.safeUnbox(var8_6);
                                var50_38 = var2_2 & var19_13;
                                cfr_temp_2 = var50_38 - var4_3;
                                var52_39 /* !! */  = (int)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
                                if (var52_39 /* !! */  == 0) break block61;
                                var52_39 /* !! */  = var44_33 == 0 ? var48_36 : 0;
                                var53_40 = var2_2 & var46_35;
                                cfr_temp_3 = var53_40 - var4_3;
                                var55_41 /* !! */  = (long)(cfr_temp_3 == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1));
                                if (var55_41 /* !! */  != false) {
                                    var53_40 = var52_39 /* !! */  != 0 ? 8192L : 4096L;
                                    var2_2 |= var53_40;
                                }
                                if ((var55_41 /* !! */  = (cfr_temp_4 = (var53_40 = var2_2 & var19_13) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) != false) {
                                    if (var52_39 /* !! */  != 0) {
                                        var53_40 = 131072L;
                                        var2_2 |= var53_40;
                                    } else {
                                        var2_2 |= var22_15;
                                    }
                                }
                                if ((var55_41 /* !! */  = (cfr_temp_5 = (var53_40 = var2_2 & var46_35) - var4_3) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1)) == false || var52_39 /* !! */  == 0) break block62;
                                var56_42 = var1_1.j.getResources();
                                var57_45 = var56_42.getDimension(var45_34);
                                break block63;
                            }
                            var52_39 /* !! */  = 0;
                            break block62;
                        }
                        var44_33 = 0;
                        var52_39 /* !! */  = 0;
                    }
                    var56_43 = null;
                    var57_45 = 0.0f;
                }
                var58_46 = var2_2 & var41_31;
                var60_47 = var58_46 == var4_3 ? 0 : (var58_46 < var4_3 ? -1 : 1);
                if (var60_47 != false) {
                    if (var8_6 == var7_5) {
                        var43_32 = var48_36;
                    } else {
                        var43_32 = 0;
                        var7_5 = null;
                    }
                    if (var60_47 != false) {
                        var58_46 = var43_32 != 0 ? 524288L : 262144L;
                        var2_2 |= var58_46;
                    }
                    var61_48 = var43_32 != 0 ? 0 : 4;
                    var43_32 = var61_48;
                    break block56;
                } else {
                    var43_32 = 0;
                    var7_5 = null;
                }
                break block56;
            }
            var43_32 = 0;
            var7_5 = null;
            var44_33 = 0;
            var52_39 /* !! */  = 0;
            var56_44 = null;
            var57_45 = 0.0f;
        }
        var62_49 = 146L;
        var58_46 = var2_2 & var62_49;
        var64_50 = var58_46 == var4_3 ? 0 : (var58_46 < var4_3 ? -1 : 1);
        if (var64_50 != false) {
            if (var9_7 != null) {
                var65_51 = var9_7.size();
            } else {
                var65_51 = 0;
                var9_7 = null;
            }
            if (var44_33 == (var65_51 += -1)) {
                var65_51 = var48_36;
            } else {
                var65_51 = 0;
                var9_7 = null;
            }
            if (var64_50 != false) {
                var58_46 = var65_51 != 0 ? 2048L : 1024L;
                var2_2 |= var58_46;
            }
            if (var65_51 != 0) {
                var8_6 = var1_1.j.getResources();
                var35_26 = var66_52 = var8_6.getDimension(var45_34);
            }
        }
        var66_52 = var35_26;
        var15_11 = var2_2 & var22_15;
        cfr_temp_6 = var15_11 - var4_3;
        var65_51 = (int)(cfr_temp_6 == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1));
        if (var65_51 != 0 && var28_21 == null) {
            var65_51 = var48_36;
        } else {
            var65_51 = 0;
            var9_7 = null;
        }
        var15_11 = var2_2 & var19_13;
        var44_33 = (int)(var15_11 == var4_3 ? 0 : (var15_11 < var4_3 ? -1 : 1));
        var22_15 = 512L;
        if (var44_33 != 0) {
            var21_14 = var52_39 /* !! */  != 0 ? var48_36 : var65_51;
            if (var44_33 != 0) {
                if (var21_14 != 0) {
                    var2_2 |= var22_15;
                } else {
                    var15_11 = 256L;
                    var2_2 |= var15_11;
                }
            }
        }
        if ((var65_51 = (int)((cfr_temp_7 = (var15_11 = var2_2 & var22_15) - var4_3) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1))) != 0 && var6_4 != null) {
            var6_4 = var6_4.I();
        } else {
            var67_53 = false;
            var6_4 = null;
        }
        var15_11 = var2_2 & var19_13;
        var65_51 = (int)(var15_11 == var4_3 ? 0 : (var15_11 < var4_3 ? -1 : 1));
        if (var65_51 != 0) {
            if (var21_14 == 0) {
                var67_53 = false;
                var6_4 = null;
            }
            var26_18 = var6_4;
        } else {
            var26_18 = null;
        }
        var15_11 = var2_2 & var17_12;
        var67_53 = var15_11 == var4_3 ? 0 : (var15_11 < var4_3 ? -1 : 1);
        if (var67_53) {
            var1_1.a.setVisibility((int)var12_9 /* !! */ );
            var6_4 = var1_1.c;
            var12_9 /* !! */  = 0;
            var24_16 = null;
            u.n((TextView)var6_4, var38_28, null, null);
        }
        if (var65_51 != 0) {
            var6_4 = var1_1.b;
            var9_7 = var6_4.getContext();
            var12_9 /* !! */  = 2131231217;
            var34_25 = AppCompatResources.getDrawable((Context)var9_7, (int)var12_9 /* !! */ );
            var48_36 = 0;
            var49_37 = 0.0f;
            var52_39 /* !! */  = 1;
            var55_41 /* !! */  = 0;
            var60_47 = 0;
            d.v.l.g.a.b((ImageView)var6_4, var26_18, var28_21, var34_25, 0, (boolean)var52_39 /* !! */ , false, null, null, null);
        }
        if (var67_53 = (cfr_temp_8 = (var68_54 = var2_2 & var46_35) - var4_3) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1)) {
            var6_4 = var1_1.j;
            ViewBindingAdapter.setPaddingStart((View)var6_4, var57_45);
        }
        if (var67_53 = (cfr_temp_9 = (var68_54 = var2_2 & var62_49) - var4_3) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1)) {
            var6_4 = var1_1.j;
            ViewBindingAdapter.setPaddingEnd((View)var6_4, var66_52);
        }
        if (var67_53 = (cfr_temp_10 = (var70_55 = 128L & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1)) {
            var6_4 = var1_1.j;
            var8_6 = var1_1.m;
            var6_4.setOnClickListener((View.OnClickListener)var8_6);
            var6_4 = var1_1.e;
            var8_6 = var1_1.l;
            var6_4.setOnClickListener((View.OnClickListener)var8_6);
        }
        if (var67_53 = (cfr_temp_11 = (var70_55 = 161L & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1)) {
            var1_1.k.setVisibility(var39_29);
            var6_4 = var1_1.e;
            var6_4.setVisibility(var39_29);
        }
        if (var67_53 = (cfr_temp_12 = (var70_55 = var2_2 & var41_31) - var4_3) == 0L ? 0 : (cfr_temp_12 < 0L ? -1 : 1)) {
            var6_4 = var1_1.d;
            var6_4.setVisibility(var43_32);
        }
        if (var67_53 = (cfr_temp_13 = (var2_2 &= (var72_56 = 193L)) - var4_3) == 0L ? 0 : (cfr_temp_13 < 0L ? -1 : 1)) {
            var6_4 = var1_1.e;
            var6_4.setProgress(var40_30);
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
        int n11 = 114;
        if (n11 == n10) {
            object = (d.v.c.b2.w.a)object;
            this.E((d.v.c.b2.w.a)object);
            return 1 != 0;
        } else {
            n11 = 115;
            if (n11 == n10) {
                object = (b)object;
                this.F((b)object);
                return 1 != 0;
            } else {
                n11 = 101;
                if (n11 == n10) {
                    object = (Integer)object;
                    this.D((Integer)object);
                    return 1 != 0;
                } else {
                    n11 = 78;
                    if (n11 != n10) return 0 != 0;
                    object = (ObservableList)object;
                    this.C((ObservableList)object);
                }
            }
        }
        return 1 != 0;
    }
}

