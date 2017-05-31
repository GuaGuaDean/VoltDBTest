import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;



public class CharSetIssueReader {
	public static void main(String[] args) throws IOException {
		
		String FILENAME = "gb_encoded_text.txt";	
		// BufferedWriter bw = null;
		// FileWriter fw = null;
		
		String currentTime = String.valueOf(System.currentTimeMillis());
				
		//read from the file
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine;
			br = new BufferedReader(new FileReader(FILENAME));
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
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
