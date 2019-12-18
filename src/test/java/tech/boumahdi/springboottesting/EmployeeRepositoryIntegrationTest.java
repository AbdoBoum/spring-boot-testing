package tech.boumahdi.springboottesting;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    @DisplayName("Test for DB")
    public void whenFindByName_thenReturnEmployee() {
        Employee alex = new Employee("alex", "alexa", "alex@cm.com");
        entityManager.persist(alex);
        entityManager.flush();

        Employee found = employeeRepository.findByFirstName(alex.getFirstName());

        assertThat(found.getFirstName(), equalTo(alex.getFirstName()));
    }

}
