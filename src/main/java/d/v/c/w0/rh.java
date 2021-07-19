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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.camera.story.video.StoryReviewVideoView;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.c.w0.qh;
import l.a.q.g0.u;

public class rh
extends qh {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private final ImageView f;
    private final TextView g;
    private long h;

    static {
        SparseIntArray sparseIntArray;
        j = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363689, 4);
        sparseIntArray.put(2131363711, 5);
    }

    public rh(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private rh(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[0];
        object2 = (ConstraintLayout)((Object)object);
        Object object3 = object = objectArray[1];
        object3 = (StoryReviewVideoView)((Object)object);
        Object object4 = object = objectArray[4];
        object4 = (View)object;
        Object object5 = object = objectArray[5];
        object5 = (View)object;
        super(dataBindingComponent, view, 0, (ConstraintLayout)((Object)object2), (StoryReviewVideoView)((Object)object3), (View)object4, (View)object5);
        this.h = -1;
        this.a.setTag(null);
        dataBindingComponent = (ImageView)objectArray[2];
        this.f = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (TextView)objectArray[3];
        this.g = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.b.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        boolean bl2;
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        synchronized (this) {
            l15 = this.h;
            this.h = l14 = 0L;
        }
        Object object = this.e;
        long l16 = 3;
        long l17 = l15 & l16;
        long l18 = l17 == l14 ? 0 : (l17 < l14 ? -1 : 1);
        int n10 = 0;
        if (l18 != false) {
            boolean bl3;
            if (object != null) {
                bl3 = ((TemplateData)object).isPrimeUsable();
                object = ((TemplateData)object).showTitle();
            } else {
                object = null;
                bl3 = false;
            }
            if (l18 != false) {
                long l19 = bl3 ? (long)8 : (long)4;
                l15 |= l19;
            }
            if (!bl3) {
                l18 = 4;
                n10 = l18;
            }
        } else {
            object = null;
        }
        long l20 = (l13 = (l16 &= l15) - l14) == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l20 != false) {
            this.f.setVisibility(n10);
            TextView textView = this.g;
            u.n(textView, (String)object, null, null);
        }
        if ((l12 = (l11 = (l15 &= (l10 = (long)2)) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false && (l12 = (long)ViewDataBinding.getBuildSdkInt()) >= (bl2 = 21 != 0)) {
            StoryReviewVideoView storyReviewVideoView = this.b;
            bl2 = true;
            storyReviewVideoView.setClipToOutline(bl2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.h;
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
            this.h = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 133;
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
        this.e = templateData;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 1L;
            this.h = l10 |= l11;
        }
        this.notifyPropertyChanged(133);
        super.requestRebind();
    }
}

