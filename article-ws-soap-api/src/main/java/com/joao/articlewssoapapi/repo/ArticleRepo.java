package com.joao.articlewssoapapi.repo;

import com.joao.articlewssoapapi.entity.ArticleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepo extends CrudRepository<ArticleEntity, Long> {
    ArticleEntity findArticleById(long articleId);
    List<ArticleEntity> findArticleByTitleAndCategory(String title, String category);
}
