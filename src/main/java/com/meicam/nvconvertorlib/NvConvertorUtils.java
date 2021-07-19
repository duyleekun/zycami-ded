/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecList
 *  android.media.MediaExtractor
 *  android.media.MediaFormat
 *  android.media.MediaMetadataRetriever
 */
package com.meicam.nvconvertorlib;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.meicam.nvconvertorlib.Logger;
import com.meicam.nvconvertorlib.NvConvertorUtils$NvMediaFileInfo;
import com.meicam.nvconvertorlib.NvVideoFrame;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashSet;

public class NvConvertorUtils {
    public static final int ERROR_EOF = 1;
    public static final int ERROR_FAIL = 2;
    public static final int ERROR_OK = 0;
    public static final int NV_CONVERTOR_FLAGS_REACH_END = 1;
    public static final int NV_MAX_PROCESS_COUNT = 70;
    public static final int NV_MAX_PROCESS_COUNT_4K = 30;
    public static final long NV_NOPTS_VALUE = Long.MAX_VALUE;
    public static final int NV_PIX_FMT_CONVERT_TYPE_422_TO_420P = 9;
    public static final int NV_PIX_FMT_CONVERT_TYPE_422_TO_NV12 = 10;
    public static final int NV_PIX_FMT_CONVERT_TYPE_422_TO_NV21 = 11;
    public static final int NV_TIME_BASE = 1000000;
    public static final int NvPixFmtNone = 255;
    public static final int NvPixFmt_NV12 = 0;
    public static final int NvPixFmt_NV21 = 1;
    public static final int NvPixFmt_YUV420P = 2;
    public static final int NvPixFmt_YUV422P = 3;
    public static final int NvPixFmt_YUYV422 = 4;
    private static final String TAG = "NvConvertorUtils";
    public static final int TIMEOUT_MS = 3000;
    private static MediaCodecInfo[] mMediaCodecInfoArray;

    static {
        System.loadLibrary("NvConvertNW");
        mMediaCodecInfoArray = NvConvertorUtils.GetMediaCodecInfoList();
    }

    private static native boolean ColorConvert(ByteBuffer var0, ByteBuffer var1, int var2, int var3, int var4);

    private static native int CopySampleBufferForDiffHeight(ByteBuffer var0, int var1, int var2, ByteBuffer var3, int var4, int var5, boolean var6);

    private static native String DecodeLicenseFile(byte[] var0, int var1);

    private static native int GetCpuCount();

