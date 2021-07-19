/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.messages;

import cn.leancloud.AVException;
import cn.leancloud.AVFile;
import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.callback.ProgressCallback;
import cn.leancloud.callback.SaveCallback;
import cn.leancloud.convertor.ObserverBuilder;
import cn.leancloud.core.PaasClient;
import cn.leancloud.im.v2.AVIMTypedMessage;
import cn.leancloud.im.v2.messages.AVIMFileMessage$1;
import cn.leancloud.im.v2.messages.AVIMFileMessage$2;
import cn.leancloud.im.v2.messages.AVIMFileMessage$3;
import cn.leancloud.json.JSONObject;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import e.a.c1.b;
import e.a.g0;
import e.a.h0;
import g.a0;
import g.a0$a;
import g.e;
import g.f;
import g.z;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AVIMFileMessage
extends AVIMTypedMessage {
    public static final String DURATION = "duration";
    public static final String FILE_META = "metaData";
    public static final String FILE_SIZE = "size";
    public static final String FILE_URL = "url";
    public static final String FORMAT = "format";
    private static final String LOCAL_PATH = "local_path";
    private static final AVLogger LOGGER = LogUtil.getLogger(AVIMFileMessage.class);
    public static final String OBJECT_ID = "objId";
    public AVFile actualFile;
    public Map attrs;
    public Map file;
    public boolean hasAdditionalMetaAttr;
    public boolean keepFileName;
    public File localFile;
    public ProgressCallback progressCallback;
    public String text;

    public AVIMFileMessage() {
        this.keepFileName = false;
        this.hasAdditionalMetaAttr = false;
    }

    public AVIMFileMessage(AVFile aVFile) {
        this.keepFileName = false;
        this.hasAdditionalMetaAttr = false;
        this.actualFile = aVFile;
    }

    public AVIMFileMessage(File object) {
        this.keepFileName = false;
        this.hasAdditionalMetaAttr = false;
        this.localFile = object;
        String string2 = ((File)object).getName();
        HashMap<String, Object> hashMap = new HashMap<String, Object>(string2, (File)object);
        this.actualFile = hashMap;
        this.file = hashMap = new HashMap<String, Object>();
        object = ((File)object).getPath();
        hashMap.put(LOCAL_PATH, object);
    }

    public AVIMFileMessage(String string2) {
        File file = new File(string2);
        this(file);
    }

    public static /* synthetic */ AVLogger access$000() {
        return LOGGER;
    }

    public static boolean isExternalAVFile(AVFile aVFile) {
        boolean bl2;
        String string2;
        boolean bl3;
        Object object;
        if (aVFile != null && (object = aVFile.getMetaData()) != null && (bl3 = (object = aVFile.getMetaData()).containsKey(string2 = "__source")) && (bl2 = ((Object)(aVFile = aVFile.getMetaData().get(string2))).equals(object = "external"))) {
            bl2 = true;
        } else {
            bl2 = false;
            aVFile = null;
        }
        return bl2;
    }

    public void attachAVFile(AVFile aVFile, boolean bl2) {
        this.actualFile = aVFile;
        this.keepFileName = bl2;
    }

    public boolean equals(Object object) {
        return super.equals(object);
    }

    public void fulFillFileInfo(SaveCallback saveCallback) {
        Object object = this.actualFile;
        if (object != null) {
            object = this.getFile();
            object = object == null ? new Object() : this.getFile();
            this.file = object;
            Object object2 = this.actualFile.getObjectId();
            object.put(OBJECT_ID, object2);
            object = this.file;
            object2 = this.actualFile.getUrl();
            Object object3 = FILE_URL;
            object.put(object3, object2);
            object = this.file;
            object2 = LOCAL_PATH;
            object.remove(object2);
            object = this.getFileMetaData();
            object = object == null ? new Object() : this.getFileMetaData();
            object2 = FILE_SIZE;
            int n10 = object.containsKey(object2);
            if (n10 == 0) {
                n10 = this.actualFile.getSize();
                object3 = n10;
                object.put(object2, object3);
            }
            object2 = new AVIMFileMessage$2(this, (Map)object, saveCallback);
            this.getAdditionalMetaData((Map)object, (SaveCallback)object2);
        } else {
            String string2 = "cannot find the file!";
            RuntimeException runtimeException = new RuntimeException(string2);
            object = new Object(runtimeException);
            saveCallback.internalDone((AVException)object);
        }
    }

    public AVFile getAVFile() {
        String string2;
        boolean bl2;
        Object object = this.actualFile;
        if (object != null) {
            return object;
        }
        object = this.file;
        String string3 = null;
        if (object != null && (bl2 = object.containsKey(string2 = FILE_URL))) {
            object = this.file;
            Object object2 = FILE_META;
            bl2 = object.containsKey(object2);
            if (bl2) {
                object = (Map)this.file.get(object2);
            } else {
                bl2 = false;
                object = null;
            }
            Map map = this.file;
            string2 = (String)map.get(string2);
            object2 = new AVFile(null, string2, (Map)object);
            object = this.file;
            string3 = OBJECT_ID;
            bl2 = object.containsKey(string3);
            if (bl2) {
                object = (String)this.file.get(string3);
                ((AVObject)object2).setObjectId((String)object);
            }
            return object2;
        }
        return null;
    }

    public void getAdditionalMetaData(Map map, SaveCallback saveCallback) {
        boolean bl2 = this.hasAdditionalMetaAttr;
        Object object = null;
        if (!bl2) {
            saveCallback.internalDone(null);
        } else {
            Object object2 = this.actualFile.getUrl();
            bl2 = StringUtil.isEmpty((String)object2);
            if (!bl2 && (object2 = this.localFile) == null && !(bl2 = AVIMFileMessage.isExternalAVFile((AVFile)(object2 = this.actualFile)))) {
                object2 = PaasClient.getGlobalOkHttpClient();
                object = new a0$a();
                CharSequence charSequence = new StringBuilder();
                String string2 = this.actualFile.getUrl();
                charSequence.append(string2);
                string2 = this.getQueryName();
                charSequence.append(string2);
                charSequence = charSequence.toString();
                object = ((a0$a)object).B((String)charSequence).g().b();
                object2 = ((z)object2).a((a0)object);
                object = new AVIMFileMessage$3(this, (String)charSequence, saveCallback, map);
                FirebasePerfOkHttpClient.enqueue((e)object2, (f)object);
            } else {
                saveCallback.internalDone(null);
            }
        }
    }

    public Map getAttrs() {
        return this.attrs;
    }

    public Map getFile() {
        return this.file;
    }

    public Map getFileMetaData() {
        String string2;
        boolean bl2;
        Map<String, Integer> map = this.file;
        if (map == null) {
            map = new Map<String, Integer>();
            this.file = map;
        }
        if (!(bl2 = (map = this.file).containsKey(string2 = FILE_META))) {
            map = new Map<String, Integer>();
            int n10 = this.actualFile.getSize();
            Object object = n10;
            String string3 = FILE_SIZE;
            map.put(string3, (Integer)object);
            object = this.file;
            object.put(string2, map);
        } else {
            map = (Map)this.file.get(string2);
        }
        return map;
    }

    public String getFileUrl() {
        Map map = this.file;
        if (map != null) {
            return (String)map.get(FILE_URL);
        }
        return null;
    }

    public String getLocalFilePath() {
        boolean bl2;
        Object object = this.localFile;
        if (object != null && (bl2 = ((File)object).exists())) {
            object = this.localFile.getPath();
        } else {
            bl2 = false;
            object = null;
        }
        return object;
    }

    public String getQueryName() {
        return "";
    }

    public long getSize() {
        String string2;
        boolean bl2;
        Map map = this.getFileMetaData();
        if (map != null && (bl2 = map.containsKey(string2 = FILE_SIZE))) {
            return Long.parseLong(map.get(string2).toString());
        }
        return 0L;
    }

    public String getText() {
        return this.text;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void parseAdditionalMetaData(Map map, JSONObject jSONObject) {
    }

    public void setAttrs(Map map) {
        this.attrs = map;
    }

    public void setFile(Map object) {
        this.file = object;
        Object object2 = (Map)object.get(FILE_META);
        String string2 = (String)object.get(FILE_URL);
        Object object3 = new AVFile(null, string2, (Map)object2);
        this.actualFile = object3;
        object2 = (String)object.get(OBJECT_ID);
        ((AVObject)object3).setObjectId((String)object2);
        object2 = LOCAL_PATH;
        boolean bl2 = object.containsKey(object2);
        if (bl2) {
            object = (String)object.get(object2);
            this.localFile = object3 = new File((String)object);
        }
    }

    public void setHasAdditionalMetaAttr(boolean bl2) {
        this.hasAdditionalMetaAttr = bl2;
    }

    public void setProgressCallback(ProgressCallback progressCallback) {
        this.progressCallback = progressCallback;
    }

    public void setText(String string2) {
        this.text = string2;
    }

    public void upload(SaveCallback object) {
        Object object2 = this.actualFile;
        if (object2 != null) {
            boolean bl2 = this.keepFileName;
            object2 = ((AVFile)object2).saveInBackground(bl2);
            Object object3 = b.d();
            object2 = ((e.a.z)object2).L5((h0)object3);
            object3 = new AVIMFileMessage$1(this, (SaveCallback)object);
            object = ObserverBuilder.buildSingleObserver((SaveCallback)object3);
            ((e.a.z)object2).subscribe((g0)object);
        } else {
            String string2 = "cannot find the file!";
            RuntimeException runtimeException = new RuntimeException(string2);
            object2 = new AVException(runtimeException);
            ((AVCallback)object).internalDone((AVException)object2);
        }
    }
}

