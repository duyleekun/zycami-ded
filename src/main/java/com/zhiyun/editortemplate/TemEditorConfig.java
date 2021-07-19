/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate;

import com.zhiyun.editorinterface.EditConfig$ResourceType;
import d.v.e.j.a;
import d.v.e.j.b;
import d.v.e.l.k2;
import d.v.e.l.s1;
import d.v.j.d;
import java.io.File;

public class TemEditorConfig {
    public static final String A = "eov/TrailerList.json";
    public static final int a = 251;
    public static final int b = 5;
    public static final int c = 1000;
    private static final String d = "fonts/";
    private static final String e = "fonts/caption/";
    private static final String f = "sticker/";
    private static final String g = "filter/";
    private static final String h = "filter/luts8/";
    private static final String i = "filter/videofx/";
    private static final String j = "song/";
    private static final String k = "transition/";
    private static final String l = "speed/";
    private static final String m = "editor_template/";
    private static final String n = "eov/";
    private static final String o = "track/";
    private static final String p = "smart_script/";
    private static final String q = "smart_script/Track/";
    private static final String r = "smart_script/TrackChain/";
    private static final String s = "smart_script/Editor/";
    private static final String t = "smart_script/Smart/";
    private static final String u = "smart_script/LocalSource/";
    public static final String v = "track/TrackList_co.json";
    public static final String w = "smart_script/Smart/smartList.json";
    public static final String x = "smart_script/Track/trackList.json";
    public static final String y = "editor_template/EditorTypeList.json";
    public static final String z = "editor_template/EditorProtocolList.json";

    private static String a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        string2 = File.separator;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static String b(a object) {
        boolean bl2;
        String string2 = object.getType();
        String string3 = EditConfig$ResourceType.MUSIC.getType();
        boolean bl3 = string3.equals(string2);
        object = bl3 ? j : ((bl3 = (string3 = EditConfig$ResourceType.RECORD.getType()).equals(string2)) ? null : ((bl3 = (string3 = EditConfig$ResourceType.FILTER.getType()).equals(string2)) ? g : ((bl3 = (string3 = EditConfig$ResourceType.FONT.getType()).equals(string2)) ? d : ((bl3 = (string3 = EditConfig$ResourceType.CAPTION.getType()).equals(string2)) ? e : ((bl3 = (string3 = EditConfig$ResourceType.STICKER.getType()).equals(string2)) ? f : ((bl3 = (string3 = EditConfig$ResourceType.TRANSITION.getType()).equals(string2)) ? k : ((bl2 = (string3 = EditConfig$ResourceType.SPEED.getType()).equals(string2)) ? l : d.v.e.j.b.g((a)object))))))));
        return object;
    }

    public static String c(a object, String string2) {
        boolean bl2 = d.v.e.j.b.i(string2);
        if (!bl2 && !(bl2 = s1.q(string2))) {
            StringBuilder stringBuilder = new StringBuilder();
            object = TemEditorConfig.b((a)object);
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
            object = stringBuilder.toString();
            string2 = d.v.e.j.b.d((String)object);
        }
        return string2;
    }

    private static String d() {
        return TemEditorConfig.a(k2.m().getAbsolutePath());
    }

    public static String e() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = TemEditorConfig.d();
        stringBuilder.append(string2);
        string2 = TemEditorConfig.a("Library");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static String f() {
        return TemEditorConfig.a(d.v.j.d.d().getAbsolutePath());
    }
}

