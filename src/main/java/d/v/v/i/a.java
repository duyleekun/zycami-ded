/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.v.v.i;

import android.graphics.Bitmap;
import com.meicam.sdk.NvsObject;
import com.meicam.sdk.NvsRational;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsVideoClip;
import com.meicam.sdk.NvsVideoTrack;
import d.v.h.g.a$a;
import d.v.v.q.i;
import java.util.List;

public class a
implements d.v.h.g.a {
    private static final int d = 1080;
    private static final int e = 1080;
    public NvsTimeline a;
    public NvsVideoClip b;
    public NvsRational c;

    public a() {
        NvsRational nvsRational;
        int n10 = 1;
        this.c = nvsRational = new NvsRational(n10, n10);
    }

    public boolean a(String string2) {
        NvsRational nvsRational;
        int n10 = 1080;
        this.c = nvsRational = new NvsRational(n10, n10);
        return this.c(string2, n10, n10);
    }

    public boolean b(int n10, int n11) {
        return this.a.changeVideoSize(n10, n11);
    }

    public boolean c(String object, int n10, int n11) {
        NvsObject nvsObject = i.n(n10, n11);
        this.a = nvsObject;
        n11 = 0;
        if (nvsObject == null) {
            return false;
        }
        if ((nvsObject = ((NvsTimeline)nvsObject).appendVideoTrack()) == null) {
            return false;
        }
        this.b = object = ((NvsVideoTrack)nvsObject).appendClip((String)object);
        if (object == null) {
            return false;
        }
        ((NvsVideoClip)object).setImageMotionAnimationEnabled(false);
        return true;
    }

    public void d(List list, a$a a$a) {
    }

    public Bitmap e(Object object) {
        return null;
    }

    public void release() {
        NvsStreamingContext nvsStreamingContext = NvsStreamingContext.getInstance();
        NvsTimeline nvsTimeline = this.a;
        nvsStreamingContext.removeTimeline(nvsTimeline);
    }
}

