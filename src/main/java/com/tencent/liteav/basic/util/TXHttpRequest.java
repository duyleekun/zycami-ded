/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.util;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXHttpRequest$a;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

public class TXHttpRequest {
    private static final int CON_TIMEOUT = 5000;
    private static final int READ_TIMEOUT = 5000;
    private static final String TAG = "TXHttpRequest";
    private long mNativeHttps = 0L;

    public TXHttpRequest(long l10) {
        this.mNativeHttps = l10;
    }

    public static /* synthetic */ long access$000(TXHttpRequest tXHttpRequest) {
        return tXHttpRequest.mNativeHttps;
    }

    public static /* synthetic */ void access$100(TXHttpRequest tXHttpRequest, long l10, int n10, byte[] byArray) {
        tXHttpRequest.nativeOnRecvMessage(l10, n10, byArray);
    }

    public static byte[] getHttpPostRsp(Map object, String object2, byte[] object3) {
        Object object4 = new StringBuilder();
        ((StringBuilder)object4).append("getHttpPostRsp->request: ");
        ((StringBuilder)object4).append((String)object2);
        object4 = ((StringBuilder)object4).toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)object4);
        object4 = new StringBuilder();
        ((StringBuilder)object4).append("getHttpPostRsp->data size: ");
        int n10 = ((byte[])object3).length;
        ((StringBuilder)object4).append(n10);
        object4 = ((StringBuilder)object4).toString();
        TXCLog.i(string2, (String)object4);
        String string3 = " ";
        String string4 = "%20";
        object2 = ((String)object2).replace(string3, string4);
        object4 = new URL((String)object2);
        object2 = (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(((URL)object4).openConnection()));
        int n11 = 1;
        ((URLConnection)object2).setDoInput(n11 != 0);
        ((URLConnection)object2).setDoOutput(n11 != 0);
        n11 = 5000;
        ((URLConnection)object2).setConnectTimeout(n11);
        ((URLConnection)object2).setReadTimeout(n11);
        object4 = "POST";
        ((HttpURLConnection)object2).setRequestMethod((String)object4);
        if (object != null) {
            object = object.entrySet().iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object4 = object.next();
                string3 = (String)object4.getKey();
                object4 = (String)object4.getValue();
                ((URLConnection)object2).setRequestProperty(string3, (String)object4);
            }
        }
        object4 = ((URLConnection)object2).getOutputStream();
        object = new DataOutputStream((OutputStream)object4);
        ((FilterOutputStream)object).write((byte[])object3);
        ((DataOutputStream)object).flush();
        ((FilterOutputStream)object).close();
        int n12 = ((HttpURLConnection)object2).getResponseCode();
        n11 = 200;
        if (n12 == n11) {
            object = ((URLConnection)object2).getInputStream();
            object4 = new ByteArrayOutputStream();
            while (true) {
                int n13;
                n10 = ((byte[])object3).length;
                string4 = null;
                if ((n10 = ((InputStream)object).read((byte[])object3, 0, n10)) == (n13 = -1)) break;
                ((ByteArrayOutputStream)object4).write((byte[])object3, 0, n10);
            }
            ((OutputStream)object4).flush();
            ((InputStream)object).close();
            ((HttpURLConnection)object2).disconnect();
            object = new StringBuilder();
            ((StringBuilder)object).append("getHttpsPostRsp->rsp size: ");
            int n14 = ((ByteArrayOutputStream)object4).size();
            ((StringBuilder)object).append(n14);
            object = ((StringBuilder)object).toString();
            TXCLog.i(string2, (String)object);
            return ((ByteArrayOutputStream)object4).toByteArray();
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("getHttpPostRsp->response code: ");
        ((StringBuilder)object2).append(n12);
        object2 = ((StringBuilder)object2).toString();
        TXCLog.i(string2, (String)object2);
        object3 = new StringBuilder;
        ((StringBuilder)object3)();
        ((StringBuilder)object3).append("response: ");
        ((StringBuilder)object3).append(n12);
        object = ((StringBuilder)object3).toString();
        object2 = new Exception((String)object);
        throw object2;
    }

    public static byte[] getHttpsPostRsp(Map object, String object2, byte[] object3) {
        Object object4 = new StringBuilder();
        ((StringBuilder)object4).append("getHttpsPostRsp->request: ");
        ((StringBuilder)object4).append((String)object2);
        object4 = ((StringBuilder)object4).toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)object4);
        object4 = new StringBuilder();
        ((StringBuilder)object4).append("getHttpsPostRsp->data: ");
        int n10 = ((byte[])object3).length;
        ((StringBuilder)object4).append(n10);
        object4 = ((StringBuilder)object4).toString();
        TXCLog.i(string2, (String)object4);
        String string3 = " ";
        String string4 = "%20";
        object2 = ((String)object2).replace(string3, string4);
        object4 = new URL((String)object2);
        object2 = (HttpsURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(((URL)object4).openConnection()));
        int n11 = 1;
        ((URLConnection)object2).setDoInput(n11 != 0);
        ((URLConnection)object2).setDoOutput(n11 != 0);
        n11 = 5000;
        ((URLConnection)object2).setConnectTimeout(n11);
        ((URLConnection)object2).setReadTimeout(n11);
        object4 = "POST";
        ((HttpURLConnection)object2).setRequestMethod((String)object4);
        if (object != null) {
            object = object.entrySet().iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object4 = object.next();
                string3 = (String)object4.getKey();
                object4 = (String)object4.getValue();
                ((URLConnection)object2).setRequestProperty(string3, (String)object4);
            }
        }
        object4 = ((URLConnection)object2).getOutputStream();
        object = new DataOutputStream((OutputStream)object4);
        ((FilterOutputStream)object).write((byte[])object3);
        ((DataOutputStream)object).flush();
        ((FilterOutputStream)object).close();
        int n12 = ((HttpURLConnection)object2).getResponseCode();
        n11 = 200;
        if (n12 == n11) {
            object = ((URLConnection)object2).getInputStream();
            object4 = new ByteArrayOutputStream();
            while (true) {
                int n13;
                n10 = ((byte[])object3).length;
                string4 = null;
                if ((n10 = ((InputStream)object).read((byte[])object3, 0, n10)) == (n13 = -1)) break;
                ((ByteArrayOutputStream)object4).write((byte[])object3, 0, n10);
            }
            ((OutputStream)object4).flush();
            ((InputStream)object).close();
            ((HttpURLConnection)object2).disconnect();
            object = new StringBuilder();
            ((StringBuilder)object).append("getHttpsPostRsp->rsp size: ");
            int n14 = ((ByteArrayOutputStream)object4).size();
            ((StringBuilder)object).append(n14);
            object = ((StringBuilder)object).toString();
            TXCLog.i(string2, (String)object);
            return ((ByteArrayOutputStream)object4).toByteArray();
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("getHttpsPostRsp->response code: ");
        ((StringBuilder)object2).append(n12);
        object2 = ((StringBuilder)object2).toString();
        TXCLog.i(string2, (String)object2);
        object3 = new StringBuilder;
        ((StringBuilder)object3)();
        ((StringBuilder)object3).append("response: ");
        ((StringBuilder)object3).append(n12);
        object = ((StringBuilder)object3).toString();
        object2 = new Exception((String)object);
        throw object2;
    }

    private native void nativeOnRecvMessage(long var1, int var3, byte[] var4);

    public void asyncPostRequest(Map object, byte[] byArray, byte[] byArray2) {
        TXHttpRequest$a tXHttpRequest$a = new TXHttpRequest$a(this, (Map)object);
        object = new byte[2][];
        object[0] = byArray;
        object[1] = byArray2;
        tXHttpRequest$a.execute((Object[])object);
    }

    public int sendHttpsRequest(String object, byte[] byArray) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("sendHttpsRequest->enter action: ");
        charSequence.append((String)object);
        charSequence.append(", data size: ");
        int n10 = byArray.length;
        charSequence.append(n10);
        charSequence = charSequence.toString();
        TXCLog.i("TXHttpRequest", (String)charSequence);
        object = ((String)object).getBytes();
        this.asyncPostRequest(null, (byte[])object, byArray);
        return 0;
    }

    public int sendHttpsRequest(Map map, String object, byte[] byArray) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("sendHttpsRequest->enter action: ");
        charSequence.append((String)object);
        charSequence.append(", data size: ");
        int n10 = byArray.length;
        charSequence.append(n10);
        charSequence = charSequence.toString();
        TXCLog.i("TXHttpRequest", (String)charSequence);
        object = ((String)object).getBytes();
        this.asyncPostRequest(map, (byte[])object, byArray);
        return 0;
    }
}

