package pack.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandInter {
	String showDate(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
