/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package d.o.a.a.a.b.a;

import android.net.Uri;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OooO00o$OooO00o;
import com.quvideo.mobile.external.platform.log.OooO00o;
import com.quvideo.mobile.external.platform.uploader.listener.OooO0O0;
import d.o.a.a.a.b.a.g$b;

public class g$b$a
implements OooO0O0 {
    public final /* synthetic */ OooO00o$OooO00o a;
    public final /* synthetic */ Uri b;

    public g$b$a(g$b g$b, OooO00o$OooO00o oooO00o$OooO00o, Uri uri) {
        this.a = oooO00o$OooO00o;
        this.b = uri;
    }

    public void OooO00o(String object, int n10) {
        object = new StringBuilder();
        ((StringBuilder)object).append("onUploadProgress: ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        OooO00o.OooO00o("cloudEngine", (String)object);
        object = this.a;
        Uri uri = this.b;
        object.OooO00o(uri, n10);
    }

    public void OooO00o(String charSequence, int n10, String string2) {
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("onUploadFailed: error = ");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append(" , msg = ");
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        OooO00o.OooO00o("cloudEngine", (String)charSequence);
        this.a.OooO00o(string2, n10);
    }

    public void OooO00o(String object, String string2) {
        object = new StringBuilder();
        ((StringBuilder)object).append("onUploadSuccess: url = ");
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        OooO00o.OooO00o("cloudEngine", (String)object);
        object = this.a;
        Uri uri = this.b;
        object.OooO00o(uri, string2);
    }
}

