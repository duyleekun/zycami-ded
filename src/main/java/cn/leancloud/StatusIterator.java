/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.AVStatus;
import cn.leancloud.AVStatusQuery$PaginationDirection;
import cn.leancloud.AVStatusQuery$SourceType;
import cn.leancloud.json.JSON;
import java.util.Map;

public class StatusIterator {
    private AVStatusQuery$PaginationDirection direction;
    public AVStatus lastStatus;
    private long maxId;
    private int pageSize;
    private long sinceId;
    public AVStatusQuery$SourceType sourceType;

    public StatusIterator(AVStatusQuery$SourceType aVStatusQuery$SourceType) {
        AVStatusQuery$PaginationDirection aVStatusQuery$PaginationDirection = AVStatusQuery$PaginationDirection.NEW_TO_OLD;
        this(aVStatusQuery$SourceType, aVStatusQuery$PaginationDirection, 0);
    }

    public StatusIterator(AVStatusQuery$SourceType aVStatusQuery$SourceType, AVStatusQuery$PaginationDirection aVStatusQuery$PaginationDirection, int n10) {
        long l10;
        long l11;
        this.lastStatus = null;
        int n11 = AVStatus.INVALID_MESSAGE_ID;
        this.sinceId = l11 = (long)n11;
        this.maxId = l10 = (long)n11;
        this.sourceType = aVStatusQuery$SourceType;
        this.direction = aVStatusQuery$PaginationDirection;
        this.pageSize = n10;
    }

    public void encounter(AVStatus aVStatus) {
        this.lastStatus = aVStatus;
        Enum enum_ = AVStatusQuery$SourceType.INBOX;
        Enum enum_2 = this.sourceType;
        if (enum_ == enum_2 && aVStatus != null) {
            enum_ = this.direction;
            enum_2 = AVStatusQuery$PaginationDirection.OLD_TO_NEW;
            if (enum_ == enum_2) {
                long l10;
                long l11 = aVStatus.getMessageId();
                long l12 = l11 - (l10 = this.sinceId);
                Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object > 0) {
                    this.sinceId = l11 = aVStatus.getMessageId();
                }
            } else {
                long l13 = 0L;
                long l14 = this.maxId;
                long l15 = l13 - l14;
                Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (object == false) {
                    this.maxId = l13 = aVStatus.getMessageId();
                } else {
                    l13 = aVStatus.getMessageId();
                    long l16 = l13 - (l14 = this.maxId);
                    object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                    if (object < 0) {
                        this.maxId = l13 = aVStatus.getMessageId();
                    }
                }
            }
        }
    }

    public void fillConditions(AVQuery aVQuery) {
        Object object;
        if (aVQuery != null && (object = this.lastStatus) != null) {
            AVStatusQuery$PaginationDirection aVStatusQuery$PaginationDirection = AVStatusQuery$PaginationDirection.NEW_TO_OLD;
            AVStatusQuery$PaginationDirection aVStatusQuery$PaginationDirection2 = this.direction;
            String string2 = "createdAt";
            if (aVStatusQuery$PaginationDirection == aVStatusQuery$PaginationDirection2) {
                object = ((AVObject)object).getCreatedAt();
                aVQuery.whereLessThan(string2, object);
            } else {
                object = ((AVObject)object).getCreatedAt();
                aVQuery.whereGreaterThan(string2, object);
            }
        }
    }

    public void fillConditions(Map map) {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        Object object = this.direction;
        Object object2 = AVStatusQuery$PaginationDirection.OLD_TO_NEW;
        if (object == object2 && (l14 = (l13 = (l12 = this.sinceId) - (l11 = (long)AVStatus.INVALID_MESSAGE_ID)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) > 0) {
            object = String.valueOf(l12);
            object2 = "sinceId";
            map.put(object2, object);
        }
        if ((object = this.direction) == (object2 = AVStatusQuery$PaginationDirection.NEW_TO_OLD) && (l14 = (l10 = (l12 = this.maxId) - (l11 = (long)AVStatus.INVALID_MESSAGE_ID)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) > 0) {
            l11 = 1L;
            object = String.valueOf(l12 -= l11);
            object2 = "maxId";
            map.put(object2, object);
        }
    }

    public AVStatusQuery$PaginationDirection getDirection() {
        return this.direction;
    }

    public long getMaxId() {
        return this.maxId;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public long getSinceId() {
        return this.sinceId;
    }

    public void setDirection(AVStatusQuery$PaginationDirection aVStatusQuery$PaginationDirection) {
        this.direction = aVStatusQuery$PaginationDirection;
    }

    public void setMaxId(long l10) {
        this.maxId = l10;
    }

    public void setPageSize(int n10) {
        int n11;
        if (n10 > 0 && n10 < (n11 = 200)) {
            this.pageSize = n10;
        }
    }

    public void setSinceId(long l10) {
        this.sinceId = l10;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}

