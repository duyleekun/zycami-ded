/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVACL;
import cn.leancloud.AVException;
import cn.leancloud.AVFile;
import cn.leancloud.AVLogger;
import cn.leancloud.AVObject$1;
import cn.leancloud.AVObject$10;
import cn.leancloud.AVObject$11;
import cn.leancloud.AVObject$2;
import cn.leancloud.AVObject$3;
import cn.leancloud.AVObject$4;
import cn.leancloud.AVObject$5;
import cn.leancloud.AVObject$6;
import cn.leancloud.AVObject$7;
import cn.leancloud.AVObject$8;
import cn.leancloud.AVObject$9;
import cn.leancloud.AVObject$Hook;
import cn.leancloud.AVQuery;
import cn.leancloud.AVRelation;
import cn.leancloud.AVSaveOption;
import cn.leancloud.AVUser;
import cn.leancloud.ArchivedRequests;
import cn.leancloud.Transformer;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.core.PaasClient;
import cn.leancloud.core.StorageClient;
import cn.leancloud.json.JSON;
import cn.leancloud.json.JSONArray;
import cn.leancloud.json.JSONArray$Builder;
import cn.leancloud.json.JSONObject;
import cn.leancloud.json.JSONObject$Builder;
import cn.leancloud.ops.BaseOperation;
import cn.leancloud.ops.CompoundOperation;
import cn.leancloud.ops.ObjectFieldOperation;
import cn.leancloud.ops.OperationBuilder;
import cn.leancloud.ops.OperationBuilder$OperationType;
import cn.leancloud.ops.Utils;
import cn.leancloud.types.AVDate;
import cn.leancloud.types.AVGeoPoint;
import cn.leancloud.types.AVNull;
import cn.leancloud.utils.AVUtils;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import e.a.c1.b;
import e.a.g0;
import e.a.h0;
import e.a.v0.o;
import e.a.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

public class AVObject {
    private static final String INTERNAL_PATTERN = "^[\\da-z][\\d-a-z]*$";
    public static final String KEY_ACL = "ACL";
    public static final String KEY_CLASSNAME = "className";
    public static final String KEY_CREATED_AT = "createdAt";
    public static final String KEY_IGNORE_HOOKS = "__ignore_hooks";
    public static final String KEY_OBJECT_ID = "objectId";
    public static final String KEY_UPDATED_AT = "updatedAt";
    private static final Set RESERVED_ATTRS;
    public static final int UUID_LEN;
    public static final AVLogger logger;
    public transient AVACL acl;
    public String className;
    public transient String endpointClassName = null;
    private volatile boolean fetchWhenSave;
    private transient Set ignoreHooks;
    public transient String objectId = "";
    public transient ConcurrentMap operations;
    public ConcurrentMap serverData;
    public volatile boolean totallyOverwrite;
    private transient String uuid;

    static {
        HashSet<String> hashSet;
        List<String> list = Arrays.asList(KEY_CREATED_AT, KEY_UPDATED_AT, KEY_OBJECT_ID, KEY_ACL, KEY_CLASSNAME);
        RESERVED_ATTRS = hashSet = new HashSet<String>(list);
        logger = LogUtil.getLogger(AVObject.class);
        UUID_LEN = UUID.randomUUID().toString().length();
    }

    public AVObject() {
        ConcurrentHashMap concurrentHashMap;
        this.serverData = concurrentHashMap = new ConcurrentHashMap();
        this.operations = concurrentHashMap = new ConcurrentHashMap();
        this.acl = null;
        this.uuid = null;
        this.fetchWhenSave = false;
        this.totallyOverwrite = false;
        Object object = new TreeSet();
        this.ignoreHooks = object;
        this.className = object = Transformer.getSubClassName(this.getClass());
    }

    public AVObject(AVObject object) {
        ConcurrentMap concurrentMap;
        this.serverData = concurrentMap = new ConcurrentMap();
        this.operations = concurrentMap = new ConcurrentMap();
        this.acl = null;
        this.uuid = null;
        this.fetchWhenSave = false;
        this.totallyOverwrite = false;
        Object object2 = new TreeSet();
        this.ignoreHooks = object2;
        this.className = object2 = ((AVObject)object).className;
        this.objectId = object2 = ((AVObject)object).objectId;
        object2 = this.serverData;
        concurrentMap = ((AVObject)object).serverData;
        object2.putAll(concurrentMap);
        object2 = this.operations;
        concurrentMap = ((AVObject)object).operations;
        object2.putAll(concurrentMap);
        this.acl = object2 = ((AVObject)object).acl;
        this.endpointClassName = object = ((AVObject)object).endpointClassName;
    }

    public AVObject(String string2) {
        TreeSet treeSet;
        ConcurrentHashMap concurrentHashMap;
        this.serverData = concurrentHashMap = new ConcurrentHashMap();
        this.operations = concurrentHashMap = new ConcurrentHashMap();
        this.acl = null;
        this.uuid = null;
        this.fetchWhenSave = false;
        this.totallyOverwrite = false;
        this.ignoreHooks = treeSet = new TreeSet();
        Transformer.checkClassName(string2);
        this.className = string2;
    }

    public static /* synthetic */ z access$000(AVObject aVObject, AVUser aVUser, AVSaveOption aVSaveOption) {
        return aVObject.saveSelfOperations(aVUser, aVSaveOption);
    }

    public static /* synthetic */ void access$100(AVObject aVObject, boolean bl2) {
        aVObject.add2ArchivedRequest(bl2);
    }

    private void add2ArchivedRequest(boolean bl2) {
        ArchivedRequests archivedRequests = ArchivedRequests.getInstance();
        if (bl2) {
            archivedRequests.deleteEventually(this);
        } else {
            archivedRequests.saveEventually(this);
        }
    }

    public static AVObject cast(AVObject object, Class object2) {
        Object object3;
        Class<?> clazz = object2.getClass();
        boolean bl2 = clazz.isAssignableFrom((Class<?>)(object3 = object.getClass()));
        if (bl2) {
            return object;
        }
        object2 = (AVObject)((Class)object2).newInstance();
        ((AVObject)object2).className = clazz = ((AVObject)object).className;
        ((AVObject)object2).objectId = clazz = ((AVObject)object).objectId;
        clazz = ((AVObject)object2).serverData;
        object3 = ((AVObject)object).serverData;
        clazz.putAll(object3);
        clazz = ((AVObject)object2).operations;
        object3 = ((AVObject)object).operations;
        clazz.putAll(object3);
        ((AVObject)object2).acl = clazz = ((AVObject)object).acl;
        ((AVObject)object2).endpointClassName = object = ((AVObject)object).endpointClassName;
        return object2;
    }

