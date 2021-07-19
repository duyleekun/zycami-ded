/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.MatrixCursor
 */
package com.baidu.location.e;

import android.database.Cursor;
import android.database.MatrixCursor;
import com.baidu.location.Address;
import com.baidu.location.Address$Builder;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.e.j$a;
import com.baidu.location.f.a;
import com.baidu.location.f.b;
import com.baidu.location.f.h;
import com.baidu.location.h.l;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public final class j {
    private static final String[] a = new String[]{"CoorType", "Time", "LocType", "Longitude", "Latitude", "Radius", "NetworkLocationType", "Country", "CountryCode", "Province", "City", "CityCode", "District", "Street", "StreetNumber", "PoiList", "LocationDescription"};

    public static Cursor a(BDLocation object) {
        int n10;
        int n11;
        int n12;
        String string2;
        String string3;
        String string4;
        String string5;
        Object object2;
        String string6;
        Object object3;
        Cloneable cloneable = Locale.US;
        Object object4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", (Locale)cloneable);
        long l10 = System.currentTimeMillis();
        cloneable = new Date(l10);
        object4 = ((DateFormat)object4).format((Date)cloneable);
        Object[] objectArray = a;
        cloneable = new MatrixCursor((String[])objectArray);
        int n13 = objectArray.length;
        objectArray = new Object[n13];
        int n14 = cloneable.getColumnIndex("CoorType");
        String string7 = "gcj02";
        objectArray[n14] = string7;
        n14 = cloneable.getColumnIndex("Time");
        objectArray[n14] = object4;
        int n15 = cloneable.getColumnIndex("LocType");
        objectArray[n15] = object3 = Integer.valueOf(((BDLocation)object).getLocType());
        n15 = cloneable.getColumnIndex("Longitude");
        objectArray[n15] = object3 = Double.valueOf(((BDLocation)object).getLongitude());
        n15 = cloneable.getColumnIndex("Latitude");
        double d10 = ((BDLocation)object).getLatitude();
        objectArray[n15] = object3 = Double.valueOf(d10);
        n15 = cloneable.getColumnIndex("Radius");
        objectArray[n15] = object3 = Float.valueOf(((BDLocation)object).getRadius());
        n15 = cloneable.getColumnIndex("NetworkLocationType");
        objectArray[n15] = object3 = ((BDLocation)object).getNetworkLocationType();
        object4 = ((BDLocation)object).getAddress();
        n14 = 0;
        object3 = null;
        if (object4 != null) {
            string7 = ((Address)object4).country;
            string6 = ((Address)object4).countryCode;
            object2 = ((Address)object4).province;
            string5 = ((Address)object4).city;
            string4 = ((Address)object4).cityCode;
            string3 = ((Address)object4).district;
            string2 = ((Address)object4).street;
            object4 = ((Address)object4).streetNumber;
        } else {
            n15 = 0;
            object4 = null;
            n12 = 0;
            string7 = null;
            n11 = 0;
            string6 = null;
            n10 = 0;
            object2 = null;
            string5 = null;
            string4 = null;
            string3 = null;
            string2 = null;
        }
        String string8 = "Country";
        int n16 = cloneable.getColumnIndex(string8);
        objectArray[n16] = string7;
        n12 = cloneable.getColumnIndex("CountryCode");
        objectArray[n12] = string6;
        n12 = cloneable.getColumnIndex("Province");
        objectArray[n12] = object2;
        n12 = cloneable.getColumnIndex("City");
        objectArray[n12] = string5;
        n12 = cloneable.getColumnIndex("CityCode");
        objectArray[n12] = string4;
        n12 = cloneable.getColumnIndex("District");
        objectArray[n12] = string3;
        n12 = cloneable.getColumnIndex("Street");
        objectArray[n12] = string2;
        n12 = cloneable.getColumnIndex("StreetNumber");
        objectArray[n12] = object4;
        object4 = ((BDLocation)object).getPoiList();
        string7 = "PoiList";
        if (object4 == null) {
            n15 = cloneable.getColumnIndex(string7);
            objectArray[n15] = null;
        } else {
            object3 = new StringBuffer();
            string6 = null;
            for (n11 = 0; n11 < (n10 = object4.size()); ++n11) {
                object2 = (Poi)object4.get(n11);
                string5 = ((Poi)object2).getId();
                ((StringBuffer)object3).append(string5);
                string5 = ";";
                ((StringBuffer)object3).append(string5);
                string4 = ((Poi)object2).getName();
                ((StringBuffer)object3).append(string4);
                ((StringBuffer)object3).append(string5);
                double d11 = ((Poi)object2).getRank();
                ((StringBuffer)object3).append(d11);
                object2 = ";|";
                ((StringBuffer)object3).append((String)object2);
            }
            n15 = cloneable.getColumnIndex(string7);
            objectArray[n15] = object3 = ((StringBuffer)object3).toString();
        }
        object = ((BDLocation)object).getLocationDescribe();
        n15 = cloneable.getColumnIndex("LocationDescription");
        objectArray[n15] = object;
        cloneable.addRow(objectArray);
        return cloneable;
    }

    public static BDLocation a(Cursor cursor) {
        BDLocation bDLocation;
        block55: {
            block53: {
                double d10;
                int n10;
                ArrayList<Object> arrayList;
                double d11;
                String[] stringArray;
                Object object;
                Object object2;
                int n11;
                String string2;
                String[] stringArray2;
                double d12;
                String string3;
                int n12;
                int n13;
                float f10;
                Cursor cursor2;
                block52: {
                    int n14;
                    block54: {
                        int n15;
                        block49: {
                            int n16;
                            Object object3;
                            int n17;
                            cursor2 = cursor;
                            bDLocation = new BDLocation();
                            if (cursor == null || (n17 = cursor.getCount()) <= 0 || (n17 = (int)(cursor.moveToFirst() ? 1 : 0)) == 0) break block53;
                            n17 = 0;
                            f10 = 0.0f;
                            String string4 = "LocType";
                            int n18 = cursor.getColumnIndex(string4);
                            if (n18 != (n13 = -1)) {
                                n12 = cursor.getColumnIndex(string4);
                                n12 = cursor.getInt(n12);
                            } else {
                                n12 = 0;
                                string4 = null;
                            }
                            string3 = "Latitude";
                            n15 = cursor2.getColumnIndex(string3);
                            double d13 = 0.0;
                            if (n15 != n13) {
                                n18 = cursor2.getColumnIndex(string3);
                                d12 = cursor2.getDouble(n18);
                            } else {
                                d12 = d13;
                            }
                            string3 = "Longitude";
                            n15 = cursor2.getColumnIndex(string3);
                            if (n15 != n13) {
                                n18 = cursor2.getColumnIndex(string3);
                                d13 = cursor2.getDouble(n18);
                            }
                            if ((n15 = cursor2.getColumnIndex(string3 = "CoorType")) != n13) {
                                n18 = cursor2.getColumnIndex(string3);
                                string3 = cursor2.getString(n18);
                            } else {
                                n18 = 0;
                                string3 = null;
                            }
                            stringArray2 = "NetworkLocationType";
                            int n19 = cursor2.getColumnIndex((String)stringArray2);
                            if (n19 != n13) {
                                n15 = cursor2.getColumnIndex((String)stringArray2);
                                stringArray2 = cursor2.getString(n15);
                            } else {
                                n15 = 0;
                                stringArray2 = null;
                            }
                            string2 = "Radius";
                            int n20 = cursor2.getColumnIndex(string2);
                            if (n20 != n13) {
                                n17 = cursor2.getColumnIndex(string2);
                                f10 = cursor2.getFloat(n17);
                            }
                            if ((n20 = cursor2.getColumnIndex(string2 = "Time")) != n13) {
                                n19 = cursor2.getColumnIndex(string2);
                                string2 = cursor2.getString(n19);
                            } else {
                                n19 = 0;
                                string2 = null;
                            }
                            Object object4 = "Country";
                            int n21 = cursor2.getColumnIndex((String)object4);
                            if (n21 != n13) {
                                n20 = cursor2.getColumnIndex((String)object4);
                                object4 = cursor2.getString(n20);
                            } else {
                                n20 = 0;
                                object4 = null;
                            }
                            Object object5 = "CountryCode";
                            n11 = cursor2.getColumnIndex((String)object5);
                            if (n11 != n13) {
                                n11 = cursor2.getColumnIndex((String)object5);
                                object2 = cursor2.getString(n11);
                            } else {
                                n11 = 0;
                                object2 = null;
                            }
                            object5 = "Province";
                            int n22 = cursor2.getColumnIndex((String)object5);
                            if (n22 != n13) {
                                n22 = cursor2.getColumnIndex((String)object5);
                                object = cursor2.getString(n22);
                            } else {
                                n22 = 0;
                                object = null;
                            }
                            object5 = "City";
                            stringArray = stringArray2;
                            n15 = cursor2.getColumnIndex((String)object5);
                            if (n15 != n13) {
                                n15 = cursor2.getColumnIndex((String)object5);
                                stringArray2 = cursor2.getString(n15);
                            } else {
                                n15 = 0;
                                stringArray2 = null;
                            }
                            object5 = "CityCode";
                            d11 = d13;
                            n14 = cursor2.getColumnIndex((String)object5);
                            if (n14 != n13) {
                                n14 = cursor2.getColumnIndex((String)object5);
                                arrayList = cursor2.getString(n14);
                            } else {
                                n14 = 0;
                                arrayList = null;
                            }
                            String string5 = "District";
                            n21 = cursor2.getColumnIndex(string5);
                            if (n21 != n13) {
                                n10 = cursor2.getColumnIndex(string5);
                                string5 = cursor2.getString(n10);
                            } else {
                                n10 = 0;
                                string5 = null;
                            }
                            object5 = "Street";
                            d10 = d12;
                            int n23 = cursor2.getColumnIndex((String)object5);
                            if (n23 != n13) {
                                n23 = cursor2.getColumnIndex((String)object5);
                                object3 = cursor2.getString(n23);
                            } else {
                                n23 = 0;
                                object3 = null;
                            }
                            Object object6 = "StreetNumber";
                            n21 = cursor2.getColumnIndex((String)object6);
                            if (n21 != n13) {
                                n16 = cursor2.getColumnIndex((String)object6);
                                object6 = cursor2.getString(n16);
                            } else {
                                n16 = 0;
                                object6 = null;
                            }
                            object5 = new Address$Builder();
                            object4 = ((Address$Builder)object5).country((String)object4);
                            object2 = ((Address$Builder)object4).countryCode((String)object2);
                            object = ((Address$Builder)object2).province((String)object).city((String)stringArray2).cityCode((String)((Object)arrayList)).district(string5).street((String)object3).streetNumber((String)object6).build();
                            stringArray2 = "PoiList";
                            n14 = cursor2.getColumnIndex((String)stringArray2);
                            if (n14 == n13) break block54;
                            arrayList = new ArrayList<Object>();
                            n15 = cursor2.getColumnIndex((String)stringArray2);
                            if ((stringArray2 = cursor2.getString(n15)) == null) break block49;
                            string5 = "\\|";
                            try {
                                stringArray2 = stringArray2.split(string5);
                                n10 = 0;
                                string5 = null;
                            }
                            catch (Throwable throwable) {
                                arrayList.size();
                                throw throwable;
                            }
                            catch (Exception exception) {
                                n15 = arrayList.size();
                                if (n15 != 0) break block52;
                            }
                            while (true) {
                                block51: {
                                    block50: {
                                        n23 = stringArray2.length;
                                        if (n10 >= n23) break block49;
                                        object3 = stringArray2[n10];
                                        object6 = ";";
                                        object3 = ((String)object3).split((String)object6);
                                        n16 = ((String[])object3).length;
                                        n11 = 3;
                                        if (n16 < n11) break block50;
                                        n11 = 0;
                                        object2 = null;
                                        String string6 = object3[0];
                                        n20 = 1;
                                        String string7 = object3[n20];
                                        n20 = 2;
                                        object3 = object3[n20];
                                        object3 = Double.valueOf((String)object3);
                                        double d14 = (Double)object3;
                                        String string8 = "";
                                        String string9 = "";
                                        object6 = new Poi(string6, string7, d14, string8, string9);
                                        arrayList.add(object6);
                                        break block51;
                                    }
                                    n11 = 0;
                                    object2 = null;
                                }
                                ++n10;
                            }
                            break block54;
                        }
                        if ((n15 = arrayList.size()) != 0) break block52;
                    }
                    n14 = 0;
                    arrayList = null;
                }
                if ((n10 = cursor2.getColumnIndex((String)(stringArray2 = "LocationDescription"))) != n13) {
                    n13 = cursor2.getColumnIndex((String)stringArray2);
                    object2 = cursor2.getString(n13);
                } else {
                    n11 = 0;
                    object2 = null;
                }
                bDLocation.setTime(string2);
                bDLocation.setRadius(f10);
                bDLocation.setLocType(n12);
                bDLocation.setCoorType(string3);
                d12 = d10;
                bDLocation.setLatitude(d10);
                bDLocation.setLongitude(d11);
                stringArray2 = stringArray;
                bDLocation.setNetworkLocationType((String)stringArray);
                bDLocation.setAddr((Address)object);
                bDLocation.setPoiList(arrayList);
                bDLocation.setLocationDescribe((String)object2);
                break block55;
            }
            int n24 = 67;
            bDLocation.setLocType(n24);
        }
        return bDLocation;
    }

    public static String a(BDLocation object, int n10) {
        Object object2;
        int n11;
        int n12;
        Object object3 = "1";
        int n13 = 1;
        int n14 = 2;
        float f10 = 2.8E-45f;
        if (object != null && (n12 = ((BDLocation)object).getLocType()) != (n11 = 67)) {
            Object[] objectArray = Locale.CHINA;
            n11 = 5;
            Object object4 = new Object[n11];
            object4[0] = object3;
            object4[n13] = object2 = Integer.valueOf(n10);
            object4[n14] = object2 = Double.valueOf(((BDLocation)object).getLongitude());
            double d10 = ((BDLocation)object).getLatitude();
            object3 = d10;
            object4[3] = object3;
            n10 = 4;
            float f11 = ((BDLocation)object).getRadius();
            int n15 = (int)f11;
            object3 = n15;
            object4[n10] = object3;
            object2 = String.format((Locale)objectArray, "&ofl=%s|%d|%f|%f|%d", object4);
            object3 = ((BDLocation)object).getAddress();
            if (object3 != null) {
                object3 = new StringBuilder();
                object3.append((String)object2);
                object3.append("&ofaddr=");
                object2 = object.getAddress().address;
                object3.append((String)object2);
                object2 = object3.toString();
            }
            if ((object3 = ((BDLocation)object).getPoiList()) != null && (n15 = (object3 = ((BDLocation)object).getPoiList()).size()) > 0) {
                object = (Poi)((BDLocation)object).getPoiList().get(0);
                object3 = new StringBuilder();
                object3.append((String)object2);
                object2 = Locale.US;
                objectArray = new Object[n14];
                objectArray[0] = object4 = ((Poi)object).getId();
                objectArray[n13] = object = ((Poi)object).getName();
                object = String.format((Locale)object2, "&ofpoi=%s|%s", objectArray);
                object3.append((String)object);
                object2 = object3.toString();
            }
            if ((object = com.baidu.location.h.b.e) != null) {
                Object object5;
                object = new StringBuilder();
                ((StringBuilder)object).append((String)object2);
                object2 = Locale.US;
                object3 = new Object[n14];
                object3[0] = object5 = com.baidu.location.h.b.e;
                n14 = 1090938470;
                f10 = 8.4f;
                object3[n13] = object5 = Float.valueOf(f10);
                String string2 = "&pack=%s&sdk=%.3f";
                object2 = String.format((Locale)object2, string2, object3);
                ((StringBuilder)object).append((String)object2);
                object2 = ((StringBuilder)object).toString();
            }
        } else {
            object = Locale.CHINA;
            Object[] objectArray = new Object[n14];
            objectArray[0] = object3;
            objectArray[n13] = object2 = Integer.valueOf(n10);
            object2 = String.format((Locale)object, "&ofl=%s|%d", objectArray);
        }
        return object2;
    }

    public static String a(BDLocation object, BDLocation objectArray, j$a object2) {
        int n10;
        Serializable serializable;
        StringBuffer stringBuffer = new StringBuffer();
        int n11 = 2;
        int n12 = 3;
        int n13 = 1;
        if (objectArray == null) {
            objectArray = "&ofcl=0";
        } else {
            serializable = Locale.US;
            Object[] objectArray2 = new Object[n12];
            Double d10 = objectArray.getLongitude();
            objectArray2[0] = d10;
            double d11 = objectArray.getLatitude();
            d10 = d11;
            objectArray2[n13] = d10;
            float f10 = objectArray.getRadius();
            int n14 = (int)f10;
            objectArray = n14;
            objectArray2[n11] = objectArray;
            objectArray = String.format(serializable, "&ofcl=1|%f|%f|%d", objectArray2);
        }
        stringBuffer.append((String)objectArray);
        if (object == null) {
            object = "&ofwf=0";
        } else {
            objectArray = Locale.US;
            Object[] objectArray3 = new Object[n12];
            serializable = Double.valueOf(((BDLocation)object).getLongitude());
            objectArray3[0] = serializable;
            double d12 = ((BDLocation)object).getLatitude();
            serializable = Double.valueOf(d12);
            objectArray3[n13] = serializable;
            float f11 = ((BDLocation)object).getRadius();
            n10 = (int)f11;
            objectArray3[n11] = object = Integer.valueOf(n10);
            object = String.format((Locale)objectArray, "&ofwf=1|%f|%f|%d", objectArray3);
        }
        stringBuffer.append((String)object);
        object = object2 != null && (n10 = ((j$a)object2).e) != 0 ? "&rgcn=1" : "&rgcn=0";
        stringBuffer.append((String)object);
        object = object2 != null && (n10 = ((j$a)object2).d) != 0 ? "&poin=1" : "&poin=0";
        stringBuffer.append((String)object);
        object = object2 != null && (n10 = ((j$a)object2).h) != 0 ? "&desc=1" : "&desc=0";
        stringBuffer.append((String)object);
        if (object2 != null) {
            object = Locale.US;
            objectArray = new Object[n13];
            int n15 = ((j$a)object2).f;
            objectArray[0] = object2 = Integer.valueOf(n15);
            object2 = "&aps=%d";
            object = String.format((Locale)object, (String)object2, objectArray);
            stringBuffer.append((String)object);
        }
        return stringBuffer.toString();
    }

    public static String[] a(a object, h object2, BDLocation object3, String string2, boolean bl2, int n10) {
        int n11;
        int n12;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Comparable<StringBuffer> comparable = new StringBuffer();
        if (object != null) {
            b b10 = b.a();
            object = b10.b((a)object);
            comparable.append((String)object);
        }
        if (object2 != null) {
            n12 = 30;
            object = object2.a(n12);
            comparable.append((String)object);
        }
        if ((n12 = comparable.length()) > 0) {
            if (string2 != null) {
                comparable.append(string2);
            }
            arrayList.add("-loc");
            object = comparable.toString();
            arrayList.add(object);
        }
        if (object3 != null) {
            object = Locale.US;
            n11 = 4;
            object2 = new Object[n11];
            string2 = null;
            comparable = ((BDLocation)object3).getLatitude();
            object2[0] = comparable;
            double d10 = ((BDLocation)object3).getLongitude();
            comparable = d10;
            object2[1] = comparable;
            int n13 = ((BDLocation)object3).getLocType();
            comparable = n13;
            object2[2] = comparable;
            int n14 = 3;
            object2[n14] = object3 = ((BDLocation)object3).getNetworkLocationType();
            object3 = "%f;%f;%d;%s";
            object = String.format((Locale)object, (String)object3, object2);
            object2 = "-com";
            arrayList.add(object2);
            arrayList.add(object);
        }
        object = "true";
        if (bl2) {
            object2 = "-log";
            arrayList.add(object2);
            arrayList.add(object);
        }
        if ((n11 = (int)((object2 = l.g).equals(object3 = "all") ? 1 : 0)) != 0) {
            object2 = "-rgc";
            arrayList.add(object2);
            arrayList.add(object);
        }
        if ((n11 = (int)(l.j ? 1 : 0)) != 0) {
            object2 = "-poi";
            arrayList.add(object2);
            arrayList.add(object);
        }
        if ((n11 = (int)(l.h ? 1 : 0)) != 0) {
            object2 = "-des";
            arrayList.add(object2);
            arrayList.add(object);
        }
        arrayList.add("-minap");
        object = Integer.toString(n10);
        arrayList.add(object);
        object = new String[arrayList.size()];
        arrayList.toArray((T[])object);
        return object;
    }
}

