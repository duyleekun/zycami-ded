/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.hms.framework.common;

import android.text.TextUtils;
import com.huawei.hms.framework.common.StringUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;

public class ExceptionCode {
    public static final int CANCEL = 1104;
    private static final String CONNECT = "connect";
    public static final int CONNECTION_ABORT = 110205;
    public static final int CONNECTION_REFUSED = 110209;
    public static final int CONNECTION_RESET = 110204;
    public static final int CONNECT_FAILED = 110206;
    public static final int CRASH_EXCEPTION = 1103;
    public static final int INTERRUPT_CONNECT_CLOSE = 110214;
    public static final int INTERRUPT_EXCEPTION = 110213;
    public static final int NETWORK_CHANGED = 110216;
    public static final int NETWORK_IO_EXCEPTION = 1102;
    public static final int NETWORK_UNREACHABLE = 110208;
    public static final int PROTOCOL_ERROR = 110217;
    private static final String READ = "read";
    public static final int READ_ERROR = 110203;
    public static final int ROUTE_FAILED = 110207;
    public static final int SHUTDOWN_EXCEPTION = 110218;
    public static final int SOCKET_CLOSE = 110215;
    public static final int SOCKET_CONNECT_TIMEOUT = 110221;
    public static final int SOCKET_READ_TIMEOUT = 110223;
    public static final int SOCKET_TIMEOUT = 110200;
    public static final int SOCKET_WRITE_TIMEOUT = 110225;
    public static final int SSL_HANDSHAKE_EXCEPTION = 110211;
    public static final int SSL_PEERUNVERIFIED_EXCEPTION = 110212;
    public static final int SSL_PROTOCOL_EXCEPTION = 110210;
    public static final int UNABLE_TO_RESOLVE_HOST = 110202;
    public static final int UNEXPECTED_EOF = 110201;
    private static final String WRITE = "write";

    private static String checkExceptionContainsKey(Exception stackTraceElementArray, String ... stringArray) {
        String string2 = ExceptionCode.checkStrContainsKey(StringUtils.toLowerCase(stackTraceElementArray.getMessage()), stringArray);
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 == 0) {
            return string2;
        }
        stackTraceElementArray = stackTraceElementArray.getStackTrace();
        n10 = stackTraceElementArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            string2 = ExceptionCode.checkStrContainsKey(StringUtils.toLowerCase(stackTraceElementArray[i10].toString()), stringArray);
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) continue;
            return string2;
        }
        return string2;
    }

    private static String checkStrContainsKey(String string2, String ... stringArray) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = "";
        if (n10 != 0) {
            return string3;
        }
        for (String string4 : stringArray) {
            boolean bl2 = string2.contains(string4);
            if (!bl2) continue;
            return string4;
        }
        return string3;
    }

    public static int getErrorCodeFromException(Exception object) {
        int n10 = 1102;
        if (object == null) {
            return n10;
        }
        boolean bl2 = object instanceof IOException;
        if (!bl2) {
            return 1103;
        }
        String string2 = ((Throwable)object).getMessage();
        if (string2 == null) {
            return n10;
        }
        int n11 = ExceptionCode.getErrorCodeFromMsg(string2 = StringUtils.toLowerCase(string2));
        if (n11 != n10) {
            return n11;
        }
        n10 = object instanceof SocketTimeoutException;
        if (n10 != 0) {
            return ExceptionCode.getErrorCodeSocketTimeout((Exception)object);
        }
        n10 = object instanceof ConnectException;
        if (n10 != 0) {
            return 110206;
        }
        n10 = object instanceof NoRouteToHostException;
        if (n10 != 0) {
            return 110207;
        }
        n10 = object instanceof SSLProtocolException;
        if (n10 != 0) {
            return 110210;
        }
        n10 = object instanceof SSLHandshakeException;
        if (n10 != 0) {
            return 110211;
        }
        n10 = object instanceof SSLPeerUnverifiedException;
        if (n10 != 0) {
            return 110212;
        }
        n10 = object instanceof UnknownHostException;
        if (n10 != 0) {
            return 110202;
        }
        boolean bl3 = object instanceof InterruptedIOException;
        if (bl3) {
            object = "connection has been shut down";
            bl3 = string2.contains((CharSequence)object);
            if (bl3) {
                return 110214;
            }
            return 110213;
        }
        return n11;
    }

    private static int getErrorCodeFromMsg(String string2) {
        int n10;
        String string3 = "unexpected end of stream";
        boolean bl2 = string2.contains(string3);
        if (bl2) {
            n10 = 110201;
        } else {
            string3 = "unable to resolve host";
            bl2 = string2.contains(string3);
            if (bl2) {
                n10 = 110202;
            } else {
                string3 = "read error";
                bl2 = string2.contains(string3);
                if (bl2) {
                    n10 = 110203;
                } else {
                    string3 = "connection reset";
                    bl2 = string2.contains(string3);
                    if (bl2) {
                        n10 = 110204;
                    } else {
                        string3 = "software caused connection abort";
                        bl2 = string2.contains(string3);
                        if (bl2) {
                            n10 = 110205;
                        } else {
                            string3 = "failed to connect to";
                            bl2 = string2.contains(string3);
                            if (bl2) {
                                n10 = 110206;
                            } else {
                                string3 = "connection refused";
                                bl2 = string2.contains(string3);
                                if (bl2) {
                                    n10 = 110209;
                                } else {
                                    string3 = "connection timed out";
                                    bl2 = string2.contains(string3);
                                    if (bl2) {
                                        return 110221;
                                    }
                                    string3 = "no route to host";
                                    bl2 = string2.contains(string3);
                                    n10 = bl2 ? 110207 : ((bl2 = string2.contains(string3 = "network is unreachable")) ? 110208 : ((n10 = (int)(string2.contains(string3 = "socket closed") ? 1 : 0)) != 0 ? 110215 : 1102));
                                }
                            }
                        }
                    }
                }
            }
        }
        return n10;
    }

    private static int getErrorCodeSocketTimeout(Exception object) {
        String string2 = CONNECT;
        String string3 = READ;
        String string4 = WRITE;
        String[] stringArray = new String[]{string2, string3, string4};
        object = ExceptionCode.checkExceptionContainsKey((Exception)object, stringArray);
        ((String)object).hashCode();
        int n10 = ((String)object).hashCode();
        int n11 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 951351530: {
                boolean bl2 = ((String)object).equals(string2);
                if (!bl2) break;
                n11 = 2;
                break;
            }
            case 113399775: {
                boolean bl3 = ((String)object).equals(string4);
                if (!bl3) break;
                n11 = 1;
                break;
            }
            case 3496342: {
                boolean bl4 = ((String)object).equals(string3);
                if (!bl4) break;
                n11 = 0;
            }
        }
        switch (n11) {
            default: {
                return 110200;
            }
            case 2: {
                return 110221;
            }
            case 1: {
                return 110225;
            }
            case 0: 
        }
        return 110223;
    }
}