    public static AVObject createWithoutData(Class object, String object2) {
        Object object3;
        try {
            object3 = ((Class)object).newInstance();
        }
        catch (Exception exception) {
            object2 = new AVException(exception);
            throw object2;
        }
        object3 = (AVObject)object3;
        object = Transformer.getSubClassName((Class)object);
        ((AVObject)object3).setClassName((String)object);
        ((AVObject)object3).setObjectId((String)object2);
        return object3;
    }

    public static AVObject createWithoutData(String string2, String string3) {
        AVObject aVObject = new AVObject(string2);
        aVObject.setObjectId(string3);
        return aVObject;
    }

    public static void deleteAll(AVUser aVUser, Collection collection) {
        AVObject.deleteAllInBackground(aVUser, collection).D();
    }

    public static void deleteAll(Collection collection) {
        AVObject.deleteAll(null, collection);
    }

    public static z deleteAllInBackground(AVUser object, Collection object2) {
        boolean bl2;
        if (object2 != null && !(bl2 = object2.isEmpty())) {
            boolean bl3;
            bl2 = false;
            String string2 = null;
            HashMap hashMap = new HashMap();
            CharSequence charSequence = new StringBuilder();
            object2 = object2.iterator();
            while (bl3 = object2.hasNext()) {
                Object object3 = (AVObject)object2.next();
                String string3 = ((AVObject)object3).getObjectId();
                boolean bl4 = StringUtil.isEmpty(string3);
                if (!bl4 && !(bl4 = StringUtil.isEmpty(string3 = ((AVObject)object3).getClassName()))) {
                    if (string2 == null) {
                        string2 = ((AVObject)object3).getClassName();
                        object3 = ((AVObject)object3).getObjectId();
                        ((StringBuilder)charSequence).append((String)object3);
                        continue;
                    }
                    string3 = ((AVObject)object3).getClassName();
                    bl4 = string2.equals(string3);
                    if (bl4) {
                        string3 = ",";
                        ((StringBuilder)charSequence).append(string3);
                        object3 = ((AVObject)object3).getObjectId();
                        ((StringBuilder)charSequence).append((String)object3);
                        continue;
                    }
                    object = new IllegalArgumentException("The objects class name must be the same.");
                    return z.m2((Throwable)object);
                }
                object = new IllegalArgumentException("Invalid AVObject, the class name or objectId is blank.");
                return z.m2((Throwable)object);
            }
            object2 = PaasClient.getStorageClient();
            charSequence = ((StringBuilder)charSequence).toString();
            return ((StorageClient)object2).deleteObject((AVUser)object, string2, (String)charSequence, hashMap);
        }
        return z.t3(AVNull.getINSTANCE());
    }

    public static z deleteAllInBackground(Collection collection) {
        return AVObject.deleteAllInBackground(null, collection);
    }

