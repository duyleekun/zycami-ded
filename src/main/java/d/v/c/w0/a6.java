/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.publish.ComposeFragment$b;
import d.v.c.u0.l;
import d.v.c.w0.a6$a;
import d.v.c.w0.a6$b;
import d.v.c.w0.a6$c;
import d.v.c.w0.z5;
import d.v.e.l.s1;
import l.a.q.g0.u;

public class a6
extends z5 {
    private static final ViewDataBinding$IncludedLayouts E;
    private static final SparseIntArray F;
    private a6$c A;
    private a6$a B;
    private a6$b C;
    private long D;
    private final ConstraintLayout y;
    private final View z;

    static {
        SparseIntArray sparseIntArray;
        F = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362469, 8);
        sparseIntArray.put(2131362636, 9);
        sparseIntArray.put(2131362170, 10);
        sparseIntArray.put(2131363433, 11);
        sparseIntArray.put(2131363559, 12);
        sparseIntArray.put(2131363109, 13);
        sparseIntArray.put(2131363060, 14);
        sparseIntArray.put(2131363056, 15);
        sparseIntArray.put(2131363057, 16);
        sparseIntArray.put(2131363447, 17);
        sparseIntArray.put(2131363103, 18);
        sparseIntArray.put(2131363028, 19);
        sparseIntArray.put(2131363029, 20);
        sparseIntArray.put(2131363030, 21);
        sparseIntArray.put(2131363385, 22);
        sparseIntArray.put(2131362470, 23);
    }

    public a6(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = E;
        SparseIntArray sparseIntArray = F;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 24, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private a6(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object = this;
        ConstraintLayout constraintLayout = (ConstraintLayout)((Object)objectArray[10]);
        FrameLayout frameLayout = (FrameLayout)objectArray[5];
        FrameLayout frameLayout2 = (FrameLayout)objectArray[8];
        FrameLayout frameLayout3 = (FrameLayout)objectArray[23];
        ImageView imageView = (ImageView)objectArray[1];
        ImageView imageView2 = (ImageView)objectArray[2];
        ImageView imageView3 = (ImageView)objectArray[9];
        TextView textView = (TextView)objectArray[3];
        ProgressBar progressBar = (ProgressBar)objectArray[7];
        RadioButton radioButton = (RadioButton)objectArray[19];
        RadioButton radioButton2 = (RadioButton)objectArray[20];
        RadioButton radioButton3 = (RadioButton)objectArray[21];
        RadioButton radioButton4 = (RadioButton)objectArray[15];
        RadioButton radioButton5 = (RadioButton)objectArray[16];
        RadioButton radioButton6 = (RadioButton)objectArray[14];
        RadioGroup radioGroup = (RadioGroup)objectArray[18];
        RadioGroup radioGroup2 = (RadioGroup)objectArray[13];
        TextView textView2 = (TextView)objectArray[22];
        TextView textView3 = (TextView)objectArray[11];
        TextView textView4 = (TextView)objectArray[17];
        TextView textView5 = (TextView)objectArray[4];
        TextView textView6 = (TextView)objectArray[12];
        int n10 = 4;
        super(dataBindingComponent, view, n10, constraintLayout, frameLayout, frameLayout2, frameLayout3, imageView, imageView2, imageView3, textView, progressBar, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioGroup, radioGroup2, textView2, textView3, textView4, textView5, textView6);
        this.D = -1;
        this.b.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.h.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.y = object;
        object.setTag(null);
        object = (View)objectArray[6];
        this.z = object;
        object.setTag(null);
        this.i.setTag(null);
        this.u.setTag(null);
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
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.D;
                long l11 = 2;
                this.D = l10 |= l11;
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
                long l10 = this.D;
                long l11 = 4;
                this.D = l10 |= l11;
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
                long l10 = this.D;
                long l11 = 8;
                this.D = l10 |= l11;
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
                long l10 = this.D;
                long l11 = 1L;
                this.D = l10 |= l11;
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
    public void A(ComposeFragment$b composeFragment$b) {
        this.x = composeFragment$b;
        synchronized (this) {
            long l10 = this.D;
            long l11 = 16;
            this.D = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(l l10) {
        this.w = l10;
        synchronized (this) {
            long l11 = this.D;
            long l12 = 32;
            this.D = l11 |= l12;
        }
        this.notifyPropertyChanged(28);
        super.requestRebind();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block56: {
            block51: {
                block55: {
                    block52: {
                        block54: {
                            block53: {
                                var1_1 = this;
                                synchronized (this) {
                                    var2_2 = this.D;
                                    this.D = var4_3 = 0L;
                                }
                                var6_4 = this.x;
                                var7_5 = this.w;
                                var8_6 = (long)117 & var2_2;
                                var10_7 /* !! */  = var8_6 == var4_3 ? 0 : (var8_6 < var4_3 ? -1 : 1);
                                var11_8 = 80;
                                var13_9 = 116;
                                var15_10 = 113;
                                if (var10_7 /* !! */  != false) {
                                    var17_11 = var2_2 & var15_10;
                                    cfr_temp_0 = var17_11 - var4_3;
                                    var10_7 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                    if (var10_7 /* !! */  != false && var6_4 != null) {
                                        var19_12 = this.A;
                                        if (var19_12 == null) {
                                            this.A = var19_12 = new a6$c();
                                        }
                                        var19_12 = var19_12.b((ComposeFragment$b)var6_4);
                                    } else {
                                        var10_7 /* !! */  = 0;
                                        var19_12 = null;
                                    }
                                    var17_11 = var2_2 & var11_8;
                                    var20_13 = var17_11 == var4_3 ? 0 : (var17_11 < var4_3 ? -1 : 1);
                                    if (var20_13 != false && var6_4 != null) {
                                        var21_15 = var1_1.B;
                                        if (var21_15 == null) {
                                            var1_1.B = var21_15 = new a6$a();
                                        }
                                        var21_15 = var21_15.b((ComposeFragment$b)var6_4);
                                    } else {
                                        var20_13 = 0;
                                        var21_15 = null;
                                    }
                                    var22_16 = var2_2 & var13_9;
                                    var24_17 = var22_16 == var4_3 ? 0 : (var22_16 < var4_3 ? -1 : 1);
                                    if (var24_17 != false && var6_4 != null) {
                                        var25_18 = var1_1.C;
                                        if (var25_18 == null) {
                                            var1_1.C = var25_18 = new a6$b();
                                        }
                                        var6_4 = var25_18.b((ComposeFragment$b)var6_4);
                                    } else {
                                        var26_19 = false;
                                        var6_4 = null;
                                    }
                                } else {
                                    var26_19 = false;
                                    var6_4 = null;
                                    var10_7 /* !! */  = 0;
                                    var19_12 = null;
                                    var20_14 = false;
                                    var21_15 = null;
                                }
                                var27_20 = (cfr_temp_1 = (var2_2 & (long)127) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1);
                                var28_21 = 104;
                                var30_22 = 100;
                                var32_23 = 98;
                                var34_24 = 0;
                                if (var27_20 == false) break block51;
                                var35_25 = var2_2 & var15_10;
                                cfr_temp_2 = var35_25 - var4_3;
                                var37_26 /* !! */  = (long)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
                                if (var37_26 /* !! */  != false) {
                                    if (var7_5 != null) {
                                        var38_27 = var7_5.A();
                                    } else {
                                        var37_26 /* !! */  = 0;
                                        var38_27 = null;
                                    }
                                    var1_1.updateLiveDataRegistration(0, (LiveData)var38_27);
                                    if (var38_27 != null) {
                                        var38_27 = (String)var38_27.getValue();
                                    } else {
                                        var37_26 /* !! */  = 0;
                                        var38_27 = null;
                                    }
                                    var37_26 /* !! */  = (long)s1.q((String)var38_27);
                                } else {
                                    var37_26 /* !! */  = 0;
                                    var38_28 = null;
                                }
                                var35_25 = var2_2 & var32_23;
                                var27_20 = var35_25 == var4_3 ? 0 : (var35_25 < var4_3 ? -1 : 1);
                                var39_30 = 8;
                                var40_31 = 1.1E-44f;
                                var34_24 = 1;
                                if (var27_20 != false) {
                                    if (var7_5 != null) {
                                        var41_32 = var7_5.s();
                                        var42_33 = var41_32;
                                    } else {
                                        var43_36 = 0;
                                        var42_33 = null;
                                    }
                                    var1_1.updateLiveDataRegistration(var34_24, (LiveData)var42_33);
                                    if (var42_33 != null) {
                                        var42_33 = (Integer)var42_33.getValue();
                                    } else {
                                        var43_36 = 0;
                                        var42_33 = null;
                                    }
                                    var43_36 = ViewDataBinding.safeUnbox((Integer)var42_33);
                                    var44_37 = var43_36 == 0 ? var34_24 : 0;
                                    if (var27_20 != false) {
                                        if (var44_37 != 0) {
                                            var2_2 |= 256L;
                                            var45_38 = 4096L;
                                        } else {
                                            var2_2 |= 128L;
                                            var45_38 = 2048L;
                                        }
                                        var2_2 |= var45_38;
                                    }
                                    if (var44_37 != 0) {
                                        var27_20 = var39_30;
                                    } else {
                                        var27_20 = 0;
                                        var25_18 = null;
                                    }
                                    var44_37 = var44_37 != 0 ? 0 : var39_30;
                                } else {
                                    var43_36 = 0;
                                    var42_34 = null;
                                    var44_37 = 0;
                                    var27_20 = 0;
                                    var25_18 = null;
                                }
                                var45_38 = var2_2 & var13_9;
                                var47_39 = var45_38 == var4_3 ? 0 : (var45_38 < var4_3 ? -1 : 1);
                                if (var47_39 == false) break block52;
                                if (var7_5 != null) {
                                    var48_40 = var7_5.t();
                                    var49_41 = var48_40;
                                } else {
                                    var50_43 = 0;
                                    var49_41 = null;
                                }
                                var51_44 = 2;
                                var1_1.updateLiveDataRegistration((int)var51_44, (LiveData)var49_41);
                                if (var49_41 != null) {
                                    var49_41 = (Integer)var49_41.getValue();
                                } else {
                                    var50_43 = 0;
                                    var49_41 = null;
                                }
                                var50_43 = ViewDataBinding.safeUnbox((Integer)var49_41);
                                var52_45 = var2_2 & var30_22;
                                var54_46 = var52_45 == var4_3 ? 0 : (var52_45 < var4_3 ? -1 : 1);
                                if (var54_46 == false) break block53;
                                if (var50_43 == var51_44) {
                                    var51_44 = var34_24;
                                } else {
                                    var51_44 = 0;
                                    var55_47 = null;
                                }
                                if (var54_46 != false) {
                                    var52_45 = var51_44 != false ? 1024L : 512L;
                                    var2_2 |= var52_45;
                                }
                                if (var51_44 == false) break block54;
                            }
                            var39_30 = 0;
                            var40_31 = 0.0f;
                        }
                        var56_48 = var50_43 == var34_24 ? var34_24 : 0;
                        var56_48 ^= 1;
                        var34_24 = var39_30;
                        break block55;
                    }
                    var34_24 = 0;
                    var56_48 = 0;
                }
                var13_9 = var2_2 & var28_21;
                var50_43 = var13_9 == var4_3 ? 0 : (var13_9 < var4_3 ? -1 : 1);
                if (var50_43 == 0) ** GOTO lbl-1000
                var7_5 = var7_5 != null ? var7_5.u() : null;
                var50_43 = 3;
                var1_1.updateLiveDataRegistration(var50_43, (LiveData)var7_5);
                if (var7_5 != null) {
                    var7_5 = (String)var7_5.getValue();
                    var50_43 = var34_24;
                    var34_24 = var56_48;
                } else lbl-1000:
                // 2 sources

                {
                    var50_43 = var34_24;
                    var34_24 = var56_48;
                    var7_5 = null;
                }
                var35_25 = 116;
                break block56;
            }
            var35_25 = var13_9;
            var7_5 = null;
            var34_24 = 0;
            var37_26 /* !! */  = 0;
            var38_29 = null;
            var50_43 = 0;
            var49_42 = null;
            var43_36 = 0;
            var42_35 = null;
            var44_37 = 0;
            var27_20 = 0;
            var25_18 = null;
        }
        var35_25 = var2_2 & var35_25;
        var51_44 = var35_25 == var4_3 ? 0 : (var35_25 < var4_3 ? -1 : 1);
        if (var51_44 != false) {
            var55_47 = var1_1.b;
            ViewBindingAdapter.setOnClick((View)var55_47, (View.OnClickListener)var6_4, (boolean)var34_24);
        }
        if (var26_19 = (cfr_temp_3 = (var57_49 = var2_2 & (long)80) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) {
            var6_4 = var1_1.e;
            var6_4.setOnClickListener((View.OnClickListener)var21_15);
        }
        if (var26_19 = (cfr_temp_4 = (var57_49 = var2_2 & (long)113) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) {
            ViewBindingAdapter.setOnClick((View)var1_1.f, var19_12, (boolean)var37_26 /* !! */ );
            var6_4 = var1_1.h;
            ViewBindingAdapter.setOnClick((View)var6_4, var19_12, (boolean)var37_26 /* !! */ );
        }
        if (var26_19 = (cfr_temp_5 = (var8_6 = var2_2 & var30_22) - var4_3) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1)) {
            var6_4 = var1_1.h;
            var6_4.setVisibility(var50_43);
        }
        if (var26_19 = (cfr_temp_6 = (var8_6 = var2_2 & var32_23) - var4_3) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1)) {
            var1_1.z.setVisibility(var44_37);
            var1_1.i.setVisibility((int)var27_20);
            var6_4 = var1_1.i;
            var6_4.setProgress(var43_36);
        }
        if (var26_19 = (cfr_temp_7 = (var2_2 &= var28_21) - var4_3) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1)) {
            var6_4 = var1_1.u;
            var59_50 = "@string/compose_generate_file_size";
            l.a.q.g0.u.n((TextView)var6_4, var59_50, var7_5, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.D;
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
            this.D = l10 = (long)64;
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
                    return this.E((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.D((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.C((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.F((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (ComposeFragment$b)object;
            this.A((ComposeFragment$b)object);
            return 1 != 0;
        } else {
            n11 = 28;
            if (n11 != n10) return 0 != 0;
            object = (l)object;
            this.B((l)object);
        }
        return 1 != 0;
    }
}

