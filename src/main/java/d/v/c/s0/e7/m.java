/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.e7;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.liveassistant.LiveAssistantFragment;

public final class m
implements Observer {
    public final /* synthetic */ LiveAssistantFragment a;

    public /* synthetic */ m(LiveAssistantFragment liveAssistantFragment) {
        this.a = liveAssistantFragment;
    }

    public final void onChanged(Object object) {
        LiveAssistantFragment liveAssistantFragment = this.a;
        object = (Boolean)object;
        liveAssistantFragment.w((Boolean)object);
    }
}

