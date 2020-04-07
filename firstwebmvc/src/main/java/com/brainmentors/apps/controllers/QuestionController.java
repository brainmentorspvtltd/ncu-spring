package com.brainmentors.apps.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brainmentors.apps.dao.QuestionDAO;
import com.brainmentors.apps.models.Question;

@Controller
public class QuestionController {
	@Autowired
	private QuestionDAO questionDAO;
	
	

	public QuestionDAO getQuestionDAO() {
		return questionDAO;
	}

	public void setQuestionDAO(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}

	@RequestMapping(path = "/question",method = RequestMethod.GET)
	public String showQuestionAddScreen(@ModelAttribute("questionModel") Question question, Model model) {
		model.addAttribute("questionModel", new Question());
		List<Question> list = questionDAO.getAllQuestions();
		model.addAttribute("questions", list);
		return "question";
	}
	
	@RequestMapping(path = "/addquestion",method = RequestMethod.POST)
	public String addQuestionInDB(@ModelAttribute("questionModel") Question question, Model model) {
		System.out.println("Question Coming "+question);
		String message = questionDAO.addQuestion(question);
		List<Question> list = questionDAO.getAllQuestions();
		model.addAttribute("questions", list);
		model.addAttribute("msg",message);
		//model.addAttribute("questionModel", new Question());
		return "redirect:/question";
	}
}
