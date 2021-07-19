/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.XmlResourceParser
 *  android.util.Log
 *  org.xmlpull.v1.XmlPullParserException
 */
package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class DefaultsXmlParser {
    private static final String XML_TAG_ENTRY = "entry";
    private static final String XML_TAG_KEY = "key";
    private static final String XML_TAG_VALUE = "value";

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Map getDefaultsFromXml(Context object, int n10) {
        void var0_6;
        String string2 = "FirebaseRemoteConfig";
        HashMap<String, String> hashMap = new HashMap<String, String>();
        try {
            int n11;
            int n12;
            Resources resources = object.getResources();
            if (resources == null) {
                String string3 = "Could not find the resources of the current context while trying to set defaults from an XML.";
                Log.e((String)string2, (String)string3);
                return hashMap;
            }
            XmlResourceParser xmlResourceParser = resources.getXml(n12);
            n12 = xmlResourceParser.getEventType();
            String string4 = null;
            String string5 = null;
            String string6 = null;
            while (n12 != (n11 = 1)) {
                int n13 = 2;
                if (n12 == n13) {
                    string4 = xmlResourceParser.getName();
                } else {
                    String string7;
                    n13 = 3;
                    if (n12 == n13) {
                        string7 = xmlResourceParser.getName();
                        n12 = (int)(string7.equals(string4 = XML_TAG_ENTRY) ? 1 : 0);
                        if (n12 != 0) {
                            if (string5 != null && string6 != null) {
                                hashMap.put(string5, string6);
                            } else {
                                string7 = "An entry in the defaults XML has an invalid key and/or value tag.";
                                Log.w((String)string2, (String)string7);
                            }
                            string5 = null;
                            string6 = null;
                        }
                        string4 = null;
                    } else {
                        n13 = 4;
                        if (n12 == n13 && string4 != null) {
                            String string8;
                            int n14;
                            n12 = -1;
                            n13 = string4.hashCode();
                            if (n13 != (n14 = 106079)) {
                                n14 = 111972721;
                                if (n13 == n14 && (n13 = (int)(string4.equals(string8 = XML_TAG_VALUE) ? 1 : 0)) != 0) {
                                    n12 = n11;
                                }
                            } else {
                                string8 = XML_TAG_KEY;
                                n13 = (int)(string4.equals(string8) ? 1 : 0);
                                if (n13 != 0) {
                                    n12 = 0;
                                    string7 = null;
                                }
                            }
                            if (n12 != 0) {
                                if (n12 != n11) {
                                    string7 = "Encountered an unexpected tag while parsing the defaults XML.";
                                    Log.w((String)string2, (String)string7);
                                } else {
                                    string6 = xmlResourceParser.getText();
                                }
                            } else {
                                string5 = xmlResourceParser.getText();
                            }
                        }
                    }
                }
                n12 = xmlResourceParser.next();
            }
            return hashMap;
        }
        catch (IOException iOException) {
        }
        catch (XmlPullParserException xmlPullParserException) {
            // empty catch block
        }
        String string9 = "Encountered an error while parsing the defaults XML file.";
        Log.e((String)string2, (String)string9, (Throwable)var0_6);
        return hashMap;
    }
}

