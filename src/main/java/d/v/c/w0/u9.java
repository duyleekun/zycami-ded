/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.ImageButton
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.device.connection.BleDevice;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.i1.s2.r$c;
import d.v.c.i1.s2.s;
import d.v.c.w0.r9;
import d.v.c.w0.t9;
import d.v.f.e.c;
import d.v.g.g.c1;
import l.a.q.g0.u;

public class u9
extends t9
implements b$a {
    private static final ViewDataBinding$IncludedLayouts q;
    private static final SparseIntArray r;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private long p;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        q = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(9);
        String[] stringArray = new String[]{"home_firmware_upgrade_notice_layout"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 7;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558614;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        r = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131362512, 8);
    }

    public u9(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = q;
        SparseIntArray sparseIntArray = r;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 9, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private u9(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[6];
        object2 = (Button)object;
        Object object3 = object = objectArray[0];
        object3 = (ConstraintLayout)((Object)object);
        Object object4 = object = objectArray[4];
        object4 = (CardView)((Object)object);
        Object object5 = object = objectArray[1];
        object5 = (FrameLayout)object;
        Object object6 = object = objectArray[8];
        object6 = (FragmentContainerView)((Object)object);
        int n10 = 2;
        Object object7 = object = objectArray[n10];
        object7 = (ImageButton)object;
        int n11 = 3;
        Object object8 = object = objectArray[n11];
        object8 = (ImageButton)object;
        Object object9 = object = objectArray[5];
        object9 = (TextView)object;
        Object object10 = object = objectArray[7];
        object10 = (r9)object;
        object = this;
        super(dataBindingComponent, view, 5, (Button)object2, (ConstraintLayout)((Object)object3), (CardView)((Object)object4), (FrameLayout)object5, (FragmentContainerView)((Object)object6), (ImageButton)object7, (ImageButton)object8, (TextView)object9, (r9)object10);
        this.p = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        object = this.i;
        this.setContainedBinding((ViewDataBinding)object);
        object = view;
        this.setRootTag(view);
        object = new b(this, n10);
        this.m = object;
        object = new b(this, n11);
        this.n = object;
        object = new b(this, 1);
        this.o = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(MediatorLiveData mediatorLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.p;
                long l11 = 16;
                this.p = l10 |= l11;
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
    private boolean F(r9 r92, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.p;
                long l11 = 4;
                this.p = l10 |= l11;
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
                long l10 = this.p;
                long l11 = 1L;
                this.p = l10 |= l11;
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
                long l10 = this.p;
                long l11 = 8;
                this.p = l10 |= l11;
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
                long l10 = this.p;
                long l11 = 2;
                this.p = l10 |= l11;
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
    public void B(r$c r$c) {
        this.j = r$c;
        synchronized (this) {
            long l10 = this.p;
            long l11 = 64;
            this.p = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(c1 c12) {
        this.l = c12;
        synchronized (this) {
            long l10 = this.p;
            long l11 = 32;
            this.p = l10 |= l11;
        }
        this.notifyPropertyChanged(63);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(s s10) {
        this.k = s10;
        synchronized (this) {
            long l10 = this.p;
            long l11 = 128L;
            this.p = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                int n14 = 3;
                if (n10 == n14) {
                    r$c r$c = this.j;
                    Object object = this.k;
                    int n15 = object != null ? n12 : 0;
                    if (n15 != 0 && (n15 = (object = ((s)object).a) != null ? n12 : 0) != 0) {
                        n14 = (Integer)(object = (Integer)((LiveData)object).getValue());
                        n13 = n14 == n13 ? n12 : 0;
                        if (n13 != 0) {
                            if (r$c != null) {
                                n11 = n12;
                            }
                            if (n11 != 0) {
                                r$c.c();
                            }
                        } else {
                            if (r$c != null) {
                                n11 = n12;
                            }
                            if (n11 != 0) {
                                r$c.d();
                            }
                        }
                    }
                }
            } else {
                r$c r$c = this.j;
                if (r$c != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    r$c.e();
                }
            }
        } else {
            r$c r$c = this.j;
            if (r$c != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                r$c.c();
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
        block87: {
            block86: {
                block83: {
                    block85: {
                        block84: {
                            block77: {
                                block79: {
                                    block82: {
                                        block81: {
                                            block80: {
                                                var1_1 = this;
                                                synchronized (this) {
                                                    var2_2 = this.p;
                                                    this.p = var4_3 = 0L;
                                                }
                                                var6_4 = this.l;
                                                var7_5 = this.j;
                                                var8_6 = this.k;
                                                var9_7 = 435L;
                                                var11_8 = var2_2 & var9_7;
                                                var13_9 /* !! */  = var11_8 == var4_3 ? 0 : (var11_8 < var4_3 ? -1 : 1);
                                                if (var13_9 /* !! */  != false) {
                                                    if (var6_4 != null) {
                                                        var14_10 = var6_4.a;
                                                    } else {
                                                        var15_12 = false;
                                                        var14_10 = null;
                                                    }
                                                    var16_13 = 4;
                                                    var1_1.updateLiveDataRegistration(var16_13, (LiveData)var14_10);
                                                    if (var14_10 != null) {
                                                        var14_10 = (Boolean)var14_10.getValue();
                                                    } else {
                                                        var15_12 = false;
                                                        var14_10 = null;
                                                    }
                                                    var15_12 = ViewDataBinding.safeUnbox((Boolean)var14_10);
                                                    if (var13_9 /* !! */  != false) {
                                                        var17_14 = var15_12 != false ? 0x4000000L : 0x2000000L;
                                                        var2_2 |= var17_14;
                                                    }
                                                } else {
                                                    var15_12 = false;
                                                    var14_11 = null;
                                                }
                                                var17_14 = 395L & var2_2;
                                                var13_9 /* !! */  = var17_14 == var4_3 ? 0 : (var17_14 < var4_3 ? -1 : 1);
                                                var19_15 = 65536L;
                                                var21_16 = 392L;
                                                var23_17 = 394L;
                                                var25_18 = 386L;
                                                var27_19 = 393L;
                                                var29_20 = 1;
                                                var30_21 = 1.4E-45f;
                                                if (var13_9 /* !! */  == false) break block79;
                                                var31_22 = var2_2 & var25_18;
                                                cfr_temp_0 = var31_22 - var4_3;
                                                var13_9 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                                if (var13_9 /* !! */  != false) {
                                                    if (var8_6 != null) {
                                                        var33_23 = var8_6.c;
                                                    } else {
                                                        var34_24 = 0;
                                                        var33_23 = null;
                                                    }
                                                    var1_1.updateLiveDataRegistration(var29_20, (LiveData)var33_23);
                                                    if (var33_23 != null) {
                                                        var35_25 = (Boolean)var33_23.getValue();
                                                    } else {
                                                        var36_26 = 0;
                                                        var35_25 = null;
                                                    }
                                                    var37_27 = var35_25 == null ? var29_20 : 0;
                                                    if (var13_9 /* !! */  != false) {
                                                        var38_28 = var37_27 != 0 ? 0x100000L : 524288L;
                                                        var2_2 |= var38_28;
                                                    }
                                                } else {
                                                    var34_24 = 0;
                                                    var33_23 = null;
                                                    var36_26 = 0;
                                                    var35_25 = null;
                                                    var37_27 = 0;
                                                }
                                                if (var8_6 != null) {
                                                    var40_29 = var8_6.a;
                                                } else {
                                                    var13_9 /* !! */  = 0;
                                                    var40_29 = null;
                                                }
                                                var29_20 = 3;
                                                var30_21 = 4.2E-45f;
                                                var1_1.updateLiveDataRegistration(var29_20, (LiveData)var40_29);
                                                if (var40_29 != null) {
                                                    var40_29 = (Integer)var40_29.getValue();
                                                } else {
                                                    var13_9 /* !! */  = 0;
                                                    var40_29 = null;
                                                }
                                                var13_9 /* !! */  = ViewDataBinding.safeUnbox((Integer)var40_29);
                                                var41_30 = var2_2 & var27_19;
                                                var29_20 = (int)(var41_30 == var4_3 ? 0 : (var41_30 < var4_3 ? -1 : 1));
                                                if (var29_20 == 0) break block80;
                                                var29_20 = 2;
                                                var30_21 = 2.8E-45f;
                                                if (var13_9 /* !! */  == var29_20) {
                                                    var29_20 = 1;
                                                    var30_21 = 1.4E-45f;
                                                } else {
                                                    var29_20 = 0;
                                                    var30_21 = 0.0f;
                                                    var43_31 = null;
                                                }
                                                var41_30 = var2_2 & var21_16;
                                                var44_32 = var41_30 == var4_3 ? 0 : (var41_30 < var4_3 ? -1 : 1);
                                                if (var44_32 != false) {
                                                    if (var29_20 != 0) {
                                                        var2_2 |= 1024L;
                                                        var41_30 = 0x1000000L;
                                                    } else {
                                                        var2_2 |= 512L;
                                                        var41_30 = 0x800000L;
                                                    }
                                                    var2_2 |= var41_30;
                                                }
                                                if ((var44_32 = (cfr_temp_1 = (var41_30 = var2_2 & var27_19) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
                                                    if (var29_20 != 0) {
                                                        var2_2 |= var19_15;
                                                    } else {
                                                        var41_30 = 32768L;
                                                        var2_2 |= var41_30;
                                                    }
                                                }
                                                if ((var44_32 = (cfr_temp_2 = (var41_30 = var2_2 & var21_16) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) == false) break block81;
                                                var45_33 = var1_1.h.getContext();
                                                var16_13 = var29_20 != 0 ? 2131231193 : 2131231342;
                                                var45_33 = AppCompatResources.getDrawable(var45_33, var16_13);
                                                var46_34 = var29_20 != 0 ? "@string/shot" : "@string/connect";
                                                break block82;
                                            }
                                            var29_20 = 0;
                                            var30_21 = 0.0f;
                                            var43_31 = null;
                                        }
                                        var45_33 = null;
                                        var16_13 = 0;
                                        var46_34 = null;
                                    }
                                    var47_35 = var2_2 & var23_17;
                                    var49_36 /* !! */  = var47_35 == var4_3 ? 0 : (var47_35 < var4_3 ? -1 : 1);
                                    if (var49_36 /* !! */  != false) {
                                        if (var13_9 /* !! */  == false) {
                                            var13_9 /* !! */  = 1;
                                        } else {
                                            var13_9 /* !! */  = 0;
                                            var40_29 = null;
                                        }
                                        if (var49_36 /* !! */  != false) {
                                            if (var13_9 /* !! */  != false) {
                                                var47_35 = 0x400000L;
                                                var2_2 |= var47_35;
                                                break block77;
                                            } else {
                                                var50_37 = 0x200000L;
                                                var2_2 |= var50_37;
                                            }
                                        }
                                        break block77;
                                    } else {
                                        var13_9 /* !! */  = 0;
                                        var40_29 = null;
                                    }
                                    break block77;
                                }
                                var34_24 = 0;
                                var33_23 = null;
                                var36_26 = 0;
                                var35_25 = null;
                                var13_9 /* !! */  = 0;
                                var40_29 = null;
                                var29_20 = 0;
                                var30_21 = 0.0f;
                                var43_31 = null;
                                var45_33 = null;
                                var16_13 = 0;
                                var46_34 = null;
                                var37_27 = 0;
                            }
                            if ((var49_36 /* !! */  = (cfr_temp_3 = (var47_35 = var2_2 & 69795840L) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) == false) break block83;
                            var52_38 = var2_2 & var19_15;
                            cfr_temp_4 = var52_38 - var4_3;
                            var49_36 /* !! */  = (long)(cfr_temp_4 == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1));
                            if (var49_36 /* !! */  != false) {
                                if (var8_6 != null) {
                                    var54_39 = var8_6.b;
                                    var55_40 = 0;
                                    var56_41 = 0.0f;
                                    var57_42 = null;
                                } else {
                                    var55_40 = 0;
                                    var56_41 = 0.0f;
                                    var57_42 = null;
                                    var49_36 /* !! */  = 0;
                                    var54_39 = null;
                                }
                                var1_1.updateLiveDataRegistration(0, var54_39);
                                if (var54_39 != null) {
                                    var57_42 = (BleDevice)var54_39.getValue();
                                } else {
                                    var55_40 = 0;
                                    var56_41 = 0.0f;
                                    var57_42 = null;
                                }
                                var58_43 = var57_42 != null ? var57_42.a : null;
                                var58_43 = var58_43 != null ? var58_43.b : null;
                            } else {
                                var55_40 = 0;
                                var56_41 = 0.0f;
                                var57_42 = null;
                                var58_43 = null;
                                var49_36 /* !! */  = 0;
                                var54_39 = null;
                            }
                            var47_35 = var2_2 & 69730304L;
                            var19_15 = 0L;
                            var59_44 = var47_35 == var19_15 ? 0 : (var47_35 < var19_15 ? -1 : 1);
                            if (var59_44 == false) break block84;
                            if (var8_6 != null) {
                                var33_23 = var8_6.c;
                            }
                            var60_45 = var57_42;
                            var55_40 = 1;
                            var56_41 = 1.4E-45f;
                            var1_1.updateLiveDataRegistration(var55_40, (LiveData)var33_23);
                            if (var33_23 != null) {
                                var35_25 = var33_23 = var33_23.getValue();
                                var35_25 = (Boolean)var33_23;
                            }
                            if ((var34_24 = (cfr_temp_5 = (var47_35 = var2_2 & 0x4200000L) - (var19_15 = 0L)) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1)) == 0) break block85;
                            var34_24 = ViewDataBinding.safeUnbox((Boolean)var35_25);
                            var50_37 = var2_2 & 0x200000L;
                            cfr_temp_6 = var50_37 - var19_15;
                            var61_46 = (int)(cfr_temp_6 == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1));
                            if (var61_46 == 0) break block86;
                            var61_46 = var34_24 ^ 1;
                            break block87;
                        }
                        var60_45 = var57_42;
                        var55_40 = 1;
                        var56_41 = 1.4E-45f;
                    }
                    var34_24 = 0;
                    var33_23 = null;
                    break block86;
                }
                var55_40 = 1;
                var56_41 = 1.4E-45f;
                var58_43 = null;
                var34_24 = 0;
                var33_23 = null;
                var49_36 /* !! */  = 0;
                var54_39 = null;
                var60_45 = null;
            }
            var61_46 = 0;
        }
        var62_47 = var2_2 & var27_19;
        var19_15 = 0L;
        var64_48 = var62_47 == var19_15 ? 0 : (var62_47 < var19_15 ? -1 : 1);
        if (var64_48 != false) {
            if (var29_20 == 0) {
                var58_43 = "@string/device_find_device";
            }
        } else {
            var58_43 = null;
        }
        var62_47 = var2_2 & var25_18;
        var29_20 = (int)(var62_47 == var19_15 ? 0 : (var62_47 < var19_15 ? -1 : 1));
        if (var29_20 != 0) {
            var36_26 = var37_27 != 0 ? var55_40 : (int)var35_25.booleanValue();
        } else {
            var36_26 = 0;
            var35_25 = null;
        }
        var62_47 = var2_2 & var23_17;
        var29_20 = (int)(var62_47 == var19_15 ? 0 : (var62_47 < var19_15 ? -1 : 1));
        var37_27 = 8;
        if (var29_20 == 0) ** GOTO lbl-1000
        if (var13_9 /* !! */  != false) {
            var61_46 = var55_40;
        }
        if (var29_20 != 0) {
            var11_8 = var61_46 != 0 ? 262144L : 131072L;
            var2_2 |= var11_8;
        }
        if (var61_46 != 0) {
            var13_9 /* !! */  = var37_27;
        } else lbl-1000:
        // 2 sources

        {
            var13_9 /* !! */  = 0;
            var40_29 = null;
        }
        var31_22 = 435L;
        var50_37 = var2_2 & var31_22;
        var19_15 = 0L;
        var29_20 = (int)(var50_37 == var19_15 ? 0 : (var50_37 < var19_15 ? -1 : 1));
        var50_37 = 4096L;
        if (var29_20 != 0) {
            if (!var15_12) {
                var34_24 = 0;
                var33_23 = null;
            }
            if (var29_20 != 0) {
                if (var34_24 != 0) {
                    var2_2 |= var50_37;
                } else {
                    var47_35 = 2048L;
                    var2_2 |= var47_35;
                }
            }
        } else {
            var34_24 = 0;
            var33_23 = null;
        }
        if ((var29_20 = (int)((cfr_temp_7 = (var50_37 = var2_2 & var50_37) - (var19_15 = 0L)) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1))) != 0) {
            if (var8_6 != null) {
                var54_39 = var8_6.b;
            }
            var65_49 = 0;
            var8_6 = null;
            var1_1.updateLiveDataRegistration(0, var54_39);
            if (var54_39 != null) {
                var60_45 = var43_31 = var54_39.getValue();
                var60_45 = (BleDevice)var43_31;
            }
            if (var60_45 != null) {
                var29_20 = var55_40;
                var30_21 = var56_41;
            } else {
                var29_20 = 0;
                var43_31 = null;
                var30_21 = 0.0f;
            }
            var55_40 = var29_20;
            var56_41 = var30_21;
        } else {
            var65_49 = 0;
            var8_6 = null;
            var55_40 = 0;
            var57_42 = null;
            var56_41 = 0.0f;
        }
        var31_22 = 435L;
        var38_28 = var2_2 & var31_22;
        var52_38 = 0L;
        var29_20 = (int)(var38_28 == var52_38 ? 0 : (var38_28 < var52_38 ? -1 : 1));
        if (var29_20 != 0) {
            if (var34_24 == 0) {
                var55_40 = 0;
                var57_42 = null;
                var56_41 = 0.0f;
            }
            if (var29_20 != 0) {
                var38_28 = var55_40 != 0 ? 16384L : 8192L;
                var2_2 |= var38_28;
            }
            if (var55_40 == 0) {
                var65_49 = var37_27;
            }
        }
        if ((var55_40 = (int)((cfr_temp_8 = (var66_50 = var2_2 & 256L) - (var52_38 = 0L)) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1))) != 0) {
            var57_42 = var1_1.a;
            var33_23 = var1_1.n;
            var57_42.setOnClickListener((View.OnClickListener)var33_23);
            var57_42 = var1_1.f;
            var33_23 = var1_1.o;
            var57_42.setOnClickListener((View.OnClickListener)var33_23);
            var57_42 = var1_1.g;
            var33_23 = var1_1.m;
            var57_42.setOnClickListener((View.OnClickListener)var33_23);
        }
        if ((var55_40 = (int)((cfr_temp_9 = (var21_16 = var2_2 & var21_16) - (var52_38 = 0L)) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1))) != 0) {
            var57_42 = var1_1.a;
            var34_24 = 0;
            var33_23 = null;
            u.n((TextView)var57_42, var46_34, null, null);
            var57_42 = var1_1.h;
            TextViewBindingAdapter.setDrawableStart((TextView)var57_42, (Drawable)var45_33);
        }
        if ((var55_40 = (int)((cfr_temp_10 = (var68_51 = var2_2 & var23_17) - var52_38) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1))) != 0) {
            var57_42 = var1_1.c;
            var57_42.setVisibility((int)var13_9 /* !! */ );
        }
        if ((var55_40 = (int)((cfr_temp_11 = (var11_8 = var2_2 & var25_18) - var52_38) == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1))) != 0) {
            var57_42 = var1_1.d;
            d.v.f.e.c.a((View)var57_42, (boolean)var36_26);
        }
        if ((var55_40 = (cfr_temp_12 = (var9_7 = var2_2 & var27_19) - var52_38) == 0L ? 0 : (cfr_temp_12 < 0L ? -1 : 1)) != 0) {
            var57_42 = var1_1.h;
            var34_24 = 0;
            var33_23 = null;
            u.n((TextView)var57_42, (String)var58_43, null, null);
        }
        if ((var55_40 = (cfr_temp_13 = (var4_3 = 435L & var2_2) - var52_38) == 0L ? 0 : (cfr_temp_13 < 0L ? -1 : 1)) != 0) {
            var57_42 = var1_1.i.getRoot();
            var57_42.setVisibility(var65_49);
        }
        if ((var55_40 = (int)((cfr_temp_14 = (var4_3 = 320L & var2_2) - var52_38) == 0L ? 0 : (cfr_temp_14 < 0L ? -1 : 1))) != 0) {
            var57_42 = var1_1.i;
            var57_42.A(var7_5);
        }
        if ((var70_52 = (cfr_temp_15 = (var2_2 &= (var4_3 = 288L)) - var52_38) == 0L ? 0 : (cfr_temp_15 < 0L ? -1 : 1)) != false) {
            var71_53 = var1_1.i;
            var71_53.B(var6_4);
        }
        ViewDataBinding.executeBindingsOn(var1_1.i);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.p;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            r9 r92 = this.i;
            l12 = (long)r92.hasPendingBindings();
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
            this.p = l10 = 256L;
        }
        this.i.invalidateAll();
        this.requestRebind();
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
                            return false;
                        }
                        object = (MediatorLiveData)object;
                        return this.E((MediatorLiveData)object, n11);
                    }
                    object = (MutableLiveData)object;
                    return this.H((MutableLiveData)object, n11);
                }
                object = (r9)object;
                return this.F((r9)object, n11);
            }
            object = (MutableLiveData)object;
            return this.I((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.G((MutableLiveData)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.i.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 63;
        if (n11 == n10) {
            object = (c1)object;
            this.C((c1)object);
            return 1 != 0;
        } else {
            n11 = 23;
            if (n11 == n10) {
                object = (r$c)object;
                this.B((r$c)object);
                return 1 != 0;
            } else {
                n11 = 152;
                if (n11 != n10) return 0 != 0;
                object = (s)object;
                this.D((s)object);
            }
        }
        return 1 != 0;
    }
}

