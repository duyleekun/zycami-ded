/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zhiyun.cama.main.MainFragment$d;
import com.zhiyun.cama.main.home.ExViewPager;
import d.v.c.i1.r2;
import d.v.c.w0.ge;
import d.v.c.w0.he$a;
import d.v.c.w0.he$b;
import d.v.c.w0.he$c;
import d.v.c.w0.he$d;
import d.v.c.w0.he$e;
import d.v.c.w0.he$f;
import d.v.c.w0.he$g;
import d.v.c.w0.he$h;
import d.v.c.w0.he$i;
import d.v.e.l.w1;
import d.v.f.e.c;

public class he
extends ge {
    private static final ViewDataBinding$IncludedLayouts D;
    private static final SparseIntArray E;
    private he$g A;
    private he$h B;
    private long C;
    private final ConstraintLayout j;
    private final TextView k;
    private final ImageView l;
    private final TextView m;
    private final TextView n;
    private final TextView o;
    private final TextView p;
    private final TextView q;
    private final TextView r;
    private final TextView s;
    private he$i t;
    private he$a u;
    private he$b v;
    private he$c w;
    private he$d x;
    private he$e y;
    private he$f z;

    static {
        SparseIntArray sparseIntArray;
        E = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362879, 15);
        sparseIntArray.put(2131362492, 16);
    }

    public he(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = D;
        SparseIntArray sparseIntArray = E;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 17, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private he(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[11];
        object3 = (BottomNavigationView)((Object)object2);
        Object object4 = object2 = objectArray[1];
        object4 = (FrameLayout)object2;
        Object object5 = object2 = objectArray[16];
        object5 = (FrameLayout)object2;
        Object object6 = object2 = objectArray[2];
        object6 = (ImageButton)object2;
        Object object7 = object2 = objectArray[15];
        object7 = (ExViewPager)((Object)object2);
        Object object8 = object2 = objectArray[13];
        object8 = (RelativeLayout)object2;
        Object object9 = object2 = objectArray[14];
        object9 = (View)object2;
        super(object, view, 6, (BottomNavigationView)((Object)object3), (FrameLayout)object4, (FrameLayout)object5, (ImageButton)object6, (ExViewPager)((Object)object7), (RelativeLayout)object8, (View)object9);
        this.C = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.d.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.j = object;
        object.setTag(null);
        object = (TextView)objectArray[10];
        this.k = object;
        object.setTag(null);
        object = (ImageView)objectArray[12];
        this.l = object;
        object.setTag(null);
        object = (TextView)objectArray[3];
        this.m = object;
        object.setTag(null);
        object = (TextView)objectArray[4];
        this.n = object;
        object.setTag(null);
        object = (TextView)objectArray[5];
        this.o = object;
        object.setTag(null);
        object = (TextView)objectArray[6];
        this.p = object;
        object.setTag(null);
        object = (TextView)objectArray[7];
        this.q = object;
        object.setTag(null);
        object = (TextView)objectArray[8];
        this.r = object;
        object.setTag(null);
        object = (TextView)objectArray[9];
        this.s = object;
        object.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
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
                long l10 = this.C;
                long l11 = 2;
                this.C = l10 |= l11;
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
                long l10 = this.C;
                long l11 = 1L;
                this.C = l10 |= l11;
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
                long l10 = this.C;
                long l11 = 4;
                this.C = l10 |= l11;
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
                long l10 = this.C;
                long l11 = 16;
                this.C = l10 |= l11;
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
                long l10 = this.C;
                long l11 = 8;
                this.C = l10 |= l11;
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
                long l10 = this.C;
                long l11 = 32;
                this.C = l10 |= l11;
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
    public void A(MainFragment$d mainFragment$d) {
        this.h = mainFragment$d;
        synchronized (this) {
            long l10 = this.C;
            long l11 = 64;
            this.C = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(r2 r22) {
        this.i = r22;
        synchronized (this) {
            long l10 = this.C;
            long l11 = 128L;
            this.C = l10 |= l11;
        }
        this.notifyPropertyChanged(153);
        super.requestRebind();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block90: {
            block92: {
                block89: {
                    block93: {
                        var1_1 = this;
                        synchronized (this) {
                            var2_2 = this.C;
                            this.C = var4_3 = 0L;
                        }
                        var6_4 = this.h;
                        var7_5 /* !! */  = this.i;
                        var8_6 = 256L;
                        var10_7 = var2_2 & var8_6;
                        var12_8 = var10_7 == var4_3 ? 0 : (var10_7 < var4_3 ? -1 : 1);
                        if (var12_8 != false && var12_8 != false) {
                            var13_9 = "zh_CN".toLowerCase();
                            var12_8 = (long)var13_9.equals(var14_10 = w1.a());
                            if (var12_8 != false) {
                                var2_2 |= 0x1000000L;
                                var10_7 = 0x4000000L;
                            } else {
                                var2_2 |= 0x800000L;
                                var10_7 = 0x2000000L;
                            }
                            var2_2 |= var10_7;
                        }
                        if ((var17_12 = (cfr_temp_0 = (var15_11 = var2_2 & (var10_7 = 320L)) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false && var6_4 != null) {
                            var18_13 = var1_1.t;
                            if (var18_13 == null) {
                                var1_1.t = var18_13 = new he$i();
                            }
                            var18_13 = var18_13.b((MainFragment$d)var6_4);
                            var19_14 = var1_1.u;
                            if (var19_14 == null) {
                                var1_1.u = var19_14 = new he$a();
                            }
                            var19_14 = var19_14.b((MainFragment$d)var6_4);
                            var20_15 = var1_1.v;
                            if (var20_15 == null) {
                                var1_1.v = var20_15 = new he$b();
                            }
                            var20_15 = var20_15.b((MainFragment$d)var6_4);
                            var21_16 = var1_1.w;
                            if (var21_16 == null) {
                                var1_1.w = var21_16 = new he$c();
                            }
                            var21_16 = var21_16.b((MainFragment$d)var6_4);
                            var22_17 = var1_1.x;
                            if (var22_17 == null) {
                                var1_1.x = var22_17 = new he$d();
                            }
                            var22_17 = var22_17.b((MainFragment$d)var6_4);
                            var23_18 = var1_1.y;
                            if (var23_18 == null) {
                                var1_1.y = var23_18 = new he$e();
                            }
                            var23_18 = var23_18.b((MainFragment$d)var6_4);
                            var24_19 = var1_1.z;
                            if (var24_19 == null) {
                                var1_1.z = var24_19 = new he$f();
                            }
                            var24_19 = var24_19.b((MainFragment$d)var6_4);
                            var13_9 = var1_1.A;
                            if (var13_9 == null) {
                                var1_1.A = var13_9 = new he$g();
                            }
                            var13_9 = var13_9.b((MainFragment$d)var6_4);
                            var14_10 = var1_1.B;
                            if (var14_10 == null) {
                                var1_1.B = var14_10 = new he$h();
                            }
                            var6_4 = var14_10.b((MainFragment$d)var6_4);
                        } else {
                            var25_20 = 0;
                            var21_16 = null;
                            var6_4 = null;
                            var23_18 = null;
                            var24_19 = null;
                            var12_8 = 0;
                            var13_9 = null;
                            var17_12 = 0;
                            var18_13 = null;
                            var22_17 = null;
                            var19_14 = null;
                            var20_15 = null;
                        }
                        var26_21 /* !! */  = (cfr_temp_1 = (var2_2 & 447L) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1);
                        var27_22 = 392L;
                        var29_23 = 0x10000000L;
                        var31_24 = 388L;
                        var33_25 = 1024L;
                        var35_26 = 8;
                        var36_27 = 1.1E-44f;
                        var37_28 = 401L;
                        var39_29 = 385L;
                        var41_30 = 419L;
                        var43_31 = 0;
                        var44_32 = 0.0f;
                        var45_33 = null;
                        if (var26_21 /* !! */  == false) break block92;
                        var46_34 = var2_2 & 435L;
                        var48_35 = 0L;
                        cfr_temp_2 = var46_34 - var48_35;
                        var26_21 /* !! */  = (long)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
                        if (var26_21 /* !! */  == false) break block93;
                        if (var7_5 /* !! */  != null) {
                            var14_10 = var7_5 /* !! */ .g;
                        } else {
                            var26_21 /* !! */  = 0;
                            var14_10 = null;
                        }
                        var1_1.updateLiveDataRegistration(0, (LiveData)var14_10);
                        if (var14_10 != null) {
                            var14_10 = (Boolean)var14_10.getValue();
                        } else {
                            var26_21 /* !! */  = 0;
                            var14_10 = null;
                        }
                        var46_34 = var2_2 & var39_29;
                        var48_35 = 0L;
                        var50_36 = var46_34 == var48_35 ? 0 : (var46_34 < var48_35 ? -1 : 1);
                        if (var50_36) {
                            var51_37 = var14_10 == null;
                            if (var50_36) {
                                var52_38 = var51_37 != false ? 16384L : 8192L;
                                var2_2 |= var52_38;
                            }
                        } else {
                            var51_37 = false;
                        }
                        var50_36 = ViewDataBinding.safeUnbox((Boolean)var14_10);
                        var52_38 = var2_2 & var41_30;
                        var48_35 = 0L;
                        cfr_temp_3 = var52_38 - var48_35;
                        var54_39 /* !! */  = (long)(cfr_temp_3 == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1));
                        if (var54_39 /* !! */  != false) {
                            if (var50_36) {
                                var2_2 |= var33_25;
                            } else {
                                var52_38 = 512L;
                                var2_2 |= var52_38;
                            }
                        }
                        if ((var54_39 /* !! */  = (cfr_temp_4 = (var52_38 = var2_2 & var37_28) - var48_35) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) != false) {
                            if (var50_36) {
                                var2_2 |= var29_23;
                                break block89;
                            } else {
                                var52_38 = 0x8000000L;
                                var2_2 |= var52_38;
                            }
                        }
                        break block89;
                    }
                    var48_35 = 0L;
                    var50_36 = false;
                    var51_37 = false;
                    var26_21 /* !! */  = 0;
                    var14_10 = null;
                }
                if ((var54_39 /* !! */  = (cfr_temp_5 = (var52_38 = var2_2 & var31_24) - var48_35) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1)) == false) ** GOTO lbl-1000
                if (var7_5 /* !! */  != null) {
                    var45_33 = var7_5 /* !! */ .i;
                } else {
                    var43_31 = 0;
                    var44_32 = 0.0f;
                    var45_33 = null;
                }
                var55_40 = 2;
                var56_41 = 2.8E-45f;
                var1_1.updateLiveDataRegistration(var55_40, (LiveData)var45_33);
                if (var45_33 != null) {
                    var57_42 = (Boolean)var45_33.getValue();
                } else {
                    var55_40 = 0;
                    var56_41 = 0.0f;
                    var57_42 = null;
                }
                var55_40 = (int)ViewDataBinding.safeUnbox((Boolean)var57_42);
                if (var54_39 /* !! */  != false) {
                    var58_43 = var55_40 != 0 ? 0x100000L : 524288L;
                    var2_2 |= var58_43;
                }
                if (var55_40 == 0) {
                    var55_40 = var35_26;
                    var56_41 = var36_27;
                } else lbl-1000:
                // 2 sources

                {
                    var55_40 = 0;
                    var56_41 = 0.0f;
                    var57_42 = null;
                }
                var58_43 = var2_2 & var27_22;
                var48_35 = 0L;
                var43_31 = var58_43 == var48_35 ? 0 : (var58_43 < var48_35 ? -1 : 1);
                var54_39 /* !! */  = var55_40;
                var60_44 = var56_41;
                if (var43_31 != 0) {
                    if (var7_5 /* !! */  != null) {
                        var57_42 = var7_5 /* !! */ .n;
                        var61_45 = var14_10;
                    } else {
                        var61_45 = var14_10;
                        var55_40 = 0;
                        var56_41 = 0.0f;
                        var57_42 = null;
                    }
                    var26_21 /* !! */  = 3;
                    var1_1.updateLiveDataRegistration((int)var26_21 /* !! */ , (LiveData)var57_42);
                    if (var57_42 != null) {
                        var57_42 = (Boolean)var57_42.getValue();
                    } else {
                        var55_40 = 0;
                        var56_41 = 0.0f;
                        var57_42 = null;
                    }
                    var55_40 = (int)ViewDataBinding.safeUnbox((Boolean)var57_42);
                    if (var43_31 != 0) {
                        var62_47 = var55_40 != 0 ? 0x400000L : 0x200000L;
                        var2_2 |= var62_47;
                    }
                    if (var55_40 != 0) {
                        var55_40 = 1065353216;
                        var56_41 = 1.0f;
                    } else {
                        var55_40 = 1053609165;
                        var56_41 = 0.4f;
                    }
                    var43_31 = (int)var54_39 /* !! */ ;
                    var44_32 = var60_44;
                    var14_10 = var61_45;
                    break block90;
                } else {
                    var61_46 = var14_10;
                    var43_31 = var55_40;
                    var44_32 = var56_41;
                    var55_40 = 0;
                    var56_41 = 0.0f;
                    var57_42 = null;
                }
                break block90;
            }
            var55_40 = 0;
            var56_41 = 0.0f;
            var57_42 = null;
            var43_31 = 0;
            var44_32 = 0.0f;
            var45_33 = null;
            var26_21 /* !! */  = 0;
            var14_10 = null;
            var50_36 = false;
            var51_37 = false;
        }
        var58_43 = var2_2 & var39_29;
        var48_35 = 0L;
        var64_48 = var58_43 == var48_35 ? 0 : (var58_43 < var48_35 ? -1 : 1);
        if (var64_48 != false) {
            var26_21 /* !! */  = var51_37 ? (long)1 : (long)var14_10.booleanValue();
        } else {
            var26_21 /* !! */  = 0;
            var14_10 = null;
        }
        var33_25 = var2_2 & var33_25;
        var64_48 = var33_25 == var48_35 ? 0 : (var33_25 < var48_35 ? -1 : 1);
        if (var64_48 != false) {
            var64_48 = var55_40;
            var65_49 = var56_41;
            if (var7_5 /* !! */  != null) {
                var57_42 = var7_5 /* !! */ .l;
                var66_50 = var43_31;
                var67_51 = var44_32;
            } else {
                var66_50 = var43_31;
                var67_51 = var44_32;
                var55_40 = 0;
                var56_41 = 0.0f;
                var57_42 = null;
            }
            var43_31 = 1;
            var44_32 = 1.4E-45f;
            var1_1.updateLiveDataRegistration(var43_31, (LiveData)var57_42);
            if (var57_42 != null) {
                var57_42 = (Boolean)var57_42.getValue();
            } else {
                var55_40 = 0;
                var56_41 = 0.0f;
                var57_42 = null;
            }
            var55_40 = (int)ViewDataBinding.safeUnbox((Boolean)var57_42);
        } else {
            var64_48 = var55_40;
            var65_49 = var56_41;
            var66_50 = var43_31;
            var67_51 = var44_32;
            var55_40 = 0;
            var56_41 = 0.0f;
            var57_42 = null;
        }
        var29_23 = var2_2 & var29_23;
        var48_35 = 0L;
        var43_31 = (int)(var29_23 == var48_35 ? 0 : (var29_23 < var48_35 ? -1 : 1));
        var68_52 = var55_40;
        var55_40 = 4;
        var56_41 = 5.6E-45f;
        if (var43_31 != 0) {
            if (var7_5 /* !! */  != null) {
                var45_33 = var7_5 /* !! */ .h;
            } else {
                var43_31 = 0;
                var44_32 = 0.0f;
                var45_33 = null;
            }
            var1_1.updateLiveDataRegistration(var55_40, (LiveData)var45_33);
            if (var45_33 != null) {
                var45_33 = (Boolean)var45_33.getValue();
            } else {
                var43_31 = 0;
                var44_32 = 0.0f;
                var45_33 = null;
            }
            var43_31 = (int)ViewDataBinding.safeUnbox((Boolean)var45_33);
        } else {
            var43_31 = 0;
            var44_32 = 0.0f;
            var45_33 = null;
        }
        var69_53 = var2_2 & var41_30;
        var48_35 = 0L;
        var71_54 = var69_53 == var48_35 ? 0 : (var69_53 < var48_35 ? -1 : 1);
        var69_53 = 262144L;
        if (var71_54 != false) {
            if (!var50_36) {
                var68_52 = 0;
            }
            if (var71_54 != false) {
                if (var68_52 != 0) {
                    var2_2 |= var69_53;
                } else {
                    var72_55 = 131072L;
                    var2_2 |= var72_55;
                }
            }
        } else {
            var68_52 = 0;
        }
        if ((var71_54 = (cfr_temp_6 = (var72_55 = var2_2 & var37_28) - (var48_35 = 0L)) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1)) != false) {
            if (!var50_36) {
                var43_31 = 0;
                var44_32 = 0.0f;
                var45_33 = null;
            }
            if (var71_54 != false) {
                var72_55 = var43_31 != 0 ? 4096L : 2048L;
                var2_2 |= var72_55;
            }
        } else {
            var43_31 = 0;
            var44_32 = 0.0f;
            var45_33 = null;
        }
        if ((var71_54 = (cfr_temp_7 = (var46_34 = var2_2 & var69_53) - (var48_35 = 0L)) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1)) != false) {
            if (var7_5 /* !! */  != null) {
                var7_5 /* !! */  = var7_5 /* !! */ .m;
            } else {
                var74_56 = false;
                var7_5 /* !! */  = null;
            }
            var55_40 = 5;
            var56_41 = 7.0E-45f;
            var1_1.updateLiveDataRegistration(var55_40, (LiveData)var7_5 /* !! */ );
            var75_57 = var7_5 /* !! */  != null ? (var57_42 = (Boolean)var7_5 /* !! */ .getValue()) : null;
            var55_40 = (int)ViewDataBinding.safeUnbox(var75_57);
        } else {
            var55_40 = 0;
            var56_41 = 0.0f;
            var57_42 = null;
        }
        var46_34 = var2_2 & var41_30;
        var48_35 = 0L;
        var74_56 = var46_34 == var48_35 ? 0 : (var46_34 < var48_35 ? -1 : 1);
        if (!var74_56) ** GOTO lbl-1000
        if (var68_52 == 0) {
            var55_40 = 0;
            var56_41 = 0.0f;
            var57_42 = null;
        }
        if (var74_56) {
            var46_34 = var55_40 != 0 ? 65536L : 32768L;
            var2_2 |= var46_34;
        }
        if (var55_40 == 0) {
            var55_40 = 4;
            var56_41 = 5.6E-45f;
        } else lbl-1000:
        // 2 sources

        {
            var55_40 = 0;
            var56_41 = 0.0f;
            var57_42 = null;
        }
        var29_23 = var2_2 & var39_29;
        var48_35 = 0L;
        var74_56 = var29_23 == var48_35 ? 0 : (var29_23 < var48_35 ? -1 : 1);
        if (var74_56) {
            var7_5 /* !! */  = var1_1.a;
            d.v.f.e.c.a((View)var7_5 /* !! */ , (boolean)var26_21 /* !! */ );
        }
        if (var74_56 = (cfr_temp_8 = (var29_23 = var2_2 & var37_28) - var48_35) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1)) {
            var7_5 /* !! */  = var1_1.b;
            d.v.f.e.c.a((View)var7_5 /* !! */ , (boolean)var43_31);
        }
        if ((var43_31 = (cfr_temp_9 = (var76_58 = var2_2 & 320L) - var48_35) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1)) != 0) {
            var1_1.d.setOnClickListener((View.OnClickListener)var23_18);
            var1_1.k.setOnClickListener((View.OnClickListener)var13_9);
            var1_1.l.setOnClickListener((View.OnClickListener)var18_13);
            var1_1.m.setOnClickListener((View.OnClickListener)var21_16);
            var1_1.n.setOnClickListener((View.OnClickListener)var19_14);
            var1_1.o.setOnClickListener((View.OnClickListener)var20_15);
            var1_1.p.setOnClickListener((View.OnClickListener)var22_17);
            var1_1.q.setOnClickListener((View.OnClickListener)var24_19);
            var1_1.r.setOnClickListener((View.OnClickListener)var6_4);
            var45_33 = var1_1.s;
            var45_33.setOnClickListener((View.OnClickListener)var21_16);
        }
        if ((var25_20 = (cfr_temp_10 = (var78_59 = 256L & var2_2) - (var80_60 = 0L)) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1)) != 0) {
            var21_16 = var1_1.m;
            var45_33 = "zh_CN".toLowerCase();
            var43_31 = var45_33.equals(var6_4 = w1.a());
            if (var43_31 != 0) {
                var43_31 = var35_26;
                var44_32 = var36_27;
            } else {
                var43_31 = 0;
                var44_32 = 0.0f;
                var45_33 = null;
            }
            var21_16.setVisibility(var43_31);
            var21_16 = var1_1.s;
            var45_33 = "zh_CN".toLowerCase();
            var6_4 = w1.a();
            var43_31 = (int)var45_33.equals(var6_4);
            if (var43_31 != 0) {
                var43_31 = 0;
                var44_32 = 0.0f;
                var45_33 = null;
            } else {
                var43_31 = var35_26;
                var44_32 = var36_27;
            }
            var21_16.setVisibility(var43_31);
        }
        if ((var25_20 = (cfr_temp_11 = (var78_59 = var2_2 & var31_24) - (var80_60 = 0L)) == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1)) != 0) {
            var21_16 = var1_1.r;
            var43_31 = var66_50;
            var44_32 = var67_51;
            var21_16.setVisibility(var66_50);
        }
        if ((var25_20 = (cfr_temp_12 = (var78_59 = var2_2 & var41_30) - var80_60) == 0L ? 0 : (cfr_temp_12 < 0L ? -1 : 1)) != 0) {
            var21_16 = var1_1.f;
            var21_16.setVisibility(var55_40);
        }
        if ((var25_20 = (cfr_temp_13 = (var2_2 &= var27_22) - var80_60) == 0L ? 0 : (cfr_temp_13 < 0L ? -1 : 1)) != 0 && (var25_20 = ViewDataBinding.getBuildSdkInt()) >= (var82_61 = 11)) {
            var21_16 = var1_1.g;
            var55_40 = (int)var64_48;
            var56_41 = var65_49;
            var21_16.setAlpha(var65_49);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.C;
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
            this.C = l10 = 256L;
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
                            return this.H((MutableLiveData)object, n11);
                        }
                        object = (MutableLiveData)object;
                        return this.F((MutableLiveData)object, n11);
                    }
                    object = (MutableLiveData)object;
                    return this.G((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.E((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.C((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.D((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (MainFragment$d)object;
            this.A((MainFragment$d)object);
            return 1 != 0;
        } else {
            n11 = 153;
            if (n11 != n10) return 0 != 0;
            object = (r2)object;
            this.B((r2)object);
        }
        return 1 != 0;
    }
}

