/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.heartbeatinfo;

import com.google.firebase.components.Component;
import com.google.firebase.heartbeatinfo.HeartBeatConsumer;
import com.google.firebase.heartbeatinfo.HeartBeatConsumerComponent$1;

public class HeartBeatConsumerComponent {
    private HeartBeatConsumerComponent() {
    }

    public static Component create() {
        HeartBeatConsumerComponent$1 heartBeatConsumerComponent$1 = new HeartBeatConsumerComponent$1();
        return Component.intoSet(heartBeatConsumerComponent$1, HeartBeatConsumer.class);
    }
}

