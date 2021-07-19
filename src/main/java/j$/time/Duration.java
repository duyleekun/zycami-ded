/*
 * Decompiled with CFR 0.151.
 */
package j$.time;

import j$.c;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.regex.Pattern;

public final class Duration
implements Comparable,
Serializable {
    public static final Duration c;
    private final long a;
    private final int b;

    static {
        Duration duration;
        c = duration = new Duration(0L, 0);
        BigInteger.valueOf(1000000000L);
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    }

    private Duration(long l10, int n10) {
        this.a = l10;
        this.b = n10;
    }

    private static Duration m(long l10, int n10) {
        long l11 = (long)n10 | l10;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            return c;
        }
        Duration duration = new Duration(l10, n10);
        return duration;
    }

    public static Duration n(long l10) {
        long l11 = 1000000000L;
        long l12 = l10 / l11;
        int n10 = (int)(l10 %= l11);
        if (n10 < 0) {
            l10 = (long)n10 + l11;
            n10 = (int)l10;
            l11 = 1L;
            l12 -= l11;
        }
        return Duration.m(l12, n10);
    }

    public static Duration o(long l10) {
        return Duration.m(l10, 0);
    }

    public static Duration ofSeconds(long l10, long l11) {
        long l12 = 1000000000L;
        long l13 = Math.floorDiv(l11, l12);
        l10 = Math.addExact(l10, l13);
        int n10 = (int)Math.floorMod(l11, l12);
        return Duration.m(l10, n10);
    }

    public int compareTo(Object object) {
        object = (Duration)object;
        long l10 = this.a;
        long l11 = ((Duration)object).a;
        int n10 = Long.compare(l10, l11);
        if (n10 == 0) {
            n10 = this.b;
            int n11 = ((Duration)object).b;
            n10 -= n11;
        }
        return n10;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        Object object2 = object instanceof Duration;
        if (object2 != 0) {
            int n10;
            object = (Duration)object;
            long l10 = this.a;
            long l11 = ((Duration)object).a;
            long l12 = l10 - l11;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 != 0 || (object2 = this.b) != (n10 = ((Duration)object).b)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getNano() {
        return this.b;
    }

    public long getSeconds() {
        return this.a;
    }

    public int hashCode() {
        long l10 = this.a;
        long l11 = l10 >>> 32;
        int n10 = (int)(l10 ^ l11);
        return this.b * 51 + n10;
    }

    public long toMillis() {
        long l10 = j$.c.a(this.a, 1000);
        long l11 = this.b / 1000000;
        return Math.addExact(l10, l11);
    }

    public String toString() {
        Duration duration = c;
        if (this == duration) {
            return "PT0S";
        }
        long l10 = this.a;
        long l11 = 3600L;
        long l12 = l10 / l11;
        l11 = l10 % l11;
        long l13 = 60;
        int n10 = (int)(l11 /= l13);
        int c10 = (int)(l10 %= l13);
        StringBuilder stringBuilder = new StringBuilder(24);
        String string2 = "PT";
        stringBuilder.append(string2);
        l13 = 0L;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l14 != false) {
            stringBuilder.append(l12);
            l14 = 72;
            stringBuilder.append((char)l14);
        }
        if (n10 != 0) {
            stringBuilder.append(n10);
            n10 = 77;
            stringBuilder.append((char)n10);
        }
        if (c10 == 0 && (n10 = this.b) == 0 && (n10 = stringBuilder.length()) > (l14 = (long)2)) {
            return stringBuilder.toString();
        }
        if (c10 < 0 && (n10 = this.b) > 0) {
            n10 = -1;
            if (c10 == n10) {
                String string3 = "-0";
                stringBuilder.append(string3);
            } else {
                n10 = c10 + 1;
                stringBuilder.append(n10);
            }
        } else {
            stringBuilder.append(c10);
        }
        n10 = this.b;
        if (n10 > 0) {
            long l15;
            long l16;
            n10 = stringBuilder.length();
            if (c10 < 0) {
                int n11 = this.b;
                l16 = n11;
                l15 = 2000000000L - l16;
                stringBuilder.append(l15);
            } else {
                int n12 = this.b;
                l16 = n12;
                l15 = 1000000000L;
                stringBuilder.append(l16 += l15);
            }
            while (true) {
                int n13 = stringBuilder.length() + -1;
                if ((n13 = (int)stringBuilder.charAt(n13)) != (l14 = (long)48)) break;
                n13 = stringBuilder.length() + -1;
                stringBuilder.setLength(n13);
            }
            char c11 = '.';
            stringBuilder.setCharAt(n10, c11);
        }
        stringBuilder.append('S');
        return stringBuilder.toString();
    }
}

