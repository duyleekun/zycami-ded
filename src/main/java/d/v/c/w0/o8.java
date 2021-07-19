/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckedTextView
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.transition.EditorTransitionFragment$a;
import com.zhiyun.cama.widget.base.BaseResourceListView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.v1.o;
import d.v.c.w0.j4;
import d.v.c.w0.n8;

public class o8
extends n8
implements b$a {
    private static final ViewDataBinding$IncludedLayouts v;
    private static final SparseIntArray w;
    private final ConstraintLayout k;
    private final CheckedTextView l;
    private final CheckedTextView m;
    private final CheckedTextView n;
    private final CheckedTextView o;
    private final View.OnClickListener p;
    private final View.OnClickListener q;
    private final View.OnClickListener r;
    private final View.OnClickListener s;
    private final View.OnClickListener t;
    private long u;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        v = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(13);
        String[] stringArray = new String[]{"editor_bottom_choice_layout"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 11;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558529;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        w = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131363086, 12);
    }

    public o8(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = v;
        SparseIntArray sparseIntArray = w;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 13, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private o8(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        CheckedTextView checkedTextView;
        Object object;
        Object object2 = object = objectArray[11];
        object2 = (j4)object;
        int n10 = 1;
        Object object3 = object = objectArray[n10];
        object3 = (ConstraintLayout)((Object)object);
        Object object4 = object = objectArray[8];
        object4 = (FrameLayout)object;
        int n11 = 2;
        Object object5 = object = objectArray[n11];
        object5 = (FrameLayout)object;
        Object object6 = object = objectArray[6];
        object6 = (FrameLayout)object;
        int n12 = 4;
        Object object7 = object = objectArray[n12];
        object7 = (FrameLayout)object;
        Object object8 = object = objectArray[12];
        object8 = (BaseResourceListView)object;
        Object object9 = object = objectArray[10];
        object9 = (StatusView)((Object)object);
        object = this;
        Object object10 = dataBindingComponent;
        View view2 = view;
        super(dataBindingComponent, view, 4, (j4)object2, (ConstraintLayout)((Object)object3), (FrameLayout)object4, (FrameLayout)object5, (FrameLayout)object6, (FrameLayout)object7, (BaseResourceListView)object8, (StatusView)((Object)object9));
        this.u = -1;
        object = this.a;
        this.setContainedBinding((ViewDataBinding)object);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.k = object;
        object.setTag(null);
        int n13 = 3;
        view2 = (CheckedTextView)objectArray[n13];
        this.l = view2;
        view2.setTag(null);
        int n14 = 5;
        this.m = checkedTextView = (CheckedTextView)objectArray[n14];
        checkedTextView.setTag(null);
        this.n = checkedTextView = (CheckedTextView)objectArray[7];
        checkedTextView.setTag(null);
        this.o = checkedTextView = (CheckedTextView)objectArray[9];
        checkedTextView.setTag(null);
        this.h.setTag(null);
        object10 = view;
        this.setRootTag(view);
        object10 = new b(this, n11);
        this.p = object10;
        object10 = new b(this, n13);
        this.q = object10;
        object = new b(this, n10);
        this.r = object;
        object = new b(this, n12);
        this.s = object;
        object = new b(this, n14);
        this.t = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(j4 j42, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.u;
                long l11 = 8;
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
        if (n10 == 0) {
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
    private boolean E(MediatorLiveData mediatorLiveData, int n10) {
        if (n10 == 0) {
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
    private boolean F(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
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
    public void A(EditorTransitionFragment$a editorTransitionFragment$a) {
        this.j = editorTransitionFragment$a;
        synchronized (this) {
            long l10 = this.u;
            long l11 = 32;
            this.u = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(o o10) {
        this.i = o10;
        synchronized (this) {
            long l10 = this.u;
            long l11 = 16;
            this.u = l10 |= l11;
        }
        this.notifyPropertyChanged(144);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                int n14 = 3;
                if (n10 != n14) {
                    n13 = 4;
                    if (n10 != n13) {
                        n13 = 5;
                        if (n10 == n13) {
                            EditorTransitionFragment$a editorTransitionFragment$a = this.j;
                            if (editorTransitionFragment$a != null) {
                                n11 = n12;
                            }
                            if (n11 != 0) {
                                editorTransitionFragment$a.h();
                            }
                        }
                    } else {
                        o o10 = this.i;
                        if (o10 != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            o10.o(n14);
                        }
                    }
                } else {
                    o o11 = this.i;
                    if (o11 != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        o11.o(n13);
                    }
                }
            } else {
                o o12 = this.i;
                if (o12 != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    o12.o(n12);
                }
            }
        } else {
            o o13 = this.i;
            if (o13 == null) {
                n12 = 0;
            }
            if (n12 != 0) {
                o13.o(0);
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
        block120: {
            block122: {
                var1_1 = this;
                synchronized (this) {
                    var2_2 = this.u;
                    this.u = var4_3 = 0L;
                }
                var6_4 = this.i;
                var7_5 = this.j;
                var8_6 = (long)87 & var2_2;
                var10_7 /* !! */  = var8_6 == var4_3 ? 0 : (var8_6 < var4_3 ? -1 : 1);
                var11_8 = 1024L;
                var13_9 = 512L;
                var15_10 = 2048L;
                var17_11 = 128L;
                var19_12 = 0x200000L;
                var21_13 = 3 != 0;
                var22_14 = 4.2E-45f;
                var23_15 = 0x80000000L;
                var25_16 = 2 != 0;
                var26_17 = 2.8E-45f;
                var27_18 = 85;
                var29_19 /* !! */  = false;
                var30_20 = 0.0f;
                var31_21 = null;
                var32_22 = 81;
                var34_23 = true;
                var35_24 = 1.4E-45f;
                var36_25 = false;
                var37_26 = 0.0f;
                if (var10_7 /* !! */  == false) break block122;
                var38_27 = var2_2 & var32_22;
                cfr_temp_0 = var38_27 - var4_3;
                var10_7 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                if (var10_7 /* !! */  != false) {
                    if (var6_4 != null) {
                        var41_29 = var40_28 = var6_4.y();
                    } else {
                        var42_30 = false;
                        var41_29 = null;
                    }
                    var1_1.updateLiveDataRegistration(0, var41_29);
                    if (var41_29 != null) {
                        var43_31 = (Integer)var41_29.getValue();
                    } else {
                        var44_32 = false;
                        var43_31 = null;
                    }
                    var36_25 = ViewDataBinding.safeUnbox(var43_31);
                    if (!var36_25) {
                        var45_33 = var34_23;
                        var46_34 = var35_24;
                    } else {
                        var45_33 = false;
                        var46_34 = 0.0f;
                        var40_28 = null;
                    }
                    if (var36_25 == var21_13) {
                        var47_35 = var34_23;
                        var48_36 = var35_24;
                    } else {
                        var47_35 = false;
                        var48_36 = 0.0f;
                    }
                    if (var36_25 == var25_16) {
                        var49_37 = var34_23;
                        var50_38 = var35_24;
                    } else {
                        var49_37 = false;
                        var50_38 = 0.0f;
                    }
                    if (var36_25 == var34_23) {
                        var36_25 = var34_23;
                        var37_26 = var35_24;
                    } else {
                        var36_25 = false;
                        var37_26 = 0.0f;
                    }
                    if (var10_7 /* !! */  != false) {
                        var2_2 = var45_33 ? (var2_2 |= var11_8) : (var2_2 |= var13_9);
                    }
                    if ((var10_7 /* !! */  = (cfr_temp_1 = (var51_39 = var2_2 & var23_15) - (var38_27 = 0L)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
                        var51_39 = var45_33 != false ? 0x40000000L : 0x20000000L;
                        var2_2 |= var51_39;
                    }
                    if ((var10_7 /* !! */  = (cfr_temp_2 = (var51_39 = var2_2 & var17_11) - var38_27) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
                        var51_39 = var47_35 != false ? 16384L : 8192L;
                        var2_2 |= var51_39;
                    }
                    if ((var10_7 /* !! */  = (cfr_temp_3 = (var51_39 = var2_2 & var32_22) - var38_27) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) {
                        var51_39 = var47_35 != false ? 0x10000000L : 0x8000000L;
                        var2_2 |= var51_39;
                    }
                    if ((var10_7 /* !! */  = (cfr_temp_4 = (var51_39 = var2_2 & var32_22) - var38_27) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) != false) {
                        var51_39 = var49_37 != false ? 0x100000L : 524288L;
                        var2_2 |= var51_39;
                    }
                    if ((var10_7 /* !! */  = (cfr_temp_5 = (var51_39 = var2_2 & var19_12) - var38_27) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1)) != false) {
                        var51_39 = var49_37 != false ? 0x1000000L : 0x800000L;
                        var2_2 |= var51_39;
                    }
                    if ((var10_7 /* !! */  = (cfr_temp_6 = (var51_39 = var2_2 & var15_10) - var38_27) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1)) != false) {
                        var51_39 = var36_25 != false ? 65536L : 32768L;
                        var2_2 |= var51_39;
                    }
                    if ((var10_7 /* !! */  = (cfr_temp_7 = (var51_39 = var2_2 & var32_22) - var38_27) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1)) != false) {
                        var51_39 = var36_25 != false ? 262144L : 131072L;
                        var2_2 |= var51_39;
                    }
                    var10_7 /* !! */  = 2131165275;
                    var53_40 = 1.7944763E38f;
                    var54_41 = 2131165278 != 0;
                    var55_42 = 1.7944769E38f;
                    var56_44 = var1_1.l.getResources();
                    var57_46 = var45_33 != false ? var56_44.getDimension((int)var10_7 /* !! */ ) : var56_44.getDimension((int)var54_41);
                    var58_48 = var1_1.o.getResources();
                    var59_50 = var47_35 != false ? var58_48.getDimension((int)var10_7 /* !! */ ) : var58_48.getDimension((int)var54_41);
                    var60_51 = var1_1.n.getResources();
                    var61_54 = var49_37 != false ? var60_51.getDimension((int)var10_7 /* !! */ ) : var60_51.getDimension((int)var54_41);
                    if (var36_25) {
                        var62_55 = var1_1.m.getResources();
                        var53_40 = var62_55.getDimension((int)var10_7 /* !! */ );
                    } else {
                        var63_57 = var1_1.m.getResources();
                        var53_40 = var63_57.getDimension((int)var54_41);
                    }
                    var54_41 = var45_33;
                    var55_42 = var46_34;
                    var64_58 = 82;
                    var46_34 = var57_46;
                } else {
                    var42_30 = false;
                    var41_29 = null;
                    var44_32 = false;
                    var43_31 = null;
                    var10_7 /* !! */  = 0;
                    var53_40 = 0.0f;
                    var63_57 = null;
                    var66_59 = false;
                    var59_50 = 0.0f;
                    var58_48 = null;
                    var61_54 = 0.0f;
                    var60_52 = null;
                    var54_41 = false;
                    var55_42 = 0.0f;
                    var62_55 = null;
                    var36_25 = false;
                    var37_26 = 0.0f;
                    var45_33 = false;
                    var46_34 = 0.0f;
                    var40_28 = null;
                    var64_58 = 82;
                    var47_35 = false;
                    var48_36 = 0.0f;
                    var49_37 = false;
                    var50_38 = 0.0f;
                }
                var67_60 = var2_2 & var64_58;
                var38_27 = 0L;
                var69_61 = var67_60 == var38_27 ? 0 : (var67_60 < var38_27 ? -1 : 1);
                if (var69_61 == 0) ** GOTO lbl-1000
                if (var6_4 != null) {
                    var70_62 = var6_4.g();
                    var71_63 = var70_62;
                } else {
                    var21_13 = false;
                    var71_63 = null;
                    var22_14 = 0.0f;
                }
                var1_1.updateLiveDataRegistration((int)var34_23, (LiveData)var71_63);
                if (var71_63 != null) {
                    var71_63 = (Integer)var71_63.getValue();
                } else {
                    var21_13 = false;
                    var71_63 = null;
                    var22_14 = 0.0f;
                }
                var21_13 = ViewDataBinding.safeUnbox((Integer)var71_63);
                if (!var21_13) {
                    var21_13 = var34_23;
                    var22_14 = var35_24;
                } else {
                    var21_13 = false;
                    var22_14 = 0.0f;
                    var71_63 = null;
                }
                if (var69_61 != 0) {
                    var72_64 = var21_13 != false ? 0x4000000L : 0x2000000L;
                    var2_2 |= var72_64;
                }
                if (var21_13) {
                    var69_61 = 4;
                    var57_46 = 5.6E-45f;
                } else lbl-1000:
                // 2 sources

                {
                    var69_61 = 0;
                    var57_46 = 0.0f;
                    var56_44 = null;
                }
                var72_64 = var2_2 & var27_18;
                var38_27 = 0L;
                var21_13 = (boolean)(var72_64 == var38_27 ? 0 : (var72_64 < var38_27 ? -1 : 1));
                if (var21_13) {
                    if (var6_4 != null) {
                        var74_65 = var6_4.v();
                        var75_66 = var74_65;
                    } else {
                        var34_23 = false;
                        var75_66 = null;
                        var35_24 = 0.0f;
                    }
                    var1_1.updateLiveDataRegistration((int)var25_16, (LiveData)var75_66);
                    if (var75_66 != null) {
                        var31_21 = var75_66 = var75_66.getValue();
                        var31_21 = (Integer)var75_66;
                    }
                    var34_23 = ViewDataBinding.safeUnbox((Integer)var31_21);
                    var76_69 = 84;
                    var78_70 = var2_2 & var76_69;
                    var38_27 = 0L;
                    cfr_temp_8 = var78_70 - var38_27;
                    var29_19 /* !! */  = cfr_temp_8 == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1);
                    if (var29_19 /* !! */ ) {
                        var25_16 = true;
                        var26_17 = 1.4E-45f;
                        if (var34_23 >= false) {
                            var29_19 /* !! */  = true;
                            var30_20 = 1.4E-45f;
                        } else {
                            var29_19 /* !! */  = false;
                            var30_20 = 0.0f;
                            var31_21 = null;
                        }
                        var80_71 = var41_29;
                        var42_30 = 2 != 0;
                        if (var34_23 >= var25_16) {
                            var25_16 = true;
                            var26_17 = 1.4E-45f;
                        } else {
                            var25_16 = false;
                            var26_17 = 0.0f;
                        }
                        if (var34_23 >= var42_30) {
                            var42_30 = 3 != 0;
                            var81_74 = true;
                            var82_75 = 1.4E-45f;
                        } else {
                            var42_30 = 3 != 0;
                            var81_74 = false;
                            var82_75 = 0.0f;
                            var70_62 = null;
                        }
                        if (var34_23 >= var42_30) {
                            var83_76 = true;
                            var84_78 = 1.4E-45f;
                        } else {
                            var83_76 = false;
                            var84_78 = 0.0f;
                        }
                        var85_79 = (long)var83_76;
                        var86_80 = var84_78;
                        var42_30 = 2 != 0;
                        var83_76 = var81_74;
                        var84_78 = var82_75;
                    } else {
                        var80_71 = var41_29;
                        var42_30 = var25_16;
                        var25_16 = false;
                        var26_17 = 0.0f;
                        var29_19 /* !! */  = false;
                        var30_20 = 0.0f;
                        var31_21 = null;
                        var83_76 = false;
                        var84_78 = 0.0f;
                        var85_79 = 0;
                        var86_80 = 0.0f;
                    }
                    var87_81 = var43_31;
                    if (var34_23 < var42_30) {
                        var42_30 = true;
                    } else {
                        var42_30 = false;
                        var41_29 = null;
                    }
                    var44_32 = 3 != 0;
                    if (var34_23 < var44_32) {
                        var44_32 = true;
                    } else {
                        var44_32 = false;
                        var43_31 = null;
                    }
                    var88_82 = var53_40;
                    var10_7 /* !! */  = 1;
                    var53_40 = 1.4E-45f;
                    var89_84 = var34_23 < false;
                    if (var34_23 < var10_7 /* !! */ ) {
                        var10_7 /* !! */  = 1;
                        var53_40 = 1.4E-45f;
                    } else {
                        var10_7 /* !! */  = 0;
                        var53_40 = 0.0f;
                        var63_57 = null;
                    }
                    if (var21_13) {
                        if (var42_30) {
                            var90_85 = 0x400000L;
                            var2_2 |= var90_85;
                        } else {
                            var2_2 |= var19_12;
                        }
                    }
                    if (var21_13 = (boolean)((cfr_temp_9 = (var90_85 = var2_2 & var27_18) - (var38_27 = 0L)) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1))) {
                        if (var44_32) {
                            var90_85 = 256L;
                            var2_2 |= var90_85;
                        } else {
                            var2_2 |= var17_11;
                        }
                    }
                    if (var21_13 = (boolean)((cfr_temp_10 = (var90_85 = var2_2 & var27_18) - var38_27) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1))) {
                        if (var89_84) {
                            var90_85 = 0x100000000L;
                            var2_2 |= var90_85;
                        } else {
                            var2_2 |= var23_15;
                        }
                    }
                    if (var21_13 = (cfr_temp_11 = (var90_85 = var2_2 & var27_18) - var38_27) == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1)) {
                        if (var10_7 /* !! */  != false) {
                            var90_85 = 4096L;
                            var2_2 |= var90_85;
                        } else {
                            var2_2 |= var15_10;
                        }
                    }
                    var22_14 = var61_54;
                    var34_23 = (boolean)var85_79;
                    var35_24 = var86_80;
                    var61_54 = var88_82;
                    var92_86 = var84_78;
                    var84_78 = var59_50;
                    var66_59 = var25_16;
                    var59_50 = var26_17;
                    var26_17 = var46_34;
                    var45_33 = var54_41;
                    var46_34 = var55_42;
                    var54_41 = var29_19 /* !! */ ;
                    var55_42 = var30_20;
                    var31_21 = var80_71;
                    var93_87 = var36_25;
                    var94_88 = var37_26;
                    var36_25 = var83_76;
                    var37_26 = var92_86;
                    break block120;
                } else {
                    var80_72 = var41_29;
                    var87_81 = var43_31;
                    var88_83 = var53_40;
                    var84_78 = var59_50;
                    var22_14 = var61_54;
                    var26_17 = var46_34;
                    var31_21 = var41_29;
                    var61_54 = var53_40;
                    var42_30 = false;
                    var41_29 = null;
                    var44_32 = false;
                    var43_31 = null;
                    var10_7 /* !! */  = 0;
                    var53_40 = 0.0f;
                    var63_57 = null;
                    var66_59 = false;
                    var59_50 = 0.0f;
                    var58_48 = null;
                    var34_23 = false;
                    var35_24 = 0.0f;
                    var75_67 = null;
                    var89_84 = false;
                    var45_33 = var54_41;
                    var46_34 = var55_42;
                    var93_87 = var36_25;
                    var94_88 = var37_26;
                    var54_41 = false;
                    var55_42 = 0.0f;
                    var62_55 = null;
                    var36_25 = false;
                    var37_26 = 0.0f;
                }
                break block120;
            }
            var87_81 = null;
            var42_30 = false;
            var41_29 = null;
            var44_32 = false;
            var43_31 = null;
            var10_7 /* !! */  = 0;
            var53_40 = 0.0f;
            var63_57 = null;
            var66_59 = false;
            var59_50 = 0.0f;
            var58_49 = null;
            var61_54 = 0.0f;
            var60_53 = null;
            var54_41 = false;
            var55_43 = 0.0f;
            var62_56 = null;
            var69_61 = 0;
            var57_47 = 0.0f;
            var56_45 = null;
            var21_13 = false;
            var22_14 = 0.0f;
            var71_63 = null;
            var25_16 = false;
            var26_17 = 0.0f;
            var34_23 = false;
            var35_24 = 0.0f;
            var75_68 = null;
            var36_25 = false;
            var37_26 = 0.0f;
            var45_33 = false;
            var46_34 = 0.0f;
            var40_28 = null;
            var47_35 = false;
            var48_36 = 0.0f;
            var49_37 = false;
            var50_38 = 0.0f;
            var93_87 = false;
            var94_88 = 0.0f;
            var80_73 = null;
            var83_77 = false;
            var84_78 = 0.0f;
            var89_84 = false;
        }
        var95_89 = var2_2 & 0x80200880L;
        var38_27 = 0L;
        var85_79 = var95_89 == var38_27 ? 0 : (var95_89 < var38_27 ? -1 : 1);
        if (var85_79 != false) {
            if (var6_4 != null) {
                var31_21 = var6_4.y();
            }
            var97_90 = false;
            var98_91 = 0.0f;
            var6_4 = null;
            var30_20 = var22_14;
            var71_63 = var31_21;
            var1_1.updateLiveDataRegistration(0, (LiveData)var31_21);
            if (var31_21 != null) {
                var87_81 = var71_63 = var31_21.getValue();
                var87_81 = (Integer)var71_63;
            }
            var21_13 = ViewDataBinding.safeUnbox((Integer)var87_81);
            var99_92 = var2_2 & var23_15;
            var38_27 = 0L;
            cfr_temp_12 = var99_92 - var38_27;
            var101_93 /* !! */  = (long)(cfr_temp_12 == 0L ? 0 : (cfr_temp_12 < 0L ? -1 : 1));
            if (var101_93 /* !! */  != false) {
                if (!var21_13) {
                    var45_33 = true;
                    var46_34 = 1.4E-45f;
                } else {
                    var45_33 = false;
                    var46_34 = 0.0f;
                    var40_28 = null;
                }
                var95_89 = var2_2 & var32_22;
                var101_93 /* !! */  = var95_89 == var38_27 ? 0 : (var95_89 < var38_27 ? -1 : 1);
                if (var101_93 /* !! */  != false) {
                    if (var45_33) {
                        var102_94 = 1024L;
                        var2_2 |= var102_94;
                    } else {
                        var51_39 = 512L;
                        var2_2 |= var51_39;
                    }
                }
                if ((var104_95 = (cfr_temp_13 = (var23_15 = var2_2 & var23_15) - var38_27) == 0L ? 0 : (cfr_temp_13 < 0L ? -1 : 1)) != false) {
                    var23_15 = var45_33 != false ? 0x40000000L : 0x20000000L;
                    var2_2 |= var23_15;
                }
                if (var45_33) {
                    var6_4 = var1_1.l;
                    var51_39 = var2_2;
                    var105_96 = 2131099863 != 0;
                    var106_97 = 1.7812091E38f;
                } else {
                    var51_39 = var2_2;
                    var6_4 = var1_1.l;
                    var105_96 = 2131099772 != 0;
                    var106_97 = 1.7811907E38f;
                }
                var97_90 = ViewDataBinding.getColorFromResource((View)var6_4, (int)var105_96);
                var2_2 = var51_39;
            } else {
                var97_90 = false;
                var98_91 = 0.0f;
                var6_4 = null;
            }
            var17_11 = var2_2 & var17_11;
            var38_27 = 0L;
            var107_98 = var17_11 == var38_27 ? 0 : (var17_11 < var38_27 ? -1 : 1);
            var108_99 = var97_90;
            if (var107_98) {
                var97_90 = 3 != 0;
                var98_91 = 4.2E-45f;
                if (var21_13 == var97_90) {
                    var97_90 = true;
                    var98_91 = 1.4E-45f;
                } else {
                    var97_90 = false;
                    var98_91 = 0.0f;
                    var6_4 = null;
                }
                if (var107_98) {
                    var109_100 = var97_90 != false ? 16384L : 8192L;
                    var2_2 |= var109_100;
                }
                if (var107_98 = (boolean)((cfr_temp_14 = (var109_100 = var2_2 & var32_22) - (var38_27 = 0L)) == 0L ? 0 : (cfr_temp_14 < 0L ? -1 : 1))) {
                    var109_100 = var97_90 != false ? 0x10000000L : 0x8000000L;
                    var2_2 |= var109_100;
                }
                var107_98 = var97_90;
                var111_101 = var98_91;
                if (var97_90) {
                    var6_4 = var1_1.o;
                    var109_100 = var2_2;
                    var105_96 = 2131099863 != 0;
                    var106_97 = 1.7812091E38f;
                } else {
                    var109_100 = var2_2;
                    var6_4 = var1_1.o;
                    var105_96 = 2131099772 != 0;
                    var106_97 = 1.7811907E38f;
                }
                var97_90 = ViewDataBinding.getColorFromResource((View)var6_4, (int)var105_96);
                var2_2 = var109_100;
                var47_35 = var107_98;
                var48_36 = var111_101;
            } else {
                var97_90 = false;
                var98_91 = 0.0f;
                var6_4 = null;
            }
            var51_39 = var2_2 & var19_12;
            var38_27 = 0L;
            var107_98 = (boolean)(var51_39 == var38_27 ? 0 : (var51_39 < var38_27 ? -1 : 1));
            if (var107_98) {
                var107_98 = var97_90;
                var97_90 = 2 != 0;
                var98_91 = 2.8E-45f;
                if (var21_13 == var97_90) {
                    var97_90 = true;
                    var98_91 = 1.4E-45f;
                } else {
                    var97_90 = false;
                    var98_91 = 0.0f;
                    var6_4 = null;
                }
                var112_103 = var2_2 & var32_22;
                var114_104 = (boolean)(var112_103 == var38_27 ? 0 : (var112_103 < var38_27 ? -1 : 1));
                if (var114_104) {
                    var112_103 = var97_90 != false ? 0x100000L : 524288L;
                    var2_2 |= var112_103;
                }
                if ((var115_105 = (cfr_temp_15 = (var19_12 = var2_2 & var19_12) - var38_27) == 0L ? 0 : (cfr_temp_15 < 0L ? -1 : 1)) != false) {
                    var19_12 = var97_90 != false ? 0x1000000L : 0x800000L;
                    var2_2 |= var19_12;
                }
                var115_105 = (long)var97_90;
                var116_106 = var98_91;
                if (var97_90) {
                    var6_4 = var1_1.n;
                    var112_103 = var2_2;
                    var105_96 = 2131099863 != 0;
                    var106_97 = 1.7812091E38f;
                } else {
                    var112_103 = var2_2;
                    var6_4 = var1_1.n;
                    var105_96 = 2131099772 != 0;
                    var106_97 = 1.7811907E38f;
                }
                var97_90 = ViewDataBinding.getColorFromResource((View)var6_4, (int)var105_96);
                var2_2 = var112_103;
                var49_37 = var115_105;
                var50_38 = var116_106;
            } else {
                var107_98 = var97_90;
                var97_90 = false;
                var98_91 = 0.0f;
                var6_4 = null;
            }
            var15_10 = var2_2 & var15_10;
            var19_12 = 0L;
            var117_107 = (boolean)(var15_10 == var19_12 ? 0 : (var15_10 < var19_12 ? -1 : 1));
            var118_108 = var97_90;
            if (var117_107) {
                var97_90 = true;
                var98_91 = 1.4E-45f;
                if (var21_13 != var97_90) {
                    var97_90 = false;
                    var98_91 = 0.0f;
                    var6_4 = null;
                }
                if (var117_107) {
                    var19_12 = var97_90 != false ? 65536L : 32768L;
                    var2_2 |= var19_12;
                }
                if (var21_13 = (boolean)((cfr_temp_16 = (var19_12 = var2_2 & var32_22) - (var38_27 = 0L)) == 0L ? 0 : (cfr_temp_16 < 0L ? -1 : 1))) {
                    var19_12 = var97_90 != false ? 262144L : 131072L;
                    var2_2 |= var19_12;
                }
                if (var97_90) {
                    var71_63 = var1_1.m;
                    var117_107 = var97_90;
                    var119_109 = var98_91;
                    var98_91 = 1.7812091E38f;
                    var97_90 = ViewDataBinding.getColorFromResource((View)var71_63, 2131099863);
                } else {
                    var117_107 = var97_90;
                    var119_109 = var98_91;
                    var6_4 = var1_1.m;
                    var21_13 = 2131099772 != 0;
                    var22_14 = 1.7811907E38f;
                    var97_90 = ViewDataBinding.getColorFromResource((View)var6_4, (int)var21_13);
                }
                var19_12 = var2_2;
                var21_13 = var117_107;
                var22_14 = var119_109;
                var117_107 = var107_98;
                var120_110 = var45_33;
                var105_96 = var49_37;
                var106_97 = var50_38;
                var107_98 = var97_90;
                var97_90 = var47_35;
                var98_91 = var48_36;
            } else {
                var19_12 = var2_2;
                var117_107 = var107_98;
                var120_110 = var45_33;
                var97_90 = var47_35;
                var98_91 = var48_36;
                var105_96 = var49_37;
                var106_97 = var50_38;
                var21_13 = var93_87;
                var22_14 = var94_88;
                var107_98 = false;
                var111_101 = 0.0f;
            }
        } else {
            var30_20 = var22_14;
            var19_12 = var2_2;
            var120_110 = var45_33;
            var97_90 = var47_35;
            var98_91 = var48_36;
            var105_96 = var49_37;
            var106_97 = var50_38;
            var21_13 = var93_87;
            var22_14 = var94_88;
            var117_107 = false;
            var119_109 = 0.0f;
            var118_108 = false;
            var107_98 = false;
            var111_102 = 0.0f;
            var108_99 = false;
        }
        var23_15 = var19_12 & var27_18;
        var121_111 = 0L;
        var104_95 = var23_15 == var121_111 ? 0 : (var23_15 < var121_111 ? -1 : 1);
        var114_104 = var97_90;
        var123_112 = var98_91;
        if (var104_95 != false) {
            var97_90 = 2131099775 != 0;
            var98_91 = 1.7811913E38f;
            if (var44_32) {
                var43_31 = var1_1.o;
                var117_107 = var44_32 = ViewDataBinding.getColorFromResource((View)var43_31, (int)var97_90);
            }
            if (var10_7 /* !! */  != false) {
                var43_31 = var1_1.m;
                var107_98 = var44_32 = ViewDataBinding.getColorFromResource((View)var43_31, (int)var97_90);
            }
            if (var42_30) {
                var41_29 = var1_1.n;
                var118_108 = var42_30 = ViewDataBinding.getColorFromResource((View)var41_29, (int)var97_90);
            }
            if (var89_84) {
                var41_29 = var1_1.l;
                var97_90 = ViewDataBinding.getColorFromResource((View)var41_29, (int)var97_90);
            } else {
                var97_90 = var108_99;
            }
            var10_7 /* !! */  = (long)var117_107;
            var44_32 = var118_108;
            var42_30 = var107_98;
        } else {
            var97_90 = false;
            var98_91 = 0.0f;
            var6_4 = null;
            var42_30 = false;
            var41_29 = null;
            var44_32 = false;
            var43_31 = null;
            var10_7 /* !! */  = 0;
            var53_40 = 0.0f;
            var63_57 = null;
        }
        var15_10 = var19_12 & (long)96;
        var17_11 = 0L;
        var117_107 = (boolean)(var15_10 == var17_11 ? 0 : (var15_10 < var17_11 ? -1 : 1));
        if (var117_107) {
            var117_107 = var105_96;
            var119_109 = var106_97;
            var124_113 /* !! */  = var1_1.a;
            var124_113 /* !! */ .z(var7_5);
        } else {
            var117_107 = var105_96;
            var119_109 = var106_97;
        }
        var121_111 = var19_12 & (long)82;
        var105_96 = (boolean)(var121_111 == var17_11 ? 0 : (var121_111 < var17_11 ? -1 : 1));
        if (var105_96) {
            var124_113 /* !! */  = var1_1.b;
            var124_113 /* !! */ .setVisibility(var69_61);
        }
        if (var105_96 = (boolean)((cfr_temp_17 = (var76_69 = var19_12 & (long)84) - var17_11) == 0L ? 0 : (cfr_temp_17 < 0L ? -1 : 1))) {
            var124_113 /* !! */  = var1_1.c;
            var7_5 = var1_1.s;
            ViewBindingAdapter.setOnClick((View)var124_113 /* !! */ , (View.OnClickListener)var7_5, var34_23);
            var124_113 /* !! */  = var1_1.d;
            var7_5 = var1_1.r;
            ViewBindingAdapter.setOnClick((View)var124_113 /* !! */ , (View.OnClickListener)var7_5, var54_41);
            var124_113 /* !! */  = var1_1.e;
            var7_5 = var1_1.q;
            ViewBindingAdapter.setOnClick((View)var124_113 /* !! */ , (View.OnClickListener)var7_5, var36_25);
            var124_113 /* !! */  = var1_1.f;
            var7_5 = var1_1.p;
            ViewBindingAdapter.setOnClick((View)var124_113 /* !! */ , (View.OnClickListener)var7_5, var66_59);
        }
        if (var104_95 != false) {
            var124_113 /* !! */  = var1_1.l;
            var124_113 /* !! */ .setTextColor((int)var97_90);
            var1_1.m.setTextColor((int)var42_30);
            var1_1.n.setTextColor((int)var44_32);
            var6_4 = var1_1.o;
            var6_4.setTextColor((int)var10_7 /* !! */ );
        }
        if (var97_90 = (boolean)((cfr_temp_18 = (var4_3 = var19_12 & var32_22) - (var125_114 = 0L)) == 0L ? 0 : (cfr_temp_18 < 0L ? -1 : 1))) {
            TextViewBindingAdapter.setTextSize((TextView)var1_1.l, var26_17);
            d.v.f.e.b.a((TextView)var1_1.l, var120_110);
            TextViewBindingAdapter.setTextSize((TextView)var1_1.m, var61_54);
            d.v.f.e.b.a((TextView)var1_1.m, var21_13);
            var6_4 = var1_1.n;
            var61_54 = var30_20;
            TextViewBindingAdapter.setTextSize((TextView)var6_4, var30_20);
            var6_4 = var1_1.n;
            var105_96 = var117_107;
            var106_97 = var119_109;
            d.v.f.e.b.a((TextView)var6_4, var117_107);
            var6_4 = var1_1.o;
            var59_50 = var84_78;
            TextViewBindingAdapter.setTextSize((TextView)var6_4, var84_78);
            var6_4 = var1_1.o;
            var105_96 = var114_104;
            var106_97 = var123_112;
            d.v.f.e.b.a((TextView)var6_4, var114_104);
        }
        if (var97_90 = (cfr_temp_19 = (var2_2 = var19_12 & (long)64) - (var4_3 = 0L)) == 0L ? 0 : (cfr_temp_19 < 0L ? -1 : 1)) {
            var6_4 = var1_1.h;
            var106_97 = 1.7812085E38f;
            var105_96 = ViewDataBinding.getColorFromResource((View)var6_4, 2131099860);
            var6_4.setBackgroundColor((int)var105_96);
            var6_4 = var1_1.h;
            var124_113 /* !! */  = var6_4.getContext();
            var120_110 = 2131231805 != 0;
            var124_113 /* !! */  = AppCompatResources.getDrawable((Context)var124_113 /* !! */ , (int)var120_110);
            var6_4.setErrorImage((Drawable)var124_113 /* !! */ );
            var1_1.h.setErrorText("@string/request_error");
            var6_4 = var1_1.h;
            var124_113 /* !! */  = var1_1.t;
            var6_4.setOnClickErrorListener((View.OnClickListener)var124_113 /* !! */ );
        }
        ViewDataBinding.executeBindingsOn(var1_1.a);
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
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            j4 j42 = this.a;
            l12 = (long)j42.hasPendingBindings();
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
            this.u = l10 = (long)64;
        }
        this.a.invalidateAll();
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
                    object = (j4)object;
                    return this.C((j4)object, n11);
                }
                object = (MutableLiveData)object;
                return this.D((MutableLiveData)object, n11);
            }
            object = (MediatorLiveData)object;
            return this.E((MediatorLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.F((MutableLiveData)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.a.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 144;
        if (n11 == n10) {
            object = (o)object;
            this.B((o)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 != n10) return 0 != 0;
            object = (EditorTransitionFragment$a)object;
            this.A((EditorTransitionFragment$a)object);
        }
        return 1 != 0;
    }
}

