/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.SeekBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter$OnProgressChanged;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.filter.EditorFilterFragment$a;
import com.zhiyun.cama.widget.NoOffsetSeekBar;
import com.zhiyun.cama.widget.base.BaseResourceListView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.f1.a.g;
import d.v.c.f1.a.g$a;
import d.v.c.w0.b5;
import d.v.c.w0.j4;
import d.v.c.w0.p6;
import l.a.q.g0.u;

public class q6
extends p6
implements b$a,
g$a {
    private static final ViewDataBinding$IncludedLayouts m;
    private static final SparseIntArray n;
    private final ConstraintLayout i;
    private final View.OnClickListener j;
    private final SeekBarBindingAdapter$OnProgressChanged k;
    private long l;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        m = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(7);
        String[] stringArray = new String[]{"editor_reset_global_layout", "editor_bottom_choice_layout"};
        int n10 = 2;
        int[] nArray = new int[n10];
        nArray[0] = 4;
        nArray[1] = 5;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558538;
        nArray2[1] = 2131558529;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        n = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131363073, 6);
    }

    public q6(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = m;
        SparseIntArray sparseIntArray = n;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private q6(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[5];
        object4 = (j4)object3;
        Object object5 = object3 = objectArray[4];
        object5 = (b5)object3;
        Object object6 = object3 = objectArray[6];
        object6 = (BaseResourceListView)object3;
        int n10 = 1;
        Object object7 = object2 = objectArray[n10];
        object7 = (NoOffsetSeekBar)((Object)object2);
        Object object8 = object2 = objectArray[3];
        object8 = (StatusView)((Object)object2);
        int n11 = 2;
        Object object9 = object2 = objectArray[n11];
        object9 = (TextView)object2;
        object2 = this;
        super(object, view, 4, (j4)object4, (b5)object5, (BaseResourceListView)object6, (NoOffsetSeekBar)((Object)object7), (StatusView)((Object)object8), (TextView)object9);
        this.l = -1;
        object = this.a;
        this.setContainedBinding((ViewDataBinding)object);
        object = this.b;
        this.setContainedBinding((ViewDataBinding)object);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.i = object;
        object.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.setRootTag(view);
        object = new b(this, n11);
        this.j = object;
        object = new g(this, n10);
        this.k = object;
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
                long l10 = this.l;
                long l11 = 8;
                this.l = l10 |= l11;
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
    private boolean D(b5 b52, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.l;
                long l11 = 1L;
                this.l = l10 |= l11;
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
                long l10 = this.l;
                long l11 = 4;
                this.l = l10 |= l11;
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
    private boolean F(MediatorLiveData mediatorLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.l;
                long l11 = 2;
                this.l = l10 |= l11;
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
    public void A(EditorFilterFragment$a editorFilterFragment$a) {
        this.h = editorFilterFragment$a;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 32;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(d.v.c.e1.u u10) {
        this.g = u10;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 16;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(58);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        EditorFilterFragment$a editorFilterFragment$a = this.h;
        boolean bl2 = editorFilterFragment$a != null;
        if (bl2) {
            editorFilterFragment$a.i();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block21: {
            block20: {
                block19: {
                    var1_1 = this;
                    synchronized (this) {
                        var2_2 = this.l;
                        this.l = var4_3 = 0L;
                    }
                    var6_4 = this.g;
                    var7_5 = this.h;
                    var8_6 = (long)86 & var2_2;
                    var10_7 /* !! */  = var8_6 == var4_3 ? 0 : (var8_6 < var4_3 ? -1 : 1);
                    var11_8 = 84;
                    var13_9 = 82;
                    var15_10 = 0;
                    if (var10_7 /* !! */  == false) break block19;
                    var16_11 = var2_2 & var13_9;
                    cfr_temp_0 = var16_11 - var4_3;
                    var10_7 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                    if (var10_7 /* !! */  == false) ** GOTO lbl-1000
                    if (var6_4 != null) {
                        var18_12 = var6_4.g();
                    } else {
                        var19_13 = 0;
                        var18_12 = null;
                    }
                    var20_14 = 1;
                    var1_1.updateLiveDataRegistration(var20_14, (LiveData)var18_12);
                    if (var18_12 != null) {
                        var18_12 = (Integer)var18_12.getValue();
                    } else {
                        var19_13 = 0;
                        var18_12 = null;
                    }
                    var19_13 = ViewDataBinding.safeUnbox((Integer)var18_12);
                    if (var19_13 != 0) {
                        var20_14 = 0;
                    }
                    if (var10_7 /* !! */  != false) {
                        var21_15 = var20_14 != 0 ? 256L : 128L;
                        var2_2 |= var21_15;
                    }
                    if (var20_14 != 0) {
                        var10_7 /* !! */  = 4;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var10_7 /* !! */  = 0;
                    }
                    var16_11 = var2_2 & var11_8;
                    var19_13 = var16_11 == var4_3 ? 0 : (var16_11 < var4_3 ? -1 : 1);
                    if (var19_13 == 0) break block20;
                    if (var6_4 != null) {
                        var6_4 = var6_4.x();
                    } else {
                        var23_16 = false;
                        var6_4 = null;
                    }
                    var15_10 = 2;
                    var1_1.updateLiveDataRegistration(var15_10, (LiveData)var6_4);
                    if (var6_4 != null) {
                        var6_4 = (Integer)var6_4.getValue();
                    } else {
                        var23_16 = false;
                        var6_4 = null;
                    }
                    var15_10 = ViewDataBinding.safeUnbox((Integer)var6_4);
                    var6_4 = String.valueOf(var15_10);
                    break block21;
                }
                var10_7 /* !! */  = 0;
            }
            var23_16 = false;
            var6_4 = null;
        }
        var16_11 = (long)96 & var2_2;
        var19_13 = var16_11 == var4_3 ? 0 : (var16_11 < var4_3 ? -1 : 1);
        if (var19_13 != 0) {
            var1_1.a.z(var7_5);
            var18_12 = var1_1.b;
            var18_12.z(var7_5);
        }
        if ((var24_17 = (cfr_temp_1 = (var11_8 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
            SeekBarBindingAdapter.setProgress(var1_1.d, var15_10);
            var7_5 = var1_1.f;
            u.n((TextView)var7_5, (String)var6_4, null, null);
        }
        if (var23_16 = (cfr_temp_2 = (var11_8 = var2_2 & var13_9) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) {
            var1_1.d.setVisibility((int)var10_7 /* !! */ );
            var6_4 = var1_1.f;
            var6_4.setVisibility((int)var10_7 /* !! */ );
        }
        if (var23_16 = (cfr_temp_3 = (var2_2 &= (var25_18 = (long)64)) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) {
            var6_4 = var1_1.d;
            var27_19 = var1_1.k;
            SeekBarBindingAdapter.setOnSeekBarChangeListener((SeekBar)var6_4, null, null, var27_19, null);
            var6_4 = var1_1.e;
            var28_20 = ViewDataBinding.getColorFromResource((View)var6_4, 2131099860);
            var6_4.setBackgroundColor(var28_20);
            var6_4 = var1_1.e;
            var27_19 = var6_4.getContext();
            var29_21 = 2131231805;
            var27_19 = AppCompatResources.getDrawable((Context)var27_19, var29_21);
            var6_4.setErrorImage((Drawable)var27_19);
            var1_1.e.setErrorText("@string/request_error");
            var6_4 = var1_1.e;
            var27_19 = var1_1.j;
            var6_4.setOnClickErrorListener((View.OnClickListener)var27_19);
        }
        ViewDataBinding.executeBindingsOn(var1_1.b);
        ViewDataBinding.executeBindingsOn(var1_1.a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.l;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            ViewDataBinding viewDataBinding = this.b;
            l12 = (long)viewDataBinding.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            viewDataBinding = this.a;
            l12 = (long)viewDataBinding.hasPendingBindings();
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
            this.l = l10 = (long)64;
        }
        this.b.invalidateAll();
        this.a.invalidateAll();
        this.requestRebind();
    }

    public final void n(int n10, SeekBar seekBar, int n11, boolean bl2) {
        EditorFilterFragment$a editorFilterFragment$a = this.h;
        boolean bl3 = editorFilterFragment$a != null;
        if (bl3) {
            editorFilterFragment$a.h(seekBar, n11, bl2);
        }
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
                return this.E((MutableLiveData)object, n11);
            }
            object = (MediatorLiveData)object;
            return this.F((MediatorLiveData)object, n11);
        }
        object = (b5)object;
        return this.D((b5)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.b.setLifecycleOwner(lifecycleOwner);
        this.a.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 58;
        if (n11 == n10) {
            object = (d.v.c.e1.u)object;
            this.B((d.v.c.e1.u)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 != n10) return 0 != 0;
            object = (EditorFilterFragment$a)object;
            this.A((EditorFilterFragment$a)object);
        }
        return 1 != 0;
    }
}

