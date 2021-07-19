/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.CheckedTextView
 *  android.widget.LinearLayout
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.ScrollView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.dialog.more.SetStabilizerFragment$c;
import com.zhiyun.cama.camera.widget.CheckedGroup;
import com.zhiyun.ui.ShadowSeekBar;
import d.v.c.s0.u6;
import d.v.c.w0.a2$a;
import d.v.c.w0.a2$b;
import d.v.c.w0.a2$c;
import d.v.c.w0.a2$d;
import d.v.c.w0.a2$e;
import d.v.c.w0.z1;

public class a2
extends z1 {
    private static final ViewDataBinding$IncludedLayouts I;
    private static final SparseIntArray J;
    private final RadioButton A;
    private final LinearLayout B;
    private a2$e C;
    private a2$a D;
    private a2$b E;
    private a2$c F;
    private a2$d G;
    private long H;
    private final ScrollView r;
    private final LinearLayout s;
    private final RadioButton t;
    private final RadioButton u;
    private final LinearLayout v;
    private final LinearLayout w;
    private final RadioButton x;
    private final LinearLayout y;
    private final RadioButton z;

    static {
        SparseIntArray sparseIntArray;
        J = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362159, 20);
        sparseIntArray.put(2131363547, 21);
        sparseIntArray.put(2131362158, 22);
        sparseIntArray.put(2131362157, 23);
        sparseIntArray.put(2131362156, 24);
    }

    public a2(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = I;
        SparseIntArray sparseIntArray = J;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 25, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private a2(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        a2 a22 = this;
        CheckBox checkBox = (CheckBox)objectArray[14];
        CheckedGroup checkedGroup = (CheckedGroup)((Object)objectArray[24]);
        RadioGroup radioGroup = (RadioGroup)objectArray[23];
        CheckedGroup checkedGroup2 = (CheckedGroup)((Object)objectArray[22]);
        CheckedGroup checkedGroup3 = (CheckedGroup)((Object)objectArray[20]);
        CheckedTextView checkedTextView = (CheckedTextView)objectArray[13];
        CheckedTextView checkedTextView2 = (CheckedTextView)objectArray[12];
        RadioButton radioButton = (RadioButton)objectArray[15];
        RadioButton radioButton2 = (RadioButton)objectArray[9];
        RadioButton radioButton3 = (RadioButton)objectArray[5];
        RadioButton radioButton4 = (RadioButton)objectArray[10];
        RadioButton radioButton5 = (RadioButton)objectArray[2];
        ShadowSeekBar shadowSeekBar = (ShadowSeekBar)((Object)objectArray[11]);
        TextView textView = (TextView)objectArray[21];
        int n10 = 6;
        super(dataBindingComponent, view, n10, checkBox, checkedGroup, radioGroup, checkedGroup2, checkedGroup3, checkedTextView, checkedTextView2, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, shadowSeekBar, textView);
        this.H = -1;
        this.a.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        a22 = (ScrollView)objectArray[0];
        this.r = a22;
        a22.setTag(null);
        a22 = (LinearLayout)objectArray[1];
        this.s = a22;
        a22.setTag(null);
        a22 = (RadioButton)objectArray[16];
        this.t = a22;
        a22.setTag("APP_PHOTO_VIDEO");
        a22 = (RadioButton)objectArray[17];
        this.u = a22;
        a22.setTag("APP_CUSTOM_MENU");
        a22 = (LinearLayout)objectArray[18];
        this.v = a22;
        a22.setTag(null);
        a22 = (LinearLayout)objectArray[19];
        this.w = a22;
        a22.setTag(null);
        a22 = (RadioButton)objectArray[3];
        this.x = a22;
        a22.setTag("RUN");
        a22 = (LinearLayout)objectArray[4];
        this.y = a22;
        a22.setTag(null);
        a22 = (RadioButton)objectArray[6];
        this.z = a22;
        a22.setTag("MEDIUM");
        a22 = (RadioButton)objectArray[7];
        this.A = a22;
        a22.setTag("LOW");
        a22 = (LinearLayout)objectArray[8];
        this.B = a22;
        a22.setTag(null);
        this.h.setTag((Object)"DEFAULT");
        this.i.setTag((Object)"FREE");
        this.j.setTag((Object)"HIGH");
        this.k.setTag((Object)"HOR_VER");
        this.l.setTag((Object)"WALK");
        this.m.setTag(null);
        a22 = view;
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.H;
                long l11 = 16;
                this.H = l10 |= l11;
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
                long l10 = this.H;
                long l11 = 8;
                this.H = l10 |= l11;
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
                long l10 = this.H;
                long l11 = 2;
                this.H = l10 |= l11;
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
                long l10 = this.H;
                long l11 = 1L;
                this.H = l10 |= l11;
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
                long l10 = this.H;
                long l11 = 32;
                this.H = l10 |= l11;
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
                long l10 = this.H;
                long l11 = 4;
                this.H = l10 |= l11;
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
    public void B(BleViewModel bleViewModel) {
        this.p = bleViewModel;
        synchronized (this) {
            long l10 = this.H;
            long l11 = 64;
            this.H = l10 |= l11;
        }
        this.notifyPropertyChanged(12);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(u6 u62) {
        this.q = u62;
        synchronized (this) {
            long l10 = this.H;
            long l11 = 128L;
            this.H = l10 |= l11;
        }
        this.notifyPropertyChanged(15);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(SetStabilizerFragment$c setStabilizerFragment$c) {
        this.o = setStabilizerFragment$c;
        synchronized (this) {
            long l10 = this.H;
            long l11 = 256L;
            this.H = l10 |= l11;
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
        block95: {
            block98: {
                var1_1 = this;
                synchronized (this) {
                    var2_2 = this.H;
                    this.H = var4_3 = 0L;
                }
                var6_4 = this.p;
                var7_5 = this.q;
                var8_6 = this.o;
                var9_7 = 767L & var2_2;
                var11_8 = var9_7 == var4_3 ? 0 : (var9_7 < var4_3 ? -1 : 1);
                var12_9 = 32768L;
                var14_10 = 65536L;
                var16_11 = 600L;
                var18_12 = 592L;
                var20_13 = 759L;
                var22_14 = null;
                if (var11_8 == false) break block98;
                if (var6_4 != null) {
                    var23_15 = var6_4.L;
                } else {
                    var11_8 = 0;
                    var23_15 = null;
                }
                var24_16 = 4;
                var25_18 = 5.6E-45f;
                var1_1.updateLiveDataRegistration(var24_16, (LiveData)var23_15);
                if (var23_15 != null) {
                    var23_15 = (Boolean)var23_15.getValue();
                } else {
                    var11_8 = 0;
                    var23_15 = null;
                }
                var11_8 = (long)ViewDataBinding.safeUnbox((Boolean)var23_15);
                var26_19 = var2_2 & var20_13;
                var24_16 = (int)(var26_19 == var4_3 ? 0 : (var26_19 < var4_3 ? -1 : 1));
                if (var24_16 != 0) {
                    if (var11_8 != false) {
                        var2_2 |= var12_9;
                    } else {
                        var26_19 = 16384L;
                        var2_2 |= var26_19;
                    }
                }
                if ((var24_16 = (int)((cfr_temp_0 = (var26_19 = var2_2 & var18_12) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) != 0) {
                    var26_19 = var11_8 != false ? 0x200000L : 0x100000L;
                    var2_2 |= var26_19;
                }
                if ((var24_16 = (int)((cfr_temp_1 = (var26_19 = var2_2 & var16_11) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) != 0) {
                    var28_20 = var11_8 ^ 1;
                    if (var24_16 != 0) {
                        if (var28_20 != 0) {
                            var29_21 = 131072L;
                            var2_2 |= var29_21;
                        } else {
                            var2_2 |= var14_10;
                        }
                    }
                } else {
                    var28_20 = 0;
                }
                if ((var24_16 = (int)((cfr_temp_2 = (var29_21 = var2_2 & var18_12) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) != 0) {
                    if (var11_8 != false) {
                        var24_16 = 1065353216;
                        var25_18 = 1.0f;
                        break block95;
                    } else {
                        var24_16 = 1053609165;
                        var25_18 = 0.4f;
                    }
                    break block95;
                } else {
                    var24_16 = 0;
                    var25_18 = 0.0f;
                }
                break block95;
            }
            var11_8 = 0;
            var23_15 = null;
            var24_17 = false;
            var25_18 = 0.0f;
            var28_20 = 0;
        }
        var29_21 = 644L;
        var31_22 = var2_2 & var29_21;
        var33_23 = var31_22 == var4_3 ? 0 : (var31_22 < var4_3 ? -1 : 1);
        var34_24 = 524288L;
        var36_25 = 262144L;
        var38_26 = 2;
        if (var33_23 != false) {
            if (var7_5 != null) {
                var39_27 = var7_5.K();
                var40_28 /* !! */  = var39_27;
            } else {
                var41_29 = false;
                var40_28 /* !! */  = null;
            }
            var1_1.updateLiveDataRegistration(var38_26, (LiveData)var40_28 /* !! */ );
            if (var40_28 /* !! */  != null) {
                var42_30 = (Boolean)var40_28 /* !! */ .getValue();
            } else {
                var43_31 = false;
                var42_30 = null;
            }
            var44_32 = ViewDataBinding.safeUnbox((Boolean)var42_30) ^ true;
            if (var33_23 != false) {
                var2_2 = var44_32 ? (var2_2 |= var34_24) : (var2_2 |= var36_25);
            }
            if (var44_32) {
                var45_33 = 1065353216;
                var46_34 = 1.0f;
            } else {
                var45_33 = 1053609165;
                var46_34 = 0.4f;
            }
            var47_35 = var46_34;
        } else {
            var41_29 = false;
            var40_28 /* !! */  = null;
            var43_31 = false;
            var42_30 = null;
            var44_32 = false;
            var39_27 = null;
            var47_35 = 0.0f;
        }
        var48_36 = 768L;
        var50_37 = var2_2 & var48_36;
        var45_33 = var50_37 == var4_3 ? 0 : (var50_37 < var4_3 ? -1 : 1);
        if (var45_33 != false && var8_6 != null) {
            var52_38 = var1_1.C;
            if (var52_38 == null) {
                var1_1.C = var52_38 = new a2$e();
            }
            var52_38 = var52_38.b((SetStabilizerFragment$c)var8_6);
            var53_39 = var1_1.D;
            if (var53_39 == null) {
                var1_1.D = var53_39 = new a2$a();
            }
            var53_39 = var53_39.b((SetStabilizerFragment$c)var8_6);
            var54_40 = var1_1.E;
            if (var54_40 == null) {
                var1_1.E = var54_40 = new a2$b();
            }
            var54_40 = var54_40.b((SetStabilizerFragment$c)var8_6);
            var55_41 = var1_1.F;
            if (var55_41 == null) {
                var1_1.F = var55_41 = new a2$c();
            }
            var55_41 = var55_41.b((SetStabilizerFragment$c)var8_6);
            var56_42 = var1_1.G;
            if (var56_42 == null) {
                var1_1.G = var56_42 = new a2$d();
            }
            var8_6 = var56_42.b((SetStabilizerFragment$c)var8_6);
        } else {
            var57_43 = 0;
            var54_40 = null;
            var55_41 = null;
            var8_6 = null;
            var52_38 = null;
            var38_26 = 0;
            var53_39 = null;
        }
        var14_10 = 65536L & var2_2;
        var50_37 = 0L;
        var58_44 = var14_10 == var50_37 ? 0 : (var14_10 < var50_37 ? -1 : 1);
        if (var58_44 != false) {
            if (var6_4 != null) {
                var56_42 = var6_4.E;
            } else {
                var58_44 = 0;
                var56_42 = null;
                var59_45 = 0.0f;
            }
            var60_46 = 3;
            var1_1.updateLiveDataRegistration(var60_46, (LiveData)var56_42);
            if (var56_42 != null) {
                var56_42 = (Boolean)var56_42.getValue();
            } else {
                var58_44 = 0;
                var56_42 = null;
                var59_45 = 0.0f;
            }
            var58_44 = (long)ViewDataBinding.safeUnbox((Boolean)var56_42);
        } else {
            var58_44 = 0;
            var59_45 = 0.0f;
            var56_42 = null;
        }
        var61_47 = var2_2 & 32768L;
        var50_37 = 0L;
        var60_46 = (int)(var61_47 == var50_37 ? 0 : (var61_47 < var50_37 ? -1 : 1));
        if (var60_46 != 0) {
            if (var7_5 != null) {
                var40_28 /* !! */  = var7_5.K();
            }
            var63_48 = 2 != 0;
            var1_1.updateLiveDataRegistration((int)var63_48, (LiveData)var40_28 /* !! */ );
            if (var40_28 /* !! */  != null) {
                var42_30 = var7_5 = var40_28 /* !! */ .getValue();
                var42_30 = (Boolean)var7_5;
            }
            var63_48 = ViewDataBinding.safeUnbox((Boolean)var42_30);
            var41_29 = true;
            var44_32 = var63_48 ^ 1;
            var12_9 = var2_2 & var29_21;
            var61_47 = 0L;
            cfr_temp_3 = var12_9 - var61_47;
            var63_48 = (boolean)(cfr_temp_3 == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1));
            if (var63_48) {
                var2_2 = var44_32 ? (var2_2 |= var34_24) : (var2_2 |= var36_25);
            }
        } else {
            var61_47 = 0L;
        }
        var63_48 = (boolean)((cfr_temp_4 = (var2_2 & var20_13) - var61_47) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1));
        var12_9 = 0x2000000L;
        if (var63_48) {
            if (var11_8 == false) {
                var44_32 = false;
                var39_27 = null;
            }
            if (var63_48) {
                if (var44_32) {
                    var2_2 |= var12_9;
                } else {
                    var31_22 = 0x1000000L;
                    var2_2 |= var31_22;
                }
            }
            var63_48 = var44_32;
        } else {
            var63_48 = false;
            var7_5 = null;
        }
        var31_22 = var2_2 & var16_11;
        var64_49 = 0L;
        var60_46 = (int)(var31_22 == var64_49 ? 0 : (var31_22 < var64_49 ? -1 : 1));
        if (var60_46 == 0) ** GOTO lbl-1000
        if (var28_20 != 0) {
            var58_44 = 1;
            var59_45 = 1.4E-45f;
        }
        if (var60_46 != 0) {
            var66_50 = var58_44 != false ? 0x800000L : 0x400000L;
            var2_2 |= var66_50;
        }
        if (var58_44 == false) {
            var58_44 = 8;
            var59_45 = 1.1E-44f;
        } else lbl-1000:
        // 2 sources

        {
            var58_44 = 0;
            var59_45 = 0.0f;
            var56_42 = null;
        }
        var66_50 = 0L;
        cfr_temp_5 = (var12_9 &= var2_2) - var66_50;
        var41_29 = cfr_temp_5 == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1);
        if (var41_29) {
            if (var6_4 != null) {
                var40_28 /* !! */  = var6_4.G;
            } else {
                var41_29 = false;
                var40_28 /* !! */  = null;
            }
            var43_31 = 5 != 0;
            var1_1.updateLiveDataRegistration((int)var43_31, (LiveData)var40_28 /* !! */ );
            if (var40_28 /* !! */  != null) {
                var40_28 /* !! */  = (Boolean)var40_28 /* !! */ .getValue();
            } else {
                var41_29 = false;
                var40_28 /* !! */  = null;
            }
            var41_29 = ViewDataBinding.safeUnbox((Boolean)var40_28 /* !! */ );
        } else {
            var41_29 = false;
            var40_28 /* !! */  = null;
        }
        var66_50 = var2_2 & var20_13;
        var31_22 = 0L;
        var43_31 = (boolean)(var66_50 == var31_22 ? 0 : (var66_50 < var31_22 ? -1 : 1));
        var66_50 = 2048L;
        if (var43_31) {
            if (!var63_48) {
                var41_29 = false;
                var40_28 /* !! */  = null;
            }
            if (var43_31) {
                if (var41_29) {
                    var2_2 |= var66_50;
                } else {
                    var31_22 = 1024L;
                    var2_2 |= var31_22;
                }
            }
        } else {
            var41_29 = false;
            var40_28 /* !! */  = null;
        }
        var31_22 = var2_2 & var66_50;
        var64_49 = 0L;
        var43_31 = (boolean)(var31_22 == var64_49 ? 0 : (var31_22 < var64_49 ? -1 : 1));
        var31_22 = 4096L;
        if (var43_31) {
            if (var6_4 != null) {
                var68_51 = var6_4.H;
                var69_53 = var58_44;
                var70_54 = var59_45;
            } else {
                var69_53 = var58_44;
                var70_54 = var59_45;
                var60_46 = 0;
                var68_51 = null;
            }
            var58_44 = 0;
            var59_45 = 0.0f;
            var56_42 = null;
            var1_1.updateLiveDataRegistration(0, (LiveData)var68_51);
            if (var68_51 != null) {
                var68_51 = (Boolean)var68_51.getValue();
            } else {
                var60_46 = 0;
                var68_51 = null;
            }
            var60_46 = (int)ViewDataBinding.safeUnbox((Boolean)var68_51);
            if (var43_31) {
                if (var60_46 != 0) {
                    var36_25 = 8192L;
                    var2_2 |= var36_25;
                } else {
                    var2_2 |= var31_22;
                }
            }
        } else {
            var69_53 = var58_44;
            var70_54 = var59_45;
            var58_44 = 0;
            var59_45 = 0.0f;
            var56_42 = null;
            var60_46 = 0;
            var68_52 = null;
        }
        if (var43_31 = (boolean)((cfr_temp_6 = (var31_22 = var2_2 & var31_22) - (var36_25 = 0L)) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1))) {
            if (var6_4 != null) {
                var6_4 = var6_4.I;
            } else {
                var71_55 = false;
                var6_4 = null;
            }
            var43_31 = true;
            var1_1.updateLiveDataRegistration((int)var43_31, (LiveData)var6_4);
            if (var6_4 != null) {
                var22_14 = var6_4 = var6_4.getValue();
                var22_14 = (Boolean)var6_4;
            }
            var71_55 = ViewDataBinding.safeUnbox(var22_14);
        } else {
            var43_31 = true;
            var71_55 = false;
            var6_4 = null;
        }
        var72_56 = var2_2 & var66_50;
        var66_50 = 0L;
        var45_33 = var72_56 == var66_50 ? 0 : (var72_56 < var66_50 ? -1 : 1);
        if (var45_33 != false) {
            if (var60_46 != 0) {
                var71_55 = var43_31;
            }
        } else {
            var71_55 = false;
            var6_4 = null;
        }
        if (!(var43_31 = (boolean)((cfr_temp_7 = (var20_13 = var2_2 & var20_13) - var66_50) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1))) || !var41_29) {
            var71_55 = false;
            var6_4 = null;
        }
        var14_10 = var2_2 & var18_12;
        var41_29 = var14_10 == var66_50 ? 0 : (var14_10 < var66_50 ? -1 : 1);
        var58_44 = 11;
        var59_45 = 1.5E-44f;
        if (var41_29) {
            var1_1.a.setEnabled((boolean)var11_8);
            var1_1.f.setEnabled((boolean)var11_8);
            var1_1.g.setEnabled((boolean)var11_8);
            var1_1.t.setEnabled((boolean)var11_8);
            var1_1.u.setEnabled((boolean)var11_8);
            var1_1.x.setEnabled((boolean)var11_8);
            var1_1.y.setEnabled((boolean)var11_8);
            var1_1.z.setEnabled((boolean)var11_8);
            var1_1.A.setEnabled((boolean)var11_8);
            var1_1.h.setEnabled((boolean)var11_8);
            var1_1.i.setEnabled((boolean)var11_8);
            var1_1.j.setEnabled((boolean)var11_8);
            var1_1.k.setEnabled((boolean)var11_8);
            var1_1.l.setEnabled((boolean)var11_8);
            var40_28 /* !! */  = var1_1.m;
            var40_28 /* !! */ .setEnabled((boolean)var11_8);
            var11_8 = ViewDataBinding.getBuildSdkInt();
            if (var11_8 >= var58_44) {
                var23_15 = var1_1.s;
                var23_15.setAlpha(var25_18);
            }
        }
        if ((var11_8 = (cfr_temp_8 = (var74_57 = var2_2 & var48_36) - (var18_12 = 0L)) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1)) != false) {
            var23_15 = var1_1.f;
            var23_15.setOnClickListener((View.OnClickListener)var8_6);
            var1_1.g.setOnClickListener((View.OnClickListener)var53_39);
            var8_6 = var1_1.v;
            var8_6.setOnClickListener((View.OnClickListener)var54_40);
            var1_1.w.setOnClickListener((View.OnClickListener)var55_41);
            var54_40 = var1_1.y;
            var54_40.setOnClickListener(var52_38);
        }
        if ((var57_43 = (cfr_temp_9 = (var4_3 = var2_2 & var29_21) - (var76_58 = 0L)) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1)) != 0 && (var57_43 = ViewDataBinding.getBuildSdkInt()) >= var58_44) {
            var1_1.v.setAlpha(var47_35);
            var54_40 = var1_1.w;
            var54_40.setAlpha(var47_35);
        }
        if ((var57_43 = (int)((cfr_temp_10 = (var4_3 = 724L & var2_2) - (var76_58 = 0L)) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1))) != 0) {
            var54_40 = var1_1.v;
            var54_40.setEnabled(var63_48);
        }
        if (var43_31) {
            var54_40 = var1_1.w;
            var54_40.setEnabled(var71_55);
        }
        if (var71_55 = (cfr_temp_11 = (var2_2 &= var16_11) - (var4_3 = 0L)) == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1)) {
            var6_4 = var1_1.B;
            var58_44 = var69_53;
            var59_45 = var70_54;
            var6_4.setVisibility((int)var69_53);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.H;
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
            this.H = l10 = 512L;
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
                            return this.I((MutableLiveData)object, n11);
                        }
                        object = (LiveData)object;
                        return this.E((LiveData)object, n11);
                    }
                    object = (MutableLiveData)object;
                    return this.F((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.J((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.G((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.H((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 12;
        if (n11 == n10) {
            object = (BleViewModel)object;
            this.B((BleViewModel)object);
            return 1 != 0;
        } else {
            n11 = 15;
            if (n11 == n10) {
                object = (u6)object;
                this.C((u6)object);
                return 1 != 0;
            } else {
                n11 = 23;
                if (n11 != n10) return 0 != 0;
                object = (SetStabilizerFragment$c)object;
                this.D((SetStabilizerFragment$c)object);
            }
        }
        return 1 != 0;
    }
}