    public static MediaCodecInfo[] GetMediaCodecInfoList() {
        int n10;
        int n11;
        int n12 = MediaCodecList.getCodecCount();
        MediaCodecInfo[] mediaCodecInfoArray = new MediaCodecInfo[n12];
        for (n11 = 0; n11 < n12; ++n11) {
            n10 = 0;
            mediaCodecInfoArray[n11] = null;
        }
        n10 = 0;
        for (n11 = 0; n11 < n12; ++n11) {
            int n13;
            MediaCodecInfo mediaCodecInfo = MediaCodecList.getCodecInfoAt((int)n11);
            String string2 = mediaCodecInfo.getName();
            String[] stringArray = mediaCodecInfo.getSupportedTypes();
            int n14 = stringArray.length;
            if (n14 <= 0) continue;
            HashSet<String> hashSet = new HashSet<String>();
            for (int i10 = 0; i10 < (n13 = stringArray.length); ++i10) {
                String string3 = stringArray[i10];
                String string4 = "audio/";
                boolean bl2 = string3.startsWith(string4);
                if (bl2 && !(bl2 = string2.startsWith(string4 = "OMX."))) continue;
                hashSet.add(string3);
            }
            int n15 = hashSet.size();
            if (n15 <= 0) continue;
            mediaCodecInfoArray[n10] = mediaCodecInfo;
            ++n10;
        }
        return mediaCodecInfoArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static NvConvertorUtils$NvMediaFileInfo GetMediaFileInfo(String object) {
        MediaExtractor object3;
        int n10 = 0;
        MediaMetadataRetriever mediaMetadataRetriever = null;
        if (object == null) {
            return null;
        }
        boolean bl2 = ((String)object).isEmpty();
        if (bl2) {
            return null;
        }
        Object object2 = new NvConvertorUtils$NvMediaFileInfo();
        try {
            object3 = new MediaExtractor();
            object3.setDataSource((String)object);
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("");
            String string2 = exception.getMessage();
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            Logger.e("NvConvertorUtils", object2);
            exception.printStackTrace();
            return null;
        }
        n10 = object3.getTrackCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            String string3;
            MediaFormat mediaFormat = object3.getTrackFormat(i10);
            String string4 = mediaFormat.getString("mime");
            int n12 = string4.startsWith(string3 = "video/");
            if (n12 != 0) {
                long l10;
                ((NvConvertorUtils$NvMediaFileInfo)object2).videoTrackCount = n12 = ((NvConvertorUtils$NvMediaFileInfo)object2).videoTrackCount + 1;
                ((NvConvertorUtils$NvMediaFileInfo)object2).videoTrackFormat = mediaFormat;
                string3 = "durationUs";
                ((NvConvertorUtils$NvMediaFileInfo)object2).duration = l10 = NvConvertorUtils.UsToNvTime(mediaFormat.getLong(string3));
            }
            if ((n11 = string4.startsWith(string3 = "audio/")) == 0) continue;
            n11 = ((NvConvertorUtils$NvMediaFileInfo)object2).audioTrackCount;
            if (n11 <= 0) {
                ((NvConvertorUtils$NvMediaFileInfo)object2).audioTrackForamt = mediaFormat;
            }
            ((NvConvertorUtils$NvMediaFileInfo)object2).audioTrackCount = ++n11;
        }
        object3.release();
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource((String)object);
            int n13 = 24;
            object = mediaMetadataRetriever.extractMetadata(n13);
            object = Integer.valueOf((String)object);
            ((NvConvertorUtils$NvMediaFileInfo)object2).displayRotation = n13 = ((Integer)object).intValue();
            return object2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return object2;
    }

    private static native int MemsetBuffer(ByteBuffer var0, byte var1);

    public static boolean NvCopyVideoBufferForDiffHeight(ByteBuffer byteBuffer, int n10, int n11, ByteBuffer byteBuffer2, int n12, int n13, boolean bl2) {
        if (byteBuffer != null && byteBuffer2 != null) {
            NvConvertorUtils.CopySampleBufferForDiffHeight(byteBuffer, n10, n11, byteBuffer2, n12, n13, bl2);
            return true;
        }
        return false;
    }

    public static String NvDecodeLicenseFile(byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        int n10 = byArray.length;
        return NvConvertorUtils.DecodeLicenseFile(byArray, n10);
    }

    public static int NvMemsetBuffer(ByteBuffer byteBuffer, byte by2) {
        if (byteBuffer == null) {
            return -1;
        }
        return NvConvertorUtils.MemsetBuffer(byteBuffer, by2);
    }

    public static int NvResizeImage(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int n10, int n11, int n12, int n13, boolean bl2) {
        if (byteBuffer != null && byteBuffer2 != null) {
            return NvConvertorUtils.ResizeImage(byteBuffer, byteBuffer2, n10, n11, n12, n13, bl2);
        }
        return -1;
    }

    public static long NvTimeToUs(long l10) {
        return l10;
    }

    private static native long NvTimeToUs(long var0, long var2);

    public static int NvUpAlignP02(int n10, int n11) {
        return (n10 + n11 + -1) / n11 * n11;
    }

    private static native int ResizeImage(ByteBuffer var0, ByteBuffer var1, int var2, int var3, int var4, int var5, boolean var6);

