/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import d.v.c.n0.a;
import d.v.c.s0.a7.l1$b;
import d.v.c.w0.j2;
import d.v.c.w0.k2$a;
import d.v.c.w0.k2$b;
import d.v.c.w0.k2$c;
import d.v.c.w0.k2$d;
import d.v.c.w0.k2$e;
import d.v.c.w0.k2$f;
import d.v.c.w0.k2$g;
import l.a.q.g0.u;

public class k2
extends j2 {
    private static final ViewDataBinding$IncludedLayouts y;
    private static final SparseIntArray z;
    private final ConstraintLayout j;
    private final LinearLayout k;
    private final ImageView l;
    private final TextView m;
    private final ImageView n;
    private final LinearLayout o;
    private final TextView p;
    private k2$g q;
    private k2$a r;
    private k2$b s;
    private k2$c t;
    private k2$d u;
    private k2$e v;
    private k2$f w;
    private long x;

    static {
        SparseIntArray sparseIntArray;
        z = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363608, 12);
        sparseIntArray.put(2131363673, 13);
    }

    public k2(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = y;
        SparseIntArray sparseIntArray = z;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 14, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private k2(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[7];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[9];
        object4 = (ImageView)object2;
        Object object5 = object2 = objectArray[2];
        object5 = (ImageView)object2;
        Object object6 = object2 = objectArray[4];
        object6 = (ImageView)object2;
        Object object7 = object2 = objectArray[11];
        object7 = (TextView)object2;
        Object object8 = object2 = objectArray[12];
        object8 = (TextView)object2;
        Object object9 = object2 = objectArray[13];
        object9 = (View)object2;
        super(object, view, 4, (ImageView)object3, (ImageView)object4, (ImageView)object5, (ImageView)object6, (TextView)object7, (TextView)object8, (View)object9);
        this.x = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.j = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[1];
        this.k = object;
        object.setTag(null);
        object = (ImageView)objectArray[10];
        this.l = object;
        object.setTag(null);
        object = (TextView)objectArray[3];
        this.m = object;
        object.setTag(null);
        object = (ImageView)objectArray[5];
        this.n = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[6];
        this.o = object;
        object.setTag(null);
        object = (TextView)objectArray[8];
        this.p = object;
        object.setTag(null);
        this.e.setTag(null);
        this.setRootTag(view);
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
                long l10 = this.x;
                long l11 = 8;
                this.x = l10 |= l11;
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
                long l10 = this.x;
                long l11 = 4;
                this.x = l10 |= l11;
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
                long l10 = this.x;
                long l11 = 2;
                this.x = l10 |= l11;
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
                long l10 = this.x;
                long l11 = 1L;
                this.x = l10 |= l11;
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
    public void A(BleViewModel bleViewModel) {
        this.h = bleViewModel;
        synchronized (this) {
            long l10 = this.x;
            long l11 = 16;
            this.x = l10 |= l11;
        }
        this.notifyPropertyChanged(12);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(l1$b l1$b) {
        this.i = l1$b;
        synchronized (this) {
            long l10 = this.x;
            long l11 = 32;
            this.x = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block81: {
            block80: {
                block79: {
                    block77: {
                        block78: {
                            block73: {
                                block76: {
                                    block75: {
                                        block74: {
                                            var1_1 = this;
                                            synchronized (this) {
                                                var2_2 = this.x;
                                                this.x = var4_3 = 0L;
                                            }
                                            var6_4 = this.h;
                                            var7_5 = this.i;
                                            var8_6 = (long)95 & var2_2;
                                            var10_7 = var8_6 == var4_3 ? 0 : (var8_6 < var4_3 ? -1 : 1);
                                            var11_8 = 0x100000L;
                                            var13_9 = 1024L;
                                            var15_10 = 262144L;
                                            var17_11 = 88;
                                            var19_12 = 84;
                                            var21_13 = 65536L;
                                            var23_14 = 82;
                                            var25_15 = 81;
                                            var27_16 = true;
                                            var28_17 = 0;
                                            if (var10_7 == false) break block73;
                                            var29_18 = var2_2 & var25_15;
                                            var10_7 = var29_18 == var4_3 ? 0 : (var29_18 < var4_3 ? -1 : 1);
                                            var31_19 = 8;
                                            var32_20 = 1.1E-44f;
                                            if (var10_7 == false) ** GOTO lbl-1000
                                            if (var6_4 != null) {
                                                var33_21 = var6_4.H;
                                            } else {
                                                var34_22 = 0;
                                                var35_23 = 0.0f;
                                                var33_21 = null;
                                            }
                                            var1_1.updateLiveDataRegistration(0, (LiveData)var33_21);
                                            if (var33_21 != null) {
                                                var33_21 = (Boolean)var33_21.getValue();
                                            } else {
                                                var34_22 = 0;
                                                var35_23 = 0.0f;
                                                var33_21 = null;
                                            }
                                            var34_22 = ViewDataBinding.safeUnbox((Boolean)var33_21);
                                            if (var10_7 != false) {
                                                var36_24 = var34_22 != 0 ? 16384L : 8192L;
                                                var2_2 |= var36_24;
                                            }
                                            if (var34_22 == 0) {
                                                var10_7 = var31_19;
                                                var38_25 = var32_20;
                                            } else lbl-1000:
                                            // 2 sources

                                            {
                                                var10_7 = 0;
                                                var38_25 = 0.0f;
                                            }
                                            var39_26 = var2_2 & var23_14;
                                            var34_22 = var39_26 == var4_3 ? 0 : (var39_26 < var4_3 ? -1 : 1);
                                            if (var34_22 == 0) break block74;
                                            if (var6_4 != null) {
                                                var41_27 = var6_4.I;
                                            } else {
                                                var42_28 = 0;
                                                var43_29 = 0.0f;
                                                var41_27 = null;
                                            }
                                            var1_1.updateLiveDataRegistration((int)var27_16, (LiveData)var41_27);
                                            if (var41_27 != null) {
                                                var41_27 = (Boolean)var41_27.getValue();
                                            } else {
                                                var42_28 = 0;
                                                var43_29 = 0.0f;
                                                var41_27 = null;
                                            }
                                            var42_28 = ViewDataBinding.safeUnbox((Boolean)var41_27);
                                            if (var34_22 != 0) {
                                                var36_24 = var42_28 != 0 ? 4096L : 2048L;
                                                var2_2 |= var36_24;
                                            }
                                            if (var42_28 == 0) break block75;
                                        }
                                        var31_19 = 0;
                                        var32_20 = 0.0f;
                                    }
                                    if ((var34_22 = (cfr_temp_0 = (var39_26 = var2_2 & var19_12) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != 0) {
                                        if (var6_4 != null) {
                                            var41_27 = var6_4.J;
                                        } else {
                                            var42_28 = 0;
                                            var43_29 = 0.0f;
                                            var41_27 = null;
                                        }
                                        var27_16 = 2 != 0;
                                        var1_1.updateLiveDataRegistration((int)var27_16, (LiveData)var41_27);
                                        if (var41_27 != null) {
                                            var41_27 = (Float)var41_27.getValue();
                                        } else {
                                            var42_28 = 0;
                                            var43_29 = 0.0f;
                                            var41_27 = null;
                                        }
                                        var27_16 = var41_27 != null;
                                        if (var34_22 != 0) {
                                            if (var27_16) {
                                                var2_2 = var2_2 | var13_9 | var21_13 | var11_8;
                                            } else {
                                                var2_2 = var2_2 | 512L | 32768L;
                                                var44_30 = 524288L;
                                                var2_2 |= var44_30;
                                            }
                                        }
                                    } else {
                                        var27_16 = false;
                                        var42_28 = 0;
                                        var43_29 = 0.0f;
                                        var41_27 = null;
                                    }
                                    if ((var34_22 = (cfr_temp_1 = (var44_30 = var2_2 & var17_11) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) == 0) break block76;
                                    if (var6_4 != null) {
                                        var6_4 = var6_4.K;
                                    } else {
                                        var46_31 = 0;
                                        var47_32 = 0.0f;
                                        var6_4 = null;
                                    }
                                    var28_17 = 3;
                                    var1_1.updateLiveDataRegistration(var28_17, (LiveData)var6_4);
                                    if (var6_4 != null) {
                                        var6_4 = (Float)var6_4.getValue();
                                    } else {
                                        var46_31 = 0;
                                        var47_32 = 0.0f;
                                        var6_4 = null;
                                    }
                                    var28_17 = var6_4 != null ? 1 : 0;
                                    if (var34_22 != 0) {
                                        if (var28_17 != 0) {
                                            var48_33 = 256L;
                                            var2_2 = var2_2 | var48_33 | var15_10;
                                            var50_34 = 0x400000L;
                                            var2_2 |= var50_34;
                                        } else {
                                            var2_2 = var2_2 | 128L | 131072L;
                                            var52_35 = 0x200000L;
                                            var2_2 |= var52_35;
                                        }
                                    }
                                    var34_22 = var31_19;
                                    var35_23 = var32_20;
                                    break block77;
                                }
                                var34_22 = var31_19;
                                var35_23 = var32_20;
                                var46_31 = 0;
                                var47_32 = 0.0f;
                                var6_4 = null;
                                break block78;
                            }
                            var46_31 = 0;
                            var47_32 = 0.0f;
                            var6_4 = null;
                            var10_7 = 0;
                            var38_25 = 0.0f;
                            var34_22 = 0;
                            var35_23 = 0.0f;
                            var33_21 = null;
                            var42_28 = 0;
                            var43_29 = 0.0f;
                            var41_27 = null;
                            var27_16 = false;
                        }
                        var28_17 = 0;
                    }
                    var52_35 = var2_2 & (long)96;
                    var31_19 = (int)(var52_35 == var4_3 ? 0 : (var52_35 < var4_3 ? -1 : 1));
                    if (var31_19 != 0 && var7_5 != null) {
                        var54_36 = var1_1.q;
                        if (var54_36 == null) {
                            var1_1.q = var54_36 = new k2$g();
                        }
                        var54_36 = var54_36.b((l1$b)var7_5);
                        var55_37 = var1_1.r;
                        if (var55_37 == null) {
                            var1_1.r = var55_37 = new k2$a();
                        }
                        var55_37 = var55_37.b((l1$b)var7_5);
                        var56_38 = var1_1.s;
                        if (var56_38 == null) {
                            var1_1.s = var56_38 = new k2$b();
                        }
                        var56_38 = var56_38.b((l1$b)var7_5);
                        var57_39 = var1_1.t;
                        if (var57_39 == null) {
                            var1_1.t = var57_39 = new k2$c();
                        }
                        var57_39 = var57_39.b((l1$b)var7_5);
                        var58_40 /* !! */  = var1_1.u;
                        if (var58_40 /* !! */  == null) {
                            var1_1.u = var58_40 /* !! */  = new k2$d();
                        }
                        var58_40 /* !! */  = var58_40 /* !! */ .b((l1$b)var7_5);
                        var59_41 /* !! */  = var1_1.v;
                        if (var59_41 /* !! */  == null) {
                            var1_1.v = var59_41 /* !! */  = new k2$e();
                        }
                        var59_41 /* !! */  = var59_41 /* !! */ .b((l1$b)var7_5);
                        var60_42 = var58_40 /* !! */ ;
                        var58_40 /* !! */  = var1_1.w;
                        if (var58_40 /* !! */  == null) {
                            var58_40 /* !! */  = new k2$f();
                            var1_1.w = var58_40 /* !! */ ;
                        }
                        var58_40 /* !! */  = var58_40 /* !! */ .b((l1$b)var7_5);
                        var7_5 = var59_41 /* !! */ ;
                        var59_41 /* !! */  = var60_42;
                    } else {
                        var58_40 /* !! */  = null;
                        var59_41 /* !! */  = null;
                        var7_5 = null;
                        var54_36 = null;
                        var55_37 = null;
                        var56_38 = null;
                        var57_39 = null;
                    }
                    var61_43 = var2_2 & 0x110400L;
                    var63_44 = 0L;
                    var65_45 = var61_43 == var63_44 ? 0 : (var61_43 < var63_44 ? -1 : 1);
                    var66_46 = -10.0f;
                    var67_47 = 10.0f;
                    if (var65_45 != false) {
                        var43_29 = ViewDataBinding.safeUnbox((Float)var41_27);
                        cfr_temp_2 = (var21_13 = var2_2 & var21_13) - var63_44;
                        var68_48 /* !! */  = (long)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
                        if (var68_48 /* !! */  != false) {
                            var69_50 = String.valueOf(var43_29);
                        } else {
                            var68_48 /* !! */  = 0;
                            var69_50 = null;
                        }
                        var70_51 = var2_2 & 1024L;
                        var72_52 = var70_51 == var63_44 ? 0 : (var70_51 < var63_44 ? -1 : 1);
                        var72_52 = var72_52 != false && (var72_52 = var43_29 == var66_46 ? 0 : (var43_29 > var66_46 ? 1 : -1)) > false;
                        var52_35 = var2_2 & 0x100000L;
                        var73_53 = var52_35 == var63_44 ? 0 : (var52_35 < var63_44 ? -1 : 1);
                        if (var73_53 != false && (var42_28 = var43_29 == var67_47 ? 0 : (var43_29 < var67_47 ? -1 : 1)) < 0) {
                            var42_28 = 1;
                            var43_29 = 1.4E-45f;
                        } else {
                            var42_28 = 0;
                            var43_29 = 0.0f;
                            var41_27 = null;
                        }
                    } else {
                        var42_28 = 0;
                        var43_29 = 0.0f;
                        var41_27 = null;
                        var68_49 = false;
                        var69_50 = null;
                        var72_52 = false;
                    }
                    var52_35 = var2_2 & 0x440100L;
                    var73_53 = var52_35 == var63_44 ? 0 : (var52_35 < var63_44 ? -1 : 1);
                    if (var73_53 == false) break block79;
                    var47_32 = ViewDataBinding.safeUnbox((Float)var6_4);
                    cfr_temp_3 = (var15_10 = var2_2 & var15_10) - var63_44;
                    var74_54 /* !! */  = (int)(cfr_temp_3 == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1));
                    if (var74_54 /* !! */  != 0 && (var74_54 /* !! */  = var47_32 == var67_47 ? 0 : (var47_32 < var67_47 ? -1 : 1)) < 0) {
                        var74_54 /* !! */  = 1;
                        var75_55 = 1.4E-45f;
                    } else {
                        var74_54 /* !! */  = 0;
                        var75_55 = 0.0f;
                    }
                    var50_34 = var2_2 & 0x400000L;
                    var76_56 = (int)(var50_34 == var63_44 ? 0 : (var50_34 < var63_44 ? -1 : 1));
                    if (var76_56 != 0) {
                        var77_57 = String.valueOf(var47_32);
                    } else {
                        var76_56 = 0;
                        var77_57 = null;
                    }
                    var50_34 = var2_2 & 256L;
                    var78_58 = var50_34 == var63_44 ? 0 : (var50_34 < var63_44 ? -1 : 1);
                    if (var78_58 == false || (var46_31 = var47_32 == var66_46 ? 0 : (var47_32 > var66_46 ? 1 : -1)) <= 0) break block80;
                    var79_59 = 1;
                    var80_60 = 1.4E-45f;
                    break block81;
                }
                var74_54 /* !! */  = 0;
                var75_55 = 0.0f;
                var76_56 = 0;
                var77_57 = null;
            }
            var79_59 = 0;
            var80_60 = 0.0f;
        }
        var17_11 = var2_2 & var17_11;
        var46_31 = var17_11 == var63_44 ? 0 : (var17_11 < var63_44 ? -1 : 1);
        if (var46_31 != 0) {
            if (var28_17 == 0) {
                var79_59 = 0;
                var80_60 = 0.0f;
            }
            if (var28_17 == 0) {
                var74_54 /* !! */  = 0;
                var75_55 = 0.0f;
            }
            if (var28_17 == 0) {
                var77_57 = "0.0";
            }
            var28_17 = var74_54 /* !! */ ;
            var74_54 /* !! */  = var42_28;
            var75_55 = var43_29;
            var41_27 = var77_57;
            var76_56 = var34_22;
            var34_22 = var79_59;
            var35_23 = var80_60;
        } else {
            var76_56 = var34_22;
            var74_54 /* !! */  = var42_28;
            var75_55 = var43_29;
            var34_22 = 0;
            var35_23 = 0.0f;
            var33_21 = null;
            var42_28 = 0;
            var43_29 = 0.0f;
            var41_27 = null;
            var28_17 = 0;
        }
        var17_11 = var2_2 & var19_12;
        var19_12 = 0L;
        var81_61 = var17_11 == var19_12 ? 0 : (var17_11 < var19_12 ? -1 : 1);
        if (var81_61 != false) {
            if (!var27_16) {
                var72_52 = false;
            }
            if (!var27_16) {
                var69_50 = "0.0";
            }
            if (!var27_16) {
                var74_54 /* !! */  = 0;
                var75_55 = 0.0f;
            }
            var82_62 = var2_2;
            var84_63 = var69_50;
            var27_16 = var72_52;
            var85_64 = var74_54 /* !! */ ;
            var86_65 = var75_55;
            var74_54 /* !! */  = (int)var10_7;
            var75_55 = var38_25;
            var10_7 = var85_64;
            var38_25 = var86_65;
        } else {
            var82_62 = var2_2;
            var74_54 /* !! */  = (int)var10_7;
            var75_55 = var38_25;
            var84_63 = null;
            var10_7 = 0;
            var38_25 = 0.0f;
            var27_16 = false;
        }
        if (var31_19 != 0) {
            var1_1.a.setOnClickListener((View.OnClickListener)var59_41 /* !! */ );
            var1_1.b.setOnClickListener((View.OnClickListener)var58_40 /* !! */ );
            var1_1.c.setOnClickListener((View.OnClickListener)var57_39);
            var1_1.d.setOnClickListener((View.OnClickListener)var56_38);
            var1_1.l.setOnClickListener((View.OnClickListener)var7_5);
            var1_1.n.setOnClickListener((View.OnClickListener)var54_36);
            var87_66 = var1_1.e;
            var87_66.setOnClickListener((View.OnClickListener)var55_37);
        }
        if (var46_31 != 0) {
            d.v.c.n0.a.d(var1_1.a, (boolean)var34_22);
            d.v.c.n0.a.d(var1_1.b, (boolean)var28_17);
            var6_4 = var1_1.p;
            var87_66 = null;
            l.a.q.g0.u.n((TextView)var6_4, (String)var41_27, null, null);
        } else {
            var87_66 = null;
        }
        if (var81_61 != false) {
            d.v.c.n0.a.d(var1_1.c, var27_16);
            d.v.c.n0.a.d(var1_1.d, (boolean)var10_7);
            var6_4 = var1_1.m;
            l.a.q.g0.u.n((TextView)var6_4, var84_63, null, null);
        }
        if ((var46_31 = (int)((cfr_temp_4 = (var2_2 = var82_62 & var25_15) - (var4_3 = 0L)) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.k;
            var10_7 = var74_54 /* !! */ ;
            var38_25 = var75_55;
            var6_4.setVisibility(var74_54 /* !! */ );
        }
        if ((var46_31 = (int)((cfr_temp_5 = (var2_2 = var82_62 & var23_14) - var4_3) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.o;
            var6_4.setVisibility(var76_56);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.x;
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
            this.x = l10 = (long)64;
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
                        return false;
                    }
                    object = (MutableLiveData)object;
                    return this.C((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.D((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.E((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.F((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 12;
        if (n11 == n10) {
            object = (BleViewModel)object;
            this.A((BleViewModel)object);
            return 1 != 0;
        } else {
            n11 = 23;
            if (n11 != n10) return 0 != 0;
            object = (l1$b)object;
            this.B((l1$b)object);
        }
        return 1 != 0;
    }
}

