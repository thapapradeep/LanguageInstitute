package com.soft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soft.app.model.Language;
import com.soft.app.model.Teacher;
import com.soft.app.model.TeacherLanguage;

@Repository("teacherlanguageRepository")
public interface TeacherLanguageRepository extends JpaRepository<TeacherLanguage, Long>{
	
	@Query("Select lan from Language lan where lan NOT IN(Select l from Language l, Teacher t, TeacherLanguage tl where t.id=tl.teacher.id and l.id=tl.language.id and t.id=?1)")
	public List<Language> loadLanguageByTeacher(long id);
	
	@Query("SELECT t from Teacher t, Language l, TeacherLanguage tl where t.id=tl.teacher.id and l.id=tl.language.id and l.id=?1")
	public List<Teacher> loadTeacherByLanguage(long id);

}
