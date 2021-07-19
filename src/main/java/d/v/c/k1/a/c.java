/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 */
package d.v.c.k1.a;

import android.view.MotionEvent;
import android.view.View;
import com.zhiyun.cama.mediacontent.media.AddVideoFragment;
import d.v.h.e.a;

public final class c
implements d.v.f.f.c {
    public final /* synthetic */ AddVideoFragment a;

    public /* synthetic */ c(AddVideoFragment addVideoFragment) {
        this.a = addVideoFragment;
    }

    public final boolean a(View view, int n10, Object object, MotionEvent motionEvent) {
        AddVideoFragment addVideoFragment = this.a;
        object = (a)object;
        return addVideoFragment.P(view, n10, (a)object, motionEvent);
    }
}

