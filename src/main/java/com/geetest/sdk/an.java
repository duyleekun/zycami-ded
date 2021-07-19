/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.ai;
import com.geetest.sdk.am;
import com.geetest.sdk.ao;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class an
extends ao {
    private final Map c;
    private String d;
    private am e;

    public an() {
        HashMap hashMap;
        this.c = hashMap = new HashMap();
    }

    public static void a(HttpURLConnection iterator2) {
        int n10;
        if (iterator2 != null && (iterator2 = ((URLConnection)((Object)iterator2)).getRequestProperties()) != null && (n10 = iterator2.size()) > 0) {
            iterator2 = iterator2.entrySet().iterator();
            while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                int n11;
                Object object = iterator2.next();
                String string2 = (String)object.getKey();
                object = (List)object.getValue();
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = null;
                for (int i10 = 0; i10 < (n11 = object.size()); ++i10) {
                    CharSequence charSequence = new StringBuilder();
                    String string4 = (String)object.get(i10);
                    charSequence.append(string4);
                    string4 = ",";
                    charSequence.append(string4);
                    charSequence = charSequence.toString();
                    stringBuilder.append((String)charSequence);
                }
                object = new StringBuilder();
                string3 = "Header key: ";
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(" value: ");
                string2 = stringBuilder.toString();
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
                ai.a((String)object);
            }
        }
    }

    private boolean a(File file, Map map, String string2) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            return false;
        }
        return this.a(string2, fileInputStream, map);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(String object, InputStream object2, Map object3) {
        Object object4;
        Object object5;
        block59: {
            boolean bl2;
            int n10;
            int n11;
            Object object6;
            block67: {
                block68: {
                    int n12;
                    block65: {
                        block66: {
                            block64: {
                                void var6_27;
                                block63: {
                                    byte[] byArray;
                                    block62: {
                                        Object object7;
                                        block61: {
                                            int n13;
                                            block58: {
                                                block60: {
                                                    object6 = new StringBuilder();
                                                    ((StringBuilder)object6).append("REQUEST URL: ");
                                                    ((StringBuilder)object6).append((String)object);
                                                    object6 = ((StringBuilder)object6).toString();
                                                    ai.a((String)object6);
                                                    n11 = 2048;
                                                    byArray = new byte[n11];
                                                    n10 = 2;
                                                    bl2 = true;
                                                    n12 = -1;
                                                    object5 = null;
                                                    object7 = new URL((String)object);
                                                    object = ((URL)object7).openConnection();
                                                    object = FirebasePerfUrlConnection.instrument(object);
                                                    object = (URLConnection)object;
                                                    object = (HttpURLConnection)object;
                                                    object3 = object3.entrySet();
                                                    object3 = object3.iterator();
                                                    while ((n13 = object3.hasNext()) != 0) {
                                                        object7 = object3.next();
                                                        object7 = (Map.Entry)object7;
                                                        object4 = object7.getKey();
                                                        object4 = (String)object4;
                                                        object7 = object7.getValue();
                                                        object7 = (String)object7;
                                                        ((URLConnection)object).addRequestProperty((String)object4, (String)object7);
                                                    }
                                                    int n14 = 15000;
                                                    ((URLConnection)object).setReadTimeout(n14);
                                                    ((URLConnection)object).setConnectTimeout(n14);
                                                    ((URLConnection)object).setDoInput(bl2);
                                                    ((URLConnection)object).setDoOutput(bl2);
                                                    object3 = "POST";
                                                    ((HttpURLConnection)object).setRequestMethod((String)object3);
                                                    an.a((HttpURLConnection)object);
                                                    object3 = ((URLConnection)object).getOutputStream();
                                                    object7 = new ByteArrayOutputStream(n11);
                                                    break block58;
                                                    catch (Throwable throwable) {
                                                        object4 = null;
                                                        break block59;
                                                    }
                                                    catch (Exception exception) {
                                                        n11 = 0;
                                                        object6 = null;
                                                        break block60;
                                                    }
                                                    catch (Throwable throwable) {
                                                        object = null;
                                                        object4 = null;
                                                        break block59;
                                                    }
                                                    catch (Exception exception) {
                                                        object = null;
                                                        n11 = 0;
                                                        object6 = null;
                                                    }
                                                }
                                                object4 = null;
                                                break block66;
                                            }
                                            while ((n11 = ((InputStream)object2).read(byArray)) != n12) {
                                                ((ByteArrayOutputStream)object7).write(byArray, 0, n11);
                                            }
                                            object6 = ((ByteArrayOutputStream)object7).toByteArray();
                                            ((ByteArrayOutputStream)object7).close();
                                            ((OutputStream)object3).write((byte[])object6);
                                            ((OutputStream)object3).flush();
                                            n11 = ((HttpURLConnection)object).getResponseCode();
                                            try {
                                                n13 = n11 / 100;
                                                if (n13 == n10) {
                                                    object7 = new ByteArrayOutputStream();
                                                    object4 = ((URLConnection)object).getInputStream();
                                                    break block61;
                                                }
                                                byArray = null;
                                                break block62;
                                            }
                                            catch (Exception exception) {
                                                n12 = n11;
                                                object4 = null;
                                                break block63;
                                            }
                                            {
                                                catch (Throwable throwable) {
                                                    object4 = null;
                                                    break block64;
                                                }
                                            }
                                            catch (Throwable throwable) {
                                                try {
                                                    ((ByteArrayOutputStream)object7).close();
                                                    throw throwable;
                                                }
                                                catch (Exception exception) {
                                                    object4 = null;
                                                    Exception exception2 = exception;
                                                    object6 = object3;
                                                    object3 = exception2;
                                                }
                                            }
                                            break block66;
                                        }
                                        try {
                                            int n15;
                                            while ((n15 = ((InputStream)object4).read(byArray)) != n12) {
                                                ((ByteArrayOutputStream)object7).write(byArray, 0, n15);
                                            }
                                            byArray = ((ByteArrayOutputStream)object7).toByteArray();
                                            object5 = object4;
                                        }
                                        catch (Throwable throwable) {
                                            break block64;
                                        }
                                        catch (Exception exception) {
                                            n12 = n11;
                                            break block63;
                                        }
                                    }
                                    if (object3 != null) {
                                        try {
                                            ((OutputStream)object3).close();
                                        }
                                        catch (IOException iOException) {
                                            iOException.printStackTrace();
                                        }
                                    }
                                    if (object5 != null) {
                                        try {
                                            ((InputStream)object5).close();
                                        }
                                        catch (IOException iOException) {
                                            iOException.printStackTrace();
                                        }
                                    }
                                    if (object2 != null) {
                                        try {
                                            ((InputStream)object2).close();
                                        }
                                        catch (IOException iOException) {
                                            iOException.printStackTrace();
                                        }
                                    }
                                    object5 = byArray;
                                    if (object == null) break block67;
                                    break block68;
                                }
                                object6 = object3;
                                object3 = var6_27;
                                break block66;
                            }
                            object5 = object3;
                            object3 = object6;
                            break block59;
                        }
                        ((Throwable)object3).printStackTrace();
                        if (object6 == null) break block65;
                        try {
                            ((OutputStream)object6).close();
                        }
                        catch (IOException iOException) {
                            iOException.printStackTrace();
                        }
                    }
                    if (object4 != null) {
                        try {
                            ((InputStream)object4).close();
                        }
                        catch (IOException iOException) {
                            iOException.printStackTrace();
                        }
                    }
                    if (object2 != null) {
                        try {
                            ((InputStream)object2).close();
                        }
                        catch (IOException iOException) {
                            iOException.printStackTrace();
                        }
                    }
                    n11 = n12;
                    if (object == null) break block67;
                }
                ((HttpURLConnection)object).disconnect();
            }
            object = new StringBuilder();
            object2 = "log send completed, http statusCode : ";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(n11);
            object = ((StringBuilder)object).toString();
            ai.a((String)object);
            if (object5 == null) {
                object = "response data null";
                ai.a((String)object);
            } else {
                object = new StringBuilder();
                ((StringBuilder)object).append("response data : ");
                object2 = new String((byte[])object5);
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
                ai.a((String)object);
            }
            object = this.e;
            if (object != null) {
                object.a(n11, (byte[])object5);
            }
            if ((n11 /= 100) != n10) return false;
            return bl2;
            catch (Throwable throwable) {
                object5 = object6;
            }
        }
        if (object5 != null) {
            try {
                ((OutputStream)object5).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        if (object4 != null) {
            try {
                ((InputStream)object4).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        if (object2 != null) {
            try {
                ((InputStream)object2).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        if (object == null) throw object3;
        ((HttpURLConnection)object).disconnect();
        throw object3;
    }

    public void a(am am2) {
        this.e = am2;
    }

    public void a(File file) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("filename: ");
        Object object2 = file.getAbsoluteFile();
        ((StringBuilder)object).append(object2);
        ai.a(((StringBuilder)object).toString());
        object = this.c;
        object2 = this.d;
        boolean bl2 = this.a(file, (Map)object, (String)object2);
        this.a();
        if (bl2) {
            file.delete();
        }
    }

    public void a(String string2) {
        this.d = string2;
    }

    public void a(Map map) {
        Map map2 = this.c;
        map2.clear();
        if (map != null) {
            map2 = this.c;
            map2.putAll(map);
        }
    }
}

