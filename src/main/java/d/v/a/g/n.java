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
import com.zhiyun.account.me.account.SetPassFragment$a;
import com.zhiyun.account.me.account.getcode.GetCodeStatus;
import com.zhiyun.account.me.account.widget.MePassView;
import d.v.a.c;
import d.v.a.d;
import d.v.a.g.m;
import d.v.a.g.n$a;
import d.v.a.g.n$b;
import d.v.a.g.n$c;
import d.v.a.i.a.m0;
import l.a.q.g0.u;

public class n
extends m {
    private static final ViewDataBinding$IncludedLayouts q;
    private static final SparseIntArray r;
    private final ConstraintLayout l;
    private n$c m;
    private n$a n;
    private n$b o;
    private long p;

    static {
        SparseIntArray sparseIntArray;
        r = sparseIntArray = new SparseIntArray();
        int n10 = R$id.iv_title;
        sparseIntArray.put(n10, 7);
        n10 = R$id.mnv_pass_first;
        sparseIntArray.put(n10, 8);
        n10 = R$id.mpv_pass_second;
        sparseIntArray.put(n10, 9);
    }

    public n(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = q;
        SparseIntArray sparseIntArray = r;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 10, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private n(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[5];
        object2 = (CheckBox)object;
        Object object3 = object = objectArray[4];
        object3 = (CheckBox)object;
        Object object4 = object = objectArray[1];
        object4 = (ImageView)object;
        Object object5 = object = objectArray[7];
        object5 = (ImageView)object;
        Object object6 = object = objectArray[8];
        object6 = (MePassView)((Object)object);
        Object object7 = object = objectArray[9];
        object7 = (MePassView)((Object)object);
        Object object8 = object = objectArray[3];
        object8 = (TextView)object;
        Object object9 = object = objectArray[2];
        object9 = (TextView)object;
        Object object10 = object = objectArray[6];
        object10 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 6, (CheckBox)object2, (CheckBox)object3, (ImageView)object4, (ImageView)object5, (MePassView)((Object)object6), (MePassView)((Object)object7), (TextView)object8, (TextView)object9, (TextView)object10);
        this.p = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.l = object;
        object.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
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
                long l10 = this.p;
                long l11 = 4;
                this.p = l10 |= l11;
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
                long l10 = this.p;
                long l11 = 1L;
                this.p = l10 |= l11;
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
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
            synchronized (this) {
                long l10 = this.p;
                long l11 = 32;
                this.p = l10 |= l11;
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
                long l10 = this.p;
                long l11 = 2;
                this.p = l10 |= l11;
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
                long l10 = this.p;
                long l11 = 8;
                this.p = l10 |= l11;
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
                long l10 = this.p;
                long l11 = 16;
                this.p = l10 |= l11;
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
    public void A(SetPassFragment$a setPassFragment$a) {
        this.j = setPassFragment$a;
        synchronized (this) {
            long l10 = this.p;
            long l11 = 128L;
            this.p = l10 |= l11;
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
        this.k = m02;
        synchronized (this) {
            long l10 = this.p;
            long l11 = 64;
            this.p = l10 |= l11;
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
        block68: {
            block69: {
                block66: {
                    block67: {
                        block65: {
                            block61: {
                                block64: {
                                    block63: {
                                        block62: {
                                            var1_1 = this;
                                            synchronized (this) {
                                                var2_2 = this.p;
                                                this.p = var4_3 = 0L;
                                            }
                                            var6_4 = this.k;
                                            var7_5 = this.j;
                                            var8_6 = 511L & var2_2;
                                            var10_7 = var8_6 == var4_3 ? 0 : (var8_6 < var4_3 ? -1 : 1);
                                            var11_8 = 336L;
                                            var13_9 = 328L;
                                            var15_10 = 324L;
                                            var17_11 = 321L;
                                            var19_12 = 450L;
                                            var21_13 = 322L;
                                            var23_14 = 0;
                                            var24_15 = 0.0f;
                                            var25_16 = null;
                                            if (var10_7 == false) break block61;
                                            var26_17 = var2_2 & var17_11;
                                            var10_7 = var26_17 == var4_3 ? 0 : (var26_17 < var4_3 ? -1 : 1);
                                            var28_18 = 1;
                                            var29_19 = 1.4E-45f;
                                            var30_21 = 8;
                                            var31_22 = 1.1E-44f;
                                            if (var10_7 == false) ** GOTO lbl-1000
                                            if (var6_4 != null) {
                                                var32_23 /* !! */  = var6_4.l;
                                            } else {
                                                var33_25 = 0;
                                                var34_26 = 0.0f;
                                                var32_23 /* !! */  = null;
                                            }
                                            var1_1.updateLiveDataRegistration(0, var32_23 /* !! */ );
                                            if (var32_23 /* !! */  != null) {
                                                var32_23 /* !! */  = (GetCodeStatus)var32_23 /* !! */ .getValue();
                                            } else {
                                                var33_25 = 0;
                                                var34_26 = 0.0f;
                                                var32_23 /* !! */  = null;
                                            }
                                            var25_16 = GetCodeStatus.REGISTER;
                                            if (var25_16 == var32_23 /* !! */ ) {
                                                var23_14 = var28_18;
                                                var24_15 = var29_19;
                                            } else {
                                                var23_14 = 0;
                                                var24_15 = 0.0f;
                                                var25_16 = null;
                                            }
                                            if (var10_7 != false) {
                                                var35_28 = var23_14 != 0 ? 1024L : 512L;
                                                var2_2 |= var35_28;
                                            }
                                            if (var23_14 == 0) {
                                                var23_14 = var30_21;
                                                var24_15 = var31_22;
                                            } else lbl-1000:
                                            // 2 sources

                                            {
                                                var23_14 = 0;
                                                var24_15 = 0.0f;
                                                var25_16 = null;
                                            }
                                            var35_28 = var2_2 & var19_12;
                                            var10_7 = var35_28 == var4_3 ? 0 : (var35_28 < var4_3 ? -1 : 1);
                                            if (var10_7 == false) break block62;
                                            if (var6_4 != null) {
                                                var37_29 = var6_4.j;
                                            } else {
                                                var10_7 = 0;
                                                var37_29 = null;
                                            }
                                            var1_1.updateLiveDataRegistration(var28_18, (LiveData)var37_29);
                                            if (var37_29 != null) {
                                                var37_29 = (Boolean)var37_29.getValue();
                                            } else {
                                                var10_7 = 0;
                                                var37_29 = null;
                                            }
                                            var10_7 = (long)ViewDataBinding.safeUnbox((Boolean)var37_29);
                                            var38_31 = var2_2 & var21_13;
                                            var33_25 = var38_31 == var4_3 ? 0 : (var38_31 < var4_3 ? -1 : 1);
                                            if (var33_25 != 0) {
                                                var38_31 = var10_7 != false ? 16384L : 8192L;
                                                var2_2 |= var38_31;
                                            }
                                            if ((var33_25 = (cfr_temp_0 = (var38_31 = var2_2 & var21_13) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) == 0) break block63;
                                            if (var10_7 != false) {
                                                var33_25 = 1065353216;
                                                var34_26 = 1.0f;
                                            } else {
                                                var33_25 = 1053609165;
                                                var34_26 = 0.4f;
                                            }
                                            var40_32 = var33_25;
                                            var41_33 = var34_26;
                                            break block64;
                                        }
                                        var10_7 = 0;
                                        var37_29 = null;
                                    }
                                    var40_32 = 0;
                                    var41_33 = 0.0f;
                                }
                                var38_31 = var2_2 & var15_10;
                                var33_25 = var38_31 == var4_3 ? 0 : (var38_31 < var4_3 ? -1 : 1);
                                if (var33_25 == 0) ** GOTO lbl-1000
                                if (var6_4 != null) {
                                    var42_34 = var6_4.s;
                                } else {
                                    var28_18 = 0;
                                    var29_19 = 0.0f;
                                    var42_34 = null;
                                }
                                var43_36 = 2;
                                var1_1.updateLiveDataRegistration((int)var43_36, (LiveData)var42_34);
                                if (var42_34 != null) {
                                    var42_34 = (Boolean)var42_34.getValue();
                                } else {
                                    var28_18 = 0;
                                    var29_19 = 0.0f;
                                    var42_34 = null;
                                }
                                var28_18 = (int)ViewDataBinding.safeUnbox((Boolean)var42_34);
                                if (var33_25 != 0) {
                                    var15_10 = var28_18 != 0 ? 4096L : 2048L;
                                    var2_2 |= var15_10;
                                }
                                if (var28_18 == 0) {
                                    var33_25 = var30_21;
                                    var34_26 = var31_22;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    var33_25 = 0;
                                    var34_26 = 0.0f;
                                    var32_23 /* !! */  = null;
                                }
                                var44_37 = var2_2 & var13_9;
                                var28_18 = (int)(var44_37 == var4_3 ? 0 : (var44_37 < var4_3 ? -1 : 1));
                                if (var28_18 != 0) {
                                    if (var6_4 != null) {
                                        var42_34 = var6_4.q;
                                    } else {
                                        var28_18 = 0;
                                        var29_19 = 0.0f;
                                        var42_34 = null;
                                    }
                                    var43_36 = 3;
                                    var1_1.updateLiveDataRegistration((int)var43_36, (LiveData)var42_34);
                                    if (var42_34 != null) {
                                        var42_34 = (Integer)var42_34.getValue();
                                    } else {
                                        var28_18 = 0;
                                        var29_19 = 0.0f;
                                        var42_34 = null;
                                    }
                                    var28_18 = ViewDataBinding.safeUnbox((Integer)var42_34);
                                } else {
                                    var28_18 = 0;
                                    var29_19 = 0.0f;
                                    var42_34 = null;
                                }
                                var15_10 = var2_2 & var11_8;
                                var43_36 = var15_10 == var4_3 ? 0 : (var15_10 < var4_3 ? -1 : 1);
                                if (var43_36 != false) {
                                    if (var6_4 != null) {
                                        var46_38 = var6_4.o;
                                    } else {
                                        var43_36 = 0;
                                        var46_38 = null;
                                    }
                                    var47_39 = 4;
                                    var1_1.updateLiveDataRegistration(var47_39, var46_38);
                                    if (var46_38 != null) {
                                        var48_40 = (Integer)var46_38.getValue();
                                    } else {
                                        var47_39 = 0;
                                        var48_40 = null;
                                    }
                                    var47_39 = ViewDataBinding.safeUnbox(var48_40);
                                } else {
                                    var47_39 = 0;
                                    var48_41 = null;
                                }
                                var15_10 = 352L;
                                var49_43 = var2_2 & var15_10;
                                var51_44 = var49_43 == var4_3 ? 0 : (var49_43 < var4_3 ? -1 : 1);
                                if (var51_44 != 0) {
                                    if (var6_4 != null) {
                                        var6_4 = var6_4.r;
                                    } else {
                                        var52_45 = 0;
                                        var53_46 = 0.0f;
                                        var6_4 = null;
                                    }
                                    var43_36 = 5;
                                    var1_1.updateLiveDataRegistration((int)var43_36, (LiveData)var6_4);
                                    if (var6_4 != null) {
                                        var6_4 = (Boolean)var6_4.getValue();
                                    } else {
                                        var52_45 = 0;
                                        var53_46 = 0.0f;
                                        var6_4 = null;
                                    }
                                    var52_45 = (int)ViewDataBinding.safeUnbox((Boolean)var6_4);
                                    if (var51_44 != 0) {
                                        var15_10 = var52_45 != 0 ? 65536L : 32768L;
                                        var2_2 |= var15_10;
                                    }
                                    if (var52_45 != 0) {
                                        var30_21 = 0;
                                        var31_22 = 0.0f;
                                    }
                                    var51_44 = var47_39;
                                    var52_45 = var40_32;
                                    var53_46 = var41_33;
                                    var47_39 = var10_7;
                                    var10_7 = var30_21;
                                } else {
                                    var51_44 = var47_39;
                                    var52_45 = var40_32;
                                    var53_46 = var41_33;
                                    var47_39 = (int)var10_7;
                                    var10_7 = 0;
                                    var37_29 = null;
                                }
                                var54_47 = var33_25;
                                var55_48 = var34_26;
                                var33_25 = var23_14;
                                var34_26 = var24_15;
                                var23_14 = var54_47;
                                var24_15 = var55_48;
                                break block65;
                            }
                            var52_45 = 0;
                            var53_46 = 0.0f;
                            var6_4 = null;
                            var23_14 = 0;
                            var24_15 = 0.0f;
                            var25_16 = null;
                            var10_7 = 0;
                            var37_30 = null;
                            var47_39 = 0;
                            var48_42 = null;
                            var51_44 = 0;
                            var33_25 = 0;
                            var34_27 = 0.0f;
                            var32_24 = null;
                            var28_18 = 0;
                            var29_20 = 0.0f;
                            var42_35 = null;
                        }
                        var15_10 = var2_2 & var19_12;
                        var43_36 = var15_10 == var4_3 ? 0 : (var15_10 < var4_3 ? -1 : 1);
                        var19_12 = 384L;
                        if (var43_36 == false) break block66;
                        if (var7_5 != null) {
                            var56_49 = var1_1.m;
                            if (var56_49 == null) {
                                var1_1.m = var56_49 = new n$c();
                            }
                            var56_49 = var56_49.b(var7_5);
                        } else {
                            var56_49 = null;
                        }
                        var57_50 = var2_2 & var19_12;
                        var59_51 = var57_50 == var4_3 ? 0 : (var57_50 < var4_3 ? -1 : 1);
                        if (!var59_51 || var7_5 == null) break block67;
                        var60_52 = var1_1.n;
                        if (var60_52 == null) {
                            var1_1.n = var60_52 = new n$a();
                        }
                        var60_52 = var60_52.b(var7_5);
                        var61_53 = var1_1.o;
                        if (var61_53 == null) {
                            var1_1.o = var61_53 = new n$b();
                        }
                        var61_53 = var61_53.b(var7_5);
                        break block68;
                    }
                    var62_54 = 0;
                    var61_53 = null;
                    break block69;
                }
                var62_54 = 0;
                var61_53 = null;
                var56_49 = null;
            }
            var59_51 = false;
            var60_52 = null;
        }
        var63_55 = var2_2 & 256L;
        var57_50 = 0L;
        var65_56 = var63_55 == var57_50 ? 0 : (var63_55 < var57_50 ? -1 : 1);
        if (var65_56 != false) {
            var66_57 = var1_1.a;
            var7_5 = d.v.a.c.b(this.getRoot().getContext());
            var66_57.setText((CharSequence)var7_5);
        }
        if ((var65_56 = (cfr_temp_1 = (var67_58 = var2_2 & 324L) - var57_50) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
            var66_57 = var1_1.a;
            var66_57.setVisibility(var23_14);
        }
        if ((var65_56 = (cfr_temp_2 = (var69_59 = 352L & var2_2) - var57_50) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
            var66_57 = var1_1.b;
            var66_57.setVisibility((int)var10_7);
        }
        if ((var65_56 = (cfr_temp_3 = (var69_59 = var2_2 & var19_12) - var57_50) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) {
            var66_57 = var1_1.c;
            var66_57.setOnClickListener((View.OnClickListener)var61_53);
            var61_53 = var1_1.i;
            var61_53.setOnClickListener(var60_52);
        }
        if ((var62_54 = (cfr_temp_4 = (var4_3 = var2_2 & var21_13) - var57_50) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) != 0 && (var62_54 = ViewDataBinding.getBuildSdkInt()) >= (var65_56 = (long)11)) {
            var61_53 = var1_1.g;
            var61_53.setAlpha(var53_46);
        }
        if (var43_36 != false) {
            var6_4 = var1_1.g;
            ViewBindingAdapter.setOnClick((View)var6_4, var56_49, (boolean)var47_39);
        }
        if ((var52_45 = (int)((cfr_temp_5 = (var4_3 = 328L & var2_2) - (var71_60 = 0L)) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.g;
            var62_54 = 0;
            var61_53 = null;
            u.k((TextView)var6_4, var28_18, null, null);
        } else {
            var62_54 = 0;
            var61_53 = null;
        }
        var8_6 = 336L & var2_2;
        var52_45 = (int)(var8_6 == var71_60 ? 0 : (var8_6 < var71_60 ? -1 : 1));
        if (var52_45 != 0) {
            var6_4 = var1_1.h;
            u.k((TextView)var6_4, var51_44, null, null);
        }
        if ((var52_45 = (int)((cfr_temp_6 = (var2_2 &= var17_11) - var71_60) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.i;
            var6_4.setVisibility(var33_25);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.p;
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
            this.p = l10 = 256L;
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
                        return this.H((MutableLiveData)object, n11);
                    }
                    object = (MutableLiveData)object;
                    return this.G((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.C((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.F((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.D((MutableLiveData)object, n11);
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
            object = (SetPassFragment$a)object;
            this.A((SetPassFragment$a)object);
        }
        return 1 != 0;
    }
}

