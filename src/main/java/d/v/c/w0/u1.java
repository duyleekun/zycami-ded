/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.camera.widget.WheelPicker;
import d.v.c.f1.a.b$a;
import d.v.c.s0.a7.x0$a;
import d.v.c.w0.t1;

public class u1
extends t1
implements b$a {
    private static final ViewDataBinding$IncludedLayouts s;
    private static final SparseIntArray t;
    private final ConstraintLayout p;
    private final View.OnClickListener q;
    private long r;

    static {
        SparseIntArray sparseIntArray;
        t = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363110, 2);
        sparseIntArray.put(2131363040, 3);
        sparseIntArray.put(2131363018, 4);
        sparseIntArray.put(2131363723, 5);
        sparseIntArray.put(2131363574, 6);
        sparseIntArray.put(2131363754, 7);
        sparseIntArray.put(2131363697, 8);
        sparseIntArray.put(2131363701, 9);
        sparseIntArray.put(2131363480, 10);
        sparseIntArray.put(2131363753, 11);
        sparseIntArray.put(2131363431, 12);
        sparseIntArray.put(2131363752, 13);
        sparseIntArray.put(2131362586, 14);
    }

    public u1(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = s;
        SparseIntArray sparseIntArray = t;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 15, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private u1(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object = this;
        ImageView imageView = (ImageView)objectArray[14];
        ImageView imageView2 = (ImageView)objectArray[1];
        RadioButton radioButton = (RadioButton)objectArray[4];
        RadioButton radioButton2 = (RadioButton)objectArray[3];
        RadioGroup radioGroup = (RadioGroup)objectArray[2];
        TextView textView = (TextView)objectArray[12];
        TextView textView2 = (TextView)objectArray[10];
        TextView textView3 = (TextView)objectArray[6];
        View view2 = (View)objectArray[8];
        View view3 = (View)objectArray[9];
        View view4 = (View)objectArray[5];
        WheelPicker wheelPicker = (WheelPicker)((Object)objectArray[13]);
        WheelPicker wheelPicker2 = (WheelPicker)((Object)objectArray[11]);
        WheelPicker wheelPicker3 = (WheelPicker)((Object)objectArray[7]);
        super(dataBindingComponent, view, 0, imageView, imageView2, radioButton, radioButton2, radioGroup, textView, textView2, textView3, view2, view3, view4, wheelPicker, wheelPicker2, wheelPicker3);
        this.r = -1;
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.p = object;
        object.setTag(null);
        object = view;
        this.setRootTag(view);
        super(this, 1);
        this.q = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        x0$a x0$a = this.o;
        boolean bl2 = x0$a != null;
        if (bl2) {
            x0$a.a();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        synchronized (this) {
            long l11 = this.r;
            this.r = l10 = 0L;
        }
        long l12 = 2;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            ImageView imageView = this.b;
            View.OnClickListener onClickListener = this.q;
            imageView.setOnClickListener(onClickListener);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.r;
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
            this.r = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (x0$a)object;
            this.z((x0$a)object);
            n10 = 1;
        } else {
            n10 = 0;
        }
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void z(x0$a x0$a) {
        this.o = x0$a;
        synchronized (this) {
            long l10 = this.r;
            long l11 = 1L;
            this.r = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

