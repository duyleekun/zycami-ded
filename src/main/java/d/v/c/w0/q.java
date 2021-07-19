/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewStub
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.ViewStubProxy;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity$e;
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import com.zhiyun.cama.widget.LineProgressBar;
import com.zhiyun.cama.widget.MediaConstrainLayout;
import com.zhiyun.cama.widget.ThumbnailView;
import com.zhiyun.cama.widget.ZYTextView;
import com.zhiyun.editorsdk.fundation.PlayerWrapperView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.f1.a.c;
import d.v.c.f1.a.c$a;
import d.v.c.f1.a.k$a;
import d.v.c.f1.a.l;
import d.v.c.f1.a.l$a;
import d.v.c.f1.a.m;
import d.v.c.f1.a.m$a;
import d.v.c.f1.a.p$a;
import d.v.c.r0.c$b;
import d.v.c.r0.c$c;
import d.v.c.r0.d;
import d.v.c.r0.d$b;
import d.v.c.r0.d$c;
import d.v.c.r0.d$d;
import d.v.c.u1.k;
import d.v.c.w0.p;
import d.v.c.w0.wi;
import d.v.e.l.l2;
import d.v.f.e.a;
import l.a.q.g0.u;

public class q
extends p
implements l$a,
c$a,
p$a,
k$a,
b$a,
m$a {
    private static final ViewDataBinding$IncludedLayouts D;
    private static final SparseIntArray E;
    private final View.OnClickListener A;
    private final View.OnClickListener B;
    private long C;
    private final ConstraintLayout r;
    private final ImageView s;
    private final ZYTextView t;
    private final c$b u;
    private final d$b v;
    private final c$c w;
    private final d$c x;
    private final View.OnClickListener y;
    private final d$d z;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        D = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(17);
        String[] stringArray = new String[]{"widget_titlebar_no_button"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 12;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558817;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        E = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131363267, 5);
        viewDataBinding$IncludedLayouts.put(2131362467, 13);
        viewDataBinding$IncludedLayouts.put(2131362995, 14);
        viewDataBinding$IncludedLayouts.put(2131362234, 15);
        viewDataBinding$IncludedLayouts.put(2131362464, 16);
    }

    public q(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = D;
        SparseIntArray sparseIntArray = E;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 17, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private q(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = this;
        Object object3 = this;
        Object object4 = dataBindingComponent;
        ConstraintLayout constraintLayout = (ConstraintLayout)((Object)objectArray[15]);
        FrameLayout frameLayout = (FrameLayout)objectArray[16];
        FrameLayout frameLayout2 = (FrameLayout)objectArray[13];
        FrameLayout frameLayout3 = (FrameLayout)objectArray[11];
        int n10 = 6;
        FrameLayout frameLayout4 = (FrameLayout)objectArray[n10];
        ImageView imageView = (ImageView)objectArray[4];
        LineProgressBar lineProgressBar = (LineProgressBar)((Object)objectArray[2]);
        PlayerWrapperView playerWrapperView = (PlayerWrapperView)((Object)objectArray[14]);
        RecyclerView recyclerView = (RecyclerView)objectArray[10];
        MediaConstrainLayout mediaConstrainLayout = (MediaConstrainLayout)((Object)objectArray[1]);
        object3 = object = objectArray[5];
        object3 = (ViewStub)object;
        object2 = new ViewStubProxy((ViewStub)object3);
        object3 = (wi)objectArray[12];
        int n11 = n10;
        Object object5 = object3;
        object = (View)objectArray[8];
        ThumbnailView thumbnailView = (ThumbnailView)objectArray[7];
        n11 = 6;
        object3 = this;
        super(dataBindingComponent, view, n11, constraintLayout, frameLayout, frameLayout2, frameLayout3, frameLayout4, imageView, lineProgressBar, playerWrapperView, recyclerView, mediaConstrainLayout, (ViewStubProxy)object2, (wi)object5, (View)object, thumbnailView);
        this.C = -1;
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        object3 = (ConstraintLayout)((Object)objectArray[0]);
        this.r = object3;
        object3.setTag(null);
        int n12 = 3;
        object2 = (ImageView)objectArray[n12];
        this.s = object2;
        object2.setTag(null);
        this.t = object2 = (ZYTextView)objectArray[9];
        object2.setTag(null);
        this.g.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setContainingBinding(this);
        object2 = this.l;
        this.setContainedBinding((ViewDataBinding)object2);
        this.m.setTag(null);
        this.n.setTag(null);
        object4 = view;
        this.setRootTag(view);
        this.u = object4 = new l(this, 1);
        this.v = object4 = new c(this, 5);
        this.w = object4 = new d.v.c.f1.a.p(this, 2);
        this.x = object4 = new d.v.c.f1.a.k(this, 6);
        object4 = new b(this, n12);
        this.y = object4;
        object3 = new m(this, 7);
        this.z = object3;
        object3 = new b(this, 8);
        this.A = object3;
        object3 = new b(this, 4);
        this.B = object3;
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
                long l10 = this.C;
                long l11 = 16;
                this.C = l10 |= l11;
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
                long l10 = this.C;
                long l11 = 1L;
                this.C = l10 |= l11;
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
                long l10 = this.C;
                long l11 = 32;
                this.C = l10 |= l11;
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
                long l10 = this.C;
                long l11 = 8;
                this.C = l10 |= l11;
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
                long l10 = this.C;
                long l11 = 2;
                this.C = l10 |= l11;
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
    private boolean J(wi wi2, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.C;
                long l11 = 4;
                this.C = l10 |= l11;
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
    public void B(EditorTemplateEditActivity$e editorTemplateEditActivity$e) {
        this.o = editorTemplateEditActivity$e;
        synchronized (this) {
            long l10 = this.C;
            long l11 = 256L;
            this.C = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(TemplateEditViewModel templateEditViewModel) {
        this.p = templateEditViewModel;
        synchronized (this) {
            long l10 = this.C;
            long l11 = 128L;
            this.C = l10 |= l11;
        }
        this.notifyPropertyChanged(47);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(k k10) {
        this.q = k10;
        synchronized (this) {
            long l10 = this.C;
            long l11 = 64;
            this.C = l10 |= l11;
        }
        this.notifyPropertyChanged(147);
        super.requestRebind();
    }

    public final void a(int n10, View object) {
        int n11 = 3;
        int n12 = 1;
        if (n10 != n11) {
            n11 = 4;
            if (n10 != n11) {
                n11 = 8;
                if (n10 == n11) {
                    int n13;
                    EditorTemplateEditActivity$e editorTemplateEditActivity$e = this.o;
                    object = this.p;
                    k k10 = this.q;
                    int n14 = k10 != null ? n12 : 0;
                    if (n14 != 0 && (n13 = k10.g()) != 0) {
                        if (object != null) {
                            n13 = n12;
                        } else {
                            n13 = 0;
                            k10 = null;
                        }
                        if (n13 != 0) {
                            if ((object = ((TemplateEditViewModel)object).d0()) != null) {
                                n13 = n12;
                            } else {
                                n13 = 0;
                                k10 = null;
                            }
                            if (n13 != 0) {
                                n13 = (Integer)(object = (Integer)((LiveData)object).getValue());
                                if (n13 != (n14 = -1)) {
                                    n13 = n12;
                                } else {
                                    n13 = 0;
                                    k10 = null;
                                }
                                if (n13 != 0) {
                                    if (editorTemplateEditActivity$e == null) {
                                        n12 = 0;
                                    }
                                    if (n12 != 0) {
                                        n11 = (Integer)object;
                                        editorTemplateEditActivity$e.i(n11);
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                TemplateEditViewModel templateEditViewModel = this.p;
                if (templateEditViewModel == null) {
                    n12 = 0;
                }
                if (n12 != 0) {
                    templateEditViewModel.V0();
                }
            }
        } else {
            TemplateEditViewModel templateEditViewModel = this.p;
            if (templateEditViewModel != null) {
                n11 = n12;
            } else {
                n11 = 0;
                object = null;
            }
            if (n11 != 0) {
                object = templateEditViewModel.V();
                if (object == null) {
                    n12 = 0;
                }
                if (n12 != 0 && (n11 = (int)(((Boolean)(object = (Boolean)((LiveData)object).getValue())).booleanValue() ? 1 : 0)) == 0) {
                    templateEditViewModel.A0();
                }
            }
        }
    }

    public final void c(int n10) {
        EditorTemplateEditActivity$e editorTemplateEditActivity$e = this.o;
        boolean bl2 = editorTemplateEditActivity$e != null;
        if (bl2) {
            editorTemplateEditActivity$e.k();
        }
    }

    public final void d(int n10, boolean bl2, int n11, d.v.h.e.a a10) {
        EditorTemplateEditActivity$e editorTemplateEditActivity$e = this.o;
        boolean bl3 = editorTemplateEditActivity$e != null;
        if (bl3) {
            editorTemplateEditActivity$e.h(bl2, n11, a10);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block81: {
            block82: {
                block79: {
                    block80: {
                        var1_1 = this;
                        synchronized (this) {
                            var2_2 = this.C;
                            this.C = var4_3 = 0L;
                        }
                        var6_4 = this.q;
                        var7_5 = this.p;
                        var8_6 = this.o;
                        var9_7 = 736L;
                        var11_8 = var2_2 & var9_7;
                        var13_9 /* !! */  = var11_8 == var4_3 ? 0 : (var11_8 < var4_3 ? -1 : 1);
                        var14_10 = 0x200000L;
                        var16_11 = 0;
                        var17_12 = null;
                        if (var13_9 /* !! */  != false) {
                            if (var6_4 != null) {
                                var18_13 = var6_4.g();
                            } else {
                                var18_13 = 0;
                                var6_4 = null;
                            }
                            if (var13_9 /* !! */  != false) {
                                if (var18_13 != 0) {
                                    var2_2 |= var14_10;
                                } else {
                                    var19_14 = 0x100000L;
                                    var2_2 |= var19_14;
                                }
                            }
                        } else {
                            var18_13 = 0;
                            var6_4 = null;
                        }
                        var19_14 = 699L & var2_2;
                        var13_9 /* !! */  = var19_14 == var4_3 ? 0 : (var19_14 < var4_3 ? -1 : 1);
                        var21_15 = 262144L;
                        var23_16 = 32768L;
                        var25_17 = 8192L;
                        var27_18 = 16384L;
                        var29_19 = 4096L;
                        var31_20 = 0x2002A0L;
                        var33_21 = -1;
                        var34_22 = 656L;
                        var36_23 = 5;
                        var37_24 = 7.0E-45f;
                        var38_25 = 648L;
                        var40_26 = 642L;
                        var42_27 = 641L;
                        var44_28 = 672L;
                        var46_29 = 8;
                        var47_30 = 1.1E-44f;
                        var48_31 = '\u0001';
                        if (var13_9 /* !! */  == false) break block79;
                        var49_32 = var2_2 & var42_27;
                        cfr_temp_0 = var49_32 - var4_3;
                        var13_9 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                        if (var13_9 /* !! */  != false) {
                            if (var7_5 != null) {
                                var51_33 = var7_5.a0();
                            } else {
                                var13_9 /* !! */  = 0;
                                var52_36 = 0.0f;
                                var51_33 = null;
                            }
                            var1_1.updateLiveDataRegistration(0, (LiveData)var51_33);
                            if (var51_33 != null) {
                                var51_33 = (Float)var51_33.getValue();
                            } else {
                                var13_9 /* !! */  = 0;
                                var52_36 = 0.0f;
                                var51_33 = null;
                            }
                            var52_36 = ViewDataBinding.safeUnbox((Float)var51_33);
                            var53_39 = 1120403456;
                            var54_40 = 100.0f;
                            var13_9 /* !! */  = (int)(var52_36 *= var54_40);
                        } else {
                            var13_9 /* !! */  = 0;
                            var51_34 = null;
                            var52_37 = 0.0f;
                        }
                        var49_32 = var2_2 & var40_26;
                        var53_39 = var49_32 == var4_3 ? 0 : (var49_32 < var4_3 ? -1 : 1);
                        if (var53_39 != false) {
                            if (var7_5 != null) {
                                var55_41 = var7_5.m0();
                                var17_12 = var55_41;
                            } else {
                                var16_11 = 0;
                                var17_12 = null;
                            }
                            var1_1.updateLiveDataRegistration(var48_31, (LiveData)var17_12);
                            if (var17_12 != null) {
                                var17_12 = (Boolean)var17_12.getValue();
                            } else {
                                var16_11 = 0;
                                var17_12 = null;
                            }
                            var16_11 = ViewDataBinding.safeUnbox((Boolean)var17_12);
                            if (var53_39 != false) {
                                var56_42 = var16_11 != 0 ? 2048L : 1024L;
                                var2_2 |= var56_42;
                            }
                            if (var16_11 != 0) {
                                var17_12 = var1_1.f.getContext();
                                var58_43 = 2131231091;
                                var59_46 = AppCompatResources.getDrawable((Context)var17_12, var58_43);
                            } else {
                                var59_46 = var1_1.f.getContext();
                                var16_11 = 2131231090;
                                var59_46 = AppCompatResources.getDrawable(var59_46, var16_11);
                            }
                        } else {
                            var58_44 = false;
                            var59_46 = null;
                        }
                        var56_42 = var2_2 & var38_25;
                        var16_11 = var56_42 == var4_3 ? 0 : (var56_42 < var4_3 ? -1 : 1);
                        if (var16_11 != 0) {
                            if (var7_5 != null) {
                                var17_12 = var7_5.f0();
                            } else {
                                var16_11 = 0;
                                var17_12 = null;
                            }
                            var48_31 = '\u0003';
                            var1_1.updateLiveDataRegistration(var48_31, (LiveData)var17_12);
                            if (var17_12 != null) {
                                var60_47 = (Long)var17_12.getValue();
                            } else {
                                var48_31 = '\u0000';
                                var60_47 = null;
                            }
                            var19_14 = ViewDataBinding.safeUnbox((Long)var60_47);
                            var60_47 = String.valueOf(l2.a(var19_14, 2));
                            var17_12 = new StringBuilder();
                            var17_12.append((String)var60_47);
                            var48_31 = 'S';
                            var17_12.append(var48_31);
                            var60_47 = var17_12.toString();
                        } else {
                            var48_31 = '\u0000';
                            var60_47 = null;
                        }
                        var61_48 = var2_2 & var34_22;
                        var16_11 = var61_48 == var4_3 ? 0 : (var61_48 < var4_3 ? -1 : 1);
                        var63_49 = 4 != 0;
                        if (var16_11 == 0) ** GOTO lbl-1000
                        if (var7_5 != null) {
                            var64_50 = var7_5.V();
                        } else {
                            var65_51 = 0;
                            var64_50 = null;
                        }
                        var1_1.updateLiveDataRegistration((int)var63_49, (LiveData)var64_50);
                        if (var64_50 != null) {
                            var64_50 = (Boolean)var64_50.getValue();
                        } else {
                            var65_51 = 0;
                            var64_50 = null;
                        }
                        var65_51 = ViewDataBinding.safeUnbox((Boolean)var64_50);
                        if (var16_11 != 0) {
                            var66_52 = var65_51 != 0 ? 131072L : 65536L;
                            var2_2 |= var66_52;
                        }
                        if (var65_51 != 0) {
                            var16_11 = var46_29;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var16_11 = 0;
                            var17_12 = null;
                        }
                        var66_52 = var2_2 & var44_28;
                        var65_51 = var66_52 == var4_3 ? 0 : (var66_52 < var4_3 ? -1 : 1);
                        if (var65_51 == 0) break block80;
                        if (var7_5 != null) {
                            var68_53 = var7_5.d0();
                            var69_54 = var68_53;
                        } else {
                            var63_49 = false;
                            var69_54 = null;
                        }
                        var1_1.updateLiveDataRegistration(var36_23, (LiveData)var69_54);
                        var70_55 = var69_54 != null ? (Integer)var69_54.getValue() : null;
                        var36_23 = ViewDataBinding.safeUnbox((Integer)var70_55);
                        if (var36_23 == var33_21) {
                            var36_23 = 1;
                            var37_24 = 1.4E-45f;
                        } else {
                            var36_23 = 0;
                            var37_24 = 0.0f;
                        }
                        if (var65_51 != 0) {
                            var2_2 = var36_23 != 0 ? var2_2 | var25_17 | var23_16 : var2_2 | var29_19 | var27_18;
                        }
                        if ((var65_51 = (int)((cfr_temp_1 = (var71_56 = var2_2 & var31_20) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) != 0) {
                            if (var36_23 != 0) {
                                var73_57 = 524288L;
                                var2_2 |= var73_57;
                            } else {
                                var2_2 |= var21_15;
                            }
                        }
                        if (var36_23 != 0) {
                            var65_51 = 0;
                            var64_50 = null;
                        } else {
                            var65_51 = 4;
                        }
                        if (var36_23 != 0) {
                            var75_58 = 4;
                            var76_59 = 5.6E-45f;
                        } else {
                            var75_58 = 0;
                            var76_60 = 0.0f;
                            var68_53 = null;
                        }
                        if (var36_23 != 0) {
                            var36_23 = var46_29;
                            var37_24 = var47_30;
                        } else {
                            var36_23 = 0;
                            var37_24 = 0.0f;
                        }
                        var77_61 = var75_58;
                        break block81;
                    }
                    var36_23 = 0;
                    var37_24 = 0.0f;
                    break block82;
                }
                var36_23 = 0;
                var37_24 = 0.0f;
                var13_9 /* !! */  = 0;
                var52_38 = 0.0f;
                var51_35 = null;
                var48_31 = '\u0000';
                var60_47 = null;
                var58_45 = false;
                var59_46 = null;
                var16_11 = 0;
                var17_12 = null;
            }
            var63_49 = false;
            var69_54 = null;
            var65_51 = 0;
            var64_50 = null;
            var70_55 = null;
            var77_61 = 0;
        }
        var78_62 = var2_2 & 0x200000L;
        var80_63 = var78_62 == var4_3 ? 0 : (var78_62 < var4_3 ? -1 : 1);
        if (var80_63 != false) {
            if (var7_5 != null) {
                var69_54 = var7_5.d0();
            }
            var81_64 = 5;
            var1_1.updateLiveDataRegistration(var81_64, (LiveData)var69_54);
            if (var69_54 != null) {
                var70_55 = var7_5 = var69_54.getValue();
                var70_55 = (Integer)var7_5;
            }
            if ((var81_64 = ViewDataBinding.safeUnbox(var70_55)) == var33_21) {
                var81_64 = 1;
            } else {
                var81_64 = 0;
                var7_5 = null;
            }
            var9_7 = var2_2 & var44_28;
            var33_21 = (int)(var9_7 == var4_3 ? 0 : (var9_7 < var4_3 ? -1 : 1));
            if (var33_21 != 0) {
                var2_2 = var81_64 != 0 ? var2_2 | var25_17 | var23_16 : var2_2 | var29_19 | var27_18;
            }
            if ((var33_21 = (int)((cfr_temp_2 = (var9_7 = var2_2 & var31_20) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) != 0) {
                if (var81_64 != 0) {
                    var9_7 = 524288L;
                    var2_2 |= var9_7;
                } else {
                    var2_2 |= var21_15;
                }
            }
            if (var81_64 != 0) {
                var36_23 = var46_29;
                var37_24 = var47_30;
            } else {
                var36_23 = 0;
                var37_24 = 0.0f;
            }
        }
        if ((var81_64 = (int)((cfr_temp_3 = (var21_15 = var2_2 & 736L) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) != 0) {
            if (var18_13 != 0) {
                var46_29 = var36_23;
                var47_30 = var37_24;
            }
            var18_13 = var46_29;
        } else {
            var18_13 = 0;
            var6_4 = null;
        }
        var21_15 = var2_2 & 512L;
        var33_21 = (int)(var21_15 == var4_3 ? 0 : (var21_15 < var4_3 ? -1 : 1));
        if (var33_21 != 0) {
            var82_65 /* !! */  = var1_1.d;
            var69_54 = var1_1.A;
            var82_65 /* !! */ .setOnClickListener((View.OnClickListener)var69_54);
            var82_65 /* !! */  = var1_1.f;
            var69_54 = var1_1.B;
            var82_65 /* !! */ .setOnClickListener((View.OnClickListener)var69_54);
            var82_65 /* !! */  = var1_1.s;
            var69_54 = var1_1.y;
            var82_65 /* !! */ .setOnClickListener((View.OnClickListener)var69_54);
            var82_65 /* !! */  = var1_1.i;
            var63_49 = true;
            d.v.f.e.a.a((RecyclerView)var82_65 /* !! */ , var63_49);
            var82_65 /* !! */  = var1_1.j;
            var69_54 = var1_1.u;
            var83_66 /* !! */  = var1_1.w;
            d.v.c.r0.c.a((MediaConstrainLayout)var82_65 /* !! */ , (c$b)var69_54, (c$c)var83_66 /* !! */ );
            var83_66 /* !! */  = var1_1.n;
            var84_67 = var1_1.x;
            var82_65 /* !! */  = var1_1.z;
            var69_54 = var1_1.v;
            d.v.c.r0.d.a((ThumbnailView)var83_66 /* !! */ , var84_67, (d$d)var82_65 /* !! */ , (d$b)var69_54);
            var85_68 = ViewDataBinding.getBuildSdkInt();
            var86_69 = 21;
            if (var85_68 >= var86_69) {
                var83_66 /* !! */  = var1_1.e;
                var86_69 = 1;
                var83_66 /* !! */ .setClipToOutline((boolean)var86_69);
            }
        }
        if (var81_64 != 0) {
            var83_66 /* !! */  = var1_1.d;
            var83_66 /* !! */ .setVisibility(var18_13);
        }
        if ((var18_13 = (int)((cfr_temp_4 = (var4_3 = var2_2 & var40_26) - (var21_15 = 0L)) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.f;
            ImageViewBindingAdapter.setImageDrawable((ImageView)var6_4, (Drawable)var59_46);
        }
        if ((var18_13 = (int)((cfr_temp_5 = (var4_3 = var2_2 & var44_28) - var21_15) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) != 0) {
            var1_1.f.setVisibility(var36_23);
            var1_1.g.setVisibility(var65_51);
            var6_4 = var1_1.m;
            var85_68 = var77_61;
            var6_4.setVisibility(var77_61);
        }
        if ((var18_13 = (int)((cfr_temp_6 = (var4_3 = var2_2 & var34_22) - var21_15) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.s;
            var6_4.setVisibility(var16_11);
        }
        if ((var18_13 = (int)((cfr_temp_7 = (var4_3 = var2_2 & var38_25) - var21_15) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.t;
            var85_68 = 0;
            var83_66 /* !! */  = null;
            l.a.q.g0.u.n((TextView)var6_4, (String)var60_47, null, null);
        }
        if ((var18_13 = (int)((cfr_temp_8 = (var4_3 = var2_2 & var42_27) - var21_15) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.g;
            var6_4.setProgress((int)var13_9 /* !! */ );
        }
        if ((var18_13 = (int)((cfr_temp_9 = (var2_2 &= (var4_3 = 768L)) - var21_15) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.k;
            var18_13 = (int)var6_4.isInflated();
            if (var18_13 != 0) {
                var6_4 = var1_1.k.getBinding();
                var87_70 = 25;
                var6_4.setVariable(var87_70, var8_6);
            }
            var6_4 = var1_1.l;
            var6_4.z(var8_6);
        }
        ViewDataBinding.executeBindingsOn(var1_1.l);
        var6_4 = var1_1.k.getBinding();
        if (var6_4 != null) {
            var6_4 = var1_1.k.getBinding();
            ViewDataBinding.executeBindingsOn((ViewDataBinding)var6_4);
        }
    }

    public final void f(int n10, RecyclerView recyclerView, long l10) {
        EditorTemplateEditActivity$e editorTemplateEditActivity$e = this.o;
        boolean bl2 = editorTemplateEditActivity$e != null;
        if (bl2) {
            editorTemplateEditActivity$e.f(recyclerView, l10);
        }
    }

    public final void g(int n10) {
        EditorTemplateEditActivity$e editorTemplateEditActivity$e = this.o;
        boolean bl2 = editorTemplateEditActivity$e != null;
        if (bl2) {
            editorTemplateEditActivity$e.j();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.C;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            wi wi2 = this.l;
            l12 = (long)wi2.hasPendingBindings();
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
            this.C = l10 = 512L;
        }
        this.l.invalidateAll();
        this.requestRebind();
    }

    public final void l(int n10, int n11) {
        EditorTemplateEditActivity$e editorTemplateEditActivity$e = this.o;
        boolean bl2 = editorTemplateEditActivity$e != null;
        if (bl2) {
            editorTemplateEditActivity$e.g(n11);
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
                        n12 = 4;
                        if (n10 != n12) {
                            n12 = 5;
                            if (n10 != n12) {
                                return false;
                            }
                            object = (MutableLiveData)object;
                            return this.G((MutableLiveData)object, n11);
                        }
                        object = (MutableLiveData)object;
                        return this.E((MutableLiveData)object, n11);
                    }
                    object = (MutableLiveData)object;
                    return this.H((MutableLiveData)object, n11);
                }
                object = (wi)object;
                return this.J((wi)object, n11);
            }
            object = (MutableLiveData)object;
            return this.I((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.F((MutableLiveData)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.l.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 147;
        if (n11 == n10) {
            object = (k)object;
            this.D((k)object);
            return 1 != 0;
        } else {
            n11 = 47;
            if (n11 == n10) {
                object = (TemplateEditViewModel)object;
                this.C((TemplateEditViewModel)object);
                return 1 != 0;
            } else {
                n11 = 25;
                if (n11 != n10) return 0 != 0;
                object = (EditorTemplateEditActivity$e)object;
                this.B((EditorTemplateEditActivity$e)object);
            }
        }
        return 1 != 0;
    }
}

