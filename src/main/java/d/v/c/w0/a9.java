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
import com.zhiyun.cama.template.edit.EditorTemplateFilterFragment$a;
import com.zhiyun.cama.widget.NoOffsetSeekBar;
import com.zhiyun.cama.widget.base.BaseResourceListView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.f1.a.g;
import d.v.c.f1.a.g$a;
import d.v.c.w0.j4;
import d.v.c.w0.z8;
import l.a.q.g0.u;

public class a9
extends z8
implements g$a,
b$a {
    private static final ViewDataBinding$IncludedLayouts l;
    private static final SparseIntArray m;
    private final ConstraintLayout h;
    private final SeekBarBindingAdapter$OnProgressChanged i;
    private final View.OnClickListener j;
    private long k;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        l = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(6);
        String[] stringArray = new String[]{"editor_bottom_choice_layout"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 4;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558529;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        m = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131363073, 5);
    }

    public a9(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = l;
        SparseIntArray sparseIntArray = m;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private a9(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[4];
        object4 = (j4)object3;
        Object object5 = object3 = objectArray[5];
        object5 = (BaseResourceListView)object3;
        int n10 = 1;
        Object object6 = object2 = objectArray[n10];
        object6 = (NoOffsetSeekBar)((Object)object2);
        Object object7 = object2 = objectArray[3];
        object7 = (StatusView)((Object)object2);
        int n11 = 2;
        Object object8 = object2 = objectArray[n11];
        object8 = (TextView)object2;
        object2 = this;
        super(object, view, 3, (j4)object4, (BaseResourceListView)object5, (NoOffsetSeekBar)((Object)object6), (StatusView)((Object)object7), (TextView)object8);
        this.k = -1;
        object = this.a;
        this.setContainedBinding((ViewDataBinding)object);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.h = object;
        object.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.setRootTag(view);
        object = new g(this, n10);
        this.i = object;
        object = new b(this, n11);
        this.j = object;
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
                long l10 = this.k;
                long l11 = 4;
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
    private boolean D(MutableLiveData mutableLiveData, int n10) {
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
    private boolean E(MediatorLiveData mediatorLiveData, int n10) {
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
    public void A(EditorTemplateFilterFragment$a editorTemplateFilterFragment$a) {
        this.g = editorTemplateFilterFragment$a;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 16;
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
    public void B(d.v.c.e1.u u10) {
        this.f = u10;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 8;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(58);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        EditorTemplateFilterFragment$a editorTemplateFilterFragment$a = this.g;
        boolean bl2 = editorTemplateFilterFragment$a != null;
        if (bl2) {
            editorTemplateFilterFragment$a.i();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block22: {
            block21: {
                block20: {
                    var1_1 = this;
                    synchronized (this) {
                        var2_2 = this.k;
                        this.k = var4_3 = 0L;
                    }
                    var6_4 = this.f;
                    var7_5 = this.g;
                    var8_6 = (long)43 & var2_2;
                    var10_7 = var8_6 == var4_3 ? 0 : (var8_6 < var4_3 ? -1 : 1);
                    var11_8 = 42;
                    var13_9 = 41;
                    var15_10 = 0;
                    if (var10_7 == false) break block20;
                    var16_11 = var2_2 & var13_9;
                    var10_7 = var16_11 == var4_3 ? 0 : (var16_11 < var4_3 ? -1 : 1);
                    var18_12 = 1;
                    if (var10_7 == false) ** GOTO lbl-1000
                    if (var6_4 != null) {
                        var19_13 = var6_4.g();
                    } else {
                        var20_14 = 0;
                        var19_13 = null;
                    }
                    var1_1.updateLiveDataRegistration(0, (LiveData)var19_13);
                    if (var19_13 != null) {
                        var19_13 = (Integer)var19_13.getValue();
                    } else {
                        var20_14 = 0;
                        var19_13 = null;
                    }
                    var20_14 = ViewDataBinding.safeUnbox((Integer)var19_13);
                    if (var20_14 == 0) {
                        var20_14 = var18_12;
                    } else {
                        var20_14 = 0;
                        var19_13 = null;
                    }
                    if (var10_7 != false) {
                        var21_15 = var20_14 != 0 ? 128L : (long)64;
                        var2_2 |= var21_15;
                    }
                    if (var20_14 != 0) {
                        var10_7 = 4;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var10_7 = 0;
                    }
                    var23_16 = var2_2 & var11_8;
                    var20_14 = var23_16 == var4_3 ? 0 : (var23_16 < var4_3 ? -1 : 1);
                    if (var20_14 == 0) break block21;
                    if (var6_4 != null) {
                        var6_4 = var6_4.x();
                    } else {
                        var25_17 = false;
                        var6_4 = null;
                    }
                    var1_1.updateLiveDataRegistration(var18_12, (LiveData)var6_4);
                    if (var6_4 != null) {
                        var6_4 = (Integer)var6_4.getValue();
                    } else {
                        var25_17 = false;
                        var6_4 = null;
                    }
                    var15_10 = ViewDataBinding.safeUnbox((Integer)var6_4);
                    var6_4 = String.valueOf(var15_10);
                    break block22;
                }
                var10_7 = 0;
            }
            var25_17 = false;
            var6_4 = null;
        }
        var16_11 = (long)48 & var2_2;
        var18_12 = var16_11 == var4_3 ? 0 : (var16_11 < var4_3 ? -1 : 1);
        if (var18_12 != 0) {
            var26_18 = var1_1.a;
            var26_18.z(var7_5);
        }
        if ((var27_19 = (cfr_temp_0 = (var11_8 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false) {
            SeekBarBindingAdapter.setProgress(var1_1.c, var15_10);
            var7_5 = var1_1.e;
            u.n((TextView)var7_5, (String)var6_4, null, null);
        }
        if (var25_17 = (cfr_temp_1 = (var11_8 = var2_2 & var13_9) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) {
            var1_1.c.setVisibility((int)var10_7);
            var6_4 = var1_1.e;
            var6_4.setVisibility((int)var10_7);
        }
        if (var25_17 = (cfr_temp_2 = (var2_2 &= (var28_20 = (long)32)) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) {
            var6_4 = var1_1.c;
            var30_21 = var1_1.i;
            SeekBarBindingAdapter.setOnSeekBarChangeListener((SeekBar)var6_4, null, null, var30_21, null);
            var6_4 = var1_1.d;
            var31_22 = ViewDataBinding.getColorFromResource((View)var6_4, 2131099860);
            var6_4.setBackgroundColor(var31_22);
            var6_4 = var1_1.d;
            var30_21 = var6_4.getContext();
            var32_23 = 2131231805;
            var30_21 = AppCompatResources.getDrawable((Context)var30_21, var32_23);
            var6_4.setErrorImage((Drawable)var30_21);
            var1_1.d.setErrorText("@string/request_error");
            var6_4 = var1_1.d;
            var30_21 = var1_1.j;
            var6_4.setOnClickErrorListener((View.OnClickListener)var30_21);
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
            long l10 = this.k;
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
            this.k = l10 = (long)32;
        }
        this.a.invalidateAll();
        this.requestRebind();
    }

    public final void n(int n10, SeekBar seekBar, int n11, boolean bl2) {
        EditorTemplateFilterFragment$a editorTemplateFilterFragment$a = this.g;
        boolean bl3 = editorTemplateFilterFragment$a != null;
        if (bl3) {
            editorTemplateFilterFragment$a.g(seekBar, n11, bl2);
        }
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
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

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
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
            object = (EditorTemplateFilterFragment$a)object;
            this.A((EditorTemplateFilterFragment$a)object);
        }
        return 1 != 0;
    }
}

