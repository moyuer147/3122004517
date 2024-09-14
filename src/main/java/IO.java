import java.io.FileReader;
import java.io.IOException;

public class IO {

    public String readTxt(String str) throws IOException {

        try {
            FileReader fr = new FileReader(str);
            char[] chars = new char[4];
            StringBuilder sb = new StringBuilder();
            int len;
            while ((len = fr.read(chars)) != -1 ){ //读取文件
                sb.append(new String(chars,0,len));
            }
            fr.close();
            return sb.toString();
        } catch (IOException e) {
            System.out.println("找不到文件或不是文本文件");
            throw new RuntimeException(e);
        }
    }

}
