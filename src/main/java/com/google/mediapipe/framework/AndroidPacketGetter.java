/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 */
package com.google.mediapipe.framework;

import android.graphics.Bitmap;
import com.google.common.base.Preconditions;
import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.framework.PacketGetter;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class AndroidPacketGetter {
    private AndroidPacketGetter() {
    }

    /*
     * WARNING - void declaration
     */
    public static void copyRgbToBitmap(Packet packet, Bitmap bitmap) {
        void var2_5;
        boolean n10 = bitmap.isMutable();
        Preconditions.checkArgument(n10, "Input bitmap should be mutable.");
        Bitmap.Config config = bitmap.getConfig();
        Object object = Bitmap.Config.ARGB_8888;
        boolean bl2 = true;
        if (config == object) {
            boolean bl3 = bl2;
        } else {
            boolean bl4 = false;
            config = null;
        }
        object = "Input bitmap should be of type ARGB_8888.";
        Preconditions.checkArgument((boolean)var2_5, object);
        int n11 = PacketGetter.getImageWidth(packet);
        int n12 = PacketGetter.getImageHeight(packet);
        int n13 = bitmap.getByteCount();
        int n14 = n11 * n12 * 4;
        if (n13 != n14) {
            bl2 = false;
        }
        Preconditions.checkArgument(bl2, "Input bitmap size mismatch.");
        AndroidPacketGetter.copyRgbToBitmap(packet, bitmap, n11, n12);
    }

    private static void copyRgbToBitmap(Packet packet, Bitmap bitmap, int n10, int n11) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n10 * n11 * 4);
        PacketGetter.getRgbaFromRgb(packet, byteBuffer);
        bitmap.copyPixelsFromBuffer((Buffer)byteBuffer);
    }

    /*
     * WARNING - void declaration
     */
    public static void copyRgbaToBitmap(Packet packet, Bitmap bitmap) {
        void var2_5;
        boolean n10 = bitmap.isMutable();
        Preconditions.checkArgument(n10, "Input bitmap should be mutable.");
        Bitmap.Config config = bitmap.getConfig();
        Object object = Bitmap.Config.ARGB_8888;
        boolean bl2 = true;
        if (config == object) {
            boolean bl3 = bl2;
        } else {
            boolean bl4 = false;
            config = null;
        }
        object = "Input bitmap should be of type ARGB_8888.";
        Preconditions.checkArgument((boolean)var2_5, object);
        int n11 = PacketGetter.getImageWidth(packet);
        int n12 = PacketGetter.getImageHeight(packet);
        int n13 = bitmap.getByteCount();
        int n14 = n11 * n12 * 4;
        if (n13 != n14) {
            bl2 = false;
        }
        Preconditions.checkArgument(bl2, "Input bitmap size mismatch.");
        AndroidPacketGetter.copyRgbaToBitmap(packet, bitmap, n11, n12);
    }

    private static void copyRgbaToBitmap(Packet packet, Bitmap bitmap, int n10, int n11) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n10 * n11 * 4);
        Object[] objectArray = ByteOrder.nativeOrder();
        byteBuffer.order((ByteOrder)objectArray);
        boolean bl2 = PacketGetter.getImageData(packet, byteBuffer);
        Object object = n10;
        objectArray = new Object[]{object, object = Integer.valueOf(n11)};
        object = String.format("Got error from getImageData, returning null Bitmap. Image width %d, height %d", objectArray);
        Preconditions.checkState(bl2, object);
        bitmap.copyPixelsFromBuffer((Buffer)byteBuffer);
    }

    public static Bitmap getBitmapFromRgb(Packet packet) {
        int n10 = PacketGetter.getImageWidth(packet);
        int n11 = PacketGetter.getImageHeight(packet);
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        config = Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)config);
        AndroidPacketGetter.copyRgbToBitmap(packet, (Bitmap)config, n10, n11);
        return config;
    }

    public static Bitmap getBitmapFromRgba(Packet packet) {
        int n10 = PacketGetter.getImageWidth(packet);
        int n11 = PacketGetter.getImageHeight(packet);
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        config = Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)config);
        AndroidPacketGetter.copyRgbaToBitmap(packet, (Bitmap)config, n10, n11);
        return config;
    }
}

