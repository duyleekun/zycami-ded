/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import d.v.c.f1.a.b$a;
import d.v.c.s0.a7.k1$a;
import d.v.c.w0.r1;

public class s1
extends r1
implements b$a {
    private static final ViewDataBinding$IncludedLayouts x;
    private static final SparseIntArray y;
    private final ConstraintLayout s;
    private final LinearLayout t;
    private final LinearLayout u;
    private final View.OnClickListener v;
    private long w;

    static {
        SparseIntArray sparseIntArray;
        y = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363608, 4);
        sparseIntArray.put(2131362841, 5);
        sparseIntArray.put(2131363109, 6);
        sparseIntArray.put(2131363059, 7);
        sparseIntArray.put(2131363055, 8);
        sparseIntArray.put(2131363058, 9);
        sparseIntArray.put(2131363103, 10);
        sparseIntArray.put(2131363025, 11);
        sparseIntArray.put(2131363026, 12);
        sparseIntArray.put(2131363027, 13);
        sparseIntArray.put(2131363106, 14);
        sparseIntArray.put(2131363048, 15);
        sparseIntArray.put(2131363045, 16);
        sparseIntArray.put(2131363046, 17);
        sparseIntArray.put(2131363047, 18);
    }

    public s1(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = x;
        SparseIntArray sparseIntArray = y;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 19, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private s1(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object = this;
        ImageView imageView = (ImageView)objectArray[1];
        LinearLayout linearLayout = (LinearLayout)objectArray[5];
        RadioButton radioButton = (RadioButton)objectArray[11];
        RadioButton radioButton2 = (RadioButton)objectArray[12];
        RadioButton radioButton3 = (RadioButton)objectArray[13];
        RadioButton radioButton4 = (RadioButton)objectArray[16];
        RadioButton radioButton5 = (RadioButton)objectArray[17];
        RadioButton radioButton6 = (RadioButton)objectArray[18];
        RadioButton radioButton7 = (RadioButton)objectArray[15];
        RadioButton radioButton8 = (RadioButton)objectArray[8];
        RadioButton radioButton9 = (RadioButton)objectArray[9];
        RadioButton radioButton10 = (RadioButton)objectArray[7];
        RadioGroup radioGroup = (RadioGroup)objectArray[10];
        RadioGroup radioGroup2 = (RadioGroup)objectArray[14];
        RadioGroup radioGroup3 = (RadioGroup)objectArray[6];
        TextView textView = (TextView)objectArray[4];
        super(dataBindingComponent, view, 0, imageView, linearLayout, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8, radioButton9, radioButton10, radioGroup, radioGroup2, radioGroup3, textView);
        this.w = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.s = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[2];
        this.t = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[3];
        this.u = object;
        object.setTag(null);
        object = view;
        this.setRootTag(view);
        super(this, 1);
        this.v = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void A(k1$a k1$a) {
        this.q = k1$a;
        synchronized (this) {
            long l10 = this.w;
            long l11 = 2;
            this.w = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(CameraSet$Mode cameraSet$Mode) {
        this.r = cameraSet$Mode;
        synchronized (this) {
            long l10 = this.w;
            long l11 = 1L;
            this.w = l10 |= l11;
        }
        this.notifyPropertyChanged(90);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        k1$a k1$a = this.q;
        boolean bl2 = k1$a != null;
        if (bl2) {
            k1$a.a();
        }
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
        View.OnClickListener onClickListener;
        float f10;
        int n10;
        CameraSet$Mode cameraSet$Mode;
        long l13;
        long l14;
        long l15;
        CameraSet$Mode cameraSet$Mode2;
        long l16;
        long l17;
        int n11;
        long l18;
        long l19;
        s1 s12 = this;
        synchronized (this) {
            l19 = this.w;
            this.w = l18 = 0L;
        }
        CameraSet$Mode cameraSet$Mode3 = this.r;
        long l20 = 5;
        long l21 = l19 & l20;
        long l22 = l21 == l18 ? 0 : (l21 < l18 ? -1 : 1);
        int n12 = 8;
        long l23 = 512L;
        int n13 = 1;
        float f11 = Float.MIN_VALUE;
        int n14 = 0;
        if (l22 != false) {
            long l24;
            int n15;
            CameraSet$Mode cameraSet$Mode4 = CameraSet$Mode.sport_delay;
            if (cameraSet$Mode4 == cameraSet$Mode3) {
                n15 = n13;
            } else {
                n15 = 0;
                cameraSet$Mode4 = null;
            }
            CameraSet$Mode cameraSet$Mode5 = CameraSet$Mode.video;
            if (cameraSet$Mode5 == cameraSet$Mode3) {
                n11 = n13;
            } else {
                n11 = 0;
                cameraSet$Mode5 = null;
            }
            if (l22 != false) {
                l17 = n15 != 0 ? (long)64 : (long)32;
                l19 |= l17;
            }
            if ((l22 = (l24 = (l17 = l19 & l20) - l18) == 0L ? 0 : (l24 < 0L ? -1 : 1)) != false) {
                if (n11 != 0) {
                    l17 = 1024L;
                    l19 |= l17;
                } else {
                    l19 |= l23;
                }
            }
            l22 = n15 != 0 ? (long)0 : (long)n12;
        } else {
            l22 = 0;
            n11 = 0;
            Object var20_16 = null;
        }
        long l25 = (l16 = (l23 &= l19) - l18) == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (l25 != false && (cameraSet$Mode2 = CameraSet$Mode.delay_video) == cameraSet$Mode3) {
            l25 = n13;
        } else {
            l25 = 0;
            cameraSet$Mode2 = null;
        }
        long l26 = (l15 = (l19 & l20) - l18) == 0L ? 0 : (l15 < 0L ? -1 : 1);
        l17 = 8;
        if (l26 != false) {
            if (n11 != 0) {
                l25 = n13;
            }
            if (l26 != false) {
                if (l25 != false) {
                    l14 = 16;
                    l19 |= l14;
                } else {
                    l19 |= l17;
                }
            }
        } else {
            l25 = 0;
            cameraSet$Mode2 = null;
        }
        if ((l26 = (l13 = (l14 = l19 & l17) - l18) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false && (cameraSet$Mode = CameraSet$Mode.dolly_zoom) == cameraSet$Mode3) {
            n10 = n13;
            f10 = f11;
        } else {
            n10 = 0;
            cameraSet$Mode3 = null;
            f10 = 0.0f;
        }
        l14 = l19 & l20;
        l26 = l14 == l18 ? 0 : (l14 < l18 ? -1 : 1);
        if (l26 != false) {
            if (l25 == false) {
                n13 = n10;
                f11 = f10;
            }
            if (l26 != false) {
                l23 = n13 != 0 ? 256L : 128L;
                l19 |= l23;
            }
            if (n13 != 0) {
                n12 = 0;
                onClickListener = null;
            }
            n14 = n12;
        }
        if ((n10 = (int)((l12 = (l11 = (long)4 & l19) - l18) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0) {
            cameraSet$Mode3 = s12.a;
            onClickListener = s12.v;
            cameraSet$Mode3.setOnClickListener(onClickListener);
        }
        if ((n10 = (int)((l10 = (l19 &= l20) - l18) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0) {
            s12.t.setVisibility(n14);
            cameraSet$Mode3 = s12.u;
            cameraSet$Mode3.setVisibility((int)l22);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.w;
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
            this.w = l10 = (long)4;
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
        int n11 = 90;
        if (n11 == n10) {
            CameraSet$Mode cameraSet$Mode = (CameraSet$Mode)((Object)object);
            this.B(cameraSet$Mode);
            return 1 != 0;
        } else {
            n11 = 23;
            if (n11 != n10) return 0 != 0;
            k1$a k1$a = (k1$a)object;
            this.A(k1$a);
        }
        return 1 != 0;
    }
}

