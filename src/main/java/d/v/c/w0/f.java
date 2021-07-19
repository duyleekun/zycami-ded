/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import d.v.c.p0.n.j;
import d.v.c.w0.e;
import d.v.c.w0.v2;
import l.a.q.g0.u;

public class f
extends e {
    private static final ViewDataBinding$IncludedLayouts p;
    private static final SparseIntArray q;
    private final LinearLayout n;
    private long o;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        p = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(13);
        String[] stringArray = new String[]{"community_titlebar"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 7;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558491;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        q = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131362032, 8);
        viewDataBinding$IncludedLayouts.put(2131362027, 9);
        viewDataBinding$IncludedLayouts.put(2131362026, 10);
        viewDataBinding$IncludedLayouts.put(2131362028, 11);
        viewDataBinding$IncludedLayouts.put(2131362029, 12);
    }

    public f(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = p;
        SparseIntArray sparseIntArray = q;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 13, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private f(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[6];
        object2 = (RecyclerView)object;
        Object object3 = object = objectArray[3];
        object3 = (TextView)object;
        Object object4 = object = objectArray[10];
        object4 = (TextView)object;
        Object object5 = object = objectArray[9];
        object5 = (TextView)object;
        Object object6 = object = objectArray[11];
        object6 = (TextView)object;
        Object object7 = object = objectArray[12];
        object7 = (TextView)object;
        Object object8 = object = objectArray[5];
        object8 = (TextView)object;
        Object object9 = object = objectArray[2];
        object9 = (TextView)object;
        Object object10 = object = objectArray[8];
        object10 = (TextView)object;
        Object object11 = object = objectArray[4];
        object11 = (View)object;
        Object object12 = object = objectArray[7];
        object12 = (v2)object;
        Object object13 = object = objectArray[1];
        object13 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 5, (RecyclerView)object2, (TextView)object3, (TextView)object4, (TextView)object5, (TextView)object6, (TextView)object7, (TextView)object8, (TextView)object9, (TextView)object10, (View)object11, (v2)object12, (TextView)object13);
        this.o = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.j.setTag(null);
        object = (LinearLayout)objectArray[0];
        this.n = object;
        object.setTag(null);
        object = this.k;
        this.setContainedBinding((ViewDataBinding)object);
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
    private boolean A(v2 v22, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.o;
                long l11 = 2;
                this.o = l10 |= l11;
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
    private boolean B(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.o;
                long l11 = 1L;
                this.o = l10 |= l11;
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
    private boolean C(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.o;
                long l11 = 16;
                this.o = l10 |= l11;
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
                long l10 = this.o;
                long l11 = 4;
                this.o = l10 |= l11;
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
                long l10 = this.o;
                long l11 = 8;
                this.o = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block30: {
            block29: {
                var1_1 = this;
                synchronized (this) {
                    var2_2 = this.o;
                    this.o = var4_3 = 0L;
                }
                var6_4 = this.m;
                var7_5 = (long)125 & var2_2;
                var9_6 /* !! */  = var7_5 == var4_3 ? 0 : (var7_5 < var4_3 ? -1 : 1);
                var10_7 = 104;
                var12_8 = 97;
                var14_9 = 100;
                var16_10 = 0;
                var17_11 = 0.0f;
                var18_12 = null;
                if (var9_6 /* !! */  == false) break block29;
                var19_13 = var2_2 & var12_8;
                cfr_temp_0 = var19_13 - var4_3;
                var9_6 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                if (var9_6 /* !! */  == false) ** GOTO lbl-1000
                if (var6_4 != null) {
                    var21_14 = var6_4.c();
                } else {
                    var9_6 /* !! */  = 0;
                    var21_14 = null;
                }
                var1_1.updateLiveDataRegistration(0, (LiveData)var21_14);
                if (var21_14 != null) {
                    var21_14 = (String)var21_14.getValue();
                } else lbl-1000:
                // 2 sources

                {
                    var9_6 /* !! */  = 0;
                    var21_14 = null;
                }
                var19_13 = var2_2 & var14_9;
                var22_15 = var19_13 == var4_3 ? 0 : (var19_13 < var4_3 ? -1 : 1);
                var23_16 = 8;
                var24_17 = 1.1E-44f;
                if (var22_15 == false) ** GOTO lbl-1000
                if (var6_4 != null) {
                    var18_12 = var25_18 = var6_4.l();
                } else {
                    var16_10 = 0;
                    var17_11 = 0.0f;
                    var18_12 = null;
                }
                var26_19 = 2;
                var27_20 = 2.8E-45f;
                var1_1.updateLiveDataRegistration(var26_19, var18_12);
                if (var18_12 != null) {
                    var28_22 = (Boolean)var18_12.getValue();
                } else {
                    var26_19 = 0;
                    var27_20 = 0.0f;
                    var28_22 = null;
                }
                var26_19 = (int)ViewDataBinding.safeUnbox(var28_22);
                if (var22_15 != false) {
                    var29_24 = var26_19 != 0 ? 256L : 128L;
                    var2_2 |= var29_24;
                }
                if (var26_19 == 0) {
                    var26_19 = var23_16;
                    var27_20 = var24_17;
                } else lbl-1000:
                // 2 sources

                {
                    var26_19 = 0;
                    var27_20 = 0.0f;
                    var28_22 = null;
                }
                var29_24 = var2_2 & var10_7;
                var22_15 = var29_24 == var4_3 ? 0 : (var29_24 < var4_3 ? -1 : 1);
                if (var22_15 != false) {
                    if (var6_4 != null) {
                        var18_12 = var6_4.m();
                    } else {
                        var16_10 = 0;
                        var17_11 = 0.0f;
                        var18_12 = null;
                    }
                    var31_25 = 3;
                    var1_1.updateLiveDataRegistration(var31_25, var18_12);
                    if (var18_12 != null) {
                        var32_26 = (Boolean)var18_12.getValue();
                    } else {
                        var31_25 = 0;
                        var32_26 = null;
                    }
                    var31_25 = (int)ViewDataBinding.safeUnbox(var32_26);
                    if (var22_15 != false) {
                        var33_27 = var31_25 != 0 ? 1024L : 512L;
                        var2_2 |= var33_27;
                    }
                    if (var31_25 != 0) {
                        var16_10 = 0;
                        var17_11 = 0.0f;
                        var18_12 = null;
                    } else {
                        var16_10 = var23_16;
                        var17_11 = var24_17;
                    }
                    var35_28 = 112;
                } else {
                    var35_28 = 112;
                    var16_10 = 0;
                    var17_11 = 0.0f;
                    var18_12 = null;
                }
                var19_13 = var2_2 & var35_28;
                var22_15 = var19_13 == var4_3 ? 0 : (var19_13 < var4_3 ? -1 : 1);
                if (var22_15 == false) ** GOTO lbl-1000
                var6_4 = var6_4 != null ? var6_4.i() : null;
                var22_15 = 4;
                var1_1.updateLiveDataRegistration((int)var22_15, (LiveData)var6_4);
                if (var6_4 != null) {
                    var6_4 = (String)var6_4.getValue();
                } else lbl-1000:
                // 2 sources

                {
                    var6_4 = null;
                }
                var37_29 = var16_10;
                var38_30 = var17_11;
                var16_10 = var26_19;
                var17_11 = var27_20;
                var26_19 = var37_29;
                var27_20 = var38_30;
                break block30;
            }
            var6_4 = null;
            var9_6 /* !! */  = 0;
            var21_14 = null;
            var26_19 = 0;
            var27_21 = 0.0f;
            var28_23 = null;
            var16_10 = 0;
            var17_11 = 0.0f;
            var18_12 = null;
        }
        var35_28 = var2_2 & var14_9;
        var22_15 = var35_28 == var4_3 ? 0 : (var35_28 < var4_3 ? -1 : 1);
        if (var22_15 != false) {
            var1_1.a.setVisibility(var16_10);
            var1_1.g.setVisibility(var16_10);
            var39_31 = var1_1.j;
            var39_31.setVisibility(var16_10);
        }
        if ((var22_15 = (cfr_temp_1 = (var35_28 = var2_2 & var12_8) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
            var39_31 = var1_1.b;
            var31_25 = 0;
            var32_26 = null;
            u.n((TextView)var39_31, (String)var21_14, null, null);
        }
        if ((var9_6 /* !! */  = (cfr_temp_2 = (var35_28 = (long)104 & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
            var1_1.h.setVisibility(var26_19);
            var21_14 = var1_1.l;
            var21_14.setVisibility(var26_19);
        }
        if ((var40_32 = (cfr_temp_3 = (var2_2 &= (var7_5 = (long)112)) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) {
            var41_33 = var1_1.h;
            u.n(var41_33, (String)var6_4, null, null);
        }
        ViewDataBinding.executeBindingsOn(var1_1.k);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.o;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            v2 v22 = this.k;
            l12 = (long)v22.hasPendingBindings();
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
            this.o = l10 = (long)64;
        }
        this.k.invalidateAll();
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
                        return this.C((MutableLiveData)object, n11);
                    }
                    object = (MutableLiveData)object;
                    return this.E((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.D((MutableLiveData)object, n11);
            }
            object = (v2)object;
            return this.A((v2)object, n11);
        }
        object = (MutableLiveData)object;
        return this.B((MutableLiveData)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.k.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 152;
        if (n11 == n10) {
            object = (j)object;
            this.z((j)object);
            n10 = 1;
        } else {
            n10 = 0;
        }
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void z(j j10) {
        this.m = j10;
        synchronized (this) {
            long l10 = this.o;
            long l11 = 32;
            this.o = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }
}

