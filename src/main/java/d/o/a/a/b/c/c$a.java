/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.o.a.a.b.c;

import android.text.TextUtils;
import com.quvideo.mobile.external.platform.api.oss.model.OSSUploadResponse;
import com.quvideo.mobile.external.platform.api.oss.model.OSSUploadResponse$Data;
import com.quvideo.mobile.external.platform.uploader.OooO;
import com.quvideo.mobile.external.platform.uploader.OooOo00;
import d.o.a.a.b.c.c;
import d.o.a.a.b.c.e;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class c$a
implements e {
    public final /* synthetic */ c a;

    public c$a(c c10) {
        this.a = c10;
    }

    public void a(OSSUploadResponse object, String object2) {
        object2 = c.a(this.a);
        boolean bl2 = ((AtomicBoolean)object2).get();
        if (bl2) {
            String string2;
            if (object != null && (object2 = ((OSSUploadResponse)object).data) != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object2 = ((OSSUploadResponse$Data)object2).accessUrl))) && !(bl2 = TextUtils.isEmpty((CharSequence)(object2 = c.b((c)this.a).OooO0oO.OooOO0))) && (bl2 = ((String)(object2 = object.data.accessUrl)).equals(string2 = c.b((c)this.a).OooO0oO.OooOO0))) {
                object2 = this.a;
                string2 = ((c)object2).a;
                object2 = c.b((c)object2);
                OooOo00.g(string2, (OooO)object2, (OSSUploadResponse)object);
            }
            try {
                object = this.a;
            }
            catch (Throwable throwable) {
                c.c(this.a).unlock();
                throw throwable;
            }
            object = c.c((c)object);
            ((ReentrantLock)object).lock();
            object = this.a;
            object = c.d((c)object);
            object.signal();
            object = c.c(this.a);
            ((ReentrantLock)object).unlock();
        }
    }
}

