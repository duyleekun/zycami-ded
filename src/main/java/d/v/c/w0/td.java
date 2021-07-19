/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.camera.CameraFragment$j;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.d7.z;
import d.v.c.w0.sd;

public class td
extends sd
implements b$a {
    private static final ViewDataBinding$IncludedLayouts n;
    private static final SparseIntArray o;
    private final RelativeLayout g;
    private final LinearLayout h;
    private final TextView i;
    private final View.OnClickListener j;
    private final View.OnClickListener k;
    private final View.OnClickListener l;
    private long m;

    static {
        SparseIntArray sparseIntArray;
        o = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363694, 6);
    }

    public td(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = n;
        SparseIntArray sparseIntArray = o;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private td(DataBindingComponent object, View object2, Object[] textView) {
        Object object3;
        Object object4;
        Object object5 = object4 = textView[4];
        object5 = (ImageView)object4;
        int n10 = 1;
        Object object6 = object3 = textView[n10];
        object6 = (ImageView)object3;
        int n11 = 2;
        Object object7 = object3 = textView[n11];
        object7 = (RecyclerView)object3;
        Object object8 = object3 = textView[6];
        object8 = (View)object3;
        object3 = this;
        DataBindingComponent dataBindingComponent = object;
        super(object, (View)object2, 1, (ImageView)object5, (ImageView)object6, (RecyclerView)object7, (View)object8);
        this.m = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        object = (RelativeLayout)textView[0];
        this.g = object;
        object.setTag(null);
        int n12 = 3;
        dataBindingComponent = (LinearLayout)textView[n12];
        this.h = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.i = textView = (TextView)textView[5];
        textView.setTag(null);
        this.setRootTag((View)object2);
        super(this, n12);
        this.j = object2;
        object = new b(this, n10);
        this.k = object;
        object = new b(this, n11);
        this.l = object;
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
                long l10 = this.m;
                long l11 = 1L;
                this.m = l10 |= l11;
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
    public void A(CameraFragment$j cameraFragment$j) {
        this.e = cameraFragment$j;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 2;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(z z10) {
        this.f = z10;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 4;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(80);
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
                    CameraFragment$j cameraFragment$j = this.e;
                    if (cameraFragment$j != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        cameraFragment$j.o0();
                    }
                }
            } else {
                z z10 = this.f;
                if (z10 != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    z10.z0();
                }
            }
        } else {
            CameraFragment$j cameraFragment$j = this.e;
            if (cameraFragment$j != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                cameraFragment$j.n();
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
        int n10;
        Object object;
        long l13;
        long l14;
        synchronized (this) {
            l14 = this.m;
            this.m = l13 = 0L;
        }
        Object object2 = this.f;
        long l15 = 13;
        long l16 = l14 & l15;
        long l17 = l16 == l13 ? 0 : (l16 < l13 ? -1 : 1);
        int n11 = 0;
        if (l17 != false) {
            int n12 = 0;
            float f10 = 0.0f;
            object = null;
            if (object2 != null) {
                object2 = ((z)object2).P();
            } else {
                n10 = 0;
                object2 = null;
            }
            this.updateLiveDataRegistration(0, (LiveData)object2);
            if (object2 != null) {
                object2 = ((LiveData)object2).getValue();
                object = object2;
                object = (Boolean)object2;
            }
            n10 = ViewDataBinding.safeUnbox(object);
            if (l17 != false) {
                if (n10 != 0) {
                    l14 |= (long)32;
                    l12 = 128L;
                } else {
                    l14 |= (long)16;
                    l12 = 64;
                }
                l14 |= l12;
            }
            l17 = 8;
            float f11 = 1.1E-44f;
            if (n10 != 0) {
                n12 = 0;
                object = null;
                f10 = 0.0f;
            } else {
                n12 = l17;
                f10 = f11;
            }
            if (n10 != 0) {
                n11 = (int)l17;
            }
            n10 = n11;
            n11 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        l12 = (long)8 & l14;
        l17 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l17 != false) {
            ImageView imageView = this.a;
            object = this.l;
            imageView.setOnClickListener(object);
            imageView = this.b;
            object = this.k;
            imageView.setOnClickListener(object);
            imageView = this.i;
            object = this.j;
            imageView.setOnClickListener(object);
        }
        if ((l11 = (l10 = (l14 &= l15) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            this.c.setVisibility(n11);
            LinearLayout linearLayout = this.h;
            linearLayout.setVisibility(n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.m;
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
            this.m = l10 = (long)8;
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (CameraFragment$j)object;
            this.A((CameraFragment$j)object);
            return 1 != 0;
        } else {
            n11 = 80;
            if (n11 != n10) return 0 != 0;
            object = (z)object;
            this.B((z)object);
        }
        return 1 != 0;
    }
}

