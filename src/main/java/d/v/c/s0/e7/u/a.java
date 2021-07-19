/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 */
package d.v.c.s0.e7.u;

import android.media.ImageReader;
import com.zhiyun.cama.camera.liveassistant.vision.LiveAssistantService;

public final class a
implements ImageReader.OnImageAvailableListener {
    public final /* synthetic */ LiveAssistantService a;

    public /* synthetic */ a(LiveAssistantService liveAssistantService) {
        this.a = liveAssistantService;
    }

    public final void onImageAvailable(ImageReader imageReader) {
        this.a.o(imageReader);
    }
}

