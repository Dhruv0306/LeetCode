class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysFrom1971(date1) - daysFrom1971(date2));
    }

    private int daysFrom1971(String date) {
        int[] dateNum = getDateNum(date);
        int year = dateNum[0], month = dateNum[1], day = dateNum[2];

        int[] daysInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int totalDays = 0;

        for (int y = 1971; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        for (int m = 1; m < month; m++) {
            totalDays += daysInMonth[m];
            if (m == 2 && isLeapYear(year)) {
                totalDays += 1;
            }
        }
        totalDays += day;

        return totalDays;
    }

    public static int[] getDateNum(String date) {
        int[] dateNum = new int[3];
        dateNum[0] = Integer.parseInt(date.substring(0, 4));
        dateNum[1] = Integer.parseInt(date.substring(5, 7));
        dateNum[2] = Integer.parseInt(date.substring(8));
        return dateNum;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
