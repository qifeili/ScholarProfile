package cn.scholarprofile.service;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.scholarprofile.bean.Scholar;
import cn.scholarprofile.dto.ScholarSort;

/**
 * <b>function:</b> 测试solr服务
 */
public class SolrServiceTest {
	private static final String DEFAULT_URL = "http://localhost:8080/solr";
//	private static final String DEFAULT_URL = "http://121.42.32.19/solr";
    private SolrClient solrClient;
	ClassPathXmlApplicationContext ctx;
	ScholarService ss;
    
    @Before
     public void init() {
        try {
        	solrClient = new HttpSolrClient(DEFAULT_URL);
        	}
        catch (Exception e) {
            e.printStackTrace();
        }
		ctx = new ClassPathXmlApplicationContext("/config/beans.xml");
		ss = (ScholarService) ctx.getBean("scholarService");
    }
    
    @After
    public void destory() {
    	solrClient = null;
        System.runFinalization();
        System.gc();
    }
    
    /**
     * <b>function:</b> 测试是否创建server对象成功
     */
    @Test
    public void server() {
        fail(solrClient);
        
    }
    
    /**
     * <b>function:</b> 根据query参数查询索引 
     */
    @Test
    public void query() {
//    	String query = "name:solr";
//      SolrParams params = new SolrQuery(query);
        Map<String, String> mapParams = new HashMap<>();
        mapParams.put("fl", "id,score");
        mapParams.put("start", String.valueOf(0));
        mapParams.put("rows", String.valueOf(Integer.MAX_VALUE));
        mapParams.put("q", "papertitle:神经网络 OR officialdesc:神经网络");
        mapParams.put("sort", "score desc");
        SolrParams mapSolrParams = new MapSolrParams(mapParams);
        try {
            QueryResponse response = solrClient.query(mapSolrParams);
            SolrDocumentList list = response.getResults();
            System.out.println("+++");
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                SolrDocument item = list.get(i);
                fail(item.get("score"));
                fail(item.get("id"));
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
    }
    
    /**
     * <b>function:</b> 根据query参数查询索引 
     */
    public void query(String query) {
        SolrParams params = new SolrQuery(query);
        try {
 
            QueryResponse response = solrClient.query(params);
            SolrDocumentList list = response.getResults();
            for (int i = 0; i < list.size(); i++) {
                fail(list.get(i));
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
    }
    
    /**
     * <b>function:</b> 删除索引
     */
    @Test
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
    @Test
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
    
    /**
     * <b>function:</b> 将所有学者的文本信息存储到slor中，建立索引信息
     * id:学者在数据库表t_scholar中对应的id
     * name:学者姓名
     * papertitle:学者论文题目列表
     * officialdesc:学者官方主页的描述
     */
    @Test
    public void addIndex() {
    	List<Map<String, String>> scholarmapList = null;
    	try {
			scholarmapList = getSolrScholarList();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	for (Map scholarmap : scholarmapList) {
            //创建doc文档
            SolrInputDocument doc = new SolrInputDocument();
            doc.addField("id", scholarmap.get("id"));
            doc.addField("name", scholarmap.get("name"));
            doc.addField("papertitle", scholarmap.get("papertitle"));
            doc.addField("officialdesc", scholarmap.get("officialdesc"));
            
/*            String path = "/home/yongliu/Documents/documents/work/Enterprise technical service/Data/教师列表-官网/tmp/";
            try {
				str2file((String) scholarmap.get("officialdesc"), new File(path+scholarmap.get("name")+".txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
            try {
                //添加一个doc文档
                UpdateResponse response = solrClient.add(doc);
                solrClient.commit();//commit后才保存到索引库
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
    }
    
    /**
     * <b>function:</b> 获取scholar列表，存入到solr中
     * @throws IOException 
     */
    public List<Map<String, String>> getSolrScholarList() throws IOException {
    	//读取学者的论文列表
    	String scholarPaperTitleTxt = "/home/yongliu/Documents/workspace/PycharmProjects/baiduscholar/baiduscholar/data/official_baiduscholar_lda/lda_raw.txt";
    	String scholarInstitude_NameTxt = "/home/yongliu/Documents/workspace/PycharmProjects/baiduscholar/baiduscholar/data/official_baiduscholar_lda/lda_raw_institude_name.txt";
    	List<String> scholarPaperTitlelist = file2strlist(new File(scholarPaperTitleTxt));
    	List<String> scholarInstitude_NameList = file2strlist(new File(scholarInstitude_NameTxt));
    	Map<String, String> scholarInsNamePaperTitleMap = new HashMap<>();
    	for (int i = 0; i < scholarPaperTitlelist.size(); i++) {
    		scholarInsNamePaperTitleMap.put(scholarInstitude_NameList.get(i), scholarPaperTitlelist.get(i));
		}
    	//读取学者的官网主页
    	String scholarHtmlPages = "/home/yongliu/Documents/documents/work/Enterprise technical service/Data/教师列表-官网/Page20160123";
    	List<String> scholarHtmlFilePathList = new ArrayList<String>();
    	File file = new File(scholarHtmlPages);
    	File[] subfilelist = file.listFiles();
    	for (File subfile : subfilelist) {
    		if (subfile.isDirectory()) {
    			File[] subsubfilelist = subfile.listFiles();
    			for (File subsubfile : subsubfilelist) {
					String filename = subsubfile.getAbsolutePath();
					scholarHtmlFilePathList.add(filename);
				}
    		}
		}
    	
    	List<Map<String, String>> solrscholarlist = new ArrayList<Map<String, String>>();
    	List<Scholar> scholarlist = ss.findAll();
    	for (Scholar scholar : scholarlist) {
			String institude_name = scholar.getInstitution() + "_" + scholar.getName();
			String scholarhtmlfilepath = "";
			for (String htmlfilepath : scholarHtmlFilePathList) {
				if (htmlfilepath.contains(institude_name)) {
					scholarhtmlfilepath = htmlfilepath;
					break;
				}
			}
	    	Map<String, String> scholarmap = new HashMap<>();
	    	scholarmap.put("id", String.valueOf(scholar.getId()));
	    	scholarmap.put("name", scholar.getName());
	    	scholarmap.put("officialdesc", delHtmlTag(file2str(new File(scholarhtmlfilepath))));
	    	scholarmap.put("papertitle", scholarInsNamePaperTitleMap.get(institude_name));
	    	solrscholarlist.add(scholarmap);
		}    	
    	return solrscholarlist;
    }
    
    /**
     * <b>function:</b> 读取文件内容
     * @throws IOException 
     */
    public String file2str(File file) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
    	String result = "";
    	String line = null;
    	while((line = br.readLine()) != null) {
    		result += "\n" + line;
    	}
    	br.close();
    	return result;
    }
    
    /**
     * <b>function:</b> 写文件内容
     * @throws IOException 
     */
    public void str2file(String str, File file) throws IOException {
    	FileOutputStream fos = null;
    	OutputStreamWriter osw = null;
    	try {
			fos = new FileOutputStream(file);
			osw = new OutputStreamWriter(fos, "UTF-8");
			osw.write(str);
			osw.flush();
			osw.close();
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			osw.close();
			fos.close();
		}
    }
    
    
    
    /**
     * <b>function:</b> 读取文件内容
     * @throws IOException 
     */
    public List<String> file2strlist(File file) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
    	List<String> result = new ArrayList<>();
    	String line = null;
    	while((line = br.readLine()) != null) {
    		result.add(line);
    	}
    	br.close();
    	return result;
    }
    
    /**
     * <b>function:</b> 输出函数
     */
    public final void fail(Object o) {
        System.out.println(o);
    }
    
    /**
     * <b>function:</b> 删除Html标签 
     */
    public String delHtmlTag(String htmlStr) {
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式  
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式  
        String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式  
        String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符  
        
        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);  
        Matcher m_script = p_script.matcher(htmlStr);  
        htmlStr = m_script.replaceAll(""); // 过滤script标签  
  
        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);  
        Matcher m_style = p_style.matcher(htmlStr);  
        htmlStr = m_style.replaceAll(""); // 过滤style标签  
  
        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);  
        Matcher m_html = p_html.matcher(htmlStr);  
        htmlStr = m_html.replaceAll(""); // 过滤html标签  
  
        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);  
        Matcher m_space = p_space.matcher(htmlStr);  
        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签  
        
        htmlStr = htmlStr.replaceAll("&nbsp;", " ");// 过滤空格标签 
        return htmlStr.trim(); // 返回文本字符串  
    }
    
    @Test
    public void test() {
    	List<ScholarSort> list = new ArrayList<>();
    	ScholarSort item1 = new ScholarSort();
    	item1.setResultscore(Float.valueOf("0.53"));
    	ScholarSort item2 = new ScholarSort();
    	item2.setResultscore(Float.valueOf("0.56"));
    	ScholarSort item3 = new ScholarSort();
    	item3.setResultscore(Float.valueOf("0.63"));
    	ScholarSort item4 = new ScholarSort();
    	item4.setResultscore(Float.valueOf("0.73"));
    	list.add(item1);
    	list.add(item2);
    	list.add(item3);
    	list.add(item4);
    	Collections.sort(list);
    	System.out.println(Float.valueOf("0.000222"));
    	System.out.println(item1.getResultscore());
    }
    

}
