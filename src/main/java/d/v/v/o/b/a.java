/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.text.TextUtils
 */
package d.v.v.o.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsVideoFrameRetriever;
import d.v.h.i.b.a$a;

public class a
implements d.v.h.i.b.a {
    private String a;
    private int b;
    private int c;
    private a$a d;
    private NvsVideoFrameRetriever e;

    public a(String object) {
        this.a = object;
        this.e = object = NvsStreamingContext.getInstance().createVideoFrameRetriever((String)object);
    }

    public void a(a$a a$a) {
        this.d = a$a;
    }

    public boolean b(int n10, int n11) {
        this.b = n10;
        this.c = n11;
        return true;
    }

    public Bitmap c(long l10, int n10) {
        synchronized (this) {
            Bitmap bitmap;
            if (n10 > 0) {
                NvsVideoFrameRetriever nvsVideoFrameRetriever = this.e;
                bitmap = nvsVideoFrameRetriever.getFrameAtTimeWithCustomVideoFrameHeight(l10, n10);
            }
            try {
                NvsVideoFrameRetriever nvsVideoFrameRetriever = this.e;
                Object var4_4 = null;
                bitmap = nvsVideoFrameRetriever.getFrameAtTime(l10, 0);
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            finally {
            }
            return bitmap;
        }
    }

    public boolean d(long[] object) {
        int n10;
        Object object2 = this.a;
        if (object2 != null && (n10 = TextUtils.isEmpty((CharSequence)object2)) == 0) {
            for (long l10 : object) {
                int n11 = this.c;
                Object object3 = this.c(l10, n11);
                if (object3 == null) {
                    a$a a$a = this.d;
                    if (a$a == null) continue;
                    Exception exception = new Exception("");
                    object3 = "get bitmap error";
                    a$a.b(exception, (String)object3);
                    continue;
                }
                a$a a$a = this.d;
                if (a$a == null) continue;
                a$a.c((Bitmap)object3, l10);
            }
            object = this.d;
            if (object != null) {
                object.a();
            }
            return true;
        }
        object = this.d;
        if (object != null) {
            String string2 = "videoPath can not be null";
            object2 = new Exception(string2);
            object.b((Exception)object2, string2);
        }
        return false;
    }

    public void release() {
        this.e.release();
    }
}

