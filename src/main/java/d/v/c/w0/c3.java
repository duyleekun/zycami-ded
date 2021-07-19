/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.album.AlbumDeleteConfirmDialog$a;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.o0.u0;
import d.v.c.w0.b3;

public class c3
extends b3
implements b$a {
    private static final ViewDataBinding$IncludedLayouts n;
    private static final SparseIntArray o;
    private final ConstraintLayout j;
    private final View.OnClickListener k;
    private final View.OnClickListener l;
    private long m;

    static {
        SparseIntArray sparseIntArray;
        o = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363608, 5);
        sparseIntArray.put(2131362287, 6);
        sparseIntArray.put(2131362292, 7);
    }

    public c3(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = n;
        SparseIntArray sparseIntArray = o;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 8, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private c3(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        int n10 = 1;
        Object object2 = object = objectArray[n10];
        object2 = (TextView)object;
        Object object3 = object = objectArray[6];
        object3 = (View)object;
        Object object4 = object = objectArray[7];
        object4 = (View)object;
        Object object5 = object = objectArray[3];
        object5 = (View)object;
        int n11 = 2;
        Object object6 = object = objectArray[n11];
        object6 = (TextView)object;
        Object object7 = object = objectArray[4];
        object7 = (ProgressBar)object;
        Object object8 = object = objectArray[5];
        object8 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 1, (TextView)object2, (View)object3, (View)object4, (View)object5, (TextView)object6, (ProgressBar)object7, (TextView)object8);
        this.m = -1;
        this.a.setTag(null);
        this.d.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.j = object;
        object.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        object = view;
        this.setRootTag(view);
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
    public void A(AlbumDeleteConfirmDialog$a albumDeleteConfirmDialog$a) {
        this.i = albumDeleteConfirmDialog$a;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 4;
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
    public void B(u0 u02) {
        this.h = u02;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 2;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(154);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                AlbumDeleteConfirmDialog$a albumDeleteConfirmDialog$a = this.i;
                if (albumDeleteConfirmDialog$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    albumDeleteConfirmDialog$a.a();
                }
            }
        } else {
            AlbumDeleteConfirmDialog$a albumDeleteConfirmDialog$a = this.i;
            if (albumDeleteConfirmDialog$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                albumDeleteConfirmDialog$a.b();
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
            l15 = this.m;
            this.m = l14 = 0L;
        }
        Object object = this.h;
        long l16 = 11;
        long l17 = l15 & l16;
        long l18 = l17 == l14 ? 0 : (l17 < l14 ? -1 : 1);
        int n11 = 0;
        float f10 = 0.0f;
        if (l18 != false) {
            float f11;
            int n12 = 0;
            float f12 = 0.0f;
            Object object2 = null;
            if (object != null) {
                object = ((u0)object).d;
            } else {
                n10 = 0;
                object = null;
                f11 = 0.0f;
            }
            this.updateLiveDataRegistration(0, (LiveData)object);
            if (object != null) {
                object2 = object = ((LiveData)object).getValue();
                object2 = (Integer)object;
            }
            n10 = ViewDataBinding.safeUnbox(object2);
            n12 = 1;
            f12 = Float.MIN_VALUE;
            int n13 = n10 == n12 ? n12 : 0;
            if (n10 == n12) {
                n12 = 0;
                object2 = null;
                f12 = 0.0f;
            }
            if (l18 != false) {
                long l19 = n13 != 0 ? (long)32 : (long)16;
                l15 |= l19;
            }
            if (n13 == 0) {
                n10 = 8;
                f11 = 1.1E-44f;
                n11 = n10;
                f10 = f11;
            }
            n10 = n11;
            f11 = f10;
            n11 = n12;
            f10 = f12;
        } else {
            n10 = 0;
            object = null;
            float f13 = 0.0f;
        }
        long l20 = (l13 = (l16 &= l15) - l14) == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l20 != false) {
            this.a.setEnabled(n11 != 0);
            this.d.setVisibility(n10);
            this.e.setEnabled(n11 != 0);
            ProgressBar progressBar = this.f;
            progressBar.setVisibility(n10);
        }
        if ((l12 = (l11 = (l15 &= (l10 = (long)8)) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            TextView textView = this.a;
            View.OnClickListener onClickListener = this.k;
            textView.setOnClickListener(onClickListener);
            textView = this.e;
            onClickListener = this.l;
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
        int n11 = 154;
        if (n11 == n10) {
            object = (u0)object;
            this.B((u0)object);
            return 1 != 0;
        } else {
            n11 = 23;
            if (n11 != n10) return 0 != 0;
            object = (AlbumDeleteConfirmDialog$a)object;
            this.A((AlbumDeleteConfirmDialog$a)object);
        }
        return 1 != 0;
    }
}

