/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVACL;
import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.AVStatus$1;
import cn.leancloud.AVStatus$INBOX_TYPE;
import cn.leancloud.AVStatusQuery;
import cn.leancloud.AVStatusQuery$PaginationDirection;
import cn.leancloud.AVStatusQuery$SourceType;
import cn.leancloud.AVUser;
import cn.leancloud.core.PaasClient;
import cn.leancloud.json.JSON;
import cn.leancloud.json.JSONObject;
import cn.leancloud.ops.Utils;
import cn.leancloud.utils.ErrorUtils;
import cn.leancloud.utils.StringUtil;
import e.a.v0.o;
import e.a.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class AVStatus
extends AVObject {
    public static final String ATTR_IMAGE = "image";
    public static final String ATTR_INBOX_TYPE = "inboxType";
    public static final String ATTR_MESSAGE = "message";
    public static final String ATTR_MESSAGE_ID = "messageId";
    public static final String ATTR_OWNER = "owner";
    public static final String ATTR_SOURCE = "source";
    public static final String CLASS_NAME = "_Status";
    public static int INVALID_MESSAGE_ID;

    public AVStatus() {
        super(CLASS_NAME);
        this.totallyOverwrite = true;
        this.endpointClassName = "statuses";
    }

    public AVStatus(AVObject aVObject) {
        super(aVObject);
    }

    private static boolean checkCurrentUserAuthenticated() {
        return AVStatus.checkUserAuthenticated(AVUser.getCurrentUser());
    }

    private static boolean checkUserAuthenticated(AVUser aVUser) {
        boolean bl2;
        return aVUser != null && (bl2 = aVUser.isAuthenticated());
    }

    public static AVStatus createStatus(String string2, String string3) {
        AVStatus aVStatus = new AVStatus();
        aVStatus.setImageUrl(string2);
        aVStatus.setMessage(string3);
        return aVStatus;
    }

    public static AVStatus createStatusWithData(Map map) {
        AVStatus aVStatus = new AVStatus();
        aVStatus.resetServerData(map);
        return aVStatus;
    }

    public static z deleteInBackground(AVStatus aVStatus) {
        return AVStatus.deleteInBackground(AVUser.currentUser(), aVStatus);
    }

    public static z deleteInBackground(AVUser aVUser, AVStatus object) {
        Object object2 = AVStatus.checkUserAuthenticated(aVUser);
        if (!object2) {
            return z.m2(ErrorUtils.sessionMissingException());
        }
        String string2 = aVUser.getObjectId();
        HashMap<String, Object> hashMap = null;
        Object object3 = ((AVStatus)object).get(ATTR_SOURCE);
        boolean bl2 = object3 instanceof AVObject;
        String string3 = "objectId";
        if (bl2) {
            hashMap = object3;
            hashMap = (AVObject)object3;
        } else {
            bl2 = object3 instanceof JSONObject;
            String string4 = "className";
            if (bl2) {
                object3 = (JSONObject)object3;
                hashMap = ((JSONObject)object3).getString(string4);
                object3 = ((JSONObject)object3).getString(string3);
                hashMap = AVObject.createWithoutData((String)((Object)hashMap), (String)object3);
            } else {
                bl2 = object3 instanceof HashMap;
                if (bl2) {
                    object3 = (HashMap)object3;
                    hashMap = (String)((HashMap)object3).get(string4);
                    object3 = (String)((HashMap)object3).get(string3);
                    hashMap = AVObject.createWithoutData((String)((Object)hashMap), (String)object3);
                }
            }
        }
        object3 = ((AVObject)object).getObjectId();
        long l10 = ((AVStatus)object).getMessageId();
        if (hashMap != null && (object2 = string2.equals(hashMap = ((AVObject)((Object)hashMap)).getString(string3)))) {
            boolean bl3 = StringUtil.isEmpty((String)object3);
            if (bl3) {
                return z.m2(ErrorUtils.invalidObjectIdException());
            }
            return PaasClient.getStorageClient().deleteStatus(aVUser, (String)object3);
        }
        long l11 = INVALID_MESSAGE_ID;
        long l12 = l11 - l10;
        object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (!object2) {
            return z.m2(ErrorUtils.invalidObjectIdException());
        }
        string2 = JSON.toJSONString(Utils.mapFromAVObject(aVUser, false));
        hashMap = new HashMap<String, Object>();
        object3 = String.valueOf(l10);
        hashMap.put(ATTR_MESSAGE_ID, object3);
        object = ((AVStatus)object).getInboxType();
        hashMap.put(ATTR_INBOX_TYPE, object);
        hashMap.put(ATTR_OWNER, string2);
        return PaasClient.getStorageClient().deleteInboxStatus(aVUser, hashMap);
    }

    private AVQuery generateFollowerQuery(String arrayList) {
        Object object = new AVUser();
        ((AVObject)object).setObjectId((String)((Object)arrayList));
        arrayList = new ArrayList<String>();
        arrayList.add("follower");
        AVQuery aVQuery = new AVQuery("_Follower");
        object = Utils.mapFromAVObject((AVObject)object, false);
        aVQuery.whereEqualTo("user", object);
        aVQuery.selectKeys(arrayList);
        return aVQuery;
    }

    public static z getStatusWithIdInBackground(AVUser aVUser, String string2) {
        return PaasClient.getStorageClient().fetchStatus(aVUser, string2);
    }

    public static z getStatusWithIdInBackground(String string2) {
        return AVStatus.getStatusWithIdInBackground(null, string2);
    }

    public static AVStatusQuery inboxQuery(AVUser object, String string2) {
        AVStatusQuery$SourceType aVStatusQuery$SourceType = AVStatusQuery$SourceType.INBOX;
        AVStatusQuery aVStatusQuery = new AVStatusQuery(aVStatusQuery$SourceType);
        aVStatusQuery.setOwner((AVUser)object);
        object = AVStatusQuery$PaginationDirection.NEW_TO_OLD;
        aVStatusQuery.setDirection((AVStatusQuery$PaginationDirection)((Object)object));
        aVStatusQuery.setInboxType(string2);
        return aVStatusQuery;
    }

    private z sendInBackground(AVUser object, String object2, AVQuery aVQuery) {
        boolean bl2 = AVStatus.checkUserAuthenticated((AVUser)object);
        if (!bl2) {
            return z.m2(ErrorUtils.sessionMissingException());
        }
        this.setSource((AVObject)object);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        ConcurrentMap concurrentMap = this.serverData;
        hashMap.put("data", concurrentMap);
        hashMap.put(ATTR_INBOX_TYPE, object2);
        object2 = aVQuery.assembleJsonParam();
        hashMap.put("query", object2);
        object = PaasClient.getStorageClient().postStatus((AVUser)object, hashMap);
        object2 = new AVStatus$1(this);
        return ((z)object).H3((o)object2);
    }

    private z sendInBackground(String string2, AVQuery aVQuery) {
        AVUser aVUser = AVUser.currentUser();
        return this.sendInBackground(aVUser, string2, aVQuery);
    }

    public static AVStatusQuery statusQuery(AVUser object) {
        AVStatusQuery$SourceType aVStatusQuery$SourceType = AVStatusQuery$SourceType.OWNED;
        AVStatusQuery aVStatusQuery = new AVStatusQuery(aVStatusQuery$SourceType);
        aVStatusQuery.setSource((AVUser)object);
        object = AVStatusQuery$PaginationDirection.NEW_TO_OLD;
        aVStatusQuery.setDirection((AVStatusQuery$PaginationDirection)((Object)object));
        object = AVStatus$INBOX_TYPE.TIMELINE.toString();
        aVStatusQuery.setInboxType((String)object);
        return aVStatusQuery;
    }

    public void add(String object, Object object2) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void addAll(String object, Collection collection) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void addAllUnique(String object, Collection collection) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void addUnique(String object, Object object2) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public z deleteInBackground() {
        return AVStatus.deleteInBackground(this);
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object == null) {
            return false;
        }
        Object object2 = this.getClass();
        if (object2 != (clazz = object.getClass())) {
            return false;
        }
        object2 = this.objectId;
        boolean bl3 = StringUtil.isEmpty((String)object2);
        if (bl3) {
            return false;
        }
        object = (AVStatus)object;
        object2 = this.objectId;
        object = ((AVObject)object).objectId;
        boolean bl4 = ((String)object2).equals(object);
        if (!bl4) {
            return false;
        }
        return bl2;
    }

    public AVObject fetch() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public AVObject fetch(String object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public AVObject fetchIfNeeded() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public z fetchIfNeededInBackground() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public z fetchInBackground() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public z fetchInBackground(String object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public Object get(String string2) {
        return this.serverData.get(string2);
    }

    public AVACL getACL() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public String getImageUrl() {
        return this.getString(ATTR_IMAGE);
    }

    public String getInboxType() {
        return this.getString(ATTR_INBOX_TYPE);
    }

    public String getMessage() {
        return this.getString(ATTR_MESSAGE);
    }

    public long getMessageId() {
        return this.getLong(ATTR_MESSAGE_ID);
    }

    public AVUser getSource() {
        return (AVUser)this.getAVObject(ATTR_SOURCE);
    }

    public boolean isFetchWhenSave() {
        return false;
    }

    public void put(String string2, Object object) {
        this.serverData.put(string2, object);
    }

    public void refresh() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void refresh(String object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public z refreshInBackground() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void remove(String string2) {
        this.serverData.remove(string2);
    }

    public void save() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void saveEventually() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public z saveInBackground() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public z sendPrivatelyInBackground(String string2) {
        AVQuery aVQuery = AVUser.getQuery();
        aVQuery.whereEqualTo("objectId", string2);
        string2 = AVStatus$INBOX_TYPE.PRIVATE.toString();
        return this.sendInBackground(string2, aVQuery);
    }

    public z sendToFollowersInBackground() {
        String string2 = AVStatus$INBOX_TYPE.TIMELINE.toString();
        return this.sendToFollowersInBackground(string2);
    }

    public z sendToFollowersInBackground(String string2) {
        boolean bl2 = AVStatus.checkCurrentUserAuthenticated();
        if (!bl2) {
            return z.m2(ErrorUtils.sessionMissingException());
        }
        Object object = AVUser.currentUser().getObjectId();
        object = this.generateFollowerQuery((String)object);
        return this.sendInBackground(string2, (AVQuery)object);
    }

    public z sendToUsersInBackground(AVQuery aVQuery) {
        String string2 = AVStatus$INBOX_TYPE.TIMELINE.toString();
        return this.sendToUsersInBackground(string2, aVQuery);
    }

    public z sendToUsersInBackground(String string2, AVQuery aVQuery) {
        return this.sendInBackground(string2, aVQuery);
    }

    public void setACL(AVACL object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void setFetchWhenSave(boolean bl2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void setImageUrl(String string2) {
        this.put(ATTR_IMAGE, string2);
    }

    public void setInboxType(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            String string3 = ATTR_INBOX_TYPE;
            this.put(string3, string2);
        }
    }

    public void setMessage(String string2) {
        this.put(ATTR_MESSAGE, string2);
    }

    public void setMessageId(long l10) {
        Long l11 = l10;
        this.put(ATTR_MESSAGE_ID, l11);
    }

    public void setSource(AVObject object) {
        object = Utils.mapFromAVObject((AVObject)object, false);
        this.put(ATTR_SOURCE, object);
    }

    public AVObject toObject() {
        String string2 = this.objectId;
        return AVObject.createWithoutData(CLASS_NAME, string2);
    }
}

