/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckedTextView
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import com.zhiyun.cama.camera.data.CameraSet$CountDownTime;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.camera.data.CameraSet$Panorama;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;
import com.zhiyun.cama.data.database.model.CameraParam;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.d7.z;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.u0.l;
import d.v.c.s0.s6;
import d.v.c.s0.u6;
import d.v.c.s0.v6;
import d.v.c.s0.w6;
import d.v.c.w0.p0;
import d.v.d.i.g.k$a;
import d.v.f.i.g;
import d.v.g.g.c1;

public class q0
extends p0
implements b$a {
    private static final ViewDataBinding$IncludedLayouts H;
    private static final SparseIntArray I;
    private final View.OnClickListener A;
    private final View.OnClickListener B;
    private final View.OnClickListener C;
    private final View.OnClickListener D;
    private final View.OnClickListener E;
    private long F;
    private long G;
    private final View.OnClickListener y;
    private final View.OnClickListener z;

    static {
        SparseIntArray sparseIntArray;
        I = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362178, 10);
    }

    public q0(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = H;
        SparseIntArray sparseIntArray = I;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 11, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private q0(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        long l10;
        Object object;
        Object object2 = object = objectArray[9];
        object2 = (CheckedTextView)object;
        Object object3 = object = objectArray[10];
        object3 = (ConstraintLayout)((Object)object);
        Object object4 = object = objectArray[0];
        object4 = (FrameLayout)object;
        Object object5 = object = objectArray[7];
        object5 = (ImageView)object;
        Object object6 = object = objectArray[3];
        object6 = (ImageView)object;
        Object object7 = object = objectArray[4];
        object7 = (ImageView)object;
        Object object8 = object = objectArray[6];
        object8 = (ImageView)object;
        Object object9 = object = objectArray[2];
        object9 = (ImageView)object;
        Object object10 = object = objectArray[5];
        object10 = (ImageView)object;
        Object object11 = object = objectArray[8];
        object11 = (ImageView)object;
        Object object12 = object = objectArray[1];
        object12 = (ConstraintLayout)((Object)object);
        object = this;
        int n10 = 14;
        super(dataBindingComponent, view, n10, (CheckedTextView)object2, (ConstraintLayout)((Object)object3), (FrameLayout)object4, (ImageView)object5, (ImageView)object6, (ImageView)object7, (ImageView)object8, (ImageView)object9, (ImageView)object10, (ImageView)object11, (ConstraintLayout)((Object)object12));
        this.F = l10 = (long)-1;
        this.G = l10;
        this.a.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, 5);
        this.y = object;
        object = new b(this, 6);
        this.z = object;
        object = new b(this, 3);
        this.A = object;
        object = new b(this, 4);
        this.B = object;
        object = new b(this, 1);
        this.C = object;
        object = new b(this, 2);
        this.D = object;
        object = new b(this, 7);
        this.E = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean Y(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 128L;
                this.F = l10 |= l11;
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
                long l10 = this.F;
                long l11 = 256L;
                this.F = l10 |= l11;
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
    private boolean a0(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 1L;
                this.F = l10 |= l11;
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
    private boolean b0(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 4096L;
                this.F = l10 |= l11;
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
    private boolean c0(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 8192L;
                this.F = l10 |= l11;
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
    private boolean d0(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 2;
                this.F = l10 |= l11;
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
    private boolean e0(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 4;
                this.F = l10 |= l11;
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
    private boolean f0(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 512L;
                this.F = l10 |= l11;
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
    private boolean g0(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 16;
                this.F = l10 |= l11;
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
    private boolean h0(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 8;
                this.F = l10 |= l11;
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
    private boolean i0(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 64;
                this.F = l10 |= l11;
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
    private boolean j0(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 32;
                this.F = l10 |= l11;
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
    private boolean k0(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 1024L;
                this.F = l10 |= l11;
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
    private boolean l0(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 2048L;
                this.F = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    public void L(BleViewModel bleViewModel) {
        this.o = bleViewModel;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void M(CameraFragment$j cameraFragment$j) {
        this.t = cameraFragment$j;
        synchronized (this) {
            long l10 = this.F;
            long l11 = 524288L;
            this.F = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    public void N(DeviceViewModel deviceViewModel) {
        this.p = deviceViewModel;
    }

    public void O(DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel) {
        this.w = dynamicZoomViewModel$TargetModel;
    }

    public void P(DynamicZoomViewModel dynamicZoomViewModel) {
        this.v = dynamicZoomViewModel;
    }

    public void Q(c1 c12) {
        this.r = c12;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void R(z z10) {
        this.u = z10;
        synchronized (this) {
            long l10 = this.F;
            long l11 = 0x4000000L;
            this.F = l10 |= l11;
        }
        this.notifyPropertyChanged(80);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void S(v6 v62) {
        this.s = v62;
        synchronized (this) {
            long l10 = this.F;
            long l11 = 0x400000L;
            this.F = l10 |= l11;
        }
        this.notifyPropertyChanged(112);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void T(l l10) {
        this.x = l10;
        synchronized (this) {
            long l11 = this.F;
            long l12 = 0x800000L;
            this.F = l11 |= l12;
        }
        this.notifyPropertyChanged(130);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void U(m0 m02) {
        this.n = m02;
        synchronized (this) {
            long l10 = this.F;
            long l11 = 32768L;
            this.F = l10 |= l11;
        }
        this.notifyPropertyChanged(131);
        super.requestRebind();
    }

    public void V(w6 w62) {
        this.q = w62;
    }

    public void W(s6 s62) {
        this.m = s62;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void X(u6 u62) {
        this.l = u62;
        synchronized (this) {
            long l10 = this.F;
            long l11 = 0x2000000L;
            this.F = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        boolean bl2 = true;
        switch (n10) {
            default: {
                break;
            }
            case 7: {
                CameraFragment$j cameraFragment$j = this.t;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.m0();
                break;
            }
            case 6: {
                CameraFragment$j cameraFragment$j = this.t;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.b0();
                break;
            }
            case 5: {
                CameraFragment$j cameraFragment$j = this.t;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.f0();
                break;
            }
            case 4: {
                CameraFragment$j cameraFragment$j = this.t;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.j0();
                break;
            }
            case 3: {
                CameraFragment$j cameraFragment$j = this.t;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.d0();
                break;
            }
            case 2: {
                CameraFragment$j cameraFragment$j = this.t;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.c0();
                break;
            }
            case 1: {
                CameraFragment$j cameraFragment$j = this.t;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.k();
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
        block280: {
            block279: {
                block278: {
                    block268: {
                        block277: {
                            block276: {
                                block275: {
                                    block274: {
                                        block273: {
                                            block272: {
                                                block271: {
                                                    block270: {
                                                        block269: {
                                                            block267: {
                                                                block266: {
                                                                    block257: {
                                                                        block262: {
                                                                            block265: {
                                                                                block264: {
                                                                                    block263: {
                                                                                        block260: {
                                                                                            block261: {
                                                                                                block258: {
                                                                                                    block259: {
                                                                                                        block256: {
                                                                                                            block255: {
                                                                                                                block254: {
                                                                                                                    var1_1 = this;
                                                                                                                    synchronized (this) {
                                                                                                                        var2_2 = this.F;
                                                                                                                        this.F = var4_3 = 0L;
                                                                                                                        var6_4 = this.G;
                                                                                                                        this.G = var4_3;
                                                                                                                    }
                                                                                                                    var8_5 /* !! */  = this.n;
                                                                                                                    var9_6 = this.s;
                                                                                                                    var10_7 = this.x;
                                                                                                                    var11_8 /* !! */  = this.l;
                                                                                                                    var12_9 = this.u;
                                                                                                                    var13_10 = 167819264L;
                                                                                                                    var15_11 = var2_2 & var13_10;
                                                                                                                    var17_12 = var15_11 == var4_3 ? 0 : (var15_11 < var4_3 ? -1 : 1);
                                                                                                                    if (var17_12 == false) ** GOTO lbl-1000
                                                                                                                    if (var8_5 /* !! */  != null) {
                                                                                                                        var18_13 /* !! */  = var8_5 /* !! */ .u();
                                                                                                                    } else {
                                                                                                                        var17_12 = 0;
                                                                                                                        var19_14 = 0.0f;
                                                                                                                        var18_13 /* !! */  = null;
                                                                                                                    }
                                                                                                                    var20_15 = 12;
                                                                                                                    var21_16 = 1.7E-44f;
                                                                                                                    var1_1.updateLiveDataRegistration(var20_15, var18_13 /* !! */ );
                                                                                                                    if (var18_13 /* !! */  != null) {
                                                                                                                        var18_13 /* !! */  = (CameraSet$StoryState)var18_13 /* !! */ .getValue();
                                                                                                                    } else lbl-1000:
                                                                                                                    // 2 sources

                                                                                                                    {
                                                                                                                        var17_12 = 0;
                                                                                                                        var19_14 = 0.0f;
                                                                                                                        var18_13 /* !! */  = null;
                                                                                                                    }
                                                                                                                    var20_15 = (int)((cfr_temp_0 = (var2_2 & 180363555L) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                                                                                                    var22_17 = 146800897L;
                                                                                                                    var24_18 = 128L;
                                                                                                                    var26_19 = 138412288L;
                                                                                                                    var28_20 = 171974912L;
                                                                                                                    var30_21 = 8;
                                                                                                                    var31_22 = 1.1E-44f;
                                                                                                                    var32_23 = 1;
                                                                                                                    if (var20_15 == 0) break block254;
                                                                                                                    if (var9_6 != null) {
                                                                                                                        var33_24 = var9_6.c;
                                                                                                                    } else {
                                                                                                                        var34_25 = 0;
                                                                                                                        var33_24 = null;
                                                                                                                    }
                                                                                                                    var1_1.updateLiveDataRegistration(var30_21, (LiveData)var33_24);
                                                                                                                    if (var33_24 != null) {
                                                                                                                        var33_24 = (Boolean)var33_24.getValue();
                                                                                                                    } else {
                                                                                                                        var34_25 = 0;
                                                                                                                        var33_24 = null;
                                                                                                                    }
                                                                                                                    var34_25 = ViewDataBinding.safeUnbox((Boolean)var33_24) ^ var32_23;
                                                                                                                    var35_26 = var2_2 & var26_19;
                                                                                                                    var37_27 = 0L;
                                                                                                                    var39_28 = var35_26 == var37_27 ? 0 : (var35_26 < var37_27 ? -1 : 1);
                                                                                                                    if (var39_28 != 0) {
                                                                                                                        var35_26 = var34_25 != 0 ? 0x200000000000L : 0x100000000000L;
                                                                                                                        var2_2 |= var35_26;
                                                                                                                    }
                                                                                                                    if ((var39_28 = (cfr_temp_1 = (var35_26 = var2_2 & var28_20) - var37_27) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != 0) {
                                                                                                                        if (var34_25 != 0) {
                                                                                                                            var2_2 |= 0x800000000000L;
                                                                                                                            var35_26 = 524288L;
                                                                                                                        } else {
                                                                                                                            var2_2 |= 0x400000000000L;
                                                                                                                            var35_26 = 262144L;
                                                                                                                        }
                                                                                                                        var6_4 |= var35_26;
                                                                                                                    }
                                                                                                                    if ((var39_28 = (cfr_temp_2 = (var35_26 = var2_2 & var22_17) - (var37_27 = 0L)) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != 0) {
                                                                                                                        var35_26 = var34_25 != 0 ? 0x8000000000000L : 0x4000000000000L;
                                                                                                                        var2_2 |= var35_26;
                                                                                                                    }
                                                                                                                    if ((var39_28 = (cfr_temp_3 = (var35_26 = var2_2 & 171974914L) - (var37_27 = 0L)) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != 0) {
                                                                                                                        if (var34_25 != 0) {
                                                                                                                            var6_4 |= var24_18;
                                                                                                                        } else {
                                                                                                                            var35_26 = 64;
                                                                                                                            var6_4 |= var35_26;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    if ((var39_28 = (cfr_temp_4 = (var35_26 = var2_2 & 171974944L) - var37_27) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) != 0) {
                                                                                                                        var35_26 = var34_25 != 0 ? 131072L : 65536L;
                                                                                                                        var6_4 |= var35_26;
                                                                                                                    }
                                                                                                                    if ((var39_28 = (cfr_temp_5 = (var35_26 = var2_2 & var26_19) - var37_27) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1)) == 0 || var34_25 != 0) break block255;
                                                                                                                    var39_28 = 4;
                                                                                                                    var40_29 = 5.6E-45f;
                                                                                                                    break block256;
                                                                                                                }
                                                                                                                var37_27 = 0L;
                                                                                                                var34_25 = 0;
                                                                                                                var33_24 = null;
                                                                                                            }
                                                                                                            var39_28 = 0;
                                                                                                            var40_29 = 0.0f;
                                                                                                            var9_6 = null;
                                                                                                        }
                                                                                                        var20_15 = (int)((cfr_temp_6 = (var2_2 & 234929916L) - var37_27) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1));
                                                                                                        var35_26 = 0x400000000000000L;
                                                                                                        var41_30 = 0xA000044L;
                                                                                                        var43_31 = 0xA000004L;
                                                                                                        var45_32 = 234889348L;
                                                                                                        var47_33 = 1053609165;
                                                                                                        var48_34 = 0.4f;
                                                                                                        var49_35 = 1065353216;
                                                                                                        var50_36 = 1.0f;
                                                                                                        var51_37 = 0x8000000L;
                                                                                                        var53_38 = 167780356L;
                                                                                                        if (var20_15 == 0) break block257;
                                                                                                        var55_39 = var2_2 & 167780420L;
                                                                                                        var37_27 = 0L;
                                                                                                        cfr_temp_7 = var55_39 - var37_27;
                                                                                                        var20_15 = (int)(cfr_temp_7 == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1));
                                                                                                        if (var20_15 == 0) break block258;
                                                                                                        if (var11_8 /* !! */  != null) {
                                                                                                            var57_40 = var11_8 /* !! */ .K();
                                                                                                        } else {
                                                                                                            var20_15 = 0;
                                                                                                            var21_16 = 0.0f;
                                                                                                            var57_40 = null;
                                                                                                        }
                                                                                                        var58_41 = 2;
                                                                                                        var59_42 = 2.8E-45f;
                                                                                                        var1_1.updateLiveDataRegistration(var58_41, (LiveData)var57_40);
                                                                                                        if (var57_40 != null) {
                                                                                                            var60_43 /* !! */  = (Boolean)var57_40.getValue();
                                                                                                        } else {
                                                                                                            var58_41 = 0;
                                                                                                            var59_42 = 0.0f;
                                                                                                            var60_43 /* !! */  = null;
                                                                                                        }
                                                                                                        var61_44 = ViewDataBinding.safeUnbox(var60_43 /* !! */ );
                                                                                                        var62_45 = var2_2 & var43_31;
                                                                                                        var37_27 = 0L;
                                                                                                        var64_46 = var62_45 == var37_27 ? 0 : (var62_45 < var37_27 ? -1 : 1);
                                                                                                        if (var64_46 != 0) {
                                                                                                            if (var61_44 != 0) {
                                                                                                                var2_2 |= 0x2000000000000L;
                                                                                                                var62_45 = 0x800000L;
                                                                                                            } else {
                                                                                                                var2_2 |= 0x1000000000000L;
                                                                                                                var62_45 = 0x400000L;
                                                                                                            }
                                                                                                            var6_4 |= var62_45;
                                                                                                        }
                                                                                                        if ((var64_46 = (int)((cfr_temp_8 = (var62_45 = var2_2 & var41_30) - (var37_27 = 0L)) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1))) != 0) {
                                                                                                            if (var61_44 != 0) {
                                                                                                                var62_45 = 0x800000000000000L;
                                                                                                                var2_2 |= var62_45;
                                                                                                            } else {
                                                                                                                var2_2 |= var35_26;
                                                                                                            }
                                                                                                        }
                                                                                                        if ((var64_46 = (int)((cfr_temp_9 = (var62_45 = var2_2 & var53_38) - var37_27) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1))) != 0) {
                                                                                                            if (var61_44 != 0) {
                                                                                                                var6_4 |= var51_37;
                                                                                                            } else {
                                                                                                                var62_45 = 0x4000000L;
                                                                                                                var6_4 |= var62_45;
                                                                                                            }
                                                                                                        }
                                                                                                        if ((var64_46 = (int)((cfr_temp_10 = (var62_45 = var2_2 & var43_31) - var37_27) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1))) == 0) break block259;
                                                                                                        if (var61_44 != 0) {
                                                                                                            var64_46 = var47_33;
                                                                                                            var65_47 = var48_34;
                                                                                                        } else {
                                                                                                            var64_46 = var49_35;
                                                                                                            var65_47 = var50_36;
                                                                                                        }
                                                                                                        var66_48 = var61_44 ^ 1;
                                                                                                        break block260;
                                                                                                    }
                                                                                                    var64_46 = 0;
                                                                                                    var65_47 = 0.0f;
                                                                                                    break block261;
                                                                                                }
                                                                                                var64_46 = 0;
                                                                                                var65_47 = 0.0f;
                                                                                                var58_41 = 0;
                                                                                                var59_42 = 0.0f;
                                                                                                var60_43 /* !! */  = null;
                                                                                                var20_15 = 0;
                                                                                                var21_16 = 0.0f;
                                                                                                var57_40 = null;
                                                                                                var61_44 = 0;
                                                                                                var67_50 /* !! */  = null;
                                                                                            }
                                                                                            var66_48 = 0;
                                                                                            var68_51 = null;
                                                                                        }
                                                                                        var69_52 = var2_2 & 0xA000008L;
                                                                                        var37_27 = 0L;
                                                                                        var71_53 = var69_52 == var37_27 ? 0 : (var69_52 < var37_27 ? -1 : 1);
                                                                                        if (var71_53 != false) {
                                                                                            if (var11_8 /* !! */  != null) {
                                                                                                var72_54 = var11_8 /* !! */ .h0();
                                                                                                var73_55 = var72_54;
                                                                                            } else {
                                                                                                var32_23 = 0;
                                                                                                var73_55 = null;
                                                                                            }
                                                                                            var30_21 = 3;
                                                                                            var31_22 = 4.2E-45f;
                                                                                            var1_1.updateLiveDataRegistration(var30_21, (LiveData)var73_55);
                                                                                            if (var73_55 != null) {
                                                                                                var73_55 = (Boolean)var73_55.getValue();
                                                                                            } else {
                                                                                                var32_23 = 0;
                                                                                                var73_55 = null;
                                                                                            }
                                                                                            var32_23 = ViewDataBinding.safeUnbox((Boolean)var73_55);
                                                                                            if (var71_53 != false) {
                                                                                                var74_56 = var32_23 != 0 ? 0x80000000000000L : 0x40000000000000L;
                                                                                                var2_2 |= var74_56;
                                                                                            }
                                                                                            if (var32_23 != 0) {
                                                                                                var73_55 = var1_1.e.getContext();
                                                                                                var30_21 = 2131231389;
                                                                                                var31_22 = 1.8078858E38f;
                                                                                            } else {
                                                                                                var73_55 = var1_1.e.getContext();
                                                                                                var30_21 = 2131231387;
                                                                                                var31_22 = 1.8078854E38f;
                                                                                            }
                                                                                            var73_55 = AppCompatResources.getDrawable((Context)var73_55, var30_21);
                                                                                        } else {
                                                                                            var32_23 = 0;
                                                                                            var73_55 = null;
                                                                                        }
                                                                                        var74_56 = var2_2 & 0xA000010L;
                                                                                        var37_27 = 0L;
                                                                                        var30_21 = (int)(var74_56 == var37_27 ? 0 : (var74_56 < var37_27 ? -1 : 1));
                                                                                        if (var30_21 != 0) {
                                                                                            if (var11_8 /* !! */  != null) {
                                                                                                var76_57 = var11_8 /* !! */ .c0();
                                                                                                var77_58 = var60_43 /* !! */ ;
                                                                                                var58_41 = 4;
                                                                                                var59_42 = 5.6E-45f;
                                                                                            } else {
                                                                                                var77_58 = var60_43 /* !! */ ;
                                                                                                var58_41 = 4;
                                                                                                var59_42 = 5.6E-45f;
                                                                                                var30_21 = 0;
                                                                                                var31_22 = 0.0f;
                                                                                                var76_57 = null;
                                                                                            }
                                                                                            var1_1.updateLiveDataRegistration(var58_41, (LiveData)var76_57);
                                                                                            if (var76_57 != null) {
                                                                                                var76_57 = (Integer)var76_57.getValue();
                                                                                            } else {
                                                                                                var30_21 = 0;
                                                                                                var31_22 = 0.0f;
                                                                                                var76_57 = null;
                                                                                            }
                                                                                            var30_21 = ViewDataBinding.safeUnbox((Integer)var76_57);
                                                                                            var78_59 = this.getRoot();
                                                                                            var60_43 /* !! */  = d.v.f.i.g.f(var78_59.getContext(), var30_21);
                                                                                        } else {
                                                                                            var77_58 = var60_43 /* !! */ ;
                                                                                            var58_41 = 0;
                                                                                            var59_42 = 0.0f;
                                                                                            var60_43 /* !! */  = null;
                                                                                        }
                                                                                        var79_61 = var2_2 & 0xA000020L;
                                                                                        var37_27 = 0L;
                                                                                        var30_21 = (int)(var79_61 == var37_27 ? 0 : (var79_61 < var37_27 ? -1 : 1));
                                                                                        if (var30_21 != 0) {
                                                                                            if (var11_8 /* !! */  != null) {
                                                                                                var76_57 = var11_8 /* !! */ .k0();
                                                                                                var78_59 = var60_43 /* !! */ ;
                                                                                            } else {
                                                                                                var78_59 = var60_43 /* !! */ ;
                                                                                                var30_21 = 0;
                                                                                                var31_22 = 0.0f;
                                                                                                var76_57 = null;
                                                                                            }
                                                                                            var58_41 = 5;
                                                                                            var59_42 = 7.0E-45f;
                                                                                            var1_1.updateLiveDataRegistration(var58_41, (LiveData)var76_57);
                                                                                            if (var76_57 != null) {
                                                                                                var60_43 /* !! */  = (CameraSet$Panorama)var76_57.getValue();
                                                                                            } else {
                                                                                                var58_41 = 0;
                                                                                                var59_42 = 0.0f;
                                                                                                var60_43 /* !! */  = null;
                                                                                            }
                                                                                            if (var60_43 /* !! */  != null) {
                                                                                                var82_63 = var81_62 = var60_43 /* !! */ .getDrawableRes();
                                                                                                var83_64 /* !! */  = var60_43 /* !! */ ;
                                                                                                var58_41 = var81_62;
                                                                                            } else {
                                                                                                var83_64 /* !! */  = var60_43 /* !! */ ;
                                                                                                var58_41 = 0;
                                                                                                var59_42 = 0.0f;
                                                                                                var60_43 /* !! */  = null;
                                                                                            }
                                                                                            var84_65 = this.getRoot();
                                                                                            var85_66 = var73_55;
                                                                                            var73_55 = d.v.f.i.g.f(var84_65.getContext(), var58_41);
                                                                                            var60_43 /* !! */  = var83_64 /* !! */ ;
                                                                                        } else {
                                                                                            var78_59 = var60_43 /* !! */ ;
                                                                                            var85_66 = var73_55;
                                                                                            var58_41 = 0;
                                                                                            var59_42 = 0.0f;
                                                                                            var60_43 /* !! */  = null;
                                                                                            var32_23 = 0;
                                                                                            var73_55 = null;
                                                                                            var30_21 = 0;
                                                                                            var31_22 = 0.0f;
                                                                                            var76_57 = null;
                                                                                        }
                                                                                        var79_61 = var2_2 & 234929796L;
                                                                                        var37_27 = 0L;
                                                                                        var81_62 = (int)(var79_61 == var37_27 ? 0 : (var79_61 < var37_27 ? -1 : 1));
                                                                                        if (var81_62 == 0) break block262;
                                                                                        if (var11_8 /* !! */  != null) {
                                                                                            var83_64 /* !! */  = var11_8 /* !! */ .H();
                                                                                            var84_65 = var73_55;
                                                                                            var32_23 = 13;
                                                                                            var86_68 = var83_64 /* !! */ ;
                                                                                            var83_64 /* !! */  = var60_43 /* !! */ ;
                                                                                            var60_43 /* !! */  = var86_68;
                                                                                        } else {
                                                                                            var83_64 /* !! */  = var60_43 /* !! */ ;
                                                                                            var84_65 = var73_55;
                                                                                            var58_41 = 0;
                                                                                            var59_42 = 0.0f;
                                                                                            var60_43 /* !! */  = null;
                                                                                            var32_23 = 13;
                                                                                        }
                                                                                        var1_1.updateLiveDataRegistration(var32_23, (LiveData)var60_43 /* !! */ );
                                                                                        if (var60_43 /* !! */  != null) {
                                                                                            var73_55 = (CameraSet$Mode)var60_43 /* !! */ .getValue();
                                                                                        } else {
                                                                                            var32_23 = 0;
                                                                                            var73_55 = null;
                                                                                        }
                                                                                        var87_69 = var2_2 & var53_38;
                                                                                        var37_27 = 0L;
                                                                                        var89_70 = (int)(var87_69 == var37_27 ? 0 : (var87_69 < var37_27 ? -1 : 1));
                                                                                        var90_71 = var60_43 /* !! */ ;
                                                                                        if (var89_70 != 0) {
                                                                                            var60_43 /* !! */  = CameraSet$Mode.slow_motion;
                                                                                            if (var60_43 /* !! */  == var73_55) {
                                                                                                var58_41 = 1;
                                                                                                var59_42 = 1.4E-45f;
                                                                                            } else {
                                                                                                var58_41 = 0;
                                                                                                var59_42 = 0.0f;
                                                                                                var60_43 /* !! */  = null;
                                                                                            }
                                                                                            if (var89_70 != 0) {
                                                                                                if (var58_41 != 0) {
                                                                                                    var2_2 |= 0x2000000000L;
                                                                                                    var91_72 = 8;
                                                                                                } else {
                                                                                                    var2_2 |= 0x1000000000L;
                                                                                                    var91_72 = 4;
                                                                                                }
                                                                                                var6_4 |= var91_72;
                                                                                            }
                                                                                        } else {
                                                                                            var58_41 = 0;
                                                                                            var59_42 = 0.0f;
                                                                                            var60_43 /* !! */  = null;
                                                                                        }
                                                                                        if ((var89_70 = (int)((cfr_temp_11 = (var91_72 = var2_2 & 0xA002000L) - (var37_27 = 0L)) == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1))) != 0) {
                                                                                            if (var73_55 != null) {
                                                                                                var82_63 = var73_55.getActionDrawableRes();
                                                                                                var89_70 = var58_41;
                                                                                                var93_73 = var59_42;
                                                                                                var58_41 = var82_63;
                                                                                            } else {
                                                                                                var89_70 = var58_41;
                                                                                                var93_73 = var59_42;
                                                                                                var58_41 = 0;
                                                                                                var59_42 = 0.0f;
                                                                                                var60_43 /* !! */  = null;
                                                                                            }
                                                                                            var94_74 = this.getRoot();
                                                                                            var95_77 = var76_57;
                                                                                            var76_57 = var94_74.getContext();
                                                                                            var60_43 /* !! */  = d.v.f.i.g.f((Context)var76_57, var58_41);
                                                                                        } else {
                                                                                            var89_70 = var58_41;
                                                                                            var93_73 = var59_42;
                                                                                            var95_77 = var76_57;
                                                                                            var58_41 = 0;
                                                                                            var59_42 = 0.0f;
                                                                                            var60_43 /* !! */  = null;
                                                                                        }
                                                                                        var96_78 = 167819264L;
                                                                                        var98_79 = var2_2 & var96_78;
                                                                                        var37_27 = 0L;
                                                                                        var30_21 = (int)(var98_79 == var37_27 ? 0 : (var98_79 < var37_27 ? -1 : 1));
                                                                                        if (var30_21 == 0) break block263;
                                                                                        if (var8_5 /* !! */  != null) {
                                                                                            var100_80 = var8_5 /* !! */ .K((CameraSet$Mode)var73_55, (CameraSet$StoryState)var18_13 /* !! */ );
                                                                                        } else {
                                                                                            var100_80 = 0;
                                                                                            var8_5 /* !! */  = null;
                                                                                        }
                                                                                        var101_81 = 0xA00B000L & var2_2;
                                                                                        var30_21 = (int)(var101_81 == var37_27 ? 0 : (var101_81 < var37_27 ? -1 : 1));
                                                                                        if (var30_21 != 0) {
                                                                                            var101_81 = var100_80 != 0 ? 0x8000000000L : 0x4000000000L;
                                                                                            var2_2 |= var101_81;
                                                                                        }
                                                                                        if ((var30_21 = (int)((cfr_temp_12 = (var98_79 = var2_2 & (var101_81 = 167819264L)) - var37_27) == 0L ? 0 : (cfr_temp_12 < 0L ? -1 : 1))) != 0) {
                                                                                            var101_81 = var100_80 != 0 ? 512L : 256L;
                                                                                            var6_4 |= var101_81;
                                                                                        }
                                                                                        if ((var30_21 = (int)((cfr_temp_13 = (var101_81 = 0xA00B000L & var2_2) - (var37_27 = 0L)) == 0L ? 0 : (cfr_temp_13 < 0L ? -1 : 1))) == 0 || var100_80 == 0) break block264;
                                                                                        var30_21 = 10;
                                                                                        var31_22 = 1.4E-44f;
                                                                                        break block265;
                                                                                    }
                                                                                    var100_80 = 0;
                                                                                    var8_5 /* !! */  = null;
                                                                                }
                                                                                var30_21 = 0;
                                                                                var31_22 = 0.0f;
                                                                                var76_57 = null;
                                                                            }
                                                                            var98_79 = var2_2 & 167781888L;
                                                                            var17_12 = var98_79 == var37_27 ? 0 : (var98_79 < var37_27 ? -1 : 1);
                                                                            var103_82 = var100_80;
                                                                            if (var17_12 != false) {
                                                                                var8_5 /* !! */  = CameraSet$Mode.panorama;
                                                                                if (var73_55 == var8_5 /* !! */ ) {
                                                                                    var100_80 = 1;
                                                                                } else {
                                                                                    var100_80 = 0;
                                                                                    var8_5 /* !! */  = null;
                                                                                }
                                                                                if (var17_12 != false) {
                                                                                    var98_79 = var100_80 != 0 ? 0x200000L : 0x100000L;
                                                                                    var6_4 |= var98_79;
                                                                                }
                                                                            } else {
                                                                                var100_80 = 0;
                                                                                var8_5 /* !! */  = null;
                                                                            }
                                                                            if ((var17_12 = (cfr_temp_14 = (var98_79 = var2_2 & var45_32) - (var37_27 = 0L)) == 0L ? 0 : (cfr_temp_14 < 0L ? -1 : 1)) != false) {
                                                                                var18_13 /* !! */  = CameraSet$Mode.live;
                                                                                if (var18_13 /* !! */  == var73_55) {
                                                                                    var17_12 = 1;
                                                                                    var19_14 = 1.4E-45f;
                                                                                } else {
                                                                                    var17_12 = 0;
                                                                                    var19_14 = 0.0f;
                                                                                    var18_13 /* !! */  = null;
                                                                                }
                                                                                var104_83 = var6_4;
                                                                                var106_84 /* !! */  = var60_43 /* !! */ ;
                                                                                var107_85 = var78_59;
                                                                                var58_41 = var89_70;
                                                                                var59_42 = var93_73;
                                                                                var89_70 = (int)var17_12;
                                                                                var93_73 = var19_14;
                                                                                var71_53 = var61_44;
                                                                                var17_12 = var66_48;
                                                                                var67_50 /* !! */  = var73_55;
                                                                                var68_51 = var57_40;
                                                                                var57_40 = var85_66;
                                                                                var108_86 = var64_46;
                                                                                var109_87 = var65_47;
                                                                                var64_46 = var39_28;
                                                                                var65_47 = var40_29;
                                                                                var39_28 = var30_21;
                                                                                var40_29 = var31_22;
                                                                            } else {
                                                                                var17_12 = var66_48;
                                                                                var68_51 = var57_40;
                                                                                var57_40 = var85_66;
                                                                                var108_86 = var64_46;
                                                                                var109_87 = var65_47;
                                                                                var64_46 = var39_28;
                                                                                var65_47 = var40_29;
                                                                                var39_28 = var30_21;
                                                                                var40_29 = var31_22;
                                                                                var104_83 = var6_4;
                                                                                var106_84 /* !! */  = var60_43 /* !! */ ;
                                                                                var107_85 = var78_59;
                                                                                var58_41 = var89_70;
                                                                                var59_42 = var93_73;
                                                                                var89_70 = 0;
                                                                                var93_73 = 0.0f;
                                                                                var71_53 = var61_44;
                                                                                var67_50 /* !! */  = var73_55;
                                                                            }
                                                                            var13_10 = var104_83;
                                                                            break block266;
                                                                        }
                                                                        var83_64 /* !! */  = var60_43 /* !! */ ;
                                                                        var84_65 = var73_55;
                                                                        var95_77 = var76_57;
                                                                        var37_27 = 0L;
                                                                        var13_10 = var6_4;
                                                                        var17_12 = var66_48;
                                                                        var107_85 = var78_59;
                                                                        var100_80 = 0;
                                                                        var8_5 /* !! */  = null;
                                                                        var58_41 = 0;
                                                                        var59_42 = 0.0f;
                                                                        var60_43 /* !! */  = null;
                                                                        var110_88 = 0;
                                                                        var106_84 /* !! */  = null;
                                                                        var89_70 = 0;
                                                                        var93_73 = 0.0f;
                                                                        var90_71 = null;
                                                                        var103_82 = 0;
                                                                        var94_75 = null;
                                                                        var68_51 = var57_40;
                                                                        var71_53 = var61_44;
                                                                        var57_40 = var85_66;
                                                                        var61_44 = 0;
                                                                        var67_50 /* !! */  = null;
                                                                        var108_86 = var64_46;
                                                                        var109_87 = var65_47;
                                                                        var64_46 = var39_28;
                                                                        var65_47 = var40_29;
                                                                        var39_28 = 0;
                                                                        var40_29 = 0.0f;
                                                                        var9_6 = null;
                                                                        break block266;
                                                                    }
                                                                    var37_27 = 0L;
                                                                    var13_10 = var6_4;
                                                                    var64_46 = var39_28;
                                                                    var65_47 = var40_29;
                                                                    var108_86 = 0;
                                                                    var85_67 = null;
                                                                    var109_87 = 0.0f;
                                                                    var100_80 = 0;
                                                                    var8_5 /* !! */  = null;
                                                                    var58_41 = 0;
                                                                    var59_42 = 0.0f;
                                                                    var60_43 /* !! */  = null;
                                                                    var110_88 = 0;
                                                                    var106_84 /* !! */  = null;
                                                                    var111_89 = 0;
                                                                    var112_90 = 0.0f;
                                                                    var107_85 = null;
                                                                    var39_28 = 0;
                                                                    var40_29 = 0.0f;
                                                                    var9_6 = null;
                                                                    var17_12 = 0;
                                                                    var19_14 = 0.0f;
                                                                    var18_13 /* !! */  = null;
                                                                    var20_15 = 0;
                                                                    var21_16 = 0.0f;
                                                                    var57_40 = null;
                                                                    var77_58 = null;
                                                                    var61_44 = 0;
                                                                    var67_50 /* !! */  = null;
                                                                    var66_49 = false;
                                                                    var68_51 = null;
                                                                    var71_53 = 0;
                                                                    var78_60 = null;
                                                                    var81_62 = 0;
                                                                    var113_91 = 0.0f;
                                                                    var83_64 /* !! */  = null;
                                                                    var84_65 = null;
                                                                    var89_70 = 0;
                                                                    var93_73 = 0.0f;
                                                                    var90_71 = null;
                                                                    var103_82 = 0;
                                                                    var94_76 = null;
                                                                    var114_92 = 0;
                                                                    var95_77 = null;
                                                                }
                                                                var98_79 = var2_2 & var45_32;
                                                                var115_93 = var98_79 == var37_27 ? 0 : (var98_79 < var37_27 ? -1 : 1);
                                                                if (var115_93 != false) {
                                                                    if (var12_9 != null) {
                                                                        var12_9 = var12_9.a0();
                                                                        var116_94 = var17_12;
                                                                    } else {
                                                                        var116_94 = var17_12;
                                                                        var117_95 = 0;
                                                                        var118_96 = 0.0f;
                                                                        var12_9 = null;
                                                                    }
                                                                    var17_12 = 7;
                                                                    var19_14 = 9.8E-45f;
                                                                    var1_1.updateLiveDataRegistration((int)var17_12, (LiveData)var12_9);
                                                                    if (var12_9 != null) {
                                                                        var12_9 = (Integer)var12_9.getValue();
                                                                    } else {
                                                                        var117_95 = 0;
                                                                        var118_96 = 0.0f;
                                                                        var12_9 = null;
                                                                    }
                                                                    var117_95 = ViewDataBinding.safeUnbox((Integer)var12_9);
                                                                    var17_12 = 1;
                                                                    var19_14 = 1.4E-45f;
                                                                    if (var117_95 == var17_12) {
                                                                        var117_95 = 1;
                                                                        var118_96 = 1.4E-45f;
                                                                    } else {
                                                                        var117_95 = 0;
                                                                        var118_96 = 0.0f;
                                                                        var12_9 = null;
                                                                    }
                                                                    var117_95 &= var89_70;
                                                                    if (var115_93 != false) {
                                                                        var119_97 = var117_95 != 0 ? 0x80000000000L : 0x40000000000L;
                                                                        var2_2 |= var119_97;
                                                                    }
                                                                } else {
                                                                    var116_94 = var17_12;
                                                                    var117_95 = 0;
                                                                    var118_96 = 0.0f;
                                                                    var12_9 = null;
                                                                }
                                                                if ((var17_12 = (cfr_temp_15 = (var119_97 = var2_2 & var53_38) - (var37_27 = 0L)) == 0L ? 0 : (cfr_temp_15 < 0L ? -1 : 1)) != false) {
                                                                    if (var58_41 != 0) {
                                                                        var89_70 = 1;
                                                                        var93_73 = 1.4E-45f;
                                                                    }
                                                                    if (var17_12 != false) {
                                                                        var119_97 = var89_70 != 0 ? 0x20000000000000L : 0x10000000000000L;
                                                                        var2_2 |= var119_97;
                                                                    }
                                                                } else {
                                                                    var89_70 = 0;
                                                                    var93_73 = 0.0f;
                                                                }
                                                                if ((var17_12 = (cfr_temp_16 = (var119_97 = var2_2 & 0x8000000000000L) - (var37_27 = 0L)) == 0L ? 0 : (cfr_temp_16 < 0L ? -1 : 1)) != false) {
                                                                    if (var10_7 != null) {
                                                                        var10_7 = var10_7.e;
                                                                    } else {
                                                                        var121_98 = 0;
                                                                        var10_7 = null;
                                                                    }
                                                                    var17_12 = 0;
                                                                    var19_14 = 0.0f;
                                                                    var18_13 /* !! */  = null;
                                                                    var1_1.updateLiveDataRegistration(0, (LiveData)var10_7);
                                                                    if (var10_7 != null) {
                                                                        var10_7 = (Boolean)var10_7.getValue();
                                                                    } else {
                                                                        var121_98 = 0;
                                                                        var10_7 = null;
                                                                    }
                                                                    var121_98 = ViewDataBinding.safeUnbox((Boolean)var10_7);
                                                                    var122_99 /* !! */  = 1;
                                                                    var121_98 ^= 1;
                                                                } else {
                                                                    var17_12 = 0;
                                                                    var19_14 = 0.0f;
                                                                    var18_13 /* !! */  = null;
                                                                    var121_98 = 0;
                                                                    var10_7 = null;
                                                                }
                                                                var119_97 = var2_2 & 0x840000000000L;
                                                                var37_27 = 0L;
                                                                var122_99 /* !! */  = var119_97 == var37_27 ? 0 : (var119_97 < var37_27 ? -1 : 1);
                                                                if (var122_99 /* !! */  != false || (var122_99 /* !! */  = (cfr_temp_17 = (var119_97 = var13_10 & 3801476L) - var37_27) == 0L ? 0 : (cfr_temp_17 < 0L ? -1 : 1)) != false) break block267;
                                                                var68_51 = var107_85;
                                                                var81_62 = var39_28;
                                                                var113_91 = var40_29;
                                                                var123_100 = var121_98;
                                                                var77_58 = var57_40;
                                                                var111_89 = 0;
                                                                var112_90 = 0.0f;
                                                                var107_85 = null;
                                                                var39_28 = 0;
                                                                var40_29 = 0.0f;
                                                                var9_6 = null;
                                                                var121_98 = 0;
                                                                var10_7 = null;
                                                                var17_12 = 0;
                                                                var19_14 = 0.0f;
                                                                var18_13 /* !! */  = null;
                                                                var20_15 = 0;
                                                                var21_16 = 0.0f;
                                                                var57_40 = null;
                                                                var124_101 = 0;
                                                                var125_102 = 0.0f;
                                                                var126_103 /* !! */  = null;
                                                                var114_92 = 0;
                                                                var95_77 = null;
                                                                break block268;
                                                            }
                                                            var119_97 = var13_10 & var24_18;
                                                            cfr_temp_18 = var119_97 - var37_27;
                                                            var122_99 /* !! */  = (long)(cfr_temp_18 == 0L ? 0 : (cfr_temp_18 < 0L ? -1 : 1));
                                                            if (var122_99 /* !! */  == false) break block269;
                                                            if (var11_8 /* !! */  != null) {
                                                                var127_104 = var11_8 /* !! */ .J();
                                                                var123_100 = var121_98;
                                                                var18_13 /* !! */  = var127_104;
                                                                var121_98 = 1;
                                                            } else {
                                                                var123_100 = var121_98;
                                                                var121_98 = 1;
                                                                var17_12 = 0;
                                                                var19_14 = 0.0f;
                                                                var18_13 /* !! */  = null;
                                                            }
                                                            var1_1.updateLiveDataRegistration(var121_98, var18_13 /* !! */ );
                                                            if (var18_13 /* !! */  != null) {
                                                                var10_7 = (CameraParam)var18_13 /* !! */ .getValue();
                                                            } else {
                                                                var121_98 = 0;
                                                                var10_7 = null;
                                                            }
                                                            if (var10_7 == null) break block270;
                                                            var10_7 = var10_7.getVideoResolution();
                                                            break block271;
                                                        }
                                                        var123_100 = var121_98;
                                                    }
                                                    var121_98 = 0;
                                                    var10_7 = null;
                                                }
                                                var128_105 = var2_2 & 0x40000000000L;
                                                var37_27 = 0L;
                                                var17_12 = var128_105 == var37_27 ? 0 : (var128_105 < var37_27 ? -1 : 1);
                                                if (var17_12 == false && (var17_12 = (cfr_temp_19 = (var128_105 = var13_10 & (long)4) - var37_27) == 0L ? 0 : (cfr_temp_19 < 0L ? -1 : 1)) == false) {
                                                    var68_51 = var107_85;
                                                    var130_106 = 0L;
                                                } else {
                                                    if (var11_8 /* !! */  != null) {
                                                        var68_51 = var11_8 /* !! */ .K();
                                                    }
                                                    var18_13 /* !! */  = var68_51;
                                                    var68_51 = var107_85;
                                                    var111_89 = 2;
                                                    var112_90 = 2.8E-45f;
                                                    var1_1.updateLiveDataRegistration(var111_89, var18_13 /* !! */ );
                                                    if (var18_13 /* !! */  != null) {
                                                        var77_58 = var107_85 = var18_13 /* !! */ .getValue();
                                                        var77_58 = (Boolean)var107_85;
                                                    }
                                                    var71_53 = (long)ViewDataBinding.safeUnbox((Boolean)var77_58);
                                                    var128_105 = var2_2 & var43_31;
                                                    var130_106 = 0L;
                                                    cfr_temp_20 = var128_105 - var130_106;
                                                    var111_89 = (int)(cfr_temp_20 == 0L ? 0 : (cfr_temp_20 < 0L ? -1 : 1));
                                                    if (var111_89 != 0) {
                                                        if (var71_53 != false) {
                                                            var2_2 |= 0x2000000000000L;
                                                            var128_105 = 0x800000L;
                                                        } else {
                                                            var2_2 |= 0x1000000000000L;
                                                            var128_105 = 0x400000L;
                                                        }
                                                        var13_10 |= var128_105;
                                                    }
                                                    if ((var111_89 = (int)((cfr_temp_21 = (var128_105 = var2_2 & var41_30) - (var130_106 = 0L)) == 0L ? 0 : (cfr_temp_21 < 0L ? -1 : 1))) != 0) {
                                                        if (var71_53 != false) {
                                                            var128_105 = 0x800000000000000L;
                                                            var2_2 |= var128_105;
                                                        } else {
                                                            var2_2 |= var35_26;
                                                        }
                                                    }
                                                    if ((var111_89 = (int)((cfr_temp_22 = (var128_105 = var2_2 & var53_38) - var130_106) == 0L ? 0 : (cfr_temp_22 < 0L ? -1 : 1))) != 0) {
                                                        if (var71_53 != false) {
                                                            var13_10 |= var51_37;
                                                        } else {
                                                            var128_105 = 0x4000000L;
                                                            var13_10 |= var128_105;
                                                        }
                                                    }
                                                }
                                                var128_105 = var13_10 & 131072L;
                                                var111_89 = (int)(var128_105 == var130_106 ? 0 : (var128_105 < var130_106 ? -1 : 1));
                                                if (var111_89 != 0) {
                                                    if (var11_8 /* !! */  != null) {
                                                        var95_77 = var11_8 /* !! */ .k0();
                                                    }
                                                    var77_58 = var57_40;
                                                    var18_13 /* !! */  = var95_77;
                                                    var20_15 = 5;
                                                    var21_16 = 7.0E-45f;
                                                    var1_1.updateLiveDataRegistration(var20_15, (LiveData)var95_77);
                                                    if (var95_77 != null) {
                                                        var18_13 /* !! */  = var95_77.getValue();
                                                        var83_64 /* !! */  = var18_13 /* !! */ ;
                                                        var83_64 /* !! */  = (CameraSet$Panorama)var18_13 /* !! */ ;
                                                    }
                                                } else {
                                                    var77_58 = var57_40;
                                                }
                                                var18_13 /* !! */  = var83_64 /* !! */ ;
                                                var128_105 = var13_10 & 0x100000L;
                                                var37_27 = 0L;
                                                cfr_temp_23 = var128_105 - var37_27;
                                                var20_15 = (int)(cfr_temp_23 == 0L ? 0 : (cfr_temp_23 < 0L ? -1 : 1));
                                                if (var20_15 == 0) break block272;
                                                if (var11_8 /* !! */  != null) {
                                                    var57_40 = var11_8 /* !! */ .R();
                                                    var81_62 = var39_28;
                                                    var113_91 = var40_29;
                                                } else {
                                                    var81_62 = var39_28;
                                                    var113_91 = var40_29;
                                                    var20_15 = 0;
                                                    var21_16 = 0.0f;
                                                    var57_40 = null;
                                                }
                                                var39_28 = 9;
                                                var40_29 = 1.3E-44f;
                                                var1_1.updateLiveDataRegistration(var39_28, (LiveData)var57_40);
                                                if (var57_40 != null) {
                                                    var9_6 = (CameraSet$CountDownTime)var57_40.getValue();
                                                } else {
                                                    var39_28 = 0;
                                                    var40_29 = 0.0f;
                                                    var9_6 = null;
                                                }
                                                if (var9_6 == null) break block273;
                                                var39_28 = var9_6.getDrawableRes();
                                                break block274;
                                            }
                                            var81_62 = var39_28;
                                            var113_91 = var40_29;
                                        }
                                        var39_28 = 0;
                                        var40_29 = 0.0f;
                                        var9_6 = null;
                                    }
                                    var128_105 = var13_10 & 0x200000L;
                                    var37_27 = 0L;
                                    var20_15 = (int)(var128_105 == var37_27 ? 0 : (var128_105 < var37_27 ? -1 : 1));
                                    if (var20_15 == 0) break block275;
                                    if (var11_8 /* !! */  != null) {
                                        var57_40 = var11_8 /* !! */ .p0();
                                        var114_92 = var39_28;
                                    } else {
                                        var114_92 = var39_28;
                                        var20_15 = 0;
                                        var21_16 = 0.0f;
                                        var57_40 = null;
                                    }
                                    var39_28 = 10;
                                    var40_29 = 1.4E-44f;
                                    var1_1.updateLiveDataRegistration(var39_28, (LiveData)var57_40);
                                    if (var57_40 != null) {
                                        var9_6 = (CameraSet$CountDownTime)var57_40.getValue();
                                    } else {
                                        var39_28 = 0;
                                        var40_29 = 0.0f;
                                        var9_6 = null;
                                    }
                                    if (var9_6 == null) break block276;
                                    var39_28 = var9_6.getDrawableRes();
                                    break block277;
                                }
                                var114_92 = var39_28;
                            }
                            var39_28 = 0;
                            var40_29 = 0.0f;
                            var9_6 = null;
                        }
                        var128_105 = var13_10 & 256L;
                        var37_27 = 0L;
                        var20_15 = (int)(var128_105 == var37_27 ? 0 : (var128_105 < var37_27 ? -1 : 1));
                        if (var20_15 != 0) {
                            if (var11_8 /* !! */  != null) {
                                var57_40 = var11_8 /* !! */ .w0();
                                var132_107 = var39_28;
                                var39_28 = 11;
                                var40_29 = 1.5E-44f;
                            } else {
                                var132_107 = var39_28;
                                var39_28 = 11;
                                var40_29 = 1.5E-44f;
                                var20_15 = 0;
                                var21_16 = 0.0f;
                                var57_40 = null;
                            }
                            var1_1.updateLiveDataRegistration(var39_28, (LiveData)var57_40);
                            if (var57_40 != null) {
                                var9_6 = (Boolean)var57_40.getValue();
                            } else {
                                var39_28 = 0;
                                var40_29 = 0.0f;
                                var9_6 = null;
                            }
                            var39_28 = (int)ViewDataBinding.safeUnbox((Boolean)var9_6);
                            var20_15 = 1;
                            var21_16 = 1.4E-45f;
                            var39_28 ^= var20_15;
                        } else {
                            var132_107 = var39_28;
                            var39_28 = 0;
                            var40_29 = 0.0f;
                            var9_6 = null;
                        }
                        var133_108 = var2_2 & 0x800000000000L;
                        var37_27 = 0L;
                        var20_15 = (int)(var133_108 == var37_27 ? 0 : (var133_108 < var37_27 ? -1 : 1));
                        if (var20_15 == 0 && (var135_109 = (cfr_temp_24 = (var133_108 = var13_10 & 655488L) - var37_27) == 0L ? 0 : (cfr_temp_24 < 0L ? -1 : 1)) == false) {
                            var20_15 = var39_28;
                            var39_28 = var132_107;
                            var111_89 = 0;
                            var112_90 = 0.0f;
                            var107_85 = null;
                            var121_98 = 0;
                            var10_7 = null;
                            var17_12 = 0;
                            var19_14 = 0.0f;
                            var18_13 /* !! */  = null;
                            var124_101 = 0;
                            var125_102 = 0.0f;
                            var126_103 /* !! */  = null;
                        } else {
                            if (var11_8 /* !! */  != null) {
                                var90_71 = var11_8 /* !! */ .H();
                            }
                            var133_108 = var2_2;
                            var136_110 = var90_71;
                            var137_111 = 13;
                            var1_1.updateLiveDataRegistration(var137_111, (LiveData)var90_71);
                            var138_112 = var90_71 != null ? (CameraSet$Mode)var90_71.getValue() : var67_50 /* !! */ ;
                            var139_113 = var13_10 & 524288L;
                            var37_27 = 0L;
                            var61_44 = (int)(var139_113 == var37_27 ? 0 : (var139_113 < var37_27 ? -1 : 1));
                            if (var61_44 != 0 && var11_8 /* !! */  != null) {
                                var61_44 = (int)var11_8 /* !! */ .X0((CameraSet$Mode)var138_112);
                            } else {
                                var61_44 = 0;
                                var67_50 /* !! */  = null;
                            }
                            var24_18 = var13_10 & var24_18;
                            var124_101 = (int)(var24_18 == var37_27 ? 0 : (var24_18 < var37_27 ? -1 : 1));
                            if (var124_101 != 0 && var11_8 /* !! */  != null) {
                                var121_98 = (int)var11_8 /* !! */ .O0((CameraSet$Mode)var138_112, (k$a)var10_7);
                            } else {
                                var121_98 = 0;
                                var10_7 = null;
                            }
                            if (var111_89 != 0 && var11_8 /* !! */  != null) {
                                var111_89 = (int)var11_8 /* !! */ .Q0((CameraSet$Mode)var138_112, (CameraSet$Panorama)var18_13 /* !! */ );
                            } else {
                                var111_89 = 0;
                                var112_90 = 0.0f;
                                var107_85 = null;
                            }
                            if (var20_15 != 0 && var11_8 /* !! */  != null) {
                                var17_12 = (long)var11_8 /* !! */ .R0((CameraSet$Mode)var138_112);
                                var90_71 = var136_110;
                                var20_15 = var39_28;
                                var124_101 = var61_44;
                                var39_28 = var132_107;
                            } else {
                                var90_71 = var136_110;
                                var20_15 = var39_28;
                                var124_101 = var61_44;
                                var39_28 = var132_107;
                                var17_12 = 0;
                                var19_14 = 0.0f;
                                var18_13 /* !! */  = null;
                            }
                            var67_50 /* !! */  = var138_112;
                            var2_2 = var133_108;
                        }
                    }
                    var128_105 = var2_2 & var45_32;
                    var37_27 = 0L;
                    var141_114 = var128_105 == var37_27 ? 0 : (var128_105 < var37_27 ? -1 : 1);
                    if (var141_114 != false) {
                        if (var117_95 != 0) {
                            var117_95 = 1;
                            var118_96 = 1.4E-45f;
                        } else {
                            var117_95 = (int)var71_53;
                        }
                        if (var141_114 != false) {
                            var128_105 = var117_95 != 0 ? 0x80000000L : 0x40000000L;
                            var2_2 |= var128_105;
                        }
                        if (var117_95 != 0) {
                            var117_95 = var47_33;
                            var118_96 = var48_34;
                        } else {
                            var117_95 = var49_35;
                            var118_96 = var50_36;
                        }
                    } else {
                        var117_95 = 0;
                        var12_9 = null;
                        var118_96 = 0.0f;
                    }
                    var128_105 = var2_2 & var28_20;
                    var37_27 = 0L;
                    var141_114 = var128_105 == var37_27 ? 0 : (var128_105 < var37_27 ? -1 : 1);
                    if (var141_114 != false) {
                        if (var34_25 == 0) {
                            var17_12 = 0;
                            var19_14 = 0.0f;
                            var18_13 /* !! */  = null;
                        }
                        if (var34_25 == 0) {
                            var124_101 = 0;
                            var125_102 = 0.0f;
                            var126_103 /* !! */  = null;
                        }
                        if (var141_114 != false) {
                            var128_105 = var17_12 != false ? 0x800000000L : 0x400000000L;
                            var2_2 |= var128_105;
                        }
                        if ((var141_114 = (cfr_temp_25 = (var128_105 = var2_2 & var28_20) - (var37_27 = 0L)) == 0L ? 0 : (cfr_temp_25 < 0L ? -1 : 1)) != false) {
                            var128_105 = var124_101 != 0 ? 0x2000000L : 0x1000000L;
                            var13_10 |= var128_105;
                        }
                        if (var17_12 != false) {
                            var17_12 = 0;
                            var19_14 = 0.0f;
                            var18_13 /* !! */  = null;
                        } else {
                            var17_12 = 8;
                            var19_14 = 1.1E-44f;
                        }
                        if (var124_101 != 0) {
                            var124_101 = 0;
                            var125_102 = 0.0f;
                            var126_103 /* !! */  = null;
                        } else {
                            var124_101 = 8;
                            var125_102 = 1.1E-44f;
                        }
                        var82_63 = var124_101;
                        var142_115 = var125_102;
                        var124_101 = var111_89;
                        var111_89 = var82_63;
                        var112_90 = var125_102;
                    } else {
                        var124_101 = var111_89;
                        var111_89 = 0;
                        var112_90 = 0.0f;
                        var107_85 = null;
                        var17_12 = 0;
                        var19_14 = 0.0f;
                        var18_13 /* !! */  = null;
                    }
                    var128_105 = var2_2 & var22_17;
                    var37_27 = 0L;
                    var141_114 = var128_105 == var37_27 ? 0 : (var128_105 < var37_27 ? -1 : 1);
                    if (var141_114 != false) {
                        if (var34_25 == 0) {
                            var123_100 = 0;
                        }
                        if (var141_114 != false) {
                            var128_105 = var123_100 != 0 ? 8192L : 4096L;
                            var13_10 |= var128_105;
                        }
                        if (var123_100 != 0) {
                            var143_116 = 0;
                            var144_117 = 0.0f;
                        } else {
                            var143_116 = 4;
                            var144_117 = 5.6E-45f;
                        }
                        var141_114 = var39_28;
                        var39_28 = var143_116;
                        var40_29 = var144_117;
                    } else {
                        var141_114 = var39_28;
                        var39_28 = 0;
                        var40_29 = 0.0f;
                        var9_6 = null;
                    }
                    var119_97 = var2_2 & var53_38;
                    var37_27 = 0L;
                    var143_116 = (int)(var119_97 == var37_27 ? 0 : (var119_97 < var37_27 ? -1 : 1));
                    if (var143_116 != 0) {
                        if (var58_41 != 0) {
                            var58_41 = 1;
                            var59_42 = 1.4E-45f;
                        } else {
                            var58_41 = (int)var71_53;
                        }
                        if (var143_116 != 0) {
                            var119_97 = var58_41 != 0 ? (long)32 : (long)16;
                            var13_10 |= var119_97;
                        }
                        var145_118 = 1;
                        var146_119 = 1.4E-45f;
                        var58_41 ^= 1;
                    } else {
                        var145_118 = 1;
                        var146_119 = 1.4E-45f;
                        var58_41 = 0;
                        var59_42 = 0.0f;
                        var60_43 /* !! */  = null;
                    }
                    var119_97 = var2_2 & 171974914L;
                    var37_27 = 0L;
                    var143_116 = (int)(var119_97 == var37_27 ? 0 : (var119_97 < var37_27 ? -1 : 1));
                    if (var143_116 == 0) ** GOTO lbl-1000
                    if (var34_25 == 0) {
                        var121_98 = 0;
                        var10_7 = null;
                    }
                    if (var143_116 != 0) {
                        var119_97 = var121_98 != 0 ? 0x20000000L : 0x10000000L;
                        var2_2 |= var119_97;
                    }
                    if (var121_98 == 0) {
                        var121_98 = 8;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var121_98 = 0;
                        var10_7 = null;
                    }
                    var96_78 = 167819264L;
                    var119_97 = var2_2 & var96_78;
                    var37_27 = 0L;
                    var143_116 = (int)(var119_97 == var37_27 ? 0 : (var119_97 < var37_27 ? -1 : 1));
                    if (var143_116 == 0) ** GOTO lbl-1000
                    if (var103_82 != 0) {
                        var20_15 = var145_118;
                        var21_16 = var146_119;
                    }
                    if (var143_116 != 0) {
                        var119_97 = var20_15 != 0 ? 32768L : 16384L;
                        var13_10 |= var119_97;
                    }
                    if (var20_15 != 0) {
                        var20_15 = 8;
                        var21_16 = 1.1E-44f;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var20_15 = 0;
                        var21_16 = 0.0f;
                        var57_40 = null;
                    }
                    var119_97 = var2_2 & 171974944L;
                    var37_27 = 0L;
                    var143_116 = (int)(var119_97 == var37_27 ? 0 : (var119_97 < var37_27 ? -1 : 1));
                    if (var143_116 != 0) {
                        if (var34_25 == 0) {
                            var124_101 = 0;
                            var125_102 = 0.0f;
                            var126_103 /* !! */  = null;
                        }
                        if (var143_116 != 0) {
                            var119_97 = var124_101 != 0 ? (long)2 : 1L;
                            var13_10 |= var119_97;
                        }
                        var147_120 = var124_101 != 0 ? 0 : 8;
                        var34_25 = var147_120;
                    } else {
                        var34_25 = 0;
                        var33_24 = null;
                    }
                    var119_97 = var2_2 & 167781888L;
                    var37_27 = 0L;
                    var124_101 = (int)(var119_97 == var37_27 ? 0 : (var119_97 < var37_27 ? -1 : 1));
                    if (var124_101 != 0) {
                        var100_80 = (int)(var100_80 != 0 ? var141_114 : var114_92);
                        var126_103 /* !! */  = this.getRoot();
                        var141_114 = var20_15;
                        var148_121 = var21_16;
                        var57_40 = var126_103 /* !! */ .getContext();
                        var8_5 /* !! */  = d.v.f.i.g.f((Context)var57_40, var100_80);
                    } else {
                        var141_114 = var20_15;
                        var148_121 = var21_16;
                        var100_80 = 0;
                        var8_5 /* !! */  = null;
                    }
                    var91_72 = var2_2 & var53_38;
                    var20_15 = (int)(var91_72 == var37_27 ? 0 : (var91_72 < var37_27 ? -1 : 1));
                    if (var20_15 != 0) {
                        if (var89_70 != 0) {
                            var124_101 = var145_118;
                            var125_102 = var146_119;
                        } else {
                            var124_101 = (int)var71_53;
                        }
                        if (var20_15 != 0) {
                            var91_72 = var124_101 != 0 ? 0x200000000000000L : 0x100000000000000L;
                            var2_2 |= var91_72;
                        }
                        if (var124_101 != 0) {
                            var20_15 = var47_33;
                            var21_16 = var48_34;
                        } else {
                            var20_15 = var49_35;
                            var21_16 = var50_36;
                        }
                    } else {
                        var20_15 = 0;
                        var57_40 = null;
                        var21_16 = 0.0f;
                    }
                    var35_26 = var2_2 & var35_26;
                    var37_27 = 0L;
                    var124_101 = (int)(var35_26 == var37_27 ? 0 : (var35_26 < var37_27 ? -1 : 1));
                    if (var124_101 == 0 && (var149_122 = (int)((cfr_temp_26 = (var35_26 = var13_10 & var51_37) - var37_27) == 0L ? 0 : (cfr_temp_26 < 0L ? -1 : 1))) == 0) {
                        var149_122 = var111_89;
                        var150_123 = var112_90;
                        var124_101 = var117_95;
                        var125_102 = var118_96;
                        var107_85 = var67_50 /* !! */ ;
                        var151_124 = 0;
                        var152_125 = 0.0f;
                        var11_8 /* !! */  = null;
                        var153_126 = 0;
                        var154_127 = 0.0f;
                        var155_128 = null;
                    } else {
                        if (var124_101 != 0) {
                            if (var11_8 /* !! */  != null) {
                                var126_103 /* !! */  = var11_8 /* !! */ .i0();
                                var149_122 = var111_89;
                                var150_123 = var112_90;
                                var86_68 = var126_103 /* !! */ ;
                                var124_101 = var117_95;
                                var125_102 = var118_96;
                                var12_9 = var126_103 /* !! */ ;
                            } else {
                                var149_122 = var111_89;
                                var150_123 = var112_90;
                                var124_101 = var117_95;
                                var125_102 = var118_96;
                                var117_95 = 0;
                                var118_96 = 0.0f;
                                var12_9 = null;
                            }
                            var111_89 = 6;
                            var112_90 = 8.4E-45f;
                            var1_1.updateLiveDataRegistration(var111_89, (LiveData)var12_9);
                            if (var12_9 != null) {
                                var155_129 = var107_85 = (Boolean)var12_9.getValue();
                            } else {
                                var153_126 = 0;
                                var154_127 = 0.0f;
                                var155_129 = null;
                            }
                            var111_89 = (int)ViewDataBinding.safeUnbox((Boolean)var155_129);
                        } else {
                            var149_122 = var111_89;
                            var150_123 = var112_90;
                            var124_101 = var117_95;
                            var125_102 = var118_96;
                            var111_89 = 0;
                            var112_90 = 0.0f;
                            var107_85 = null;
                        }
                        var156_130 = var13_10 & var51_37;
                        var37_27 = 0L;
                        var117_95 = (int)(var156_130 == var37_27 ? 0 : (var156_130 < var37_27 ? -1 : 1));
                        if (var117_95 != 0) {
                            if (var11_8 /* !! */  != null) {
                                var90_71 = var11_8 /* !! */ .H();
                            }
                            var153_126 = var111_89;
                            var11_8 /* !! */  = var90_71;
                            var111_89 = 13;
                            var112_90 = 1.8E-44f;
                            var1_1.updateLiveDataRegistration(var111_89, (LiveData)var90_71);
                            if (var90_71 != null) {
                                var67_50 /* !! */  = var107_85 = var90_71.getValue();
                                var67_50 /* !! */  = (CameraSet$Mode)var107_85;
                            }
                            var107_85 = var67_50 /* !! */ ;
                            var11_8 /* !! */  = CameraSet$Mode.photograph;
                            if (var11_8 /* !! */  == var67_50 /* !! */ ) {
                                var151_124 = var145_118;
                                var152_125 = var146_119;
                            } else {
                                var151_124 = 0;
                                var152_125 = 0.0f;
                                var11_8 /* !! */  = null;
                            }
                            if (var117_95 != 0) {
                                var156_130 = var151_124 != 0 ? 0x20000000000L : 0x10000000000L;
                                var2_2 |= var156_130;
                            }
                        } else {
                            var153_126 = var111_89;
                            var107_85 = var67_50 /* !! */ ;
                            var151_124 = 0;
                            var152_125 = 0.0f;
                            var11_8 /* !! */  = null;
                        }
                    }
                    var156_130 = var2_2 & var41_30;
                    var37_27 = 0L;
                    var117_95 = (int)(var156_130 == var37_27 ? 0 : (var156_130 < var37_27 ? -1 : 1));
                    if (var117_95 != 0) {
                        if (var71_53 != false) {
                            var153_126 = var145_118;
                            var154_127 = var146_119;
                        }
                        if (var117_95 != 0) {
                            if (var153_126 != 0) {
                                var2_2 |= 0x2000000000000000L;
                                var156_130 = -9223372036854775808L;
                            } else {
                                var2_2 |= 0x1000000000000000L;
                                var156_130 = 0x4000000000000000L;
                            }
                            var2_2 |= var156_130;
                        }
                        var117_95 = var153_126 ^ 1;
                        if (var153_126 != 0) {
                            var153_126 = var47_33;
                            var154_127 = var48_34;
                        } else {
                            var153_126 = var49_35;
                            var154_127 = var50_36;
                        }
                        var82_63 = var153_126;
                        var142_115 = var154_127;
                        var153_126 = (int)var17_12;
                        var154_127 = var19_14;
                        var17_12 = var82_63;
                        var19_14 = var142_115;
                    } else {
                        var153_126 = (int)var17_12;
                        var154_127 = var19_14;
                        var17_12 = 0;
                        var18_13 /* !! */  = null;
                        var19_14 = 0.0f;
                        var117_95 = 0;
                        var118_96 = 0.0f;
                        var12_9 = null;
                    }
                    var156_130 = var2_2 & 0x10000000000L;
                    var37_27 = 0L;
                    var158_131 = var156_130 == var37_27 ? 0 : (var156_130 < var37_27 ? -1 : 1);
                    if (var158_131 == false) break block278;
                    var158_131 = var58_41;
                    var60_43 /* !! */  = CameraSet$Mode.panorama;
                    if (var60_43 /* !! */  != var107_85) break block279;
                    var58_41 = var145_118;
                    var59_42 = var146_119;
                    break block280;
                }
                var158_131 = var58_41;
            }
            var58_41 = 0;
            var59_42 = 0.0f;
            var60_43 /* !! */  = null;
        }
        var111_89 = (int)((cfr_temp_27 = (var13_10 &= var51_37) - var37_27) == 0L ? 0 : (cfr_temp_27 < 0L ? -1 : 1));
        if (var111_89 != 0) {
            var32_23 = var151_124 != 0 ? var145_118 : var58_41;
        } else {
            var32_23 = 0;
            var73_55 = null;
        }
        var159_132 = var2_2 & var53_38;
        var58_41 = (int)(var159_132 == var37_27 ? 0 : (var159_132 < var37_27 ? -1 : 1));
        if (var58_41 != 0) {
            if (var71_53 == false) {
                var32_23 = 0;
                var73_55 = null;
            }
            if (var58_41 != 0) {
                var69_52 = var32_23 != 0 ? 0x200000000L : 0x100000000L;
                var2_2 |= var69_52;
            }
            var58_41 = var32_23 ^ 1;
            if (var32_23 == 0) {
                var47_33 = var49_35;
                var48_34 = var50_36;
            }
            var111_89 = var47_33;
            var112_90 = var48_34;
        } else {
            var111_89 = 0;
            var107_85 = null;
            var112_90 = 0.0f;
            var58_41 = 0;
            var59_42 = 0.0f;
            var60_43 /* !! */  = null;
        }
        var13_10 = 0xA002000L & var2_2;
        var37_27 = 0L;
        var151_124 = (int)(var13_10 == var37_27 ? 0 : (var13_10 < var37_27 ? -1 : 1));
        if (var151_124 != 0) {
            var11_8 /* !! */  = var1_1.a;
            ViewBindingAdapter.setBackground((View)var11_8 /* !! */ , (Drawable)var106_84 /* !! */ );
        }
        if ((var110_88 = (cfr_temp_28 = (var13_10 = 0xA00B000L & var2_2) - var37_27) == 0L ? 0 : (cfr_temp_28 < 0L ? -1 : 1)) != 0) {
            var110_88 = ViewDataBinding.getBuildSdkInt();
            var151_124 = 21;
            var152_125 = 2.9E-44f;
            if (var110_88 >= var151_124) {
                var106_84 /* !! */  = var1_1.a;
                var30_21 = var81_62;
                var31_22 = var113_91;
                var152_125 = var81_62;
                var106_84 /* !! */ .setTranslationZ(var152_125);
            }
        }
        if ((var110_88 = (int)((cfr_temp_29 = (var13_10 = var2_2 & var22_17) - (var22_17 = 0L)) == 0L ? 0 : (cfr_temp_29 < 0L ? -1 : 1))) != 0) {
            var106_84 /* !! */  = var1_1.a;
            var106_84 /* !! */ .setVisibility(var39_28);
        }
        if ((var110_88 = (int)((cfr_temp_30 = (var13_10 = var2_2 & var51_37) - var22_17) == 0L ? 0 : (cfr_temp_30 < 0L ? -1 : 1))) != 0) {
            var106_84 /* !! */  = var1_1.d;
            var9_6 = var1_1.z;
            var106_84 /* !! */ .setOnClickListener((View.OnClickListener)var9_6);
            var106_84 /* !! */  = var1_1.e;
            var9_6 = var1_1.D;
            var106_84 /* !! */ .setOnClickListener((View.OnClickListener)var9_6);
        }
        if ((var110_88 = (int)((cfr_temp_31 = (var13_10 = 171974914L & var2_2) - (var22_17 = 0L)) == 0L ? 0 : (cfr_temp_31 < 0L ? -1 : 1))) != 0) {
            var106_84 /* !! */  = var1_1.d;
            var106_84 /* !! */ .setVisibility(var121_98);
        }
        if ((var110_88 = (int)((cfr_temp_32 = (var161_133 = 0xA000008L & var2_2) - var22_17) == 0L ? 0 : (cfr_temp_32 < 0L ? -1 : 1))) != 0) {
            var106_84 /* !! */  = var1_1.e;
            var9_6 = var77_58;
            ImageViewBindingAdapter.setImageDrawable((ImageView)var106_84 /* !! */ , (Drawable)var77_58);
        }
        if ((var110_88 = (int)((cfr_temp_33 = (var161_133 = var2_2 & var41_30) - var22_17) == 0L ? 0 : (cfr_temp_33 < 0L ? -1 : 1))) != 0) {
            var110_88 = ViewDataBinding.getBuildSdkInt();
            var39_28 = 11;
            var40_29 = 1.5E-44f;
            if (var110_88 >= var39_28) {
                var106_84 /* !! */  = var1_1.f;
                var106_84 /* !! */ .setAlpha(var19_14);
            }
            var106_84 /* !! */  = var1_1.f;
            var9_6 = var1_1.A;
            ViewBindingAdapter.setOnClick((View)var106_84 /* !! */ , (View.OnClickListener)var9_6, (boolean)var117_95);
        }
        if ((var110_88 = (int)((cfr_temp_34 = (var161_133 = 167781888L & var2_2) - (var163_134 = 0L)) == 0L ? 0 : (cfr_temp_34 < 0L ? -1 : 1))) != 0) {
            var106_84 /* !! */  = var1_1.f;
            ImageViewBindingAdapter.setImageDrawable((ImageView)var106_84 /* !! */ , (Drawable)var8_5 /* !! */ );
        }
        if ((var100_80 = (cfr_temp_35 = (var161_133 = 171974944L & var2_2) - var163_134) == 0L ? 0 : (cfr_temp_35 < 0L ? -1 : 1)) != 0) {
            var8_5 /* !! */  = var1_1.f;
            var8_5 /* !! */ .setVisibility(var34_25);
        }
        if ((var100_80 = (cfr_temp_36 = (var165_135 = var2_2 & var53_38) - var163_134) == 0L ? 0 : (cfr_temp_36 < 0L ? -1 : 1)) != 0) {
            var100_80 = ViewDataBinding.getBuildSdkInt();
            if (var100_80 >= (var34_25 = 11)) {
                var1_1.g.setAlpha(var21_16);
                var8_5 /* !! */  = var1_1.j;
                var8_5 /* !! */ .setAlpha(var112_90);
            }
            var8_5 /* !! */  = var1_1.g;
            var33_24 = var1_1.y;
            var110_88 = (int)var158_131;
            ViewBindingAdapter.setOnClick((View)var8_5 /* !! */ , (View.OnClickListener)var33_24, (boolean)var158_131);
            var8_5 /* !! */  = var1_1.j;
            var33_24 = var1_1.E;
            ViewBindingAdapter.setOnClick((View)var8_5 /* !! */ , (View.OnClickListener)var33_24, (boolean)var58_41);
        }
        if ((var100_80 = (int)((cfr_temp_37 = (var4_3 = 0xA000010L & var2_2) - (var6_4 = 0L)) == 0L ? 0 : (cfr_temp_37 < 0L ? -1 : 1))) != 0) {
            var8_5 /* !! */  = var1_1.g;
            var60_43 /* !! */  = var68_51;
            ImageViewBindingAdapter.setImageDrawable((ImageView)var8_5 /* !! */ , (Drawable)var68_51);
        }
        if ((var100_80 = (int)((cfr_temp_38 = (var4_3 = var2_2 & var28_20) - var6_4) == 0L ? 0 : (cfr_temp_38 < 0L ? -1 : 1))) != 0) {
            var8_5 /* !! */  = var1_1.g;
            var17_12 = var153_126;
            var19_14 = var154_127;
            var8_5 /* !! */ .setVisibility(var153_126);
            var8_5 /* !! */  = var1_1.i;
            var58_41 = var149_122;
            var59_42 = var150_123;
            var8_5 /* !! */ .setVisibility(var149_122);
        }
        if ((var100_80 = (cfr_temp_39 = (var4_3 = var2_2 & var45_32) - var6_4) == 0L ? 0 : (cfr_temp_39 < 0L ? -1 : 1)) != 0) {
            var100_80 = ViewDataBinding.getBuildSdkInt();
            var58_41 = 11;
            var59_42 = 1.5E-44f;
            if (var100_80 >= var58_41) {
                var8_5 /* !! */  = var1_1.h;
                var117_95 = var124_101;
                var118_96 = var125_102;
                var8_5 /* !! */ .setAlpha(var125_102);
            }
        }
        if ((var100_80 = (int)((cfr_temp_40 = (var4_3 = var2_2 & var43_31) - var6_4) == 0L ? 0 : (cfr_temp_40 < 0L ? -1 : 1))) != 0) {
            var8_5 /* !! */  = var1_1.h;
            var60_43 /* !! */  = var1_1.C;
            var34_25 = (int)var116_94;
            ViewBindingAdapter.setOnClick((View)var8_5 /* !! */ , (View.OnClickListener)var60_43 /* !! */ , (boolean)var116_94);
            var8_5 /* !! */  = var1_1.i;
            var60_43 /* !! */  = var1_1.B;
            ViewBindingAdapter.setOnClick((View)var8_5 /* !! */ , (View.OnClickListener)var60_43 /* !! */ , (boolean)var116_94);
            var100_80 = ViewDataBinding.getBuildSdkInt();
            var58_41 = 11;
            var59_42 = 1.5E-44f;
            if (var100_80 >= var58_41) {
                var8_5 /* !! */  = var1_1.i;
                var58_41 = var108_86;
                var59_42 = var109_87;
                var8_5 /* !! */ .setAlpha(var109_87);
            }
        }
        if ((var100_80 = (int)((cfr_temp_41 = (var4_3 = 0xA000020L & var2_2) - (var6_4 = 0L)) == 0L ? 0 : (cfr_temp_41 < 0L ? -1 : 1))) != 0) {
            var8_5 /* !! */  = var1_1.i;
            var60_43 /* !! */  = var84_65;
            ImageViewBindingAdapter.setImageDrawable((ImageView)var8_5 /* !! */ , (Drawable)var84_65);
        }
        if ((var100_80 = (int)((cfr_temp_42 = (var4_3 = var2_2 & var26_19) - var6_4) == 0L ? 0 : (cfr_temp_42 < 0L ? -1 : 1))) != 0) {
            var8_5 /* !! */  = var1_1.j;
            var58_41 = var64_46;
            var59_42 = var65_47;
            var8_5 /* !! */ .setVisibility(var64_46);
        }
        if ((var100_80 = (int)((cfr_temp_43 = (var2_2 &= (var4_3 = 167819264L)) - var6_4) == 0L ? 0 : (cfr_temp_43 < 0L ? -1 : 1))) != 0) {
            var8_5 /* !! */  = var1_1.k;
            var20_15 = (int)var141_114;
            var21_16 = var148_121;
            var8_5 /* !! */ .setVisibility((int)var141_114);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.F;
            long l11 = 0L;
            Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (object != false) return (boolean)((Object)1);
            l10 = this.G;
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
            this.F = l10 = 0x8000000L;
            this.G = l10 = 0L;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        switch (n10) {
            default: {
                return false;
            }
            case 13: {
                object = (MutableLiveData)object;
                return this.c0((MutableLiveData)object, n11);
            }
            case 12: {
                object = (MutableLiveData)object;
                return this.b0((MutableLiveData)object, n11);
            }
            case 11: {
                object = (MutableLiveData)object;
                return this.l0((MutableLiveData)object, n11);
            }
            case 10: {
                object = (MutableLiveData)object;
                return this.k0((MutableLiveData)object, n11);
            }
            case 9: {
                object = (MutableLiveData)object;
                return this.f0((MutableLiveData)object, n11);
            }
            case 8: {
                object = (MutableLiveData)object;
                return this.Z((MutableLiveData)object, n11);
            }
            case 7: {
                object = (MutableLiveData)object;
                return this.Y((MutableLiveData)object, n11);
            }
            case 6: {
                object = (MutableLiveData)object;
                return this.i0((MutableLiveData)object, n11);
            }
            case 5: {
                object = (MutableLiveData)object;
                return this.j0((MutableLiveData)object, n11);
            }
            case 4: {
                object = (MutableLiveData)object;
                return this.g0((MutableLiveData)object, n11);
            }
            case 3: {
                object = (MutableLiveData)object;
                return this.h0((MutableLiveData)object, n11);
            }
            case 2: {
                object = (MutableLiveData)object;
                return this.e0((MutableLiveData)object, n11);
            }
            case 1: {
                object = (LiveData)object;
                return this.d0((LiveData)object, n11);
            }
            case 0: 
        }
        object = (MutableLiveData)object;
        return this.a0((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 147;
        if (n11 == n10) {
            s6 s62 = (s6)object;
            this.W(s62);
            return 1 != 0;
        } else {
            n11 = 131;
            if (n11 == n10) {
                m0 m02 = (m0)object;
                this.U(m02);
                return 1 != 0;
            } else {
                n11 = 45;
                if (n11 == n10) {
                    DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel = (DynamicZoomViewModel$TargetModel)((Object)object);
                    this.O(dynamicZoomViewModel$TargetModel);
                    return 1 != 0;
                } else {
                    n11 = 39;
                    if (n11 == n10) {
                        DeviceViewModel deviceViewModel = (DeviceViewModel)object;
                        this.N(deviceViewModel);
                        return 1 != 0;
                    } else {
                        n11 = 143;
                        if (n11 == n10) {
                            w6 w62 = (w6)object;
                            this.V(w62);
                            return 1 != 0;
                        } else {
                            n11 = 23;
                            if (n11 == n10) {
                                CameraFragment$j cameraFragment$j = (CameraFragment$j)object;
                                this.M(cameraFragment$j);
                                return 1 != 0;
                            } else {
                                n11 = 13;
                                if (n11 == n10) {
                                    BleViewModel bleViewModel = (BleViewModel)object;
                                    this.L(bleViewModel);
                                    return 1 != 0;
                                } else {
                                    n11 = 46;
                                    if (n11 == n10) {
                                        DynamicZoomViewModel dynamicZoomViewModel = (DynamicZoomViewModel)object;
                                        this.P(dynamicZoomViewModel);
                                        return 1 != 0;
                                    } else {
                                        n11 = 112;
                                        if (n11 == n10) {
                                            v6 v62 = (v6)object;
                                            this.S(v62);
                                            return 1 != 0;
                                        } else {
                                            n11 = 130;
                                            if (n11 == n10) {
                                                l l10 = (l)object;
                                                this.T(l10);
                                                return 1 != 0;
                                            } else {
                                                n11 = 63;
                                                if (n11 == n10) {
                                                    c1 c12 = (c1)object;
                                                    this.Q(c12);
                                                    return 1 != 0;
                                                } else {
                                                    n11 = 152;
                                                    if (n11 == n10) {
                                                        u6 u62 = (u6)object;
                                                        this.X(u62);
                                                        return 1 != 0;
                                                    } else {
                                                        n11 = 80;
                                                        if (n11 != n10) return 0 != 0;
                                                        z z10 = (z)object;
                                                        this.R(z10);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return 1 != 0;
    }
}

