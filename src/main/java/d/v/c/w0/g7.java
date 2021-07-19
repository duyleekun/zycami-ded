/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import d.v.c.w0.f7;
import d.v.c.w0.g7$a;
import d.v.c.w0.g7$b;
import d.v.c.w0.g7$c;
import d.v.c.y1.f.x.g0$a;
import d.v.c.y1.f.x.l0;
import l.a.q.g0.u;

public class g7
extends f7 {
    private static final ViewDataBinding$IncludedLayouts l;
    private static final SparseIntArray m;
    private final ConstraintLayout g;
    private g7$c h;
    private g7$a i;
    private g7$b j;
    private long k;

    static {
        SparseIntArray sparseIntArray;
        m = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363146, 4);
    }

    public g7(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = l;
        SparseIntArray sparseIntArray = m;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private g7(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[1];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[4];
        object4 = (RecyclerView)object2;
        Object object5 = object2 = objectArray[3];
        object5 = (TextView)object2;
        Object object6 = object2 = objectArray[2];
        object6 = (TextView)object2;
        super(object, view, 2, (ImageView)object3, (RecyclerView)object4, (TextView)object5, (TextView)object6);
        this.k = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.g = object;
        object.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
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
                long l10 = this.k;
                long l11 = 2;
                this.k = l10 |= l11;
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
    private boolean D(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.k;
                long l11 = 1L;
                this.k = l10 |= l11;
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
    public void A(g0$a g0$a) {
        this.e = g0$a;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 8;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(l0 l02) {
        this.f = l02;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 4;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(113);
        super.requestRebind();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block30: {
            block32: {
                var1_1 = this;
                synchronized (this) {
                    var2_2 = this.k;
                    this.k = var4_3 = 0L;
                }
                var6_4 = this.f;
                var7_5 = this.e;
                var8_6 = (long)31 & var2_2;
                var10_7 /* !! */  = var8_6 == var4_3 ? 0 : (var8_6 < var4_3 ? -1 : 1);
                var11_8 = 22;
                var13_9 = 29;
                var15_10 = false;
                var16_11 = null;
                var17_12 = 21;
                if (var10_7 /* !! */  == false) break block32;
                var19_13 = var2_2 & var13_9;
                cfr_temp_0 = var19_13 - var4_3;
                var10_7 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                if (var10_7 /* !! */  == false) ** GOTO lbl45
                if (var6_4 != null) {
                    var21_14 = var6_4.d();
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
                var19_13 = var2_2 & var17_12;
                var15_10 = var19_13 == var4_3 ? 0 : (var19_13 < var4_3 ? -1 : 1);
                if (var15_10) {
                    var19_13 = var10_7 /* !! */  != false ? 256L : 128L;
                    var2_2 |= var19_13;
                }
                if (var15_10 = (cfr_temp_1 = (var19_13 = var2_2 & var17_12) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) {
                    var16_11 = var1_1.c.getContext();
                    var22_15 = var10_7 /* !! */  != false ? (long)2131231041 : (long)2131231192;
                    var16_11 = AppCompatResources.getDrawable(var16_11, (int)var22_15);
                    var15_10 = var10_7 /* !! */ ;
                    var21_14 = var16_11;
                } else {
                    var15_10 = var10_7 /* !! */ ;
lbl45:
                    // 2 sources

                    var10_7 /* !! */  = 0;
                    var21_14 = null;
                }
                var23_16 = var2_2 & var11_8;
                var22_15 = var23_16 == var4_3 ? 0 : (var23_16 < var4_3 ? -1 : 1);
                if (var22_15 != false) {
                    if (var6_4 != null) {
                        var6_4 = var6_4.b();
                    } else {
                        var25_17 = false;
                        var6_4 = null;
                    }
                    var26_20 = 1;
                    var1_1.updateLiveDataRegistration((int)var26_20, (LiveData)var6_4);
                    if (var6_4 != null) {
                        var6_4 = (Boolean)var6_4.getValue();
                    } else {
                        var25_17 = false;
                        var6_4 = null;
                    }
                    var25_17 = ViewDataBinding.safeUnbox((Boolean)var6_4);
                    if (var22_15 != false) {
                        var11_8 = var25_17 != false ? (long)64 : (long)32;
                        var2_2 |= var11_8;
                    }
                    var6_4 = var25_17 ? "@string/edit_cancel_select" : "@string/edit_selected_all";
                    break block30;
                } else {
                    var25_18 = false;
                    var6_4 = null;
                }
                break block30;
            }
            var25_19 = false;
            var6_4 = null;
            var10_7 /* !! */  = 0;
            var21_14 = null;
        }
        var11_8 = var2_2 & var13_9;
        var26_20 = var11_8 == var4_3 ? 0 : (var11_8 < var4_3 ? -1 : 1);
        var27_21 = 24;
        if (var26_20 != false) {
            var29_22 = var2_2 & var27_21;
            cfr_temp_2 = var29_22 - var4_3;
            var31_23 /* !! */  = (long)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
            if (var31_23 /* !! */  != false && var7_5 != null) {
                var32_25 = var1_1.h;
                if (var32_25 == null) {
                    var1_1.h = var32_25 = new g7$c();
                }
                var32_25 = var32_25.b((g0$a)var7_5);
                var33_26 = var1_1.i;
                if (var33_26 == null) {
                    var1_1.i = var33_26 = new g7$a();
                }
                var33_26 = var33_26.b((g0$a)var7_5);
            } else {
                var31_23 /* !! */  = 0;
                var32_25 = null;
                var22_15 = 0;
                var33_26 = null;
            }
            if (var7_5 != null) {
                var34_27 = var1_1.j;
                if (var34_27 == null) {
                    var1_1.j = var34_27 = new g7$b();
                }
                var7_5 = var34_27.b((g0$a)var7_5);
            } else {
                var7_5 = null;
            }
        } else {
            var7_5 = null;
            var31_24 = false;
            var32_25 = null;
            var22_15 = 0;
            var33_26 = null;
        }
        var35_28 = (cfr_temp_3 = (var27_21 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1);
        if (var35_28 != false) {
            var1_1.a.setOnClickListener((View.OnClickListener)var32_25);
            var36_29 = var1_1.d;
            var36_29.setOnClickListener((View.OnClickListener)var33_26);
        }
        if ((var35_28 = (cfr_temp_4 = (var27_21 = (long)21 & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) != false) {
            var36_29 = var1_1.c;
            TextViewBindingAdapter.setDrawableTop(var36_29, (Drawable)var21_14);
        }
        if (var26_20 != false) {
            var21_14 = var1_1.c;
            ViewBindingAdapter.setOnClick((View)var21_14, (View.OnClickListener)var7_5, var15_10);
        }
        if ((var39_31 = (cfr_temp_5 = (var2_2 &= (var37_30 = (long)22)) - var4_3) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1)) != false) {
            var40_32 = var1_1.d;
            u.n(var40_32, (String)var6_4, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.k;
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
            this.k = l10 = (long)16;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                return false;
            }
            object = (MutableLiveData)object;
            return this.C((MutableLiveData)object, n11);
        }
        object = (LiveData)object;
        return this.D((LiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 113;
        if (n11 == n10) {
            object = (l0)object;
            this.B((l0)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 != n10) return 0 != 0;
            object = (g0$a)object;
            this.A((g0$a)object);
        }
        return 1 != 0;
    }
}

