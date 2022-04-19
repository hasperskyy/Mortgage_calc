<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ include file="../includes/header.jsp"%>

<form id="calculationForm" action="/Mortgage_calculator/calculator"
	method="post">
	<div id="table" align='right'>
		<table>
			<tr>
				<td width="180px">
					<div class="field">
						<label> Loan, UAH </label>
						<div class="input">
							<input type='text' name='Loan' placeholder="Enter your init loan"
								<c:choose>
										<c:when test = "${loan != null && loan.length() != 0}"> 
											value = '${loan}' 
										</c:when> 
										</c:choose>
						</div>
					</div>
					<div class="field">
						<label> Payment, UAH </label>
						<div class="input">
							<input type='text' name='Payment' required="required"
								placeholder="Enter your down payment"
								<c:choose>
										<c:when test = "${payment != null && payment.length() != 0}"> 
											value = '${payment}' 
										</c:when> 
										</c:choose>>
						</div>
					</div>
					<div class="field">
						<label> Bank </label>
						<div class="input">
							<input type='text' name='Name' required="required"
								placeholder="Enter Bank Name"
								<c:choose>
										<c:when test = "${name != null && name.length() != 0}"> 
											value = '${name}' 
										</c:when> 
										</c:choose>>
						</div>



						<button type="submit" name='calculate' value='Calculate'>Calculate</button>
					</div>
				</td>
				<td width="280px">
					<table align="center">
						<tr>
							<td align='center' , width="180px"><c:choose>
									<c:when test="${mounthlyPay != null}">	
						Your mounthly payment: <br><br> ${mounthlyPay} ,UAH
						</c:when>
								</c:choose> ${utilites.getErrorText()}</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
</form>


<%@ include file="../includes/footer.jsp"%>