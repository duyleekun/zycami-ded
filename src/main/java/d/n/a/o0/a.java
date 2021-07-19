/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.o0;

public class a {
    public static final a b;
    public static final a c;
    public static final a d;
    public static final a e;
    public static final a f;
    public static final a g;
    public static final a h;
    public static final a i;
    public static final a j;
    public static final a k;
    public static final a l;
    public static final a m;
    private final String a;

    static {
        a a10;
        b = a10 = new a("CONNECTION_STATE");
        c = a10 = new a("SERVICE_DISCOVERY");
        d = a10 = new a("CHARACTERISTIC_READ");
        e = a10 = new a("CHARACTERISTIC_WRITE");
        f = a10 = new a("CHARACTERISTIC_LONG_WRITE");
        g = a10 = new a("CHARACTERISTIC_CHANGED");
        h = a10 = new a("DESCRIPTOR_READ");
        i = a10 = new a("DESCRIPTOR_WRITE");
        j = a10 = new a("RELIABLE_WRITE_COMPLETED");
        k = a10 = new a("READ_RSSI");
        l = a10 = new a("ON_MTU_CHANGED");
        m = a10 = new a("CONNECTION_PRIORITY_CHANGE");
    }

    private a(String string2) {
        this.a = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BleGattOperation{description='");
        String string2 = this.a;
        stringBuilder.append(string2);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

