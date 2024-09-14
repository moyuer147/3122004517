import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("请输入规定格式，如：java -jar main.jar C:\\tests\\org.txt C:\\tests\\org_add.txt C:\\tests\\ans.txt");
        while (true) {

            String s1 = null;
            String s2 = null;
            String s3 = null;
            String readTxt1 = null;
            String readTxt2 = null;
            while (true) {
                String str = new String();
                Scanner sc = new Scanner(System.in);
                str = sc.nextLine();
                if (str.equals("exit")) return;
                String[] s = str.split(" ");
                s1 = null;
                s2 = null;
                s3 = null;
                try {
                    s1 = s[3];
                    s2 = s[4];
                    s3 = s[5];

                    IO io1 = new IO();
                    readTxt1 = io1.readTxt(s1);
                    IO io2 = new IO();
                    readTxt2 = io1.readTxt(s2);
                    IO io3 = new IO();
                    io3.readTxt(s3);
                    break;
                } catch (Exception e) {
                    System.out.println("未按规定格式输入，请重新输入");
                    continue;
                }
            }

            double number1 = readTxt1.length(); //记录文本字数
            double number2 = readTxt2.length(); //记录文本字数

            List<String> origlist = origtxt.shujuku(s1); //分词放进list
            Getwordcount gw1 = new Getwordcount();

            JavaBreakIterator jb = new JavaBreakIterator();
            IO io = new IO();
            List<String> txtlist = jb.Breakline(io.readTxt(s2)); //读取断句
            IK_analyzer ik = new IK_analyzer();
            List<String> dividelist = ik.divideText(txtlist); //分词放进list

            Union un = new Union();
            List<String> unionall = un.Unionall(origlist, dividelist); //两个文本词语的并集

            COS cos = new COS(); //计算余弦相似度

            double answer = cos.Cos(origlist, dividelist, unionall);
            if (number1 > number2) {  //将字数占比也作为相似度的依据
                answer = (answer / number1) * number2;
            } else {
                answer = (answer / number2 * number1);
            }

            FileWriter fw = new FileWriter(s3, true);
            fw.write(s1 + "和" + s2 + "的相似度为：" + answer * 100 + "%");
            fw.write("\n");
            fw.close();

            System.out.println("计算成功，答案已放入指定文本内，继续按格式输入，如要退出请输入：exit");
        }
    }

}
