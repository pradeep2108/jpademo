package com.jpaDemo.jpa.dao;

import org.springframework.stereotype.Repository;

import com.jpaDemo.jpa.models.BookDetails;
import com.jpaDemo.jpa.models.CompositePK;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BookDetailsDaoImpl {

    @PersistenceContext
    private EntityManager em;

    public void saveBook(BookDetails bd) {
        em.persist(bd);

    }

    public BookDetails updateBook(BookDetails bd) {
        em.merge(bd);
        return bd;
    }

    public BookDetails updateprice(String title, String language, int updatePrice) {
        BookDetails bd = em.find(BookDetails.class, new CompositePK(title, language));
        bd.setPrice(updatePrice);
        em.merge(bd);
        return bd;
    }

    public BookDetails getBook(String title, String language) {

        BookDetails bd = em.find(BookDetails.class, new CompositePK(title, language));
        return bd;
    }

    public void deleteBook(BookDetails bd) {
        bd = em.find(BookDetails.class, new CompositePK(bd.getTitle(), bd.getLanguage()));
        em.remove(bd);

    }

    public void deleteBook(BookDetails bd, CompositePK id) {
        bd = em.find(BookDetails.class, id);
        em.remove(bd);
    }

    public void deleteOneBook(BookDetails bd, CompositePK id) {

    }

    public void deleteTwoBook(BookDetails bd, CompositePK id) {

    }

}
