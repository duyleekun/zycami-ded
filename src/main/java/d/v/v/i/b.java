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
import d.v.h.g.a$a;
import d.v.v.i.a;
import java.util.List;

public class b
extends a {
    private boolean f(d.v.h.f.a a10) {
        int n10;
        int n11 = a10.f();
        if (n11 == (n10 = -1)) {
            return false;
        }
        d.v.v.h.a a11 = d.v.v.h.a.x();
        NvsVideoClip nvsVideoClip = this.b;
        return a11.a(nvsVideoClip, a10);
    }

    public void d(List object, a$a object2) {
        boolean bl2;
        Object object3 = this.b;
        if (object3 == null) {
            if (object2 != null) {
                object3 = "NvsFilterBitmapFetcher should be init";
                object = new Exception((String)object3);
                object2.b((Exception)object, (String)object3);
            }
            object = NvsStreamingContext.getInstance();
            object2 = this.a;
            ((NvsStreamingContext)object).removeTimeline((NvsTimeline)object2);
            return;
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object3 = (d.v.h.f.a)object.next();
            boolean bl3 = this.f((d.v.h.f.a)object3);
            if (!bl3) continue;
            NvsStreamingContext nvsStreamingContext = NvsStreamingContext.getInstance();
            NvsTimeline nvsTimeline = this.a;
            long l10 = 500000L;
            NvsRational nvsRational = this.c;
            if ((nvsStreamingContext = nvsStreamingContext.grabImageFromTimeline(nvsTimeline, l10, nvsRational)) == null || object2 == null) continue;
            object2.c((Bitmap)nvsStreamingContext, object3);
        }
        if (object2 != null) {
            object2.a();
        }
    }

    public Bitmap g(d.v.h.f.a object) {
        NvsObject nvsObject = this.b;
        Bitmap bitmap = null;
        if (nvsObject == null) {
            return null;
        }
        boolean bl2 = this.f((d.v.h.f.a)object);
        if (bl2) {
            object = NvsStreamingContext.getInstance();
            nvsObject = this.a;
            long l10 = 500000L;
            NvsRational nvsRational = this.c;
            bitmap = ((NvsStreamingContext)object).grabImageFromTimeline((NvsTimeline)nvsObject, l10, nvsRational);
        }
        return bitmap;
    }
}