    private static z extractSaveAheadFiles(Collection object) {
        boolean bl2;
        Object object2 = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            boolean bl3;
            List list = ((AVObject)object.next()).getUnsavedFiles();
            if (list == null || (bl3 = list.isEmpty())) continue;
            object2.addAll(list);
        }
        object = z.t3(object2);
        object2 = b.d();
        return ((z)object).L5((h0)object2);
    }

    public static AVQuery getQuery(Class clazz) {
        String string2 = Transformer.getSubClassName(clazz);
        AVQuery aVQuery = new AVQuery(string2, clazz);
        return aVQuery;
    }

    private boolean needBatchMode() {
        boolean bl2;
        Iterator iterator2 = this.operations.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            ObjectFieldOperation objectFieldOperation = (ObjectFieldOperation)iterator2.next();
            bl2 = objectFieldOperation instanceof CompoundOperation;
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static AVObject parseAVObject(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return null;
        }
        return (AVObject)JSON.parseObject(StringUtil.replaceFastjsonDateForm(string2.replaceAll("^\\{\\s*\"@type\":\\s*\"[A-Za-z\\.]+\",", "{").replaceAll("\"@type\":\\s*\"com.avos.avoscloud.AVObject\",", "\"@type\":\"cn.leancloud.AVObject\",").replaceAll("\"@type\":\\s*\"com.avos.avoscloud.AVInstallation\",", "\"@type\":\"cn.leancloud.AVInstallation\",").replaceAll("\"@type\":\\s*\"com.avos.avoscloud.AVUser\",", "\"@type\":\"cn.leancloud.AVUser\",").replaceAll("\"@type\":\\s*\"com.avos.avoscloud.AVStatus\",", "\"@type\":\"cn.leancloud.AVStatus\",").replaceAll("\"@type\":\\s*\"com.avos.avoscloud.AVRole\",", "\"@type\":\"cn.leancloud.AVRole\",").replaceAll("\"@type\":\\s*\"com.avos.avoscloud.AVFile\",", "\"@type\":\"cn.leancloud.AVFile\",").replaceAll("\"@type\":\\s*\"com.avos.avoscloud.ops.[A-Za-z]+Op\",", "")), AVObject.class);
    }

    public static void registerSubclass(Class clazz) {
        Transformer.registerClass(clazz);
    }

    public static void saveAll(AVUser aVUser, Collection collection) {
        AVObject.saveAllInBackground(aVUser, collection).D();
    }

    public static void saveAll(Collection collection) {
        AVObject.saveAll(null, collection);
    }

    public static z saveAllInBackground(AVUser object, Collection collection) {
        boolean bl2;
        if (collection != null && !(bl2 = collection.isEmpty())) {
            Object object2;
            boolean bl3;
            Object object3 = collection.iterator();
            while (bl3 = object3.hasNext()) {
                HashMap hashMap;
                object2 = (AVObject)object3.next();
                bl3 = ((AVObject)object2).hasCircleReference(hashMap = new HashMap());
                if (!bl3) continue;
                object = new AVException(100001, "Found a circular dependency when saving.");
                return z.m2((Throwable)object);
            }
            object3 = AVObject.extractSaveAheadFiles(collection);
            object2 = new AVObject$7((AVUser)object, collection);
            return ((z)object3).s2((o)object2);
        }
        return z.t3(JSONArray$Builder.create(null));
    }

    public static z saveAllInBackground(Collection collection) {
        return AVObject.saveAllInBackground(null, collection);
    }

    private z saveSelfOperations(AVUser object, AVSaveOption object2) {
        Object object3;
        boolean bl2;
        boolean bl3;
        Object object4;
        boolean bl4 = object2 != null ? ((AVSaveOption)object2).fetchWhenSave : this.isFetchWhenSave();
        if (object2 != null && (object4 = ((AVSaveOption)object2).matchQuery) != null && !(bl3 = StringUtil.isEmpty((String)(object4 = this.getClassName()))) && !(bl2 = ((String)object4).equals(object3 = ((AVSaveOption)object2).matchQuery.getClassName()))) {
            object = new AVException(0, "AVObject class inconsistant with AVQuery in AVSaveOption");
            return z.m2((Throwable)object);
        }
        Object object5 = this.generateChangedParam();
        object4 = logger;
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("saveObject param: ");
        Object object6 = ((JSONObject)object5).toJSONString();
        ((StringBuilder)object3).append((String)object6);
        object3 = ((StringBuilder)object3).toString();
        ((AVLogger)object4).d((String)object3);
        Object object7 = this.getObjectId();
        bl3 = this.needBatchMode();
        if (bl3) {
            object2 = "Caution: batch mode will ignore fetchWhenSave flag and matchQuery.";
            ((AVLogger)object4).w((String)object2);
            boolean bl5 = StringUtil.isEmpty((String)object7);
            if (bl5) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("request payload: ");
                String string2 = ((JSONObject)object5).toJSONString();
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                ((AVLogger)object4).d((String)object2);
                object = PaasClient.getStorageClient().batchSave((AVUser)object, (JSONObject)object5);
                object2 = new AVObject$1(this);
                return ((z)object).H3((o)object2);
            }
            object = PaasClient.getStorageClient().batchUpdate((AVUser)object, (JSONObject)object5);
            object2 = new AVObject$2(this, (String)object7);
            return ((z)object).H3((o)object2);
        }
        bl2 = false;
        object4 = null;
        if (object2 != null && (object2 = ((AVSaveOption)object2).matchQuery) != null) {
            object2 = JSONObject$Builder.create(((AVQuery)object2).conditions.compileWhereOperationMap());
        } else {
            boolean bl6 = false;
            object2 = null;
        }
        bl2 = this.totallyOverwrite;
        if (bl2) {
            object4 = PaasClient.getStorageClient();
            object6 = this.getClass();
            String string3 = this.endpointClassName;
            object3 = object;
            object = ((StorageClient)object4).saveWholeObject((AVUser)object, (Class)object6, string3, (String)object7, (JSONObject)object5, bl4, (JSONObject)object2);
            object2 = new AVObject$3(this, bl4);
            return ((z)object).H3((o)object2);
        }
        bl2 = StringUtil.isEmpty((String)object7);
        if (bl2) {
            object4 = PaasClient.getStorageClient();
            object6 = this.className;
            object3 = object;
            JSONObject jSONObject = object5;
            object5 = object2;
            object = ((StorageClient)object4).createObject((AVUser)object, (String)object6, jSONObject, bl4, (JSONObject)object2);
            object2 = new AVObject$4(this, bl4);
            return ((z)object).H3((o)object2);
        }
        object4 = PaasClient.getStorageClient();
        object6 = this.className;
        String string4 = this.getObjectId();
        object3 = object;
        object7 = object5;
        object = ((StorageClient)object4).saveObject((AVUser)object, (String)object6, string4, (JSONObject)object5, bl4, (JSONObject)object2);
        object2 = new AVObject$5(this, bl4);
        return ((z)object).H3((o)object2);
    }

    public static boolean verifyInternalId(String string2) {
        return Pattern.matches(INTERNAL_PATTERN, string2);
    }

    public void abortOperations() {
        boolean bl2 = this.totallyOverwrite;
        if (bl2) {
            AVLogger aVLogger = logger;
            String string2 = "Can't abort modify operations under TotalOverWrite mode.";
            aVLogger.w(string2);
        }
        this.operations.clear();
    }

    public void add(String object, Object object2) {
        this.validFieldName((String)object);
        OperationBuilder operationBuilder = OperationBuilder.gBuilder;
        OperationBuilder$OperationType operationBuilder$OperationType = OperationBuilder$OperationType.Add;
        object = operationBuilder.create(operationBuilder$OperationType, (String)object, object2);
        this.addNewOperation((ObjectFieldOperation)object);
    }

    public void addAll(String object, Collection collection) {
        this.validFieldName((String)object);
        OperationBuilder operationBuilder = OperationBuilder.gBuilder;
        OperationBuilder$OperationType operationBuilder$OperationType = OperationBuilder$OperationType.Add;
        object = operationBuilder.create(operationBuilder$OperationType, (String)object, collection);
        this.addNewOperation((ObjectFieldOperation)object);
    }

    public void addAllUnique(String object, Collection collection) {
        this.validFieldName((String)object);
        OperationBuilder operationBuilder = OperationBuilder.gBuilder;
        OperationBuilder$OperationType operationBuilder$OperationType = OperationBuilder$OperationType.AddUnique;
        object = operationBuilder.create(operationBuilder$OperationType, (String)object, collection);
        this.addNewOperation((ObjectFieldOperation)object);
    }

    public void addNewOperation(ObjectFieldOperation object) {
        if (object == null) {
            return;
        }
        boolean bl2 = this.totallyOverwrite;
        if (bl2) {
            Object object2 = "Delete";
            Object object3 = object.getOperation();
            bl2 = ((String)object2).equalsIgnoreCase((String)object3);
            if (bl2) {
                object3 = this.serverData;
                object = object.getField();
                object3.remove(object);
            } else {
                object3 = this.serverData;
                object2 = object.getField();
                object3 = object3.get(object2);
                if ((object3 = object.apply(object3)) == null) {
                    object3 = this.serverData;
                    object = object.getField();
                    object3.remove(object);
                } else {
                    object2 = this.serverData;
                    object = object.getField();
                    object2.put(object, object3);
                }
            }
        } else {
            bl2 = false;
            Object object4 = null;
            Object object5 = this.operations;
            String string2 = object.getField();
            boolean bl3 = object5.containsKey(string2);
            if (bl3) {
                object4 = this.operations;
                object5 = object.getField();
                object4 = (ObjectFieldOperation)object4.get(object5);
            }
            object5 = this.operations;
            string2 = object.getField();
            object = object.merge((ObjectFieldOperation)object4);
            object5.put(string2, object);
        }
    }

    public void addRelation(AVObject object, String string2) {
        this.validFieldName(string2);
        OperationBuilder operationBuilder = OperationBuilder.gBuilder;
        OperationBuilder$OperationType operationBuilder$OperationType = OperationBuilder$OperationType.AddRelation;
        object = operationBuilder.create(operationBuilder$OperationType, string2, object);
        this.addNewOperation((ObjectFieldOperation)object);
    }

    public void addUnique(String object, Object object2) {
        this.validFieldName((String)object);
        OperationBuilder operationBuilder = OperationBuilder.gBuilder;
        OperationBuilder$OperationType operationBuilder$OperationType = OperationBuilder$OperationType.AddUnique;
        object = operationBuilder.create(operationBuilder$OperationType, (String)object, object2);
        this.addNewOperation((ObjectFieldOperation)object);
    }

    public void bitAnd(String object, long l10) {
        this.validFieldName((String)object);
        OperationBuilder operationBuilder = OperationBuilder.gBuilder;
        OperationBuilder$OperationType operationBuilder$OperationType = OperationBuilder$OperationType.BitAnd;
        Long l11 = l10;
        object = operationBuilder.create(operationBuilder$OperationType, (String)object, l11);
        this.addNewOperation((ObjectFieldOperation)object);
    }

    public void bitOr(String object, long l10) {
        this.validFieldName((String)object);
        OperationBuilder operationBuilder = OperationBuilder.gBuilder;
        OperationBuilder$OperationType operationBuilder$OperationType = OperationBuilder$OperationType.BitOr;
        Long l11 = l10;
        object = operationBuilder.create(operationBuilder$OperationType, (String)object, l11);
        this.addNewOperation((ObjectFieldOperation)object);
    }

    public void bitXor(String object, long l10) {
        this.validFieldName((String)object);
        OperationBuilder operationBuilder = OperationBuilder.gBuilder;
        OperationBuilder$OperationType operationBuilder$OperationType = OperationBuilder$OperationType.BitXor;
        Long l11 = l10;
        object = operationBuilder.create(operationBuilder$OperationType, (String)object, l11);
        this.addNewOperation((ObjectFieldOperation)object);
    }

    public boolean containsKey(String string2) {
        return this.serverData.containsKey(string2);
    }

    public void decrement(String string2) {
        Integer n10 = 1;
        this.decrement(string2, n10);
    }

    public void decrement(String object, Number number) {
        this.validFieldName((String)object);
        OperationBuilder operationBuilder = OperationBuilder.gBuilder;
        OperationBuilder$OperationType operationBuilder$OperationType = OperationBuilder$OperationType.Decrement;
        object = operationBuilder.create(operationBuilder$OperationType, (String)object, number);
        this.addNewOperation((ObjectFieldOperation)object);
    }

    public void delete() {
        this.delete(null);
    }

    public void delete(AVUser aVUser) {
        this.deleteInBackground(aVUser).D();
    }

    public void deleteEventually() {
        this.deleteEventually(null);
    }

    public void deleteEventually(AVUser object) {
        Object object2 = this.getObjectId();
        boolean bl2 = StringUtil.isEmpty((String)object2);
        if (bl2) {
            logger.w("objectId is empty, you couldn't delete a persistent object.");
            return;
        }
        object2 = AppConfiguration.getGlobalNetworkingDetector();
        if (object2 != null && (bl2 = object2.isConnected())) {
            object = this.deleteInBackground((AVUser)object);
            object2 = new AVObject$9(this);
            ((z)object).subscribe((g0)object2);
        } else {
            boolean bl3 = true;
            this.add2ArchivedRequest(bl3);
        }
    }

    public z deleteInBackground() {
        return this.deleteInBackground(null);
    }

    public z deleteInBackground(AVUser aVUser) {
        String string2;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Object object = this.ignoreHooks;
        int n10 = object.size();
        if (n10 > 0) {
            object = this.ignoreHooks;
            string2 = KEY_IGNORE_HOOKS;
            hashMap.put(string2, object);
        }
        if ((n10 = (int)(this.totallyOverwrite ? 1 : 0)) != 0) {
            object = PaasClient.getStorageClient();
            string2 = this.endpointClassName;
            String string3 = this.getObjectId();
            return ((StorageClient)object).deleteWholeObject(aVUser, string2, string3, hashMap);
        }
        object = PaasClient.getStorageClient();
        string2 = this.className;
        String string4 = this.getObjectId();
        return ((StorageClient)object).deleteObject(aVUser, string2, string4, hashMap);
    }

    public void disableAfterHook() {
        Set set = this.ignoreHooks;
        AVObject$Hook aVObject$Hook = AVObject$Hook.afterSave;
        aVObject$Hook = AVObject$Hook.afterUpdate;
        aVObject$Hook = AVObject$Hook.afterDelete;
        AVObject$Hook[] aVObject$HookArray = new AVObject$Hook[]{aVObject$Hook, aVObject$Hook, aVObject$Hook};
        Collections.addAll(set, aVObject$HookArray);
    }

    public void disableBeforeHook() {
        Set set = this.ignoreHooks;
        AVObject$Hook aVObject$Hook = AVObject$Hook.beforeSave;
        aVObject$Hook = AVObject$Hook.beforeUpdate;
        aVObject$Hook = AVObject$Hook.beforeDelete;
        AVObject$Hook[] aVObject$HookArray = new AVObject$Hook[]{aVObject$Hook, aVObject$Hook, aVObject$Hook};
        Collections.addAll(set, aVObject$HookArray);
    }

    public boolean equals(Object object) {
        boolean bl2;
        Object object2;
        Object object3;
        boolean bl3;
        boolean bl4 = true;
        if (this == object) {
            return bl4;
        }
        boolean bl5 = object instanceof AVObject;
        if (!bl5) {
            return false;
        }
        object = (AVObject)object;
        bl5 = this.isFetchWhenSave();
        if (!(bl5 == (bl3 = ((AVObject)object).isFetchWhenSave()) && (bl5 = Objects.equals(object3 = this.getClassName(), object2 = ((AVObject)object).getClassName())) && (bl5 = Objects.equals(object3 = this.getServerData(), object2 = ((AVObject)object).getServerData())) && (bl5 = Objects.equals(object3 = this.operations, object2 = ((AVObject)object).operations)) && (bl2 = Objects.equals(object3 = this.acl, object = ((AVObject)object).acl)))) {
            bl4 = false;
        }
        return bl4;
    }

    /*
     * Enabled aggressive block sorting
     */
    public List extractCascadingObjects(Object objectArray) {
        int n10;
        String string2;
        ArrayList<AVObject> arrayList = new ArrayList<AVObject>();
        int n11 = objectArray instanceof AVObject;
        if (n11 != 0) {
            Object[] objectArray2 = objectArray;
            AVObject aVObject = (AVObject)objectArray;
            string2 = aVObject.getObjectId();
            n10 = StringUtil.isEmpty(string2);
            if (n10 != 0) {
                arrayList.add(aVObject);
                return arrayList;
            }
        }
        if ((n11 = objectArray instanceof Collection) == 0) return arrayList;
        objectArray = ((Collection)objectArray).toArray();
        n11 = objectArray.length;
        n10 = 0;
        string2 = null;
        while (n10 < n11) {
            boolean bl2;
            Object object = objectArray[n10];
            if ((object = this.extractCascadingObjects(object)) != null && !(bl2 = object.isEmpty())) {
                arrayList.addAll((Collection<AVObject>)object);
            }
            ++n10;
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     */
    public List extractUnsavedFiles(Object objectArray) {
        int n10;
        String string2;
        ArrayList<AVFile> arrayList = new ArrayList<AVFile>();
        int n11 = objectArray instanceof AVFile;
        if (n11 != 0) {
            Object[] objectArray2 = objectArray;
            AVFile aVFile = (AVFile)objectArray;
            string2 = aVFile.getObjectId();
            n10 = StringUtil.isEmpty(string2);
            if (n10 != 0) {
                arrayList.add(aVFile);
                return arrayList;
            }
        }
        if ((n11 = objectArray instanceof Collection) == 0) return arrayList;
        objectArray = ((Collection)objectArray).toArray();
        n11 = objectArray.length;
        n10 = 0;
        string2 = null;
        while (n10 < n11) {
            boolean bl2;
            Object object = objectArray[n10];
            if ((object = this.extractUnsavedFiles(object)) != null && !(bl2 = object.isEmpty())) {
                arrayList.addAll((Collection<AVFile>)object);
            }
            ++n10;
        }
        return arrayList;
    }

    public AVObject fetch() {
        return this.fetch(null);
    }

    public AVObject fetch(AVUser aVUser, String string2) {
        this.refresh(aVUser, string2);
        return this;
    }

    public AVObject fetch(String string2) {
        return this.fetch(null, string2);
    }

    public AVObject fetchIfNeeded() {
        this.fetchIfNeededInBackground().D();
        return this;
    }

    public z fetchIfNeededInBackground() {
        int n10;
        Object object = this.getObjectId();
        int n11 = StringUtil.isEmpty((String)object);
        if (n11 == 0 && (n11 = (object = this.serverData).size()) > (n10 = 1)) {
            return z.t3(this);
        }
        return this.refreshInBackground();
    }

    public z fetchIfNeededInBackground(AVUser aVUser, String string2) {
        int n10;
        Object object = this.getObjectId();
        int n11 = StringUtil.isEmpty((String)object);
        if (n11 == 0 && (n11 = (object = this.serverData).size()) > (n10 = 1)) {
            return z.t3(this);
        }
        return this.refreshInBackground(aVUser, string2);
    }

    public z fetchIfNeededInBackground(String string2) {
        return this.fetchIfNeededInBackground(null, string2);
    }

    public z fetchInBackground() {
        return this.refreshInBackground();
    }

    public z fetchInBackground(AVUser aVUser, String string2) {
        return this.refreshInBackground(aVUser, string2);
    }

    public z fetchInBackground(String string2) {
        return this.fetchInBackground(null, string2);
    }

    public AVACL generateACLFromServerData() {
        Object object = this.serverData;
        Object object2 = KEY_ACL;
        boolean bl2 = object.containsKey(object2);
        if (!bl2) {
            object = new AVACL();
            return object;
        }
        object = this.serverData.get(object2);
        boolean bl3 = object instanceof HashMap;
        if (bl3) {
            object = (HashMap)object;
            object2 = new AVACL((HashMap)object);
            return object2;
        }
        object = new AVACL();
        return object;
    }

    public z generateCascadingSaveObjects() {
        boolean bl2;
        Object object = new ArrayList();
        Object object2 = this.operations.values().iterator();
        while (bl2 = object2.hasNext()) {
            boolean bl3;
            Object object3 = ((ObjectFieldOperation)object2.next()).getValue();
            if ((object3 = this.extractCascadingObjects(object3)) == null || (bl3 = object3.isEmpty())) continue;
            object.addAll(object3);
        }
        object = z.t3(object);
        object2 = b.d();
        return ((z)object).L5((h0)object2);
    }

    public JSONObject generateChangedParam() {
        boolean bl2;
        Object object;
        int n10;
        Object object2;
        boolean bl3;
        boolean bl4 = this.totallyOverwrite;
        ArrayList arrayList = KEY_IGNORE_HOOKS;
        if (bl4) {
            boolean bl5;
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            Object object3 = this.serverData.entrySet().iterator();
            while (bl5 = object3.hasNext()) {
                Object object4 = object3.next();
                String string2 = (String)object4.getKey();
                object4 = BaseOperation.encodeObject(object4.getValue());
                hashMap.put(string2, object4);
            }
            hashMap.remove(KEY_CREATED_AT);
            hashMap.remove(KEY_UPDATED_AT);
            hashMap.remove(KEY_OBJECT_ID);
            object3 = this.ignoreHooks;
            int n11 = object3.size();
            if (n11 > 0) {
                object3 = this.ignoreHooks;
                hashMap.put(arrayList, object3);
            }
            return JSONObject$Builder.create(hashMap);
        }
        Map map = new Map();
        Object object5 = this.operations.entrySet().iterator();
        while (bl3 = object5.hasNext()) {
            object2 = ((ObjectFieldOperation)object5.next().getValue()).encode();
            map.putAll(object2);
        }
        object5 = this.acl;
        if (object5 != null && (n10 = (int)(((AVACL)(object2 = this.acl)).equals(object5 = this.generateACLFromServerData()) ? 1 : 0)) == 0) {
            object5 = OperationBuilder.gBuilder;
            object2 = OperationBuilder$OperationType.Set;
            object = this.acl;
            String string3 = KEY_ACL;
            object5 = ((OperationBuilder)object5).create((OperationBuilder$OperationType)((Object)object2), string3, object).encode();
            map.putAll(object5);
        }
        if ((n10 = (object5 = this.ignoreHooks).size()) > 0) {
            object5 = this.ignoreHooks;
            map.put((String)((Object)arrayList), object5);
        }
        if (!(bl2 = this.needBatchMode())) {
            return JSONObject$Builder.create(map);
        }
        arrayList = new ArrayList();
        object5 = this.getObjectId();
        map = Utils.makeCompletedRequest((String)object5, (String)(object2 = this.getRequestRawEndpoint()), (String)(object = this.getRequestMethod()), map);
        if (map != null) {
            arrayList.add(map);
        }
        map = this.operations.values().iterator();
        while ((n10 = (int)(map.hasNext() ? 1 : 0)) != 0) {
            object5 = (ObjectFieldOperation)map.next();
            bl3 = object5 instanceof CompoundOperation;
            if (!bl3 || (object5 = ((CompoundOperation)object5).encodeRestOp(this)) == null || (bl3 = object5.isEmpty())) continue;
            arrayList.addAll(object5);
        }
        map = new Map(1);
        map.put("requests", arrayList);
        return JSONObject$Builder.create(map);
    }

    public Object get(String string2) {
        return this.internalGet(string2);
    }

    public AVACL getACL() {
        synchronized (this) {
            AVACL aVACL = this.acl;
            if (aVACL == null) {
                this.acl = aVACL = this.generateACLFromServerData();
            }
            aVACL = this.acl;
            return aVACL;
        }
    }

    public AVFile getAVFile(String string2) {
        return (AVFile)this.get(string2);
    }

    public AVGeoPoint getAVGeoPoint(String string2) {
        return (AVGeoPoint)this.get(string2);
    }

    public AVObject getAVObject(String object) {
        try {
            object = this.get((String)object);
        }
        catch (Exception exception) {
            logger.w("failed to convert Object.", exception);
            return null;
        }
        return (AVObject)object;
    }

    public boolean getBoolean(String object) {
        boolean bl2;
        if ((object = (Boolean)this.get((String)object)) == null) {
            bl2 = false;
            object = null;
        } else {
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public byte[] getBytes(String string2) {
        return (byte[])this.get(string2);
    }

    public String getClassName() {
        return this.className;
    }

    public Date getCreatedAt() {
        return StringUtil.dateFromString(this.getCreatedAtString());
    }

    public String getCreatedAtString() {
        return (String)this.serverData.get(KEY_CREATED_AT);
    }

    public Date getDate(String object) {
        boolean bl2 = (object = this.get((String)object)) instanceof Date;
        if (bl2) {
            return (Date)object;
        }
        bl2 = object instanceof Long;
        if (bl2) {
            long l10 = (Long)object;
            Date date = new Date(l10);
            return date;
        }
        bl2 = object instanceof String;
        if (bl2) {
            return StringUtil.dateFromString((String)object);
        }
        bl2 = object instanceof JSONObject;
        if (bl2) {
            object = (JSONObject)object;
            AVDate aVDate = new AVDate((JSONObject)object);
            return aVDate.getDate();
        }
        bl2 = object instanceof Map;
        if (bl2) {
            object = JSONObject$Builder.create((Map)object);
            AVDate aVDate = new AVDate((JSONObject)object);
            return aVDate.getDate();
        }
        return null;
    }

    public double getDouble(String object) {
        if ((object = (Number)this.get((String)object)) != null) {
            return ((Number)object).doubleValue();
        }
        return 0.0;
    }

    public int getInt(String object) {
        if ((object = (Number)this.get((String)object)) != null) {
            return ((Number)object).intValue();
        }
        return 0;
    }

    public JSONArray getJSONArray(String objectArray) {
        objectArray = this.get((String)objectArray);
        JSONArray jSONArray = null;
        if (objectArray == null) {
            return null;
        }
        int n10 = objectArray instanceof JSONArray;
        if (n10 != 0) {
            return (JSONArray)objectArray;
        }
        n10 = objectArray instanceof List;
        if (n10 != 0) {
            return JSONArray$Builder.create((List)objectArray);
        }
        n10 = objectArray instanceof Object[];
        if (n10 != 0) {
            jSONArray = JSONArray$Builder.create(null);
            for (Object object : (Object[])objectArray) {
                jSONArray.add(object);
            }
        }
        return jSONArray;
    }

    public JSONObject getJSONObject(String object) {
        boolean bl2 = (object = this.get((String)object)) instanceof JSONObject;
        if (bl2) {
            return (JSONObject)object;
        }
        object = JSON.toJSONString(object);
        try {
            return JSON.parseObject((String)object);
        }
        catch (Exception exception) {
            IllegalStateException illegalStateException = new IllegalStateException("Invalid json string", exception);
            throw illegalStateException;
        }
    }

    public List getList(String string2) {
        return (List)this.get(string2);
    }

    public long getLong(String object) {
        if ((object = (Number)this.get((String)object)) != null) {
            return ((Number)object).longValue();
        }
        return 0L;
    }

    public Number getNumber(String string2) {
        return (Number)this.get(string2);
    }

    public String getObjectId() {
        ConcurrentMap concurrentMap = this.serverData;
        String string2 = KEY_OBJECT_ID;
        boolean bl2 = concurrentMap.containsKey(string2);
        if (bl2) {
            return (String)this.serverData.get(string2);
        }
        return this.objectId;
    }

    public AVRelation getRelation(String string2) {
        this.validFieldName(string2);
        Object object = this.get(string2);
        boolean bl2 = object instanceof AVRelation;
        if (bl2) {
            object = (AVRelation)object;
            ((AVRelation)object).setParent(this);
            ((AVRelation)object).setKey(string2);
            return object;
        }
        object = new AVRelation(this, string2);
        return object;
    }

    public String getRequestMethod() {
        String string2 = this.getObjectId();
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return "POST";
        }
        return "PUT";
    }

    public String getRequestRawEndpoint() {
        CharSequence charSequence = this.getObjectId();
        boolean bl2 = StringUtil.isEmpty((String)charSequence);
        String string2 = "/1.1/classes/";
        if (bl2) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            string2 = this.getClassName();
            ((StringBuilder)charSequence).append(string2);
            return ((StringBuilder)charSequence).toString();
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string2);
        string2 = this.getClassName();
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append("/");
        string2 = this.getObjectId();
        ((StringBuilder)charSequence).append(string2);
        return ((StringBuilder)charSequence).toString();
    }

    public ConcurrentMap getServerData() {
        return this.serverData;
    }

    public String getString(String object) {
        boolean bl2 = (object = this.get((String)object)) instanceof String;
        if (bl2) {
            return (String)object;
        }
        return null;
    }

    public List getUnsavedFiles() {
        boolean bl2;
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = this.operations.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            Object object = ((ObjectFieldOperation)iterator2.next()).getValue();
            if ((object = this.extractUnsavedFiles(object)) == null || (bl3 = object.isEmpty())) continue;
            arrayList.addAll(object);
        }
        return arrayList;
    }

    public Date getUpdatedAt() {
        return StringUtil.dateFromString(this.getUpdatedAtString());
    }

    public String getUpdatedAtString() {
        return (String)this.serverData.get(KEY_UPDATED_AT);
    }

    public String getUuid() {
        String string2 = this.uuid;
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            this.uuid = string2 = UUID.randomUUID().toString().toLowerCase();
        }
        return this.uuid;
    }

    public boolean has(String object) {
        boolean bl2;
        if ((object = this.get((String)object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean hasCircleReference(Map map) {
        boolean bl2;
        if (map == null) {
            return false;
        }
        Object object = Boolean.TRUE;
        map.put(this, object);
        object = this.operations.values().iterator();
        block0: while (true) {
            boolean bl3;
            bl2 = false;
            while (bl3 = object.hasNext()) {
                ObjectFieldOperation objectFieldOperation = (ObjectFieldOperation)object.next();
                if (!bl2 && !(bl2 = objectFieldOperation.checkCircleReference(map))) continue block0;
                bl2 = true;
            }
            break;
        }
        return bl2;
    }

    public int hashCode() {
        Object object = this.getClassName();
        Object[] objectArray = new Object[]{object, object = this.getServerData(), object = this.operations, object = this.acl, object = Boolean.valueOf(this.isFetchWhenSave())};
        return Objects.hash(objectArray);
    }

    public void ignoreHook(AVObject$Hook aVObject$Hook) {
        this.ignoreHooks.add(aVObject$Hook);
    }

    public void increment(String string2) {
        Integer n10 = 1;
        this.increment(string2, n10);
    }

    public void increment(String object, Number number) {
        this.validFieldName((String)object);
        OperationBuilder operationBuilder = OperationBuilder.gBuilder;
        OperationBuilder$OperationType operationBuilder$OperationType = OperationBuilder$OperationType.Increment;
        object = operationBuilder.create(operationBuilder$OperationType, (String)object, number);
        this.addNewOperation((ObjectFieldOperation)object);
    }

    public String internalClassName() {
        return this.getClassName();
    }

    public Object internalGet(String object) {
        Object object2 = this.serverData.get(object);
        ConcurrentMap concurrentMap = this.operations;
        if ((object = (ObjectFieldOperation)concurrentMap.get(object)) != null) {
            object2 = object.apply(object2);
        }
        return object2;
    }

    public String internalId() {
        String string2 = this.getObjectId();
        boolean bl2 = StringUtil.isEmpty(string2);
        string2 = bl2 ? this.getUuid() : this.getObjectId();
        return string2;
    }

    public void internalPut(String object, Object object2) {
        OperationBuilder operationBuilder = OperationBuilder.gBuilder;
        OperationBuilder$OperationType operationBuilder$OperationType = OperationBuilder$OperationType.Set;
        object = operationBuilder.create(operationBuilder$OperationType, (String)object, object2);
        this.addNewOperation((ObjectFieldOperation)object);
    }

    public boolean isDataAvailable() {
        Object object = this.objectId;
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2 && !(bl2 = (object = this.serverData).isEmpty())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean isFetchWhenSave() {
        return this.fetchWhenSave;
    }

    public void mergeRawData(AVObject iterator2, boolean bl2) {
        boolean bl3;
        Object object;
        if (iterator2 != null) {
            object = this.serverData;
            iterator2 = ((AVObject)iterator2).serverData;
            object.putAll(iterator2);
        }
        if (!bl2 && (bl3 = AppConfiguration.isAutoMergeOperationDataWhenSave())) {
            iterator2 = this.operations.entrySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                String string2 = (String)iterator2.next().getKey();
                object = this.internalGet(string2);
                if (object == null) {
                    object = this.serverData;
                    object.remove(string2);
                    continue;
                }
                ConcurrentMap concurrentMap = this.serverData;
                concurrentMap.put(string2, object);
            }
        }
    }

    public void onDataSynchronized() {
    }

    public void onSaveFailure() {
    }

    public void onSaveSuccess() {
        this.operations.clear();
    }

    public void put(String string2, Object object) {
        this.validFieldName(string2);
        this.internalPut(string2, object);
    }

    public void refresh() {
        this.refresh(null);
    }

    public void refresh(AVUser aVUser, String string2) {
        this.refreshInBackground(aVUser, string2).D();
    }

    public void refresh(String string2) {
        this.refreshInBackground(string2).D();
    }

    public z refreshInBackground() {
        return this.refreshInBackground(null, null);
    }

    public z refreshInBackground(AVUser aVUser) {
        return this.refreshInBackground(aVUser, null);
    }

    public z refreshInBackground(AVUser object, String object2) {
        boolean bl2 = this.totallyOverwrite;
        if (bl2) {
            StorageClient storageClient = PaasClient.getStorageClient();
            String string2 = this.endpointClassName;
            String string3 = this.getObjectId();
            object = storageClient.getWholeObject((AVUser)object, string2, string3, (String)object2);
            object2 = new AVObject$10(this);
            return ((z)object).H3((o)object2);
        }
        Object object3 = PaasClient.getStorageClient();
        String string4 = this.className;
        String string5 = this.getObjectId();
        object = ((StorageClient)object3).fetchObject((AVUser)object, string4, string5, (String)object2);
        object3 = new AVObject$11(this, (String)object2);
        return ((z)object).H3((o)object3);
    }

    public z refreshInBackground(String string2) {
        return this.refreshInBackground(null, string2);
    }

    public void remove(String object) {
        this.validFieldName((String)object);
        OperationBuilder operationBuilder = OperationBuilder.gBuilder;
        OperationBuilder$OperationType operationBuilder$OperationType = OperationBuilder$OperationType.Delete;
        object = operationBuilder.create(operationBuilder$OperationType, (String)object, null);
        this.addNewOperation((ObjectFieldOperation)object);
    }

    public void removeAll(String object, Collection collection) {
        this.validFieldName((String)object);
        OperationBuilder operationBuilder = OperationBuilder.gBuilder;
        OperationBuilder$OperationType operationBuilder$OperationType = OperationBuilder$OperationType.Remove;
        object = operationBuilder.create(operationBuilder$OperationType, (String)object, collection);
        this.addNewOperation((ObjectFieldOperation)object);
    }

    public void removeOperationForKey(String string2) {
        this.operations.remove(string2);
    }

    public void removeRelation(AVObject object, String string2) {
        this.validFieldName(string2);
        OperationBuilder operationBuilder = OperationBuilder.gBuilder;
        OperationBuilder$OperationType operationBuilder$OperationType = OperationBuilder$OperationType.RemoveRelation;
        object = operationBuilder.create(operationBuilder$OperationType, string2, object);
        this.addNewOperation((ObjectFieldOperation)object);
    }

    public void resetAll() {
        this.objectId = "";
        this.acl = null;
        this.serverData.clear();
        this.operations.clear();
    }

    public void resetByRawData(AVObject object) {
        this.resetAll();
        if (object != null) {
            ConcurrentMap concurrentMap = this.serverData;
            ConcurrentMap concurrentMap2 = ((AVObject)object).serverData;
            concurrentMap.putAll(concurrentMap2);
            concurrentMap = this.operations;
            object = ((AVObject)object).operations;
            concurrentMap.putAll(object);
        }
    }

    public void resetServerData(Map map) {
        this.serverData.clear();
        AVUtils.mergeConcurrentMap(this.serverData, map);
        this.operations.clear();
    }

    public void save() {
        this.save(null);
    }

    public void save(AVUser aVUser) {
        this.saveInBackground(aVUser).D();
    }

    public void saveEventually() {
        this.saveEventually(null);
    }

    public void saveEventually(AVUser object) {
        Object object2 = this.operations;
        boolean bl2 = object2.isEmpty();
        if (bl2) {
            return;
        }
        object2 = new HashMap();
        bl2 = this.hasCircleReference((Map)object2);
        if (!bl2) {
            object2 = AppConfiguration.getGlobalNetworkingDetector();
            if (object2 != null && (bl2 = object2.isConnected())) {
                object = this.saveInBackground((AVUser)object);
                object2 = new AVObject$8(this);
                ((z)object).subscribe((g0)object2);
            } else {
                object = null;
                this.add2ArchivedRequest(false);
            }
            return;
        }
        object = new AVException(100001, "Found a circular dependency when saving.");
        throw object;
    }

    public z saveInBackground() {
        return this.saveInBackground((AVUser)null);
    }

    public z saveInBackground(AVSaveOption aVSaveOption) {
        return this.saveInBackground(null, aVSaveOption);
    }

    public z saveInBackground(AVUser aVUser) {
        AVSaveOption aVSaveOption;
        boolean bl2 = this.totallyOverwrite;
        if (bl2) {
            aVSaveOption = new AVSaveOption();
            boolean bl3 = true;
            aVSaveOption.setFetchWhenSave(bl3);
        } else {
            bl2 = false;
            aVSaveOption = null;
        }
        return this.saveInBackground(aVUser, aVSaveOption);
    }

    public z saveInBackground(AVUser object, AVSaveOption aVSaveOption) {
        Object object2 = new HashMap();
        boolean bl2 = this.hasCircleReference((Map)object2);
        if (bl2) {
            object = new AVException(100001, "Found a circular dependency when saving.");
            return z.m2((Throwable)object);
        }
        object2 = this.generateCascadingSaveObjects();
        AVObject$6 aVObject$6 = new AVObject$6(this, (AVUser)object, aVSaveOption);
        return ((z)object2).s2(aVObject$6);
    }

    public void setACL(AVACL aVACL) {
        synchronized (this) {
            this.acl = aVACL;
            return;
        }
    }

    public void setClassName(String string2) {
        Transformer.checkClassName(string2);
        this.className = string2;
    }

    public void setFetchWhenSave(boolean bl2) {
        this.fetchWhenSave = bl2;
    }

    public void setObjectId(String string2) {
        boolean bl2;
        this.objectId = string2;
        ConcurrentMap concurrentMap = this.serverData;
        if (concurrentMap != null && !(bl2 = StringUtil.isEmpty(string2))) {
            concurrentMap = this.serverData;
            String string3 = KEY_OBJECT_ID;
            concurrentMap.put(string3, string2);
        }
    }

    public void setUuid(String string2) {
        this.uuid = string2;
    }

    public JSONObject toJSONObject() {
        return JSONObject$Builder.create(this.serverData);
    }

    public String toJSONString() {
        return JSON.toJSONString(this);
    }

    public String toString() {
        return this.toJSONString();
    }

    public void validFieldName(String object) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            Object object2 = "_";
            bl2 = ((String)object).startsWith((String)object2);
            if (!bl2) {
                object2 = RESERVED_ATTRS;
                bl2 = object2.contains(object);
                if (!bl2) {
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("key(");
                stringBuilder.append((String)object);
                stringBuilder.append(") is reserved by LeanCloud");
                object = stringBuilder.toString();
                object2 = new IllegalArgumentException((String)object);
                throw object2;
            }
            object = new IllegalArgumentException("key should not start with '_'");
            throw object;
        }
        object = new IllegalArgumentException("Blank key");
        throw object;
    }
}

