/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.MetaDataStore$1;
import com.google.firebase.crashlytics.internal.common.UserMetadata;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class MetaDataStore {
    private static final String KEYDATA_SUFFIX = "keys";
    private static final String KEY_USER_ID = "userId";
    private static final String METADATA_EXT = ".meta";
    private static final String USERDATA_SUFFIX = "user";
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final File filesDir;

    public MetaDataStore(File file) {
        this.filesDir = file;
    }

    private static Map jsonToKeysData(String hashMap) {
        boolean bl2;
        JSONObject jSONObject = new JSONObject((String)((Object)hashMap));
        hashMap = new HashMap<String, String>();
        Iterator iterator2 = jSONObject.keys();
        while (bl2 = iterator2.hasNext()) {
            String string2 = (String)iterator2.next();
            String string3 = MetaDataStore.valueOrNull(jSONObject, string2);
            hashMap.put(string2, string3);
        }
        return hashMap;
    }

    private static UserMetadata jsonToUserData(String object) {
        Object object2 = new JSONObject((String)object);
        object = new UserMetadata();
        object2 = MetaDataStore.valueOrNull(object2, KEY_USER_ID);
        ((UserMetadata)object).setUserId((String)object2);
        return object;
    }

    private static String keysDataToJson(Map map) {
        JSONObject jSONObject = new JSONObject(map);
        return jSONObject.toString();
    }

    private static String userDataToJson(UserMetadata userMetadata) {
        MetaDataStore$1 metaDataStore$1 = new MetaDataStore$1(userMetadata);
        return metaDataStore$1.toString();
    }

    private static String valueOrNull(JSONObject jSONObject, String string2) {
        boolean bl2 = jSONObject.isNull(string2);
        String string3 = null;
        if (!bl2) {
            string3 = jSONObject.optString(string2, null);
        }
        return string3;
    }

    public File getKeysFileForSession(String string2) {
        File file = this.filesDir;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(KEYDATA_SUFFIX);
        stringBuilder.append(METADATA_EXT);
        string2 = stringBuilder.toString();
        File file2 = new File(file, string2);
        return file2;
    }

    public File getUserDataFileForSession(String string2) {
        File file = this.filesDir;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(USERDATA_SUFFIX);
        stringBuilder.append(METADATA_EXT);
        string2 = stringBuilder.toString();
        File file2 = new File(file, string2);
        return file2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map readKeyData(String var1_1) {
        block8: {
            var2_7 = "Failed to close user metadata file.";
            var3_8 = (var1_1 = this.getKeysFileForSession((String)var1_1)).exists();
            if (!var3_8) {
                return Collections.emptyMap();
            }
            var3_8 = false;
            var4_9 = null;
            try {
                var5_10 = new FileInputStream((File)var1_1);
            }
            catch (Throwable var1_4) {
                break block8;
            }
            catch (Exception var1_5) {
                // empty catch block
                ** GOTO lbl-1000
            }
            try {
                var1_1 = CommonUtils.streamToString((InputStream)var5_10);
                var1_1 = MetaDataStore.jsonToKeysData((String)var1_1);
            }
            catch (Throwable var1_2) {
                var4_9 = var5_10;
                break block8;
            }
            catch (Exception var1_3) {
                var4_9 = var5_10;
                ** GOTO lbl-1000
            }
            CommonUtils.closeOrLog((Closeable)var5_10, var2_7);
            return var1_1;
lbl-1000:
            // 2 sources

            {
                var5_10 = Logger.getLogger();
                var6_11 = "Error deserializing user metadata.";
                var5_10.e(var6_11, (Throwable)var1_1);
            }
            CommonUtils.closeOrLog((Closeable)var4_9, var2_7);
            return Collections.emptyMap();
        }
        CommonUtils.closeOrLog(var4_9, var2_7);
        throw var1_6;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public UserMetadata readUserData(String var1_1) {
        block8: {
            var2_7 = "Failed to close user metadata file.";
            var3_8 = (var1_1 = this.getUserDataFileForSession((String)var1_1)).exists();
            if (!var3_8) {
                return new UserMetadata();
            }
            var3_8 = false;
            var4_9 = null;
            try {
                var5_10 = new FileInputStream((File)var1_1);
            }
            catch (Throwable var1_4) {
                break block8;
            }
            catch (Exception var1_5) {
                // empty catch block
                ** GOTO lbl-1000
            }
            try {
                var1_1 = CommonUtils.streamToString((InputStream)var5_10);
                var1_1 = MetaDataStore.jsonToUserData((String)var1_1);
            }
            catch (Throwable var1_2) {
                var4_9 = var5_10;
                break block8;
            }
            catch (Exception var1_3) {
                var4_9 = var5_10;
                ** GOTO lbl-1000
            }
            CommonUtils.closeOrLog((Closeable)var5_10, var2_7);
            return var1_1;
lbl-1000:
            // 2 sources

            {
                var5_10 = Logger.getLogger();
                var6_11 = "Error deserializing user metadata.";
                var5_10.e(var6_11, (Throwable)var1_1);
            }
            CommonUtils.closeOrLog((Closeable)var4_9, var2_7);
            return new UserMetadata();
        }
        CommonUtils.closeOrLog(var4_9, var2_7);
        throw var1_6;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void writeKeyData(String var1_1, Map var2_7) {
        block7: {
            var3_8 = "Failed to close key/value metadata file.";
            var1_1 = this.getKeysFileForSession((String)var1_1);
            var4_9 = null;
            try {
                var2_7 = MetaDataStore.keysDataToJson((Map)var2_7);
                var7_12 = new FileOutputStream((File)var1_1);
                var1_1 = MetaDataStore.UTF_8;
                var6_11 = new OutputStreamWriter((OutputStream)var7_12, (Charset)var1_1);
                var5_10 = new BufferedWriter(var6_11);
            }
            catch (Throwable var1_4) {
                break block7;
            }
            catch (Exception var1_5) {
                // empty catch block
                ** GOTO lbl-1000
            }
            try {
                var5_10.write((String)var2_7);
                var5_10.flush();
            }
            catch (Throwable var1_2) {
                var4_9 = var5_10;
                break block7;
            }
            catch (Exception var1_3) {
                var4_9 = var5_10;
                ** GOTO lbl-1000
            }
            CommonUtils.closeOrLog((Closeable)var5_10, var3_8);
            return;
lbl-1000:
            // 2 sources

            {
                var2_7 = Logger.getLogger();
                var5_10 = "Error serializing key/value metadata.";
                var2_7.e((String)var5_10, (Throwable)var1_1);
            }
            CommonUtils.closeOrLog(var4_9, var3_8);
            return;
        }
        CommonUtils.closeOrLog(var4_9, var3_8);
        throw var1_6;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void writeUserData(String var1_1, UserMetadata var2_7) {
        block7: {
            var3_8 = "Failed to close user metadata file.";
            var1_1 = this.getUserDataFileForSession((String)var1_1);
            var4_9 = null;
            try {
                var2_7 = MetaDataStore.userDataToJson((UserMetadata)var2_7);
                var7_12 = new FileOutputStream((File)var1_1);
                var1_1 = MetaDataStore.UTF_8;
                var6_11 = new OutputStreamWriter((OutputStream)var7_12, (Charset)var1_1);
                var5_10 = new BufferedWriter(var6_11);
            }
            catch (Throwable var1_4) {
                break block7;
            }
            catch (Exception var1_5) {
                // empty catch block
                ** GOTO lbl-1000
            }
            try {
                var5_10.write((String)var2_7);
                var5_10.flush();
            }
            catch (Throwable var1_2) {
                var4_9 = var5_10;
                break block7;
            }
            catch (Exception var1_3) {
                var4_9 = var5_10;
                ** GOTO lbl-1000
            }
            CommonUtils.closeOrLog((Closeable)var5_10, var3_8);
            return;
lbl-1000:
            // 2 sources

            {
                var2_7 = Logger.getLogger();
                var5_10 = "Error serializing user metadata.";
                var2_7.e((String)var5_10, (Throwable)var1_1);
            }
            CommonUtils.closeOrLog(var4_9, var3_8);
            return;
        }
        CommonUtils.closeOrLog(var4_9, var3_8);
        throw var1_6;
    }
}

