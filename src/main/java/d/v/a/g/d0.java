/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.a.g;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.R$id;
import com.zhiyun.account.set.privacy.BindSuccessFragment$a;
import d.v.a.d;
import d.v.a.g.c0;
import d.v.a.g.d0$a;
import d.v.a.g.d0$b;
import d.v.a.g.d0$c;
import d.v.a.j.c.y;
import l.a.q.g0.u;

public class d0
extends c0 {
    private static final ViewDataBinding$IncludedLayouts n;
    private static final SparseIntArray o;
    private final LinearLayout e;
    private final TextView f;
    private final TextView g;
    private final TextView h;
    private final TextView i;
    private d0$c j;
    private d0$a k;
    private d0$b l;
    private long m;

    static {
        SparseIntArray sparseIntArray;
        o = sparseIntArray = new SparseIntArray();
        int n10 = R$id.tv_title_center;
        sparseIntArray.put(n10, 6);
    }

    public d0(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = n;
        SparseIntArray sparseIntArray = o;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private d0(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[1];
        object2 = (ImageView)object;
        Object object3 = object = objectArray[6];
        object3 = (TextView)object;
        super(dataBindingComponent, view, 4, (ImageView)object2, (TextView)object3);
        this.m = -1;
        this.a.setTag(null);
        dataBindingComponent = (LinearLayout)objectArray[0];
        this.e = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (TextView)objectArray[2];
        this.f = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (TextView)objectArray[3];
        this.g = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (TextView)objectArray[4];
        this.h = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (TextView)objectArray[5];
        this.i = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(MutableLiveData mutableLiveData, int n10) {
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
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
    private boolean D(MutableLiveData mutableLiveData, int n10) {
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 8;
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
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
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
    private boolean F(MutableLiveData mutableLiveData, int n10) {
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
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
    public void A(BindSuccessFragment$a bindSuccessFragment$a) {
        this.d = bindSuccessFragment$a;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 32;
            this.m = l10 |= l11;
        }
        int n10 = d.v.a.d.x;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(y y10) {
        this.c = y10;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 16;
            this.m = l10 |= l11;
        }
        int n10 = d.v.a.d.N0;
        this.notifyPropertyChanged(n10);
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
        Object object;
        boolean bl2;
        d0$b d0$b;
        d0$a d0$a;
        d0$c d0$c;
        String string2;
        int n10;
        String string3;
        Object object2;
        boolean bl3;
        Object object3;
        long l15;
        int n11;
        long l16;
        BindSuccessFragment$a bindSuccessFragment$a;
        long l17;
        long l18;
        d0 d02;
        block33: {
            Object object4;
            Object object5;
            Object object6;
            block34: {
                String string4;
                block40: {
                    int n12;
                    block39: {
                        int n13;
                        block38: {
                            long l19;
                            long l20;
                            block37: {
                                block36: {
                                    block35: {
                                        d02 = this;
                                        synchronized (this) {
                                            l18 = this.m;
                                            this.m = l17 = 0L;
                                        }
                                        object6 = this.c;
                                        bindSuccessFragment$a = this.d;
                                        long l21 = (long)95 & l18;
                                        object5 = l21 == l17 ? 0 : (l21 < l17 ? -1 : 1);
                                        l16 = 84;
                                        l20 = 82;
                                        l19 = 81;
                                        n11 = 0;
                                        object4 = null;
                                        if (object5 == false) break block34;
                                        l15 = l18 & l19;
                                        long l22 = l15 - l17;
                                        object5 = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
                                        if (object5 == false) break block35;
                                        if (object6 != null) {
                                            object3 = ((y)object6).B;
                                        } else {
                                            object5 = 0;
                                            object3 = null;
                                        }
                                        d02.updateLiveDataRegistration(0, (LiveData)object3);
                                        if (object3 != null) {
                                            object3 = (String)((LiveData)object3).getValue();
                                        } else {
                                            object5 = 0;
                                            object3 = null;
                                        }
                                        if (object6 == null) break block36;
                                        string4 = ((y)object6).l((String)object3);
                                        break block37;
                                    }
                                    object5 = 0;
                                    object3 = null;
                                }
                                bl3 = false;
                                string4 = null;
                            }
                            long l23 = l18 & l20;
                            long l24 = l23 == l17 ? 0 : (l23 < l17 ? -1 : 1);
                            if (l24 != false) {
                                if (object6 != null) {
                                    object4 = ((y)object6).A;
                                } else {
                                    n11 = 0;
                                    object4 = null;
                                }
                                n13 = 1;
                                d02.updateLiveDataRegistration(n13, (LiveData)object4);
                                if (object4 != null) {
                                    object4 = (Integer)((LiveData)object4).getValue();
                                } else {
                                    n11 = 0;
                                    object4 = null;
                                }
                                n11 = ViewDataBinding.safeUnbox((Integer)object4);
                            } else {
                                n11 = 0;
                                object4 = null;
                            }
                            l19 = l18 & l16;
                            n13 = (int)(l19 == l17 ? 0 : (l19 < l17 ? -1 : 1));
                            if (n13 == 0) break block38;
                            if (object6 != null) {
                                object2 = ((y)object6).z;
                            } else {
                                n13 = 0;
                                object2 = null;
                            }
                            n12 = 2;
                            d02.updateLiveDataRegistration(n12, (LiveData)object2);
                            if (object2 != null) {
                                object2 = (String)((LiveData)object2).getValue();
                            } else {
                                n13 = 0;
                                object2 = null;
                            }
                            if (object6 == null) break block39;
                            string3 = ((y)object6).l((String)object2);
                            break block40;
                        }
                        n13 = 0;
                        object2 = null;
                    }
                    n12 = 0;
                    string3 = null;
                }
                long l25 = 88;
                long l26 = l18 & l25;
                long l27 = l26 == l17 ? 0 : (l26 < l17 ? -1 : 1);
                if (l27 != false) {
                    if (object6 != null) {
                        object6 = ((y)object6).C;
                    } else {
                        n10 = 0;
                        object6 = null;
                    }
                    int n14 = 3;
                    d02.updateLiveDataRegistration(n14, (LiveData)object6);
                    if (object6 != null) {
                        object6 = (Integer)((LiveData)object6).getValue();
                    } else {
                        n10 = 0;
                        object6 = null;
                    }
                    n10 = ViewDataBinding.safeUnbox((Integer)object6);
                    string2 = string4;
                    break block33;
                } else {
                    string2 = string4;
                    n10 = 0;
                    object6 = null;
                }
                break block33;
            }
            n10 = 0;
            object6 = null;
            object5 = 0;
            object3 = null;
            n11 = 0;
            object4 = null;
            boolean bl4 = false;
            string2 = null;
            boolean bl5 = false;
            object2 = null;
            boolean bl6 = false;
            string3 = null;
        }
        l15 = l18 & (long)96;
        bl3 = l15 == l17 ? 0 : (l15 < l17 ? -1 : 1);
        if (bl3 && bindSuccessFragment$a != null) {
            d0$c = d02.j;
            if (d0$c == null) {
                d02.j = d0$c = new d0$c();
            }
            d0$c = d0$c.b(bindSuccessFragment$a);
            d0$a = d02.k;
            if (d0$a == null) {
                d02.k = d0$a = new d0$a();
            }
            d0$a = d0$a.b(bindSuccessFragment$a);
            d0$b = d02.l;
            if (d0$b == null) {
                d02.l = d0$b = new d0$b();
            }
            d0$b = d0$b.b(bindSuccessFragment$a);
        } else {
            bl2 = false;
            d0$b = null;
            d0$c = null;
            d0$a = null;
        }
        if (bl3) {
            object = d02.a;
            object.setOnClickListener(d0$b);
            d02.g.setOnClickListener((View.OnClickListener)d0$a);
            d0$b = d02.i;
            d0$b.setOnClickListener(d0$c);
        }
        if (bl2 = (l14 = (l17 = l18 & l16) - (l16 = 0L)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) {
            d0$b = d02.f;
            object = "@string/set_private_phone";
            u.n((TextView)d0$b, (String)object, string3, object2);
        }
        if (bl2 = (l13 = (l17 = (long)82 & l18) - l16) == 0L ? 0 : (l13 < 0L ? -1 : 1)) {
            d0$b = d02.g;
            object = null;
            u.k((TextView)d0$b, n11, null, null);
        }
        if (bl2 = (l12 = (l17 = (long)81 & l18) - l16) == 0L ? 0 : (l12 < 0L ? -1 : 1)) {
            d0$b = d02.h;
            object = "@string/set_private_email";
            u.n((TextView)d0$b, (String)object, string2, object3);
        }
        if ((l11 = (l10 = (l18 &= (l17 = (long)88)) - l16) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            TextView textView = d02.i;
            u.k(textView, n10, null, null);
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
            this.m = l10 = (long)64;
        }
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
                        return false;
                    }
                    object = (MutableLiveData)object;
                    return this.D((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.E((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.F((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.C((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = d.v.a.d.N0;
        if (n11 == n10) {
            object = (y)object;
            this.B((y)object);
            return 1 != 0;
        } else {
            n11 = d.v.a.d.x;
            if (n11 != n10) return 0 != 0;
            object = (BindSuccessFragment$a)object;
            this.A((BindSuccessFragment$a)object);
        }
        return 1 != 0;
    }
}

