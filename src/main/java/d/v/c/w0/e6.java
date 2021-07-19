/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.zhiyun.cama.device.connect.DeviceConnectFragment$c;
import com.zhiyun.device.connection.BleDeviceViewModel;
import com.zhiyun.device.connection.BleDeviceViewModel$ScanFailType;
import com.zhiyun.device.connection.BleDeviceViewModel$ShowStatus;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.d6;
import l.a.q.g0.u;

public class e6
extends d6
implements b$a {
    private static final ViewDataBinding$IncludedLayouts r;
    private static final SparseIntArray s;
    private final ConstraintLayout i;
    private final ImageView j;
    private final ImageView k;
    private final TextView l;
    private final Button m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private long q;

    static {
        SparseIntArray sparseIntArray;
        s = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362205, 9);
        sparseIntArray.put(2131363608, 10);
    }

    public e6(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = r;
        SparseIntArray sparseIntArray = s;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 11, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private e6(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        int n10 = 3;
        Object object2 = object = objectArray[n10];
        object2 = (LottieAnimationView)object;
        Object object3 = object = objectArray[9];
        object3 = (ConstraintLayout)((Object)object);
        int n11 = 2;
        Object object4 = object = objectArray[n11];
        object4 = (ImageButton)object;
        int n12 = 1;
        Object object5 = object = objectArray[n12];
        object5 = (ImageButton)object;
        Object object6 = object = objectArray[6];
        object6 = (RecyclerView)object;
        Object object7 = object = objectArray[10];
        object7 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 4, (LottieAnimationView)object2, (ConstraintLayout)((Object)object3), (ImageButton)object4, (ImageButton)object5, (RecyclerView)object6, (TextView)object7);
        this.q = -1;
        this.a.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.i = object;
        object.setTag(null);
        object = (ImageView)objectArray[4];
        this.j = object;
        object.setTag(null);
        object = (ImageView)objectArray[5];
        this.k = object;
        object.setTag(null);
        object = (TextView)objectArray[7];
        this.l = object;
        object.setTag(null);
        object = (Button)objectArray[8];
        this.m = object;
        object.setTag(null);
        this.e.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n12);
        this.n = object;
        object = new b(this, n11);
        this.o = object;
        object = new b(this, n10);
        this.p = object;
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
                long l10 = this.q;
                long l11 = 8;
                this.q = l10 |= l11;
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
                long l10 = this.q;
                long l11 = 2;
                this.q = l10 |= l11;
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
                long l10 = this.q;
                long l11 = 4;
                this.q = l10 |= l11;
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
                long l10 = this.q;
                long l11 = 1L;
                this.q = l10 |= l11;
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
    public void A(DeviceConnectFragment$c deviceConnectFragment$c) {
        this.g = deviceConnectFragment$c;
        synchronized (this) {
            long l10 = this.q;
            long l11 = 32;
            this.q = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(BleDeviceViewModel bleDeviceViewModel) {
        this.h = bleDeviceViewModel;
        synchronized (this) {
            long l10 = this.q;
            long l11 = 16;
            this.q = l10 |= l11;
        }
        this.notifyPropertyChanged(154);
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
                    DeviceConnectFragment$c deviceConnectFragment$c = this.g;
                    if (deviceConnectFragment$c != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        deviceConnectFragment$c.b();
                    }
                }
            } else {
                DeviceConnectFragment$c deviceConnectFragment$c = this.g;
                if (deviceConnectFragment$c != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    deviceConnectFragment$c.c();
                }
            }
        } else {
            DeviceConnectFragment$c deviceConnectFragment$c = this.g;
            if (deviceConnectFragment$c != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                deviceConnectFragment$c.a();
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
        block78: {
            block77: {
                block76: {
                    block70: {
                        block72: {
                            block75: {
                                block74: {
                                    block73: {
                                        var1_1 = this;
                                        synchronized (this) {
                                            var2_2 = this.q;
                                            this.q = var4_3 = 0L;
                                        }
                                        var6_4 = this.h;
                                        var7_5 = (long)95 & var2_2;
                                        var9_6 /* !! */  = var7_5 == var4_3 ? 0 : (var7_5 < var4_3 ? -1 : 1);
                                        var10_7 = 1024L;
                                        var12_8 = 512L;
                                        var14_9 = 84;
                                        var16_10 = 128L;
                                        var18_11 = 65536L;
                                        var20_12 = 8;
                                        var21_13 = 1.1E-44f;
                                        var22_14 = 81;
                                        var24_15 = 83;
                                        var26_16 = 0;
                                        var27_17 = null;
                                        if (var9_6 /* !! */  == false) break block72;
                                        var28_18 = var2_2 & var24_15;
                                        cfr_temp_0 = var28_18 - var4_3;
                                        var9_6 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                        if (var9_6 /* !! */  == false) break block73;
                                        if (var6_4 != null) {
                                            var30_19 /* !! */  = var6_4.F();
                                        } else {
                                            var9_6 /* !! */  = 0;
                                            var30_19 /* !! */  = null;
                                        }
                                        var1_1.updateLiveDataRegistration(0, var30_19 /* !! */ );
                                        if (var30_19 /* !! */  != null) {
                                            var30_19 /* !! */  = (BleDeviceViewModel$ShowStatus)var30_19 /* !! */ .getValue();
                                        } else {
                                            var9_6 /* !! */  = 0;
                                            var30_19 /* !! */  = null;
                                        }
                                        var28_18 = var2_2 & var22_14;
                                        var31_20 = var28_18 == var4_3 ? 0 : (var28_18 < var4_3 ? -1 : 1);
                                        if (var31_20 != 0) {
                                            var27_17 = BleDeviceViewModel$ShowStatus.SHOW_STATE_SCANNING;
                                            if (var30_19 /* !! */  == var27_17) {
                                                var26_16 = 1;
                                            } else {
                                                var26_16 = 0;
                                                var27_17 = null;
                                            }
                                            var32_21 = BleDeviceViewModel$ShowStatus.SHOW_STATE_DEVICE_LIST;
                                            if (var30_19 /* !! */  == var32_21) {
                                                var33_25 = 1;
                                            } else {
                                                var33_25 = 0;
                                                var32_21 = null;
                                            }
                                            if (var31_20 != 0) {
                                                var2_2 = var26_16 != 0 ? (var2_2 |= var10_7) : (var2_2 |= var12_8);
                                            }
                                            if ((var31_20 = (cfr_temp_1 = (var34_26 = var2_2 & var22_14) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != 0) {
                                                var34_26 = var33_25 != 0 ? 16384L : 8192L;
                                                var2_2 |= var34_26;
                                            }
                                            var31_20 = var26_16 != 0 ? 0 : var20_12;
                                            if (var33_25 != 0) {
                                                var33_25 = 0;
                                                var32_21 = null;
                                            } else {
                                                var33_25 = var20_12;
                                            }
                                        } else {
                                            var33_25 = 0;
                                            var32_22 = null;
                                            var26_16 = 0;
                                            var27_17 = null;
                                            var31_20 = 0;
                                        }
                                        var36_27 = BleDeviceViewModel$ShowStatus.SHOW_STATE_FAIL;
                                        if (var30_19 /* !! */  == var36_27) {
                                            var37_30 = true;
                                        } else {
                                            var37_30 = false;
                                            var36_27 = null;
                                        }
                                        var38_31 = BleDeviceViewModel$ShowStatus.SHOW_STATE_NO_DEVICE;
                                        if (var30_19 /* !! */  == var38_31) {
                                            var39_34 = true;
                                        } else {
                                            var39_34 = false;
                                            var38_31 = null;
                                        }
                                        var40_35 = var2_2 & 524371L;
                                        var42_36 = (int)(var40_35 == var4_3 ? 0 : (var40_35 < var4_3 ? -1 : 1));
                                        if (var42_36 != 0) {
                                            if (var37_30) {
                                                var2_2 |= var18_11;
                                            } else {
                                                var40_35 = 32768L;
                                                var2_2 |= var40_35;
                                            }
                                        }
                                        if ((var42_36 = (int)((cfr_temp_2 = (var40_35 = var2_2 & var24_15) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) != 0) {
                                            if (var39_34) {
                                                var40_35 = 256L;
                                                var2_2 |= var40_35;
                                            } else {
                                                var2_2 |= var16_10;
                                            }
                                        }
                                        if ((var42_36 = (int)((cfr_temp_3 = (var40_35 = var2_2 & var22_14) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) != 0) {
                                            var40_35 = var39_34 != false ? 262144L : 131072L;
                                            var2_2 |= var40_35;
                                        }
                                        if ((var42_36 = (int)((cfr_temp_4 = (var40_35 = var2_2 & var22_14) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) == 0 || var39_34) break block74;
                                        var42_36 = var20_12;
                                        break block75;
                                    }
                                    var9_6 /* !! */  = 0;
                                    var30_19 /* !! */  = null;
                                    var37_30 = false;
                                    var36_28 = null;
                                    var39_34 = false;
                                    var38_32 = null;
                                    var33_25 = 0;
                                    var32_23 = null;
                                    var26_16 = 0;
                                    var27_17 = null;
                                    var31_20 = 0;
                                }
                                var42_36 = 0;
                            }
                            var43_37 = var2_2 & var14_9;
                            var45_38 = var43_37 == var4_3 ? 0 : (var43_37 < var4_3 ? -1 : 1);
                            if (var45_38 == false) ** GOTO lbl-1000
                            if (var6_4 != null) {
                                var46_39 = var6_4.y();
                                var47_40 = var46_39;
                            } else {
                                var47_40 = null;
                            }
                            var48_41 = 2;
                            var1_1.updateLiveDataRegistration(var48_41, (LiveData)var47_40);
                            if (var47_40 != null) {
                                var47_40 = (String)var47_40.getValue();
                            } else lbl-1000:
                            // 2 sources

                            {
                                var47_40 = null;
                            }
                            var49_42 = 88;
                            var51_43 = var2_2 & var49_42;
                            var48_41 = (int)(var51_43 == var4_3 ? 0 : (var51_43 < var4_3 ? -1 : 1));
                            if (var48_41 != 0) {
                                if (var6_4 != null) {
                                    var53_44 = var6_4.t();
                                    var54_45 = var53_44;
                                } else {
                                    var55_48 = 0;
                                    var54_45 = null;
                                }
                                var56_49 = 3;
                                var1_1.updateLiveDataRegistration(var56_49, (LiveData)var54_45);
                                if (var54_45 != null) {
                                    var54_45 = (Stabilizer)var54_45.getValue();
                                } else {
                                    var55_48 = 0;
                                    var54_45 = null;
                                }
                                if (var54_45 == null) {
                                    var55_48 = 1;
                                } else {
                                    var55_48 = 0;
                                    var54_45 = null;
                                }
                                if (var48_41 != 0) {
                                    var57_50 = var55_48 != 0 ? 0x1000000L : 0x800000L;
                                    var2_2 |= var57_50;
                                }
                                if (var55_48 != 0) {
                                    var55_48 = 0;
                                    var54_45 = null;
                                } else {
                                    var55_48 = var20_12;
                                }
                                var56_49 = var31_20;
                                var48_41 = var42_36;
                                break block70;
                            } else {
                                var56_49 = var31_20;
                                var48_41 = var42_36;
                                var55_48 = 0;
                                var54_46 = null;
                            }
                            break block70;
                        }
                        var9_6 /* !! */  = 0;
                        var30_19 /* !! */  = null;
                        var55_48 = 0;
                        var54_47 = null;
                        var56_49 = 0;
                        var37_30 = false;
                        var36_29 = null;
                        var39_34 = false;
                        var38_33 = null;
                        var33_25 = 0;
                        var32_24 = null;
                        var26_16 = 0;
                        var27_17 = null;
                        var47_40 = null;
                        var48_41 = 0;
                    }
                    var18_11 = var2_2 & var18_11;
                    var59_51 = var18_11 == var4_3 ? 0 : (var18_11 < var4_3 ? -1 : 1);
                    if (var59_51 == false) break block76;
                    if (var6_4 != null) {
                        var6_4 = var6_4.x();
                    } else {
                        var60_52 = 0;
                        var6_4 = null;
                    }
                    var61_53 = 1;
                    var1_1.updateLiveDataRegistration(var61_53, (LiveData)var6_4);
                    if (var6_4 != null) {
                        var6_4 = (BleDeviceViewModel$ScanFailType)var6_4.getValue();
                    } else {
                        var60_52 = 0;
                        var6_4 = null;
                    }
                    var62_54 = BleDeviceViewModel$ScanFailType.FAIL_TYPE_BLUETOOTH_UNABLE;
                    if (var6_4 != var62_54) break block77;
                    var60_52 = var61_53;
                    break block78;
                }
                var61_53 = 1;
            }
            var60_52 = 0;
            var6_4 = null;
        }
        var18_11 = 0L;
        cfr_temp_5 = (var16_10 &= var2_2) - var18_11;
        var63_55 = cfr_temp_5 == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1);
        if (var63_55 != false) {
            var62_54 = BleDeviceViewModel$ShowStatus.SHOW_STATE_SCANNING;
            if (var30_19 /* !! */  == var62_54) {
                var26_16 = var61_53;
            } else {
                var26_16 = 0;
                var27_17 = null;
            }
            var64_56 = var2_2 & var22_14;
            var63_55 = var64_56 == var18_11 ? 0 : (var64_56 < var18_11 ? -1 : 1);
            if (var63_55 != false) {
                var64_56 = var26_16 != 0 ? 1024L : 512L;
                var2_2 |= var64_56;
            }
        }
        if ((var63_55 = (cfr_temp_6 = (var64_56 = var2_2 & var24_15) - var18_11) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1)) != false) {
            if (var39_34) {
                var26_16 = var61_53;
            }
            if (!var37_30) {
                var60_52 = 0;
                var6_4 = null;
            }
            if (var63_55 != false) {
                var64_56 = var26_16 != 0 ? 0x100000L : 524288L;
                var2_2 |= var64_56;
            }
            if ((var63_55 = (cfr_temp_7 = (var64_56 = var2_2 & var24_15) - (var12_8 = 0L)) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1)) != false) {
                var64_56 = var60_52 != 0 ? 4096L : 2048L;
                var2_2 |= var64_56;
            }
            if (var60_52 != 0) {
                var63_55 = 0;
                var62_54 = null;
            } else {
                var63_55 = var20_12;
            }
        } else {
            var60_52 = 0;
            var6_4 = null;
            var63_55 = 0;
            var62_54 = null;
            var26_16 = 0;
            var27_17 = null;
        }
        var12_8 = var2_2 & var24_15;
        var16_10 = 0L;
        var9_6 /* !! */  = var12_8 == var16_10 ? 0 : (var12_8 < var16_10 ? -1 : 1);
        if (var9_6 /* !! */  != false) {
            if (var26_16 != 0) {
                var60_52 = var61_53;
            }
            if (var9_6 /* !! */  != false) {
                var12_8 = var60_52 != 0 ? 0x400000L : 0x200000L;
                var2_2 |= var12_8;
            }
            if (var60_52 != 0) {
                var20_12 = 0;
                var21_13 = 0.0f;
            }
            var26_16 = var20_12;
        } else {
            var26_16 = 0;
            var27_17 = null;
        }
        var12_8 = var2_2 & var22_14;
        var16_10 = 0L;
        var60_52 = (int)(var12_8 == var16_10 ? 0 : (var12_8 < var16_10 ? -1 : 1));
        if (var60_52 != 0) {
            var1_1.a.setVisibility(var56_49);
            var1_1.j.setVisibility(var48_41);
            var1_1.m.setVisibility(var48_41);
            var6_4 = var1_1.e;
            var6_4.setVisibility(var33_25);
        }
        if ((var60_52 = (int)((cfr_temp_8 = (var66_57 = (long)64 & var2_2) - (var68_58 = 0L)) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.c;
            var70_59 = var1_1.o;
            var6_4.setOnClickListener(var70_59);
            var6_4 = var1_1.d;
            var70_59 = var1_1.n;
            var6_4.setOnClickListener(var70_59);
            var6_4 = var1_1.m;
            var70_59 = var1_1.p;
            var6_4.setOnClickListener(var70_59);
        }
        if ((var60_52 = (int)((cfr_temp_9 = (var66_57 = (long)88 & var2_2) - (var68_58 = 0L)) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.c;
            var6_4.setVisibility(var55_48);
        }
        if ((var60_52 = (int)((cfr_temp_10 = (var7_5 = var2_2 & var24_15) - var68_58) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1))) != 0) {
            var1_1.k.setVisibility((int)var63_55);
            var6_4 = var1_1.l;
            var6_4.setVisibility(var26_16);
        }
        if ((var60_52 = (int)((cfr_temp_11 = (var2_2 &= (var4_3 = (long)84)) - var68_58) == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.l;
            u.n((TextView)var6_4, (String)var47_40, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.q;
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
            this.q = l10 = (long)64;
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
                return this.E((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.D((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.F((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 154;
        if (n11 == n10) {
            object = (BleDeviceViewModel)object;
            this.B((BleDeviceViewModel)object);
            return 1 != 0;
        } else {
            n11 = 23;
            if (n11 != n10) return 0 != 0;
            object = (DeviceConnectFragment$c)object;
            this.A((DeviceConnectFragment$c)object);
        }
        return 1 != 0;
    }
}

