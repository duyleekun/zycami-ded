/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.q1.i0;

import android.view.View;
import com.zhiyun.cama.data.api.entity.ServerEntity;
import com.zhiyun.cama.set.server.ServersFragment$a;

public final class e
implements View.OnClickListener {
    public final /* synthetic */ ServersFragment$a a;
    public final /* synthetic */ ServerEntity b;

    public /* synthetic */ e(ServersFragment$a a10, ServerEntity serverEntity) {
        this.a = a10;
        this.b = serverEntity;
    }

    public final void onClick(View view) {
        ServersFragment$a serversFragment$a = this.a;
        ServerEntity serverEntity = this.b;
        serversFragment$a.f(serverEntity, view);
    }
}

