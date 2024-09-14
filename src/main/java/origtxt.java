import java.io.IOException;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class origtxt {

    public static List<String> shujuku(String str) throws IOException { //原文本的数据

        JavaBreakIterator jb = new JavaBreakIterator();
        IO io = new IO();
        List<String> list = jb.Breakline(io.readTxt(str));
        IK_analyzer ik = new IK_analyzer();
        List<String> divideText = ik.divideText(list);

        return divideText;

    }
}