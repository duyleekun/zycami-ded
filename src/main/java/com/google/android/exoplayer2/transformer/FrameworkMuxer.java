/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 *  android.media.MediaMuxer
 */
package com.google.android.exoplayer2.transformer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaFormatUtil;
import com.google.android.exoplayer2.transformer.FrameworkMuxer$1;
import com.google.android.exoplayer2.transformer.Muxer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.List;

public final class FrameworkMuxer
implements Muxer {
    private final MediaCodec.BufferInfo bufferInfo;
    private boolean isStarted;
    private final MediaMuxer mediaMuxer;
    private final String outputMimeType;

    private FrameworkMuxer(MediaMuxer mediaMuxer, String string2) {
        this.mediaMuxer = mediaMuxer;
        this.outputMimeType = string2;
        this.bufferInfo = mediaMuxer;
    }

    public /* synthetic */ FrameworkMuxer(MediaMuxer mediaMuxer, String string2, FrameworkMuxer$1 frameworkMuxer$1) {
        this(mediaMuxer, string2);
    }

    public static /* synthetic */ int access$000(String string2) {
        return FrameworkMuxer.mimeTypeToMuxerOutputFormat(string2);
    }

    private static int mimeTypeToMuxerOutputFormat(String string2) {
        Object object = "video/mp4";
        int n10 = string2.equals(object);
        if (n10 != 0) {
            return 0;
        }
        n10 = Util.SDK_INT;
        int n11 = 21;
        if (n10 >= n11 && (n10 = (int)(string2.equals(object = "video/webm") ? 1 : 0)) != 0) {
            return 1;
        }
        String string3 = "Unsupported output MIME type: ";
        int n12 = (string2 = String.valueOf(string2)).length();
        string2 = n12 != 0 ? string3.concat(string2) : new String(string3);
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public int addTrack(Format object) {
        String string2 = (String)Assertions.checkNotNull(((Format)object).sampleMimeType);
        int n10 = MimeTypes.isAudio(string2);
        if (n10 != 0) {
            string2 = (String)Util.castNonNull(string2);
            n10 = ((Format)object).sampleRate;
            int n11 = ((Format)object).channelCount;
            string2 = MediaFormat.createAudioFormat((String)string2, (int)n10, (int)n11);
        } else {
            string2 = (String)Util.castNonNull(string2);
            n10 = ((Format)object).width;
            int n12 = ((Format)object).height;
            string2 = MediaFormat.createVideoFormat((String)string2, (int)n10, (int)n12);
            MediaMuxer mediaMuxer = this.mediaMuxer;
            n12 = ((Format)object).rotationDegrees;
            mediaMuxer.setOrientationHint(n12);
        }
        object = ((Format)object).initializationData;
        MediaFormatUtil.setCsdBuffers((MediaFormat)string2, (List)object);
        return this.mediaMuxer.addTrack((MediaFormat)string2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release(boolean var1_1) {
        var2_2 = this.isStarted;
        if (!var2_2) {
            this.mediaMuxer.release();
            return;
        }
        var2_2 = false;
        var3_3 = null;
        this.isStarted = false;
        var3_3 = this.mediaMuxer;
        var3_3.stop();
lbl11:
        // 2 sources

        while (true) {
            var4_5 = this.mediaMuxer;
            ** GOTO lbl42
            break;
        }
        {
            catch (Throwable var4_6) {
            }
            catch (IllegalStateException var3_4) {}
            {
                var5_7 = Util.SDK_INT;
                var6_8 = 30;
                if (var5_7 < var6_8) {
                    var7_9 = MediaMuxer.class;
                    var8_10 = "MUXER_STATE_STOPPED";
                    var7_9 = var7_9.getDeclaredField(var8_10);
                    var6_8 = 1;
                    var7_9.setAccessible((boolean)var6_8);
                    var9_11 = this.mediaMuxer;
                    var7_9 = var7_9.get(var9_11);
                    var7_9 = (Integer)var7_9;
                    var7_9 = Util.castNonNull(var7_9);
                    var7_9 = (Integer)var7_9;
                    var5_7 = var7_9.intValue();
                    var9_11 = MediaMuxer.class;
                    var10_12 = "mState";
                    var9_11 = var9_11.getDeclaredField(var10_12);
                    var9_11.setAccessible((boolean)var6_8);
                    var8_10 = this.mediaMuxer;
                    var7_9 = var5_7;
                    var9_11.set(var8_10, var7_9);
                }
lbl39:
                // 4 sources

                while (true) {
                    if (var1_1 == false) throw var3_4;
                    ** continue;
                    break;
                }
lbl42:
                // 1 sources

                var4_5.release();
                return;
                catch (Exception v0) {
                    ** continue;
                }
            }
        }
        this.mediaMuxer.release();
        throw var4_6;
    }

    public boolean supportsSampleMimeType(String string2) {
        int n10 = MimeTypes.isAudio(string2);
        boolean bl2 = MimeTypes.isVideo(string2);
        String string3 = this.outputMimeType;
        String string4 = "video/mp4";
        int n11 = string3.equals(string4);
        int n12 = 24;
        boolean bl3 = true;
        if (n11 != 0) {
            if (bl2) {
                boolean bl4;
                String string5 = "video/3gpp";
                n10 = string5.equals(string2);
                if (!(n10 != 0 || (n10 = (string5 = "video/avc").equals(string2)) != 0 || (n10 = (string5 = "video/mp4v-es").equals(string2)) != 0 || (n10 = Util.SDK_INT) >= n12 && (bl4 = (string5 = "video/hevc").equals(string2)))) {
                    bl3 = false;
                }
                return bl3;
            }
            if (n10 != 0) {
                boolean bl5;
                String string6 = "audio/mp4a-latm";
                n10 = string6.equals(string2);
                if (n10 == 0 && (n10 = (string6 = "audio/3gpp").equals(string2)) == 0 && !(bl5 = (string6 = "audio/amr-wb").equals(string2))) {
                    bl3 = false;
                }
                return bl3;
            }
        } else {
            int n13;
            string3 = this.outputMimeType;
            String string7 = "video/webm";
            n11 = string3.equals(string7);
            if (n11 != 0 && (n11 = Util.SDK_INT) >= (n13 = 21)) {
                if (bl2) {
                    boolean bl6;
                    String string8 = "video/x-vnd.on2.vp8";
                    n10 = string8.equals(string2);
                    if (!(n10 != 0 || n11 >= n12 && (bl6 = (string8 = "video/x-vnd.on2.vp9").equals(string2)))) {
                        bl3 = false;
                    }
                    return bl3;
                }
                if (n10 != 0) {
                    return "audio/vorbis".equals(string2);
                }
            }
        }
        return false;
    }

    public void writeSampleData(int n10, ByteBuffer byteBuffer, boolean bl2, long l10) {
        boolean bl3 = this.isStarted;
        if (!bl3) {
            this.isStarted = bl3 = true;
            MediaMuxer mediaMuxer = this.mediaMuxer;
            mediaMuxer.start();
        }
        int n11 = byteBuffer.position();
        int n12 = byteBuffer.limit() - n11;
        this.bufferInfo.set(n11, n12, l10, (int)(bl2 ? 1 : 0));
        MediaMuxer mediaMuxer = this.mediaMuxer;
        MediaCodec.BufferInfo bufferInfo = this.bufferInfo;
        mediaMuxer.writeSampleData(n10, byteBuffer, bufferInfo);
    }
}

