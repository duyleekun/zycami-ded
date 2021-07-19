/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.network;

import cn.leancloud.cache.SystemSetting;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.utils.StringUtil;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import g.a0;
import g.a0$a;
import g.c0;
import g.d0;
import g.e;
import g.p;
import g.t;
import g.t$a;
import g.z;
import g.z$a;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DNSDetoxicant
implements p {
    public static final String AVOS_SERVER_HOST_ZONE = "avoscloud_server_host_zone";
    public static final String DNSPOD_HOST = System.getProperty("dnspodHost", "119.29.29.29");
    private static final int DNS_REQUEST_TIME_OUT = 2000;
    public static final String EXPIRE_TIME = ".expireTime";
    public static final long TWENTY_MIN_IN_MILLS = 1200000L;

    private void cacheDNS(String string2, String object) {
        Object object2 = AppConfiguration.getDefaultSetting();
        String string3 = AVOS_SERVER_HOST_ZONE;
        object2.saveString(string3, string2, (String)object);
        object = AppConfiguration.getDefaultSetting();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(EXPIRE_TIME);
        string2 = ((StringBuilder)object2).toString();
        object2 = String.valueOf(System.currentTimeMillis() + 1200000L);
        object.saveString(string3, string2, (String)object2);
    }

    private String getCacheDNSResult(String string2) {
        long l10;
        long l11;
        long l12;
        long l13;
        Object object = AppConfiguration.getDefaultSetting();
        String string3 = AVOS_SERVER_HOST_ZONE;
        object = object.getString(string3, string2, null);
        SystemSetting systemSetting = AppConfiguration.getDefaultSetting();
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string2);
        charSequence.append(EXPIRE_TIME);
        string2 = charSequence.toString();
        charSequence = "0";
        string2 = systemSetting.getString(string3, string2, (String)charSequence);
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2 && (l13 = (l12 = (l11 = System.currentTimeMillis()) - (l10 = Long.parseLong(string2))) == 0L ? 0 : (l12 < 0L ? -1 : 1)) < 0) {
            return object;
        }
        return null;
    }

    private static InetAddress[] getIPAddress(String string2, String stringArray) {
        int n10;
        stringArray = stringArray.split(";");
        int n11 = stringArray.length;
        InetAddress[] inetAddressArray = new InetAddress[n11];
        int n12 = 3;
        Class[] classArray = new Class[n12];
        Object object = Integer.TYPE;
        classArray[0] = object;
        int n13 = 1;
        classArray[n13] = byte[].class;
        object = String.class;
        int n14 = 2;
        classArray[n14] = object;
        Constructor constructor = InetAddress.class.getDeclaredConstructor(classArray);
        constructor.setAccessible(n13 != 0);
        classArray = null;
        for (int i10 = 0; i10 < (n10 = stringArray.length); ++i10) {
            int n15;
            object = stringArray[i10];
            Object object2 = "\\.";
            int n16 = ((String[])(object = object.split((String)object2))).length;
            if (n16 != (n15 = 4)) continue;
            object2 = new byte[n15];
            n15 = (byte)Integer.parseInt(object[0]);
            object2[0] = n15;
            n15 = (byte)Integer.parseInt(object[n13]);
            object2[n13] = n15;
            n15 = (byte)Integer.parseInt(object[n14]);
            object2[n14] = n15;
            n10 = (byte)Integer.parseInt(object[n12]);
            object2[n12] = n10;
            object = new Object[n12];
            Integer n17 = n14;
            object[0] = n17;
            object[n13] = object2;
            object[n14] = string2;
            inetAddressArray[i10] = object = (InetAddress)constructor.newInstance(object);
        }
        return inetAddressArray;
    }

    public static String getIPByHostSync(String object) {
        String string2;
        block6: {
            string2 = "";
            Object object2 = new t$a();
            object2 = ((t$a)object2).M("http");
            Object object3 = DNSPOD_HOST;
            object = ((t$a)object2).x((String)object3).d("d").g("dn", (String)object).h();
            object2 = new z$a();
            object3 = TimeUnit.MILLISECONDS;
            long l10 = 2000L;
            ((z$a)object2).k(l10, (TimeUnit)((Object)object3));
            object3 = p.a;
            ((z$a)object2).q((p)object3);
            object2 = ((z$a)object2).f();
            object3 = new a0$a();
            object = ((a0$a)object3).D((t)object).g().b();
            try {
                object = ((z)object2).a((a0)object);
            }
            catch (IOException iOException) {}
            object = FirebasePerfOkHttpClient.execute((e)object);
            if (object == null) break block6;
            boolean bl2 = ((c0)object).isSuccessful();
            if (!bl2) break block6;
            object = ((c0)object).r0();
            return ((d0)object).string();
        }
        return string2;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public List lookup(String object) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            InetAddress[] inetAddressArray;
            try {
                inetAddressArray = InetAddress.getAllByName((String)object);
            }
            catch (UnknownHostException unknownHostException) {
                void var3_6;
                boolean bl3;
                block10: {
                    String string2;
                    try {
                        string2 = this.getCacheDNSResult((String)object);
                    }
                    catch (Exception exception) {
                        object = new UnknownHostException();
                        throw object;
                    }
                    bl3 = StringUtil.isEmpty(string2) ^ true;
                    if (bl3) break block10;
                    String string3 = DNSDetoxicant.getIPByHostSync((String)object);
                }
                InetAddress[] inetAddressArray2 = DNSDetoxicant.getIPAddress((String)object, (String)var3_6);
                if (bl3) return Arrays.asList(inetAddressArray2);
                this.cacheDNS((String)object, (String)var3_6);
                return Arrays.asList(inetAddressArray2);
            }
            return Arrays.asList(inetAddressArray);
        }
        object = new UnknownHostException("hostname is empty");
        throw object;
    }
}

