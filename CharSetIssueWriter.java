import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;



public class CharSetIssueWriter {
	public static void main(String[] args) throws IOException {
		
		String FILENAME = "gb_encoded_text.txt";	
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		String currentTime = String.valueOf(System.currentTimeMillis());
		
		String []myData = {
                "clm_integer, clm_tinyint, clm_smallint, clm_bigint, clm_string, clm_decimal, clm_float, clm_timestamp, clm_point,clm_geography",
                "1 ,1,1,11111111,复杂的汉字,1.10,1.11,"+currentTime+",POINT(1 1),\\\"POLYGON((0 0, 1 0, 0 1, 0 0))\\\"",
                "2,2,2,222222,second,3.30,NULL,"+currentTime+",POINT(2 2),\\\"POLYGON((0 0, 2 0, 0 2, 0 0))\\\"",
                "3,3,3,333333, third ,NULL, 3.33,"+currentTime+",POINT(3 3),\\\"POLYGON((0 0, 3 0, 0 3, 0 0))\\\"",
                "4,4,4,444444, NULL ,4.40 ,4.44,"+currentTime+",POINT(4 4),\\\"POLYGON((0 0, 4 0, 0 4, 0 0))\\\"",
                "5,5,5,5555555,  \"abcde\"g, 5.50, 5.55,"+currentTime+",POINT(5 5),\\\"POLYGON((0 0, 5 0, 0 5, 0 0))\\\"",
                "6,6,NULL,666666, sixth, 6.60, 6.66,"+currentTime+",POINT(6 6),\\\"POLYGON((0 0, 6 0, 0 6, 0 0))\\\"",
                "7,NULL,7,7777777, seventh, 7.70, 7.77,"+currentTime+",POINT(7 7),\\\"POLYGON((0 0, 7 0, 0 7, 0 0))\\\"",
                "11, 1,1,\"1,000\",first,1.10,1.11,"+currentTime+",POINT(1 1),\\\"POLYGON((0 0, 8 0, 0 8, 0 0))\\\"",
        };
		
		// write to the file
		try {
			fw = new FileWriter(FILENAME);
			fw.flush();
			bw = new BufferedWriter(fw);
			for(String line: myData) {
				String gbline = new String(line.getBytes("gbk"), "gbk");
				bw.write(gbline+"\n");
			}
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
				
//		InputStream is = new FileInputStream("utf8_encoded_text.txt");
//        OutputStream os = new FileOutputStream("gb2312_encoded.txt");
//
//        Reader r = new InputStreamReader(is,"utf-8");
//        BufferedReader br = new BufferedReader(r);
//        Writer w = new OutputStreamWriter(os, "gb2312");
//        BufferedWriter bw = new BufferedWriter(w);
//
//        String s=null;
//        while((s=br.readLine())!=null) {
//            bw.write(s);
//        }
//        br.close();
//        bw.close();
//        os.flush();
		
//		String origin = "UTF-8是通用的编码";
//		String utf8Data = new String(origin.getBytes(), "utf-8");
//		String gbData = new String(origin.getBytes(), "gb2312");
//		String utf8_to_gb = new String(utf8Data.getBytes("gb2312"), "gb2312");
//		String gb_to_utf8 = new String(gbData.getBytes(), "utf-8");
//		System.out.println("This is utf8 data: " + utf8Data);
//		System.out.println("This is gb data: " + gbData);
//		System.out.println("This is from utf8 to gb data: " + utf8_to_gb);
//		System.out.println("This is from gb to utf8 data: " + gb_to_utf8);
	}
}
