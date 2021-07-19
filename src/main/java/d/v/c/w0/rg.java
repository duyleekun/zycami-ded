/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.api.entity.BindDeviceInfo;
import com.zhiyun.cama.set.bind.DeviceBindViewModel;
import com.zhiyun.cama.set.bind.DeviceDetailFragment$b;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.qg;
import d.v.f.e.c;
import l.a.q.g0.u;

public class rg
extends qg
implements b$a {
    private static final ViewDataBinding$IncludedLayouts F;
    private static final SparseIntArray G;
    private final TextView A;
    private final View.OnClickListener B;
    private final View.OnClickListener C;
    private final View.OnClickListener D;
    private long E;
    private final ConstraintLayout r;
    private final TextView s;
    private final TextView t;
    private final TextView u;
    private final Button v;
    private final TextView w;
    private final TextView x;
    private final TextView y;
    private final TextView z;

    static {
        SparseIntArray sparseIntArray;
        G = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362497, 18);
        sparseIntArray.put(2131363416, 19);
        sparseIntArray.put(2131362279, 20);
        sparseIntArray.put(2131363417, 21);
        sparseIntArray.put(2131362280, 22);
        sparseIntArray.put(2131363418, 23);
        sparseIntArray.put(2131362281, 24);
    }

    public rg(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = F;
        SparseIntArray sparseIntArray = G;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 25, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private rg(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        rg rg2 = this;
        Object object = this;
        Object object2 = dataBindingComponent;
        View view2 = (View)objectArray[20];
        View view3 = (View)objectArray[22];
        View view4 = (View)objectArray[24];
        View view5 = (View)objectArray[11];
        View view6 = (View)objectArray[14];
        View view7 = (View)objectArray[7];
        FrameLayout frameLayout = (FrameLayout)objectArray[18];
        ImageView imageView = (ImageView)objectArray[1];
        TextView textView = (TextView)objectArray[12];
        TextView textView2 = (TextView)objectArray[15];
        TextView textView3 = (TextView)objectArray[9];
        TextView textView4 = (TextView)objectArray[5];
        TextView textView5 = (TextView)objectArray[19];
        TextView textView6 = (TextView)objectArray[21];
        TextView textView7 = (TextView)objectArray[23];
        int n10 = 1;
        super(dataBindingComponent, view, n10, view2, view3, view4, view5, view6, view7, frameLayout, imageView, textView, textView2, textView3, textView4, textView5, textView6, textView7);
        this.E = -1;
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.h.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.r = object;
        object.setTag(null);
        object = (TextView)objectArray[10];
        this.s = object;
        object.setTag(null);
        object = (TextView)objectArray[13];
        this.t = object;
        object.setTag(null);
        object = (TextView)objectArray[16];
        this.u = object;
        object.setTag(null);
        object = (Button)objectArray[17];
        this.v = object;
        object.setTag(null);
        int n11 = 2;
        rg2 = (TextView)objectArray[n11];
        this.w = rg2;
        rg2.setTag(null);
        n10 = 3;
        view2 = (TextView)objectArray[n10];
        this.x = view2;
        view2.setTag(null);
        view2 = (TextView)objectArray[4];
        this.y = view2;
        view2.setTag(null);
        view2 = (TextView)objectArray[6];
        this.z = view2;
        view2.setTag(null);
        view2 = (TextView)objectArray[8];
        this.A = view2;
        view2.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        object2 = view;
        this.setRootTag(view);
        object2 = new b(this, 1);
        this.B = object2;
        object2 = new b(this, n11);
        this.C = object2;
        super(this, n10);
        this.D = object;
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
                long l10 = this.E;
                long l11 = 1L;
                this.E = l10 |= l11;
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
    public void A(DeviceBindViewModel deviceBindViewModel) {
        this.q = deviceBindViewModel;
        synchronized (this) {
            long l10 = this.E;
            long l11 = 2;
            this.E = l10 |= l11;
        }
        this.notifyPropertyChanged(11);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(DeviceDetailFragment$b deviceDetailFragment$b) {
        this.p = deviceDetailFragment$b;
        synchronized (this) {
            long l10 = this.E;
            long l11 = 4;
            this.E = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    public final void a(int n10, View object) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 == n13) {
                    DeviceDetailFragment$b deviceDetailFragment$b = this.p;
                    if (deviceDetailFragment$b != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        deviceDetailFragment$b.b();
                    }
                }
            } else {
                Object object2 = this.q;
                object = this.p;
                int n14 = object2 != null ? n12 : 0;
                if (n14 != 0 && (n14 = (object2 = ((DeviceBindViewModel)object2).a) != null ? n12 : 0) != 0 && (n14 = (object2 = (BindDeviceInfo)((LiveData)object2).getValue()) != null ? n12 : 0) != 0) {
                    if ((object2 = ((BindDeviceInfo)object2).getBindAt()) != null) {
                        n10 = n12;
                    } else {
                        n10 = 0;
                        object2 = null;
                    }
                    if (n10 != 0) {
                        if (object != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            ((DeviceDetailFragment$b)object).j();
                        }
                    } else {
                        if (object != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            ((DeviceDetailFragment$b)object).a();
                        }
                    }
                }
            }
        } else {
            DeviceDetailFragment$b deviceDetailFragment$b = this.p;
            if (deviceDetailFragment$b != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                deviceDetailFragment$b.c((View)object);
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
            var2_2 = this.E;
            this.E = var4_3 = 0L;
        }
        var6_4 = this.q;
        var7_5 = 11;
        var9_6 = var2_2 & var7_5;
        var11_7 = var9_6 == var4_3 ? 0 : (var9_6 < var4_3 ? -1 : 1);
        var12_8 = 128L;
        var14_9 = 1;
        var15_10 = 1.4E-45f;
        var16_11 = 0;
        var17_12 = null;
        if (var11_7 != false) {
            if (var6_4 != null) {
                var18_13 = var6_4.a;
                var19_14 = var6_4.A();
            } else {
                var19_14 = false;
                var18_13 = null;
            }
            var1_1.updateLiveDataRegistration(0, (LiveData)var18_13);
            if (var11_7 != false) {
                if (var19_14) {
                    var2_2 |= var12_8;
                } else {
                    var20_15 = 64;
                    var2_2 |= var20_15;
                }
            }
            if (var18_13 != null) {
                var22_16 = (BindDeviceInfo)var18_13.getValue();
            } else {
                var11_7 = 0;
                var22_16 = null;
            }
            if (var22_16 != null) {
                var18_13 = var22_16.getDeviceModel();
                var23_17 = var22_16.getFirmwareVersion();
                var24_18 = var22_16.getTheme();
                var25_19 = var22_16.getDeviceName();
                var26_20 = var22_16.getBindAt();
                var27_21 = var22_16.getBindTime();
                var28_22 = var22_16.getSn();
                var29_23 = var22_16.getActiveTime();
            } else {
                var18_13 = null;
                var30_24 = false;
                var23_17 = null;
                var31_25 = 0;
                var24_18 = null;
                var25_19 = null;
                var32_26 = 0;
                var33_27 = 0.0f;
                var26_20 = null;
                var27_21 = null;
                var28_22 = null;
                var34_28 = false;
                var29_23 = null;
            }
            if (var23_17 != null) {
                var35_29 = var14_9;
                var36_30 = var15_10;
            } else {
                var35_29 = 0;
                var36_30 = 0.0f;
            }
            if (var24_18 == null) {
                var37_31 = var14_9;
                var38_32 = var15_10;
            } else {
                var37_31 = 0;
                var38_32 = 0.0f;
            }
            if (var26_20 != null) {
                var32_26 = var14_9;
                var33_27 = var15_10;
            } else {
                var32_26 = 0;
                var26_20 = null;
                var33_27 = 0.0f;
            }
            var39_33 = var2_2 & var7_5;
            var41_34 = var39_33 == var4_3 ? 0 : (var39_33 < var4_3 ? -1 : 1);
            if (var41_34 != false) {
                var39_33 = var37_31 != 0 ? 2048L : 1024L;
                var2_2 |= var39_33;
            }
            if ((var41_34 = (cfr_temp_0 = (var39_33 = var2_2 & var7_5) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false) {
                if (var32_26 != 0) {
                    var2_2 |= 8192L;
                    var39_33 = 524288L;
                } else {
                    var2_2 |= 4096L;
                    var39_33 = 262144L;
                }
                var2_2 |= var39_33;
            }
            if (var24_18 != null) {
                var16_11 = var31_25 = var24_18.getValue();
            }
            if (var37_31 != 0) {
                var37_31 = 8;
                var38_32 = 1.1E-44f;
            } else {
                var37_31 = 0;
                var38_32 = 0.0f;
            }
            var42_35 = var32_26 != 0 ? "@string/unlink" : "@string/link";
            if (var32_26 != 0) {
                var43_36 /* !! */  = var1_1.w;
                var44_37 = ViewDataBinding.getColorFromResource((View)var43_36 /* !! */ , 2131099814);
            } else {
                var45_38 = var1_1.w;
                var46_40 = 2131099756;
                var44_37 = ViewDataBinding.getColorFromResource((View)var45_38, var46_40);
            }
            if (var16_11 == var14_9) {
                var46_40 = var14_9;
            } else {
                var46_40 = 0;
                var47_42 = null;
            }
            var48_43 = var2_2 & var7_5;
            var16_11 = (int)(var48_43 == var4_3 ? 0 : (var48_43 < var4_3 ? -1 : 1));
            if (var16_11 != 0) {
                var48_43 = var46_40 != 0 ? 512L : 256L;
                var2_2 |= var48_43;
            }
            var47_42 = var46_40 != 0 ? "@string/camera_theme_pink" : "@string/camera_theme_pearl";
            var17_12 = var23_17;
            var43_36 /* !! */  = var25_19;
            var50_44 = var32_26;
            var51_45 = var27_21;
            var52_46 = var28_22;
            var53_47 = var29_23;
            var54_48 = var35_29;
            var55_49 = var36_30;
            var56_50 = var37_31;
            var57_51 = var42_35;
            var58_52 = 128L;
        } else {
            var58_52 = var12_8;
            var11_7 = 0;
            var22_16 = null;
            var44_37 = 0;
            var45_39 = null;
            var46_41 = false;
            var47_42 = null;
            var16_11 = 0;
            var17_12 = null;
            var43_36 /* !! */  = null;
            var18_13 = null;
            var19_14 = false;
            var50_44 = 0;
            var51_45 = null;
            var52_46 = null;
            var53_47 = null;
            var54_48 = 0;
            var55_49 = 0.0f;
            var56_50 = 0;
            var57_51 = null;
        }
        var58_52 = var2_2 & var58_52;
        var30_24 = var58_52 == var4_3 ? 0 : (var58_52 < var4_3 ? -1 : 1);
        if (var30_24) {
            if (var22_16 != null) {
                var11_7 = (long)var22_16.isFetchSuccess();
            } else {
                var11_7 = 0;
                var22_16 = null;
            }
            var11_7 = var11_7 ^ var14_9;
        } else {
            var11_7 = 0;
            var22_16 = null;
        }
        var30_24 = (cfr_temp_1 = (var2_2 & var7_5) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1);
        var58_52 = 16384L;
        if (var30_24) {
            if (!var19_14) {
                var11_7 = 0;
                var22_16 = null;
            }
            if (var30_24) {
                if (var11_7 != false) {
                    var60_53 = 32768L;
                    var2_2 |= var60_53;
                } else {
                    var2_2 |= var58_52;
                }
            }
        } else {
            var11_7 = 0;
            var22_16 = null;
        }
        var30_24 = (cfr_temp_2 = (var2_2 & var58_52) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1);
        var60_53 = 131072L;
        if (var30_24) {
            var34_28 = var19_14 ^ true;
            if (var30_24) {
                if (var34_28) {
                    var2_2 |= var60_53;
                } else {
                    var62_54 = 65536L;
                    var2_2 |= var62_54;
                }
            }
        } else {
            var34_28 = false;
            var29_23 = null;
        }
        if (!(var30_24 = (cfr_temp_3 = (var60_53 = var2_2 & var60_53) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) ** GOTO lbl-1000
        if (var6_4 != null) {
            var6_4 = var6_4.y();
        } else {
            var64_55 = 0;
            var65_56 = 0.0f;
            var6_4 = null;
        }
        if (var6_4 != null) {
            var6_4 = var6_4.getBindAt();
        } else {
            var64_55 = 0;
            var65_56 = 0.0f;
            var6_4 = null;
        }
        if (var6_4 == null) {
            var64_55 = var14_9;
            var65_56 = var15_10;
        } else lbl-1000:
        // 2 sources

        {
            var64_55 = 0;
            var65_56 = 0.0f;
            var6_4 = null;
        }
        var58_52 = var2_2 & var58_52;
        var30_24 = var58_52 == var4_3 ? 0 : (var58_52 < var4_3 ? -1 : 1);
        if (!var30_24 || !var34_28) {
            var64_55 = 0;
            var65_56 = 0.0f;
            var6_4 = null;
        }
        var58_52 = var2_2 & var7_5;
        var30_24 = var58_52 == var4_3 ? 0 : (var58_52 < var4_3 ? -1 : 1);
        if (!var30_24) ** GOTO lbl-1000
        if (var11_7 == false) {
            var14_9 = var64_55;
            var15_10 = var65_56;
        }
        if (var30_24) {
            var58_52 = var14_9 != 0 ? (long)32 : (long)16;
            var2_2 |= var58_52;
        }
        if (var14_9 != 0) {
            var64_55 = 4;
            var65_56 = 5.6E-45f;
        } else lbl-1000:
        // 2 sources

        {
            var64_55 = 0;
            var65_56 = 0.0f;
            var6_4 = null;
        }
        var66_57 = (cfr_temp_4 = (var7_5 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1);
        if (var66_57 != false) {
            var1_1.d.setVisibility(var56_50);
            var67_58 /* !! */  = var1_1.e;
            var11_7 = var50_44;
            d.v.f.e.c.a(var67_58 /* !! */ , (boolean)var50_44);
            var67_58 /* !! */  = var1_1.f;
            var14_9 = var54_48;
            var15_10 = var55_49;
            d.v.f.e.c.a(var67_58 /* !! */ , (boolean)var54_48);
            var1_1.s.setVisibility(var56_50);
            var67_58 /* !! */  = var1_1.s;
            var68_59 = null;
            l.a.q.g0.u.n((TextView)var67_58 /* !! */ , var47_42, null, null);
            d.v.f.e.c.a((View)var1_1.t, (boolean)var50_44);
            var69_60 /* !! */  = var1_1.t;
            var67_58 /* !! */  = var53_47;
            l.a.q.g0.u.n(var69_60 /* !! */ , var53_47, null, null);
            d.v.f.e.c.a((View)var1_1.u, (boolean)var50_44);
            var69_60 /* !! */  = var1_1.u;
            var67_58 /* !! */  = var51_45;
            l.a.q.g0.u.n(var69_60 /* !! */ , var51_45, null, null);
            var1_1.w.setVisibility(var64_55);
            var1_1.w.setTextColor(var44_37);
            var6_4 = var1_1.w;
            var69_60 /* !! */  = var57_51;
            l.a.q.g0.u.n((TextView)var6_4, var57_51, null, null);
            l.a.q.g0.u.n(var1_1.x, (String)var18_13, null, null);
            l.a.q.g0.u.n(var1_1.y, (String)var43_36 /* !! */ , null, null);
            d.v.f.e.c.a((View)var1_1.z, (boolean)var54_48);
            l.a.q.g0.u.n(var1_1.z, var17_12, null, null);
            var6_4 = var1_1.A;
            var69_60 /* !! */  = var52_46;
            l.a.q.g0.u.n((TextView)var6_4, var52_46, null, null);
            d.v.f.e.c.a((View)var1_1.i, (boolean)var50_44);
            d.v.f.e.c.a((View)var1_1.j, (boolean)var50_44);
            var1_1.k.setVisibility(var56_50);
            var6_4 = var1_1.l;
            d.v.f.e.c.a((View)var6_4, (boolean)var54_48);
        }
        if ((var64_55 = (int)((cfr_temp_5 = (var4_3 = (long)8 & var2_2) - (var7_5 = 0L)) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.h;
            var68_59 = var1_1.B;
            var6_4.setOnClickListener(var68_59);
            var6_4 = var1_1.v;
            var68_59 = var1_1.D;
            var6_4.setOnClickListener(var68_59);
            var6_4 = var1_1.w;
            var68_59 = var1_1.C;
            var6_4.setOnClickListener(var68_59);
        }
        if ((var64_55 = (cfr_temp_6 = (var2_2 &= (long)10) - (var4_3 = 0L)) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1)) != 0) {
            var6_4 = var1_1.v;
            d.v.f.e.c.a((View)var6_4, var19_14);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.E;
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
            this.E = l10 = (long)8;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (MutableLiveData)object;
        return this.C((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 11;
        if (n11 == n10) {
            object = (DeviceBindViewModel)object;
            this.A((DeviceBindViewModel)object);
            return 1 != 0;
        } else {
            n11 = 23;
            if (n11 != n10) return 0 != 0;
            object = (DeviceDetailFragment$b)object;
            this.B((DeviceDetailFragment$b)object);
        }
        return 1 != 0;
    }
}

