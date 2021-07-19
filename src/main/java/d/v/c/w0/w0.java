/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.airbnb.lottie.LottieAnimationView;
import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import com.zhiyun.cama.camera.ble.BleViewModel;
import d.v.c.s0.b7.k$a;
import d.v.c.s0.u6;
import d.v.c.w0.v0;

public class w0
extends v0 {
    private static final ViewDataBinding$IncludedLayouts A;
    private static final SparseIntArray B;
    private final ConstraintLayout y;
    private long z;

    static {
        SparseIntArray sparseIntArray;
        B = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363331, 1);
        sparseIntArray.put(2131362060, 2);
        sparseIntArray.put(2131362058, 3);
        sparseIntArray.put(2131362181, 4);
        sparseIntArray.put(2131363517, 5);
        sparseIntArray.put(2131362709, 6);
        sparseIntArray.put(2131362183, 7);
        sparseIntArray.put(2131363001, 8);
        sparseIntArray.put(2131362187, 9);
        sparseIntArray.put(2131363117, 10);
        sparseIntArray.put(2131363561, 11);
        sparseIntArray.put(2131363375, 12);
        sparseIntArray.put(2131362569, 13);
        sparseIntArray.put(2131362567, 14);
        sparseIntArray.put(2131362568, 15);
        sparseIntArray.put(2131362306, 16);
        sparseIntArray.put(2131362307, 17);
        sparseIntArray.put(2131362311, 18);
        sparseIntArray.put(2131362304, 19);
    }

    public w0(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = A;
        SparseIntArray sparseIntArray = B;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 20, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private w0(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object = this;
        Guideline guideline = (Guideline)((Object)objectArray[3]);
        Guideline guideline2 = (Guideline)((Object)objectArray[2]);
        ConstraintLayout constraintLayout = (ConstraintLayout)((Object)objectArray[4]);
        ConstraintLayout constraintLayout2 = (ConstraintLayout)((Object)objectArray[7]);
        ConstraintLayout constraintLayout3 = (ConstraintLayout)((Object)objectArray[9]);
        LottieAnimationView lottieAnimationView = (LottieAnimationView)objectArray[19];
        View view2 = (View)objectArray[16];
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView)objectArray[17];
        TextView textView = (TextView)objectArray[18];
        Guideline guideline3 = (Guideline)((Object)objectArray[14]);
        Guideline guideline4 = (Guideline)((Object)objectArray[15]);
        Guideline guideline5 = (Guideline)((Object)objectArray[13]);
        ImageView imageView = (ImageView)objectArray[6];
        View view3 = (View)objectArray[8];
        Guideline guideline6 = (Guideline)((Object)objectArray[10]);
        Guideline guideline7 = (Guideline)((Object)objectArray[1]);
        Guideline guideline8 = (Guideline)((Object)objectArray[12]);
        TextView textView2 = (TextView)objectArray[5];
        Guideline guideline9 = (Guideline)((Object)objectArray[11]);
        super(dataBindingComponent, view, 0, guideline, guideline2, constraintLayout, constraintLayout2, constraintLayout3, lottieAnimationView, view2, lottieAnimationView2, textView, guideline3, guideline4, guideline5, imageView, view3, guideline6, guideline7, guideline8, textView2, guideline9);
        this.z = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.y = object;
        object.setTag(null);
        object = view;
        this.setRootTag(view);
        this.invalidateAll();
    }

    public void D(BleViewModel bleViewModel) {
        this.v = bleViewModel;
    }

    public void E(k$a k$a) {
        this.t = k$a;
    }

    public void F(DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel) {
        this.w = dynamicZoomViewModel$TargetModel;
    }

    public void G(DynamicZoomViewModel dynamicZoomViewModel) {
        this.u = dynamicZoomViewModel;
    }

    public void H(u6 u62) {
        this.x = u62;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        synchronized (this) {
            long l10;
            this.z = l10 = 0L;
            return;
        }
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
            this.z = l10 = (long)32;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 13;
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
                n11 = 45;
                if (n11 == n10) {
                    DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel = (DynamicZoomViewModel$TargetModel)((Object)object);
                    this.F(dynamicZoomViewModel$TargetModel);
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

