/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.network;

import cn.leancloud.network.NetworkingDetector;
import cn.leancloud.network.NetworkingDetector$NetworkType;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.regex.Pattern;

public class SimpleNetworkingDetector
implements NetworkingDetector {
    private static final String eth0Pattern = "[0-9]+\\.[0-9]+\\.[0-9]+\\.[0-9]+";

    public NetworkingDetector$NetworkType getNetworkType() {
        return NetworkingDetector$NetworkType.WIFI;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isConnected() {
        boolean bl2 = false;
        try {
            NetworkInterface networkInterface;
            boolean bl3;
            Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
            block2: do {
                boolean bl4;
                boolean bl5;
                if (!(bl5 = enumeration.hasMoreElements())) return bl2;
                networkInterface = enumeration.nextElement();
                Object object = networkInterface.getInterfaceAddresses();
                object = object.iterator();
                while (bl4 = object.hasNext()) {
                    Object object2 = object.next();
                    object2 = (InterfaceAddress)object2;
                    String string2 = "127.0.0.1";
                    Object object3 = ((InterfaceAddress)object2).getAddress();
                    boolean bl6 = string2.equalsIgnoreCase((String)(object3 = ((InetAddress)object3).getHostAddress()));
                    if (bl6) break;
                    string2 = eth0Pattern;
                    object2 = ((InterfaceAddress)object2).getAddress();
                    bl4 = Pattern.matches(string2, (CharSequence)(object2 = ((InetAddress)object2).getHostAddress()));
                    if (!bl4) continue;
                    bl3 = true;
                    continue block2;
                }
                bl3 = false;
                object = null;
            } while (!bl3);
            return networkInterface.isUp();
        }
        catch (SocketException socketException) {
            return bl2;
        }
    }
}

