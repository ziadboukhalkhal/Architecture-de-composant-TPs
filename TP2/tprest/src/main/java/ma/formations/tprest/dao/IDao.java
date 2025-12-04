package ma.formations.tprest.dao;

import ma.formations.tprest.service.service.model.Article;

import java.util.List;

public interface IDao {
    Article findById(Long id);
    List<Article> findAll();
    void save(Article article);
    void deleteById(Long id);
}
