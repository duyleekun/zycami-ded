/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.Transformer;
import cn.leancloud.ops.Utils;
import cn.leancloud.utils.StringUtil;
import java.util.Collection;
import java.util.HashMap;

public class AVRelation {
    private String key;
    private transient AVObject parent;
    private String targetClass;

    public AVRelation() {
    }

    public AVRelation(AVObject aVObject, String string2) {
        this();
        this.parent = aVObject;
        this.key = string2;
    }

    public AVRelation(String string2) {
        this(null, null);
        this.targetClass = string2;
    }

    public static AVQuery reverseQuery(Class object, String string2, AVObject aVObject) {
        String string3 = Transformer.getSubClassName((Class)object);
        AVQuery aVQuery = new AVQuery(string3, (Class)object);
        object = Utils.mapFromPointerObject(aVObject);
        aVQuery.whereEqualTo(string2, object);
        return aVQuery;
    }

    public static AVQuery reverseQuery(String object, String string2, AVObject aVObject) {
        AVQuery aVQuery = new AVQuery((String)object);
        object = Utils.mapFromPointerObject(aVObject);
        aVQuery.whereEqualTo(string2, object);
        return aVQuery;
    }

    public void add(AVObject object) {
        if (object != null) {
            CharSequence charSequence;
            Object object2 = this.targetClass;
            boolean bl2 = StringUtil.isEmpty((String)object2);
            if (bl2) {
                object2 = ((AVObject)object).getClassName();
                this.targetClass = object2;
            }
            if (!(bl2 = StringUtil.isEmpty((String)(object2 = this.targetClass))) && !(bl2 = ((String)(object2 = this.targetClass)).equals(charSequence = ((AVObject)object).getClassName()))) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Could not add class '");
                object = ((AVObject)object).getClassName();
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append("' to this relation,expect class is '");
                object = this.targetClass;
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append("'");
                object = ((StringBuilder)charSequence).toString();
                object2 = new IllegalArgumentException((String)object);
                throw object2;
            }
            object2 = this.parent;
            charSequence = this.key;
            ((AVObject)object2).addRelation((AVObject)object, (String)charSequence);
            return;
        }
        object = new IllegalArgumentException("null AVObject");
        throw object;
    }

    public void addAll(Collection object) {
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                AVObject aVObject = (AVObject)object.next();
                this.add(aVObject);
            }
        }
    }

    public String getKey() {
        return this.key;
    }

    public AVObject getParent() {
        return this.parent;
    }

    public AVQuery getQuery() {
        return this.getQuery(null);
    }

    public AVQuery getQuery(Class object) {
        boolean bl2;
        Object object2 = this.getParent();
        if (object2 != null && !(bl2 = StringUtil.isEmpty((String)(object2 = this.getParent().getObjectId())))) {
            object2 = new HashMap();
            Object object3 = Utils.mapFromPointerObject(this.getParent());
            object2.put("object", object3);
            object3 = this.getKey();
            Object object4 = "key";
            object2.put(object4, object3);
            object3 = this.getTargetClass();
            boolean bl3 = StringUtil.isEmpty((String)object3);
            if (bl3) {
                object3 = this.getParent().getClassName();
            }
            object4 = new AVQuery((String)object3, (Class)object);
            object3 = "$relatedTo";
            ((AVQuery)object4).addWhereItem((String)object3, null, object2);
            object = this.getTargetClass();
            boolean bl4 = StringUtil.isEmpty((String)object);
            if (bl4) {
                object = ((AVQuery)object4).getParameters();
                object2 = this.getKey();
                object3 = "redirectClassNameForKey";
                object.put(object3, object2);
            }
            return object4;
        }
        object = new IllegalStateException("unable to encode an association with an unsaved AVObject");
        throw object;
    }

    public String getTargetClass() {
        return this.targetClass;
    }

    public void remove(AVObject aVObject) {
        AVObject aVObject2 = this.parent;
        String string2 = this.key;
        aVObject2.removeRelation(aVObject, string2);
    }

    public void setKey(String string2) {
        this.key = string2;
    }

    public void setParent(AVObject aVObject) {
        this.parent = aVObject;
    }

    public void setTargetClass(String string2) {
        this.targetClass = string2;
    }
}

