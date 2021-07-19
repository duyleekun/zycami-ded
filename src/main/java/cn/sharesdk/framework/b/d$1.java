/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.b;

import cn.sharesdk.framework.b.a;
import cn.sharesdk.framework.b.d;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.commons.MobProduct;
import com.mob.commons.SHARESDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.log.NLog;

public class d$1
implements Runnable {
    public final /* synthetic */ d a;

    public d$1(d d10) {
        this.a = d10;
    }

    public void run() {
        Object object = new SHARESDK();
        object = DeviceAuthorizer.authorize((MobProduct)object);
        Object object2 = this.a;
        object2 = d.a((d)object2);
        try {
            ((a)object2).a((String)object);
        }
        catch (Exception exception) {
            object2 = SSDKLog.b();
            ((NLog)object2).d(exception);
        }
    }
}

