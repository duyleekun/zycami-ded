/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.media.MediaExtractor
 *  android.net.Uri
 */
package com.cdv.io;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.MediaExtractor;
import android.net.Uri;
import com.cdv.io.NvAndroidMediaFileInfo$MediaInfo;
import java.io.FileDescriptor;

public class NvAndroidMediaFileInfo {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static NvAndroidMediaFileInfo$MediaInfo getMediaInfoFromFile(String var0, Context var1_6, AssetManager var2_7) {
        block66: {
            block67: {
                block65: {
                    block61: {
                        block64: {
                            block63: {
                                block62: {
                                    block56: {
                                        block57: {
                                            block58: {
                                                var3_8 = "color-transfer";
                                                var4_9 = "frame-rate";
                                                var5_10 = "rotation-degrees";
                                                var6_11 = null;
                                                var7_12 = new MediaExtractor();
                                                if (var2_7 /* !! */  != null) break block56;
                                                var2_7 /* !! */  = "content://";
                                                var8_13 = var0.startsWith((String)var2_7 /* !! */ );
                                                if (var8_13 == 0) break block57;
                                                if (var1_6 /* !! */  != null) break block58;
                                                var7_12.release();
                                                return null;
                                            }
                                            var1_6 /* !! */  = var1_6 /* !! */ .getContentResolver();
                                            var0 = Uri.parse((String)var0);
                                            var2_7 /* !! */  = "r";
                                            var0 = var1_6 /* !! */ .openFileDescriptor((Uri)var0, (String)var2_7 /* !! */ );
                                            var1_6 /* !! */  = var0.getFileDescriptor();
                                            var7_12.setDataSource((FileDescriptor)var1_6 /* !! */ );
                                            var0.close();
                                            ** GOTO lbl45
                                        }
                                        var7_12.setDataSource((String)var0);
                                        ** GOTO lbl45
                                    }
                                    var0 = var2_7 /* !! */ .openFd((String)var0);
                                    var9_14 = var0.getFileDescriptor();
                                    var10_15 = var0.getStartOffset();
                                    var12_16 = var0.getLength();
                                    var7_12.setDataSource((FileDescriptor)var9_14, var10_15, var12_16);
                                    var0.close();
lbl45:
                                    // 3 sources

                                    var14_17 = var7_12.getTrackCount();
                                    var15_18 = 0;
                                    var1_6 /* !! */  = null;
                                    var16_19 = var8_13 = -1;
                                    while (true) {
                                        block60: {
                                            block59: {
                                                var9_14 = "mime";
                                                if (var15_18 >= var14_17) break;
                                                var17_20 /* !! */  = var7_12.getTrackFormat(var15_18);
                                                var9_14 = var17_20 /* !! */ .getString((String)var9_14);
                                                if (var8_13 >= 0) break block59;
                                                var17_20 /* !! */  = "video/";
                                                var18_21 = var9_14.startsWith((String)var17_20 /* !! */ );
                                                if (!var18_21) break block59;
                                                var8_13 = var15_18;
                                                break block60;
                                            }
                                            if (var16_19 < 0) {
                                                var17_20 /* !! */  = "audio/";
                                                var19_22 = var9_14.startsWith((String)var17_20 /* !! */ );
                                                if (var19_22 == 0) break block60;
                                                var16_19 = var15_18;
                                            }
                                        }
                                        ++var15_18;
                                    }
                                    var0 = new NvAndroidMediaFileInfo$MediaInfo();
                                    var1_6 /* !! */  = "durationUs";
                                    var18_21 = true;
                                    if (var8_13 < 0) break block61;
                                    var2_7 /* !! */  = var7_12.getTrackFormat(var8_13);
                                    var9_14 = var2_7 /* !! */ .getString((String)var9_14);
                                    var0.mime = var9_14;
                                    var20_23 = var2_7 /* !! */ .getLong((String)var1_6 /* !! */ );
                                    var0.videoStreamDurationUs = var20_23;
                                    var9_14 = "width";
                                    var19_22 = var2_7 /* !! */ .getInteger((String)var9_14);
                                    var0.width = var19_22;
                                    var9_14 = "height";
                                    var19_22 = var2_7 /* !! */ .getInteger((String)var9_14);
                                    var0.height = var19_22;
                                    var19_22 = (int)var2_7 /* !! */ .containsKey(var5_10);
                                    if (var19_22 == 0) break block62;
                                    var22_24 = var2_7 /* !! */ .getInteger(var5_10);
                                    var0.rotation = var22_24;
                                }
                                var22_24 = (int)var2_7 /* !! */ .containsKey(var4_9);
                                if (var22_24 == 0) break block63;
                                var23_25 = var2_7 /* !! */ .getInteger(var4_9);
                                var0.frameRate = var23_25;
                            }
                            var23_25 = (int)var2_7 /* !! */ .containsKey(var3_8);
                            if (var23_25 == 0) break block64;
                            var8_13 = var2_7 /* !! */ .getInteger(var3_8);
                            var0.colorTransfer = var8_13;
                        }
                        try {
                            var0.hasVideoStream = var18_21;
                        }
                        catch (Exception var0_1) {
                            break block65;
                        }
                    }
                    if (var16_19 >= 0) {
                        var2_7 /* !! */  = var7_12.getTrackFormat(var16_19);
                        var24_26 = var2_7 /* !! */ .getLong((String)var1_6 /* !! */ );
                        var0.audioStreamDurationUs = var24_26;
                        var1_6 /* !! */  = "channel-count";
                        var15_18 = var2_7 /* !! */ .getInteger((String)var1_6 /* !! */ );
                        var0.channelCount = var15_18;
                        var1_6 /* !! */  = "sample-rate";
                        var15_18 = var2_7 /* !! */ .getInteger((String)var1_6 /* !! */ );
                        var0.sampleRate = var15_18;
                        var0.hasAudioStream = var18_21;
                    }
                    var7_12.release();
                    return var0;
                    catch (Throwable var0_2) {
                        break block66;
                    }
                    catch (Exception var0_3) {
                        var7_12 = null;
                    }
                }
                try {
                    var0.printStackTrace();
                    if (var7_12 == null) break block67;
                }
                catch (Throwable var0_4) {
                    var6_11 = var7_12;
                }
                var7_12.release();
            }
            return null;
        }
        if (var6_11 != null) {
            var6_11.release();
        }
        throw var0_5;
    }
}

