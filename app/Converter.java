package app;

import java.util.HashMap;
import java.util.Map;

public class Converter{
	
	private static Map<String, Double> ratios = new HashMap<String, Double>();
	
	static {
		ratios.put("mm", 1.0);
		ratios.put("cm", 10.0);
		ratios.put("dm", 100.0);
		ratios.put("m", 1000.0);
		ratios.put("km", 1000000.0);
		ratios.put("in", 25.4);
		ratios.put("ft", 304.8);
		ratios.put("yd", 914.4);
		ratios.put("mi", 1609344.0);
	}
	
	public static double getAnswer(double value, String valueKey, String key) {
		double ratioFrom = ratios.get(valueKey);
		double ratioTo = ratios.get(key);
		return value * ratioFrom / ratioTo;
	}
}
