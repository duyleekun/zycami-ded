/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 *  android.media.AudioRecord
 *  android.media.Image
 *  android.media.Image$Plane
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaCodecInfo$CodecCapabilities
 *  android.media.MediaCodecList
 *  android.media.MediaExtractor
 *  android.media.MediaFormat
 *  android.util.Log
 */
package d.u.a;

import android.content.res.AssetFileDescriptor;
import android.media.AudioRecord;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;
import d.u.a.b$a;
import java.io.FileDescriptor;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class b {
    private static final String k = "VideoDecoder";
    public static final int l = 2135033992;
    public static final int m = 2134288520;
    public MediaExtractor a = null;
    public MediaCodec b = null;
    public MediaFormat c = null;
    public int d;
    public int e;
    public int f;
    public b$a g;
    public MediaExtractor h;
    public int i;
    public MediaFormat j;

    public b(AssetFileDescriptor assetFileDescriptor) {
        int n10;
        int n11;
        this.d = n11 = -1;
        this.e = n10 = 2135033992;
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = n11;
        this.j = null;
        this.j(n10, null, assetFileDescriptor);
    }

    public b(AssetFileDescriptor assetFileDescriptor, int n10) {
        int n11;
        this.d = n11 = -1;
        this.e = 2135033992;
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = n11;
        this.j = null;
        this.j(n10, null, assetFileDescriptor);
    }

    public b(String string2) {
        int n10;
        int n11;
        this.d = n11 = -1;
        this.e = n10 = 2135033992;
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = n11;
        this.j = null;
        this.j(n10, string2, null);
    }

    public b(String string2, int n10) {
        int n11;
        this.d = n11 = -1;
        this.e = 2135033992;
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = n11;
        this.j = null;
        this.j(n10, string2, null);
    }

    public static int c(MediaExtractor mediaExtractor) {
        if (mediaExtractor != null) {
            int n10 = mediaExtractor.getTrackCount();
            for (int i10 = 0; i10 < n10; ++i10) {
                String string2;
                String string3 = mediaExtractor.getTrackFormat(i10).getString("mime");
                boolean bl2 = string3.startsWith(string2 = "audio/");
                if (!bl2) continue;
                return i10;
            }
        }
        return -1;
    }

    private ByteBuffer d(Image image) {
        Object object;
        int n10 = image.getFormat();
        int n11 = 2;
        int n12 = 1;
        int n13 = 0;
        int n14 = 35;
        if (n14 != n10 && (n14 = 842094169) != n10) {
            n14 = 17;
            if (n14 == n10) {
                int n15;
                int n16;
                Object var17_24;
                object = image.getPlanes();
                n14 = ((Image.Plane[])object).length;
                ByteBuffer byteBuffer = object[0].getBuffer();
                ByteBuffer byteBuffer2 = object[n12].getBuffer();
                Image.Plane plane = object[0];
                int n17 = plane.getRowStride();
                int n18 = image.getHeight();
                Image.Plane plane2 = object[n12];
                int n19 = plane2.getRowStride();
                object = object[n12];
                object.getPixelStride();
                n10 = image.getWidth();
                byteBuffer.rewind();
                byteBuffer2.rewind();
                n12 = n10 * n18;
                int n20 = n12 * 3 / n11;
                byte[] byArray = new byte[n20];
                if (n10 == n17) {
                    byteBuffer.get(byArray, 0, n12);
                } else {
                    var17_24 = null;
                    for (n20 = 0; n20 < n18; ++n20) {
                        for (n16 = 0; n16 < n10; ++n16) {
                            n15 = n20 * n10 + n16;
                            int n21 = n20 * n17 + n16;
                            byArray[n15] = n21 = (int)byteBuffer.get(n21);
                        }
                    }
                }
                if (n19 == n10) {
                    n10 = n12 / 2;
                    byteBuffer2.get(byArray, n12, n10);
                } else {
                    byteBuffer = null;
                    for (n14 = 0; n14 < n18; ++n14) {
                        var17_24 = null;
                        for (n20 = 0; n20 < n17; ++n20) {
                            n16 = n14 / 2;
                            n15 = n16 * n19 + n20;
                            n16 = n16 * n10 + n20 + n12;
                            byArray[n16] = n15 = (int)byteBuffer2.get(n15);
                        }
                    }
                }
                object = ByteBuffer.wrap(byArray);
            } else {
                n14 = 256;
                if (n14 == n10) {
                    object = image.getPlanes()[0].getBuffer();
                } else if (n12 != n10 && n11 != n10) {
                    n10 = 0;
                    object = null;
                } else {
                    object = image.getPlanes();
                    image.getWidth();
                    image.getHeight();
                    object = object[0].getBuffer();
                }
            }
        } else {
            int n22;
            int n23;
            object = image.getPlanes();
            n14 = ((Image.Plane[])object).length;
            ByteBuffer byteBuffer = object[0].getBuffer();
            ByteBuffer byteBuffer3 = object[n12].getBuffer();
            ByteBuffer byteBuffer4 = object[n11].getBuffer();
            Image.Plane plane = object[0];
            int n24 = plane.getRowStride();
            int n25 = image.getHeight();
            Image.Plane plane3 = object[n12];
            int n26 = plane3.getRowStride();
            object = object[n12];
            n10 = object.getPixelStride();
            n12 = image.getWidth();
            byteBuffer.rewind();
            byteBuffer3.rewind();
            byteBuffer4.rewind();
            int n27 = n12 * n25;
            byte[] byArray = new byte[n27 * 3 / n11];
            int n28 = n27 / 4;
            int n29 = n27 + n28;
            int n30 = n12 / 2;
            if (n12 == n24) {
                byteBuffer.get(byArray, 0, n27);
            } else {
                for (n23 = 0; n23 < n25; ++n23) {
                    for (n22 = 0; n22 < n12; ++n22) {
                        int n31 = n23 * n12 + n22;
                        int n32 = n23 * n24;
                        n13 = n32 + n22;
                        byArray[n31] = n13 = (int)byteBuffer.get(n13);
                        n13 = 0;
                    }
                    n13 = 0;
                }
            }
            if (n26 == n30) {
                byteBuffer3.get(byArray, n27, n28);
                byteBuffer4.get(byArray, n29, n28);
            } else {
                for (n12 = 0; n12 < n25; ++n12) {
                    for (n13 = 0; n13 < n24; ++n13) {
                        n14 = n13 / n10 * n10;
                        n28 = n12 / 2;
                        n23 = n28 * n26 + n14;
                        n28 = n28 * n30 + n14;
                        n14 = n27 + n28;
                        byArray[n14] = n22 = (int)byteBuffer3.get(n23);
                        byArray[n28 += n29] = n14 = (int)byteBuffer4.get(n23);
                    }
                }
            }
            object = ByteBuffer.wrap(byArray);
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     */
    private byte[] e(Image image) {
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        byte[] byArray;
        int n15;
        int n16;
        int n17;
        int n18;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        byte[] byArray2;
        int n19;
        int n20;
        int n21;
        int n22;
        int n23;
        block18: {
            ByteBuffer byteBuffer3;
            block17: {
                int n24;
                int n25;
                Object var17_28;
                int n26;
                int n27;
                int n28;
                int n29;
                ByteBuffer byteBuffer4;
                ByteBuffer byteBuffer5;
                block15: {
                    block16: {
                        block12: {
                            block13: {
                                block14: {
                                    n23 = image.getFormat();
                                    n22 = 2;
                                    n21 = 1;
                                    n20 = 0;
                                    n19 = 35;
                                    if (n19 == n23 || (n19 = 842094169) == n23) break block12;
                                    n19 = 17;
                                    if (n19 != n23) break block13;
                                    Image.Plane plane = image.getPlanes();
                                    n19 = ((Image.Plane[])plane).length;
                                    byteBuffer5 = plane[0].getBuffer();
                                    byteBuffer4 = plane[n21].getBuffer();
                                    Image.Plane plane2 = plane[0];
                                    n29 = plane2.getRowStride();
                                    n28 = image.getHeight();
                                    Image.Plane plane3 = plane[n21];
                                    n27 = plane3.getRowStride();
                                    plane = plane[n21];
                                    plane.getPixelStride();
                                    n23 = image.getWidth();
                                    byteBuffer5.rewind();
                                    byteBuffer4.rewind();
                                    n21 = n23 * n28;
                                    n26 = n21 * 3 / n22;
                                    byArray2 = new byte[n26];
                                    if (n23 != n29) break block14;
                                    byteBuffer5.get(byArray2, 0, n21);
                                    break block15;
                                }
                                var17_28 = null;
                                break block16;
                            }
                            n19 = 256;
                            if (n19 == n23) {
                                ByteBuffer byteBuffer6 = image.getPlanes()[0].getBuffer();
                                byte[] byArray3 = new byte[byteBuffer6.remaining()];
                                byteBuffer6.get(byArray3);
                                return byArray3;
                            }
                            if (n21 != n23 && n22 != n23) {
                                return null;
                            }
                            Object object = image.getPlanes();
                            image.getWidth();
                            image.getHeight();
                            object = object[0].getBuffer();
                            byte[] byArray4 = new byte[((Buffer)object).remaining()];
                            ((ByteBuffer)object).get(byArray4);
                            return byArray4;
                        }
                        Image.Plane plane = image.getPlanes();
                        n19 = ((Image.Plane[])plane).length;
                        byteBuffer3 = plane[0].getBuffer();
                        byteBuffer2 = plane[n21].getBuffer();
                        byteBuffer = plane[n22].getBuffer();
                        Image.Plane plane4 = plane[0];
                        n18 = plane4.getRowStride();
                        n17 = image.getHeight();
                        Image.Plane plane5 = plane[n21];
                        n16 = plane5.getRowStride();
                        plane = plane[n21];
                        n23 = plane.getPixelStride();
                        n21 = image.getWidth();
                        byteBuffer3.rewind();
                        byteBuffer2.rewind();
                        byteBuffer.rewind();
                        n15 = n21 * n17;
                        int n30 = n15 * 3 / n22;
                        byArray = new byte[n30];
                        n14 = n15 / 4;
                        n13 = n15 + n14;
                        n12 = n21 / 2;
                        if (n21 != n18) break block17;
                        byteBuffer3.get(byArray, 0, n15);
                        break block18;
                    }
                    for (n26 = 0; n26 < n28; ++n26) {
                        for (n25 = 0; n25 < n23; ++n25) {
                            n24 = n26 * n23 + n25;
                            int n31 = n26 * n29 + n25;
                            byArray2[n24] = n31 = (int)byteBuffer5.get(n31);
                        }
                    }
                }
                if (n27 == n23) {
                    n23 = n21 / 2;
                    byteBuffer4.get(byArray2, n21, n23);
                    return byArray2;
                }
                n19 = 0;
                byteBuffer5 = null;
                while (n19 < n28) {
                    var17_28 = null;
                    for (n26 = 0; n26 < n29; ++n26) {
                        n25 = n19 / 2;
                        n24 = n25 * n27 + n26;
                        n25 = n25 * n23 + n26 + n21;
                        byArray2[n25] = n24 = (int)byteBuffer4.get(n24);
                    }
                    ++n19;
                }
                return byArray2;
            }
            for (n11 = 0; n11 < n17; ++n11) {
                while (n20 < n21) {
                    n10 = n11 * n21 + n20;
                    int n32 = n11 * n18;
                    n22 = n32 + n20;
                    byArray[n10] = n22 = (int)byteBuffer3.get(n22);
                    ++n20;
                    n22 = 2;
                }
                n22 = 2;
                n20 = 0;
            }
        }
        if (n16 != n12) {
            n22 = 0;
            byArray2 = null;
            while (n22 < n17) {
                for (n20 = 0; n20 < n21; ++n20) {
                    n19 = n20 / n23 * n23;
                    n18 = n22 / 2;
                    n14 = n18 * n16 + n19;
                    n18 *= n12;
                    n11 = 2;
                    n19 = n15 + (n18 += (n19 /= n11));
                    byArray[n19] = n10 = (int)byteBuffer2.get(n14);
                    byArray[n18 += n13] = n19 = (int)byteBuffer.get(n14);
                }
                n11 = 2;
                ++n22;
            }
            return byArray;
        }
        byteBuffer2.get(byArray, n15, n14);
        byteBuffer.get(byArray, n13, n14);
        return byArray;
    }

    public static int g(MediaExtractor mediaExtractor) {
        if (mediaExtractor != null) {
            int n10 = mediaExtractor.getTrackCount();
            for (int i10 = 0; i10 < n10; ++i10) {
                String string2;
                String string3 = mediaExtractor.getTrackFormat(i10).getString("mime");
                boolean bl2 = string3.startsWith(string2 = "video/");
                if (!bl2) continue;
                return i10;
            }
        }
        return -1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void j(int n10, String string2, AssetFileDescriptor assetFileDescriptor) {
        b b10 = this;
        int n11 = n10;
        Object object = string2;
        CharSequence charSequence = "rotation-degrees";
        String string3 = "pcm-encoding";
        String string4 = "channel-count";
        String string5 = "sample-rate";
        int n12 = 2134288520;
        int n13 = 2135033992;
        if (n10 <= 0 || n10 != n13 && n10 != n12) {
            n11 = n13;
        }
        b10.e = n11;
        try {
            MediaCodec mediaCodec;
            int n14;
            int n15;
            int n16;
            Object object2;
            FileDescriptor fileDescriptor;
            Object object3;
            Object object4;
            Object object5;
            int n17;
            int n18;
            MediaExtractor mediaExtractor;
            b10.a = mediaExtractor = new MediaExtractor();
            b10.h = mediaExtractor = new MediaExtractor();
            mediaExtractor = null;
            if (object != null && (n18 = ((String)object).charAt(0)) == (n17 = 47)) {
                object5 = b10.a;
                object5.setDataSource((String)object);
                object5 = b10.h;
                object5.setDataSource((String)object);
            } else {
                long l10;
                if (assetFileDescriptor == null) {
                    b10.a = null;
                    b10.h = null;
                    return;
                }
                if (assetFileDescriptor == null) {
                    charSequence = new StringBuilder();
                    string3 = "asset file: ";
                    ((StringBuilder)charSequence).append(string3);
                    ((StringBuilder)charSequence).append((String)object);
                    object = " not found.";
                    ((StringBuilder)charSequence).append((String)object);
                    object = ((StringBuilder)charSequence).toString();
                    NullPointerException nullPointerException = new NullPointerException((String)object);
                    throw nullPointerException;
                }
                long l11 = assetFileDescriptor.getDeclaredLength();
                long l12 = l11 - (l10 = 0L);
                n18 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                if (n18 < 0) {
                    object5 = b10.a;
                    object4 = assetFileDescriptor.getFileDescriptor();
                    object5.setDataSource((FileDescriptor)object4);
                    object5 = b10.h;
                    object4 = assetFileDescriptor.getFileDescriptor();
                    object5.setDataSource((FileDescriptor)object4);
                } else {
                    object3 = b10.a;
                    fileDescriptor = assetFileDescriptor.getFileDescriptor();
                    long l13 = assetFileDescriptor.getStartOffset();
                    long l14 = assetFileDescriptor.getDeclaredLength();
                    object3.setDataSource(fileDescriptor, l13, l14);
                    object5 = b10.h;
                    FileDescriptor fileDescriptor2 = assetFileDescriptor.getFileDescriptor();
                    long l15 = assetFileDescriptor.getStartOffset();
                    long l16 = assetFileDescriptor.getDeclaredLength();
                    object5.setDataSource(fileDescriptor2, l15, l16);
                }
            }
            object5 = b10.h;
            b10.i = n18 = d.u.a.b.c((MediaExtractor)object5);
            object4 = "mime";
            object3 = k;
            if (n18 < 0) {
                string3 = b10.h;
                string3.release();
                b10.h = null;
            } else {
                fileDescriptor = b10.h;
                fileDescriptor.selectTrack(n18);
                object5 = b10.h;
                int n19 = b10.i;
                object5 = object5.getTrackFormat(n19);
                b10.j = object5;
                n18 = (int)(object5.containsKey(string5) ? 1 : 0);
                if (n18 != 0) {
                    object5 = b10.j;
                    object2 = object5.getInteger(string5);
                } else {
                    object2 = 48000;
                }
                object5 = b10.j;
                n18 = (int)(object5.containsKey(string4) ? 1 : 0);
                n19 = 2;
                if (n18 != 0) {
                    object5 = b10.j;
                    n16 = object5.getInteger(string4);
                } else {
                    n16 = n19;
                }
                object5 = b10.j;
                n18 = (int)(object5.containsKey(string3) ? 1 : 0);
                if (n18 != 0) {
                    object5 = b10.j;
                    n15 = object5.getInteger(string3);
                } else {
                    n15 = n19;
                }
                n16 = n16 == n19 ? 12 : 16;
                n15 = AudioRecord.getMinBufferSize((int)object2, (int)n16, (int)n15);
                string4 = b10.j;
                string5 = "max-input-size";
                string4.setInteger(string5, n15);
                string3 = b10.j;
                string3 = string3.getString((String)object4);
                string4 = "audio/mp4a-latm";
                n15 = (int)(string3.equals(string4) ? 1 : 0);
                if (n15 == 0) {
                    string3 = "ERROR: Only AAC format support!";
                    Log.d((String)object3, (String)string3);
                }
            }
            string3 = b10.a;
            b10.d = n15 = d.u.a.b.g((MediaExtractor)string3);
            if (n15 < 0) {
                charSequence = new StringBuilder();
                string3 = "video: ";
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append((String)object);
                object = " has no video track.";
                ((StringBuilder)charSequence).append((String)object);
                object = ((StringBuilder)charSequence).toString();
                NullPointerException nullPointerException = new NullPointerException((String)object);
                throw nullPointerException;
            }
            object = b10.a;
            object = object.getTrackFormat(n15);
            b10.c = object;
            object = b10.a;
            n15 = b10.d;
            object.selectTrack(n15);
            object = b10.c;
            object = object.getString((String)object4);
            string3 = b10.c;
            n15 = (int)(string3.containsKey((String)charSequence) ? 1 : 0);
            if (n15 != 0) {
                string3 = b10.c;
                b10.f = n14 = string3.getInteger((String)charSequence);
            }
            charSequence = new MediaCodecList(0);
            string3 = b10.c;
            if ((charSequence = charSequence.findDecoderForFormat((MediaFormat)string3)) != null) {
                charSequence = MediaCodec.createByCodecName((String)charSequence);
                b10.b = charSequence;
            } else {
                charSequence = MediaCodec.createDecoderByType((String)object);
                b10.b = charSequence;
            }
            charSequence = b10.b;
            if (charSequence == null) {
                object = "Create Decoder Failed!";
                NullPointerException nullPointerException = new NullPointerException((String)object);
                throw nullPointerException;
            }
            charSequence = charSequence.getCodecInfo();
            charSequence = charSequence.getCapabilitiesForType((String)object);
            n14 = (int)(b10.k(n11, (MediaCodecInfo.CodecCapabilities)charSequence) ? 1 : 0);
            string3 = "color-format";
            if (n14 != 0) {
                object = b10.c;
                object.setInteger(string3, n11);
            } else {
                charSequence = new StringBuilder();
                string4 = "unable to set decode color format, color format type ";
                ((StringBuilder)charSequence).append(string4);
                ((StringBuilder)charSequence).append(n11);
                string4 = " not supported";
                ((StringBuilder)charSequence).append(string4);
                charSequence = ((StringBuilder)charSequence).toString();
                Log.i((String)object3, (String)charSequence);
                charSequence = b10.b;
                charSequence = charSequence.getCodecInfo();
                object = charSequence.getCapabilitiesForType((String)object);
                object = ((MediaCodecInfo.CodecCapabilities)object).colorFormats;
                n14 = ((Object)object).length;
                string4 = null;
                for (n16 = 0; n16 < n14; ++n16) {
                    object2 = object[n16];
                    object5 = new StringBuilder();
                    object4 = "support colorformat: ";
                    ((StringBuilder)object5).append((String)object4);
                    ((StringBuilder)object5).append((int)object2);
                    string5 = ((StringBuilder)object5).toString();
                    Log.i((String)object3, (String)string5);
                }
                if (n11 == n12) {
                    b10.e = n13;
                    mediaCodec = b10.c;
                    mediaCodec.setInteger(string3, n13);
                }
            }
            mediaCodec = b10.b;
            object = b10.c;
            mediaCodec.configure((MediaFormat)object, null, null, 0);
            mediaCodec = b10.b;
            mediaCodec.start();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            MediaCodec mediaCodec = b10.b;
            if (mediaCodec != null) {
                mediaCodec.stop();
                mediaCodec = b10.b;
                mediaCodec.release();
                b10.b = null;
            }
            if ((mediaCodec = b10.a) != null) {
                mediaCodec.release();
                b10.a = null;
            }
            if ((mediaCodec = b10.h) == null) return;
            mediaCodec.release();
            b10.h = null;
            return;
        }
    }

    private boolean k(int n10, MediaCodecInfo.CodecCapabilities object) {
        for (int n11 : ((MediaCodecInfo.CodecCapabilities)object).colorFormats) {
            if (n11 != n10) continue;
            return true;
        }
        return false;
    }

    public void a() {
        b b10 = this;
        Object object = this.b;
        if (object != null && (object = this.a) != null) {
            int n10;
            object = new MediaCodec.BufferInfo();
            Object object2 = this.h;
            int n11 = 1;
            if (object2 == null) {
                n10 = n11;
            } else {
                n10 = 0;
                object2 = null;
            }
            b10.c.getInteger("width");
            b10.c.getInteger("height");
            int n12 = 0;
            int n13 = 0;
            while (true) {
                MediaExtractor mediaExtractor;
                Object object3;
                int n14;
                int n15;
                int n16;
                Object object4;
                Object object5;
                int n17;
                if (n12 && n10) {
                    object = b10.g;
                    if (object != null) {
                        object.f();
                    }
                    return;
                }
                long l10 = 0L;
                if (!n13 && (n17 = (object5 = b10.b).dequeueInputBuffer(l10)) >= 0) {
                    int n18;
                    long l11;
                    object4 = b10.a;
                    object5 = b10.b.getInputBuffer(n17);
                    n16 = object4.readSampleData((ByteBuffer)object5, 0);
                    if (n16 < 0) {
                        object4 = b10.b;
                        n15 = 0;
                        n16 = 0;
                        l11 = 0L;
                        n18 = 4;
                        object4.queueInputBuffer(n17, 0, 0, l11, n18);
                        n13 = n11;
                    } else {
                        l11 = b10.a.getSampleTime();
                        n18 = b10.a.getSampleFlags();
                        object4 = b10.b;
                        n15 = 0;
                        object4.queueInputBuffer(n17, 0, n16, l11, n18);
                        object5 = b10.a;
                        object5.advance();
                    }
                }
                if (!n12 && (n14 = (object5 = b10.b).dequeueOutputBuffer((MediaCodec.BufferInfo)object, l10)) >= 0) {
                    int n19 = ((MediaCodec.BufferInfo)object).flags & 4;
                    if (n19) {
                        n12 = n11;
                    }
                    if (n19 = ((MediaCodec.BufferInfo)object).size) {
                        n19 = n11;
                    } else {
                        n19 = 0;
                        object3 = null;
                    }
                    if (n19) {
                        int n20;
                        int n21;
                        object3 = b10.b.getOutputImage(n14);
                        long l12 = object3.getTimestamp();
                        object5 = b10.g;
                        if (object5 != null && ((n21 = object5.a()) == 0 ? (n21 = (int)((object5 = b10.g).c((ByteBuffer)(object4 = b10.d((Image)object3)), n17 = object3.getWidth(), n15 = object3.getHeight(), n16 = b10.f, n20 = object3.getFormat(), l12) ? 1 : 0)) != 0 : (n21 = (int)((object5 = b10.g).e((byte[])(object4 = (Object)b10.e((Image)object3)), n17 = object3.getWidth(), n15 = object3.getHeight(), n16 = b10.f, n20 = object3.getFormat(), l12) ? 1 : 0)) != 0)) {
                            n12 = n11;
                        }
                        object3.close();
                        object3 = b10.b;
                        object3.releaseOutputBuffer(n14, n11 != 0);
                    }
                }
                if ((mediaExtractor = b10.h) != null && !n10) {
                    mediaExtractor = b10.j;
                    mediaExtractor = b10.h;
                    object3 = "max-input-size";
                    n14 = mediaExtractor.getInteger((String)object3);
                    object5 = ByteBuffer.allocate(n14);
                    int n22 = mediaExtractor.readSampleData((ByteBuffer)object5, 0);
                    if (n22 < 0) {
                        object2 = b10.g;
                        if (object2 != null) {
                            object2.d();
                        }
                    } else {
                        long l13 = b10.h.getSampleTime();
                        n16 = b10.h.getSampleFlags();
                        mediaExtractor = b10.h;
                        mediaExtractor.advance();
                        object3 = b10.g;
                        if (object3 == null) continue;
                        object3.b((ByteBuffer)object5, n22, l13, n16);
                        continue;
                    }
                }
                n10 = n11;
            }
        }
    }

    public MediaFormat b() {
        return this.j;
    }

    public MediaFormat f() {
        return this.c;
    }

    public boolean h() {
        MediaExtractor mediaExtractor;
        int n10 = this.i;
        if (n10 >= 0 && (mediaExtractor = this.h) != null) {
            n10 = 1;
        } else {
            n10 = 0;
            mediaExtractor = null;
        }
        return n10 != 0;
    }

    public boolean i() {
        MediaCodec mediaCodec;
        int n10 = this.d;
        if (n10 >= 0 && (mediaCodec = this.b) != null) {
            n10 = 1;
        } else {
            n10 = 0;
            mediaCodec = null;
        }
        return n10 != 0;
    }

    public boolean l() {
        MediaCodec mediaCodec = this.b;
        return mediaCodec != null && (mediaCodec = this.a) != null;
        {
        }
    }

    public void m(b$a b$a) {
        this.g = b$a;
    }
}

