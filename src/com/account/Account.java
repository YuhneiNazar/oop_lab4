package com.account;
import java.util.Scanner;
public class Account
{
    private String priz;
    private int no;
    private double vid;
    private double sum;
    public String getPriz() { return priz; }
    public int getNo() { return no; }
    public double getVid() { return vid; }
    public double getSum() { return sum; }
    public void setPriz(String nm) { this.priz = nm; }
    MoneyInWords condoubleinstring = new MoneyInWords();
    public boolean setNo(int num)
    {
        if (num > 0)
        {
            no = num;
            return true;
        }
        else
        {
            no = 0;
            return false;
        }
    }
    public boolean setVid(double v)
    {
        if (v > 0)
        {
            vid = v;
            return true;
        }
        else
        {
            vid = -v;
            return false;
        }
    }
    public boolean setSum(double s)
    {
        if (s > 0)
        {
            sum = s;

            return true;
        }
        else
        {
            sum = -s;
            return false;
        }
    }
    public boolean Init(String nm, int num, double v, double s)
    {
        setPriz(nm);
        return setNo(num) && setVid(v) && setSum(s);
    }
    public void Read()
    {
        Scanner scan = new Scanner(System.in);
        String nm;
        int num;
        double v;
        double s;
        System.out.println("Прізвище власника: ");
        nm = scan.nextLine();
        do
        {
            System.out.println("Номер рахунку: ");
            num = scan.nextInt();
            System.out.println("Відсоток нарахування: ");
            v = scan.nextDouble();
            System.out.println("Сума: ");
            s = scan.nextDouble();
        } while (!Init(nm, num, v, s));
    }
    public void Display()
    { System.out.println();
        System.out.println("Прізвище: " + priz);
        System.out.println("Номер: " + no);
        System.out.println("Відсоток: " + vid);
        System.out.printf("Сума: " + "%.2f\n",sum);
    }

    public void Chegvl () {
        System.out.println("Введіть прізвище нового власника:");
        Scanner scan = new Scanner(System.in);
        String newname = scan.nextLine();
        if (newname.length() == 0||newname.matches(".*\\d.*")){
            while (newname.length() == 0||newname.matches(".*\\d.*")) {
                System.out.println("Ви неправельно ввели прізвище!");
                System.out.println("Введіть прізвище щераз:");
                newname = scan.nextLine();
            }
            priz = newname;
        }
        else priz = newname;
    }
    public void minussum () {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть суму:");
        double minsum = scan.nextDouble();
        if (minsum>sum || minsum<=0) {
                while (minsum > sum || minsum<=0) {
                    System.out.println("Ви ввели неправельну суму!");
                    System.out.println("Введіть правельну суму:");
                    minsum = scan.nextDouble();
                }
            minsum = minsum-sum;
                setSum(minsum);
        }
        else {
            minsum =  minsum- sum;
            setSum( minsum);
        }
    }

    public void plussum () {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть суму:");
        double plusum = scan.nextDouble();
        if (plusum<=0) {
            while (plusum<=0) {
                System.out.println("Ви ввели неправельну суму!");
                System.out.println("Введіть правельну суму:");
                plusum = scan.nextDouble();
            }
            plusum = plusum + sum;
            setSum(plusum );
        }
        else {
            plusum = plusum + sum;
            setSum(plusum );
        }
    }

    public void addvid () {
        double v = ((sum/100)*vid)+sum;
        if (v>0) {
            System.out.println("Нарахування відсотоку відбулось успішно!");
            setSum(v);
            setVid(0);
        }
        else System.out.println("Помилка нарахування відсотку!");
    }

    public void sumcondol () {
        double d = (sum/38.50);
        if (d>0) {
            System.out.println("Переведення суми в долар виконано!");
            setSum(d);
        }
        else System.out.println("Помилка переведення суми в долар");
    }
    public void sumtost () {
        System.out.println(condoubleinstring.inwords(sum));
    }
}