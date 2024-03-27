package toy.usedgoods;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import toy.usedgoods.entity.QTestEntity;
import toy.usedgoods.entity.TestEntity;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class UsedgoodsApplicationTest {
    @Autowired
    EntityManager em;

    @Test
    void contextLoads(){
        TestEntity testEntity = new TestEntity();
        em.persist(testEntity);

        JPAQueryFactory query = new JPAQueryFactory(em);
        QTestEntity qTestEntity = QTestEntity.testEntity;

        TestEntity result = query.selectFrom(qTestEntity).fetchOne();
        assertThat(result).isEqualTo(testEntity);
        assertThat(result.getId()).isEqualTo(testEntity.getId());
    }

}