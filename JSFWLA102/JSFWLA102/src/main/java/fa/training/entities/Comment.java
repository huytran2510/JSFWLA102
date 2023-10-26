package fa.training.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(schema = "dbo" , name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column
    private String status;

    @Column
    private String createTime;

    @Column
    private String author;

    @Column
    private String email;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id" , referencedColumnName = "id")
    private Post post;

}
