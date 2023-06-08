package hello.member;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {
    private final JdbcTemplate jdbcTemplate;

    public MemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void initTable() {
        jdbcTemplate.execute("CREATE TABLE MEMBER (MEMBER_ID VARCHAR PRIMARY KEY, NAME VARCHAR)");
    }

    public void save(Member member) {
        jdbcTemplate.update("INSERT INTO MEMBER(MEMBER_ID, NAME) VALUES(?,?)",member.getMemberId(),member.getName());
    }
    public Member findById(String memberId) {
        return jdbcTemplate.queryForObject("SELECT MEMBER_ID ,NAME FROM MEMBER WHERE MEMBER_ID = ?",
                BeanPropertyRowMapper.newInstance(Member.class),memberId);
    }
    public List<Member> findAll(String memberId) {
        return jdbcTemplate.query("SELECT MEMBER_ID ,NAME FROM MEMBER",
                BeanPropertyRowMapper.newInstance(Member.class));
    }
}
