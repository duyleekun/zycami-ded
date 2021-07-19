/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.z0;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.zhiyun.editorinterface.compose.ComposeParams$Resolution;
import d.v.c.m1.b;
import d.v.c.z0.j;

public class j$a {
    public final /* synthetic */ j a;

    public j$a(j j10) {
        this.a = j10;
    }

    public void a(View object, ComposeParams$Resolution composeParams$Resolution) {
        boolean bl2;
        object = ComposeParams$Resolution.RESOLUTION_4K;
        if (composeParams$Resolution != object || (bl2 = b.c((Fragment)(object = this.a)))) {
            object = j.u(this.a);
            if (object != null) {
                object = j.u(this.a);
                object.a(composeParams$Resolution);
            }
            object = this.a;
            object.i();
        }
    }

    public void b() {
        this.a.i();
    }
}

