/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import com.zhiyun.cama.widget.RoundImageView;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.f1.a.b$a;
import d.v.c.w0.oc;
import d.v.e.l.l2;
import d.v.l.g.a;
import l.a.q.g0.u;

public class pc
extends oc
implements b$a {
    private static final ViewDataBinding$IncludedLayouts j;
    private static final SparseIntArray k;
    private final ConstraintLayout e;
    private final View f;
    private final ZYTextView g;
    private final View.OnClickListener h;
    private long i;

    public pc(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = j;
        SparseIntArray sparseIntArray = k;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private pc(DataBindingComponent object, View view, Object[] objectArray) {
        int n10 = 1;
        RoundImageView roundImageView = (RoundImageView)objectArray[n10];
        int n11 = 2;
        super(object, view, n11, roundImageView);
        this.i = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.e = object;
        object.setTag(null);
        object = (View)objectArray[n11];
        this.f = object;
        object.setTag(null);
        object = (ZYTextView)objectArray[3];
        this.g = object;
        object.setTag(null);
        this.setRootTag(view);
        super(this, n10);
        this.h = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.i;
                long l11 = 2;
                this.i = l10 |= l11;
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
                long l10 = this.i;
                long l11 = 1L;
                this.i = l10 |= l11;
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
    public void B(d.v.h.e.a a10) {
        this.c = a10;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 8;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(83);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(Integer n10) {
        this.b = n10;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 4;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(101);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(TemplateEditViewModel templateEditViewModel) {
        this.d = templateEditViewModel;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 16;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(153);
        super.requestRebind();
    }

    public final void a(int n10, View object) {
        d.v.h.e.a a10 = this.c;
        object = this.b;
        TemplateEditViewModel templateEditViewModel = this.d;
        int n11 = 1;
        int n12 = templateEditViewModel != null ? n11 : 0;
        if (n12 != 0) {
            n12 = templateEditViewModel.e0();
            int n13 = (Integer)object;
            if (n13 != n12) {
                n11 = 0;
            }
            if (n11 == 0) {
                int n14 = (Integer)object;
                templateEditViewModel.x0(n14, a10);
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
        block40: {
            block41: {
                var1_1 = this;
                synchronized (this) {
                    var2_2 = this.i;
                    this.i = var4_3 = 0L;
                }
                var6_4 /* !! */  = this.b;
                var7_5 = this.c;
                var8_6 = this.d;
                var9_7 = 53;
                var11_8 = var2_2 & var9_7;
                var13_9 = var11_8 == var4_3 ? 0 : (var11_8 < var4_3 ? -1 : 1);
                var14_10 = 40;
                var16_11 = var2_2 & var14_10;
                var18_12 = var16_11 == var4_3 ? 0 : (var16_11 < var4_3 ? -1 : 1);
                var19_13 = 1;
                var20_14 = 1.4E-45f;
                if (var18_12 != false) {
                    if (var7_5 != null) {
                        var21_15 = var7_5.e();
                        var9_7 = var22_16 = var7_5.d();
                    } else {
                        var9_7 = var4_3;
                        var18_12 = 0;
                        var21_15 = null;
                    }
                    var7_5 = String.valueOf(l2.a(var9_7, var19_13));
                    var24_17 = new StringBuilder();
                    var24_17.append((String)var7_5);
                    var25_18 = 83;
                    var24_17.append((char)var25_18);
                    var7_5 = var24_17.toString();
                    var26_19 = var21_15;
                } else {
                    var25_18 = 0;
                    var7_5 = null;
                    var26_19 = null;
                }
                var9_7 = 55;
                cfr_temp_0 = (var2_2 & var9_7) - var4_3;
                var18_12 = cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
                var27_20 = 8192L;
                var29_21 = 0;
                var30_22 = 0.0f;
                if (var18_12 == false) break block41;
                if (var8_6 != null) {
                    var21_15 = var8_6.d0();
                } else {
                    var18_12 = 0;
                    var21_15 = null;
                }
                var1_1.updateLiveDataRegistration(0, (LiveData)var21_15);
                if (var21_15 != null) {
                    var21_15 = (Integer)var21_15.getValue();
                } else {
                    var18_12 = 0;
                    var21_15 = null;
                }
                if (var13_9 == false) ** GOTO lbl-1000
                var31_23 = var6_4 /* !! */  == var21_15 ? var19_13 : 0;
                if (var13_9 != false) {
                    var32_24 = var31_23 != 0 ? 128L : (long)64;
                    var2_2 |= var32_24;
                }
                if (!var31_23) {
                    var13_9 = 8;
                } else lbl-1000:
                // 2 sources

                {
                    var13_9 = 0;
                }
                var18_12 = ViewDataBinding.safeUnbox((Integer)var21_15);
                var29_21 = -1;
                var30_22 = 0.0f / 0.0f;
                if (var18_12 == var29_21) {
                    var18_12 = var19_13;
                } else {
                    var18_12 = 0;
                    var21_15 = null;
                }
                var32_24 = var2_2 & var9_7;
                var29_21 = (int)(var32_24 == var4_3 ? 0 : (var32_24 < var4_3 ? -1 : 1));
                if (var29_21) {
                    if (var18_12 != false) {
                        var2_2 |= var27_20;
                        break block40;
                    } else {
                        var32_24 = 4096L;
                        var2_2 |= var32_24;
                    }
                }
                break block40;
            }
            var13_9 = 0;
            var18_12 = 0;
            var21_15 = null;
        }
        if (!(var29_21 = (cfr_temp_1 = (var27_20 = var2_2 & var27_20) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) ** GOTO lbl-1000
        if (var8_6 != null) {
            var8_6 = var8_6.I();
        } else {
            var34_25 = 0;
            var35_26 = 0.0f;
            var8_6 = null;
        }
        var1_1.updateLiveDataRegistration(var19_13, (LiveData)var8_6);
        if (var8_6 != null) {
            var8_6 = (Integer)var8_6.getValue();
        } else {
            var34_25 = 0;
            var35_26 = 0.0f;
            var8_6 = null;
        }
        if (var8_6 != var6_4 /* !! */ ) {
            var36_27 = var19_13;
            var37_28 = var20_14;
        } else lbl-1000:
        // 2 sources

        {
            var36_27 = 0;
            var37_28 = 0.0f;
            var6_4 /* !! */  = null;
        }
        var27_20 = var2_2 & var9_7;
        var34_25 = var27_20 == var4_3 ? 0 : (var27_20 < var4_3 ? -1 : 1);
        var29_21 = 0;
        var30_22 = 0.0f;
        if (var34_25) {
            if (var18_12 != false) {
                var29_21 = var36_27;
                var30_22 = var37_28;
            } else {
                var29_21 = 0;
                var30_22 = 0.0f;
            }
            if (var34_25) {
                if (var29_21) {
                    var2_2 |= 512L;
                    var27_20 = 2048L;
                } else {
                    var2_2 |= 256L;
                    var27_20 = 1024L;
                }
                var2_2 |= var27_20;
            }
            var36_27 = 1065353216;
            var37_28 = 1.0f;
            if (var29_21) {
                var34_25 = 1045220557;
                var35_26 = 0.2f;
            } else {
                var34_25 = var36_27;
                var35_26 = var37_28;
            }
            if (var29_21) {
                var36_27 = 1050253722;
                var37_28 = 0.3f;
            }
            var29_21 = var36_27;
            var30_22 = var37_28;
        } else {
            var34_25 = 0;
            var8_6 = null;
            var35_26 = 0.0f;
        }
        var36_27 = (int)((cfr_temp_2 = (var9_7 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
        if (var36_27 && (var36_27 = ViewDataBinding.getBuildSdkInt()) >= (var38_29 = 11)) {
            var1_1.a.setAlpha(var30_22);
            var6_4 /* !! */  = var1_1.g;
            var6_4 /* !! */ .setAlpha(var35_26);
        }
        if (var36_27 = (int)((cfr_temp_3 = (var39_30 = var2_2 & var14_10) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) {
            var6_4 /* !! */  = var1_1.a;
            var8_6 = var6_4 /* !! */ .getContext();
            var38_29 = 2131232077;
            var41_31 = AppCompatResources.getDrawable((Context)var8_6, var38_29);
            var42_32 = true;
            d.v.l.g.a.b((ImageView)var6_4 /* !! */ , var26_19, null, var41_31, 0, var42_32, false, null, null, null);
            var6_4 /* !! */  = var1_1.g;
            var34_25 = 0;
            var35_26 = 0.0f;
            var8_6 = null;
            u.n((TextView)var6_4 /* !! */ , (String)var7_5, null, null);
        }
        if (var36_27 = (int)((cfr_temp_4 = (var43_33 = (long)32 & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) {
            var6_4 /* !! */  = var1_1.e;
            var7_5 = var1_1.h;
            var6_4 /* !! */ .setOnClickListener((View.OnClickListener)var7_5);
            var36_27 = ViewDataBinding.getBuildSdkInt();
            var25_18 = 21;
            if (var36_27 >= var25_18) {
                var6_4 /* !! */  = var1_1.e;
                var6_4 /* !! */ .setClipToOutline((boolean)var19_13);
            }
        }
        if (var36_27 = (int)((cfr_temp_5 = (var2_2 &= (var43_33 = (long)53)) - var4_3) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) {
            var6_4 /* !! */  = var1_1.f;
            var6_4 /* !! */ .setVisibility((int)var13_9);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.i;
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
            this.i = l10 = (long)32;
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
            return this.E((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.F((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 101;
        if (n11 == n10) {
            object = (Integer)object;
            this.C((Integer)object);
            return 1 != 0;
        } else {
            n11 = 83;
            if (n11 == n10) {
                object = (d.v.h.e.a)object;
                this.B((d.v.h.e.a)object);
                return 1 != 0;
            } else {
                n11 = 153;
                if (n11 != n10) return 0 != 0;
                object = (TemplateEditViewModel)object;
                this.D((TemplateEditViewModel)object);
            }
        }
        return 1 != 0;
    }
}

