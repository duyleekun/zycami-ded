/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Pair;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.liveassistant.LiveAssistantFragment$c;
import com.zhiyun.cama.camera.liveassistant.LiveAssistantState;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import com.zhiyun.protocol.constants.WorkingMode;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.n0.a;
import d.v.c.s0.e7.s;
import d.v.c.s0.q6;
import d.v.c.w0.ee;
import d.v.f.e.c;
import l.a.q.g0.u;

public class fe
extends ee
implements b$a {
    private static final ViewDataBinding$IncludedLayouts w;
    private static final SparseIntArray x;
    private final ImageView n;
    private final ImageView o;
    private final ImageView p;
    private final ImageView q;
    private final View.OnClickListener r;
    private final View.OnClickListener s;
    private final View.OnClickListener t;
    private final View.OnClickListener u;
    private long v;

    static {
        SparseIntArray sparseIntArray;
        x = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362608, 12);
    }

    public fe(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = w;
        SparseIntArray sparseIntArray = x;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 13, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private fe(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[0];
        object2 = (ConstraintLayout)((Object)object);
        Object object3 = object = objectArray[1];
        object3 = (ImageView)object;
        int n10 = 2;
        Object object4 = object = objectArray[n10];
        object4 = (ImageView)object;
        Object object5 = object = objectArray[12];
        object5 = (ImageView)object;
        Object object6 = object = objectArray[10];
        object6 = (ImageView)object;
        Object object7 = object = objectArray[9];
        object7 = (LinearLayout)object;
        int n11 = 4;
        Object object8 = object = objectArray[n11];
        object8 = (LinearLayout)object;
        Object object9 = object = objectArray[8];
        object9 = (TextView)object;
        Object object10 = object = objectArray[11];
        object10 = (TextView)object;
        object = this;
        Object object11 = dataBindingComponent;
        View view2 = view;
        super(dataBindingComponent, view, 5, (ConstraintLayout)((Object)object2), (ImageView)object3, (ImageView)object4, (ImageView)object5, (ImageView)object6, (LinearLayout)object7, (LinearLayout)object8, (TextView)object9, (TextView)object10);
        this.v = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        int n12 = 3;
        view2 = (ImageView)objectArray[n12];
        this.n = view2;
        view2.setTag(null);
        view2 = (ImageView)objectArray[5];
        this.o = view2;
        view2.setTag(null);
        view2 = (ImageView)objectArray[6];
        this.p = view2;
        view2.setTag(null);
        view2 = (ImageView)objectArray[7];
        this.q = view2;
        view2.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        object11 = view;
        this.setRootTag(view);
        object11 = new b(this, n10);
        this.r = object11;
        object11 = new b(this, n12);
        this.s = object11;
        object = new b(this, n11);
        this.t = object;
        object = new b(this, 1);
        this.u = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean G(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.v;
                long l11 = 8;
                this.v = l10 |= l11;
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
    private boolean H(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.v;
                long l11 = 2;
                this.v = l10 |= l11;
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
                long l10 = this.v;
                long l11 = 4;
                this.v = l10 |= l11;
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
    private boolean J(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.v;
                long l11 = 16;
                this.v = l10 |= l11;
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
                long l10 = this.v;
                long l11 = 1L;
                this.v = l10 |= l11;
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
    public void C(BleViewModel bleViewModel) {
        this.j = bleViewModel;
        synchronized (this) {
            long l10 = this.v;
            long l11 = 32;
            this.v = l10 |= l11;
        }
        this.notifyPropertyChanged(13);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(LiveAssistantFragment$c liveAssistantFragment$c) {
        this.m = liveAssistantFragment$c;
        synchronized (this) {
            long l10 = this.v;
            long l11 = 256L;
            this.v = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(DeviceViewModel deviceViewModel) {
        this.k = deviceViewModel;
        synchronized (this) {
            long l10 = this.v;
            long l11 = 128L;
            this.v = l10 |= l11;
        }
        this.notifyPropertyChanged(39);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(s s10) {
        this.l = s10;
        synchronized (this) {
            long l10 = this.v;
            long l11 = 64;
            this.v = l10 |= l11;
        }
        this.notifyPropertyChanged(79);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 != n13) {
                    n13 = 4;
                    if (n10 == n13) {
                        LiveAssistantFragment$c liveAssistantFragment$c = this.m;
                        if (liveAssistantFragment$c != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            liveAssistantFragment$c.f();
                        }
                    }
                } else {
                    LiveAssistantFragment$c liveAssistantFragment$c = this.m;
                    if (liveAssistantFragment$c != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        liveAssistantFragment$c.b();
                    }
                }
            } else {
                LiveAssistantFragment$c liveAssistantFragment$c = this.m;
                if (liveAssistantFragment$c != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    liveAssistantFragment$c.c();
                }
            }
        } else {
            LiveAssistantFragment$c liveAssistantFragment$c = this.m;
            if (liveAssistantFragment$c != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                liveAssistantFragment$c.a();
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
        block45: {
            block46: {
                var1_1 = this;
                synchronized (this) {
                    var2_2 = this.v;
                    this.v = var4_3 = 0L;
                }
                var6_4 = this.j;
                var7_5 = this.l;
                var8_6 = this.k;
                var9_7 = 558L & var2_2;
                var11_8 /* !! */  = var9_7 == var4_3 ? 0 : (var9_7 < var4_3 ? -1 : 1);
                var12_9 = 552L;
                var14_10 = 548L;
                var16_11 = 1;
                var17_12 = 546L;
                if (var11_8 /* !! */  == false) break block46;
                var19_13 = var2_2 & var17_12;
                cfr_temp_0 = var19_13 - var4_3;
                var11_8 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                if (var11_8 /* !! */  != false) {
                    if (var6_4 != null) {
                        var21_14 = var6_4.L;
                    } else {
                        var22_17 = 0;
                        var21_14 = null;
                    }
                    var1_1.updateLiveDataRegistration(var16_11, (LiveData)var21_14);
                    if (var21_14 != null) {
                        var21_14 = (Boolean)var21_14.getValue();
                    } else {
                        var22_17 = 0;
                        var21_14 = null;
                    }
                    var22_17 = ViewDataBinding.safeUnbox((Boolean)var21_14);
                    if (var11_8 /* !! */  != false) {
                        if (var22_17 != 0) {
                            var2_2 |= 8192L;
                            var23_18 = 32768L;
                        } else {
                            var2_2 |= 4096L;
                            var23_18 = 16384L;
                        }
                        var2_2 |= var23_18;
                    }
                    var11_8 /* !! */  = var22_17 ^ 1;
                    var25_19 = var22_17 != 0 ? 0 : 8;
                    if (var22_17 != 0) {
                        var22_17 = 8;
                    } else {
                        var22_17 = 0;
                        var21_14 = null;
                    }
                    var26_20 = var2_2 & var17_12;
                    var28_21 = var26_20 == var4_3 ? 0 : (var26_20 < var4_3 ? -1 : 1);
                    if (var28_21 != false) {
                        var26_20 = var11_8 /* !! */  != false ? 2048L : 1024L;
                        var2_2 |= var26_20;
                    }
                    if (var11_8 /* !! */  != false) {
                        var29_22 = this.getRoot().getContext();
                        var16_11 = 2130771980;
                        var29_22 = AnimationUtils.loadAnimation((Context)var29_22, (int)var16_11);
                    } else {
                        var11_8 /* !! */  = 0;
                        var29_22 = null;
                    }
                } else {
                    var11_8 /* !! */  = 0;
                    var29_22 = null;
                    var22_17 = 0;
                    var21_15 = null;
                    var25_19 = 0;
                }
                var30_23 = var2_2 & var14_10;
                var16_11 = (int)(var30_23 == var4_3 ? 0 : (var30_23 < var4_3 ? -1 : 1));
                if (var16_11 == 0) ** GOTO lbl-1000
                if (var6_4 != null) {
                    var32_24 = var6_4.b;
                } else {
                    var16_11 = 0;
                    var32_24 = null;
                }
                var33_25 = 2;
                var1_1.updateLiveDataRegistration(var33_25, var32_24);
                if (var32_24 != null) {
                    var34_27 = (WorkingMode)var32_24.getValue();
                } else lbl-1000:
                // 2 sources

                {
                    var33_25 = 0;
                    var34_27 = null;
                }
                var35_28 = var2_2 & var12_9;
                var37_29 = var35_28 == var4_3 ? 0 : (var35_28 < var4_3 ? -1 : 1);
                if (var37_29 != 0) {
                    if (var6_4 != null) {
                        var6_4 = var6_4.O;
                    } else {
                        var38_30 = false;
                        var6_4 = null;
                    }
                    var37_29 = 3;
                    var1_1.updateLiveDataRegistration(var37_29, (LiveData)var6_4);
                    if (var6_4 != null) {
                        var6_4 = (Pair)var6_4.getValue();
                    } else {
                        var38_30 = false;
                        var6_4 = null;
                    }
                    var39_31 = this.getRoot().getContext();
                    var6_4 = q6.a(var39_31, (Pair)var6_4);
                    var37_29 = var25_19;
                    break block45;
                } else {
                    var37_29 = var25_19;
                    var38_30 = false;
                    var6_4 = null;
                }
                break block45;
            }
            var38_30 = false;
            var6_4 = null;
            var11_8 /* !! */  = 0;
            var29_22 = null;
            var33_26 = false;
            var34_27 = null;
            var37_29 = 0;
            var39_32 = null;
            var22_17 = 0;
            var21_16 = null;
        }
        var35_28 = 577L;
        var40_33 = var2_2 & var35_28;
        var16_11 = (int)(var40_33 == var4_3 ? 0 : (var40_33 < var4_3 ? -1 : 1));
        if (var16_11 != 0) {
            if (var7_5 != null) {
                var7_5 = var7_5.k();
            } else {
                var42_34 = 0;
                var7_5 = null;
            }
            var43_35 = 0;
            var44_36 = null;
            var1_1.updateLiveDataRegistration(0, (LiveData)var7_5);
            if (var7_5 != null) {
                var7_5 = (LiveAssistantState)var7_5.getValue();
            } else {
                var42_34 = 0;
                var7_5 = null;
            }
            if (var7_5 != null) {
                var45_38 = var7_5.getStateExplainText();
                var46_39 = var7_5.getStateText();
            } else {
                var45_38 = 0;
                var46_39 = 0;
            }
            var44_36 = LiveAssistantState.OPEN_SUCCESS;
            var28_21 = var7_5 == var44_36 ? (long)1 : (long)0;
            if (var16_11 != 0) {
                var47_40 = var28_21 != false ? 131072L : 65536L;
                var2_2 |= var47_40;
            }
            var49_41 = var28_21 != false ? 0 : 8;
            var42_34 = var49_41;
            var43_35 = var46_39;
        } else {
            var42_34 = 0;
            var7_5 = null;
            var43_35 = 0;
            var44_37 = null;
            var45_38 = 0;
        }
        var50_42 = var2_2 & 656L;
        var16_11 = (int)(var50_42 == var4_3 ? 0 : (var50_42 < var4_3 ? -1 : 1));
        if (var16_11 != 0) {
            var8_6 = var8_6 != null ? var8_6.b : null;
            var52_43 = 4;
            var1_1.updateLiveDataRegistration(var52_43, (LiveData)var8_6);
            var8_6 = var8_6 != null ? (Pair)var8_6.getValue() : null;
            var53_44 = this.getRoot().getContext();
            var8_6 = q6.c((Context)var53_44, (Pair)var8_6);
        } else {
            var8_6 = null;
        }
        var17_12 = 512L & var2_2;
        var52_43 = (int)(var17_12 == var4_3 ? 0 : (var17_12 < var4_3 ? -1 : 1));
        if (var52_43 != 0) {
            var53_44 = var1_1.b;
            var54_45 = var1_1.u;
            var53_44.setOnClickListener(var54_45);
            var54_45 = var1_1.c;
            var55_46 = var1_1.r;
            var54_45.setOnClickListener(var55_46);
            var54_45 = var1_1.f;
            var55_46 = var1_1.t;
            var54_45.setOnClickListener(var55_46);
            var54_45 = var1_1.n;
            var55_46 = var1_1.s;
            var54_45.setOnClickListener(var55_46);
        }
        if ((var56_47 = (cfr_temp_1 = (var4_3 = var2_2 & var35_28) - (var17_12 = 0L)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
            var1_1.e.setVisibility(var42_34);
            var54_45 = var1_1.h;
            var55_46 = null;
            l.a.q.g0.u.k((TextView)var54_45, var45_38, null, null);
            var54_45 = var1_1.i;
            l.a.q.g0.u.k((TextView)var54_45, var43_35, null, null);
        }
        if ((var56_47 = (cfr_temp_2 = (var4_3 = 546L & var2_2) - var17_12) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
            var1_1.g.setVisibility(var37_29);
            d.v.f.e.c.b((View)var1_1.n, (Animation)var29_22);
            var54_45 = var1_1.n;
            var54_45.setVisibility(var22_17);
        }
        if (var16_11 != 0) {
            var54_45 = var1_1.o;
            ImageViewBindingAdapter.setImageDrawable((ImageView)var54_45, (Drawable)var8_6);
        }
        if ((var56_47 = (cfr_temp_3 = (var4_3 = 552L & var2_2) - (var57_48 = 0L)) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) {
            var54_45 = var1_1.p;
            ImageViewBindingAdapter.setImageDrawable((ImageView)var54_45, (Drawable)var6_4);
        }
        if (var38_30 = (cfr_temp_4 = (var2_2 &= (var4_3 = 548L)) - var57_48) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) {
            var6_4 = var1_1.q;
            d.v.c.n0.a.a((ImageView)var6_4, var34_27);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.v;
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
            this.v = l10 = 512L;
        }
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
                        object = (LiveData)object;
                        return this.J((LiveData)object, n11);
                    }
                    object = (LiveData)object;
                    return this.G((LiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.I((MutableLiveData)object, n11);
            }
            object = (LiveData)object;
            return this.H((LiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.K((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 13;
        if (n11 == n10) {
            object = (BleViewModel)object;
            this.C((BleViewModel)object);
            return 1 != 0;
        } else {
            n11 = 79;
            if (n11 == n10) {
                object = (s)object;
                this.F((s)object);
                return 1 != 0;
            } else {
                n11 = 39;
                if (n11 == n10) {
                    object = (DeviceViewModel)object;
                    this.E((DeviceViewModel)object);
                    return 1 != 0;
                } else {
                    n11 = 23;
                    if (n11 != n10) return 0 != 0;
                    object = (LiveAssistantFragment$c)object;
                    this.D((LiveAssistantFragment$c)object);
                }
            }
        }
        return 1 != 0;
    }
}

