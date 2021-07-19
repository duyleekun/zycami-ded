/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 */
package d.v.c.w1;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.zhiyun.cama.data.api.entity.VersionInfo;
import com.zhiyun.cama.update.DownloadAPKService;
import d.v.c.w1.c;

public class c$a {
    public final /* synthetic */ c a;

    public c$a(c c10) {
        this.a = c10;
    }

    public void a(View view) {
        this.a.dismissAllowingStateLoss();
    }

    public void b(View object) {
        Object object2 = c.u(this.a);
        boolean bl2 = ((VersionInfo)object2).isForceUpdate();
        if (!bl2) {
            object2 = this.a;
            ((DialogFragment)object2).dismissAllowingStateLoss();
        }
        object.setEnabled(false);
        object = this.a.getActivity();
        object2 = c.u(this.a).getFileURL();
        DownloadAPKService.w((Activity)object, (String)object2);
    }
}

