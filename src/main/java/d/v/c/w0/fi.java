/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.story.video.StoryReviewVideoView;
import d.v.c.f1.a.b$a;
import d.v.c.s0.h7.t0.b$c;
import d.v.c.s0.h7.u0.l;
import d.v.c.w0.ei;

public class fi
extends ei
implements b$a {
    private static final ViewDataBinding$IncludedLayouts o;
    private static final SparseIntArray p;
    private final ConstraintLayout i;
    private final ImageView j;
    private final View.OnClickListener k;
    private final View.OnClickListener l;
    private final View.OnClickListener m;
    private long n;

    static {
        SparseIntArray sparseIntArray;
        p = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363239, 4);
        sparseIntArray.put(2131362378, 5);
        sparseIntArray.put(2131362371, 6);
        sparseIntArray.put(2131363410, 7);
    }

    public fi(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = o;
        SparseIntArray sparseIntArray = p;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 8, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private fi(DataBindingComponent object, View object2, Object[] imageView) {
        Object object3;
        Object object4;
        Object object5 = object4 = imageView[6];
        object5 = (EditText)object4;
        Object object6 = object4 = imageView[5];
        object6 = (EditText)object4;
        Object object7 = object4 = imageView[4];
        object7 = (StoryReviewVideoView)((Object)object4);
        Object object8 = object4 = imageView[7];
        object8 = (TextView)object4;
        int n10 = 3;
        Object object9 = object3 = imageView[n10];
        object9 = (TextView)object3;
        int n11 = 2;
        Object object10 = object3 = imageView[n11];
        object10 = (TextView)object3;
        object3 = this;
        super(object, (View)object2, 1, (EditText)object5, (EditText)object6, (StoryReviewVideoView)((Object)object7), (TextView)object8, (TextView)object9, (TextView)object10);
        this.n = -1;
        object = (ConstraintLayout)((Object)imageView[0]);
        this.i = object;
        object.setTag(null);
        int n12 = 1;
        this.j = imageView = (ImageView)imageView[n12];
        imageView.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.setRootTag((View)object2);
        super(this, n12);
        this.k = object2;
        super(this, n11);
        this.l = object;
        super(this, n10);
        this.m = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.n;
                long l11 = 1L;
                this.n = l10 |= l11;
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
    public void A(b$c b$c) {
        this.g = b$c;
        synchronized (this) {
            long l10 = this.n;
            long l11 = 4;
            this.n = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(l l10) {
        this.h = l10;
        synchronized (this) {
            long l11 = this.n;
            long l12 = 2;
            this.n = l11 |= l12;
        }
        this.notifyPropertyChanged(1);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 == n13) {
                    b$c b$c = this.g;
                    if (b$c != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        b$c.b(view);
                    }
                }
            } else {
                b$c b$c = this.g;
                if (b$c != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    b$c.c();
                }
            }
        } else {
            b$c b$c = this.g;
            if (b$c != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                b$c.a();
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
        long l13;
        int n10;
        long l14;
        long l15;
        synchronized (this) {
            l15 = this.n;
            this.n = l14 = 0L;
        }
        Object object = this.h;
        long l16 = 11;
        long l17 = l15 & l16;
        long l18 = l17 == l14 ? 0 : (l17 < l14 ? -1 : 1);
        int n11 = 0;
        if (l18 != false) {
            Object object2 = null;
            if (object != null) {
                object = ((l)object).a;
            } else {
                n10 = 0;
                object = null;
            }
            this.updateLiveDataRegistration(0, (LiveData)object);
            if (object != null) {
                object2 = object = ((LiveData)object).getValue();
                object2 = (Boolean)object;
            }
            n10 = ViewDataBinding.safeUnbox(object2);
            if (l18 != false) {
                l13 = n10 != 0 ? (long)32 : (long)16;
                l15 |= l13;
            }
            if (n10 == 0) {
                n11 = n10 = 8;
            }
        }
        if ((n10 = (l12 = (l13 = (long)8 & l15) - l14) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != 0) {
            object = this.j;
            View.OnClickListener onClickListener = this.k;
            object.setOnClickListener(onClickListener);
            object = this.e;
            onClickListener = this.m;
            object.setOnClickListener(onClickListener);
            object = this.f;
            onClickListener = this.l;
            object.setOnClickListener(onClickListener);
        }
        if ((l11 = (l10 = (l15 &= l16) - l14) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            TextView textView = this.f;
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
            long l10 = this.n;
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
            this.n = l10 = (long)8;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (MutableLiveData)object;
        return this.C((MutableLiveData)object, n11);
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 1;
        if (n11 == n10) {
            object = (l)object;
            this.B((l)object);
        } else {
            int n12 = 23;
            if (n12 == n10) {
                object = (b$c)object;
                this.A((b$c)object);
            } else {
                n11 = 0;
            }
        }
        return n11;
    }
}

