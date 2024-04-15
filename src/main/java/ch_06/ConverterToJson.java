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
        elementToJson(stringBuilder, object, 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.append("\n}").toString();
    }

    private static void elementToJson(StringBuilder stringBuilder, Object object, int offset)
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
            Class<?> type = field.getType();
            Object o = field.get(object);
            if (o == null) {
                stringBuilder.append("null");
            } else if (type.isPrimitive() || o instanceof Number || o instanceof Boolean) {
                stringBuilder.append(o);
            } else if (o instanceof CharSequence) {
                stringBuilder.append("\"").append(o).append("\"");
            } else if (type.isArray()) {
                stringBuilder.append("[ ");
                arrayToJson(stringBuilder, o, offset);
                stringBuilder.append(" ]");
            } else if (o instanceof Collection<?>) {
                stringBuilder.append("[ ");
                for (var el: (Collection<?>) o) {
                    pickUpAction(stringBuilder, el, offset);
                    stringBuilder.append(",");
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                stringBuilder.append(" ]");
            } else if (o instanceof Map) {
                stringBuilder.append("{ ");
                for (var el: ((Map<?,?>) o).entrySet()) {
                    pickUpAction(stringBuilder, el.getKey(),offset + 1);
                    stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
                    stringBuilder.append(" : ");
                    pickUpAction(stringBuilder, el.getValue(), offset + 1);
                }
                stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
                stringBuilder.append(" }");
            } else {
                stringBuilder.append("{ ");
                elementToJson(stringBuilder,o,offset + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                stringBuilder.append("\n").append("\t".repeat(offset)).append("}");
            }
            stringBuilder.append(",");
        }
    }

    private static void arrayToJson(StringBuilder stringBuilder, Object array, int offset) throws IllegalAccessException {
        int len = Array.getLength(array);
        ;
        for (int i = 0; i < len; ++i) {
            Object el = Array.get(array, i);
            pickUpAction(stringBuilder, el, offset);
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
    }

    private static void pickUpAction(StringBuilder stringBuilder, Object obj, int offset)
            throws IllegalAccessException {
        if (obj == null ||
                obj.getClass().isPrimitive() ||
                obj instanceof Number ||
                obj instanceof Boolean) {
            stringBuilder.append(obj).append(", ");
        } else if (obj instanceof CharSequence) {
            stringBuilder.append("\"").append(obj).append("\"").append(", ");
        } else {
            stringBuilder.append(" {");
            elementToJson(stringBuilder, obj, offset + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append("\n").append("\t".repeat(offset + 1)).append("}");
        }
    }
}
