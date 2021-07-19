/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

public class e0$b {
    public static final e0$b c;
    public static final e0$b d;
    public static final e0$b e;
    public static final e0$b f;
    private final boolean a;
    private final String b;

    static {
        e0$b e0$b;
        c = e0$b = new e0$b(true, "STATE_ON");
        d = e0$b = new e0$b(false, "STATE_OFF");
        e = e0$b = new e0$b(false, "STATE_TURNING_ON");
        f = e0$b = new e0$b(false, "STATE_TURNING_OFF");
    }

    private e0$b(boolean bl2, String string2) {
        this.a = bl2;
        this.b = string2;
    }

    public boolean a() {
        return this.a;
    }

    public String toString() {
        return this.b;
    }
}

