/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.me.message.MessageTextFragment$a;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.of;

public class pf
extends of
implements b$a {
    private static final ViewDataBinding$IncludedLayouts j;
    private static final SparseIntArray k;
    private final LinearLayout g;
    private final View.OnClickListener h;
    private long i;

    static {
        SparseIntArray sparseIntArray;
        k = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363612, 2);
        sparseIntArray.put(2131363608, 3);
        sparseIntArray.put(2131363606, 4);
        sparseIntArray.put(2131363389, 5);
    }

    public pf(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = j;
        SparseIntArray sparseIntArray = k;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private pf(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        int n10 = 1;
        Object object3 = object2 = objectArray[n10];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[5];
        object4 = (TextView)object2;
        Object object5 = object2 = objectArray[4];
        object5 = (TextView)object2;
        Object object6 = object2 = objectArray[3];
        object6 = (TextView)object2;
        Object object7 = object2 = objectArray[2];
        object7 = (TextView)object2;
        super(object, view, 0, (ImageView)object3, (TextView)object4, (TextView)object5, (TextView)object6, (TextView)object7);
        this.i = -1;
        this.a.setTag(null);
        object = (LinearLayout)objectArray[0];
        this.g = object;
        object.setTag(null);
        this.setRootTag(view);
        object = new b(this, n10);
        this.h = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        MessageTextFragment$a messageTextFragment$a = this.f;
        boolean bl2 = messageTextFragment$a != null;
        if (bl2) {
            messageTextFragment$a.a(view);
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
            ImageView imageView = this.a;
            View.OnClickListener onClickListener = this.h;
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
            object = (MessageTextFragment$a)object;
            this.z((MessageTextFragment$a)object);
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
    public void z(MessageTextFragment$a messageTextFragment$a) {
        this.f = messageTextFragment$a;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 1L;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

