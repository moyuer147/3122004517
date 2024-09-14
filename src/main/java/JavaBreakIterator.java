import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class JavaBreakIterator {

    public List<String> Breakline(String context) {

        List<String> list = new ArrayList<>();
        BreakIterator boundary = BreakIterator.getSentenceInstance(Locale.CHINESE);
        boundary.setText(context);
        int start = boundary.first();
        for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {
            //System.out.println(context.substring(start, end));
            list.add(context.substring(start, end));  //将一句话作为一个list的成员
        }
        return list;
    }
}
