package model;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SimpleErrorHandler implements ErrorHandler {
	
	private boolean errorOccured = false;
	
	public void warning(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		errorOccured = true;
		System.out.println(exception.getMessage());
		throw new SAXException(exception.getMessage());
	}

	public void error(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(exception.getMessage());
		errorOccured = true;
		throw new SAXException(exception.getMessage());
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(exception.getMessage());
		errorOccured = true;
		throw new SAXException(exception.getMessage());
	}
	
	public boolean hasError() {
		return errorOccured;
	}

}
