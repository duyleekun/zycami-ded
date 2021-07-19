/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.alibaba.sdk.android.oss.common.utils;

import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.HttpdnsMini;
import com.alibaba.sdk.android.oss.common.utils.HttpdnsMini$HostObject;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public class HttpdnsMini$QueryHostTask
implements Callable {
    private boolean hasRetryed = false;
    private String hostName;
    public final /* synthetic */ HttpdnsMini this$0;

    public HttpdnsMini$QueryHostTask(HttpdnsMini httpdnsMini, String string2) {
        this.this$0 = httpdnsMini;
        this.hostName = string2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String call() {
        Object object;
        Object object2;
        block23: {
            int n10;
            Object object3;
            block25: {
                int n11;
                block24: {
                    block22: {
                        int n12;
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("http://");
                        ((StringBuilder)object2).append("203.107.1.1");
                        ((StringBuilder)object2).append("/");
                        ((StringBuilder)object2).append("181345");
                        ((StringBuilder)object2).append("/d?host=");
                        object = this.hostName;
                        ((StringBuilder)object2).append((String)object);
                        object2 = ((StringBuilder)object2).toString();
                        object = new StringBuilder();
                        object3 = "[httpdnsmini] - buildUrl: ";
                        ((StringBuilder)object).append((String)object3);
                        ((StringBuilder)object).append((String)object2);
                        OSSLog.logDebug(((StringBuilder)object).toString());
                        object = null;
                        object3 = new URL((String)object2);
                        object2 = ((URL)object3).openConnection();
                        object2 = FirebasePerfUrlConnection.instrument(object2);
                        object2 = (URLConnection)object2;
                        object2 = (HttpURLConnection)object2;
                        int n13 = 10000;
                        ((URLConnection)object2).setConnectTimeout(n13);
                        ((URLConnection)object2).setReadTimeout(n13);
                        n13 = ((HttpURLConnection)object2).getResponseCode();
                        n11 = 200;
                        if (n13 != n11) {
                            object3 = new StringBuilder();
                            String string2 = "[httpdnsmini] - responseCodeNot 200, but: ";
                            ((StringBuilder)object3).append(string2);
                            n10 = ((HttpURLConnection)object2).getResponseCode();
                            ((StringBuilder)object3).append(n10);
                            object2 = ((StringBuilder)object3).toString();
                            OSSLog.logError((String)object2);
                            n10 = 0;
                            object2 = null;
                            break block22;
                        }
                        object2 = ((URLConnection)object2).getInputStream();
                        String string3 = "UTF-8";
                        Object object4 = new InputStreamReader((InputStream)object2, string3);
                        object3 = new BufferedReader((Reader)object4);
                        object4 = new StringBuilder();
                        while ((string3 = ((BufferedReader)object3).readLine()) != null) {
                            ((StringBuilder)object4).append(string3);
                        }
                        object4 = ((StringBuilder)object4).toString();
                        object3 = new JSONObject((String)object4);
                        object4 = "host";
                        object4 = object3.getString((String)object4);
                        string3 = "ttl";
                        long l10 = object3.getLong(string3);
                        Object object5 = "ips";
                        object3 = object3.getJSONArray((String)object5);
                        object5 = new StringBuilder();
                        Object object6 = "[httpdnsmini] - ips:";
                        ((StringBuilder)object5).append((String)object6);
                        object6 = object3.toString();
                        ((StringBuilder)object5).append((String)object6);
                        object5 = ((StringBuilder)object5).toString();
                        OSSLog.logDebug((String)object5);
                        if (object4 == null || object3 == null || (n12 = object3.length()) <= 0) break block22;
                        long l11 = 0L;
                        long l12 = l10 - l11;
                        n12 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                        if (n12 == 0) {
                            l10 = 30;
                        }
                        object6 = this.this$0;
                        object5 = new HttpdnsMini$HostObject((HttpdnsMini)object6);
                        if (object3 == null) {
                            n13 = 0;
                            object3 = null;
                        } else {
                            object6 = null;
                            object3 = object3.getString(0);
                        }
                        ((HttpdnsMini$HostObject)object5).setHostName((String)object4);
                        ((HttpdnsMini$HostObject)object5).setTtl(l10);
                        ((HttpdnsMini$HostObject)object5).setIp((String)object3);
                        long l13 = System.currentTimeMillis();
                        long l14 = 1000L;
                        ((HttpdnsMini$HostObject)object5).setQueryTime(l13 /= l14);
                        object4 = new StringBuilder();
                        string3 = "[httpdnsmini] - resolve result:";
                        ((StringBuilder)object4).append(string3);
                        string3 = ((HttpdnsMini$HostObject)object5).toString();
                        ((StringBuilder)object4).append(string3);
                        object4 = ((StringBuilder)object4).toString();
                        OSSLog.logDebug((String)object4);
                        object4 = this.this$0;
                        object4 = HttpdnsMini.access$000((HttpdnsMini)object4);
                        n11 = object4.size();
                        int n14 = 100;
                        if (n11 < n14) {
                            object4 = this.this$0;
                            object4 = HttpdnsMini.access$000((HttpdnsMini)object4);
                            string3 = this.hostName;
                            object4.put(string3, object5);
                        }
                        if (object2 == null) return object3;
                        try {
                            ((InputStream)object2).close();
                            return object3;
                        }
                        catch (IOException iOException) {
                            iOException.printStackTrace();
                        }
                        return object3;
                    }
                    if (object2 == null) break block25;
                    ((InputStream)object2).close();
                    catch (Throwable throwable) {
                        object = object2;
                        object2 = throwable;
                        break block23;
                    }
                    catch (Exception exception) {
                        object3 = object2;
                        object2 = exception;
                        break block24;
                    }
                    catch (Throwable throwable) {
                        break block23;
                    }
                    catch (Exception exception) {
                        boolean bl2 = false;
                        object3 = null;
                    }
                }
                n11 = OSSLog.isEnableLog();
                if (n11 != 0) {
                    ((Throwable)object2).printStackTrace();
                    OSSLog.logThrowable2Local((Throwable)object2);
                }
                if (object3 == null) break block25;
                try {
                    ((InputStream)object3).close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            if ((n10 = this.hasRetryed) != 0) return null;
            this.hasRetryed = true;
            return this.call();
            catch (Throwable throwable) {
                object = object3;
            }
        }
        if (object == null) throw object2;
        try {
            ((InputStream)object).close();
            throw object2;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        throw object2;
    }
}

