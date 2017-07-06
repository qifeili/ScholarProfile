package cn.scholarprofile.util;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 * 按领域关键字搜索学者的缓存管理类
 * 缓存的key是查询的字符串
 * 缓存的value是查询出的学者id列表
 */
public class FieldQueryCacheManager {
	private static HashMap<String, List<Integer>> cacheMap = new HashMap<>();
	private static int cachelimit = 1000;
	private static int cachesize = 0;

	private static Queue<String> mapkeyQueue = new ArrayDeque<>();
	
	public static int getCachesize() {
		return cachesize;
	}

	public static void setCachesize(int cachesize) {
		FieldQueryCacheManager.cachesize = cachesize;
	}
	
    // 载入缓存  
    public synchronized static void putCache(String key, List<Integer> scholaridlist) {
    	if (cachesize >= cachelimit) {
			String keytoremove = mapkeyQueue.poll();
			cacheMap.remove(keytoremove);
			cachesize --;
		}
        cacheMap.put(key, scholaridlist);  
        mapkeyQueue.add(key);
        cachesize ++;
    } 
	
    // 得到缓存。同步静态方法  
    private synchronized static List<Integer> getCache(String key) {  
        return cacheMap.get(key);  
    } 
    
    // 按页得到缓存。同步静态方法
    // pageno 获取的页码数：1,2,3,4,5，，，
    // rows 每页呈现的记录数
    public synchronized static Map<String, Object> getCache(String key, int pageno, int rows) { 
    	Map<String, Object> queryresult = new HashMap<>();
    	List<Integer> scholaridlist = cacheMap.get(key); 
    	if (scholaridlist == null) {
			return null;
		}
    	int maxresultrows = scholaridlist.size();
    	queryresult.put("maxresultrows", maxresultrows);
    	int startindex = (pageno - 1) * rows;
    	int endindex = startindex + rows;
    	endindex = endindex > maxresultrows ? maxresultrows : endindex; 
    	queryresult.put("resultlist", scholaridlist.subList(startindex, endindex));
        return queryresult;  
    }
	
    // 判断是否存在一个缓存  
    private synchronized static boolean hasCache(String key) {  
        return cacheMap.containsKey(key);  
    } 
	
	// 清除所有缓存  
    public synchronized static void clearAll() {  
        cacheMap.clear();  
    } 
}
