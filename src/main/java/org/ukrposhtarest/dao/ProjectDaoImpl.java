package org.ukrposhtarest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.ukrposhtarest.model.project.Project;

@Component
@Service
public class ProjectDaoImpl implements ProjectDao{

//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//
//    @Override
//    public Project create() {
//        String sql = "INSERT INTO public.projects (id) VALUES (DEFAULT)";
//        jdbcTemplate.update(sql);
//        return new Project();
//    }
}
