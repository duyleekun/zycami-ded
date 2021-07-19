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
import com.zhiyun.cama.voice.music.volume.EditorMusicVolumeFragment$b;
import com.zhiyun.cama.widget.AudioBarView;
import com.zhiyun.cama.widget.NoOffsetSeekBar;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.f1.a.b$a;
import d.v.c.f1.a.g$a;
import d.v.c.f1.a.h$a;
import d.v.c.f1.a.i$a;
import d.v.c.f1.a.r$a;
import d.v.c.r0.a;
import d.v.c.r0.a$b;
import d.v.c.r0.a$c;
import d.v.c.r0.a$d;
import d.v.c.w0.h7;
import d.v.c.w0.j4;
import d.v.c.w0.sf;
import d.v.c.y1.f.y.e;
import d.v.e.l.l2;
import java.util.List;
import l.a.q.g0.u;

public class i7
extends h7
implements g$a,
r$a,
h$a,
b$a,
i$a {
    private static final ViewDataBinding$IncludedLayouts A;
    private static final SparseIntArray B;
    private final sf q;
    private final ConstraintLayout r;
    private final SeekBarBindingAdapter$OnProgressChanged s;
    private final a$d t;
    private final SeekBarBindingAdapter$OnProgressChanged u;
    private final a$b v;
    private final View.OnClickListener w;
    private final SeekBarBindingAdapter$OnProgressChanged x;
    private final a$c y;
    private long z;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        A = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(16);
        String[] stringArray = new String[]{"media_duration_layout", "editor_bottom_choice_layout"};
        int n10 = 2;
        int[] nArray = new int[n10];
        nArray[0] = 11;
        nArray[1] = 12;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558715;
        nArray2[1] = 2131558529;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        B = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131363437, 13);
        viewDataBinding$IncludedLayouts.put(2131363733, 14);
        viewDataBinding$IncludedLayouts.put(2131363734, 15);
    }

    public i7(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = A;
        SparseIntArray sparseIntArray = B;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 16, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private i7(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object = this;
        j4 j42 = (j4)objectArray[12];
        AudioBarView audioBarView = (AudioBarView)((Object)objectArray[1]);
        NoOffsetSeekBar noOffsetSeekBar = (NoOffsetSeekBar)((Object)objectArray[5]);
        NoOffsetSeekBar noOffsetSeekBar2 = (NoOffsetSeekBar)((Object)objectArray[7]);
        NoOffsetSeekBar noOffsetSeekBar3 = (NoOffsetSeekBar)((Object)objectArray[9]);
        TextView textView = (TextView)objectArray[13];
        ZYTextView zYTextView = (ZYTextView)objectArray[3];
        ZYTextView zYTextView2 = (ZYTextView)objectArray[2];
        TextView textView2 = (TextView)objectArray[6];
        TextView textView3 = (TextView)objectArray[8];
        TextView textView4 = (TextView)objectArray[10];
        CheckBox checkBox = (CheckBox)objectArray[4];
        View view2 = (View)objectArray[14];
        View view3 = (View)objectArray[15];
        int n10 = 7;
        super(dataBindingComponent, view, n10, j42, audioBarView, noOffsetSeekBar, noOffsetSeekBar2, noOffsetSeekBar3, textView, zYTextView, zYTextView2, textView2, textView3, textView4, checkBox, view2, view3);
        this.z = -1;
        object = this.a;
        this.setContainedBinding((ViewDataBinding)object);
        object = (sf)objectArray[11];
        this.q = object;
        this.setContainedBinding((ViewDataBinding)object);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.r = object;
        object.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        object = view;
        this.setRootTag(view);
        super(this, 6);
        this.s = object;
        super(this, 2);
        this.t = object;
        super(this, 7);
        this.u = object;
        super(this, 3);
        this.v = object;
        super(this, 4);
        this.w = object;
        super(this, 5);
        this.x = object;
        super(this, 1);
        this.y = object;
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
                long l10 = this.z;
                long l11 = 64;
                this.z = l10 |= l11;
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
                long l10 = this.z;
                long l11 = 2;
                this.z = l10 |= l11;
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
                long l10 = this.z;
                long l11 = 1L;
                this.z = l10 |= l11;
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
                long l10 = this.z;
                long l11 = 32;
                this.z = l10 |= l11;
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
    private boolean G(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.z;
                long l11 = 8;
                this.z = l10 |= l11;
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
    private boolean H(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.z;
                long l11 = 4;
                this.z = l10 |= l11;
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
    private boolean I(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.z;
                long l11 = 16;
                this.z = l10 |= l11;
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
    public void A(EditorMusicVolumeFragment$b editorMusicVolumeFragment$b) {
        this.p = editorMusicVolumeFragment$b;
        synchronized (this) {
            long l10 = this.z;
            long l11 = 256L;
            this.z = l10 |= l11;
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
        this.o = e10;
        synchronized (this) {
            long l10 = this.z;
            long l11 = 128L;
            this.z = l10 |= l11;
        }
        this.notifyPropertyChanged(155);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        EditorMusicVolumeFragment$b editorMusicVolumeFragment$b = this.p;
        boolean bl2 = editorMusicVolumeFragment$b != null;
        if (bl2) {
            editorMusicVolumeFragment$b.l();
        }
    }

    public final void e(int n10) {
        EditorMusicVolumeFragment$b editorMusicVolumeFragment$b = this.p;
        boolean bl2 = editorMusicVolumeFragment$b != null;
        if (bl2) {
            editorMusicVolumeFragment$b.j();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block50: {
            block49: {
                var1_1 = this;
                synchronized (this) {
                    var2_2 = this.z;
                    this.z = var4_3 = 0L;
                }
                var6_4 = this.o;
                var7_5 /* !! */  = this.p;
                var8_6 = 703L & var2_2;
                var10_7 = var8_6 == var4_3 ? 0 : (var8_6 < var4_3 ? -1 : 1);
                var11_8 = 648L;
                var13_9 = 644L;
                var15_10 = 656L;
                var17_11 = 642L;
                var19_12 = 641L;
                var21_13 = 0;
                var22_14 = null;
                if (var10_7 == false) break block49;
                var23_15 = var2_2 & var19_12;
                var10_7 = var23_15 == var4_3 ? 0 : (var23_15 < var4_3 ? -1 : 1);
                var25_16 = 1000000.0f;
                if (var10_7 != false) {
                    if (var6_4 != null) {
                        var26_17 = var6_4.j();
                    } else {
                        var10_7 = 0;
                        var27_18 = 0.0f;
                        var26_17 = null;
                    }
                    var1_1.updateLiveDataRegistration(0, (LiveData)var26_17);
                    if (var26_17 != null) {
                        var26_17 = (Long)var26_17.getValue();
                    } else {
                        var10_7 = 0;
                        var27_18 = 0.0f;
                        var26_17 = null;
                    }
                    var28_21 = ViewDataBinding.safeUnbox((Long)var26_17);
                    var27_18 = (float)var28_21 / var25_16;
                    var26_17 = String.valueOf(var27_18);
                    var22_14 = new StringBuilder();
                    var22_14.append((String)var26_17);
                    var22_14.append("s");
                    var26_17 = var22_14.toString();
                } else {
                    var10_7 = 0;
                    var27_19 = 0.0f;
                    var26_17 = null;
                }
                var28_21 = var2_2 & var17_11;
                var21_13 = var28_21 == var4_3 ? 0 : (var28_21 < var4_3 ? -1 : 1);
                var30_22 = true;
                if (var21_13 != 0) {
                    if (var6_4 != null) {
                        var22_14 = var6_4.f();
                    } else {
                        var21_13 = 0;
                        var22_14 = null;
                    }
                    var1_1.updateLiveDataRegistration((int)var30_22, (LiveData)var22_14);
                    if (var22_14 != null) {
                        var22_14 = (Long)var22_14.getValue();
                    } else {
                        var21_13 = 0;
                        var22_14 = null;
                    }
                    var31_23 = ViewDataBinding.safeUnbox((Long)var22_14);
                    var22_14 = l2.d(var31_23);
                } else {
                    var21_13 = 0;
                    var22_14 = null;
                }
                var31_23 = var2_2 & var13_9;
                var33_24 = var31_23 == var4_3 ? 0 : (var31_23 < var4_3 ? -1 : 1);
                if (var33_24 != false) {
                    if (var6_4 != null) {
                        var34_25 = var6_4.o();
                        var35_26 = var34_25;
                    } else {
                        var30_22 = false;
                        var35_26 = null;
                    }
                    var36_28 = 2;
                    var37_29 = 2.8E-45f;
                    var1_1.updateLiveDataRegistration(var36_28, (LiveData)var35_26);
                    if (var35_26 != null) {
                        var35_26 = (Long)var35_26.getValue();
                    } else {
                        var30_22 = false;
                        var35_26 = null;
                    }
                    var13_9 = ViewDataBinding.safeUnbox((Long)var35_26);
                    var35_26 = l2.d(var13_9);
                } else {
                    var30_22 = false;
                    var35_26 = null;
                }
                var13_9 = var2_2 & var11_8;
                var36_28 = (int)(var13_9 == var4_3 ? 0 : (var13_9 < var4_3 ? -1 : 1));
                if (var36_28 != 0) {
                    if (var6_4 != null) {
                        var38_31 = var6_4.l();
                    } else {
                        var36_28 = 0;
                        var37_29 = 0.0f;
                        var38_31 = null;
                    }
                    var39_34 = 3;
                    var40_37 = 4.2E-45f;
                    var1_1.updateLiveDataRegistration(var39_34, (LiveData)var38_31);
                    if (var38_31 != null) {
                        var38_31 = (Float)var38_31.getValue();
                    } else {
                        var36_28 = 0;
                        var37_29 = 0.0f;
                        var38_31 = null;
                    }
                    var37_29 = ViewDataBinding.safeUnbox((Float)var38_31);
                    var39_34 = 1120403456;
                    var40_37 = 100.0f;
                    var36_28 = (int)(var37_29 *= var40_37);
                    var41_40 = String.valueOf(var36_28);
                    var42_41 = var36_28 == 0;
                    if (var36_28 != 0) {
                        var43_42 = 1;
                        var44_43 = 1.4E-45f;
                    } else {
                        var43_42 = 0;
                        var44_43 = 0.0f;
                    }
                    var45_45 = var43_42;
                    var43_42 = var36_28;
                    var36_28 = var45_45;
                    var37_29 = var44_43;
                } else {
                    var36_28 = 0;
                    var37_29 = 0.0f;
                    var38_32 = null;
                    var39_35 = false;
                    var40_38 = 0.0f;
                    var41_40 = null;
                    var43_42 = 0;
                    var44_44 = 0.0f;
                    var42_41 = false;
                }
                var46_46 = var2_2 & var15_10;
                var33_24 = var46_46 == var4_3 ? 0 : (var46_46 < var4_3 ? -1 : 1);
                if (var33_24 == false) ** GOTO lbl-1000
                if (var6_4 != null) {
                    var34_25 = var6_4.r();
                    var48_47 = var34_25;
                } else {
                    var48_47 = null;
                }
                var49_48 = 4;
                var1_1.updateLiveDataRegistration(var49_48, (LiveData)var48_47);
                if (var48_47 != null) {
                    var48_47 = (List)var48_47.getValue();
                } else lbl-1000:
                // 2 sources

                {
                    var48_47 = null;
                }
                var50_50 = 672L;
                var52_51 = var2_2 & var50_50;
                var49_48 = (int)(var52_51 == var4_3 ? 0 : (var52_51 < var4_3 ? -1 : 1));
                if (var49_48 != 0) {
                    if (var6_4 != null) {
                        var6_4 = var6_4.k();
                    } else {
                        var54_52 = 0.0f;
                        var6_4 = null;
                    }
                    var49_48 = 5;
                    var1_1.updateLiveDataRegistration(var49_48, (LiveData)var6_4);
                    if (var6_4 != null) {
                        var6_4 = (Long)var6_4.getValue();
                    } else {
                        var54_52 = 0.0f;
                        var6_4 = null;
                    }
                    var15_10 = ViewDataBinding.safeUnbox((Long)var6_4);
                    var54_52 = (float)var15_10 / var25_16;
                    var6_4 = String.valueOf(var54_52);
                    var55_55 = new StringBuilder();
                    var55_55.append((String)var6_4);
                    var55_55.append("s");
                    var6_4 = var55_55.toString();
                    var55_55 = var35_26;
                    var56_56 = var41_40;
                    var30_22 = var42_41;
                } else {
                    var55_55 = var35_26;
                    var56_56 = var41_40;
                    var30_22 = var42_41;
                    var54_53 = 0.0f;
                    var6_4 = null;
                }
                var41_40 = var48_47;
                var48_47 = var22_14;
                var21_13 = var43_42;
                break block50;
            }
            var54_54 = 0.0f;
            var6_4 = null;
            var10_7 = 0;
            var27_20 = 0.0f;
            var26_17 = null;
            var21_13 = 0;
            var22_14 = null;
            var30_22 = false;
            var35_27 = null;
            var48_47 = null;
            var49_49 = false;
            var55_55 = null;
            var36_28 = 0;
            var37_30 = 0.0f;
            var38_33 = null;
            var39_36 = false;
            var40_39 = 0.0f;
            var41_40 = null;
            var56_56 = null;
        }
        var23_15 = var2_2 & 768L;
        var57_57 = var23_15 == var4_3 ? 0 : (var23_15 < var4_3 ? -1 : 1);
        if (var57_57 != false) {
            var58_58 = var1_1.a;
            var58_58.z(var7_5 /* !! */ );
        }
        if ((var59_59 = (cfr_temp_0 = (var23_15 = var2_2 & 656L) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false) {
            var7_5 /* !! */  = var1_1.b;
            var7_5 /* !! */ .setDataList((List)var41_40);
        }
        if ((var59_59 = (cfr_temp_1 = (var23_15 = var2_2 & 512L) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
            var7_5 /* !! */  = var1_1.b;
            var41_40 = var1_1.y;
            var58_58 = var1_1.t;
            var60_60 /* !! */  = var1_1.v;
            d.v.c.r0.a.a((AudioBarView)var7_5 /* !! */ , (a$c)var41_40, (a$d)var58_58, var60_60 /* !! */ );
            var60_60 /* !! */  = var1_1.c;
            var61_61 = var1_1.x;
            var59_59 = 0;
            var7_5 /* !! */  = null;
            SeekBarBindingAdapter.setOnSeekBarChangeListener((SeekBar)var60_60 /* !! */ , null, null, var61_61, null);
            var60_60 /* !! */  = var1_1.d;
            var61_61 = var1_1.s;
            SeekBarBindingAdapter.setOnSeekBarChangeListener((SeekBar)var60_60 /* !! */ , null, null, var61_61, null);
            var60_60 /* !! */  = var1_1.e;
            var61_61 = var1_1.u;
            SeekBarBindingAdapter.setOnSeekBarChangeListener((SeekBar)var60_60 /* !! */ , null, null, var61_61, null);
        } else {
            var59_59 = 0;
            var7_5 /* !! */  = null;
        }
        var4_3 = 648L & var2_2;
        var23_15 = 0L;
        var62_62 = var4_3 == var23_15 ? 0 : (var4_3 < var23_15 ? -1 : 1);
        if (var62_62 != false) {
            SeekBarBindingAdapter.setProgress(var1_1.c, var21_13);
            l.a.q.g0.u.n(var1_1.i, var56_56, null, null);
            CompoundButtonBindingAdapter.setChecked((CompoundButton)var1_1.l, var30_22);
            var60_60 /* !! */  = var1_1.l;
            var61_61 = var1_1.w;
            ViewBindingAdapter.setOnClick((View)var60_60 /* !! */ , (View.OnClickListener)var61_61, (boolean)var36_28);
        }
        if ((var62_62 = (cfr_temp_2 = (var4_3 = var2_2 & var17_11) - (var28_21 = 0L)) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
            var60_60 /* !! */  = var1_1.g;
            var61_61 = null;
            l.a.q.g0.u.n((TextView)var60_60 /* !! */ , (String)var48_47, null, null);
        } else {
            var61_61 = null;
        }
        var13_9 = 644L & var2_2;
        var62_62 = var13_9 == var28_21 ? 0 : (var13_9 < var28_21 ? -1 : 1);
        if (var62_62 != false) {
            var60_60 /* !! */  = var1_1.h;
            l.a.q.g0.u.n((TextView)var60_60 /* !! */ , (String)var55_55, null, null);
        }
        if ((var62_62 = (cfr_temp_3 = (var11_8 = var2_2 & var19_12) - var28_21) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) {
            var60_60 /* !! */  = var1_1.j;
            l.a.q.g0.u.n((TextView)var60_60 /* !! */ , (String)var26_17, null, null);
        }
        if ((var65_64 = (cfr_temp_4 = (var2_2 &= (var63_63 = 672L)) - var28_21) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) != false) {
            var66_65 = var1_1.k;
            l.a.q.g0.u.n(var66_65, (String)var6_4, null, null);
        }
        ViewDataBinding.executeBindingsOn(var1_1.q);
        ViewDataBinding.executeBindingsOn(var1_1.a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.z;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            ViewDataBinding viewDataBinding = this.q;
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
            this.z = l10 = 512L;
        }
        this.q.invalidateAll();
        this.a.invalidateAll();
        this.requestRebind();
    }

    public final void j(int n10) {
        EditorMusicVolumeFragment$b editorMusicVolumeFragment$b = this.p;
        boolean bl2 = editorMusicVolumeFragment$b != null;
        if (bl2) {
            editorMusicVolumeFragment$b.k();
        }
    }

    public final void n(int n10, SeekBar seekBar, int n11, boolean bl2) {
        int n12 = 5;
        boolean bl3 = true;
        if (n10 != n12) {
            n12 = 6;
            if (n10 != n12) {
                n12 = 7;
                if (n10 == n12) {
                    EditorMusicVolumeFragment$b editorMusicVolumeFragment$b = this.p;
                    if (editorMusicVolumeFragment$b == null) {
                        bl3 = false;
                    }
                    if (bl3) {
                        editorMusicVolumeFragment$b.h(seekBar, n11, bl2);
                    }
                }
            } else {
                EditorMusicVolumeFragment$b editorMusicVolumeFragment$b = this.p;
                if (editorMusicVolumeFragment$b == null) {
                    bl3 = false;
                }
                if (bl3) {
                    editorMusicVolumeFragment$b.h(seekBar, n11, bl2);
                }
            }
        } else {
            EditorMusicVolumeFragment$b editorMusicVolumeFragment$b = this.p;
            if (editorMusicVolumeFragment$b == null) {
                bl3 = false;
            }
            if (bl3) {
                editorMusicVolumeFragment$b.h(seekBar, n11, bl2);
            }
        }
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        switch (n10) {
            default: {
                return false;
            }
            case 6: {
                object = (j4)object;
                return this.C((j4)object, n11);
            }
            case 5: {
                object = (MutableLiveData)object;
                return this.F((MutableLiveData)object, n11);
            }
            case 4: {
                object = (MutableLiveData)object;
                return this.I((MutableLiveData)object, n11);
            }
            case 3: {
                object = (MutableLiveData)object;
                return this.G((MutableLiveData)object, n11);
            }
            case 2: {
                object = (MutableLiveData)object;
                return this.H((MutableLiveData)object, n11);
            }
            case 1: {
                object = (MutableLiveData)object;
                return this.D((MutableLiveData)object, n11);
            }
            case 0: 
        }
        object = (MutableLiveData)object;
        return this.E((MutableLiveData)object, n11);
    }

    public final void r(int n10, int n11) {
        EditorMusicVolumeFragment$b editorMusicVolumeFragment$b = this.p;
        boolean bl2 = editorMusicVolumeFragment$b != null;
        if (bl2) {
            editorMusicVolumeFragment$b.i(n11);
        }
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.q.setLifecycleOwner(lifecycleOwner);
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
            object = (EditorMusicVolumeFragment$b)object;
            this.A((EditorMusicVolumeFragment$b)object);
        }
        return 1 != 0;
    }
}

