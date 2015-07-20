package net.mpopov.cms.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "public.article")
public class Article
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "article_article_id_seq")
    @SequenceGenerator(name = "article_article_id_seq",
            sequenceName = "article_article_id_seq")
    @Column(name = "article_id", nullable = false)
    private Long articleId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "article_category_id")
    @NotNull
    private ArticleCategory articleCategory;

    @Column(name = "name")
    @Size(min = 1, max = 256)
    private String name;

    @Column(name = "ufl")
    @Size(min = 1, max = 256)
    private String ufl;

    @Column(name = "description")
    @Size(max = 65536)
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "gallery_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Gallery gallery;

    @Column(name = "is_gallery_visible")
    private Boolean isGalleryVisible;

    /**
     * @return the articleId
     */
    public Long getArticleId()
    {
        return articleId;
    }

    /**
     * @param articleId
     *            the articleId to set
     */
    public void setArticleId(Long articleId)
    {
        this.articleId = articleId;
    }

    /**
     * @return the articleCategory
     */
    public ArticleCategory getArticleCategory()
    {
        return articleCategory;
    }

    /**
     * @param articleCategory
     *            the articleCategory to set
     */
    public void setArticleCategory(ArticleCategory articleCategory)
    {
        this.articleCategory = articleCategory;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the ufl
     */
    public String getUfl()
    {
        return ufl;
    }

    /**
     * @param ufl
     *            the ufl to set
     */
    public void setUfl(String ufl)
    {
        this.ufl = ufl;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @return the gallery
     */
    public Gallery getGallery()
    {
        return gallery;
    }

    /**
     * @param gallery
     *            the gallery to set
     */
    public void setGallery(Gallery gallery)
    {
        this.gallery = gallery;
    }

    /**
     * @return the isGalleryVisible
     */
    public Boolean getIsGalleryVisible()
    {
        return isGalleryVisible;
    }

    /**
     * @param isGalleryVisible
     *            the isGalleryVisible to set
     */
    public void setIsGalleryVisible(Boolean isGalleryVisible)
    {
        this.isGalleryVisible = isGalleryVisible;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Article [articleId=" + articleId + ", name=" + name + "]";
    }

}
