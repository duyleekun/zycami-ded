/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.websocket;

import cn.leancloud.websocket.HeartBeatPolicy;

public class HeartBeatPolicy$1
implements Runnable {
    public final /* synthetic */ HeartBeatPolicy this$0;

    public HeartBeatPolicy$1(HeartBeatPolicy heartBeatPolicy) {
        this.this$0 = heartBeatPolicy;
    }

    public void run() {
        long l10 = System.currentTimeMillis();
        HeartBeatPolicy heartBeatPolicy = this.this$0;
        long l11 = HeartBeatPolicy.access$000(heartBeatPolicy);
        long l12 = (l10 -= l11) - (l11 = 360000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            HeartBeatPolicy heartBeatPolicy2 = this.this$0;
            heartBeatPolicy2.onTimeOut();
        } else {
            HeartBeatPolicy heartBeatPolicy3 = this.this$0;
            heartBeatPolicy3.sendPing();
        }
    }
}

