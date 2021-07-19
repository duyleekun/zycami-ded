/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.google.android.gms.common.util.zzd;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsonUtils {
    private static final Pattern zza = Pattern.compile("\\\\.");
    private static final Pattern zzb = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    private JsonUtils() {
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean areJsonValuesEquivalent(Object object, Object object2) {
        int n10;
        boolean bl2 = true;
        if (object == null && object2 == null) {
            return bl2;
        }
        if (object == null || object2 == null) return false;
        int n11 = object instanceof JSONObject;
        if (n11 != 0 && (n11 = object2 instanceof JSONObject) != 0) {
            int n12;
            object = (JSONObject)object;
            object2 = (JSONObject)object2;
            n11 = object.length();
            if (n11 != (n12 = object2.length())) {
                return false;
            }
            Iterator iterator2 = object.keys();
            while ((n12 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                Object object3 = (String)iterator2.next();
                boolean bl3 = object2.has((String)object3);
                if (!bl3) {
                    return false;
                }
                Object object4 = object.get((String)object3);
                object3 = object2.get((String)object3);
                n12 = (int)(JsonUtils.areJsonValuesEquivalent(object4, object3) ? 1 : 0);
                if (n12 != 0) continue;
                return false;
            }
            return bl2;
        }
        n11 = object instanceof JSONArray;
        if (n11 == 0 || (n11 = object2 instanceof JSONArray) == 0) return object.equals(object2);
        object = (JSONArray)object;
        object2 = (JSONArray)object2;
        n11 = object.length();
        if (n11 != (n10 = object2.length())) {
            return false;
        }
        Object var5_7 = null;
        for (n11 = 0; n11 < (n10 = object.length()); ++n11) {
            Object object5;
            try {
                object5 = object.get(n11);
            }
            catch (JSONException jSONException) {
                return false;
            }
            Object object6 = object2.get(n11);
            n10 = (int)(JsonUtils.areJsonValuesEquivalent(object5, object6) ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return bl2;
        catch (JSONException jSONException) {
            return false;
        }
    }

    public static String escapeString(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            int n10;
            Matcher matcher = zzb.matcher(string2);
            StringBuffer stringBuffer = null;
            block5: while ((n10 = matcher.find()) != 0) {
                int n11;
                String string3;
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer();
                }
                if ((n10 = (string3 = matcher.group()).charAt(0)) != (n11 = 12)) {
                    n11 = 13;
                    if (n10 != n11) {
                        n11 = 34;
                        if (n10 != n11) {
                            n11 = 47;
                            if (n10 != n11) {
                                n11 = 92;
                                if (n10 != n11) {
                                    switch (n10) {
                                        default: {
                                            continue block5;
                                        }
                                        case 10: {
                                            string3 = "\\\\n";
                                            matcher.appendReplacement(stringBuffer, string3);
                                            continue block5;
                                        }
                                        case 9: {
                                            string3 = "\\\\t";
                                            matcher.appendReplacement(stringBuffer, string3);
                                            continue block5;
                                        }
                                        case 8: 
                                    }
                                    string3 = "\\\\b";
                                    matcher.appendReplacement(stringBuffer, string3);
                                    continue;
                                }
                                string3 = "\\\\\\\\";
                                matcher.appendReplacement(stringBuffer, string3);
                                continue;
                            }
                            string3 = "\\\\/";
                            matcher.appendReplacement(stringBuffer, string3);
                            continue;
                        }
                        string3 = "\\\\\\\"";
                        matcher.appendReplacement(stringBuffer, string3);
                        continue;
                    }
                    string3 = "\\\\r";
                    matcher.appendReplacement(stringBuffer, string3);
                    continue;
                }
                string3 = "\\\\f";
                matcher.appendReplacement(stringBuffer, string3);
            }
            if (stringBuffer == null) {
                return string2;
            }
            matcher.appendTail(stringBuffer);
            string2 = stringBuffer.toString();
        }
        return string2;
    }

    public static String unescapeString(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            int n10;
            object = zzd.zza((String)object);
            Matcher matcher = zza.matcher((CharSequence)object);
            StringBuffer stringBuffer = null;
            while ((n10 = matcher.find()) != 0) {
                int n11;
                String string2;
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer();
                }
                if ((n10 = (string2 = matcher.group()).charAt(1)) != (n11 = 34)) {
                    n11 = 47;
                    if (n10 != n11) {
                        n11 = 92;
                        if (n10 != n11) {
                            n11 = 98;
                            if (n10 != n11) {
                                n11 = 102;
                                if (n10 != n11) {
                                    n11 = 110;
                                    if (n10 != n11) {
                                        n11 = 114;
                                        if (n10 != n11) {
                                            n11 = 116;
                                            if (n10 == n11) {
                                                string2 = "\t";
                                                matcher.appendReplacement(stringBuffer, string2);
                                                continue;
                                            }
                                            object = new IllegalStateException("Found an escaped character that should never be.");
                                            throw object;
                                        }
                                        string2 = "\r";
                                        matcher.appendReplacement(stringBuffer, string2);
                                        continue;
                                    }
                                    string2 = "\n";
                                    matcher.appendReplacement(stringBuffer, string2);
                                    continue;
                                }
                                string2 = "\f";
                                matcher.appendReplacement(stringBuffer, string2);
                                continue;
                            }
                            string2 = "\b";
                            matcher.appendReplacement(stringBuffer, string2);
                            continue;
                        }
                        string2 = "\\\\";
                        matcher.appendReplacement(stringBuffer, string2);
                        continue;
                    }
                    string2 = "/";
                    matcher.appendReplacement(stringBuffer, string2);
                    continue;
                }
                string2 = "\"";
                matcher.appendReplacement(stringBuffer, string2);
            }
            if (stringBuffer == null) {
                return object;
            }
            matcher.appendTail(stringBuffer);
            object = stringBuffer.toString();
        }
        return object;
    }
}

