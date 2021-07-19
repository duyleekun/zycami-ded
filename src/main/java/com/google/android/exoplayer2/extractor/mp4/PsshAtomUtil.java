/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil$PsshAtom;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class PsshAtomUtil {
    private static final String TAG = "PsshAtomUtil";

    private PsshAtomUtil() {
    }

    public static byte[] buildPsshAtom(UUID uUID, byte[] byArray) {
        return PsshAtomUtil.buildPsshAtom(uUID, null, byArray);
    }

    public static byte[] buildPsshAtom(UUID uUID, UUID[] uUIDArray, byte[] byArray) {
        int n10;
        UUID uUID2;
        int n11;
        int n12 = 0;
        if (byArray != null) {
            n11 = byArray.length;
        } else {
            n11 = 0;
            uUID2 = null;
        }
        n11 += 32;
        if (uUIDArray != null) {
            int n13 = uUIDArray.length * 16 + 4;
            n11 += n13;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate(n11);
        byteBuffer.putInt(n11);
        n11 = 1886614376;
        byteBuffer.putInt(n11);
        if (uUIDArray != null) {
            n11 = 0x1000000;
        } else {
            n11 = 0;
            uUID2 = null;
        }
        byteBuffer.putInt(n11);
        long l10 = uUID.getMostSignificantBits();
        byteBuffer.putLong(l10);
        l10 = uUID.getLeastSignificantBits();
        byteBuffer.putLong(l10);
        if (uUIDArray != null) {
            n10 = uUIDArray.length;
            byteBuffer.putInt(n10);
            n10 = uUIDArray.length;
            while (n12 < n10) {
                uUID2 = uUIDArray[n12];
                l10 = uUID2.getMostSignificantBits();
                byteBuffer.putLong(l10);
                l10 = uUID2.getLeastSignificantBits();
                byteBuffer.putLong(l10);
                ++n12;
            }
        }
        if (byArray != null && (n10 = byArray.length) != 0) {
            n10 = byArray.length;
            byteBuffer.putInt(n10);
            byteBuffer.put(byArray);
        }
        return byteBuffer.array();
    }

    public static boolean isPsshAtom(byte[] object) {
        boolean bl2;
        if ((object = (Object)PsshAtomUtil.parsePsshAtom(object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private static PsshAtomUtil$PsshAtom parsePsshAtom(byte[] object) {
        int n10;
        Object object2 = new ParsableByteArray((byte[])object);
        int n11 = ((ParsableByteArray)object2).limit();
        byte[] byArray = null;
        int n12 = 32;
        if (n11 < n12) {
            return null;
        }
        n11 = 0;
        object = null;
        ((ParsableByteArray)object2).setPosition(0);
        n12 = ((ParsableByteArray)object2).readInt();
        int n13 = ((ParsableByteArray)object2).bytesLeft() + 4;
        if (n12 != n13) {
            return null;
        }
        n12 = ((ParsableByteArray)object2).readInt();
        if (n12 != (n13 = 1886614376)) {
            return null;
        }
        n12 = Atom.parseFullAtomVersion(((ParsableByteArray)object2).readInt());
        if (n12 > (n13 = 1)) {
            object2 = new StringBuilder(37);
            ((StringBuilder)object2).append("Unsupported pssh version: ");
            ((StringBuilder)object2).append(n12);
            object = ((StringBuilder)object2).toString();
            Log.w(TAG, (String)object);
            return null;
        }
        long l10 = ((ParsableByteArray)object2).readLong();
        long l11 = ((ParsableByteArray)object2).readLong();
        UUID uUID = new UUID(l10, l11);
        if (n12 == n13) {
            n13 = ((ParsableByteArray)object2).readUnsignedIntToInt() * 16;
            ((ParsableByteArray)object2).skipBytes(n13);
        }
        if ((n13 = ((ParsableByteArray)object2).readUnsignedIntToInt()) != (n10 = ((ParsableByteArray)object2).bytesLeft())) {
            return null;
        }
        byArray = new byte[n13];
        ((ParsableByteArray)object2).readBytes(byArray, 0, n13);
        object = new PsshAtomUtil$PsshAtom;
        object(uUID, n12, byArray);
        return object;
    }

    public static byte[] parseSchemeSpecificData(byte[] object, UUID object2) {
        if ((object = PsshAtomUtil.parsePsshAtom((byte[])object)) == null) {
            return null;
        }
        UUID uUID = PsshAtomUtil$PsshAtom.access$000((PsshAtomUtil$PsshAtom)object);
        boolean n10 = ((UUID)object2).equals(uUID);
        if (!n10) {
            object2 = String.valueOf(object2);
            object = String.valueOf(PsshAtomUtil$PsshAtom.access$000((PsshAtomUtil$PsshAtom)object));
            int n11 = String.valueOf(object2).length() + 33;
            int n12 = String.valueOf(object).length();
            int n13 = n11 + n12;
            StringBuilder stringBuilder = new StringBuilder(n13);
            stringBuilder.append("UUID mismatch. Expected: ");
            stringBuilder.append((String)object2);
            stringBuilder.append(", got: ");
            stringBuilder.append((String)object);
            stringBuilder.append(".");
            object = stringBuilder.toString();
            Log.w(TAG, (String)object);
            return null;
        }
        return PsshAtomUtil$PsshAtom.access$200((PsshAtomUtil$PsshAtom)object);
    }

    public static UUID parseUuid(byte[] object) {
        if ((object = (Object)PsshAtomUtil.parsePsshAtom(object)) == null) {
            return null;
        }
        return PsshAtomUtil$PsshAtom.access$000((PsshAtomUtil$PsshAtom)object);
    }

    public static int parseVersion(byte[] object) {
        if ((object = (Object)PsshAtomUtil.parsePsshAtom(object)) == null) {
            return -1;
        }
        return PsshAtomUtil$PsshAtom.access$100((PsshAtomUtil$PsshAtom)object);
    }
}

