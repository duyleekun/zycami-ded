/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVACL;
import cn.leancloud.AVFile$1;
import cn.leancloud.AVFile$2;
import cn.leancloud.AVFile$3;
import cn.leancloud.AVFile$4;
import cn.leancloud.AVFile$5;
import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.AVUser;
import cn.leancloud.cache.FileCache;
import cn.leancloud.cache.PersistenceUtil;
import cn.leancloud.callback.ProgressCallback;
import cn.leancloud.codec.MDFive;
import cn.leancloud.core.AVOSCloud;
import cn.leancloud.core.AVOSCloud$REGION;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.core.PaasClient;
import cn.leancloud.core.StorageClient;
import cn.leancloud.json.JSONObject;
import cn.leancloud.upload.FileDownloader;
import cn.leancloud.upload.FileUploader;
import cn.leancloud.utils.AVUtils;
import cn.leancloud.utils.FileUtil;
import cn.leancloud.utils.StringUtil;
import e.a.c1.b;
import e.a.h0;
import e.a.v0.o;
import e.a.z;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public final class AVFile
extends AVObject {
    public static final String CLASS_NAME = "_File";
    private static final String FILE_LENGTH_KEY = "size";
    private static final String FILE_NAME_KEY = "_name";
    private static final String FILE_SOURCE_EXTERNAL = "external";
    private static final String FILE_SOURCE_KEY = "__source";
    private static final String FILE_SUM_KEY = "_checksum";
    private static final String KEY_BUCKET = "bucket";
    private static final String KEY_FILE_KEY = "key";
    private static final String KEY_FILE_NAME = "name";
    private static final String KEY_METADATA = "metaData";
    private static final String KEY_MIME_TYPE = "mime_type";
    private static final String KEY_PROVIDER = "provider";
    private static final String KEY_URL = "url";
    private static final String THUMBNAIL_FMT = "?imageView/%d/w/%d/h/%d/q/%d/format/%s";
    private transient String cachePath;
    private transient String localPath;

    public AVFile() {
        super(CLASS_NAME);
        Object object = "";
        this.localPath = object;
        this.cachePath = object;
        object = AppConfiguration.getDefaultACL();
        if (object != null) {
            AVACL aVACL = AppConfiguration.getDefaultACL();
            this.acl = object = new AVACL(aVACL);
        }
    }

    public AVFile(String object, File file) {
        this();
        boolean bl2;
        if (file != null && (bl2 = file.exists()) && (bl2 = file.isFile())) {
            String string2;
            this.internalPut(KEY_FILE_NAME, object);
            this.addMetaData(FILE_NAME_KEY, object);
            object = MDFive.computeFileMD5(file);
            this.localPath = string2 = file.getAbsolutePath();
            this.addMetaData(FILE_SUM_KEY, object);
            object = file.length();
            this.addMetaData(FILE_LENGTH_KEY, object);
            object = FileUtil.getMimeTypeFromPath(this.localPath);
            this.internalPut(KEY_MIME_TYPE, object);
            return;
        }
        AVObject.logger.w("local file is illegal");
        object = new IllegalArgumentException("local file is illegal.");
        throw object;
    }

    public AVFile(String string2, String string3) {
        this(string2, string3, null);
    }

    public AVFile(String string2, String string3, Map map) {
        this(string2, string3, map, true);
    }

    public AVFile(String object, String string2, Map object2, boolean bl2) {
        this();
        this.internalPut(KEY_FILE_NAME, object);
        String string3 = FILE_NAME_KEY;
        this.addMetaData(string3, object);
        this.internalPut(KEY_URL, string2);
        object = new HashMap();
        if (object2 != null) {
            AVUtils.putAllWithNullFilter(object, (Map)object2);
        }
        if (bl2) {
            object2 = FILE_SOURCE_KEY;
            String string4 = FILE_SOURCE_EXTERNAL;
            object.put(object2, string4);
        }
        this.internalPut(KEY_METADATA, object);
        object = FileUtil.getMimeTypeFromUrl(string2);
        this.internalPut(KEY_MIME_TYPE, object);
    }

    public AVFile(String object, byte[] object2) {
        this();
        if (object2 != null) {
            String string2;
            this.internalPut(KEY_FILE_NAME, object);
            this.addMetaData(FILE_NAME_KEY, object);
            String string3 = MDFive.computeMD5(object2);
            this.localPath = string2 = FileCache.getIntance().saveData(string3, (byte[])object2);
            this.addMetaData(FILE_SUM_KEY, string3);
            object2 = ((byte[])object2).length;
            this.addMetaData(FILE_LENGTH_KEY, object2);
            object = FileUtil.getMimeTypeFromFilename((String)object);
            this.internalPut(KEY_MIME_TYPE, object);
            return;
        }
        object = AVObject.logger;
        object2 = "data is illegal(null)";
        ((AVLogger)object).w((String)object2);
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public static /* synthetic */ void access$000(AVFile aVFile, String string2, Object object) {
        aVFile.internalPutDirectly(string2, object);
    }

    private z directlyCreate(AVUser object, JSONObject jSONObject) {
        Object object2 = PaasClient.getStorageClient();
        String string2 = this.className;
        object = ((StorageClient)object2).createObject((AVUser)object, string2, jSONObject, false, null);
        object2 = new AVFile$2(this, jSONObject);
        return ((z)object).H3((o)object2);
    }

    private void internalPutDirectly(String string2, Object object) {
        this.serverData.put(string2, object);
    }

    private boolean isSavingExternalFile() {
        String string2 = this.getObjectId();
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2 && !(bl2 = StringUtil.isEmpty(string2 = this.getUrl()))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    private z saveWithProgressCallback(AVUser object, boolean bl2, ProgressCallback progressCallback) {
        Object object2 = this.generateChangedParam();
        Object object3 = "File";
        object2.put("__type", object3);
        Object object4 = this.getObjectId();
        boolean bl3 = StringUtil.isEmpty((String)object4);
        if (bl3) {
            object4 = this.getUrl();
            bl3 = StringUtil.isEmpty((String)object4);
            if (!bl3) {
                return this.directlyCreate((AVUser)object, (JSONObject)object2);
            }
            object4 = AVObject.logger;
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("createToken params: ");
            String string2 = ((JSONObject)object2).toJSONString();
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(", ");
            ((StringBuilder)object3).append(this);
            object3 = ((StringBuilder)object3).toString();
            ((AVLogger)object4).d((String)object3);
            object4 = PaasClient.getStorageClient();
            object2 = ((StorageClient)object4).newUploadToken((AVUser)object, (JSONObject)object2);
            object3 = new AVFile$3(this, progressCallback, (AVUser)object);
            object = ((z)object2).H3((o)object3);
            return ((StorageClient)object4).wrapObservable((z)object);
        }
        AVObject.logger.d("file has been upload to cloud, ignore update request.");
        return z.t3(this);
    }

    public static void setUploadHeader(String string2, String string3) {
        FileUploader.setUploadHeader(string2, string3);
    }

    public static AVFile withAbsoluteLocalPath(String string2, String string3) {
        File file = new File(string3);
        return AVFile.withFile(string2, file);
    }

    public static AVFile withFile(String object, File object2) {
        if (object2 != null) {
            boolean bl2 = ((File)object2).exists();
            if (bl2 && (bl2 = ((File)object2).isFile())) {
                boolean bl3;
                AVFile aVFile = new AVFile((String)object, (File)object2);
                object = AVUser.getCurrentUser();
                if (object != null && !(bl3 = StringUtil.isEmpty((String)(object2 = ((AVObject)object).getObjectId())))) {
                    object = ((AVObject)object).getObjectId();
                    object2 = "owner";
                    aVFile.addMetaData((String)object2, object);
                }
                return aVFile;
            }
            object = new FileNotFoundException();
            throw object;
        }
        object = new IllegalArgumentException("null file object.");
        throw object;
    }

    public static z withObjectIdInBackground(String string2) {
        return PaasClient.getStorageClient().fetchFile(null, string2);
    }

    public void addMetaData(String string2, Object object) {
        this.getMetaData().put(string2, object);
    }

    public void clearMetaData() {
        this.getMetaData().clear();
    }

    public boolean equals(Object object) {
        return super.equals(object);
    }

    public Object get(String object) {
        object = new UnsupportedOperationException("cannot invoke get method in AVFile");
        throw object;
    }

    public String getBucket() {
        return (String)this.internalGet(KEY_BUCKET);
    }

    /*
     * Unable to fully structure code
     */
    public byte[] getData() {
        block5: {
            block6: {
                block4: {
                    var1_1 = this.localPath;
                    var2_2 = StringUtil.isEmpty((String)var1_1);
                    if (var2_2) break block4;
                    var1_1 = this.localPath;
                    break block5;
                }
                var1_1 = this.cachePath;
                var2_2 = StringUtil.isEmpty((String)var1_1);
                if (var2_2) break block6;
                var1_1 = this.cachePath;
                break block5;
            }
            var1_1 = this.getUrl();
            var2_2 = StringUtil.isEmpty((String)var1_1);
            if (var2_2) ** GOTO lbl-1000
            var1_1 = FileCache.getIntance();
            var3_3 = this.getUrl();
            if ((var1_1 = var1_1.getCacheFile((String)var3_3)) == null || !(var4_4 = var1_1.exists())) {
                var3_3 = new FileDownloader();
                var5_5 = this.getUrl();
                var3_3.execute((String)var5_5, (File)var1_1);
            }
            if (var1_1 != null) {
                var1_1 = var1_1.getAbsolutePath();
            } else lbl-1000:
            // 2 sources

            {
                var1_1 = "";
            }
        }
        var4_4 = StringUtil.isEmpty((String)var1_1);
        if (!var4_4) {
            var3_3 = PersistenceUtil.sharedInstance();
            var5_5 = new File((String)var1_1);
            return var3_3.readContentBytesFromFile((File)var5_5);
        }
        return new byte[0];
    }

    public z getDataInBackground() {
        Object object;
        Object object2 = new AVFile$4(this);
        object2 = z.R2((Callable)object2);
        boolean bl2 = AppConfiguration.isAsynchronized();
        if (bl2) {
            object = b.d();
            object2 = ((z)object2).L5((h0)object);
        }
        if ((object = AppConfiguration.getDefaultScheduler()) != null) {
            object = object.create();
            object2 = ((z)object2).i4((h0)object);
        }
        return object2;
    }

    /*
     * Unable to fully structure code
     */
    public InputStream getDataStream() {
        block5: {
            block6: {
                block4: {
                    var1_1 = this.localPath;
                    var2_2 = StringUtil.isEmpty((String)var1_1);
                    if (var2_2) break block4;
                    var1_1 = this.localPath;
                    break block5;
                }
                var1_1 = this.cachePath;
                var2_2 = StringUtil.isEmpty((String)var1_1);
                if (var2_2) break block6;
                var1_1 = this.cachePath;
                break block5;
            }
            var1_1 = this.getUrl();
            var2_2 = StringUtil.isEmpty((String)var1_1);
            if (var2_2) ** GOTO lbl-1000
            var1_1 = FileCache.getIntance();
            var3_3 = this.getUrl();
            if ((var1_1 = var1_1.getCacheFile((String)var3_3)) == null || !(var4_4 = var1_1.exists())) {
                var3_3 = new FileDownloader();
                var5_5 = this.getUrl();
                var3_3.execute((String)var5_5, (File)var1_1);
            }
            if (var1_1 != null) {
                var1_1 = var1_1.getAbsolutePath();
            } else lbl-1000:
            // 2 sources

            {
                var1_1 = "";
            }
        }
        var4_4 = StringUtil.isEmpty((String)var1_1);
        if (!var4_4) {
            var3_3 = AVObject.logger;
            var5_5 = new StringBuilder();
            var5_5.append("dest file path=");
            var5_5.append((String)var1_1);
            var5_5 = var5_5.toString();
            var3_3.d((String)var5_5);
            var3_3 = FileCache.getIntance();
            var5_5 = new File((String)var1_1);
            return var3_3.getInputStreamFromFile((File)var5_5);
        }
        AVObject.logger.w("failed to get dataStream.");
        return null;
    }

    public z getDataStreamInBackground() {
        Object object;
        Object object2 = new AVFile$5(this);
        object2 = z.R2((Callable)object2);
        boolean bl2 = AppConfiguration.isAsynchronized();
        if (bl2) {
            object = b.d();
            object2 = ((z)object2).L5((h0)object);
        }
        if ((object = AppConfiguration.getDefaultScheduler()) != null) {
            object = object.create();
            object2 = ((z)object2).i4((h0)object);
        }
        return object2;
    }

    public String getKey() {
        return (String)this.internalGet(KEY_FILE_KEY);
    }

    public Object getMetaData(String string2) {
        return this.getMetaData().get(string2);
    }

    public Map getMetaData() {
        String string2 = KEY_METADATA;
        HashMap hashMap = (HashMap)this.internalGet(string2);
        if (hashMap == null) {
            hashMap = new HashMap();
            this.internalPut(string2, hashMap);
        }
        return hashMap;
    }

    public String getMimeType() {
        return (String)this.internalGet(KEY_MIME_TYPE);
    }

    public String getName() {
        return (String)this.internalGet(KEY_FILE_NAME);
    }

    public String getProvider() {
        return (String)this.internalGet(KEY_PROVIDER);
    }

    public int getSize() {
        Number number = (Number)this.getMetaData(FILE_LENGTH_KEY);
        if (number != null) {
            return number.intValue();
        }
        return -1;
    }

    public String getThumbnailUrl(boolean bl2, int n10, int n11) {
        return this.getThumbnailUrl(bl2, n10, n11, 100, "png");
    }

    /*
     * WARNING - void declaration
     */
    public String getThumbnailUrl(boolean bl2, int n10, int n11, int n12, String string2) {
        Object object;
        AVOSCloud$REGION aVOSCloud$REGION = AVOSCloud.getRegion();
        if (aVOSCloud$REGION != (object = AVOSCloud$REGION.NorthAmerica)) {
            void var3_6;
            void var2_5;
            if (var2_5 >= 0 && var3_6 >= 0) {
                int n13;
                void var4_7;
                int n14 = 1;
                if (var4_7 >= n14 && var4_7 <= (n13 = 100)) {
                    void var1_4;
                    Object object5;
                    String string3;
                    if (string3 == null || (n13 = (int)(StringUtil.isEmpty((String)(object = string3.trim())) ? 1 : 0)) != 0) {
                        string3 = "png";
                    }
                    n13 = 2;
                    if (bl2) {
                        int n15 = n13;
                    } else {
                        int n16 = n14;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    Object[] objectArray = this.getUrl();
                    stringBuilder.append((String)objectArray);
                    objectArray = new Object[5];
                    objectArray[0] = object5 = Integer.valueOf((int)var1_4);
                    objectArray[n14] = object5 = Integer.valueOf((int)var2_5);
                    objectArray[n13] = object5 = Integer.valueOf((int)var3_6);
                    Integer string5 = (int)var4_7;
                    objectArray[3] = string5;
                    objectArray[4] = string3;
                    object5 = String.format(THUMBNAIL_FMT, objectArray);
                    stringBuilder.append((String)object5);
                    return stringBuilder.toString();
                }
                Object object2 = AVObject.logger;
                String string4 = "Invalid quality,valid range is 0-100.";
                ((AVLogger)object2).w(string4);
                object2 = new IllegalArgumentException(string4);
                throw object2;
            }
            Object object3 = AVObject.logger;
            String string5 = "Invalid width or height.";
            ((AVLogger)object3).w(string5);
            object3 = new IllegalArgumentException(string5);
            throw object3;
        }
        Object object4 = AVObject.logger;
        String string6 = "We only support this method for qiniu storage.";
        ((AVLogger)object4).w(string6);
        object4 = new UnsupportedOperationException(string6);
        throw object4;
    }

    public String getUrl() {
        return (String)this.internalGet(KEY_URL);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void increment(String object) {
        object = new UnsupportedOperationException("cannot invoke increment method in AVFile");
        throw object;
    }

    public void increment(String object, Number number) {
        object = new UnsupportedOperationException("cannot invoke increment(Number) method in AVFile");
        throw object;
    }

    public void put(String object, Object object2) {
        object = new UnsupportedOperationException("cannot invoke put method in AVFile");
        throw object;
    }

    public void remove(String object) {
        object = new UnsupportedOperationException("cannot invoke remove method in AVFile");
        throw object;
    }

    public Object removeMetaData(String string2) {
        return this.getMetaData().remove(string2);
    }

    public void save() {
        this.saveInBackground().D();
    }

    public void save(AVUser aVUser) {
        this.saveInBackground(aVUser, false).D();
    }

    public void saveEventually() {
        this.saveEventually(null);
    }

    public void saveEventually(AVUser object) {
        boolean bl2 = this.isSavingExternalFile();
        if (bl2) {
            super.saveEventually((AVUser)object);
            return;
        }
        object = new UnsupportedOperationException("AVFile#saveEventually is not allowed, please save the binary data to temp store and try to save in future.");
        throw object;
    }

    public z saveInBackground() {
        return this.saveInBackground(false);
    }

    public z saveInBackground(AVUser aVUser, boolean bl2) {
        return this.saveWithProgressCallback(aVUser, bl2, null);
    }

    public z saveInBackground(boolean bl2) {
        return this.saveInBackground(null, bl2);
    }

    public void saveInBackground(AVUser object, boolean bl2, ProgressCallback progressCallback) {
        synchronized (this) {
            object = this.saveWithProgressCallback((AVUser)object, bl2, progressCallback);
            AVFile$1 aVFile$1 = new AVFile$1(this, progressCallback);
            ((z)object).subscribe(aVFile$1);
            return;
        }
    }

    public void saveInBackground(ProgressCallback progressCallback) {
        this.saveInBackground(false, progressCallback);
    }

    public void saveInBackground(boolean bl2, ProgressCallback progressCallback) {
        synchronized (this) {
            this.saveInBackground(null, bl2, progressCallback);
            return;
        }
    }

    public void setKey(String string2) {
        this.internalPut(KEY_FILE_KEY, string2);
    }

    public void setMetaData(Map map) {
        this.internalPut(KEY_METADATA, map);
    }

    public void setMimeType(String string2) {
        this.internalPut(KEY_MIME_TYPE, string2);
    }

    public void setName(String string2) {
        this.internalPut(KEY_FILE_NAME, string2);
    }

    public Map toMap() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("__type", CLASS_NAME);
        Object object = this.getMetaData();
        String string2 = KEY_METADATA;
        hashMap.put(string2, object);
        object = this.getUrl();
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            object = this.getUrl();
            string2 = KEY_URL;
            hashMap.put(string2, object);
        }
        if (!(bl2 = StringUtil.isEmpty((String)(object = this.getObjectId())))) {
            object = this.getObjectId();
            string2 = "objectId";
            hashMap.put(string2, object);
        }
        object = this.getName();
        hashMap.put("id", object);
        return hashMap;
    }
}

