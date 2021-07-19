/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.CaseInsensitiveHashMap;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParser;
import com.alibaba.sdk.android.oss.model.OSSResult;
import g.c0;
import g.s;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.Map;
import java.util.zip.CheckedInputStream;

public abstract class AbstractResponseParser
implements ResponseParser {
    private CaseInsensitiveHashMap parseResponseHeader(c0 object) {
        int n10;
        CaseInsensitiveHashMap caseInsensitiveHashMap = new CaseInsensitiveHashMap();
        object = ((c0)object).C0();
        for (int i10 = 0; i10 < (n10 = ((s)object).size()); ++i10) {
            String string2 = ((s)object).h(i10);
            String string3 = ((s)object).n(i10);
            caseInsensitiveHashMap.put(string2, string3);
        }
        return caseInsensitiveHashMap;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void safeCloseResponse(ResponseMessage responseMessage) {
        try {
            responseMessage.close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public boolean needCloseResponse() {
        return true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public OSSResult parse(ResponseMessage responseMessage) {
        Throwable throwable2222222;
        block7: {
            Object object;
            block6: {
                object = this.getClass();
                object = ((Class)object).getGenericSuperclass();
                object = (ParameterizedType)object;
                object = object.getActualTypeArguments();
                int n10 = 0;
                Object object2 = null;
                object = object[0];
                object = (Class)object;
                object = ((Class)object).newInstance();
                object = (OSSResult)object;
                if (object != null) {
                    object2 = responseMessage.getHeaders();
                    String string2 = "x-oss-request-id";
                    object2 = object2.get(string2);
                    object2 = (String)object2;
                    ((OSSResult)object).setRequestId((String)object2);
                    n10 = responseMessage.getStatusCode();
                    ((OSSResult)object).setStatusCode(n10);
                    object2 = responseMessage.getResponse();
                    object2 = this.parseResponseHeader((c0)object2);
                    ((OSSResult)object).setResponseHeader((Map)object2);
                    this.setCRC((OSSResult)object, responseMessage);
                    object = this.parseData(responseMessage, (OSSResult)object);
                }
                if ((n10 = this.needCloseResponse()) == 0) break block6;
                {
                    catch (Throwable throwable2222222) {
                        break block7;
                    }
                    catch (Exception exception) {}
                    {
                        String string3 = exception.getMessage();
                        IOException iOException = new IOException(string3, exception);
                        exception.printStackTrace();
                        OSSLog.logThrowable2Local(exception);
                        throw iOException;
                    }
                }
                AbstractResponseParser.safeCloseResponse(responseMessage);
            }
            return object;
        }
        boolean bl2 = this.needCloseResponse();
        if (bl2) {
            AbstractResponseParser.safeCloseResponse(responseMessage);
        }
        throw throwable2222222;
    }

    public abstract OSSResult parseData(ResponseMessage var1, OSSResult var2);

    public void setCRC(OSSResult oSSResult, ResponseMessage object) {
        long l10;
        boolean bl2;
        Object object2 = ((ResponseMessage)object).getRequest().getContent();
        if (object2 != null && (bl2 = object2 instanceof CheckedInputStream)) {
            l10 = ((CheckedInputStream)object2).getChecksum().getValue();
            object2 = l10;
            oSSResult.setClientCRC((Long)object2);
        }
        object = ((ResponseMessage)object).getHeaders();
        object2 = "x-oss-hash-crc64ecma";
        if ((object = (String)object.get(object2)) != null) {
            object2 = new BigInteger((String)object);
            l10 = ((BigInteger)object2).longValue();
            object = l10;
            oSSResult.setServerCRC((Long)object);
        }
    }
}

