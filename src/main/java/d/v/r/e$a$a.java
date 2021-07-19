/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.v.r;

import android.util.Log;
import com.google.mediapipe.components.TextureFrameConsumer;
import com.google.mediapipe.framework.TextureFrame;
import d.v.r.e$a;

public class e$a$a
implements TextureFrameConsumer {
    public final /* synthetic */ e$a a;

    public e$a$a(e$a e$a) {
        this.a = e$a;
    }

    public void onNewFrame(TextureFrame textureFrame) {
        Log.d((String)"", (String)"Frame procceed");
        long l10 = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(": ");
        long l11 = this.a.t;
        stringBuilder.append(l10 -= l11);
        String string2 = stringBuilder.toString();
        Log.d((String)"PIPELINE_TIME", (String)string2);
        this.a.u = false;
        textureFrame.release();
    }
}

