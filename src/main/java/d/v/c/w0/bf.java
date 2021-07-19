/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.me.help.data.FeedbackSet$DealStatus;
import d.v.c.w0.af;
import d.v.f.i.g;
import l.a.q.g0.u;

public class bf
extends af {
    private static final ViewDataBinding$IncludedLayouts h;
    private static final SparseIntArray i;
    private final ConstraintLayout f;
    private long g;

    static {
        SparseIntArray sparseIntArray;
        i = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362660, 3);
    }

    public bf(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = h;
        SparseIntArray sparseIntArray = i;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private bf(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[3];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[1];
        object4 = (TextView)object2;
        Object object5 = object2 = objectArray[2];
        object5 = (TextView)object2;
        super(object, view, 0, (ImageView)object3, (TextView)object4, (TextView)object5);
        this.g = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.f = object;
        object.setTag(null);
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
    public void A(FeedbackSet$DealStatus feedbackSet$DealStatus) {
        this.d = feedbackSet$DealStatus;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 1L;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(34);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(String string2) {
        this.e = string2;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 2;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(142);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        int n10;
        long l10;
        String string2;
        long l11;
        String string3;
        Object object;
        bf bf2;
        block22: {
            Context context;
            block21: {
                Object object2;
                block20: {
                    long l12;
                    int n11;
                    long l13;
                    long l14;
                    boolean bl2;
                    long l15;
                    long l16;
                    bf2 = this;
                    synchronized (this) {
                        l16 = this.g;
                        this.g = l15 = 0L;
                    }
                    object = this.d;
                    string3 = this.e;
                    long l17 = 5;
                    long l18 = l16 & l17;
                    l11 = l18 == l15 ? 0 : (l18 < l15 ? -1 : 1);
                    long l19 = 32;
                    long l20 = 8;
                    if (l11 != false) {
                        bl2 = object == null;
                        if (l11 != false) {
                            if (bl2) {
                                l16 |= (long)16;
                                l14 = 64;
                                l16 |= l14;
                            } else {
                                l16 = l16 | l20 | l19;
                            }
                        }
                    } else {
                        bl2 = false;
                    }
                    l14 = l16 & (long)6;
                    l11 = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1);
                    long l21 = (l20 &= l16) - l15;
                    object2 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
                    if (object2 != false) {
                        if (object != null) {
                            object2 = object.getStringRes();
                        } else {
                            object2 = 0;
                            string2 = null;
                        }
                        View view = this.getRoot();
                        context = view.getContext();
                        string2 = d.v.f.i.g.m(context, (int)object2);
                    } else {
                        object2 = 0;
                        string2 = null;
                    }
                    long l22 = (l13 = (l19 &= l16) - l15) == 0L ? 0 : (l13 < 0L ? -1 : 1);
                    if (l22 != false) {
                        if (object != null) {
                            object = object.getColorStr();
                        } else {
                            n11 = 0;
                            object = null;
                        }
                        n11 = Color.parseColor((String)object);
                    } else {
                        n11 = 0;
                        object = null;
                    }
                    l10 = (l12 = (l16 &= l17) - l15) == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (l10 == false) break block20;
                    if (bl2) {
                        string2 = "@string/share_default";
                    }
                    if (bl2) break block21;
                    n10 = n11;
                    break block22;
                }
                object2 = 0;
                string2 = null;
            }
            n10 = 0;
            context = null;
        }
        if (l10 != false) {
            bf2.b.setTextColor(n10);
            object = bf2.b;
            u.n((TextView)object, string2, null, null);
        }
        if (l11 != false) {
            object = bf2.c;
            u.n((TextView)object, string3, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.g;
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
            this.g = l10 = (long)4;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 34;
        if (n11 == n10) {
            FeedbackSet$DealStatus feedbackSet$DealStatus = (FeedbackSet$DealStatus)((Object)object);
            this.A(feedbackSet$DealStatus);
            return 1 != 0;
        } else {
            n11 = 142;
            if (n11 != n10) return 0 != 0;
            String string2 = (String)object;
            this.B(string2);
        }
        return 1 != 0;
    }
}

