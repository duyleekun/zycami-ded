/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u;

import com.zhiyun.cama.data.database.model.PublishWorks;
import com.zhiyun.cama.data.me.PublishLogManager$ReasonCode;
import d.v.c.v0.u.y;

public final class r
implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PublishLogManager$ReasonCode c;
    public final /* synthetic */ PublishWorks d;

    public /* synthetic */ r(String string2, String string3, PublishLogManager$ReasonCode publishLogManager$ReasonCode, PublishWorks publishWorks) {
        this.a = string2;
        this.b = string3;
        this.c = publishLogManager$ReasonCode;
        this.d = publishWorks;
    }

    public final void run() {
        String string2 = this.a;
        String string3 = this.b;
        PublishLogManager$ReasonCode publishLogManager$ReasonCode = this.c;
        PublishWorks publishWorks = this.d;
        y.j(string2, string3, publishLogManager$ReasonCode, publishWorks);
    }
}

