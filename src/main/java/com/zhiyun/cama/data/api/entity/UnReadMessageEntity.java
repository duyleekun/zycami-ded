/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

import com.zhiyun.cama.data.api.entity.UnReadMessageEntity$CountBaseEntity;
import com.zhiyun.cama.data.api.entity.UnReadMessageEntity$PersonalCountEntity;
import com.zhiyun.net.BaseEntity;

public class UnReadMessageEntity
extends BaseEntity {
    public UnReadMessageEntity$CountBaseEntity comment;
    public UnReadMessageEntity$CountBaseEntity follow;
    public UnReadMessageEntity$CountBaseEntity like;
    public UnReadMessageEntity$CountBaseEntity message;
    public UnReadMessageEntity$CountBaseEntity notice;
    public UnReadMessageEntity$PersonalCountEntity personal;
}

