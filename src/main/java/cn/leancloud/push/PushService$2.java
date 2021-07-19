/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package cn.leancloud.push;

import android.content.Context;
import cn.leancloud.push.AVConnectivityListener;
import cn.leancloud.push.PushService;
import cn.leancloud.push.PushService$2$1;
import java.util.Timer;
import java.util.TimerTask;

public class PushService$2
implements AVConnectivityListener {
    private volatile boolean connectionEstablished = false;
    public final /* synthetic */ PushService this$0;

    public PushService$2(PushService pushService) {
        this.this$0 = pushService;
    }

    public static /* synthetic */ boolean access$200(PushService$2 pushService$2) {
        return pushService$2.connectionEstablished;
    }

    public void onMobile(Context context) {
        PushService.access$000().d("Connection resumed with Mobile...");
        this.connectionEstablished = true;
        PushService.access$100(this.this$0).autoConnection();
    }

    public void onNotConnected(Context object) {
        boolean bl2 = this.connectionEstablished;
        if (!bl2) {
            PushService.access$000().d("Connectivity isn't established yet.");
            return;
        }
        PushService.access$000().d("Connectivity broken");
        this.connectionEstablished = false;
        object = PushService.access$300(this.this$0);
        PushService$2$1 pushService$2$1 = new PushService$2$1(this);
        ((Timer)object).schedule((TimerTask)pushService$2$1, 3000L);
    }

    public void onOtherConnected(Context context) {
        PushService.access$000().d("Connectivity resumed with Others");
        this.connectionEstablished = true;
        PushService.access$100(this.this$0).autoConnection();
    }

    public void onWifi(Context context) {
        PushService.access$000().d("Connection resumed with Wifi...");
        this.connectionEstablished = true;
        PushService.access$100(this.this$0).autoConnection();
    }
}

