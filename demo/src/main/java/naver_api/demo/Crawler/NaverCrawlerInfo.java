package naver_api.demo.Crawler;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

public class NaverCrawlerInfo {

    final private String id = "lP4uSC28hhSmRAB9BYrf";
    final private String secret = "YG2o0I9jPh";

    public Optional<List> get_response (String query)
    {
        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
        String response=null;

        try {
            NaverCrawler crawler = new NaverCrawler();
            String url = URLEncoder.encode(query, "UTF-8");

            response = crawler.search(id, secret, url);

            String[] fields = {"title", "link", "description"};

            Map<String, Object> result = crawler.getResult(response, fields);
            if(result.size() > 0)
                System.out.println("total -> " + result.get("total"));
            items = (List<Map<String, Object>>) result.get("result");
            for(Map<String, Object> item : items) {
                System.out.println("====================================================");
                for (String field : fields) System.out.println(field + "->" + item.get(field));
            }





        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(items);

    }




}
