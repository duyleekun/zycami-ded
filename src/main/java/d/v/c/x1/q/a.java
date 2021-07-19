/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x1.q;

import d.v.c.x1.q.c;
import java.util.Objects;

public final class a
extends c {
    private final String b;
    private final long c;
    private final int d;

    public a(String string2, long l10, int n10) {
        Objects.requireNonNull(string2, "Null videoPath");
        this.b = string2;
        this.c = l10;
        this.d = n10;
    }

    public int c() {
        return this.d;
    }

    public long d() {
        return this.c;
    }

    public String e() {
        return this.b;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof c;
        if (n10 != 0) {
            int n11;
            long l10;
            long l11;
            long l12;
            String string2 = this.b;
            String string3 = ((c)(object = (c)object)).e();
            n10 = string2.equals(string3);
            if (n10 == 0 || (n10 = (l12 = (l11 = this.c) - (l10 = ((c)object).d())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != 0 || (n10 = this.d) != (n11 = ((c)object).c())) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.b.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        long l10 = this.c;
        long l11 = l10 >>> 32;
        int n12 = (int)(l10 ^ l11);
        n10 = (n10 ^ n12) * n11;
        n11 = this.d;
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VideoThumbnailModel{videoPath=");
        String string2 = this.b;
        stringBuilder.append(string2);
        stringBuilder.append(", position=");
        long l10 = this.c;
        stringBuilder.append(l10);
        stringBuilder.append(", height=");
        int n10 = this.d;
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

