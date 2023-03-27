package com.account;

public class MoneyInWords {
    private static final String dig1[][] = {{"одна", "дві", "три", "чотири", "п'ять", "шість", "сім", "вісім", "дев'ять"},
            {"одна", "дві"}}; //dig[0] - female, dig[1] - male
    private static final String dig10[]  = {"десять", "одинадцять", "дванадцять", "тринадцять", "чотирнадцять",
            "п'ятнадцять", "шістнадцять", "сімнадцять", "вісімнадцять", "дев'ятнадцять"};
    private static final String dig20[]  = {"двадцять", "тридцять", "сорок", "п'ятдесят",
            "шістдесят", "сімдесят", "вісімдесят", "дев'яносто"};
    private static final String dig100[] = {"сто", "двісті", "триста", "чотириста", "п'ятсот",
            "шістсот", "сімсот", "вісімсот", "дев'ятсот"};
    private static final String leword[][] = { {"коп.", "коп.", "коп.", "0"},
            {"грн.", "грн.", "грн.", "1"},
            {"тисяча", "тисячі", "тисяч", "0"},
            {"мільйон", "мільйона", "мільйонів", "1"},
            {"мільярд", "мільярда", "мільярдів", "1"},
            {"трильйон", "трильйони", "трильйони", "1"}};

    //рекурсивна функція перетворення цілого числа num у гривні
    private static String num2words(long num, int level) {
        StringBuilder words = new StringBuilder(50);
        if (num==0) words.append("нуль ");
        int sex = leword[level][3].indexOf("1")+1;
        int h = (int)(num%1000);
        int d = h/100;
        if (d>0) words.append(dig100[d-1]).append(" ");
        int n = h%100;
        d = n/10;
        n = n%10;
        switch(d) {
            case 0: break;
            case 1: words.append(dig10[n]).append(" ");
                break;
            default: words.append(dig20[d-2]).append(" ");
        }
        if (d==1) n=0;
        switch(n) {
            case 0: break;
            case 1:
            case 2: words.append(dig1[sex][n-1]).append(" ");
                break;
            default: words.append(dig1[0][n-1]).append(" ");
        }
        switch(n) {
            case 1: words.append(leword[level][0]);
                break;
            case 2:
            case 3:
            case 4: words.append(leword[level][1]);
                break;
            default: if((h!=0)||((h==0)&&(level==1)))
                words.append(leword[level][2]);
        }
        long nextnum = num/1000;
        if(nextnum>0) {
            return (num2words(nextnum, level+1) + " " + words.toString()).trim();
        } else {
            return words.toString().trim();
        }
    }

    //функція перетворення речовинного числа на гривня-копійки
    public static String inwords(double money) {
        if (money<0.0) return "error: від'ємне значення";
        String sm = String.format("%.2f", money);
        String skop = sm.substring(sm.length()-2, sm.length());
        int iw;
        switch(skop.substring(1)) {
            case "1": iw = 0;
                break;
            case "2":
            case "3":
            case "4": iw = 1;
                break;
            default:  iw = 2;
        }
        long num = (long)Math.floor(money);
        if (num<1000000000000000l) {
            return num2words(num, 1) + " " + skop + " " + leword[0][iw];
        } else
            return "error: занадто багато гривень " + skop + " " + leword[0][iw];
    }
}