<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ include file="../includes/header.jsp"%>

<form id="correctingForm" action="/Mortgage_calculator/correcting" method="post">
<div id = "table">
<table align = "right">
		<tr>
			<td width = "180px">
				<div class="field">
						<label> Name: ${bank.getName()} </label>
					<input type='hidden' name='Name' value = '${bank.getName()}' />
					</div>
					<div class="field">
						<label> Interest rate, % </label>
						<div class="input">
							<input type='text' name='Rate' required="required"
								placeholder="Enter Interest rate from 0 to 1"
								<c:choose>
										<c:when test = "${rate != null && rate.length() != 0}"> 
											value = '${rate}' 
										</c:when> 
										<c:otherwise>
										 	value = '${bank.getRate()}'
										</c:otherwise>
										</c:choose>>
						</div>
					</div>
					<div class="field">
						<label> Maximum loan, UAH </label>
						<div class="input">
							<input type='text' name='Max_Loan' required="required"
								placeholder="Enter maximum loan"
								<c:choose>
										<c:when test = "${max_loan != null && max_loan.length() != 0}"> 
											value = '${max_loan}' 
										</c:when> 
										<c:otherwise>
										 	value = '${bank.getMax_Loan()}'
										</c:otherwise>
										</c:choose>>
						</div>
					</div>
					<div class="field">
						<label> Minimum payment, UAH </label>
						<div class="input">
							<input type='text' name='Min_Payment' required="required"
								placeholder="Enter minimum payment"
								<c:choose>
										<c:when test = "${min_payment != null && min_payment.length() != 0}"> 
											value = '${min_payment}' 
										</c:when>
										<c:otherwise>
										 	value = '${bank.getMin_Payment()}'
										</c:otherwise>
									</c:choose>>
						</div>
					</div>
					<div class="field">
						<label> Loan term, Month </label>
						<div class="input">
							<input type='text' name='Loan_Term' required="required"
								placeholder="Enter loan term"
								<c:choose>
										<c:when test = "${loan_term != null && loan_term.length() != 0}"> 
											value = '${loan_term}' 
										</c:when> 
										<c:otherwise>
										 	value = '${bank.getLoan_Term()}'
										</c:otherwise>
									</c:choose>>
						</div>
					</div>
						<button type="submit" name='correct' value='Correct'>Correct</button>
					</div>
			</td>
			<td width = "280px">
				<table>
					<tr>
						<td align='center'>${utilites.getErrorText()}</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>
	</form>

<%@ include file="../includes/footer.jsp"%>