/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2.util;

import android.os.SystemClock;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader$Loadable;
import com.google.android.exoplayer2.util.SntpClient$InitializationCallback;
import com.google.android.exoplayer2.util.SntpClient$NtpTimeCallback;
import com.google.android.exoplayer2.util.SntpClient$NtpTimeLoadable;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public final class SntpClient {
    public static final String DEFAULT_NTP_HOST = "time.android.com";
    private static final int NTP_LEAP_NOSYNC = 3;
    private static final int NTP_MODE_BROADCAST = 5;
    private static final int NTP_MODE_CLIENT = 3;
    private static final int NTP_MODE_SERVER = 4;
    private static final int NTP_PACKET_SIZE = 48;
    private static final int NTP_PORT = 123;
    private static final int NTP_STRATUM_DEATH = 0;
    private static final int NTP_STRATUM_MAX = 15;
    private static final int NTP_VERSION = 3;
    private static final long OFFSET_1900_TO_1970 = 2208988800L;
    private static final int ORIGINATE_TIME_OFFSET = 24;
    private static final int RECEIVE_TIME_OFFSET = 32;
    private static final int TIMEOUT_MS = 10000;
    private static final int TRANSMIT_TIME_OFFSET = 40;
    private static long elapsedRealtimeOffsetMs = 0L;
    private static boolean isInitialized = false;
    private static final Object loaderLock;
    private static String ntpHost = "time.android.com";
    private static final Object valueLock;

    static {
        Object object;
        loaderLock = object = new Object();
        valueLock = object = new Object();
    }

    private SntpClient() {
    }

    public static /* synthetic */ Object access$100() {
        return loaderLock;
    }

    public static /* synthetic */ Object access$200() {
        return valueLock;
    }

    public static /* synthetic */ boolean access$300() {
        return isInitialized;
    }

    public static /* synthetic */ boolean access$302(boolean bl2) {
        isInitialized = bl2;
        return bl2;
    }

    public static /* synthetic */ long access$400() {
        return SntpClient.loadNtpTimeOffsetMs();
    }

    public static /* synthetic */ long access$502(long l10) {
        elapsedRealtimeOffsetMs = l10;
        return l10;
    }

    private static void checkValidServerReply(byte by2, byte by3, int n10, long l10) {
        byte by4 = 3;
        if (by2 != by4) {
            by2 = (byte)4;
            if (by3 != by2 && by3 != (by2 = (byte)5)) {
                StringBuilder stringBuilder = new StringBuilder(26);
                stringBuilder.append("SNTP: Untrusted mode: ");
                stringBuilder.append(by3);
                String string2 = stringBuilder.toString();
                IOException iOException = new IOException(string2);
                throw iOException;
            }
            if (n10 != 0 && n10 <= (by2 = (byte)15)) {
                long l11 = 0L;
                long l12 = l10 - l11;
                by2 = (byte)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                if (by2 != 0) {
                    return;
                }
                IOException iOException = new IOException("SNTP: Zero transmitTime");
                throw iOException;
            }
            StringBuilder stringBuilder = new StringBuilder(36);
            stringBuilder.append("SNTP: Untrusted stratum: ");
            stringBuilder.append(n10);
            String string3 = stringBuilder.toString();
            IOException iOException = new IOException(string3);
            throw iOException;
        }
        IOException iOException = new IOException("SNTP: Unsynchronized server");
        throw iOException;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static long getElapsedRealtimeOffsetMs() {
        Object object = valueLock;
        synchronized (object) {
            boolean bl2 = isInitialized;
            if (!bl2) return -9223372036854775807L;
            return elapsedRealtimeOffsetMs;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String getNtpHost() {
        Object object = valueLock;
        synchronized (object) {
            return ntpHost;
        }
    }

    public static void initialize(Loader loader, SntpClient$InitializationCallback sntpClient$InitializationCallback) {
        Object object;
        boolean bl2 = SntpClient.isInitialized();
        if (bl2) {
            if (sntpClient$InitializationCallback != null) {
                sntpClient$InitializationCallback.onInitialized();
            }
            return;
        }
        if (loader == null) {
            object = "SntpClient";
            loader = new Loader((String)object);
        }
        object = new SntpClient$NtpTimeLoadable(null);
        SntpClient$NtpTimeCallback sntpClient$NtpTimeCallback = new SntpClient$NtpTimeCallback(sntpClient$InitializationCallback);
        loader.startLoading((Loader$Loadable)object, sntpClient$NtpTimeCallback, 1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean isInitialized() {
        Object object = valueLock;
        synchronized (object) {
            return isInitialized;
        }
    }

    private static long loadNtpTimeOffsetMs() {
        int n10;
        InetAddress inetAddress = InetAddress.getByName(SntpClient.getNtpHost());
        DatagramSocket datagramSocket = new DatagramSocket();
        int by2 = 10000;
        try {
            datagramSocket.setSoTimeout(by2);
            n10 = 48;
        }
        catch (Throwable throwable) {
            try {
                datagramSocket.close();
            }
            catch (Throwable throwable2) {
                throwable.addSuppressed(throwable2);
            }
            throw throwable;
        }
        byte[] byArray = new byte[n10];
        int n11 = 123;
        DatagramPacket datagramPacket = new DatagramPacket(byArray, n10, inetAddress, n11);
        int n12 = 27;
        n11 = 0;
        byArray[0] = n12;
        long l10 = System.currentTimeMillis();
        long l11 = SystemClock.elapsedRealtime();
        n12 = 40;
        SntpClient.writeTimestamp(byArray, n12, l10);
        datagramSocket.send(datagramPacket);
        datagramPacket = new DatagramPacket(byArray, n10);
        datagramSocket.receive(datagramPacket);
        long l12 = SystemClock.elapsedRealtime();
        l11 = l12 - l11;
        l10 += l11;
        byte by3 = (byte)(byArray[0] >> 6 & 3);
        byte by4 = (byte)(byArray[0] & 7);
        n11 = 1;
        n11 = byArray[n11] & 0xFF;
        int n13 = 24;
        l11 = SntpClient.readTimestamp(byArray, n13);
        int n14 = 32;
        long l13 = SntpClient.readTimestamp(byArray, n14);
        long l14 = SntpClient.readTimestamp(byArray, n12);
        SntpClient.checkValidServerReply(by3, by4, n11, l14);
        l13 -= l11;
        l13 += (l14 -= l10);
        long l15 = 2;
        l10 = l10 + (l13 /= l15) - l12;
        datagramSocket.close();
        return l10;
    }

    private static long read32(byte[] byArray, int n10) {
        int n11 = byArray[n10];
        int n12 = n10 + 1;
        n12 = byArray[n12];
        int n13 = n10 + 2;
        n13 = byArray[n13];
        int n14 = byArray[n10 += 3];
        n10 = n11 & 0x80;
        int n15 = 128;
        if (n10 == n15) {
            n10 = n11 & 0x7F;
            n11 = n10 + 128;
        }
        if ((n10 = n12 & 0x80) == n15) {
            n10 = n12 & 0x7F;
            n12 = n10 + 128;
        }
        if ((n10 = n13 & 0x80) == n15) {
            n10 = n13 & 0x7F;
            n13 = n10 + 128;
        }
        if ((n10 = n14 & 0x80) == n15) {
            n14 = (n14 & 0x7F) + n15;
        }
        long l10 = (long)n11 << 24;
        long l11 = (long)n12 << 16;
        l10 += l11;
        l11 = (long)n13 << 8;
        long l12 = n14;
        return (l10 += l11) + l12;
    }

    private static long readTimestamp(byte[] byArray, int n10) {
        long l10 = SntpClient.read32(byArray, n10);
        long l11 = SntpClient.read32(byArray, n10 += 4);
        long l12 = 0L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false && (object = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1)) == false) {
            return l12;
        }
        l10 -= 2208988800L;
        l12 = 1000L;
        l11 = l11 * l12 / 0x100000000L;
        return (l10 *= l12) + l11;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void setNtpHost(String string2) {
        Object object = valueLock;
        synchronized (object) {
            String string3 = ntpHost;
            boolean bl2 = string3.equals(string2);
            if (!bl2) {
                ntpHost = string2;
                string2 = null;
                isInitialized = false;
            }
            return;
        }
    }

    private static void writeTimestamp(byte[] byArray, int n10, long l10) {
        byte by2;
        byte by3;
        int n11;
        int n12;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        byte by4 = 0;
        if (l12 == false) {
            int n13 = n10 + 8;
            Arrays.fill(byArray, n10, n13, (byte)0);
            return;
        }
        long l13 = 1000L;
        long l14 = l10 / l13;
        long l15 = l14 * l13;
        l10 -= l15;
        l12 = n10 + 1;
        int n14 = 24;
        byArray[n10] = n12 = (int)((int)((l14 += 2208988800L) >> n14));
        n10 = (int)(l12 + true);
        n12 = 16;
        byArray[l12] = n11 = (int)((int)(l14 >> n12));
        l12 = n10 + 1;
        n11 = 8;
        byArray[n10] = by3 = (byte)(l14 >> n11);
        n10 = (int)(l12 + true);
        byArray[l12] = by4 = (byte)(l14 >> 0);
        l10 = l10 * 0x100000000L / l13;
        l12 = n10 + 1;
        byArray[n10] = by4 = (byte)(l10 >> n14);
        n10 = (int)(l12 + true);
        byArray[l12] = by4 = (byte)(l10 >> n12);
        l12 = n10 + 1;
        byArray[n10] = by2 = (byte)(l10 >> n11);
        byArray[l12] = n10 = (int)((byte)(Math.random() * 255.0));
    }
}

