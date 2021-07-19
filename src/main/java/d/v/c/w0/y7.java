/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.ImageButton
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import com.zhiyun.cama.template.PlayLayout;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.f1.a.b$a;
import d.v.c.f1.a.f$a;
import d.v.c.u1.l.l$c;
import d.v.c.u1.l.m;
import d.v.c.w0.x7;
import d.v.f.e.c;
import d.v.f.f.d;
import d.v.j.f.g;
import l.a.q.g0.u;

public class y7
extends x7
implements b$a,
f$a {
    private static final ViewDataBinding$IncludedLayouts y;
    private static final SparseIntArray z;
    private final ConstraintLayout s;
    private final View.OnClickListener t;
    private final View.OnClickListener u;
    private final View.OnClickListener v;
    private final d w;
    private long x;

    static {
        SparseIntArray sparseIntArray;
        z = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362172, 9);
        sparseIntArray.put(2131362188, 10);
        sparseIntArray.put(2131363609, 11);
        sparseIntArray.put(2131363610, 12);
        sparseIntArray.put(2131363611, 13);
        sparseIntArray.put(2131362247, 14);
        sparseIntArray.put(2131363599, 15);
    }

    public y7(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = y;
        SparseIntArray sparseIntArray = z;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 16, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private y7(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object = this;
        FrameLayout frameLayout = (FrameLayout)objectArray[8];
        ConstraintLayout constraintLayout = (ConstraintLayout)((Object)objectArray[9]);
        ConstraintLayout constraintLayout2 = (ConstraintLayout)((Object)objectArray[10]);
        ProgressBar progressBar = (ProgressBar)objectArray[14];
        PlayLayout playLayout = (PlayLayout)((Object)objectArray[2]);
        TextView textView = (TextView)objectArray[4];
        ImageButton imageButton = (ImageButton)objectArray[1];
        TextView textView2 = (TextView)objectArray[15];
        TextView textView3 = (TextView)objectArray[11];
        TextView textView4 = (TextView)objectArray[12];
        TextView textView5 = (TextView)objectArray[13];
        TextView textView6 = (TextView)objectArray[7];
        TextView textView7 = (TextView)objectArray[6];
        TextView textView8 = (TextView)objectArray[5];
        ImageButton imageButton2 = (ImageButton)objectArray[3];
        int n10 = 2;
        super(dataBindingComponent, view, n10, frameLayout, constraintLayout, constraintLayout2, progressBar, playLayout, textView, imageButton, textView2, textView3, textView4, textView5, textView6, textView7, textView8, imageButton2);
        this.x = -1;
        this.a.setTag(null);
        this.e.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.s = object;
        object.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        object = view;
        this.setRootTag(view);
        super(this, 1);
        this.t = object;
        super(this, 3);
        this.u = object;
        super(this, 2);
        this.v = object;
        super(this, 4);
        this.w = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.x;
                long l11 = 1L;
                this.x = l10 |= l11;
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
    private boolean F(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.x;
                long l11 = 2;
                this.x = l10 |= l11;
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
    public void B(l$c l$c) {
        this.r = l$c;
        synchronized (this) {
            long l10 = this.x;
            long l11 = 4;
            this.x = l10 |= l11;
        }
        this.notifyPropertyChanged(104);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(m m10) {
        this.p = m10;
        synchronized (this) {
            long l10 = this.x;
            long l11 = 8;
            this.x = l10 |= l11;
        }
        this.notifyPropertyChanged(135);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(g g10) {
        this.q = g10;
        synchronized (this) {
            long l10 = this.x;
            long l11 = 16;
            this.x = l10 |= l11;
        }
        this.notifyPropertyChanged(136);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 == n13) {
                    l$c l$c = this.r;
                    if (l$c != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        l$c.a();
                    }
                }
            } else {
                l$c l$c = this.r;
                if (l$c != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    l$c.b();
                }
            }
        } else {
            l$c l$c = this.r;
            if (l$c != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                l$c.d();
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
        var1_1 = this;
        synchronized (this) {
            var2_2 = this.x;
            this.x = var4_3 = 0L;
        }
        var6_4 = this.p;
        var7_5 = this.q;
        var8_6 = 41;
        var10_7 = var2_2 & var8_6;
        var12_8 = var10_7 == var4_3 ? 0 : (var10_7 < var4_3 ? -1 : 1);
        var13_9 = 0;
        var14_10 = null;
        if (var12_8 == false) ** GOTO lbl-1000
        if (var6_4 != null) {
            var6_4 = var6_4.f();
        } else {
            var15_11 = 0;
            var6_4 = null;
        }
        var1_1.updateLiveDataRegistration(0, (LiveData)var6_4);
        if (var6_4 != null) {
            var6_4 = (Boolean)var6_4.getValue();
        } else {
            var15_11 = 0;
            var6_4 = null;
        }
        var15_11 = ViewDataBinding.safeUnbox((Boolean)var6_4);
        if (var12_8 != false) {
            var16_12 = var15_11 != 0 ? 512L : 256L;
            var2_2 |= var16_12;
        }
        if (var15_11 != 0) {
            var15_11 = 8;
        } else lbl-1000:
        // 2 sources

        {
            var15_11 = 0;
            var6_4 = null;
        }
        var16_12 = 50;
        var18_13 = var2_2 & var16_12;
        var12_8 = var18_13 == var4_3 ? 0 : (var18_13 < var4_3 ? -1 : 1);
        if (var12_8 != false) {
            var7_5 = var7_5 != null ? var7_5.j() : null;
            var20_14 = 1;
            var1_1.updateLiveDataRegistration(var20_14, (LiveData)var7_5);
            var7_5 = var7_5 != null ? (TemplatePOJO)var7_5.getValue() : null;
            var7_5 = var7_5 != null ? var7_5.getTemplateData() : null;
            if (var7_5 != null) {
                var13_9 = var7_5.isPrimeUsable();
                var21_16 = var7_5.getVideoRatio();
                var22_17 = var7_5.showVideoCount();
                var23_18 = var7_5.showVideoTimeSecond();
                var7_5 = var7_5.showTitle();
            } else {
                var7_5 = null;
                var20_14 = 0;
                var21_16 = null;
                var22_17 = null;
                var24_19 = 0;
                var23_18 = null;
            }
            if (var12_8 != false) {
                var25_20 = var13_9 != 0 ? 128L : (long)64;
                var2_2 |= var25_20;
            }
            if (var13_9 != 0) {
                var27_21 = var1_1.f.getContext();
                var13_9 = 2131231140;
                var27_21 = AppCompatResources.getDrawable(var27_21, var13_9);
            } else {
                var12_8 = 0;
                var27_21 = null;
            }
            var14_10 = var23_18;
        } else {
            var7_5 = null;
            var12_8 = 0;
            var27_21 = null;
            var13_9 = 0;
            var14_10 = null;
            var20_15 = false;
            var21_16 = null;
            var22_17 = null;
        }
        var28_22 = var2_2 & (long)32;
        var24_19 = var28_22 == var4_3 ? 0 : (var28_22 < var4_3 ? -1 : 1);
        if (var24_19 != false) {
            var30_23 = var1_1.a;
            var31_24 = var1_1.w;
            d.v.f.e.c.f((View)var30_23, var31_24);
            var30_23 = var1_1.e;
            var31_24 = var1_1.v;
            var30_23.setOnClickListener((View.OnClickListener)var31_24);
            var30_23 = var1_1.g;
            var31_24 = var1_1.t;
            var30_23.setOnClickListener((View.OnClickListener)var31_24);
            var30_23 = var1_1.o;
            var31_24 = var1_1.u;
            var30_23.setOnClickListener((View.OnClickListener)var31_24);
        }
        if ((var32_25 = (cfr_temp_0 = (var8_6 = var2_2 & var16_12) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false) {
            TextViewBindingAdapter.setDrawableEnd(var1_1.f, (Drawable)var27_21);
            var30_23 = var1_1.f;
            l.a.q.g0.u.n((TextView)var30_23, (String)var7_5, null, null);
            l.a.q.g0.u.n(var1_1.l, var22_17, null, null);
            l.a.q.g0.u.n(var1_1.m, var14_10, null, null);
            var7_5 = var1_1.n;
            l.a.q.g0.u.n((TextView)var7_5, var21_16, null, null);
        }
        if ((var35_27 = (cfr_temp_1 = (var2_2 &= (var33_26 = (long)41)) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
            var36_28 = var1_1.o;
            var36_28.setVisibility(var15_11);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.x;
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
            this.x = l10 = (long)32;
        }
        this.requestRebind();
    }

    public final void m(int n10, View view) {
        l$c l$c = this.r;
        boolean bl2 = l$c != null;
        if (bl2) {
            l$c.c();
        }
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                return false;
            }
            object = (LiveData)object;
            return this.F((LiveData)object, n11);
        }
        object = (LiveData)object;
        return this.E((LiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 104;
        if (n11 == n10) {
            object = (l$c)object;
            this.B((l$c)object);
            return 1 != 0;
        } else {
            n11 = 135;
            if (n11 == n10) {
                object = (m)object;
                this.C((m)object);
                return 1 != 0;
            } else {
                n11 = 136;
                if (n11 != n10) return 0 != 0;
                object = (g)object;
                this.D((g)object);
            }
        }
        return 1 != 0;
    }
}

