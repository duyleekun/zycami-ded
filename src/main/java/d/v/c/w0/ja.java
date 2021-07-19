/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.quvideo.mobile.external.component.cloudengine.model.TemplateResponse$Data;
import d.v.c.w0.ha;
import d.v.f.e.c;
import d.v.l.g.a;
import l.a.q.g0.u;

public class ja
extends ha {
    private static final ViewDataBinding$IncludedLayouts h;
    private static final SparseIntArray i;
    private final ConstraintLayout f;
    private long g;

    static {
        SparseIntArray sparseIntArray;
        i = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362880, 4);
    }

    public ja(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = h;
        SparseIntArray sparseIntArray = i;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private ja(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[1];
        object3 = (CardView)((Object)object2);
        Object object4 = object2 = objectArray[2];
        object4 = (ImageView)object2;
        Object object5 = object2 = objectArray[4];
        object5 = (TextView)object2;
        Object object6 = object2 = objectArray[3];
        object6 = (TextView)object2;
        super(object, view, 0, (CardView)((Object)object3), (ImageView)object4, (TextView)object5, (TextView)object6);
        this.g = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.f = object;
        object.setTag(null);
        this.d.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        String string2;
        StringBuilder stringBuilder;
        ImageView imageView;
        String string3;
        String string4;
        long l10;
        synchronized (this) {
            long l11 = this.g;
            this.g = l10 = 0L;
        }
        Object object = this.e;
        long l12 = 3;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            int n10;
            int n11 = 0;
            string4 = null;
            if (object != null) {
                n11 = ((TemplateResponse$Data)object).getWidth();
                n10 = ((TemplateResponse$Data)object).getHeight();
                string3 = ((TemplateResponse$Data)object).getTitle();
                object = ((TemplateResponse$Data)object).getIcon();
            } else {
                object = null;
                string3 = null;
                n10 = 0;
                imageView = null;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(n11);
            stringBuilder.append(":");
            string4 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(string4);
            stringBuilder.append(n10);
            string4 = stringBuilder.toString();
            string2 = string3;
        } else {
            boolean bl2 = false;
            string4 = null;
            object = null;
            string2 = null;
        }
        if (l14 != false) {
            d.v.f.e.c.d((View)this.a, string4);
            imageView = this.b;
            string3 = null;
            stringBuilder = null;
            d.v.l.g.a.b(imageView, object, null, null, 0, false, false, null, null, null);
            TextView textView = this.d;
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
            this.g = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 75;
        if (n11 == n10) {
            object = (TemplateResponse$Data)object;
            this.z((TemplateResponse$Data)object);
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
    public void z(TemplateResponse$Data templateResponse$Data) {
        this.e = templateResponse$Data;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 1L;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(75);
        super.requestRebind();
    }
}

