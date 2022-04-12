package com.cg.dfs.BookApi;

import com.cg.dfs.BookApi.service.BookServiceImpl;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.sql.SQLOutput;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {"server.baseuri=http://localhost:9000"})
public class WireMockTesting {

    @Autowired
    private BookServiceImpl bookService;

    private static WireMockServer wireMockServer;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(WireMockConfiguration.options().port(8888)
            .notifier(new ConsoleNotifier(true)).extensions(new ResponseTemplateTransformer(true)));



    /*@Test public void exactUrlOnly() {
        stubFor(get(urlEqualTo("/book/add"))
                .willReturn(aResponse()
                        .withStatus(200)));
    }*/


}
