/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.HorizontalScrollView
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.camera.widget.WheelPicker;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.a7.e1$d;
import d.v.c.w0.h1;

public class i1
extends h1
implements b$a {
    private static final ViewDataBinding$IncludedLayouts q;
    private static final SparseIntArray r;
    private final FrameLayout m;
    private final ImageButton n;
    private final View.OnClickListener o;
    private long p;

    static {
        SparseIntArray sparseIntArray;
        r = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363273, 4);
        sparseIntArray.put(2131362824, 5);
        sparseIntArray.put(2131363653, 6);
        sparseIntArray.put(2131362477, 7);
        sparseIntArray.put(2131362250, 8);
        sparseIntArray.put(2131362384, 9);
        sparseIntArray.put(2131362674, 10);
        sparseIntArray.put(2131363656, 11);
    }

    public i1(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = q;
        SparseIntArray sparseIntArray = r;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 12, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private i1(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[8];
        object2 = (CardView)((Object)object);
        Object object3 = object = objectArray[9];
        object3 = (ExoVideoView)object;
        Object object4 = object = objectArray[7];
        object4 = (FrameLayout)object;
        Object object5 = object = objectArray[10];
        object5 = (ImageView)object;
        Object object6 = object = objectArray[5];
        object6 = (LinearLayout)object;
        Object object7 = object = objectArray[4];
        object7 = (HorizontalScrollView)object;
        Object object8 = object = objectArray[6];
        object8 = (View)object;
        Object object9 = object = objectArray[11];
        object9 = (View)object;
        Object object10 = object = objectArray[2];
        object10 = (WheelPicker)((Object)object);
        int n10 = 1;
        Object object11 = object = objectArray[n10];
        object11 = (WheelPicker)((Object)object);
        object = this;
        super(dataBindingComponent, view, 0, (CardView)((Object)object2), (ExoVideoView)object3, (FrameLayout)object4, (ImageView)object5, (LinearLayout)object6, (HorizontalScrollView)object7, (View)object8, (View)object9, (WheelPicker)((Object)object10), (WheelPicker)((Object)object11));
        this.p = -1;
        object = (FrameLayout)objectArray[0];
        this.m = object;
        object.setTag(null);
        object = (ImageButton)objectArray[3];
        this.n = object;
        object.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n10);
        this.o = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void A(e1$d e1$d) {
        this.k = e1$d;
        synchronized (this) {
            long l10 = this.p;
            long l11 = 1L;
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
    public void B(Integer n10) {
        this.l = n10;
        synchronized (this) {
            long l10 = this.p;
            long l11 = 2;
            this.p = l10 |= l11;
        }
        this.notifyPropertyChanged(118);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        e1$d e1$d = this.k;
        boolean bl2 = e1$d != null;
        if (bl2) {
            e1$d.a();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        int n10;
        long l10;
        long l11;
        float f10;
        View.OnClickListener onClickListener;
        float f11;
        float f12;
        long l12;
        long l13;
        synchronized (this) {
            l13 = this.p;
            this.p = l12 = 0L;
        }
        Integer n11 = this.l;
        long l14 = 6;
        long l15 = l13 & l14;
        long l16 = l15 == l12 ? 0 : (l15 < l12 ? -1 : 1);
        int n12 = 0;
        float f13 = 0.0f;
        if (l16 != false) {
            long l17;
            long l18;
            int n13 = ViewDataBinding.safeUnbox(n11);
            n12 = 2;
            f13 = 2.8E-45f;
            int n14 = 1;
            float f14 = Float.MIN_VALUE;
            f12 = 0.0f;
            if (n12 == n13) {
                n12 = n14;
                f13 = f14;
            } else {
                n12 = 0;
                f13 = 0.0f;
            }
            int n15 = 3;
            f11 = 4.2E-45f;
            if (n15 != n13) {
                n14 = 0;
                onClickListener = null;
                f14 = 0.0f;
            }
            if (l16 != false) {
                if (n12 != 0) {
                    l13 |= (long)64;
                    l18 = 256L;
                } else {
                    l13 |= (long)32;
                    l18 = 128L;
                }
                l13 |= l18;
            }
            if ((n13 = (int)((l17 = (l18 = l13 & l14) - l12) == 0L ? 0 : (l17 < 0L ? -1 : 1))) != 0) {
                if (n14 != 0) {
                    l13 |= (long)16;
                    l18 = 1024L;
                } else {
                    l13 |= (long)8;
                    l18 = 512L;
                }
                l13 |= l18;
            }
            n13 = 1058642330;
            f10 = 0.6f;
            l16 = 1065353216;
            float f15 = 1.0f;
            f12 = n12 != 0 ? f15 : f10;
            n15 = 0x3F666666;
            f11 = 0.9f;
            if (n12 != 0) {
                n12 = (int)l16;
                f13 = f15;
            } else {
                n12 = n15;
                f13 = f11;
            }
            if (n14 != 0) {
                n15 = (int)l16;
                f11 = f15;
            }
            if (n14 != 0) {
                n13 = (int)l16;
                f10 = f15;
            }
            int n16 = n12;
            float f16 = f13;
            n12 = n13;
            f13 = f10;
            n13 = n16;
            f10 = f16;
        } else {
            boolean bl2 = false;
            n11 = null;
            f10 = 0.0f;
            f12 = 0.0f;
            boolean bl3 = false;
            f11 = 0.0f;
        }
        long l19 = (long)4 & l13;
        l16 = l19 == l12 ? 0 : (l19 < l12 ? -1 : 1);
        if (l16 != false) {
            ImageButton imageButton = this.n;
            onClickListener = this.o;
            imageButton.setOnClickListener(onClickListener);
        }
        if ((l11 = (l10 = (l13 &= l14) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false && (l11 = (long)ViewDataBinding.getBuildSdkInt()) >= (n10 = 11)) {
            this.i.setAlpha(f13);
            this.i.setScaleX(f11);
            this.i.setScaleY(f11);
            this.j.setAlpha(f12);
            this.j.setScaleX(f10);
            WheelPicker wheelPicker = this.j;
            wheelPicker.setScaleY(f10);
        }
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
            this.p = l10 = (long)4;
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
        int n11 = 23;
        if (n11 == n10) {
            object = (e1$d)object;
            this.A((e1$d)object);
            return 1 != 0;
        } else {
            n11 = 118;
            if (n11 != n10) return 0 != 0;
            object = (Integer)object;
            this.B((Integer)object);
        }
        return 1 != 0;
    }
}

