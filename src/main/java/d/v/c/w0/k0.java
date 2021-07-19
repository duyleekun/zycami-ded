/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.zhiyun.cama.camera.data.BeautyData;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.a7.v0$c;
import d.v.c.w0.j0;
import l.a.q.g0.u;

public class k0
extends j0
implements b$a {
    private static final ViewDataBinding$IncludedLayouts j;
    private static final SparseIntArray k;
    private final LinearLayout g;
    private final View.OnClickListener h;
    private long i;

    public k0(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = j;
        SparseIntArray sparseIntArray = k;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private k0(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        int n10 = 1;
        Object object3 = object2 = objectArray[n10];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[2];
        object4 = (TextView)object2;
        super(object, view, 0, (ImageView)object3, (TextView)object4);
        this.i = -1;
        this.a.setTag(null);
        object = (LinearLayout)objectArray[0];
        this.g = object;
        object.setTag(null);
        this.b.setTag(null);
        this.setRootTag(view);
        object = new b(this, n10);
        this.h = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(BeautyData beautyData) {
        this.d = beautyData;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 2;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(7);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(v0$c v0$c) {
        this.e = v0$c;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 4;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(int n10) {
        this.c = n10;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 1L;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(69);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(boolean bl2) {
        this.f = bl2;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 8;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(118);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        BeautyData beautyData = this.d;
        int n11 = this.c;
        v0$c v0$c = this.e;
        boolean bl2 = v0$c != null;
        if (bl2) {
            v0$c.a(n11, beautyData);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        synchronized (this) {
            var1_1 = this.i;
            this.i = var3_2 = 0L;
        }
        var5_3 = this.d;
        var6_4 = this.f;
        var7_5 = 18;
        var9_6 = var1_1 & var7_5;
        var11_7 = var9_6 == var3_2 ? 0 : (var9_6 < var3_2 ? -1 : 1);
        var12_8 = 0;
        var13_9 = null;
        if (var11_7 != false) {
            if (var5_3 != null) {
                var5_3 = var5_3.getBeauty();
            } else {
                var14_10 = 0;
                var5_3 = null;
            }
            if (var5_3 != null) {
                var11_7 = var5_3.getStringRes();
                var14_10 = var5_3.getDrawableRes();
            } else {
                var14_10 = 0;
                var5_3 = null;
                var11_7 = 0;
            }
            var15_12 = this.getRoot().getContext();
            var5_3 = ContextCompat.getDrawable(var15_12, var14_10);
        } else {
            var11_7 = 0;
            var14_11 = false;
            var5_3 = null;
        }
        var16_13 = 24;
        var18_14 = var1_1 & var16_13;
        var20_15 = var18_14 == var3_2 ? 0 : (var18_14 < var3_2 ? -1 : 1);
        if (var20_15 == false) ** GOTO lbl-1000
        if (var20_15 != false) {
            if (var6_4) {
                var1_1 |= (long)64;
                var18_14 = 256L;
            } else {
                var1_1 |= (long)32;
                var18_14 = 128L;
            }
            var1_1 |= var18_14;
        }
        var13_9 = this.b;
        var20_15 = var6_4 != false ? (long)2131099772 : (long)2131099784;
        var12_8 = ViewDataBinding.getColorFromResource((View)var13_9, (int)var20_15);
        if (var6_4) {
            var21_16 = this.a.getContext();
            var20_15 = 2131232045;
            var21_16 = AppCompatResources.getDrawable(var21_16, (int)var20_15);
        } else lbl-1000:
        // 2 sources

        {
            var6_4 = false;
            var21_16 = null;
        }
        var22_17 = (cfr_temp_0 = (var16_13 &= var1_1) - var3_2) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
        if (var22_17 != false) {
            var15_12 = this.a;
            ViewBindingAdapter.setBackground((View)var15_12, (Drawable)var21_16);
            var21_16 = this.b;
            var21_16.setTextColor(var12_8);
        }
        if (var6_4 = (cfr_temp_1 = (var23_18 = var1_1 & var7_5) - var3_2) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) {
            var21_16 = this.a;
            ImageViewBindingAdapter.setImageDrawable((ImageView)var21_16, (Drawable)var5_3);
            var5_3 = this.b;
            u.k((TextView)var5_3, (int)var11_7, null, null);
        }
        if ((var27_20 = (cfr_temp_2 = (var1_1 &= (var25_19 = (long)16)) - var3_2) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
            var28_21 = this.g;
            var29_22 = this.h;
            var28_21.setOnClickListener(var29_22);
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
            this.i = l10 = (long)16;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 69;
        if (n11 == n10) {
            object = (Integer)object;
            n10 = (Integer)object;
            this.E(n10);
            return 1 != 0;
        } else {
            n11 = 7;
            if (n11 == n10) {
                object = (BeautyData)object;
                this.C((BeautyData)object);
                return 1 != 0;
            } else {
                n11 = 23;
                if (n11 == n10) {
                    object = (v0$c)object;
                    this.D((v0$c)object);
                    return 1 != 0;
                } else {
                    n11 = 118;
                    if (n11 != n10) return 0 != 0;
                    object = (Boolean)object;
                    n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                    this.F(n10 != 0);
                }
            }
        }
        return 1 != 0;
    }
}

