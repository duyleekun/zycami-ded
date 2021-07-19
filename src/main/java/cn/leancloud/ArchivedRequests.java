/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.ArchivedRequests$1;
import cn.leancloud.ArchivedRequests$2;
import cn.leancloud.ArchivedRequests$3;
import cn.leancloud.cache.PersistenceUtil;
import cn.leancloud.codec.MDFive;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.json.JSON;
import cn.leancloud.ops.BaseOperation;
import cn.leancloud.ops.ObjectFieldOperation;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import e.a.g0;
import e.a.z;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class ArchivedRequests {
    private static final String ATTR_INTERNAL_ID = "internalId";
    private static final String ATTR_METHOD = "method";
    private static final String ATTR_OBJECT = "objectJson";
    private static final String ATTR_OPERATION = "opertions";
    private static final String METHOD_DELETE = "Delete";
    private static final String METHOD_SAVE = "Save";
    private static ArchivedRequests instance;
    private static final AVLogger logger;
    private Map deleteObjects;
    private Map saveObjects;
    private Timer timer;

    static {
        logger = LogUtil.getLogger(ArchivedRequests.class);
        instance = null;
    }

    private ArchivedRequests() {
        boolean bl2;
        Object object = new HashMap();
        this.saveObjects = object;
        object = new HashMap();
        this.deleteObjects = object;
        this.timer = null;
        object = AppConfiguration.getCommandCacheDir();
        PersistenceUtil.sharedInstance();
        object = PersistenceUtil.listFiles((String)object).iterator();
        while (bl2 = object.hasNext()) {
            File file = (File)object.next();
            this.parseArchiveFile(file);
        }
        this.timer = object = new Timer(true);
        ArchivedRequests$1 archivedRequests$1 = new ArchivedRequests$1(this);
        this.timer.schedule((TimerTask)archivedRequests$1, 10000L, 15000L);
    }

    public static /* synthetic */ AVLogger access$000() {
        return logger;
    }

    public static /* synthetic */ Map access$100(ArchivedRequests archivedRequests) {
        return archivedRequests.saveObjects;
    }

    public static /* synthetic */ Map access$200(ArchivedRequests archivedRequests) {
        return archivedRequests.deleteObjects;
    }

    public static /* synthetic */ void access$300(ArchivedRequests archivedRequests, Map map, boolean bl2) {
        archivedRequests.sendArchivedRequest(map, bl2);
    }

    public static /* synthetic */ File access$400(ArchivedRequests archivedRequests, AVObject aVObject, boolean bl2) {
        return archivedRequests.getArchivedFile(aVObject, bl2);
    }

    public static /* synthetic */ File access$500(ArchivedRequests archivedRequests, String string2, boolean bl2) {
        return archivedRequests.getArchivedFile(string2, bl2);
    }

    public static String getArchiveContent(AVObject object, boolean bl2) {
        int n10 = 3;
        HashMap<String, Object> hashMap = new HashMap<String, Object>(n10);
        String string2 = bl2 ? METHOD_DELETE : METHOD_SAVE;
        hashMap.put(ATTR_METHOD, string2);
        string2 = ((AVObject)object).internalId();
        hashMap.put(ATTR_INTERNAL_ID, string2);
        string2 = ((AVObject)object).toJSONString();
        hashMap.put(ATTR_OBJECT, string2);
        object = JSON.toJSONString(((AVObject)object).operations.values());
        hashMap.put(ATTR_OPERATION, object);
        return JSON.toJSONString(hashMap);
    }

    private static String getArchiveRequestFileName(AVObject aVObject) {
        String string2 = aVObject.getObjectId();
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            return aVObject.getObjectId();
        }
        string2 = aVObject.getUuid();
        bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            return aVObject.getUuid();
        }
        return MDFive.computeMD5(aVObject.getRequestRawEndpoint());
    }

    private File getArchivedFile(AVObject object, boolean bl2) {
        object = ArchivedRequests.getArchiveRequestFileName((AVObject)object);
        String string2 = AppConfiguration.getCommandCacheDir();
        File file = new File(string2, (String)object);
        return file;
    }

    private File getArchivedFile(String string2, boolean bl2) {
        String string3 = AppConfiguration.getCommandCacheDir();
        File file = new File(string3, string2);
        return file;
    }

    public static ArchivedRequests getInstance() {
        Class<ArchivedRequests> clazz = ArchivedRequests.class;
        synchronized (clazz) {
            ArchivedRequests archivedRequests = instance;
            if (archivedRequests == null) {
                instance = archivedRequests = new ArchivedRequests();
            }
            archivedRequests = instance;
            return archivedRequests;
        }
    }

    public static AVObject parseAVObject(String string2) {
        return ArchivedRequests.parseAVObject((Map)JSON.parseObject(string2, Map.class));
    }

    private static AVObject parseAVObject(Map iterator2) {
        boolean bl2;
        Object object = (String)iterator2.get(ATTR_INTERNAL_ID);
        Object object2 = (String)iterator2.get(ATTR_OBJECT);
        String string2 = ATTR_OPERATION;
        iterator2 = (String)iterator2.get(string2);
        object2 = AVObject.parseAVObject((String)object2);
        boolean bl3 = StringUtil.isEmpty((String)object);
        if (!bl3 && !(bl3 = ((String)object).equals(string2 = ((AVObject)object2).getObjectId()))) {
            ((AVObject)object2).setUuid((String)object);
        }
        if (!(bl2 = StringUtil.isEmpty((String)((Object)iterator2)))) {
            object = BaseOperation.class;
            iterator2 = JSON.parseArray((String)((Object)iterator2), (Class)object).iterator();
            while (bl2 = iterator2.hasNext()) {
                object = (BaseOperation)iterator2.next();
                ((AVObject)object2).addNewOperation((ObjectFieldOperation)object);
            }
        }
        return object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void parseArchiveFile(File object) {
        if (object == null) {
            return;
        }
        Object object2 = ((File)object).getName();
        boolean bl2 = AVObject.verifyInternalId((String)object2);
        if (!bl2) {
            object2 = logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ignore invalid file. ");
            object = ((File)object).getAbsolutePath();
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            ((AVLogger)object2).d((String)object);
            return;
        }
        object2 = PersistenceUtil.sharedInstance();
        object = ((PersistenceUtil)object2).readContentFromFile((File)object);
        bl2 = StringUtil.isEmpty((String)object);
        if (bl2) {
            return;
        }
        object2 = Map.class;
        try {
            object = JSON.parseObject((String)object, object2);
            object = (Map)object;
            object2 = ATTR_METHOD;
            object2 = object.get(object2);
            object2 = (String)object2;
            object = ArchivedRequests.parseAVObject((Map)object);
            Object object3 = logger;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "get archived request. method=";
            stringBuilder.append(string2);
            stringBuilder.append((String)object2);
            string2 = ", object=";
            stringBuilder.append(string2);
            string2 = ((AVObject)object).toString();
            stringBuilder.append(string2);
            String string3 = stringBuilder.toString();
            ((AVLogger)object3).d(string3);
            object3 = METHOD_SAVE;
            bl2 = ((String)object3).equalsIgnoreCase((String)object2);
            if (bl2) {
                object2 = this.saveObjects;
                object3 = ((AVObject)object).internalId();
                object2.put(object3, object);
                return;
            }
            object2 = this.deleteObjects;
            object3 = ((AVObject)object).internalId();
            object2.put(object3, object);
            return;
        }
        catch (Exception exception) {
            object2 = logger;
            String string4 = "encounter exception whiling parse archived file.";
            ((AVLogger)object2).w(string4, exception);
        }
    }

    private void saveArchivedRequest(AVObject object, boolean bl2) {
        String string2 = ArchivedRequests.getArchiveContent((AVObject)object, bl2);
        object = this.getArchivedFile((AVObject)object, bl2);
        PersistenceUtil.sharedInstance().saveContentToFile(string2, (File)object);
    }

    private void sendArchivedRequest(Map map, boolean bl2) {
        boolean bl3;
        if (map != null && !(bl3 = map.isEmpty())) {
            boolean bl4;
            int n10;
            Iterator iterator2 = map.values();
            int n11 = 0;
            Object object = null;
            int n12 = iterator2.size();
            if (n12 <= (n10 = 5)) {
                n10 = iterator2.size();
            }
            iterator2 = iterator2.iterator();
            Object object2 = new ArrayList(n10);
            while (n11 < n10 && (bl4 = iterator2.hasNext())) {
                AVObject aVObject = (AVObject)iterator2.next();
                ++n11;
                object2.add(aVObject);
            }
            iterator2 = object2.iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                g0 g02;
                object = (AVObject)iterator2.next();
                if (bl2) {
                    object2 = ((AVObject)object).deleteInBackground();
                    g02 = new ArchivedRequests$2(this, map, (AVObject)object, bl2);
                    ((z)object2).subscribe(g02);
                    continue;
                }
                object2 = ((AVObject)object).internalId();
                object = ((AVObject)object).saveInBackground();
                g02 = new ArchivedRequests$3(this, map, (String)object2, bl2);
                ((z)object).subscribe(g02);
            }
        }
    }

    public void deleteEventually(AVObject aVObject) {
        if (aVObject == null) {
            return;
        }
        this.saveArchivedRequest(aVObject, true);
        Map map = this.deleteObjects;
        String string2 = aVObject.internalId();
        map.put(string2, aVObject);
    }

    public void saveEventually(AVObject aVObject) {
        if (aVObject == null) {
            return;
        }
        this.saveArchivedRequest(aVObject, false);
        Map map = this.saveObjects;
        String string2 = aVObject.internalId();
        map.put(string2, aVObject);
    }
}

