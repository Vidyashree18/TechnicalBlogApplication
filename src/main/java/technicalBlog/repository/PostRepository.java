package technicalBlog.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import technicalBlog.model.post;

import javax.persistence.*;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    public List<post> getAllPosts(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<post> query = em.createQuery("SELECT p FROM post p", post.class);
        List<post> resultList = query.getResultList();

        return resultList;
    }

    public post getLatestPost(){
        EntityManager em = emf.createEntityManager();
        return em.find(post.class, 3);
    }

    public post createPost(post newPost){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(newPost);
            transaction.commit();
        }
        catch (Exception e){
            transaction.rollback();
        }
        return newPost;
    }

    public post getPost(Integer postId) {
        EntityManager em = emf.createEntityManager();
        return em.find(post.class, postId);
    }

    public void updatePost(post updatedPost){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(updatedPost);
            transaction.commit();
        }
        catch (Exception e){
            transaction.rollback();
        }
    }

    public void deletePost(Integer postId){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            post post = em.find(post.class, postId);
            em.remove(post);
            transaction.commit();
        }
        catch (Exception e){
            transaction.rollback();
        }
    }
}
