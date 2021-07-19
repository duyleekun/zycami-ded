/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.widget.RingProgressBar;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.c.w0.ih;
import d.v.l.g.a;
import l.a.q.g0.u;

public class jh
extends ih {
    private static final ViewDataBinding$IncludedLayouts j;
    private static final SparseIntArray k;
    private final ConstraintLayout g;
    private final TextView h;
    private long i;

    static {
        SparseIntArray sparseIntArray;
        k = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362706, 5);
        sparseIntArray.put(2131362724, 6);
    }

    public jh(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = j;
        SparseIntArray sparseIntArray = k;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private jh(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[1];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[3];
        object4 = (ImageView)object2;
        Object object5 = object2 = objectArray[5];
        object5 = (ImageView)object2;
        Object object6 = object2 = objectArray[6];
        object6 = (ImageView)object2;
        Object object7 = object2 = objectArray[2];
        object7 = (RingProgressBar)((Object)object2);
        super(object, view, 0, (ImageView)object3, (ImageView)object4, (ImageView)object5, (ImageView)object6, (RingProgressBar)((Object)object7));
        this.i = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.g = object;
        object.setTag(null);
        object = (TextView)objectArray[4];
        this.h = object;
        object.setTag(null);
        this.e.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        long l11;
        String string2;
        ImageView imageView;
        int n10;
        boolean bl2;
        int n11;
        String string3;
        long l12;
        long l13;
        jh jh2 = this;
        synchronized (this) {
            l13 = this.i;
            this.i = l12 = 0L;
        }
        Object object = this.f;
        long l14 = 3;
        long l15 = l13 & l14;
        long l16 = l15 == l12 ? 0 : (l15 < l12 ? -1 : 1);
        int n12 = 0;
        float f10 = 0.0f;
        if (l16 != false) {
            float f11;
            int n13;
            float f12;
            String string4;
            if (object != null) {
                string4 = object.getCoverUrl();
                string3 = object.showTitle();
                n11 = object.isDownloadFinished();
            } else {
                bl2 = false;
                string4 = null;
                string3 = null;
                n11 = 0;
                object = null;
                f12 = 0.0f;
            }
            if (l16 != false) {
                long l17;
                if (n11 != 0) {
                    l13 |= (long)8;
                    l17 = 32;
                } else {
                    l13 |= (long)4;
                    l17 = 16;
                }
                l13 |= l17;
            }
            l16 = (long)TextUtils.isEmpty((CharSequence)string3);
            n10 = 8;
            float f13 = 1.1E-44f;
            if (n11 != 0) {
                n13 = 0;
                imageView = null;
                f11 = 0.0f;
            } else {
                n13 = n10;
                f11 = f13;
            }
            if (n11 == 0) {
                n10 = 0;
                f13 = 0.0f;
            }
            long l18 = l13 & l14;
            n11 = l18 == l12 ? 0 : (l18 < l12 ? -1 : 1);
            if (n11 != 0) {
                l18 = l16 != false ? 128L : (long)64;
                l13 |= l18;
            }
            if (l16 != false) {
                n11 = 4;
                f12 = 5.6E-45f;
                n12 = n11;
                f10 = f12;
            }
            n11 = n12;
            f12 = f10;
            string2 = string4;
            n12 = n13;
            f10 = f11;
        } else {
            string3 = null;
            string2 = null;
            n11 = 0;
            object = null;
            float f14 = 0.0f;
            n10 = 0;
            float f15 = 0.0f;
        }
        long l19 = l13 & (long)2;
        l16 = l19 == l12 ? 0 : (l19 < l12 ? -1 : 1);
        if (l16 != false && (l16 = (long)ViewDataBinding.getBuildSdkInt()) >= (bl2 = 21 != 0)) {
            ImageView imageView2 = jh2.a;
            bl2 = true;
            imageView2.setClipToOutline(bl2);
        }
        if ((l11 = (l10 = (l13 &= l14) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            imageView = jh2.a;
            d.v.l.g.a.b(imageView, string2, null, null, 0, false, false, null, null, null);
            jh2.b.setVisibility(n12);
            TextView textView = jh2.h;
            textView.setVisibility(n11);
            u.n(jh2.h, string3, null, null);
            object = jh2.e;
            object.setVisibility(n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.i;
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
            this.i = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 134;
        if (n11 == n10) {
            object = (TemplateData)object;
            this.z((TemplateData)object);
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
    public void z(TemplateData templateData) {
        this.f = templateData;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 1L;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(134);
        super.requestRebind();
    }
}

