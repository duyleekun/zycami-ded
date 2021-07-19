/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVFriendshipRequest;
import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.AVQuery$CachePolicy;
import cn.leancloud.AVUser;
import cn.leancloud.cache.QueryResultCache;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.core.AppConfiguration$SchedulerCreator;
import cn.leancloud.core.StorageClient$1;
import cn.leancloud.core.StorageClient$10;
import cn.leancloud.core.StorageClient$11;
import cn.leancloud.core.StorageClient$12;
import cn.leancloud.core.StorageClient$13;
import cn.leancloud.core.StorageClient$14;
import cn.leancloud.core.StorageClient$15;
import cn.leancloud.core.StorageClient$16;
import cn.leancloud.core.StorageClient$17;
import cn.leancloud.core.StorageClient$18;
import cn.leancloud.core.StorageClient$19;
import cn.leancloud.core.StorageClient$2;
import cn.leancloud.core.StorageClient$20;
import cn.leancloud.core.StorageClient$21;
import cn.leancloud.core.StorageClient$22;
import cn.leancloud.core.StorageClient$23;
import cn.leancloud.core.StorageClient$24;
import cn.leancloud.core.StorageClient$25;
import cn.leancloud.core.StorageClient$26;
import cn.leancloud.core.StorageClient$27;
import cn.leancloud.core.StorageClient$28;
import cn.leancloud.core.StorageClient$29;
import cn.leancloud.core.StorageClient$3;
import cn.leancloud.core.StorageClient$30;
import cn.leancloud.core.StorageClient$31;
import cn.leancloud.core.StorageClient$4;
import cn.leancloud.core.StorageClient$5;
import cn.leancloud.core.StorageClient$6;
import cn.leancloud.core.StorageClient$7;
import cn.leancloud.core.StorageClient$8;
import cn.leancloud.core.StorageClient$9;
import cn.leancloud.core.StorageClient$QueryExecutor;
import cn.leancloud.json.JSONObject;
import cn.leancloud.json.JSONObject$Builder;
import cn.leancloud.service.APIService;
import cn.leancloud.sms.AVCaptchaOption;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import e.a.c1.b;
import e.a.h0;
import e.a.v0.o;
import e.a.z;
import java.util.HashMap;
import java.util.Map;

public class StorageClient {
    private static AVLogger LOGGER = LogUtil.getLogger(StorageClient.class);
    private APIService apiService = null;
    private boolean asynchronized = false;
    private AVUser currentUser;
    private AppConfiguration$SchedulerCreator defaultCreator = null;
    private QueryResultCache queryResultCache;

    public StorageClient(APIService aPIService, boolean bl2, AppConfiguration$SchedulerCreator appConfiguration$SchedulerCreator) {
        QueryResultCache queryResultCache;
        this.queryResultCache = queryResultCache = QueryResultCache.getInstance();
        this.currentUser = null;
        this.apiService = aPIService;
        this.asynchronized = bl2;
        this.defaultCreator = appConfiguration$SchedulerCreator;
    }

    public static /* synthetic */ AVLogger access$000() {
        return LOGGER;
    }

    public static /* synthetic */ z access$100(StorageClient storageClient, AVUser aVUser, String string2, Map map) {
        return storageClient.queryRemoteServer(aVUser, string2, map);
    }

    public static /* synthetic */ void access$200(StorageClient storageClient, JSONObject jSONObject, AVUser aVUser) {
        storageClient.attachLoginInfo(jSONObject, aVUser);
    }

    private void attachLoginInfo(JSONObject object, AVUser aVUser) {
        if (object != null && aVUser != null) {
            String string2 = "email";
            boolean bl2 = object.containsKey(string2);
            if (bl2) {
                string2 = ((JSONObject)object).getString(string2);
                aVUser.setEmail(string2);
            }
            if (bl2 = object.containsKey(string2 = "username")) {
                string2 = ((JSONObject)object).getString(string2);
                aVUser.setUsername(string2);
            }
            if (bl2 = object.containsKey(string2 = "mobilePhoneNumber")) {
                object = ((JSONObject)object).getString(string2);
                aVUser.setMobilePhoneNumber((String)object);
            }
        }
    }

