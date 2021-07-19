/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import d.v.c.b1.t.f$a;
import d.v.c.b1.t.g;
import d.v.c.i1.i2;
import d.v.c.q0.f.a;
import d.v.c.w0.d5;
import d.v.c.w0.sf;

public class e5
extends d5 {
    private static final ViewDataBinding$IncludedLayouts g;
    private static final SparseIntArray h;
    private final ConstraintLayout e;
    private long f;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        g = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(2);
        String[] stringArray = new String[]{"media_duration_layout"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = n10;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558715;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        h = null;
    }

    public e5(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = g;
        SparseIntArray sparseIntArray = h;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 2, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private e5(DataBindingComponent object, View view, Object[] objectArray) {
        sf sf2 = (sf)objectArray[1];
        super(object, view, 5, sf2);
        this.f = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.e = object;
        object.setTag(null);
        object = this.a;
        this.setContainedBinding((ViewDataBinding)object);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(sf sf2, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.f;
                long l11 = 8;
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
    private boolean F(MutableLiveData mutableLiveData, int n10) {
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
    private boolean G(MutableLiveData mutableLiveData, int n10) {
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
    private boolean H(MutableLiveData mutableLiveData, int n10) {
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
    private boolean I(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.f;
                long l11 = 16;
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
    public void B(f$a f$a) {
        this.d = f$a;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 32;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(i2 i22) {
        this.b = i22;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 64;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(g g10) {
        this.c = g10;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 128L;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(158);
        super.requestRebind();
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
        long l14;
        long l15;
        Object object;
        boolean bl2;
        Object object2;
        Object object3;
        MutableLiveData mutableLiveData;
        long l16;
        long l17;
        long l18;
        long l19;
        Object object4;
        Object object5;
        Object object6;
        long l20;
        long l21;
        e5 e52;
        block30: {
            Object object7;
            block29: {
                long l22;
                e52 = this;
                synchronized (this) {
                    l21 = this.f;
                    this.f = l20 = 0L;
                }
                object6 = this.d;
                object5 = this.b;
                object4 = this.c;
                long l23 = 0x120L & l21;
                l19 = l23 == l20 ? 0 : (l23 < l20 ? -1 : 1);
                long l24 = 0x146L & l21;
                object7 = l24 == l20 ? 0 : (l24 < l20 ? -1 : 1);
                l18 = 324L;
                l17 = 322L;
                if (object7 == false) break block29;
                l16 = l21 & l17;
                long l25 = l16 - l20;
                object7 = l25 == 0L ? 0 : (l25 < 0L ? -1 : 1);
                if (object7 != false) {
                    if (object5 != null) {
                        mutableLiveData = ((i2)object5).T0();
                    } else {
                        object7 = 0;
                        mutableLiveData = null;
                    }
                    object3 = 1;
                    e52.updateLiveDataRegistration((int)object3, mutableLiveData);
                    if (mutableLiveData != null) {
                        object2 = (Long)mutableLiveData.getValue();
                    }
                } else {
                    object7 = 0;
                    mutableLiveData = null;
                }
                if ((object3 = (l22 = (l16 = l21 & l18) - l20) == 0L ? 0 : (l22 < 0L ? -1 : 1)) != false) {
                    object5 = object5 != null ? ((i2)object5).c2() : null;
                    object3 = 2;
                    e52.updateLiveDataRegistration((int)object3, (LiveData)object5);
                    if (object5 != null) {
                        object2 = (Long)((LiveData)object5).getValue();
                    }
                    break block30;
                } else {
                    object5 = null;
                }
                break block30;
            }
            object5 = null;
            object7 = 0;
            mutableLiveData = null;
        }
        l16 = 0x191L & l21;
        object3 = l16 == l20 ? 0 : (l16 < l20 ? -1 : 1);
        long l26 = 400L;
        long l27 = 385L;
        if (object3 != false) {
            long l28;
            long l29;
            long l30 = l21 & l27;
            long l31 = l30 - l20;
            object3 = l31 == 0L ? 0 : (l31 < 0L ? -1 : 1);
            if (object3 != false) {
                if (object4 != null) {
                    object2 = ((g)object4).s4();
                } else {
                    object3 = 0;
                    object2 = null;
                }
                bl2 = false;
                object = null;
                e52.updateLiveDataRegistration(0, (LiveData)object2);
                if (object2 != null) {
                    object = (Boolean)((LiveData)object2).getValue();
                }
            } else {
                object3 = 0;
                object2 = null;
            }
            if (bl2 = (l29 = (l28 = l21 & l26) - l20) == 0L ? 0 : (l29 < 0L ? -1 : 1)) {
                if (object4 != null) {
                    object = ((g)object4).t4();
                } else {
                    bl2 = false;
                    object = null;
                }
                int n10 = 4;
                e52.updateLiveDataRegistration(n10, (LiveData)object);
                if (object != null) {
                    object4 = (Boolean)((LiveData)object).getValue();
                }
                object4 = object;
                object = object2;
            } else {
                object = object2;
                boolean bl3 = false;
                object4 = null;
            }
        } else {
            boolean bl4 = false;
            object4 = null;
            bl2 = false;
            object = null;
        }
        l27 = l21 & l27;
        object3 = l27 == l20 ? 0 : (l27 < l20 ? -1 : 1);
        if (object3 != false) {
            object2 = e52.a;
            ((sf)object2).D((MutableLiveData)object);
        }
        if (bl2 = (l15 = (l14 = l21 & l26) - l20) == 0L ? 0 : (l15 < 0L ? -1 : 1)) {
            object = e52.a;
            ((sf)object).E((MutableLiveData)object4);
        }
        if (l19 != false) {
            object4 = e52.a;
            ((sf)object4).F((a)object6);
        }
        if ((l13 = (l12 = (l11 = l21 & l17) - l20) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            object6 = e52.a;
            ((sf)object6).G(mutableLiveData);
        }
        if ((l13 = (l10 = (l21 &= l18) - l20) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            object6 = e52.a;
            ((sf)object6).H((MutableLiveData)object5);
        }
        ViewDataBinding.executeBindingsOn(e52.a);
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
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            sf sf2 = this.a;
            l12 = (long)sf2.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            return false;
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
            this.f = l10 = 256L;
        }
        this.a.invalidateAll();
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
                if (n10 != n12) {
                    n12 = 3;
                    if (n10 != n12) {
                        n12 = 4;
                        if (n10 != n12) {
                            return false;
                        }
                        object = (MutableLiveData)object;
                        return this.I((MutableLiveData)object, n11);
                    }
                    object = (sf)object;
                    return this.E((sf)object, n11);
                }
                object = (MutableLiveData)object;
                return this.G((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.F((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.H((MutableLiveData)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.a.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (f$a)object;
            this.B((f$a)object);
            return 1 != 0;
        } else {
            n11 = 152;
            if (n11 == n10) {
                object = (i2)object;
                this.C((i2)object);
                return 1 != 0;
            } else {
                n11 = 158;
                if (n11 != n10) return 0 != 0;
                object = (g)object;
                this.D((g)object);
            }
        }
        return 1 != 0;
    }
}

