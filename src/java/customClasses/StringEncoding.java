/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customClasses;

/**
 *
 * @author Ostap
 */
public class StringEncoding {

  public static String encodeHtmlTag(String tag) {
    if (tag==null)
      return null;
    int length = tag.length();
    StringBuffer encodedTag = new StringBuffer(2 * length);
    for (int i=0; i<length; i++) {
      char c = tag.charAt(i);
      if (c=='<')
        encodedTag.append("&lt;");
      else if (c=='>')
        encodedTag.append("&gt;");
      else if (c=='&')
        encodedTag.append("&amp;");
      else if (c=='"')
        encodedTag.append("&quot;");  //when trying to output text as tag's
        // value as in values="???".
      else if (c==' ')
        encodedTag.append("&nbsp;");
      else
        encodedTag.append(c);

    }
    return encodedTag.toString();
  }
    
    
    
}


