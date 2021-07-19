/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package d.v.c.n1;

import android.view.MotionEvent;
import android.view.View;
import com.zhiyun.cama.publish.CropImageActivity;

public final class o
implements View.OnTouchListener {
    public final /* synthetic */ CropImageActivity a;

    public /* synthetic */ o(CropImageActivity cropImageActivity) {
        this.a = cropImageActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.a.Y(view, motionEvent);
    }
}

