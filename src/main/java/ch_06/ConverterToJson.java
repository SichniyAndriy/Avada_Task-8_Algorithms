package ch_06;

import java.lang.reflect.Field;

public class ConverterToJson {
    public static String convertToJson(Object object) throws IllegalAccessException {
        StringBuilder stringBuilder = new StringBuilder("{");
        prettyFormatterToJson(stringBuilder, object, 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.append("\n}").toString();
    }

    private static void prettyFormatterToJson(StringBuilder stringBuilder, Object object, int offset) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field: fields) {
            String name = field.getName();
            stringBuilder.append("\n").append("\t".repeat(offset)).append("\"").append(name).append("\"").append(" : ");
            field.setAccessible(true);
            var o = field.get(object);

            if (o instanceof Number) {
                stringBuilder.append(o);
            } else if (o instanceof String) {
                stringBuilder.append("\"").append(o).append("\"");
            } else {
                stringBuilder.append("{");
                prettyFormatterToJson(stringBuilder, o, offset + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                stringBuilder.append("\n").append("\t".repeat(offset)).append("}");
            }
            stringBuilder.append(",");
        }
    }
}
