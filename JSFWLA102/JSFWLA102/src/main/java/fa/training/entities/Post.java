package fa.training.entities;

import fa.training.dto.create.PostForCreateDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(schema = "dbo" , name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String tags;

    @Column
    private String status;

    @Column
    private LocalDate create_time;

    @Column
    private LocalDate update_time;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorId" , referencedColumnName = "id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private Set<Comment> commentSet ;

    public Post(PostForCreateDTO dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.tags = dto.getTags();
        this.status = dto.getStatus();
        this.create_time = dto.getCreate_time();
        this.update_time = dto.getUpdate_time();
        this.user = dto.getUser();
    }
}
