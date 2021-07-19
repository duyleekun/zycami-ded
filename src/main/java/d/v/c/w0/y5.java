/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import d.v.c.s0.b7.k$a;
import d.v.c.s0.u6;
import d.v.c.w0.d1;
import d.v.c.w0.v0;
import d.v.c.w0.x5;

public class y5
extends x5 {
    private static final ViewDataBinding$IncludedLayouts j;
    private static final SparseIntArray k;
    private long i;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        j = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(3);
        String[] stringArray = new String[]{"camera_hitchcock_select_mode", "camera_dynamic_zoom_assist"};
        int n10 = 2;
        int[] nArray = new int[n10];
        nArray[0] = 1;
        nArray[1] = 2;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558468;
        nArray2[1] = 2131558464;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        k = null;
    }

    public y5(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = j;
        SparseIntArray sparseIntArray = k;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private y5(DataBindingComponent object, View view, Object[] object2) {
        Object object3;
        Object object4 = object3 = object2[0];
        object4 = (ConstraintLayout)((Object)object3);
        Object object5 = object3 = object2[2];
        object5 = (v0)object3;
        Object object6 = object2 = object2[1];
        object6 = (d1)object2;
        super(object, view, 3, (ConstraintLayout)((Object)object4), (v0)object5, (d1)object6);
        this.i = -1;
        this.a.setTag(null);
        object = this.b;
        this.setContainedBinding((ViewDataBinding)object);
        object = this.c;
        this.setContainedBinding((ViewDataBinding)object);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean I(v0 v02, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.i;
                long l11 = 2;
                this.i = l10 |= l11;
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
    private boolean J(d1 d12, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.i;
                long l11 = 4;
                this.i = l10 |= l11;
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
                long l10 = this.i;
                long l11 = 1L;
                this.i = l10 |= l11;
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
        this.f = bleViewModel;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 16;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(13);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(k$a k$a) {
        this.d = k$a;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 64;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel) {
        this.h = dynamicZoomViewModel$TargetModel;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 8;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(45);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void G(DynamicZoomViewModel dynamicZoomViewModel) {
        this.g = dynamicZoomViewModel;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 32;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(46);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void H(u6 u62) {
        this.e = u62;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 128L;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        long l16;
        long l17;
        long l18;
        long l19;
        long l20;
        long l21;
        long l22;
        long l23;
        int n10;
        int n11;
        long l24;
        Object object;
        Object object2;
        Object object3;
        BleViewModel bleViewModel;
        Object object4;
        long l25;
        long l26;
        y5 y52;
        block16: {
            block15: {
                long l27;
                MutableLiveData mutableLiveData;
                int n12;
                y52 = this;
                synchronized (this) {
                    l26 = this.i;
                    this.i = l25 = 0L;
                }
                object4 = this.h;
                bleViewModel = this.f;
                object3 = this.g;
                object2 = this.d;
                object = this.e;
                long l28 = 417L;
                long l29 = l26 & l28;
                long l30 = l29 == l25 ? 0 : (l29 < l25 ? -1 : 1);
                l24 = 385L;
                n11 = 0;
                if (l30 == false) break block15;
                n10 = object3 != null ? (n12 = ((DynamicZoomViewModel)object3).S()) : 0;
                Object object5 = object != null ? (mutableLiveData = ((u6)object).H()) : null;
                y52.updateLiveDataRegistration(0, (LiveData)object5);
                object5 = object5 != null ? (CameraSet$Mode)((Object)object5.getValue()) : null;
                n10 = object != null ? ((u6)object).T0((CameraSet$Mode)((Object)object5), n10 != 0) : 0;
                if (l30 != false) {
                    l27 = n10 != 0 ? 4096L : 2048L;
                    l26 |= l27;
                }
                l30 = 4;
                n10 = n10 != 0 ? 0 : l30;
                l27 = l26 & l24;
                long l31 = l27 - l25;
                Object object6 = l31 == 0L ? 0 : (l31 < 0L ? -1 : 1);
                if (object6 != false) {
                    if (object != null) {
                        l23 = (long)((u6)object).S0((CameraSet$Mode)((Object)object5));
                    } else {
                        l23 = 0;
                        object = null;
                    }
                    if (object6 != false) {
                        l27 = l23 != false ? 1024L : 512L;
                        l26 |= l27;
                    }
                    if (l23 == false) {
                        n11 = l30;
                    }
                }
                break block16;
            }
            n10 = 0;
        }
        if ((l23 = (l22 = (l21 = 0x140L & l26) - l25) == 0L ? 0 : (l22 < 0L ? -1 : 1)) != false) {
            y52.b.E((k$a)object2);
            object = y52.c;
            ((d1)object).B((k$a)object2);
        }
        if ((l20 = (l19 = (l18 = 0x120L & l26) - l25) == 0L ? 0 : (l19 < 0L ? -1 : 1)) != false) {
            y52.b.G((DynamicZoomViewModel)object3);
            object2 = y52.c;
            ((d1)object2).D((DynamicZoomViewModel)object3);
        }
        if ((l17 = (l16 = (l15 = 0x108L & l26) - l25) == 0L ? 0 : (l16 < 0L ? -1 : 1)) != false) {
            y52.b.F((DynamicZoomViewModel$TargetModel)((Object)object4));
            object3 = y52.c;
            ((d1)object3).C((DynamicZoomViewModel$TargetModel)((Object)object4));
        }
        if ((l14 = (l13 = (l15 = 0x110L & l26) - l25) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            object4 = y52.b;
            ((v0)object4).D(bleViewModel);
        }
        if ((l14 = (l12 = (l11 = l26 & l24) - l25) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            object4 = y52.b.getRoot();
            object4.setVisibility(n11);
        }
        if ((l14 = (l10 = (l26 &= (l11 = 417L)) - l25) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            object4 = y52.c.getRoot();
            object4.setVisibility(n10);
        }
        ViewDataBinding.executeBindingsOn(y52.c);
        ViewDataBinding.executeBindingsOn(y52.b);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.i;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            ViewDataBinding viewDataBinding = this.c;
            l12 = (long)viewDataBinding.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            viewDataBinding = this.b;
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
            this.i = l10 = 256L;
        }
        this.c.invalidateAll();
        this.b.invalidateAll();
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
                if (n10 != n12) {
                    return false;
                }
                object = (d1)object;
                return this.J((d1)object, n11);
            }
            object = (v0)object;
            return this.I((v0)object, n11);
        }
        object = (MutableLiveData)object;
        return this.K((MutableLiveData)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.c.setLifecycleOwner(lifecycleOwner);
        this.b.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 45;
        if (n11 == n10) {
            DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel = (DynamicZoomViewModel$TargetModel)((Object)object);
            this.F(dynamicZoomViewModel$TargetModel);
            return 1 != 0;
        } else {
            n11 = 13;
            if (n11 == n10) {
                BleViewModel bleViewModel = (BleViewModel)object;
                this.D(bleViewModel);
                return 1 != 0;
            } else {
                n11 = 46;
                if (n11 == n10) {
                    DynamicZoomViewModel dynamicZoomViewModel = (DynamicZoomViewModel)object;
                    this.G(dynamicZoomViewModel);
                    return 1 != 0;
                } else {
                    n11 = 23;
                    if (n11 == n10) {
                        k$a k$a = (k$a)object;
                        this.E(k$a);
                        return 1 != 0;
                    } else {
                        n11 = 152;
                        if (n11 != n10) return 0 != 0;
                        u6 u62 = (u6)object;
                        this.H(u62);
                    }
                }
            }
        }
        return 1 != 0;
    }
}

