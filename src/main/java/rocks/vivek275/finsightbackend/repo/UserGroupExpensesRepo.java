package rocks.vivek275.finsightbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rocks.vivek275.finsightbackend.model.UserGroupExpenses;

import java.util.List;

@Repository
public interface UserGroupExpensesRepo extends JpaRepository<UserGroupExpenses, Integer> {
    List<UserGroupExpenses> getAllByEmail(String email);
    UserGroupExpenses getUserGroupExpensesByIdAndEmail(Integer userGroupId, String email);

    UserGroupExpenses findByEmail(String email);

    UserGroupExpenses getByEmailAndId(String email, Integer id);

    void deleteByEmailAndId(String email, Integer id);

    void removeAllByEmailAndId(String email, Integer id);
}
