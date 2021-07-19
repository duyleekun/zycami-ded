/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioRecord
 */
package d.v.v.q;

import android.media.AudioRecord;
import d.v.v.q.e$a;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class e {
    private int a;
    private int b;
    private int c;

    public e(int n10, int n11, int n12) {
        this.b = n10;
        this.c = n11;
        this.a = n10 = AudioRecord.getMinBufferSize((int)n10, (int)n11, (int)n12);
    }

    private void b(FileOutputStream fileOutputStream, long l10, long l11, long l12, int n10, long l13) {
        int n11;
        int n12;
        byte by2;
        int n13;
        int n14;
        int n15;
        int n16 = 44;
        byte[] byArray = new byte[n16];
        byArray[0] = 82;
        int n17 = 1;
        byArray[n17] = 73;
        byArray[2] = n15 = 70;
        byArray[3] = n15;
        long l14 = 255L;
        int n18 = (int)(l11 & l14);
        int n19 = 4;
        byArray[n19] = n18;
        n18 = 8;
        byArray[5] = n14 = (int)((int)(l11 >> n18 & l14));
        n14 = 16;
        byArray[6] = n13 = (int)((int)(l11 >> n14 & l14));
        n13 = 24;
        byArray[7] = by2 = (byte)(l11 >> n13 & l14);
        byArray[n18] = 87;
        byArray[9] = 65;
        byArray[10] = 86;
        byArray[11] = 69;
        byArray[12] = 102;
        byArray[13] = 109;
        byArray[14] = n12 = 116;
        byArray[15] = n11 = 32;
        byArray[n14] = n14;
        byArray[17] = 0;
        byArray[18] = 0;
        byArray[19] = 0;
        byArray[20] = n17;
        byArray[21] = 0;
        n17 = n10;
        byArray[22] = n17 = (int)((byte)n10);
        byArray[23] = 0;
        byArray[n13] = n17 = (int)((byte)(l12 & l14));
        byArray[25] = n17 = (int)((byte)(l12 >> n18 & l14));
        byArray[26] = n17 = (int)((byte)(l12 >> n14 & l14));
        byArray[27] = n17 = (int)((byte)(l12 >> n13 & l14));
        byArray[28] = n17 = (int)((byte)(l13 & l14));
        byArray[29] = n17 = (int)((byte)(l13 >> n18 & l14));
        byArray[30] = n17 = (int)((byte)(l13 >> n14 & l14));
        byArray[31] = n17 = (int)((byte)(l13 >> n13 & l14));
        byArray[n11] = n19;
        byArray[33] = 0;
        byArray[34] = n14;
        byArray[35] = 0;
        byArray[36] = 100;
        byArray[37] = n19 = 97;
        byArray[38] = n12;
        byArray[39] = n19;
        byArray[40] = n17 = (int)((byte)(l10 & l14));
        byArray[41] = n18 = (int)((byte)(l10 >> n18 & l14));
        byArray[42] = n18 = (int)((byte)(l10 >> n14 & l14));
        byArray[43] = n18 = (int)((byte)(l10 >> n13 & l14));
        fileOutputStream.write(byArray, 0, n16);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String string2, String string3, e$a e$a) {
        e e10 = this;
        e$a e$a2 = e$a;
        int n10 = this.b;
        long l10 = n10;
        int n11 = this.c;
        int n12 = 16;
        n11 = n11 == n12 ? 1 : 2;
        long l11 = n10 * n12 * n11 / 8;
        n10 = e10.a;
        byte[] byArray = new byte[n10];
        try {
            Object object = string2;
            FileInputStream fileInputStream = new FileInputStream(string2);
            object = string3;
            FileOutputStream fileOutputStream = new FileOutputStream(string3);
            object = fileInputStream.getChannel();
            long l12 = ((FileChannel)object).size();
            long l13 = 36;
            long l14 = l12 + l13;
            object = this;
            this.b(fileOutputStream, l12, l14, l10, n11, l11);
            while (true) {
                if ((n11 = fileInputStream.read(byArray)) == (n12 = -1)) {
                    fileInputStream.close();
                    fileOutputStream.close();
                    if (e$a2 == null) return;
                    e$a.complete();
                    return;
                }
                fileOutputStream.write(byArray);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            if (e$a2 == null) return;
            e$a2.a(iOException);
        }
    }
}

