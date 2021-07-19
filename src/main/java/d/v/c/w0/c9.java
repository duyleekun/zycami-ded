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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Pair;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.device.firmware.FirmwareUpgradeFragment$b;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.b9;
import d.v.c.y0.c.o;
import d.v.e.l.o1;
import l.a.q.g0.u;

public class c9
extends b9
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
        sparseIntArray.put(2131363608, 11);
        sparseIntArray.put(2131363695, 12);
    }

    public c9(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = u;
        SparseIntArray sparseIntArray = v;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 13, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private c9(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[2];
        object2 = (ImageView)object;
        Object object3 = object = objectArray[9];
        object3 = (ProgressBar)object;
        Object object4 = object = objectArray[8];
        object4 = (TextView)object;
        Object object5 = object = objectArray[4];
        object5 = (TextView)object;
        Object object6 = object = objectArray[6];
        object6 = (TextView)object;
        Object object7 = object = objectArray[3];
        object7 = (TextView)object;
        Object object8 = object = objectArray[5];
        object8 = (TextView)object;
        Object object9 = object = objectArray[7];
        object9 = (TextView)object;
        Object object10 = object = objectArray[10];
        object10 = (TextView)object;
        Object object11 = object = objectArray[11];
        object11 = (TextView)object;
        Object object12 = object = objectArray[12];
        object12 = (View)object;
        object = this;
        Object object13 = dataBindingComponent;
        View view2 = view;
        super(dataBindingComponent, view, 8, (ImageView)object2, (ProgressBar)object3, (TextView)object4, (TextView)object5, (TextView)object6, (TextView)object7, (TextView)object8, (TextView)object9, (TextView)object10, (TextView)object11, (View)object12);
        this.t = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.o = object;
        object.setTag(null);
        int n10 = 1;
        view2 = (ImageView)objectArray[n10];
        this.p = view2;
        view2.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        object13 = view;
        this.setRootTag(view);
        object13 = new b(this, 3);
        this.q = object13;
        object13 = new b(this, n10);
        this.r = object13;
        object = new b(this, 2);
        this.s = object;
        this.invalidateAll();
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
    private boolean F(MutableLiveData mutableLiveData, int n10) {
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
    private boolean I(MutableLiveData mutableLiveData, int n10) {
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
    private boolean J(MutableLiveData mutableLiveData, int n10) {
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
    private boolean K(MutableLiveData mutableLiveData, int n10) {
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
    private boolean L(MutableLiveData mutableLiveData, int n10) {
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
    public void B(FirmwareUpgradeFragment$b firmwareUpgradeFragment$b) {
        this.m = firmwareUpgradeFragment$b;
        synchronized (this) {
            long l10 = this.t;
            long l11 = 256L;
            this.t = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(String string2) {
        this.l = string2;
        synchronized (this) {
            long l10 = this.t;
            long l11 = 512L;
            this.t = l10 |= l11;
        }
        this.notifyPropertyChanged(38);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(o o10) {
        this.n = o10;
        synchronized (this) {
            long l10 = this.t;
            long l11 = 1024L;
            this.t = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
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
                    FirmwareUpgradeFragment$b firmwareUpgradeFragment$b = this.m;
                    if (firmwareUpgradeFragment$b != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        firmwareUpgradeFragment$b.b();
                    }
                }
            } else {
                FirmwareUpgradeFragment$b firmwareUpgradeFragment$b = this.m;
                if (firmwareUpgradeFragment$b != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    firmwareUpgradeFragment$b.c();
                }
            }
        } else {
            FirmwareUpgradeFragment$b firmwareUpgradeFragment$b = this.m;
            if (firmwareUpgradeFragment$b != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                firmwareUpgradeFragment$b.a();
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
        block62: {
            block63: {
                var1_1 = this;
                synchronized (this) {
                    var2_2 = this.t;
                    this.t = var4_3 = 0L;
                }
                var6_4 = this.l;
                var7_5 = this.n;
                var8_6 = 3327L & var2_2;
                var10_7 /* !! */  = var8_6 == var4_3 ? 0 : (var8_6 < var4_3 ? -1 : 1);
                var11_8 = 3088L;
                var13_9 = 3080L;
                var15_10 = 3076L;
                var17_11 = 3074L;
                var19_12 = 3200L;
                var21_13 = 3073L;
                var23_14 = 0;
                var24_15 = 0.0f;
                var25_16 = null;
                if (var10_7 /* !! */  == false) break block63;
                var26_17 = var2_2 & var21_13;
                cfr_temp_0 = var26_17 - var4_3;
                var10_7 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                if (var10_7 /* !! */  != false) {
                    if (var7_5 != null) {
                        var28_18 = var7_5.m();
                    } else {
                        var10_7 /* !! */  = 0;
                        var28_18 = null;
                    }
                    var1_1.updateLiveDataRegistration(0, (LiveData)var28_18);
                    if (var28_18 != null) {
                        var28_18 = (Integer)var28_18.getValue();
                    } else {
                        var10_7 /* !! */  = 0;
                        var28_18 = null;
                    }
                    var10_7 /* !! */  = ViewDataBinding.safeUnbox((Integer)var28_18);
                    var29_19 = this.getRoot().getContext();
                    var28_18 = o1.m((Context)var29_19, (int)var10_7 /* !! */ );
                } else {
                    var10_7 /* !! */  = 0;
                    var28_18 = null;
                }
                var26_17 = var2_2 & var17_11;
                var30_20 = var26_17 == var4_3 ? 0 : (var26_17 < var4_3 ? -1 : 1);
                if (var30_20 == false) ** GOTO lbl-1000
                if (var7_5 != null) {
                    var29_19 = var7_5.t();
                } else {
                    var30_20 = 0;
                    var29_19 = null;
                }
                var23_14 = 1;
                var24_15 = 1.4E-45f;
                var1_1.updateLiveDataRegistration(var23_14, (LiveData)var29_19);
                if (var29_19 != null) {
                    var25_16 = (Pair)var29_19.getValue();
                } else {
                    var23_14 = 0;
                    var24_15 = 0.0f;
                    var25_16 = null;
                }
                if (var25_16 != null) {
                    var29_19 = (String)var25_16.second;
                    var25_16 = (String)var25_16.first;
                } else lbl-1000:
                // 2 sources

                {
                    var23_14 = 0;
                    var24_15 = 0.0f;
                    var25_16 = null;
                    var30_20 = 0;
                    var29_19 = null;
                }
                var31_22 = var2_2 & var15_10;
                var33_23 = var31_22 == var4_3 ? 0 : (var31_22 < var4_3 ? -1 : 1);
                var34_24 = 8;
                var35_25 = 1.1E-44f;
                if (var33_23 == false) ** GOTO lbl-1000
                if (var7_5 != null) {
                    var36_26 = var7_5.p();
                    var37_27 = var36_26;
                } else {
                    var38_28 = false;
                    var37_27 = null;
                }
                var39_30 = 2;
                var1_1.updateLiveDataRegistration(var39_30, (LiveData)var37_27);
                if (var37_27 != null) {
                    var40_31 = (Boolean)var37_27.getValue();
                } else {
                    var39_30 = 0;
                    var40_31 = null;
                }
                var39_30 = (int)ViewDataBinding.safeUnbox(var40_31);
                if (var33_23 != false) {
                    var41_33 = var39_30 != 0 ? 131072L : 65536L;
                    var2_2 |= var41_33;
                }
                if (var39_30 == 0) {
                    var39_30 = var34_24;
                } else lbl-1000:
                // 2 sources

                {
                    var39_30 = 0;
                    var40_31 = null;
                }
                var41_33 = var2_2 & var13_9;
                var43_34 = var41_33 == var4_3 ? 0 : (var41_33 < var4_3 ? -1 : 1);
                if (var43_34 == 0) ** GOTO lbl-1000
                if (var7_5 != null) {
                    var37_27 = var7_5.j();
                } else {
                    var38_28 = false;
                    var37_27 = null;
                }
                var44_35 = 3;
                var1_1.updateLiveDataRegistration((int)var44_35, (LiveData)var37_27);
                if (var37_27 != null) {
                    var37_27 = (Boolean)var37_27.getValue();
                } else {
                    var38_28 = false;
                    var37_27 = null;
                }
                var38_28 = ViewDataBinding.safeUnbox((Boolean)var37_27);
                if (var43_34 != 0) {
                    var13_9 = var38_28 != false ? 8192L : 4096L;
                    var2_2 |= var13_9;
                }
                if (!var38_28) {
                    var43_34 = var34_24;
                } else lbl-1000:
                // 2 sources

                {
                    var43_34 = 0;
                }
                var13_9 = var2_2 & var11_8;
                var38_28 = var13_9 == var4_3 ? 0 : (var13_9 < var4_3 ? -1 : 1);
                if (!var38_28) ** GOTO lbl-1000
                if (var7_5 != null) {
                    var37_27 = var7_5.g();
                } else {
                    var38_28 = false;
                    var37_27 = null;
                }
                var44_35 = 4;
                var1_1.updateLiveDataRegistration((int)var44_35, (LiveData)var37_27);
                if (var37_27 != null) {
                    var37_27 = (String)var37_27.getValue();
                } else lbl-1000:
                // 2 sources

                {
                    var38_28 = false;
                    var37_27 = null;
                }
                var13_9 = 3104L;
                var45_36 = var2_2 & var13_9;
                var44_35 = var45_36 == var4_3 ? 0 : (var45_36 < var4_3 ? -1 : 1);
                if (var44_35 == false) ** GOTO lbl-1000
                if (var7_5 != null) {
                    var47_37 = var7_5.n();
                } else {
                    var44_35 = 0;
                    var47_37 = null;
                }
                var48_38 = 5;
                var1_1.updateLiveDataRegistration(var48_38, (LiveData)var47_37);
                if (var47_37 != null) {
                    var49_40 = (String)var47_37.getValue();
                } else lbl-1000:
                // 2 sources

                {
                    var48_38 = 0;
                    var49_40 = null;
                }
                var13_9 = 3136L;
                var50_41 = var2_2 & var13_9;
                var52_42 = var50_41 == var4_3 ? 0 : (var50_41 < var4_3 ? -1 : 1);
                if (var52_42 == false) ** GOTO lbl-1000
                if (var7_5 != null) {
                    var53_44 = var7_5.i();
                } else {
                    var52_42 = 0;
                    var53_44 = null;
                }
                var44_35 = 6;
                var1_1.updateLiveDataRegistration((int)var44_35, (LiveData)var53_44);
                if (var53_44 != null) {
                    var53_44 = (String)var53_44.getValue();
                } else lbl-1000:
                // 2 sources

                {
                    var52_42 = 0;
                    var53_44 = null;
                }
                var13_9 = var2_2 & var19_12;
                var44_35 = var13_9 == var4_3 ? 0 : (var13_9 < var4_3 ? -1 : 1);
                if (var44_35 != false) {
                    var7_5 = var7_5 != null ? var7_5.o() : null;
                    var54_45 = 7;
                    var55_46 = 9.8E-45f;
                    var1_1.updateLiveDataRegistration(var54_45, (LiveData)var7_5);
                    if (var7_5 != null) {
                        var56_48 /* !! */  = (Boolean)var7_5.getValue();
                    } else {
                        var54_45 = 0;
                        var55_46 = 0.0f;
                        var56_48 /* !! */  = null;
                    }
                    var54_45 = (int)ViewDataBinding.safeUnbox((Boolean)var56_48 /* !! */ );
                    if (var44_35 != false) {
                        if (var54_45 != 0) {
                            var2_2 |= 32768L;
                            var13_9 = 524288L;
                        } else {
                            var2_2 |= 16384L;
                            var13_9 = 262144L;
                        }
                        var2_2 |= var13_9;
                    }
                    var57_49 = var54_45 ^ 1;
                    var58_50 = var54_45 != 0 ? 0 : var34_24;
                    if (var54_45 != 0) {
                        var54_45 = 1053609165;
                        var55_46 = 0.4f;
                    } else {
                        var54_45 = 1065353216;
                        var55_46 = 1.0f;
                    }
                    var59_51 = var57_49;
                    var57_49 = ViewDataBinding.safeUnbox(var59_51);
                    var60_54 = var25_16;
                    var23_14 = var54_45;
                    var24_15 = var55_46;
                    var56_48 /* !! */  = var28_18;
                    var61_55 = var58_50;
                    var62_56 = var2_2;
                    break block62;
                } else {
                    var56_48 /* !! */  = var28_18;
                    var57_49 = false;
                    var59_52 = null;
                    var62_56 = var2_2;
                    var61_55 = 0;
                    var64_57 /* !! */  = null;
                    var60_54 = var25_16;
                    var23_14 = 0;
                    var24_15 = 0.0f;
                    var25_16 = null;
                }
                break block62;
            }
            var62_56 = var2_2;
            var23_14 = 0;
            var24_15 = 0.0f;
            var25_16 = null;
            var61_55 = 0;
            var64_57 /* !! */  = null;
            var60_54 = null;
            var54_45 = 0;
            var55_47 = 0.0f;
            var56_48 /* !! */  = null;
            var57_49 = false;
            var59_53 = null;
            var39_30 = 0;
            var40_32 = null;
            var43_34 = 0;
            var48_39 = false;
            var49_40 = null;
            var52_43 = false;
            var53_44 = null;
            var38_29 = false;
            var37_27 = null;
            var30_21 = false;
            var29_19 = null;
        }
        var13_9 = var62_56 & var21_13;
        var21_13 = 0L;
        var44_35 = var13_9 == var21_13 ? 0 : (var13_9 < var21_13 ? -1 : 1);
        if (var44_35 != false) {
            var47_37 = var1_1.a;
            ImageViewBindingAdapter.setImageDrawable((ImageView)var47_37, var56_48 /* !! */ );
        }
        if ((var54_45 = (cfr_temp_1 = (var13_9 = var62_56 & var19_12) - var21_13) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != 0) {
            var54_45 = ViewDataBinding.getBuildSdkInt();
            if (var54_45 >= (var44_35 = (long)11)) {
                var56_48 /* !! */  = var1_1.p;
                var56_48 /* !! */ .setAlpha(var24_15);
            }
            var25_16 = var1_1.p;
            var56_48 /* !! */  = var1_1.r;
            ViewBindingAdapter.setOnClick((View)var25_16, (View.OnClickListener)var56_48 /* !! */ , var57_49);
            var1_1.b.setVisibility(var61_55);
            var25_16 = var1_1.i;
            var25_16.setVisibility(var61_55);
        }
        if ((var23_14 = (int)((cfr_temp_2 = (var4_3 = 2048L & var62_56) - (var13_9 = 0L)) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) != 0) {
            var25_16 = var1_1.c;
            var64_57 /* !! */  = var1_1.q;
            var25_16.setOnClickListener(var64_57 /* !! */ );
            var25_16 = var1_1.h;
            var64_57 /* !! */  = var1_1.s;
            var25_16.setOnClickListener(var64_57 /* !! */ );
        }
        if ((var23_14 = (int)((cfr_temp_3 = (var4_3 = 3080L & var62_56) - var13_9) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) != 0) {
            var25_16 = var1_1.c;
            var25_16.setVisibility(var43_34);
        }
        if ((var23_14 = (int)((cfr_temp_4 = (var4_3 = 3136L & var62_56) - var13_9) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) != 0) {
            var25_16 = var1_1.c;
            var61_55 = 0;
            var64_57 /* !! */  = null;
            l.a.q.g0.u.n((TextView)var25_16, (String)var53_44, null, null);
        } else {
            var61_55 = 0;
            var64_57 /* !! */  = null;
        }
        var4_3 = 2560L & var62_56;
        var23_14 = (int)(var4_3 == var13_9 ? 0 : (var4_3 < var13_9 ? -1 : 1));
        if (var23_14 != 0) {
            var25_16 = var1_1.d;
            l.a.q.g0.u.n((TextView)var25_16, var6_4, null, null);
        }
        if ((var23_14 = (int)((cfr_temp_5 = (var4_3 = 3088L & var62_56) - var13_9) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) != 0) {
            var25_16 = var1_1.e;
            l.a.q.g0.u.n((TextView)var25_16, (String)var37_27, null, null);
        }
        if ((var23_14 = (int)((cfr_temp_6 = (var4_3 = 3104L & var62_56) - var13_9) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1))) != 0) {
            var25_16 = var1_1.f;
            l.a.q.g0.u.n((TextView)var25_16, var49_40, null, null);
        }
        if ((var23_14 = (int)((cfr_temp_7 = (var4_3 = var62_56 & var17_11) - var13_9) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1))) != 0) {
            var25_16 = var1_1.g;
            var64_57 /* !! */  = "@string/firmware_version_str";
            l.a.q.g0.u.n((TextView)var25_16, (String)var64_57 /* !! */ , var60_54, var29_19);
        }
        if ((var23_14 = (int)((cfr_temp_8 = (var2_2 = var62_56 & var15_10) - var13_9) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1))) != 0) {
            var25_16 = var1_1.h;
            var25_16.setVisibility(var39_30);
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
            this.t = l10 = 2048L;
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
                return this.J((MutableLiveData)object, n11);
            }
            case 6: {
                object = (MutableLiveData)object;
                return this.F((MutableLiveData)object, n11);
            }
            case 5: {
                object = (MutableLiveData)object;
                return this.I((MutableLiveData)object, n11);
            }
            case 4: {
                object = (MutableLiveData)object;
                return this.E((MutableLiveData)object, n11);
            }
            case 3: {
                object = (MutableLiveData)object;
                return this.G((MutableLiveData)object, n11);
            }
            case 2: {
                object = (MutableLiveData)object;
                return this.K((MutableLiveData)object, n11);
            }
            case 1: {
                object = (MutableLiveData)object;
                return this.L((MutableLiveData)object, n11);
            }
            case 0: 
        }
        object = (MutableLiveData)object;
        return this.H((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (FirmwareUpgradeFragment$b)object;
            this.B((FirmwareUpgradeFragment$b)object);
            return 1 != 0;
        } else {
            n11 = 38;
            if (n11 == n10) {
                object = (String)object;
                this.C((String)object);
                return 1 != 0;
            } else {
                n11 = 152;
                if (n11 != n10) return 0 != 0;
                object = (o)object;
                this.D((o)object);
            }
        }
        return 1 != 0;
    }
}

