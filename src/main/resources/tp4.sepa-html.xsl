<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:p="http://univ.fr/sepa" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="html" indent="yes" encoding="UTF-8" doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"></xsl:output>
	<xsl:template match="/p:CstmrDrctDbtInitn">
		<xsl:element name="html">
		  <xsl:element name="head"></xsl:element>
		  <xsl:element name="body">
		      <xsl:element name="header">
		          <xsl:element name="h1"><xsl:text>Transaction SEPA</xsl:text></xsl:element>
		          <xsl:element name="h3">
		              <xsl:text>Date émission : </xsl:text><xsl:value-of select="format-date(current-date(), '[F] [F1] [MNn] [Y]')"/>
		          </xsl:element>
		      </xsl:element>
		      <xsl:element name="article">
		          <xsl:call-template name="sommaire"></xsl:call-template>
		          <xsl:call-template name="transaction"></xsl:call-template>
		      </xsl:element>
		      <xsl:element name="footer">
		          <xsl:element name="div">
		              <xsl:text>Document émis par Spaur Geoffrey</xsl:text>
		          </xsl:element>
		      </xsl:element>
		  </xsl:element>
		</xsl:element>
	</xsl:template>
	
	<xsl:template name="transaction">
	   <xsl:for-each select="p:DrctDbtTxInf">
	       <xsl:variable name="n" select="last()"/>
	       <xsl:variable name="k" select="position()"/>
	       <xsl:element name="h2">
	           <xsl:text>Transaction </xsl:text>
	           <xsl:value-of select="concat($k, '/', $n)"></xsl:value-of>
	           <xsl:text> : REF OPE </xsl:text>
	           <xsl:value-of select="PmtId"></xsl:value-of>
	       </xsl:element>
	       <xsl:call-template name="info"></xsl:call-template>
	       <xsl:element name="h3"><xsl:text>Débiteur</xsl:text></xsl:element>
	       <xsl:call-template name="debiteur"></xsl:call-template>
	       <xsl:element name="h3"><xsl:text>Comment</xsl:text></xsl:element>
	       <xsl:element name="p"><xsl:value-of select="RmtInf"></xsl:value-of></xsl:element>
	       
	   </xsl:for-each>
	</xsl:template>
	
	<xsl:template name="info">
		   <xsl:element name="table">
		         <xsl:element name="tr">
		             <xsl:element name="td"><xsl:text>Montant</xsl:text></xsl:element>
		             <xsl:element name="td"><xsl:value-of select="InstdAmt"></xsl:value-of><xsl:value-of select="InstdAmt/@Ccy"></xsl:value-of></xsl:element>
		         </xsl:element>
		         <xsl:element name="tr">
		             <xsl:element name="td"><xsl:text>Date</xsl:text></xsl:element>
		             <xsl:element name="td"><xsl:value-of select="p:DrctDbtTx/DtOfSgntr"></xsl:value-of></xsl:element>
		         </xsl:element>
		         <xsl:element name="tr">
		             <xsl:element name="td"><xsl:text>Transac</xsl:text></xsl:element>
		             <xsl:element name="td">
		                 <xsl:text>MANDAT NO </xsl:text>
		                 <xsl:value-of select="p:DrctDbtTx/MndtId"></xsl:value-of>
		             </xsl:element>
		         </xsl:element>
		    </xsl:element>
	</xsl:template>
	
	<xsl:template name="debiteur">
	   <xsl:element name="table">
                 <xsl:element name="tr">
                     <xsl:element name="td"><xsl:text>Nom</xsl:text></xsl:element>
                     <xsl:element name="td"><xsl:value-of select="p:Dbtr/Nm"></xsl:value-of></xsl:element>
                 </xsl:element>
                 <xsl:element name="tr">
                     <xsl:element name="td"><xsl:text>BIC</xsl:text></xsl:element>
                     <xsl:element name="td"><xsl:value-of select="p:DbtrAgt/BIC"></xsl:value-of></xsl:element>
                 </xsl:element>
                 <xsl:element name="tr">
                     <xsl:element name="td"><xsl:text>IBAN</xsl:text></xsl:element>
                     <xsl:element name="td"><xsl:element name="td"><xsl:value-of select="p:DbtrAcct/IBAN"></xsl:value-of></xsl:element></xsl:element>
                 </xsl:element>
            </xsl:element>
	</xsl:template>
	
	<xsl:template name="sommaire">
	   <xsl:for-each select="p:DrctDbtTxInf">
	       <xsl:element name="h2">
	           <xsl:value-of select="position()"></xsl:value-of>
	           <xsl:text>  montant = </xsl:text>
	           <xsl:value-of select="InstdAmt"></xsl:value-of>
	           <xsl:text>  référence = </xsl:text>
	           <xsl:value-of select="PmtId"></xsl:value-of>
	       </xsl:element>
	   </xsl:for-each>
	</xsl:template>
	
</xsl:stylesheet>