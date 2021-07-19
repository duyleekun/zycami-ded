/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

public final class AdapterHelper$UpdateOp {
    public static final int ADD = 1;
    public static final int MOVE = 8;
    public static final int POOL_SIZE = 30;
    public static final int REMOVE = 2;
    public static final int UPDATE = 4;
    public int cmd;
    public int itemCount;
    public Object payload;
    public int positionStart;

    public AdapterHelper$UpdateOp(int n10, int n11, int n12, Object object) {
        this.cmd = n10;
        this.positionStart = n11;
        this.itemCount = n12;
        this.payload = object;
    }

    public String cmdToString() {
        int n10 = this.cmd;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 4;
                if (n10 != n11) {
                    n11 = 8;
                    if (n10 != n11) {
                        return "??";
                    }
                    return "mv";
                }
                return "up";
            }
            return "rm";
        }
        return "add";
    }

    public boolean equals(Object object) {
        boolean bl2;
        int n10 = 1;
        if (this == object) {
            return n10 != 0;
        }
        int n11 = object instanceof AdapterHelper$UpdateOp;
        if (n11 == 0) {
            return false;
        }
        object = (AdapterHelper$UpdateOp)object;
        n11 = this.cmd;
        int n12 = ((AdapterHelper$UpdateOp)object).cmd;
        if (n11 != n12) {
            return false;
        }
        n12 = 8;
        if (n11 == n12) {
            n11 = this.itemCount;
            n12 = this.positionStart;
            if ((n11 = Math.abs(n11 - n12)) == n10 && (n11 = this.itemCount) == (n12 = ((AdapterHelper$UpdateOp)object).positionStart) && (n11 = this.positionStart) == (n12 = ((AdapterHelper$UpdateOp)object).itemCount)) {
                return n10 != 0;
            }
        }
        if ((n11 = this.itemCount) != (n12 = ((AdapterHelper$UpdateOp)object).itemCount)) {
            return false;
        }
        n11 = this.positionStart;
        n12 = ((AdapterHelper$UpdateOp)object).positionStart;
        if (n11 != n12) {
            return false;
        }
        Object object2 = this.payload;
        if (object2 != null ? !(bl2 = object2.equals(object = ((AdapterHelper$UpdateOp)object).payload)) : (object = ((AdapterHelper$UpdateOp)object).payload) != null) {
            return false;
        }
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.cmd * 31;
        int n11 = this.positionStart;
        n10 = (n10 + n11) * 31;
        n11 = this.itemCount;
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append((String)object);
        stringBuilder.append("[");
        object = this.cmdToString();
        stringBuilder.append((String)object);
        stringBuilder.append(",s:");
        int n10 = this.positionStart;
        stringBuilder.append(n10);
        stringBuilder.append("c:");
        n10 = this.itemCount;
        stringBuilder.append(n10);
        stringBuilder.append(",p:");
        object = this.payload;
        stringBuilder.append(object);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

