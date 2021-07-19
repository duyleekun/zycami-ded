/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.o.a;

public class e {
    private String a;
    private long b;

    public e(String string2, long l10) {
        this.a = string2;
        this.b = l10;
    }

    public boolean a(e e10) {
        long l10;
        long l11;
        long l12;
        long l13;
        boolean bl2 = false;
        if (e10 == null) {
            return false;
        }
        String string2 = this.a;
        String string3 = e10.a;
        boolean bl3 = string2.equals(string3);
        if (bl3 && (l13 = (l12 = (l11 = this.b) - (l10 = e10.b)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
            bl2 = true;
        }
        return bl2;
    }

    public String b() {
        return this.a;
    }

    public long c() {
        return this.b;
    }

    public e d(String string2) {
        this.a = string2;
        return this;
    }

    public e e(long l10) {
        this.b = l10;
        return this;
    }
}

