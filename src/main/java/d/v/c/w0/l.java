/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.ScrollView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.main.EditorMainActivity$b;
import com.zhiyun.editorsdk.fundation.PlayerWrapperView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.i1.i2;
import d.v.c.w0.k;
import d.v.c.w0.ui;
import l.a.q.g0.u;

public class l
extends k
implements b$a {
    private static final ViewDataBinding$IncludedLayouts J;
    private static final SparseIntArray K;
    private final ImageView A;
    private final View.OnClickListener B;
    private final View.OnClickListener C;
    private final View.OnClickListener D;
    private final View.OnClickListener E;
    private final View.OnClickListener F;
    private final View.OnClickListener G;
    private final View.OnClickListener H;
    private long I;
    private final ConstraintLayout s;
    private final View t;
    private final FrameLayout u;
    private final ImageView v;
    private final TextView w;
    private final ImageView x;
    private final ImageView y;
    private final ImageView z;

    static {
        SparseIntArray sparseIntArray;
        K = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362189, 12);
        sparseIntArray.put(2131362482, 13);
        sparseIntArray.put(2131362995, 14);
        sparseIntArray.put(2131363166, 15);
        sparseIntArray.put(2131362464, 16);
    }

    public l(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = J;
        SparseIntArray sparseIntArray = K;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 17, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private l(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = this;
        Object object3 = dataBindingComponent;
        Object object4 = object = objectArray[3];
        object4 = (Button)object;
        Object object5 = object = objectArray[12];
        object5 = (ConstraintLayout)((Object)object);
        Object object6 = object = objectArray[16];
        object6 = (ConstraintLayout)((Object)object);
        Object object7 = object = objectArray[6];
        object7 = (FrameLayout)object;
        Object object8 = object = objectArray[13];
        object8 = (FrameLayout)object;
        Object object9 = object = objectArray[1];
        object9 = (ImageView)object;
        Object object10 = object = objectArray[14];
        object10 = (PlayerWrapperView)((Object)object);
        Object object11 = object = objectArray[15];
        object11 = (ScrollView)object;
        super(dataBindingComponent, view, 13, (Button)object4, (ConstraintLayout)((Object)object5), (ConstraintLayout)((Object)object6), (FrameLayout)object7, (FrameLayout)object8, (ImageView)object9, null, null, (PlayerWrapperView)((Object)object10), null, null, (ScrollView)object11, null, null, null, null);
        this.I = -1;
        this.a.setTag(null);
        this.d.setTag(null);
        this.f.setTag(null);
        object2 = (ConstraintLayout)((Object)objectArray[0]);
        this.s = object2;
        object2.setTag(null);
        object2 = (View)objectArray[10];
        this.t = object2;
        object2.setTag(null);
        object2 = (FrameLayout)objectArray[11];
        this.u = object2;
        object2.setTag(null);
        int n10 = 2;
        object = (ImageView)objectArray[n10];
        this.v = object;
        object.setTag(null);
        int n11 = 4;
        object4 = (TextView)objectArray[n11];
        this.w = object4;
        object4.setTag(null);
        int n12 = 5;
        object5 = (ImageView)objectArray[n12];
        this.x = object5;
        object5.setTag(null);
        int n13 = 7;
        object6 = (ImageView)objectArray[n13];
        this.y = object6;
        object6.setTag(null);
        object6 = (ImageView)objectArray[8];
        this.z = object6;
        object6.setTag(null);
        object6 = (ImageView)objectArray[9];
        this.A = object6;
        object6.setTag(null);
        object3 = view;
        this.setRootTag(view);
        object3 = new b(this, n12);
        this.B = object3;
        object3 = new b(this, 1);
        this.C = object3;
        object3 = new b(this, 6);
        this.D = object3;
        object3 = new b(this, n10);
        this.E = object3;
        super(this, n13);
        this.F = object2;
        super(this, 3);
        this.G = object2;
        super(this, n11);
        this.H = object2;
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
                long l10 = this.I;
                long l11 = 8;
                this.I = l10 |= l11;
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
                long l10 = this.I;
                long l11 = 4;
                this.I = l10 |= l11;
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
                long l10 = this.I;
                long l11 = 512L;
                this.I = l10 |= l11;
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
                long l10 = this.I;
                long l11 = 2048L;
                this.I = l10 |= l11;
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
                long l10 = this.I;
                long l11 = 1L;
                this.I = l10 |= l11;
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
                long l10 = this.I;
                long l11 = 16;
                this.I = l10 |= l11;
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
                long l10 = this.I;
                long l11 = 128L;
                this.I = l10 |= l11;
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
    private boolean J(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.I;
                long l11 = 64;
                this.I = l10 |= l11;
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
    private boolean K(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.I;
                long l11 = 256L;
                this.I = l10 |= l11;
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
    private boolean L(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.I;
                long l11 = 2;
                this.I = l10 |= l11;
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
    private boolean M(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.I;
                long l11 = 1024L;
                this.I = l10 |= l11;
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
    private boolean N(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.I;
                long l11 = 4096L;
                this.I = l10 |= l11;
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
    private boolean O(ui ui2, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.I;
                long l11 = 32;
                this.I = l10 |= l11;
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
    public void A(EditorMainActivity$b editorMainActivity$b) {
        this.r = editorMainActivity$b;
        synchronized (this) {
            long l10 = this.I;
            long l11 = 16384L;
            this.I = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(i2 i22) {
        this.q = i22;
        synchronized (this) {
            long l10 = this.I;
            long l11 = 8192L;
            this.I = l10 |= l11;
        }
        this.notifyPropertyChanged(50);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        boolean bl2 = true;
        switch (n10) {
            default: {
                break;
            }
            case 7: {
                i2 i22 = this.q;
                if (i22 == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                i22.w2();
                break;
            }
            case 6: {
                i2 i23 = this.q;
                if (i23 == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                i23.K3();
                break;
            }
            case 5: {
                i2 i24 = this.q;
                if (i24 == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                i24.C2();
                break;
            }
            case 4: {
                EditorMainActivity$b editorMainActivity$b = this.r;
                if (editorMainActivity$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                editorMainActivity$b.i();
                break;
            }
            case 3: {
                EditorMainActivity$b editorMainActivity$b = this.r;
                if (editorMainActivity$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                editorMainActivity$b.b(view);
                break;
            }
            case 2: {
                EditorMainActivity$b editorMainActivity$b = this.r;
                if (editorMainActivity$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                editorMainActivity$b.c();
                break;
            }
            case 1: {
                EditorMainActivity$b editorMainActivity$b = this.r;
                if (editorMainActivity$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                editorMainActivity$b.a(view);
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
        block116: {
            block115: {
                block114: {
                    block113: {
                        block109: {
                            block112: {
                                block111: {
                                    block110: {
                                        var1_1 = this;
                                        synchronized (this) {
                                            var2_2 = this.I;
                                            this.I = var4_3 = 0L;
                                        }
                                        var6_4 = this.q;
                                        var7_5 = 49119L & var2_2;
                                        var9_6 = var7_5 == var4_3 ? 0 : (var7_5 < var4_3 ? -1 : 1);
                                        var10_7 = 41088L;
                                        var12_8 = 41024L;
                                        var14_9 = 40976L;
                                        var16_10 = 40968L;
                                        var18_11 = 40964L;
                                        var20_12 = 40962L;
                                        var22_13 = 43520L;
                                        var24_14 = 40961L;
                                        var26_15 = 0x100000L;
                                        var28_16 = 43008L;
                                        var30_17 = 0;
                                        var31_18 = null;
                                        if (var9_6 == false) break block109;
                                        var32_19 = var2_2 & var24_14;
                                        var9_6 = var32_19 == var4_3 ? 0 : (var32_19 < var4_3 ? -1 : 1);
                                        var34_20 = 1;
                                        if (var9_6 != false) {
                                            if (var6_4 != null) {
                                                var35_22 = var6_4.b1();
                                            } else {
                                                var9_6 = 0;
                                                var35_22 = null;
                                            }
                                            var1_1.updateLiveDataRegistration(0, (LiveData)var35_22);
                                            if (var35_22 != null) {
                                                var35_22 = (Boolean)var35_22.getValue();
                                            } else {
                                                var9_6 = 0;
                                                var35_22 = null;
                                            }
                                            var35_22 = ViewDataBinding.safeUnbox((Boolean)var35_22) ^ var34_20;
                                            var9_6 = (long)ViewDataBinding.safeUnbox((Boolean)var35_22);
                                        } else {
                                            var9_6 = 0;
                                            var35_22 = null;
                                        }
                                        var32_19 = var2_2 & var20_12;
                                        var36_23 = var32_19 == var4_3 ? 0 : (var32_19 < var4_3 ? -1 : 1);
                                        if (var36_23 == false) ** GOTO lbl-1000
                                        if (var6_4 != null) {
                                            var37_24 = var6_4.M1();
                                            var31_18 = var37_24;
                                        } else {
                                            var30_17 = 0;
                                            var31_18 = null;
                                        }
                                        var1_1.updateLiveDataRegistration(var34_20, (LiveData)var31_18);
                                        if (var31_18 != null) {
                                            var38_25 = (String)var31_18.getValue();
                                        } else lbl-1000:
                                        // 2 sources

                                        {
                                            var34_20 = 0;
                                            var38_25 = null;
                                        }
                                        var39_26 = var2_2 & var18_11;
                                        var30_17 = var39_26 == var4_3 ? 0 : (var39_26 < var4_3 ? -1 : 1);
                                        if (var30_17 != 0) {
                                            if (var6_4 != null) {
                                                var41_27 = var6_4.F0();
                                                var42_28 = var41_27;
                                            } else {
                                                var43_30 = false;
                                                var42_28 = null;
                                            }
                                            var44_31 = 2;
                                            var1_1.updateLiveDataRegistration(var44_31, (LiveData)var42_28);
                                            if (var42_28 != null) {
                                                var42_28 = (Boolean)var42_28.getValue();
                                            } else {
                                                var43_30 = false;
                                                var42_28 = null;
                                            }
                                            var43_30 = ViewDataBinding.safeUnbox((Boolean)var42_28);
                                            if (var30_17 != 0) {
                                                var45_32 = var43_30 != false ? 0x200000000L : 0x100000000L;
                                                var2_2 |= var45_32;
                                            }
                                            if (var43_30) {
                                                var42_28 = var1_1.y.getContext();
                                                var44_31 = 2131231062;
                                            } else {
                                                var42_28 = var1_1.y.getContext();
                                                var44_31 = 2131231056;
                                            }
                                            var42_28 = AppCompatResources.getDrawable((Context)var42_28, var44_31);
                                        } else {
                                            var43_30 = false;
                                            var42_28 = null;
                                        }
                                        var45_32 = var2_2 & var16_10;
                                        var44_31 = (int)(var45_32 == var4_3 ? 0 : (var45_32 < var4_3 ? -1 : 1));
                                        if (var44_31 != 0) {
                                            if (var6_4 != null) {
                                                var31_18 = var6_4.E0();
                                            } else {
                                                var30_17 = 0;
                                                var31_18 = null;
                                            }
                                            var47_33 = 3;
                                            var1_1.updateLiveDataRegistration(var47_33, (LiveData)var31_18);
                                            if (var31_18 != null) {
                                                var48_36 = (Boolean)var31_18.getValue();
                                            } else {
                                                var47_33 = 0;
                                                var48_36 = null;
                                            }
                                            var47_33 = (int)ViewDataBinding.safeUnbox((Boolean)var48_36);
                                            if (var44_31 != 0) {
                                                var45_32 = var47_33 != 0 ? 0x20000000L : 0x10000000L;
                                                var2_2 |= var45_32;
                                            }
                                            if (var47_33 != 0) {
                                                var48_36 = var1_1.A.getContext();
                                                var49_37 = 2131231057;
                                            } else {
                                                var48_36 = var1_1.A.getContext();
                                                var49_37 = 2131231055;
                                            }
                                            var48_36 = AppCompatResources.getDrawable((Context)var48_36, var49_37);
                                        } else {
                                            var47_34 = false;
                                            var48_36 = null;
                                        }
                                        var45_32 = var2_2 & var14_9;
                                        var49_37 = var45_32 == var4_3 ? 0 : (var45_32 < var4_3 ? -1 : 1);
                                        if (var49_37 == 0) ** GOTO lbl-1000
                                        if (var6_4 != null) {
                                            var50_38 = var6_4.g1();
                                        } else {
                                            var44_31 = 0;
                                            var50_38 = null;
                                        }
                                        var30_17 = 4;
                                        var1_1.updateLiveDataRegistration(var30_17, (LiveData)var50_38);
                                        if (var50_38 != null) {
                                            var50_38 = (Boolean)var50_38.getValue();
                                        } else {
                                            var44_31 = 0;
                                            var50_38 = null;
                                        }
                                        var44_31 = (int)ViewDataBinding.safeUnbox((Boolean)var50_38);
                                        if (var49_37 != 0) {
                                            var51_40 = var44_31 != 0 ? 0x800000L : 0x400000L;
                                            var2_2 |= var51_40;
                                        }
                                        if (var44_31 == 0) {
                                            var49_37 = 8;
                                        } else lbl-1000:
                                        // 2 sources

                                        {
                                            var49_37 = 0;
                                            var53_41 = null;
                                        }
                                        var45_32 = var2_2 & var12_8;
                                        var44_31 = (int)(var45_32 == var4_3 ? 0 : (var45_32 < var4_3 ? -1 : 1));
                                        if (var44_31 != 0) {
                                            if (var6_4 != null) {
                                                var50_38 = var6_4.J1();
                                            } else {
                                                var44_31 = 0;
                                                var50_38 = null;
                                            }
                                            var30_17 = 6;
                                            var1_1.updateLiveDataRegistration(var30_17, (LiveData)var50_38);
                                            if (var50_38 != null) {
                                                var50_38 = (Boolean)var50_38.getValue();
                                            } else {
                                                var44_31 = 0;
                                                var50_38 = null;
                                            }
                                            var44_31 = (int)ViewDataBinding.safeUnbox((Boolean)var50_38);
                                        } else {
                                            var44_31 = 0;
                                            var50_38 = null;
                                        }
                                        var51_40 = var2_2 & var10_7;
                                        var30_17 = (int)(var51_40 == var4_3 ? 0 : (var51_40 < var4_3 ? -1 : 1));
                                        if (var30_17 != 0) {
                                            if (var6_4 != null) {
                                                var54_42 = var6_4.x1();
                                                var55_43 = var54_42;
                                            } else {
                                                var56_44 = 0;
                                                var57_45 = 0.0f;
                                                var55_43 = null;
                                            }
                                            var58_47 = 7;
                                            var1_1.updateLiveDataRegistration(var58_47, (LiveData)var55_43);
                                            if (var55_43 != null) {
                                                var59_48 = (Boolean)var55_43.getValue();
                                            } else {
                                                var58_47 = 0;
                                                var59_48 = null;
                                            }
                                            var58_47 = (int)ViewDataBinding.safeUnbox(var59_48);
                                            if (var30_17 != 0) {
                                                var60_50 = var58_47 != 0 ? 0x8000000L : 0x4000000L;
                                                var2_2 |= var60_50;
                                            }
                                            if (var58_47 != 0) {
                                                var59_48 = var1_1.z.getContext();
                                                var62_51 = 2131231061;
                                            } else {
                                                var59_48 = var1_1.z.getContext();
                                                var62_51 = 2131231060;
                                            }
                                            var59_48 = AppCompatResources.getDrawable((Context)var59_48, (int)var62_51);
                                        } else {
                                            var58_47 = 0;
                                            var59_48 = null;
                                        }
                                        var60_50 = 41216L;
                                        var63_53 = var2_2 & var60_50;
                                        var62_51 = var63_53 == var4_3 ? 0 : (var63_53 < var4_3 ? -1 : 1);
                                        if (var62_51 == false) break block110;
                                        if (var6_4 != null) {
                                            var31_18 = var6_4.K1();
                                        } else {
                                            var30_17 = 0;
                                            var31_18 = null;
                                        }
                                        var56_44 = 8;
                                        var57_45 = 1.1E-44f;
                                        var1_1.updateLiveDataRegistration(var56_44, (LiveData)var31_18);
                                        if (var31_18 != null) {
                                            var31_18 = (Boolean)var31_18.getValue();
                                        } else {
                                            var30_17 = 0;
                                            var31_18 = null;
                                        }
                                        var30_17 = (int)ViewDataBinding.safeUnbox((Boolean)var31_18);
                                        if (var62_51 != false) {
                                            var63_53 = var30_17 != 0 ? 131072L : 65536L;
                                            var2_2 |= var63_53;
                                        }
                                        if (var30_17 != 0) break block111;
                                        var62_51 = var56_44;
                                        break block112;
                                    }
                                    var56_44 = 8;
                                    var57_45 = 1.1E-44f;
                                }
                                var62_51 = 0;
                                var65_54 = null;
                            }
                            var66_55 = 41984L;
                            var63_53 = var2_2 & var66_55;
                            var30_17 = (int)(var63_53 == var4_3 ? 0 : (var63_53 < var4_3 ? -1 : 1));
                            if (var30_17 == 0) ** GOTO lbl-1000
                            if (var6_4 != null) {
                                var68_56 = var6_4.N1();
                                var55_43 = var68_56;
                            } else {
                                var56_44 = 0;
                                var57_45 = 0.0f;
                                var55_43 = null;
                            }
                            var69_57 = 10;
                            var70_58 = 1.4E-44f;
                            var1_1.updateLiveDataRegistration(var69_57, (LiveData)var55_43);
                            if (var55_43 != null) {
                                var71_59 = (Boolean)var55_43.getValue();
                            } else {
                                var69_57 = 0;
                                var70_58 = 0.0f;
                                var71_59 = null;
                            }
                            var69_57 = (int)ViewDataBinding.safeUnbox((Boolean)var71_59);
                            if (var30_17 != 0) {
                                var60_50 = var69_57 != 0 ? 0x800000000L : 0x400000000L;
                                var2_2 |= var60_50;
                            }
                            if (var69_57 == 0) {
                                var69_57 = 8;
                                var70_58 = 1.1E-44f;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var69_57 = 0;
                                var70_58 = 0.0f;
                                var71_59 = null;
                            }
                            var60_50 = var2_2 & var22_13;
                            var63_53 = 0L;
                            var72_60 = var60_50 == var63_53 ? 0 : (var60_50 < var63_53 ? -1 : 1);
                            if (var72_60 != 0) {
                                if (var6_4 != null) {
                                    var31_18 = var6_4.J0();
                                } else {
                                    var30_17 = 0;
                                    var31_18 = null;
                                }
                                var56_44 = 11;
                                var57_45 = 1.5E-44f;
                                var1_1.updateLiveDataRegistration(var56_44, (LiveData)var31_18);
                                if (var31_18 != null) {
                                    var31_18 = (Boolean)var31_18.getValue();
                                } else {
                                    var30_17 = 0;
                                    var31_18 = null;
                                }
                                var30_17 = (int)ViewDataBinding.safeUnbox((Boolean)var31_18);
                                if (var72_60 != 0) {
                                    if (var30_17 != 0) {
                                        var12_8 = 0x200000L;
                                        var2_2 |= var12_8;
                                    } else {
                                        var2_2 |= var26_15;
                                    }
                                }
                                if ((var72_60 = (int)((cfr_temp_0 = (var12_8 = var2_2 & var28_16) - (var63_53 = 0L)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) != 0) {
                                    var12_8 = var30_17 != 0 ? 0x80000000L : 0x40000000L;
                                    var2_2 |= var12_8;
                                }
                                if ((var72_60 = (int)((cfr_temp_1 = (var12_8 = var2_2 & var28_16) - var63_53) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) != 0 && var30_17 == 0) {
                                    var72_60 = 8;
                                    var73_61 = 1.1E-44f;
                                } else {
                                    var72_60 = 0;
                                    var73_61 = 0.0f;
                                }
                            } else {
                                var63_53 = 0L;
                                var72_60 = 0;
                                var73_61 = 0.0f;
                                var30_17 = 0;
                                var31_18 = null;
                            }
                            var12_8 = 45056L;
                            var74_63 = var2_2 & var12_8;
                            var56_44 = (int)(var74_63 == var63_53 ? 0 : (var74_63 < var63_53 ? -1 : 1));
                            if (var56_44 != 0) {
                                if (var6_4 != null) {
                                    var68_56 = var6_4.U1();
                                    var76_64 = var72_60;
                                    var77_65 = var69_57;
                                    var78_66 = var70_58;
                                    var71_59 = var68_56;
                                } else {
                                    var77_65 = var69_57;
                                    var78_66 = var70_58;
                                    var76_64 = var72_60;
                                    var69_57 = 0;
                                    var70_58 = 0.0f;
                                    var71_59 = null;
                                }
                                var72_60 = 12;
                                var73_61 = 1.7E-44f;
                                var1_1.updateLiveDataRegistration(var72_60, (LiveData)var71_59);
                                if (var71_59 != null) {
                                    var71_59 = (Boolean)var71_59.getValue();
                                } else {
                                    var69_57 = 0;
                                    var70_58 = 0.0f;
                                    var71_59 = null;
                                }
                                var69_57 = (int)ViewDataBinding.safeUnbox((Boolean)var71_59);
                                if (var56_44 != 0) {
                                    var79_68 = var69_57 != 0 ? 524288L : 262144L;
                                    var2_2 |= var79_68;
                                }
                                if (var69_57 != 0) {
                                    var69_57 = 0;
                                    var70_58 = 0.0f;
                                    var71_59 = null;
                                } else {
                                    var69_57 = 8;
                                    var70_58 = 1.1E-44f;
                                }
                                var56_44 = var30_17;
                                var72_60 = (int)var77_65;
                                var73_61 = var78_66;
                            } else {
                                var77_65 = var69_57;
                                var78_67 = var70_58;
                                var76_64 = var72_60;
                                var56_44 = var30_17;
                                var72_60 = var69_57;
                                var73_61 = var70_58;
                                var69_57 = 0;
                                var70_58 = 0.0f;
                                var71_59 = null;
                            }
                            var30_17 = var44_31;
                            var44_31 = (int)var62_51;
                            var65_54 = var59_48;
                            var58_47 = var49_37;
                            var53_41 = var48_36;
                            var48_36 = var38_25;
                            var38_25 = var42_28;
                            var43_30 = var9_6;
                            var9_6 = var76_64;
                            break block113;
                        }
                        var69_57 = 0;
                        var70_58 = 0.0f;
                        var71_59 = null;
                        var72_60 = 0;
                        var73_62 = 0.0f;
                        var9_6 = 0;
                        var35_22 = null;
                        var43_30 = false;
                        var42_29 = null;
                        var34_21 = false;
                        var38_25 = null;
                        var47_35 = false;
                        var48_36 = null;
                        var49_37 = 0;
                        var53_41 = null;
                        var58_47 = 0;
                        var59_49 = null;
                        var62_52 = false;
                        var65_54 = null;
                        var44_31 = 0;
                        var50_39 = null;
                        var30_17 = 0;
                        var31_18 = null;
                        var56_44 = 0;
                        var57_46 = 0.0f;
                        var55_43 = null;
                    }
                    var26_15 = var2_2 & var26_15;
                    var63_53 = 0L;
                    var77_65 = var26_15 == var63_53 ? 0 : (var26_15 < var63_53 ? -1 : 1);
                    if (var77_65 == false) break block114;
                    if (var6_4 != null) {
                        var6_4 = var6_4.I0();
                        var81_69 = var53_41;
                    } else {
                        var81_69 = var53_41;
                        var82_70 = 0;
                        var6_4 = null;
                    }
                    var49_37 = 9;
                    var1_1.updateLiveDataRegistration(var49_37, (LiveData)var6_4);
                    if (var6_4 != null) {
                        var6_4 = (Boolean)var6_4.getValue();
                    } else {
                        var82_70 = 0;
                        var6_4 = null;
                    }
                    var82_70 = (int)ViewDataBinding.safeUnbox((Boolean)var6_4);
                    if (var77_65 != false) {
                        var74_63 = var82_70 != 0 ? 0x2000000L : 0x1000000L;
                        var2_2 |= var74_63;
                    }
                    if (var82_70 != 0) break block115;
                    var82_70 = 8;
                    break block116;
                }
                var81_69 = var53_41;
            }
            var82_70 = 0;
            var6_4 = null;
        }
        var22_13 = var2_2 & var22_13;
        var63_53 = 0L;
        var49_37 = (int)(var22_13 == var63_53 ? 0 : (var22_13 < var63_53 ? -1 : 1));
        if (var49_37 != 0) {
            if (var56_44 != 0) {
                var82_70 = 8;
            }
        } else {
            var82_70 = 0;
            var6_4 = null;
        }
        if ((var56_44 = (cfr_temp_2 = (var12_8 = 32768L & var2_2) - var63_53) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != 0) {
            var55_43 = var1_1.a;
            var77_65 = var30_17;
            var31_18 = var1_1.G;
            var55_43.setOnClickListener((View.OnClickListener)var31_18);
            var31_18 = var1_1.f;
            var55_43 = var1_1.C;
            var31_18.setOnClickListener((View.OnClickListener)var55_43);
            var31_18 = var1_1.v;
            var55_43 = var1_1.E;
            var31_18.setOnClickListener((View.OnClickListener)var55_43);
            var31_18 = var1_1.x;
            var55_43 = var1_1.H;
            var31_18.setOnClickListener((View.OnClickListener)var55_43);
            var31_18 = var1_1.y;
            var55_43 = var1_1.B;
            var31_18.setOnClickListener((View.OnClickListener)var55_43);
            var31_18 = var1_1.A;
            var55_43 = var1_1.F;
            var31_18.setOnClickListener((View.OnClickListener)var55_43);
        } else {
            var77_65 = var30_17;
        }
        var60_50 = var2_2 & var28_16;
        var22_13 = 0L;
        var30_17 = (int)(var60_50 == var22_13 ? 0 : (var60_50 < var22_13 ? -1 : 1));
        if (var30_17 != 0) {
            var31_18 = var1_1.d;
            var31_18.setVisibility((int)var9_6);
        }
        if (var49_37 != 0) {
            var35_22 = var1_1.t;
            var35_22.setVisibility(var82_70);
        }
        if ((var82_70 = (int)((cfr_temp_3 = (var60_50 = var2_2 & var24_14) - (var22_13 = 0L)) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.u;
            var6_4.setClickable(var43_30);
        }
        if ((var82_70 = (int)((cfr_temp_4 = (var7_5 = 45056L & var2_2) - var22_13) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.w;
            var6_4.setVisibility(var69_57);
        }
        if ((var82_70 = (int)((cfr_temp_5 = (var7_5 = var2_2 & var20_12) - var22_13) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.w;
            var69_57 = 0;
            var70_58 = 0.0f;
            var71_59 = null;
            l.a.q.g0.u.n((TextView)var6_4, (String)var48_36, null, null);
        }
        if ((var82_70 = (int)((cfr_temp_6 = (var7_5 = var2_2 & var14_9) - var22_13) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.x;
            var6_4.setVisibility(var58_47);
        }
        if ((var82_70 = (int)((cfr_temp_7 = (var7_5 = var2_2 & var18_11) - var22_13) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.y;
            ImageViewBindingAdapter.setImageDrawable((ImageView)var6_4, (Drawable)var38_25);
        }
        if ((var82_70 = (int)((cfr_temp_8 = (var7_5 = 41984L & var2_2) - var22_13) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1))) != 0) {
            var1_1.y.setVisibility(var72_60);
            var6_4 = var1_1.A;
            var6_4.setVisibility(var72_60);
        }
        if ((var82_70 = (int)((cfr_temp_9 = (var4_3 = 41216L & var2_2) - var22_13) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.z;
            var6_4.setVisibility(var44_31);
        }
        if ((var82_70 = (int)((cfr_temp_10 = (var4_3 = 41088L & var2_2) - var22_13) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.z;
            ImageViewBindingAdapter.setImageDrawable((ImageView)var6_4, (Drawable)var65_54);
        }
        if ((var82_70 = (int)((cfr_temp_11 = (var4_3 = 41024L & var2_2) - var22_13) == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.z;
            var71_59 = var1_1.D;
            var44_31 = (int)var77_65;
            ViewBindingAdapter.setOnClick((View)var6_4, (View.OnClickListener)var71_59, (boolean)var77_65);
        }
        if ((var82_70 = (int)((cfr_temp_12 = (var2_2 &= var16_10) - var22_13) == 0L ? 0 : (cfr_temp_12 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.A;
            var48_36 = var81_69;
            ImageViewBindingAdapter.setImageDrawable((ImageView)var6_4, (Drawable)var81_69);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.I;
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
            this.I = l10 = 32768L;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        switch (n10) {
            default: {
                return false;
            }
            case 12: {
                object = (MutableLiveData)object;
                return this.N((MutableLiveData)object, n11);
            }
            case 11: {
                object = (MutableLiveData)object;
                return this.F((MutableLiveData)object, n11);
            }
            case 10: {
                object = (MutableLiveData)object;
                return this.M((MutableLiveData)object, n11);
            }
            case 9: {
                object = (MutableLiveData)object;
                return this.E((MutableLiveData)object, n11);
            }
            case 8: {
                object = (MutableLiveData)object;
                return this.K((MutableLiveData)object, n11);
            }
            case 7: {
                object = (MutableLiveData)object;
                return this.I((MutableLiveData)object, n11);
            }
            case 6: {
                object = (MutableLiveData)object;
                return this.J((MutableLiveData)object, n11);
            }
            case 5: {
                object = (ui)object;
                return this.O((ui)object, n11);
            }
            case 4: {
                object = (MutableLiveData)object;
                return this.H((MutableLiveData)object, n11);
            }
            case 3: {
                object = (MutableLiveData)object;
                return this.C((MutableLiveData)object, n11);
            }
            case 2: {
                object = (MutableLiveData)object;
                return this.D((MutableLiveData)object, n11);
            }
            case 1: {
                object = (MutableLiveData)object;
                return this.L((MutableLiveData)object, n11);
            }
            case 0: 
        }
        object = (MutableLiveData)object;
        return this.G((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 50;
        if (n11 == n10) {
            object = (i2)object;
            this.B((i2)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 != n10) return 0 != 0;
            object = (EditorMainActivity$b)object;
            this.A((EditorMainActivity$b)object);
        }
        return 1 != 0;
    }
}

