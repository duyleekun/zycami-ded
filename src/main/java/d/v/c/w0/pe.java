/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.data.database.model.Feedback$Extras;
import com.zhiyun.cama.me.help.FeedbackEditAddFragment$b;
import com.zhiyun.common.util.Times;
import d.v.c.w0.oe;
import l.a.q.g0.u;

public class pe
extends oe {
    private static final ViewDataBinding$IncludedLayouts m;
    private static final SparseIntArray n;
    private final LinearLayout g;
    private final LinearLayout h;
    private final TextView i;
    private final LinearLayout j;
    private final TextView k;
    private long l;

    static {
        SparseIntArray sparseIntArray;
        n = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362834, 5);
        sparseIntArray.put(2131362667, 6);
        sparseIntArray.put(2131362669, 7);
        sparseIntArray.put(2131362668, 8);
    }

    public pe(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = m;
        SparseIntArray sparseIntArray = n;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 9, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private pe(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[6];
        object2 = (ImageView)object;
        Object object3 = object = objectArray[8];
        object3 = (ImageView)object;
        Object object4 = object = objectArray[7];
        object4 = (ImageView)object;
        Object object5 = object = objectArray[5];
        object5 = (LinearLayout)object;
        super(dataBindingComponent, view, 0, (ImageView)object2, (ImageView)object3, (ImageView)object4, (LinearLayout)object5);
        this.l = -1;
        dataBindingComponent = (LinearLayout)objectArray[0];
        this.g = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (LinearLayout)objectArray[1];
        this.h = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (TextView)objectArray[2];
        this.i = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (LinearLayout)objectArray[3];
        this.j = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (TextView)objectArray[4];
        this.k = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    public void A(FeedbackEditAddFragment$b feedbackEditAddFragment$b) {
        this.e = feedbackEditAddFragment$b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(Feedback$Extras feedback$Extras) {
        this.f = feedback$Extras;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 2;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(56);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        String string2;
        int n10;
        String string3;
        long l11;
        long l12;
        synchronized (this) {
            l12 = this.l;
            this.l = l11 = 0L;
        }
        Object object = this.f;
        long l13 = 6;
        long l14 = l12 & l13;
        long l15 = l14 == l11 ? 0 : (l14 < l11 ? -1 : 1);
        int n11 = 0;
        if (l15 != false) {
            long l16;
            long l17;
            float f10;
            int n12;
            String string4;
            if (object != null) {
                string3 = ((Feedback$Extras)object).getContent();
                object = ((Feedback$Extras)object).getCreatedAt();
            } else {
                n10 = 0;
                object = null;
                string3 = null;
            }
            if (string3 != null) {
                string4 = string3.trim();
            } else {
                n12 = 0;
                string4 = null;
                f10 = 0.0f;
            }
            string2 = Times.getTimeZoneDesSecond((String)object);
            if (object != null) {
                object = ((String)object).trim();
            } else {
                n10 = 0;
                object = null;
            }
            n12 = TextUtils.isEmpty((CharSequence)string4);
            n10 = TextUtils.isEmpty((CharSequence)object);
            if (l15 != false) {
                l17 = n12 != 0 ? (long)64 : (long)32;
                l12 |= l17;
            }
            if ((l15 = (l16 = (l17 = l12 & l13) - l11) == 0L ? 0 : (l16 < 0L ? -1 : 1)) != false) {
                l17 = n10 != 0 ? (long)16 : (long)8;
                l12 |= l17;
            }
            l15 = 8;
            float f11 = 1.1E-44f;
            if (n12 != 0) {
                n12 = l15;
                f10 = f11;
            } else {
                n12 = 0;
                string4 = null;
                f10 = 0.0f;
            }
            if (n10 != 0) {
                n11 = (int)l15;
            }
            n10 = n11;
            n11 = n12;
        } else {
            n10 = 0;
            object = null;
            string3 = null;
            string2 = null;
        }
        long l18 = (l10 = (l12 &= l13) - l11) == 0L ? 0 : (l10 < 0L ? -1 : 1);
        if (l18 != false) {
            this.h.setVisibility(n11);
            u.n(this.i, string3, null, null);
            this.j.setVisibility(n10);
            TextView textView = this.k;
            u.n(textView, string2, null, null);
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
            this.l = l10 = (long)4;
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
        int n11 = 23;
        if (n11 == n10) {
            object = (FeedbackEditAddFragment$b)object;
            this.A((FeedbackEditAddFragment$b)object);
            return 1 != 0;
        } else {
            n11 = 56;
            if (n11 != n10) return 0 != 0;
            object = (Feedback$Extras)object;
            this.B((Feedback$Extras)object);
        }
        return 1 != 0;
    }
}

