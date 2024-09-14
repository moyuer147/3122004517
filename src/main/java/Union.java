import java.util.*;

public class Union {

    public List<String> Unionall(List<String> list1, List<String> list2) {

        TreeSet<String> union = new TreeSet<>();
        union.addAll(list1);
        union.addAll(list2);  //将两个文本出现过的词语合并在一个集合中

        List<String> list = new ArrayList<>(union);
        return list;

    }

}
