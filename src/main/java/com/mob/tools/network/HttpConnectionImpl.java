/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.mob.tools.network;

import android.os.Build;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.HttpConnection;
import com.mob.tools.utils.ReflectHelper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HttpConnectionImpl
implements HttpConnection {
    private Object response;

    static {
        String string2 = "org.apache.http.HttpResponse";
        ReflectHelper.importClass(string2);
        string2 = "org.apache.http.Header";
        try {
            ReflectHelper.importClass(string2);
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.w(throwable);
        }
    }

    public HttpConnectionImpl(Object object) {
        this.response = object;
    }

    public InputStream getErrorStream() {
        return this.getInputStream();
    }

    public Map getHeaderFields() {
        HashMap<Object, String[]> hashMap;
        block23: {
            int n10;
            hashMap = new HashMap<Object, String[]>();
            Object object = this.response;
            Object object2 = "getAllHeaders";
            Object[] objectArray = new Object[]{};
            object = ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
            if (object == null) break block23;
            object2 = "length";
            object2 = ReflectHelper.getInstanceField(object, (String)object2);
            object2 = (Integer)object2;
            int n11 = (Integer)object2;
            objectArray = new Object[n11];
            try {
                System.arraycopy(object, 0, objectArray, 0, n11);
                object = null;
            }
            catch (Throwable throwable) {
                n10 = Build.VERSION.SDK_INT;
                n11 = 9;
                if (n10 < n11) {
                    String string2 = throwable.getMessage();
                    object = new IOException(string2);
                    throw object;
                }
                object = new IOException(throwable);
                throw object;
            }
            for (n10 = 0; n10 < n11; ++n10) {
                Object object3 = objectArray[n10];
                Object object4 = "getName";
                Object object5 = new Object[]{};
                object4 = ReflectHelper.invokeInstanceMethod(object3, (String)object4, object5);
                object4 = (String)object4;
                object5 = "getValue";
                Object[] objectArray2 = new Object[]{};
                object3 = ReflectHelper.invokeInstanceMethod(object3, (String)object5, objectArray2);
                object3 = (String)object3;
                if (object3 == null) {
                    object3 = "";
                }
                object5 = ",";
                object3 = object3.split((String)object5);
                object3 = Arrays.asList(object3);
                hashMap.put(object4, (String[])object3);
                continue;
            }
        }
        return hashMap;
    }

    public InputStream getInputStream() {
        Object[] objectArray;
        int n10;
        Object object;
        Object object2;
        try {
            object2 = this.response;
            object = "getEntity";
            n10 = 0;
            objectArray = null;
        }
        catch (Throwable throwable) {
            int n11 = Build.VERSION.SDK_INT;
            n10 = 9;
            if (n11 < n10) {
                String string2 = throwable.getMessage();
                object = new IOException(string2);
                throw object;
            }
            object = new IOException(throwable);
            throw object;
        }
        Object[] objectArray2 = new Object[]{};
        object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object, objectArray2);
        object = "getContent";
        objectArray = new Object[]{};
        object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object, objectArray);
        return (InputStream)object2;
    }

    public int getResponseCode() {
        Object[] objectArray;
        int n10;
        Object object;
        Object object2;
        try {
            object2 = this.response;
            object = "getStatusLine";
            n10 = 0;
            objectArray = null;
        }
        catch (Throwable throwable) {
            int n11 = Build.VERSION.SDK_INT;
            n10 = 9;
            if (n11 < n10) {
                String string2 = throwable.getMessage();
                object = new IOException(string2);
                throw object;
            }
            object = new IOException(throwable);
            throw object;
        }
        Object[] objectArray2 = new Object[]{};
        object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object, objectArray2);
        object = "getStatusCode";
        objectArray = new Object[]{};
        object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object, objectArray);
        object2 = (Integer)object2;
        return (Integer)object2;
    }
}

