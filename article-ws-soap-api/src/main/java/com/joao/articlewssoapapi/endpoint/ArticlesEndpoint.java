package com.joao.articlewssoapapi.endpoint;

import com.joao.articlewssoapapi.service.impl.ArticlesServiceImpl;
import com.joao.articlewssoapapi.service.inter.ArticleServiceInterface;
import http.soap.ArticleInfo;
import http.soap.GetArticleByIdRequest;
import http.soap.GetArticleByIdResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ArticlesEndpoint {
    private static final String NAMESPACE_URI = "http://soap.ws";

    @Autowired
    private ArticleServiceInterface articlesServiceInterface;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getArticleByIdRequest")
    @ResponsePayload
    public GetArticleByIdResponse getArticleById(@RequestPayload GetArticleByIdRequest request){
        GetArticleByIdResponse response = new GetArticleByIdResponse();
        ArticleInfo articleInfo = new ArticleInfo();
        BeanUtils.copyProperties(articlesServiceInterface.getArticleById(request.getArticleId()), articleInfo);
        response.setArticleInfo(articleInfo);
        return response;
    }
}
