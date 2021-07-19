/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.camera.liveassistant.LiveAssistantOpenSuccessDialog$a;
import d.v.c.f1.a.b$a;
import d.v.c.w0.ce;

public class de
extends ce
implements b$a {
    private static final ViewDataBinding$IncludedLayouts j;
    private static final SparseIntArray k;
    private final ConstraintLayout g;
    private final View.OnClickListener h;
    private long i;

    static {
        SparseIntArray sparseIntArray;
        k = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363319, 2);
        sparseIntArray.put(2131362913, 3);
        sparseIntArray.put(2131362163, 4);
        sparseIntArray.put(2131362554, 5);
    }

    public de(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = j;
        SparseIntArray sparseIntArray = k;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private de(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[4];
        object4 = (CheckBox)object3;
        int n10 = 1;
        Object object5 = object2 = objectArray[n10];
        object5 = (TextView)object2;
        Object object6 = object2 = objectArray[5];
        object6 = (View)object2;
        Object object7 = object2 = objectArray[3];
        object7 = (TextView)object2;
        Object object8 = object2 = objectArray[2];
        object8 = (TextView)object2;
        object2 = this;
        super(object, view, 0, (CheckBox)object4, (TextView)object5, (View)object6, (TextView)object7, (TextView)object8);
        this.i = -1;
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.g = object;
        object.setTag(null);
        this.setRootTag(view);
        super(this, n10);
        this.h = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        LiveAssistantOpenSuccessDialog$a liveAssistantOpenSuccessDialog$a = this.f;
        boolean bl2 = liveAssistantOpenSuccessDialog$a != null;
        if (bl2) {
            liveAssistantOpenSuccessDialog$a.a();
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
            long l11 = this.i;
            this.i = l10 = 0L;
        }
        long l12 = 2;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            TextView textView = this.b;
            View.OnClickListener onClickListener = this.h;
            textView.setOnClickListener(onClickListener);
        }
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
            this.i = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (LiveAssistantOpenSuccessDialog$a)object;
            this.z((LiveAssistantOpenSuccessDialog$a)object);
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
    public void z(LiveAssistantOpenSuccessDialog$a liveAssistantOpenSuccessDialog$a) {
        this.f = liveAssistantOpenSuccessDialog$a;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 1L;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

