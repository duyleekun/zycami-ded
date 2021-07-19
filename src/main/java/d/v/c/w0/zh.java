/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.camera.CameraFragment$j;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;
import com.zhiyun.cama.camera.widget.StoryProgressBar;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.u0.l;
import d.v.c.s0.u6;
import d.v.c.w0.yh;
import d.v.c.w0.zh$a;
import l.a.q.g0.u;

public class zh
extends yh
implements b$a {
    private static final ViewDataBinding$IncludedLayouts W;
    private static final SparseIntArray X;
    private final ConstraintLayout A;
    private final TextView B;
    private final ImageView C;
    private final TextView D;
    private final TextView E;
    private final ImageView F;
    private final View.OnClickListener G;
    private final View.OnClickListener H;
    private final View.OnClickListener I;
    private final View.OnClickListener J;
    private final View.OnClickListener K;
    private final View.OnClickListener L;
    private final View.OnClickListener M;
    private final View.OnClickListener N;
    private final View.OnClickListener O;
    private final View.OnClickListener P;
    private final View.OnClickListener Q;
    private final View.OnClickListener R;
    private final View.OnClickListener S;
    private zh$a T;
    private long U;
    private long V;

    static {
        SparseIntArray sparseIntArray;
        X = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362548, 21);
        sparseIntArray.put(2131362777, 22);
        sparseIntArray.put(2131362804, 23);
        sparseIntArray.put(2131362549, 24);
        sparseIntArray.put(2131362850, 25);
        sparseIntArray.put(2131363619, 26);
    }

    public zh(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = W;
        SparseIntArray sparseIntArray = X;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 27, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private zh(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        long l10;
        zh zh2 = this;
        Object object = this;
        Object object2 = dataBindingComponent;
        CheckBox checkBox = (CheckBox)objectArray[18];
        ExoVideoView exoVideoView = (ExoVideoView)objectArray[10];
        ConstraintLayout constraintLayout = (ConstraintLayout)((Object)objectArray[8]);
        Guideline guideline = (Guideline)((Object)objectArray[21]);
        Guideline guideline2 = (Guideline)((Object)objectArray[24]);
        ImageView imageView = (ImageView)objectArray[13];
        ImageView imageView2 = (ImageView)objectArray[16];
        ImageView imageView3 = (ImageView)objectArray[4];
        ImageView imageView4 = (ImageView)objectArray[12];
        ImageView imageView5 = (ImageView)objectArray[3];
        ImageView imageView6 = (ImageView)objectArray[5];
        View view2 = (View)objectArray[22];
        ImageView imageView7 = (ImageView)objectArray[6];
        Guideline guideline3 = (Guideline)((Object)objectArray[23]);
        LinearLayout linearLayout = (LinearLayout)objectArray[25];
        LinearLayout linearLayout2 = (LinearLayout)objectArray[17];
        RecyclerView recyclerView = (RecyclerView)objectArray[20];
        StoryProgressBar storyProgressBar = (StoryProgressBar)objectArray[14];
        TextView textView = (TextView)objectArray[15];
        TextView textView2 = (TextView)objectArray[26];
        View view3 = (View)objectArray[7];
        int n10 = 14;
        super(dataBindingComponent, view, n10, checkBox, exoVideoView, constraintLayout, guideline, guideline2, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, view2, imageView7, guideline3, linearLayout, linearLayout2, recyclerView, storyProgressBar, textView, textView2, view3);
        this.U = l10 = (long)-1;
        this.V = l10;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.m.setTag(null);
        this.p.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.A = object;
        object.setTag(null);
        int n11 = 1;
        zh2 = (TextView)objectArray[n11];
        this.B = zh2;
        zh2.setTag(null);
        n10 = 11;
        checkBox = (ImageView)objectArray[n10];
        this.C = checkBox;
        checkBox.setTag(null);
        checkBox = (TextView)objectArray[19];
        this.D = checkBox;
        checkBox.setTag(null);
        int n12 = 2;
        exoVideoView = (TextView)objectArray[n12];
        this.E = exoVideoView;
        exoVideoView.setTag(null);
        int n13 = 9;
        constraintLayout = (ImageView)objectArray[n13];
        this.F = constraintLayout;
        constraintLayout.setTag(null);
        this.q.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.u.setTag(null);
        object2 = view;
        this.setRootTag(view);
        object2 = new b(this, 12);
        this.G = object2;
        object2 = new b(this, 13);
        this.H = object2;
        object2 = new b(this, 6);
        this.I = object2;
        object2 = new b(this, 10);
        this.J = object2;
        object2 = new b(this, 5);
        this.K = object2;
        object2 = new b(this, n10);
        this.L = object2;
        object2 = new b(this, 4);
        this.M = object2;
        object2 = new b(this, 8);
        this.N = object2;
        object2 = new b(this, 3);
        this.O = object2;
        object2 = new b(this, n13);
        this.P = object2;
        object2 = new b(this, n12);
        this.Q = object2;
        object2 = new b(this, n11);
        this.R = object2;
        super(this, 7);
        this.S = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean I(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.U;
                long l11 = 256L;
                this.U = l10 |= l11;
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
                long l10 = this.U;
                long l11 = 8;
                this.U = l10 |= l11;
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
                long l10 = this.U;
                long l11 = 32;
                this.U = l10 |= l11;
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
                long l10 = this.U;
                long l11 = 4096L;
                this.U = l10 |= l11;
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
                long l10 = this.U;
                long l11 = 2048L;
                this.U = l10 |= l11;
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
                long l10 = this.U;
                long l11 = 64;
                this.U = l10 |= l11;
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
                long l10 = this.U;
                long l11 = 128L;
                this.U = l10 |= l11;
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
                long l10 = this.U;
                long l11 = 1L;
                this.U = l10 |= l11;
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
                long l10 = this.U;
                long l11 = 1024L;
                this.U = l10 |= l11;
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
                long l10 = this.U;
                long l11 = 2;
                this.U = l10 |= l11;
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
                long l10 = this.U;
                long l11 = 4;
                this.U = l10 |= l11;
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
                long l10 = this.U;
                long l11 = 512L;
                this.U = l10 |= l11;
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
    private boolean U(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.U;
                long l11 = 8192L;
                this.U = l10 |= l11;
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
                long l10 = this.U;
                long l11 = 16;
                this.U = l10 |= l11;
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
    public void D(BleViewModel bleViewModel) {
        this.y = bleViewModel;
        synchronized (this) {
            long l10 = this.U;
            long l11 = 65536L;
            this.U = l10 |= l11;
        }
        this.notifyPropertyChanged(13);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(u6 u62) {
        this.x = u62;
        synchronized (this) {
            long l10 = this.U;
            long l11 = 16384L;
            this.U = l10 |= l11;
        }
        this.notifyPropertyChanged(16);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(CameraFragment$j cameraFragment$j) {
        this.z = cameraFragment$j;
        synchronized (this) {
            long l10 = this.U;
            long l11 = 262144L;
            this.U = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void G(l l10) {
        this.v = l10;
        synchronized (this) {
            long l11 = this.U;
            long l12 = 131072L;
            this.U = l11 |= l12;
        }
        this.notifyPropertyChanged(130);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void H(m0 m02) {
        this.w = m02;
        synchronized (this) {
            long l10 = this.U;
            long l11 = 32768L;
            this.U = l10 |= l11;
        }
        this.notifyPropertyChanged(131);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        boolean bl2 = true;
        boolean bl3 = false;
        switch (n10) {
            default: {
                break;
            }
            case 13: {
                CameraFragment$j cameraFragment$j = this.z;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.a0();
                break;
            }
            case 12: {
                CameraFragment$j cameraFragment$j = this.z;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.d();
                break;
            }
            case 11: {
                CameraFragment$j cameraFragment$j = this.z;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.m();
                break;
            }
            case 10: {
                CameraFragment$j cameraFragment$j = this.z;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.d();
                break;
            }
            case 9: {
                CameraFragment$j cameraFragment$j = this.z;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.d();
                break;
            }
            case 8: {
                CameraFragment$j cameraFragment$j = this.z;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.q0();
                break;
            }
            case 7: {
                CameraFragment$j cameraFragment$j = this.z;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.q0();
                break;
            }
            case 6: {
                CameraFragment$j cameraFragment$j = this.z;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.p0(false);
                break;
            }
            case 5: {
                CameraFragment$j cameraFragment$j = this.z;
                if (cameraFragment$j != null) {
                    bl3 = bl2;
                }
                if (!bl3) break;
                cameraFragment$j.p0(bl2);
                break;
            }
            case 4: {
                CameraFragment$j cameraFragment$j = this.z;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.m0();
                break;
            }
            case 3: {
                CameraFragment$j cameraFragment$j = this.z;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.b0();
                break;
            }
            case 2: {
                CameraFragment$j cameraFragment$j = this.z;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.W();
                break;
            }
            case 1: {
                CameraFragment$j cameraFragment$j = this.z;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.Z();
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
        block395: {
            block379: {
                block391: {
                    block394: {
                        block393: {
                            block392: {
                                block376: {
                                    block387: {
                                        block390: {
                                            block389: {
                                                block388: {
                                                    block375: {
                                                        block385: {
                                                            block374: {
                                                                block386: {
                                                                    var1_1 = this;
                                                                    synchronized (this) {
                                                                        var2_2 = this.U;
                                                                        this.U = var4_3 = 0L;
                                                                        var6_4 = this.V;
                                                                        this.V = var4_3;
                                                                    }
                                                                    var8_5 = this.x;
                                                                    var9_6 = this.w;
                                                                    var10_7 = this.y;
                                                                    var11_8 = this.v;
                                                                    var12_9 /* !! */  = this.z;
                                                                    var13_10 = 974379L & var2_2;
                                                                    var15_11 /* !! */  = var13_10 == var4_3 ? 0 : (var13_10 < var4_3 ? -1 : 1);
                                                                    var16_12 = 0x400000L;
                                                                    var18_13 = 0x2000000L;
                                                                    var20_14 = 1058642330;
                                                                    var21_15 = 0.6f;
                                                                    var22_16 = 1065353216;
                                                                    var23_17 = 1.0f;
                                                                    var24_18 = 0x200000L;
                                                                    var26_19 = 0x1000000000000000L;
                                                                    var28_20 = 0x40000000L;
                                                                    var30_21 = 65536L;
                                                                    var32_22 = 938018L;
                                                                    var34_23 = 0x4000000L;
                                                                    var36_24 = 0x100000L;
                                                                    if (var15_11 /* !! */  == false) break block385;
                                                                    var38_25 = var2_2 & 573960L;
                                                                    cfr_temp_0 = var38_25 - var4_3;
                                                                    var15_11 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                                                    if (var15_11 /* !! */  == false) ** GOTO lbl-1000
                                                                    if (var8_5 != null) {
                                                                        var40_26 /* !! */  = var8_5.H();
                                                                    } else {
                                                                        var15_11 /* !! */  = 0;
                                                                        var41_27 = 0.0f;
                                                                        var40_26 /* !! */  = null;
                                                                    }
                                                                    var42_28 = 3;
                                                                    var43_29 = 4.2E-45f;
                                                                    var1_1.updateLiveDataRegistration(var42_28, var40_26 /* !! */ );
                                                                    if (var40_26 /* !! */  != null) {
                                                                        var40_26 /* !! */  = (CameraSet$Mode)var40_26 /* !! */ .getValue();
                                                                    } else lbl-1000:
                                                                    // 2 sources

                                                                    {
                                                                        var15_11 /* !! */  = 0;
                                                                        var41_27 = 0.0f;
                                                                        var40_26 /* !! */  = null;
                                                                    }
                                                                    var44_30 = var2_2 & 939043L;
                                                                    var42_28 = (int)(var44_30 == var4_3 ? 0 : (var44_30 < var4_3 ? -1 : 1));
                                                                    if (var42_28 == 0) break block386;
                                                                    if (var8_5 != null) {
                                                                        var46_31 = var8_5.K();
                                                                    } else {
                                                                        var42_28 = 0;
                                                                        var43_29 = 0.0f;
                                                                        var46_31 = null;
                                                                    }
                                                                    var47_32 = 5;
                                                                    var48_33 = 7.0E-45f;
                                                                    var1_1.updateLiveDataRegistration(var47_32, (LiveData)var46_31);
                                                                    if (var46_31 != null) {
                                                                        var49_34 = (Boolean)var46_31.getValue();
                                                                    } else {
                                                                        var47_32 = 0;
                                                                        var48_33 = 0.0f;
                                                                        var49_34 = null;
                                                                    }
                                                                    var50_35 = ViewDataBinding.safeUnbox((Boolean)var49_34);
                                                                    var51_36 = var2_2 & var26_19;
                                                                    var53_37 = var51_36 == var4_3 ? 0 : (var51_36 < var4_3 ? -1 : 1);
                                                                    if (var53_37 != 0) {
                                                                        var2_2 = var50_35 != 0 ? (var2_2 |= var24_18) : (var2_2 |= var36_24);
                                                                    }
                                                                    if ((var53_37 = (int)((cfr_temp_1 = (var51_36 = var2_2 & var34_23) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) != 0) {
                                                                        if (var50_35 != 0) {
                                                                            var51_36 = 0x800000L;
                                                                            var2_2 |= var51_36;
                                                                        } else {
                                                                            var2_2 |= var16_12;
                                                                        }
                                                                    }
                                                                    if ((var53_37 = (int)((cfr_temp_2 = (var51_36 = var2_2 & var32_22) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) != 0) {
                                                                        var51_36 = var50_35 != 0 ? 0x200000000000L : 0x100000000000L;
                                                                        var2_2 |= var51_36;
                                                                    }
                                                                    if ((var53_37 = (int)((cfr_temp_3 = (var51_36 = var2_2 & 671778L) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) != 0) {
                                                                        var51_36 = var50_35 != 0 ? 0x20000000000000L : 0x10000000000000L;
                                                                        var2_2 |= var51_36;
                                                                    }
                                                                    if ((var53_37 = (int)((cfr_temp_4 = (var51_36 = var2_2 & 540704L) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) != 0) {
                                                                        var51_36 = var50_35 != 0 ? -9223372036854775808L : 0x4000000000000000L;
                                                                        var2_2 |= var51_36;
                                                                    }
                                                                    if ((var53_37 = (int)((cfr_temp_5 = (var51_36 = var6_4 & var30_21) - var4_3) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) != 0) {
                                                                        var6_4 = var50_35 != 0 ? (var6_4 |= var24_18) : (var6_4 |= var36_24);
                                                                    }
                                                                    if ((var53_37 = (int)((cfr_temp_6 = (var51_36 = var6_4 & (var54_38 = (long)4)) - var4_3) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1))) != 0) {
                                                                        if (var50_35 != 0) {
                                                                            var51_36 = 0x80000000L;
                                                                            var6_4 |= var51_36;
                                                                        } else {
                                                                            var6_4 |= var28_20;
                                                                        }
                                                                    }
                                                                    if ((var53_37 = (int)((cfr_temp_7 = (var51_36 = var2_2 & 676897L) - var4_3) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1))) != 0) {
                                                                        var56_39 = var50_35 ^ 1;
                                                                        if (var53_37 != 0) {
                                                                            var57_40 = var56_39 != 0 ? 0x80000000000L : 0x40000000000L;
                                                                            var2_2 |= var57_40;
                                                                        }
                                                                    } else {
                                                                        var56_39 = 0;
                                                                        var59_41 = null;
                                                                    }
                                                                    if ((var53_37 = (int)((cfr_temp_8 = (var57_40 = var2_2 & 540704L) - var4_3) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1))) != 0) {
                                                                        if (var50_35 != 0) {
                                                                            var53_37 = var20_14;
                                                                            var60_42 = var21_15;
                                                                            break block374;
                                                                        } else {
                                                                            var53_37 = var22_16;
                                                                            var60_42 = var23_17;
                                                                        }
                                                                        break block374;
                                                                    } else {
                                                                        var53_37 = 0;
                                                                        var61_43 = null;
                                                                        var60_42 = 0.0f;
                                                                    }
                                                                    break block374;
                                                                }
                                                                var53_37 = 0;
                                                                var61_43 = null;
                                                                var60_42 = 0.0f;
                                                                var47_32 = 0;
                                                                var48_33 = 0.0f;
                                                                var49_34 = null;
                                                                var42_28 = 0;
                                                                var43_29 = 0.0f;
                                                                var46_31 = null;
                                                                var50_35 = 0;
                                                                var62_44 = 0.0f;
                                                                var63_45 = null;
                                                                var56_39 = 0;
                                                                var59_41 = null;
                                                            }
                                                            var57_40 = var2_2 & 542720L;
                                                            var64_46 = var57_40 == var4_3 ? 0 : (var57_40 < var4_3 ? -1 : 1);
                                                            if (var64_46 != false) {
                                                                if (var8_5 != null) {
                                                                    var65_47 = var8_5.w0();
                                                                    var66_48 = var65_47;
                                                                    var67_49 = 11;
                                                                    var68_50 = 1.5E-44f;
                                                                } else {
                                                                    var67_49 = 11;
                                                                    var68_50 = 1.5E-44f;
                                                                    var69_51 = 0;
                                                                    var70_52 = 0.0f;
                                                                    var66_48 = null;
                                                                }
                                                                var1_1.updateLiveDataRegistration(var67_49, (LiveData)var66_48);
                                                                if (var66_48 != null) {
                                                                    var71_53 = (Boolean)var66_48.getValue();
                                                                } else {
                                                                    var67_49 = 0;
                                                                    var68_50 = 0.0f;
                                                                    var71_53 = null;
                                                                }
                                                                var72_54 = ViewDataBinding.safeUnbox(var71_53);
                                                                if (var64_46 != false) {
                                                                    if (var72_54 != 0) {
                                                                        var2_2 |= var18_13;
                                                                    } else {
                                                                        var73_55 = 0x1000000L;
                                                                        var2_2 |= var73_55;
                                                                    }
                                                                }
                                                                if (var72_54 != 0) {
                                                                    var72_54 = 0;
                                                                    var75_56 = 0.0f;
                                                                } else {
                                                                    var72_54 = 4;
                                                                    var75_56 = 5.6E-45f;
                                                                }
                                                                var76_57 = var71_53;
                                                                var67_49 = var53_37;
                                                                var68_50 = var60_42;
                                                                break block375;
                                                            } else {
                                                                var67_49 = var53_37;
                                                                var68_50 = var60_42;
                                                                var72_54 = 0;
                                                                var75_56 = 0.0f;
                                                                var69_51 = 0;
                                                                var70_52 = 0.0f;
                                                                var66_48 = null;
                                                                var76_57 = null;
                                                            }
                                                            break block375;
                                                        }
                                                        var67_49 = 0;
                                                        var71_53 = null;
                                                        var68_50 = 0.0f;
                                                        var72_54 = 0;
                                                        var75_56 = 0.0f;
                                                        var15_11 /* !! */  = 0;
                                                        var41_27 = 0.0f;
                                                        var40_26 /* !! */  = null;
                                                        var47_32 = 0;
                                                        var48_33 = 0.0f;
                                                        var49_34 = null;
                                                        var42_28 = 0;
                                                        var43_29 = 0.0f;
                                                        var46_31 = null;
                                                        var69_51 = 0;
                                                        var70_52 = 0.0f;
                                                        var66_48 = null;
                                                        var76_57 = null;
                                                        var50_35 = 0;
                                                        var62_44 = 0.0f;
                                                        var63_45 = null;
                                                        var56_39 = 0;
                                                        var59_41 = null;
                                                    }
                                                    var73_55 = var2_2 & 573980L;
                                                    var77_58 = 0L;
                                                    var53_37 = var73_55 == var77_58 ? 0 : (var73_55 < var77_58 ? -1 : 1);
                                                    var79_59 = var49_34;
                                                    if (var53_37 == 0) break block387;
                                                    var73_55 = var2_2 & 557060L;
                                                    cfr_temp_9 = var73_55 - var77_58;
                                                    var53_37 = (int)(cfr_temp_9 == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1));
                                                    if (var53_37 != 0) {
                                                        if (var9_6 != null) {
                                                            var61_43 = var9_6.t();
                                                            var80_60 = var46_31;
                                                            var49_34 = var61_43;
                                                        } else {
                                                            var80_60 = var46_31;
                                                            var47_32 = 0;
                                                            var48_33 = 0.0f;
                                                            var49_34 = null;
                                                        }
                                                        var42_28 = 2;
                                                        var43_29 = 2.8E-45f;
                                                        var1_1.updateLiveDataRegistration(var42_28, (LiveData)var49_34);
                                                        if (var49_34 != null) {
                                                            var49_34 = (Integer)var49_34.getValue();
                                                        } else {
                                                            var47_32 = 0;
                                                            var48_33 = 0.0f;
                                                            var49_34 = null;
                                                        }
                                                        var47_32 = ViewDataBinding.safeUnbox((Integer)var49_34);
                                                    } else {
                                                        var80_60 = var46_31;
                                                        var47_32 = 0;
                                                        var48_33 = 0.0f;
                                                        var49_34 = null;
                                                    }
                                                    var81_61 = var2_2 & 557072L;
                                                    var77_58 = 0L;
                                                    var42_28 = (int)(var81_61 == var77_58 ? 0 : (var81_61 < var77_58 ? -1 : 1));
                                                    if (var42_28 == 0) break block388;
                                                    if (var9_6 != null) {
                                                        var83_62 = var9_6.A();
                                                        var84_63 = var66_48;
                                                        var85_64 = var83_62;
                                                        var86_65 = var47_32;
                                                        var49_34 = var83_62;
                                                    } else {
                                                        var86_65 = var47_32;
                                                        var84_63 = var66_48;
                                                        var47_32 = 0;
                                                        var48_33 = 0.0f;
                                                        var49_34 = null;
                                                    }
                                                    var69_51 = 4;
                                                    var70_52 = 5.6E-45f;
                                                    var1_1.updateLiveDataRegistration(var69_51, (LiveData)var49_34);
                                                    if (var49_34 != null) {
                                                        var49_34 = (Boolean)var49_34.getValue();
                                                    } else {
                                                        var47_32 = 0;
                                                        var48_33 = 0.0f;
                                                        var49_34 = null;
                                                    }
                                                    var47_32 = (int)ViewDataBinding.safeUnbox((Boolean)var49_34);
                                                    if (var42_28 != 0) {
                                                        var87_66 = var47_32 != 0 ? 524288L : 262144L;
                                                        var6_4 |= var87_66;
                                                    }
                                                    if (var47_32 == 0) break block389;
                                                    var47_32 = 8;
                                                    var48_33 = 1.1E-44f;
                                                    break block390;
                                                }
                                                var86_65 = var47_32;
                                                var84_63 = var66_48;
                                            }
                                            var47_32 = 0;
                                            var48_33 = 0.0f;
                                            var49_34 = null;
                                        }
                                        var87_66 = 573960L & var2_2;
                                        var77_58 = 0L;
                                        var42_28 = (int)(var87_66 == var77_58 ? 0 : (var87_66 < var77_58 ? -1 : 1));
                                        if (var42_28 != 0) {
                                            if (var9_6 != null) {
                                                var66_48 = var9_6.u();
                                                var89_67 = var47_32;
                                                var90_69 = var48_33;
                                            } else {
                                                var89_67 = var47_32;
                                                var90_69 = var48_33;
                                                var69_51 = 0;
                                                var70_52 = 0.0f;
                                                var66_48 = null;
                                            }
                                            var47_32 = 9;
                                            var48_33 = 1.3E-44f;
                                            var1_1.updateLiveDataRegistration(var47_32, (LiveData)var66_48);
                                            if (var66_48 != null) {
                                                var49_34 = (CameraSet$StoryState)var66_48.getValue();
                                            } else {
                                                var47_32 = 0;
                                                var48_33 = 0.0f;
                                                var49_34 = null;
                                            }
                                            if (var9_6 != null) {
                                                var15_11 /* !! */  = (long)var9_6.K((CameraSet$Mode)var40_26 /* !! */ , (CameraSet$StoryState)var49_34);
                                            } else {
                                                var15_11 /* !! */  = 0;
                                                var41_27 = 0.0f;
                                                var40_26 /* !! */  = null;
                                            }
                                            if (var42_28 != 0) {
                                                var91_71 = var15_11 /* !! */  != false ? 0x800000L : 0x400000L;
                                                var6_4 |= var91_71;
                                            }
                                            if (var15_11 /* !! */  != false) {
                                                var15_11 /* !! */  = 0;
                                                var41_27 = 0.0f;
                                                var40_26 /* !! */  = null;
                                            } else {
                                                var15_11 /* !! */  = 8;
                                                var41_27 = 1.1E-44f;
                                            }
                                            var42_28 = var86_65;
                                            var47_32 = var89_67;
                                            var48_33 = var90_69;
                                            break block376;
                                        } else {
                                            var89_68 = var47_32;
                                            var90_70 = var48_33;
                                            var42_28 = var86_65;
                                            var15_11 /* !! */  = 0;
                                            var41_27 = 0.0f;
                                            var40_26 /* !! */  = null;
                                        }
                                        break block376;
                                    }
                                    var80_60 = var46_31;
                                    var84_63 = var66_48;
                                    var15_11 /* !! */  = 0;
                                    var41_27 = 0.0f;
                                    var40_26 /* !! */  = null;
                                    var47_32 = 0;
                                    var48_33 = 0.0f;
                                    var49_34 = null;
                                    var42_28 = 0;
                                    var43_29 = 0.0f;
                                    var46_31 = null;
                                }
                                var93_72 = var2_2 & 781794L;
                                var77_58 = 0L;
                                var69_51 = var93_72 == var77_58 ? 0 : (var93_72 < var77_58 ? -1 : 1);
                                var93_72 = 0x1000000000L;
                                var95_73 = 655362L;
                                var97_74 = 1024L;
                                var86_65 = var42_28;
                                if (var69_51 == 0) break block391;
                                var99_75 = var2_2 & var95_73;
                                cfr_temp_10 = var99_75 - var77_58;
                                var69_51 = (int)(cfr_temp_10 == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1));
                                if (var69_51 != 0) {
                                    if (var11_8 != null) {
                                        var46_31 = var11_8.e;
                                        var101_76 = var47_32;
                                        var102_77 = var48_33;
                                        var47_32 = 1;
                                        var48_33 = 1.4E-45f;
                                    } else {
                                        var101_76 = var47_32;
                                        var102_77 = var48_33;
                                        var47_32 = 1;
                                        var48_33 = 1.4E-45f;
                                        var42_28 = 0;
                                        var43_29 = 0.0f;
                                        var46_31 = null;
                                    }
                                    var1_1.updateLiveDataRegistration(var47_32, (LiveData)var46_31);
                                    if (var46_31 != null) {
                                        var49_34 = (Boolean)var46_31.getValue();
                                    } else {
                                        var47_32 = 0;
                                        var48_33 = 0.0f;
                                        var49_34 = null;
                                    }
                                    var103_78 = ViewDataBinding.safeUnbox((Boolean)var49_34);
                                    if (var69_51 != 0) {
                                        var104_79 = var103_78 != 0 ? 512L : 256L;
                                        var6_4 |= var104_79;
                                    }
                                    if (var103_78 != 0) {
                                        var69_51 = var20_14;
                                        var70_52 = var21_15;
                                    } else {
                                        var69_51 = var22_16;
                                        var70_52 = var23_17;
                                    }
                                } else {
                                    var101_76 = var47_32;
                                    var102_77 = var48_33;
                                    var69_51 = 0;
                                    var66_48 = null;
                                    var70_52 = 0.0f;
                                    var47_32 = 0;
                                    var48_33 = 0.0f;
                                    var49_34 = null;
                                    var42_28 = 0;
                                    var43_29 = 0.0f;
                                    var46_31 = null;
                                    var103_78 = 0;
                                    var106_80 = null;
                                }
                                var104_79 = var2_2 & 655426L;
                                var77_58 = 0L;
                                var107_81 = var104_79 == var77_58 ? 0 : (var104_79 < var77_58 ? -1 : 1);
                                var108_82 = var49_34;
                                if (var107_81 != 0) {
                                    if (var11_8 != null) {
                                        var49_34 = var11_8.b;
                                        var109_83 = var46_31;
                                    } else {
                                        var109_83 = var46_31;
                                        var47_32 = 0;
                                        var48_33 = 0.0f;
                                        var49_34 = null;
                                    }
                                    var42_28 = 6;
                                    var43_29 = 8.4E-45f;
                                    var1_1.updateLiveDataRegistration(var42_28, (LiveData)var49_34);
                                    if (var49_34 != null) {
                                        var49_34 = (Integer)var49_34.getValue();
                                    } else {
                                        var47_32 = 0;
                                        var48_33 = 0.0f;
                                        var49_34 = null;
                                    }
                                    if (var49_34 != null) {
                                        var42_28 = 1;
                                        var43_29 = 1.4E-45f;
                                    } else {
                                        var42_28 = 0;
                                        var43_29 = 0.0f;
                                        var46_31 = null;
                                    }
                                    if (var107_81 != 0) {
                                        var110_84 = var42_28 != 0 ? 0x800000000L : 0x400000000L;
                                        var2_2 |= var110_84;
                                    }
                                } else {
                                    var109_83 = var46_31;
                                    var47_32 = 0;
                                    var48_33 = 0.0f;
                                    var49_34 = null;
                                    var42_28 = 0;
                                    var43_29 = 0.0f;
                                    var46_31 = null;
                                }
                                if ((var107_81 = (cfr_temp_11 = (var110_84 = var2_2 & 655490L) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1)) == 0) break block392;
                                var112_85 = var49_34;
                                if (var11_8 != null) {
                                    var49_34 = var11_8.d;
                                    var113_86 = var42_28;
                                    var114_87 = var43_29;
                                } else {
                                    var113_86 = var42_28;
                                    var114_87 = var43_29;
                                    var47_32 = 0;
                                    var48_33 = 0.0f;
                                    var49_34 = null;
                                }
                                var42_28 = 7;
                                var43_29 = 9.8E-45f;
                                var1_1.updateLiveDataRegistration(var42_28, (LiveData)var49_34);
                                if (var49_34 != null) {
                                    var49_34 = (Boolean)var49_34.getValue();
                                } else {
                                    var47_32 = 0;
                                    var48_33 = 0.0f;
                                    var49_34 = null;
                                }
                                var47_32 = (int)ViewDataBinding.safeUnbox((Boolean)var49_34);
                                var115_88 = var2_2 & 655488L;
                                var77_58 = 0L;
                                var42_28 = (int)(var115_88 == var77_58 ? 0 : (var115_88 < var77_58 ? -1 : 1));
                                if (var42_28 != 0) {
                                    var115_88 = var47_32 != 0 ? 0x2000000000000L : 0x1000000000000L;
                                    var2_2 |= var115_88;
                                }
                                if ((var42_28 = (int)((cfr_temp_12 = (var115_88 = var2_2 & 655488L) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_12 < 0L ? -1 : 1))) != 0) {
                                    if (var47_32 != 0) {
                                        var42_28 = var20_14;
                                        var43_29 = var21_15;
                                    } else {
                                        var42_28 = var22_16;
                                        var43_29 = var23_17;
                                    }
                                } else {
                                    var42_28 = 0;
                                    var46_31 = null;
                                    var43_29 = 0.0f;
                                }
                                var47_32 ^= 1;
                                var115_88 = var2_2 & 655490L;
                                var77_58 = 0L;
                                var117_89 = (int)(var115_88 == var77_58 ? 0 : (var115_88 < var77_58 ? -1 : 1));
                                if (var117_89 != 0) {
                                    var115_88 = var47_32 != 0 ? 0x800000000000000L : 0x400000000000000L;
                                    var2_2 |= var115_88;
                                }
                                if ((var117_89 = (int)((cfr_temp_13 = (var115_88 = var2_2 & 655488L) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_13 < 0L ? -1 : 1))) == 0) break block393;
                                var118_90 = (boolean)var47_32;
                                var117_89 = ViewDataBinding.safeUnbox(var118_90);
                                break block394;
                            }
                            var112_85 = var49_34;
                            var113_86 = var42_28;
                            var114_87 = var43_29;
                            var77_58 = 0L;
                            var42_28 = 0;
                            var46_31 = null;
                            var43_29 = 0.0f;
                            var47_32 = 0;
                            var48_33 = 0.0f;
                            var49_34 = null;
                        }
                        var117_89 = 0;
                        var118_91 = null;
                    }
                    var119_93 = var2_2 & 781600L;
                    var121_94 = var119_93 == var77_58 ? 0 : (var119_93 < var77_58 ? -1 : 1);
                    var122_95 = var47_32;
                    if (var121_94 != 0) {
                        if (var11_8 != null) {
                            var49_34 = var11_8.a;
                            var123_96 = var42_28;
                            var124_97 = var43_29;
                        } else {
                            var123_96 = var42_28;
                            var124_97 = var43_29;
                            var47_32 = 0;
                            var48_33 = 0.0f;
                            var49_34 = null;
                        }
                        var42_28 = 10;
                        var43_29 = 1.4E-44f;
                        var1_1.updateLiveDataRegistration(var42_28, (LiveData)var49_34);
                        if (var49_34 != null) {
                            var46_31 = (Boolean)var49_34.getValue();
                        } else {
                            var42_28 = 0;
                            var43_29 = 0.0f;
                            var46_31 = null;
                        }
                        var125_98 = ViewDataBinding.safeUnbox((Boolean)var46_31);
                        if (var121_94 != 0) {
                            if (var125_98 != 0) {
                                var2_2 |= 0x2000000000L;
                                var126_99 = 2048L;
                                var6_4 |= var126_99;
                            } else {
                                var2_2 |= var93_72;
                                var6_4 |= var97_74;
                            }
                        }
                        if ((var121_94 = (cfr_temp_14 = (var126_99 = var2_2 & 740608L) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_14 < 0L ? -1 : 1)) != 0) {
                            var126_99 = var125_98 != 0 ? 0x8000000000000L : 0x4000000000000L;
                            var2_2 |= var126_99;
                        }
                        if ((var121_94 = (cfr_temp_15 = (var126_99 = var2_2 & 715808L) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_15 < 0L ? -1 : 1)) != 0) {
                            if (var125_98 != 0) {
                                var2_2 |= 0x2000000000000000L;
                                var126_99 = 131072L;
                                var6_4 |= var126_99;
                            } else {
                                var2_2 |= var26_19;
                                var6_4 |= var30_21;
                            }
                        }
                        if ((var121_94 = (cfr_temp_16 = (var126_99 = var2_2 & 656384L) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_16 < 0L ? -1 : 1)) != 0) {
                            var126_99 = var125_98 != 0 ? 0x20000000L : 0x10000000L;
                            var6_4 |= var126_99;
                        }
                        if (var121_94 != 0) {
                            if (var125_98 != 0) {
                                var121_94 = 0;
                                var128_100 = 0.0f;
                                var129_103 = null;
                            } else {
                                var121_94 = 8;
                                var128_100 = 1.1E-44f;
                            }
                            var85_64 = var108_82;
                            var108_82 = var49_34;
                            var47_32 = var123_96;
                            var48_33 = var124_97;
                            var123_96 = var69_51;
                            var124_97 = var70_52;
                            var69_51 = var117_89;
                            var117_89 = var103_78;
                            var106_80 = var85_64;
                            var129_103 = var46_31;
                            var42_28 = var121_94;
                            var43_29 = var128_100;
                            break block379;
                        } else {
                            var129_103 = var46_31;
                            var42_28 = 0;
                            var43_29 = 0.0f;
                            var46_31 = null;
                            var85_64 = var108_82;
                            var108_82 = var49_34;
                            var47_32 = var123_96;
                            var48_33 = var124_97;
                            var123_96 = var69_51;
                            var124_97 = var70_52;
                            var69_51 = var117_89;
                            var117_89 = var103_78;
                            var106_80 = var85_64;
                        }
                        break block379;
                    } else {
                        var123_96 = var42_28;
                        var124_97 = var43_29;
                        var47_32 = var42_28;
                        var48_33 = var43_29;
                        var42_28 = 0;
                        var43_29 = 0.0f;
                        var46_31 = null;
                        var121_94 = 0;
                        var128_101 = 0.0f;
                        var129_103 = null;
                        var125_98 = 0;
                        var123_96 = var69_51;
                        var124_97 = var70_52;
                        var69_51 = var117_89;
                        var117_89 = var103_78;
                        var106_80 = var108_82;
                        var130_104 = 0;
                        var131_105 = 0.0f;
                        var108_82 = null;
                    }
                    break block379;
                }
                var101_76 = var47_32;
                var102_77 = var48_33;
                var47_32 = 0;
                var49_34 = null;
                var48_33 = 0.0f;
                var123_96 = 0;
                var124_97 = 0.0f;
                var42_28 = 0;
                var43_29 = 0.0f;
                var46_31 = null;
                var69_51 = 0;
                var70_52 = 0.0f;
                var66_48 = null;
                var103_78 = 0;
                var106_80 = null;
                var107_81 = 0;
                var112_85 = null;
                var130_104 = 0;
                var131_105 = 0.0f;
                var108_82 = null;
                var109_83 = null;
                var113_86 = 0;
                var114_87 = 0.0f;
                var117_89 = 0;
                var118_92 = null;
                var121_94 = 0;
                var128_102 = 0.0f;
                var129_103 = null;
                var122_95 = 0;
                var132_106 = null;
                var125_98 = 0;
            }
            var126_99 = var2_2 & 0x80000000000L;
            var77_58 = 0L;
            var133_107 = var126_99 == var77_58 ? 0 : (var126_99 < var77_58 ? -1 : 1);
            if (var133_107 != false) {
                if (var8_5 != null) {
                    var134_108 = var8_5.T();
                    var135_109 = var69_51;
                    var85_64 = var134_108;
                    var133_107 = var47_32;
                    var136_110 = var48_33;
                    var49_34 = var134_108;
                } else {
                    var133_107 = var47_32;
                    var136_110 = var48_33;
                    var135_109 = var69_51;
                    var47_32 = 0;
                    var48_33 = 0.0f;
                    var49_34 = null;
                }
                var69_51 = 12;
                var70_52 = 1.7E-44f;
                var1_1.updateLiveDataRegistration(var69_51, (LiveData)var49_34);
                if (var49_34 != null) {
                    var66_48 = (Boolean)var49_34.getValue();
                } else {
                    var69_51 = 0;
                    var70_52 = 0.0f;
                    var66_48 = null;
                }
                var137_111 = ViewDataBinding.safeUnbox((Boolean)var66_48);
                var138_112 = var137_111 ^ 1;
            } else {
                var133_107 = var47_32;
                var136_110 = var48_33;
                var135_109 = var69_51;
                var47_32 = 0;
                var48_33 = 0.0f;
                var49_34 = null;
                var69_51 = 0;
                var70_52 = 0.0f;
                var66_48 = null;
                var137_111 = 0;
                var138_112 = 0;
                var139_113 = 0.0f;
                var140_114 = null;
            }
            var141_115 = var2_2 & 0x800000000L;
            var77_58 = 0L;
            var143_116 = var141_115 == var77_58 ? 0 : (var141_115 < var77_58 ? -1 : 1);
            if (var143_116 != false && (var107_81 = ViewDataBinding.safeUnbox((Integer)var112_85)) != 0) {
                var107_81 = 1;
            } else {
                var107_81 = 0;
                var112_85 = null;
            }
            var141_115 = var2_2 & 0x800000000000000L;
            var143_116 = var141_115 == var77_58 ? 0 : (var141_115 < var77_58 ? -1 : 1);
            if (var143_116 != false) {
                var144_117 = var49_34;
                if (var11_8 != null) {
                    var49_34 = var11_8.e;
                    var145_118 = var66_48;
                } else {
                    var145_118 = var66_48;
                    var49_34 = var109_83;
                }
                var69_51 = 1;
                var70_52 = 1.4E-45f;
                var1_1.updateLiveDataRegistration(var69_51, (LiveData)var49_34);
                var66_48 = var49_34 != null ? (Boolean)var49_34.getValue() : var106_80;
                var117_89 = (int)ViewDataBinding.safeUnbox((Boolean)var66_48);
                var146_119 = var2_2 & var95_73;
                var77_58 = 0L;
                var103_78 = (int)(var146_119 == var77_58 ? 0 : (var146_119 < var77_58 ? -1 : 1));
                if (var103_78 != 0) {
                    var146_119 = var117_89 != 0 ? 512L : 256L;
                    var6_4 |= var146_119;
                }
                var109_83 = var49_34;
                var49_34 = var66_48;
            } else {
                var144_117 = var49_34;
                var145_118 = var66_48;
                var49_34 = var106_80;
            }
            var146_119 = var2_2 & 655426L;
            var77_58 = 0L;
            var69_51 = (int)(var146_119 == var77_58 ? 0 : (var146_119 < var77_58 ? -1 : 1));
            if (var69_51 != 0) {
                if (var113_86 == 0) {
                    var107_81 = 0;
                    var112_85 = null;
                }
                if (var69_51 != 0) {
                    var146_119 = var107_81 != 0 ? 0x20000000L : 0x10000000L;
                    var2_2 |= var146_119;
                }
            } else {
                var107_81 = 0;
                var112_85 = null;
            }
            if ((var69_51 = (int)((cfr_temp_17 = (var146_119 = var2_2 & 676897L) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_17 < 0L ? -1 : 1))) != 0) {
                if (var56_39 == 0) {
                    var138_112 = 0;
                    var139_113 = 0.0f;
                    var140_114 = null;
                }
                if (var69_51 != 0) {
                    var146_119 = var138_112 != 0 ? 8192L : 4096L;
                    var6_4 |= var146_119;
                }
            } else {
                var138_112 = 0;
                var139_113 = 0.0f;
                var140_114 = null;
            }
            if ((var69_51 = (cfr_temp_18 = (var146_119 = var2_2 & 655490L) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_18 < 0L ? -1 : 1)) != 0) {
                if (var122_95 != 0) {
                    var56_39 = var117_89;
                } else {
                    var56_39 = 0;
                    var59_41 = null;
                }
                if (var69_51 != 0) {
                    var146_119 = var56_39 != 0 ? 32768L : 16384L;
                    var6_4 |= var146_119;
                }
                var66_48 = var56_39 != 0 ? "@string/story_preview_all_track_cancel" : "@string/story_preview_all_track";
            } else {
                var69_51 = 0;
                var70_52 = 0.0f;
                var66_48 = null;
            }
            var146_119 = var2_2 & 0x20000000L;
            var77_58 = 0L;
            var56_39 = var146_119 == var77_58 ? 0 : (var146_119 < var77_58 ? -1 : 1);
            if (var56_39 == 0 && (var103_78 = (cfr_temp_19 = (var146_119 = var6_4 & 8192L) - var77_58) == 0L ? 0 : (cfr_temp_19 < 0L ? -1 : 1)) == 0) {
                var106_80 = var66_48;
                var56_39 = 0;
                var59_41 = null;
            } else {
                if (var56_39 != 0) {
                    var59_41 = var49_34;
                    if (var11_8 != null) {
                        var49_34 = var11_8.e;
                        var106_80 = var66_48;
                    } else {
                        var106_80 = var66_48;
                        var49_34 = var109_83;
                    }
                    var69_51 = 1;
                    var70_52 = 1.4E-45f;
                    var1_1.updateLiveDataRegistration(var69_51, (LiveData)var49_34);
                    var66_48 = var49_34 != null ? (Boolean)var49_34.getValue() : var59_41;
                    var117_89 = (int)ViewDataBinding.safeUnbox((Boolean)var66_48);
                    var148_120 = var2_2 & var95_73;
                    var77_58 = 0L;
                    var56_39 = (int)(var148_120 == var77_58 ? 0 : (var148_120 < var77_58 ? -1 : 1));
                    if (var56_39 != 0) {
                        var148_120 = var117_89 != 0 ? 512L : 256L;
                        var6_4 |= var148_120;
                    }
                    var56_39 = var117_89 ^ 1;
                    var109_83 = var49_34;
                    var49_34 = var66_48;
                } else {
                    var59_41 = var49_34;
                    var106_80 = var66_48;
                    var56_39 = 0;
                    var59_41 = null;
                }
                var146_119 = var6_4 & 8192L;
                var77_58 = 0L;
                var69_51 = (int)(var146_119 == var77_58 ? 0 : (var146_119 < var77_58 ? -1 : 1));
                if (var69_51 != 0) {
                    var66_48 = var11_8 != null ? var11_8.a : var108_82;
                    var108_82 = var49_34;
                    var47_32 = 10;
                    var48_33 = 1.4E-44f;
                    var1_1.updateLiveDataRegistration(var47_32, (LiveData)var66_48);
                    if (var66_48 != null) {
                        var66_48 = var49_34 = var66_48.getValue();
                        var66_48 = (Boolean)var49_34;
                    } else {
                        var66_48 = var129_103;
                    }
                    var125_98 = ViewDataBinding.safeUnbox((Boolean)var66_48);
                    var119_93 = var2_2 & 781600L;
                    var77_58 = 0L;
                    var47_32 = (int)(var119_93 == var77_58 ? 0 : (var119_93 < var77_58 ? -1 : 1));
                    if (var47_32 != 0) {
                        if (var125_98 != 0) {
                            var2_2 |= 0x2000000000L;
                            var119_93 = 2048L;
                            var6_4 |= var119_93;
                        } else {
                            var2_2 |= var93_72;
                            var6_4 |= var97_74;
                        }
                    }
                    if ((var47_32 = (int)((cfr_temp_20 = (var119_93 = var2_2 & 740608L) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_20 < 0L ? -1 : 1))) != 0) {
                        var119_93 = var125_98 != 0 ? 0x8000000000000L : 0x4000000000000L;
                        var2_2 |= var119_93;
                    }
                    if ((var47_32 = (int)((cfr_temp_21 = (var119_93 = var2_2 & 715808L) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_21 < 0L ? -1 : 1))) != 0) {
                        if (var125_98 != 0) {
                            var2_2 |= 0x2000000000000000L;
                            var119_93 = 131072L;
                            var6_4 |= var119_93;
                        } else {
                            var2_2 |= var26_19;
                            var6_4 |= var30_21;
                        }
                    }
                    if ((var47_32 = (int)((cfr_temp_22 = (var119_93 = var2_2 & 656384L) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_22 < 0L ? -1 : 1))) != 0) {
                        var119_93 = var125_98 != 0 ? 0x20000000L : 0x10000000L;
                        var6_4 |= var119_93;
                    }
                    var49_34 = var108_82;
                } else {
                    var108_82 = var49_34;
                }
            }
            var119_93 = var2_2 & 655426L;
            var77_58 = 0L;
            var69_51 = (int)(var119_93 == var77_58 ? 0 : (var119_93 < var77_58 ? -1 : 1));
            if (var69_51 != 0) {
                if (var107_81 == 0) {
                    var56_39 = 0;
                    var59_41 = null;
                }
                var69_51 = var56_39;
            } else {
                var69_51 = 0;
                var70_52 = 0.0f;
                var66_48 = null;
            }
            var104_79 = var2_2 & 676897L;
            var56_39 = (int)(var104_79 == var77_58 ? 0 : (var104_79 < var77_58 ? -1 : 1));
            if (var56_39 != 0) {
                if (var138_112 != 0) {
                    var107_81 = var125_98;
                } else {
                    var107_81 = 0;
                    var112_85 = null;
                }
                if (var56_39 != 0) {
                    if (var107_81 != 0) {
                        var6_4 |= var18_13;
                    } else {
                        var119_93 = 0x1000000L;
                        var6_4 |= var119_93;
                    }
                }
            } else {
                var107_81 = 0;
                var112_85 = null;
            }
            if ((var56_39 = (int)((cfr_temp_23 = (var119_93 = var2_2 & var26_19) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_23 < 0L ? -1 : 1))) == 0 && (var130_104 = (cfr_temp_24 = (var119_93 = var6_4 & var30_21) - var77_58) == 0L ? 0 : (cfr_temp_24 < 0L ? -1 : 1)) == 0) {
                var77_58 = 0L;
                var150_121 = var50_35;
                var63_45 = var49_34;
                var49_34 = var79_59;
                var64_46 = var50_35;
                var151_122 = var69_51;
                var66_48 = var80_60;
            } else {
                if (var8_5 != null) {
                    var63_45 = var8_5.K();
                    var151_122 = var69_51;
                    var85_64 = var63_45;
                    var63_45 = var49_34;
                    var49_34 = var85_64;
                } else {
                    var63_45 = var49_34;
                    var49_34 = var80_60;
                    var151_122 = var69_51;
                }
                var69_51 = 5;
                var70_52 = 7.0E-45f;
                var1_1.updateLiveDataRegistration(var69_51, (LiveData)var49_34);
                var66_48 = var49_34 != null ? (Boolean)var49_34.getValue() : var79_59;
                var64_46 = (long)ViewDataBinding.safeUnbox((Boolean)var66_48);
                if (var56_39 != 0) {
                    var2_2 = var64_46 != false ? (var2_2 |= var24_18) : (var2_2 |= var36_24);
                }
                if ((var56_39 = (int)((cfr_temp_25 = (var119_93 = var2_2 & var34_23) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_25 < 0L ? -1 : 1))) != 0) {
                    if (var64_46 != false) {
                        var119_93 = 0x800000L;
                        var2_2 |= var119_93;
                    } else {
                        var152_123 = 0x400000L;
                        var2_2 |= var152_123;
                    }
                }
                if ((var56_39 = (int)((cfr_temp_26 = (var119_93 = var2_2 & var32_22) - var77_58) == 0L ? 0 : (cfr_temp_26 < 0L ? -1 : 1))) != 0) {
                    var119_93 = var64_46 != false ? 0x200000000000L : 0x100000000000L;
                    var2_2 |= var119_93;
                }
                if ((var56_39 = (int)((cfr_temp_27 = (var119_93 = var2_2 & 671778L) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_27 < 0L ? -1 : 1))) != 0) {
                    var119_93 = var64_46 != false ? 0x20000000000000L : 0x10000000000000L;
                    var2_2 |= var119_93;
                }
                if ((var56_39 = (int)((cfr_temp_28 = (var119_93 = var2_2 & 540704L) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_28 < 0L ? -1 : 1))) != 0) {
                    var119_93 = var64_46 != false ? -9223372036854775808L : 0x4000000000000000L;
                    var2_2 |= var119_93;
                }
                if ((var56_39 = (int)((cfr_temp_29 = (var119_93 = var6_4 & var30_21) - var77_58) == 0L ? 0 : (cfr_temp_29 < 0L ? -1 : 1))) != 0) {
                    var6_4 = var64_46 != false ? (var6_4 |= var24_18) : (var6_4 |= var36_24);
                }
                if ((var56_39 = (int)((cfr_temp_30 = (var119_93 = var6_4 & (var54_38 = (long)4)) - var77_58) == 0L ? 0 : (cfr_temp_30 < 0L ? -1 : 1))) != 0) {
                    if (var64_46 != false) {
                        var119_93 = 0x80000000L;
                        var6_4 |= var119_93;
                    } else {
                        var6_4 |= var28_20;
                    }
                }
                var85_64 = var66_48;
                var66_48 = var49_34;
                var49_34 = var85_64;
            }
            var119_93 = var2_2 & 0x8001000000000L;
            var56_39 = (int)(var119_93 == var77_58 ? 0 : (var119_93 < var77_58 ? -1 : 1));
            if (var56_39 == 0 && (var130_104 = (cfr_temp_31 = (var119_93 = var6_4 & var97_74) - var77_58) == 0L ? 0 : (cfr_temp_31 < 0L ? -1 : 1)) == 0) {
                var61_43 = var49_34;
                var154_124 = 0;
                var10_7 = null;
                var47_32 = 8;
                var48_33 = 1.1E-44f;
            } else {
                if (var10_7 != null) {
                    var10_7 = var10_7.L;
                    var61_43 = var49_34;
                } else {
                    var61_43 = var49_34;
                    var154_124 = 0;
                    var10_7 = null;
                }
                var47_32 = 8;
                var48_33 = 1.1E-44f;
                var1_1.updateLiveDataRegistration(var47_32, (LiveData)var10_7);
                if (var10_7 != null) {
                    var10_7 = (Boolean)var10_7.getValue();
                } else {
                    var154_124 = 0;
                    var10_7 = null;
                }
                var154_124 = ViewDataBinding.safeUnbox((Boolean)var10_7);
                if (var56_39 != 0 || (var56_39 = (int)((cfr_temp_32 = (var119_93 = var6_4 & var97_74) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_32 < 0L ? -1 : 1))) != 0) {
                    if (var154_124 != 0) {
                        var119_93 = 0x2000000000L;
                        var6_4 |= var119_93;
                    } else {
                        var6_4 |= var93_72;
                    }
                }
            }
            var119_93 = var6_4 & var18_13;
            var77_58 = 0L;
            var56_39 = (int)(var119_93 == var77_58 ? 0 : (var119_93 < var77_58 ? -1 : 1));
            if (var56_39 != 0) {
                if (var11_8 != null) {
                    var49_34 = var11_8.f;
                    var155_125 = var66_48;
                } else {
                    var155_125 = var66_48;
                    var47_32 = 0;
                    var48_33 = 0.0f;
                    var49_34 = null;
                }
                var69_51 = 0;
                var70_52 = 0.0f;
                var66_48 = null;
                var1_1.updateLiveDataRegistration(0, (LiveData)var49_34);
                if (var49_34 != null) {
                    var49_34 = (Boolean)var49_34.getValue();
                } else {
                    var47_32 = 0;
                    var48_33 = 0.0f;
                    var49_34 = null;
                }
                var47_32 = (int)ViewDataBinding.safeUnbox((Boolean)var49_34);
            } else {
                var155_125 = var66_48;
                var69_51 = 0;
                var70_52 = 0.0f;
                var66_48 = null;
                var47_32 = 0;
                var49_34 = null;
                var48_33 = 0.0f;
            }
            var119_93 = var2_2 & 676897L;
            var77_58 = 0L;
            var130_104 = var119_93 == var77_58 ? 0 : (var119_93 < var77_58 ? -1 : 1);
            if (var130_104 == 0) ** GOTO lbl-1000
            if (var107_81 == 0) {
                var47_32 = 0;
                var49_34 = null;
                var48_33 = 0.0f;
            }
            if (var130_104 != 0) {
                var104_79 = var47_32 != 0 ? 0x800000000000L : 0x400000000000L;
                var2_2 |= var104_79;
            }
            if (var47_32 == 0) {
                var47_32 = 8;
                var48_33 = 1.1E-44f;
            } else lbl-1000:
            // 2 sources

            {
                var47_32 = 0;
                var49_34 = null;
                var48_33 = 0.0f;
            }
            var104_79 = var6_4 & var93_72;
            var77_58 = 0L;
            var107_81 = (int)(var104_79 == var77_58 ? 0 : (var104_79 < var77_58 ? -1 : 1));
            if (var107_81 != 0) {
                if (var8_5 != null) {
                    var84_63 = var8_5.w0();
                }
                var130_104 = var47_32;
                var131_105 = var48_33;
                var66_48 = var84_63;
                var47_32 = 11;
                var48_33 = 1.5E-44f;
                var1_1.updateLiveDataRegistration(var47_32, var84_63);
                if (var84_63 != null) {
                    var76_57 = var49_34 = (Boolean)var84_63.getValue();
                }
                var47_32 = (int)ViewDataBinding.safeUnbox((Boolean)var76_57);
                var119_93 = var2_2 & 542720L;
                var77_58 = 0L;
                cfr_temp_33 = var119_93 - var77_58;
                var156_126 /* !! */  = (long)(cfr_temp_33 == 0L ? 0 : (cfr_temp_33 < 0L ? -1 : 1));
                if (var156_126 /* !! */  != false) {
                    if (var47_32 != 0) {
                        var2_2 |= var18_13;
                    } else {
                        var119_93 = 0x1000000L;
                        var2_2 |= var119_93;
                    }
                }
                var156_126 /* !! */  = 1;
                var157_127 = 1.4E-45f;
                var47_32 ^= 1;
            } else {
                var130_104 = var47_32;
                var131_105 = var48_33;
                var66_48 = var84_63;
                var47_32 = 0;
                var48_33 = 0.0f;
                var49_34 = null;
            }
            var119_93 = var2_2 & 0x8001000000000L;
            var77_58 = 0L;
            var156_126 /* !! */  = var119_93 == var77_58 ? 0 : (var119_93 < var77_58 ? -1 : 1);
            if (var156_126 /* !! */  != false || (var156_126 /* !! */  = (cfr_temp_34 = (var119_93 = var6_4 & var97_74) - var77_58) == 0L ? 0 : (cfr_temp_34 < 0L ? -1 : 1)) != false) break block395;
            var154_124 = 0;
            var10_7 = null;
            ** GOTO lbl-1000
        }
        var154_124 = var154_124 != 0 ? 1 : var47_32;
        var119_93 = var6_4 & var97_74;
        var156_126 /* !! */  = var119_93 == var77_58 ? 0 : (var119_93 < var77_58 ? -1 : 1);
        if (var156_126 /* !! */  != false) {
            if (var154_124 != 0) {
                var119_93 = 0x8000000L;
                var2_2 |= var119_93;
            } else {
                var2_2 |= var34_23;
            }
        }
        if ((var156_126 /* !! */  = (cfr_temp_35 = (var119_93 = var2_2 & var93_72) - var77_58) == 0L ? 0 : (cfr_temp_35 < 0L ? -1 : 1)) != false) {
            if (var154_124 != 0) {
                var119_93 = 8;
                var6_4 |= var119_93;
            } else {
                var54_38 = 4;
                var6_4 |= var54_38;
            }
        }
        if ((var156_126 /* !! */  = (cfr_temp_36 = (var119_93 = var2_2 & 0x8000000000000L) - var77_58) == 0L ? 0 : (cfr_temp_36 < 0L ? -1 : 1)) != false) {
            var119_93 = var154_124 != 0 ? 128L : (long)64;
            var6_4 |= var119_93;
        }
        if (var156_126 /* !! */  != false && var154_124 != 0) {
            var156_126 /* !! */  = 8;
            var157_127 = 1.1E-44f;
        } else lbl-1000:
        // 2 sources

        {
            var156_126 /* !! */  = 0;
            var157_127 = 0.0f;
            var84_63 = null;
        }
        var119_93 = var2_2 & 740608L;
        var77_58 = 0L;
        var113_86 = (int)(var119_93 == var77_58 ? 0 : (var119_93 < var77_58 ? -1 : 1));
        if (var113_86 != 0) {
            if (var125_98 == 0) {
                var156_126 /* !! */  = 8;
                var157_127 = 1.1E-44f;
            }
            var150_121 = (int)var156_126 /* !! */ ;
            var156_126 /* !! */  = var47_32;
            var47_32 = var150_121;
            var48_33 = var157_127;
        } else {
            var156_126 /* !! */  = var47_32;
            var47_32 = 0;
            var48_33 = 0.0f;
            var49_34 = null;
        }
        var119_93 = var2_2 & var34_23;
        var113_86 = (int)(var119_93 == var77_58 ? 0 : (var119_93 < var77_58 ? -1 : 1));
        if (var113_86 == 0 && (var113_86 = (int)((cfr_temp_37 = (var119_93 = var6_4 & (var54_38 = (long)4)) - var77_58) == 0L ? 0 : (cfr_temp_37 < 0L ? -1 : 1))) == 0) {
            var158_128 = var15_11 /* !! */ ;
            var159_129 = var41_27;
            var15_11 /* !! */  = var64_46;
            var77_58 = 0L;
            var79_59 = var66_48;
        } else {
            if (var8_5 != null) {
                var155_125 = var8_5.K();
            }
            var79_59 = var66_48;
            var66_48 = var155_125;
            var158_128 = var15_11 /* !! */ ;
            var159_129 = var41_27;
            var15_11 /* !! */  = 5;
            var41_27 = 7.0E-45f;
            var1_1.updateLiveDataRegistration((int)var15_11 /* !! */ , (LiveData)var155_125);
            if (var155_125 != null) {
                var40_26 /* !! */  = (Boolean)var155_125.getValue();
                var61_43 = var40_26 /* !! */ ;
            }
            var15_11 /* !! */  = (long)ViewDataBinding.safeUnbox((Boolean)var61_43);
            var119_93 = var2_2 & var26_19;
            var77_58 = 0L;
            cfr_temp_38 = var119_93 - var77_58;
            var69_51 = (int)(cfr_temp_38 == 0L ? 0 : (cfr_temp_38 < 0L ? -1 : 1));
            if (var69_51 != 0) {
                var2_2 = var15_11 /* !! */  != false ? (var2_2 |= var24_18) : (var2_2 |= var36_24);
            }
            if ((var69_51 = (int)((cfr_temp_39 = (var119_93 = var2_2 & var34_23) - var77_58) == 0L ? 0 : (cfr_temp_39 < 0L ? -1 : 1))) != 0) {
                if (var15_11 /* !! */  != false) {
                    var119_93 = 0x800000L;
                    var2_2 |= var119_93;
                } else {
                    var152_123 = 0x400000L;
                    var2_2 |= var152_123;
                }
            }
            if ((var69_51 = (int)((cfr_temp_40 = (var119_93 = var2_2 & var32_22) - var77_58) == 0L ? 0 : (cfr_temp_40 < 0L ? -1 : 1))) != 0) {
                var119_93 = var15_11 /* !! */  != false ? 0x200000000000L : 0x100000000000L;
                var2_2 |= var119_93;
            }
            if ((var69_51 = (int)((cfr_temp_41 = (var119_93 = var2_2 & 671778L) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_41 < 0L ? -1 : 1))) != 0) {
                var119_93 = var15_11 /* !! */  != false ? 0x20000000000000L : 0x10000000000000L;
                var2_2 |= var119_93;
            }
            if ((var69_51 = (int)((cfr_temp_42 = (var119_93 = var2_2 & 540704L) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_42 < 0L ? -1 : 1))) != 0) {
                var119_93 = var15_11 /* !! */  != false ? -9223372036854775808L : 0x4000000000000000L;
                var2_2 |= var119_93;
            }
            if ((var69_51 = (int)((cfr_temp_43 = (var119_93 = var6_4 & var30_21) - var77_58) == 0L ? 0 : (cfr_temp_43 < 0L ? -1 : 1))) != 0) {
                var6_4 = var15_11 /* !! */  != false ? (var6_4 |= var24_18) : (var6_4 |= var36_24);
            }
            if ((var69_51 = (int)((cfr_temp_44 = (var119_93 = var6_4 & (var24_18 = (long)4)) - var77_58) == 0L ? 0 : (cfr_temp_44 < 0L ? -1 : 1))) != 0) {
                if (var15_11 /* !! */  != false) {
                    var24_18 = 0x80000000L;
                    var6_4 |= var24_18;
                } else {
                    var6_4 |= var28_20;
                }
            }
        }
        var24_18 = var2_2 & 0x100000000000L;
        var69_51 = (int)(var24_18 == var77_58 ? 0 : (var24_18 < var77_58 ? -1 : 1));
        if (var69_51 == 0 && (var69_51 = (int)((cfr_temp_45 = (var24_18 = var6_4 & var36_24) - var77_58) == 0L ? 0 : (cfr_temp_45 < 0L ? -1 : 1))) == 0) {
            var160_130 = var42_28;
            var161_131 = var43_29;
            var66_48 = var79_59;
        } else {
            var24_18 = var6_4 & var36_24;
            cfr_temp_46 = var24_18 - var77_58;
            var69_51 = (int)(cfr_temp_46 == 0L ? 0 : (cfr_temp_46 < 0L ? -1 : 1));
            if (var69_51 != 0) {
                if (var8_5 != null) {
                    var66_48 = var8_5.w0();
                    var160_130 = var42_28;
                    var161_131 = var43_29;
                } else {
                    var160_130 = var42_28;
                    var161_131 = var43_29;
                    var66_48 = var79_59;
                }
                var42_28 = 11;
                var43_29 = 1.5E-44f;
                var1_1.updateLiveDataRegistration(var42_28, (LiveData)var66_48);
                if (var66_48 != null) {
                    var76_57 = var46_31 = var66_48.getValue();
                    var76_57 = (Boolean)var46_31;
                }
                var42_28 = (int)ViewDataBinding.safeUnbox((Boolean)var76_57);
                var119_93 = var2_2 & 542720L;
                var77_58 = 0L;
                cfr_temp_47 = var119_93 - var77_58;
                var162_132 /* !! */  = (long)(cfr_temp_47 == 0L ? 0 : (cfr_temp_47 < 0L ? -1 : 1));
                if (var162_132 /* !! */  != false) {
                    if (var42_28 != 0) {
                        var2_2 |= var18_13;
                    } else {
                        var119_93 = 0x1000000L;
                        var2_2 |= var119_93;
                    }
                }
                var162_132 /* !! */  = 1;
                var156_126 /* !! */  = var42_28 ^= 1;
            } else {
                var160_130 = var42_28;
                var161_131 = var43_29;
                var66_48 = var79_59;
            }
            var119_93 = var2_2 & 0x100000000000L;
            var77_58 = 0L;
            var42_28 = (int)(var119_93 == var77_58 ? 0 : (var119_93 < var77_58 ? -1 : 1));
            if (var42_28 != 0) {
                if (var8_5 != null) {
                    var46_31 = var8_5.T();
                    var119_93 = var2_2;
                } else {
                    var119_93 = var2_2;
                    var46_31 = var144_117;
                }
                var163_133 = 12;
                var1_1.updateLiveDataRegistration(var163_133, (LiveData)var46_31);
                var164_134 = var46_31 != null ? (Boolean)var46_31.getValue() : var145_118;
                var137_111 = var163_133 = (int)ViewDataBinding.safeUnbox((Boolean)var164_134);
                var2_2 = var119_93;
            } else {
                var119_93 = var2_2;
            }
        }
        var119_93 = var2_2 & 0x500000L;
        var77_58 = 0L;
        var42_28 = (int)(var119_93 == var77_58 ? 0 : (var119_93 < var77_58 ? -1 : 1));
        if (var42_28 == 0 && (var42_28 = (int)((cfr_temp_48 = (var119_93 = var6_4 & var28_20) - var77_58) == 0L ? 0 : (cfr_temp_48 < 0L ? -1 : 1))) == 0) {
            var165_135 = var66_48;
            var42_28 = 0;
            var43_29 = 0.0f;
            var46_31 = null;
            var69_51 = 0;
            var70_52 = 0.0f;
            var66_48 = null;
            var53_37 = 0;
            var60_42 = 0.0f;
            var61_43 = null;
            var64_46 = 0;
            var166_136 = 0.0f;
            var79_59 = null;
            var113_86 = 0;
            var114_87 = 0.0f;
        } else {
            if (var9_6 != null) {
                var46_31 = var9_6.y();
                var165_135 = var66_48;
            } else {
                var165_135 = var66_48;
                var42_28 = 0;
                var43_29 = 0.0f;
                var46_31 = null;
            }
            var69_51 = 13;
            var70_52 = 1.8E-44f;
            var1_1.updateLiveDataRegistration(var69_51, (LiveData)var46_31);
            if (var46_31 != null) {
                var66_48 = (Boolean)var46_31.getValue();
            } else {
                var69_51 = 0;
                var70_52 = 0.0f;
                var66_48 = null;
            }
            var53_37 = (int)ViewDataBinding.safeUnbox((Boolean)var66_48);
            var119_93 = var6_4 & var28_20;
            var77_58 = 0L;
            var64_46 = var119_93 == var77_58 ? 0 : (var119_93 < var77_58 ? -1 : 1);
            if (var64_46 != false) {
                var119_93 = var53_37 != 0 ? 0x200000000L : 0x100000000L;
                var2_2 |= var119_93;
            }
            if ((var64_46 = (cfr_temp_49 = (var119_93 = var2_2 & (var57_40 = 0x400000L)) - var77_58) == 0L ? 0 : (cfr_temp_49 < 0L ? -1 : 1)) != false || (var113_86 = (int)((cfr_temp_50 = (var119_93 = var6_4 & (long)16) - var77_58) == 0L ? 0 : (cfr_temp_50 < 0L ? -1 : 1))) != 0) {
                var119_93 = var53_37 != 0 ? (long)2 : 1L;
                var6_4 |= var119_93;
            }
            if ((var113_86 = (int)((cfr_temp_51 = (var119_93 = var2_2 & var36_24) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_51 < 0L ? -1 : 1))) != 0) {
                if (var53_37 != 0) {
                    var119_93 = 0x8000000L;
                    var6_4 |= var119_93;
                } else {
                    var6_4 |= var34_23;
                }
            }
            if ((var113_86 = (int)((cfr_temp_52 = (var119_93 = var6_4 & var28_20) - var77_58) == 0L ? 0 : (cfr_temp_52 < 0L ? -1 : 1))) != 0 && var53_37 != 0) {
                var113_86 = 8;
                var114_87 = 1.1E-44f;
            } else {
                var113_86 = 0;
                var114_87 = 0.0f;
            }
            if (var64_46 != false && var53_37 == 0) {
                var64_46 = 8;
                var166_136 = 1.1E-44f;
            } else {
                var64_46 = 0;
                var166_136 = 0.0f;
                var79_59 = null;
            }
        }
        var119_93 = var2_2 & 0x10000000000000L;
        var77_58 = 0L;
        var121_94 = (int)(var119_93 == var77_58 ? 0 : (var119_93 < var77_58 ? -1 : 1));
        if (var121_94 != 0) {
            var129_103 = var46_31;
            if (var11_8 != null) {
                var46_31 = var11_8.e;
                var132_106 = var66_48;
            } else {
                var132_106 = var66_48;
                var46_31 = var109_83;
            }
            var69_51 = 1;
            var70_52 = 1.4E-45f;
            var1_1.updateLiveDataRegistration(var69_51, (LiveData)var46_31);
            var66_48 = var46_31 != null ? (Boolean)var46_31.getValue() : var63_45;
            var117_89 = (int)ViewDataBinding.safeUnbox((Boolean)var66_48);
            var167_137 = var2_2 & var95_73;
            var77_58 = 0L;
            var50_35 = (int)(var167_137 == var77_58 ? 0 : (var167_137 < var77_58 ? -1 : 1));
            if (var50_35 != 0) {
                var167_137 = var117_89 != 0 ? 512L : 256L;
                var6_4 |= var167_137;
            }
            var109_83 = var46_31;
        } else {
            var129_103 = var46_31;
            var132_106 = var66_48;
            var66_48 = var63_45;
        }
        var167_137 = var2_2 & var34_23;
        var77_58 = 0L;
        var42_28 = (int)(var167_137 == var77_58 ? 0 : (var167_137 < var77_58 ? -1 : 1));
        if (var42_28 != 0) {
            if (var15_11 /* !! */  != false) {
                var42_28 = 8;
                var43_29 = 1.1E-44f;
            } else {
                var42_28 = (int)var64_46;
                var43_29 = var166_136;
            }
        } else {
            var42_28 = 0;
            var43_29 = 0.0f;
            var46_31 = null;
        }
        var167_137 = var2_2 & var32_22;
        var50_35 = (int)(var167_137 == var77_58 ? 0 : (var167_137 < var77_58 ? -1 : 1));
        if (var50_35 != 0) {
            if (var15_11 /* !! */  != false) {
                var137_111 = 1;
            }
            if ((var50_35 = (int)((cfr_temp_53 = (var167_137 = var2_2 & 544800L) - var77_58) == 0L ? 0 : (cfr_temp_53 < 0L ? -1 : 1))) != 0) {
                if (var137_111 != 0) {
                    var2_2 |= 0x80000000L;
                    var167_137 = 0x800000000L;
                } else {
                    var2_2 |= var28_20;
                    var167_137 = 0x400000000L;
                }
                var6_4 |= var167_137;
            }
            if ((var50_35 = (int)((cfr_temp_54 = (var167_137 = var2_2 & var32_22) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_54 < 0L ? -1 : 1))) != 0) {
                var167_137 = var137_111 != 0 ? 0x80000000000000L : 0x40000000000000L;
                var2_2 |= var167_137;
            }
            if ((var50_35 = (int)((cfr_temp_55 = (var167_137 = var2_2 & 544800L) - (var77_58 = 0L)) == 0L ? 0 : (cfr_temp_55 < 0L ? -1 : 1))) != 0) {
                var50_35 = var137_111 ^ 1;
                if (var137_111 != 0) {
                    var138_112 = var20_14;
                    var139_113 = var21_15;
                } else {
                    var138_112 = var22_16;
                    var139_113 = var23_17;
                }
                var150_121 = var50_35;
                var50_35 = var42_28;
                var62_44 = var43_29;
                var42_28 = var150_121;
                var140_114 = var66_48;
                var69_51 = var138_112;
                var70_52 = var139_113;
            } else {
                var50_35 = var42_28;
                var62_44 = var43_29;
                var140_114 = var66_48;
                var69_51 = 0;
                var66_48 = null;
                var70_52 = 0.0f;
                var42_28 = 0;
                var43_29 = 0.0f;
                var46_31 = null;
            }
        } else {
            var50_35 = var42_28;
            var62_44 = var43_29;
            var140_114 = var66_48;
            var69_51 = 0;
            var66_48 = null;
            var70_52 = 0.0f;
            var42_28 = 0;
            var43_29 = 0.0f;
            var46_31 = null;
            var137_111 = 0;
        }
        var141_115 = var2_2 & 671778L;
        var77_58 = 0L;
        var143_116 = var141_115 == var77_58 ? 0 : (var141_115 < var77_58 ? -1 : 1);
        if (var143_116 != false) {
            var169_138 = var15_11 /* !! */  != false ? 1 : var117_89;
            if (var143_116 != false) {
                var146_119 = var169_138 != 0 ? 0x8000000000L : 0x4000000000L;
                var2_2 |= var146_119;
            }
            if (var169_138 != 0) {
                var143_116 = var20_14;
                var170_139 = var21_15;
            } else {
                var143_116 = var22_16;
                var170_139 = var23_17;
            }
            var171_140 = var143_116;
            var172_141 = var170_139;
        } else {
            var171_140 = 0;
            var172_141 = 0.0f;
        }
        var141_115 = var6_4 & var30_21;
        var77_58 = 0L;
        var143_116 = var141_115 == var77_58 ? 0 : (var141_115 < var77_58 ? -1 : 1);
        if (var143_116 != false) {
            var169_138 = var15_11 /* !! */  != false ? 1 : (int)var156_126 /* !! */ ;
            if (var143_116 != false) {
                var146_119 = var169_138 != 0 ? (long)32 : (long)16;
                var6_4 |= var146_119;
            }
            var54_38 = 4;
        } else {
            var54_38 = 4;
            var169_138 = 0;
            var145_118 = null;
        }
        var54_38 = var6_4 & var54_38;
        var77_58 = 0L;
        var173_142 = var54_38 == var77_58 ? 0 : (var54_38 < var77_58 ? -1 : 1);
        if (var173_142 == false || var15_11 /* !! */  != false) {
            var113_86 = 0;
            var114_87 = 0.0f;
        }
        if ((var173_142 = (cfr_temp_56 = (var54_38 = var6_4 & var97_74) - var77_58) == 0L ? 0 : (cfr_temp_56 < 0L ? -1 : 1)) != false) {
            if (var154_124 != 0) {
                var50_35 = 8;
                var62_44 = 1.1E-44f;
            }
        } else {
            var50_35 = 0;
            var62_44 = 0.0f;
            var63_45 = null;
        }
        if ((var173_142 = (cfr_temp_57 = (var54_38 = var2_2 & var93_72) - var77_58) == 0L ? 0 : (cfr_temp_57 < 0L ? -1 : 1)) != false) {
            if (var154_124 != 0) {
                var113_86 = 8;
                var114_87 = 1.1E-44f;
            }
        } else {
            var113_86 = 0;
            var114_87 = 0.0f;
        }
        if ((var154_124 = (int)((cfr_temp_58 = (var54_38 = var2_2 & 781600L) - var77_58) == 0L ? 0 : (cfr_temp_58 < 0L ? -1 : 1))) != 0) {
            if (var125_98 != 0) {
                var113_86 = 8;
                var114_87 = 1.1E-44f;
            }
            if (var125_98 != 0) {
                var50_35 = 8;
                var62_44 = 1.1E-44f;
            }
            var173_142 = var72_54;
            var174_143 = var75_56;
            var154_124 = var50_35;
            var72_54 = var113_86;
            var75_56 = var114_87;
        } else {
            var173_142 = var72_54;
            var174_143 = var75_56;
            var72_54 = 0;
            var75_56 = 0.0f;
            var154_124 = 0;
            var10_7 = null;
        }
        var93_72 = var6_4 & (long)16;
        var77_58 = 0L;
        var175_144 = var93_72 == var77_58 ? 0 : (var93_72 < var77_58 ? -1 : 1);
        if (var175_144 != false) {
            if (var9_6 != null) {
                var9_6 = var9_6.y();
                var50_35 = var47_32;
                var62_44 = var48_33;
            } else {
                var50_35 = var47_32;
                var62_44 = var48_33;
                var9_6 = var129_103;
            }
            var47_32 = 13;
            var48_33 = 1.8E-44f;
            var1_1.updateLiveDataRegistration(var47_32, (LiveData)var9_6);
            if (var9_6 != null) {
                var132_106 = var9_6 = (Boolean)var9_6.getValue();
            }
            var53_37 = (int)ViewDataBinding.safeUnbox((Boolean)var132_106);
            var77_58 = 0L;
            cfr_temp_59 = (var28_20 = var6_4 & var28_20) - var77_58;
            var176_145 /* !! */  = (long)(cfr_temp_59 == 0L ? 0 : (cfr_temp_59 < 0L ? -1 : 1));
            if (var176_145 /* !! */  != false) {
                var28_20 = var53_37 != 0 ? 0x200000000L : 0x100000000L;
                var2_2 |= var28_20;
            }
            if ((var176_145 /* !! */  = (cfr_temp_60 = (var28_20 = var2_2 & 0x400000L) - var77_58) == 0L ? 0 : (cfr_temp_60 < 0L ? -1 : 1)) != false || var175_144 != false) {
                var28_20 = var53_37 != 0 ? (long)2 : 1L;
                var6_4 |= var28_20;
            }
            if ((var176_145 /* !! */  = (cfr_temp_61 = (var28_20 = var2_2 & var36_24) - (var57_40 = 0L)) == 0L ? 0 : (cfr_temp_61 < 0L ? -1 : 1)) != false) {
                if (var53_37 != 0) {
                    var28_20 = 0x8000000L;
                    var6_4 |= var28_20;
                } else {
                    var6_4 |= var34_23;
                }
            }
            if (var53_37 != 0) {
                var64_46 = 0;
                var166_136 = 0.0f;
                var79_59 = null;
            } else {
                var64_46 = 8;
                var166_136 = 1.1E-44f;
            }
        } else {
            var50_35 = var47_32;
            var62_44 = var48_33;
        }
        var28_20 = var2_2 & 0x40000000000000L;
        var152_123 = 0L;
        var176_145 /* !! */  = var28_20 == var152_123 ? 0 : (var28_20 < var152_123 ? -1 : 1);
        if (var176_145 /* !! */  != false) {
            var9_6 = var11_8 != null ? var11_8.e : var109_83;
            var177_146 = 1;
            var178_147 = 1.4E-45f;
            var1_1.updateLiveDataRegistration(var177_146, (LiveData)var9_6);
            var9_6 = var9_6 != null ? (Boolean)var9_6.getValue() : var140_114;
            var176_145 /* !! */  = (long)ViewDataBinding.safeUnbox((Boolean)var9_6);
            var28_20 = var2_2 & var95_73;
            var152_123 = 0L;
            var177_146 = (int)(var28_20 == var152_123 ? 0 : (var28_20 < var152_123 ? -1 : 1));
            if (var177_146 != 0) {
                var28_20 = var176_145 /* !! */  != false ? 512L : 256L;
                var6_4 |= var28_20;
            }
        } else {
            var176_145 /* !! */  = var117_89;
        }
        if ((var177_146 = (int)((cfr_temp_62 = (var28_20 = var2_2 & var32_22) - (var152_123 = 0L)) == 0L ? 0 : (cfr_temp_62 < 0L ? -1 : 1))) != 0) {
            if (var137_111 != 0) {
                var176_145 /* !! */  = 1;
            }
            if ((var177_146 = (int)((cfr_temp_63 = (var28_20 = var2_2 & 675874L) - var152_123) == 0L ? 0 : (cfr_temp_63 < 0L ? -1 : 1))) != 0) {
                var28_20 = var176_145 /* !! */  != false ? 0x20000000000L : 0x10000000000L;
                var2_2 |= var28_20;
            }
            if ((var177_146 = (int)((cfr_temp_64 = (var28_20 = var2_2 & var32_22) - var152_123) == 0L ? 0 : (cfr_temp_64 < 0L ? -1 : 1))) != 0) {
                var28_20 = var176_145 /* !! */  != false ? 0x200000000L : 0x100000000L;
                var6_4 |= var28_20;
            }
            if ((var177_146 = (int)((cfr_temp_65 = (var28_20 = var2_2 & 675874L) - (var152_123 = 0L)) == 0L ? 0 : (cfr_temp_65 < 0L ? -1 : 1))) != 0) {
                if (var176_145 /* !! */  == false) {
                    var20_14 = var22_16;
                    var21_15 = var23_17;
                }
                var177_146 = var20_14;
                var178_147 = var21_15;
            } else {
                var177_146 = 0;
                var11_8 = null;
                var178_147 = 0.0f;
            }
        } else {
            var177_146 = 0;
            var11_8 = null;
            var178_147 = 0.0f;
            var176_145 /* !! */  = 0;
            var9_6 = null;
        }
        var179_148 = var6_4 & var30_21;
        var47_32 = (int)(var179_148 == var152_123 ? 0 : (var179_148 < var152_123 ? -1 : 1));
        if (var47_32 != 0) {
            if (var169_138 != 0) {
                var64_46 = 8;
                var166_136 = 1.1E-44f;
            }
        } else {
            var64_46 = 0;
            var166_136 = 0.0f;
            var79_59 = null;
        }
        if ((var47_32 = (int)((cfr_temp_66 = (var179_148 = var2_2 & 715808L) - var152_123) == 0L ? 0 : (cfr_temp_66 < 0L ? -1 : 1))) != 0) {
            if (var125_98 != 0) {
                var64_46 = 8;
                var166_136 = 1.1E-44f;
            }
            var47_32 = (int)var64_46;
            var48_33 = var166_136;
        } else {
            var47_32 = 0;
            var48_33 = 0.0f;
            var49_34 = null;
        }
        var179_148 = var6_4 & var34_23;
        var20_14 = (int)(var179_148 == var152_123 ? 0 : (var179_148 < var152_123 ? -1 : 1));
        if (var20_14 != 0) {
            if (var8_5 != null) {
                var8_5 = var8_5.w0();
                var20_14 = var177_146;
                var21_15 = var178_147;
            } else {
                var20_14 = var177_146;
                var21_15 = var178_147;
                var8_5 = var165_135;
            }
            var177_146 = 11;
            var178_147 = 1.5E-44f;
            var1_1.updateLiveDataRegistration(var177_146, (LiveData)var8_5);
            if (var8_5 != null) {
                var76_57 = var8_5 = var8_5.getValue();
                var76_57 = (Boolean)var8_5;
            }
            var181_149 = (long)ViewDataBinding.safeUnbox((Boolean)var76_57);
            var182_150 = var2_2 & 542720L;
            var184_151 = 0L;
            cfr_temp_67 = var182_150 - var184_151;
            var177_146 = (int)(cfr_temp_67 == 0L ? 0 : (cfr_temp_67 < 0L ? -1 : 1));
            if (var177_146 != 0) {
                if (var181_149 != false) {
                    var2_2 |= var18_13;
                } else {
                    var186_152 = 0x1000000L;
                    var2_2 |= var186_152;
                }
            }
            var177_146 = 1;
            var178_147 = 1.4E-45f;
            var181_149 = var181_149 ^ var177_146;
        } else {
            var20_14 = var177_146;
            var21_15 = var178_147;
            var181_149 = var156_126 /* !! */ ;
        }
        var186_152 = 0L;
        cfr_temp_68 = (var6_4 &= 0x100000000L) - var186_152;
        var188_153 = cfr_temp_68 == 0L ? 0 : (cfr_temp_68 < 0L ? -1 : 1);
        if (var188_153 != false && var12_9 /* !! */  != null) {
            var189_154 = var1_1.T;
            if (var189_154 == null) {
                var1_1.T = var189_154 = new zh$a();
            }
            var189_154 = var189_154.b((CameraFragment$j)var12_9 /* !! */ );
        } else {
            var188_153 = 0;
            var189_154 = null;
        }
        var190_155 = var2_2 & var36_24;
        var186_152 = 0L;
        var192_156 = var190_155 == var186_152 ? 0 : (var190_155 < var186_152 ? -1 : 1);
        if (var192_156 == false) ** GOTO lbl-1000
        if (var53_37 != 0) {
            var181_149 = 1;
        }
        if (var192_156 != false) {
            var190_155 = var181_149 != false ? 0x200000000000000L : 0x100000000000000L;
            var2_2 |= var190_155;
        }
        if (var181_149 != false) {
            var181_149 = 8;
        } else lbl-1000:
        // 2 sources

        {
            var181_149 = 0;
            var8_5 = null;
        }
        var190_155 = var2_2 & var32_22;
        var186_152 = 0L;
        var192_156 = var190_155 == var186_152 ? 0 : (var190_155 < var186_152 ? -1 : 1);
        if (var192_156 == false || var176_145 /* !! */  != false) {
            var188_153 = 0;
            var189_154 = null;
        }
        if ((var177_146 = (int)((cfr_temp_69 = (var190_155 = var2_2 & var26_19) - var186_152) == 0L ? 0 : (cfr_temp_69 < 0L ? -1 : 1))) == 0 || var15_11 /* !! */  != false) {
            var181_149 = 0;
            var8_5 = null;
        }
        if ((var177_146 = (int)((cfr_temp_70 = (var190_155 = 715808L & var2_2) - var186_152) == 0L ? 0 : (cfr_temp_70 < 0L ? -1 : 1))) != 0) {
            if (var125_98 != 0) {
                var181_149 = 8;
            }
        } else {
            var181_149 = 0;
            var8_5 = null;
        }
        if ((var195_158 = (cfr_temp_71 = (var193_157 = 544800L & var2_2) - var186_152) == 0L ? 0 : (cfr_temp_71 < 0L ? -1 : 1)) != false) {
            var12_9 /* !! */  = var1_1.a;
            var12_9 /* !! */ .setEnabled((boolean)var42_28);
            var195_158 = ViewDataBinding.getBuildSdkInt();
            var15_11 /* !! */  = 11;
            var41_27 = 1.5E-44f;
            if (var195_158 >= var15_11 /* !! */ ) {
                var12_9 /* !! */  = var1_1.a;
                var12_9 /* !! */ .setAlpha(var70_52);
            }
        }
        if ((var195_158 = (cfr_temp_72 = (var193_157 = 524288L & var2_2) - (var87_66 = 0L)) == 0L ? 0 : (cfr_temp_72 < 0L ? -1 : 1)) != false) {
            var12_9 /* !! */  = var1_1.b;
            var40_26 /* !! */  = var1_1.S;
            var12_9 /* !! */ .setOnClickListener((View.OnClickListener)var40_26 /* !! */ );
            var12_9 /* !! */  = var1_1.f;
            var40_26 /* !! */  = var1_1.J;
            var12_9 /* !! */ .setOnClickListener((View.OnClickListener)var40_26 /* !! */ );
            var12_9 /* !! */  = var1_1.g;
            var40_26 /* !! */  = var1_1.G;
            var12_9 /* !! */ .setOnClickListener((View.OnClickListener)var40_26 /* !! */ );
            var12_9 /* !! */  = var1_1.h;
            var40_26 /* !! */  = var1_1.O;
            var12_9 /* !! */ .setOnClickListener((View.OnClickListener)var40_26 /* !! */ );
            var12_9 /* !! */  = var1_1.i;
            var40_26 /* !! */  = var1_1.P;
            var12_9 /* !! */ .setOnClickListener((View.OnClickListener)var40_26 /* !! */ );
            var12_9 /* !! */  = var1_1.j;
            var40_26 /* !! */  = var1_1.Q;
            var12_9 /* !! */ .setOnClickListener((View.OnClickListener)var40_26 /* !! */ );
            var12_9 /* !! */  = var1_1.k;
            var40_26 /* !! */  = var1_1.M;
            var12_9 /* !! */ .setOnClickListener((View.OnClickListener)var40_26 /* !! */ );
            var12_9 /* !! */  = var1_1.m;
            var40_26 /* !! */  = var1_1.K;
            var12_9 /* !! */ .setOnClickListener((View.OnClickListener)var40_26 /* !! */ );
            var12_9 /* !! */  = var1_1.B;
            var40_26 /* !! */  = var1_1.R;
            var12_9 /* !! */ .setOnClickListener((View.OnClickListener)var40_26 /* !! */ );
            var12_9 /* !! */  = var1_1.C;
            var40_26 /* !! */  = var1_1.N;
            var12_9 /* !! */ .setOnClickListener((View.OnClickListener)var40_26 /* !! */ );
            var12_9 /* !! */  = var1_1.D;
            var40_26 /* !! */  = var1_1.H;
            var12_9 /* !! */ .setOnClickListener((View.OnClickListener)var40_26 /* !! */ );
            var12_9 /* !! */  = var1_1.F;
            var40_26 /* !! */  = var1_1.I;
            var12_9 /* !! */ .setOnClickListener((View.OnClickListener)var40_26 /* !! */ );
            var12_9 /* !! */  = var1_1.s;
            var40_26 /* !! */  = var1_1.L;
            var12_9 /* !! */ .setOnClickListener((View.OnClickListener)var40_26 /* !! */ );
            var195_158 = ViewDataBinding.getBuildSdkInt();
            var15_11 /* !! */  = 21;
            var41_27 = 2.9E-44f;
            if (var195_158 >= var15_11 /* !! */ ) {
                var12_9 /* !! */  = var1_1.c;
                var15_11 /* !! */  = 1;
                var41_27 = 1.4E-45f;
                var12_9 /* !! */ .setClipToOutline((boolean)var15_11 /* !! */ );
            }
        }
        if (var177_146 != 0) {
            var1_1.c.setVisibility(var47_32);
            var11_8 = var1_1.m;
            var11_8.setVisibility((int)var181_149);
            var8_5 = var1_1.u;
            var8_5.setVisibility(var47_32);
        }
        if ((var181_149 = (cfr_temp_73 = (var190_155 = 540704L & var2_2) - (var13_10 = 0L)) == 0L ? 0 : (cfr_temp_73 < 0L ? -1 : 1)) != false) {
            var181_149 = ViewDataBinding.getBuildSdkInt();
            var177_146 = 11;
            var178_147 = 1.5E-44f;
            if (var181_149 >= var177_146) {
                var1_1.c.setAlpha(var68_50);
                var1_1.m.setAlpha(var68_50);
                var8_5 = var1_1.u;
                var8_5.setAlpha(var68_50);
            }
        }
        if ((var181_149 = (cfr_temp_74 = (var190_155 = 781600L & var2_2) - (var13_10 = 0L)) == 0L ? 0 : (cfr_temp_74 < 0L ? -1 : 1)) != false) {
            var1_1.f.setVisibility(var154_124);
            var8_5 = var1_1.i;
            var8_5.setVisibility(var72_54);
        }
        if ((var181_149 = (cfr_temp_75 = (var4_3 = 740608L & var2_2) - var13_10) == 0L ? 0 : (cfr_temp_75 < 0L ? -1 : 1)) != false) {
            var8_5 = var1_1.g;
            var67_49 = var50_35;
            var68_50 = var62_44;
            var8_5.setVisibility(var50_35);
        }
        if ((var181_149 = (cfr_temp_76 = (var4_3 = 542720L & var2_2) - var13_10) == 0L ? 0 : (cfr_temp_76 < 0L ? -1 : 1)) != false) {
            var8_5 = var1_1.h;
            var72_54 = (int)var173_142;
            var75_56 = var174_143;
            var8_5.setVisibility((int)var173_142);
            var1_1.j.setVisibility((int)var173_142);
            var8_5 = var1_1.k;
            var8_5.setVisibility((int)var173_142);
        }
        if ((var181_149 = (cfr_temp_77 = (var4_3 = 671778L & var2_2) - (var196_159 = 0L)) == 0L ? 0 : (cfr_temp_77 < 0L ? -1 : 1)) != false) {
            var181_149 = ViewDataBinding.getBuildSdkInt();
            var67_49 = 11;
            var68_50 = 1.5E-44f;
            if (var181_149 >= var67_49) {
                var8_5 = var1_1.h;
                var67_49 = var171_140;
                var68_50 = var172_141;
                var8_5.setAlpha(var172_141);
                var1_1.j.setAlpha(var172_141);
                var8_5 = var1_1.k;
                var8_5.setAlpha(var172_141);
            }
        }
        if ((var181_149 = (cfr_temp_78 = (var4_3 = 656384L & var2_2) - (var196_159 = 0L)) == 0L ? 0 : (cfr_temp_78 < 0L ? -1 : 1)) != false) {
            var8_5 = var1_1.p;
            var67_49 = var160_130;
            var68_50 = var161_131;
            var8_5.setVisibility(var160_130);
            var8_5 = var1_1.s;
            var8_5.setVisibility(var160_130);
        }
        if ((var181_149 = (cfr_temp_79 = (var4_3 = 573960L & var2_2) - var196_159) == 0L ? 0 : (cfr_temp_79 < 0L ? -1 : 1)) != false) {
            var8_5 = var1_1.A;
            var15_11 /* !! */  = var158_128;
            var41_27 = var159_129;
            var8_5.setVisibility((int)var158_128);
            var8_5 = var1_1.r;
            var8_5.setVisibility((int)var158_128);
        }
        if ((var181_149 = (cfr_temp_80 = (var4_3 = 655488L & var2_2) - var196_159) == 0L ? 0 : (cfr_temp_80 < 0L ? -1 : 1)) != false) {
            var8_5 = var1_1.B;
            var67_49 = var135_109;
            var8_5.setEnabled((boolean)var135_109);
            var181_149 = ViewDataBinding.getBuildSdkInt();
            var67_49 = 11;
            var68_50 = 1.5E-44f;
            if (var181_149 >= var67_49) {
                var8_5 = var1_1.B;
                var67_49 = (int)var133_107;
                var68_50 = var136_110;
                var8_5.setAlpha(var136_110);
            }
        }
        if ((var181_149 = (cfr_temp_81 = (var4_3 = 676897L & var2_2) - (var196_159 = 0L)) == 0L ? 0 : (cfr_temp_81 < 0L ? -1 : 1)) != false) {
            var8_5 = var1_1.B;
            var69_51 = var130_104;
            var70_52 = var131_105;
            var8_5.setVisibility(var130_104);
        }
        if ((var181_149 = (cfr_temp_82 = (var4_3 = 655490L & var2_2) - var196_159) == 0L ? 0 : (cfr_temp_82 < 0L ? -1 : 1)) != false) {
            var8_5 = var1_1.B;
            var66_48 = var106_80;
            var67_49 = 0;
            var68_50 = 0.0f;
            var71_53 = null;
            l.a.q.g0.u.n((TextView)var8_5, (String)var106_80, null, null);
        }
        if ((var181_149 = (cfr_temp_83 = (var4_3 = 557072L & var2_2) - var196_159) == 0L ? 0 : (cfr_temp_83 < 0L ? -1 : 1)) != false) {
            var8_5 = var1_1.C;
            var67_49 = var101_76;
            var68_50 = var102_77;
            var8_5.setVisibility(var101_76);
        }
        if ((var181_149 = (cfr_temp_84 = (var4_3 = 655426L & var2_2) - var196_159) == 0L ? 0 : (cfr_temp_84 < 0L ? -1 : 1)) != false) {
            var8_5 = var1_1.D;
            var67_49 = var151_122;
            var8_5.setEnabled((boolean)var151_122);
        }
        if ((var181_149 = (cfr_temp_85 = (var4_3 = 675874L & var2_2) - var196_159) == 0L ? 0 : (cfr_temp_85 < 0L ? -1 : 1)) != false) {
            var8_5 = var1_1.E;
            var8_5.setClickable((boolean)var176_145 /* !! */ );
            var181_149 = ViewDataBinding.getBuildSdkInt();
            var67_49 = 11;
            var68_50 = 1.5E-44f;
            if (var181_149 >= var67_49) {
                var8_5 = var1_1.s;
                var72_54 = var20_14;
                var75_56 = var21_15;
                var8_5.setAlpha(var21_15);
            }
        } else {
            var67_49 = 11;
            var68_50 = 1.5E-44f;
        }
        if ((var181_149 = (cfr_temp_86 = (var198_160 = var2_2 & var95_73) - (var190_155 = 0L)) == 0L ? 0 : (cfr_temp_86 < 0L ? -1 : 1)) != false && (var181_149 = (long)ViewDataBinding.getBuildSdkInt()) >= var67_49) {
            var8_5 = var1_1.q;
            var69_51 = var123_96;
            var70_52 = var124_97;
            var8_5.setAlpha(var124_97);
        }
        if (var192_156 != false) {
            var8_5 = var1_1.r;
            var8_5.setOnStoryItemClickListener(var189_154);
        }
        if ((var181_149 = (cfr_temp_87 = (var2_2 &= 557060L) - (var4_3 = 0L)) == 0L ? 0 : (cfr_temp_87 < 0L ? -1 : 1)) != false) {
            var8_5 = var1_1.r;
            var163_133 = var86_65;
            var8_5.setProgress(var86_65);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.U;
            long l11 = 0L;
            Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (object != false) return (boolean)((Object)1);
            l10 = this.V;
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
            this.U = l10 = 524288L;
            this.V = l10 = 0L;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        switch (n10) {
            default: {
                return false;
            }
            case 13: {
                object = (LiveData)object;
                return this.U((LiveData)object, n11);
            }
            case 12: {
                object = (MutableLiveData)object;
                return this.L((MutableLiveData)object, n11);
            }
            case 11: {
                object = (MutableLiveData)object;
                return this.M((MutableLiveData)object, n11);
            }
            case 10: {
                object = (MutableLiveData)object;
                return this.Q((MutableLiveData)object, n11);
            }
            case 9: {
                object = (MutableLiveData)object;
                return this.T((MutableLiveData)object, n11);
            }
            case 8: {
                object = (LiveData)object;
                return this.I((LiveData)object, n11);
            }
            case 7: {
                object = (MutableLiveData)object;
                return this.O((MutableLiveData)object, n11);
            }
            case 6: {
                object = (MutableLiveData)object;
                return this.N((MutableLiveData)object, n11);
            }
            case 5: {
                object = (MutableLiveData)object;
                return this.K((MutableLiveData)object, n11);
            }
            case 4: {
                object = (MutableLiveData)object;
                return this.V((MutableLiveData)object, n11);
            }
            case 3: {
                object = (MutableLiveData)object;
                return this.J((MutableLiveData)object, n11);
            }
            case 2: {
                object = (MutableLiveData)object;
                return this.S((MutableLiveData)object, n11);
            }
            case 1: {
                object = (MutableLiveData)object;
                return this.R((MutableLiveData)object, n11);
            }
            case 0: 
        }
        object = (MutableLiveData)object;
        return this.P((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 16;
        if (n11 == n10) {
            object = (u6)object;
            this.E((u6)object);
            return 1 != 0;
        } else {
            n11 = 131;
            if (n11 == n10) {
                object = (m0)object;
                this.H((m0)object);
                return 1 != 0;
            } else {
                n11 = 13;
                if (n11 == n10) {
                    object = (BleViewModel)object;
                    this.D((BleViewModel)object);
                    return 1 != 0;
                } else {
                    n11 = 130;
                    if (n11 == n10) {
                        object = (l)object;
                        this.G((l)object);
                        return 1 != 0;
                    } else {
                        n11 = 25;
                        if (n11 != n10) return 0 != 0;
                        object = (CameraFragment$j)object;
                        this.F((CameraFragment$j)object);
                    }
                }
            }
        }
        return 1 != 0;
    }
}

