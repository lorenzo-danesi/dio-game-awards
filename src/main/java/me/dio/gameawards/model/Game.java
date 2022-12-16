package me.dio.gameawards.model;

import jakarta.persistence.*;

@Entity(name = "GAMES")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //tabela GAMES com id incremental no banco
    private Long id;
    private String name;
    @Column(length = 500)
    private String description;
    private String cover; //capa do game
    private long votes; //classe primitiva do Long, não aceita valor null

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCover() {
        return cover;
    }
    public void setCover(String cover) {
        this.cover = cover;
    }
    public long getVotes() {
        return votes;
    }
    public void setVotes(long votes) {
        this.votes = votes;
    }
}
