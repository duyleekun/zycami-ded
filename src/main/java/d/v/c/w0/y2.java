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
import com.zhiyun.cama.publish.CreationFragment$a;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.x2;

public class y2
extends x2
implements b$a {
    private static final ViewDataBinding$IncludedLayouts t;
    private static final SparseIntArray u;
    private final ConstraintLayout j;
    private final View.OnClickListener k;
    private final View.OnClickListener l;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private final View.OnClickListener q;
    private final View.OnClickListener r;
    private long s;

    public y2(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = t;
        SparseIntArray sparseIntArray = u;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 9, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private y2(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[1];
        object2 = (ImageView)object;
        Object object3 = object = objectArray[7];
        object3 = (TextView)object;
        int n10 = 3;
        Object object4 = object = objectArray[n10];
        object4 = (TextView)object;
        Object object5 = object = objectArray[2];
        object5 = (ImageView)object;
        int n11 = 6;
        Object object6 = object = objectArray[n11];
        object6 = (TextView)object;
        int n12 = 4;
        Object object7 = object = objectArray[n12];
        object7 = (TextView)object;
        int n13 = 5;
        Object object8 = object = objectArray[n13];
        object8 = (TextView)object;
        int n14 = 8;
        Object object9 = object = objectArray[n14];
        object9 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 0, (ImageView)object2, (TextView)object3, (TextView)object4, (ImageView)object5, (TextView)object6, (TextView)object7, (TextView)object8, (TextView)object9);
        this.s = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.j = object;
        object.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n13);
        this.k = object;
        object = new b(this, n11);
        this.l = object;
        object = new b(this, n10);
        this.m = object;
        object = new b(this, 4);
        this.n = object;
        object = new b(this, 1);
        this.o = object;
        object = new b(this, 2);
        this.p = object;
        object = new b(this, 8);
        this.q = object;
        object = new b(this, 7);
        this.r = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        boolean bl2 = true;
        switch (n10) {
            default: {
                break;
            }
            case 8: {
                CreationFragment$a creationFragment$a = this.i;
                if (creationFragment$a == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                creationFragment$a.h();
                break;
            }
            case 7: {
                CreationFragment$a creationFragment$a = this.i;
                if (creationFragment$a == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                creationFragment$a.c();
                break;
            }
            case 6: {
                CreationFragment$a creationFragment$a = this.i;
                if (creationFragment$a == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                creationFragment$a.f();
                break;
            }
            case 5: {
                CreationFragment$a creationFragment$a = this.i;
                if (creationFragment$a == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                creationFragment$a.b();
                break;
            }
            case 4: {
                CreationFragment$a creationFragment$a = this.i;
                if (creationFragment$a == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                creationFragment$a.g();
                break;
            }
            case 3: {
                CreationFragment$a creationFragment$a = this.i;
                if (creationFragment$a == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                creationFragment$a.d();
                break;
            }
            case 2: {
                CreationFragment$a creationFragment$a = this.i;
                if (creationFragment$a == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                creationFragment$a.e();
                break;
            }
            case 1: {
                CreationFragment$a creationFragment$a = this.i;
                if (creationFragment$a == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                creationFragment$a.a();
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
            long l11 = this.s;
            this.s = l10 = 0L;
        }
        long l12 = 2;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            ImageView imageView = this.a;
            View.OnClickListener onClickListener = this.o;
            imageView.setOnClickListener(onClickListener);
            imageView = this.b;
            onClickListener = this.r;
            imageView.setOnClickListener(onClickListener);
            imageView = this.c;
            onClickListener = this.m;
            imageView.setOnClickListener(onClickListener);
            imageView = this.d;
            onClickListener = this.p;
            imageView.setOnClickListener(onClickListener);
            imageView = this.e;
            onClickListener = this.l;
            imageView.setOnClickListener(onClickListener);
            imageView = this.f;
            onClickListener = this.n;
            imageView.setOnClickListener(onClickListener);
            imageView = this.g;
            onClickListener = this.k;
            imageView.setOnClickListener(onClickListener);
            imageView = this.h;
            onClickListener = this.q;
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
            long l10 = this.s;
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
            this.s = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (CreationFragment$a)object;
            this.z((CreationFragment$a)object);
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
    public void z(CreationFragment$a creationFragment$a) {
        this.i = creationFragment$a;
        synchronized (this) {
            long l10 = this.s;
            long l11 = 1L;
            this.s = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

