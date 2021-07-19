/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVLogger;
import cn.leancloud.core.AVOSCloud;
import cn.leancloud.utils.LogUtil;
import g.a0;
import g.b0;
import g.c0;
import g.c0$a;
import g.d0;
import g.s;
import g.u;
import g.u$a;
import h.k0;
import h.n;
import h.z;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class LoggingInterceptor
implements u {
    private static final String CURL_COMMAND = "curl -X %s %n";
    private static final String CURL_HEADER_FORMAT = " -H %s: %s %n";
    private static AVLogger LOGGER = LogUtil.getLogger(LoggingInterceptor.class);

    private String generateCURLCommandString(a0 object) {
        StringBuilder stringBuilder;
        String string2;
        block15: {
            boolean bl2;
            string2 = ((a0)object).q().toString();
            Object object2 = ((a0)object).m();
            Object[] objectArray = ((a0)object).k();
            stringBuilder = new StringBuilder();
            int n10 = 1;
            Object object3 = new Object[n10];
            object3[0] = object2;
            object2 = String.format(CURL_COMMAND, object3);
            stringBuilder.append((String)object2);
            object2 = objectArray.i().iterator();
            while (bl2 = object2.hasNext()) {
                Object object4;
                object3 = (String)object2.next();
                boolean bl3 = AVOSCloud.printAllHeaders;
                int n11 = 2;
                String string3 = CURL_HEADER_FORMAT;
                if (!bl3) {
                    object4 = "X-LC-Key";
                    bl3 = ((String)object4).equals(object3);
                    if (bl3) {
                        object4 = new Object[n11];
                        object4[0] = object3;
                        object4[n10] = "{your_app_key}";
                        object3 = String.format(string3, (Object[])object4);
                        stringBuilder.append((String)object3);
                        continue;
                    }
                    object4 = "X-LC-Session";
                    bl3 = ((String)object4).equals(object3);
                    if (bl3) {
                        object4 = new Object[n11];
                        object4[0] = object3;
                        object4[n10] = "{your_session}";
                        object3 = String.format(string3, (Object[])object4);
                        stringBuilder.append((String)object3);
                        continue;
                    }
                    object4 = "X-LC-Sign";
                    boolean bl4 = ((String)object4).equals(object3);
                    if (bl4) {
                        object3 = new Object[n11];
                        object3[0] = object4;
                        object3[n10] = object4 = "{your_sign}";
                        object3 = String.format(string3, object3);
                        stringBuilder.append((String)object3);
                        continue;
                    }
                }
                object4 = new Object[n11];
                object4[0] = object3;
                object4[n10] = object3 = objectArray.e((String)object3);
                object3 = String.format(string3, (Object[])object4);
                stringBuilder.append((String)object3);
            }
            object2 = new ByteArrayOutputStream();
            objectArray = z.h((OutputStream)object2);
            objectArray = z.c((k0)objectArray);
            object = ((a0)object).f();
            if (object == null) break block15;
            ((b0)object).writeTo((n)objectArray);
            objectArray.close();
            object = ((ByteArrayOutputStream)object2).toString();
            object2 = "-d '%s' %n";
            objectArray = new Object[n10];
            objectArray[0] = object;
            object = String.format((String)object2, objectArray);
            try {
                stringBuilder.append((String)object);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public c0 intercept(u$a object) {
        Object object2 = object.C();
        object = object.c((a0)object2);
        boolean bl2 = AVOSCloud.isDebugEnable();
        if (!bl2) {
            return object;
        }
        Object object3 = LOGGER;
        int n10 = 1;
        Object object4 = new Object[n10];
        object4[0] = object2 = this.generateCURLCommandString((a0)object2);
        object2 = String.format("Request: %s", object4);
        ((AVLogger)object3).d((String)object2);
        int n11 = ((c0)object).v0();
        object3 = ((c0)object).C0();
        object4 = ((c0)object).r0().string();
        AVLogger aVLogger = LOGGER;
        Object[] objectArray = new Object[3];
        Integer n12 = ((c0)object).v0();
        objectArray[0] = n12;
        objectArray[n10] = object3;
        objectArray[2] = object4;
        String string2 = String.format("Response: %d %n%s %n%s ", objectArray);
        aVLogger.d(string2);
        object2 = ((c0)object).G0().g(n11).w((s)object3);
        object = d0.create(((c0)object).r0().contentType(), (String)object4);
        return ((c0$a)object2).b((d0)object).c();
    }
}