    private String getSessionToken(AVUser aVUser) {
        if (aVUser == null) {
            boolean bl2 = AppConfiguration.isIncognitoMode();
            if (!bl2 && (aVUser = AVUser.currentUser()) != null) {
                return AVUser.currentUser().getSessionToken();
            }
            return "";
        }
        return aVUser.getSessionToken();
    }

    private z queryRemoteServer(AVUser object, String string2, Map map) {
        object = this.getSessionToken((AVUser)object);
        String string3 = "_User";
        boolean bl2 = string3.equalsIgnoreCase(string2);
        if (bl2) {
            object = this.apiService.queryUsers((String)object, map);
            return this.wrapObservable((z)object);
        }
        object = this.apiService.queryObjects((String)object, string2, map);
        return this.wrapObservable((z)object);
    }

    private z wrapObservableInBackground(z z10) {
        AppConfiguration$SchedulerCreator appConfiguration$SchedulerCreator;
        if (z10 == null) {
            return null;
        }
        h0 h02 = b.d();
        boolean bl2 = this.asynchronized;
        if (bl2) {
            z10 = z10.L5(h02);
        }
        if ((appConfiguration$SchedulerCreator = this.defaultCreator) != null) {
            z10 = z10.i4(h02);
        }
        return z10;
    }

    public z acceptFriendshipRequest(AVUser object, AVFriendshipRequest object2, JSONObject jSONObject) {
        object = this.getSessionToken((AVUser)object);
        APIService aPIService = this.apiService;
        object2 = ((AVObject)object2).getObjectId();
        object = aPIService.acceptFriendshipRequest((String)object, (String)object2, jSONObject);
        if ((object = this.wrapObservable((z)object)) == null) {
            return null;
        }
        object2 = new StorageClient$15(this);
        return ((z)object).H3((o)object2);
    }

    public z applyFriendshipRequest(AVUser object, JSONObject object2) {
        object = this.getSessionToken((AVUser)object);
        APIService aPIService = this.apiService;
        object = aPIService.applyFriendship((String)object, (JSONObject)object2);
        if ((object = this.wrapObservable((z)object)) == null) {
            return null;
        }
        object2 = new StorageClient$14(this);
        return ((z)object).H3((o)object2);
    }

