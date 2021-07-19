/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.set.SetPrivateFragment$a;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.q1.g0;
import d.v.c.w0.sg;
import d.v.c.w0.tg$a;
import d.v.c.w0.tg$b;

public class tg
extends sg
implements b$a {
    private static final ViewDataBinding$IncludedLayouts n;
    private static final SparseIntArray o;
    private final LinearLayout g;
    private final TextView h;
    private final TextView i;
    private final View.OnClickListener j;
    private tg$b k;
    private tg$a l;
    private long m;

    public tg(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = n;
        SparseIntArray sparseIntArray = o;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private tg(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[3];
        object4 = (CheckBox)object3;
        Object object5 = object3 = objectArray[2];
        object5 = (CheckBox)object3;
        Object object6 = object3 = objectArray[4];
        object6 = (CheckBox)object3;
        int n10 = 1;
        Object object7 = object2 = objectArray[n10];
        object7 = (ImageView)object2;
        object2 = this;
        super(object, view, 3, (CheckBox)object4, (CheckBox)object5, (CheckBox)object6, (ImageView)object7);
        this.m = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        object = (LinearLayout)objectArray[0];
        this.g = object;
        object.setTag(null);
        object = (TextView)objectArray[5];
        this.h = object;
        object.setTag(null);
        object = (TextView)objectArray[6];
        this.i = object;
        object.setTag(null);
        this.setRootTag(view);
        object = new b(this, n10);
        this.j = object;
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
    private boolean D(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 2;
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
    private boolean E(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 4;
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
    public void A(SetPrivateFragment$a setPrivateFragment$a) {
        this.e = setPrivateFragment$a;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 8;
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
    public void B(g0 g02) {
        this.f = g02;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 16;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        SetPrivateFragment$a setPrivateFragment$a = this.e;
        boolean bl2 = setPrivateFragment$a != null;
        if (bl2) {
            setPrivateFragment$a.a(view);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        ImageView imageView;
        long l10;
        long l11;
        long l12;
        long l13;
        int n10;
        long l14;
        Object object;
        int n11;
        long l15;
        long l16;
        Object object2;
        long l17;
        tg$b tg$b;
        long l18;
        Object object3;
        Object object4;
        long l19;
        long l20;
        tg tg2;
        block28: {
            Object object5;
            block29: {
                block26: {
                    block27: {
                        tg2 = this;
                        synchronized (this) {
                            l20 = this.m;
                            this.m = l19 = 0L;
                        }
                        object4 = this.e;
                        object3 = this.f;
                        long l21 = (long)40 & l20;
                        l18 = l21 == l19 ? 0 : (l21 < l19 ? -1 : 1);
                        if (l18 != false && object4 != null) {
                            tg$b = this.k;
                            if (tg$b == null) {
                                this.k = tg$b = new tg$b();
                            }
                            tg$b = tg$b.b((SetPrivateFragment$a)object4);
                            object5 = tg2.l;
                            if (object5 == null) {
                                object5 = new tg$a();
                                tg2.l = object5;
                            }
                            object4 = ((tg$a)object5).b((SetPrivateFragment$a)object4);
                        } else {
                            object4 = null;
                            tg$b = null;
                        }
                        l17 = (long)55 & l20;
                        object2 = l17 == l19 ? 0 : (l17 < l19 ? -1 : 1);
                        long l22 = 52;
                        l16 = 50;
                        l15 = 49;
                        n11 = 0;
                        object = null;
                        if (object2 == false) break block26;
                        long l23 = l20 & l15;
                        long l24 = l23 - l19;
                        object2 = l24 == 0L ? 0 : (l24 < 0L ? -1 : 1);
                        if (object2 != false) {
                            if (object3 != null) {
                                object5 = ((g0)object3).k();
                            } else {
                                object2 = 0;
                                object5 = null;
                            }
                            tg2.updateLiveDataRegistration(0, (LiveData)object5);
                            if (object5 != null) {
                                object5 = (Boolean)((LiveData)object5).getValue();
                            } else {
                                object2 = 0;
                                object5 = null;
                            }
                            object2 = ViewDataBinding.safeUnbox((Boolean)object5);
                        } else {
                            object2 = 0;
                            object5 = null;
                        }
                        l23 = l20 & l16;
                        long l25 = l23 == l19 ? 0 : (l23 < l19 ? -1 : 1);
                        if (l25 != false) {
                            if (object3 != null) {
                                LiveData liveData = ((g0)object3).y();
                                object = liveData;
                            } else {
                                n11 = 0;
                                object = null;
                            }
                            l14 = 1;
                            tg2.updateLiveDataRegistration((int)l14, (LiveData)object);
                            if (object != null) {
                                object = (Boolean)((LiveData)object).getValue();
                            } else {
                                n11 = 0;
                                object = null;
                            }
                            n11 = ViewDataBinding.safeUnbox((Boolean)object);
                        } else {
                            n11 = 0;
                            object = null;
                        }
                        l16 = l20 & l22;
                        l14 = l16 == l19 ? 0 : (l16 < l19 ? -1 : 1);
                        if (l14 == false) break block27;
                        if (object3 != null) {
                            object3 = ((g0)object3).A();
                        } else {
                            n10 = 0;
                            object3 = null;
                        }
                        l14 = 2;
                        tg2.updateLiveDataRegistration((int)l14, (LiveData)object3);
                        Object object6 = object3 != null ? (object3 = (Boolean)((LiveData)object3).getValue()) : null;
                        n10 = ViewDataBinding.safeUnbox(object6);
                        long l26 = object2;
                        object2 = n10;
                        n10 = n11;
                        n11 = (int)l26;
                        break block28;
                    }
                    n10 = n11;
                    n11 = object2;
                    break block29;
                }
                n10 = 0;
                object3 = null;
                n11 = 0;
                object = null;
            }
            object2 = 0;
            object5 = null;
        }
        l16 = l20 & l15;
        l14 = l16 == l19 ? 0 : (l16 < l19 ? -1 : 1);
        if (l14 != false) {
            CheckBox checkBox = tg2.a;
            CompoundButtonBindingAdapter.setChecked((CompoundButton)checkBox, n11 != 0);
        }
        if ((n11 = (l13 = (l16 = (long)50 & l20) - l19) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != 0) {
            object = tg2.b;
            CompoundButtonBindingAdapter.setChecked((CompoundButton)object, n10 != 0);
        }
        if ((n10 = (l12 = (l22 &= l20) - l19) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != 0) {
            object3 = tg2.c;
            CompoundButtonBindingAdapter.setChecked((CompoundButton)object3, (boolean)object2);
        }
        if ((l11 = (l10 = (l20 &= (l17 = (long)32)) - l19) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            imageView = tg2.d;
            View.OnClickListener onClickListener = tg2.j;
            imageView.setOnClickListener(onClickListener);
        }
        if (l18 != false) {
            tg2.h.setOnClickListener((View.OnClickListener)tg$b);
            imageView = tg2.i;
            imageView.setOnClickListener((View.OnClickListener)object4);
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
            this.m = l10 = (long)32;
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
                return this.E((MutableLiveData)object, n11);
            }
            object = (LiveData)object;
            return this.D((LiveData)object, n11);
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
            object = (SetPrivateFragment$a)object;
            this.A((SetPrivateFragment$a)object);
            return 1 != 0;
        } else {
            n11 = 152;
            if (n11 != n10) return 0 != 0;
            object = (g0)object;
            this.B((g0)object);
        }
        return 1 != 0;
    }
}

