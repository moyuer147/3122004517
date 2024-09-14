import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class IK_analyzer {
    public List<String> divideText(List<String> list) {

        List<String> resultList = new ArrayList<>();
        // 智能分词： 合并数词和量词，对分词结果进行歧义判断
        int i = 0;

        for (String juzi : list) {
            IKSegmenter ik = new IKSegmenter(new StringReader(juzi), true);
            // Lexeme 词元对象
            Lexeme lex = null;
            try {
                // 分词，获取下一个词元
                while ((lex = ik.next()) != null) {
                    // 获取词元的文本内容，存入结果集中
                    resultList.add(lex.getLexemeText());
                }
            } catch (IOException e) {
                System.out.println("分词IO异常：" + e.getMessage());
            }
        }
        return resultList;
    }
}
