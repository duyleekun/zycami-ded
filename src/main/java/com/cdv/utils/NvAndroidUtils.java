/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$MemoryInfo
 *  android.content.Context
 *  android.hardware.display.DisplayManager
 *  android.media.MediaCodec
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecInfo$CodecCapabilities
 *  android.media.MediaCodecInfo$CodecProfileLevel
 *  android.media.MediaExtractor
 *  android.media.MediaMuxer
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Process
 *  android.util.Log
 */
package com.cdv.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaExtractor;
import android.media.MediaMuxer;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import java.io.FileDescriptor;

public class NvAndroidUtils {
    private static final String TAG = "Meicam";

    public static int GetLevelSupportedFromProfile(String codecProfileLevel, MediaCodecInfo codecCapabilities, int n10) {
        int n11;
        block18: {
            int n12;
            block17: {
                int n13;
                block16: {
                    n11 = -1;
                    if (codecCapabilities == null) {
                        return n11;
                    }
                    codecCapabilities = codecCapabilities.getCapabilitiesForType((String)codecProfileLevel);
                    if (codecCapabilities != null) break block16;
                    return n11;
                }
                codecCapabilities = codecCapabilities.profileLevels;
                int n14 = ((MediaCodecInfo.CodecProfileLevel[])codecCapabilities).length;
                int n15 = 0;
                for (n13 = 0; n13 < n14; ++n13) {
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel2 = codecCapabilities[n13];
                    int n16 = codecProfileLevel2.profile;
                    if (n16 != n10) continue;
                    int n17 = codecProfileLevel2.level;
                    if (n17 <= n15) continue;
                    n15 = n17;
                }
                n12 = 0;
                codecCapabilities = null;
                n14 = Build.VERSION.SDK_INT;
                n13 = 21;
                if (n14 < n13) break block17;
                codecCapabilities = MediaCodecInfo.CodecCapabilities.createFromProfileLevel((String)codecProfileLevel, (int)n10, (int)n15);
            }
            if (codecCapabilities == null) {
                return n11;
            }
            codecProfileLevel = codecCapabilities.profileLevels;
            n12 = ((MediaCodecInfo.CodecProfileLevel[])codecProfileLevel).length;
            if (n12 <= 0) break block18;
            codecProfileLevel = codecProfileLevel[0];
            try {
                return codecProfileLevel.level;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return n11;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static MediaExtractor createMediaExtractorFromMediaFilePath(Context context, String object) {
        void var0_3;
        String string2;
        MediaExtractor mediaExtractor;
        block6: {
            try {
                mediaExtractor = new MediaExtractor();
                string2 = "content://";
            }
            catch (Exception exception) {
                mediaExtractor = null;
                break block6;
            }
            try {
                boolean n10 = ((String)object).startsWith(string2);
                if (n10) {
                    context = context.getContentResolver();
                    object = Uri.parse((String)object);
                    string2 = "r";
                    context = context.openFileDescriptor((Uri)object, string2);
                    object = context.getFileDescriptor();
                    mediaExtractor.setDataSource((FileDescriptor)object);
                    context.close();
                    return mediaExtractor;
                }
                string2 = "assets:/";
                boolean bl2 = ((String)object).startsWith(string2);
                if (bl2) {
                    context = context.getAssets();
                    int n102 = 8;
                    object = ((String)object).substring(n102);
                    context = context.openFd((String)object);
                    FileDescriptor fileDescriptor = context.getFileDescriptor();
                    long l10 = context.getStartOffset();
                    long l11 = context.getLength();
                    string2 = mediaExtractor;
                    mediaExtractor.setDataSource(fileDescriptor, l10, l11);
                    context.close();
                    return mediaExtractor;
                }
                mediaExtractor.setDataSource((String)object);
                return mediaExtractor;
            }
            catch (Exception exception) {}
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("");
        string2 = var0_3.getMessage();
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        string2 = TAG;
        Log.e((String)string2, (String)object);
        var0_3.printStackTrace();
        if (mediaExtractor == null) return null;
        mediaExtractor.release();
        return null;
    }

    public static MediaMuxer createMediaMuxerFromContentUrl(Context context, String object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 < n11) {
            return null;
        }
        try {
            context = context.getContentResolver();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        object = Uri.parse((String)object);
        String string2 = "rwt";
        context = context.openFileDescriptor((Uri)object, string2);
        object = context.getFileDescriptor();
        n11 = 0;
        string2 = new MediaMuxer((FileDescriptor)object, 0);
        context.close();
        return string2;
    }

    public static boolean displayIsSupportHDR(Context object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 < n11) {
            return false;
        }
        Class<DisplayManager> clazz = DisplayManager.class;
        object = object.getSystemService(clazz);
        object = (DisplayManager)object;
        object = object.getDisplay(0);
        object = object.getHdrCapabilities();
        object = object.getSupportedHdrTypes();
        try {
            n10 = ((Context)object).length;
            if (n10 == 0) {
                return false;
            }
            n10 = 0;
            clazz = null;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        while (true) {
            n11 = ((Context)object).length;
            if (n10 >= n11) break;
            String string2 = TAG;
            CharSequence charSequence = new StringBuilder();
            String string3 = "Display support HDR Type:";
            charSequence.append(string3);
            Context context = object[n10];
            charSequence.append((int)context);
            charSequence = charSequence.toString();
            Log.d((String)string2, (String)charSequence);
            ++n10;
            continue;
            break;
        }
        return true;
    }

    public static float getDisplayHDRMaxLuminance(Context object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 < n11) {
            return 0.0f;
        }
        Class<DisplayManager> clazz = DisplayManager.class;
        try {
            object = object.getSystemService(clazz);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return 0.0f;
        }
        object = (DisplayManager)object;
        n10 = 0;
        clazz = null;
        object = object.getDisplay(0);
        object = object.getHdrCapabilities();
        return object.getDesiredMaxLuminance();
    }

    public static float getDisplayHDRMinLuminance(Context object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 < n11) {
            return 0.0f;
        }
        Class<DisplayManager> clazz = DisplayManager.class;
        try {
            object = object.getSystemService(clazz);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return 0.0f;
        }
        object = (DisplayManager)object;
        n10 = 0;
        clazz = null;
        object = object.getDisplay(0);
        object = object.getHdrCapabilities();
        return object.getDesiredMinLuminance();
    }

    public static double getMaxFPSOfVideoResolution(String object, boolean n10, int n11, int n12) {
        double d10;
        block14: {
            block13: {
                MediaCodec mediaCodec;
                d10 = 0.0;
                if (n10 != 0) {
                    mediaCodec = MediaCodec.createEncoderByType((String)object);
                } else {
                    mediaCodec = MediaCodec.createDecoderByType((String)object);
                }
                int n13 = Build.VERSION.SDK_INT;
                int n14 = 18;
                if (n13 < n14) break block13;
                mediaCodec = mediaCodec.getCodecInfo();
                object = mediaCodec.getCapabilitiesForType((String)object);
                n10 = 21;
                if (n13 < n10) break block14;
                object = object.getVideoCapabilities();
                object = object.getSupportedFrameRatesFor(n11, n12);
                object = object.getUpper();
                object = (Double)object;
                try {
                    return (Double)object;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            return d10;
        }
        return d10;
    }

    public static String getMimeTypeFromContentUrl(Context context, String string2) {
        try {
            context = context.getContentResolver();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        string2 = Uri.parse((String)string2);
        return context.getType((Uri)string2);
    }

    public static long getSystemMemorySizeInBytes(Context context) {
        context = (ActivityManager)context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        context.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static int openFdForContentUrl(Context context, String string2, String string3) {
        try {
            context = context.getContentResolver();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return -1;
        }
        string2 = Uri.parse((String)string2);
        context = context.openFileDescriptor((Uri)string2, string3);
        return context.detachFd();
    }

    public static void setThreadPriority() {
        Process.setThreadPriority((int)-2);
    }
}

