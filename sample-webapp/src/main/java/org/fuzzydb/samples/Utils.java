package org.fuzzydb.samples;

import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.util.Assert;

import com.wwm.db.query.Result;
import com.wwm.model.attributes.Score;

public abstract class Utils {

	/**
	 * Returns a string of the form rgb(100,200,0) to be used
	 * to indicate the percentage.  100% is green, 0% is red.
	 * HSV model:
	 *   Hue 0 -> 120 (red -> green)
	 *   Sat -> fixed @ 85
	 *   Brightness -> fixed @ 90
	 *   
	 *   @param value 0 - 1.0f
	 */
	public static String toCssRGBColor(float value) {
	    int intVal = Math.round(value * 100);
	    Color color = new Color(Color.HSBtoRGB(intVal * 1.2f / 360f, 0.85f, 0.90f));
	    return "rgb(" + color.getRed() + "," + color.getGreen() + ","+ color.getBlue() +")";
	}

	/**
	 * Returns a string of the form rgb(100,200,0) to be used
	 * to indicate the percentage.  100% is green, 0% is red.
	 * HSV model:
	 *   Hue 0 -> 120 (red -> green)
	 *   Sat -> fixed @ 85
	 *   Brightness -> fixed @ 90
	 *   
	 *   @param value 0 - 1.0f
	 */
	public static String toCssRGBColor(Score score) {
		return toCssRGBColor(score.total());
	}
	
	public static int toPercent(Score score) {
		return Math.round(score.total() * 100f);
	}
		
	public static <T> List<T> toList(Iterator<T> items) {
		Assert.notNull(items);
		
		List<T> list = new LinkedList<T>();
		for (Iterator<T> iterator = items; iterator.hasNext();) {
			T item = iterator.next();
			list.add(item);
		}
		return list;
	}

	
	public static <T> float forwardsScore(Result<T> result, String matcher) {
		return result.getScore().getForwardsScore(matcher);
	}

	public static <T> float reverseScore(Result<T> result, String matcher) {
		return result.getScore().getReverseScore(matcher);
	}
	
	/**
	 * A little help for things like Arrays
	 * @param object
	 * @return formatted string representation
	 */
	public static String toString(Object object) {
		if (object instanceof Object[]) {
			Object[] array = (Object[]) object;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < array.length; i++) {
				sb.append(array[i].toString());
				if (i < array.length - 1) {
					sb.append(", ");
				}
			}
			return sb.toString();
		} 
		else if (object instanceof float[]) {
			float[] array = (float[]) object;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < array.length; i++) {
				sb.append(array[i]);
				if (i < array.length - 1) {
					sb.append(", ");
				}
			}
			return sb.toString();
		}

		return object.toString();
	}
}