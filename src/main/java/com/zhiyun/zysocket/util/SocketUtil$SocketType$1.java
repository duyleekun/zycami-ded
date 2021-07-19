/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.zysocket.util;

import com.zhiyun.zysocket.util.SocketUtil$SocketType;
import java.net.InetAddress;
import javax.net.ServerSocketFactory;

public final class SocketUtil$SocketType$1
extends SocketUtil$SocketType {
    /*
     * Unable to fully structure code
     */
    public boolean isPortAvailable(int var1_1, String var2_2) {
        block5: {
            var3_3 = "localhost";
            if (var2_2 != null) ** GOTO lbl7
            InetAddress.getByName((String)var3_3);
            break block5;
lbl7:
            // 1 sources

            InetAddress.getByName((String)var2_2);
        }
        var2_2 = ServerSocketFactory.getDefault();
        try {
            var3_3 = InetAddress.getByName((String)var3_3);
            var4_4 = true;
        }
        catch (Exception v0) {
            return false;
        }
        var5_5 = var2_2.createServerSocket(var1_1, (int)var4_4, (InetAddress)var3_3);
        var5_5.close();
        return var4_4;
    }
}

