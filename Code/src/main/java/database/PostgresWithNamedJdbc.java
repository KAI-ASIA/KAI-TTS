package database;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;
import java.util.List;

public class PostgresWithNamedJdbc {

    public static void main(String[] args) {

       try{
           String sql = "Create table tiktok_user(\n" +
                   "\tid bigserial,\n" +
                   "\tuser_id varchar primary key,\n" +
                   "\tusername varchar,\n" +
                   "\tprofile_image varchar(500),\n" +
                   "\tfollowing varchar,\n" +
                   "\tfollowers varchar,\n" +
                   "\ttotal_videos varchar,\n" +
                   "\ttotal_heart varchar,\n" +
                   "\tverfied varchar,\n" +
                   "\tdescription varchar(500)\n" +
                   ")";

           jdbcTemplate().execute(sql);
           System.out.println("DONE");
       } catch (Exception ex){
           ex.printStackTrace();
       }

    }



    public static DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://14.225.254.212:5432/KAI");
        dataSource.setUsername("for_test");
        dataSource.setPassword("for_test@2024");
        return dataSource;
    }
    public static JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }


}
