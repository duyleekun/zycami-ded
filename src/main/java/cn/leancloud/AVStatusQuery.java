/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.AVStatus;
import cn.leancloud.AVStatusQuery$1;
import cn.leancloud.AVStatusQuery$2;
import cn.leancloud.AVStatusQuery$PaginationDirection;
import cn.leancloud.AVStatusQuery$SourceType;
import cn.leancloud.AVUser;
import cn.leancloud.StatusIterator;
import cn.leancloud.core.PaasClient;
import cn.leancloud.core.StorageClient;
import cn.leancloud.json.JSONObject$Builder;
import cn.leancloud.ops.Utils;
import cn.leancloud.utils.ErrorUtils;
import cn.leancloud.utils.StringUtil;
import e.a.v0.o;
import e.a.z;
import java.util.Map;

public class AVStatusQuery
extends AVQuery {
    private String inboxType = null;
    private StatusIterator iterator;
    private AVUser owner = null;
    private AVUser source = null;
    private AVStatusQuery$SourceType sourceType;

    public AVStatusQuery(AVStatusQuery$SourceType aVStatusQuery$SourceType) {
        super("_Status", AVStatus.class);
        StatusIterator statusIterator;
        this.sourceType = aVStatusQuery$SourceType;
        this.iterator = statusIterator = new StatusIterator(aVStatusQuery$SourceType);
    }

    public static /* synthetic */ StatusIterator access$000(AVStatusQuery aVStatusQuery) {
        return aVStatusQuery.iterator;
    }

    private Map assembleParameters(boolean n10) {
        Object object;
        String string2;
        Object object2;
        Object object3 = AVStatusQuery$SourceType.OWNED;
        Object object4 = this.sourceType;
        String string3 = "source";
        String string4 = "inboxType";
        if (object3 == object4) {
            object4 = this.inboxType;
            boolean bl2 = StringUtil.isEmpty((String)object4);
            if (!bl2) {
                object4 = this.inboxType;
                this.whereEqualTo(string4, object4);
            }
            if ((object4 = this.source) != null) {
                this.whereEqualTo(string3, object4);
            }
            if (n10 != 0) {
                object4 = this.iterator;
                ((StatusIterator)object4).fillConditions(this);
            } else {
                object4 = AVStatusQuery$PaginationDirection.NEW_TO_OLD;
                object2 = this.iterator.getDirection();
                string2 = "createdAt";
                if (object4 == object2) {
                    this.addDescendingOrder(string2);
                } else {
                    this.addAscendingOrder(string2);
                }
            }
        } else if (n10 == 0) {
            object4 = AVStatusQuery$PaginationDirection.NEW_TO_OLD;
            object2 = this.iterator.getDirection();
            string2 = "messageId";
            if (object4 == object2) {
                this.addDescendingOrder(string2);
            } else {
                this.addAscendingOrder(string2);
            }
        }
        object4 = super.assembleParameters();
        object2 = this.owner;
        string2 = null;
        if (object2 != null) {
            if (n10 != 0) {
                object = this.iterator;
                ((StatusIterator)object).fillConditions((Map)object4);
            }
            if ((n10 = StringUtil.isEmpty((String)(object = this.inboxType))) == 0) {
                object = this.inboxType;
                object4.put(string4, object);
            }
            object = JSONObject$Builder.create(Utils.mapFromAVObject(this.owner, false)).toJSONString();
            object3 = "owner";
            object4.put(object3, object);
        } else {
            object = this.sourceType;
            if (object3 != object && (object = this.source) != null) {
                object = JSONObject$Builder.create(Utils.mapFromAVObject((AVObject)object, false)).toJSONString();
                object4.put(string3, object);
            }
        }
        n10 = this.getPageSize();
        if (n10 > 0) {
            n10 = this.getPageSize();
            object = String.valueOf(n10);
            object3 = "limit";
            object4.put(object3, object);
        }
        return object4;
    }

    private z internalFindInBackground(AVUser object, int n10, boolean bl2) {
        Object object2;
        Map map;
        boolean bl3;
        AVUser aVUser;
        Object object3 = this.owner;
        if (object3 == null && (aVUser = this.source) == null) {
            return z.m2(ErrorUtils.illegalArgument("source or owner is null, please initialize correctly."));
        }
        if (object3 != null && !(bl3 = ((AVUser)object3).isAuthenticated())) {
            return z.m2(ErrorUtils.sessionMissingException());
        }
        if (bl2) {
            bl2 = true;
            map = this.assembleParameters(bl2);
        } else {
            map = this.assembleParameters();
        }
        if (n10 > 0) {
            object2 = String.valueOf(n10);
            object3 = "limit";
            map.put(object3, object2);
        }
        if ((object2 = this.owner) != null) {
            object = PaasClient.getStorageClient().queryInbox((AVUser)object, map);
            object2 = new AVStatusQuery$1(this);
            return ((z)object).H3((o)object2);
        }
        object = PaasClient.getStorageClient().queryStatus((AVUser)object, map);
        object2 = new AVStatusQuery$2(this);
        return ((z)object).H3((o)object2);
    }

    public Map assembleParameters() {
        return this.assembleParameters(false);
    }

    public z countInBackground() {
        AVUser aVUser;
        Object object = this.owner;
        if (object == null && (aVUser = this.source) == null) {
            return z.m2(ErrorUtils.illegalArgument("source or owner is null, please initialize correctly."));
        }
        if (object != null) {
            return z.m2(ErrorUtils.invalidStateException("countInBackground doesn't work for inbox query, please use unreadCountInBackground."));
        }
        object = this.assembleParameters();
        object.put("count", "1");
        object.put("limit", "0");
        return PaasClient.getStorageClient().queryCount(null, "_Status", (Map)object);
    }

    public z findInBackground(int n10) {
        return this.findInBackground(null, n10);
    }

    public z findInBackground(AVUser aVUser, int n10) {
        return this.internalFindInBackground(aVUser, n10, false);
    }

    public long getMaxId() {
        return this.iterator.getMaxId();
    }

    public int getPageSize() {
        return this.iterator.getPageSize();
    }

    public long getSinceId() {
        return this.iterator.getSinceId();
    }

    public z nextInBackground() {
        return this.internalFindInBackground(null, 0, true);
    }

    public void setDirection(AVStatusQuery$PaginationDirection aVStatusQuery$PaginationDirection) {
        this.iterator.setDirection(aVStatusQuery$PaginationDirection);
    }

    public void setInboxType(String string2) {
        this.inboxType = string2;
    }

    public void setMaxId(long l10) {
        this.iterator.setMaxId(l10);
    }

    public void setOwner(AVUser object) {
        this.owner = object;
        if (object != null) {
            object = this.getInclude();
            String string2 = "source";
            object.add(string2);
        }
    }

    public void setPageSize(int n10) {
        this.iterator.setPageSize(n10);
    }

    public void setSinceId(long l10) {
        this.iterator.setSinceId(l10);
    }

    public void setSource(AVUser aVUser) {
        this.source = aVUser;
    }

    public z unreadCountInBackground() {
        boolean bl2;
        Object object = this.owner;
        if (object != null && (bl2 = ((AVUser)object).isAuthenticated())) {
            object = this.assembleParameters();
            object.put("count", "1");
            object.put("limit", "0");
            StorageClient storageClient = PaasClient.getStorageClient();
            AVUser aVUser = this.owner;
            return storageClient.getInboxCount(aVUser, (Map)object);
        }
        return z.m2(ErrorUtils.sessionMissingException());
    }
}

