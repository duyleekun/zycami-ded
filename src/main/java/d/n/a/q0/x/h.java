/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.x;

import d.n.a.q0.p;

public class h {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int[] h;

    public h(int n10, int n11, int n12, int n13, int n14, int n15, int n16) {
        this.a = n10;
        this.b = n11;
        this.c = n12;
        this.d = n13;
        this.e = n14;
        this.f = n15;
        this.g = n16;
        int[] nArray = this.a();
        this.h = nArray;
    }

    private int[] a() {
        int n10 = this.a;
        n10 = this.b;
        n10 = this.c;
        n10 = this.d;
        n10 = this.e;
        n10 = this.f;
        n10 = this.g;
        int[] nArray = new int[]{n10, n10, n10, n10, n10, n10, n10};
        return nArray;
    }

    private static boolean b(int n10, int n11) {
        n10 = (n10 &= n11) != 0 ? 1 : 0;
        return n10 != 0;
    }

    private String d(int n10) {
        int n11 = this.b;
        if (n10 == n11) {
            return "READ";
        }
        n11 = this.d;
        if (n10 == n11) {
            return "WRITE";
        }
        n11 = this.c;
        if (n10 == n11) {
            return "WRITE_NO_RESPONSE";
        }
        n11 = this.g;
        if (n10 == n11) {
            return "SIGNED_WRITE";
        }
        n11 = this.f;
        if (n10 == n11) {
            return "INDICATE";
        }
        n11 = this.a;
        if (n10 == n11) {
            return "BROADCAST";
        }
        n11 = this.e;
        if (n10 == n11) {
            return "NOTIFY";
        }
        if (n10 == 0) {
            return "";
        }
        Object object = new Object[1];
        Integer n12 = n10;
        object[0] = n12;
        p.d("Unknown property specified (%d)", (Object[])object);
        object = new StringBuilder();
        ((StringBuilder)object).append("UNKNOWN (");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" -> check android.bluetooth.BluetoothGattCharacteristic)");
        return ((StringBuilder)object).toString();
    }

    public String c(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (int n11 : this.h) {
            boolean bl2 = d.n.a.q0.x.h.b(n10, n11);
            if (!bl2) continue;
            String string2 = this.d(n11);
            stringBuilder.append(string2);
            string2 = " ";
            stringBuilder.append(string2);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

