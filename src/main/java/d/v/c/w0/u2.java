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
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.quvideo.mobile.external.component.cloudengine.model.CompositeConfig$Resolution;
import com.zhiyun.cama.cloud_engine.CEVideoSizeDialog$a;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.t2;

public class u2
extends t2
implements b$a {
    private static final ViewDataBinding$IncludedLayouts m;
    private static final SparseIntArray n;
    private final ConstraintLayout g;
    private final View.OnClickListener h;
    private final View.OnClickListener i;
    private final View.OnClickListener j;
    private final View.OnClickListener k;
    private long l;

    static {
        SparseIntArray sparseIntArray;
        n = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363319, 5);
    }

    public u2(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = m;
        SparseIntArray sparseIntArray = n;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private u2(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        int n10 = 1;
        Object object2 = object = objectArray[n10];
        object2 = (ImageView)object;
        int n11 = 2;
        Object object3 = object = objectArray[n11];
        object3 = (TextView)object;
        int n12 = 4;
        Object object4 = object = objectArray[n12];
        object4 = (TextView)object;
        int n13 = 3;
        Object object5 = object = objectArray[n13];
        object5 = (TextView)object;
        Object object6 = object = objectArray[5];
        object6 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 0, (ImageView)object2, (TextView)object3, (TextView)object4, (TextView)object5, (TextView)object6);
        this.l = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.g = object;
        object.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n10);
        this.h = object;
        object = new b(this, n13);
        this.i = object;
        object = new b(this, n12);
        this.j = object;
        object = new b(this, n11);
        this.k = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        CompositeConfig$Resolution compositeConfig$Resolution = null;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 != n13) {
                    n13 = 4;
                    if (n10 == n13) {
                        CEVideoSizeDialog$a cEVideoSizeDialog$a = this.f;
                        if (cEVideoSizeDialog$a != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            compositeConfig$Resolution = CompositeConfig$Resolution.R_480;
                            cEVideoSizeDialog$a.b(view, compositeConfig$Resolution);
                        }
                    }
                } else {
                    CEVideoSizeDialog$a cEVideoSizeDialog$a = this.f;
                    if (cEVideoSizeDialog$a != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        compositeConfig$Resolution = CompositeConfig$Resolution.R_720;
                        cEVideoSizeDialog$a.b(view, compositeConfig$Resolution);
                    }
                }
            } else {
                CEVideoSizeDialog$a cEVideoSizeDialog$a = this.f;
                if (cEVideoSizeDialog$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    compositeConfig$Resolution = CompositeConfig$Resolution.R_1080;
                    cEVideoSizeDialog$a.b(view, compositeConfig$Resolution);
                }
            }
        } else {
            CEVideoSizeDialog$a cEVideoSizeDialog$a = this.f;
            if (cEVideoSizeDialog$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                cEVideoSizeDialog$a.a();
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
        synchronized (this) {
            long l11 = this.l;
            this.l = l10 = 0L;
        }
        long l12 = 2;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            ImageView imageView = this.a;
            View.OnClickListener onClickListener = this.h;
            imageView.setOnClickListener(onClickListener);
            imageView = this.b;
            onClickListener = this.k;
            imageView.setOnClickListener(onClickListener);
            imageView = this.c;
            onClickListener = this.j;
            imageView.setOnClickListener(onClickListener);
            imageView = this.d;
            onClickListener = this.i;
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
            this.l = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (CEVideoSizeDialog$a)object;
            this.z((CEVideoSizeDialog$a)object);
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
    public void z(CEVideoSizeDialog$a cEVideoSizeDialog$a) {
        this.f = cEVideoSizeDialog$a;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 1L;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

