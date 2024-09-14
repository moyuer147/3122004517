import java.util.List;
import java.util.Map;
import java.util.Set;

public class COS {
    public double Cos(List<String> origlist, List<String> dividelist, List<String> union) {

        if (origlist == null || dividelist == null || union == null) {
            System.out.println("参数缺失");
            return 1.0;
        }

        Getwordcount gw1 = new Getwordcount();
        Map<String, Integer> txtmap = gw1.wordnumber(dividelist);

        Getwordcount gw2 = new Getwordcount();
        Map<String, Integer> origmap = gw1.wordnumber(origlist);

        int[] origarr = new int[union.size()];
        int[] txtarr = new int[union.size()];

        for (int i = 0; i < union.size(); i++) {
            origarr[i] = origmap.getOrDefault(union.get(i), 0);  //将每个词语的出现次数储存在数组中
            txtarr[i] = txtmap.getOrDefault(union.get(i), 0); //将每个词语的出现次数储存在数组中
        }

        int n = txtarr.length;
        double p1 = 0;
        double p2 = 0f;
        double p3 = 0f;
        for (int i = 0; i < n; i++) {
            p1 += (origarr[i] * txtarr[i]);
            p2 += (origarr[i] * origarr[i]);
            p3 += (txtarr[i] * txtarr[i]);
        }
        p2 = Math.sqrt(p2);
        p3 = Math.sqrt(p3);

        return (p1) / (p2 * p3);

    }
}
