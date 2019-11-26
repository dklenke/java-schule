package de.hss.uebungen;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MyUtils {
	public String getPrintString(Object myObj) {
		Class <?> klazz = myObj.getClass();
		List<String> attributes = inspect(klazz);
		Map<String, String> map = new HashMap<String, String>();
		for (String attr : attributes) {
			Field f;
			try {
				f = klazz.getDeclaredField(attr);
				f.setAccessible(true);
				map.put(attr, String.valueOf(f.get(myObj)));
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		String output = "";
		output += "--------------------------------\n";
		Iterator<Entry<String, String>> baseAttrIt = map.entrySet().iterator();
		while (baseAttrIt.hasNext()) {
			Map.Entry<String, String> basePair = (Map.Entry<String, String>)baseAttrIt.next();
			output += (basePair.getKey() + " : " + basePair.getValue() + "\n");
		}
		return output;
	}
	
	public String getPrintString(Object myObj, Map<String, String> input) {
		Class <?> klazz = myObj.getClass();
		List<String> attributes = inspect(klazz);
		Map<String, String> map = new HashMap<String, String>();
		for (String attr : attributes) {
			Field f;
			try {
				f = klazz.getDeclaredField(attr);
				f.setAccessible(true);
				map.put(attr, String.valueOf(f.get(myObj)));
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		String output = "";
		output += "--------------------------------\n";
		Iterator<Entry<String, String>> baseAttrIt = map.entrySet().iterator();
		while (baseAttrIt.hasNext()) {
			Map.Entry<String, String> basePair = (Map.Entry<String, String>)baseAttrIt.next();
			output += (basePair.getKey() + " : " + basePair.getValue() + "\n");
		}
		Iterator<Entry<String, String>> funcIt = input.entrySet().iterator();
		while (funcIt.hasNext()) {
			Map.Entry<String, String> funcPair = (Map.Entry<String, String>)funcIt.next();
			output += (funcPair.getKey() + " : " + funcPair.getValue() + "\n");
		}
		output += "--------------------------------\n";
		return output;
	}
	
    <T> List<String> inspect(Class<T> klazz) {
        Field[] fields = klazz.getDeclaredFields();
        List<String> attributes = new ArrayList<String>();  
        for (Field field : fields) {
        	if (Modifier.toString(field.getModifiers()).equals("public")) {
        		attributes.add(field.getName());
        	}
        }
        return attributes;
    }
}
