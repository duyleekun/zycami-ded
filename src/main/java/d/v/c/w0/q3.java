/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.LinearLayout
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import d.v.c.s0.a7.j1;
import d.v.c.w0.p3;
import l.a.q.g0.u;

public class q3
extends p3 {
    private static final ViewDataBinding$IncludedLayouts g;
    private static final SparseIntArray h;
    private final LinearLayout e;
    private long f;

    public q3(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = g;
        SparseIntArray sparseIntArray = h;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private q3(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[1];
        object2 = (ProgressBar)object;
        Object object3 = object = objectArray[3];
        object3 = (TextView)object;
        Object object4 = object = objectArray[2];
        object4 = (TextView)object;
        super(dataBindingComponent, view, 3, (ProgressBar)object2, (TextView)object3, (TextView)object4);
        this.f = -1;
        dataBindingComponent = (LinearLayout)objectArray[0];
        this.e = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean A(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.f;
                long l11 = 4;
                this.f = l10 |= l11;
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
    private boolean B(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.f;
                long l11 = 2;
                this.f = l10 |= l11;
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
    private boolean C(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.f;
                long l11 = 1L;
                this.f = l10 |= l11;
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
    public void executeBindings() {
        long l10;
        long l11;
        long l12;
        boolean bl2;
        long l13;
        int n10;
        TextView textView;
        Object object;
        long l14;
        long l15;
        q3 q32 = this;
        synchronized (this) {
            l15 = this.f;
            this.f = l14 = 0L;
        }
        Object object2 = this.d;
        long l16 = (long)31 & l15;
        Object object3 = l16 == l14 ? 0 : (l16 < l14 ? -1 : 1);
        long l17 = 28;
        long l18 = 25;
        long l19 = 26;
        int n11 = 0;
        float f10 = 0.0f;
        MutableLiveData mutableLiveData = null;
        if (object3 != false) {
            long l20;
            long l21 = l15 & l18;
            long l22 = l21 - l14;
            object3 = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
            if (object3 != false) {
                object = object2 != null ? ((j1)object2).c : null;
                q32.updateLiveDataRegistration(0, (LiveData)object);
                object = object != null ? (String)((LiveData)object).getValue() : null;
                l20 = (long)TextUtils.isEmpty((CharSequence)object);
                if (object3 != false) {
                    long l23 = l20 != false ? 256L : 128L;
                    l15 |= l23;
                }
                if (l20 != false) {
                    object3 = 8;
                } else {
                    object3 = 0;
                    textView = null;
                }
            } else {
                object3 = 0;
                textView = null;
                object = null;
            }
            long l24 = l15 & l19;
            l20 = l24 == l14 ? 0 : (l24 < l14 ? -1 : 1);
            if (l20 != false) {
                Integer n12;
                if (object2 != null) {
                    mutableLiveData = ((j1)object2).b;
                } else {
                    n11 = 0;
                    mutableLiveData = null;
                    f10 = 0.0f;
                }
                n10 = 1;
                q32.updateLiveDataRegistration(n10, mutableLiveData);
                if (mutableLiveData != null) {
                    n12 = (Integer)mutableLiveData.getValue();
                } else {
                    n10 = 0;
                    n12 = null;
                }
                n10 = ViewDataBinding.safeUnbox(n12);
            } else {
                n10 = 0;
                Object var29_21 = null;
            }
            long l25 = l15 & l17;
            l13 = l25 == l14 ? 0 : (l25 < l14 ? -1 : 1);
            if (l13 != false) {
                if (object2 != null) {
                    object2 = ((j1)object2).d;
                } else {
                    bl2 = false;
                    object2 = null;
                }
                n11 = 2;
                f10 = 2.8E-45f;
                q32.updateLiveDataRegistration(n11, (LiveData)object2);
                if (object2 != null) {
                    object2 = (String)((LiveData)object2).getValue();
                } else {
                    bl2 = false;
                    object2 = null;
                }
                n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
                if (l13 != false) {
                    l25 = n11 != 0 ? (long)64 : (long)32;
                    l15 |= l25;
                }
                if (n11 != 0) {
                    n11 = 8;
                    f10 = 1.1E-44f;
                } else {
                    n11 = 0;
                    f10 = 0.0f;
                    mutableLiveData = null;
                }
                int n13 = n10;
                n10 = (int)object3;
                object3 = n11;
                n11 = n13;
            } else {
                n11 = n10;
                bl2 = false;
                object2 = null;
                n10 = (int)object3;
                object3 = 0;
                textView = null;
            }
        } else {
            bl2 = false;
            object2 = null;
            object = null;
            object3 = 0;
            textView = null;
            n10 = 0;
            Object var29_22 = null;
            n11 = 0;
            f10 = 0.0f;
            mutableLiveData = null;
        }
        long l26 = l15 & l19;
        l13 = l26 == l14 ? 0 : (l26 < l14 ? -1 : 1);
        if (l13 != false) {
            ProgressBar progressBar = q32.a;
            progressBar.setProgress(n11);
        }
        if ((l12 = (l11 = (l17 &= l15) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            TextView textView2 = q32.b;
            textView2.setVisibility((int)object3);
            textView = q32.b;
            u.n(textView, (String)object2, null, null);
        }
        if (bl2 = (l10 = (l15 &= (l16 = (long)25)) - l14) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            q32.c.setVisibility(n10);
            object2 = q32.c;
            u.n((TextView)object2, (String)object, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.f;
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
            this.f = l10 = (long)16;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
                if (n10 != n12) {
                    return false;
                }
                object = (MutableLiveData)object;
                return this.A((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.B((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.C((MutableLiveData)object, n11);
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 111;
        if (n11 == n10) {
            object = (j1)object;
            this.z((j1)object);
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
    public void z(j1 j12) {
        this.d = j12;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 8;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(111);
        super.requestRebind();
    }
}

