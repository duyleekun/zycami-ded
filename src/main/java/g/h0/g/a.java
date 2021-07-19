/*
 * Decompiled with CFR 0.151.
 */
package g.h0.g;

import f.h2.t.f0;
import h.m;
import java.nio.channels.FileChannel;

public final class a {
    private final FileChannel a;

    public a(FileChannel fileChannel) {
        f0.p(fileChannel, "fileChannel");
        this.a = fileChannel;
    }

    public final void a(long l10, m m10, long l11) {
        String string2 = "sink";
        f0.p(m10, string2);
        long l12 = 0L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 >= 0) {
            while ((l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1)) > 0) {
                FileChannel fileChannel = this.a;
                long l14 = fileChannel.transferTo(l10, l11, m10);
                l10 += l14;
                l11 -= l14;
            }
            return;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
        throw indexOutOfBoundsException;
    }

    public final void b(long l10, m m10, long l11) {
        long l12;
        long l13;
        String string2 = "source";
        f0.p(m10, string2);
        long l14 = 0L;
        long l15 = l11 == l14 ? 0 : (l11 < l14 ? -1 : 1);
        if (l15 >= 0 && (l15 = (l13 = l11 - (l12 = m10.S0())) == 0L ? 0 : (l13 < 0L ? -1 : 1)) <= 0) {
            while ((l15 = l11 == l14 ? 0 : (l11 < l14 ? -1 : 1)) > 0) {
                FileChannel fileChannel = this.a;
                l12 = fileChannel.transferFrom(m10, l10, l11);
                l10 += l12;
                l11 -= l12;
            }
            return;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
        throw indexOutOfBoundsException;
    }
}

