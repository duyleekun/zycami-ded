/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.l1.x$b;
import d.v.c.w0.r;

public class s
extends r
implements b$a {
    private static final ViewDataBinding$IncludedLayouts r;
    private static final SparseIntArray s;
    private final ConstraintLayout i;
    private final View.OnClickListener j;
    private final View.OnClickListener k;
    private final View.OnClickListener l;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private long q;

    public s(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = r;
        SparseIntArray sparseIntArray = s;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 8, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private s(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[3];
        object2 = (Button)object;
        Object object3 = object = objectArray[2];
        object3 = (Button)object;
        Object object4 = object = objectArray[1];
        object4 = (Button)object;
        int n10 = 4;
        Object object5 = object = objectArray[n10];
        object5 = (Button)object;
        int n11 = 5;
        Object object6 = object = objectArray[n11];
        object6 = (Button)object;
        int n12 = 6;
        Object object7 = object = objectArray[n12];
        object7 = (Button)object;
        int n13 = 7;
        Object object8 = object = objectArray[n13];
        object8 = (Button)object;
        object = this;
        super(dataBindingComponent, view, 0, (Button)object2, (Button)object3, (Button)object4, (Button)object5, (Button)object6, (Button)object7, (Button)object8);
        this.q = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.i = object;
        object.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n12);
        this.j = object;
        object = new b(this, n13);
        this.k = object;
        object = new b(this, n10);
        this.l = object;
        object = new b(this, n11);
        this.m = object;
        object = new b(this, 2);
        this.n = object;
        object = new b(this, 3);
        this.o = object;
        object = new b(this, 1);
        this.p = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        boolean bl2 = true;
        switch (n10) {
            default: {
                break;
            }
            case 7: {
                x$b x$b = this.h;
                if (x$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                x$b.b();
                break;
            }
            case 6: {
                x$b x$b = this.h;
                if (x$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                x$b.c();
                break;
            }
            case 5: {
                x$b x$b = this.h;
                if (x$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                x$b.a();
                break;
            }
            case 4: {
                x$b x$b = this.h;
                if (x$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                x$b.h();
                break;
            }
            case 3: {
                x$b x$b = this.h;
                if (x$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                x$b.g();
                break;
            }
            case 2: {
                x$b x$b = this.h;
                if (x$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                x$b.f();
                break;
            }
            case 1: {
                x$b x$b = this.h;
                if (x$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                x$b.e();
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
            long l11 = this.q;
            this.q = l10 = 0L;
        }
        long l12 = 2;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            Button button = this.a;
            View.OnClickListener onClickListener = this.o;
            button.setOnClickListener(onClickListener);
            button = this.b;
            onClickListener = this.n;
            button.setOnClickListener(onClickListener);
            button = this.c;
            onClickListener = this.p;
            button.setOnClickListener(onClickListener);
            button = this.d;
            onClickListener = this.l;
            button.setOnClickListener(onClickListener);
            button = this.e;
            onClickListener = this.m;
            button.setOnClickListener(onClickListener);
            button = this.f;
            onClickListener = this.j;
            button.setOnClickListener(onClickListener);
            button = this.g;
            onClickListener = this.k;
            button.setOnClickListener(onClickListener);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.q;
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
            this.q = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (x$b)object;
            this.z((x$b)object);
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
    public void z(x$b x$b) {
        this.h = x$b;
        synchronized (this) {
            long l10 = this.q;
            long l11 = 1L;
            this.q = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }
}

