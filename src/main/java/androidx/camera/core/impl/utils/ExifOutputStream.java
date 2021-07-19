/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.impl.utils.ByteOrderedDataOutputStream;
import androidx.camera.core.impl.utils.ExifAttribute;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifData$Builder;
import androidx.camera.core.impl.utils.ExifOutputStream$JpegHeader;
import androidx.camera.core.impl.utils.ExifTag;
import androidx.core.util.Preconditions;
import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class ExifOutputStream
extends FilterOutputStream {
    private static final short BYTE_ALIGN_II = 18761;
    private static final short BYTE_ALIGN_MM = 19789;
    private static final boolean DEBUG = false;
    private static final byte[] IDENTIFIER_EXIF_APP1;
    private static final int IFD_OFFSET = 8;
    private static final byte START_CODE = 42;
    private static final int STATE_FRAME_HEADER = 1;
    private static final int STATE_JPEG_DATA = 2;
    private static final int STATE_SOI = 0;
    private static final int STREAMBUFFER_SIZE = 65536;
    private static final String TAG = "ExifOutputStream";
    private final ByteBuffer mBuffer;
    private int mByteToCopy;
    private int mByteToSkip;
    private final ExifData mExifData;
    private final byte[] mSingleByteArray;
    private int mState;

    static {
        Charset charset = ExifAttribute.ASCII;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(charset);
    }

    public ExifOutputStream(OutputStream object, ExifData exifData) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream((OutputStream)object, 65536);
        super(bufferedOutputStream);
        object = new byte[1];
        this.mSingleByteArray = (byte[])object;
        this.mBuffer = object = ByteBuffer.allocate(4);
        this.mState = 0;
        this.mExifData = exifData;
    }

    private int requestByteToBuffer(int n10, byte[] byArray, int n11, int n12) {
        int n13 = this.mBuffer.position();
        n10 -= n13;
        n10 = Math.min(n12, n10);
        this.mBuffer.put(byArray, n11, n10);
        return n10;
    }

    private void writeExifSegment(ByteOrderedDataOutputStream byteOrderedDataOutputStream) {
        Object object;
        long l10;
        long l11;
        Object object2;
        int n10;
        CharSequence charSequence;
        int n11;
        int n12;
        Object object3;
        Object object4;
        Object object5;
        int n13;
        int n14;
        String string2;
        Object object6 = ExifData.EXIF_TAGS;
        int n15 = ((ExifTag[][])object6).length;
        int[] nArray = new int[n15];
        int n16 = ((ExifTag[][])object6).length;
        object6 = new int[n16];
        for (ExifTag exifTag : ExifData.EXIF_POINTER_TAGS) {
            string2 = null;
            for (n14 = 0; n14 < (n13 = ((ExifTag[][])(object5 = ExifData.EXIF_TAGS)).length); ++n14) {
                object5 = this.mExifData.getAttributes(n14);
                object4 = exifTag.name;
                object5.remove(object4);
            }
        }
        Object object7 = this.mExifData;
        int n17 = 1;
        object7 = ((ExifData)object7).getAttributes(n17);
        int n18 = object7.isEmpty();
        long l12 = 0L;
        if (n18 == 0) {
            object7 = this.mExifData.getAttributes(0);
            string2 = ExifData.EXIF_POINTER_TAGS[n17].name;
            object5 = this.mExifData.getByteOrder();
            object5 = ExifAttribute.createULong(l12, (ByteOrder)object5);
            object7.put(string2, object5);
        }
        object7 = this.mExifData;
        n14 = 2;
        n18 = (object7 = ((ExifData)object7).getAttributes(n14)).isEmpty();
        if (n18 == 0) {
            object7 = this.mExifData.getAttributes(0);
            object5 = ExifData.EXIF_POINTER_TAGS[n14].name;
            object4 = this.mExifData.getByteOrder();
            object4 = ExifAttribute.createULong(l12, (ByteOrder)object4);
            object7.put(object5, object4);
        }
        object7 = this.mExifData;
        n13 = 3;
        n18 = (object7 = ((ExifData)object7).getAttributes(n13)).isEmpty();
        if (n18 == 0) {
            object7 = this.mExifData.getAttributes(n17);
            object4 = ExifData.EXIF_POINTER_TAGS[n13].name;
            Object object8 = this.mExifData.getByteOrder();
            object8 = ExifAttribute.createULong(l12, (ByteOrder)object8);
            object7.put(object4, object8);
        }
        n18 = 0;
        object7 = null;
        while (true) {
            object4 = ExifData.EXIF_TAGS;
            object3 = ((ExifTag[][])object4).length;
            n12 = 4;
            if (n18 >= object3) break;
            object4 = this.mExifData.getAttributes(n18).entrySet().iterator();
            n11 = 0;
            charSequence = null;
            while ((n10 = (int)(object4.hasNext() ? 1 : 0)) != 0) {
                object2 = (ExifAttribute)((Map.Entry)object4.next()).getValue();
                n10 = ((ExifAttribute)object2).size();
                if (n10 <= n12) continue;
                n11 += n10;
            }
            object3 = object6[n18] + n11;
            object6[n18] = (ExifTag[])object3;
            ++n18;
        }
        n11 = n18 = 8;
        object4 = null;
        for (object3 = 0; object3 < (n10 = ((ExifTag[][])(object2 = ExifData.EXIF_TAGS)).length); ++object3) {
            object2 = this.mExifData.getAttributes((int)object3);
            n10 = object2.isEmpty() ? 1 : 0;
            if (n10 != 0) continue;
            nArray[object3] = n11;
            object2 = this.mExifData.getAttributes((int)object3);
            n10 = object2.size() * 12 + n14 + n12;
            Object object9 = object6[object3];
            n11 += (n10 += object9);
        }
        n11 += n18;
        object6 = this.mExifData.getAttributes(n17);
        n16 = object6.isEmpty() ? 1 : 0;
        if (n16 == 0) {
            object6 = this.mExifData.getAttributes(0);
            object7 = ExifData.EXIF_POINTER_TAGS[n17].name;
            object3 = nArray[n17];
            l11 = object3;
            object4 = this.mExifData.getByteOrder();
            object4 = ExifAttribute.createULong(l11, (ByteOrder)object4);
            object6.put(object7, object4);
        }
        if ((n16 = (int)((object6 = this.mExifData.getAttributes(n14)).isEmpty() ? 1 : 0)) == 0) {
            object6 = this.mExifData.getAttributes(0);
            object7 = ExifData.EXIF_POINTER_TAGS[n14].name;
            object3 = nArray[n14];
            l11 = object3;
            object4 = this.mExifData.getByteOrder();
            object4 = ExifAttribute.createULong(l11, (ByteOrder)object4);
            object6.put(object7, object4);
        }
        if ((n16 = (int)((object6 = this.mExifData.getAttributes(n13)).isEmpty() ? 1 : 0)) == 0) {
            object6 = this.mExifData.getAttributes(n17);
            object7 = ExifData.EXIF_POINTER_TAGS[n13].name;
            n17 = nArray[n13];
            l10 = n17;
            object = this.mExifData.getByteOrder();
            object = ExifAttribute.createULong(l10, (ByteOrder)object);
            object6.put(object7, object);
        }
        byteOrderedDataOutputStream.writeUnsignedShort(n11);
        object6 = IDENTIFIER_EXIF_APP1;
        byteOrderedDataOutputStream.write((byte[])object6);
        object6 = this.mExifData.getByteOrder();
        object7 = ByteOrder.BIG_ENDIAN;
        n16 = object6 == object7 ? 19789 : 18761;
        byteOrderedDataOutputStream.writeShort((short)n16);
        object6 = this.mExifData.getByteOrder();
        byteOrderedDataOutputStream.setByteOrder((ByteOrder)object6);
        byteOrderedDataOutputStream.writeUnsignedShort(42);
        long l13 = 8;
        byteOrderedDataOutputStream.writeUnsignedInt(l13);
        object6 = null;
        for (n16 = 0; n16 < (n18 = ((Object)(object7 = ExifData.EXIF_TAGS)).length); ++n16) {
            object7 = this.mExifData.getAttributes(n16);
            n18 = object7.isEmpty() ? 1 : 0;
            if (n18 != 0) continue;
            object7 = this.mExifData.getAttributes(n16);
            n18 = object7.size();
            byteOrderedDataOutputStream.writeUnsignedShort(n18);
            n18 = nArray[n16] + n14;
            n17 = this.mExifData.getAttributes(n16).size() * 12;
            n18 = n18 + n17 + n12;
            object = this.mExifData.getAttributes(n16).entrySet().iterator();
            while ((n13 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object5 = object.next();
                object4 = (HashMap)ExifData$Builder.sExifTagMapsForWriting.get(n16);
                charSequence = (CharSequence)object5.getKey();
                object4 = (ExifTag)((HashMap)object4).get(charSequence);
                charSequence = new StringBuilder();
                charSequence.append("Tag not supported: ");
                object2 = (String)object5.getKey();
                charSequence.append((String)object2);
                object2 = ". Tag needs to be ported from ExifInterface to ExifData.";
                charSequence.append((String)object2);
                charSequence = charSequence.toString();
                object4 = (ExifTag)Preconditions.checkNotNull(object4, charSequence);
                object3 = ((ExifTag)object4).number;
                object5 = (ExifAttribute)object5.getValue();
                n11 = object5.size();
                byteOrderedDataOutputStream.writeUnsignedShort((int)object3);
                object3 = object5.format;
                byteOrderedDataOutputStream.writeUnsignedShort((int)object3);
                object3 = object5.numberOfComponents;
                byteOrderedDataOutputStream.writeInt((int)object3);
                if (n11 > n12) {
                    l10 = n18;
                    byteOrderedDataOutputStream.writeUnsignedInt(l10);
                    n18 += n11;
                    continue;
                }
                object5 = object5.bytes;
                byteOrderedDataOutputStream.write((byte[])object5);
                if (n11 >= n12) continue;
                while (n11 < n12) {
                    byteOrderedDataOutputStream.writeByte(0);
                    ++n11;
                }
            }
            byteOrderedDataOutputStream.writeUnsignedInt(l12);
            object7 = this.mExifData.getAttributes(n16).entrySet().iterator();
            while ((n17 = (int)(object7.hasNext() ? 1 : 0)) != 0) {
                object = ((ExifAttribute)((Map.Entry)object7.next()).getValue()).bytes;
                n13 = ((Object)object).length;
                if (n13 <= n12) continue;
                n13 = ((Object)object).length;
                byteOrderedDataOutputStream.write((byte[])object, 0, n13);
            }
        }
        object6 = ByteOrder.BIG_ENDIAN;
        byteOrderedDataOutputStream.setByteOrder((ByteOrder)object6);
    }

    public void write(int n10) {
        byte[] byArray = this.mSingleByteArray;
        byArray[0] = n10 = (int)((byte)(n10 & 0xFF));
        this.write(byArray);
    }

    public void write(byte[] byArray) {
        int n10 = byArray.length;
        this.write(byArray, 0, n10);
    }

    public void write(byte[] object, int n10, int n11) {
        Object object2;
        block13: {
            while (true) {
                byte[] byArray;
                int n12;
                Object object3;
                OutputStream outputStream;
                int n13;
                int n14 = this.mByteToSkip;
                int n15 = 2;
                if (n14 <= 0 && (n13 = this.mByteToCopy) <= 0 && (n13 = this.mState) == n15 || n11 <= 0) break block13;
                if (n14 > 0) {
                    n14 = Math.min(n11, n14);
                    n11 -= n14;
                    this.mByteToSkip = n13 = this.mByteToSkip - n14;
                    n10 += n14;
                }
                if ((n14 = this.mByteToCopy) > 0) {
                    n14 = Math.min(n11, n14);
                    outputStream = this.out;
                    outputStream.write((byte[])object, n10, n14);
                    n11 -= n14;
                    this.mByteToCopy = n13 = this.mByteToCopy - n14;
                    n10 += n14;
                }
                if (n11 == 0) {
                    return;
                }
                n14 = this.mState;
                n13 = -31;
                int n16 = 1;
                if (n14 != 0) {
                    if (n14 != n16) continue;
                    n14 = 4;
                    n16 = this.requestByteToBuffer(n14, (byte[])object, n10, n11);
                    n10 += n16;
                    n11 -= n16;
                    object3 = this.mBuffer;
                    n16 = ((Buffer)object3).position();
                    if (n16 == n15 && (n16 = (int)((ByteBuffer)(object3 = this.mBuffer)).getShort()) == (n12 = -39)) {
                        object3 = this.out;
                        byArray = this.mBuffer.array();
                        ((OutputStream)object3).write(byArray, 0, n15);
                        object3 = this.mBuffer;
                        ((ByteBuffer)object3).rewind();
                    }
                    if ((n16 = ((Buffer)(object3 = this.mBuffer)).position()) < n14) {
                        return;
                    }
                    this.mBuffer.rewind();
                    object3 = this.mBuffer;
                    n16 = ((ByteBuffer)object3).getShort();
                    n12 = (char)-1;
                    if (n16 == n13) {
                        object2 = this.mBuffer;
                        this.mByteToSkip = n14 = (((ByteBuffer)object2).getShort() & n12) - n15;
                        this.mState = n15;
                    } else {
                        n13 = ExifOutputStream$JpegHeader.isSofMarker((short)n16) ? 1 : 0;
                        if (n13 == 0) {
                            outputStream = this.out;
                            object3 = this.mBuffer.array();
                            outputStream.write((byte[])object3, 0, n14);
                            object2 = this.mBuffer;
                            this.mByteToCopy = n14 = (((ByteBuffer)object2).getShort() & n12) - n15;
                        } else {
                            outputStream = this.out;
                            object3 = this.mBuffer.array();
                            outputStream.write((byte[])object3, 0, n14);
                            this.mState = n15;
                        }
                    }
                    object2 = this.mBuffer;
                    ((ByteBuffer)object2).rewind();
                    continue;
                }
                n14 = this.requestByteToBuffer(n15, (byte[])object, n10, n11);
                n10 += n14;
                n11 -= n14;
                object2 = this.mBuffer;
                n14 = ((Buffer)object2).position();
                if (n14 < n15) {
                    return;
                }
                this.mBuffer.rewind();
                object2 = this.mBuffer;
                n14 = ((ByteBuffer)object2).getShort();
                n12 = -40;
                if (n14 != n12) break;
                object2 = this.out;
                byArray = this.mBuffer.array();
                ((OutputStream)object2).write(byArray, 0, n15);
                this.mState = n16;
                this.mBuffer.rewind();
                OutputStream outputStream2 = this.out;
                object3 = ByteOrder.BIG_ENDIAN;
                object2 = new ByteOrderedDataOutputStream(outputStream2, (ByteOrder)object3);
                ((ByteOrderedDataOutputStream)object2).writeShort((short)n13);
                this.writeExifSegment((ByteOrderedDataOutputStream)object2);
            }
            object = new IOException;
            object("Not a valid jpeg image, cannot write exif");
            throw object;
        }
        if (n11 > 0) {
            object2 = this.out;
            ((OutputStream)object2).write((byte[])object, n10, n11);
        }
    }
}

