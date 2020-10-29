package com.wiiflex.account.web;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wiiflex.account.service.PersonService;

@Controller
public class ReportingController {

	@Autowired
	private PersonService personService;
	@Autowired
	private ServletContext servletContext;

	@RequestMapping(value = "/exportToExcel", method = RequestMethod.GET)
	public String exportToExcel(HttpServletRequest request, HttpServletResponse response) {
		try {
			// set output header
			ServletOutputStream os = response.getOutputStream();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=\"excelreport.xls\"");

			String reportLocation = servletContext.getRealPath("WEB-INF");
			InputStream is = new FileInputStream(reportLocation + "/report_template.xls");

			Context context = new Context();
			context.putVar("persons", this.personService.listPersons());

			JxlsHelper.getInstance().processTemplate(is, os, context);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
