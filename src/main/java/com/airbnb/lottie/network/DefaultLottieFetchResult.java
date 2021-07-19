/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.network;

import com.airbnb.lottie.network.LottieFetchResult;
import com.airbnb.lottie.utils.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URLConnection;

public class DefaultLottieFetchResult
implements LottieFetchResult {
    private final HttpURLConnection connection;

    public DefaultLottieFetchResult(HttpURLConnection httpURLConnection) {
        this.connection = httpURLConnection;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String getErrorFromConnection(HttpURLConnection object) {
        Throwable throwable2222222;
        BufferedReader bufferedReader;
        block9: {
            object = ((HttpURLConnection)object).getErrorStream();
            Object object2 = new InputStreamReader((InputStream)object);
            bufferedReader = new BufferedReader((Reader)object2);
            object = new StringBuilder();
            while ((object2 = bufferedReader.readLine()) != null) {
                ((StringBuilder)object).append((String)object2);
                char c10 = '\n';
                ((StringBuilder)object).append(c10);
            }
            {
                catch (Throwable throwable2222222) {
                    break block9;
                }
                catch (Exception exception) {}
                {
                    throw exception;
                }
            }
            try {
                bufferedReader.close();
                return ((StringBuilder)object).toString();
            }
            catch (Exception exception) {
                return ((StringBuilder)object).toString();
            }
        }
        try {
            bufferedReader.close();
            throw throwable2222222;
        }
        catch (Exception exception) {
            throw throwable2222222;
        }
    }

    public InputStream bodyByteStream() {
        return this.connection.getInputStream();
    }

    public void close() {
        this.connection.disconnect();
    }

    public String contentType() {
        return this.connection.getContentType();
    }

    public String error() {
        CharSequence charSequence;
        block14: {
            block13: {
                try {
                    boolean bl2 = this.isSuccessful();
                    if (!bl2) break block13;
                    bl2 = false;
                    charSequence = null;
                    break block14;
                }
                catch (IOException iOException) {
                    Logger.warning("get error failed ", iOException);
                    return iOException.getMessage();
                }
            }
            charSequence = new StringBuilder();
            Object object = "Unable to fetch ";
            charSequence.append((String)object);
            object = this.connection;
            object = ((URLConnection)object).getURL();
            charSequence.append(object);
            object = ". Failed with ";
            charSequence.append((String)object);
            object = this.connection;
            int n10 = ((HttpURLConnection)object).getResponseCode();
            charSequence.append(n10);
            object = "\n";
            charSequence.append((String)object);
            object = this.connection;
            object = this.getErrorFromConnection((HttpURLConnection)object);
            charSequence.append((String)object);
            charSequence = charSequence.toString();
        }
        return charSequence;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isSuccessful() {
        HttpURLConnection httpURLConnection;
        boolean bl2 = false;
        try {
            httpURLConnection = this.connection;
        }
        catch (IOException iOException) {
            return bl2;
        }
        int n10 = httpURLConnection.getResponseCode();
        int n11 = 2;
        if ((n10 /= 100) != n11) return bl2;
        return true;
    }
}

