/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.CameraFragment$j;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.s0.d7.z;
import d.v.c.w0.kd;
import d.v.c.w0.md;
import d.v.c.w0.od;
import d.v.c.w0.qd;
import d.v.c.w0.sd;
import d.v.c.w0.si;
import d.v.c.w0.ud;
import d.v.c.w0.wd;
import d.v.c.w0.yd;

public class ti
extends si {
    private static final ViewDataBinding$IncludedLayouts n;
    private static final SparseIntArray o;
    private long m;

    static {
        int[] nArray;
        int[] nArray2;
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        n = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(10);
        String[] stringArray = new String[]{"layout_live_platfrom_choose", "layout_live_platfrom_login", "layout_live_introduce", "layout_live_setting", "layout_live_custom", "layout_live_restream_list", "layout_live_state", "layout_live_stop_state"};
        int n10 = 8;
        int[] nArray3 = nArray2 = new int[n10];
        int[] nArray4 = nArray2;
        nArray3[0] = 2;
        nArray4[1] = 3;
        nArray3[2] = 4;
        nArray4[3] = 5;
        nArray3[4] = 6;
        nArray4[5] = 7;
        nArray3[6] = 8;
        nArray4[7] = 9;
        int[] nArray5 = nArray = new int[n10];
        int[] nArray6 = nArray;
        nArray5[0] = 2131558672;
        nArray6[1] = 2131558673;
        nArray5[2] = 2131558671;
        nArray6[3] = 2131558675;
        nArray5[4] = 2131558670;
        nArray6[5] = 2131558674;
        nArray5[6] = 2131558676;
        nArray6[7] = 2131558677;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray2, nArray);
        o = null;
    }

    public ti(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = n;
        SparseIntArray sparseIntArray = o;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 10, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private ti(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[0];
        object2 = (ConstraintLayout)((Object)object);
        Object object3 = object = objectArray[2];
        object3 = (od)object;
        Object object4 = object = objectArray[6];
        object4 = (kd)object;
        Object object5 = object = objectArray[4];
        object5 = (md)object;
        Object object6 = object = objectArray[3];
        object6 = (qd)object;
        Object object7 = object = objectArray[7];
        object7 = (sd)object;
        Object object8 = object = objectArray[5];
        object8 = (ud)object;
        Object object9 = object = objectArray[8];
        object9 = (wd)object;
        Object object10 = object = objectArray[9];
        object10 = (yd)object;
        Object object11 = object = objectArray[1];
        object11 = (ZYTextView)object;
        object = this;
        super(dataBindingComponent, view, 10, (ConstraintLayout)((Object)object2), (od)object3, (kd)object4, (md)object5, (qd)object6, (sd)object7, (ud)object8, (wd)object9, (yd)object10, (ZYTextView)object11);
        this.m = -1;
        this.a.setTag(null);
        object = this.b;
        this.setContainedBinding((ViewDataBinding)object);
        object = this.c;
        this.setContainedBinding((ViewDataBinding)object);
        object = this.d;
        this.setContainedBinding((ViewDataBinding)object);
        object = this.e;
        this.setContainedBinding((ViewDataBinding)object);
        object = this.f;
        this.setContainedBinding((ViewDataBinding)object);
        object = this.g;
        this.setContainedBinding((ViewDataBinding)object);
        object = this.h;
        this.setContainedBinding((ViewDataBinding)object);
        object = this.i;
        this.setContainedBinding((ViewDataBinding)object);
        this.j.setTag(null);
        object = view;
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(od od2, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 8;
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
    private boolean D(kd kd2, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 64;
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
    private boolean E(md md2, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 512L;
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
    private boolean F(qd qd2, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 4;
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
    private boolean G(sd sd2, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 32;
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
    private boolean H(ud ud2, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 2;
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
    private boolean I(wd wd2, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 128L;
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
    private boolean J(yd yd2, int n10) {
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
    private boolean K(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 16;
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
    private boolean L(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 256L;
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
    public void A(CameraFragment$j cameraFragment$j) {
        this.k = cameraFragment$j;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 1024L;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(z z10) {
        this.l = z10;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 2048L;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(80);
        super.requestRebind();
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
                            var2_2 = this.m;
                            this.m = var4_3 = 0L;
                        }
                        var6_4 = this.k;
                        var7_5 = this.l;
                        var8_6 = 6416L & var2_2;
                        var10_7 = var8_6 == var4_3 ? 0 : (var8_6 < var4_3 ? -1 : 1);
                        var11_8 = 6160L;
                        var13_9 = 6400L;
                        if (var10_7 == false) break block41;
                        var15_10 = var2_2 & var11_8;
                        var10_7 = var15_10 == var4_3 ? 0 : (var15_10 < var4_3 ? -1 : 1);
                        var17_11 = 4;
                        var18_12 = 5.6E-45f;
                        if (var10_7 == false) ** GOTO lbl-1000
                        if (var7_5 != null) {
                            var19_13 = var7_5.H();
                        } else {
                            var20_14 = false;
                            var19_13 = null;
                        }
                        var1_1.updateLiveDataRegistration(var17_11, (LiveData)var19_13);
                        if (var19_13 != null) {
                            var19_13 = (Boolean)var19_13.getValue();
                        } else {
                            var20_14 = false;
                            var19_13 = null;
                        }
                        var20_14 = ViewDataBinding.safeUnbox((Boolean)var19_13);
                        if (var10_7 != false) {
                            var21_15 = var20_14 != false ? 262144L : 131072L;
                            var2_2 |= var21_15;
                        }
                        if (!var20_14) {
                            var10_7 = var17_11;
                            var23_16 = var18_12;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var10_7 = 0;
                            var23_16 = 0.0f;
                        }
                        var24_18 = var2_2 & var13_9;
                        var20_14 = var24_18 == var4_3 ? 0 : (var24_18 < var4_3 ? -1 : 1);
                        if (!var20_14) break block42;
                        if (var7_5 != null) {
                            var26_19 = var7_5.X();
                            var27_20 = var26_19;
                        } else {
                            var28_21 = 0;
                            var29_22 = 0.0f;
                            var27_20 = null;
                        }
                        var30_24 = 8;
                        var1_1.updateLiveDataRegistration(var30_24, (LiveData)var27_20);
                        var31_25 = var27_20 != null ? (var27_20 = (Integer)var27_20.getValue()) : null;
                        var28_21 = ViewDataBinding.safeUnbox(var31_25);
                        var32_26 = 7;
                        var33_27 = 1;
                        var34_28 = 1.4E-45f;
                        var32_26 = var28_21 == var32_26 ? var33_27 : 0;
                        var35_31 = 2;
                        var36_32 = 2.8E-45f;
                        if (var28_21 == var35_31) {
                            var35_31 = var33_27;
                            var36_32 = var34_28;
                        } else {
                            var35_31 = 0;
                            var36_32 = 0.0f;
                            var37_35 = null;
                        }
                        if (var28_21 == var30_24) {
                            var38_36 = var33_27;
                            var39_37 = var34_28;
                        } else {
                            var38_36 = 0;
                            var39_37 = 0.0f;
                        }
                        var30_24 = 3;
                        var30_24 = var28_21 == var30_24 ? var33_27 : 0;
                        var40_40 = 5;
                        if (var28_21 == var40_40) {
                            var40_40 = var33_27;
                        } else {
                            var40_40 = 0;
                            var41_41 = null;
                        }
                        var42_42 = 6;
                        var42_42 = var28_21 == var42_42 ? var33_27 : 0;
                        var43_43 = var28_21 == var17_11 ? var33_27 : 0;
                        if (var28_21 != var33_27) {
                            var33_27 = 0;
                            var34_28 = 0.0f;
                        }
                        if (var20_14) {
                            var44_44 = var32_26 != 0 ? 0x400000L : 0x200000L;
                            var2_2 |= var44_44;
                        }
                        if ((var28_21 = (int)((cfr_temp_0 = (var44_44 = var2_2 & (var46_45 = 6400L)) - (var48_46 = 0L)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) != 0) {
                            var44_44 = var35_31 != 0 ? 0x10000000L : 0x8000000L;
                            var2_2 |= var44_44;
                        }
                        if ((var28_21 = (int)((cfr_temp_1 = (var44_44 = var2_2 & var46_45) - var48_46) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) != 0) {
                            var44_44 = var38_36 != 0 ? 0x1000000L : 0x800000L;
                            var2_2 |= var44_44;
                        }
                        if ((var28_21 = (int)((cfr_temp_2 = (var44_44 = var2_2 & var46_45) - var48_46) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) != 0) {
                            var44_44 = var30_24 != 0 ? 0x4000000L : 0x2000000L;
                            var2_2 |= var44_44;
                        }
                        if ((var28_21 = (int)((cfr_temp_3 = (var44_44 = var2_2 & var46_45) - var48_46) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) != 0) {
                            var44_44 = var40_40 != 0 ? 65536L : 32768L;
                            var2_2 |= var44_44;
                        }
                        if ((var28_21 = (int)((cfr_temp_4 = (var44_44 = var2_2 & var46_45) - var48_46) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) != 0) {
                            var44_44 = var42_42 != 0 ? 0x40000000L : 0x20000000L;
                            var2_2 |= var44_44;
                        }
                        if ((var28_21 = (int)((cfr_temp_5 = (var44_44 = var2_2 & var46_45) - var48_46) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) != 0) {
                            var44_44 = var43_43 != 0 ? 0x100000L : 524288L;
                            var2_2 |= var44_44;
                        }
                        if ((var28_21 = (int)((cfr_temp_6 = (var44_44 = var2_2 & var46_45) - var48_46) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1))) != 0) {
                            var44_44 = var33_27 != 0 ? 16384L : 8192L;
                            var2_2 |= var44_44;
                        }
                        var32_26 = var32_26 != 0 ? 0 : var17_11;
                        if (var35_31 != 0) {
                            var35_31 = 0;
                            var36_32 = 0.0f;
                            var37_35 = null;
                        } else {
                            var35_31 = var17_11;
                            var36_32 = var18_12;
                        }
                        if (var38_36 != 0) {
                            var38_36 = 0;
                            var39_37 = 0.0f;
                        } else {
                            var38_36 = var17_11;
                            var39_37 = var18_12;
                        }
                        if (var30_24 != 0) {
                            var28_21 = 0;
                            var29_22 = 0.0f;
                            var27_20 = null;
                        } else {
                            var28_21 = var17_11;
                            var29_22 = var18_12;
                        }
                        if (var40_40 != 0) {
                            var40_40 = 0;
                            var41_41 = null;
                        } else {
                            var40_40 = var17_11;
                        }
                        var42_42 = var42_42 != 0 ? 0 : var17_11;
                        var30_24 = var43_43 != 0 ? 0 : var17_11;
                        if (var33_27 != 0) {
                            var50_47 = 0;
                            var51_48 = 0.0f;
                            var26_19 = null;
                        } else {
                            var50_47 = var17_11;
                            var51_48 = var18_12;
                        }
                        var33_27 = (int)var10_7;
                        var34_28 = var23_16;
                        var52_49 = 6400L;
                        var10_7 = var38_36;
                        var23_16 = var39_37;
                        var38_36 = var35_31;
                        var39_37 = var36_32;
                        var35_31 = var28_21;
                        var36_32 = var29_22;
                        var28_21 = var50_47;
                        var29_22 = var51_48;
                        break block43;
                    }
                    var33_27 = var10_7;
                    var34_29 = var23_16;
                    var52_49 = var13_9;
                    var35_31 = 0;
                    var36_33 = 0.0f;
                    var37_35 = null;
                    var38_36 = 0;
                    var39_38 = 0.0f;
                    var10_7 = 0;
                    var23_16 = 0.0f;
                    var32_26 = 0;
                    break block44;
                }
                var52_49 = var13_9;
                var35_31 = 0;
                var36_34 = 0.0f;
                var37_35 = null;
                var38_36 = 0;
                var39_39 = 0.0f;
                var10_7 = 0;
                var23_17 = 0.0f;
                var32_26 = 0;
                var33_27 = 0;
                var34_30 = 0.0f;
            }
            var40_40 = 0;
            var41_41 = null;
            var42_42 = 0;
            var28_21 = 0;
            var29_23 = 0.0f;
            var27_20 = null;
            var30_24 = 0;
        }
        var48_46 = 0L;
        cfr_temp_7 = (var52_49 &= var2_2) - var48_46;
        var17_11 = (int)(cfr_temp_7 == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1));
        if (var17_11 != 0) {
            var54_50 = var1_1.b.getRoot();
            var54_50.setVisibility(var28_21);
            var27_20 = var1_1.c.getRoot();
            var27_20.setVisibility(var40_40);
            var41_41 = var1_1.d.getRoot();
            var41_41.setVisibility(var35_31);
            var1_1.e.getRoot().setVisibility(var38_36);
            var1_1.f.getRoot().setVisibility(var42_42);
            var1_1.g.getRoot().setVisibility(var30_24);
            var1_1.h.getRoot().setVisibility(var32_26);
            var37_35 = var1_1.i.getRoot();
            var37_35.setVisibility((int)var10_7);
        }
        if ((var35_31 = (cfr_temp_8 = (var4_3 = 5120L & var2_2) - (var8_6 = 0L)) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1)) != 0) {
            var1_1.c.A((CameraFragment$j)var6_4);
            var1_1.d.A((CameraFragment$j)var6_4);
            var1_1.e.A((CameraFragment$j)var6_4);
            var1_1.f.A((CameraFragment$j)var6_4);
            var1_1.g.A((CameraFragment$j)var6_4);
            var1_1.h.A((CameraFragment$j)var6_4);
            var37_35 = var1_1.i;
            var37_35.A((CameraFragment$j)var6_4);
        }
        if ((var55_51 = (cfr_temp_9 = (var4_3 = 6144L & var2_2) - (var8_6 = 0L)) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1)) != false) {
            var1_1.c.B(var7_5);
            var1_1.d.B(var7_5);
            var1_1.e.B(var7_5);
            var1_1.f.B(var7_5);
            var1_1.g.B(var7_5);
            var1_1.h.B(var7_5);
            var6_4 = var1_1.i;
            var6_4.B(var7_5);
        }
        if ((var55_51 = (cfr_temp_10 = (var2_2 &= 6160L) - (var4_3 = 0L)) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.j;
            var6_4.setVisibility(var33_27);
        }
        ViewDataBinding.executeBindingsOn(var1_1.b);
        ViewDataBinding.executeBindingsOn(var1_1.e);
        ViewDataBinding.executeBindingsOn(var1_1.d);
        ViewDataBinding.executeBindingsOn(var1_1.g);
        ViewDataBinding.executeBindingsOn(var1_1.c);
        ViewDataBinding.executeBindingsOn(var1_1.f);
        ViewDataBinding.executeBindingsOn(var1_1.h);
        ViewDataBinding.executeBindingsOn(var1_1.i);
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
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            ViewDataBinding viewDataBinding = this.b;
            l12 = (long)viewDataBinding.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            viewDataBinding = this.e;
            l12 = (long)viewDataBinding.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            viewDataBinding = this.d;
            l12 = (long)viewDataBinding.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            viewDataBinding = this.g;
            l12 = (long)viewDataBinding.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            viewDataBinding = this.c;
            l12 = (long)viewDataBinding.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            viewDataBinding = this.f;
            l12 = (long)viewDataBinding.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            viewDataBinding = this.h;
            l12 = (long)viewDataBinding.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            viewDataBinding = this.i;
            l12 = (long)viewDataBinding.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            return false;
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
            this.m = l10 = 4096L;
        }
        this.b.invalidateAll();
        this.e.invalidateAll();
        this.d.invalidateAll();
        this.g.invalidateAll();
        this.c.invalidateAll();
        this.f.invalidateAll();
        this.h.invalidateAll();
        this.i.invalidateAll();
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        switch (n10) {
            default: {
                return false;
            }
            case 9: {
                object = (md)object;
                return this.E((md)object, n11);
            }
            case 8: {
                object = (MutableLiveData)object;
                return this.L((MutableLiveData)object, n11);
            }
            case 7: {
                object = (wd)object;
                return this.I((wd)object, n11);
            }
            case 6: {
                object = (kd)object;
                return this.D((kd)object, n11);
            }
            case 5: {
                object = (sd)object;
                return this.G((sd)object, n11);
            }
            case 4: {
                object = (MutableLiveData)object;
                return this.K((MutableLiveData)object, n11);
            }
            case 3: {
                object = (od)object;
                return this.C((od)object, n11);
            }
            case 2: {
                object = (qd)object;
                return this.F((qd)object, n11);
            }
            case 1: {
                object = (ud)object;
                return this.H((ud)object, n11);
            }
            case 0: 
        }
        object = (yd)object;
        return this.J((yd)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.b.setLifecycleOwner(lifecycleOwner);
        this.e.setLifecycleOwner(lifecycleOwner);
        this.d.setLifecycleOwner(lifecycleOwner);
        this.g.setLifecycleOwner(lifecycleOwner);
        this.c.setLifecycleOwner(lifecycleOwner);
        this.f.setLifecycleOwner(lifecycleOwner);
        this.h.setLifecycleOwner(lifecycleOwner);
        this.i.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (CameraFragment$j)object;
            this.A((CameraFragment$j)object);
            return 1 != 0;
        } else {
            n11 = 80;
            if (n11 != n10) return 0 != 0;
            object = (z)object;
            this.B((z)object);
        }
        return 1 != 0;
    }
}

