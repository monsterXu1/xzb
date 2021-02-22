package com.my.es.clent;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.recycler.Recycler;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class test {
    private String index = "personss";
    private String type= "man";

    @Qualifier("esRestClient")
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public void dd(){

        System.out.println("dddd");
    }
    public void creatIndex() throws IOException {
        //设置settings
        Settings.Builder settings = Settings.builder().
                put("number_of_replicas", 1)
                .put("number_of_shards", 3);
        //设置mapping
        XContentBuilder mappings = JsonXContent.contentBuilder()
                .startObject()
                    .startObject("properti1es")
                        .startObject("name")
                            .field("type","text")
                        .endObject()
                    .endObject()
                .endObject();

         CreateIndexRequest createIndexRequest = new CreateIndexRequest(index)
                 .settings(settings)
                 .mapping(type,mappings);

        //链接并创建索引
        restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
    }
}
