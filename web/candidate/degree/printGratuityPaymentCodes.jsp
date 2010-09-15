<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page import="net.sourceforge.fenixedu.domain.accounting.installments.InstallmentForFirstTimeStudents" %>


<html:xhtml/>

<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<style>
body {
font-size: 76%;
margin-top: 20px;
text-align: center;
line-height: 1.7em;
}
h1 {
font-family: Helvetica, Arial, sans-serif;
font-size: 13px;
}
div#content {
margin-top: 50px;
font-family: Georgia, serif;
}
div#content h2 {
font-size: 14px;
}
div.box {
border: 1px solid #000;
width: 610px;
margin: 0 auto;
padding: 5px 10px;
}
p {
width: 610px;
margin: 10px auto;
text-align: left;	
}
div.box p {
margin: 10px 0;
font-size: 12px;
font-family: Courier New, monospace;
}
div.box p span.label {
color: #555;
}
div.box p span.data {
font-weight: bold;
}
table {
font-family: Georgia, serif;
margin: 20px auto;
width: 610px;
}
table td {
vertical-align: top;
}
table td.col1 {
text-align: left;
}
table td.col2 {
padding-top: 10px;
text-align: center;
width: 1%;
}
</style>

</head>



<body>

<div id="content">
	
	<h2 style="text-align: center;">REFER�NCIAS MULTIBANCO PARA PAGAMENTO DAS PROPINAS</h2>
	
	<p style="margin-top: 20px;">A data limite da primeira presta��o e a totalidade da propina s�o de 10 dias a partir da data de inicio da matricula. Ap�s a data limite � cobrado 1% sobre a propina da 1� presta��o. Deve optar entre o pagamento da propina na totalidade ou pagamento em tr�s presta��es.</p>
	
	<p style="margin-top: 20px;">Taxa de secretaria/Seguro Escolar</p>
	
	<div class="box">
		<bean:define id="administrativeOfficeFeeAndInsurancePaymentCode" name="administrativeOfficeFeeAndInsurancePaymentCode" />
		<p style="margin: 0.15em 0; width: auto;"><span class="label">Entidade: </span> <span class="data"><bean:write name="sibsEntityCode" /></span></p>
		<p style="margin: 0.15em 0; width: auto;"><span class="label">Refer�ncia: </span> <span class="data"><bean:write name="administrativeOfficeFeeAndInsurancePaymentCode" property="code" /></span></p>
		<p style="margin: 0.15em 0; width: auto;"><span class="label">Data limite:</span> <span class="data"> <bean:write name="administrativeOfficeFeeAndInsurancePaymentCode" property="endDate" /></span></p>
		<p style="margin: 0.15em 0; width: auto;"><span class="label">Valor:</span> <span class="data"><bean:write name="administrativeOfficeFeeAndInsurancePaymentCode" property="minAmount" /></span></p>
	</div>
	
	<bean:define id="firstInstallmentEndDate" name="firstInstallmentEndDate" />
	<p style="margin-top: 20px;">Propina na totalidade</p>
	<div class="box">
		<bean:define id="totalGratuityPaymentCode" name="totalGratuityPaymentCode" />
		<p style="margin: 0.15em 0; width: auto;"><span class="label">Entidade: </span> <span class="data"><bean:write name="sibsEntityCode" /></span></p>
		<p style="margin: 0.15em 0; width: auto;"><span class="label">Refer�ncia: </span> <span class="data"><bean:write name="totalGratuityPaymentCode" property="code" /></span></p>
		<p style="margin: 0.15em 0; width: auto;"><span class="label">Data limite:</span> <span class="data"> <bean:write name="firstInstallmentEndDate" /></span></p>
		<p style="margin: 0.15em 0; width: auto;"><span class="label">Valor:</span> <span class="data"><bean:write name="totalGratuityPaymentCode" property="minAmount" /></span></p>
	</div>

	<p style="margin-top: 20px;">Propina em presta��es</p>
	<div class="box">
		<table>
			<tr>
		<logic:iterate id="paymentCode" name="installmentPaymentCodes" indexId="i" type="net.sourceforge.fenixedu.domain.accounting.PaymentCode">
			<% final String style = i > 0 ? "padding-left: 20px; border-left-color: black; border-left-width: thin; border-left-style: solid;" : ""; %>
				<td style="<%= style %>">
			<p style="margin: 0.15em 0; width: auto;"><span class="label"><%= (i + 1)  + "� presta��o" %></span></p>
			<p style="margin: 0.15em 0; width: auto;"><span class="label">Entidade: </span> <span class="data"><bean:write name="sibsEntityCode" /></span></p>
			<p style="margin: 0.15em 0; width: auto;"><span class="label">Refer�ncia: </span> <span class="data"><bean:write name="paymentCode" property="code" /></span></p>
			
			<logic:equal name="i" value="0">
			<p style="margin: 0.15em 0; width: auto;"><span class="label">Data limite:</span> <span class="data"> <bean:write name="firstInstallmentEndDate" /></span></p>
			</logic:equal>
			
			<logic:greaterThan name="i" value="0">
			<p style="margin: 0.15em 0; width: auto;"><span class="label">Data limite:</span> <span class="data"> <bean:write name="paymentCode" property="endDate" /></span></p>
			</logic:greaterThan>
			
			<p style="margin: 0.15em 0; width: auto;"><span class="label">Valor:</span> <span class="data"><bean:write name="paymentCode" property="minAmount" /></span></p>
				</td>
		</logic:iterate>
			</tr>
		</table>
	</div>
</div>

</body>