<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ include file="../includes/header.jsp"%>

<form id="creatingForm" action="/Mortgage_calculator/creating" method="post">
<div id = "table">
<table align = "right">
		<tr>
			<td width = "180px">
				<div class="field">
						<label> Name </label>
						<div class="input">
							<input type='text' name='Name' required="required" placeholder="Banking name"
								<c:choose>
										<c:when test = "${name != null && name.length() != 0 && userDAO.isUnique(name) == true}"> 
											value = '${name}' 
										</c:when> 
										</c:choose>
								title="Enter the Banking name" value=''>
						</div>
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
									</c:choose>>
						</div>
					</div>
						<button type="submit" name='create' value='Create'>Create</button>
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