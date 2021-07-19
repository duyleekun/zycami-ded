/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.framework;

import com.google.mediapipe.framework.Graph$1;
import com.google.mediapipe.framework.Packet;

public class Graph$PacketBufferItem {
    public final Packet packet;
    public final Long timestamp;

    private Graph$PacketBufferItem(Packet packet, Long l10) {
        this.packet = packet;
        this.timestamp = l10;
    }

    public /* synthetic */ Graph$PacketBufferItem(Packet packet, Long l10, Graph$1 graph$1) {
        this(packet, l10);
    }
}

