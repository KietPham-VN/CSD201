package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    // hàm chuẩn hóa chuỗi date
    public static String dateNormalizer(String dateStr) {
        return dateStr.replaceAll("[\\s]+", "").replaceAll("[./-]", "-");
    }

    // hàm ép kiểu về 1 định dạng ngày tháng cụ thể
    public static Date parseDate(String str, String dateFormat) {
        str = dateNormalizer(str);
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        try {
            return formatter.parse(str);
        } catch (ParseException e) {
            System.out.println(e);
        }
        return null;
    }

    // hàm chuyển date thành string
    public static String formatDate(Date date, String dateFormat) {
        if (date == null) {
            return null;
        }
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }

    // hàm toString
    public static String toString(Date date, String dateFormat) {
        if (date == null) {
            return "";
        }
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }

    // hàm in ra mấy cái đường cho đẹp
    public static void printLine(int... widths) {
        System.out.print("+");
        for (int width : widths) {
            for (int i = 0; i < width; i++) {
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println();
    }

    // hàm lấy ra số từ chuỗi
    public static int[] extractNumbers(String input) {
        ArrayList<Integer> numberList = new ArrayList<>();
        Pattern pattern = Pattern.compile("-(\\d+)|\\d+");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String number = matcher.group();
            numberList.add(Integer.parseInt(number.replace("-", "")));
        }
        return numberList.stream().mapToInt(i -> i).toArray();
    }

    // hàm viết hoa chữ cái đầu tiên
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String[] words = str.toLowerCase().split("\\s+");
        StringBuilder capitalizedWords = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                capitalizedWords.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        return capitalizedWords.toString().trim();
    }
}
