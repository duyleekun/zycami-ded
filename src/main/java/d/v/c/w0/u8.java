/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.SeekBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter$OnProgressChanged;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.voice.EditorVolumeFragment$a;
import com.zhiyun.cama.widget.NoOffsetSeekBar;
import d.v.c.f1.a.b$a;
import d.v.c.f1.a.g$a;
import d.v.c.w0.b5;
import d.v.c.w0.j4;
import d.v.c.w0.t8;
import d.v.c.y1.e;
import l.a.q.g0.u;

public class u8
extends t8
implements g$a,
b$a {
    private static final ViewDataBinding$IncludedLayouts n;
    private static final SparseIntArray o;
    private final ConstraintLayout h;
    private final ConstraintLayout i;
    private final View j;
    private final SeekBarBindingAdapter$OnProgressChanged k;
    private final View.OnClickListener l;
    private long m;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        n = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(8);
        String[] stringArray = new String[]{"editor_reset_global_layout", "editor_bottom_choice_layout"};
        int n10 = 2;
        int[] nArray = new int[n10];
        nArray[0] = 6;
        nArray[1] = 7;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558538;
        nArray2[1] = 2131558529;
        viewDataBinding$IncludedLayouts.setIncludes(1, stringArray, nArray, nArray2);
        o = null;
    }

    public u8(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = n;
        SparseIntArray sparseIntArray = o;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 8, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private u8(DataBindingComponent object, View object2, Object[] view) {
        Object object3;
        Object object4;
        Object object5 = object4 = view[7];
        object5 = (j4)object4;
        Object object6 = object4 = view[6];
        object6 = (b5)object4;
        Object object7 = object4 = view[3];
        object7 = (NoOffsetSeekBar)((Object)object4);
        Object object8 = object4 = view[4];
        object8 = (TextView)object4;
        int n10 = 2;
        Object object9 = object3 = view[n10];
        object9 = (CheckBox)object3;
        object3 = this;
        Object object10 = object;
        super(object, (View)object2, 4, (j4)object5, (b5)object6, (NoOffsetSeekBar)((Object)object7), (TextView)object8, (CheckBox)object9);
        this.m = -1;
        object = this.a;
        this.setContainedBinding((ViewDataBinding)object);
        object = this.b;
        this.setContainedBinding((ViewDataBinding)object);
        object = (ConstraintLayout)((Object)view[0]);
        this.h = object;
        object.setTag(null);
        int n11 = 1;
        object10 = (ConstraintLayout)((Object)view[n11]);
        this.i = object10;
        object10.setTag(null);
        this.j = view = (View)view[5];
        view.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.setRootTag((View)object2);
        super(this, n10);
        this.k = object2;
        super(this, n11);
        this.l = object2;
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
                long l10 = this.m;
                long l11 = 4;
                this.m = l10 |= l11;
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
                long l10 = this.m;
                long l11 = 1L;
                this.m = l10 |= l11;
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
                long l10 = this.m;
                long l11 = 2;
                this.m = l10 |= l11;
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
                long l10 = this.m;
                long l11 = 8;
                this.m = l10 |= l11;
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
    public void A(EditorVolumeFragment$a editorVolumeFragment$a) {
        this.g = editorVolumeFragment$a;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 32;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(e e10) {
        this.f = e10;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 16;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(155);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        EditorVolumeFragment$a editorVolumeFragment$a = this.g;
        boolean bl2 = editorVolumeFragment$a != null;
        if (bl2) {
            editorVolumeFragment$a.i();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block23: {
            block24: {
                var1_1 = this;
                synchronized (this) {
                    var2_2 = this.m;
                    this.m = var4_3 = 0L;
                }
                var6_4 /* !! */  = this.f;
                var7_5 = this.g;
                var8_6 = (long)90 & var2_2;
                var10_7 = var8_6 == var4_3 ? 0 : (var8_6 < var4_3 ? -1 : 1);
                var11_8 = 88;
                var13_9 = 82;
                var15_10 = 0;
                var16_11 = 0.0f;
                if (var10_7 == false) break block24;
                var17_12 = var2_2 & var13_9;
                var10_7 = var17_12 == var4_3 ? 0 : (var17_12 < var4_3 ? -1 : 1);
                var19_13 = 1;
                var20_15 = 1.4E-45f;
                if (var10_7 == false) ** GOTO lbl-1000
                if (var6_4 /* !! */  != null) {
                    var21_17 = var6_4 /* !! */ .c;
                } else {
                    var22_19 = 0;
                    var23_20 = 0.0f;
                    var21_17 = null;
                }
                var1_1.updateLiveDataRegistration(var19_13, (LiveData)var21_17);
                if (var21_17 != null) {
                    var21_17 = (Boolean)var21_17.getValue();
                } else {
                    var22_19 = 0;
                    var23_20 = 0.0f;
                    var21_17 = null;
                }
                var22_19 = ViewDataBinding.safeUnbox((Boolean)var21_17);
                if (var10_7 != false) {
                    var24_22 = var22_19 != 0 ? 256L : 128L;
                    var2_2 |= var24_22;
                }
                if (var22_19 != 0) {
                    var10_7 = 8;
                    var26_23 = 1.1E-44f;
                } else lbl-1000:
                // 2 sources

                {
                    var10_7 = 0;
                    var26_23 = 0.0f;
                }
                var27_25 = var2_2 & var11_8;
                var22_19 = var27_25 == var4_3 ? 0 : (var27_25 < var4_3 ? -1 : 1);
                if (var22_19 != 0) {
                    if (var6_4 /* !! */  != null) {
                        var6_4 /* !! */  = var6_4 /* !! */ .c();
                    } else {
                        var29_26 = 0;
                        var30_27 = 0.0f;
                        var6_4 /* !! */  = null;
                    }
                    var22_19 = 3;
                    var23_20 = 4.2E-45f;
                    var1_1.updateLiveDataRegistration(var22_19, (LiveData)var6_4 /* !! */ );
                    if (var6_4 /* !! */  != null) {
                        var6_4 /* !! */  = (Float)var6_4 /* !! */ .getValue();
                    } else {
                        var29_26 = 0;
                        var30_27 = 0.0f;
                        var6_4 /* !! */  = null;
                    }
                    var30_27 = ViewDataBinding.safeUnbox((Float)var6_4 /* !! */ );
                    var22_19 = 1120403456;
                    var23_20 = 100.0f;
                    var29_26 = (int)(var30_27 *= var23_20);
                    if (var29_26 == 0) {
                        var22_19 = var19_13;
                        var23_20 = var20_15;
                    } else {
                        var22_19 = 0;
                        var21_17 = null;
                        var23_20 = 0.0f;
                    }
                    var31_30 = String.valueOf(var29_26);
                    if (var29_26 != 0) {
                        var15_10 = var19_13;
                        var16_11 = var20_15;
                    }
                    var32_31 = var31_30;
                    var33_32 = var15_10;
                    var34_33 = var16_11;
                    var15_10 = (int)var10_7;
                    var16_11 = var26_23;
                    var10_7 = var33_32;
                    var26_23 = var34_33;
                    break block23;
                } else {
                    var29_26 = 0;
                    var6_4 /* !! */  = null;
                    var30_28 = 0.0f;
                    var22_19 = 0;
                    var21_17 = null;
                    var23_20 = 0.0f;
                    var19_13 = 0;
                    var20_15 = 0.0f;
                    var32_31 = null;
                    var15_10 = var10_7;
                    var16_11 = var26_23;
                    var10_7 = 0;
                    var26_23 = 0.0f;
                }
                break block23;
            }
            var29_26 = 0;
            var6_4 /* !! */  = null;
            var30_29 = 0.0f;
            var10_7 = 0;
            var26_24 = 0.0f;
            var22_19 = 0;
            var21_18 = null;
            var23_21 = 0.0f;
            var19_14 = false;
            var20_16 = 0.0f;
            var32_31 = null;
        }
        var24_22 = var2_2 & (long)96;
        var35_34 = var24_22 == var4_3 ? 0 : (var24_22 < var4_3 ? -1 : 1);
        if (var35_34 != false) {
            var1_1.a.z(var7_5);
            var36_35 = var1_1.b;
            var36_35.z(var7_5);
        }
        if ((var37_36 = (cfr_temp_0 = (var13_9 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false) {
            var7_5 = var1_1.j;
            var7_5.setVisibility(var15_10);
        }
        if ((var37_36 = (cfr_temp_1 = (var11_8 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
            SeekBarBindingAdapter.setProgress(var1_1.c, var29_26);
            var6_4 /* !! */  = var1_1.d;
            var37_36 = 0;
            u.n((TextView)var6_4 /* !! */ , var32_31, null, null);
            CompoundButtonBindingAdapter.setChecked((CompoundButton)var1_1.e, (boolean)var22_19);
            var6_4 /* !! */  = var1_1.e;
            var7_5 = var1_1.l;
            ViewBindingAdapter.setOnClick((View)var6_4 /* !! */ , (View.OnClickListener)var7_5, (boolean)var10_7);
        }
        if ((var29_26 = (int)((cfr_temp_2 = (var2_2 &= (var38_37 = (long)64)) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) != 0) {
            var6_4 /* !! */  = var1_1.c;
            var40_38 = var1_1.k;
            SeekBarBindingAdapter.setOnSeekBarChangeListener((SeekBar)var6_4 /* !! */ , null, null, var40_38, null);
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
            long l10 = this.m;
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
            this.m = l10 = (long)64;
        }
        this.b.invalidateAll();
        this.a.invalidateAll();
        this.requestRebind();
    }

    public final void n(int n10, SeekBar seekBar, int n11, boolean bl2) {
        EditorVolumeFragment$a editorVolumeFragment$a = this.g;
        boolean bl3 = editorVolumeFragment$a != null;
        if (bl3) {
            editorVolumeFragment$a.h(seekBar, n11, bl2);
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
                    object = (MutableLiveData)object;
                    return this.F((MutableLiveData)object, n11);
                }
                object = (j4)object;
                return this.C((j4)object, n11);
            }
            object = (MutableLiveData)object;
            return this.E((MutableLiveData)object, n11);
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
        int n11 = 155;
        if (n11 == n10) {
            object = (e)object;
            this.B((e)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 != n10) return 0 != 0;
            object = (EditorVolumeFragment$a)object;
            this.A((EditorVolumeFragment$a)object);
        }
        return 1 != 0;
    }
}

