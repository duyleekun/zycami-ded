/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.template.PlayLayout;
import com.zhiyun.cama.widget.RingProgressBar;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.w0.qc;

public class rc
extends qc {
    private static final ViewDataBinding$IncludedLayouts u;
    private static final SparseIntArray v;
    private long t;

    static {
        SparseIntArray sparseIntArray;
        v = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362467, 1);
        sparseIntArray.put(2131362193, 2);
        sparseIntArray.put(2131362597, 3);
        sparseIntArray.put(2131362194, 4);
        sparseIntArray.put(2131362762, 5);
        sparseIntArray.put(2131362760, 6);
        sparseIntArray.put(2131362763, 7);
        sparseIntArray.put(2131363685, 8);
        sparseIntArray.put(2131363684, 9);
        sparseIntArray.put(2131363012, 10);
        sparseIntArray.put(2131363422, 11);
        sparseIntArray.put(2131362723, 12);
        sparseIntArray.put(2131363682, 13);
        sparseIntArray.put(2131363711, 14);
        sparseIntArray.put(2131362494, 15);
        sparseIntArray.put(2131363601, 16);
        sparseIntArray.put(2131362089, 17);
        sparseIntArray.put(2131363600, 18);
    }

    public rc(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = u;
        SparseIntArray sparseIntArray = v;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 19, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private rc(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        ImageButton imageButton = (ImageButton)objectArray[17];
        ConstraintLayout constraintLayout = (ConstraintLayout)((Object)objectArray[2]);
        ConstraintLayout constraintLayout2 = (ConstraintLayout)((Object)objectArray[4]);
        FrameLayout frameLayout = (FrameLayout)objectArray[1];
        LinearLayout linearLayout = (LinearLayout)objectArray[15];
        PlayLayout playLayout = (PlayLayout)((Object)objectArray[3]);
        ImageView imageView = (ImageView)objectArray[12];
        ZYTextView zYTextView = (ZYTextView)objectArray[6];
        ZYTextView zYTextView2 = (ZYTextView)objectArray[5];
        ZYTextView zYTextView3 = (ZYTextView)objectArray[7];
        LinearLayout linearLayout2 = (LinearLayout)objectArray[0];
        RingProgressBar ringProgressBar = (RingProgressBar)((Object)objectArray[10]);
        TextView textView = (TextView)objectArray[11];
        ZYTextView zYTextView4 = (ZYTextView)objectArray[18];
        TextView textView2 = (TextView)objectArray[16];
        View view2 = (View)objectArray[13];
        TextView textView3 = (TextView)objectArray[9];
        TextView textView4 = (TextView)objectArray[8];
        View view3 = (View)objectArray[14];
        super(dataBindingComponent, view, 0, imageButton, constraintLayout, constraintLayout2, frameLayout, linearLayout, playLayout, imageView, zYTextView, zYTextView2, zYTextView3, linearLayout2, ringProgressBar, textView, zYTextView4, textView2, view2, textView3, textView4, view3);
        this.t = -1;
        this.k.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        synchronized (this) {
            long l10;
            this.t = l10 = 0L;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.t;
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
            this.t = l10 = 1L;
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

