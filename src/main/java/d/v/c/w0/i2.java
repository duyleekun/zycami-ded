/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.Chronometer
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.CameraFragment$j;
import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.ble.BleViewModel$PanoramaState;
import com.zhiyun.cama.camera.data.CameraSet$DelayInterval;
import com.zhiyun.cama.camera.data.CameraSet$DelayTime;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.camera.data.CameraSet$Panorama;
import com.zhiyun.cama.camera.widget.MutiNodeProgress;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.u6;
import d.v.c.s0.v6;
import d.v.c.w0.h2;
import l.a.q.g0.u;

public class i2
extends h2
implements b$a {
    private static final ViewDataBinding$IncludedLayouts V;
    private static final SparseIntArray W;
    private final ImageView N;
    private final ImageView O;
    private final View.OnClickListener P;
    private final View.OnClickListener Q;
    private final View.OnClickListener R;
    private final View.OnClickListener S;
    private long T;
    private long U;

    static {
        SparseIntArray sparseIntArray;
        W = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363731, 25);
        sparseIntArray.put(2131362222, 26);
        sparseIntArray.put(2131362967, 27);
        sparseIntArray.put(2131363526, 28);
        sparseIntArray.put(2131362829, 29);
        sparseIntArray.put(2131363504, 30);
        sparseIntArray.put(2131362702, 31);
        sparseIntArray.put(2131363716, 32);
        sparseIntArray.put(2131362221, 33);
        sparseIntArray.put(2131363577, 34);
    }

    public i2(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = V;
        SparseIntArray sparseIntArray = W;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 35, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private i2(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        long l10;
        Object object = this;
        CheckBox checkBox = (CheckBox)objectArray[22];
        CheckBox checkBox2 = (CheckBox)objectArray[7];
        ConstraintLayout constraintLayout = (ConstraintLayout)((Object)objectArray[13]);
        ConstraintLayout constraintLayout2 = (ConstraintLayout)((Object)objectArray[9]);
        Chronometer chronometer = (Chronometer)objectArray[33];
        Chronometer chronometer2 = (Chronometer)objectArray[26];
        ConstraintLayout constraintLayout3 = (ConstraintLayout)((Object)objectArray[4]);
        TextView textView = (TextView)objectArray[10];
        TextView textView2 = (TextView)objectArray[11];
        ImageView imageView = (ImageView)objectArray[31];
        ImageView imageView2 = (ImageView)objectArray[2];
        LinearLayout linearLayout = (LinearLayout)objectArray[29];
        LinearLayout linearLayout2 = (LinearLayout)objectArray[0];
        LinearLayout linearLayout3 = (LinearLayout)objectArray[1];
        LinearLayout linearLayout4 = (LinearLayout)objectArray[14];
        LinearLayout linearLayout5 = (LinearLayout)objectArray[23];
        MutiNodeProgress mutiNodeProgress = (MutiNodeProgress)((Object)objectArray[15]);
        View view2 = (View)objectArray[27];
        TextView textView3 = (TextView)objectArray[17];
        TextView textView4 = (TextView)objectArray[18];
        TextView textView5 = (TextView)objectArray[19];
        TextView textView6 = (TextView)objectArray[3];
        TextView textView7 = (TextView)objectArray[24];
        TextView textView8 = (TextView)objectArray[30];
        TextView textView9 = (TextView)objectArray[6];
        TextView textView10 = (TextView)objectArray[28];
        TextView textView11 = (TextView)objectArray[34];
        TextView textView12 = (TextView)objectArray[20];
        TextView textView13 = (TextView)objectArray[21];
        View view3 = (View)objectArray[5];
        View view4 = (View)objectArray[32];
        View view5 = (View)objectArray[16];
        View view6 = (View)objectArray[25];
        int n10 = 16;
        super(dataBindingComponent, view, n10, checkBox, checkBox2, constraintLayout, constraintLayout2, chronometer, chronometer2, constraintLayout3, textView, textView2, imageView, imageView2, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, mutiNodeProgress, view2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, view3, view4, view5, view6);
        this.T = l10 = (long)-1;
        this.U = l10;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.k.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
        object = (ImageView)objectArray[12];
        this.N = object;
        object.setTag(null);
        object = (ImageView)objectArray[8];
        this.O = object;
        object.setTag(null);
        this.q.setTag(null);
        this.s.setTag(null);
        this.t.setTag(null);
        this.u.setTag(null);
        this.v.setTag(null);
        this.w.setTag(null);
        this.y.setTag(null);
        this.B.setTag(null);
        this.C.setTag(null);
        this.D.setTag(null);
        this.F.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, 4);
        this.P = object;
        object = new b(this, 2);
        this.Q = object;
        object = new b(this, 3);
        this.R = object;
        object = new b(this, 1);
        this.S = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean K(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.T;
                long l11 = 2048L;
                this.T = l10 |= l11;
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
                long l10 = this.T;
                long l11 = 4096L;
                this.T = l10 |= l11;
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
                long l10 = this.T;
                long l11 = 16;
                this.T = l10 |= l11;
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
                long l10 = this.T;
                long l11 = 64;
                this.T = l10 |= l11;
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
    private boolean O(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.T;
                long l11 = 32;
                this.T = l10 |= l11;
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
    private boolean P(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.T;
                long l11 = 8192L;
                this.T = l10 |= l11;
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
    private boolean Q(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.T;
                long l11 = 2;
                this.T = l10 |= l11;
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
    private boolean R(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.T;
                long l11 = 512L;
                this.T = l10 |= l11;
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
    private boolean S(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.T;
                long l11 = 32768L;
                this.T = l10 |= l11;
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
    private boolean T(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.T;
                long l11 = 128L;
                this.T = l10 |= l11;
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
    private boolean U(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.T;
                long l11 = 8;
                this.T = l10 |= l11;
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
    private boolean V(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.T;
                long l11 = 4;
                this.T = l10 |= l11;
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
    private boolean W(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.T;
                long l11 = 1024L;
                this.T = l10 |= l11;
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
    private boolean X(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.T;
                long l11 = 1L;
                this.T = l10 |= l11;
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
    private boolean Y(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.T;
                long l11 = 256L;
                this.T = l10 |= l11;
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
    private boolean Z(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.T;
                long l11 = 16384L;
                this.T = l10 |= l11;
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
    public void E(BleViewModel bleViewModel) {
        this.J = bleViewModel;
        synchronized (this) {
            long l10 = this.T;
            long l11 = 262144L;
            this.T = l10 |= l11;
        }
        this.notifyPropertyChanged(13);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(CameraFragment$j cameraFragment$j) {
        this.H = cameraFragment$j;
        synchronized (this) {
            long l10 = this.T;
            long l11 = 131072L;
            this.T = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    public void G(DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel) {
        this.M = dynamicZoomViewModel$TargetModel;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void H(DynamicZoomViewModel dynamicZoomViewModel) {
        this.L = dynamicZoomViewModel;
        synchronized (this) {
            long l10 = this.T;
            long l11 = 524288L;
            this.T = l10 |= l11;
        }
        this.notifyPropertyChanged(46);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void I(v6 v62) {
        this.K = v62;
        synchronized (this) {
            long l10 = this.T;
            long l11 = 0x100000L;
            this.T = l10 |= l11;
        }
        this.notifyPropertyChanged(112);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void J(u6 u62) {
        this.I = u62;
        synchronized (this) {
            long l10 = this.T;
            long l11 = 0x200000L;
            this.T = l10 |= l11;
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
                n13 = 3;
                if (n10 != n13) {
                    n13 = 4;
                    if (n10 == n13) {
                        CameraFragment$j cameraFragment$j = this.H;
                        if (cameraFragment$j != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            cameraFragment$j.e0();
                        }
                    }
                } else {
                    CameraFragment$j cameraFragment$j = this.H;
                    if (cameraFragment$j != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        cameraFragment$j.g0();
                    }
                }
            } else {
                CameraFragment$j cameraFragment$j = this.H;
                if (cameraFragment$j != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    cameraFragment$j.X();
                }
            }
        } else {
            CameraFragment$j cameraFragment$j = this.H;
            if (cameraFragment$j != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                cameraFragment$j.Y();
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
        block271: {
            block270: {
                block269: {
                    block268: {
                        block247: {
                            block267: {
                                block266: {
                                    block265: {
                                        block264: {
                                            block263: {
                                                block262: {
                                                    block261: {
                                                        block260: {
                                                            block259: {
                                                                block258: {
                                                                    block257: {
                                                                        block256: {
                                                                            block255: {
                                                                                block254: {
                                                                                    block253: {
                                                                                        block252: {
                                                                                            block251: {
                                                                                                block250: {
                                                                                                    block249: {
                                                                                                        block248: {
                                                                                                            block241: {
                                                                                                                block246: {
                                                                                                                    block245: {
                                                                                                                        var1_1 = this;
                                                                                                                        synchronized (this) {
                                                                                                                            var2_2 = this.T;
                                                                                                                            this.T = var4_3 = 0L;
                                                                                                                            var6_4 = this.U;
                                                                                                                            this.U = var4_3;
                                                                                                                        }
                                                                                                                        var8_5 = this.J;
                                                                                                                        var9_6 = this.L;
                                                                                                                        var10_7 = this.K;
                                                                                                                        var11_8 = this.I;
                                                                                                                        var12_9 = 6560000L & var2_2;
                                                                                                                        var14_10 /* !! */  = var12_9 == var4_3 ? 0 : (var12_9 < var4_3 ? -1 : 1);
                                                                                                                        var15_11 = 11;
                                                                                                                        var16_12 = 0x441000L;
                                                                                                                        var18_13 = 6555904L;
                                                                                                                        if (var14_10 /* !! */  == false) break block245;
                                                                                                                        var20_14 = var2_2 & var18_13;
                                                                                                                        cfr_temp_0 = var20_14 - var4_3;
                                                                                                                        var14_10 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                                                                                                        if (var14_10 /* !! */  != false) {
                                                                                                                            if (var8_5 != null) {
                                                                                                                                var22_15 /* !! */  = var8_5.B;
                                                                                                                            } else {
                                                                                                                                var23_16 = 0;
                                                                                                                                var22_15 /* !! */  = null;
                                                                                                                            }
                                                                                                                            var1_1.updateLiveDataRegistration(var15_11, (LiveData)var22_15 /* !! */ );
                                                                                                                            if (var22_15 /* !! */  != null) {
                                                                                                                                var22_15 /* !! */  = (Boolean)var22_15 /* !! */ .getValue();
                                                                                                                            } else {
                                                                                                                                var23_16 = 0;
                                                                                                                                var22_15 /* !! */  = null;
                                                                                                                            }
                                                                                                                            var23_16 = ViewDataBinding.safeUnbox((Boolean)var22_15 /* !! */ );
                                                                                                                            if (var14_10 /* !! */  != false) {
                                                                                                                                var24_17 = var23_16 != 0 ? 0x1000000000L : 0x800000000L;
                                                                                                                                var2_2 |= var24_17;
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            var23_16 = 0;
                                                                                                                            var22_15 /* !! */  = null;
                                                                                                                        }
                                                                                                                        if ((var14_10 /* !! */  = (cfr_temp_1 = (var24_17 = var2_2 & var16_12) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) == false) break block246;
                                                                                                                        if (var8_5 != null) {
                                                                                                                            var26_18 = var8_5.r;
                                                                                                                        } else {
                                                                                                                            var15_11 = 0;
                                                                                                                            var26_18 = null;
                                                                                                                        }
                                                                                                                        var27_19 = 12;
                                                                                                                        var1_1.updateLiveDataRegistration(var27_19, (LiveData)var26_18);
                                                                                                                        if (var26_18 != null) {
                                                                                                                            var26_18 = (BleViewModel$PanoramaState)var26_18.getValue();
                                                                                                                        } else {
                                                                                                                            var15_11 = 0;
                                                                                                                            var26_18 = null;
                                                                                                                        }
                                                                                                                        if (var8_5 != null) {
                                                                                                                            var28_20 = var8_5.L((BleViewModel$PanoramaState)var26_18);
                                                                                                                        } else {
                                                                                                                            var28_20 = 0;
                                                                                                                            var29_21 = 0.0f;
                                                                                                                            var8_5 = null;
                                                                                                                        }
                                                                                                                        if (var14_10 /* !! */  != false) {
                                                                                                                            if (var28_20 != 0) {
                                                                                                                                var2_2 |= 0x40000000L;
                                                                                                                                var12_9 = 0x1000000000000L;
                                                                                                                            } else {
                                                                                                                                var2_2 |= 0x20000000L;
                                                                                                                                var12_9 = 0x800000000000L;
                                                                                                                            }
                                                                                                                            var2_2 |= var12_9;
                                                                                                                        }
                                                                                                                        var14_10 /* !! */  = var28_20 ^ 1;
                                                                                                                        if (var28_20 != 0) {
                                                                                                                            var28_20 = 0x3F000000;
                                                                                                                            var29_21 = 0.5f;
                                                                                                                            break block241;
                                                                                                                        } else {
                                                                                                                            var28_20 = 1065353216;
                                                                                                                            var29_21 = 1.0f;
                                                                                                                        }
                                                                                                                        break block241;
                                                                                                                    }
                                                                                                                    var23_16 = 0;
                                                                                                                    var22_15 /* !! */  = null;
                                                                                                                }
                                                                                                                var28_20 = 0;
                                                                                                                var29_21 = 0.0f;
                                                                                                                var8_5 = null;
                                                                                                                var14_10 /* !! */  = 0;
                                                                                                                var30_22 = null;
                                                                                                            }
                                                                                                            var31_23 = 4718608L;
                                                                                                            var33_24 = var2_2 & var31_23;
                                                                                                            var35_25 /* !! */  = var33_24 == var4_3 ? 0 : (var33_24 < var4_3 ? -1 : 1);
                                                                                                            if (var35_25 /* !! */  != false) {
                                                                                                                if (var9_6 != null) {
                                                                                                                    var36_26 = var9_6.o();
                                                                                                                } else {
                                                                                                                    var37_27 = 0;
                                                                                                                    var36_26 = null;
                                                                                                                }
                                                                                                                var38_28 = 4;
                                                                                                                var39_29 = 5.6E-45f;
                                                                                                                var1_1.updateLiveDataRegistration(var38_28, (LiveData)var36_26);
                                                                                                                if (var36_26 != null) {
                                                                                                                    var40_30 = (DynamicZoomViewModel$TargetModel)var36_26.getValue();
                                                                                                                } else {
                                                                                                                    var38_28 = 0;
                                                                                                                    var39_29 = 0.0f;
                                                                                                                    var40_30 = null;
                                                                                                                }
                                                                                                                var36_26 = DynamicZoomViewModel$TargetModel.FAR;
                                                                                                                if (var40_30 == var36_26) {
                                                                                                                    var37_27 = 1;
                                                                                                                } else {
                                                                                                                    var37_27 = 0;
                                                                                                                    var36_26 = null;
                                                                                                                }
                                                                                                                var26_18 = DynamicZoomViewModel$TargetModel.NEAR;
                                                                                                                if (var40_30 == var26_18) {
                                                                                                                    var38_28 = 1;
                                                                                                                    var39_29 = 1.4E-45f;
                                                                                                                } else {
                                                                                                                    var38_28 = 0;
                                                                                                                    var39_29 = 0.0f;
                                                                                                                    var40_30 = null;
                                                                                                                }
                                                                                                                if (var35_25 /* !! */  != false) {
                                                                                                                    var31_23 = var37_27 != 0 ? 0x1000000L : 0x800000L;
                                                                                                                    var2_2 |= var31_23;
                                                                                                                }
                                                                                                                if ((var35_25 /* !! */  = (cfr_temp_2 = (var41_31 = var2_2 & 4718608L) - (var31_23 = 0L)) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
                                                                                                                    var31_23 = var38_28 != 0 ? 0x4000000000000000L : 0x2000000000000000L;
                                                                                                                    var2_2 |= var31_23;
                                                                                                                }
                                                                                                                if (var37_27 != 0) {
                                                                                                                    var36_26 = var1_1.h;
                                                                                                                    var15_11 = 2131099772;
                                                                                                                } else {
                                                                                                                    var36_26 = var1_1.h;
                                                                                                                    var15_11 = 2131099780;
                                                                                                                }
                                                                                                                var37_27 = ViewDataBinding.getColorFromResource((View)var36_26, var15_11);
                                                                                                                if (var38_28 != 0) {
                                                                                                                    var40_30 = var1_1.i;
                                                                                                                    var15_11 = 2131099772;
                                                                                                                } else {
                                                                                                                    var40_30 = var1_1.i;
                                                                                                                    var15_11 = 2131099780;
                                                                                                                }
                                                                                                                var38_28 = ViewDataBinding.getColorFromResource((View)var40_30, var15_11);
                                                                                                            } else {
                                                                                                                var38_28 = 0;
                                                                                                                var39_29 = 0.0f;
                                                                                                                var40_30 = null;
                                                                                                                var37_27 = 0;
                                                                                                                var36_26 = null;
                                                                                                            }
                                                                                                            var31_23 = 7348524L;
                                                                                                            var41_31 = var2_2 & var31_23;
                                                                                                            var33_24 = 0L;
                                                                                                            var35_25 /* !! */  = var41_31 == var33_24 ? 0 : (var41_31 < var33_24 ? -1 : 1);
                                                                                                            var41_31 = 0x500020L;
                                                                                                            if (var35_25 /* !! */  != false) {
                                                                                                                if (var10_7 != null) {
                                                                                                                    var10_7 = var10_7.c;
                                                                                                                } else {
                                                                                                                    var43_32 = 0;
                                                                                                                    var10_7 = null;
                                                                                                                }
                                                                                                                var35_25 /* !! */  = 5;
                                                                                                                var1_1.updateLiveDataRegistration((int)var35_25 /* !! */ , (LiveData)var10_7);
                                                                                                                if (var10_7 != null) {
                                                                                                                    var10_7 = (Boolean)var10_7.getValue();
                                                                                                                } else {
                                                                                                                    var43_32 = 0;
                                                                                                                    var10_7 = null;
                                                                                                                }
                                                                                                                var43_32 = ViewDataBinding.safeUnbox((Boolean)var10_7);
                                                                                                                var44_33 = var2_2 & var41_31;
                                                                                                                var33_24 = 0L;
                                                                                                                var35_25 /* !! */  = var44_33 == var33_24 ? 0 : (var44_33 < var33_24 ? -1 : 1);
                                                                                                                if (var35_25 /* !! */  != false) {
                                                                                                                    var44_33 = var43_32 != 0 ? 0x10000000000000L : 0x8000000000000L;
                                                                                                                    var2_2 |= var44_33;
                                                                                                                }
                                                                                                                if ((var35_25 /* !! */  = (cfr_temp_3 = (var44_33 = var2_2 & var41_31) - var33_24) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) {
                                                                                                                    var35_25 /* !! */  = var43_32 ^ 1;
                                                                                                                } else {
                                                                                                                    var35_25 /* !! */  = 0;
                                                                                                                    var46_34 = null;
                                                                                                                }
                                                                                                                var47_35 = true;
                                                                                                                var43_32 ^= 1;
                                                                                                                var44_33 = var2_2 & var31_23;
                                                                                                                var33_24 = 0L;
                                                                                                                var48_36 = var44_33 == var33_24 ? 0 : (var44_33 < var33_24 ? -1 : 1);
                                                                                                                if (var48_36 != false) {
                                                                                                                    var44_33 = var43_32 != 0 ? 256L : 128L;
                                                                                                                    var6_4 |= var44_33;
                                                                                                                }
                                                                                                            } else {
                                                                                                                var43_32 = 0;
                                                                                                                var10_7 = null;
                                                                                                                var35_25 /* !! */  = 0;
                                                                                                                var46_34 = null;
                                                                                                            }
                                                                                                            var44_33 = var2_2 & 6875079L;
                                                                                                            var33_24 = 0L;
                                                                                                            var48_36 = var44_33 == var33_24 ? 0 : (var44_33 < var33_24 ? -1 : 1);
                                                                                                            var49_37 = 0x400000000000000L;
                                                                                                            var51_38 = 6824000L;
                                                                                                            var53_39 = 0x602000L;
                                                                                                            var55_40 = 0x200000000000L;
                                                                                                            var57_41 = 0x600002L;
                                                                                                            var59_42 = 6299778L;
                                                                                                            var61_43 = 6299907L;
                                                                                                            var63_44 = 6299908L;
                                                                                                            var65_45 = 6299651L;
                                                                                                            var67_46 = 1024L;
                                                                                                            var69_47 = 6299906L;
                                                                                                            if (var48_36 == false) break block247;
                                                                                                            var71_48 = var2_2 & 6300035L;
                                                                                                            var33_24 = 0L;
                                                                                                            cfr_temp_4 = var71_48 - var33_24;
                                                                                                            var27_19 = (int)(cfr_temp_4 == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1));
                                                                                                            if (var27_19 == 0) break block248;
                                                                                                            if (var11_8 != null) {
                                                                                                                var26_18 = var73_49 /* !! */  = var11_8.K();
                                                                                                            } else {
                                                                                                                var15_11 = 0;
                                                                                                                var26_18 = null;
                                                                                                            }
                                                                                                            var27_19 = 1;
                                                                                                            var1_1.updateLiveDataRegistration(var27_19, (LiveData)var26_18);
                                                                                                            if (var26_18 != null) {
                                                                                                                var26_18 = (Boolean)var26_18.getValue();
                                                                                                            } else {
                                                                                                                var15_11 = 0;
                                                                                                                var26_18 = null;
                                                                                                            }
                                                                                                            var15_11 = (int)ViewDataBinding.safeUnbox((Boolean)var26_18);
                                                                                                            var71_48 = var2_2 & var57_41;
                                                                                                            var33_24 = 0L;
                                                                                                            var48_36 = var71_48 == var33_24 ? 0 : (var71_48 < var33_24 ? -1 : 1);
                                                                                                            if (var48_36 != false) {
                                                                                                                if (var15_11 != 0) {
                                                                                                                    var2_2 |= 0x100000000L;
                                                                                                                    var71_48 = 0x400000000L;
                                                                                                                } else {
                                                                                                                    var2_2 |= 0x80000000L;
                                                                                                                    var71_48 = 0x200000000L;
                                                                                                                }
                                                                                                                var2_2 |= var71_48;
                                                                                                            }
                                                                                                            if ((var48_36 = (cfr_temp_5 = (var71_48 = var2_2 & var57_41) - (var33_24 = 0L)) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1)) == false) break block249;
                                                                                                            if (var15_11 != 0) {
                                                                                                                var48_36 = 0;
                                                                                                                var74_50 = 0.0f;
                                                                                                                var75_51 /* !! */  = null;
                                                                                                            } else {
                                                                                                                var48_36 = 8;
                                                                                                                var74_50 = 1.1E-44f;
                                                                                                            }
                                                                                                            if (var15_11 == 0) break block250;
                                                                                                            var76_52 = 8;
                                                                                                            var77_54 = 1.1E-44f;
                                                                                                            break block251;
                                                                                                        }
                                                                                                        var27_19 = 1;
                                                                                                        var15_11 = 0;
                                                                                                        var26_18 = null;
                                                                                                    }
                                                                                                    var48_36 = 0;
                                                                                                    var74_50 = 0.0f;
                                                                                                    var75_51 /* !! */  = null;
                                                                                                }
                                                                                                var76_52 = 0;
                                                                                                var77_54 = 0.0f;
                                                                                                var78_56 /* !! */  = null;
                                                                                            }
                                                                                            var79_57 = var2_2 & var63_44;
                                                                                            var33_24 = 0L;
                                                                                            var81_58 = var79_57 == var33_24 ? 0 : (var79_57 < var33_24 ? -1 : 1);
                                                                                            if (var81_58 == false) break block252;
                                                                                            if (var11_8 != null) {
                                                                                                var82_59 = var11_8.k0();
                                                                                                var83_60 = var35_25 /* !! */ ;
                                                                                                var73_49 /* !! */  = var82_59;
                                                                                            } else {
                                                                                                var83_60 = var35_25 /* !! */ ;
                                                                                                var27_19 = 0;
                                                                                                var73_49 /* !! */  = null;
                                                                                            }
                                                                                            var35_25 /* !! */  = 2;
                                                                                            var1_1.updateLiveDataRegistration((int)var35_25 /* !! */ , (LiveData)var73_49 /* !! */ );
                                                                                            if (var73_49 /* !! */  == null) break block253;
                                                                                            var46_34 = (CameraSet$Panorama)var73_49 /* !! */ .getValue();
                                                                                            break block254;
                                                                                        }
                                                                                        var83_60 = var35_25 /* !! */ ;
                                                                                        var27_19 = 0;
                                                                                        var73_49 /* !! */  = null;
                                                                                    }
                                                                                    var35_25 /* !! */  = 0;
                                                                                    var46_34 = null;
                                                                                }
                                                                                var84_61 = var2_2 & var59_42;
                                                                                var33_24 = 0L;
                                                                                var86_62 = var84_61 == var33_24 ? 0 : (var84_61 < var33_24 ? -1 : 1);
                                                                                if (var86_62 == 0) break block255;
                                                                                if (var11_8 != null) {
                                                                                    var87_63 = var11_8.a0();
                                                                                    var88_64 = var38_28;
                                                                                    var89_65 = var87_63;
                                                                                    var87_63 = var73_49 /* !! */ ;
                                                                                    var73_49 /* !! */  = var89_65;
                                                                                } else {
                                                                                    var88_64 = var38_28;
                                                                                    var87_63 = var73_49 /* !! */ ;
                                                                                    var27_19 = 0;
                                                                                    var73_49 /* !! */  = null;
                                                                                }
                                                                                var38_28 = 7;
                                                                                var39_29 = 9.8E-45f;
                                                                                var1_1.updateLiveDataRegistration(var38_28, (LiveData)var73_49 /* !! */ );
                                                                                if (var73_49 /* !! */  != null) {
                                                                                    var40_30 = (CameraSet$DelayTime)var73_49 /* !! */ .getValue();
                                                                                } else {
                                                                                    var38_28 = 0;
                                                                                    var39_29 = 0.0f;
                                                                                    var40_30 = null;
                                                                                }
                                                                                var90_66 = var2_2 & 0x600080L;
                                                                                var33_24 = 0L;
                                                                                var27_19 = (int)(var90_66 == var33_24 ? 0 : (var90_66 < var33_24 ? -1 : 1));
                                                                                if (var27_19 == 0 || var40_30 == null) break block256;
                                                                                var73_49 /* !! */  = var40_30.getFormatStr();
                                                                                break block257;
                                                                            }
                                                                            var88_64 = var38_28;
                                                                            var87_63 = var73_49 /* !! */ ;
                                                                            var33_24 = 0L;
                                                                            var38_28 = 0;
                                                                            var39_29 = 0.0f;
                                                                            var40_30 = null;
                                                                        }
                                                                        var27_19 = 0;
                                                                        var73_49 /* !! */  = null;
                                                                    }
                                                                    var90_66 = var2_2 & 0x600200L;
                                                                    var92_67 = var90_66 == var33_24 ? 0 : (var90_66 < var33_24 ? -1 : 1);
                                                                    if (var92_67 == false) break block258;
                                                                    if (var11_8 != null) {
                                                                        var93_69 = var11_8.W();
                                                                        var94_70 = var37_27;
                                                                        var89_65 = var93_69;
                                                                        var93_69 = var73_49 /* !! */ ;
                                                                        var73_49 /* !! */  = var89_65;
                                                                    } else {
                                                                        var94_70 = var37_27;
                                                                        var93_69 = var73_49 /* !! */ ;
                                                                        var27_19 = 0;
                                                                        var73_49 /* !! */  = null;
                                                                    }
                                                                    var37_27 = 9;
                                                                    var1_1.updateLiveDataRegistration(var37_27, (LiveData)var73_49 /* !! */ );
                                                                    if (var73_49 /* !! */  == null) break block259;
                                                                    var36_26 = (String)var73_49 /* !! */ .getValue();
                                                                    break block260;
                                                                }
                                                                var94_70 = var37_27;
                                                                var93_69 = var73_49 /* !! */ ;
                                                            }
                                                            var37_27 = 0;
                                                            var36_26 = null;
                                                        }
                                                        var95_71 = var2_2 & 0x600400L;
                                                        var33_24 = 0L;
                                                        var27_19 = (int)(var95_71 == var33_24 ? 0 : (var95_71 < var33_24 ? -1 : 1));
                                                        if (var27_19 == 0) break block261;
                                                        if (var11_8 != null) {
                                                            var73_49 /* !! */  = var11_8.l0();
                                                            var97_72 /* !! */  = var36_26;
                                                        } else {
                                                            var97_72 /* !! */  = var36_26;
                                                            var27_19 = 0;
                                                            var73_49 /* !! */  = null;
                                                        }
                                                        var37_27 = 10;
                                                        var1_1.updateLiveDataRegistration(var37_27, (LiveData)var73_49 /* !! */ );
                                                        if (var73_49 /* !! */  == null) break block262;
                                                        var36_26 = (Integer)var73_49 /* !! */ .getValue();
                                                        break block263;
                                                    }
                                                    var97_72 /* !! */  = var36_26;
                                                }
                                                var37_27 = 0;
                                                var36_26 = null;
                                            }
                                            var98_73 = var2_2 & 6824391L;
                                            var33_24 = 0L;
                                            var27_19 = (int)(var98_73 == var33_24 ? 0 : (var98_73 < var33_24 ? -1 : 1));
                                            if (var27_19 == 0) break block264;
                                            if (var11_8 != null) {
                                                var73_49 /* !! */  = var11_8.H();
                                                var100_74 /* !! */  = var36_26;
                                            } else {
                                                var100_74 /* !! */  = var36_26;
                                                var27_19 = 0;
                                                var73_49 /* !! */  = null;
                                            }
                                            var37_27 = 13;
                                            var1_1.updateLiveDataRegistration(var37_27, (LiveData)var73_49 /* !! */ );
                                            if (var73_49 /* !! */  != null) {
                                                var36_26 = (CameraSet$Mode)var73_49 /* !! */ .getValue();
                                            } else {
                                                var37_27 = 0;
                                                var36_26 = null;
                                            }
                                            var101_76 = var2_2 & var53_39;
                                            var33_24 = 0L;
                                            var103_77 = var101_76 == var33_24 ? 0 : (var101_76 < var33_24 ? -1 : 1);
                                            var104_78 = var73_49 /* !! */ ;
                                            if (var103_77) {
                                                var73_49 /* !! */  = CameraSet$Mode.slow_motion;
                                                if (var73_49 /* !! */  == var36_26) {
                                                    var27_19 = 1;
                                                } else {
                                                    var27_19 = 0;
                                                    var73_49 /* !! */  = null;
                                                }
                                                if (var103_77) {
                                                    if (var27_19 != 0) {
                                                        var105_79 = 0x400000000000L;
                                                        var2_2 |= var105_79;
                                                    } else {
                                                        var2_2 |= var55_40;
                                                    }
                                                }
                                            } else {
                                                var27_19 = 0;
                                                var73_49 /* !! */  = null;
                                            }
                                            if (var103_77 = (cfr_temp_6 = (var105_79 = var2_2 & var63_44) - (var33_24 = 0L)) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1)) {
                                                var107_80 = var11_8 != null ? var11_8.Y0((CameraSet$Mode)var36_26, (CameraSet$Panorama)var46_34) : false;
                                                if (var103_77) {
                                                    var108_81 = var107_80 != false ? 0x4000000000L : 0x2000000000L;
                                                    var2_2 |= var108_81;
                                                }
                                            } else {
                                                var107_80 = false;
                                            }
                                            if (var103_77 = (cfr_temp_7 = (var108_81 = var2_2 & var69_47) - (var33_24 = 0L)) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1)) {
                                                if (var11_8 != null) {
                                                    var110_82 = var11_8.f1((CameraSet$Mode)var36_26, (boolean)var15_11);
                                                    var111_83 = var11_8.h1((CameraSet$Mode)var36_26, (boolean)var15_11);
                                                } else {
                                                    var110_82 = false;
                                                    var111_83 = false;
                                                }
                                                if (var103_77) {
                                                    var112_84 = var110_82 != false ? 0x40000000000000L : 0x20000000000000L;
                                                    var2_2 |= var112_84;
                                                }
                                                if (var103_77 = (cfr_temp_8 = (var112_84 = var2_2 & var69_47) - (var33_24 = 0L)) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1)) {
                                                    var112_84 = var111_83 != false ? 4096L : 2048L;
                                                    var6_4 |= var112_84;
                                                }
                                            } else {
                                                var110_82 = false;
                                                var111_83 = false;
                                            }
                                            if (!(var103_77 = (cfr_temp_9 = (var112_84 = var2_2 & var59_42) - (var33_24 = 0L)) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1))) ** GOTO lbl-1000
                                            if (var11_8 != null) {
                                                var38_28 = (int)var11_8.e1((CameraSet$Mode)var36_26, (boolean)var15_11, (CameraSet$DelayTime)var40_30);
                                            } else {
                                                var38_28 = 0;
                                                var39_29 = 0.0f;
                                                var40_30 = null;
                                            }
                                            if (var103_77) {
                                                var112_84 = var38_28 != 0 ? (long)16 : (long)8;
                                                var6_4 |= var112_84;
                                            }
                                            if (var38_28 == 0) {
                                                var38_28 = 8;
                                                var39_29 = 1.1E-44f;
                                            } else lbl-1000:
                                            // 2 sources

                                            {
                                                var38_28 = 0;
                                                var39_29 = 0.0f;
                                                var40_30 = null;
                                            }
                                            var112_84 = var2_2 & var65_45;
                                            var33_24 = 0L;
                                            var103_77 = var112_84 == var33_24 ? 0 : (var112_84 < var33_24 ? -1 : 1);
                                            if (var103_77) {
                                                var114_85 = var11_8 != null ? var11_8.g1((CameraSet$Mode)var36_26, (boolean)var15_11) : false;
                                                if (var103_77 || (var103_77 = (cfr_temp_10 = (var115_86 = var6_4 & var67_46) - var33_24) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1))) {
                                                    if (var114_85) {
                                                        var2_2 |= var49_37;
                                                    } else {
                                                        var115_86 = 0x200000000000000L;
                                                        var2_2 |= var115_86;
                                                    }
                                                }
                                            } else {
                                                var114_85 = false;
                                            }
                                            if (var103_77 = (cfr_temp_11 = (var115_86 = var2_2 & 6824259L) - (var33_24 = 0L)) == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1)) {
                                                var103_77 = var11_8 != null ? var11_8.S0((CameraSet$Mode)var36_26) : false;
                                                var115_86 = var2_2 & var61_43;
                                                cfr_temp_12 = var115_86 - var33_24;
                                                var117_87 /* !! */  = (long)(cfr_temp_12 == 0L ? 0 : (cfr_temp_12 < 0L ? -1 : 1));
                                                if (var117_87 /* !! */  != false) {
                                                    if (var103_77) {
                                                        var6_4 |= var67_46;
                                                    } else {
                                                        var115_86 = 512L;
                                                        var6_4 |= var115_86;
                                                    }
                                                }
                                                if ((var117_87 /* !! */  = (cfr_temp_13 = (var115_86 = var2_2 & var51_38) - var33_24) == 0L ? 0 : (cfr_temp_13 < 0L ? -1 : 1)) != false) {
                                                    var115_86 = var103_77 != false ? 16384L : 8192L;
                                                    var6_4 |= var115_86;
                                                }
                                                break block265;
                                            } else {
                                                var103_77 = false;
                                            }
                                            break block265;
                                        }
                                        var100_74 /* !! */  = var36_26;
                                        var38_28 = 0;
                                        var39_29 = 0.0f;
                                        var40_30 = null;
                                        var37_27 = 0;
                                        var36_26 = null;
                                        var27_19 = 0;
                                        var73_49 /* !! */  = null;
                                        var103_77 = false;
                                        var104_78 = null;
                                        var107_80 = false;
                                        var110_82 = false;
                                        var111_83 = false;
                                        var114_85 = false;
                                    }
                                    if ((var117_87 /* !! */  = (cfr_temp_14 = (var115_86 = var2_2 & 0x604000L) - (var33_24 = 0L)) == 0L ? 0 : (cfr_temp_14 < 0L ? -1 : 1)) != false) {
                                        if (var11_8 != null) {
                                            var118_88 = var11_8.F0();
                                            var119_89 /* !! */  = var36_26;
                                            var89_65 = var118_88;
                                            var117_87 /* !! */  = var38_28;
                                            var120_90 = var39_29;
                                            var40_30 = var118_88;
                                        } else {
                                            var117_87 /* !! */  = var38_28;
                                            var120_91 = var39_29;
                                            var119_89 /* !! */  = var36_26;
                                            var38_28 = 0;
                                            var39_29 = 0.0f;
                                            var40_30 = null;
                                        }
                                        var37_27 = 14;
                                        var1_1.updateLiveDataRegistration(var37_27, (LiveData)var40_30);
                                        if (var40_30 != null) {
                                            var40_30 = (Integer)var40_30.getValue();
                                        } else {
                                            var38_28 = 0;
                                            var39_29 = 0.0f;
                                            var40_30 = null;
                                        }
                                        var38_28 = ViewDataBinding.safeUnbox((Integer)var40_30);
                                        var36_26 = this.getRoot().getContext();
                                        var40_30 = ContextCompat.getDrawable((Context)var36_26, var38_28);
                                    } else {
                                        var117_87 /* !! */  = var38_28;
                                        var120_92 = var39_29;
                                        var119_89 /* !! */  = var36_26;
                                        var38_28 = 0;
                                        var39_29 = 0.0f;
                                        var40_30 = null;
                                    }
                                    var121_93 = var2_2 & 0x608000L;
                                    var33_24 = 0L;
                                    var37_27 = (int)(var121_93 == var33_24 ? 0 : (var121_93 < var33_24 ? -1 : 1));
                                    if (var37_27 == 0) break block266;
                                    if (var11_8 != null) {
                                        var36_26 = var11_8.Y();
                                        var121_93 = var2_2;
                                    } else {
                                        var121_93 = var2_2;
                                        var37_27 = 0;
                                        var36_26 = null;
                                    }
                                    var123_94 = 15;
                                    var1_1.updateLiveDataRegistration(var123_94, (LiveData)var36_26);
                                    if (var36_26 != null) {
                                        var124_95 /* !! */  = (CameraSet$DelayInterval)var36_26.getValue();
                                    } else {
                                        var123_94 = 0;
                                        var124_95 /* !! */  = null;
                                    }
                                    if (var124_95 /* !! */  == null) break block267;
                                    var124_95 /* !! */  = var124_95 /* !! */ .getStr();
                                    var37_27 = (int)var48_36;
                                    var125_96 = var93_69;
                                    var93_69 = var100_74 /* !! */ ;
                                    var126_97 = var117_87 /* !! */ ;
                                    var75_51 /* !! */  = var46_34;
                                    var35_25 /* !! */  = var27_19;
                                    var89_65 = var97_72 /* !! */ ;
                                    var97_72 /* !! */  = var124_95 /* !! */ ;
                                    var2_2 = var121_93;
                                    var127_98 = var40_30;
                                    var128_99 = var15_11;
                                    var38_28 = var76_52;
                                    var39_29 = var77_54;
                                    var78_56 /* !! */  = var89_65;
                                    var31_23 = var6_4;
                                    break block268;
                                }
                                var121_93 = var2_2;
                            }
                            var37_27 = (int)var48_36;
                            var125_96 = var93_69;
                            var93_69 = var100_74 /* !! */ ;
                            var126_97 = var117_87 /* !! */ ;
                            var2_2 = var121_93;
                            var75_51 /* !! */  = var46_34;
                            var35_25 /* !! */  = var27_19;
                            var127_98 = var40_30;
                            var128_99 = var15_11;
                            var38_28 = var76_52;
                            var39_29 = var77_54;
                            var78_56 /* !! */  = var97_72 /* !! */ ;
                            var97_72 /* !! */  = null;
                            var31_23 = var6_4;
                            break block268;
                        }
                        var88_64 = var38_28;
                        var94_70 = var37_27;
                        var83_60 = var35_25 /* !! */ ;
                        var31_23 = var6_4;
                        var38_28 = 0;
                        var39_29 = 0.0f;
                        var40_30 = null;
                        var37_27 = 0;
                        var36_26 = null;
                        var129_100 = 0;
                        var127_98 = null;
                        var128_99 = 0;
                        var130_101 = null;
                        var35_25 /* !! */  = 0;
                        var46_34 = null;
                        var48_36 = 0;
                        var74_50 = 0.0f;
                        var75_51 /* !! */  = null;
                        var76_53 = false;
                        var77_55 = 0.0f;
                        var78_56 /* !! */  = null;
                        var86_62 = 0;
                        var87_63 = null;
                        var92_68 = false;
                        var93_69 = null;
                        var97_72 /* !! */  = null;
                        var126_97 = 0;
                        var100_75 = null;
                        var103_77 = false;
                        var104_78 = null;
                        var107_80 = false;
                        var110_82 = false;
                        var111_83 = false;
                        var114_85 = false;
                        var119_89 /* !! */  = null;
                        var125_96 = null;
                    }
                    var121_93 = var31_23 & 16384L;
                    var33_24 = 0L;
                    var117_87 /* !! */  = var121_93 == var33_24 ? 0 : (var121_93 < var33_24 ? -1 : 1);
                    if (var117_87 /* !! */  != false) {
                        if (var9_6 != null) {
                            var9_6 = var9_6.B;
                            var118_88 = var127_98;
                        } else {
                            var118_88 = var127_98;
                            var131_102 /* !! */  = 0;
                            var9_6 = null;
                        }
                        var129_100 = 6;
                        var1_1.updateLiveDataRegistration(var129_100, (LiveData)var9_6);
                        if (var9_6 != null) {
                            var127_98 = (Boolean)var9_6.getValue();
                        } else {
                            var129_100 = 0;
                            var127_98 = null;
                        }
                        var129_100 = (int)ViewDataBinding.safeUnbox((Boolean)var127_98);
                    } else {
                        var118_88 = var127_98;
                        var129_100 = 0;
                        var127_98 = null;
                    }
                    var121_93 = var2_2 & 18049926478954496L;
                    var33_24 = 0L;
                    var131_102 /* !! */  = var121_93 == var33_24 ? 0 : (var121_93 < var33_24 ? -1 : 1);
                    if (var131_102 /* !! */  == 0 && (var131_102 /* !! */  = (cfr_temp_15 = (var121_93 = var31_23 & 5376L) - var33_24) == 0L ? 0 : (cfr_temp_15 < 0L ? -1 : 1)) == 0) {
                        var132_103 = var129_100;
                        var48_36 = var28_20;
                        var74_50 = var29_21;
                        var86_62 = var14_10 /* !! */ ;
                        var129_100 = 0;
                        var127_98 = null;
                        var128_99 = 0;
                        var130_101 = null;
                        var104_78 = null;
                        var133_104 = 0;
                        var134_105 = false;
                        var135_107 = null;
                    } else {
                        var121_93 = var31_23 & 256L;
                        cfr_temp_16 = var121_93 - var33_24;
                        var131_102 /* !! */  = (int)(cfr_temp_16 == 0L ? 0 : (cfr_temp_16 < 0L ? -1 : 1));
                        if (var131_102 /* !! */  != 0) {
                            if (var11_8 != null) {
                                var87_63 = var11_8.k0();
                            }
                            var132_103 = var129_100;
                            var127_98 = var87_63;
                            var86_62 = var14_10 /* !! */ ;
                            var14_10 /* !! */  = 2;
                            var1_1.updateLiveDataRegistration((int)var14_10 /* !! */ , var87_63);
                            if (var87_63 != null) {
                                var75_51 /* !! */  = var127_98 = var87_63.getValue();
                                var75_51 /* !! */  = (CameraSet$Panorama)var127_98;
                            }
                        } else {
                            var132_103 = var129_100;
                            var86_62 = var14_10 /* !! */ ;
                        }
                        var127_98 = var75_51 /* !! */ ;
                        var136_108 = var2_2 & 0x40005000000000L;
                        var33_24 = 0L;
                        cfr_temp_17 = var136_108 - var33_24;
                        var14_10 /* !! */  = (long)(cfr_temp_17 == 0L ? 0 : (cfr_temp_17 < 0L ? -1 : 1));
                        if (var14_10 /* !! */  == false && (var14_10 /* !! */  = (cfr_temp_18 = (var136_108 = var31_23 & 4096L) - var33_24) == 0L ? 0 : (cfr_temp_18 < 0L ? -1 : 1)) == false) {
                            var48_36 = var28_20;
                            var74_50 = var29_21;
                            var28_20 = 0;
                            var29_21 = 0.0f;
                            var8_5 = null;
                            var14_10 /* !! */  = 0;
                            var30_22 = null;
                            var133_104 = 0;
                        } else {
                            if (var11_8 != null) {
                                var30_22 = var11_8.w0();
                                var48_36 = var28_20;
                                var74_50 = var29_21;
                                var28_20 = 8;
                                var29_21 = 1.1E-44f;
                            } else {
                                var48_36 = var28_20;
                                var74_50 = var29_21;
                                var28_20 = 8;
                                var29_21 = 1.1E-44f;
                                var14_10 /* !! */  = 0;
                                var30_22 = null;
                            }
                            var1_1.updateLiveDataRegistration(var28_20, var30_22);
                            if (var30_22 != null) {
                                var8_5 = (Boolean)var30_22.getValue();
                            } else {
                                var28_20 = 0;
                                var29_21 = 0.0f;
                                var8_5 = null;
                            }
                            var133_104 = ViewDataBinding.safeUnbox((Boolean)var8_5);
                        }
                        var136_108 = var2_2 & var55_40;
                        var33_24 = 0L;
                        var134_106 = var136_108 == var33_24 ? 0 : (var136_108 < var33_24 ? -1 : 1);
                        if (var134_106 == false && (var134_106 = (cfr_temp_19 = (var136_108 = var31_23 & 1280L) - var33_24) == 0L ? 0 : (cfr_temp_19 < 0L ? -1 : 1)) == false) {
                            var135_107 = var8_5;
                            var104_78 = var30_22;
                            var129_100 = 0;
                            var127_98 = null;
                            var128_99 = 0;
                            var130_101 = null;
                            var33_24 = 0L;
                        } else {
                            if (var11_8 != null) {
                                var104_78 = var11_8.H();
                            }
                            var135_107 = var8_5;
                            var8_5 = var104_78;
                            var104_78 = var30_22;
                            var14_10 /* !! */  = 13;
                            var1_1.updateLiveDataRegistration((int)var14_10 /* !! */ , (LiveData)var8_5);
                            if (var8_5 != null) {
                                var8_5 = var8_5.getValue();
                                var119_89 /* !! */  = var8_5;
                                var119_89 /* !! */  = (CameraSet$Mode)var8_5;
                            }
                            var8_5 = var119_89 /* !! */ ;
                            if (var131_102 /* !! */  != 0 && var11_8 != null) {
                                var129_100 = (int)var11_8.V0((CameraSet$Mode)var119_89 /* !! */ , (CameraSet$Panorama)var127_98);
                            } else {
                                var129_100 = 0;
                                var127_98 = null;
                            }
                            var138_109 = var31_23 & var67_46;
                            var33_24 = 0L;
                            var131_102 /* !! */  = (int)(var138_109 == var33_24 ? 0 : (var138_109 < var33_24 ? -1 : 1));
                            if (var131_102 /* !! */  != 0) {
                                if (var11_8 != null) {
                                    var114_85 = var11_8.g1((CameraSet$Mode)var8_5, (boolean)var128_99);
                                }
                                if ((var128_99 = (cfr_temp_20 = (var138_109 = var2_2 & var65_45) - var33_24) == 0L ? 0 : (cfr_temp_20 < 0L ? -1 : 1)) != 0 || var131_102 /* !! */  != 0) {
                                    if (var114_85) {
                                        var2_2 |= var49_37;
                                    } else {
                                        var138_109 = 0x200000000000000L;
                                        var2_2 |= var138_109;
                                    }
                                }
                            }
                            if ((var128_99 = (cfr_temp_21 = (var55_40 = var2_2 & var55_40) - (var33_24 = 0L)) == 0L ? 0 : (cfr_temp_21 < 0L ? -1 : 1)) != 0 && (var130_101 = CameraSet$Mode.dolly_zoom) == var8_5) {
                                var128_99 = 1;
                            } else {
                                var128_99 = 0;
                                var130_101 = null;
                            }
                        }
                    }
                    var140_110 = var2_2 & var18_13;
                    var28_20 = (int)(var140_110 == var33_24 ? 0 : (var140_110 < var33_24 ? -1 : 1));
                    if (var28_20 == 0) ** GOTO lbl-1000
                    if (var23_16 != 0) {
                        var23_16 = var133_104;
                    } else {
                        var23_16 = 0;
                        var22_15 /* !! */  = null;
                    }
                    if (var28_20 != 0) {
                        var140_110 = var23_16 != 0 ? (long)64 : (long)32;
                        var31_23 |= var140_110;
                    }
                    if (var23_16 == 0) {
                        var28_20 = 8;
                        var29_21 = 1.1E-44f;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var28_20 = 0;
                        var29_21 = 0.0f;
                        var8_5 = null;
                    }
                    var55_40 = var2_2 & var63_44;
                    var33_24 = 0L;
                    var23_16 = var55_40 == var33_24 ? 0 : (var55_40 < var33_24 ? -1 : 1);
                    if (var23_16 == 0) ** GOTO lbl-1000
                    if (var107_80) {
                        var131_102 /* !! */  = var133_104;
                    } else {
                        var131_102 /* !! */  = 0;
                        var9_6 = null;
                    }
                    if (var23_16 != 0) {
                        var55_40 = var131_102 /* !! */  != 0 ? 65536L : 32768L;
                        var31_23 |= var55_40;
                    }
                    if (var131_102 /* !! */  == 0) {
                        var23_16 = 8;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var23_16 = 0;
                        var22_15 /* !! */  = null;
                    }
                    var55_40 = var2_2 & var53_39;
                    var33_24 = 0L;
                    var131_102 /* !! */  = (int)(var55_40 == var33_24 ? 0 : (var55_40 < var33_24 ? -1 : 1));
                    if (var131_102 /* !! */  == 0) ** GOTO lbl-1000
                    if (var35_25 /* !! */  != false) {
                        var128_99 = 1;
                    }
                    if (var131_102 /* !! */  != 0) {
                        if (var128_99 != 0) {
                            var55_40 = 1L;
                            var31_23 |= var55_40;
                        } else {
                            var55_40 = -9223372036854775808L;
                            var2_2 |= var55_40;
                        }
                    }
                    if (var128_99 != 0) {
                        var128_99 = 8;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var128_99 = 0;
                        var130_101 = null;
                    }
                    var55_40 = var2_2 & var69_47;
                    var33_24 = 0L;
                    var131_102 /* !! */  = (int)(var55_40 == var33_24 ? 0 : (var55_40 < var33_24 ? -1 : 1));
                    if (var131_102 /* !! */  == 0) break block269;
                    if (var110_82) {
                        var14_10 /* !! */  = var133_104;
                    } else {
                        var14_10 /* !! */  = 0;
                        var30_22 = null;
                    }
                    if (var111_83) {
                        var35_25 /* !! */  = var133_104;
                    } else {
                        var35_25 /* !! */  = 0;
                        var46_34 = null;
                    }
                    if (var131_102 /* !! */  != 0) {
                        var55_40 = var14_10 /* !! */  != false ? 0x1000000000000000L : 0x800000000000000L;
                        var2_2 |= var55_40;
                    }
                    if ((var131_102 /* !! */  = (int)((cfr_temp_22 = (var55_40 = var2_2 & var69_47) - (var33_24 = 0L)) == 0L ? 0 : (cfr_temp_22 < 0L ? -1 : 1))) != 0) {
                        var55_40 = var35_25 /* !! */  != false ? 0x100000000000L : 0x80000000000L;
                        var2_2 |= var55_40;
                    }
                    if (var14_10 /* !! */  != false) {
                        var131_102 /* !! */  = 0;
                        var9_6 = null;
                    } else {
                        var131_102 /* !! */  = 8;
                    }
                    if (var35_25 /* !! */  != false) break block270;
                    var14_10 /* !! */  = 8;
                    break block271;
                }
                var131_102 /* !! */  = 0;
                var9_6 = null;
            }
            var14_10 /* !! */  = 0;
            var30_22 = null;
        }
        var55_40 = 7348524L;
        var105_79 = var2_2 & var55_40;
        var33_24 = 0L;
        var35_25 /* !! */  = var105_79 == var33_24 ? 0 : (var105_79 < var33_24 ? -1 : 1);
        if (var35_25 /* !! */  != false) {
            if (var43_32 == 0) {
                var129_100 = 0;
                var127_98 = null;
            }
            if (var35_25 /* !! */  != false) {
                var55_40 = var129_100 != 0 ? 0x4000000000000L : 0x2000000000000L;
                var2_2 |= var55_40;
            }
        } else {
            var129_100 = 0;
            var127_98 = null;
        }
        if ((var43_32 = (cfr_temp_23 = (var55_40 = var2_2 & var51_38) - (var33_24 = 0L)) == 0L ? 0 : (cfr_temp_23 < 0L ? -1 : 1)) == 0) ** GOTO lbl-1000
        if (!var103_77) {
            var132_103 = 0;
        }
        if (var43_32 != 0) {
            var55_40 = var132_103 != 0 ? 0x10000000000L : 0x8000000000L;
            var2_2 |= var55_40;
        }
        if (var132_103 == 0) {
            var43_32 = 8;
        } else lbl-1000:
        // 2 sources

        {
            var43_32 = 0;
            var10_7 = null;
        }
        var55_40 = var2_2 & 0x404000000000000L;
        var33_24 = 0L;
        var35_25 /* !! */  = var55_40 == var33_24 ? 0 : (var55_40 < var33_24 ? -1 : 1);
        if (var35_25 /* !! */  != false) {
            cfr_temp_24 = (var49_37 = var2_2 & var49_37) - var33_24;
            var35_25 /* !! */  = (long)(cfr_temp_24 == 0L ? 0 : (cfr_temp_24 < 0L ? -1 : 1));
            if (var35_25 /* !! */  != false) {
                if (var11_8 != null) {
                    var46_34 = var11_8.s0();
                    var142_111 = var28_20;
                    var143_112 = var29_21;
                    var8_5 = var46_34;
                } else {
                    var142_111 = var28_20;
                    var143_112 = var29_21;
                    var28_20 = 0;
                    var29_21 = 0.0f;
                    var8_5 = null;
                }
                var35_25 /* !! */  = 0;
                var46_34 = null;
                var1_1.updateLiveDataRegistration(0, (LiveData)var8_5);
                if (var8_5 != null) {
                    var8_5 = (Boolean)var8_5.getValue();
                } else {
                    var28_20 = 0;
                    var29_21 = 0.0f;
                    var8_5 = null;
                }
                var28_20 = (int)ViewDataBinding.safeUnbox((Boolean)var8_5);
            } else {
                var142_111 = var28_20;
                var143_112 = var29_21;
                var35_25 /* !! */  = 0;
                var46_34 = null;
                var28_20 = 0;
                var8_5 = null;
                var29_21 = 0.0f;
            }
            var49_37 = var2_2 & 0x4000000000000L;
            var33_24 = 0L;
            var144_113 = var49_37 == var33_24 ? 0 : (var49_37 < var33_24 ? -1 : 1);
            if (var144_113 != false) {
                if (var11_8 != null) {
                    var145_114 = var11_8.i0();
                    var146_115 = var28_20;
                    var46_34 = var145_114;
                } else {
                    var146_115 = var28_20;
                    var35_25 /* !! */  = 0;
                    var46_34 = null;
                }
                var28_20 = 3;
                var29_21 = 4.2E-45f;
                var1_1.updateLiveDataRegistration(var28_20, (LiveData)var46_34);
                if (var46_34 != null) {
                    var8_5 = (Boolean)var46_34.getValue();
                } else {
                    var28_20 = 0;
                    var29_21 = 0.0f;
                    var8_5 = null;
                }
                var28_20 = (int)ViewDataBinding.safeUnbox((Boolean)var8_5);
            } else {
                var146_115 = var28_20;
                var28_20 = 0;
                var29_21 = 0.0f;
                var8_5 = null;
            }
        } else {
            var142_111 = var28_20;
            var143_112 = var29_21;
            var28_20 = 0;
            var29_21 = 0.0f;
            var8_5 = null;
            var146_115 = 0;
        }
        var55_40 = 7348524L;
        var105_79 = var2_2 & var55_40;
        var33_24 = 0L;
        var35_25 /* !! */  = var105_79 == var33_24 ? 0 : (var105_79 < var33_24 ? -1 : 1);
        if (var35_25 /* !! */  != false) {
            if (var129_100 == 0) {
                var28_20 = 0;
                var29_21 = 0.0f;
                var8_5 = null;
            }
            if (var35_25 /* !! */  != false) {
                var55_40 = var28_20 != 0 ? 0x10000000L : 0x8000000L;
                var2_2 |= var55_40;
            }
        } else {
            var28_20 = 0;
            var29_21 = 0.0f;
            var8_5 = null;
        }
        if ((var129_100 = (int)((cfr_temp_25 = (var55_40 = var2_2 & var65_45) - (var33_24 = 0L)) == 0L ? 0 : (cfr_temp_25 < 0L ? -1 : 1))) == 0 && (var35_25 /* !! */  = (cfr_temp_26 = (var55_40 = var31_23 & var67_46) - var33_24) == 0L ? 0 : (cfr_temp_26 < 0L ? -1 : 1)) == false) {
            var129_100 = 0;
            var127_98 = null;
            var15_11 = 0;
            var26_18 = null;
            var33_24 = 0L;
        } else {
            if (!var114_85) {
                var146_115 = 0;
            }
            if (var129_100 != 0) {
                var55_40 = var146_115 != 0 ? 0x100000000000000L : 0x80000000000000L;
                var2_2 |= var55_40;
            }
            if ((var129_100 = (int)((cfr_temp_27 = (var31_23 &= var67_46) - (var33_24 = 0L)) == 0L ? 0 : (cfr_temp_27 < 0L ? -1 : 1))) != 0) {
                var129_100 = var146_115 ^ 1;
            } else {
                var129_100 = 0;
                var127_98 = null;
            }
            var31_23 = var2_2 & var65_45;
            var15_11 = var31_23 == var33_24 ? 0 : (var31_23 < var33_24 ? -1 : 1);
            if (var15_11 != 0 && var146_115 == 0) {
                var15_11 = 8;
            } else {
                var15_11 = 0;
                var26_18 = null;
            }
        }
        var16_12 = var2_2 & var61_43;
        var27_19 = (int)(var16_12 == var33_24 ? 0 : (var16_12 < var33_24 ? -1 : 1));
        if (var27_19 != 0) {
            if (!var103_77) {
                var129_100 = 0;
                var127_98 = null;
            }
            if (var27_19 != 0) {
                var16_12 = var129_100 != 0 ? 0x4000000L : 0x2000000L;
                var2_2 |= var16_12;
            }
        } else {
            var129_100 = 0;
            var127_98 = null;
        }
        if ((var27_19 = (int)((cfr_temp_28 = (var16_12 = 0x14000000L & var2_2) - (var33_24 = 0L)) == 0L ? 0 : (cfr_temp_28 < 0L ? -1 : 1))) != 0) {
            if (var11_8 != null) {
                var104_78 = var11_8.w0();
            }
            var73_49 /* !! */  = var104_78;
            var147_116 = 8;
            var148_117 = 1.1E-44f;
            var1_1.updateLiveDataRegistration(var147_116, (LiveData)var104_78);
            if (var104_78 != null) {
                var135_107 = var73_49 /* !! */  = var104_78.getValue();
                var135_107 = (Boolean)var73_49 /* !! */ ;
            }
            var133_104 = (int)ViewDataBinding.safeUnbox((Boolean)var135_107);
        } else {
            var147_116 = 8;
            var148_118 = 1.1E-44f;
        }
        var16_12 = var2_2 & var61_43;
        var33_24 = 0L;
        var27_19 = (int)(var16_12 == var33_24 ? 0 : (var16_12 < var33_24 ? -1 : 1));
        if (var27_19 == 0) ** GOTO lbl-1000
        if (var129_100 != 0) {
            var129_100 = var133_104;
        } else {
            var129_100 = 0;
            var127_98 = null;
        }
        if (var129_100 == 0) {
            var129_100 = var147_116;
        } else lbl-1000:
        // 2 sources

        {
            var129_100 = 0;
            var127_98 = null;
        }
        var55_40 = var2_2 & 7348524L;
        var16_12 = 0L;
        var47_35 = var55_40 == var16_12 ? 0 : (var55_40 < var16_12 ? -1 : 1);
        if (var47_35) {
            if (var28_20 == 0) {
                var133_104 = 0;
            }
            if (var47_35) {
                var16_12 = var133_104 != 0 ? 0x40000000000L : 0x20000000000L;
                var2_2 |= var16_12;
            }
            if (var133_104 != 0) {
                var144_113 = 0;
                var145_114 = null;
            } else {
                var144_113 = var147_116;
            }
            var16_12 = var2_2;
            var123_94 = (int)var144_113;
        } else {
            var16_12 = var2_2;
            var123_94 = 0;
            var124_95 /* !! */  = null;
        }
        var49_37 = var16_12 & var57_41;
        var33_24 = 0L;
        var149_119 = var49_37 == var33_24 ? 0 : (var49_37 < var33_24 ? -1 : 1);
        if (var149_119 != false) {
            var1_1.a.setVisibility(var38_28);
            var1_1.s.setVisibility(var38_28);
            var1_1.t.setVisibility(var38_28);
            var1_1.u.setVisibility(var37_27);
            var1_1.B.setVisibility(var38_28);
            var1_1.C.setVisibility(var37_27);
            var150_120 /* !! */  = var1_1.F;
            var150_120 /* !! */ .setVisibility(var37_27);
        }
        if ((var149_119 = (cfr_temp_29 = (var151_121 = 0x441000L & var16_12) - (var153_122 = 0L)) == 0L ? 0 : (cfr_temp_29 < 0L ? -1 : 1)) != false) {
            var149_119 = ViewDataBinding.getBuildSdkInt();
            var38_28 = 11;
            var39_29 = 1.5E-44f;
            if (var149_119 >= var38_28) {
                var150_120 /* !! */  = var1_1.b;
                var28_20 = (int)var48_36;
                var29_21 = var74_50;
                var150_120 /* !! */ .setAlpha(var74_50);
                var1_1.O.setAlpha(var74_50);
                var150_120 /* !! */  = var1_1.y;
                var150_120 /* !! */ .setAlpha(var74_50);
            }
            var150_120 /* !! */  = var1_1.D;
            var40_30 = var1_1.S;
            var37_27 = var86_62;
            ViewBindingAdapter.setOnClick((View)var150_120 /* !! */ , (View.OnClickListener)var40_30, (boolean)var86_62);
        }
        if ((var149_119 = (cfr_temp_30 = (var151_121 = var16_12 & var51_38) - (var24_17 = 0L)) == 0L ? 0 : (cfr_temp_30 < 0L ? -1 : 1)) != false) {
            var150_120 /* !! */  = var1_1.c;
            var150_120 /* !! */ .setVisibility(var43_32);
        }
        if ((var149_119 = (cfr_temp_31 = (var151_121 = var16_12 & var61_43) - var24_17) == 0L ? 0 : (cfr_temp_31 < 0L ? -1 : 1)) != false) {
            var150_120 /* !! */  = var1_1.d;
            var150_120 /* !! */ .setVisibility(var129_100);
        }
        if ((var149_119 = (cfr_temp_32 = (var151_121 = var16_12 & var63_44) - var24_17) == 0L ? 0 : (cfr_temp_32 < 0L ? -1 : 1)) != false) {
            var150_120 /* !! */  = var1_1.g;
            var150_120 /* !! */ .setVisibility(var23_16);
        }
        if ((var23_16 = (int)((cfr_temp_33 = (var151_121 = 4718608L & var16_12) - var24_17) == 0L ? 0 : (cfr_temp_33 < 0L ? -1 : 1))) != 0) {
            var22_15 /* !! */  = var1_1.h;
            var37_27 = var94_70;
            var22_15 /* !! */ .setTextColor(var94_70);
            var22_15 /* !! */  = var1_1.i;
            var38_28 = var88_64;
            var22_15 /* !! */ .setTextColor(var88_64);
        }
        if ((var23_16 = (int)((cfr_temp_34 = (var151_121 = 0x604000L & var16_12) - var24_17) == 0L ? 0 : (cfr_temp_34 < 0L ? -1 : 1))) != 0) {
            var22_15 /* !! */  = var1_1.k;
            var40_30 = var118_88;
            ImageViewBindingAdapter.setImageDrawable((ImageView)var22_15 /* !! */ , (Drawable)var118_88);
        }
        if ((var23_16 = (int)((cfr_temp_35 = (var151_121 = var16_12 & var53_39) - var24_17) == 0L ? 0 : (cfr_temp_35 < 0L ? -1 : 1))) != 0) {
            var22_15 /* !! */  = var1_1.k;
            var22_15 /* !! */ .setVisibility(var128_99);
        }
        if ((var23_16 = (int)((cfr_temp_36 = (var151_121 = var16_12 & var65_45) - var24_17) == 0L ? 0 : (cfr_temp_36 < 0L ? -1 : 1))) != 0) {
            var22_15 /* !! */  = var1_1.n;
            var22_15 /* !! */ .setVisibility(var15_11);
        }
        if ((var23_16 = (int)((cfr_temp_37 = (var151_121 = var16_12 & var69_47) - var24_17) == 0L ? 0 : (cfr_temp_37 < 0L ? -1 : 1))) != 0) {
            var1_1.o.setVisibility(var131_102 /* !! */ );
            var22_15 /* !! */  = var1_1.p;
            var22_15 /* !! */ .setVisibility((int)var14_10 /* !! */ );
        }
        if ((var23_16 = (int)((cfr_temp_38 = (var151_121 = var16_12 & var41_31) - var24_17) == 0L ? 0 : (cfr_temp_38 < 0L ? -1 : 1))) != 0) {
            var22_15 /* !! */  = var1_1.o;
            var150_120 /* !! */  = var1_1.P;
            var38_28 = (int)var83_60;
            ViewBindingAdapter.setOnClick((View)var22_15 /* !! */ , (View.OnClickListener)var150_120 /* !! */ , (boolean)var83_60);
        }
        if ((var23_16 = (int)((cfr_temp_39 = (var151_121 = 0x400000L & var16_12) - var24_17) == 0L ? 0 : (cfr_temp_39 < 0L ? -1 : 1))) != 0) {
            var22_15 /* !! */  = var1_1.N;
            var150_120 /* !! */  = var1_1.R;
            var22_15 /* !! */ .setOnClickListener((View.OnClickListener)var150_120 /* !! */ );
            var22_15 /* !! */  = var1_1.O;
            var150_120 /* !! */  = var1_1.Q;
            var22_15 /* !! */ .setOnClickListener((View.OnClickListener)var150_120 /* !! */ );
        }
        if ((var23_16 = (int)((cfr_temp_40 = (var151_121 = var16_12 & var59_42) - var24_17) == 0L ? 0 : (cfr_temp_40 < 0L ? -1 : 1))) != 0) {
            var22_15 /* !! */  = var1_1.q;
            var149_119 = var126_97;
            var22_15 /* !! */ .setVisibility(var126_97);
        }
        if ((var23_16 = (int)((cfr_temp_41 = (var151_121 = 0x608000L & var16_12) - var24_17) == 0L ? 0 : (cfr_temp_41 < 0L ? -1 : 1))) != 0) {
            var22_15 /* !! */  = var1_1.s;
            var150_120 /* !! */  = var97_72 /* !! */ ;
            var38_28 = 0;
            var39_29 = 0.0f;
            var40_30 = null;
            l.a.q.g0.u.n((TextView)var22_15 /* !! */ , (String)var97_72 /* !! */ , null, null);
        } else {
            var38_28 = 0;
            var39_29 = 0.0f;
            var40_30 = null;
        }
        var155_123 = 0x600080L & var16_12;
        var23_16 = (int)(var155_123 == var24_17 ? 0 : (var155_123 < var24_17 ? -1 : 1));
        if (var23_16 != 0) {
            var22_15 /* !! */  = var1_1.t;
            var150_120 /* !! */  = var125_96;
            l.a.q.g0.u.n((TextView)var22_15 /* !! */ , (String)var125_96, null, null);
        }
        if ((var23_16 = (int)((cfr_temp_42 = (var151_121 = var16_12 & var18_13) - var24_17) == 0L ? 0 : (cfr_temp_42 < 0L ? -1 : 1))) != 0) {
            var22_15 /* !! */  = var1_1.v;
            var28_20 = var142_111;
            var29_21 = var143_112;
            var22_15 /* !! */ .setVisibility(var142_111);
        }
        if ((var23_16 = (int)((cfr_temp_43 = (var151_121 = 7348524L & var16_12) - var24_17) == 0L ? 0 : (cfr_temp_43 < 0L ? -1 : 1))) != 0) {
            var22_15 /* !! */  = var1_1.w;
            var22_15 /* !! */ .setVisibility(var123_94);
        }
        if ((var23_16 = (int)((cfr_temp_44 = (var2_2 = 0x600400L & var16_12) - var24_17) == 0L ? 0 : (cfr_temp_44 < 0L ? -1 : 1))) != 0) {
            var22_15 /* !! */  = var1_1.y;
            var124_95 /* !! */  = "@string/camera_panorama_clone_count";
            var150_120 /* !! */  = var93_69;
            var38_28 = 0;
            var39_29 = 0.0f;
            var40_30 = null;
            l.a.q.g0.u.n((TextView)var22_15 /* !! */ , (String)var124_95 /* !! */ , var93_69, null);
        } else {
            var38_28 = 0;
            var39_29 = 0.0f;
            var40_30 = null;
        }
        var2_2 = 0x600200L & var16_12;
        var23_16 = (int)(var2_2 == var24_17 ? 0 : (var2_2 < var24_17 ? -1 : 1));
        if (var23_16 != 0) {
            var22_15 /* !! */  = var1_1.B;
            var124_95 /* !! */  = var78_56 /* !! */ ;
            l.a.q.g0.u.n((TextView)var22_15 /* !! */ , (String)var78_56 /* !! */ , null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.T;
            long l11 = 0L;
            Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (object != false) return (boolean)((Object)1);
            l10 = this.U;
            long l12 = l10 - l11;
            object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object != false) return (boolean)((Object)1);
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
            this.T = l10 = 0x400000L;
            this.U = l10 = 0L;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        switch (n10) {
            default: {
                return false;
            }
            case 15: {
                object = (MutableLiveData)object;
                return this.S((MutableLiveData)object, n11);
            }
            case 14: {
                object = (MutableLiveData)object;
                return this.Z((MutableLiveData)object, n11);
            }
            case 13: {
                object = (MutableLiveData)object;
                return this.P((MutableLiveData)object, n11);
            }
            case 12: {
                object = (MutableLiveData)object;
                return this.L((MutableLiveData)object, n11);
            }
            case 11: {
                object = (MutableLiveData)object;
                return this.K((MutableLiveData)object, n11);
            }
            case 10: {
                object = (MutableLiveData)object;
                return this.W((MutableLiveData)object, n11);
            }
            case 9: {
                object = (MutableLiveData)object;
                return this.R((MutableLiveData)object, n11);
            }
            case 8: {
                object = (MutableLiveData)object;
                return this.Y((MutableLiveData)object, n11);
            }
            case 7: {
                object = (MutableLiveData)object;
                return this.T((MutableLiveData)object, n11);
            }
            case 6: {
                object = (MutableLiveData)object;
                return this.N((MutableLiveData)object, n11);
            }
            case 5: {
                object = (MutableLiveData)object;
                return this.O((MutableLiveData)object, n11);
            }
            case 4: {
                object = (MutableLiveData)object;
                return this.M((MutableLiveData)object, n11);
            }
            case 3: {
                object = (MutableLiveData)object;
                return this.U((MutableLiveData)object, n11);
            }
            case 2: {
                object = (MutableLiveData)object;
                return this.V((MutableLiveData)object, n11);
            }
            case 1: {
                object = (MutableLiveData)object;
                return this.Q((MutableLiveData)object, n11);
            }
            case 0: 
        }
        object = (MutableLiveData)object;
        return this.X((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 45;
        if (n11 == n10) {
            DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel = (DynamicZoomViewModel$TargetModel)((Object)object);
            this.G(dynamicZoomViewModel$TargetModel);
            return 1 != 0;
        } else {
            n11 = 23;
            if (n11 == n10) {
                CameraFragment$j cameraFragment$j = (CameraFragment$j)object;
                this.F(cameraFragment$j);
                return 1 != 0;
            } else {
                n11 = 13;
                if (n11 == n10) {
                    BleViewModel bleViewModel = (BleViewModel)object;
                    this.E(bleViewModel);
                    return 1 != 0;
                } else {
                    n11 = 46;
                    if (n11 == n10) {
                        DynamicZoomViewModel dynamicZoomViewModel = (DynamicZoomViewModel)object;
                        this.H(dynamicZoomViewModel);
                        return 1 != 0;
                    } else {
                        n11 = 112;
                        if (n11 == n10) {
                            v6 v62 = (v6)object;
                            this.I(v62);
                            return 1 != 0;
                        } else {
                            n11 = 152;
                            if (n11 != n10) return 0 != 0;
                            u6 u62 = (u6)object;
                            this.J(u62);
                        }
                    }
                }
            }
        }
        return 1 != 0;
    }
}

