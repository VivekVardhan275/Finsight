package rocks.vivek275.finsightbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupExpenseWrapper {
    private String groupName;
    private String email;
    private List<String> members;
    private List<Float> expenses;
    private List<Float> balances;
    private Float totalExpenses;
}
