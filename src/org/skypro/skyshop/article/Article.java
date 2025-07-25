package org.skypro.skyshop.article;

import org.skypro.skyshop.searchProduct.Searchable;

import java.util.Objects;

public final class Article implements Searchable {
    private final String nameTitleArticle;
    private final String textTitleArticle;

    public Article(String nameTitleArticle, String textTitleArticle) {
        this.nameTitleArticle = nameTitleArticle;
        this.textTitleArticle = textTitleArticle;
    }

    public String getNameTitleArticle() {
        return nameTitleArticle;
    }

    public String getTextTitleArticle() {
        return textTitleArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Article article)) return false;
        return Objects.equals(nameTitleArticle, article.nameTitleArticle) && Objects.equals(textTitleArticle, article.textTitleArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameTitleArticle, textTitleArticle);
    }

    @Override
    public String toString() {
        return "Название " + getNameTitleArticle() + '\n'
                + "Текст " + getTextTitleArticle();
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String returnTypeContent() {
        return "ARTICLE";
    }
}
