/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.w0.ci;

public class di
extends ci {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private long h;

    static {
        SparseIntArray sparseIntArray;
        j = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363682, 3);
        sparseIntArray.put(2131362751, 4);
        sparseIntArray.put(2131362722, 5);
        sparseIntArray.put(2131362861, 6);
    }

    public di(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private di(DataBindingComponent dataBindingComponent, View view, Object[] object) {
        Object object2;
        Object object3 = object2 = object[1];
        object3 = (ExoVideoView)object2;
        Object object4 = object2 = object[0];
        object4 = (FrameLayout)object2;
        Object object5 = object2 = object[2];
        object5 = (ImageView)object2;
        Object object6 = object2 = object[5];
        object6 = (ImageView)object2;
        Object object7 = object2 = object[4];
        object7 = (ImageView)object2;
        Object object8 = object2 = object[6];
        object8 = (ProgressBar)object2;
        object = object[3];
        View view2 = object;
        view2 = (View)object;
        super(dataBindingComponent, view, 0, (ExoVideoView)object3, (FrameLayout)object4, (ImageView)object5, (ImageView)object6, (ImageView)object7, (ProgressBar)object8, view2);
        this.h = -1;
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
    public void executeBindings() {
        boolean bl2;
        long l10;
        synchronized (this) {
            long l11 = this.h;
            this.h = l10 = 0L;
        }
        long l12 = 1L;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false && (l14 = (long)ViewDataBinding.getBuildSdkInt()) >= (bl2 = 21 != 0)) {
            ExoVideoView exoVideoView = this.a;
            bl2 = true;
            exoVideoView.setClipToOutline(bl2);
            exoVideoView = this.c;
            exoVideoView.setClipToOutline(bl2);
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
            this.h = l10 = 1L;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        return true;
    }
}

