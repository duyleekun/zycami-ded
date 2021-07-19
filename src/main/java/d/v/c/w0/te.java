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
import com.zhiyun.cama.me.help.FeedbackEditAddFragment$b;
import com.zhiyun.cama.me.help.view.AddImageRecyclerView;
import com.zhiyun.cama.me.help.view.ScrollEditText;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.se;
import d.v.c.w0.te$a;

public class te
extends se
implements b$a {
    private static final ViewDataBinding$IncludedLayouts l;
    private static final SparseIntArray m;
    private final LinearLayout h;
    private final View.OnClickListener i;
    private te$a j;
    private long k;

    static {
        SparseIntArray sparseIntArray;
        m = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362498, 3);
        sparseIntArray.put(2131363615, 4);
        sparseIntArray.put(2131362371, 5);
        sparseIntArray.put(2131363144, 6);
    }

    public te(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = l;
        SparseIntArray sparseIntArray = m;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private te(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[5];
        object4 = (ScrollEditText)object3;
        Object object5 = object3 = objectArray[3];
        object5 = (FrameLayout)object3;
        int n10 = 1;
        Object object6 = object2 = objectArray[n10];
        object6 = (ImageView)object2;
        Object object7 = object2 = objectArray[6];
        object7 = (AddImageRecyclerView)object2;
        Object object8 = object2 = objectArray[2];
        object8 = (TextView)object2;
        Object object9 = object2 = objectArray[4];
        object9 = (TextView)object2;
        object2 = this;
        super(object, view, 0, (ScrollEditText)object4, (FrameLayout)object5, (ImageView)object6, (AddImageRecyclerView)object7, (TextView)object8, (TextView)object9);
        this.k = -1;
        this.c.setTag(null);
        object = (LinearLayout)objectArray[0];
        this.h = object;
        object.setTag(null);
        this.e.setTag(null);
        this.setRootTag(view);
        object = new b(this, n10);
        this.i = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        FeedbackEditAddFragment$b feedbackEditAddFragment$b = this.g;
        boolean bl2 = feedbackEditAddFragment$b != null;
        if (bl2) {
            feedbackEditAddFragment$b.b(view);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        ImageView imageView;
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        synchronized (this) {
            l14 = this.k;
            this.k = l13 = 0L;
        }
        te$a te$a = null;
        FeedbackEditAddFragment$b feedbackEditAddFragment$b = this.g;
        long l15 = (long)3 & l14;
        long l16 = l15 == l13 ? 0 : (l15 < l13 ? -1 : 1);
        if (l16 != false && feedbackEditAddFragment$b != null) {
            te$a = this.j;
            if (te$a == null) {
                this.j = te$a = new te$a();
            }
            te$a = te$a.b(feedbackEditAddFragment$b);
        }
        if ((l12 = (l11 = (l14 &= (l10 = (long)2)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            imageView = this.c;
            View.OnClickListener onClickListener = this.i;
            imageView.setOnClickListener(onClickListener);
        }
        if (l16 != false) {
            imageView = this.e;
            imageView.setOnClickListener((View.OnClickListener)te$a);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.k;
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
            this.k = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (FeedbackEditAddFragment$b)object;
            this.z((FeedbackEditAddFragment$b)object);
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
    public void z(FeedbackEditAddFragment$b feedbackEditAddFragment$b) {
        this.g = feedbackEditAddFragment$b;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 1L;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

