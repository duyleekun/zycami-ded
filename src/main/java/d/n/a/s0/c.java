/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.s0;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class c {
    private static final Map a;
    private static final Map b;
    private static final Map c;

    static {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("1811", "Alert Notification Service");
        hashMap.put("180F", "Battery Service");
        hashMap.put("1810", "Blood Pressure");
        hashMap.put("181B", "Body Composition");
        hashMap.put("181E", "Bond Management");
        hashMap.put("181F", "Continuous Glucose Monitoring");
        hashMap.put("1805", "Current Time Service");
        hashMap.put("1818", "Cycling Power");
        hashMap.put("1816", "Cycling Speed and Cadence");
        hashMap.put("180A", "Device Information");
        hashMap.put("181A", "Environmental Sensing");
        hashMap.put("1800", "Generic Access");
        hashMap.put("1801", "Generic Attribute");
        hashMap.put("1808", "Glucose");
        hashMap.put("1809", "Health Thermometer");
        hashMap.put("180D", "Heart Rate");
        hashMap.put("1812", "Human Interface Device");
        String string2 = "1802";
        hashMap.put(string2, "Immediate Alert");
        hashMap.put("1803", "Link Loss");
        hashMap.put("1819", "Location and Navigation");
        hashMap.put("1820", "Internet Protocol Support");
        hashMap.put("1807", "Next DST Change Service");
        hashMap.put("180E", "Phone Alert Status Service");
        hashMap.put("1806", "Reference Time Update Service");
        hashMap.put("1814", "Running Speed and Cadence");
        hashMap.put("1813", "Scan Parameters");
        hashMap.put("1804", "Tx Power");
        hashMap.put("181C", "User Data");
        hashMap.put("181D", "Weight Scale");
        hashMap.put("1815", "Automation IO");
        hashMap.put(string2, "Immediate Alert Service 1.1");
        a = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap<String, String>();
        hashMap.put("2A7E", "Aerobic Heart Rate Lower Limit");
        hashMap.put("2A84", "Aerobic Heart Rate Upper Limit");
        hashMap.put("2A7F", "Aerobic Threshold");
        hashMap.put("2A80", "Age");
        hashMap.put("2A43", "Alert Category ID");
        hashMap.put("2A42", "Alert Category ID Bit Mask");
        hashMap.put("2A06", "Alert Level");
        hashMap.put("2A44", "Alert Notification Control Point");
        hashMap.put("2A3F", "Alert Status");
        hashMap.put("2A81", "Anaerobic Heart Rate Lower Limit");
        hashMap.put("2A82", "Anaerobic Heart Rate Upper Limit");
        hashMap.put("2A83", "Anaerobic Threshold");
        hashMap.put("2A73", "Apparent Wind Direction");
        hashMap.put("2A72", "Apparent Wind Speed");
        hashMap.put("2A01", "Appearance");
        hashMap.put("2AA3", "Barometric Pressure Trend");
        hashMap.put("2A19", "Battery Level");
        hashMap.put("2A49", "Blood Pressure Feature");
        hashMap.put("2A35", "Blood Pressure Measurement");
        hashMap.put("2A9B", "Body Composition Feature");
        hashMap.put("2A9C", "Body Composition Measurement");
        hashMap.put("2A38", "Body Sensor Location");
        hashMap.put("2AA4", "Bond Management Control Point");
        hashMap.put("2AA5", "Bond Management Feature");
        hashMap.put("2A22", "Boot Keyboard Input Report");
        hashMap.put("2A32", "Boot Keyboard Output Report");
        hashMap.put("2A33", "Boot Mouse Input Report");
        hashMap.put("2AA6", "Central Address Resolution");
        hashMap.put("2AA8", "CGM Feature");
        hashMap.put("2AA7", "CGM Measurement");
        hashMap.put("2AAB", "CGM Session Run Time");
        hashMap.put("2AAA", "CGM Session Start Time");
        hashMap.put("2AAC", "CGM Specific Ops Control Point");
        hashMap.put("2AA9", "CGM Status");
        hashMap.put("2A5C", "CSC Feature");
        hashMap.put("2A5B", "CSC Measurement");
        hashMap.put("2A2B", "Current Time");
        hashMap.put("2A66", "Cycling Power Control Point");
        hashMap.put("2A65", "Cycling Power Feature");
        hashMap.put("2A63", "Cycling Power Measurement");
        hashMap.put("2A64", "Cycling Power Vector");
        hashMap.put("2A99", "Database Change Increment");
        hashMap.put("2A85", "Date of Birth");
        hashMap.put("2A86", "Date of Threshold Assessment ");
        hashMap.put("2A08", "Date Time");
        hashMap.put("2A0A", "Day Date Time");
        hashMap.put("2A09", "Day of Week");
        hashMap.put("2A7D", "Descriptor Value Changed");
        hashMap.put("2A00", "Device Name");
        hashMap.put("2A7B", "Dew Point");
        hashMap.put("2A0D", "DST Offset");
        hashMap.put("2A6C", "Elevation");
        hashMap.put("2A87", "Email Address");
        hashMap.put("2A0C", "Exact Time 256");
        hashMap.put("2A88", "Fat Burn Heart Rate Lower Limit");
        hashMap.put("2A89", "Fat Burn Heart Rate Upper Limit");
        hashMap.put("2A26", "Firmware Revision String");
        hashMap.put("2A8A", "First Name");
        hashMap.put("2A8B", "Five Zone Heart Rate Limits");
        hashMap.put("2A8C", "Gender");
        hashMap.put("2A51", "Glucose Feature");
        hashMap.put("2A18", "Glucose Measurement");
        hashMap.put("2A34", "Glucose Measurement Context");
        hashMap.put("2A74", "Gust Factor");
        hashMap.put("2A27", "Hardware Revision String");
        hashMap.put("2A39", "Heart Rate Control Point");
        hashMap.put("2A8D", "Heart Rate Max");
        hashMap.put("2A37", "Heart Rate Measurement");
        hashMap.put("2A7A", "Heat Index");
        hashMap.put("2A8E", "Height");
        hashMap.put("2A4C", "HID Control Point");
        hashMap.put("2A4A", "HID Information");
        hashMap.put("2A8F", "Hip Circumference");
        hashMap.put("2A6F", "Humidity");
        hashMap.put("2A2A", "IEEE 11073-20601 Regulatory Certification Data List");
        hashMap.put("2A36", "Intermediate Cuff Pressure");
        hashMap.put("2A1E", "Intermediate Temperature");
        hashMap.put("2A77", "Irradiance");
        hashMap.put("2AA2", "Language");
        hashMap.put("2A90", "Last Name");
        hashMap.put("2A6B", "LN Control Point");
        hashMap.put("2A6A", "LN Feature");
        hashMap.put("2A0F", "Local Time Information");
        hashMap.put("2A67", "Location and Speed");
        hashMap.put("2A2C", "Magnetic Declination");
        hashMap.put("2AA0", "Magnetic Flux Density - 2D");
        hashMap.put("2AA1", "Magnetic Flux Density - 3D");
        hashMap.put("2A29", "Manufacturer Name String");
        hashMap.put("2A91", "Maximum Recommended Heart Rate");
        hashMap.put("2A21", "Measurement Interval");
        hashMap.put("2A24", "Model Number String");
        hashMap.put("2A68", "Navigation");
        hashMap.put("2A46", "New Alert");
        hashMap.put("2A04", "Peripheral Preferred Connection Parameters");
        hashMap.put("2A02", "Peripheral Privacy Flag");
        hashMap.put("2A50", "PnP ID");
        hashMap.put("2A75", "Pollen Concentration");
        hashMap.put("2A69", "Position Quality");
        hashMap.put("2A6D", "Pressure");
        hashMap.put("2A4E", "Protocol Mode");
        hashMap.put("2A78", "Rainfall");
        hashMap.put("2A03", "Reconnection Address");
        hashMap.put("2A52", "Record Access Control Point");
        hashMap.put("2A14", "Reference Time Information");
        hashMap.put("2A4D", "Report");
        hashMap.put("2A4B", "Report Map");
        hashMap.put("2A92", "Resting Heart Rate");
        hashMap.put("2A40", "Ringer Control Point");
        hashMap.put("2A41", "Ringer Setting");
        hashMap.put("2A54", "RSC Feature");
        hashMap.put("2A53", "RSC Measurement");
        hashMap.put("2A55", "SC Control Point");
        hashMap.put("2A4F", "Scan Interval Window");
        hashMap.put("2A31", "Scan Refresh");
        hashMap.put("2A5D", "Sensor Location");
        hashMap.put("2A25", "Serial Number String");
        hashMap.put("2A05", "Service Changed");
        hashMap.put("2A28", "Software Revision String");
        hashMap.put("2A93", "Sport Type for Aerobic and Anaerobic Thresholds");
        hashMap.put("2A47", "Supported New Alert Category");
        hashMap.put("2A48", "Supported Unread Alert Category");
        hashMap.put("2A23", "System ID");
        hashMap.put("2A6E", "Temperature");
        hashMap.put("2A1C", "Temperature Measurement");
        hashMap.put("2A1D", "Temperature Type");
        hashMap.put("2A94", "Three Zone Heart Rate Limits");
        hashMap.put("2A12", "Time Accuracy");
        hashMap.put("2A13", "Time Source");
        hashMap.put("2A16", "Time Update Control Point");
        hashMap.put("2A17", "Time Update State");
        hashMap.put("2A11", "Time with DST");
        hashMap.put("2A0E", "Time Zone");
        hashMap.put("2A71", "True Wind Direction");
        hashMap.put("2A70", "True Wind Speed");
        hashMap.put("2A95", "Two Zone Heart Rate Limit");
        hashMap.put("2A07", "Tx Power Level");
        hashMap.put("2A45", "Unread Alert Status");
        hashMap.put("2A9F", "User Control Point");
        hashMap.put("2A9A", "User Index");
        hashMap.put("2A76", "UV Index");
        hashMap.put("2A96", "VO2 Max");
        hashMap.put("2A97", "Waist Circumference");
        hashMap.put("2A98", "Weight");
        hashMap.put("2A9D", "Weight Measurement");
        hashMap.put("2A9E", "Weight Scale Feature");
        hashMap.put("2A79", "Wind Chill");
        hashMap.put("2A5A", "Aggregate");
        hashMap.put("2A58", "Analog");
        hashMap.put("2A56", "Digital");
        b = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap<String, String>();
        hashMap.put("2900", "Characteristic Extended Properties");
        hashMap.put("2901", "Characteristic User Description");
        hashMap.put("2902", "Client Characteristic Configuration");
        hashMap.put("2903", "Server Characteristic Configuration");
        hashMap.put("2904", "Characteristic Presentation Format");
        hashMap.put("2905", "Characteristic Aggregate Format");
        hashMap.put("2906", "Valid Range");
        hashMap.put("2907", "External Report Reference");
        hashMap.put("2908", "Report Reference");
        hashMap.put("290B", "Environmental Sensing Configuration");
        hashMap.put("290C", "Environmental Sensing Measurement");
        hashMap.put("290D", "Environmental Sensing Trigger Setting");
        hashMap.put("2909", "Number of Digitals");
        hashMap.put("290A", "Value Trigger Setting");
        hashMap.put("290E", "Time Trigger Setting");
        c = Collections.unmodifiableMap(hashMap);
    }

    private c() {
    }

    public static String a(UUID object) {
        if ((object = d.n.a.s0.c.d((UUID)object)) != null) {
            Map map = b;
            object = (String)map.get(object);
        } else {
            object = null;
        }
        return object;
    }

    public static String b(UUID object) {
        if ((object = d.n.a.s0.c.d((UUID)object)) != null) {
            Map map = c;
            object = (String)map.get(object);
        } else {
            object = null;
        }
        return object;
    }

    public static String c(UUID object) {
        if ((object = d.n.a.s0.c.d((UUID)object)) != null) {
            Map map = a;
            object = (String)map.get(object);
        } else {
            object = null;
        }
        return object;
    }

    private static String d(UUID object) {
        int n10 = d.n.a.s0.c.e((String)(object = ((UUID)object).toString().toUpperCase()));
        if (n10 != 0) {
            n10 = 4;
            int n11 = 8;
            object = ((String)object).substring(n10, n11);
        } else {
            object = null;
        }
        return object;
    }

    private static boolean e(String string2) {
        boolean bl2;
        String string3 = "0000";
        boolean bl3 = string2.startsWith(string3);
        if (bl3 && (bl2 = string2.endsWith(string3 = "-0000-1000-8000-00805F9B34FB"))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }
}

