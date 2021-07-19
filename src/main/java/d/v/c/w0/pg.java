/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.util.Pair;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.set.SetFragment$a;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.q1.g0;
import d.v.c.w0.og;
import d.v.c.w0.pg$a;
import d.v.c.w0.pg$b;
import d.v.c.w0.pg$c;
import d.v.c.w0.pg$d;
import d.v.c.w0.pg$e;
import d.v.c.w0.pg$f;
import d.v.c.w0.pg$g;
import d.v.c.w0.pg$h;
import d.v.c.w0.pg$i;
import l.a.q.g0.u;

public class pg
extends og
implements b$a {
    private static final ViewDataBinding$IncludedLayouts F;
    private static final SparseIntArray G;
    private pg$e A;
    private pg$f B;
    private pg$g C;
    private pg$h D;
    private long E;
    private final LinearLayout j;
    private final TextView k;
    private final TextView l;
    private final TextView m;
    private final TextView n;
    private final TextView o;
    private final FrameLayout p;
    private final TextView q;
    private final TextView r;
    private final TextView s;
    private final TextView t;
    private final View.OnClickListener u;
    private pg$i v;
    private pg$a w;
    private pg$b x;
    private pg$c y;
    private pg$d z;

    static {
        SparseIntArray sparseIntArray;
        G = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363612, 17);
    }

    public pg(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = F;
        SparseIntArray sparseIntArray = G;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 18, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private pg(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[11];
        object4 = (CheckBox)object3;
        Object object5 = object3 = objectArray[10];
        object5 = (CheckBox)object3;
        Object object6 = object3 = objectArray[13];
        object6 = (CheckBox)object3;
        Object object7 = object3 = objectArray[2];
        object7 = (CheckBox)object3;
        Object object8 = object3 = objectArray[3];
        object8 = (CheckBox)object3;
        int n10 = 1;
        Object object9 = object2 = objectArray[n10];
        object9 = (ImageView)object2;
        Object object10 = object2 = objectArray[17];
        object10 = (TextView)object2;
        object2 = this;
        super(object, view, 6, (CheckBox)object4, (CheckBox)object5, (CheckBox)object6, (CheckBox)object7, (CheckBox)object8, (ImageView)object9, (TextView)object10);
        this.E = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        object = (LinearLayout)objectArray[0];
        this.j = object;
        object.setTag(null);
        object = (TextView)objectArray[12];
        this.k = object;
        object.setTag(null);
        object = (TextView)objectArray[14];
        this.l = object;
        object.setTag(null);
        object = (TextView)objectArray[15];
        this.m = object;
        object.setTag(null);
        object = (TextView)objectArray[16];
        this.n = object;
        object.setTag(null);
        object = (TextView)objectArray[4];
        this.o = object;
        object.setTag(null);
        object = (FrameLayout)objectArray[5];
        this.p = object;
        object.setTag(null);
        object = (TextView)objectArray[6];
        this.q = object;
        object.setTag(null);
        object = (TextView)objectArray[7];
        this.r = object;
        object.setTag(null);
        object = (TextView)objectArray[8];
        this.s = object;
        object.setTag(null);
        object = (TextView)objectArray[9];
        this.t = object;
        object.setTag(null);
        this.setRootTag(view);
        object = new b(this, n10);
        this.u = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(MediatorLiveData mediatorLiveData, int n10) {
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
    private boolean D(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.E;
                long l11 = 16;
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
    private boolean E(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.E;
                long l11 = 32;
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
    private boolean F(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.E;
                long l11 = 2;
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
    private boolean G(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.E;
                long l11 = 4;
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
    private boolean H(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.E;
                long l11 = 8;
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
    public void A(SetFragment$a setFragment$a) {
        this.h = setFragment$a;
        synchronized (this) {
            long l10 = this.E;
            long l11 = 64;
            this.E = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(g0 g02) {
        this.i = g02;
        synchronized (this) {
            long l10 = this.E;
            long l11 = 128L;
            this.E = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        SetFragment$a setFragment$a = this.h;
        boolean bl2 = setFragment$a != null;
        if (bl2) {
            setFragment$a.b(view);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block60: {
            block59: {
                var1_1 = this;
                synchronized (this) {
                    var2_2 = this.E;
                    this.E = var4_3 = 0L;
                }
                var6_4 = this.h;
                var7_5 = this.i;
                var8_6 = 320L & var2_2;
                var10_7 = var8_6 == var4_3 ? 0 : (var8_6 < var4_3 ? -1 : 1);
                if (var10_7 != false && var6_4 != null) {
                    var11_8 = this.v;
                    if (var11_8 == null) {
                        this.v = var11_8 = new pg$i();
                    }
                    var11_8 = var11_8.b((SetFragment$a)var6_4);
                    var12_9 = var1_1.w;
                    if (var12_9 == null) {
                        var1_1.w = var12_9 = new pg$a();
                    }
                    var12_9 = var12_9.b((SetFragment$a)var6_4);
                    var13_10 = var1_1.x;
                    if (var13_10 == null) {
                        var1_1.x = var13_10 = new pg$b();
                    }
                    var13_10 = var13_10.b((SetFragment$a)var6_4);
                    var14_11 = var1_1.y;
                    if (var14_11 == null) {
                        var1_1.y = var14_11 = new pg$c();
                    }
                    var14_11 = var14_11.b((SetFragment$a)var6_4);
                    var15_12 = var1_1.z;
                    if (var15_12 == null) {
                        var1_1.z = var15_12 = new pg$d();
                    }
                    var15_12 = var15_12.b((SetFragment$a)var6_4);
                    var16_13 = var1_1.A;
                    if (var16_13 == null) {
                        var1_1.A = var16_13 = new pg$e();
                    }
                    var16_13 = var16_13.b((SetFragment$a)var6_4);
                    var17_14 = var1_1.B;
                    if (var17_14 == null) {
                        var1_1.B = var17_14 = new pg$f();
                    }
                    var17_14 = var17_14.b((SetFragment$a)var6_4);
                    var18_15 = var1_1.C;
                    if (var18_15 == null) {
                        var18_15 = new pg$g();
                        var1_1.C = var18_15;
                    }
                    var18_15 = var18_15.b((SetFragment$a)var6_4);
                    var19_16 = var1_1.D;
                    if (var19_16 == null) {
                        var1_1.D = var19_16 = new pg$h();
                    }
                    var6_4 = var19_16.b((SetFragment$a)var6_4);
                } else {
                    var20_17 = false;
                    var6_4 = null;
                    var21_18 = false;
                    var18_15 = null;
                    var11_8 = null;
                    var12_9 = null;
                    var13_10 = null;
                    var14_11 = null;
                    var15_12 = null;
                    var16_13 = null;
                    var22_19 = false;
                    var17_14 = null;
                }
                var4_3 = 447L & var2_2;
                var23_20 = 0L;
                var25_21 /* !! */  = var4_3 == var23_20 ? 0 : (var4_3 < var23_20 ? -1 : 1);
                var26_22 = 392L;
                var28_23 = 388L;
                var30_24 = 386L;
                var32_25 = 416L;
                var34_26 = 385L;
                var36_27 = 400L;
                var38_28 = false;
                var39_29 = null;
                if (var25_21 /* !! */  == false) break block59;
                var40_30 = var2_2 & var34_26;
                cfr_temp_0 = var40_30 - var23_20;
                var25_21 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                if (var25_21 /* !! */  == false) ** GOTO lbl-1000
                if (var7_5 != null) {
                    var19_16 = var7_5.j;
                } else {
                    var25_21 /* !! */  = 0;
                    var19_16 = null;
                }
                var1_1.updateLiveDataRegistration(0, (LiveData)var19_16);
                if (var19_16 != null) {
                    var19_16 = (Pair)var19_16.getValue();
                } else {
                    var25_21 /* !! */  = 0;
                    var19_16 = null;
                }
                if (var19_16 != null) {
                    var19_16 = (String)var19_16.second;
                } else lbl-1000:
                // 2 sources

                {
                    var25_21 /* !! */  = 0;
                    var19_16 = null;
                }
                var40_30 = var2_2 & var30_24;
                var23_20 = 0L;
                var42_31 = var40_30 == var23_20 ? 0 : (var40_30 < var23_20 ? -1 : 1);
                if (var42_31 != false) {
                    if (var7_5 != null) {
                        var43_33 = var7_5.w();
                        var44_34 = var19_16;
                        var39_29 = var43_33;
                    } else {
                        var44_34 = var19_16;
                        var38_28 = false;
                        var39_29 = null;
                    }
                    var25_21 /* !! */  = 1;
                    var1_1.updateLiveDataRegistration((int)var25_21 /* !! */ , (LiveData)var39_29);
                    if (var39_29 != null) {
                        var19_16 = (Boolean)var39_29.getValue();
                    } else {
                        var25_21 /* !! */  = 0;
                        var19_16 = null;
                    }
                    var25_21 /* !! */  = (long)ViewDataBinding.safeUnbox((Boolean)var19_16);
                } else {
                    var44_34 = var19_16;
                    var25_21 /* !! */  = 0;
                    var19_16 = null;
                }
                var45_35 = var2_2 & var28_23;
                var23_20 = 0L;
                var38_28 = var45_35 == var23_20 ? 0 : (var45_35 < var23_20 ? -1 : 1);
                if (var38_28) {
                    if (var7_5 != null) {
                        var39_29 = var7_5.z();
                        var47_36 = var25_21 /* !! */ ;
                    } else {
                        var47_36 = var25_21 /* !! */ ;
                        var38_28 = false;
                        var39_29 = null;
                    }
                    var25_21 /* !! */  = 2;
                    var1_1.updateLiveDataRegistration((int)var25_21 /* !! */ , (LiveData)var39_29);
                    if (var39_29 != null) {
                        var19_16 = (Boolean)var39_29.getValue();
                    } else {
                        var25_21 /* !! */  = 0;
                        var19_16 = null;
                    }
                    var25_21 /* !! */  = (long)ViewDataBinding.safeUnbox((Boolean)var19_16);
                } else {
                    var47_36 = var25_21 /* !! */ ;
                    var25_21 /* !! */  = 0;
                    var19_16 = null;
                }
                var48_37 = var2_2 & var26_22;
                var23_20 = 0L;
                var38_28 = var48_37 == var23_20 ? 0 : (var48_37 < var23_20 ? -1 : 1);
                if (var38_28) {
                    if (var7_5 != null) {
                        var39_29 = var7_5.F();
                        var50_38 = var25_21 /* !! */ ;
                    } else {
                        var50_38 = var25_21 /* !! */ ;
                        var38_28 = false;
                        var39_29 = null;
                    }
                    var25_21 /* !! */  = 3;
                    var1_1.updateLiveDataRegistration((int)var25_21 /* !! */ , (LiveData)var39_29);
                    if (var39_29 != null) {
                        var19_16 = (Boolean)var39_29.getValue();
                    } else {
                        var25_21 /* !! */  = 0;
                        var19_16 = null;
                    }
                    var25_21 /* !! */  = (long)ViewDataBinding.safeUnbox((Boolean)var19_16);
                } else {
                    var50_38 = var25_21 /* !! */ ;
                    var25_21 /* !! */  = 0;
                    var19_16 = null;
                }
                var51_39 = var2_2 & var36_27;
                var23_20 = 0L;
                var38_28 = var51_39 == var23_20 ? 0 : (var51_39 < var23_20 ? -1 : 1);
                if (var38_28) {
                    if (var7_5 != null) {
                        var39_29 = var7_5.u();
                        var53_40 = var25_21 /* !! */ ;
                    } else {
                        var53_40 = var25_21 /* !! */ ;
                        var38_28 = false;
                        var39_29 = null;
                    }
                    var25_21 /* !! */  = 4;
                    var1_1.updateLiveDataRegistration((int)var25_21 /* !! */ , (LiveData)var39_29);
                    if (var39_29 != null) {
                        var19_16 = (Boolean)var39_29.getValue();
                    } else {
                        var25_21 /* !! */  = 0;
                        var19_16 = null;
                    }
                    var25_21 /* !! */  = (long)ViewDataBinding.safeUnbox((Boolean)var19_16);
                } else {
                    var53_40 = var25_21 /* !! */ ;
                    var25_21 /* !! */  = 0;
                    var19_16 = null;
                }
                var54_41 = var2_2 & var32_25;
                var23_20 = 0L;
                var38_28 = var54_41 == var23_20 ? 0 : (var54_41 < var23_20 ? -1 : 1);
                if (var38_28) {
                    if (var7_5 != null) {
                        var39_29 = var7_5.v();
                    } else {
                        var38_28 = false;
                        var39_29 = null;
                    }
                    var56_42 = 5;
                    var1_1.updateLiveDataRegistration(var56_42, (LiveData)var39_29);
                    if (var39_29 != null) {
                        var39_29 = (Boolean)var39_29.getValue();
                    } else {
                        var38_28 = false;
                        var39_29 = null;
                    }
                    var56_42 = (int)ViewDataBinding.safeUnbox((Boolean)var39_29);
                    var43_33 = var44_34;
                    var38_28 = var25_21 /* !! */ ;
                    var44_34 = var18_15;
                    var25_21 /* !! */  = var47_36;
                    var21_18 = var50_38;
                    var57_43 = var17_14;
                } else {
                    var38_28 = var25_21 /* !! */ ;
                    var43_33 = var44_34;
                    var25_21 /* !! */  = var47_36;
                    var56_42 = 0;
                    var7_5 = null;
                    var44_34 = var18_15;
                    var57_43 = var17_14;
                    var21_18 = var50_38;
                }
                var22_19 = var53_40;
                break block60;
            }
            var44_34 = var18_15;
            var57_43 = var17_14;
            var25_21 /* !! */  = 0;
            var19_16 = null;
            var38_28 = false;
            var39_29 = null;
            var56_42 = 0;
            var7_5 = null;
            var21_18 = false;
            var18_15 = null;
            var22_19 = false;
            var17_14 = null;
            var42_32 = false;
            var43_33 = null;
        }
        var36_27 = var2_2 & var36_27;
        var23_20 = 0L;
        var58_44 = var36_27 == var23_20 ? 0 : (var36_27 < var23_20 ? -1 : 1);
        if (var58_44 != false) {
            var59_45 = var16_13;
            var16_13 = var1_1.a;
            CompoundButtonBindingAdapter.setChecked((CompoundButton)var16_13, var38_28);
        } else {
            var59_45 = var16_13;
        }
        var32_25 = var2_2 & var32_25;
        var38_28 = var32_25 == var23_20 ? 0 : (var32_25 < var23_20 ? -1 : 1);
        if (var38_28) {
            var39_29 = var1_1.b;
            CompoundButtonBindingAdapter.setChecked((CompoundButton)var39_29, (boolean)var56_42);
        }
        if (var38_28 = (cfr_temp_1 = (var60_46 = var2_2 & var30_24) - var23_20) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) {
            var39_29 = var1_1.c;
            CompoundButtonBindingAdapter.setChecked((CompoundButton)var39_29, (boolean)var25_21 /* !! */ );
        }
        if ((var25_21 /* !! */  = (cfr_temp_2 = (var4_3 = var2_2 & var28_23) - var23_20) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
            var19_16 = var1_1.d;
            CompoundButtonBindingAdapter.setChecked((CompoundButton)var19_16, var21_18);
        }
        if ((var25_21 /* !! */  = (cfr_temp_3 = (var4_3 = var2_2 & var26_22) - var23_20) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) {
            var19_16 = var1_1.e;
            CompoundButtonBindingAdapter.setChecked((CompoundButton)var19_16, var22_19);
        }
        if ((var25_21 /* !! */  = (cfr_temp_4 = (var4_3 = 256L & var2_2) - var23_20) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) != false) {
            var19_16 = var1_1.f;
            var39_29 = var1_1.u;
            var19_16.setOnClickListener((View.OnClickListener)var39_29);
        }
        if (var10_7 != false) {
            var1_1.k.setOnClickListener((View.OnClickListener)var15_12);
            var1_1.l.setOnClickListener((View.OnClickListener)var12_9);
            var1_1.m.setOnClickListener((View.OnClickListener)var13_10);
            var1_1.n.setOnClickListener((View.OnClickListener)var14_11);
            var1_1.o.setOnClickListener((View.OnClickListener)var11_8);
            var19_16 = var1_1.p;
            var19_16.setOnClickListener((View.OnClickListener)var6_4);
            var6_4 = var1_1.r;
            var16_13 = var59_45;
            var6_4.setOnClickListener((View.OnClickListener)var59_45);
            var6_4 = var1_1.s;
            var17_14 = var57_43;
            var6_4.setOnClickListener((View.OnClickListener)var57_43);
            var6_4 = var1_1.t;
            var18_15 = var44_34;
            var6_4.setOnClickListener((View.OnClickListener)var44_34);
        }
        if (var20_17 = (cfr_temp_5 = (var2_2 &= var34_26) - (var4_3 = 0L)) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1)) {
            var6_4 = var1_1.q;
            l.a.q.g0.u.n((TextView)var6_4, (String)var43_33, null, null);
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
            this.E = l10 = 256L;
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
                            object = (LiveData)object;
                            return this.E((LiveData)object, n11);
                        }
                        object = (MutableLiveData)object;
                        return this.D((MutableLiveData)object, n11);
                    }
                    object = (MutableLiveData)object;
                    return this.H((MutableLiveData)object, n11);
                }
                object = (LiveData)object;
                return this.G((LiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.F((MutableLiveData)object, n11);
        }
        object = (MediatorLiveData)object;
        return this.C((MediatorLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (SetFragment$a)object;
            this.A((SetFragment$a)object);
            return 1 != 0;
        } else {
            n11 = 152;
            if (n11 != n10) return 0 != 0;
            object = (g0)object;
            this.B((g0)object);
        }
        return 1 != 0;
    }
}

