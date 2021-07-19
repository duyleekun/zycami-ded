/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.a.g;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
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
import com.zhiyun.account.me.account.LoginQuickFragment$b;
import com.zhiyun.account.me.account.widget.InputCodeView;
import com.zhiyun.account.me.account.widget.MeNameView;
import d.v.a.c;
import d.v.a.d;
import d.v.a.g.g;
import d.v.a.g.h$a;
import d.v.a.g.h$b;
import d.v.a.g.h$c;
import d.v.a.g.h$d;
import d.v.a.i.a.m0;
import l.a.q.g0.u;

public class h
extends g {
    private static final ViewDataBinding$IncludedLayouts v;
    private static final SparseIntArray w;
    private final ConstraintLayout o;
    private final View p;
    private h$d q;
    private h$a r;
    private h$b s;
    private h$c t;
    private long u;

    static {
        SparseIntArray sparseIntArray;
        w = sparseIntArray = new SparseIntArray();
        int n10 = R$id.iv_title;
        sparseIntArray.put(n10, 12);
        n10 = R$id.tv_title_content;
        sparseIntArray.put(n10, 13);
    }

    public h(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = v;
        SparseIntArray sparseIntArray = w;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 14, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private h(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[8];
        object2 = (Button)object;
        Object object3 = object = objectArray[11];
        object3 = (CheckBox)object;
        Object object4 = object = objectArray[10];
        object4 = (TextView)object;
        Object object5 = object = objectArray[3];
        object5 = (InputCodeView)((Object)object);
        Object object6 = object = objectArray[1];
        object6 = (ImageView)object;
        Object object7 = object = objectArray[12];
        object7 = (ImageView)object;
        Object object8 = object = objectArray[4];
        object8 = (MeNameView)((Object)object);
        Object object9 = object = objectArray[9];
        object9 = (TextView)object;
        Object object10 = object = objectArray[7];
        object10 = (TextView)object;
        Object object11 = object = objectArray[6];
        object11 = (TextView)object;
        Object object12 = object = objectArray[13];
        object12 = (TextView)object;
        Object object13 = object = objectArray[2];
        object13 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 3, (Button)object2, (CheckBox)object3, (TextView)object4, (InputCodeView)((Object)object5), (ImageView)object6, (ImageView)object7, (MeNameView)((Object)object8), (TextView)object9, (TextView)object10, (TextView)object11, (TextView)object12, (TextView)object13);
        this.u = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.o = object;
        object.setTag(null);
        object = (View)objectArray[5];
        this.p = object;
        object.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.l.setTag(null);
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
                long l10 = this.u;
                long l11 = 1L;
                this.u = l10 |= l11;
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
                long l10 = this.u;
                long l11 = 2;
                this.u = l10 |= l11;
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
                long l10 = this.u;
                long l11 = 4;
                this.u = l10 |= l11;
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
    public void A(LoginQuickFragment$b loginQuickFragment$b) {
        this.m = loginQuickFragment$b;
        synchronized (this) {
            long l10 = this.u;
            long l11 = 16;
            this.u = l10 |= l11;
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
        this.n = m02;
        synchronized (this) {
            long l10 = this.u;
            long l11 = 8;
            this.u = l10 |= l11;
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
        block43: {
            block45: {
                block48: {
                    block47: {
                        block46: {
                            var1_1 = this;
                            synchronized (this) {
                                var2_2 = this.u;
                                this.u = var4_3 = 0L;
                            }
                            var6_4 = this.n;
                            var7_5 = this.m;
                            var8_6 = (long)63 & var2_2;
                            var10_7 /* !! */  = var8_6 == var4_3 ? 0 : (var8_6 < var4_3 ? -1 : 1);
                            var11_8 = 42;
                            var13_9 = 57;
                            var15_10 = 41;
                            var17_11 = 0;
                            var18_12 = null;
                            if (var10_7 /* !! */  == false) break block45;
                            var19_13 = var2_2 & var13_9;
                            cfr_temp_0 = var19_13 - var4_3;
                            var10_7 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                            if (var10_7 /* !! */  == false) break block46;
                            if (var6_4 != null) {
                                var21_14 = var6_4.f;
                            } else {
                                var10_7 /* !! */  = 0;
                                var21_14 = null;
                            }
                            var1_1.updateLiveDataRegistration(0, (LiveData)var21_14);
                            if (var21_14 != null) {
                                var21_14 = (Boolean)var21_14.getValue();
                            } else {
                                var10_7 /* !! */  = 0;
                                var21_14 = null;
                            }
                            var10_7 /* !! */  = (long)ViewDataBinding.safeUnbox((Boolean)var21_14);
                            var19_13 = var2_2 & var15_10;
                            var22_15 = var19_13 == var4_3 ? 0 : (var19_13 < var4_3 ? -1 : 1);
                            if (var22_15 != 0) {
                                var19_13 = var10_7 /* !! */  != false ? 512L : 256L;
                                var2_2 |= var19_13;
                            }
                            if ((var22_15 = (cfr_temp_1 = (var19_13 = var2_2 & var15_10) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) == 0) break block47;
                            if (var10_7 /* !! */  != false) {
                                var22_15 = 1065353216;
                                var23_16 = 1.0f;
                            } else {
                                var22_15 = 1053609165;
                                var23_16 = 0.4f;
                            }
                            var24_18 = var22_15;
                            var25_19 = var23_16;
                            break block48;
                        }
                        var10_7 /* !! */  = 0;
                        var21_14 = null;
                    }
                    var24_18 = 0;
                    var25_19 = 0.0f;
                }
                var19_13 = var2_2 & var11_8;
                var22_15 = var19_13 == var4_3 ? 0 : (var19_13 < var4_3 ? -1 : 1);
                if (var22_15 == 0) ** GOTO lbl-1000
                if (var6_4 != null) {
                    var26_20 = var6_4.h;
                } else {
                    var22_15 = 0;
                    var23_16 = 0.0f;
                    var26_20 = null;
                }
                var17_11 = 1;
                var1_1.updateLiveDataRegistration(var17_11, var26_20);
                if (var26_20 != null) {
                    var18_12 = (String)var26_20.getValue();
                } else lbl-1000:
                // 2 sources

                {
                    var17_11 = 0;
                    var18_12 = null;
                }
                var27_22 = 44;
                var29_23 = var2_2 & var27_22;
                var22_15 = var29_23 == var4_3 ? 0 : (var29_23 < var4_3 ? -1 : 1);
                if (var22_15 != 0) {
                    if (var6_4 != null) {
                        var6_4 = var6_4.g;
                    } else {
                        var31_24 = 0;
                        var32_25 = 0.0f;
                        var6_4 = null;
                    }
                    var33_26 = 2;
                    var34_27 = 2.8E-45f;
                    var1_1.updateLiveDataRegistration(var33_26, (LiveData)var6_4);
                    if (var6_4 != null) {
                        var6_4 = (Boolean)var6_4.getValue();
                    } else {
                        var31_24 = 0;
                        var32_25 = 0.0f;
                        var6_4 = null;
                    }
                    var31_24 = (int)ViewDataBinding.safeUnbox((Boolean)var6_4);
                    if (var22_15 != 0) {
                        if (var31_24 != 0) {
                            var2_2 |= 128L;
                            var35_29 = 2048L;
                        } else {
                            var2_2 |= (long)64;
                            var35_29 = 1024L;
                        }
                        var2_2 |= var35_29;
                    }
                    var33_26 = 8;
                    var34_27 = 1.1E-44f;
                    if (var31_24 != 0) {
                        var22_15 = var33_26;
                        var23_16 = var34_27;
                    } else {
                        var22_15 = 0;
                        var23_16 = 0.0f;
                        var26_20 = null;
                    }
                    if (var31_24 != 0) {
                        var37_30 = 0;
                        var38_31 = 0.0f;
                    } else {
                        var37_30 = var33_26;
                        var38_31 = var34_27;
                    }
                    var33_26 = (int)var10_7 /* !! */ ;
                    var31_24 = var24_18;
                    var32_25 = var25_19;
                    var21_14 = var18_12;
                    var17_11 = var22_15;
                    var22_15 = var37_30;
                    var23_16 = var38_31;
                    break block43;
                } else {
                    var33_26 = var10_7 /* !! */ ;
                    var31_24 = var24_18;
                    var32_25 = var25_19;
                    var22_15 = 0;
                    var23_16 = 0.0f;
                    var26_20 = null;
                    var21_14 = var18_12;
                    var17_11 = 0;
                    var18_12 = null;
                }
                break block43;
            }
            var31_24 = 0;
            var32_25 = 0.0f;
            var6_4 = null;
            var17_11 = 0;
            var18_12 = null;
            var10_7 /* !! */  = 0;
            var21_14 = null;
            var33_26 = 0;
            var34_28 = 0.0f;
            var22_15 = 0;
            var23_17 = 0.0f;
            var26_21 = null;
        }
        var39_32 = (cfr_temp_2 = (var13_9 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1);
        var40_33 = 48;
        if (var39_32 != false) {
            if (var7_5 != null) {
                var42_34 = var1_1.q;
                if (var42_34 == null) {
                    var1_1.q = var42_34 = new h$d();
                }
                var42_34 = var42_34.b((LoginQuickFragment$b)var7_5);
            } else {
                var42_34 = null;
            }
            var43_35 = var2_2 & var40_33;
            var24_18 = var43_35 == var4_3 ? 0 : (var43_35 < var4_3 ? -1 : 1);
            if (var24_18 != 0 && var7_5 != null) {
                var45_36 = var1_1.r;
                if (var45_36 == null) {
                    var1_1.r = var45_36 = new h$a();
                }
                var45_36 = var45_36.b((LoginQuickFragment$b)var7_5);
                var46_37 = var1_1.s;
                if (var46_37 == null) {
                    var1_1.s = var46_37 = new h$b();
                }
                var46_37 = var46_37.b((LoginQuickFragment$b)var7_5);
                var47_38 /* !! */  = var1_1.t;
                if (var47_38 /* !! */  == null) {
                    var47_38 /* !! */  = new h$c();
                    var1_1.t = var47_38 /* !! */ ;
                }
                var7_5 = var47_38 /* !! */ .b((LoginQuickFragment$b)var7_5);
            } else {
                var48_39 = 0;
                var7_5 = null;
                var45_36 = null;
                var46_37 = null;
            }
        } else {
            var48_39 = 0;
            var7_5 = null;
            var45_36 = null;
            var46_37 = null;
            var42_34 = null;
        }
        var15_10 = var2_2 & var40_33;
        var49_40 = var15_10 == var4_3 ? 0 : (var15_10 < var4_3 ? -1 : 1);
        if (var49_40 != false) {
            var1_1.a.setOnClickListener((View.OnClickListener)var42_34);
            var47_38 /* !! */  = var1_1.c;
            var47_38 /* !! */ .setOnClickListener((View.OnClickListener)var7_5);
            var1_1.e.setOnClickListener((View.OnClickListener)var45_36);
            var7_5 = var1_1.l;
            var7_5.setOnClickListener((View.OnClickListener)var46_37);
        }
        if ((var48_39 = (cfr_temp_3 = (var11_8 = (long)44 & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != 0) {
            var1_1.a.setVisibility(var22_15);
            var1_1.b.setVisibility(var17_11);
            var1_1.c.setVisibility(var17_11);
            var1_1.d.setVisibility(var22_15);
            var1_1.p.setVisibility(var17_11);
            var1_1.g.setVisibility(var17_11);
            var1_1.h.setVisibility(var17_11);
            var1_1.i.setVisibility(var22_15);
            var7_5 = var1_1.j;
            var7_5.setVisibility(var17_11);
        }
        if ((var17_11 = (int)((cfr_temp_4 = (var50_41 = (long)32 & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) != 0) {
            var18_12 = var1_1.b;
            var7_5 = d.v.a.c.b(this.getRoot().getContext());
            var18_12.setText((CharSequence)var7_5);
        }
        if ((var17_11 = (int)((cfr_temp_5 = (var50_41 = (long)41 & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) != 0 && (var17_11 = ViewDataBinding.getBuildSdkInt()) >= (var48_39 = 11)) {
            var18_12 = var1_1.h;
            var18_12.setAlpha(var32_25);
        }
        if (var39_32 != false) {
            var6_4 = var1_1.h;
            ViewBindingAdapter.setOnClick((View)var6_4, var42_34, (boolean)var33_26);
        }
        if ((var31_24 = (int)((cfr_temp_6 = (var2_2 &= (var50_41 = (long)42)) - var4_3) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.i;
            l.a.q.g0.u.n((TextView)var6_4, (String)var21_14, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.u;
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
            this.u = l10 = (long)32;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
                if (n10 != n12) {
                    return false;
                }
                object = (MutableLiveData)object;
                return this.E((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.D((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.C((MutableLiveData)object, n11);
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
            object = (LoginQuickFragment$b)object;
            this.A((LoginQuickFragment$b)object);
        }
        return 1 != 0;
    }
}

