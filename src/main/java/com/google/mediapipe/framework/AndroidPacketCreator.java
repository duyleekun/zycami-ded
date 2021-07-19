/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 */
package com.google.mediapipe.framework;

import android.graphics.Bitmap;
import com.google.mediapipe.framework.Graph;
import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.framework.PacketCreator;

public class AndroidPacketCreator
extends PacketCreator {
    public AndroidPacketCreator(Graph graph) {
        super(graph);
    }

    private native long nativeCreateRgbImageFrame(long var1, Bitmap var3);

    private native long nativeCreateRgbaImageFrame(long var1, Bitmap var3);

    public Packet createRgbImageFrame(Bitmap object) {
        Bitmap.Config config;
        Bitmap.Config config2 = object.getConfig();
        if (config2 == (config = Bitmap.Config.ARGB_8888)) {
            long l10 = this.mediapipeGraph.getNativeHandle();
            return Packet.create(this.nativeCreateRgbImageFrame(l10, (Bitmap)object));
        }
        object = new RuntimeException("bitmap must use ARGB_8888 config.");
        throw object;
    }

    public Packet createRgbaImageFrame(Bitmap object) {
        Bitmap.Config config;
        Bitmap.Config config2 = object.getConfig();
        if (config2 == (config = Bitmap.Config.ARGB_8888)) {
            long l10 = this.mediapipeGraph.getNativeHandle();
            return Packet.create(this.nativeCreateRgbaImageFrame(l10, (Bitmap)object));
        }
        object = new RuntimeException("bitmap must use ARGB_8888 config.");
        throw object;
    }
}

