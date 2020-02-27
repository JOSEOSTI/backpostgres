package com.example.springposgres.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springposgres.model.Carrera;
import com.example.springposgres.model.Docente;
import com.example.springposgres.model.Materia;
import com.example.springposgres.model.Usuario;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/reporte")
public class UsuarioController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value = "/j", method = RequestMethod.GET)
	public String inicioCertMatricula() {
		return "HOLA FUNCIONA REPORTES";
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Usuario> getUsuarioById() {
		return jdbcTemplate
				.query("SELECT  idnumber,firstname,lastname,username,id,email	FROM eva_user order by  firstname asc ; ", new BeanPropertyRowMapper<>(Usuario.class));
}
	@RequestMapping(value = "/username/{id}", method = RequestMethod.GET)
	public List<Docente> getUsuarioById(@PathVariable String id) {
		return jdbcTemplate
				.query("SELECT id, username, password, idnumber, firstname, lastname, email\r\n" + 
						"	FROM public.eva_user where  username='"+id+"'", new BeanPropertyRowMapper<>(Docente.class));
}
	@RequestMapping(value = "/showmaterias", method = RequestMethod.GET)
	public List<Carrera> getCarreraById() {
		return jdbcTemplate
				.query("select DISTINCT fullname, name   from eva_user u inner join eva_course_completions cc \r\n" + 
						"on u.id= cc.userid inner join eva_course co on\r\n" + 
						"cc.course=co.id inner join eva_course_categories ct on \r\n" + 
						"co.category=ct.id", new BeanPropertyRowMapper<>(Carrera.class));
}
	
	
	
	@RequestMapping(value = "/materia/{id}", method = RequestMethod.GET)
	public List<Materia> getMateriaId(@PathVariable String id ) {
		return jdbcTemplate
				.query("SELECT u.firstname,cc.name,u.username,ec.fullname\r\n" + 
						"	FROM public.eva_course_completions c \r\n" + 
						"	inner join eva_user u on c.userid=u.id\r\n" + 
						"	inner join eva_course ec on ec.id=c.course \r\n" + 
						"	inner join eva_course_categories cc on cc.id=ec.category\r\n" + 
						"	where u.username='"+id+"'", new BeanPropertyRowMapper<>(Materia.class));
}
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	public List<Usuario> getUsuarioId(@PathVariable String id ) {
		return jdbcTemplate
				.query("SELECT egg.id, egg.itemid, egg.userid,egg.timemodified,egt.timecreated, u.firstname,u.lastname,u.username,u.idnumber,ec.fullname,rawgrade, finalgrade,egt.itemname\r\n" + 
						"	FROM public.eva_grade_grades egg inner join eva_grade_items egt on egg.itemid=egt.id	\r\n" + 
						"	inner join eva_course ec on egt.courseid=ec.id\r\n" + 
						"     inner join eva_user u on egg.userid=u.id\r\n" + 
						"	where ec.fullname='"+id+"' and rawgrade is not null", new BeanPropertyRowMapper<>(Usuario.class));
}
	
}

