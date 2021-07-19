/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVException;
import cn.leancloud.AVFriendship;
import cn.leancloud.AVFriendshipRequest;
import cn.leancloud.AVFriendshipRequest$RequestStatus;
import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.AVSaveOption;
import cn.leancloud.AVUser$1;
import cn.leancloud.AVUser$2;
import cn.leancloud.AVUser$3;
import cn.leancloud.AVUser$4;
import cn.leancloud.AVUser$5;
import cn.leancloud.AVUser$6;
import cn.leancloud.Transformer;
import cn.leancloud.cache.PersistenceUtil;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.callback.FollowersAndFolloweesCallback;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.core.PaasClient;
import cn.leancloud.core.StorageClient;
import cn.leancloud.json.JSON;
import cn.leancloud.json.JSONObject;
import cn.leancloud.json.JSONObject$Builder;
import cn.leancloud.ops.Utils;
import cn.leancloud.sms.AVSMS;
import cn.leancloud.sms.AVSMSOption;
import cn.leancloud.utils.AVUtils;
import cn.leancloud.utils.ErrorUtils;
import cn.leancloud.utils.StringUtil;
import e.a.g0;
import e.a.v0.o;
import e.a.z;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AVUser
extends AVObject {
    public static final String ATTR_EMAIL = "email";
    public static final String ATTR_MOBILEPHONE = "mobilePhoneNumber";
    private static final String ATTR_MOBILEPHONE_VERIFIED = "mobilePhoneVerified";
    private static final String ATTR_PASSWORD = "password";
    public static final String ATTR_SESSION_TOKEN = "sessionToken";
    private static final String ATTR_SMSCODE = "smsCode";
    public static final String ATTR_USERNAME = "username";
    private static final String AUTHDATA_ATTR_MAIN_ACCOUNT = "main_account";
    private static final String AUTHDATA_ATTR_UNIONID = "unionid";
    private static final String AUTHDATA_ATTR_UNIONID_PLATFORM = "platform";
    private static final String AUTHDATA_PLATFORM_ANONYMOUS = "anonymous";
    private static final String AUTHDATA_TAG = "authData";
    public static final String CLASS_NAME = "_User";
    public static final String FOLLOWEE_TAG = "followee";
    public static final String FOLLOWER_TAG = "follower";
    private static final String ILLEGALARGUMENT_MSG_FORMAT = "illegal parameter. %s must not null/empty.";
    private static final String PARAM_ATTR_FRIENDSHIP = "friendship";
    private static transient boolean enableAutomatic = false;
    private static Class subClazz;

    public AVUser() {
        super(CLASS_NAME);
    }

    public static /* synthetic */ Map access$000(AVUser aVUser, JSONObject jSONObject) {
        return aVUser.parseFollowerAndFollowee(jSONObject);
    }

    public static void alwaysUseSubUserClass(Class clazz) {
        AVObject.registerSubclass(clazz);
        subClazz = clazz;
    }

    public static AVUser becomeWithSessionToken(String string2) {
        return AVUser.becomeWithSessionToken(string2, false);
    }

    public static AVUser becomeWithSessionToken(String string2, Class clazz) {
        return AVUser.becomeWithSessionToken(string2, false, clazz);
    }

    public static AVUser becomeWithSessionToken(String string2, boolean bl2) {
        return (AVUser)AVUser.becomeWithSessionTokenInBackground(string2, bl2).r();
    }

    public static AVUser becomeWithSessionToken(String string2, boolean bl2, Class clazz) {
        return (AVUser)AVUser.becomeWithSessionTokenInBackground(string2, bl2, clazz).r();
    }

    public static z becomeWithSessionTokenInBackground(String string2) {
        return AVUser.becomeWithSessionTokenInBackground(string2, false);
    }

    public static z becomeWithSessionTokenInBackground(String string2, Class clazz) {
        return AVUser.becomeWithSessionTokenInBackground(string2, false, clazz);
    }

    public static z becomeWithSessionTokenInBackground(String string2, boolean bl2) {
        Class clazz = AVUser.internalUserClazz();
        return AVUser.becomeWithSessionTokenInBackground(string2, bl2, clazz);
    }

    public static z becomeWithSessionTokenInBackground(String object, boolean bl2, Class object2) {
        object = PaasClient.getStorageClient().createUserBySession((String)object, (Class)object2);
        object2 = new AVUser$5(bl2);
        return ((z)object).H3((o)object2);
    }

    public static AVUser cast(AVUser aVObject, Class clazz) {
        try {
            aVObject = AVObject.cast(aVObject, clazz);
        }
        catch (Exception exception) {
            return null;
        }
        return aVObject;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void changeCurrentUser(AVUser aVUser, boolean bl2) {
        Class<AVUser> clazz = AVUser.class;
        synchronized (clazz) {
            Object object;
            boolean bl3;
            Object object2;
            boolean bl4 = AppConfiguration.isIncognitoMode();
            if (bl4) {
                return;
            }
            if (aVUser != null) {
                object2 = ATTR_PASSWORD;
                aVUser.removeOperationForKey((String)object2);
            }
            object2 = AVUser.currentUserArchivePath();
            if (aVUser != null && bl3) {
                object = aVUser.toJSONString();
                Object object3 = AVObject.logger;
                ((AVLogger)object3).d((String)object);
                object3 = PersistenceUtil.sharedInstance();
                ((PersistenceUtil)object3).saveContentToFile((String)object, (File)object2);
            } else if (bl3) {
                object = PersistenceUtil.sharedInstance();
                String string2 = ((File)object2).getAbsolutePath();
                ((PersistenceUtil)object).removeLock(string2);
                bl3 = ((File)object2).delete();
                if (!bl3) {
                    object = AVObject.logger;
                    object2 = "failed to delete currentUser cache file.";
                    ((AVLogger)object).w((String)object2);
                }
            }
            object = PaasClient.getStorageClient();
            ((StorageClient)object).setCurrentUser(aVUser);
            return;
        }
    }

    private boolean checkUserAuthentication(AVCallback aVCallback) {
        Object object;
        int n10 = this.isAuthenticated();
        if (n10 != 0 && (n10 = (int)(StringUtil.isEmpty((String)(object = this.getObjectId())) ? 1 : 0)) == 0) {
            return true;
        }
        if (aVCallback != null) {
            n10 = 206;
            String string2 = "No valid session token, make sure signUp or login has been called.";
            object = ErrorUtils.propagateException(n10, string2);
            aVCallback.internalDone((AVException)object);
        }
        return false;
    }

    private static Map createUserMap(String object, String string2, String string3, String string4, String string5) {
        boolean bl2;
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        boolean bl3 = StringUtil.isEmpty((String)object);
        if (bl3 && (bl3 = StringUtil.isEmpty(string4))) {
            object = new IllegalArgumentException("Blank username and blank mobile phone number");
            throw object;
        }
        bl3 = StringUtil.isEmpty((String)object);
        if (!bl3) {
            String string6 = ATTR_USERNAME;
            hashMap.put(string6, object);
        }
        if (!(bl2 = StringUtil.isEmpty(string2))) {
            object = ATTR_PASSWORD;
            hashMap.put(object, string2);
        }
        if (!(bl2 = StringUtil.isEmpty(string3))) {
            object = ATTR_EMAIL;
            hashMap.put(object, string3);
        }
        if (!(bl2 = StringUtil.isEmpty(string4))) {
            object = ATTR_MOBILEPHONE;
            hashMap.put(object, string4);
        }
        if (!(bl2 = StringUtil.isEmpty(string5))) {
            object = ATTR_SMSCODE;
            hashMap.put(object, string5);
        }
        return hashMap;
    }

    private static HashMap createUserMapAFAP(String string2, String string3, String string4, String string5, String string6) {
        boolean bl2;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        boolean bl3 = StringUtil.isEmpty(string2);
        if (!bl3) {
            String string7 = ATTR_USERNAME;
            hashMap.put(string7, string2);
        }
        if (!(bl2 = StringUtil.isEmpty(string3))) {
            string2 = ATTR_PASSWORD;
            hashMap.put(string2, string3);
        }
        if (!(bl2 = StringUtil.isEmpty(string4))) {
            string2 = ATTR_EMAIL;
            hashMap.put(string2, string4);
        }
        if (!(bl2 = StringUtil.isEmpty(string5))) {
            string2 = ATTR_MOBILEPHONE;
            hashMap.put(string2, string5);
        }
        if (!(bl2 = StringUtil.isEmpty(string6))) {
            string2 = ATTR_SMSCODE;
            hashMap.put(string2, string6);
        }
        return hashMap;
    }

    public static AVUser currentUser() {
        return AVUser.getCurrentUser();
    }

    private static File currentUserArchivePath() {
        CharSequence charSequence = new StringBuilder();
        String string2 = AppConfiguration.getDocumentDir();
        charSequence.append(string2);
        charSequence.append("/currentUser");
        charSequence = charSequence.toString();
        File file = new File((String)charSequence);
        return file;
    }

    public static void disableAutomaticUser() {
        enableAutomatic = false;
    }

    public static void enableAutomaticUser() {
        enableAutomatic = true;
    }

    public static AVQuery followeeQuery(String object, Class clazz) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            AVQuery aVQuery = new AVQuery("_Followee", clazz);
            object = AVObject.createWithoutData(CLASS_NAME, (String)object);
            aVQuery.whereEqualTo("user", object);
            aVQuery.include(FOLLOWEE_TAG);
            return aVQuery;
        }
        object = new IllegalArgumentException("Blank user objectId");
        throw object;
    }

    public static AVQuery followerQuery(String object, Class clazz) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            AVQuery aVQuery = new AVQuery("_Follower", clazz);
            object = AVObject.createWithoutData(CLASS_NAME, (String)object);
            aVQuery.whereEqualTo("user", object);
            aVQuery.include(FOLLOWER_TAG);
            return aVQuery;
        }
        object = new IllegalArgumentException("Blank user objectId");
        throw object;
    }

    public static AVUser getCurrentUser() {
        return AVUser.getCurrentUser(AVUser.internalUserClazz());
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static AVUser getCurrentUser(Class clazz) {
        boolean bl2;
        Object object;
        boolean bl3;
        Object object2;
        block19: {
            boolean bl4 = AppConfiguration.isIncognitoMode();
            if (bl4) {
                return null;
            }
            object2 = PaasClient.getStorageClient().getCurrentUser();
            if (object2 != null && (bl3 = clazz.isAssignableFrom((Class<?>)(object = object2.getClass())))) {
                return object2;
            }
            bl3 = AVUser.userArchiveExist();
            bl2 = true;
            if (bl3) {
                object = AVUser.currentUserArchivePath();
                Class<AVUser> clazz2 = AVUser.class;
                synchronized (clazz2) {
                    Object object3 = PersistenceUtil.sharedInstance();
                    object = ((PersistenceUtil)object3).readContentFromFile((File)object);
                    int n10 = StringUtil.isEmpty((String)object);
                    if (n10 == 0) {
                        block18: {
                            block20: {
                                object3 = "@type";
                                n10 = ((String)object).indexOf((String)object3);
                                if (n10 < 0 && (n10 = ((String)object).indexOf((String)(object3 = "_version"))) < 0) {
                                    object3 = AVObject.class;
                                    try {
                                        object = JSON.parseObject((String)object, object3);
                                        object = (AVObject)object;
                                        object = Transformer.transform((AVObject)object, clazz);
                                        object = (AVUser)object;
                                        AVUser.changeCurrentUser((AVUser)object, bl2);
                                        break block18;
                                    }
                                    catch (Exception exception) {
                                        object3 = AVObject.logger;
                                        ((AVLogger)object3).w(exception);
                                        break block19;
                                    }
                                }
                                object = AVObject.parseAVObject((String)object);
                                object = (AVUser)object;
                                try {
                                    object2 = PaasClient.getStorageClient();
                                    ((StorageClient)object2).setCurrentUser((AVUser)object);
                                    break block18;
                                }
                                catch (Exception exception) {
                                    break block20;
                                }
                                catch (Exception exception) {
                                    object = object2;
                                    object2 = exception;
                                }
                            }
                            object3 = AVObject.logger;
                            String string2 = "failed to deserialize AVUser instance.";
                            ((AVLogger)object3).w(string2, (Throwable)object2);
                        }
                        object2 = object;
                    }
                }
            }
        }
        if ((bl3 = enableAutomatic) && object2 == null) {
            block21: {
                block22: {
                    object = clazz.newInstance();
                    object = (AVUser)object;
                    try {
                        AVUser.changeCurrentUser((AVUser)object, bl2);
                        break block21;
                    }
                    catch (Exception exception) {
                        break block22;
                    }
                    catch (Exception exception) {
                        object = object2;
                        object2 = exception;
                    }
                }
                AVLogger aVLogger = AVObject.logger;
                aVLogger.w((Throwable)object2);
            }
            object2 = object;
        }
        return (AVUser)Transformer.transform((AVObject)object2, clazz);
    }

    public static AVQuery getQuery() {
        return AVObject.getQuery(AVUser.class);
    }

    public static AVQuery getUserQuery(Class clazz) {
        AVQuery aVQuery = new AVQuery(CLASS_NAME, clazz);
        return aVQuery;
    }

    private static Class internalUserClazz() {
        Class<AVUser> clazz = subClazz;
        if (clazz == null) {
            clazz = AVUser.class;
        }
        return clazz;
    }

    public static boolean isEnableAutomatic() {
        return enableAutomatic;
    }

    public static z logIn(String string2, String string3) {
        Class clazz = AVUser.internalUserClazz();
        return AVUser.logIn(string2, string3, clazz);
    }

    public static z logIn(String object, String string2, Class clazz) {
        object = JSONObject$Builder.create(AVUser.createUserMap((String)object, string2, null, null, null));
        return PaasClient.getStorageClient().logIn((JSONObject)object, clazz);
    }

    public static z logInAnonymously() {
        String string2 = UUID.randomUUID().toString().toLowerCase();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("id", string2);
        return AVUser.loginWithAuthData(hashMap, AUTHDATA_PLATFORM_ANONYMOUS);
    }

    public static void logOut() {
        AVUser.changeCurrentUser(null, true);
    }

    public static z loginByEmail(String object, String object2) {
        object = AVUser.createUserMapAFAP(null, (String)object2, (String)object, null, null);
        object2 = PaasClient.getStorageClient();
        object = JSONObject$Builder.create((Map)object);
        Class clazz = AVUser.internalUserClazz();
        return ((StorageClient)object2).logIn((JSONObject)object, clazz);
    }

    public static z loginByMobilePhoneNumber(String string2, String string3) {
        Class clazz = AVUser.internalUserClazz();
        return AVUser.loginByMobilePhoneNumber(string2, string3, clazz);
    }

    public static z loginByMobilePhoneNumber(String object, String string2, Class clazz) {
        object = JSONObject$Builder.create(AVUser.createUserMap(null, string2, null, (String)object, null));
        return PaasClient.getStorageClient().logIn((JSONObject)object, clazz);
    }

    public static z loginBySMSCode(String string2, String string3) {
        Class clazz = AVUser.internalUserClazz();
        return AVUser.loginBySMSCode(string2, string3, clazz);
    }

    public static z loginBySMSCode(String object, String string2, Class clazz) {
        object = JSONObject$Builder.create(AVUser.createUserMap(null, null, null, (String)object, string2));
        return PaasClient.getStorageClient().logIn((JSONObject)object, clazz);
    }

    public static z loginWithAuthData(Class serializable, Map object, String object2) {
        boolean bl2;
        HashMap hashMap = null;
        int n10 = 1;
        String string2 = ILLEGALARGUMENT_MSG_FORMAT;
        if (serializable == null) {
            object = new Object[n10];
            object[0] = "clazz";
            object = String.format(string2, (Object[])object);
            serializable = new IllegalArgumentException((String)object);
            return z.m2((Throwable)serializable);
        }
        String string3 = AUTHDATA_TAG;
        if (object != null && !(bl2 = object.isEmpty())) {
            bl2 = StringUtil.isEmpty((String)object2);
            if (bl2) {
                object = new Object[n10];
                object[0] = AUTHDATA_ATTR_UNIONID_PLATFORM;
                object = String.format(string2, (Object[])object);
                serializable = new IllegalArgumentException((String)object);
                return z.m2((Throwable)serializable);
            }
            hashMap = new HashMap();
            HashMap<String, Object[]> hashMap2 = new HashMap<String, Object[]>();
            hashMap2.put((String)object2, (Object[])object);
            hashMap.put(string3, hashMap2);
            object = JSONObject$Builder.create(hashMap);
            object = PaasClient.getStorageClient().signUp((JSONObject)object);
            object2 = new AVUser$2((Class)serializable);
            return ((z)object).H3((o)object2);
        }
        object = new Object[n10];
        object[0] = string3;
        object = String.format(string2, (Object[])object);
        serializable = new IllegalArgumentException((String)object);
        return z.m2((Throwable)serializable);
    }

    public static z loginWithAuthData(Class serializable, Map object, String string2, String object2, String string3, boolean bl2) {
        boolean bl3 = StringUtil.isEmpty((String)object2);
        int n10 = 1;
        String string4 = ILLEGALARGUMENT_MSG_FORMAT;
        if (bl3) {
            object = new Object[n10];
            object[0] = "unionId";
            object = String.format(string4, (Object[])object);
            serializable = new IllegalArgumentException((String)object);
            return z.m2((Throwable)serializable);
        }
        bl3 = StringUtil.isEmpty(string3);
        if (bl3) {
            object = new Object[n10];
            object[0] = "unionIdPlatform";
            object = String.format(string4, (Object[])object);
            serializable = new IllegalArgumentException((String)object);
            return z.m2((Throwable)serializable);
        }
        if (object != null && !(bl3 = object.isEmpty())) {
            String string5 = AUTHDATA_ATTR_UNIONID;
            object.put(string5, object2);
            object2 = AUTHDATA_ATTR_UNIONID_PLATFORM;
            object.put(object2, string3);
            if (bl2) {
                object2 = bl2;
                string3 = AUTHDATA_ATTR_MAIN_ACCOUNT;
                object.put(string3, object2);
            }
            return AVUser.loginWithAuthData(serializable, (Map)object, string2);
        }
        object = new Object[n10];
        object[0] = AUTHDATA_TAG;
        object = String.format(string4, (Object[])object);
        serializable = new IllegalArgumentException((String)object);
        return z.m2((Throwable)serializable);
    }

    public static z loginWithAuthData(Map map, String string2) {
        return AVUser.loginWithAuthData(AVUser.internalUserClazz(), map, string2);
    }

    public static z loginWithAuthData(Map map, String string2, String string3, String string4, boolean bl2) {
        return AVUser.loginWithAuthData(AVUser.internalUserClazz(), map, string2, string3, string4, bl2);
    }

    private Map parseFollowerAndFollowee(JSONObject object) {
        HashMap hashMap = new HashMap();
        if (object != null) {
            int n10;
            Object object2;
            int n11;
            List list = AVUtils.getObjectListFromMapList((List)object.get("followers"));
            if (list != null && (n11 = list.size()) > 0) {
                object2 = new LinkedList();
                String string2 = FOLLOWER_TAG;
                this.processResultList(list, (List)object2, string2);
                hashMap.put(string2, object2);
            }
            if ((object = AVUtils.getObjectListFromMapList((List)object.get(list = "followees"))) != null && (n10 = object.size()) > 0) {
                list = new List();
                object2 = FOLLOWEE_TAG;
                this.processResultList((List)object, list, (String)object2);
                hashMap.put(object2, list);
            }
        }
        return hashMap;
    }

    private void processResultList(List object, List list, String string2) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (JSONObject)object.next();
            if (object2 == null) continue;
            object2 = (AVUser)Utils.parseObjectFromMap((Map)object2.get(string2));
            list.add(object2);
        }
    }

    public static z requestEmailVerifyInBackground(String string2) {
        return PaasClient.getStorageClient().requestEmailVerify(string2);
    }

    public static z requestLoginSmsCodeInBackground(String object) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2 && (bl2 = AVSMS.checkMobilePhoneNumber((String)object))) {
            return AVUser.requestLoginSmsCodeInBackground((String)object, null);
        }
        object = new IllegalArgumentException("mobile phone number is empty or invalid");
        return z.m2((Throwable)object);
    }

    public static z requestLoginSmsCodeInBackground(String object, String string2) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2 && (bl2 = AVSMS.checkMobilePhoneNumber((String)object))) {
            return PaasClient.getStorageClient().requestLoginSmsCode((String)object, string2);
        }
        object = new IllegalArgumentException("mobile phone number is empty or invalid");
        return z.m2((Throwable)object);
    }

    public static z requestMobilePhoneVerifyInBackground(String object) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2 && (bl2 = AVSMS.checkMobilePhoneNumber((String)object))) {
            return AVUser.requestMobilePhoneVerifyInBackground((String)object, null);
        }
        object = new IllegalArgumentException("mobile phone number is empty or invalid");
        return z.m2((Throwable)object);
    }

    public static z requestMobilePhoneVerifyInBackground(String object, String string2) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2 && (bl2 = AVSMS.checkMobilePhoneNumber((String)object))) {
            return PaasClient.getStorageClient().requestMobilePhoneVerify((String)object, string2);
        }
        object = new IllegalArgumentException("mobile phone number is empty or invalid");
        return z.m2((Throwable)object);
    }

    public static z requestPasswordResetBySmsCodeInBackground(String string2) {
        return AVUser.requestPasswordResetBySmsCodeInBackground(string2, null);
    }

    public static z requestPasswordResetBySmsCodeInBackground(String string2, String string3) {
        return PaasClient.getStorageClient().requestResetPasswordBySmsCode(string2, string3);
    }

    public static z requestPasswordResetInBackground(String string2) {
        return PaasClient.getStorageClient().requestResetPassword(string2);
    }

    public static z requestSMSCodeForUpdatingPhoneNumberInBackground(AVUser object, String string2, AVSMSOption map) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2 && (bl2 = AVSMS.checkMobilePhoneNumber(string2))) {
            map = map == null ? new Map() : ((AVSMSOption)((Object)map)).getOptionMap();
            return PaasClient.getStorageClient().requestSMSCodeForUpdatingPhoneNumber((AVUser)object, string2, map);
        }
        object = new IllegalArgumentException("mobile phone number is empty or invalid");
        return z.m2((Throwable)object);
    }

    public static z requestSMSCodeForUpdatingPhoneNumberInBackground(String string2, AVSMSOption aVSMSOption) {
        return AVUser.requestSMSCodeForUpdatingPhoneNumberInBackground(null, string2, aVSMSOption);
    }

    public static z resetPasswordBySmsCodeInBackground(String string2, String string3) {
        return PaasClient.getStorageClient().resetPasswordBySmsCode(string2, string3);
    }

    public static AVUser signUpOrLoginByMobilePhone(String string2, String string3) {
        Class clazz = AVUser.internalUserClazz();
        return AVUser.signUpOrLoginByMobilePhone(string2, string3, clazz);
    }

    public static AVUser signUpOrLoginByMobilePhone(String string2, String string3, Class clazz) {
        return (AVUser)AVUser.signUpOrLoginByMobilePhoneInBackground(string2, string3, clazz).B();
    }

    public static z signUpOrLoginByMobilePhoneInBackground(String string2, String string3) {
        Class clazz = AVUser.internalUserClazz();
        return AVUser.signUpOrLoginByMobilePhoneInBackground(string2, string3, clazz);
    }

    public static z signUpOrLoginByMobilePhoneInBackground(String object, String object2, Class clazz) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        int n10 = 1;
        String string2 = ILLEGALARGUMENT_MSG_FORMAT;
        if (bl2) {
            object2 = new Object[n10];
            object2[0] = ATTR_MOBILEPHONE;
            object2 = String.format(string2, object2);
            object = new IllegalArgumentException((String)object2);
            return z.m2((Throwable)object);
        }
        bl2 = StringUtil.isEmpty((String)object2);
        if (bl2) {
            object2 = new Object[n10];
            object2[0] = ATTR_SMSCODE;
            object2 = String.format(string2, object2);
            object = new IllegalArgumentException((String)object2);
            return z.m2((Throwable)object);
        }
        if (clazz == null) {
            object2 = new Object[n10];
            object2[0] = "clazz";
            object2 = String.format(string2, object2);
            object = new IllegalArgumentException((String)object2);
            return z.m2((Throwable)object);
        }
        object = JSONObject$Builder.create(AVUser.createUserMap(null, null, null, (String)object, (String)object2));
        return PaasClient.getStorageClient().signUpOrLoginByMobilephone((JSONObject)object, clazz);
    }

    private void updateCurrentUserCache() {
        boolean bl2;
        boolean bl3;
        String string2;
        boolean bl4;
        String string3 = this.getSessionToken();
        Object object = AVUser.currentUser();
        if (object != null && !(bl4 = StringUtil.isEmpty(string2 = ((AVObject)object).getObjectId())) && (bl3 = ((String)(object = ((AVObject)object).getObjectId())).equals(string2 = this.getObjectId())) && !(bl2 = StringUtil.isEmpty(string3))) {
            bl2 = true;
            AVUser.changeCurrentUser(this, bl2);
        }
    }

    private static boolean userArchiveExist() {
        return AVUser.currentUserArchivePath().exists();
    }

    public static z verifyMobilePhoneInBackground(String string2) {
        return PaasClient.getStorageClient().verifyMobilePhone(string2);
    }

    public static z verifySMSCodeForUpdatingPhoneNumberInBackground(AVUser object, String string2, String string3) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2 && !(bl2 = StringUtil.isEmpty(string3))) {
            return PaasClient.getStorageClient().verifySMSCodeForUpdatingPhoneNumber((AVUser)object, string2, string3);
        }
        object = new IllegalArgumentException("code or mobilePhone is empty");
        return z.m2((Throwable)object);
    }

    public static z verifySMSCodeForUpdatingPhoneNumberInBackground(String string2, String string3) {
        return AVUser.verifySMSCodeForUpdatingPhoneNumberInBackground(null, string2, string3);
    }

    public z acceptFriendshipRequest(AVFriendshipRequest aVFriendshipRequest, Map map) {
        return this.acceptFriendshipRequest(null, aVFriendshipRequest, map);
    }

    public z acceptFriendshipRequest(AVUser aVUser, AVFriendshipRequest aVFriendshipRequest, Map map) {
        HashMap<String, Map> hashMap = null;
        boolean bl2 = this.checkUserAuthentication(null);
        if (!bl2) {
            AVObject.logger.d("current user isn't authenticated.");
            return z.m2(ErrorUtils.propagateException(206, "No valid session token, make sure signUp or login has been called."));
        }
        if (aVFriendshipRequest != null && !(bl2 = StringUtil.isEmpty((String)((Object)(hashMap = aVFriendshipRequest.getObjectId()))))) {
            int n10;
            hashMap = new HashMap<String, Map>();
            if (map != null && (n10 = map.size()) > 0) {
                String string2 = PARAM_ATTR_FRIENDSHIP;
                hashMap.put(string2, map);
            }
            map = JSONObject$Builder.create(hashMap);
            return PaasClient.getStorageClient().acceptFriendshipRequest(aVUser, aVFriendshipRequest, (JSONObject)map);
        }
        return z.m2(ErrorUtils.propagateException(9304, "friendship request(objectId) is invalid."));
    }

    public z applyFriendshipInBackground(AVUser aVUser, AVUser object, Map map) {
        HashMap<String, Object> hashMap = null;
        boolean bl2 = this.checkUserAuthentication(null);
        if (!bl2) {
            AVObject.logger.d("current user isn't authenticated.");
            return z.m2(ErrorUtils.propagateException(206, "No valid session token, make sure signUp or login has been called."));
        }
        if (object != null && !(bl2 = StringUtil.isEmpty((String)((Object)(hashMap = ((AVObject)object).getObjectId()))))) {
            int n10;
            hashMap = new HashMap<String, Object>();
            Object object2 = Utils.getParsedObject(this);
            String string2 = "user";
            hashMap.put(string2, object2);
            object = Utils.getParsedObject(object);
            object2 = "friend";
            hashMap.put((String)object2, object);
            if (map != null && (n10 = map.size()) > 0) {
                object = PARAM_ATTR_FRIENDSHIP;
                hashMap.put((String)object, map);
            }
            object = JSONObject$Builder.create(hashMap);
            return PaasClient.getStorageClient().applyFriendshipRequest(aVUser, (JSONObject)object);
        }
        return z.m2(ErrorUtils.propagateException(9304, "friend user is invalid."));
    }

    public z applyFriendshipInBackground(AVUser aVUser, Map map) {
        return this.applyFriendshipInBackground(null, aVUser, map);
    }

    public z associateWithAuthData(Map object, String object2) {
        boolean bl2;
        HashMap<Object[], Object> hashMap = null;
        String string2 = ILLEGALARGUMENT_MSG_FORMAT;
        String string3 = AUTHDATA_TAG;
        boolean bl3 = true;
        if (object != null && !(bl2 = object.isEmpty())) {
            bl2 = StringUtil.isEmpty((String)object2);
            if (bl2) {
                object2 = new Object[bl3];
                object2[0] = AUTHDATA_ATTR_UNIONID_PLATFORM;
                object2 = String.format(string2, object2);
                object = new IllegalArgumentException((String)object2);
                return z.m2((Throwable)object);
            }
            hashMap = new HashMap<Object[], Object>();
            hashMap.put((Object[])object2, object);
            object = this.get(string3);
            boolean bl4 = object instanceof Map;
            if (bl4) {
                object = (Map)object;
                hashMap.putAll((Map<Object[], Object>)object);
            }
            this.put(string3, hashMap);
            object = new AVSaveOption();
            object = ((AVSaveOption)object).setFetchWhenSave(bl3);
            return this.saveInBackground((AVSaveOption)object);
        }
        object2 = new Object[bl3];
        object2[0] = string3;
        object2 = String.format(string2, object2);
        object = new IllegalArgumentException((String)object2);
        return z.m2((Throwable)object);
    }

    public z associateWithAuthData(Map object, String object2, String object3, String string2, boolean bl2) {
        boolean bl3;
        String string3 = null;
        int n10 = 1;
        String string4 = ILLEGALARGUMENT_MSG_FORMAT;
        if (object != null && !(bl3 = object.isEmpty())) {
            bl3 = StringUtil.isEmpty((String)object3);
            if (bl3) {
                object2 = new Object[n10];
                object2[0] = "unionId";
                object2 = String.format(string4, object2);
                object = new IllegalArgumentException((String)object2);
                return z.m2((Throwable)object);
            }
            bl3 = StringUtil.isEmpty(string2);
            if (bl3) {
                object2 = new Object[n10];
                object2[0] = "unionIdPlatform";
                object2 = String.format(string4, object2);
                object = new IllegalArgumentException((String)object2);
                return z.m2((Throwable)object);
            }
            string3 = AUTHDATA_ATTR_UNIONID;
            object.put(string3, object3);
            object3 = AUTHDATA_ATTR_UNIONID_PLATFORM;
            object.put(object3, string2);
            if (bl2) {
                object3 = Boolean.TRUE;
                string2 = AUTHDATA_ATTR_MAIN_ACCOUNT;
                object.put(string2, object3);
            }
            return this.associateWithAuthData((Map)object, (String)object2);
        }
        object2 = new Object[n10];
        object2[0] = AUTHDATA_TAG;
        object2 = String.format(string4, object2);
        object = new IllegalArgumentException((String)object2);
        return z.m2((Throwable)object);
    }

    public z checkAuthenticatedInBackground() {
        String string2 = this.getSessionToken();
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            AVObject.logger.d("sessionToken is not existed.");
            return z.t3(Boolean.FALSE);
        }
        return PaasClient.getStorageClient().checkAuthenticated(string2);
    }

    public z declineFriendshipRequest(AVFriendshipRequest aVFriendshipRequest) {
        return this.declineFriendshipRequest(null, aVFriendshipRequest);
    }

    public z declineFriendshipRequest(AVUser aVUser, AVFriendshipRequest aVFriendshipRequest) {
        String string2 = null;
        boolean bl2 = this.checkUserAuthentication(null);
        if (!bl2) {
            AVObject.logger.d("current user isn't authenticated.");
            return z.m2(ErrorUtils.propagateException(206, "No valid session token, make sure signUp or login has been called."));
        }
        if (aVFriendshipRequest != null && !(bl2 = StringUtil.isEmpty(string2 = aVFriendshipRequest.getObjectId()))) {
            return PaasClient.getStorageClient().declineFriendshipRequest(aVUser, aVFriendshipRequest);
        }
        return z.m2(ErrorUtils.propagateException(9304, "friendship request(objectId) is invalid."));
    }

    public z dissociateWithAuthData(String object) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (bl2) {
            Object object2 = new Object[]{AUTHDATA_ATTR_UNIONID_PLATFORM};
            object2 = String.format(ILLEGALARGUMENT_MSG_FORMAT, object2);
            object = new IllegalArgumentException((String)object2);
            return z.m2((Throwable)object);
        }
        Object object3 = this.getObjectId();
        bl2 = StringUtil.isEmpty((String)object3);
        if (!bl2 && (bl2 = this.isAuthenticated())) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("authData.");
            ((StringBuilder)object3).append((String)object);
            object3 = ((StringBuilder)object3).toString();
            this.remove((String)object3);
            object3 = this.saveInBackground();
            AVUser$4 aVUser$4 = new AVUser$4(this, (String)object);
            return ((z)object3).H3(aVUser$4);
        }
        object = new AVException(206, "the user object missing a valid session");
        return z.m2((Throwable)object);
    }

    public z followInBackground(AVUser aVUser, String string2) {
        HashMap hashMap = new HashMap();
        return this.followInBackground(aVUser, string2, hashMap);
    }

    public z followInBackground(AVUser aVUser, String string2, Map map) {
        StorageClient storageClient = null;
        boolean bl2 = this.checkUserAuthentication(null);
        if (!bl2) {
            return z.m2(ErrorUtils.propagateException(206, "No valid session token, make sure signUp or login has been called."));
        }
        storageClient = PaasClient.getStorageClient();
        String string3 = this.getObjectId();
        return storageClient.followUser(aVUser, string3, string2, map);
    }

    public z followInBackground(String string2) {
        return this.followInBackground(null, string2);
    }

    public z followInBackground(String string2, Map map) {
        return this.followInBackground(null, string2, map);
    }

    public AVQuery followeeQuery() {
        return AVUser.followeeQuery(this.getObjectId(), AVObject.class);
    }

    public AVQuery followerQuery() {
        return AVUser.followerQuery(this.getObjectId(), AVObject.class);
    }

    public AVQuery friendshipQuery(boolean bl2) {
        String string2 = this.getObjectId();
        boolean bl3 = StringUtil.isEmpty(string2);
        if (bl3) {
            AVObject.logger.d("user object id is empty.");
            return null;
        }
        AVQuery aVQuery = new AVQuery("_Followee");
        String string3 = FOLLOWEE_TAG;
        String string4 = CLASS_NAME;
        String string5 = "user";
        if (bl2) {
            AVObject aVObject = AVObject.createWithoutData(string4, string2);
            aVQuery.whereEqualTo(string3, aVObject);
            aVQuery.include(string5);
        } else {
            AVObject aVObject = AVObject.createWithoutData(string4, string2);
            aVQuery.whereEqualTo(string5, aVObject);
            aVQuery.include(string3);
        }
        return aVQuery;
    }

    public AVQuery friendshipRequestQuery(int n10, boolean bl2, boolean bl3) {
        Object object;
        int n11;
        String string2;
        String string3 = null;
        boolean bl4 = this.checkUserAuthentication(null);
        if (!bl4) {
            AVObject.logger.d("current user isn't authenticated.");
            return null;
        }
        int n12 = 1;
        Object object2 = new ArrayList(n12);
        int n13 = n10 & 1;
        if (n13 == n12) {
            string2 = AVFriendshipRequest$RequestStatus.Pending.name().toLowerCase();
            object2.add(string2);
        }
        if ((n13 = n10 & 2) == (n11 = 2)) {
            string2 = AVFriendshipRequest$RequestStatus.Accepted.name().toLowerCase();
            object2.add(string2);
        }
        if ((n10 &= (n13 = 4)) == n13) {
            object = AVFriendshipRequest$RequestStatus.Declined.name().toLowerCase();
            object2.add(object);
        }
        if ((n10 = object2.size()) < n12) {
            AVObject.logger.d("status parameter is invalid.");
            return null;
        }
        object = new AVQuery("_FriendshipRequest");
        ((AVQuery)object).whereContainedIn("status", (Collection)object2);
        string3 = "friend";
        object2 = "user";
        if (bl3) {
            ((AVQuery)object).whereEqualTo(string3, this);
            if (bl2) {
                ((AVQuery)object).include((String)object2);
            }
        } else {
            ((AVQuery)object).whereEqualTo((String)object2, this);
            if (bl2) {
                ((AVQuery)object).include(string3);
            }
        }
        ((AVQuery)object).addDescendingOrder("updatedAt");
        return object;
    }

    public String getEmail() {
        return (String)this.get(ATTR_EMAIL);
    }

    public void getFollowersAndFolloweesInBackground(AVUser object, FollowersAndFolloweesCallback followersAndFolloweesCallback) {
        if (followersAndFolloweesCallback == null) {
            return;
        }
        boolean bl2 = this.checkUserAuthentication(followersAndFolloweesCallback);
        if (!bl2) {
            return;
        }
        Object object2 = PaasClient.getStorageClient();
        String string2 = this.getObjectId();
        object = ((StorageClient)object2).getFollowersAndFollowees((AVUser)object, string2);
        object2 = new AVUser$6(this, followersAndFolloweesCallback);
        ((z)object).subscribe((g0)object2);
    }

    public void getFollowersAndFolloweesInBackground(FollowersAndFolloweesCallback followersAndFolloweesCallback) {
        this.getFollowersAndFolloweesInBackground(null, followersAndFolloweesCallback);
    }

    public String getMobilePhoneNumber() {
        return (String)this.get(ATTR_MOBILEPHONE);
    }

    public String getPassword() {
        return (String)this.get(ATTR_PASSWORD);
    }

    public z getRolesInBackground() {
        AVQuery aVQuery = new AVQuery("_Role");
        aVQuery.whereEqualTo("users", this);
        return aVQuery.findInBackground();
    }

    public String getSessionToken() {
        return (String)this.get(ATTR_SESSION_TOKEN);
    }

    public String getUsername() {
        return (String)this.get(ATTR_USERNAME);
    }

    public void internalChangeSessionToken(String string2) {
        this.getServerData().put(ATTR_SESSION_TOKEN, string2);
    }

    public boolean isAnonymous() {
        String string2;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        JSONObject jSONObject = this.getJSONObject(AUTHDATA_TAG);
        if (jSONObject != null && (bl4 = jSONObject.size()) == (bl3 = true) && (bl2 = jSONObject.containsKey(string2 = AUTHDATA_PLATFORM_ANONYMOUS))) {
            return bl3;
        }
        return false;
    }

    public boolean isAuthenticated() {
        return StringUtil.isEmpty(this.getSessionToken()) ^ true;
    }

    public boolean isMobilePhoneVerified() {
        return this.getBoolean(ATTR_MOBILEPHONE_VERIFIED);
    }

    public z loginWithAuthData(Map object, String object2, String object3, String string2, boolean bl2, boolean bl3) {
        boolean bl4;
        String string3 = null;
        int n10 = 1;
        String string4 = ILLEGALARGUMENT_MSG_FORMAT;
        if (object != null && !(bl4 = object.isEmpty())) {
            bl4 = StringUtil.isEmpty((String)object3);
            if (bl4) {
                object2 = new Object[n10];
                object2[0] = "unionId";
                object2 = String.format(string4, object2);
                object = new IllegalArgumentException((String)object2);
                return z.m2((Throwable)object);
            }
            bl4 = StringUtil.isEmpty(string2);
            if (bl4) {
                object2 = new Object[n10];
                object2[0] = "unionIdPlatform";
                object2 = String.format(string4, object2);
                object = new IllegalArgumentException((String)object2);
                return z.m2((Throwable)object);
            }
            string3 = AUTHDATA_ATTR_UNIONID;
            object.put(string3, object3);
            object3 = AUTHDATA_ATTR_UNIONID_PLATFORM;
            object.put(object3, string2);
            if (bl2) {
                object3 = bl2;
                string2 = AUTHDATA_ATTR_MAIN_ACCOUNT;
                object.put(string2, object3);
            }
            return this.loginWithAuthData((Map)object, (String)object2, bl3);
        }
        object2 = new Object[n10];
        object2[0] = AUTHDATA_TAG;
        object2 = String.format(string4, object2);
        object = new IllegalArgumentException((String)object2);
        return z.m2((Throwable)object);
    }

    public z loginWithAuthData(Map object, String object2, boolean bl2) {
        boolean bl3;
        String string2 = AUTHDATA_TAG;
        Object object3 = null;
        int n10 = 1;
        String string3 = ILLEGALARGUMENT_MSG_FORMAT;
        if (object != null && !(bl3 = object.isEmpty())) {
            bl3 = StringUtil.isEmpty((String)object2);
            if (bl3) {
                object2 = new Object[n10];
                object2[0] = AUTHDATA_ATTR_UNIONID_PLATFORM;
                object2 = String.format(string3, object2);
                object = new IllegalArgumentException((String)object2);
                return z.m2((Throwable)object);
            }
            object3 = this.getUsername();
            HashMap<Object[], Object> hashMap = this.getEmail();
            string3 = this.getMobilePhoneNumber();
            object3 = AVUser.createUserMapAFAP((String)object3, null, (String)((Object)hashMap), string3, null);
            hashMap = new HashMap<Object[], Object>();
            hashMap.put((Object[])object2, object);
            ((HashMap)object3).put(string2, hashMap);
            object = JSONObject$Builder.create((Map)object3);
            object = PaasClient.getStorageClient().signUpWithFlag((JSONObject)object, bl2);
            object2 = new AVUser$3(this);
            return ((z)object).H3((o)object2);
        }
        object2 = new Object[n10];
        object2[0] = string2;
        object2 = String.format(string3, object2);
        object = new IllegalArgumentException((String)object2);
        return z.m2((Throwable)object);
    }

    public void onDataSynchronized() {
        super.onDataSynchronized();
        this.updateCurrentUserCache();
    }

    public void onSaveFailure() {
        super.onSaveFailure();
    }

    public void onSaveSuccess() {
        super.onSaveSuccess();
        this.updateCurrentUserCache();
    }

    public z refreshSessionTokenInBackground() {
        return PaasClient.getStorageClient().refreshSessionToken(this);
    }

    public void setEmail(String string2) {
        this.put(ATTR_EMAIL, string2);
    }

    public void setMobilePhoneNumber(String string2) {
        this.put(ATTR_MOBILEPHONE, string2);
    }

    public void setPassword(String string2) {
        this.put(ATTR_PASSWORD, string2);
    }

    public void setUsername(String string2) {
        this.put(ATTR_USERNAME, string2);
    }

    public void signUp() {
        this.signUpInBackground().D();
    }

    public z signUpInBackground() {
        Object object = this.generateChangedParam();
        Object object2 = AVObject.logger;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("signup param: ");
        String string2 = ((JSONObject)object).toJSONString();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        ((AVLogger)object2).d((String)charSequence);
        object = PaasClient.getStorageClient().signUp((JSONObject)object);
        object2 = new AVUser$1(this);
        return ((z)object).H3((o)object2);
    }

    public z unfollowInBackground(AVUser aVUser, String string2) {
        StorageClient storageClient = null;
        boolean bl2 = this.checkUserAuthentication(null);
        if (!bl2) {
            return z.m2(ErrorUtils.propagateException(206, "No valid session token, make sure signUp or login has been called."));
        }
        storageClient = PaasClient.getStorageClient();
        String string3 = this.getObjectId();
        return storageClient.unfollowUser(aVUser, string3, string2);
    }

    public z unfollowInBackground(String string2) {
        return this.unfollowInBackground(null, string2);
    }

    public z updateFriendship(AVFriendship aVFriendship) {
        return this.updateFriendship(null, aVFriendship);
    }

    public z updateFriendship(AVUser aVUser, AVFriendship object) {
        Object object2;
        int n10;
        Object object3 = null;
        int n11 = this.checkUserAuthentication(null);
        if (n11 == 0) {
            AVObject.logger.d("current user isn't authenticated.");
            return z.m2(ErrorUtils.propagateException(206, "No valid session token, make sure signUp or login has been called."));
        }
        n11 = 9304;
        if (object != null && (n10 = StringUtil.isEmpty((String)(object2 = ((AVObject)object).getObjectId()))) == 0) {
            object2 = ((AVFriendship)object).getFollowee();
            if (object2 != null && (n10 = StringUtil.isEmpty((String)(object2 = ((AVFriendship)object).getFollowee().getObjectId()))) == 0) {
                int n12;
                object3 = ((AVObject)object).generateChangedParam();
                if (object3 != null && (n10 = object3.size()) >= (n12 = 1)) {
                    object2 = new Object();
                    ((HashMap)object2).put(PARAM_ATTR_FRIENDSHIP, object3);
                    object3 = PaasClient.getStorageClient();
                    String string2 = this.getObjectId();
                    object = ((AVFriendship)object).getFollowee().getObjectId();
                    return ((StorageClient)object3).updateFriendship(aVUser, string2, (String)object, (Map)object2);
                }
                AVObject.logger.d("nothing is changed within friendship.");
                return z.t3(object);
            }
            return z.m2(ErrorUtils.propagateException(n11, "friendship request(followee) is invalid."));
        }
        return z.m2(ErrorUtils.propagateException(n11, "friendship request(objectId) is invalid."));
    }

    public z updatePasswordInBackground(String string2, String string3) {
        return PaasClient.getStorageClient().updatePassword(this, string2, string3);
    }
}

