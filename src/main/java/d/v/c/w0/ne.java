/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.me.help.FeedbackDetailAddFragment$b;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.me;

public class ne
extends me
implements b$a {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private final View.OnClickListener g;
    private long h;

    static {
        SparseIntArray sparseIntArray;
        j = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362498, 2);
        sparseIntArray.put(2131363615, 3);
        sparseIntArray.put(2131363145, 4);
    }

    public ne(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private ne(DataBindingComponent object, View view, Object[] object2) {
        Object object3;
        Object object4;
        Object object5 = object4 = object2[2];
        object5 = (FrameLayout)object4;
        int n10 = 1;
        Object object6 = object3 = object2[n10];
        object6 = (ImageView)object3;
        Object object7 = object3 = object2[0];
        object7 = (LinearLayout)object3;
        Object object8 = object3 = object2[4];
        object8 = (RecyclerView)object3;
        object2 = object2[3];
        TextView textView = object2;
        textView = (TextView)object2;
        object3 = this;
        super(object, view, 0, (FrameLayout)object5, (ImageView)object6, (LinearLayout)object7, (RecyclerView)object8, textView);
        this.h = -1;
        this.b.setTag(null);
        this.c.setTag(null);
        this.setRootTag(view);
        object = new b(this, n10);
        this.g = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        FeedbackDetailAddFragment$b feedbackDetailAddFragment$b = this.f;
        boolean bl2 = feedbackDetailAddFragment$b != null;
        if (bl2) {
            feedbackDetailAddFragment$b.a(view);
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
            long l11 = this.h;
            this.h = l10 = 0L;
        }
        long l12 = 2;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            ImageView imageView = this.b;
            View.OnClickListener onClickListener = this.g;
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
            object = (FeedbackDetailAddFragment$b)object;
            this.z((FeedbackDetailAddFragment$b)object);
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
    public void z(FeedbackDetailAddFragment$b feedbackDetailAddFragment$b) {
        this.f = feedbackDetailAddFragment$b;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 1L;
            this.h = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