    public static MediaCodecInfo SelectEncoderByMimeType(String object) {
        String[] stringArray;
        int n10;
        int n11;
        int n12 = 0;
        String string2 = null;
        MediaCodecInfo mediaCodecInfo = null;
        for (n11 = 0; n11 < (n10 = (stringArray = mMediaCodecInfoArray).length); ++n11) {
            int n13;
            boolean bl2;
            MediaCodecInfo mediaCodecInfo2 = stringArray[n11];
            if (mediaCodecInfo2 == null || !(bl2 = (stringArray = stringArray[n11]).isEncoder())) continue;
            stringArray = mMediaCodecInfoArray[n11].getSupportedTypes();
            mediaCodecInfo2 = null;
            for (n10 = 0; n10 < (n13 = stringArray.length); ++n10) {
                String string3 = stringArray[n10];
                n13 = string3.compareToIgnoreCase((String)object);
                if (n13 != 0) continue;
                string2 = mMediaCodecInfoArray[n11].getName();
                break;
            }
            if (string2 != null) break;
        }
        while (n12 < (n11 = ((MediaCodecInfo[])(object = mMediaCodecInfoArray)).length)) {
            int n14;
            mediaCodecInfo = object[n12];
            if (mediaCodecInfo != null && (n14 = (object = object[n12]).isEncoder()) != 0 && (n14 = ((String)(object = mMediaCodecInfoArray[n12].getName())).compareToIgnoreCase(string2)) == 0) {
                return mMediaCodecInfoArray[n12];
            }
            ++n12;
        }
        return null;
    }

    public static long UsToNvTime(long l10) {
        return l10;
    }

    private static native long UsToNvTime(long var0, long var2);

    public static boolean convertBufferFormat(NvVideoFrame object, NvVideoFrame object2, int n10, int n11) {
        int n12;
        int n13;
        int n14 = 0;
        ByteBuffer byteBuffer = null;
        if (object != null && object2 != null && (n13 = ((NvVideoFrame)object).pixelFormat) == (n12 = 4) && (n13 = ((NvVideoFrame)object2).pixelFormat) == 0) {
            long l10;
            ((NvVideoFrame)object2).buffer = byteBuffer = ByteBuffer.allocateDirect(n10 * 3 * n11 / 2);
            ((NvVideoFrame)object2).streamTime = l10 = ((NvVideoFrame)object).streamTime;
            ((NvVideoFrame)object2).bufferFlags = n14 = ((NvVideoFrame)object).bufferFlags;
            ((NvVideoFrame)object).buffer.clear();
            ((NvVideoFrame)object2).buffer.clear();
            object = ((NvVideoFrame)object).buffer;
            object2 = ((NvVideoFrame)object2).buffer;
            NvConvertorUtils.ColorConvert((ByteBuffer)object, (ByteBuffer)object2, n10, n11, 10);
            return true;
        }
        return false;
    }

    public static void convertPixFmt(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int n10, int n11, int n12) {
        String string2 = "NvConvertorUtils";
        if (byteBuffer != null && byteBuffer2 != null) {
            int n13 = n10 & 1;
            if (n13 == 0 && (n13 = n11 & 1) == 0) {
                n13 = 9;
                if (n12 != n13 && n12 != (n13 = 10) && n12 != (n13 = 11)) {
                    Logger.e(string2, "pixel formet convert type is invalid!");
                    return;
                }
                NvConvertorUtils.ColorConvert(byteBuffer, byteBuffer2, n10, n11, n12);
                return;
            }
            Logger.e(string2, "image width or height is odd number!");
            return;
        }
        Logger.e(string2, "srcBuffer or dstBuffer is null!");
    }

    private static int extractValue(byte[] byArray, int n10) {
        int n11;
        int n12;
        while (n10 < (n12 = byArray.length) && (n12 = byArray[n10]) != (n11 = 10)) {
            int n13;
            n12 = byArray[n10];
            n11 = 48;
            if (n12 >= n11 && (n12 = byArray[n10]) <= (n13 = 57)) {
                int n14;
                for (n12 = n10 + 1; n12 < (n14 = byArray.length) && (n14 = byArray[n12]) >= n11 && (n14 = byArray[n12]) <= n13; ++n12) {
                }
                String string2 = new String(byArray, 0, n10, n12 -= n10);
                return Integer.parseInt(string2);
            }
            ++n10;
        }
        return 0;
    }

