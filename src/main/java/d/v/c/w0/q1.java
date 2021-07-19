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
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.w0.p1;

public class q1
extends p1 {
    private static final ViewDataBinding$IncludedLayouts j;
    private static final SparseIntArray k;
    private final ConstraintLayout h;
    private long i;

    static {
        SparseIntArray sparseIntArray;
        k = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363530, 2);
        sparseIntArray.put(2131363528, 3);
        sparseIntArray.put(2131362748, 4);
        sparseIntArray.put(2131362749, 5);
        sparseIntArray.put(2131362662, 6);
        sparseIntArray.put(2131362404, 7);
    }

    public q1(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = j;
        SparseIntArray sparseIntArray = k;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 8, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private q1(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[7];
        object3 = (ExoVideoView)object2;
        Object object4 = object2 = objectArray[1];
        object4 = (ConstraintLayout)((Object)object2);
        Object object5 = object2 = objectArray[6];
        object5 = (ImageView)object2;
        Object object6 = object2 = objectArray[4];
        object6 = (ImageView)object2;
        Object object7 = object2 = objectArray[5];
        object7 = (ImageView)object2;
        Object object8 = object2 = objectArray[3];
        object8 = (TextView)object2;
        Object object9 = object2 = objectArray[2];
        object9 = (TextView)object2;
        super(object, view, 0, (ExoVideoView)object3, (ConstraintLayout)((Object)object4), (ImageView)object5, (ImageView)object6, (ImageView)object7, (TextView)object8, (TextView)object9);
        this.i = -1;
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.h = object;
        object.setTag(null);
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
            long l11 = this.i;
            this.i = l10 = 0L;
        }
        long l12 = 1L;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false && (l14 = (long)ViewDataBinding.getBuildSdkInt()) >= (bl2 = 21 != 0)) {
            ConstraintLayout constraintLayout = this.b;
            bl2 = true;
            constraintLayout.setClipToOutline(bl2);
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
            this.i = l10 = 1L;
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

