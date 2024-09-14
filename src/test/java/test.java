import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;


public class test {

    @Test
    public void read_test() throws IOException {
        IO io = new IO();
        File file = new File("a.txt");
        FileWriter fw = new FileWriter("b.txt");
        fw.write("你好，我是摸鱼儿。");
        fw.close();
        String str = io.readTxt("a.txt");
        Assert.assertEquals("你好，我是摸鱼儿。", str);
        file.delete();
    }

    @Test
    public void breakiterator_test() {
        String str = "在Github仓库中新建一个学号为名的文件夹。" +
                "在开始实现程序之前，在PSP表格[附录2]记录下你估计在程序开发各个步骤上耗费的时间，" +
                "在你实现程序之后，在PSP表格记录下你在程序的各个模块上实际花费的时间。" +
                "使用C++ 、Java语言或者python3实现，提交python代码时请附带上requirements.txt。" +
                "C++请使用Visual Studio Community 2017进行开发，运行环境为64-bit Windows 10。" +
                "对于C++/Java，还需将编译好的程序发布到Github仓库中的releases中。" +
                "提交的代码要求经过Code Quality Analysis工具的分析并消除所有的警告。";
        JavaBreakIterator jb = new JavaBreakIterator();
        List<String> breakline = jb.Breakline(str);
        System.out.println(breakline);
    }


    @Test
    public void ik_test() {
        String str = "在Github仓库中新建一个学号为名的文件夹。" +
                "在开始实现程序之前，在PSP表格[附录2]记录下你估计在程序开发各个步骤上耗费的时间，" +
                "在你实现程序之后，在PSP表格记录下你在程序的各个模块上实际花费的时间。" +
                "使用C++ 、Java语言或者python3实现，提交python代码时请附带上requirements.txt。" +
                "C++请使用Visual Studio Community 2017进行开发，运行环境为64-bit Windows 10。" +
                "对于C++/Java，还需将编译好的程序发布到Github仓库中的releases中。" +
                "提交的代码要求经过Code Quality Analysis工具的分析并消除所有的警告。";
        JavaBreakIterator jb = new JavaBreakIterator();
        List<String> breakline = jb.Breakline(str);
        List<String> list = new ArrayList<>();
        IK_analyzer ik = new IK_analyzer();
        System.out.println(ik.divideText(breakline));

    }

    @Test
    public void getwordcount_test() {
        List<String> list = new ArrayList<>();
        list.add("你");
        list.add("我");
        list.add("他");
        list.add("她");
        list.add("男");
        list.add("女");
        list.add("老");
        list.add("少");
        list.add("我");
        list.add("她");
        list.add("男");
        Getwordcount gw = new Getwordcount();
        System.out.println(gw.wordnumber(list));
    }

    @Test
    public void Union_test() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        Collections.addAll(list1, "a", "b", "c", "d", "e", "f");
        Collections.addAll(list2, "e", "b", "g", "z", "d", "f");
        Union un = new Union();
        System.out.println(un.Unionall(list1, list2));

    }

    @Test
    public void cos_test(){
        COS c = new COS();
        c.Cos(null,null,null);
    }
}
