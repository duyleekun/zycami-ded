/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.e7.u;

import com.google.android.gms.tasks.OnSuccessListener;
import com.zhiyun.cama.camera.liveassistant.vision.LiveAssistantService;
import java.util.List;

public final class b
implements OnSuccessListener {
    public final /* synthetic */ LiveAssistantService a;

    public /* synthetic */ b(LiveAssistantService liveAssistantService) {
        this.a = liveAssistantService;
    }

    public final void onSuccess(Object object) {
        LiveAssistantService liveAssistantService = this.a;
        object = (List)object;
        liveAssistantService.k((List)object);
    }
}

