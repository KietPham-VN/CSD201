package utils;

import java.util.Scanner;

public class Inputter {

    public static final Scanner sc = new Scanner(System.in);

    //1. method ép người dùng nhập số nguyên
    public static int getAnInteger(String inpMsg, String errMsg) {
        System.out.print(inpMsg);
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());

                return number;
            } catch (NumberFormatException e) {
                System.out.println(errMsg);
            }
        }
    }

    public static int getAnIntegerWithLowerBound(String inpMsg, String errMsg, int lowerBound) {
        System.out.print(inpMsg);
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number < lowerBound) {
                    System.out.println("Number cannot be smaller than " + lowerBound);
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println(errMsg);
            }
        }
    }

    public static int getAnIntegerWithUpperBound(String inpMsg, String errMsg, int upperBound) {
        System.out.print(inpMsg);
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number > upperBound) {
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }

    public static int getAnInteger(String inpMsg) {
        System.out.print(inpMsg);
        while (true) {
            try {
                String str = sc.nextLine();
                if (str.isEmpty()) {
                    return -1;
                }
                int number = Integer.parseInt(str);
                return number;
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
    }

    //2. method ép người dùng nhập số nguyên chuẩn nhưng phải trong khoảng
    public static int getAnInteger(String inpMsg, String errMsg,
            int upperBound, int lowerBound) {
        if (lowerBound > upperBound) {
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }

        while (true) {
            try {
                System.out.println(inpMsg);
                int number = Integer.parseInt(sc.nextLine());//
                if (number < lowerBound || number > upperBound) {
                    System.out.println("The number must be in range of " + lowerBound + " and " + upperBound);
                } else {
                    return number;
                }
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }

    //3. method ép người dùng nhập số thực
    public static double getADouble(String inpMsg, String errMsg) {
        while (true) {
            try {
                System.out.println(inpMsg);

                double number = Double.parseDouble(sc.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.println(errMsg);// hiển thị câu chửi
            }
        }
    }

    //4. method ép người dùng nhập số thực chuẩn nhưng phải trong khoảng
    public static double getADouble(String inpMsg, String errMsg,
            double upperBound, double lowerBound) {

        if (lowerBound > upperBound) {
            double tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }

        System.out.println(inpMsg);
        while (true) {
            try {
                double number = Double.parseDouble(sc.nextLine());
                if (number < lowerBound || number > upperBound) {
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }

    public static double getADouble(String inpMsg,
            double upperBound, double lowerBound) {

        if (lowerBound > upperBound) {
            double tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }

        System.out.println(inpMsg);
        while (true) {
            try {
                String str = sc.nextLine();
                if (str.isEmpty()) {
                    return -1;
                }
                double number = Double.parseDouble(str);
                if (number < lowerBound || number > upperBound) {
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    // hàm nhập chuỗi được để trống
    public static String getString(String inpMsg) {
        System.out.printf(inpMsg);
        return sc.nextLine();
    }

    //5. Hàm nhập chuỗi cấm để trống
    public static String getString(String inpMsg, String errMsg) {
        System.out.println(inpMsg);
        while (true) {
            try {
                String str = sc.nextLine();
                if (str.isEmpty()) {
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }

    //6. Hàm nhập chuỗi cấm để trống và phải giống format(regex)  
    public static String getString(String inpMsg, String errMsg, String regex) {
        System.out.println(inpMsg);
        while (true) {
            try {
                String str = sc.nextLine();
                if (str.isEmpty() || !str.matches(regex)) {
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}

