package rocks.vivek275.finsightbackend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserGroupExpenses {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   @Column
   private String groupName;
    @Column
   private String email;
    @Column
   private List<String> members;
    @Column
   private List<Float> expenses;
    @Column
   private List<Float> balances;
    @Column
   private Float totalExpenses;
    @Column(nullable = false, columnDefinition = "TIMESTAMPTZ")
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @Column(nullable = false, columnDefinition = "TIMESTAMPTZ")
    private OffsetDateTime updatedAt = OffsetDateTime.now();
}
