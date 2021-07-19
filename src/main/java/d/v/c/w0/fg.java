/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.prime.dialog.PrimeGetDialogViewModel;
import com.zhiyun.cama.prime.dialog.PrimeGetDialogViewModel$PRIME_STATUS;
import com.zhiyun.cama.prime.model.ActivatePrimeInfo;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.m1.d.p$a;
import d.v.c.w0.eg;
import d.v.f.i.g;
import l.a.q.g0.u;

public class fg
extends eg
implements b$a {
    private static final ViewDataBinding$IncludedLayouts u;
    private static final SparseIntArray v;
    private final ConstraintLayout o;
    private final ImageView p;
    private final View.OnClickListener q;
    private final View.OnClickListener r;
    private final View.OnClickListener s;
    private long t;

    static {
        SparseIntArray sparseIntArray;
        v = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362227, 10);
        sparseIntArray.put(2131362224, 11);
        sparseIntArray.put(2131363678, 12);
        sparseIntArray.put(2131363681, 13);
    }

    public fg(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = u;
        SparseIntArray sparseIntArray = v;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 14, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private fg(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        ImageView imageView;
        Object object;
        Object object2 = object = objectArray[11];
        object2 = (ConstraintLayout)((Object)object);
        Object object3 = object = objectArray[7];
        object3 = (ConstraintLayout)((Object)object);
        Object object4 = object = objectArray[10];
        object4 = (ConstraintLayout)((Object)object);
        Object object5 = object = objectArray[1];
        object5 = (ImageView)object;
        Object object6 = object = objectArray[8];
        object6 = (ProgressBar)object;
        Object object7 = object = objectArray[5];
        object7 = (TextView)object;
        Object object8 = object = objectArray[9];
        object8 = (AppCompatTextView)object;
        Object object9 = object = objectArray[4];
        object9 = (TextView)object;
        Object object10 = object = objectArray[3];
        object10 = (AppCompatTextView)object;
        Object object11 = object = objectArray[6];
        object11 = (TextView)object;
        Object object12 = object = objectArray[12];
        object12 = (View)object;
        Object object13 = object = objectArray[13];
        object13 = (View)object;
        object = this;
        Object object14 = dataBindingComponent;
        super(dataBindingComponent, view, 8, (ConstraintLayout)((Object)object2), (ConstraintLayout)((Object)object3), (ConstraintLayout)((Object)object4), (ImageView)object5, (ProgressBar)object6, (TextView)object7, (AppCompatTextView)object8, (TextView)object9, (AppCompatTextView)object10, (TextView)object11, (View)object12, (View)object13);
        this.t = -1;
        this.b.setTag(null);
        this.d.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.o = object;
        object.setTag(null);
        int n10 = 2;
        this.p = imageView = (ImageView)objectArray[n10];
        imageView.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        object14 = view;
        this.setRootTag(view);
        object14 = new b(this, 3);
        this.q = object14;
        object14 = new b(this, 1);
        this.r = object14;
        object14 = new b(this, n10);
        this.s = object14;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.t;
                long l11 = 1L;
                this.t = l10 |= l11;
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
    private boolean D(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.t;
                long l11 = 16;
                this.t = l10 |= l11;
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
    private boolean E(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.t;
                long l11 = 4;
                this.t = l10 |= l11;
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
    private boolean F(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.t;
                long l11 = 32;
                this.t = l10 |= l11;
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
    private boolean G(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.t;
                long l11 = 8;
                this.t = l10 |= l11;
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
    private boolean H(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.t;
                long l11 = 128L;
                this.t = l10 |= l11;
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
    private boolean I(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.t;
                long l11 = 64;
                this.t = l10 |= l11;
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
    private boolean J(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.t;
                long l11 = 2;
                this.t = l10 |= l11;
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
    public void A(p$a p$a) {
        this.m = p$a;
        synchronized (this) {
            long l10 = this.t;
            long l11 = 512L;
            this.t = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(PrimeGetDialogViewModel primeGetDialogViewModel) {
        this.n = primeGetDialogViewModel;
        synchronized (this) {
            long l10 = this.t;
            long l11 = 256L;
            this.t = l10 |= l11;
        }
        this.notifyPropertyChanged(40);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 == n13) {
                    p$a p$a = this.m;
                    if (p$a != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        p$a.c();
                    }
                }
            } else {
                p$a p$a = this.m;
                if (p$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    p$a.b();
                }
            }
        } else {
            p$a p$a = this.m;
            if (p$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                p$a.a();
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
        block86: {
            block85: {
                block84: {
                    block82: {
                        block83: {
                            var1_1 = this;
                            synchronized (this) {
                                var2_2 = this.t;
                                this.t = var4_3 = 0L;
                            }
                            var6_4 = this.n;
                            var7_5 = 1535L & var2_2;
                            var9_6 /* !! */  = var7_5 == var4_3 ? 0 : (var7_5 < var4_3 ? -1 : 1);
                            var10_7 = 1416L;
                            var12_8 = 1284L;
                            var14_9 = 1282L;
                            var16_10 = 1281L;
                            var18_11 = 65536L;
                            var20_12 = 8;
                            var21_13 = 1.1E-44f;
                            var22_14 = 1344L;
                            var24_15 = 1345L;
                            var26_16 = 1;
                            var27_17 = 0;
                            var28_18 /* !! */  = null;
                            if (var9_6 /* !! */  == false) break block83;
                            var29_19 = var2_2 & var16_10;
                            cfr_temp_0 = var29_19 - var4_3;
                            var9_6 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                            if (var9_6 /* !! */  != false) {
                                if (var6_4 != null) {
                                    var31_20 = var6_4.d();
                                } else {
                                    var32_22 = 0;
                                    var31_20 = null;
                                }
                                var1_1.updateLiveDataRegistration(0, var31_20);
                                var33_23 = var31_20 != null ? (ActivatePrimeInfo)var31_20.getValue() : null;
                                if (var33_23 == null) {
                                    var34_24 = var26_16;
                                } else {
                                    var34_24 = 0;
                                    var35_27 = null;
                                }
                                if (var9_6 /* !! */  != false) {
                                    var36_28 = var34_24 != 0 ? 0x400000L : 0x200000L;
                                    var2_2 |= var36_28;
                                }
                                var9_6 /* !! */  = var33_23 != null ? (long)var33_23.getCount() : (long)0;
                                var35_27 = var34_24 != 0 ? "@string/refuse" : "@string/prime_duration";
                            } else {
                                var9_6 /* !! */  = 0;
                                var32_22 = 0;
                                var31_20 = null;
                                var33_23 = null;
                                var34_25 = false;
                                var35_27 = null;
                            }
                            var36_28 = var2_2 & var14_9;
                            var38_29 = var36_28 == var4_3 ? 0 : (var36_28 < var4_3 ? -1 : 1);
                            if (var38_29 != false) {
                                if (var6_4 != null) {
                                    var39_30 = var6_4.o();
                                    var40_31 /* !! */  = var39_30;
                                } else {
                                    var41_32 = 0;
                                    var40_31 /* !! */  = null;
                                }
                                var1_1.updateLiveDataRegistration(var26_16, (LiveData)var40_31 /* !! */ );
                                if (var40_31 /* !! */  != null) {
                                    var40_31 /* !! */  = (Integer)var40_31 /* !! */ .getValue();
                                } else {
                                    var41_32 = 0;
                                    var40_31 /* !! */  = null;
                                }
                                var41_32 = ViewDataBinding.safeUnbox((Integer)var40_31 /* !! */ );
                                var42_33 = this.getRoot();
                                var43_34 = d.v.f.i.g.m(var42_33.getContext(), var41_32);
                            } else {
                                var26_16 = 0;
                                var43_34 = null;
                            }
                            var14_9 = var2_2 & var12_8;
                            var41_32 = var14_9 == var4_3 ? 0 : (var14_9 < var4_3 ? -1 : 1);
                            if (var41_32 == 0) ** GOTO lbl-1000
                            if (var6_4 != null) {
                                var42_33 = var6_4.f();
                                var44_35 = var42_33;
                            } else {
                                var45_36 = 0;
                                var46_37 = 0.0f;
                                var44_35 = null;
                            }
                            var47_38 = 2;
                            var1_1.updateLiveDataRegistration(var47_38, (LiveData)var44_35);
                            if (var44_35 != null) {
                                var44_35 = (Boolean)var44_35.getValue();
                            } else {
                                var45_36 = 0;
                                var46_37 = 0.0f;
                                var44_35 = null;
                            }
                            var45_36 = (int)ViewDataBinding.safeUnbox((Boolean)var44_35);
                            if (var41_32 != 0) {
                                var48_40 = var45_36 != 0 ? 4096L : 2048L;
                                var2_2 |= var48_40;
                            }
                            if (var45_36 == 0) {
                                var45_36 = var20_12;
                                var46_37 = var21_13;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var45_36 = 0;
                                var44_35 = null;
                                var46_37 = 0.0f;
                            }
                            var48_40 = var2_2 & var10_7;
                            var47_38 = (int)(var48_40 == var4_3 ? 0 : (var48_40 < var4_3 ? -1 : 1));
                            if (var47_38 != 0) {
                                if (var6_4 != null) {
                                    var50_41 = var6_4.i();
                                    var40_31 /* !! */  = var6_4.j();
                                } else {
                                    var47_38 = 0;
                                    var50_41 = null;
                                    var41_32 = 0;
                                    var40_31 /* !! */  = null;
                                }
                                var1_1.updateLiveDataRegistration(3, (LiveData)var50_41);
                                var51_42 = 7;
                                var1_1.updateLiveDataRegistration(var51_42, (LiveData)var40_31 /* !! */ );
                                if (var50_41 != null) {
                                    var52_45 = (Integer)var50_41.getValue();
                                } else {
                                    var51_42 = 0;
                                    var52_45 = null;
                                }
                                var53_46 = var40_31 /* !! */  != null ? var40_31 /* !! */ .getValue() : null;
                                var51_42 = ViewDataBinding.safeUnbox((Integer)var52_45);
                                var50_41 = this.getRoot().getContext();
                                var52_45 = d.v.f.i.g.m((Context)var50_41, var51_42);
                            } else {
                                var51_43 = false;
                                var52_45 = null;
                                var53_46 = null;
                            }
                            var48_40 = 1296L;
                            var54_47 = var2_2 & var48_40;
                            var47_38 = (int)(var54_47 == var4_3 ? 0 : (var54_47 < var4_3 ? -1 : 1));
                            var41_32 = 4;
                            if (var47_38 == 0) ** GOTO lbl-1000
                            if (var6_4 != null) {
                                var42_33 = var6_4.e();
                                var56_48 = var42_33;
                            } else {
                                var57_50 = 0;
                                var56_48 = null;
                            }
                            var1_1.updateLiveDataRegistration(var41_32, (LiveData)var56_48);
                            if (var56_48 != null) {
                                var56_48 = (Boolean)var56_48.getValue();
                            } else {
                                var57_50 = 0;
                                var56_48 = null;
                            }
                            var57_50 = ViewDataBinding.safeUnbox((Boolean)var56_48);
                            if (var47_38 != 0) {
                                var54_47 = var57_50 != 0 ? 0x100000L : 524288L;
                                var2_2 |= var54_47;
                            }
                            if (var57_50 == 0) {
                                var57_50 = var41_32;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var57_50 = 0;
                                var56_48 = null;
                            }
                            var58_51 = 1312L;
                            var54_47 = var2_2 & var58_51;
                            var47_38 = (int)(var54_47 == var4_3 ? 0 : (var54_47 < var4_3 ? -1 : 1));
                            if (var47_38 != 0) {
                                if (var6_4 != null) {
                                    var50_41 = var6_4.g();
                                } else {
                                    var47_38 = 0;
                                    var50_41 = null;
                                }
                                var41_32 = 5;
                                var1_1.updateLiveDataRegistration(var41_32, (LiveData)var50_41);
                                if (var50_41 != null) {
                                    var50_41 = (Integer)var50_41.getValue();
                                } else {
                                    var47_38 = 0;
                                    var50_41 = null;
                                }
                                var47_38 = ViewDataBinding.safeUnbox((Integer)var50_41);
                                var40_31 /* !! */  = this.getRoot().getContext();
                                var50_41 = d.v.f.i.g.m((Context)var40_31 /* !! */ , var47_38);
                            } else {
                                var47_38 = 0;
                                var50_41 = null;
                            }
                            var60_52 = var2_2 & var24_15;
                            var41_32 = (int)(var60_52 == var4_3 ? 0 : (var60_52 < var4_3 ? -1 : 1));
                            if (var41_32 != 0) {
                                if (var6_4 != null) {
                                    var40_31 /* !! */  = var6_4.m();
                                } else {
                                    var41_32 = 0;
                                    var40_31 /* !! */  = null;
                                }
                                var27_17 = 6;
                                var1_1.updateLiveDataRegistration(var27_17, (LiveData)var40_31 /* !! */ );
                                if (var40_31 /* !! */  != null) {
                                    var28_18 /* !! */  = (PrimeGetDialogViewModel$PRIME_STATUS)var40_31 /* !! */ .getValue();
                                } else {
                                    var27_17 = 0;
                                    var28_18 /* !! */  = null;
                                }
                                var40_31 /* !! */  = PrimeGetDialogViewModel$PRIME_STATUS.PRIME_STATUS_SUCCESS;
                                if (var28_18 /* !! */  == var40_31 /* !! */ ) {
                                    var41_32 = 1;
                                } else {
                                    var41_32 = 0;
                                    var40_31 /* !! */  = null;
                                }
                                var62_53 = var2_2 & var22_14;
                                var64_54 = var62_53 == var4_3 ? 0 : (var62_53 < var4_3 ? -1 : 1);
                                if (var64_54 != false) {
                                    if (var41_32 != 0) {
                                        var2_2 |= 16384L;
                                        var62_53 = 0x4000000L;
                                    } else {
                                        var2_2 |= 8192L;
                                        var62_53 = 0x2000000L;
                                    }
                                    var2_2 |= var62_53;
                                }
                                if ((var64_54 = (cfr_temp_1 = (var62_53 = var2_2 & var24_15) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
                                    if (var41_32 != 0) {
                                        var2_2 |= var18_11;
                                    } else {
                                        var62_53 = 32768L;
                                        var2_2 |= var62_53;
                                    }
                                }
                                if ((var64_54 = (cfr_temp_2 = (var62_53 = var2_2 & var22_14) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
                                    var65_55 = var41_32 != 0 ? 0 : 4;
                                    var66_56 = var41_32 != 0 ? "@string/prime_view_rightsinterests" : "@string/refuse";
                                } else {
                                    var65_55 = 0;
                                    var66_56 = null;
                                }
                                if (var64_54 != false) {
                                    var67_57 /* !! */  = PrimeGetDialogViewModel$PRIME_STATUS.PRIME_STATUS_RECEIVING;
                                    if (var28_18 /* !! */  == var67_57 /* !! */ ) {
                                        var68_58 = 1;
                                    } else {
                                        var68_58 = 0;
                                        var67_57 /* !! */  = null;
                                    }
                                    if (var64_54 != false) {
                                        var69_59 = var68_58 != 0 ? 262144L : 131072L;
                                        var2_2 |= var69_59;
                                    }
                                    if (var68_58 != 0) {
                                        var68_58 = 0;
                                        var67_57 /* !! */  = null;
                                    } else {
                                        var68_58 = var20_12;
                                    }
                                    var28_18 /* !! */  = var35_27;
                                    var71_60 = var66_56;
                                } else {
                                    var28_18 /* !! */  = var35_27;
                                    var71_60 = var66_56;
                                    var68_58 = 0;
                                    var67_57 /* !! */  = null;
                                }
                                var35_27 = var31_20;
                                var32_22 = var65_55;
                                break block82;
                            } else {
                                var28_18 /* !! */  = var35_27;
                                var68_58 = 0;
                                var67_57 /* !! */  = null;
                                var71_60 = null;
                                var41_32 = 0;
                                var40_31 /* !! */  = null;
                                var35_27 = var31_20;
                                var32_22 = 0;
                                var31_20 = null;
                            }
                            break block82;
                        }
                        var68_58 = 0;
                        var67_57 /* !! */  = null;
                        var71_60 = null;
                        var9_6 /* !! */  = 0;
                        var26_16 = 0;
                        var43_34 = null;
                        var27_17 = 0;
                        var28_18 /* !! */  = null;
                        var51_44 = false;
                        var52_45 = null;
                        var53_46 = null;
                        var57_50 = 0;
                        var56_49 = null;
                        var32_22 = 0;
                        var31_21 = null;
                        var45_36 = 0;
                        var46_37 = 0.0f;
                        var44_35 = null;
                        var47_39 = false;
                        var50_41 = null;
                        var41_32 = 0;
                        var40_31 /* !! */  = null;
                        var33_23 = null;
                        var34_26 = false;
                        var35_27 = null;
                    }
                    var18_11 = var2_2 & var18_11;
                    var62_53 = 0L;
                    var72_61 = var18_11 == var62_53 ? 0 : (var18_11 < var62_53 ? -1 : 1);
                    if (var72_61 == false) break block84;
                    if (var6_4 != null) {
                        var6_4 = var6_4.d();
                        var72_61 = var45_36;
                        var73_62 = var46_37;
                    } else {
                        var72_61 = var45_36;
                        var73_62 = var46_37;
                        var6_4 = var35_27;
                    }
                    var45_36 = 0;
                    var46_37 = 0.0f;
                    var44_35 = null;
                    var1_1.updateLiveDataRegistration(0, (LiveData)var6_4);
                    if (var6_4 != null) {
                        var33_23 = var6_4 = var6_4.getValue();
                        var33_23 = (ActivatePrimeInfo)var6_4;
                    }
                    if (var33_23 == null) break block85;
                    var74_63 = true;
                    break block86;
                }
                var72_61 = var45_36;
                var73_62 = var46_37;
                var45_36 = 0;
                var46_37 = 0.0f;
                var44_35 = null;
            }
            var74_63 = false;
        }
        var29_19 = var2_2 & var24_15;
        var54_47 = 0L;
        var75_64 = var29_19 == var54_47 ? 0 : (var29_19 < var54_47 ? -1 : 1);
        if (var75_64 != false) {
            if (var41_32 == 0) {
                var74_63 = false;
            }
            if (var75_64 != false) {
                var29_19 = var74_63 != false ? 0x1000000L : 0x800000L;
                var2_2 |= var29_19;
            }
            if (var74_63) {
                var20_12 = 0;
                var21_13 = 0.0f;
            }
            var45_36 = var20_12;
            var46_37 = var21_13;
        }
        if ((var75_64 = (cfr_temp_3 = (var76_65 = var2_2 & 1024L) - (var29_19 = 0L)) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.b;
            var40_31 /* !! */  = var1_1.q;
            var6_4.setOnClickListener((View.OnClickListener)var40_31 /* !! */ );
            var6_4 = var1_1.d;
            var40_31 /* !! */  = var1_1.r;
            var6_4.setOnClickListener((View.OnClickListener)var40_31 /* !! */ );
            var6_4 = var1_1.j;
            var40_31 /* !! */  = var1_1.s;
            var6_4.setOnClickListener((View.OnClickListener)var40_31 /* !! */ );
        }
        if ((var75_64 = (cfr_temp_4 = (var76_65 = var2_2 & 1296L) - (var78_66 = 0L)) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.d;
            var6_4.setVisibility(var57_50);
        }
        if ((var75_64 = (cfr_temp_5 = (var76_65 = var2_2 & var22_14) - var78_66) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1)) != false) {
            var1_1.p.setVisibility(var32_22);
            var1_1.e.setVisibility(var68_58);
            var6_4 = var1_1.j;
            var68_58 = 0;
            var67_57 /* !! */  = null;
            l.a.q.g0.u.n((TextView)var6_4, var71_60, null, null);
        }
        if ((var75_64 = (cfr_temp_6 = (var4_3 = var2_2 & var24_15) - var78_66) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.f;
            var6_4.setVisibility(var45_36);
        }
        if ((var75_64 = (cfr_temp_7 = (var4_3 = var2_2 & var16_10) - var78_66) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.f;
            var67_57 /* !! */  = (int)var9_6 /* !! */ ;
            var71_60 = null;
            l.a.q.g0.u.n((TextView)var6_4, var28_18 /* !! */ , var67_57 /* !! */ , null);
        } else {
            var71_60 = null;
        }
        var80_67 = 1312L & var2_2;
        var75_64 = var80_67 == var78_66 ? 0 : (var80_67 < var78_66 ? -1 : 1);
        if (var75_64 != false) {
            var6_4 = var1_1.g;
            l.a.q.g0.u.n((TextView)var6_4, (String)var50_41, null, null);
        }
        if ((var75_64 = (cfr_temp_8 = (var80_67 = 1416L & var2_2) - var78_66) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.h;
            l.a.q.g0.u.n((TextView)var6_4, (String)var52_45, var53_46, null);
        }
        if ((var75_64 = (cfr_temp_9 = (var82_68 = 1282L & var2_2) - var78_66) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.i;
            l.a.q.g0.u.n((TextView)var6_4, var43_34, null, null);
        }
        if ((var75_64 = (cfr_temp_10 = (var2_2 &= (var4_3 = 1284L)) - var78_66) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.j;
            var45_36 = (int)var72_61;
            var46_37 = var73_62;
            var6_4.setVisibility((int)var72_61);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.t;
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
            this.t = l10 = 1024L;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        switch (n10) {
            default: {
                return false;
            }
            case 7: {
                object = (MutableLiveData)object;
                return this.H((MutableLiveData)object, n11);
            }
            case 6: {
                object = (MutableLiveData)object;
                return this.I((MutableLiveData)object, n11);
            }
            case 5: {
                object = (MutableLiveData)object;
                return this.F((MutableLiveData)object, n11);
            }
            case 4: {
                object = (MutableLiveData)object;
                return this.D((MutableLiveData)object, n11);
            }
            case 3: {
                object = (MutableLiveData)object;
                return this.G((MutableLiveData)object, n11);
            }
            case 2: {
                object = (MutableLiveData)object;
                return this.E((MutableLiveData)object, n11);
            }
            case 1: {
                object = (MutableLiveData)object;
                return this.J((MutableLiveData)object, n11);
            }
            case 0: 
        }
        object = (MutableLiveData)object;
        return this.C((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 40;
        if (n11 == n10) {
            object = (PrimeGetDialogViewModel)object;
            this.B((PrimeGetDialogViewModel)object);
            return 1 != 0;
        } else {
            n11 = 23;
            if (n11 != n10) return 0 != 0;
            object = (p$a)object;
            this.A((p$a)object);
        }
        return 1 != 0;
    }
}