    public z batchSave(AVUser object, JSONObject jSONObject) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.batchCreate((String)object, jSONObject);
        return this.wrapObservable((z)object);
    }

    public z batchUpdate(AVUser object, JSONObject jSONObject) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.batchUpdate((String)object, jSONObject);
        return this.wrapObservable((z)object);
    }

    public z callFunction(AVUser aVUser, String string2, Map map) {
        return this.callFunction(aVUser, string2, map, false, null);
    }

    public z callFunction(AVUser object, String object2, Map map, boolean bl2, String string2) {
        object = this.getSessionToken((AVUser)object);
        APIService aPIService = this.apiService;
        object = aPIService.cloudFunction((String)object, (String)object2, map);
        if ((object = this.wrapObservable((z)object)) == null) {
            return null;
        }
        object2 = new StorageClient$24(this, bl2, string2);
        return ((z)object).H3((o)object2);
    }

    public z callFunctionWithCachePolicy(AVUser aVUser, String string2, Map map, AVQuery$CachePolicy aVQuery$CachePolicy, long l10) {
        String string3 = QueryResultCache.generateCachedKey(string2, map);
        StorageClient$29 storageClient$29 = new StorageClient$29(this, string2, string3, l10);
        StorageClient$30 storageClient$30 = new StorageClient$30(this, aVUser, string2, map, aVQuery$CachePolicy, string3);
        return this.executeCachedQuery(string2, map, aVQuery$CachePolicy, l10, storageClient$29, storageClient$30);
    }

    public z callRPC(AVUser aVUser, String string2, Object object) {
        return this.callRPC(aVUser, string2, object, false, null);
    }

    public z callRPC(AVUser object, String object2, Object object3, boolean bl2, String string2) {
        object = this.getSessionToken((AVUser)object);
        APIService aPIService = this.apiService;
        object = aPIService.cloudRPC((String)object, (String)object2, object3);
        if ((object = this.wrapObservable((z)object)) == null) {
            return null;
        }
        object2 = new StorageClient$23(this, bl2, string2);
        return ((z)object).H3((o)object2);
    }

    public z callRPCWithCachePolicy(AVUser aVUser, String string2, Map map, AVQuery$CachePolicy aVQuery$CachePolicy, long l10) {
        String string3 = QueryResultCache.generateCachedKey(string2, map);
        StorageClient$27 storageClient$27 = new StorageClient$27(this, string2, string3, l10);
        StorageClient$28 storageClient$28 = new StorageClient$28(this, aVUser, string2, map, aVQuery$CachePolicy, string3);
        return this.executeCachedQuery(string2, map, aVQuery$CachePolicy, l10, storageClient$27, storageClient$28);
    }

    public z checkAuthenticated(String object) {
        int n10 = 1;
        Object object2 = new HashMap(n10);
        object2.put("session_token", object);
        APIService aPIService = this.apiService;
        object = aPIService.checkAuthenticated((String)object, (Map)object2);
        object = this.wrapObservable((z)object);
        if (object == null) {
            return z.t3(Boolean.FALSE);
        }
        object2 = new StorageClient$17(this);
        return ((z)object).H3((o)object2);
    }

    public z cloudQuery(AVUser object, Map map) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.cloudQuery((String)object, map);
        return this.wrapObservable((z)object);
    }

    public z createObject(AVUser object, String string2, JSONObject object2, boolean bl2, JSONObject jSONObject) {
        String string3 = this.getSessionToken((AVUser)object);
        APIService aPIService = this.apiService;
        object = aPIService.createObject(string3, string2, (JSONObject)object2, bl2, jSONObject);
        if ((object = this.wrapObservable((z)object)) == null) {
            return null;
        }
        object2 = new StorageClient$8(this, string2);
        return ((z)object).H3((o)object2);
    }

    public z createUserBySession(String object, Class clazz) {
        Object object2 = new HashMap(1);
        object2.put("session_token", object);
        object = this.apiService.checkAuthenticated((String)object, (Map)object2);
        object = this.wrapObservable((z)object);
        object2 = new StorageClient$18(this, clazz);
        return ((z)object).H3((o)object2);
    }

    public z declineFriendshipRequest(AVUser object, AVFriendshipRequest object2) {
        object = this.getSessionToken((AVUser)object);
        APIService aPIService = this.apiService;
        object2 = ((AVObject)object2).getObjectId();
        object = aPIService.declineFriendshipRequest((String)object, (String)object2);
        object = this.wrapObservable((z)object);
        object2 = new StorageClient$16(this);
        return ((z)object).H3((o)object2);
    }

    public z deleteInboxStatus(AVUser object, Map map) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.deleteInboxStatus((String)object, map);
        return this.wrapObservable((z)object);
    }

    public z deleteObject(AVUser object, String string2, String string3, Map map) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.deleteObject((String)object, string2, string3, map);
        return this.wrapObservable((z)object);
    }

    public z deleteStatus(AVUser object, String string2) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.deleteStatus((String)object, string2);
        return this.wrapObservable((z)object);
    }

    public z deleteWholeObject(AVUser object, String string2, String string3, Map map) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.deleteWholeObject((String)object, string2, string3, map);
        return this.wrapObservable((z)object);
    }

    public z executeCachedQuery(String object, Map object2, AVQuery$CachePolicy aVQuery$CachePolicy, long l10, StorageClient$QueryExecutor storageClient$QueryExecutor, StorageClient$QueryExecutor storageClient$QueryExecutor2) {
        object = StorageClient$31.$SwitchMap$cn$leancloud$AVQuery$CachePolicy;
        int n10 = aVQuery$CachePolicy.ordinal();
        Object object3 = object[n10];
        if (object3 != (n10 = 1)) {
            n10 = 2;
            if (object3 != n10) {
                n10 = 3;
                if (object3 != n10) {
                    object = storageClient$QueryExecutor2.executor();
                } else {
                    object = storageClient$QueryExecutor2.executor();
                    object2 = new StorageClient$26(this, storageClient$QueryExecutor);
                    object = ((z)object).n4((o)object2);
                }
            } else {
                object = storageClient$QueryExecutor.executor();
                object2 = new StorageClient$25(this, storageClient$QueryExecutor2);
                object = ((z)object).n4((o)object2);
            }
        } else {
            object = storageClient$QueryExecutor.executor();
        }
        return object;
    }

    public z fetchFile(AVUser object, String object2) {
        object = this.getSessionToken((AVUser)object);
        APIService aPIService = this.apiService;
        object = aPIService.fetchFile((String)object, (String)object2);
        if ((object = this.wrapObservable((z)object)) == null) {
            return null;
        }
        object2 = new StorageClient$11(this);
        return ((z)object).H3((o)object2);
    }

    public z fetchObject(AVUser object, String string2, String object2, String object3) {
        object = this.getSessionToken((AVUser)object);
        boolean bl2 = StringUtil.isEmpty((String)object3);
        if (bl2) {
            object3 = this.apiService;
            object = object3.fetchObject((String)object, string2, (String)object2);
            object = this.wrapObservable((z)object);
        } else {
            APIService aPIService = this.apiService;
            object = aPIService.fetchObject((String)object, string2, (String)object2, (String)object3);
            object = this.wrapObservable((z)object);
        }
        if (object == null) {
            return object;
        }
        object2 = new StorageClient$2(this, string2);
        return ((z)object).H3((o)object2);
    }

    public z fetchStatus(AVUser object, String string2) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.fetchSingleStatus((String)object, string2);
        return this.wrapObservable((z)object);
    }

    public void fileCallback(AVUser object, JSONObject jSONObject) {
        object = this.getSessionToken((AVUser)object);
        this.apiService.fileCallback((String)object, jSONObject).execute();
    }

    public z followUser(AVUser object, String string2, String string3, Map map) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.followUser((String)object, string2, string3, map);
        return this.wrapObservable((z)object);
    }

    public AVUser getCurrentUser() {
        return this.currentUser;
    }

    public z getFollowersAndFollowees(AVUser object, String string2) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.getFollowersAndFollowees((String)object, string2);
        return this.wrapObservable((z)object);
    }

    public z getInboxCount(AVUser object, Map map) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.getInboxCount((String)object, map);
        return this.wrapObservable((z)object);
    }

    public z getServerTime() {
        z z10 = this.apiService.currentTimeMillis();
        return this.wrapObservable(z10);
    }

    public z getWholeObject(AVUser object, String string2, String string3, String string4) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.getWholeObject((String)object, string2, string3, string4);
        return this.wrapObservable((z)object);
    }

    public boolean hasCachedResult(String string2, Map map, long l10) {
        return QueryResultCache.getInstance().hasCachedResult(string2, map, l10);
    }

    public z logIn(JSONObject jSONObject, Class clazz) {
        z z10 = this.apiService.login(jSONObject);
        if ((z10 = this.wrapObservable(z10)) == null) {
            return null;
        }
        StorageClient$13 storageClient$13 = new StorageClient$13(this, clazz, jSONObject);
        return z10.H3(storageClient$13);
    }

    public z newUploadToken(AVUser object, JSONObject jSONObject) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.createUploadToken((String)object, jSONObject);
        return this.wrapObservableInBackground((z)object);
    }

    public z postStatus(AVUser object, Map map) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.postStatus((String)object, map);
        return this.wrapObservable((z)object);
    }

    public z queryCount(AVUser object, String object2, Map map) {
        if ((object = this.queryRemoteServer((AVUser)object, (String)object2, map)) == null) {
            return null;
        }
        object2 = new StorageClient$7(this);
        return ((z)object).H3((o)object2);
    }

    public z queryInbox(AVUser object, Map object2) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.queryInbox((String)object, (Map)object2);
        object2 = new StorageClient$22(this);
        object = ((z)object).H3((o)object2);
        return this.wrapObservable((z)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public z queryObjects(AVUser aVUser, String string2, Map map, AVQuery$CachePolicy aVQuery$CachePolicy, long l10) {
        Object object = QueryResultCache.generateKeyForQueryCondition(string2, map);
        Object object2 = StorageClient$31.$SwitchMap$cn$leancloud$AVQuery$CachePolicy;
        int n10 = aVQuery$CachePolicy.ordinal();
        int n11 = object2[n10];
        if (n11 != (n10 = 1)) {
            StorageClient$3 storageClient$3;
            n10 = 2;
            if (n11 != n10) {
                StorageClient$4 storageClient$4;
                n10 = 3;
                if (n11 != n10) {
                    object2 = this.queryRemoteServer(aVUser, string2, map);
                    if (object2 == null) return null;
                    StorageClient$6 storageClient$6 = new StorageClient$6(this, string2, (String)object);
                    return ((z)object2).H3(storageClient$6);
                }
                object2 = this.queryRemoteServer(aVUser, string2, map);
                if (object2 == null) return null;
                Object object3 = new StorageClient$5(this, string2, (String)object);
                object = ((z)object2).H3((o)object3);
                object2 = storageClient$4;
                object3 = this;
                storageClient$4 = new StorageClient$4(this, string2, map, l10);
                return ((z)object).n4(storageClient$4);
            }
            object2 = QueryResultCache.getInstance();
            boolean bl2 = false;
            Object object4 = string2;
            object2 = ((QueryResultCache)object2).getCacheResult(string2, map, l10, false);
            z z10 = this.wrapObservable((z)object2);
            object2 = storageClient$3;
            object4 = this;
            storageClient$3 = new StorageClient$3(this, aVUser, string2, map, (String)object);
            return z10.n4(storageClient$3);
        }
        object2 = QueryResultCache.getInstance();
        boolean bl3 = true;
        String string3 = string2;
        object2 = ((QueryResultCache)object2).getCacheResult(string2, map, l10, bl3);
        return this.wrapObservable((z)object2);
    }

    public z queryStatus(AVUser object, Map object2) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.fetchStatuses((String)object, (Map)object2);
        object2 = new StorageClient$21(this);
        object = ((z)object).H3((o)object2);
        return this.wrapObservable((z)object);
    }

    public z refreshSessionToken(AVUser object) {
        Object object2 = this.apiService;
        Object object3 = ((AVUser)object).getSessionToken();
        String string2 = ((AVObject)object).getObjectId();
        object2 = object2.refreshSessionToken((String)object3, string2);
        object3 = new StorageClient$19(this, (AVUser)object);
        object = ((z)object2).H3((o)object3);
        return this.wrapObservable((z)object);
    }

    public z requestCaptcha(AVCaptchaOption object) {
        APIService aPIService = this.apiService;
        object = ((AVCaptchaOption)object).getRequestParam();
        object = aPIService.requestCaptcha((Map)object);
        return this.wrapObservable((z)object);
    }

    public z requestEmailVerify(String object) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("email", (String)object);
        object = this.apiService.requestEmailVerify(hashMap);
        return this.wrapObservable((z)object);
    }

    public z requestLoginSmsCode(String object, String string2) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String string3 = "mobilePhoneNumber";
        hashMap.put(string3, (String)object);
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            object = "validate_token";
            hashMap.put((String)object, string2);
        }
        object = this.apiService.requestLoginSmsCode(hashMap);
        return this.wrapObservable((z)object);
    }

    public z requestMobilePhoneVerify(String object, String string2) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String string3 = "mobilePhoneNumber";
        hashMap.put(string3, (String)object);
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            object = "validate_token";
            hashMap.put((String)object, string2);
        }
        object = this.apiService.requestMobilePhoneVerify(hashMap);
        return this.wrapObservable((z)object);
    }

    public z requestResetPassword(String object) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("email", (String)object);
        object = this.apiService.requestResetPassword(hashMap);
        return this.wrapObservable((z)object);
    }

    public z requestResetPasswordBySmsCode(String object, String string2) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String string3 = "mobilePhoneNumber";
        hashMap.put(string3, (String)object);
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            object = "validate_token";
            hashMap.put((String)object, string2);
        }
        object = this.apiService.requestResetPasswordBySmsCode(hashMap);
        return this.wrapObservable((z)object);
    }

    public z requestSMSCode(String object, Map map) {
        map.put("mobilePhoneNumber", object);
        object = this.apiService.requestSMSCode(map);
        return this.wrapObservable((z)object);
    }

    public z requestSMSCodeForUpdatingPhoneNumber(AVUser object, String string2, Map map) {
        map.put("mobilePhoneNumber", string2);
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.requestSMSCodeForUpdatingPhoneNumber((String)object, map);
        return this.wrapObservable((z)object);
    }

    public z resetPasswordBySmsCode(String object, String string2) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("password", string2);
        object = this.apiService.resetPasswordBySmsCode((String)object, hashMap);
        return this.wrapObservable((z)object);
    }

    public z saveObject(AVUser object, String string2, String object2, JSONObject jSONObject, boolean bl2, JSONObject jSONObject2) {
        String string3 = this.getSessionToken((AVUser)object);
        APIService aPIService = this.apiService;
        object = aPIService.updateObject(string3, string2, (String)object2, jSONObject, bl2, jSONObject2);
        if ((object = this.wrapObservable((z)object)) == null) {
            return null;
        }
        object2 = new StorageClient$9(this, string2);
        return ((z)object).H3((o)object2);
    }

    public z saveWholeObject(AVUser object, Class clazz, String object2, String string2, JSONObject jSONObject, boolean bl2, JSONObject jSONObject2) {
        String string3 = this.getSessionToken((AVUser)object);
        boolean bl3 = StringUtil.isEmpty(string2);
        if (bl3) {
            APIService aPIService = this.apiService;
            object = aPIService.saveWholeObject(string3, (String)object2, jSONObject, bl2, jSONObject2);
            object = this.wrapObservable((z)object);
        } else {
            APIService aPIService = this.apiService;
            object = aPIService.saveWholeObject(string3, (String)object2, string2, jSONObject, bl2, jSONObject2);
            object = this.wrapObservable((z)object);
        }
        if (object == null) {
            return null;
        }
        object2 = new StorageClient$10(this, clazz);
        return ((z)object).H3((o)object2);
    }

    public z search(AVUser object, Map map) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.search((String)object, map);
        return this.wrapObservable((z)object);
    }

    public void setCurrentUser(AVUser aVUser) {
        this.currentUser = aVUser;
    }

    public z signUp(JSONObject object) {
        object = this.apiService.signup((JSONObject)object);
        return this.wrapObservable((z)object);
    }

    public z signUpOrLoginByMobilephone(JSONObject jSONObject, Class clazz) {
        z z10 = this.apiService.signupByMobilePhone(jSONObject);
        z10 = this.wrapObservable(z10);
        StorageClient$12 storageClient$12 = new StorageClient$12(this, clazz, jSONObject);
        return z10.H3(storageClient$12);
    }

    public z signUpWithFlag(JSONObject object, boolean bl2) {
        object = this.apiService.signup((JSONObject)object, bl2);
        return this.wrapObservable((z)object);
    }

    public z unfollowUser(AVUser object, String string2, String string3) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.unfollowUser((String)object, string2, string3);
        return this.wrapObservable((z)object);
    }

    public z updateFriendship(AVUser object, String string2, String string3, Map map) {
        object = this.getSessionToken((AVUser)object);
        object = this.apiService.updateFriendship((String)object, string2, string3, map);
        return this.wrapObservable((z)object);
    }

    public z updatePassword(AVUser object, String object2, String object3) {
        if (object == null) {
            object = new IllegalArgumentException("user is null");
            return z.m2((Throwable)object);
        }
        boolean bl2 = StringUtil.isEmpty((String)object2);
        if (!bl2 && !(bl2 = StringUtil.isEmpty((String)object3))) {
            JSONObject jSONObject = JSONObject$Builder.create(null);
            jSONObject.put("old_password", object2);
            jSONObject.put("new_password", object3);
            object2 = this.apiService;
            object3 = ((AVUser)object).getSessionToken();
            String string2 = ((AVObject)object).getObjectId();
            object2 = object2.updatePassword((String)object3, string2, jSONObject);
            object3 = new StorageClient$20(this, (AVUser)object);
            object = ((z)object2).H3((o)object3);
            return this.wrapObservable((z)object);
        }
        object = new IllegalArgumentException("old password or new password is empty");
        return z.m2((Throwable)object);
    }

    public z verifyCaptcha(String object, String string2) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2 && !(bl2 = StringUtil.isEmpty(string2))) {
            HashMap<String, Object> hashMap = new HashMap<String, Object>(2);
            hashMap.put("captcha_code", object);
            hashMap.put("captcha_token", string2);
            object = this.apiService.verifyCaptcha(hashMap);
            return this.wrapObservable((z)object);
        }
        object = new IllegalArgumentException("code or token is empty");
        return z.m2((Throwable)object);
    }

    public z verifyMobilePhone(String object) {
        object = this.apiService.verifyMobilePhone((String)object);
        return this.wrapObservable((z)object);
    }

    public z verifySMSCode(String object, String string2) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2 && !(bl2 = StringUtil.isEmpty(string2))) {
            HashMap<String, String> hashMap = new HashMap<String, String>(1);
            hashMap.put("mobilePhoneNumber", string2);
            object = this.apiService.verifySMSCode((String)object, hashMap);
            return this.wrapObservable((z)object);
        }
        object = new IllegalArgumentException("code or mobilePhone is empty");
        return z.m2((Throwable)object);
    }

    public z verifySMSCodeForUpdatingPhoneNumber(AVUser object, String string2, String string3) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2 && !(bl2 = StringUtil.isEmpty(string3))) {
            object = this.getSessionToken((AVUser)object);
            HashMap<String, String> hashMap = new HashMap<String, String>(1);
            hashMap.put("mobilePhoneNumber", string3);
            hashMap.put("code", string2);
            object = this.apiService.verifySMSCodeForUpdatingPhoneNumber((String)object, hashMap);
            return this.wrapObservable((z)object);
        }
        object = new IllegalArgumentException("code or mobilePhone is empty");
        return z.m2((Throwable)object);
    }

    public z wrapObservable(z z10) {
        Object object;
        if (z10 == null) {
            return null;
        }
        boolean bl2 = this.asynchronized;
        if (bl2) {
            object = b.d();
            z10 = z10.L5((h0)object);
        }
        if ((object = this.defaultCreator) != null) {
            object = object.create();
            z10 = z10.i4((h0)object);
        }
        object = new StorageClient$1(this);
        return z10.n4((o)object);
    }
}

