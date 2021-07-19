/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.zysocket.util;

import com.zhiyun.zysocket.util.SocketUtil;
import com.zhiyun.zysocket.util.SocketUtil$SocketType$1;
import com.zhiyun.zysocket.util.SocketUtil$SocketType$2;
import com.zhiyun.zysocket.util.SocketUtil$a;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public abstract class SocketUtil$SocketType
extends Enum {
    public static final /* enum */ SocketUtil$SocketType TCP;
    public static final /* enum */ SocketUtil$SocketType UDP;
    private static final /* synthetic */ SocketUtil$SocketType[] a;

    static {
        SocketUtil$SocketType$1 socketUtil$SocketType$1 = new SocketUtil$SocketType$1();
        TCP = socketUtil$SocketType$1;
        int n10 = 1;
        SocketUtil$SocketType$2 socketUtil$SocketType$2 = new SocketUtil$SocketType$2();
        UDP = socketUtil$SocketType$2;
        SocketUtil$SocketType[] socketUtil$SocketTypeArray = new SocketUtil$SocketType[2];
        socketUtil$SocketTypeArray[0] = socketUtil$SocketType$1;
        socketUtil$SocketTypeArray[n10] = socketUtil$SocketType$2;
        a = socketUtil$SocketTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SocketUtil$SocketType() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ SocketUtil$SocketType(SocketUtil.a a10) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    private int a(int n10, int n11) {
        n11 -= n10;
        Random random = SocketUtil.a();
        ++n11;
        n11 = random.nextInt(n11);
        return n10 + n11;
    }

    public static SocketUtil$SocketType valueOf(String string2) {
        return Enum.valueOf(SocketUtil$SocketType.class, string2);
    }

    public static SocketUtil$SocketType[] values() {
        return (SocketUtil$SocketType[])a.clone();
    }

    public int findAvailablePort(int n10, int n11, String object) {
        Object object2;
        int n12;
        int n13 = n11 - n10;
        for (n12 = 0; n12 <= n13; ++n12) {
            int n14 = this.a(n10, n11);
            boolean bl2 = this.isPortAvailable(n14, (String)object);
            if (!bl2) continue;
            return n14;
        }
        Object[] objectArray = new Object[4];
        String string2 = this.name();
        objectArray[0] = string2;
        objectArray[1] = object2 = Integer.valueOf(n10);
        Integer n15 = n11;
        objectArray[2] = n15;
        n15 = n12;
        objectArray[3] = n15;
        object2 = String.format("Could not find an available %s port in the range [%d, %d] after %d attempts", objectArray);
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public SortedSet findAvailablePorts(int n10, int n11, int n12, String object) {
        Object object2;
        int n13;
        int n14;
        Object[] objectArray = new TreeSet();
        int n15 = 0;
        while ((n15 += (n14 = 1)) <= (n13 = n10 + 100) && (n13 = objectArray.size()) < n10) {
            n14 = this.findAvailablePort(n11, n12, (String)object);
            Integer n16 = n14;
            objectArray.add(n16);
        }
        int n17 = objectArray.size();
        if (n17 == n10) {
            return objectArray;
        }
        objectArray = new Object[4];
        objectArray[0] = object2 = Integer.valueOf(n10);
        objectArray[n14] = object2 = this.name();
        Integer n18 = n11;
        objectArray[2] = n18;
        n18 = n12;
        objectArray[3] = n18;
        object2 = String.format("Could not find %d available %s ports in the range [%d, %d]", objectArray);
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public abstract boolean isPortAvailable(int var1, String var2);
}

