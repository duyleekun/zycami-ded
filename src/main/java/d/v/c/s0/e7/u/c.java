/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.e7.u;

import com.google.android.gms.tasks.OnFailureListener;
import com.zhiyun.cama.camera.liveassistant.vision.LiveAssistantService;

public final class c
implements OnFailureListener {
    public final /* synthetic */ LiveAssistantService a;

    public /* synthetic */ c(LiveAssistantService liveAssistantService) {
        this.a = liveAssistantService;
    }

    public final void onFailure(Exception exception) {
        this.a.m(exception);
    }
}

