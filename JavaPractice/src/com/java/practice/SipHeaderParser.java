package com.java.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SipHeaderParser {
	public static void main(String[] args) {
		
		
		/*
		 * String finalregex=".*(<sip:\\s*)([^\\s]+?)@.*>.*"; String guid_Regex=
		 * "(.*x-cisco-tenant=)([a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}).*";
		 */
		// String
		// mailId="((.*[^\\s|;])|(\\s|;)+)(.+[^\\s|;]@.+\\..+[^\\s|;])(\\s|;)+.*";
		// getRemotePartyId(finalregex,guid_Regex);
		// get_P_assertedId(finalregex,guid_Regex);
		// getFrom(finalregex,guid_Regex);
		// getDiversionHeader(mailId/*,guid_Regex*/);

		/*
		 * String
		 * mailId2="(.*?)(\\b[A-Z0-9._%+-]+@[A-Z0-9.]+\\.[A-Z]{2,4}\\b)(.*)";
		 * String mailidd="(.+@.+\\..+)(\\s.+)";
		 */// getDiversionHeader(mailId2);
		
		//  P-Asserted-Identity: "Cullen Jennings" <sip:fluffy@cisco.com>
	//;    P-Asserted-Identity: tel:+14085264000
		//mail regex
		String SIP_URI_MAIL_REGEX="(.*?)(\\b[A-Z0-9._%+-]+@[A-Z0-9.]+\\.[A-Z]{2,4}\\b)(.*)";
		String sipuriregex="^[0-9]*$|^\\+[1-9]\\d{7,14}$";
		String mailregex="(.*?)(\\b[A-Z0-9._%+-]+@[A-Z0-9.]+\\.[A-Z]{2,4}\\b)(.*)";
		validateRegex(mailregex);
		String esnnumber = "   ;<sip:40@192.168.90.81> ;";
		String extensionNo = "   ;<sip:295@192.168.90.81> ;";
		String e164No = "  ; <sip:+13172222222@192.168.90.81> ;";
		String sipUri = " ssdsddsd ;<sip:hawks@cisco.com> ;ssssssssssssssssss";
		// String
		// sipURIregex="(.*?)(\\b[A-Z0-9._%+-]+@[A-Z0-9.]+\\.[A-Z]{2,4}\\b)(.*)";
	String sipURIregex = ".*(<sip:\\s*)([^\\s]+@.*[^\\.]?\\..*?)>.*";
	String numberSipUriRegex=".*(<sip:\\s*)([^\\s]+?)@.*>.*";
		String NUMBER_REGEX_SIP_URI = "^(([0-9#\\-_\\.,:;\\+\\%\\?'\\(\\)~\\*]*)|(([!@#$%^&*()+=`~|\\{}\\[\\];:',./?\"<>A-Za-z0-9 _-])|(%[2-7][0-9A-F])){1,40}@([a-zA-Z0-9](-*[a-zA-Z0-9])*\\.?|[a-zA-Z0-9](-*[a-zA-z0-9])*(\\.[a-zA-Z0-9](-*[a-zA-Z0-9])*)*\\.[a-zA-Z](-*[a-zA-Z0-9])*\\.?|(([1-9]?[0-9]|1[0-9]{2,2}|2[0-4][0-9]|25[0-5])(\\.([1-9]?[0-9]|1[0-9]{2,2}|2[0-4][0-9]|25[0-5])){3})))$";
		// String NUMBER_REGEX = "^[0-9]*$";
		      String NUMBER_REGEX = "^[0-9]*$|^\\+[1-9]\\d{7,14}$";
		
		//  validateDifferentPrimaryLines(sipUri, numberSipUriRegex, sipURIregex, NUMBER_REGEX, NUMBER_REGEX_SIP_URI);
		validateDifferentPrimaryLines(e164No, numberSipUriRegex, sipuriregex, NUMBER_REGEX, NUMBER_REGEX_SIP_URI);
		validateDifferentPrimaryLines(extensionNo, numberSipUriRegex, sipuriregex, NUMBER_REGEX, NUMBER_REGEX_SIP_URI);
		validateDifferentPrimaryLines(esnnumber, numberSipUriRegex, sipuriregex, NUMBER_REGEX, NUMBER_REGEX_SIP_URI);
//String paiRegex="(.*tel:)(\\+?[0-9]{2,5}+)(.*)";
//get_P_assertedId(paiRegex, null);
	}
    


private static void validateRegex(String mailregex) {
	 Pattern pattern = Pattern.compile(mailregex);
		// an object which matches a string against a pattern
		Matcher matcher = pattern.matcher("addsd@ss");
		//Matcher matcher = pattern.matcher(extensionNo);
		//Matcher matcher = pattern.matcher(e164No);
		//Matcher matcher = pattern.matcher(sipUri);
		// checking whether the SIP uri matches with regex or not
		if (matcher.matches()) {
			matcher.group(2);
		}
		
	}



private static void validateDifferentPrimaryLines(String sipUri,String numberSipUriRegex,String sipURIregex,String NUMBER_REGEX,String NUMBER_REGEX_SIP_URI) {
		// TODO Auto-generated method stub
	
	 Pattern pattern = Pattern.compile(numberSipUriRegex);
	// an object which matches a string against a pattern
	Matcher matcher = pattern.matcher(sipUri);
	//Matcher matcher = pattern.matcher(extensionNo);
	//Matcher matcher = pattern.matcher(e164No);
	//Matcher matcher = pattern.matcher(sipUri);
	// checking whether the SIP uri matches with regex or not
	if (matcher.matches()) {

		System.out.println("2[" + matcher.group(2) + "]");
	}
	/*if(validateRegex( NUMBER_REGEX, matcher.group(2))){
		System.out.println("valid :   "+ NUMBER_REGEX+" regex..: "+ matcher.group(2));		
		// System.out.println("3[" +matcher.group(3) + "]");
		// System.out.println("3[" +matcher.group(3) + "]");
		// System.out.println(matcher.group(4));

	}*/else{
		System.out.println("not a valid input");
		 Pattern pattern1 = Pattern.compile(sipURIregex);
		Matcher matcher1 = pattern1.matcher(sipUri);
		//Matcher matcher = pattern.matcher(extensionNo);
		//Matcher matcher = pattern.matcher(e164No);
		//Matcher matcher = pattern.matcher(sipUri);
		// checking whether the SIP uri matches with regex or not
		/*if (matcher1.matches()) {

			System.out.println("else [" + matcher1.group(2) + "]");
			if(validateRegex( NUMBER_REGEX_SIP_URI, matcher1.group(2))){
				System.out.println("valid");
			}else{
				System.out.println("not valid");
			}
		}*/
	}
	/*}else{
		System.out.println("not met inotial cond.");
	}*/
	}



private static boolean validateRegex(String nUMBER_REGEX, String group) {
	Pattern pattern = Pattern.compile(nUMBER_REGEX);
	Matcher matcher = pattern.matcher(group);
	// checking whether the SIP uri matches with regex or not
	if (matcher.matches()) {

	
	return true;
	}return false;
	}



private static void getDiversionHeader(String mailId/*, String guid_Regex*/) {
	String header="rahulagnihotri56+995@gmail.com<sip:rahulagnihotri56+995@gmail-com.wbx2.com;x-cisco-number=81002115> ;   reason=no-answer;privacy=off;screen=yes;x-cisco-tenant=7e88d491-d6ca-4786-82ed-cbe9efb02ad2 ;";	
	Pattern pattern = Pattern.compile(mailId, Pattern.CASE_INSENSITIVE);

	// an object which matches a string against a pattern
	Matcher matcher = pattern.matcher(header);
	// checking whether the SIP uri matches with regex or not
		if (matcher.matches()) {

			System.out.println("1[" + matcher.group(1) + "]");
			System.out.println("2[" +matcher.group(2) + "]");
			System.out.println("3[" +matcher.group(3) + "]");
			//System.out.println(matcher.group(4));

		}
	/*Pattern pattern1 = Pattern.compile(guid_Regex);

	// an object which matches a string against a pattern
	Matcher matcher1 = pattern1.matcher(header);
	// checking whether the SIP uri matches with regex or not
	if (matcher1.matches()) {
	    
	   
	    System.out.println(matcher1.group(2));
	    
	}*/
}



private static void getFrom(String finalregex, String guid_Regex) {
	// TODO Auto-generated method stub
	String from="\\\\ ;<sip:4084742311@192.168.90.81>;tag=1183~-163126379 ;Indigo AA 1\\\\ ";

Pattern pattern = Pattern.compile(finalregex);

// an object which matches a string against a pattern
Matcher matcher = pattern.matcher(from);
// checking whether the SIP uri matches with regex or not
if (matcher.matches()) {
    
   
    System.out.println(matcher.group(2));
    
}
}



private static void get_P_assertedId(String finalregex, String guid_Regex) {
	 // checking whether parameter is null or blank
	 String P_Asserted_Identity=" tel:+12;34;;;; Indigo AA 1\\\\ "; 
      // String P_Asserted_Identity=" tel:+1408526434;34;;;; Indigo AA 1\\\\ "; 
       /*String pppp="tel:+14085264000";
       String finalregex=".*(<sip:\\s*)([^\\s]+?)@.*>.*";*/
        // creating an object to represent a regular expression
        Pattern pattern = Pattern.compile(finalregex);
      
        // an object which matches a string against a pattern
        Matcher matcher = pattern.matcher(P_Asserted_Identity);
        // checking whether the SIP uri matches with regex or not
        if (matcher.matches()) {
            
            // returns the extension number from the SIP uri
            // name
            // callerTO.set
            
            System.out.println(matcher.group(2));
            
        } /*else {
            // creating an object to represent a regular expression
            pattern = Pattern.compile("(tel:\\+)([0-9].+)");
            matcher = pattern.matcher(pppp);
            
            if (matcher.matches()) {
                
                // returns the extension number from the SIP uri
                // name
            	 System.out.println((matcher.group(2)));
            }
        }*/
    }




private static void getRemotePartyId(String finalregex, String guid_Regex) {
	/*String remote1= "John Doe <sip:jdoe@foo.com>;party=calling;id-type=subscriber;privacy=full;screen=yes";
	String remote="<sip: +919013982184@192.168.13.120: 5060>;privacy=off;screen=no";
	String regex="(<sip:\\s*)([^\\s]+?)@.*>.*";
	String regex1="(.*).*(<sip:\\s*)([^\\s]+?@.*>).*";*/
	String finalReuqest="x-cisco-tenant=6a5e1eaa-c7b8-4fcc-88e1-50f78e858f5c ;\\\\Indigo AA 1\\\\ <sip:4084742311@192.168.90.66>;privacy=off;no-anchor;screen=no;party=calling";
//	/String finalregex=".*(<sip:\\s*)([^\\s]+?)@.*>.*";
	//creating an object to represent a regular expression
    Pattern pattern = Pattern.compile(finalregex);
    
    //an object which matches a string against a pattern
    Matcher matcher = pattern.matcher(finalReuqest);
    // checking whether the SIP uri matches with regex or not
		if (matcher.matches()) {

			// returns the extension number from the SIP uri
			System.out.println("Mail id: " + matcher.group(2).trim().replace("+", ""));
		}
Pattern pattern1 = Pattern.compile( guid_Regex);
    
    //an object which matches a string against a pattern
    Matcher matcher1 = pattern1.matcher(finalReuqest);
    // checking whether the SIP uri matches with regex or not
    if (matcher1.matches()) {
    	
        // returns the extension number from the SIP uri

        // returns the extension number from the SIP uri
    	System.out.println("number: " + matcher1.group(2).trim());
    	
}
   /* *//**
     * This method parses the Called Party mailbox and customerguid from the incoming
     * request which contains "Diversion" header.
     * 
     * Example: "Diversion": *
     * "rakeshrana@gmail.com  <sip:rakeshrana@gmail-com.wbx2.>;reason=no-answer;privacy=off;screen=yes;x-cisco-tenant=7e88d491-d6ca-4786-82ed-cbe9efb02ad2"
     * 
     * 
     * It will fetch only the Called Party mailbox and customerguid from "Diversion"
     * header.
     * 
     * @param diversionHeader
     * @return
     *//*
    private String getCalledMailIdFromDiversionHeader(String diversionHeader) {
    
        Pattern pattern = Pattern.compile(RoutingMgmntConsts.SIP_URI_MAIL_REGEX);
        
        // an object which matches a string against a pattern
        Matcher matcher = pattern.matcher(diversionHeader);
        // checking whether the SIP uri matches with regex or not
        if (matcher.matches()) {
            
            // returns the extension number from the SIP uri
            
            // returns the extension number from the SIP uri
            return matcher.group(1).trim();
            
        } else {
            // thro which is mandatory
            throw new ControllerValidationException(RoutingMgmntConsts.DIVERSION_HEADER_MISSING);
            
        }
    }*/
}
}
