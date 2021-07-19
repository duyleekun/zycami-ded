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
package d.v.c.w0;

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
import com.zhiyun.cama.me.help.FeedbackFragment$a;
import com.zhiyun.cama.me.help.data.FeedbackSet$Type;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.j1.a.o0;
import d.v.c.w0.we;
import d.v.c.w0.xe$a;

public class xe
extends we
implements b$a {
    private static final ViewDataBinding$IncludedLayouts q;
    private static final SparseIntArray r;
    private final LinearLayout d;
    private final TextView e;
    private final TextView f;
    private final TextView g;
    private final TextView h;
    private final TextView i;
    private final View.OnClickListener j;
    private final View.OnClickListener k;
    private final View.OnClickListener l;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private xe$a o;
    private long p;

    public xe(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = q;
        SparseIntArray sparseIntArray = r;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private xe(DataBindingComponent object, View object2, Object[] textView) {
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        int n10 = 1;
        ImageView imageView = (ImageView)textView[n10];
        super(object, (View)object2, n10, imageView);
        this.p = -1;
        this.a.setTag(null);
        object = (LinearLayout)textView[0];
        this.d = object;
        object.setTag(null);
        int n11 = 2;
        this.e = textView5 = (TextView)textView[n11];
        textView5.setTag(null);
        int n12 = 3;
        this.f = textView4 = (TextView)textView[n12];
        textView4.setTag(null);
        int n13 = 4;
        this.g = textView3 = (TextView)textView[n13];
        textView3.setTag(null);
        int n14 = 5;
        this.h = textView2 = (TextView)textView[n14];
        textView2.setTag(null);
        this.i = textView = (TextView)textView[6];
        textView.setTag(null);
        this.setRootTag((View)object2);
        super(this, n13);
        this.j = object2;
        super(this, n11);
        this.k = object2;
        object = new b(this, n12);
        this.l = object;
        object = new b(this, n10);
        this.m = object;
        object = new b(this, n14);
        this.n = object;
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
                long l10 = this.p;
                long l11 = 1L;
                this.p = l10 |= l11;
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
    public void A(FeedbackFragment$a feedbackFragment$a) {
        this.b = feedbackFragment$a;
        synchronized (this) {
            long l10 = this.p;
            long l11 = 2;
            this.p = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(o0 o02) {
        this.c = o02;
        synchronized (this) {
            long l10 = this.p;
            long l11 = 4;
            this.p = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        FeedbackSet$Type feedbackSet$Type = null;
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
                            FeedbackFragment$a feedbackFragment$a = this.b;
                            if (feedbackFragment$a != null) {
                                n11 = n12;
                            }
                            if (n11 != 0) {
                                feedbackSet$Type = FeedbackSet$Type.OTHER;
                                feedbackFragment$a.b(view, feedbackSet$Type);
                            }
                        }
                    } else {
                        FeedbackFragment$a feedbackFragment$a = this.b;
                        if (feedbackFragment$a != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            feedbackSet$Type = FeedbackSet$Type.ADVICE;
                            feedbackFragment$a.b(view, feedbackSet$Type);
                        }
                    }
                } else {
                    FeedbackFragment$a feedbackFragment$a = this.b;
                    if (feedbackFragment$a != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        feedbackSet$Type = FeedbackSet$Type.SOFTWARE;
                        feedbackFragment$a.b(view, feedbackSet$Type);
                    }
                }
            } else {
                FeedbackFragment$a feedbackFragment$a = this.b;
                if (feedbackFragment$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    feedbackSet$Type = FeedbackSet$Type.FIRMWARE;
                    feedbackFragment$a.b(view, feedbackSet$Type);
                }
            }
        } else {
            FeedbackFragment$a feedbackFragment$a = this.b;
            if (feedbackFragment$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                feedbackFragment$a.a(view);
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
        long l14;
        int n10;
        xe$a xe$a;
        long l15;
        long l16;
        synchronized (this) {
            l16 = this.p;
            this.p = l15 = 0L;
        }
        Object object = this.b;
        Object object2 = this.c;
        long l17 = 10;
        long l18 = l16 & l17;
        long l19 = l18 == l15 ? 0 : (l18 < l15 ? -1 : 1);
        Object object3 = null;
        if (l19 != false && object != null) {
            xe$a = this.o;
            if (xe$a == null) {
                this.o = xe$a = new xe$a();
            }
            object = xe$a.b((FeedbackFragment$a)object);
        } else {
            object = null;
        }
        long l20 = 13;
        long l21 = l16 & l20;
        l19 = l21 == l15 ? 0 : (l21 < l15 ? -1 : 1);
        int n11 = 0;
        if (l19 != false) {
            if (object2 != null) {
                object2 = ((o0)object2).o;
            } else {
                n10 = 0;
                object2 = null;
            }
            this.updateLiveDataRegistration(0, (LiveData)object2);
            if (object2 != null) {
                object3 = object2 = ((LiveData)object2).getValue();
                object3 = (Boolean)object2;
            }
            n10 = ViewDataBinding.safeUnbox(object3);
            if (l19 != false) {
                l18 = n10 != 0 ? (long)32 : (long)16;
                l16 |= l18;
            }
            if (n10 == 0) {
                n11 = n10 = 8;
            }
        }
        if ((n10 = (l14 = (l18 = (long)8 & l16) - l15) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != 0) {
            object2 = this.a;
            xe$a = this.m;
            object2.setOnClickListener((View.OnClickListener)xe$a);
            object2 = this.e;
            xe$a = this.k;
            object2.setOnClickListener((View.OnClickListener)xe$a);
            object2 = this.f;
            xe$a = this.l;
            object2.setOnClickListener((View.OnClickListener)xe$a);
            object2 = this.g;
            xe$a = this.j;
            object2.setOnClickListener((View.OnClickListener)xe$a);
            object2 = this.h;
            xe$a = this.n;
            object2.setOnClickListener((View.OnClickListener)xe$a);
        }
        if ((n10 = (l13 = (l12 = l16 & l17) - l15) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != 0) {
            object2 = this.i;
            object2.setOnClickListener((View.OnClickListener)object);
        }
        if ((l11 = (l10 = (l16 &= l20) - l15) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            TextView textView = this.i;
            textView.setVisibility(n11);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.p;
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
            this.p = l10 = (long)8;
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
            object = (FeedbackFragment$a)object;
            this.A((FeedbackFragment$a)object);
            return 1 != 0;
        } else {
            n11 = 152;
            if (n11 != n10) return 0 != 0;
            object = (o0)object;
            this.B((o0)object);
        }
        return 1 != 0;
    }
}

