/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.kwai.opensdk.sdk.utils;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.kwai.opensdk.sdk.utils.LogUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class NetworkUtil {
    private static String buildFrom(Map map) {
        boolean bl2;
        if (map == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator2 = map.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = (String)iterator2.next();
            String string3 = (String)map.get(string2);
            if (string3 == null) continue;
            stringBuilder.append(string2);
            stringBuilder.append("=");
            string2 = "UTF-8";
            string2 = URLEncoder.encode(string3, string2);
            try {
                stringBuilder.append(string2);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                string2 = unsupportedEncodingException.getMessage();
                string3 = "NetworkUtil";
                LogUtil.e(string3, string2);
            }
            string2 = "&";
            stringBuilder.append(string2);
        }
        int n10 = stringBuilder.length() + -1;
        stringBuilder.deleteCharAt(n10);
        return stringBuilder.toString();
    }

    private static String buildJson(Map map) {
        int n10;
        if (map != null && (n10 = map.size()) != 0) {
            JSONObject jSONObject;
            block12: {
                jSONObject = new JSONObject();
                Object object = map.keySet();
                try {
                    object = object.iterator();
                }
                catch (Exception exception) {}
                while (true) {
                    boolean bl2 = object.hasNext();
                    if (!bl2) break block12;
                    break;
                }
                {
                    Object object2 = object.next();
                    object2 = (String)object2;
                    Object object3 = map.get(object2);
                    object3 = (String)object3;
                    if (object3 == null) continue;
                    object3 = map.get(object2);
                    jSONObject.put(object2, object3);
                    continue;
                }
            }
            return jSONObject.toString();
        }
        return null;
    }

    private static String buildUrl(String object, Map map) {
        boolean bl2;
        if (map == null) {
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder((String)((Object)object));
        String string2 = "?";
        boolean n10 = ((String)((Object)object)).contains(string2);
        String string3 = "&";
        if (n10) {
            stringBuilder.append(string3);
        } else {
            stringBuilder.append(string2);
        }
        object = map.keySet().iterator();
        while (bl2 = object.hasNext()) {
            string2 = (String)object.next();
            String string4 = (String)map.get(string2);
            if (string4 == null) continue;
            stringBuilder.append(string2);
            stringBuilder.append("=");
            string2 = "UTF-8";
            string2 = URLEncoder.encode(string4, string2);
            try {
                stringBuilder.append(string2);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                string2 = unsupportedEncodingException.getMessage();
                string4 = "NetworkUtil";
                LogUtil.e(string4, string2);
            }
            stringBuilder.append(string3);
        }
        int n11 = stringBuilder.length() + -1;
        stringBuilder.deleteCharAt(n11);
        return stringBuilder.toString();
    }

    public static String get(String string2, Map map, Map map2) {
        return NetworkUtil.request(string2, map, null, true, false, map2);
    }

    public static String postData(String string2, Map map, String string3, Map map2) {
        return NetworkUtil.request(string2, map, string3, false, false, map2);
    }

    public static String postFormJSON(String string2, Map map, Map map2) {
        String string3 = NetworkUtil.buildJson(map);
        return NetworkUtil.request(string2, null, string3, false, false, map2);
    }

    public static String postFrom(String string2, Map map, Map map2) {
        String string3 = NetworkUtil.buildFrom(map);
        return NetworkUtil.request(string2, null, string3, false, true, map2);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String request(String object, Map object2, String object3, boolean bl2, boolean bl3, Map map) {
        block55: {
            block56: {
                block54: {
                    String string2;
                    String string3;
                    block50: {
                        block53: {
                            block49: {
                                block52: {
                                    block48: {
                                        block51: {
                                            block47: {
                                                block46: {
                                                    Object object4;
                                                    string3 = "NetworkUtil";
                                                    object = NetworkUtil.buildUrl((String)object, (Map)object2);
                                                    Object object5 = new URL((String)object);
                                                    object = ((URL)object5).openConnection();
                                                    object = FirebasePerfUrlConnection.instrument(object);
                                                    object = (URLConnection)object;
                                                    object = (HttpURLConnection)object;
                                                    boolean bl4 = 5000 != 0;
                                                    ((URLConnection)object).setReadTimeout((int)(bl4 ? 1 : 0));
                                                    bl4 = 10000 != 0;
                                                    ((URLConnection)object).setConnectTimeout((int)(bl4 ? 1 : 0));
                                                    if (map != null && (bl4 = map.size()) > false) {
                                                        boolean bl5;
                                                        object2 = map.keySet();
                                                        object2 = object2.iterator();
                                                        while (bl5 = object2.hasNext()) {
                                                            object5 = object2.next();
                                                            object5 = (String)object5;
                                                            Object object6 = map.get(object5);
                                                            object6 = (String)object6;
                                                            ((URLConnection)object).setRequestProperty((String)object5, (String)object6);
                                                        }
                                                    }
                                                    if (!bl2) {
                                                        object2 = "Content-Type";
                                                        if (!bl3) {
                                                            object4 = "application/json; charset=utf-8";
                                                            ((URLConnection)object).setRequestProperty((String)object2, (String)object4);
                                                        } else {
                                                            object4 = "application/x-www-form-urlencoded; charset=utf-8";
                                                            ((URLConnection)object).setRequestProperty((String)object2, (String)object4);
                                                        }
                                                        object2 = "POST";
                                                        ((HttpURLConnection)object).setRequestMethod((String)object2);
                                                        bl4 = true;
                                                        ((URLConnection)object).setDoOutput(bl4);
                                                        object2 = ((URLConnection)object).getOutputStream();
                                                        object3 = ((String)object3).getBytes();
                                                        ((OutputStream)object2).write((byte[])object3);
                                                        ((OutputStream)object2).flush();
                                                        ((OutputStream)object2).close();
                                                    } else {
                                                        object2 = "GET";
                                                        ((HttpURLConnection)object).setRequestMethod((String)object2);
                                                    }
                                                    bl4 = ((HttpURLConnection)object).getResponseCode();
                                                    int n10 = 200;
                                                    if (bl4 != n10) break block46;
                                                    object2 = ((URLConnection)object).getInputStream();
                                                    object4 = new InputStreamReader((InputStream)object2);
                                                    object3 = new BufferedReader((Reader)object4);
                                                    object2 = new StringBuffer();
                                                    while ((object4 = ((BufferedReader)object3).readLine()) != null) {
                                                        ((StringBuffer)object2).append((String)object4);
                                                    }
                                                    object2 = ((StringBuffer)object2).toString();
                                                    try {
                                                        ((BufferedReader)object3).close();
                                                    }
                                                    catch (IOException iOException) {
                                                        object3 = iOException.getMessage();
                                                        LogUtil.e(string3, (String)object3);
                                                    }
                                                    if (object != null) {
                                                        ((HttpURLConnection)object).disconnect();
                                                    }
                                                    return object2;
                                                    catch (Throwable throwable) {
                                                        break block47;
                                                    }
                                                    catch (Exception exception) {
                                                        break block48;
                                                    }
                                                    catch (IOException iOException) {
                                                        break block49;
                                                    }
                                                    catch (MalformedURLException malformedURLException) {
                                                        break block50;
                                                    }
                                                }
                                                if (object != null) {
                                                    ((HttpURLConnection)object).disconnect();
                                                }
                                                return null;
                                                catch (Throwable throwable) {
                                                    boolean bl6 = false;
                                                    object3 = null;
                                                    break block47;
                                                }
                                                catch (Exception exception) {
                                                    boolean bl7 = false;
                                                    object3 = null;
                                                    break block48;
                                                }
                                                catch (IOException iOException) {
                                                    boolean bl8 = false;
                                                    object3 = null;
                                                    break block49;
                                                }
                                                catch (MalformedURLException malformedURLException) {
                                                    boolean bl9 = false;
                                                    object3 = null;
                                                    break block50;
                                                }
                                                catch (Throwable throwable) {
                                                    object = null;
                                                    boolean bl10 = false;
                                                    object3 = null;
                                                }
                                            }
                                            try {
                                                string2 = ((Throwable)((Object)string2)).getMessage();
                                                LogUtil.e(string3, string2);
                                                if (object3 == null) break block51;
                                            }
                                            catch (Throwable throwable) {
                                                if (object3 != null) {
                                                    try {
                                                        ((BufferedReader)object3).close();
                                                    }
                                                    catch (IOException iOException) {
                                                        object3 = iOException.getMessage();
                                                        LogUtil.e(string3, (String)object3);
                                                    }
                                                }
                                                if (object != null) {
                                                    ((HttpURLConnection)object).disconnect();
                                                }
                                                throw throwable;
                                            }
                                            try {
                                                ((BufferedReader)object3).close();
                                            }
                                            catch (IOException iOException) {
                                                string2 = iOException.getMessage();
                                                LogUtil.e(string3, string2);
                                            }
                                        }
                                        if (object == null) break block55;
                                        break block56;
                                        catch (Exception exception) {
                                            object = null;
                                            boolean bl11 = false;
                                            object3 = null;
                                        }
                                    }
                                    string2 = ((Throwable)((Object)string2)).getMessage();
                                    LogUtil.e(string3, string2);
                                    if (object3 == null) break block52;
                                    try {
                                        ((BufferedReader)object3).close();
                                    }
                                    catch (IOException iOException) {
                                        string2 = iOException.getMessage();
                                        LogUtil.e(string3, string2);
                                    }
                                }
                                if (object == null) break block55;
                                break block56;
                                catch (IOException iOException) {
                                    object = null;
                                    boolean bl12 = false;
                                    object3 = null;
                                }
                            }
                            string2 = ((Throwable)((Object)string2)).getMessage();
                            LogUtil.e(string3, string2);
                            if (object3 == null) break block53;
                            try {
                                ((BufferedReader)object3).close();
                            }
                            catch (IOException iOException) {
                                string2 = iOException.getMessage();
                                LogUtil.e(string3, string2);
                            }
                        }
                        if (object == null) break block55;
                        break block56;
                        catch (MalformedURLException malformedURLException) {
                            object = null;
                            boolean bl13 = false;
                            object3 = null;
                        }
                    }
                    string2 = ((Throwable)((Object)string2)).getMessage();
                    LogUtil.e(string3, string2);
                    if (object3 == null) break block54;
                    try {
                        ((BufferedReader)object3).close();
                    }
                    catch (IOException iOException) {
                        string2 = iOException.getMessage();
                        LogUtil.e(string3, string2);
                    }
                }
                if (object == null) break block55;
            }
            ((HttpURLConnection)object).disconnect();
        }
        return null;
    }
}

