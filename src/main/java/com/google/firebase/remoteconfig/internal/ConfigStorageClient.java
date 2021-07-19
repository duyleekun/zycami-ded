/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigStorageClient {
    private static final String JSON_STRING_ENCODING = "UTF-8";
    private static final Map clientInstances;
    private final Context context;
    private final String fileName;

    static {
        HashMap hashMap;
        clientInstances = hashMap = new HashMap();
    }

    private ConfigStorageClient(Context context, String string2) {
        this.context = context;
        this.fileName = string2;
    }

    public static void clearInstancesForTest() {
        Class<ConfigStorageClient> clazz = ConfigStorageClient.class;
        synchronized (clazz) {
            Map map = clientInstances;
            map.clear();
            return;
        }
    }

    public static ConfigStorageClient getInstance(Context object, String string2) {
        Class<ConfigStorageClient> clazz = ConfigStorageClient.class;
        synchronized (clazz) {
            Map map = clientInstances;
            boolean bl2 = map.containsKey(string2);
            if (!bl2) {
                ConfigStorageClient configStorageClient = new ConfigStorageClient((Context)object, string2);
                map.put(string2, configStorageClient);
            }
            object = map.get(string2);
            object = (ConfigStorageClient)object;
            return object;
        }
    }

    public Void clear() {
        synchronized (this) {
            Context context = this.context;
            String string2 = this.fileName;
            context.deleteFile(string2);
            return null;
        }
    }

    public String getFileName() {
        return this.fileName;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ConfigContainer read() {
        synchronized (this) {
            Object object;
            Object object2;
            block8: {
                object2 = null;
                object = this.context;
                String string2 = this.fileName;
                object = object.openFileInput(string2);
                try {
                    int n10 = ((FileInputStream)object).available();
                    byte[] byArray = new byte[n10];
                    String string3 = null;
                    ((FileInputStream)object).read(byArray, 0, n10);
                    string3 = JSON_STRING_ENCODING;
                    string2 = new String(byArray, string3);
                    JSONObject jSONObject = new JSONObject(string2);
                    object2 = ConfigContainer.copyOf(jSONObject);
                    if (object == null) return object2;
                }
                catch (Throwable throwable) {
                    break block8;
                }
                ((FileInputStream)object).close();
                return object2;
                catch (Throwable throwable) {
                    object = null;
                    object2 = throwable;
                }
            }
            if (object == null) throw object2;
            ((FileInputStream)object).close();
            throw object2;
            catch (FileNotFoundException | JSONException throwable) {}
            return null;
            catch (FileNotFoundException | JSONException throwable) {}
            if (object == null) return null;
            ((FileInputStream)object).close();
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Void write(ConfigContainer object) {
        synchronized (this) {
            Object object2 = this.context;
            String string2 = this.fileName;
            object2 = object2.openFileOutput(string2, 0);
            try {
                object = ((ConfigContainer)object).toString();
                string2 = JSON_STRING_ENCODING;
                object = ((String)object).getBytes(string2);
                ((FileOutputStream)object2).write((byte[])object);
                return null;
            }
            finally {
                ((FileOutputStream)object2).close();
            }
        }
    }
}

