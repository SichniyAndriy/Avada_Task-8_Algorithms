package ch_06;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ConverterToJson {
    public static String prettyConvertToJson(Object object) throws IllegalAccessException {
        if (object == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder("{");
        objectToJson(stringBuilder, object, 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.append("\n}").toString();
    }

    private static void objectToJson(StringBuilder stringBuilder, Object object, int offset)
            throws IllegalAccessException
    {
        List<Field> allFields = new ArrayList<>(Arrays.asList(object.getClass().getDeclaredFields()));
        Class<?> superclass = object.getClass().getSuperclass();
        if (superclass != null) {
            allFields.addAll(Arrays.asList(superclass.getDeclaredFields()));
        }
        for (Field field: allFields) {
            String name = field.getName();
            stringBuilder.append("\n").append("\t".repeat(offset)).append("\"").append(name).append("\"").append(" : ");

            field.setAccessible(true);
            Object value = field.get(object);
            Class<?> type = field.getType();

            if (type.isArray()) {
                arrayToJson(stringBuilder, value, offset + 1);
            } else if (value instanceof Collection<?>) {
                arrayToJson(stringBuilder, ((Collection<?>) value).toArray(), offset + 1);
            } else if (value instanceof Map<?, ?>) {
                stringBuilder.append("{\n");
                for (var el: ((Map<?, ?>) value).entrySet()) {
                    stringBuilder.append("\t".repeat(offset + 1));
                    valueToJson(stringBuilder, el.getKey(),offset + 1);
                    stringBuilder.append(" : ");
                    valueToJson(stringBuilder, el.getValue(),offset + 1);
                    stringBuilder.append(",\n");
                }
                stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
                stringBuilder.append("\n").append("\t".repeat(offset)).append("}");
            } else {
                valueToJson(stringBuilder, value, offset);
            }
            stringBuilder.append(",");
        }
    }

    private static void arrayToJson(StringBuilder stringBuilder, Object array, int offset)
            throws IllegalAccessException {
        int len = Array.getLength(array);
        stringBuilder.append("[ ");
        for (int i = 0; i < len; ++i) {
            valueToJson(stringBuilder,Array.get(array, i), offset + 1);
            stringBuilder.append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(" ]");
    }

    private static void valueToJson(StringBuilder stringBuilder, Object value, int offset)
            throws IllegalAccessException {
        if (value == null ||
            value.getClass().isPrimitive() ||
            value instanceof Number ||
            value instanceof Boolean) {
            stringBuilder.append(value);
        } else if (value instanceof CharSequence) {
            stringBuilder.append("\"").append(value).append("\"");
        } else {
            stringBuilder.append("{");
            objectToJson(stringBuilder, value, offset + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append("\n").append("\t".repeat(offset)).append("}");
        }
    }
}
