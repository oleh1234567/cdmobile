package jclevel9;

public class Main {
    static int data;
    static int CountryPhoneCode;
    public static String getPhoneNumber1() {
        return String.format("+%d(%2$s)%3$s-%4$s-%5$s", CountryPhoneCode,
                String.format("%010d", data).substring(0, 3),
                String.format("%010d", data).substring(3, 6),
                String.format("%010d", data).substring(6, 8),
                String.format("%010d", data).substring(8));
    }

    public static String getPhoneNumber() {
        String d = String.valueOf(data);
        StringBuilder pnumber = new StringBuilder(d);
        while(pnumber.length() != 10){
            pnumber.insert(0, "0");
        }
        String phone = pnumber.toString();
        return String.format("+%s(%s)%s-%s-%s", CountryPhoneCode,
                phone.substring(0,3),
                phone.substring(3,6),
                phone.substring(6,8),
                phone.substring(8)
        );
    }
    public static void main(String[] args) {
        data = 991234567;
        CountryPhoneCode = 1;
        System.out.println(getPhoneNumber());
    }
}
