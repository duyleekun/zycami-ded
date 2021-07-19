/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVLogger;
import cn.leancloud.ArchivedRequests;
import cn.leancloud.core.AppConfiguration;
import java.util.Map;
import java.util.TimerTask;

public class ArchivedRequests$1
extends TimerTask {
    public final /* synthetic */ ArchivedRequests this$0;

    public ArchivedRequests$1(ArchivedRequests archivedRequests) {
        this.this$0 = archivedRequests;
    }

    public void run() {
        int n10;
        Object object = ArchivedRequests.access$000();
        Object object2 = "begin to run timer task for archived request.";
        ((AVLogger)object).i((String)object2);
        object = AppConfiguration.getGlobalNetworkingDetector();
        if (object != null && (n10 = object.isConnected()) != 0) {
            boolean bl2;
            object = ArchivedRequests.access$100(this.this$0);
            n10 = object.isEmpty();
            if (n10 != 0 && (n10 = (object = ArchivedRequests.access$200(this.this$0)).isEmpty()) != 0) {
                ArchivedRequests.access$000().i("ignore timer task bcz request queue is empty.");
                return;
            }
            object = ArchivedRequests.access$100(this.this$0);
            n10 = object.size();
            if (n10 > 0) {
                object = this.this$0;
                object2 = ArchivedRequests.access$100((ArchivedRequests)object);
                bl2 = false;
                ArchivedRequests.access$300((ArchivedRequests)object, (Map)object2, false);
            }
            if ((n10 = (object = ArchivedRequests.access$200(this.this$0)).size()) > 0) {
                object = this.this$0;
                object2 = ArchivedRequests.access$200((ArchivedRequests)object);
                bl2 = true;
                ArchivedRequests.access$300((ArchivedRequests)object, (Map)object2, bl2);
            }
            ArchivedRequests.access$000().i("end to run timer task for archived request.");
            return;
        }
        ArchivedRequests.access$000().i("ignore timer task bcz networking is unavailable.");
    }
}

