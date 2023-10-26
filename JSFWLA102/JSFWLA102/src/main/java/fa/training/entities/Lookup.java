package fa.training.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(schema = "dbo" , name = "lookup")
public class Lookup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private int code;

    @Column(name="type")
    private String type;

    @Column(name = "position")
    private String position;


}
