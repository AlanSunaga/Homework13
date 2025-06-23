package org.skypro.skyshop.searchProduct;


public final class Article implements Searchable {
    String nameTitleArticle;
    String textTitleArticle;

    public Article(String nameTitleArticle, String textTitleArticle) {
        this.nameTitleArticle = nameTitleArticle;
        this.textTitleArticle = textTitleArticle;
    }

    @Override
    public String toString() {
        return "Название " + nameTitleArticle + '\n'
                + "Текст " + textTitleArticle;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String returnTypeContent() {
        return "ARTICLE";
    }
}
