/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 */
package d.v.a.j.c.z;

import android.app.Activity;
import android.view.View;
import androidx.core.app.ActivityCompat;
import com.zhiyun.account.set.privacy.getcode.PrivateGetCodeStatus;
import d.v.a.j.c.y;
import d.v.a.j.c.z.j;
import d.v.a.k.a;

public class j$b {
    public final /* synthetic */ j a;

    public j$b(j j10) {
        this.a = j10;
    }

    public void a(View view) {
        y y10 = j.k(this.a);
        PrivateGetCodeStatus privateGetCodeStatus = this.a.a();
        String string2 = j.l((j)this.a).b.getCountryCode();
        String string3 = j.l((j)this.a).b.getName();
        String string4 = j.l((j)this.a).c.getCode();
        y10.n(view, privateGetCodeStatus, string2, string3, string4);
    }

    public void b(View object) {
        boolean bl2 = d.v.a.k.a.g(object);
        if (!bl2) {
            object = this.a.getActivity();
            ActivityCompat.finishAfterTransition((Activity)object);
        }
    }
}

