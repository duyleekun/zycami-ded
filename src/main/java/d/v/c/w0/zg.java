/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.ScrollView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.yg;
import d.v.c.z0.k$c;
import d.v.c.z0.l;
import l.a.q.g0.u;

public class zg
extends yg
implements b$a {
    private static final ViewDataBinding$IncludedLayouts p;
    private static final SparseIntArray q;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private long o;

    static {
        SparseIntArray sparseIntArray;
        q = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363695, 9);
    }

    public zg(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = p;
        SparseIntArray sparseIntArray = q;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 10, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private zg(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[5];
        object2 = (CheckBox)object;
        Object object3 = object = objectArray[0];
        object3 = (ConstraintLayout)((Object)object);
        Object object4 = object = objectArray[3];
        object4 = (ScrollView)object;
        Object object5 = object = objectArray[6];
        object5 = (AppCompatTextView)object;
        Object object6 = object = objectArray[8];
        object6 = (AppCompatTextView)object;
        Object object7 = object = objectArray[2];
        object7 = (TextView)object;
        Object object8 = object = objectArray[4];
        object8 = (TextView)object;
        int n10 = 1;
        Object object9 = object = objectArray[n10];
        object9 = (TextView)object;
        Object object10 = object = objectArray[7];
        object10 = (View)object;
        Object object11 = object = objectArray[9];
        object11 = (View)object;
        object = this;
        super(dataBindingComponent, view, 6, (CheckBox)object2, (ConstraintLayout)((Object)object3), (ScrollView)object4, (AppCompatTextView)object5, (AppCompatTextView)object6, (TextView)object7, (TextView)object8, (TextView)object9, (View)object10, (View)object11);
        this.o = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n10);
        this.m = object;
        object = new b(this, 2);
        this.n = object;
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
                long l10 = this.o;
                long l11 = 16;
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
    private boolean D(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.o;
                long l11 = 4;
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
    private boolean E(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.o;
                long l11 = 32;
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
    private boolean F(MutableLiveData mutableLiveData, int n10) {
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
    private boolean G(MutableLiveData mutableLiveData, int n10) {
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
    private boolean H(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.o;
                long l11 = 8;
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
    public void A(k$c k$c) {
        this.k = k$c;
        synchronized (this) {
            long l10 = this.o;
            long l11 = 64;
            this.o = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(l l10) {
        this.l = l10;
        synchronized (this) {
            long l11 = this.o;
            long l12 = 128L;
            this.o = l11 |= l12;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                k$c k$c = this.k;
                if (k$c != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    k$c.b();
                }
            }
        } else {
            k$c k$c = this.k;
            if (k$c != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                k$c.a();
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
        var1_1 = this;
        synchronized (this) {
            var2_2 = this.o;
            this.o = var4_3 = 0L;
        }
        var6_4 = this.l;
        var7_5 = 447L & var2_2;
        var9_6 /* !! */  = var7_5 == var4_3 ? 0 : (var7_5 < var4_3 ? -1 : 1);
        var10_7 = 0x100000000L;
        var12_8 = 0x40000000L;
        var14_9 = 0x80000000L;
        var16_10 = 0x20000000L;
        var18_11 = 0x10000000L;
        var20_12 = 131072L;
        var22_13 = 392L;
        var24_14 = 388L;
        var26_15 = 385L;
        var28_16 = 387L;
        var30_17 = 386L;
        var32_18 = 420L;
        var34_19 = 8;
        var35_20 = 1.1E-44f;
        var36_21 = 0;
        if (var9_6 /* !! */  != false) {
            var37_22 = var2_2 & var26_15;
            cfr_temp_0 = var37_22 - var4_3;
            var9_6 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
            if (var9_6 /* !! */  != false) {
                if (var6_4 != null) {
                    var39_23 = var6_4.f();
                    var40_24 = var39_23;
                } else {
                    var41_25 = false;
                    var40_24 = null;
                }
                var1_1.updateLiveDataRegistration(0, (LiveData)var40_24);
                var42_26 = var40_24 != null ? (String)var40_24.getValue() : null;
                var43_27 = var42_26 == null ? 1 : 0;
                if (var9_6 /* !! */  != false) {
                    var2_2 = var43_27 != 0 ? var2_2 | var12_8 | var10_7 : var2_2 | var16_10 | var14_9;
                }
                var9_6 /* !! */  = var43_27 != 0 ? (long)var34_19 : (long)0;
            } else {
                var9_6 /* !! */  = 0;
                var43_27 = 0;
                var41_25 = false;
                var40_24 = null;
                var42_26 = null;
            }
            var44_28 = var2_2 & var28_16;
            var37_22 = 0L;
            var46_29 = var44_28 == var37_22 ? 0 : (var44_28 < var37_22 ? -1 : 1);
            if (var46_29 != false) {
                if (var6_4 != null) {
                    var47_30 = var6_4.e();
                    var48_31 = var47_30;
                } else {
                    var49_32 = false;
                    var48_31 = null;
                }
                var50_33 = 1;
                var1_1.updateLiveDataRegistration(var50_33, (LiveData)var48_31);
                if (var48_31 != null) {
                    var48_31 = (String)var48_31.getValue();
                } else {
                    var49_32 = false;
                    var48_31 = null;
                }
                var51_34 = var48_31 == null ? var50_33 : 0;
                var52_35 = var2_2 & var30_17;
                var37_22 = 0L;
                var54_36 = var52_35 == var37_22 ? 0 : (var52_35 < var37_22 ? -1 : 1);
                if (var54_36 != 0) {
                    if (var51_34 != 0) {
                        var2_2 |= 4096L;
                        var52_35 = 65536L;
                    } else {
                        var2_2 |= 2048L;
                        var52_35 = 32768L;
                    }
                    var2_2 |= var52_35;
                }
                if ((var54_36 = (cfr_temp_1 = (var52_35 = var2_2 & var28_16) - (var37_22 = 0L)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != 0) {
                    if (var51_34 != 0) {
                        var52_35 = 262144L;
                        var2_2 |= var52_35;
                    } else {
                        var2_2 |= var20_12;
                    }
                }
                if ((var54_36 = (cfr_temp_2 = (var52_35 = var2_2 & var30_17) - var37_22) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != 0 && var51_34 != 0) {
                    var54_36 = var34_19;
                    var55_37 = var35_20;
                } else {
                    var54_36 = 0;
                    var55_38 = 0.0f;
                }
            } else {
                var50_33 = 1;
                var37_22 = 0L;
                var51_34 = 0;
                var54_36 = 0;
                var55_39 = 0.0f;
                var49_32 = false;
                var48_31 = null;
            }
            var56_40 = var2_2 & var32_18;
            var58_41 = var56_40 == var37_22 ? 0 : (var56_40 < var37_22 ? -1 : 1);
            if (var58_41 != false) {
                if (var6_4 != null) {
                    var59_42 = var6_4.c();
                    var60_43 = var6_4.d();
                    var61_44 = var59_42;
                    var62_45 = var60_43;
                } else {
                    var50_33 = 0;
                    var61_44 = null;
                    var63_46 = 0;
                    var62_45 = null;
                }
                var1_1.updateLiveDataRegistration(2, (LiveData)var61_44);
                var64_47 = 5;
                var1_1.updateLiveDataRegistration(var64_47, (LiveData)var62_45);
                if (var61_44 != null) {
                    var61_44 = (String)var61_44.getValue();
                } else {
                    var50_33 = 0;
                    var61_44 = null;
                }
                if (var62_45 != null) {
                    var62_45 = (Boolean)var62_45.getValue();
                } else {
                    var63_46 = 0;
                    var62_45 = null;
                }
                var64_47 = var61_44 == null ? 1 : 0;
                var63_46 = ViewDataBinding.safeUnbox((Boolean)var62_45);
                var65_48 = var2_2 & var24_14;
                var37_22 = 0L;
                var67_49 = var65_48 == var37_22 ? 0 : (var65_48 < var37_22 ? -1 : 1);
                if (var67_49 != false) {
                    var65_48 = var64_47 != 0 ? 0x100000L : 524288L;
                    var2_2 |= var65_48;
                }
                if ((var67_49 = (cfr_temp_3 = (var65_48 = var2_2 & var32_18) - var37_22) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) {
                    var65_48 = var64_47 != 0 ? 0x400000000L : 0x200000000L;
                    var2_2 |= var65_48;
                }
                if ((var67_49 = (cfr_temp_4 = (var65_48 = var2_2 & var32_18) - var37_22) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) != false) {
                    if (var63_46 != 0) {
                        var2_2 |= var18_11;
                    } else {
                        var65_48 = 0x8000000L;
                        var2_2 |= var65_48;
                    }
                }
            } else {
                var37_22 = 0L;
                var63_46 = 0;
                var62_45 = null;
                var64_47 = 0;
                var50_33 = 0;
                var61_44 = null;
            }
            if ((var67_49 = (cfr_temp_5 = (var65_48 = var2_2 & var22_13) - var37_22) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1)) != false) {
                if (var6_4 != null) {
                    var68_50 = var6_4.g();
                    var69_51 = var68_50;
                } else {
                    var69_51 = null;
                }
                var70_52 = 3;
                var1_1.updateLiveDataRegistration(var70_52, (LiveData)var69_51);
                var69_51 = var69_51 != null ? (String)var69_51.getValue() : null;
                var70_52 = var69_51 == null ? 1 : 0;
                if (var67_49 != false) {
                    if (var70_52 != 0) {
                        var2_2 |= 0x4000000L;
                        var71_53 = 0x1000000000L;
                    } else {
                        var2_2 |= 0x2000000L;
                        var71_53 = 0x800000000L;
                    }
                    var2_2 |= var71_53;
                }
                if (var70_52 != 0) {
                    var67_49 = var34_19;
                    var73_54 = var35_20;
                } else {
                    var67_49 = 0;
                    var73_55 = 0.0f;
                }
            } else {
                var70_52 = 0;
                var67_49 = 0;
                var73_56 = 0.0f;
                var69_51 = null;
            }
            var74_57 = 400L;
            var71_53 = var2_2 & var74_57;
            var37_22 = 0L;
            var76_58 = var71_53 == var37_22 ? 0 : (var71_53 < var37_22 ? -1 : 1);
            if (var76_58 != false) {
                if (var6_4 != null) {
                    var77_59 = var6_4.b();
                    var78_60 = var77_59;
                } else {
                    var79_61 = false;
                    var78_60 = null;
                }
                var80_62 = 4;
                var1_1.updateLiveDataRegistration(var80_62, (LiveData)var78_60);
                if (var78_60 != null) {
                    var78_60 = (String)var78_60.getValue();
                } else {
                    var79_61 = false;
                    var78_60 = null;
                }
                if (var78_60 == null) {
                    var80_62 = 1;
                } else {
                    var80_62 = 0;
                    var81_63 = null;
                }
                if (var76_58 != false) {
                    var82_64 = var80_62 != 0 ? 0x400000L : 0x200000L;
                    var2_2 |= var82_64;
                }
                if (var80_62 != 0) {
                    var80_62 = var34_19;
                } else {
                    var80_62 = 0;
                    var81_63 = null;
                }
                var84_65 = var54_36;
                var85_66 = var67_49;
            } else {
                var80_62 = 0;
                var81_63 = null;
                var84_65 = var54_36;
                var85_66 = var67_49;
                var79_61 = false;
                var78_60 = null;
            }
        } else {
            var9_6 /* !! */  = 0;
            var70_52 = 0;
            var80_62 = 0;
            var81_63 = null;
            var63_46 = 0;
            var62_45 = null;
            var64_47 = 0;
            var51_34 = 0;
            var43_27 = 0;
            var84_65 = 0;
            var85_66 = 0;
            var41_25 = false;
            var40_24 = null;
            var42_26 = null;
            var69_51 = null;
            var79_61 = false;
            var78_60 = null;
            var49_32 = false;
            var48_31 = null;
            var50_33 = 0;
            var61_44 = null;
        }
        var20_12 = var2_2 & var20_12;
        var37_22 = 0L;
        var86_67 = var20_12 == var37_22 ? 0 : (var20_12 < var37_22 ? -1 : 1);
        if (var86_67 != false) {
            if (var6_4 != null) {
                var40_24 = var6_4.f();
            }
            var1_1.updateLiveDataRegistration(0, (LiveData)var40_24);
            if (var40_24 != null) {
                var42_26 = var6_4 = var40_24.getValue();
                var42_26 = (String)var6_4;
            }
            var43_27 = var42_26 == null ? 1 : 0;
            var20_12 = var2_2 & var26_15;
            var37_22 = 0L;
            cfr_temp_6 = var20_12 - var37_22;
            var87_68 /* !! */  = (long)(cfr_temp_6 == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1));
            if (var87_68 /* !! */  != false) {
                if (var43_27 != 0) {
                    var2_2 |= 0x40000000L;
                    var20_12 = 0x100000000L;
                } else {
                    var2_2 |= 0x20000000L;
                    var20_12 = 0x80000000L;
                }
                var2_2 |= var20_12;
            }
        }
        if ((var87_68 /* !! */  = (cfr_temp_7 = (var20_12 = var2_2 & var30_17) - (var37_22 = 0L)) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1)) != false) {
            var6_4 = var51_34 != 0 ? "" : var48_31;
        } else {
            var87_68 /* !! */  = 0;
            var6_4 = null;
        }
        var20_12 = var2_2 & var24_14;
        var41_25 = var20_12 == var37_22 ? 0 : (var20_12 < var37_22 ? -1 : 1);
        if (var41_25) {
            var40_24 = var64_47 != 0 ? "" : var61_44;
        } else {
            var41_25 = false;
            var40_24 = null;
        }
        var18_11 = var2_2 & var18_11;
        var49_32 = var18_11 == var37_22 ? 0 : (var18_11 < var37_22 ? -1 : 1);
        if (var49_32 && var61_44 != null) {
            var49_32 = true;
        } else {
            var49_32 = false;
            var48_31 = null;
        }
        var18_11 = var2_2 & var32_18;
        var50_33 = (int)(var18_11 == var37_22 ? 0 : (var18_11 < var37_22 ? -1 : 1));
        if (var50_33 == 0) ** GOTO lbl-1000
        var64_47 = var64_47 != 0 ? 1 : var63_46;
        if (var50_33 != 0) {
            var18_11 = var64_47 != 0 ? 0x1000000L : 0x800000L;
            var2_2 |= var18_11;
        }
        if (var64_47 != 0) {
            var50_33 = var34_19;
        } else lbl-1000:
        // 2 sources

        {
            var50_33 = 0;
            var61_44 = null;
        }
        var18_11 = var2_2 & var22_13;
        var20_12 = 0L;
        var64_47 = (int)(var18_11 == var20_12 ? 0 : (var18_11 < var20_12 ? -1 : 1));
        if (var64_47 != 0) {
            if (var70_52 != 0) {
                var69_51 = "";
            }
        } else {
            var69_51 = null;
        }
        if ((var70_52 = (int)((cfr_temp_8 = (var18_11 = var2_2 & var28_16) - var20_12) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1))) == 0) ** GOTO lbl-1000
        var58_41 = var51_34 != 0 ? (long)1 : (long)var43_27;
        if (var70_52 != 0) {
            var88_69 = var58_41 != false ? 16384L : 8192L;
            var2_2 |= var88_69;
        }
        if (var58_41 != false) {
            var70_52 = var34_19;
        } else lbl-1000:
        // 2 sources

        {
            var70_52 = 0;
        }
        var88_69 = var2_2 & var32_18;
        var90_70 = 0L;
        var64_47 = (int)(var88_69 == var90_70 ? 0 : (var88_69 < var90_70 ? -1 : 1));
        if (var64_47 != 0) {
            if (var63_46 == 0) {
                var49_32 = false;
                var48_31 = null;
            }
            if (var64_47 != 0) {
                var16_10 = var49_32 != false ? 1024L : 512L;
                var2_2 |= var16_10;
            }
            if (var49_32) {
                var34_19 = 0;
                var35_20 = 0.0f;
            }
            var36_21 = var34_19;
        }
        if (var49_32 = (cfr_temp_9 = (var16_10 = var2_2 & var26_15) - (var88_69 = 0L)) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1)) {
            if (var43_27 != 0) {
                var42_26 = "";
            }
        } else {
            var42_26 = null;
        }
        if ((var63_46 = (int)((cfr_temp_10 = (var16_10 = 400L & var2_2) - var88_69) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1))) != 0) {
            var1_1.a.setVisibility(var80_62);
            var81_63 = var1_1.a;
            var63_46 = 0;
            var62_45 = null;
            u.n((TextView)var81_63, (String)var78_60, null, null);
        }
        if (var79_61 = (cfr_temp_11 = (var12_8 = var2_2 & var32_18) - var88_69) == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1)) {
            var1_1.c.setVisibility(var36_21);
            var78_60 = var1_1.f;
            var78_60.setVisibility(var50_33);
        }
        if (var79_61 = (cfr_temp_12 = (var12_8 = 256L & var2_2) - var88_69) == 0L ? 0 : (cfr_temp_12 < 0L ? -1 : 1)) {
            var78_60 = var1_1.d;
            var81_63 = var1_1.m;
            var78_60.setOnClickListener((View.OnClickListener)var81_63);
            var78_60 = var1_1.e;
            var81_63 = var1_1.n;
            var78_60.setOnClickListener((View.OnClickListener)var81_63);
        }
        if (var79_61 = (cfr_temp_13 = (var12_8 = var2_2 & var30_17) - var88_69) == 0L ? 0 : (cfr_temp_13 < 0L ? -1 : 1)) {
            var78_60 = var1_1.d;
            var36_21 = var84_65;
            var78_60.setVisibility(var84_65);
            var78_60 = var1_1.d;
            var80_62 = 0;
            var81_63 = null;
            u.n((TextView)var78_60, (String)var6_4, null, null);
        } else {
            var80_62 = 0;
            var81_63 = null;
        }
        if (var49_32) {
            var1_1.e.setVisibility((int)var9_6 /* !! */ );
            var6_4 = var1_1.e;
            u.n((TextView)var6_4, (String)var42_26, null, null);
        }
        if ((var87_68 /* !! */  = (cfr_temp_14 = (var92_71 = var2_2 & var24_14) - (var14_9 = 0L)) == 0L ? 0 : (cfr_temp_14 < 0L ? -1 : 1)) != false) {
            u.n(var1_1.f, (String)var40_24, null, null);
            var6_4 = var1_1.g;
            u.n((TextView)var6_4, (String)var40_24, null, null);
        }
        if ((var87_68 /* !! */  = (cfr_temp_15 = (var4_3 = var2_2 & var22_13) - var14_9) == 0L ? 0 : (cfr_temp_15 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.h;
            var36_21 = var85_66;
            var6_4.setVisibility(var85_66);
            var6_4 = var1_1.h;
            u.n((TextView)var6_4, (String)var69_51, null, null);
        }
        if ((var87_68 /* !! */  = (cfr_temp_16 = (var2_2 &= var28_16) - var14_9) == 0L ? 0 : (cfr_temp_16 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.i;
            var6_4.setVisibility(var70_52);
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
                    n12 = 3;
                    if (n10 != n12) {
                        n12 = 4;
                        if (n10 != n12) {
                            n12 = 5;
                            if (n10 != n12) {
                                return false;
                            }
                            object = (MutableLiveData)object;
                            return this.E((MutableLiveData)object, n11);
                        }
                        object = (MutableLiveData)object;
                        return this.C((MutableLiveData)object, n11);
                    }
                    object = (MutableLiveData)object;
                    return this.H((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.D((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.F((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.G((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (k$c)object;
            this.A((k$c)object);
            return 1 != 0;
        } else {
            n11 = 152;
            if (n11 != n10) return 0 != 0;
            object = (l)object;
            this.B((l)object);
        }
        return 1 != 0;
    }
}

