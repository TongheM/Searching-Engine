package copy;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadingPDF {
	//this 'read' method accept filePath, output a list of string
	//the [0] element in the string is the email of the resume holder
	//element starting from [1] is the skill
   public String[] read(String filePath) throws IOException {
      //Loading an existing document
	  //filePath Example: "/Users/zhouxuqing/Documents/申请CS master/留学申请/CV/Resume ZhouXuQing.pdf"
      File file = new File(filePath);
      PDDocument document = PDDocument.load(file);
      //Instantiate PDFTextStripper class
      PDFTextStripper pdfStripper = new PDFTextStripper();
      //Retrieving text from PDF document
      String text = pdfStripper.getText(document);
      //Closing the document
      document.close();
      //Extract email
      String[] emailsearch = text.split(" ");
      String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
      Pattern pattern = Pattern.compile(regEx);
      String email = null;
      
      for(int i = 0; i < emailsearch.length; i++) {
    	  Matcher matcher = pattern.matcher(emailsearch[i]);
    	  if (matcher.matches()) {
    		  email = emailsearch[i];
    	  }
      }
      
      //Eliminate symbols and split text into array of string
    		text = text.replace(",", "");
    		text = text.replace(".", "");
    		text = text.replace(":", "");
    		String[] resumeArray = text.split(" ");
    		
    	//Setting skill you are looking for
    		String[] skills = {"Calculus", "Keras", "C++"};
    		
    	//Search and display skills
    		//Initialize skill flag that indicate the presence of skills
    		int[] skillsFlag = new int[skills.length];
    		for (int i = 0; i<skills.length; i++) {
    			skillsFlag[i] = 0;
    		}
    		//Search
    		for (int i = 0; i < skills.length; i++) {
    			for (int j = 0; j < resumeArray.length;j++) {
    				if (resumeArray[j].equals(skills[i])) {
    					skillsFlag[i] = 1;
    				}
    			}
    		}
    		//Compute the length of output list
    		int counter = 1; //save space for email
    		for (int i = 0; i< skills.length; i++) {
    			if (skillsFlag[i] == 1) {
    				counter++;
    			}
    		}
    		//Output actual skillList
    		
    		String[] skillList = new String[counter];
    		//Put in email address and skills
    		skillList[0] = email; //email is a string detected in the beginning
    		int position = 1;
    		for (int i = 0; i< skills.length; i++) {
    			if (skillsFlag[i] == 1) {
    				skillList[position] = skills[i];
    				position++;
    			}
    		}
    		return skillList;
    	}
}