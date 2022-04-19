<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ include file="../includes/header.jsp"%>

<div id = "table" align = 'right'>
<table id = 'main' border = "1">
	<tr id = 'head'> 
		<td width = "180px">Name</td>
		<td width = "80px">Rate, %</td>
		<td width = "100px">Maximum Loan, UAH</td>
		<td width = "100px">Minimum Payment, UAH</td>
		<td width = "80px">Term, month</td>
		<td width = "50px"></td>
	</tr> 
	<c:forEach var="bank" items="${bankSet}">
		<tr>
			<td>${bank.getName()}</td>
			<td> ${bank.getRate()}</td>
			<td> ${bank.getMax_Loan()}</td>
			<td> ${bank.getMin_Payment()}</td>
			<td> ${bank.getLoan_Term()}</td>
			<td width = "80px">	
				<input type="submit" id="Correct" name="Correct" value="Correct"
				onclick="location.href='/Mortgage_calculator/correcting?name=${bank.getName()}'" />
				<input type = "button" id = "${bank.getName()}" name = "Delete" value = "Delete" 
				onclick="location.href='/Mortgage_calculator/bank?deleteBank=${bank.getName()}'" />
			</td>
		</tr>
		
	</c:forEach>
</table>
<table align = 'center'>
<tr>
		<td>
		<input type="submit" id="Create" name="Create" value="Create a new Bank"
				onclick="location.href='/Mortgage_calculator/creating'" />
		</td>
		
		</tr>
</table>
</div>

</div>
</div>
			
<%@ include file="../includes/footer.jsp"%>