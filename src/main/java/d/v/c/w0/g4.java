/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.editorinterface.compose.ComposeParams$Resolution;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.f4;
import d.v.c.z0.j$a;

public class g4
extends f4
implements b$a {
    private static final ViewDataBinding$IncludedLayouts n;
    private static final SparseIntArray o;
    private final ConstraintLayout g;
    private final View.OnClickListener h;
    private final View.OnClickListener i;
    private final View.OnClickListener j;
    private final View.OnClickListener k;
    private final View.OnClickListener l;
    private long m;

    static {
        SparseIntArray sparseIntArray;
        o = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363319, 5);
    }

    public g4(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = n;
        SparseIntArray sparseIntArray = o;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private g4(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        int n10 = 2;
        Object object2 = object = objectArray[n10];
        object2 = (TextView)object;
        int n11 = 4;
        Object object3 = object = objectArray[n11];
        object3 = (TextView)object;
        int n12 = 1;
        Object object4 = object = objectArray[n12];
        object4 = (TextView)object;
        int n13 = 3;
        Object object5 = object = objectArray[n13];
        object5 = (TextView)object;
        int n14 = 5;
        Object object6 = object = objectArray[n14];
        object6 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 0, (TextView)object2, (TextView)object3, (TextView)object4, (TextView)object5, (TextView)object6);
        this.m = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.g = object;
        object.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n10);
        this.h = object;
        object = new b(this, n12);
        this.i = object;
        object = new b(this, n13);
        this.j = object;
        object = new b(this, n14);
        this.k = object;
        object = new b(this, n11);
        this.l = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        ComposeParams$Resolution composeParams$Resolution = null;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 != n13) {
                    n13 = 4;
                    if (n10 != n13) {
                        n13 = 5;
                        if (n10 == n13) {
                            j$a j$a = this.f;
                            if (j$a != null) {
                                n11 = n12;
                            }
                            if (n11 != 0) {
                                composeParams$Resolution = ComposeParams$Resolution.RESOLUTION_480P;
                                j$a.a(view, composeParams$Resolution);
                            }
                        }
                    } else {
                        j$a j$a = this.f;
                        if (j$a != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            composeParams$Resolution = ComposeParams$Resolution.RESOLUTION_720P;
                            j$a.a(view, composeParams$Resolution);
                        }
                    }
                } else {
                    j$a j$a = this.f;
                    if (j$a != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        composeParams$Resolution = ComposeParams$Resolution.RESOLUTION_1080P;
                        j$a.a(view, composeParams$Resolution);
                    }
                }
            } else {
                j$a j$a = this.f;
                if (j$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    composeParams$Resolution = ComposeParams$Resolution.RESOLUTION_4K;
                    j$a.a(view, composeParams$Resolution);
                }
            }
        } else {
            j$a j$a = this.f;
            if (j$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                j$a.b();
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
            long l11 = this.m;
            this.m = l10 = 0L;
        }
        long l12 = 2;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            ConstraintLayout constraintLayout = this.g;
            View.OnClickListener onClickListener = this.i;
            constraintLayout.setOnClickListener(onClickListener);
            constraintLayout = this.a;
            onClickListener = this.j;
            constraintLayout.setOnClickListener(onClickListener);
            constraintLayout = this.b;
            onClickListener = this.k;
            constraintLayout.setOnClickListener(onClickListener);
            constraintLayout = this.c;
            onClickListener = this.h;
            constraintLayout.setOnClickListener(onClickListener);
            constraintLayout = this.d;
            onClickListener = this.l;
            constraintLayout.setOnClickListener(onClickListener);
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
            this.m = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (j$a)object;
            this.z((j$a)object);
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
    public void z(j$a j$a) {
        this.f = j$a;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 1L;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

