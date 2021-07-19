/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.util;

import cn.leancloud.AVLogger;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import java.lang.reflect.Method;

public class FieldAttribute {
    private static final AVLogger LOGGER = LogUtil.getLogger(FieldAttribute.class);
    public String aliaName;
    public String fieldName;
    public Class fieldType;
    public Method getterMethod;
    public Method setterMethod;

    public FieldAttribute(String string2, String string3, Method method, Method method2, Class clazz) {
        this.aliaName = string3;
        this.fieldName = string2;
        this.getterMethod = method;
        this.setterMethod = method2;
        this.fieldType = clazz;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object get(Object object) {
        try {
            Method method = this.getterMethod;
            if (method != null) {
                Object var3_4 = null;
                Object[] objectArray = new Object[]{};
                return method.invoke(object, objectArray);
            }
            object = new RuntimeException();
            throw object;
        }
        catch (Exception exception) {}
        object = LOGGER;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Failed to invoke getter:");
        String string2 = this.fieldName;
        charSequence.append(string2);
        charSequence = charSequence.toString();
        ((AVLogger)object).d((String)charSequence);
        return null;
    }

    public String getAliaName() {
        String string2 = this.aliaName;
        boolean bl2 = StringUtil.isEmpty(string2);
        string2 = bl2 ? this.fieldName : this.aliaName;
        return string2;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public Class getFieldType() {
        return this.fieldType;
    }

    public Method getGetterMethod() {
        return this.getterMethod;
    }

    public Method getSetterMethod() {
        return this.setterMethod;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void set(Object object, Object object2) {
        String string2 = "Failed to invoke setter:";
        try {
            Method method = this.setterMethod;
            if (method != null) {
                int n10 = 1;
                Object[] objectArray = new Object[n10];
                objectArray[0] = object2;
                method.invoke(object, objectArray);
                return;
            }
            object = new RuntimeException();
            throw object;
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            object = LOGGER;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string2);
            string2 = this.fieldName;
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            ((AVLogger)object).d((String)object2);
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {}
        object = LOGGER;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(string2);
        string2 = this.fieldName;
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        ((AVLogger)object).d((String)object2);
    }

    public void setAliaName(String string2) {
        this.aliaName = string2;
    }

    public void setFieldName(String string2) {
        this.fieldName = string2;
    }

    public void setFieldType(Class clazz) {
        this.fieldType = clazz;
    }

    public void setGetterMethod(Method method) {
        this.getterMethod = method;
    }

    public void setSetterMethod(Method method) {
        this.setterMethod = method;
    }
}

