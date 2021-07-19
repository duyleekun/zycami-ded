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
import com.zhiyun.cama.publish.ComposeFragment;

public final class k
implements View.OnTouchListener {
    public final /* synthetic */ ComposeFragment a;

    public /* synthetic */ k(ComposeFragment composeFragment) {
        this.a = composeFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.a.x(view, motionEvent);
    }
}

