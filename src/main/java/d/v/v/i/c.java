/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.v.v.i;

import android.graphics.Bitmap;
import com.meicam.sdk.NvsRational;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsTimeline;
import d.v.h.g.a$a;
import d.v.v.i.a;
import java.util.List;

public class c
extends a {
    public void d(List object, a$a a$a) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            NvsRational nvsRational;
            Long l10 = (Long)object.next();
            NvsStreamingContext nvsStreamingContext = NvsStreamingContext.getInstance();
            NvsTimeline nvsTimeline = this.a;
            long l11 = l10;
            if ((nvsStreamingContext = nvsStreamingContext.grabImageFromTimeline(nvsTimeline, l11, nvsRational = this.c)) == null || a$a == null) continue;
            a$a.c((Bitmap)nvsStreamingContext, l10);
        }
        if (a$a != null) {
            a$a.a();
        }
    }

    public Bitmap f(Long object) {
        long l10;
        Object object2 = this.a;
        NvsTimeline nvsTimeline = null;
        if (object2 == null) {
            return null;
        }
        long l11 = (Long)object;
        long l12 = l11 - (l10 = ((NvsTimeline)(object2 = this.a)).getDuration());
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 >= 0) {
            return null;
        }
        object2 = NvsStreamingContext.getInstance();
        nvsTimeline = this.a;
        l11 = (Long)object;
        object = this.c;
        return ((NvsStreamingContext)object2).grabImageFromTimeline(nvsTimeline, l11, (NvsRational)object);
    }
}

