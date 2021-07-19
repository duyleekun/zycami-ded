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
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.zhiyun.device.connection.BleDeviceViewModel;
import com.zhiyun.device.connection.BleDeviceViewModel$ConnectStatus;
import com.zhiyun.device.connection.BleDeviceViewModel$ScanFailType;
import com.zhiyun.device.connection.BleDeviceViewModel$ShowStatus;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.j3;
import d.v.c.y0.b.s$d;
import l.a.q.g0.u;

public class k3
extends j3
implements b$a {
    private static final ViewDataBinding$IncludedLayouts y;
    private static final SparseIntArray z;
    private final ConstraintLayout o;
    private final TextView p;
    private final ImageView q;
    private final TextView r;
    private final TextView s;
    private final View.OnClickListener t;
    private final View.OnClickListener u;
    private final View.OnClickListener v;
    private long w;
    private long x;

    public k3(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = y;
        SparseIntArray sparseIntArray = z;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 15, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private k3(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        long l10;
        Object object;
        Object object2 = object = objectArray[11];
        object2 = (LottieAnimationView)object;
        Object object3 = object = objectArray[6];
        object3 = (ConstraintLayout)((Object)object);
        Object object4 = object = objectArray[1];
        object4 = (ImageView)object;
        Object object5 = object = objectArray[8];
        object5 = (ImageView)object;
        int n10 = 3;
        Object object6 = object = objectArray[n10];
        object6 = (ImageView)object;
        Object object7 = object = objectArray[4];
        object7 = (ProgressBar)object;
        Object object8 = object = objectArray[10];
        object8 = (RecyclerView)object;
        Object object9 = object = objectArray[7];
        object9 = (TextView)object;
        Object object10 = object = objectArray[9];
        object10 = (TextView)object;
        Object object11 = object = objectArray[5];
        object11 = (View)object;
        object = this;
        Object object12 = dataBindingComponent;
        View view2 = view;
        super(dataBindingComponent, view, 5, (LottieAnimationView)object2, (ConstraintLayout)((Object)object3), (ImageView)object4, (ImageView)object5, (ImageView)object6, (ProgressBar)object7, (RecyclerView)object8, (TextView)object9, (TextView)object10, (View)object11);
        this.w = l10 = (long)-1;
        this.x = l10;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.o = object;
        object.setTag(null);
        object = (TextView)objectArray[12];
        this.p = object;
        object.setTag(null);
        object = (ImageView)objectArray[13];
        this.q = object;
        object.setTag(null);
        object = (TextView)objectArray[14];
        this.r = object;
        object.setTag(null);
        int n11 = 2;
        view2 = (TextView)objectArray[n11];
        this.s = view2;
        view2.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        object12 = view;
        this.setRootTag(view);
        object12 = new b(this, n11);
        this.t = object12;
        object = new b(this, n10);
        this.u = object;
        object = new b(this, 1);
        this.v = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean G(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.w;
                long l11 = 8;
                this.w = l10 |= l11;
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
                long l10 = this.w;
                long l11 = 16;
                this.w = l10 |= l11;
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
                long l10 = this.w;
                long l11 = 1L;
                this.w = l10 |= l11;
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
                long l10 = this.w;
                long l11 = 2;
                this.w = l10 |= l11;
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
                long l10 = this.w;
                long l11 = 4;
                this.w = l10 |= l11;
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
    public void C(boolean bl2) {
        this.m = bl2;
        synchronized (this) {
            long l10 = this.w;
            long l11 = 128L;
            this.w = l10 |= l11;
        }
        this.notifyPropertyChanged(9);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(s$d s$d) {
        this.n = s$d;
        synchronized (this) {
            long l10 = this.w;
            long l11 = 64;
            this.w = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(boolean bl2) {
        this.l = bl2;
        synchronized (this) {
            long l10 = this.w;
            long l11 = 32;
            this.w = l10 |= l11;
        }
        this.notifyPropertyChanged(33);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(BleDeviceViewModel bleDeviceViewModel) {
        this.k = bleDeviceViewModel;
        synchronized (this) {
            long l10 = this.w;
            long l11 = 256L;
            this.w = l10 |= l11;
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
                    s$d s$d = this.n;
                    if (s$d != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        s$d.a();
                    }
                }
            } else {
                s$d s$d = this.n;
                if (s$d != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    s$d.g();
                }
            }
        } else {
            n10 = (int)(this.m ? 1 : 0);
            s$d s$d = this.n;
            boolean bl2 = this.l;
            if (bl2) {
                if (s$d != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    s$d.b();
                }
            } else if (n10 != 0) {
                if (s$d != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    s$d.b();
                }
            } else {
                if (s$d != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    s$d.c();
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
        block153: {
            block152: {
                block151: {
                    block149: {
                        block150: {
                            block147: {
                                block148: {
                                    block135: {
                                        block139: {
                                            block134: {
                                                block140: {
                                                    block146: {
                                                        block145: {
                                                            block144: {
                                                                block143: {
                                                                    block142: {
                                                                        block141: {
                                                                            var1_1 = this;
                                                                            synchronized (this) {
                                                                                var2_2 = this.w;
                                                                                this.w = var4_3 = 0L;
                                                                                this.x = var4_3;
                                                                            }
                                                                            var6_4 = this.l;
                                                                            var7_5 = this.m;
                                                                            var8_6 /* !! */  = this.k;
                                                                            var9_7 = 936L;
                                                                            var11_8 = var2_2 & var9_7;
                                                                            var13_9 /* !! */  = var11_8 == var4_3 ? 0 : (var11_8 < var4_3 ? -1 : 1);
                                                                            var14_10 = 0x400000L;
                                                                            var16_11 = 0x100000L;
                                                                            var18_12 = 4096L;
                                                                            var20_13 = 0x40000000L;
                                                                            var22_14 = 0x800000000000000L;
                                                                            var24_15 = 0x400000000000000L;
                                                                            var26_16 = 544L;
                                                                            if (var13_9 /* !! */  == false) ** GOTO lbl103
                                                                            var28_17 = var2_2 & var26_16;
                                                                            cfr_temp_0 = var28_17 - var4_3;
                                                                            var13_9 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                                                            if (var13_9 /* !! */  != false) {
                                                                                if (var6_4) {
                                                                                    var2_2 = var2_2 | 8192L | 0x200000L | 0x800000L | 0x800000000L | 0x8000000000L | 0x20000000000L | 0x80000000000L | 0x2000000000000L | 0x200000000000000L;
                                                                                    var28_17 = 0x2000000000000000L;
                                                                                } else {
                                                                                    var2_2 = var2_2 | var18_12 | var16_11 | var14_10 | 0x400000000L | 0x4000000000L | 0x10000000000L | 0x40000000000L | 0x1000000000000L | 0x100000000000000L;
                                                                                    var28_17 = 0x1000000000000000L;
                                                                                }
                                                                                var2_2 |= var28_17;
                                                                            }
                                                                            if ((var13_9 /* !! */  = (cfr_temp_1 = (var28_17 = var2_2 & var24_15) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
                                                                                var28_17 = var6_4 != false ? 0x2000000L : 0x1000000L;
                                                                                var2_2 |= var28_17;
                                                                            }
                                                                            if ((var13_9 /* !! */  = (cfr_temp_2 = (var28_17 = var2_2 & (var30_18 = 936L)) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
                                                                                if (var6_4) {
                                                                                    var28_17 = 0x80000000L;
                                                                                    var2_2 |= var28_17;
                                                                                } else {
                                                                                    var2_2 |= var20_13;
                                                                                }
                                                                            }
                                                                            if ((var13_9 /* !! */  = (cfr_temp_3 = (var28_17 = var2_2 & var22_14) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) {
                                                                                var28_17 = var6_4 != false ? 0x80000000000000L : 0x40000000000000L;
                                                                                var2_2 |= var28_17;
                                                                            }
                                                                            if ((var13_9 /* !! */  = (cfr_temp_4 = (var28_17 = var2_2 & var26_16) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) != false) {
                                                                                var13_9 /* !! */  = 2131099772;
                                                                                var32_19 = 2131099739;
                                                                                var33_20 = var1_1.s;
                                                                                var34_21 = var6_4 != false ? ViewDataBinding.getColorFromResource((View)var33_20, (int)var13_9 /* !! */ ) : ViewDataBinding.getColorFromResource((View)var33_20, var32_19);
                                                                                var35_22 = var1_1.e.getContext();
                                                                                if (var6_4) {
                                                                                    var36_23 = 2131231225;
                                                                                    var37_24 = 1.8078525E38f;
                                                                                } else {
                                                                                    var36_23 = 2131231275;
                                                                                    var37_24 = 1.8078626E38f;
                                                                                }
                                                                                var35_22 = AppCompatResources.getDrawable(var35_22, var36_23);
                                                                                var38_25 /* !! */  = var1_1.p;
                                                                                var39_26 = var6_4 != false ? 2131099781 : 2131099748;
                                                                                var36_23 = ViewDataBinding.getColorFromResource((View)var38_25 /* !! */ , var39_26);
                                                                                var40_27 /* !! */  = var1_1.r;
                                                                                var41_28 = var6_4 != false ? 2131099781 : 2131099748;
                                                                                var39_26 = ViewDataBinding.getColorFromResource((View)var40_27 /* !! */ , var41_28);
                                                                                var42_30 = var1_1.b.getContext();
                                                                                if (var6_4) {
                                                                                    var43_31 = 2131230888;
                                                                                    var44_32 = 1.8077841E38f;
                                                                                } else {
                                                                                    var43_31 = 2131230920;
                                                                                    var44_32 = 1.8077906E38f;
                                                                                }
                                                                                var42_30 = AppCompatResources.getDrawable(var42_30, var43_31);
                                                                                var45_33 /* !! */  = var1_1.i;
                                                                                var43_31 = var6_4 != false ? ViewDataBinding.getColorFromResource((View)var45_33 /* !! */ , (int)var13_9 /* !! */ ) : ViewDataBinding.getColorFromResource((View)var45_33 /* !! */ , var32_19);
                                                                                var46_34 /* !! */  = var1_1.j;
                                                                                if (var6_4) {
                                                                                    var47_35 = 2131099773;
                                                                                    var48_36 = 1.7811909E38f;
                                                                                } else {
                                                                                    var47_35 = 2131099740;
                                                                                    var48_36 = 1.7811842E38f;
                                                                                }
                                                                                var49_37 = ViewDataBinding.getColorFromResource(var46_34 /* !! */ , var47_35);
                                                                                var50_38 = var1_1.h;
                                                                                var47_35 = var6_4 != false ? ViewDataBinding.getColorFromResource((View)var50_38, (int)var13_9 /* !! */ ) : ViewDataBinding.getColorFromResource((View)var50_38, var32_19);
                                                                                var51_39 /* !! */  = var1_1.f.getContext();
                                                                                var13_9 /* !! */  = var6_4 != false ? (long)2131231858 : (long)2131231859;
                                                                                var51_39 /* !! */  = AppCompatResources.getDrawable(var51_39 /* !! */ , (int)var13_9 /* !! */ );
                                                                                if (var6_4) {
                                                                                    var52_40 = var1_1.o.getContext();
                                                                                    var53_41 = var2_2;
                                                                                    var55_42 = 2131230825;
                                                                                    var56_43 = AppCompatResources.getDrawable(var52_40, var55_42);
                                                                                } else {
                                                                                    var53_41 = var2_2;
                                                                                    var56_43 = var1_1.o.getContext();
                                                                                    var57_44 = 2131230826;
                                                                                    var56_43 = AppCompatResources.getDrawable(var56_43, var57_44);
                                                                                }
                                                                                var13_9 /* !! */  = var34_21;
                                                                                var33_20 = var51_39 /* !! */ ;
                                                                                var32_19 = var47_35;
                                                                                var47_35 = var49_37;
                                                                                var46_34 /* !! */  = var56_43;
                                                                                var2_2 = var53_41;
                                                                            } else {
                                                                                var53_41 = var2_2;
lbl103:
                                                                                // 2 sources

                                                                                var49_37 = 0;
                                                                                var46_34 /* !! */  = null;
                                                                                var47_35 = 0;
                                                                                var48_36 = 0.0f;
                                                                                var50_38 = null;
                                                                                var32_19 = 0;
                                                                                var51_39 /* !! */  = null;
                                                                                var34_21 = 0;
                                                                                var33_20 = null;
                                                                                var13_9 /* !! */  = 0;
                                                                                var52_40 = null;
                                                                                var35_22 = null;
                                                                                var36_23 = 0;
                                                                                var37_24 = 0.0f;
                                                                                var38_25 /* !! */  = null;
                                                                                var39_26 = 0;
                                                                                var40_27 /* !! */  = null;
                                                                                var41_29 = false;
                                                                                var42_30 = null;
                                                                                var43_31 = 0;
                                                                                var44_32 = 0.0f;
                                                                                var45_33 /* !! */  = null;
                                                                            }
                                                                            var53_41 = var2_2 & 823L;
                                                                            var58_45 = 0L;
                                                                            var60_46 /* !! */  = var53_41 == var58_45 ? 0 : (var53_41 < var58_45 ? -1 : 1);
                                                                            var53_41 = 773L;
                                                                            var61_47 = 804L;
                                                                            var63_48 = 788L;
                                                                            var65_49 = 784L;
                                                                            var67_50 = 786L;
                                                                            var69_51 = 0x10000000000000L;
                                                                            var71_52 = 8;
                                                                            var72_53 = 1.1E-44f;
                                                                            var73_54 = 772L;
                                                                            var75_55 = var47_35;
                                                                            var47_35 = 1;
                                                                            var48_36 = 1.4E-45f;
                                                                            if (var60_46 /* !! */  == false) break block139;
                                                                            var76_56 = var2_2 & var67_50;
                                                                            var58_45 = 0L;
                                                                            cfr_temp_5 = var76_56 - var58_45;
                                                                            var60_46 /* !! */  = (long)(cfr_temp_5 == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1));
                                                                            if (var60_46 /* !! */  != false) {
                                                                                if (var8_6 /* !! */  != null) {
                                                                                    var78_57 = var8_6 /* !! */ .F();
                                                                                    var79_58 = var78_57;
                                                                                    var80_59 = var43_31;
                                                                                    var45_33 /* !! */  = var78_57;
                                                                                } else {
                                                                                    var80_59 = var43_31;
                                                                                    var43_31 = 0;
                                                                                    var44_32 = 0.0f;
                                                                                    var45_33 /* !! */  = null;
                                                                                }
                                                                                var1_1.updateLiveDataRegistration(var47_35, var45_33 /* !! */ );
                                                                                if (var45_33 /* !! */  != null) {
                                                                                    var45_33 /* !! */  = (BleDeviceViewModel$ShowStatus)var45_33 /* !! */ .getValue();
                                                                                } else {
                                                                                    var43_31 = 0;
                                                                                    var44_32 = 0.0f;
                                                                                    var45_33 /* !! */  = null;
                                                                                }
                                                                                var50_38 = BleDeviceViewModel$ShowStatus.SHOW_STATE_DEVICE_LIST;
                                                                                if (var45_33 /* !! */  == var50_38) {
                                                                                    var47_35 = 1;
                                                                                    var48_36 = 1.4E-45f;
                                                                                } else {
                                                                                    var47_35 = 0;
                                                                                    var48_36 = 0.0f;
                                                                                    var50_38 = null;
                                                                                }
                                                                                if (var60_46 /* !! */  != false) {
                                                                                    var18_12 = var47_35 != 0 ? 0x2000000000L : 0x1000000000L;
                                                                                    var2_2 |= var18_12;
                                                                                }
                                                                            } else {
                                                                                var80_59 = var43_31;
                                                                                var47_35 = 0;
                                                                                var48_36 = 0.0f;
                                                                                var50_38 = null;
                                                                            }
                                                                            if ((var43_31 = (int)((cfr_temp_6 = (var18_12 = 821L & var2_2) - (var58_45 = 0L)) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1))) == 0) break block140;
                                                                            if (var8_6 /* !! */  != null) {
                                                                                var45_33 /* !! */  = var8_6 /* !! */ .F();
                                                                                var60_46 /* !! */  = var47_35;
                                                                                var81_60 = var48_36;
                                                                            } else {
                                                                                var60_46 /* !! */  = var47_35;
                                                                                var81_60 = var48_36;
                                                                                var43_31 = 0;
                                                                                var44_32 = 0.0f;
                                                                                var45_33 /* !! */  = null;
                                                                            }
                                                                            var47_35 = 2;
                                                                            var48_36 = 2.8E-45f;
                                                                            var1_1.updateLiveDataRegistration(var47_35, var45_33 /* !! */ );
                                                                            if (var45_33 /* !! */  != null) {
                                                                                var50_38 = (BleDeviceViewModel$ShowStatus)var45_33 /* !! */ .getValue();
                                                                            } else {
                                                                                var47_35 = 0;
                                                                                var48_36 = 0.0f;
                                                                                var50_38 = null;
                                                                            }
                                                                            var82_61 = var2_2 & 805L;
                                                                            var58_45 = 0L;
                                                                            var43_31 = (int)(var82_61 == var58_45 ? 0 : (var82_61 < var58_45 ? -1 : 1));
                                                                            if (var43_31 == 0) break block141;
                                                                            var45_33 /* !! */  = BleDeviceViewModel$ShowStatus.SHOW_STATE_NO_DEVICE;
                                                                            if (var50_38 == var45_33 /* !! */ ) {
                                                                                var43_31 = 1;
                                                                                var44_32 = 1.4E-45f;
                                                                            } else {
                                                                                var43_31 = 0;
                                                                                var44_32 = 0.0f;
                                                                                var45_33 /* !! */  = null;
                                                                            }
                                                                            var82_61 = var2_2 & var73_54;
                                                                            var84_62 = var82_61 == var58_45 ? 0 : (var82_61 < var58_45 ? -1 : 1);
                                                                            if (var84_62) {
                                                                                var82_61 = var43_31 != 0 ? 2048L : 1024L;
                                                                                var2_2 |= var82_61;
                                                                            }
                                                                            if (var84_62 = (cfr_temp_7 = (var82_61 = var2_2 & var53_41) - var58_45) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1)) {
                                                                                if (var43_31 != 0) {
                                                                                    var82_61 = 0x20000000000000L;
                                                                                    var2_2 |= var82_61;
                                                                                } else {
                                                                                    var2_2 |= var69_51;
                                                                                }
                                                                            }
                                                                            if (var84_62 = (cfr_temp_8 = (var82_61 = var2_2 & var61_47) - var58_45) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1)) {
                                                                                var2_2 = var43_31 != 0 ? (var2_2 |= var22_14) : (var2_2 |= var24_15);
                                                                            }
                                                                            if (!(var84_62 = (cfr_temp_9 = (var82_61 = var2_2 & var73_54) - var58_45) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1))) break block142;
                                                                            var85_64 = var43_31 != 0 ? "@string/device_scan_undiscover" : "@string/device_scan_ble_disable";
                                                                            break block143;
                                                                        }
                                                                        var43_31 = 0;
                                                                        var44_32 = 0.0f;
                                                                        var45_33 /* !! */  = null;
                                                                    }
                                                                    var84_62 = false;
                                                                    var85_64 = null;
                                                                }
                                                                var86_65 = var2_2 & var63_48;
                                                                var88_66 = var86_65 == var58_45 ? 0 : (var86_65 < var58_45 ? -1 : 1);
                                                                var89_68 = var43_31;
                                                                var90_69 = var44_32;
                                                                if (var88_66 == 0) break block144;
                                                                var45_33 /* !! */  = BleDeviceViewModel$ShowStatus.SHOW_STATE_DEVICE_LIST;
                                                                if (var50_38 == var45_33 /* !! */ ) {
                                                                    var43_31 = 1;
                                                                    var44_32 = 1.4E-45f;
                                                                } else {
                                                                    var43_31 = 0;
                                                                    var44_32 = 0.0f;
                                                                    var45_33 /* !! */  = null;
                                                                }
                                                                if (var88_66 != 0) {
                                                                    var91_71 = var43_31 != 0 ? 0x8000000L : 0x4000000L;
                                                                    var2_2 |= var91_71;
                                                                }
                                                                if ((var88_66 = (cfr_temp_10 = (var91_71 = var2_2 & var73_54) - (var58_45 = 0L)) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1)) != 0) {
                                                                    var91_71 = var43_31 != 0 ? 0x200000000L : 0x100000000L;
                                                                    var2_2 |= var91_71;
                                                                }
                                                                if ((var88_66 = (cfr_temp_11 = (var91_71 = var2_2 & var73_54) - var58_45) == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1)) == 0 || var43_31 != 0) break block145;
                                                                var88_66 = var71_52;
                                                                var93_72 = var72_53;
                                                                break block146;
                                                            }
                                                            var58_45 = 0L;
                                                            var43_31 = 0;
                                                            var44_32 = 0.0f;
                                                            var45_33 /* !! */  = null;
                                                        }
                                                        var88_66 = 0;
                                                        var93_72 = 0.0f;
                                                        var94_74 /* !! */  = null;
                                                    }
                                                    var91_71 = var2_2 & var73_54;
                                                    var95_75 = var91_71 == var58_45 ? 0 : (var91_71 < var58_45 ? -1 : 1);
                                                    var96_76 = var43_31;
                                                    if (var95_75 != false) {
                                                        var45_33 /* !! */  = BleDeviceViewModel$ShowStatus.SHOW_STATE_SCANNING;
                                                        if (var50_38 == var45_33 /* !! */ ) {
                                                            var43_31 = 1;
                                                            var44_32 = 1.4E-45f;
                                                        } else {
                                                            var43_31 = 0;
                                                            var44_32 = 0.0f;
                                                            var45_33 /* !! */  = null;
                                                        }
                                                        if (var95_75 != false) {
                                                            var97_77 = var43_31 != 0 ? 0x200000000000L : 0x100000000000L;
                                                            var2_2 |= var97_77;
                                                        }
                                                        if (var43_31 != 0) {
                                                            var43_31 = 0;
                                                            var44_32 = 0.0f;
                                                            var45_33 /* !! */  = null;
                                                        } else {
                                                            var43_31 = var71_52;
                                                            var44_32 = var72_53;
                                                        }
                                                        var79_58 = var85_64;
                                                        var85_64 = var50_38;
                                                        var47_35 = var43_31;
                                                        var48_36 = var44_32;
                                                        var43_31 = var89_68;
                                                        var44_32 = var90_69;
                                                        var89_68 = var88_66;
                                                        var90_69 = var93_72;
                                                        var94_74 /* !! */  = var79_58;
                                                        break block134;
                                                    } else {
                                                        var43_31 = var89_68;
                                                        var44_32 = var90_69;
                                                        var89_68 = var88_66;
                                                        var90_69 = var93_72;
                                                        var94_74 /* !! */  = var85_64;
                                                        var85_64 = var50_38;
                                                        var47_35 = 0;
                                                        var48_36 = 0.0f;
                                                        var50_38 = null;
                                                    }
                                                    break block134;
                                                }
                                                var60_46 /* !! */  = var47_35;
                                                var81_60 = var48_36;
                                                var47_35 = 0;
                                                var48_36 = 0.0f;
                                                var50_38 = null;
                                                var43_31 = 0;
                                                var44_32 = 0.0f;
                                                var45_33 /* !! */  = null;
                                                var84_62 = false;
                                                var85_64 = null;
                                                var88_66 = 0;
                                                var93_72 = 0.0f;
                                                var94_74 /* !! */  = null;
                                                var89_68 = 0;
                                                var90_70 = 0.0f;
                                                var99_78 = null;
                                                var96_76 = 0;
                                            }
                                            var97_77 = var2_2 & var65_49;
                                            var58_45 = 0L;
                                            var95_75 = var97_77 == var58_45 ? 0 : (var97_77 < var58_45 ? -1 : 1);
                                            if (var95_75 != false) {
                                                if (var8_6 /* !! */  != null) {
                                                    var100_79 = var8_6 /* !! */ .t();
                                                    var101_80 = var43_31;
                                                    var79_58 = var100_79;
                                                    var102_81 = var47_35;
                                                    var103_82 = var48_36;
                                                    var50_38 = var100_79;
                                                } else {
                                                    var102_81 = var47_35;
                                                    var103_82 = var48_36;
                                                    var101_80 = var43_31;
                                                    var47_35 = 0;
                                                    var48_36 = 0.0f;
                                                    var50_38 = null;
                                                }
                                                var43_31 = 4;
                                                var44_32 = 5.6E-45f;
                                                var1_1.updateLiveDataRegistration(var43_31, (LiveData)var50_38);
                                                if (var50_38 != null) {
                                                    var45_33 /* !! */  = (Stabilizer)var50_38.getValue();
                                                } else {
                                                    var43_31 = 0;
                                                    var44_32 = 0.0f;
                                                    var45_33 /* !! */  = null;
                                                }
                                                var104_84 = var45_33 /* !! */  == null;
                                                if (var95_75 != false) {
                                                    var105_85 = var104_84 != false ? 0x8000000000000L : 0x4000000000000L;
                                                    var2_2 |= var105_85;
                                                }
                                                var95_75 = var13_9 /* !! */ ;
                                                var13_9 /* !! */  = var89_68;
                                                var99_78 = var33_20;
                                                var33_20 = var94_74 /* !! */ ;
                                                var94_74 /* !! */  = var45_33 /* !! */ ;
                                                var43_31 = (int)var102_81;
                                                var44_32 = var103_82;
                                                var79_58 = var85_64;
                                                var85_64 = var50_38;
                                                var47_35 = (int)var60_46 /* !! */ ;
                                                var48_36 = var81_60;
                                                var60_46 /* !! */  = var32_19;
                                                var51_39 /* !! */  = var79_58;
                                                break block135;
                                            } else {
                                                var102_81 = var47_35;
                                                var103_83 = var48_36;
                                                var101_80 = var43_31;
                                                var95_75 = var13_9 /* !! */ ;
                                                var47_35 = (int)var60_46 /* !! */ ;
                                                var48_36 = var81_60;
                                                var13_9 /* !! */  = var89_68;
                                                var43_31 = (int)var102_81;
                                                var44_32 = var103_83;
                                                var104_84 = false;
                                                var60_46 /* !! */  = var32_19;
                                                var99_78 = var33_20;
                                                var51_39 /* !! */  = var85_64;
                                                var33_20 = var94_74 /* !! */ ;
                                                var84_62 = false;
                                                var85_64 = null;
                                                var88_66 = 0;
                                                var93_72 = 0.0f;
                                                var94_74 /* !! */  = null;
                                            }
                                            break block135;
                                        }
                                        var80_59 = var43_31;
                                        var60_46 /* !! */  = var32_19;
                                        var99_78 = var33_20;
                                        var95_75 = var13_9 /* !! */ ;
                                        var47_35 = 0;
                                        var48_36 = 0.0f;
                                        var50_38 = null;
                                        var32_19 = 0;
                                        var51_39 /* !! */  = null;
                                        var34_21 = 0;
                                        var33_20 = null;
                                        var13_9 /* !! */  = 0;
                                        var52_40 = null;
                                        var43_31 = 0;
                                        var44_32 = 0.0f;
                                        var45_33 /* !! */  = null;
                                        var84_63 = false;
                                        var85_64 = null;
                                        var88_67 = false;
                                        var93_73 = 0.0f;
                                        var94_74 /* !! */  = null;
                                        var96_76 = 0;
                                        var101_80 = 0;
                                        var104_84 = false;
                                    }
                                    var105_85 = var2_2 & var69_51;
                                    var58_45 = 0L;
                                    var102_81 = var105_85 == var58_45 ? 0 : (var105_85 < var58_45 ? -1 : 1);
                                    var107_86 = var39_26;
                                    if (var102_81 != false) {
                                        var40_27 /* !! */  = BleDeviceViewModel$ShowStatus.SHOW_STATE_FAIL;
                                        if (var51_39 /* !! */  == var40_27 /* !! */ ) {
                                            var32_19 = 1;
                                        } else {
                                            var32_19 = 0;
                                            var51_39 /* !! */  = null;
                                        }
                                        if (var102_81 != false) {
                                            var108_87 = var32_19 != 0 ? 0x800000000000L : 0x400000000000L;
                                            var2_2 |= var108_87;
                                        }
                                    } else {
                                        var32_19 = 0;
                                        var51_39 /* !! */  = null;
                                    }
                                    if ((var39_26 = (int)((cfr_temp_12 = (var108_87 = var2_2 & 0xC00000000000000L) - (var58_45 = 0L)) == 0L ? 0 : (cfr_temp_12 < 0L ? -1 : 1))) == 0) break block147;
                                    var108_87 = var2_2 & var26_16;
                                    cfr_temp_13 = var108_87 - var58_45;
                                    var39_26 = (int)(cfr_temp_13 == 0L ? 0 : (cfr_temp_13 < 0L ? -1 : 1));
                                    if (var39_26 != 0) {
                                        if (var6_4) {
                                            var2_2 = var2_2 | 8192L | 0x200000L | 0x800000L | 0x800000000L | 0x8000000000L | 0x20000000000L | 0x80000000000L | 0x2000000000000L | 0x200000000000000L;
                                            var110_88 = 0x2000000000000000L;
                                        } else {
                                            var112_89 = 4096L;
                                            var2_2 |= var112_89;
                                            var114_90 = 0x100000L;
                                            var2_2 = var2_2 | var114_90 | 0x400000L | 0x400000000L | 0x4000000000L | 0x10000000000L | 0x40000000000L | 0x1000000000000L | 0x100000000000000L;
                                            var110_88 = 0x1000000000000000L;
                                        }
                                        var2_2 |= var110_88;
                                    }
                                    if ((var39_26 = (int)((cfr_temp_14 = (var110_88 = var2_2 & var24_15) - (var114_90 = 0L)) == 0L ? 0 : (cfr_temp_14 < 0L ? -1 : 1))) != 0) {
                                        var110_88 = var6_4 != false ? 0x2000000L : 0x1000000L;
                                        var2_2 |= var110_88;
                                    }
                                    if ((var39_26 = (int)((cfr_temp_15 = (var110_88 = var2_2 & (var30_18 = 936L)) - var114_90) == 0L ? 0 : (cfr_temp_15 < 0L ? -1 : 1))) != 0) {
                                        if (var6_4) {
                                            var110_88 = 0x80000000L;
                                            var2_2 |= var110_88;
                                        } else {
                                            var2_2 |= var20_13;
                                        }
                                    }
                                    if ((var39_26 = (int)((cfr_temp_16 = (var110_88 = var2_2 & var22_14) - var114_90) == 0L ? 0 : (cfr_temp_16 < 0L ? -1 : 1))) != 0) {
                                        var110_88 = var6_4 != false ? 0x80000000000000L : 0x40000000000000L;
                                        var2_2 |= var110_88;
                                    }
                                    if ((var39_26 = (int)((cfr_temp_17 = (var24_15 = var2_2 & var24_15) - var114_90) == 0L ? 0 : (cfr_temp_17 < 0L ? -1 : 1))) != 0) {
                                        if (var6_4) {
                                            var40_27 /* !! */  = var1_1.q.getContext();
                                            var116_91 = var36_23;
                                            var36_23 = 2131231792;
                                            var37_24 = 1.8079675E38f;
                                            var38_25 /* !! */  = AppCompatResources.getDrawable((Context)var40_27 /* !! */ , var36_23);
                                        } else {
                                            var116_91 = var36_23;
                                            var38_25 /* !! */  = var1_1.q.getContext();
                                            var39_26 = 2131231272;
                                            var38_25 /* !! */  = AppCompatResources.getDrawable((Context)var38_25 /* !! */ , var39_26);
                                        }
                                    } else {
                                        var116_91 = var36_23;
                                        var36_23 = 0;
                                        var37_24 = 0.0f;
                                        var38_25 /* !! */  = null;
                                    }
                                    var22_14 = var2_2 & var22_14;
                                    var110_88 = 0L;
                                    var39_26 = (int)(var22_14 == var110_88 ? 0 : (var22_14 < var110_88 ? -1 : 1));
                                    if (var39_26 == 0) break block148;
                                    if (var6_4) {
                                        var40_27 /* !! */  = var1_1.q.getContext();
                                        var22_14 = var2_2;
                                        var55_42 = 2131231794;
                                        var56_43 = AppCompatResources.getDrawable((Context)var40_27 /* !! */ , var55_42);
                                    } else {
                                        var22_14 = var2_2;
                                        var56_43 = var1_1.q.getContext();
                                        var57_44 = 2131231276;
                                        var56_43 = AppCompatResources.getDrawable(var56_43, var57_44);
                                    }
                                    var40_27 /* !! */  = var56_43;
                                    var2_2 = var22_14;
                                    break block149;
                                }
                                var22_14 = var2_2;
                                break block150;
                            }
                            var116_91 = var36_23;
                            var36_23 = 0;
                            var37_24 = 0.0f;
                            var38_25 /* !! */  = null;
                        }
                        var39_26 = 0;
                        var40_27 /* !! */  = null;
                    }
                    var22_14 = var2_2 & 1126037480013824L;
                    var110_88 = 0L;
                    var117_92 = var22_14 == var110_88 ? 0 : (var22_14 < var110_88 ? -1 : 1);
                    if (var117_92 != false) {
                        if (var8_6 /* !! */  != null) {
                            var85_64 = var8_6 /* !! */ .t();
                        }
                        var118_93 = var38_25 /* !! */ ;
                        var119_94 /* !! */  = var40_27 /* !! */ ;
                        var38_25 /* !! */  = var85_64;
                        var39_26 = 4;
                        var1_1.updateLiveDataRegistration(var39_26, (LiveData)var85_64);
                        if (var85_64 != null) {
                            var38_25 /* !! */  = var85_64.getValue();
                            var94_74 /* !! */  = var38_25 /* !! */ ;
                            var94_74 /* !! */  = (Stabilizer)var38_25 /* !! */ ;
                        }
                        var38_25 /* !! */  = var94_74 /* !! */ ;
                        var110_88 = var2_2 & 0x4000000000000L;
                        var114_90 = 0L;
                        cfr_temp_18 = var110_88 - var114_90;
                        var39_26 = (int)(cfr_temp_18 == 0L ? 0 : (cfr_temp_18 < 0L ? -1 : 1));
                        if (var39_26 != 0 && var94_74 /* !! */  != null) {
                            var40_27 /* !! */  = var94_74 /* !! */ .b;
                        } else {
                            var39_26 = 0;
                            var40_27 /* !! */  = null;
                        }
                        var110_88 = var2_2 & 0x2008000000L;
                        var120_95 = var110_88 == var114_90 ? 0 : (var110_88 < var114_90 ? -1 : 1);
                        if (var120_95 != false && var38_25 /* !! */  != null) {
                            var36_23 = 1;
                            var37_24 = 1.4E-45f;
                        } else {
                            var36_23 = 0;
                            var37_24 = 0.0f;
                            var38_25 /* !! */  = null;
                        }
                    } else {
                        var118_93 = var38_25 /* !! */ ;
                        var119_94 /* !! */  = var40_27 /* !! */ ;
                        var114_90 = 0L;
                        var36_23 = 0;
                        var37_24 = 0.0f;
                        var38_25 /* !! */  = null;
                        var39_26 = 0;
                        var40_27 /* !! */  = null;
                    }
                    var110_88 = var2_2 & var63_48;
                    var120_95 = var110_88 == var114_90 ? 0 : (var110_88 < var114_90 ? -1 : 1);
                    if (var120_95 != false) {
                        var121_96 = var96_76 != 0 ? var36_23 : 0;
                        if (var120_95 != false) {
                            var122_97 = var121_96 != 0 ? 0x20000000L : 0x10000000L;
                            var2_2 |= var122_97;
                        }
                        if (var121_96 != 0) {
                            var120_95 = 0;
                            var124_98 = 0.0f;
                            var125_99 /* !! */  = null;
                        } else {
                            var120_95 = var71_52;
                            var124_98 = var72_53;
                        }
                        var126_100 = var120_95;
                        var127_101 = var124_98;
                        var120_95 = var36_23;
                        var124_98 = var37_24;
                        var36_23 = (int)var126_100;
                        var37_24 = var127_101;
                    } else {
                        var120_95 = var36_23;
                        var124_98 = var37_24;
                        var36_23 = 0;
                        var37_24 = 0.0f;
                        var38_25 /* !! */  = null;
                    }
                    var110_88 = var2_2 & var67_50;
                    var114_90 = 0L;
                    var121_96 = (int)(var110_88 == var114_90 ? 0 : (var110_88 < var114_90 ? -1 : 1));
                    if (var121_96 == 0) ** GOTO lbl-1000
                    if (var47_35 == 0) {
                        var120_95 = 0;
                        var124_98 = 0.0f;
                        var125_99 /* !! */  = null;
                    }
                    if (var121_96 != 0) {
                        var110_88 = var120_95 != false ? 131072L : 65536L;
                        var2_2 |= var110_88;
                    }
                    if (var120_95 == false) {
                        var47_35 = var71_52;
                        var48_36 = var72_53;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var47_35 = 0;
                        var48_36 = 0.0f;
                        var50_38 = null;
                    }
                    var110_88 = var2_2 & var65_49;
                    var114_90 = 0L;
                    var120_95 = var110_88 == var114_90 ? 0 : (var110_88 < var114_90 ? -1 : 1);
                    if (var120_95 != false) {
                        if (var104_84) {
                            var40_27 /* !! */  = "@string/device_connect";
                        }
                    } else {
                        var39_26 = 0;
                        var40_27 /* !! */  = null;
                    }
                    if ((var120_95 = (cfr_temp_19 = (var110_88 = var2_2 & var61_47) - var114_90) == 0L ? 0 : (cfr_temp_19 < 0L ? -1 : 1)) != false) {
                        if (var101_80 != 0) {
                            var118_93 = var119_94 /* !! */ ;
                        }
                        var79_58 = var118_93;
                        var117_92 = var36_23;
                        var38_25 /* !! */  = var118_93;
                    } else {
                        var117_92 = var36_23;
                        var36_23 = 0;
                        var37_24 = 0.0f;
                        var38_25 /* !! */  = null;
                    }
                    var110_88 = var2_2 & var20_13;
                    var128_102 = var110_88 == var114_90 ? 0 : (var110_88 < var114_90 ? -1 : 1);
                    if (var128_102 != false && var128_102 != false) {
                        var110_88 = var7_5 != 0 ? 32768L : 16384L;
                        var2_2 |= var110_88;
                    }
                    if ((var128_102 = (cfr_temp_20 = (var110_88 = var2_2 & 0x800000000000L) - (var114_90 = 0L)) == 0L ? 0 : (cfr_temp_20 < 0L ? -1 : 1)) == false) break block151;
                    if (var8_6 /* !! */  != null) {
                        var119_94 /* !! */  = var8_6 /* !! */ .x();
                        var125_99 /* !! */  = var38_25 /* !! */ ;
                        var36_23 = 0;
                        var37_24 = 0.0f;
                        var38_25 /* !! */  = null;
                        var79_58 = var119_94 /* !! */ ;
                        var119_94 /* !! */  = var40_27 /* !! */ ;
                        var40_27 /* !! */  = var79_58;
                    } else {
                        var125_99 /* !! */  = var38_25 /* !! */ ;
                        var119_94 /* !! */  = var40_27 /* !! */ ;
                        var36_23 = 0;
                        var37_24 = 0.0f;
                        var38_25 /* !! */  = null;
                        var39_26 = 0;
                        var40_27 /* !! */  = null;
                    }
                    var1_1.updateLiveDataRegistration(0, (LiveData)var40_27 /* !! */ );
                    if (var40_27 /* !! */  != null) {
                        var40_27 /* !! */  = (BleDeviceViewModel$ScanFailType)var40_27 /* !! */ .getValue();
                    } else {
                        var39_26 = 0;
                        var40_27 /* !! */  = null;
                    }
                    var38_25 /* !! */  = BleDeviceViewModel$ScanFailType.FAIL_TYPE_BLUETOOTH_UNABLE;
                    if (var40_27 /* !! */  != var38_25 /* !! */ ) break block152;
                    var36_23 = 1;
                    var37_24 = 1.4E-45f;
                    break block153;
                }
                var125_99 /* !! */  = var38_25 /* !! */ ;
                var119_94 /* !! */  = var40_27 /* !! */ ;
            }
            var36_23 = 0;
            var37_24 = 0.0f;
            var38_25 /* !! */  = null;
        }
        var110_88 = var2_2 & var69_51;
        var114_90 = 0L;
        var39_26 = (int)(var110_88 == var114_90 ? 0 : (var110_88 < var114_90 ? -1 : 1));
        if (var39_26 == 0 || var32_19 == 0) {
            var36_23 = 0;
            var37_24 = 0.0f;
            var38_25 /* !! */  = null;
        }
        var110_88 = var2_2 & var53_41;
        var32_19 = (int)(var110_88 == var114_90 ? 0 : (var110_88 < var114_90 ? -1 : 1));
        if (var32_19 != 0) {
            if (var101_80 != 0) {
                var36_23 = 1;
                var37_24 = 1.4E-45f;
            }
            if (var32_19 != 0) {
                var110_88 = var36_23 != 0 ? 524288L : 262144L;
                var2_2 |= var110_88;
            }
            if (var36_23 != 0) {
                var71_52 = 0;
                var72_53 = 0.0f;
            }
            var32_19 = var71_52;
        } else {
            var32_19 = 0;
            var51_39 /* !! */  = null;
        }
        var129_103 = 16384L & var2_2;
        var110_88 = 0L;
        var36_23 = (int)(var129_103 == var110_88 ? 0 : (var129_103 < var110_88 ? -1 : 1));
        if (var36_23 == 0) ** GOTO lbl-1000
        if (var8_6 /* !! */  != null) {
            var8_6 /* !! */  = var8_6 /* !! */ .s();
        } else {
            var131_104 = 0;
            var8_6 /* !! */  = null;
        }
        var36_23 = 3;
        var37_24 = 4.2E-45f;
        var1_1.updateLiveDataRegistration(var36_23, (LiveData)var8_6 /* !! */ );
        if (var8_6 /* !! */  != null) {
            var8_6 /* !! */  = (BleDeviceViewModel$ConnectStatus)var8_6 /* !! */ .getValue();
        } else {
            var131_104 = 0;
            var8_6 /* !! */  = null;
        }
        var38_25 /* !! */  = BleDeviceViewModel$ConnectStatus.CONNECT_STATUS_DISCONNECT;
        if (var8_6 /* !! */  == var38_25 /* !! */ ) {
            var132_105 = true;
        } else lbl-1000:
        // 2 sources

        {
            var132_105 = false;
        }
        var129_103 = var2_2 & var20_13;
        var20_13 = 0L;
        var131_104 = var129_103 == var20_13 ? 0 : (var129_103 < var20_13 ? -1 : 1);
        if (var131_104 != 0) {
            var133_106 = var7_5 != 0 ? true : var132_105;
            if (var131_104 != 0) {
                var134_107 = var133_106 != false ? -9223372036854775808L : 0x4000000000000000L;
                var2_2 |= var134_107;
            }
            var136_108 /* !! */  = var1_1.c.getContext();
            var131_104 = var133_106 != false ? 2131231273 : 2131231360;
            var136_108 /* !! */  = AppCompatResources.getDrawable(var136_108 /* !! */ , var131_104);
        } else {
            var7_5 = 0;
            var136_108 /* !! */  = null;
        }
        var129_103 = 936L & var2_2;
        var20_13 = 0L;
        var131_104 = (int)(var129_103 == var20_13 ? 0 : (var129_103 < var20_13 ? -1 : 1));
        if (var131_104 != 0) {
            if (var6_4) {
                var137_109 = var1_1.c.getContext();
                var7_5 = 2131231371;
                var137_109 = AppCompatResources.getDrawable(var137_109, var7_5);
            } else {
                var137_109 = var136_108 /* !! */ ;
            }
        } else {
            var6_4 = false;
            var137_109 = null;
        }
        var129_103 = var2_2 & var73_54;
        var20_13 = 0L;
        var7_5 = (int)(var129_103 == var20_13 ? 0 : (var129_103 < var20_13 ? -1 : 1));
        if (var7_5 != 0) {
            var1_1.a.setVisibility(var43_31);
            var1_1.p.setVisibility(var43_31);
            var136_108 /* !! */  = var1_1.r;
            var36_23 = 0;
            var37_24 = 0.0f;
            var38_25 /* !! */  = null;
            l.a.q.g0.u.n((TextView)var136_108 /* !! */ , (String)var33_20, null, null);
            var136_108 /* !! */  = var1_1.g;
            var136_108 /* !! */ .setVisibility((int)var13_9 /* !! */ );
        }
        if ((var7_5 = (int)((cfr_temp_21 = (var138_110 = var2_2 & var26_16) - (var129_103 = 0L)) == 0L ? 0 : (cfr_temp_21 < 0L ? -1 : 1))) != 0) {
            ViewBindingAdapter.setBackground((View)var1_1.b, (Drawable)var42_30);
            ImageViewBindingAdapter.setImageDrawable(var1_1.e, (Drawable)var35_22);
            ViewBindingAdapter.setBackground((View)var1_1.o, (Drawable)var46_34 /* !! */ );
            var46_34 /* !! */  = var1_1.p;
            var36_23 = var116_91;
            var46_34 /* !! */ .setTextColor(var116_91);
            var46_34 /* !! */  = var1_1.r;
            var39_26 = var107_86;
            var46_34 /* !! */ .setTextColor(var107_86);
            var46_34 /* !! */  = var1_1.s;
            var34_21 = (int)var95_75;
            var46_34 /* !! */ .setTextColor((int)var95_75);
            var46_34 /* !! */  = var1_1.f;
            var136_108 /* !! */  = var99_78;
            var46_34 /* !! */ .setIndeterminateDrawable((Drawable)var99_78);
            var46_34 /* !! */  = var1_1.h;
            var7_5 = (int)var60_46 /* !! */ ;
            var46_34 /* !! */ .setTextColor((int)var60_46 /* !! */ );
            var46_34 /* !! */  = var1_1.i;
            var43_31 = var80_59;
            var46_34 /* !! */ .setTextColor(var80_59);
            var46_34 /* !! */  = var1_1.j;
            var136_108 /* !! */  = Converters.convertColorToDrawable(var75_55);
            ViewBindingAdapter.setBackground(var46_34 /* !! */ , (Drawable)var136_108 /* !! */ );
        }
        if ((var49_37 = (int)((cfr_temp_22 = (var138_110 = var2_2 & var67_50) - (var14_10 = 0L)) == 0L ? 0 : (cfr_temp_22 < 0L ? -1 : 1))) != 0) {
            var46_34 /* !! */  = var1_1.b;
            var46_34 /* !! */ .setVisibility(var47_35);
        }
        if ((var49_37 = (int)((cfr_temp_23 = (var4_3 = 512L & var2_2) - var14_10) == 0L ? 0 : (cfr_temp_23 < 0L ? -1 : 1))) != 0) {
            var46_34 /* !! */  = var1_1.c;
            var50_38 = var1_1.v;
            var46_34 /* !! */ .setOnClickListener((View.OnClickListener)var50_38);
            var46_34 /* !! */  = var1_1.d;
            var50_38 = var1_1.u;
            var46_34 /* !! */ .setOnClickListener((View.OnClickListener)var50_38);
            var46_34 /* !! */  = var1_1.e;
            var50_38 = var1_1.t;
            var46_34 /* !! */ .setOnClickListener((View.OnClickListener)var50_38);
        }
        if (var131_104 != 0) {
            var46_34 /* !! */  = var1_1.c;
            ImageViewBindingAdapter.setImageDrawable((ImageView)var46_34 /* !! */ , (Drawable)var137_109);
        }
        if (var6_4 = (cfr_temp_24 = (var4_3 = var2_2 & var61_47) - (var134_107 = 0L)) == 0L ? 0 : (cfr_temp_24 < 0L ? -1 : 1)) {
            var137_109 = var1_1.q;
            var46_34 /* !! */  = var125_99 /* !! */ ;
            ImageViewBindingAdapter.setImageDrawable((ImageView)var137_109, (Drawable)var125_99 /* !! */ );
        }
        if (var6_4 = (cfr_temp_25 = (var4_3 = var2_2 & var53_41) - var134_107) == 0L ? 0 : (cfr_temp_25 < 0L ? -1 : 1)) {
            var1_1.q.setVisibility(var32_19);
            var137_109 = var1_1.r;
            var137_109.setVisibility(var32_19);
        }
        if (var6_4 = (cfr_temp_26 = (var4_3 = var2_2 & var65_49) - var134_107) == 0L ? 0 : (cfr_temp_26 < 0L ? -1 : 1)) {
            var137_109 = var1_1.h;
            var40_27 /* !! */  = var119_94 /* !! */ ;
            var49_37 = 0;
            var46_34 /* !! */  = null;
            l.a.q.g0.u.n((TextView)var137_109, (String)var119_94 /* !! */ , null, null);
        }
        if (var6_4 = (cfr_temp_27 = (var2_2 &= var63_48) - var134_107) == 0L ? 0 : (cfr_temp_27 < 0L ? -1 : 1)) {
            var137_109 = var1_1.i;
            var55_42 = (int)var117_92;
            var137_109.setVisibility((int)var117_92);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.w;
            long l11 = 0L;
            Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (object != false) return (boolean)((Object)1);
            l10 = this.x;
            long l12 = l10 - l11;
            object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object != false) return (boolean)((Object)1);
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
            this.w = l10 = 512L;
            this.x = l10 = 0L;
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
                            return false;
                        }
                        object = (MutableLiveData)object;
                        return this.H((MutableLiveData)object, n11);
                    }
                    object = (MutableLiveData)object;
                    return this.G((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.K((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.J((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.I((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 33;
        if (n11 == n10) {
            object = (Boolean)object;
            n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
            this.E(n10 != 0);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 == n10) {
                object = (s$d)object;
                this.D((s$d)object);
                return 1 != 0;
            } else {
                n11 = 9;
                if (n11 == n10) {
                    object = (Boolean)object;
                    n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                    this.C(n10 != 0);
                    return 1 != 0;
                } else {
                    n11 = 152;
                    if (n11 != n10) return 0 != 0;
                    object = (BleDeviceViewModel)object;
                    this.F((BleDeviceViewModel)object);
                }
            }
        }
        return 1 != 0;
    }
}

