/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVACL$Permissions;
import cn.leancloud.AVObject;
import cn.leancloud.AVUser;
import cn.leancloud.json.JSON;
import cn.leancloud.json.JSONObject;
import cn.leancloud.utils.StringUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AVACL {
    private static final String KEY_READ_PERMISSION = "read";
    private static final String KEY_WRITE_PERMISSION = "write";
    private static final String PUBLIC_KEY = "*";
    private static final String ROLE_PREFIX = "role:";
    private final Map permissionsById;

    public AVACL() {
        HashMap hashMap;
        this.permissionsById = hashMap = new HashMap();
    }

    public AVACL(AVACL object) {
        HashMap hashMap;
        this.permissionsById = hashMap = new HashMap();
        object = ((AVACL)object).permissionsById;
        hashMap.putAll(object);
    }

    public AVACL(AVUser aVUser) {
        HashMap hashMap;
        this.permissionsById = hashMap = new HashMap();
        boolean bl2 = true;
        this.setReadAccess(aVUser, bl2);
        this.setWriteAccess(aVUser, bl2);
    }

    public AVACL(JSONObject object) {
        Object object2 = new HashMap();
        this.permissionsById = object2;
        if (object != null) {
            boolean bl2;
            object = object.entrySet().iterator();
            while (bl2 = object.hasNext()) {
                boolean bl3;
                object2 = (Map.Entry)object.next();
                Object object3 = object2.getValue();
                if (object3 == null || !(bl3 = object3 instanceof HashMap)) continue;
                object3 = this.permissionsById;
                Object k10 = object2.getKey();
                object2 = (HashMap)object2.getValue();
                AVACL$Permissions aVACL$Permissions = new AVACL$Permissions((HashMap)object2);
                object3.put(k10, (AVACL$Permissions)aVACL$Permissions);
            }
        }
    }

    public AVACL(HashMap object) {
        Object object2 = new HashMap();
        this.permissionsById = object2;
        if (object != null) {
            boolean bl2;
            object = ((HashMap)object).entrySet().iterator();
            while (bl2 = object.hasNext()) {
                boolean bl3;
                object2 = (Map.Entry)object.next();
                Object object3 = object2.getValue();
                if (object3 == null || !(bl3 = object3 instanceof HashMap)) continue;
                object3 = this.permissionsById;
                Object k10 = object2.getKey();
                object2 = (HashMap)object2.getValue();
                AVACL$Permissions aVACL$Permissions = new AVACL$Permissions((HashMap)object2);
                object3.put(k10, (AVACL$Permissions)aVACL$Permissions);
            }
        }
    }

    private void setPermissionsIfNonEmpty(String string2, boolean bl2, boolean bl3) {
        if (!bl2 && !bl3) {
            Map map = this.permissionsById;
            map.remove(string2);
        } else {
            Map map = this.permissionsById;
            AVACL$Permissions aVACL$Permissions = new AVACL$Permissions(bl2, bl3);
            map.put(string2, aVACL$Permissions);
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof AVACL;
        if (!bl2) {
            return false;
        }
        object = (AVACL)object;
        Map map = this.getPermissionsById();
        object = ((AVACL)object).getPermissionsById();
        return Objects.equals(map, object);
    }

    public Map getPermissionsById() {
        return this.permissionsById;
    }

    public boolean getPublicReadAccess() {
        return this.getReadAccess(PUBLIC_KEY);
    }

    public boolean getPublicWriteAccess() {
        return this.getWriteAccess(PUBLIC_KEY);
    }

    public boolean getReadAccess(AVUser object) {
        String string2;
        boolean bl2;
        if (object != null && !(bl2 = StringUtil.isEmpty(string2 = ((AVObject)object).getObjectId()))) {
            object = ((AVObject)object).getObjectId();
            return this.getReadAccess((String)object);
        }
        return false;
    }

    public boolean getReadAccess(String object) {
        boolean bl2;
        boolean bl3 = StringUtil.isEmpty((String)object);
        boolean bl4 = false;
        if (bl3) {
            return false;
        }
        Map map = this.permissionsById;
        if ((object = (AVACL$Permissions)map.get(object)) != null && (bl2 = ((AVACL$Permissions)object).getReadPermission())) {
            bl4 = true;
        }
        return bl4;
    }

    public boolean getRoleReadAccess(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ROLE_PREFIX);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        return this.getReadAccess(string2);
    }

    public boolean getRoleWriteAccess(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ROLE_PREFIX);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        return this.getWriteAccess(string2);
    }

    public boolean getWriteAccess(AVUser object) {
        String string2;
        boolean bl2;
        if (object != null && !(bl2 = StringUtil.isEmpty(string2 = ((AVObject)object).getObjectId()))) {
            object = ((AVObject)object).getObjectId();
            return this.getWriteAccess((String)object);
        }
        return false;
    }

    public boolean getWriteAccess(String object) {
        boolean bl2;
        boolean bl3 = StringUtil.isEmpty((String)object);
        boolean bl4 = false;
        if (bl3) {
            return false;
        }
        Map map = this.permissionsById;
        if ((object = (AVACL$Permissions)map.get(object)) != null && (bl2 = ((AVACL$Permissions)object).getWritePermission())) {
            bl4 = true;
        }
        return bl4;
    }

    public int hashCode() {
        Object[] objectArray = new Object[1];
        Map map = this.getPermissionsById();
        objectArray[0] = map;
        return Objects.hash(objectArray);
    }

    public void setPublicReadAccess(boolean bl2) {
        this.setReadAccess(PUBLIC_KEY, bl2);
    }

    public void setPublicWriteAccess(boolean bl2) {
        this.setWriteAccess(PUBLIC_KEY, bl2);
    }

    public void setReadAccess(AVUser object, boolean bl2) {
        String string2;
        boolean bl3;
        if (object != null && !(bl3 = StringUtil.isEmpty(string2 = ((AVObject)object).getObjectId()))) {
            object = ((AVObject)object).getObjectId();
            this.setReadAccess((String)object, bl2);
            return;
        }
        object = new IllegalArgumentException("cannot setRead/WriteAccess for a user with null id");
        throw object;
    }

    public void setReadAccess(String object, boolean bl2) {
        boolean bl3 = StringUtil.isEmpty((String)object);
        if (!bl3) {
            bl3 = this.getWriteAccess((String)object);
            this.setPermissionsIfNonEmpty((String)object, bl2, bl3);
            return;
        }
        object = new IllegalArgumentException("cannot setRead/WriteAccess for null userId");
        throw object;
    }

    public void setRoleReadAccess(String object, boolean bl2) {
        boolean bl3 = StringUtil.isEmpty((String)object);
        if (!bl3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ROLE_PREFIX);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            this.setReadAccess((String)object, bl2);
            return;
        }
        object = new IllegalArgumentException("cannot setRead/WriteAccess to a empty role");
        throw object;
    }

    public void setRoleWriteAccess(String object, boolean bl2) {
        boolean bl3 = StringUtil.isEmpty((String)object);
        if (!bl3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ROLE_PREFIX);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            this.setWriteAccess((String)object, bl2);
            return;
        }
        object = new IllegalArgumentException("cannot setRead/WriteAccess to a empty role");
        throw object;
    }

    public void setWriteAccess(AVUser object, boolean bl2) {
        String string2;
        boolean bl3;
        if (object != null && !(bl3 = StringUtil.isEmpty(string2 = ((AVObject)object).getObjectId()))) {
            object = ((AVObject)object).getObjectId();
            this.setWriteAccess((String)object, bl2);
            return;
        }
        object = new IllegalArgumentException("cannot setRead/WriteAccess for a user with null id");
        throw object;
    }

    public void setWriteAccess(String object, boolean bl2) {
        boolean bl3 = StringUtil.isEmpty((String)object);
        if (!bl3) {
            bl3 = this.getReadAccess((String)object);
            this.setPermissionsIfNonEmpty((String)object, bl3, bl2);
            return;
        }
        object = new IllegalArgumentException("cannot setRead/WriteAccess for null userId");
        throw object;
    }

    public JSONObject toJSONObject() {
        return JSON.parseObject(JSON.toJSONString(this.permissionsById));
    }
}

