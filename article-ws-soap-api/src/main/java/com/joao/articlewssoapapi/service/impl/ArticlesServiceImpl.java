package com.joao.articlewssoapapi.service.impl;

import com.joao.articlewssoapapi.entity.ArticleEntity;
import com.joao.articlewssoapapi.repo.ArticleRepo;
import com.joao.articlewssoapapi.service.inter.ArticleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticlesServiceImpl implements ArticleServiceInterface {
    @Autowired
    private ArticleRepo articleRepository;

    @Override
    public ArticleEntity getArticlebyId(long articleId){
        ArticleEntity article = articleRepository.findArticleById(articleId);
        return article;
    }

    @Override
    public List<ArticleEntity> getAllArticles() {
        List<ArticleEntity> listOfArticles = new ArrayList<>();
        articleRepository.findAll().forEach(articleEntity -> listOfArticles.add(articleEntity));
        return listOfArticles;
    }

    @Override
    public ArticleEntity getArticleById(long articleId) {
        return null;
    }

    @Override
    public synchronized boolean addArticle(ArticleEntity articleEntity) {
        List<ArticleEntity> listOfArticles = articleRepository.findArticleByTitleAndCategory(articleEntity.getTitle(), articleEntity.getCategory());
        if(listOfArticles.size() > 0) {
            return false;
        }else{
            articleEntity = articleRepository.save(articleEntity);
            System.out.println(articleEntity + "Saved successfully");
            return true;
        }
    }

    @Override
    public void updateArticle(ArticleEntity articleEntity) {
        articleRepository.save(articleEntity);
    }

    @Override
    public void deleteArticle(ArticleEntity articleEntity) {
        articleRepository.delete(articleEntity);
    }

}
