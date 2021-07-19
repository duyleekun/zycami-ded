/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.a.g;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.R$id;
import com.zhiyun.account.me.account.getcode.GetCodeStatus;
import com.zhiyun.account.me.account.widget.MeGetCodeView;
import com.zhiyun.account.me.account.widget.MeNameView;
import d.v.a.g.c;
import d.v.a.g.d$a;
import d.v.a.g.d$b;
import d.v.a.g.d$c;
import d.v.a.i.a.m0;
import d.v.a.i.a.v0.m$b;
import l.a.q.g0.u;

public class d
extends c {
    private static final ViewDataBinding$IncludedLayouts r;
    private static final SparseIntArray s;
    private final ConstraintLayout m;
    private d$c n;
    private d$a o;
    private d$b p;
    private long q;

    static {
        SparseIntArray sparseIntArray;
        s = sparseIntArray = new SparseIntArray();
        int n10 = R$id.iv_title;
        sparseIntArray.put(n10, 8);
        n10 = R$id.mnv_name;
        sparseIntArray.put(n10, 9);
        n10 = R$id.mpv_get_code;
        sparseIntArray.put(n10, 10);
    }

    public d(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = r;
        SparseIntArray sparseIntArray = s;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 11, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private d(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[7];
        object2 = (CheckBox)object;
        Object object3 = object = objectArray[5];
        object3 = (CheckBox)object;
        Object object4 = object = objectArray[6];
        object4 = (CheckBox)object;
        Object object5 = object = objectArray[1];
        object5 = (ImageView)object;
        Object object6 = object = objectArray[8];
        object6 = (ImageView)object;
        Object object7 = object = objectArray[9];
        object7 = (MeNameView)((Object)object);
        Object object8 = object = objectArray[10];
        object8 = (MeGetCodeView)((Object)object);
        Object object9 = object = objectArray[4];
        object9 = (TextView)object;
        Object object10 = object = objectArray[3];
        object10 = (TextView)object;
        Object object11 = object = objectArray[2];
        object11 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 7, (CheckBox)object2, (CheckBox)object3, (CheckBox)object4, (ImageView)object5, (ImageView)object6, (MeNameView)((Object)object7), (MeGetCodeView)((Object)object8), (TextView)object9, (TextView)object10, (TextView)object11);
        this.q = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.m = object;
        object.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
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
    private boolean C(MutableLiveData mutableLiveData, int n10) {
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
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
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
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
    private boolean E(LiveData liveData, int n10) {
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
            synchronized (this) {
                long l10 = this.q;
                long l11 = 16;
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
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
            synchronized (this) {
                long l10 = this.q;
                long l11 = 32;
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
    private boolean G(MutableLiveData mutableLiveData, int n10) {
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
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
    private boolean H(MutableLiveData mutableLiveData, int n10) {
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
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
    private boolean I(MutableLiveData mutableLiveData, int n10) {
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
            synchronized (this) {
                long l10 = this.q;
                long l11 = 64;
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
    public void A(m$b m$b) {
        this.k = m$b;
        synchronized (this) {
            long l10 = this.q;
            long l11 = 256L;
            this.q = l10 |= l11;
        }
        int n10 = d.v.a.d.x;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(m0 m02) {
        this.l = m02;
        synchronized (this) {
            long l10 = this.q;
            long l11 = 128L;
            this.q = l10 |= l11;
        }
        int n10 = d.v.a.d.N0;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block78: {
            block74: {
                block77: {
                    block76: {
                        block75: {
                            var1_1 = this;
                            synchronized (this) {
                                var2_2 = this.q;
                                this.q = var4_3 = 0L;
                            }
                            var6_4 = this.l;
                            var7_5 = this.k;
                            var8_6 = 1023L & var2_2;
                            var10_7 = var8_6 == var4_3 ? 0 : (var8_6 < var4_3 ? -1 : 1);
                            var11_8 = 656L;
                            var13_9 = 644L;
                            var15_10 = 648L;
                            var17_11 = 642L;
                            var19_12 = 641L;
                            var21_13 = 928L;
                            var23_14 = 672L;
                            var25_15 = 0;
                            var26_16 = 0.0f;
                            var27_17 = null;
                            if (var10_7 == false) break block74;
                            var28_18 = var2_2 & var19_12;
                            var10_7 = var28_18 == var4_3 ? 0 : (var28_18 < var4_3 ? -1 : 1);
                            var30_19 = 1;
                            var31_20 = 1.4E-45f;
                            var32_22 = 8;
                            var33_23 = 1.1E-44f;
                            if (var10_7 == false) ** GOTO lbl-1000
                            if (var6_4 != null) {
                                var34_24 = var6_4.l;
                            } else {
                                var35_26 = 0;
                                var36_28 = 0.0f;
                                var34_24 = null;
                            }
                            var1_1.updateLiveDataRegistration(0, (LiveData)var34_24);
                            if (var34_24 != null) {
                                var34_24 = (GetCodeStatus)var34_24.getValue();
                            } else {
                                var35_26 = 0;
                                var36_28 = 0.0f;
                                var34_24 = null;
                            }
                            var27_17 = GetCodeStatus.REGISTER;
                            if (var27_17 == var34_24) {
                                var25_15 = var30_19;
                                var26_16 = var31_20;
                            } else {
                                var25_15 = 0;
                                var26_16 = 0.0f;
                                var27_17 = null;
                            }
                            if (var10_7 != false) {
                                var8_6 = var25_15 != 0 ? 2048L : 1024L;
                                var2_2 |= var8_6;
                            }
                            if (var25_15 == 0) {
                                var25_15 = var32_22;
                                var26_16 = var33_23;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var25_15 = 0;
                                var26_16 = 0.0f;
                                var27_17 = null;
                            }
                            var8_6 = var2_2 & var17_11;
                            var10_7 = var8_6 == var4_3 ? 0 : (var8_6 < var4_3 ? -1 : 1);
                            if (var10_7 != false) {
                                if (var6_4 != null) {
                                    var37_29 = var6_4.p;
                                } else {
                                    var10_7 = 0;
                                    var37_29 = null;
                                }
                                var1_1.updateLiveDataRegistration(var30_19, (LiveData)var37_29);
                                if (var37_29 != null) {
                                    var37_29 = (Integer)var37_29.getValue();
                                } else {
                                    var10_7 = 0;
                                    var37_29 = null;
                                }
                                var10_7 = ViewDataBinding.safeUnbox((Integer)var37_29);
                            } else {
                                var10_7 = 0;
                                var37_30 = null;
                            }
                            var38_32 = var2_2 & var13_9;
                            var35_26 = var38_32 == var4_3 ? 0 : (var38_32 < var4_3 ? -1 : 1);
                            if (var35_26 != 0) {
                                if (var6_4 != null) {
                                    var34_24 = var6_4.n;
                                } else {
                                    var35_26 = 0;
                                    var36_28 = 0.0f;
                                    var34_24 = null;
                                }
                                var30_19 = 2;
                                var31_20 = 2.8E-45f;
                                var1_1.updateLiveDataRegistration(var30_19, (LiveData)var34_24);
                                if (var34_24 != null) {
                                    var34_24 = (Integer)var34_24.getValue();
                                } else {
                                    var35_26 = 0;
                                    var36_28 = 0.0f;
                                    var34_24 = null;
                                }
                                var35_26 = ViewDataBinding.safeUnbox((Integer)var34_24);
                            } else {
                                var35_26 = 0;
                                var36_28 = 0.0f;
                                var34_24 = null;
                            }
                            var40_33 = var2_2 & var15_10;
                            var30_19 = (int)(var40_33 == var4_3 ? 0 : (var40_33 < var4_3 ? -1 : 1));
                            if (var30_19 == 0) ** GOTO lbl-1000
                            if (var6_4 != null) {
                                var42_34 = var6_4.s;
                            } else {
                                var43_35 = 0;
                                var44_36 = 0.0f;
                                var42_34 = null;
                            }
                            var45_37 = 3;
                            var1_1.updateLiveDataRegistration((int)var45_37, (LiveData)var42_34);
                            if (var42_34 != null) {
                                var42_34 = (Boolean)var42_34.getValue();
                            } else {
                                var43_35 = 0;
                                var44_36 = 0.0f;
                                var42_34 = null;
                            }
                            var43_35 = ViewDataBinding.safeUnbox((Boolean)var42_34);
                            if (var30_19 != 0) {
                                var46_38 = var43_35 != 0 ? 32768L : 16384L;
                                var2_2 |= var46_38;
                            }
                            if (var43_35 == 0) {
                                var30_19 = var32_22;
                                var31_20 = var33_23;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var30_19 = 0;
                                var31_20 = 0.0f;
                            }
                            var13_9 = var2_2 & var11_8;
                            var43_35 = var13_9 == var4_3 ? 0 : (var13_9 < var4_3 ? -1 : 1);
                            if (var43_35 == 0) ** GOTO lbl-1000
                            if (var6_4 != null) {
                                var48_39 = var6_4.t;
                            } else {
                                var45_37 = 0;
                                var48_39 = null;
                            }
                            var49_40 = 4;
                            var50_41 = 5.6E-45f;
                            var1_1.updateLiveDataRegistration(var49_40, var48_39);
                            if (var48_39 != null) {
                                var51_43 = (Boolean)var48_39.getValue();
                            } else {
                                var49_40 = 0;
                                var50_41 = 0.0f;
                                var51_43 = null;
                            }
                            var49_40 = (int)ViewDataBinding.safeUnbox(var51_43);
                            if (var43_35 != 0) {
                                var52_45 = var49_40 != 0 ? 8192L : 4096L;
                                var2_2 |= var52_45;
                            }
                            if (var49_40 == 0) {
                                var49_40 = var32_22;
                                var50_41 = var33_23;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var49_40 = 0;
                                var50_41 = 0.0f;
                                var51_43 = null;
                            }
                            var52_45 = var2_2 & var21_13;
                            var54_46 = var52_45 == var4_3 ? 0 : (var52_45 < var4_3 ? -1 : 1);
                            if (!var54_46) break block75;
                            if (var6_4 != null) {
                                var55_47 = var6_4.i;
                            } else {
                                var54_46 = false;
                                var55_47 = null;
                            }
                            var43_35 = 5;
                            var44_36 = 7.0E-45f;
                            var1_1.updateLiveDataRegistration(var43_35, (LiveData)var55_47);
                            if (var55_47 != null) {
                                var55_47 = (Boolean)var55_47.getValue();
                            } else {
                                var54_46 = false;
                                var55_47 = null;
                            }
                            var54_46 = ViewDataBinding.safeUnbox((Boolean)var55_47);
                            var13_9 = var2_2 & var23_14;
                            var43_35 = (int)(var13_9 == var4_3 ? 0 : (var13_9 < var4_3 ? -1 : 1));
                            if (var43_35 != 0) {
                                var13_9 = var54_46 != false ? 131072L : 65536L;
                                var2_2 |= var13_9;
                            }
                            if ((var43_35 = (int)((cfr_temp_0 = (var13_9 = var2_2 & var23_14) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) == 0) break block76;
                            if (var54_46) {
                                var43_35 = 1065353216;
                                var44_36 = 1.0f;
                            } else {
                                var43_35 = 1053609165;
                                var44_36 = 0.4f;
                            }
                            var56_50 = var43_35;
                            var57_51 = var44_36;
                            var13_9 = 704L;
                            break block77;
                        }
                        var54_46 = false;
                        var55_48 = null;
                    }
                    var13_9 = 704L;
                    var56_50 = 0;
                    var57_51 = 0.0f;
                }
                var58_52 = var2_2 & var13_9;
                var43_35 = (int)(var58_52 == var4_3 ? 0 : (var58_52 < var4_3 ? -1 : 1));
                if (var43_35 != 0) {
                    if (var6_4 != null) {
                        var6_4 = var6_4.r;
                    } else {
                        var60_53 = 0;
                        var6_4 = null;
                    }
                    var45_37 = 6;
                    var1_1.updateLiveDataRegistration((int)var45_37, (LiveData)var6_4);
                    if (var6_4 != null) {
                        var6_4 = (Boolean)var6_4.getValue();
                    } else {
                        var60_53 = 0;
                        var6_4 = null;
                    }
                    var60_53 = (int)ViewDataBinding.safeUnbox((Boolean)var6_4);
                    if (var43_35 != 0) {
                        var13_9 = var60_53 != 0 ? 524288L : 262144L;
                        var2_2 |= var13_9;
                    }
                    if (var60_53 != 0) {
                        var32_22 = 0;
                        var33_23 = 0.0f;
                    }
                    var43_35 = var25_15;
                    var44_36 = var26_16;
                    var25_15 = var49_40;
                    var26_16 = var50_41;
                    var60_53 = var32_22;
                } else {
                    var43_35 = var25_15;
                    var44_36 = var26_16;
                    var25_15 = var49_40;
                    var26_16 = var50_41;
                    var60_53 = 0;
                    var6_4 = null;
                }
                var49_40 = var35_26;
                var35_26 = var56_50;
                var36_28 = var57_51;
                break block78;
            }
            var60_53 = 0;
            var6_4 = null;
            var25_15 = 0;
            var26_16 = 0.0f;
            var27_17 = null;
            var10_7 = 0;
            var37_31 = null;
            var35_27 = false;
            var36_28 = 0.0f;
            var34_25 = null;
            var30_19 = 0;
            var31_21 = 0.0f;
            var49_40 = 0;
            var50_42 = 0.0f;
            var51_44 = null;
            var54_46 = false;
            var55_49 = null;
            var43_35 = 0;
            var44_36 = 0.0f;
            var42_34 = null;
        }
        var45_37 = (cfr_temp_1 = (var2_2 & var21_13) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1);
        var21_13 = 768L;
        if (var45_37 != false) {
            if (var7_5 != null) {
                var61_54 = var1_1.n;
                if (var61_54 == null) {
                    var1_1.n = var61_54 = new d$c();
                }
                var61_54 = var61_54.b(var7_5);
            } else {
                var61_54 = null;
            }
            var62_55 = var2_2 & var21_13;
            var64_56 = var62_55 == var4_3 ? 0 : (var62_55 < var4_3 ? -1 : 1);
            if (var64_56 != false && var7_5 != null) {
                var65_57 = var1_1.o;
                if (var65_57 == null) {
                    var1_1.o = var65_57 = new d$a();
                }
                var65_57 = var65_57.b(var7_5);
                var66_58 = var1_1.p;
                if (var66_58 == null) {
                    var1_1.p = var66_58 = new d$b();
                }
                var66_58 = var66_58.b(var7_5);
            } else {
                var67_59 = 0;
                var65_57 = null;
                var66_58 = null;
            }
        } else {
            var67_59 = 0;
            var65_57 = null;
            var66_58 = null;
            var61_54 = null;
        }
        var68_60 = var2_2 & 512L;
        var62_55 = 0L;
        var70_61 = var68_60 == var62_55 ? 0 : (var68_60 < var62_55 ? -1 : 1);
        if (var70_61 != false) {
            var7_5 = var1_1.a;
            var71_62 = this.getRoot().getContext();
            var56_50 = var43_35;
            var57_51 = var44_36;
            var42_34 = d.v.a.c.b(var71_62);
            var7_5.setText((CharSequence)var42_34);
        } else {
            var56_50 = var43_35;
            var57_51 = var44_36;
        }
        var58_52 = var2_2 & 648L;
        var70_61 = var58_52 == var62_55 ? 0 : (var58_52 < var62_55 ? -1 : 1);
        if (var70_61 != false) {
            var7_5 = var1_1.a;
            var7_5.setVisibility(var30_19);
        }
        if ((var70_61 = (cfr_temp_2 = (var46_38 = var2_2 & 656L) - var62_55) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
            var7_5 = var1_1.b;
            var7_5.setVisibility(var25_15);
        }
        if ((var25_15 = (int)((cfr_temp_3 = (var72_63 = var2_2 & var17_11) - var62_55) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) != 0) {
            var27_17 = var1_1.b;
            var70_61 = 0;
            var7_5 = null;
            u.k((TextView)var27_17, (int)var10_7, null, null);
        }
        if ((var25_15 = (int)((cfr_temp_4 = (var72_63 = 704L & var2_2) - var62_55) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) != 0) {
            var27_17 = var1_1.c;
            var27_17.setVisibility(var60_53);
        }
        if ((var60_53 = (int)((cfr_temp_5 = (var72_63 = var2_2 & var21_13) - var62_55) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) != 0) {
            var1_1.d.setOnClickListener((View.OnClickListener)var66_58);
            var6_4 = var1_1.j;
            var6_4.setOnClickListener((View.OnClickListener)var65_57);
        }
        if ((var60_53 = (int)((cfr_temp_6 = (var4_3 = var2_2 & var23_14) - var62_55) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1))) != 0 && (var60_53 = ViewDataBinding.getBuildSdkInt()) >= (var67_59 = 11)) {
            var6_4 = var1_1.h;
            var6_4.setAlpha(var36_28);
        }
        if (var45_37 != false) {
            var6_4 = var1_1.h;
            ViewBindingAdapter.setOnClick((View)var6_4, var61_54, var54_46);
        }
        if ((var60_53 = (int)((cfr_temp_7 = (var4_3 = 644L & var2_2) - (var72_63 = 0L)) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.i;
            var67_59 = 0;
            var65_57 = null;
            u.k((TextView)var6_4, var49_40, null, null);
        }
        if ((var60_53 = (int)((cfr_temp_8 = (var2_2 &= var19_12) - var72_63) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.j;
            var25_15 = var56_50;
            var26_16 = var57_51;
            var6_4.setVisibility(var56_50);
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
            this.q = l10 = 512L;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        switch (n10) {
            default: {
                return false;
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
                object = (LiveData)object;
                return this.E((LiveData)object, n11);
            }
            case 3: {
                object = (MutableLiveData)object;
                return this.C((MutableLiveData)object, n11);
            }
            case 2: {
                object = (MutableLiveData)object;
                return this.H((MutableLiveData)object, n11);
            }
            case 1: {
                object = (MutableLiveData)object;
                return this.D((MutableLiveData)object, n11);
            }
            case 0: 
        }
        object = (MutableLiveData)object;
        return this.G((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = d.v.a.d.N0;
        if (n11 == n10) {
            object = (m0)object;
            this.B((m0)object);
            return 1 != 0;
        } else {
            n11 = d.v.a.d.x;
            if (n11 != n10) return 0 != 0;
            object = (m$b)object;
            this.A((m$b)object);
        }
        return 1 != 0;
    }
}

