/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVACL;
import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.AVRelation;

public class AVRole
extends AVObject {
    private static final String ATTR_NAME = "name";
    public static final String CLASS_NAME = "_Role";
    private static final String RELATION_ROLE_NAME = "roles";
    private static final String RELATION_USER_NAME = "users";

    public AVRole() {
        super(CLASS_NAME);
    }

    public AVRole(String string2) {
        super(CLASS_NAME);
        this.put(ATTR_NAME, string2);
    }

    public AVRole(String string2, AVACL aVACL) {
        this(string2);
        this.acl = aVACL;
    }

    public static AVQuery getQuery() {
        AVQuery aVQuery = new AVQuery(CLASS_NAME);
        return aVQuery;
    }

    public String getName() {
        return this.getString(ATTR_NAME);
    }

    public AVRelation getRoles() {
        return super.getRelation(RELATION_ROLE_NAME);
    }

    public AVRelation getUsers() {
        return super.getRelation(RELATION_USER_NAME);
    }

    public void setName(String string2) {
        super.put(ATTR_NAME, string2);
    }
}

