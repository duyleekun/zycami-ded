/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.TrafficStats
 *  android.os.Build$VERSION
 *  android.os.ParcelFileDescriptor
 */
package androidx.core.net;

import android.net.TrafficStats;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.core.net.DatagramSocketWrapper;
import java.io.FileDescriptor;
import java.net.DatagramSocket;
import java.net.Socket;

public final class TrafficStatsCompat {
    private TrafficStatsCompat() {
    }

    public static void clearThreadStatsTag() {
        TrafficStats.clearThreadStatsTag();
    }

    public static int getThreadStatsTag() {
        return TrafficStats.getThreadStatsTag();
    }

    public static void incrementOperationCount(int n10) {
        TrafficStats.incrementOperationCount((int)n10);
    }

    public static void incrementOperationCount(int n10, int n11) {
        TrafficStats.incrementOperationCount((int)n10, (int)n11);
    }

    public static void setThreadStatsTag(int n10) {
        TrafficStats.setThreadStatsTag((int)n10);
    }

    public static void tagDatagramSocket(DatagramSocket datagramSocket) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            TrafficStats.tagDatagramSocket((DatagramSocket)datagramSocket);
        } else {
            ParcelFileDescriptor parcelFileDescriptor = ParcelFileDescriptor.fromDatagramSocket((DatagramSocket)datagramSocket);
            FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
            DatagramSocketWrapper datagramSocketWrapper = new DatagramSocketWrapper(datagramSocket, fileDescriptor);
            TrafficStats.tagSocket((Socket)datagramSocketWrapper);
            parcelFileDescriptor.detachFd();
        }
    }

    public static void tagSocket(Socket socket) {
        TrafficStats.tagSocket((Socket)socket);
    }

    public static void untagDatagramSocket(DatagramSocket datagramSocket) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            TrafficStats.untagDatagramSocket((DatagramSocket)datagramSocket);
        } else {
            ParcelFileDescriptor parcelFileDescriptor = ParcelFileDescriptor.fromDatagramSocket((DatagramSocket)datagramSocket);
            FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
            DatagramSocketWrapper datagramSocketWrapper = new DatagramSocketWrapper(datagramSocket, fileDescriptor);
            TrafficStats.untagSocket((Socket)datagramSocketWrapper);
            parcelFileDescriptor.detachFd();
        }
    }

    public static void untagSocket(Socket socket) {
        TrafficStats.untagSocket((Socket)socket);
    }
}