    public static int getCPUCount() {
        return NvConvertorUtils.GetCpuCount();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int getCPUMaxFreqKHz() {
        var0 = 0;
        var1_1 = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq";
        try {
            var2_4 = new File((String)var1_1);
            var3_5 = var2_4.exists();
            if (var3_5 != 0) {
                var3_5 = 128;
                var4_6 /* !! */  = new byte[var3_5];
                var5_7 = new FileInputStream((File)var2_4);
            }
            ** GOTO lbl34
        }
        catch (IOException v0) {
            return var0;
        }
        var5_7.read(var4_6 /* !! */ );
        var2_4 = null;
        for (var6_8 = 0; (var7_9 = var4_6 /* !! */ [var6_8]) >= (var8_10 = 48) && (var7_9 = var4_6 /* !! */ [var6_8]) <= (var8_10 = 57) && var6_8 < var3_5; ++var6_8) {
        }
        var1_1 = new String(var4_6 /* !! */ , 0, var6_8);
        var3_5 = Integer.parseInt((String)var1_1);
        var6_8 = (var1_1 = Integer.valueOf(var3_5)).intValue();
        if (var6_8 > 0) {
            var3_5 = var1_1.intValue();
        } else {
            var3_5 = 0;
            var1_1 = null;
        }
        {
            catch (Throwable var1_2) {
                var5_7.close();
                throw var1_2;
            }
lbl32:
            // 1 sources

            while (true) {
                var5_7.close();
lbl34:
                // 2 sources

                var3_5 = 0;
                var1_1 = null;
lbl36:
                // 2 sources

                while (true) {
                    if (var3_5 != 0) return var3_5;
                    var4_6 /* !! */  = (byte[])"/proc/cpuinfo";
                    var2_4 = new FileInputStream((String)var4_6 /* !! */ );
                    var4_6 /* !! */  = (byte[])"cpu MHz";
                    try {
                        var9_11 = NvConvertorUtils.parseFileForValue((String)var4_6 /* !! */ , (FileInputStream)var2_4) * 1000;
                        if (var9_11 > var3_5) {
                            var3_5 = var9_11;
                        }
                    }
                    finally {
                        var2_4.close();
                    }
                    {
                    }
                    break;
                }
                break;
            }
            catch (NumberFormatException v1) {
                ** continue;
            }
            var5_7.close();
            ** continue;
        }
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long getTotalMemory() {
        long l10 = 0L;
        String string2 = "/proc/meminfo";
        FileInputStream fileInputStream = new FileInputStream(string2);
        string2 = "MemTotal";
        {
            catch (IOException iOException) {
                return l10;
            }
        }
        int n10 = NvConvertorUtils.parseFileForValue(string2, fileInputStream);
        l10 = n10;
        long l11 = 1024L;
        l10 *= l11;
        fileInputStream.close();
        return l10;
        catch (Throwable throwable) {
            fileInputStream.close();
            throw throwable;
        }
    }

    private static int parseFileForValue(String string2, FileInputStream fileInputStream) {
        int n10 = 1024;
        byte[] byArray = new byte[n10];
        int n11 = fileInputStream.read(byArray);
        block8: for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            int n13;
            block10: {
                n13 = byArray[i10];
                n12 = 10;
                if (n13 != n12 && i10 != 0) continue;
                try {
                    n13 = byArray[i10];
                    if (n13 != n12) break block10;
                    ++i10;
                }
                catch (IOException | NumberFormatException exception) {}
            }
            for (n13 = i10; n13 < n11; ++n13) {
                n12 = n13 - i10;
                int n14 = byArray[n13];
                char c10 = string2.charAt(n12);
                if (n14 != c10) continue block8;
                n14 = string2.length() + -1;
                if (n12 != n14) continue;
                return NvConvertorUtils.extractValue(byArray, n13);
            }
            continue;
            break;
        }
        return 0;
    }
}

