/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import java.util.HashMap;
import java.util.Map;

public class NvsFxDescription$ParamInfoObject {
    public static final String PARAM_BOOL_DEF_VAL = "boolDefVal";
    public static final String PARAM_COLOR_DEF_A = "colorDefA";
    public static final String PARAM_COLOR_DEF_B = "colorDefB";
    public static final String PARAM_COLOR_DEF_G = "colorDefG";
    public static final String PARAM_COLOR_DEF_R = "colorDefR";
    public static final String PARAM_FLOAT_DEF_VAL = "floatDefVal";
    public static final String PARAM_FLOAT_MAX_VAL = "floatMaxVal";
    public static final String PARAM_FLOAT_MIN_VAL = "floatMinVal";
    public static final String PARAM_INT_DEF_VAL = "intDefVal";
    public static final String PARAM_INT_MAX_VAL = "intMaxVal";
    public static final String PARAM_INT_MIN_VAL = "intMinVal";
    public static final String PARAM_MENU_ARRAY = "menuArray";
    public static final String PARAM_MENU_DEF_VAL = "menuDefVal";
    public static final String PARAM_NAME = "paramName";
    public static final String PARAM_POSITION2D_DEF_X = "position2DDefX";
    public static final String PARAM_POSITION2D_DEF_Y = "position2DDefY";
    public static final String PARAM_POSITION3D_DEF_X = "position3DDefX";
    public static final String PARAM_POSITION3D_DEF_Y = "position3DDefY";
    public static final String PARAM_POSITION3D_DEF_Z = "position3DDefZ";
    public static final String PARAM_STRING_DEF = "stringDef";
    public static final String PARAM_STRING_TYPE = "stringType";
    public static final int PARAM_STRING_TYPE_DIRECTORYPATH = 3;
    public static final int PARAM_STRING_TYPE_FILEPATH = 2;
    public static final int PARAM_STRING_TYPE_INVALID = 255;
    public static final int PARAM_STRING_TYPE_LABEL = 4;
    public static final int PARAM_STRING_TYPE_MULTILINE = 1;
    public static final int PARAM_STRING_TYPE_SINGLELINE = 0;
    public static final String PARAM_TYPE = "paramType";
    public static final String PARAM_TYPE_ARBITRARY = "ARBITRARY";
    public static final String PARAM_TYPE_BOOL = "BOOL";
    public static final String PARAM_TYPE_COLOR = "COLOR";
    public static final String PARAM_TYPE_FLOAT = "FLOAT";
    public static final String PARAM_TYPE_INT = "INT";
    public static final String PARAM_TYPE_MENU = "MENU";
    public static final String PARAM_TYPE_POSITION2D = "POSITION2D";
    public static final String PARAM_TYPE_POSITION3D = "POSITION3D";
    public static final String PARAM_TYPE_STRING = "STRING";
    private Map m_mapParams;

    public NvsFxDescription$ParamInfoObject() {
        HashMap hashMap;
        this.m_mapParams = hashMap = new HashMap();
    }

    public final boolean getBoolean(String object) {
        Map map = this.m_mapParams;
        int n10 = (Integer)(object = (Integer)map.get(object));
        if (!n10) {
            n10 = 0;
            object = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }

    public final double getFloat(String string2) {
        return (Double)this.m_mapParams.get(string2);
    }

    public final int getInteger(String string2) {
        return (Integer)this.m_mapParams.get(string2);
    }

    public final Object getObject(String string2) {
        return this.m_mapParams.get(string2);
    }

    public final String getString(String string2) {
        return (String)this.m_mapParams.get(string2);
    }

    public final void setFloat(String string2, double d10) {
        Map map = this.m_mapParams;
        Double d11 = d10;
        map.put(string2, d11);
    }

    public final void setInteger(String string2, int n10) {
        Map map = this.m_mapParams;
        Integer n11 = n10;
        map.put(string2, n11);
    }

    public final void setObject(String string2, Object object) {
        this.m_mapParams.put(string2, object);
    }

    public final void setString(String string2, String string3) {
        this.m_mapParams.put(string2, string3);
    }
}

