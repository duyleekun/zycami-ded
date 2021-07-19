/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.recyclerview.widget.RecyclerView;
import com.quvideo.mobile.external.component.cloudengine.model.RequestError;
import com.zhiyun.cama.cloud_engine.CEPullToRefreshLayout;
import com.zhiyun.cama.cloud_engine.CETemplateFragment$b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.p2;
import l.a.q.g0.u;

public class q2
extends p2
implements b$a {
    private static final ViewDataBinding$IncludedLayouts m;
    private static final SparseIntArray n;
    private final ConstraintLayout i;
    private final View.OnClickListener j;
    private final View.OnClickListener k;
    private long l;

    static {
        SparseIntArray sparseIntArray;
        n = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363319, 4);
        sparseIntArray.put(2131363092, 5);
        sparseIntArray.put(2131363091, 6);
    }

    public q2(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = m;
        SparseIntArray sparseIntArray = n;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private q2(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        int n10 = 1;
        Object object4 = object3 = objectArray[n10];
        object4 = (ImageView)object3;
        int n11 = 2;
        Object object5 = object2 = objectArray[n11];
        object5 = (TextView)object2;
        Object object6 = object2 = objectArray[6];
        object6 = (RecyclerView)object2;
        Object object7 = object2 = objectArray[5];
        object7 = (CEPullToRefreshLayout)object2;
        Object object8 = object2 = objectArray[3];
        object8 = (TextView)object2;
        Object object9 = object2 = objectArray[4];
        object9 = (TextView)object2;
        object2 = this;
        super(object, view, 1, (ImageView)object4, (TextView)object5, (RecyclerView)object6, (CEPullToRefreshLayout)object7, (TextView)object8, (TextView)object9);
        this.l = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.i = object;
        object.setTag(null);
        this.e.setTag(null);
        this.setRootTag(view);
        super(this, n11);
        this.j = object;
        super(this, n10);
        this.k = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(ObservableField observableField, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.l;
                long l11 = 1L;
                this.l = l10 |= l11;
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
    public void A(CETemplateFragment$b cETemplateFragment$b) {
        this.h = cETemplateFragment$b;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 2;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(ObservableField observableField) {
        this.updateRegistration(0, observableField);
        this.g = observableField;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 1L;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(59);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                CETemplateFragment$b cETemplateFragment$b = this.h;
                if (cETemplateFragment$b != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    cETemplateFragment$b.b();
                }
            }
        } else {
            CETemplateFragment$b cETemplateFragment$b = this.h;
            if (cETemplateFragment$b != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                cETemplateFragment$b.a();
            }
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
        String string2;
        int n10;
        long l13;
        long l14;
        synchronized (this) {
            l14 = this.l;
            this.l = l13 = 0L;
        }
        Object object = this.g;
        long l15 = 5;
        long l16 = l14 & l15;
        long l17 = l16 == l13 ? 0 : (l16 < l13 ? -1 : 1);
        int n11 = 0;
        if (l17 != false) {
            if (object != null) {
                object = (RequestError)((ObservableField)object).get();
            } else {
                n10 = 0;
                object = null;
            }
            string2 = object != null ? ((RequestError)object).getMessage() : null;
            if (object != null) {
                n10 = 1;
            } else {
                n10 = 0;
                object = null;
            }
            if (l17 != false) {
                l12 = n10 != 0 ? (long)16 : (long)8;
                l14 |= l12;
            }
            if (n10 == 0) {
                n11 = n10 = 8;
            }
        } else {
            string2 = null;
        }
        l12 = (long)4 & l14;
        n10 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (n10 != 0) {
            object = this.a;
            View.OnClickListener onClickListener = this.k;
            object.setOnClickListener(onClickListener);
            object = this.e;
            onClickListener = this.j;
            object.setOnClickListener(onClickListener);
        }
        if ((l11 = (l10 = (l14 &= l15) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            this.b.setVisibility(n11);
            u.n(this.b, string2, null, null);
            TextView textView = this.e;
            textView.setVisibility(n11);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.l;
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
            this.l = l10 = (long)4;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (ObservableField)object;
        return this.C((ObservableField)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 59;
        if (n11 == n10) {
            object = (ObservableField)object;
            this.B((ObservableField)object);
            return 1 != 0;
        } else {
            n11 = 23;
            if (n11 != n10) return 0 != 0;
            object = (CETemplateFragment$b)object;
            this.A((CETemplateFragment$b)object);
        }
        return 1 != 0;
    }
}

