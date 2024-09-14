import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Getwordcount {
    public TreeMap<String,Integer> wordnumber(List<String> list){

        TreeMap<String,Integer> map = new TreeMap<>();
        for (String str : list) {
            map.put(str, map.getOrDefault(str, 0) + 1); //键：词语，值：每个词语的出现次数
        }
        //System.out.println(map);
        return map;

    }
}
