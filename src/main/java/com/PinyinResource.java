package main.java.com;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 资源文件加载类
 *
 * @author stuxuhai (dczxxuhai@gmail.com)
 */
public final class PinyinResource {

    private PinyinResource() {
    }

    protected static Reader newClassPathReader(String classpath) {
        InputStream is = PinyinResource.class.getResourceAsStream(classpath);
        try {
            return new InputStreamReader(is, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    protected static Reader newFileReader(String path) throws FileNotFoundException {
        try {
            return new InputStreamReader(new FileInputStream(path), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    protected static Map<String, String> getResource(Reader reader) {
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        try {
            BufferedReader br = new BufferedReader(reader);
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.trim().split("=");
                map.put(tokens[0], tokens[1]);
            }
            br.close();
        } 
        catch (FileNotFoundException e) {
			// TODO: handle exception
        	System.err.println("[ERROR]: cannot find the file, please check");
        	e.printStackTrace();
		}
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        return map;
    }

    public static Map<String, String> getPinyinResource() {
        return getResource(newClassPathReader("../../resources/data/pinyin.dict"));
    }

    public static Map<String, String> getMutilPinyinResource() {
        return getResource(newClassPathReader("../../resources/data/mutil_pinyin.dict"));
    }

    public static Map<String, String> getChineseResource() {
        return getResource(newClassPathReader("../../resources/data/chinese.dict"));
    }
}