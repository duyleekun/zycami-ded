/*
 * Decompiled with CFR 0.151.
 */
package i.d.p;

import org.java_websocket.enums.Opcode;

public class g$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Opcode opcode;
        int n12 = Opcode.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            opcode = Opcode.PING;
            n11 = opcode.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            opcode = Opcode.PONG;
            n11 = opcode.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            opcode = Opcode.TEXT;
            n11 = opcode.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            opcode = Opcode.BINARY;
            n11 = opcode.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            opcode = Opcode.CLOSING;
            n11 = opcode.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            opcode = Opcode.CONTINUOUS;
            n11 = opcode.ordinal();
            nArray[n11] = n10 = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

