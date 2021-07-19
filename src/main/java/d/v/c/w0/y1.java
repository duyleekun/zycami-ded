/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.camera.dialog.more.GestureModeFragment$a;
import d.v.c.w0.x1;
import d.v.c.w0.y1$a;

public class y1
extends x1 {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private final CardView f;
    private y1$a g;
    private long h;

    static {
        SparseIntArray sparseIntArray;
        j = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363445, 3);
        sparseIntArray.put(2131363521, 4);
    }

    public y1(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private y1(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[1];
        object3 = (FrameLayout)object2;
        Object object4 = object2 = objectArray[2];
        object4 = (FrameLayout)object2;
        Object object5 = object2 = objectArray[3];
        object5 = (TextView)object2;
        Object object6 = object2 = objectArray[4];
        object6 = (TextView)object2;
        super(object, view, 0, (FrameLayout)object3, (FrameLayout)object4, (TextView)object5, (TextView)object6);
        this.h = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        object = (CardView)((Object)objectArray[0]);
        this.f = object;
        object.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        synchronized (this) {
            long l11 = this.h;
            this.h = l10 = 0L;
        }
        y1$a y1$a = null;
        GestureModeFragment$a gestureModeFragment$a = this.e;
        long l12 = 3;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false && gestureModeFragment$a != null) {
            y1$a y1$a2 = this.g;
            if (y1$a2 == null) {
                this.g = y1$a2 = new y1$a();
            }
            y1$a = y1$a2.b(gestureModeFragment$a);
        }
        if (l14 != false) {
            this.a.setOnClickListener(y1$a);
            FrameLayout frameLayout = this.b;
            frameLayout.setOnClickListener((View.OnClickListener)y1$a);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.h;
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
            this.h = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (GestureModeFragment$a)object;
            this.z((GestureModeFragment$a)object);
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
    public void z(GestureModeFragment$a gestureModeFragment$a) {
        this.e = gestureModeFragment$a;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 1L;
            this.h = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

