package rocks.vivek275.finsightbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rocks.vivek275.finsightbackend.model.GroupExpenseWrapper;
import rocks.vivek275.finsightbackend.model.GroupExpenseWrapperWithID;
import rocks.vivek275.finsightbackend.model.UserGroupExpenses;
import rocks.vivek275.finsightbackend.repo.UserGroupExpensesRepo;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserGroupExpensesService {
    @Autowired
    UserGroupExpensesRepo userGroupExpensesRepo;
    public List<GroupExpenseWrapperWithID> getAllGroupExpenses(String email) {
        try {
            List<GroupExpenseWrapperWithID> groupExpenseWrapperWithIDS = new ArrayList<>();
            List<UserGroupExpenses> userGroupExpensesList = userGroupExpensesRepo.getAllByEmail(email);
            if(!userGroupExpensesList.isEmpty()) {
                for (UserGroupExpenses userGroupExpenses : userGroupExpensesList) {
                    GroupExpenseWrapperWithID wrapper = new GroupExpenseWrapperWithID();
                    wrapper.setGroupId(userGroupExpenses.getId());
                    wrapper.setExpenses(userGroupExpenses.getExpenses());
                    wrapper.setGroupName(userGroupExpenses.getGroupName());
                    wrapper.setTotalExpenses(userGroupExpenses.getTotalExpenses());
                    wrapper.setEmail(userGroupExpenses.getEmail());
                    wrapper.setBalances(userGroupExpenses.getBalances());
                    wrapper.setMembers(userGroupExpenses.getMembers());
                    groupExpenseWrapperWithIDS.add(wrapper);
                }
            }
            return groupExpenseWrapperWithIDS;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public GroupExpenseWrapperWithID setGroupExpense(GroupExpenseWrapper groupExpenseWrapper , String email) {
        try{
            UserGroupExpenses userGroupExpenses = new UserGroupExpenses();
            userGroupExpenses.setGroupName(groupExpenseWrapper.getGroupName());
            userGroupExpenses.setMembers(groupExpenseWrapper.getMembers());
            userGroupExpenses.setEmail(email);
            userGroupExpenses.setExpenses(groupExpenseWrapper.getExpenses());
            userGroupExpenses.setBalances(groupExpenseWrapper.getBalances());
            userGroupExpenses.setTotalExpenses(groupExpenseWrapper.getTotalExpenses());
            userGroupExpenses.setCreatedAt(OffsetDateTime.now());
            userGroupExpenses.setUpdatedAt(OffsetDateTime.now());
            userGroupExpensesRepo.save(userGroupExpenses);
            GroupExpenseWrapperWithID wrapper = new GroupExpenseWrapperWithID();
            wrapper.setGroupId(userGroupExpenses.getId());
            wrapper.setExpenses(userGroupExpenses.getExpenses());
            wrapper.setGroupName(userGroupExpenses.getGroupName());
            wrapper.setTotalExpenses(userGroupExpenses.getTotalExpenses());
            wrapper.setEmail(userGroupExpenses.getEmail());
            wrapper.setBalances(userGroupExpenses.getBalances());
            wrapper.setMembers(userGroupExpenses.getMembers());
            return wrapper;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public GroupExpenseWrapperWithID updateGroupExpense(Integer id,GroupExpenseWrapper groupExpenseWrapper , String email) {
        try
        {
            UserGroupExpenses userGroupExpenses = userGroupExpensesRepo.getByEmailAndId(email, id);
            userGroupExpenses.setGroupName(groupExpenseWrapper.getGroupName());
            userGroupExpenses.setMembers(groupExpenseWrapper.getMembers());
            userGroupExpenses.setExpenses(groupExpenseWrapper.getExpenses());
            userGroupExpenses.setBalances(groupExpenseWrapper.getBalances());
            userGroupExpenses.setTotalExpenses(groupExpenseWrapper.getTotalExpenses());
            userGroupExpenses.setUpdatedAt(OffsetDateTime.now());
            userGroupExpensesRepo.save(userGroupExpenses);
            GroupExpenseWrapperWithID wrapper = new GroupExpenseWrapperWithID();
            wrapper.setGroupId(userGroupExpenses.getId());
            wrapper.setExpenses(userGroupExpenses.getExpenses());
            wrapper.setGroupName(userGroupExpenses.getGroupName());
            wrapper.setTotalExpenses(userGroupExpenses.getTotalExpenses());
            wrapper.setEmail(userGroupExpenses.getEmail());
            wrapper.setBalances(userGroupExpenses.getBalances());
            wrapper.setMembers(userGroupExpenses.getMembers());
            return wrapper;

        }
        catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public ResponseEntity<String> deleteGroupExpense(Integer id, String email) {
        try{
            userGroupExpensesRepo.deleteById(id);
            return ResponseEntity.ok("Deleted");
        }
        catch(Exception ex) {
            return null;
        }
    }
}
