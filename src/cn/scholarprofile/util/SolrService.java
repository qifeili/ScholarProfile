package cn.scholarprofile.util;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;

/**
 * <b>function:</b> 测试solr服务
 */
public class SolrService {
//	private static final String DEFAULT_URL = "http://121.42.32.19/solr";
	private static final String DEFAULT_URL = "http://localhost:8081/solr";//本地服务器solr接口
//	private static final String DEFAULT_URL = "http://www.comwit.cn:8081/solr";  //阿里云服务器solr接口
    private SolrClient solrClient;
    
     public SolrService() {
        try {
        	solrClient = new HttpSolrClient(DEFAULT_URL);
        	}
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void destory() {
    	solrClient = null;
        System.runFinalization();
        System.gc();
    }
    
    /**
     * <b>function:</b> 测试是否创建server对象成功
     */
    public void server() {
        fail(solrClient);
        
    }
    
    /**
     * <b>function:</b> 根据query参数查询索引 
     */
    public Map<String, String> query(String query) {
//    	query = "papertitle:神经网络 AND officialdesc:神经网络";
    	query = "papertitle:" + query + "OR officialdesc:" + query;
//    	String query = "name:solr";
//      SolrParams params = new SolrQuery(query);
    	Map<String, String> sortedScholarMap = new HashMap(); //key:id   value:score
        Map<String, String> mapParams = new HashMap<>();
        mapParams.put("fl", "id,score");
        mapParams.put("start", String.valueOf(0));
        mapParams.put("rows", String.valueOf(Integer.MAX_VALUE));
        mapParams.put("q", query);
        mapParams.put("sort", "score desc");
        SolrParams mapSolrParams = new MapSolrParams(mapParams);
        try {
            QueryResponse response = solrClient.query(mapSolrParams);
            
            SolrDocumentList list = response.getResults();
            for (int i = 0; i < list.size(); i++) {
                SolrDocument item = list.get(i);
                Map<String, String> solrscholar = new HashMap<>();
                sortedScholarMap.put(String.valueOf(item.get("id")), String.valueOf(item.get("score")));
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
        return sortedScholarMap;
    }
    
    
    /**
     * <b>function:</b> 提供双语查询,根据query参数查询索引 ,transquery是query翻译后的字符串.
     * 					若query中文,则transquery英文;若query英文,则transquery中文
     */
    public Map<String, String> query(String query, String transquery) {
//    	query = "papertitle:神经网络 AND officialdesc:神经网络";
//    	query = query + " " + transquery;
    	query = "papertitle:" + query + " OR officialdesc:" + query + " OR papertitle:" + transquery + " OR officialdesc:" + transquery;
//    	String query = "name:solr";
//      SolrParams params = new SolrQuery(query);
    	Map<String, String> sortedScholarMap = new HashMap(); //key:id   value:score
        Map<String, String> mapParams = new HashMap<>();
        mapParams.put("fl", "id,score");
        mapParams.put("start", String.valueOf(0));
        mapParams.put("rows", String.valueOf(Integer.MAX_VALUE));
        mapParams.put("q", query);
        mapParams.put("sort", "score desc");
        SolrParams mapSolrParams = new MapSolrParams(mapParams);
        try {
            QueryResponse response = solrClient.query(mapSolrParams);
            SolrDocumentList list = response.getResults();
            for (int i = 0; i < list.size(); i++) {
                SolrDocument item = list.get(i);
                Map<String, String> solrscholar = new HashMap<>();
                sortedScholarMap.put(String.valueOf(item.get("id")), String.valueOf(item.get("score")));
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
        return sortedScholarMap;
    }
    
    /**
     * <b>function:</b> 根据query参数查询索引 
     */
//    public void query(String query) {
//        SolrParams params = new SolrQuery(query);
//        try {
// 
//            QueryResponse response = solrClient.query(params);
//            SolrDocumentList list = response.getResults();
//            for (int i = 0; i < list.size(); i++) {
//                fail(list.get(i));
//            }
//        } catch (SolrServerException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//			// TODO: handle exception
//        	e.printStackTrace();
//		}
//    }
    
    /**
     * <b>function:</b> 删除索引
     */
    public void deleteIndex() {
    	String query = "id:*";
    	try {
			UpdateResponse response = solrClient.deleteByQuery(query);
			response = solrClient.commit();
		} catch (SolrServerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

    
    /**
     * <b>function:</b> 添加doc文档
     */
    public void addDoc() {
        //创建doc文档
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", 8);
        doc.addField("name", "Solr Solr Document");
        doc.addField("manu", "this is SolrInputDocument content");
        try {
            //添加一个doc文档
            UpdateResponse response = solrClient.add(doc);
            System.out.println(response);
            fail(solrClient.commit());//commit后才保存到索引库
            fail(response);
            fail("query time：" + response.getQTime());
            fail("Elapsed Time：" + response.getElapsedTime());
            fail("status：" + response.getStatus());
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        query("name:solr");
    }
    
//    /**
//     * <b>function:</b> 将所有学者的文本信息存储到slor中，建立索引信息
//     * id:学者在数据库表t_scholar中对应的id
//     * name:学者姓名
//     * papertitle:学者论文题目列表
//     * officialdesc:学者官方主页的描述
//     */
//    public void addIndex() {
//    	List<Map<String, String>> scholarmapList = null;
//    	try {
//			scholarmapList = getSolrScholarList();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//    	
//    	for (Map scholarmap : scholarmapList) {
//            //创建doc文档
//            SolrInputDocument doc = new SolrInputDocument();
//            doc.addField("id", scholarmap.get("id"));
//            doc.addField("name", scholarmap.get("name"));
//            doc.addField("papertitle", scholarmap.get("papertitle"));
//            doc.addField("officialdesc", scholarmap.get("officialdesc"));
//            try {
//                //添加一个doc文档
//                UpdateResponse response = solrClient.add(doc);
//                solrClient.commit();//commit后才保存到索引库
//            } catch (SolrServerException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//		}
//    }    
    
    /**
     * <b>function:</b> 输出函数
     */
    public final void fail(Object o) {
        System.out.println(o);
    }
    

}
