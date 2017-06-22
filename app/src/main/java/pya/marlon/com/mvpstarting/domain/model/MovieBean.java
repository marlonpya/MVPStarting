package pya.marlon.com.mvpstarting.domain.model;

/**
 * Created by marlonpya on 22/06/17.
 */

public class MovieBean {
    public final int id;
    public final String name;
    public final String htmlUrl;
    public final String description;
    public final String language;
    public final int stargazersCount;

    public MovieBean(int id, String name, String htmlUrl, String description, String language, int stargazersCount) {
        this.id = id;
        this.name = name;
        this.htmlUrl = htmlUrl;
        this.description = description;
        this.language = language;
        this.stargazersCount = stargazersCount;
    }

    @Override
    public String toString() {
        return "MovieBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", stargazersCount=" + stargazersCount +
                '}';
    }
}
